#include <cpuSw_wifiDriver_wifiDriverVM_wifiDriver.h>
#include <cpuSw_wifiDriver_wifiDriverVM_wifiDriver_user.h>
#include <libvmm/arch/aarch64/linux.h>
#include <libvmm/arch/aarch64/fault.h>
#include <libvmm/guest.h>
#include <libvmm/virq.h>
#include <libvmm/virtio/virtio.h>
#include <libvmm/virtio/net.h>
#include <string.h>

// This file will not be overwritten if codegen is rerun

// Data for the guest's kernel image.
extern char _guest_kernel_image[];
extern char _guest_kernel_image_end[];

// Data for the device tree to be passed to the kernel.
extern char _guest_dtb_image[];
extern char _guest_dtb_image_end[];

// Data for the initial RAM disk to be passed to the kernel.
extern char _guest_initrd_image[];
extern char _guest_initrd_image_end[];

// Microkit will set this variable to the start of the guest RAM memory region.
uintptr_t GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_RAM_vaddr;

// Microkit will set this variable to the start of the RX memory buffer
uintptr_t GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_RX_Buffer_vaddr;

// Microkit will set this variable to the start of the TX memory buffer
uintptr_t GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_TX_Buffer_vaddr;

static void serial_ack(size_t vcpu_id, int irq, void *cookie);

static bool parse_message(const char* str, Common_IncomingWifiMessage_Impl *message);

void cpuSw_wifiDriver_wifiDriverVM_wifiDriver_initialize(void) {
  // Initialise the VMM, the VCPU(s), and start the guest
  LOG_VMM("starting \"%s\"\n", microkit_name);

  // Place all the binaries in the right locations before starting the guest

  size_t kernel_size = _guest_kernel_image_end - _guest_kernel_image;
  size_t dtb_size = _guest_dtb_image_end - _guest_dtb_image;
  size_t initrd_size = _guest_initrd_image_end - _guest_initrd_image;

  // https://github.com/au-ts/libvmm/blob/a996382581b9dbb7f067b25f312e87264c7b8ace/include/libvmm/arch/aarch64/linux.h#L37
  // https://github.com/au-ts/libvmm/blob/a996382581b9dbb7f067b25f312e87264c7b8ace/src/arch/aarch64/linux.c#L11
  uintptr_t kernel_pc = linux_setup_images(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_Guest_RAM_vaddr,
                                          (uintptr_t) _guest_kernel_image,
                                          kernel_size,
                                          (uintptr_t) _guest_dtb_image,
                                          GUEST_DTB_VADDR,
                                          dtb_size,
                                          (uintptr_t) _guest_initrd_image,
                                          GUEST_INIT_RAM_DISK_VADDR,
                                          initrd_size);

  if (!kernel_pc) {
    LOG_VMM_ERR("Failed to initialise guest images\n");
    return;
  }

  // Initialise the virtual GIC driver
  bool success = virq_controller_init();
  if (!success) {
    LOG_VMM_ERR("Failed to initialise emulated interrupt controller\n");
    return;
  }

  // Register Serial Interrupt
  success = virq_register(GUEST_BOOT_VCPU_ID, SERIAL_IRQ, &serial_ack, NULL);
  if (!success){
     LOG_VMM_ERR("Failed to register serial interrupt.\n");
  }

  // Register Ethernet Interrupt
  success = virq_register_passthrough(GUEST_BOOT_VCPU_ID, ETHERNET_IRQ, ETHERNET_IRQ_CH);
  if (!success){
     LOG_VMM_ERR("Failed to register ethernet interrupt %d\n");
  }

  if (!success) {
     LOG_VMM_ERR("Could not register virtual memory fault handler for RX wifi buffer");
  }

  // Finally start the guest /

  guest_start(kernel_pc, GUEST_DTB_VADDR, GUEST_INIT_RAM_DISK_VADDR);

  LOG_VMM("Guest started, leaving cpuSw_wifiDriver_wifiDriverVM_wifiDriver_initialize");
}

void cpuSw_wifiDriver_wifiDriverVM_wifiDriver_timeTriggered(void) {
     uint32_t rx_ready = *(uint32_t *)GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_RX_Buffer_vaddr;
     if (rx_ready == 1){
          Common_IncomingWifiMessage_Impl message;
          char *data = (char *)(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_RX_Buffer_vaddr + 0x04);
          if (parse_message(data, &message)){
               printf("HOST: %s\n", message.header.Host);
               printf("UserAgent: %s\n", message.header.UserAgent);
               printf("XForwardedProto: %s\n", message.header.XForwardedProto);
               printf("Payload: %s\n", message.payload);
          }
          else{
               printf("Error!");
          }
          // put_wifiRecvOut(const Common_IncomingWifiMessage_Impl *data);

          // Reset RX flag
          *(uint32_t *)GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_RX_Buffer_vaddr = 0;
          LOG_VMM("Received RX flag!\n");
     } else {
          LOG_VMM("RX flag: 0x%08x\n", rx_ready);
     }

  //printf("%s: cpuSw_wifiDriver_wifiDriverVM_wifiDriver_timeTriggered invoked\n", microkit_name);
}

