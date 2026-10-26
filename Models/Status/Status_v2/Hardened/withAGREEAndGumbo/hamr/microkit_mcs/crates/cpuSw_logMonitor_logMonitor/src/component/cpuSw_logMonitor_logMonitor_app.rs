// This file will not be overwritten if HAMR codegen is rerun

use data::*;
use crate::bridge::cpuSw_logMonitor_logMonitor_api::*;
use vstd::prelude::*;

verus! {

  pub struct cpuSw_logMonitor_logMonitor {
    // PLACEHOLDER MARKER STATE VARS
  }

  impl cpuSw_logMonitor_logMonitor {
    pub fn new() -> Self
    {
      Self {
        // PLACEHOLDER MARKER STATE VAR INIT
      }
    }

    pub fn initialize<API: cpuSw_logMonitor_logMonitor_Put_Api> (
      &mut self,
      api: &mut cpuSw_logMonitor_logMonitor_Application_Api<API>)
      ensures
        // PLACEHOLDER MARKER INITIALIZATION ENSURES
    {

    }

    pub fn timeTriggered<API: cpuSw_logMonitor_logMonitor_Full_Api> (
      &mut self,
      api: &mut cpuSw_logMonitor_logMonitor_Application_Api<API>)
      requires
        // BEGIN MARKER TIME TRIGGERED REQUIRES
        // assume AADL_Requirement
        //   All outgoing event ports must be empty
        old(api).response_log_out.is_none(),
        old(api).alert_out.is_none(),
        old(api).storage_alert_out.is_none(),
        // END MARKER TIME TRIGGERED REQUIRES
      ensures
        // BEGIN MARKER TIME TRIGGERED ENSURES
        // guarantee Monitor_Requirement
        //   Alert ports are reserved for the monitor
        old(api).alert_out == final(api).alert_out,
        old(api).storage_alert_out == final(api).storage_alert_out,
        // END MARKER TIME TRIGGERED ENSURES
        // response_log_out is reserved for handle_r2u2_verdict
        old(api).response_log_out == final(api).response_log_out,
    {
      let request_log = api.get_request_log(); // Clear event data port for next frame
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
