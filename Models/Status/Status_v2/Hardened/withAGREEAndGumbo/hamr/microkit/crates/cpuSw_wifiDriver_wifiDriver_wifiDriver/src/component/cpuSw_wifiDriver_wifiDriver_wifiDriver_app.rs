// This file will not be overwritten if codegen is rerun

use data::*;
use crate::bridge::cpuSw_wifiDriver_wifiDriver_wifiDriver_api::*;
use vstd::prelude::*;

verus! {

  pub struct cpuSw_wifiDriver_wifiDriver_wifiDriver {
    // BEGIN MARKER STATE VARS
    pub alert_cmd: bool,
    // END MARKER STATE VARS
  }

  impl cpuSw_wifiDriver_wifiDriver_wifiDriver {
    pub fn new() -> Self
    {
      Self {
        // BEGIN MARKER STATE VAR INIT
        alert_cmd: false,
        // END MARKER STATE VAR INIT
      }
    }

    pub fn initialize<API: cpuSw_wifiDriver_wifiDriver_wifiDriver_Put_Api> (
      &mut self,
      api: &mut cpuSw_wifiDriver_wifiDriver_wifiDriver_Application_Api<API>)
      ensures
        // BEGIN MARKER INITIALIZATION ENSURES
        // guarantee defaultAlert
        self.alert_cmd == false,
        // END MARKER INITIALIZATION ENSURES
    {
      // log_info("initialize entrypoint invoked");
    }

    pub fn timeTriggered<API: cpuSw_wifiDriver_wifiDriver_wifiDriver_Full_Api> (
      &mut self,
      api: &mut cpuSw_wifiDriver_wifiDriver_wifiDriver_Application_Api<API>)
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
      let wifi_rx_message = api.get_wifiRecv();
      if wifi_rx_message.is_some() {
          log::info!("Client: 0x{:08x}", wifi_rx_message.unwrap().header.client);
          let len = wifi_rx_message.unwrap().header.route.iter().position(|&b| b == 0).unwrap_or(64); // Find null byte
          match core::str::from_utf8(&wifi_rx_message.unwrap().header.route[..len]) {
               Ok(v) => {
                    if v == "localhost/hmd"{
                         api.put_HMD_log(wifi_rx_message.unwrap().payload);
                    }
                    log::info!("Route: {}", v);
               },
               Err(e) => panic!("Invalid UTF-8: {}", e),
          };
      }
    }

    pub fn notify(
      &mut self,
      channel: microkit_channel)
    {
      // this method is called when the monitor does not handle the passed in channel
      match channel {
        _ => {
          log_warn_channel(channel)
        }
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

  // PLACEHOLDER MARKER GUMBO METHODS

}
