// Content between markers will be preserved if codegen is rerun

use crate::bridge::cpuSw_logMonitor_logMonitor_api::*;
use crate::bridge::cpuSw_logMonitor_logMonitor_GUMBOX as GUMBOX;
use data::*;
use super::cpuSw_logMonitor_logMonitor_app::{cpuSw_logMonitor_logMonitor, log_info};
use vstd::prelude::*;

// Instance of the R2U2 monitor.
static mut R2U2_MONITOR: Option<R2U2Monitor> = None;

verus! {
  #[allow(non_camel_case_types)]
  pub enum R2U2Property {
    No_Response_Without_Request,
    Historically_No_Alert,
  }

  impl cpuSw_logMonitor_logMonitor {
    pub fn handle_r2u2_verdict<API: cpuSw_logMonitor_logMonitor_Full_Api> (
      &mut self,
      api: &mut cpuSw_logMonitor_logMonitor_Application_Api<API>,
      property: R2U2Property,
      verdict: Option<bool>)
      requires
          old(api).response_log_out.is_none(),
      ensures
        // guarantee Monitor_Requirement
        //   Alert ports are reserved for the monitor
        old(api).alert_out == final(api).alert_out,
        old(api).storage_alert_out == final(api).storage_alert_out,
        // guarantee Forward_Response
        //   G: Only forward a response if a valid request has been made.
        if (final(api).response_log_in.is_some() && (property == R2U2Property::Historically_No_Alert && verdict == Some(true))) {
          final(api).response_log_out.is_some() &&
            (final(api).response_log_out.unwrap() == final(api).response_log_in.unwrap())
        } else {
          final(api).response_log_out.is_none()
        },
    {
      // BEGIN MARKER R2U2 VERDICT HANDLER
      // Optional implementation placeholder for handling R2U2 verdicts.
      match property {
        R2U2Property::Historically_No_Alert => {
          if let Some(response) = api.get_response_log_in(){
               match verdict {
               Some(true) => {
                    api.put_response_log_out(response); // Forward
               },
               Some(false) => {
                    return; // Do not forward
               },
               None => {}, // This is never the case with past-time logic
               }
          }
        },
        _ => {}
      }

      // END MARKER R2U2 VERDICT HANDLER
     }
  }
}

struct R2U2Monitor {
  monitor: r2u2_core::Monitor,
  // Cache latest verdict (if applicable) per C2PO specification between monitor steps.
  verdict_cache: [Option<r2u2_core::r2u2_verdict>; 2],
}

impl R2U2Monitor {
  fn new() -> Self {
    Self {
      monitor: r2u2_core::Monitor::default(),
      verdict_cache: [None; 2],
    }
  }
}

impl cpuSw_logMonitor_logMonitor {
  pub fn r2u2_monitor_initialize(&mut self)
  {
    let mut r2u2_monitor = R2U2Monitor::new();
    r2u2_core::update_binary_file(include_bytes!("spec.bin"), &mut r2u2_monitor.monitor);
    unsafe { R2U2_MONITOR = Some(r2u2_monitor); }
  }

  pub fn r2u2_monitor_pre_timeTriggered<API: cpuSw_logMonitor_logMonitor_Full_Api> (
    &mut self,
    api: &cpuSw_logMonitor_logMonitor_Application_Api<API>)
  {
    let request_log = api.peek_request_log();
    let response_log_in = api.peek_response_log_in();

    let r2u2_monitor = unsafe {
      R2U2_MONITOR.as_mut().expect("R2U2 monitor used before initialization")
    };

    r2u2_core::load_bool_signal(&mut r2u2_monitor.monitor, 0, response_log_in.is_some()); // Loading signal api_response_log_in_nonEmpty into index 0
    r2u2_core::load_bool_signal(&mut r2u2_monitor.monitor, 1, request_log.is_some()); // Loading signal api_request_log_nonEmpty into index 1
  }

  pub fn r2u2_monitor_post_timeTriggered<API: cpuSw_logMonitor_logMonitor_Full_Api> (
    &mut self,
    api: &mut cpuSw_logMonitor_logMonitor_Application_Api<API>)
  {
    let r2u2_monitor = unsafe {
      R2U2_MONITOR.as_mut().expect("R2U2 monitor used before initialization")
    };


    r2u2_core::monitor_step(&mut r2u2_monitor.monitor);
    let r2u2_time_stamp = r2u2_monitor.monitor.time_stamp;
    // Expire cached verdicts before applying this step's new outputs.
    for verdict in r2u2_monitor.verdict_cache.iter_mut() {
        if verdict.is_some() && r2u2_time_stamp > verdict.unwrap().time {
            *verdict = None;
        }
    }
    // Keep false verdicts visible when a later output replaces the cache entry.
    let output_buffer = r2u2_core::get_output_buffer(&r2u2_monitor.monitor);
    let verdict_cache = &mut r2u2_monitor.verdict_cache;
    let mut false_verdict_seen = [false; 2];
    for out in output_buffer {
        let spec_num = out.spec_num as usize;
        if !out.verdict.truth {
            false_verdict_seen[spec_num] = true;
        }
        verdict_cache[spec_num] = Some(out.verdict);
    }
    // Delegate each current verdict to the preserved policy handler.
    let r2u2_No_Response_Without_Request_verdict = r2u2_monitor.verdict_cache[0]
        .map(|verdict| verdict.truth && !false_verdict_seen[0]);
    self.handle_r2u2_verdict(
        api,
        R2U2Property::No_Response_Without_Request,
        r2u2_No_Response_Without_Request_verdict);
    let r2u2_Historically_No_Alert_verdict = r2u2_monitor.verdict_cache[1]
        .map(|verdict| verdict.truth && !false_verdict_seen[1]);
    self.handle_r2u2_verdict(
        api,
        R2U2Property::Historically_No_Alert,
        r2u2_Historically_No_Alert_verdict);
    // Send one result through each mapped alert port.
    if let Some(truth) = r2u2_No_Response_Without_Request_verdict {
        if !truth {
            api.put_alert_out();
        }
    }
    if let Some(truth) = r2u2_No_Response_Without_Request_verdict {
        if !truth {
            api.put_storage_alert_out();
        }
    }
  }
}
