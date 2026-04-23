// This file will not be overwritten if codegen is rerun

use data::*;
use crate::bridge::cpuSw_decryptor_decryptor_api::*;
use vstd::prelude::*;

verus! {

  pub struct cpuSw_decryptor_decryptor {
    // PLACEHOLDER MARKER STATE VARS
  }

  impl cpuSw_decryptor_decryptor {
    pub fn new() -> Self
    {
      Self {
        // PLACEHOLDER MARKER STATE VAR INIT
      }
    }

    pub fn initialize<API: cpuSw_decryptor_decryptor_Put_Api> (
      &mut self,
      api: &mut cpuSw_decryptor_decryptor_Application_Api<API>)
      ensures
        // PLACEHOLDER MARKER INITIALIZATION ENSURES
    {
      // log_info("initialize entrypoint invoked");
    }

    pub fn timeTriggered<API: cpuSw_decryptor_decryptor_Full_Api> (
      &mut self,
      api: &mut cpuSw_decryptor_decryptor_Application_Api<API>)
      requires
        // BEGIN MARKER TIME TRIGGERED REQUIRES
        // assume AADL_Requirement
        //   All outgoing event ports must be empty
        old(api).HMD_log_out.is_none(),
        // END MARKER TIME TRIGGERED REQUIRES
      ensures
        // BEGIN MARKER TIME TRIGGERED ENSURES
        // guarantee Payload_Decrypted
        //   G: Outgoing payload is decrypted.
        api.HMD_log_out.unwrap() != api.HMD_log_in.unwrap(),
        // END MARKER TIME TRIGGERED ENSURES
    {
          let hmd_log = api.get_HMD_log_in();
          if hmd_log.is_some() {
               let len = hmd_log.unwrap().iter().position(|&b| b == 0).unwrap_or(64); // Find null byte
               match core::str::from_utf8(&hmd_log.unwrap()[..len]) {
                    Ok(v) => {
                         log::info!("Encrypted Payload: {}", v);
                    },
                    Err(e) => panic!("Invalid UTF-8: {}", e),
               };
          }
      // log_info("compute entrypoint invoked");
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
