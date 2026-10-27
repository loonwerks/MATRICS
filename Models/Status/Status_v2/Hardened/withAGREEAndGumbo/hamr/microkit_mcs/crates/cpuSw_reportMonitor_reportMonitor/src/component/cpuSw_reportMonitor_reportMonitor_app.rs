// This file will not be overwritten if HAMR codegen is rerun

use data::*;
use crate::bridge::cpuSw_reportMonitor_reportMonitor_api::*;
use vstd::prelude::*;

verus! {

  pub struct cpuSw_reportMonitor_reportMonitor {
    // BEGIN MARKER STATE VARS
    pub counter: i32,
    // END MARKER STATE VARS
  }

  impl cpuSw_reportMonitor_reportMonitor {
    pub fn new() -> Self
    {
      Self {
        // BEGIN MARKER STATE VAR INIT
        counter: 0,
        // END MARKER STATE VAR INIT
      }
    }

    pub fn initialize<API: cpuSw_reportMonitor_reportMonitor_Put_Api> (
      &mut self,
      api: &mut cpuSw_reportMonitor_reportMonitor_Application_Api<API>)
      ensures
        // BEGIN MARKER INITIALIZATION ENSURES
        // guarantee defaultCounter
        final(self).counter == 0i32,
        // END MARKER INITIALIZATION ENSURES
    {
      self.counter = 0;
    }

    pub fn timeTriggered<API: cpuSw_reportMonitor_reportMonitor_Full_Api> (
      &mut self,
      api: &mut cpuSw_reportMonitor_reportMonitor_Application_Api<API>)
      requires
        // BEGIN MARKER TIME TRIGGERED REQUIRES
        // assume AADL_Requirement
        //   All outgoing event ports must be empty
        old(api).analysis_report_out.is_none(),
        old(api).alert_out.is_none(),
        // END MARKER TIME TRIGGERED REQUIRES
      ensures
        // BEGIN MARKER TIME TRIGGERED ENSURES
        // guarantee counter_variable
        //   G: counter set correctly
        final(self).counter == Counter(final(api).analysis_request.is_some(), final(api).analysis_report_in.is_some(), old(self).counter),
        // guarantee Monitor_Requirement
        //   Alert ports are reserved for the monitor
        old(api).alert_out == final(api).alert_out,
        // END MARKER TIME TRIGGERED ENSURES
        // analysis_report_out is reserved for handle_r2u2_verdict
        old(api).analysis_report_out == final(api).analysis_report_out,
    {
          let request = api.get_analysis_request(); // Clears event data port for next frame
          let report = api.peek_analysis_report_in(); // Peek at the analysis_report_in but do not clear
          if request.is_some() {
               self.counter += 1; // Increment counter whenever a request is received
          }

          if report.is_some() {
               self.counter = 0; // Reset counter when a report is received
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

  // BEGIN MARKER GUMBO METHODS
  pub open spec fn Counter(
    i: bool,
    reset: bool,
    count: i32) -> i32
  {
    if (reset) {
      0i32
    } else {
      if (i) {
        (count + 1i32) as i32
      } else {
        count
      }
    }
  }
  // END MARKER GUMBO METHODS

}