void cpuSw_wifiDriver_wifiDriverVM_wifiDriver_notify(microkit_channel ch) {
  switch (ch) {
    case SERIAL_IRQ_CH: {
      bool success = virq_inject(SERIAL_IRQ);
      if (!success) {
        LOG_VMM_ERR("IRQ %d dropped on vCPU %d\n", SERIAL_IRQ, GUEST_BOOT_VCPU_ID);
      }    
      break;
    }
    case ETHERNET_IRQ_CH: {
      bool success = virq_handle_passthrough(ETHERNET_IRQ_CH);
      if (!success) {
        LOG_VMM_ERR("IRQ %d dropped on vCPU %d\n", ETHERNET_IRQ, GUEST_BOOT_VCPU_ID);
      }
      break;
    }
    default:
      printf("Unexpected channel, ch: 0x%lx\n", ch);
  }
}

/*
 * The primary purpose of the VMM after initialisation is to act as a fault-handler.
 * Whenever our guest causes an exception, it gets delivered to this entry point for
 * the VMM to handle.
 */
seL4_Bool fault(microkit_child child, microkit_msginfo msginfo, microkit_msginfo *reply_msginfo) {
    bool success = fault_handle(child, msginfo);
    if (success) {
        // Now that we have handled the fault successfully, we reply to it so
        // that the guest can resume execution.
        *reply_msginfo = microkit_msginfo_new(0, 0);
        return seL4_True;
    }

    return seL4_False;
}

static void serial_ack(uint64_t vcpu_id, int irq, void *cookie){
     /*
     * For now we by default simply ack the serial IRQ, we have not
     * come across a case yet where more than this needs to be done.
     */
     microkit_irq_ack(SERIAL_IRQ_CH);
}

void skip_whitespace(const char **str) {
     while(**str == ' '){
          (*str)++;
     }
}

void parse_string(const char **str, char *dest, size_t dest_size){
     (*str)++; // Skip openning quote
     size_t i = 0;

     while (**str != '"' && **str != '\0' && i < dest_size){
          dest[i++] = **str;
          (*str)++;
     }

     dest[i] = '\0'; // Null-terminate the string

     if(**str == '"')
          (*str)++; // Skip ending quote
     printf("String: %s\n", dest);
}

static bool parse_message(const char* str, Common_IncomingWifiMessage_Impl *message){
     Common_WifiHeader_Impl header;
     skip_whitespace(&str);
     if(*str != '{'){
          return false; // Invalid JSON
     }
     str++; // Skip '{'

     while(1) {
          skip_whitespace(&str);
          printf("%s\n", str);
          if (*str == '}'){
               str++; // Skip '}'
               break;
          }

          // Parse key
          char key[64];
          parse_string(&str, key, sizeof(key));
          skip_whitespace(&str);
          if (*str != ':'){
               return false; // Invalid JSON
          }
          str++; // Skip ':'
          skip_whitespace(&str);
          printf("Key: %s\n", key);
          if(strcmp(key, "headers") == 0){
               if(*str != '{'){
                    return false; // Invalid JSON
               }
               str++; // Skip '{'
               while(1){
                    skip_whitespace(&str);
                    if (*str == '}'){
                         str++; // Skip '}'
                         break;
                    }
                    // Parse key
                    char header_key[64];
                    parse_string(&str, header_key, sizeof(header_key));
                    skip_whitespace(&str);
                    if (*str != ':'){
                         return false; // Invalid JSON
                    }
                    str++; // Skip ':'
                    skip_whitespace(&str);
                    char value[64];
                    if(strcmp(header_key, "Host") == 0){
                         parse_string(&str, value, sizeof(value));
                         strcpy(header.Host, value);
                    } else if(strcmp(header_key, "User-Agent") == 0){
                         parse_string(&str, value, sizeof(value));
                         strcpy(header.UserAgent, value);
                    } else if(strcmp(header_key, "X-Forwarded-Proto") == 0){
                         parse_string(&str, value, sizeof(value));
                         strcpy(header.XForwardedProto, value);
                    }
                    else {
                         parse_string(&str, value, sizeof(value));
                    }
                    skip_whitespace(&str);
                    if (*str == ','){
                         str++;
                         skip_whitespace(&str);
                    }
               }
          } else if(strcmp(key, "body") == 0){
               char value[1024];
               parse_string(&str, value, sizeof(value));
               strcpy((char*)(*message).payload, value);
          } else {
               return false; // Unexpected JSON member
          }
          if (*str == ','){ // More members
               str++; // Skip ','
               skip_whitespace(&str);
          }
     }
     (*message).header = header;
     return true;
}