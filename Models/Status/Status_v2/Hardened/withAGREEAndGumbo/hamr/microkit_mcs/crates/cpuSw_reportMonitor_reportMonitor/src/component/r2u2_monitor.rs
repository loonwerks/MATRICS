// Content between markers will be preserved if codegen is rerun

use crate::bridge::cpuSw_reportMonitor_reportMonitor_api::*;
use crate::bridge::cpuSw_reportMonitor_reportMonitor_GUMBOX as GUMBOX;
use data::*;
use super::cpuSw_reportMonitor_reportMonitor_app::{cpuSw_reportMonitor_reportMonitor, log_info};
use vstd::prelude::*;

// Instance of the R2U2 monitor.
static mut R2U2_MONITOR: Option<R2U2Monitor> = None;

verus! {
  #[allow(non_camel_case_types)]
  pub enum R2U2Property {
    Valid_Response_Request_Behavior,
    Valid_And_Trusted_Report,
  }

    const ALLOWED_IP_ADDRESSES: [u32; 4]= [
    0xC0_A8_01_65, // 192.168.1.101
    0xC0_A8_01_66, // 192.168.1.102
    0xC0_A8_01_67, // 192.168.1.103
    0xC0_A8_01_68, // 192.168.1.104
  ];

  impl cpuSw_reportMonitor_reportMonitor {
    pub fn handle_r2u2_verdict<API: cpuSw_reportMonitor_reportMonitor_Full_Api> (
      &mut self,
      api: &mut cpuSw_reportMonitor_reportMonitor_Application_Api<API>,
      property: R2U2Property,
      verdict: Option<bool>)
      ensures
        // guarantee Monitor_Requirement
        //   Alert ports are reserved for the monitor
        old(api).alert_out == final(api).alert_out,
        // guarantee Forward_Report
        //  G: Only forward a report if a valid request has been made and it is to a trusted destination.
        if (final(api).analysis_report_in.is_some() && (property == R2U2Property::Valid_And_Trusted_Report && verdict == Some(true)) && 
               MATRICS_Model_Transformations::FOUND_IN_ALLOW_LIST_spec(final(api).analysis_report_in.unwrap().header.client)) {
          final(api).analysis_report_out.is_some() &&
            (final(api).analysis_report_out.unwrap() == final(api).analysis_report_in.unwrap())
        } else {
          final(api).analysis_report_out.is_none()
        },
    {
      // BEGIN MARKER R2U2 VERDICT HANDLER
      // Optional implementation placeholder for handling R2U2 verdicts.
      match property {
        R2U2Property::Valid_And_Trusted_Report => {
          match verdict {
            Some(true) => {
               let Some(report) = api.get_analysis_report_in() else {
                    return;
               };
               for i in scan: 0..ALLOWED_IP_ADDRESSES.len() 
                    invariant
                         // Connect api.analysis_report_in to the retried analysis_report_in
                         api.analysis_report_in == Some(report),
                         // Nothing has been forwarded yet
                         api.analysis_report_out.is_none(),
                         // Every address already checked differs from the client
                         forall |j: int| 0 <= j < scan.index() ==>
                              ALLOWED_IP_ADDRESSES[j] != report.header.client,
               {
                    if report.header.client == ALLOWED_IP_ADDRESSES[i] {
                         api.put_analysis_report_out(report); // Forward
                         return;
                    }
               }
            },
            Some(false) => {
               return; // Do not forward
            },
            None => {}, // This is never the case with past-time logic
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

impl cpuSw_reportMonitor_reportMonitor {
  pub fn r2u2_monitor_initialize(&mut self)
  {
    let mut r2u2_monitor = R2U2Monitor::new();
    r2u2_core::update_binary_file(include_bytes!("spec.bin"), &mut r2u2_monitor.monitor);
    unsafe { R2U2_MONITOR = Some(r2u2_monitor); }
  }

  pub fn r2u2_monitor_pre_timeTriggered<API: cpuSw_reportMonitor_reportMonitor_Full_Api> (
    &mut self,
    api: &cpuSw_reportMonitor_reportMonitor_Application_Api<API>)
  {
    let analysis_request = api.peek_analysis_request();
    let analysis_report_in = api.peek_analysis_report_in();

    let r2u2_monitor = unsafe {
      R2U2_MONITOR.as_mut().expect("R2U2 monitor used before initialization")
    };

    r2u2_core::load_bool_signal(&mut r2u2_monitor.monitor, 0, analysis_report_in.is_some()); // Loading signal api_analysis_report_in_nonEmpty into index 0
    r2u2_core::load_bool_signal(&mut r2u2_monitor.monitor, 1, analysis_request.is_some()); // Loading signal api_analysis_request_nonEmpty into index 1
  }

  pub fn r2u2_monitor_post_timeTriggered<API: cpuSw_reportMonitor_reportMonitor_Full_Api> (
    &mut self,
    api: &mut cpuSw_reportMonitor_reportMonitor_Application_Api<API>)
  {
    let r2u2_monitor = unsafe {
      R2U2_MONITOR.as_mut().expect("R2U2 monitor used before initialization")
    };

    r2u2_core::load_int_signal(&mut r2u2_monitor.monitor, 2, (self.counter) as i32); // Loading signal counter into index 2

    let r2u2_time_stamp = r2u2_monitor.monitor.time_stamp;
    r2u2_core::monitor_step(&mut r2u2_monitor.monitor);
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
    let r2u2_Valid_Response_Request_Behavior_verdict = r2u2_monitor.verdict_cache[0]
        .map(|verdict| verdict.truth && !false_verdict_seen[0]);
    self.handle_r2u2_verdict(
        api,
        R2U2Property::Valid_Response_Request_Behavior,
        r2u2_Valid_Response_Request_Behavior_verdict);
    let r2u2_Valid_And_Trusted_Report_verdict = r2u2_monitor.verdict_cache[1]
        .map(|verdict| verdict.truth && !false_verdict_seen[1]);
    self.handle_r2u2_verdict(
        api,
        R2U2Property::Valid_And_Trusted_Report,
        r2u2_Valid_And_Trusted_Report_verdict);
    // Send one result through each mapped alert port.
    if let Some(truth) = r2u2_Valid_Response_Request_Behavior_verdict {
        if !truth {
            api.put_alert_out();
        }
    }
  }
}
