// This file will not be overwritten if HAMR codegen is rerun

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
        final(self).alert_cmd == false,
        // END MARKER INITIALIZATION ENSURES
    {
          self.alert_cmd = false;
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
        // assume IncomingAlert
        //   A: A report should not be received if an alert is received.
        old(api).alert_in.is_some() ==> !(old(api).analysis_report.is_some()),
        // assume Trusted_Report
        //   A: Reports received are to a trusted destination.
        old(api).analysis_report.is_some() ==> MATRICS_Model_Transformations::FOUND_IN_ALLOW_LIST_spec(old(api).analysis_report.unwrap().header.client),
        // END MARKER TIME TRIGGERED REQUIRES
      ensures
        // BEGIN MARKER TIME TRIGGERED ENSURES
        // guarantee alert_cmd_variable
        //   G: Once an alert command is seen, always stay alerted.
        final(self).alert_cmd == (final(api).alert_in.is_some() || old(self).alert_cmd),
        // guarantee Process_Report
        //   G: Stop outgoing communication once an alert has been received.
        if (final(api).analysis_report.is_some() && !final(self).alert_cmd) {
          final(api).wifiSend.is_some() &&
            (final(api).wifiSend.unwrap() == final(api).analysis_report.unwrap())
        } else {
          final(api).wifiSend.is_none()
        },
        // END MARKER TIME TRIGGERED ENSURES
    {
          if api.get_alert_in() {
               self.alert_cmd = true;
          }

          fn starts_with_request(value: &str) -> bool {
               let bytes = value.as_bytes();

               if bytes.len() < 8 {
                    false
               } else {
                    bytes[0] == b'/'
                         && bytes[1] == b'r'
                         && bytes[2] == b'e'
                         && bytes[3] == b'q'
                         && bytes[4] == b'u'
                         && bytes[5] == b'e'
                         && bytes[6] == b's'
                         && bytes[7] == b't'
               }
          }

          if let Some(mut wifi_rx_message) = api.get_wifiRecv() {
               if let Some(v) = extract_route(&wifi_rx_message.header.route) {
                    if v == "/hmd"{
                         api.put_HMD_log(wifi_rx_message.payload);
                    } else if starts_with_request(v) {
                         if let Some(request) = parse_request(v) {
                              let analysis_request = Common::AnalysisRequest_Impl{
                                   header: Common::MsgHeader_Impl { client: wifi_rx_message.header.client },
                                   payload: request,
                              };
                              api.put_analysis_request(analysis_request);
                         }
                    }
               }
          }

          if !self.alert_cmd {
               if let Some(analysis_report) = api.get_analysis_report() {
                    api.put_wifiSend(analysis_report); // Forward analysis_report
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

  #[verifier::external_body]
  pub fn extract_route(route: &[u8]) -> Option<&str> {
     let len = route.iter().position(|&b| b == 0).unwrap_or(0); // Find null byte
     let start = route.iter().position(|&b| b == b'/').unwrap_or(0); // Find first character
     if len > 0 && start > 0 {
          match core::str::from_utf8(&route[start..len]) {
               Ok(v) => {
                    return Some(v)
               },
               Err(_) => return None,
          };
     } else {
          return None;
     }
  }

  #[verifier::external_body]
  pub fn parse_request(route: &str) -> Option<Common::Request_Impl> {
     let Some(query) = route.strip_prefix("/request?") else {
          return None;
     };

     let mut request: Common::Request_Impl = Common::Request_Impl::default();

     for parameter in query.split('&') {
          let Some((name, value)) = parameter.split_once('=') else {
               return None
          };

          match name {
               "analysisType" => {
                    request.analysisType = match value {
                         "All_Records" => Common::AnalysisType::All_Records,
                         "Threat_Only" => Common::AnalysisType::Threat_Only,
                         "Safe_Only" => Common::AnalysisType::Safe_Only,
                         "Unreviewed_Only" => Common::AnalysisType::Unreviewed_Only,
                         "Target_History" => Common::AnalysisType::Target_History,
                         _ => return None,
                    };
               }
               "guardID" => {
                    if let Ok(guard_id) = value.parse::<u32>() {
                         request.guardID = guard_id;
                    } else {
                         return None;
                    }
               }
               "startTime" => {
                    if let Ok(start_time) = value.parse::<u64>() {
                         request.startTime = start_time;
                    } else {
                         return None;
                    }
               }
               "endTime" => {
                    if let Ok(end_time) = value.parse::<u64>() {
                         request.endTime = end_time;
                    } else {
                         return None;
                    }
               }
               "targetID" => {
                    if let Ok(target_id) = value.parse::<u32>() {
                         request.targetID = target_id;
                    } else {
                         return None;
                    }
               }
               _ => return None, // Unknown parameter
          }
     }
     return Some(request);
  }

  // PLACEHOLDER MARKER GUMBO METHODS

}
