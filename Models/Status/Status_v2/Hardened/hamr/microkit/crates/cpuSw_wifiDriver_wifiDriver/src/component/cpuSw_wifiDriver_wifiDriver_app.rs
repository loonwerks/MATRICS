// This file will not be overwritten if codegen is rerun
use data::*;
use crate::bridge::cpuSw_wifiDriver_wifiDriver_api::*;
use vstd::prelude::*;
use sel4_microkit_base::{memory_region_symbol};

// UART specific crates:
use sel4_pl011_driver::Driver as UartDriver;
use embedded_hal_nb::serial::Write;

// VMM specific crates
use core::{include_bytes};
use core::ffi::{c_void};
use sel4_microkit_base::{Channel};
//use sel4_microkit::{MessageInfo, Channel, ChannelSet, Child, Handler, Infallible};

const GUEST_RAM_VADDR: usize = 0x40000000;
const GUEST_DTB_VADDR: usize = 0x4f000000;
const GUEST_INIT_RAM_DISK_VADDR: usize = 0x4d700000;
const GUEST_BOOT_VCPU_ID: usize = 0;
const UART_IRQ: usize = 33; // On the QEMU virt AArch64 platform the UART we are using has an IRQ number of 33.
const UART_CH: Channel = Channel::new(1); // The VMM is expecting the IRQ to be delivered with the channel ID of 1.

