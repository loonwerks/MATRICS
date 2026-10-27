// This file will not be overwritten if HAMR codegen is rerun

use data::*;
use crate::bridge::cpuSw_encryptor_encryptor_api::*;
use vstd::prelude::*;

use aes_gcm::{
     aead::{AeadCore, AeadInOut, inout::InOutBuf, consts::{U12,U16}},
     Aes128Gcm, Nonce, Key, KeyInit, Tag
};
use serde::Serialize;
use rand::rngs::SmallRng;
use rand::{RngCore, SeedableRng};

// Shared key between client and server
const AES_KEY: [u8; 16] = [
    0xa8, 0xf0, 0xe5, 0x78,
    0xe8, 0x26, 0x08, 0x6d,
    0x30, 0x42, 0xa0, 0x50,
    0x22, 0xa7, 0x8b, 0x26,
];

verus! {

  pub struct cpuSw_encryptor_encryptor {
    // PLACEHOLDER MARKER STATE VARS
  }

  impl cpuSw_encryptor_encryptor {
    pub fn new() -> Self
    {
      Self {
        // PLACEHOLDER MARKER STATE VAR INIT
      }
    }

    pub fn initialize<API: cpuSw_encryptor_encryptor_Put_Api> (
      &mut self,
      api: &mut cpuSw_encryptor_encryptor_Application_Api<API>)
      ensures
        // PLACEHOLDER MARKER INITIALIZATION ENSURES
    {
      log_info("initialize entrypoint invoked");
    }

    pub fn timeTriggered<API: cpuSw_encryptor_encryptor_Full_Api> (
      &mut self,
      api: &mut cpuSw_encryptor_encryptor_Application_Api<API>)
      requires
        // BEGIN MARKER TIME TRIGGERED REQUIRES
        // assume AADL_Requirement
        //   All outgoing event ports must be empty
        old(api).analysis_report_out.is_none(),
        // END MARKER TIME TRIGGERED REQUIRES
      ensures
        // BEGIN MARKER TIME TRIGGERED ENSURES
        // guarantee Payload_Encrypted
        //   G: Outgoing payload is encrypted.
        final(api).analysis_report_in.is_some() ==> MATRICS_Model_Transformations::AES_128_GCM_ENCRYPTS_RESPONSE_spec(final(api).analysis_report_in.unwrap().payload, final(api).analysis_report_out.unwrap().payload),
        // guarantee Header_Unencrypted
        //   G: Outgoing header is not encrypted.
        final(api).analysis_report_out.is_some() ==>
          (final(api).analysis_report_out.unwrap().header == final(api).analysis_report_in.unwrap().header),
        // END MARKER TIME TRIGGERED ENSURES
    {

          let Some(analysis_response) = api.get_analysis_report_in() else {
               return;
          }; 

          if let Some(encrypted) = encrypt(analysis_response.payload) {
               api.put_analysis_report_out(Common::OutgoingWifiMessage_Impl {
                         header: analysis_response.header,
                         payload: encrypted,
                    });
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
  pub fn encrypt(response: Common::Response_Impl) -> Option<Common::EncryptedMessage_Impl>
  {
     match to_json(response){
          Some((mut sent_response, sent_response_len)) => {
               let key = Key::<Aes128Gcm>::try_from(AES_KEY.as_slice()).ok()?;
               let cipher = Aes128Gcm::new(&key);
               let mut rng = SmallRng::from_seed([42; 32]); // To-Do: Adjust the seed
               let mut nonce_array = [0u8; 12];
               rng.fill_bytes(&mut nonce_array);
               let nonce = Nonce::<U12>::try_from(nonce_array.as_slice()).ok()?;
               let ciphertext = sent_response.get_mut(..sent_response_len as usize)?;
               match cipher.encrypt_inout_detached(&nonce, b"", InOutBuf::from(&mut *ciphertext)) {
                    Ok((tag)) => {
                         return Some(Common::EncryptedMessage_Impl {
                              nonce: nonce_array,
                              ciphertext: sent_response,
                              tag: tag.into(),
                              ciphertext_len: sent_response_len as u32,
                         });
                    }
                    Err(e) => {
                         // Failure: Data is corrupted or tag is wrong. 
                         // DO NOT trust the 'buffer' contents.
                         log::info!("Encryption failed: {}", e);
                         return None;
                    }
               }
          },
          None => {
               log_info("Parsing log failed");
               return None; 
          },
     };
  }

    #[verifier::external_body]
  pub fn to_json(response: Common::Response_Impl) -> Option<(Common::Ciphertext_Impl, u32)>
  {
     // We have to mirror ResponseLog_Impl to allow the #[derive(Serialize)] macro to be applied
     #[verifier::external]
     #[derive(Serialize)]
     struct HMDPosition_Mirror {
          positionX: i32,
          positionY: i32,
          positionZ: i32,
          orientationX: i32,
          orientationY: i32,
          orientationZ: i32,
          orientationW: i32,
     }

     #[verifier::external]
     #[derive(Serialize)]
     enum TargetAssessment_Mirror {
          Unreviewed = 0,
          Safe = 1,
          Threat = 2,
     }

     #[verifier::external]
     #[derive(Serialize)]
     struct TargetObservation_Mirror {
          targetID: u32,
          locationX: i32,
          locationY: i32,
          locationZ: i32,
          assessment: TargetAssessment_Mirror,
     }

     #[verifier::external]
     impl Default for TargetObservation_Mirror {
          fn default() -> Self
          {
               Self { targetID: 0, locationX: 0, locationY: 0, locationZ: 0, assessment: TargetAssessment_Mirror::Unreviewed }
          }
     }

     #[derive(Serialize)]
     struct Log_Mirror {
          timestamp: u64,
          guardID: u32,
          deviceID: u32,
          hmdPosition: HMDPosition_Mirror,
          targetCount: u32,
          // Allows JSON to contain targetCount elements instead of all 15
          targets: heapless::Vec<TargetObservation_Mirror, 15>,
     }

     #[derive(Serialize)]
     struct Sent_Response { // Differs slightly from Response_Impl as it doesn't include request
          validLogCount: u32,
          moreAvailable: bool,
          nextStartTime: u64,
          logs: heapless::Vec<Log_Mirror, 10>,
     }

     let mut logs = heapless::Vec::<Log_Mirror, 10>::new();

     for i in 0..response.validLogCount as usize {
          if (i >= Common::Common_ResponseLog_Impl_DIM_0){
               return None; // Check for invalid validLogCount
          }

          let hmd_log = response.logs[i];

          let mut targets = heapless::Vec::<TargetObservation_Mirror, 15>::new();

          for j in 0..hmd_log.targetCount as usize {
               if (j >= Common::Common_TargetObservationArray_Impl_DIM_0){
                    return None; // Check for invalid targetCount
               }
               if targets.push(TargetObservation_Mirror {
                         targetID: hmd_log.targets[j].targetID,
                         locationX: hmd_log.targets[j].locationX,
                         locationY: hmd_log.targets[j].locationY,
                         locationZ: hmd_log.targets[j].locationZ,
                         assessment: match hmd_log.targets[j].assessment {
                              Common::TargetAssessment::Unreviewed => TargetAssessment_Mirror::Unreviewed,
                              Common::TargetAssessment::Safe => TargetAssessment_Mirror::Safe,
                              Common::TargetAssessment::Threat => TargetAssessment_Mirror::Threat,
                    },}).is_err() {
                    return None;
               }
          }

          if logs.push(Log_Mirror {
               timestamp: hmd_log.timestamp,
               guardID: hmd_log.guardID,
               deviceID: hmd_log.deviceID,
               hmdPosition: HMDPosition_Mirror {
                    positionX: hmd_log.hmdPosition.positionX,
                    positionY: hmd_log.hmdPosition.positionY,
                    positionZ: hmd_log.hmdPosition.positionZ,
                    orientationX: hmd_log.hmdPosition.orientationX,
                    orientationY: hmd_log.hmdPosition.orientationY,
                    orientationZ: hmd_log.hmdPosition.orientationZ,
                    orientationW: hmd_log.hmdPosition.orientationW,
               },
               targetCount: hmd_log.targetCount,
               targets,
          }).is_err() {
               return None;
          }
     }

     let sent_response = Sent_Response {
          validLogCount: response.validLogCount,
          moreAvailable: response.moreAvailable,
          nextStartTime: response.nextStartTime,
          logs: logs,
     };

     let mut plaintext: Common::Ciphertext_Impl = [0u8; Common::Common_Ciphertext_Impl_DIM_0];

     return match serde_json_core::to_slice::<Sent_Response>(&sent_response, &mut plaintext) {
          Ok(bytes_written) =>
          {
               Some((plaintext, bytes_written as u32))
          },
          Err(_err) => 
               None,
     };
  }

  // PLACEHOLDER MARKER GUMBO METHODS

}
