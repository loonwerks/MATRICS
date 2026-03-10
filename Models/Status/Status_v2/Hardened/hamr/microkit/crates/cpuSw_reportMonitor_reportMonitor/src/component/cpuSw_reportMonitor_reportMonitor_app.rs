// This file will not be overwritten if codegen is rerun

use data::*;
use crate::bridge::cpuSw_reportMonitor_reportMonitor_api::*;
use vstd::prelude::*;

verus! {

  pub struct cpuSw_reportMonitor_reportMonitor {
    // BEGIN MARKER STATE VARS
    pub counter: u32,
    pub since_result: bool,
    pub is_valid1: bool,
    pub is_invalid2: bool,
    // END MARKER STATE VARS
  }

  impl cpuSw_reportMonitor_reportMonitor {
    pub fn new() -> Self
    {
      Self {
        // BEGIN MARKER STATE VAR INIT
        counter: 0,
        since_result: false,
        is_valid1: false,
        is_invalid2: false,
        // END MARKER STATE VAR INIT
      }
    }

    pub fn initialize<API: cpuSw_reportMonitor_reportMonitor_Put_Api> (
      &mut self,
      api: &mut cpuSw_reportMonitor_reportMonitor_Application_Api<API>)
      ensures
        // BEGIN MARKER INITIALIZATION ENSURES
        // guarantee defaultCounterAndSince
        (self.counter == 0u32) &&
          (self.since_result == false),
        // END MARKER INITIALIZATION ENSURES
    {
      log_info("initialize entrypoint invoked");
    }

    pub fn timeTriggered<API: cpuSw_reportMonitor_reportMonitor_Full_Api> (
      &mut self,
      api: &mut cpuSw_reportMonitor_reportMonitor_Application_Api<API>)
      requires
        // BEGIN MARKER TIME TRIGGERED REQUIRES
        // assume AADL_Requirement
        //   All outgoing event ports must be empty
        old(api).analysis_report_out.is_none(),
        old(api).alert.is_none(),
        // END MARKER TIME TRIGGERED REQUIRES
      ensures
        // BEGIN MARKER TIME TRIGGERED ENSURES
        // guarantee since_result_variable
        //   G: Internal Variable since_result is equivalent to (not response_log_in event) Since (request_log event)
        self.since_result == GUMBO_PLTL::Since_spec(!(api.analysis_report_in.is_some()), api.analysis_request.is_some(), old(self).since_result),
        // guarantee valid1
        //   G: is_valid1 set correctly
        if (api.analysis_report_in.is_some() && api.analysis_request.is_some()) {
          self.is_valid1 == true
        } else {
          self.is_valid1 == (api.analysis_report_in.is_some() ==> old(self).since_result)
        },
        // guarantee invalid2
        //   G: is_invalid2 set correctly
        Counter(api.analysis_request.is_some(), api.analysis_report_in.is_some(), self.counter) >= 3u32,
        // guarantee Alert1
        //   G: Send an alert if more than one report is received without a request.
        if (api.analysis_report_in.is_some() && !self.is_valid1) {
          api.alert.is_some()
        } else {
          api.alert.is_none()
        },
        // guarantee Alert2
        //   G: Send an alert if 3 or more requests are received without a report.
        if (self.is_invalid2) {
          api.alert.is_some()
        } else {
          api.alert.is_none()
        },
        // guarantee Forward_Report
        //   G: Only forward a report if a valid request has been made and it is to a trusted destination.
        if (((api.analysis_report_in.is_some() && self.is_valid1) &&
          !self.is_invalid2) &&
          FOUND_IN_ALLOW_LIST(ALLOW_LIST(), api.analysis_report_in.unwrap().header.dst)) {
          api.analysis_report_out.is_some() &&
            (api.analysis_report_out.unwrap() == api.analysis_report_in.unwrap())
        } else {
          api.analysis_report_out.is_none()
        },
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
  pub open spec fn Counter(
    i: bool,
    reset: bool,
    count: u32) -> u32
  {
    (if (reset == true) {
      0u32
    } else {
      if (i == true) {
        count + 1u32
      } else {
        count
      }
    }) as u32
  }

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