verus! {

#[link(name = "vmm", kind = "static")]
#[link(name = "microkit", kind = "static")]
extern "C" {
     fn linux_setup_images(ram_start: usize,
                              kernel: usize, kernel_size: usize,
                              dtb_src: usize, dtb_dest: usize, dtb_size: usize,
                              initrd_src: usize, initrd_dest: usize, initrd_size: usize) -> usize;
     fn virq_controller_init() -> bool;
     fn virq_register(vcpu_id: usize, irq: i32, ack_fn: extern fn(usize, i32, *const c_void), ack_data: *const c_void) -> bool;
     fn virq_inject(irq: i32) -> bool;
     fn guest_start(kernel_pc: usize, dtb: usize, initrd: usize) -> bool;
     //fn fault_handle(vcpu_id: usize, msginfo: MessageInfo) -> bool;
}

extern "C" fn uart_irq_ack(_: usize, _: i32, _: *const c_void) {
    match UART_CH.irq_ack() {
        // Do nothing if there's no problem
        Ok(()) => {}
        Err(_e) => {
            log_info("VMM|ERROR: received ack from guest, but could not ack UART IRQ channel: {_e}");
        }
    }
}

  fn uart_put_str(driver: &mut UartDriver, str: &str) {
     for c in str.chars(){
          let _ = driver.write(c as u8);
     }
   }

  pub struct cpuSw_wifiDriver_wifiDriver {
    // BEGIN MARKER STATE VARS
    pub alert_cmd: bool,
//     uart_debug: UartDriver,
    vmm: VmmHandler,
    // END MARKER STATE VARS
  }

  impl cpuSw_wifiDriver_wifiDriver {
    pub fn new() -> Self
    {
     // let uart_driver = 
     //    unsafe { UartDriver::new(memory_region_symbol!(uart_base_vaddr: *mut ()).as_ptr()) };
      Self {
        // BEGIN MARKER STATE VAR INIT
        alert_cmd: false,
     //    uart_debug: uart_driver,
        vmm: VmmHandler{},
        // END MARKER STATE VAR INIT
      }
    }

    pub fn initialize<API: cpuSw_wifiDriver_wifiDriver_Put_Api> (
      &mut self,
      api: &mut cpuSw_wifiDriver_wifiDriver_Application_Api<API>)
      ensures
        // BEGIN MARKER INITIALIZATION ENSURES
        // guarantee defaultAlert
        self.alert_cmd == false,
        // END MARKER INITIALIZATION ENSURES
    {
     log_info("initialize entrypoint invoked");
     //  self.uart_debug.init();
     //  uart_put_str(&mut self.uart_debug, "UART is successfully initialized!\n");
      self.vmm.init();

    }

    pub fn timeTriggered<API: cpuSw_wifiDriver_wifiDriver_Full_Api> (
      &mut self,
      api: &mut cpuSw_wifiDriver_wifiDriver_Application_Api<API>)
      requires
        // BEGIN MARKER TIME TRIGGERED REQUIRES
        // assume AADL_Requirement
        //   All outgoing event ports must be empty
        old(api).wifiSend.is_none(),
        old(api).HMD_log.is_none(),
        old(api).analysis_request.is_none(),
        // END MARKER TIME TRIGGERED REQUIRES
      ensures
        // BEGIN MARKER TIME TRIGGERED ENSURES
        // guarantee alert_cmd_variable
        //   G: Once an alert command is seen, always stay alerted.
        (api.alert.is_some() ==>
          (self.alert_cmd == true)) &&
          ((old(self).alert_cmd == true) ==>
            (self.alert_cmd == true)),
        // guarantee Process_Report
        //   G: Stop outgoing communication once an alert has been received.
        if (api.analysis_report.is_some() && !self.alert_cmd) {
          api.wifiSend.is_some()
        } else {
          api.wifiSend.is_none()
        },
        // END MARKER TIME TRIGGERED ENSURES
    {
      log_info("compute entrypoint invoked");
      //uart_put_str(&mut self.uart_debug, "Hello from UART land again!\n");
    }

    pub fn notify(
      &mut self,
      channel: microkit_channel)
    {
      // this method is called when the monitor does not handle the passed in channel
      match channel {
       1 => {
          unsafe {
               let success = virq_inject(UART_IRQ as i32);
               if !success {
                    log_info("VMM|ERROR: could not inject UART IRQ");
               }
          }
        },
        _ => {
          log_warn_channel(channel)
        },
      }
    }
  }

  #[verifier::external_body]
  pub fn log_info(msg: &str)
  {
    log::info!("{0}", msg);
  }

  #[verifier::external_body]
  pub fn log_warn_channel(channel: u32)
  {
    log::warn!("Unexpected channel: {0}", channel);
  }

struct VmmHandler {}

impl VmmHandler {
     fn init(&self){
          log_info("VMM|INFO: starting Rust VMM");
          // Thankfully Rust comes with a simple macro that allows us to package
          // binaries locally and placing them in the final binary that we load
          // onto our platform, in this case the QEMU virt AArch64 board.
          let linux = include_bytes!(env!("LINUX_PATH"));
          let initrd = include_bytes!(env!("INITRD_PATH"));
          let dtb = include_bytes!(env!("DTB_PATH"));
          // libvmm does not understand slices like Rust, so we have to
          // turn this slices of u8 into raw addresses.
          let linux_addr = linux.as_ptr() as usize;
          let dtb_addr = dtb.as_ptr() as usize;
          let initrd_addr = initrd.as_ptr() as usize;

          unsafe {
               let guest_pc = linux_setup_images(GUEST_RAM_VADDR,
                                                  linux_addr, linux.len(),
                                                  dtb_addr, GUEST_DTB_VADDR, dtb.len(),
                                                  initrd_addr, GUEST_INIT_RAM_DISK_VADDR, initrd.len()
                                                  );
               log_info("VMM|INFO: Setup Linux Images");
               //let success = virq_controller_init();
               // log_info("VMM|INFO: Initialized VIRQ controller");
               // assert!(success);
               // let success = virq_register(GUEST_BOOT_VCPU_ID, UART_IRQ as i32, uart_irq_ack, core::ptr::null());
               // if success {
               //      log_info("VMM|INFO: Registered VIRQ controller successfully");
               // } else {
               //      log_info("VMM|INFO: Registered VIRQ controller FAILURE");
               // }
               // assert!(success);
               log_info("VMM|INFO: Got here");
               // match UART_CH.irq_ack() {
               //      Ok(()) => { log_info("VMM|INFO: could  ack UART IRQ channel");}
               //      Err(_e) => {
               //           log_info("VMM|ERROR: could not ack UART IRQ channel");
               //      }
               // }
               log_info("VMM|INFO: Going to start guest...");
               guest_start(guest_pc, GUEST_DTB_VADDR, GUEST_INIT_RAM_DISK_VADDR);
               log_info("VMM|INFO: Started guest");
          }
     }
}

// impl Handler for VmmHandler {
//     type Error = Infallible;

//     fn notified(&mut self, channels: ChannelSet) -> Result<(), Self::Error> {
//           if channels.contains(UART_CH) {
//                unsafe {
//                     let success = virq_inject(UART_IRQ as i32);
//                     if !success {
//                          log_info("VMM|ERROR: could not inject UART IRQ");
//                     }
//                }
//         }
//         Ok(())
//     }

//     fn fault(&mut self, id: Child, msg_info: MessageInfo) -> Result<Option<MessageInfo>, Self::Error> {
//         unsafe {
//             if fault_handle(id.index(), msg_info) {
//                 Ok(Some(MessageInfo::new(0, 0)))
//             } else {
//                 unreachable!()
//             }
//         }
//     }
// }


  // PLACEHOLDER MARKER GUMBO METHODS

}
