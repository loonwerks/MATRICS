// This file will not be overwritten if codegen is rerun

use data::*;
use crate::bridge::cpuSw_dataManager_dataManager_api::*;
use vstd::prelude::*;

verus! {

  pub struct cpuSw_dataManager_dataManager {
    // BEGIN MARKER STATE VARS
    pub cache: Common::LogArray_Impl,
    pub zeroize_cmd: bool,
    // END MARKER STATE VARS
  }

  impl cpuSw_dataManager_dataManager {
    pub fn new() -> Self
    {
      Self {
        // BEGIN MARKER STATE VAR INIT
        cache: [Common::Log_Impl::default(); Common::Common_LogArray_Impl_DIM_0],
        zeroize_cmd: false,
        // END MARKER STATE VAR INIT
      }
    }

    pub fn initialize<API: cpuSw_dataManager_dataManager_Put_Api> (
      &mut self,
      api: &mut cpuSw_dataManager_dataManager_Application_Api<API>)
      ensures
        // BEGIN MARKER INITIALIZATION ENSURES
        // guarantee defaultZeroize
        self.zeroize_cmd == false,
        // END MARKER INITIALIZATION ENSURES
    {
      log_info("initialize entrypoint invoked");
    }

    pub fn timeTriggered<API: cpuSw_dataManager_dataManager_Full_Api> (
      &mut self,
      api: &mut cpuSw_dataManager_dataManager_Application_Api<API>)
      requires
        // BEGIN MARKER TIME TRIGGERED REQUIRES
        // assume AADL_Requirement
        //   All outgoing event ports must be empty
        old(api).response_log.is_none(),
        // END MARKER TIME TRIGGERED REQUIRES
      ensures
        // BEGIN MARKER TIME TRIGGERED ENSURES
        // guarantee zeroize_cmd_variable
        //   G: Once a zeroize command is seen, always zeroize.
        (api.zeroize.is_some() ==>
          (self.zeroize_cmd == true)) &&
          ((old(self).zeroize_cmd == true) ==>
            (self.zeroize_cmd == true)),
        // guarantee Zeroize_Payload
        //   G: Zeroize outgoing responses once an alert is received and when a request has been made.
        (self.zeroize_cmd && api.request_log.is_some()) ==>
          IS_ZEROIZED(api.response_log.unwrap().payload),
        // guarantee Zeroize_Cache
        //   G: Zeroize cache once an alert is received.
        self.zeroize_cmd ==> IS_ZEROIZED(self.cache),
        // END MARKER TIME TRIGGERED ENSURES
    {
      log_info("compute entrypoint invoked");
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

  // BEGIN MARKER GUMBO METHODS
  pub open spec fn IS_ZEROIZED(logs: Common::LogArray_Impl) -> bool
  {
    forall|i:int| 0 <= i <= logs.len() - 1 ==> ((((((#[trigger] logs[i].timestamp == 0u32) &&
      (logs[i].userID == 0u32)) &&
      (logs[i].numSuspects == 0u32)) &&
      (logs[i].numSuspectsFlagged == 0u32)) &&
      (logs[i].yaw == 0i32)) &&
      (logs[i].pitch == 0i32)) &&
      (logs[i].roll == 0i32)
  }
  // END MARKER GUMBO METHODS

}
