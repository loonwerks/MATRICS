#include <cpuSw_wifiDriver_wifiDriverVM_wifiDriver.h>
#include <cpuSw_wifiDriver_wifiDriverVM_wifiDriver_user.h>
#include <libvmm/arch/aarch64/linux.h>
#include <libvmm/arch/aarch64/fault.h>
#include <libvmm/guest.h>
#include <libvmm/virq.h>
#include <libvmm/virtio/virtio.h>
#include <libvmm/virtio/net.h>

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
          // Common_IncomingWifiMessage_Impl message;
          // Common_WifiHeader_Impl {
          //      Common_shortText Host;
          //      Common_shortText UserAgent;
          //      uint32_t ContentLength;
          //      Common_shortText XForwardedProto;
          //      Common_ip_address XForwardedFor;
          //      Common_ip_address XRealIP;
          // }
          // message.header = 
          // message.body = 
          // put_wifiRecvOut(const Common_IncomingWifiMessage_Impl *data);
          char *data = (char *)(GroundStation_Impl_Instance_cpuSw_wifiDriver_wifiDriverVM_wifiDriver_VM_RX_Buffer_vaddr + 0x04);
          while(*data != '\0'){
               printf("%c", *data);
               data++;
          }
          printf("\n");
          // int i;
          // for (i = 0; i < 20; i++){
          //      printf("%d: %c\n", i, *data);
          //      data++;
          // }
          // printf("\n");
          // LOG_VMM("Here is the data of length %d: %s\n", i, data);
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