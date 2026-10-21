// This file will not be overwritten if HAMR codegen is rerun

use data::*;
use crate::bridge::cpuSw_firewall_firewall_api::*;
use vstd::prelude::*;

verus! {

  const ALLOWED_IP_ADDRESSES: [u32; 4]= [
    3232235877, // 197.168.1.101
    3232235878, // 197.168.1.102
    3232235879, // 197.168.1.103
    3232235880, // 197.168.1.104
  ];

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
      log_info("initialize entrypoint invoked");
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
        if (final(api).analysis_request_in.is_some() && MATRICS_Model_Transformations::FOUND_IN_ALLOW_LIST_spec(final(api).analysis_request_in.unwrap().header.client)) {
          final(api).analysis_request_out.is_some() &&
            (final(api).analysis_request_out.unwrap() == final(api).analysis_request_in.unwrap())
        } else {
          final(api).analysis_request_out.is_none()
        },
        // END MARKER TIME TRIGGERED ENSURES
    {
          let Some(analysis_request) = api.get_analysis_request_in() else {
               return;
          };


          for i in scan: 0..ALLOWED_IP_ADDRESSES.len() 
               invariant
                    // Connect api.analysis_request_in to the retried analysis_request
                    api.analysis_request_in == Some(analysis_request),
                    // Nothing has been forwarded yet
                    api.analysis_request_out.is_none(),
                    // Every address already checked differs from the client
                    forall |j: int| 0 <= j < scan.index() ==>
                         ALLOWED_IP_ADDRESSES[j] != analysis_request.header.client,
          {
               if analysis_request.header.client == ALLOWED_IP_ADDRESSES[i] {
                    api.put_analysis_request_out(analysis_request);
                    return;
               }
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
