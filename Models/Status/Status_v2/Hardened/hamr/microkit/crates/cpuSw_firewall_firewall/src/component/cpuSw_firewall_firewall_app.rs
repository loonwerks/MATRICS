// This file will not be overwritten if codegen is rerun

use data::*;
use crate::bridge::cpuSw_firewall_firewall_api::*;
use vstd::prelude::*;

verus! {

  pub struct cpuSw_firewall_firewall {
    // PLACEHOLDER MARKER STATE VARS
  }

  impl cpuSw_firewall_firewall {
    pub fn new() -> Self
    {
      Self {
        // PLACEHOLDER MARKER STATE VAR INIT
      }
    }

    pub fn initialize<API: cpuSw_firewall_firewall_Put_Api> (
      &mut self,
      api: &mut cpuSw_firewall_firewall_Application_Api<API>)
      ensures
        // PLACEHOLDER MARKER INITIALIZATION ENSURES
    {
      // log_info("initialize entrypoint invoked");
    }

    pub fn timeTriggered<API: cpuSw_firewall_firewall_Full_Api> (
      &mut self,
      api: &mut cpuSw_firewall_firewall_Application_Api<API>)
      requires
        // BEGIN MARKER TIME TRIGGERED REQUIRES
        // assume AADL_Requirement
        //   All outgoing event ports must be empty
        old(api).analysis_request_out.is_none(),
        // END MARKER TIME TRIGGERED REQUIRES
      ensures
        // BEGIN MARKER TIME TRIGGERED ENSURES
        // guarantee Forward_Request
        //   G: Only forward a request if it is from a trusted source.
        if (api.analysis_request_in.is_some() && FOUND_IN_ALLOW_LIST(ALLOW_LIST(), api.analysis_request_in.unwrap().header.client)) {
          api.analysis_request_out.is_some() &&
            (api.analysis_request_out.unwrap() == api.analysis_request_in.unwrap())
        } else {
          api.analysis_request_out.is_none()
        },
        // END MARKER TIME TRIGGERED ENSURES
    {
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

  // BEGIN MARKER GUMBO METHODS
  pub open spec fn ALLOW_LIST() -> MATRICS_Model_Transformations::AllowList_Impl
  {
    [1u32, 2u32, 3u32, 4u32]
  }

  pub open spec fn FOUND_IN_ALLOW_LIST(
    allow_list: MATRICS_Model_Transformations::AllowList_Impl,
    src: u32) -> bool
  {
    exists|i:int| 0 <= i < allow_list.len() && #[trigger] allow_list[i] == src
  }
  // END MARKER GUMBO METHODS

}
