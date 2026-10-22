// This file will not be overwritten if HAMR codegen is rerun

use data::*;
use crate::bridge::cpuSw_dataAnalysis_dataAnalysis_api::*;
use vstd::prelude::*;

verus! {

  pub struct cpuSw_dataAnalysis_dataAnalysis {
    // PLACEHOLDER MARKER STATE VARS
  }

  impl cpuSw_dataAnalysis_dataAnalysis {
    pub fn new() -> Self
    {
      Self {
        // PLACEHOLDER MARKER STATE VAR INIT
      }
    }

    pub fn initialize<API: cpuSw_dataAnalysis_dataAnalysis_Put_Api> (
      &mut self,
      api: &mut cpuSw_dataAnalysis_dataAnalysis_Application_Api<API>)
      ensures
        // PLACEHOLDER MARKER INITIALIZATION ENSURES
    {
      log_info("initialize entrypoint invoked");
    }

    pub fn timeTriggered<API: cpuSw_dataAnalysis_dataAnalysis_Full_Api> (
      &mut self,
      api: &mut cpuSw_dataAnalysis_dataAnalysis_Application_Api<API>)
      requires
        // BEGIN MARKER TIME TRIGGERED REQUIRES
        // assume AADL_Requirement
        //   All outgoing event ports must be empty
        old(api).request_log.is_none(),
        old(api).analysis_report.is_none(),
        // assume Trusted_Request
        //   A: Requests received are from a trusted source.
        old(api).analysis_request.is_some() ==> MATRICS_Model_Transformations::FOUND_IN_ALLOW_LIST_spec(old(api).analysis_request.unwrap().header.client),
        // END MARKER TIME TRIGGERED REQUIRES
        old(api).response_log.is_some() ==>
          old(api).response_log.unwrap().payload.validLogCount
          <= Common::Common_ResponseLog_Impl_DIM_0 as u32,
        old(api).response_log.is_some() ==>
          forall|i: int|
               0 <= i < old(api).response_log.unwrap().payload.validLogCount as int ==>
                    old(api).response_log.unwrap().payload.logs[i].targetCount
                         <= Common::Common_TargetObservationArray_Impl_DIM_0 as u32,
      ensures
        // PLACEHOLDER MARKER TIME TRIGGERED ENSURES
    {
          if let Some(request) = api.get_analysis_request() { // Send Request to dataManager and logMonitor
               api.put_request_log(request);
          }

          if let Some(response) = api.get_response_log() { // Analyze and send report to encryptor
               let mut report = response;
               match response.payload.request.analysisType {
                    Common::AnalysisType::All_Records => {},
                    Common::AnalysisType::Threat_Only => {
                         let mut analysis_report_logs: Common::ResponseLog_Impl = Common::ResponseLog_Impl::default();
                         let mut validLogCount: usize = 0;
                         for i in logs_loop: 0..response.payload.validLogCount
                              invariant
                                   response.payload.validLogCount <= Common::Common_ResponseLog_Impl_DIM_0 as u32,
                                   validLogCount as int <= logs_loop.index(),
                                   forall|k: int|
                                        0 <= k < response.payload.validLogCount as int ==>
                                             response.payload.logs[k].targetCount
                                                  <= Common::Common_TargetObservationArray_Impl_DIM_0 as u32,
                         {
                              let log = response.payload.logs[i as usize];
                              let mut analysis_report_log: Common::Log_Impl = Common::Log_Impl::default();
                              let mut targetCount: usize = 0;
                              for j in targets_loop: 0..log.targetCount
                                   invariant
                                        log.targetCount <= Common::Common_TargetObservationArray_Impl_DIM_0 as u32,
                                        targetCount as int <= targets_loop.index(),
                              {
                                   let target = log.targets[j as usize];
                                   if target.assessment == Common::TargetAssessment::Threat {
                                        analysis_report_log.targets[targetCount] = target;
                                        targetCount += 1;
                                   }
                              }
                              analysis_report_log.targetCount = targetCount as u32;
                              if targetCount > 0 {
                                   analysis_report_logs[validLogCount] = analysis_report_log;
                                   validLogCount += 1;
                              }
                         }
                         report.payload.validLogCount = validLogCount as u32;
                         report.payload.logs = analysis_report_logs;
                    },
                    Common::AnalysisType::Safe_Only => {
                         let mut analysis_report_logs: Common::ResponseLog_Impl = Common::ResponseLog_Impl::default();
                         let mut validLogCount: usize = 0;
                         for i in logs_loop: 0..response.payload.validLogCount
                              invariant
                                   response.payload.validLogCount <= Common::Common_ResponseLog_Impl_DIM_0 as u32,
                                   validLogCount as int <= logs_loop.index(),
                                   forall|k: int|
                                        0 <= k < response.payload.validLogCount as int ==>
                                             response.payload.logs[k].targetCount
                                                  <= Common::Common_TargetObservationArray_Impl_DIM_0 as u32,
                         {
                              let log = response.payload.logs[i as usize];
                              let mut analysis_report_log: Common::Log_Impl = Common::Log_Impl::default();
                              let mut targetCount: usize = 0;
                              for j in targets_loop: 0..log.targetCount
                                   invariant
                                        log.targetCount <= Common::Common_TargetObservationArray_Impl_DIM_0 as u32,
                                        targetCount as int <= targets_loop.index(),
                              {
                                   let target = log.targets[j as usize];
                                   if target.assessment == Common::TargetAssessment::Safe {
                                        analysis_report_log.targets[targetCount] = target;
                                        targetCount += 1;
                                   }
                              }
                              analysis_report_log.targetCount = targetCount as u32;
                              if targetCount > 0 {
                                   analysis_report_logs[validLogCount] = analysis_report_log;
                                   validLogCount += 1;
                              }
                         }
                         report.payload.validLogCount = validLogCount as u32;
                         report.payload.logs = analysis_report_logs;
                    },
                    Common::AnalysisType::Unreviewed_Only => {
                         let mut analysis_report_logs: Common::ResponseLog_Impl = Common::ResponseLog_Impl::default();
                         let mut validLogCount: usize = 0;
                         for i in logs_loop: 0..response.payload.validLogCount
                              invariant
                                   response.payload.validLogCount <= Common::Common_ResponseLog_Impl_DIM_0 as u32,
                                   validLogCount as int <= logs_loop.index(),
                                   forall|k: int|
                                        0 <= k < response.payload.validLogCount as int ==>
                                             response.payload.logs[k].targetCount
                                                  <= Common::Common_TargetObservationArray_Impl_DIM_0 as u32,
                         {
                              let log = response.payload.logs[i as usize];
                              let mut analysis_report_log: Common::Log_Impl = Common::Log_Impl::default();
                              let mut targetCount: usize = 0;
                              for j in targets_loop: 0..log.targetCount
                                   invariant
                                        log.targetCount <= Common::Common_TargetObservationArray_Impl_DIM_0 as u32,
                                        targetCount as int <= targets_loop.index(),
                              {
                                   let target = log.targets[j as usize];
                                   if target.assessment == Common::TargetAssessment::Unreviewed {
                                        analysis_report_log.targets[targetCount] = target;
                                        targetCount += 1;
                                   }
                              }
                              analysis_report_log.targetCount = targetCount as u32;
                              if targetCount > 0 {
                                   analysis_report_logs[validLogCount] = analysis_report_log;
                                   validLogCount += 1;
                              }
                         }
                         report.payload.validLogCount = validLogCount as u32;
                         report.payload.logs = analysis_report_logs;
                    },
                    Common::AnalysisType::Target_History => {
                         let mut analysis_report_logs: Common::ResponseLog_Impl = Common::ResponseLog_Impl::default();
                         let mut validLogCount: usize = 0;
                         for i in logs_loop: 0..response.payload.validLogCount
                              invariant
                                   response.payload.validLogCount <= Common::Common_ResponseLog_Impl_DIM_0 as u32,
                                   validLogCount as int <= logs_loop.index(),
                                   forall|k: int|
                                        0 <= k < response.payload.validLogCount as int ==>
                                             response.payload.logs[k].targetCount
                                                  <= Common::Common_TargetObservationArray_Impl_DIM_0 as u32,
                         {
                              let log = response.payload.logs[i as usize];
                              let mut analysis_report_log: Common::Log_Impl = Common::Log_Impl::default();
                              let mut targetCount: usize = 0;
                              for j in targets_loop: 0..log.targetCount
                                   invariant
                                        log.targetCount <= Common::Common_TargetObservationArray_Impl_DIM_0 as u32,
                                        targetCount as int <= targets_loop.index(),
                              {
                                   let target = log.targets[j as usize];
                                   if target.targetID == response.payload.request.targetID {
                                        analysis_report_log.targets[targetCount] = target;
                                        targetCount += 1;
                                   }
                              }
                              analysis_report_log.targetCount = targetCount as u32;
                              if targetCount > 0 {
                                   analysis_report_logs[validLogCount] = analysis_report_log;
                                   validLogCount += 1;
                              }
                         }
                         report.payload.validLogCount = validLogCount as u32;
                         report.payload.logs = analysis_report_logs;
                    },
               }
               api.put_analysis_report(report);
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
