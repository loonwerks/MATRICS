// This file will not be overwritten if HAMR codegen is rerun

use data::*;
use crate::bridge::cpuSw_dataManager_dataManager_dataManager_api::*;
use vstd::prelude::*;
use aes_gcm::{
     aead::{AeadCore, AeadInOut, inout::InOutBuf, consts::{U12,U16}},
     Aes128Gcm, Nonce, Key, KeyInit, Tag
};
use serde::{Deserialize, Serialize};
use rand::rngs::SmallRng;
use rand::{RngCore, SeedableRng};

// Shared key between dataManager and on-disk storage
const AES_KEY: [u8; 16] = [
    0x3c, 0x79, 0x6a, 0x68,
    0xa8, 0x33, 0x4f, 0x17,
    0x4c, 0xec, 0x31, 0x12,
    0x29, 0x22, 0xc7, 0xc5,
];

verus! {

  pub struct cpuSw_dataManager_dataManager_dataManager {
    // BEGIN MARKER STATE VARS
    pub zeroize_cmd: bool,
    // END MARKER STATE VARS
  }

  impl cpuSw_dataManager_dataManager_dataManager {
    pub fn new() -> Self
    {
      Self {
        // BEGIN MARKER STATE VAR INIT
        zeroize_cmd: false,
        // END MARKER STATE VAR INIT
      }
    }

    pub fn initialize<API: cpuSw_dataManager_dataManager_dataManager_Put_Api> (
      &mut self,
      api: &mut cpuSw_dataManager_dataManager_dataManager_Application_Api<API>)
      ensures
        // BEGIN MARKER INITIALIZATION ENSURES
        // guarantee defaultZeroize
        final(self).zeroize_cmd == false,
        // END MARKER INITIALIZATION ENSURES
    {
      self.zeroize_cmd = false;
    }

    pub fn timeTriggered<API: cpuSw_dataManager_dataManager_dataManager_Full_Api> (
      &mut self,
      api: &mut cpuSw_dataManager_dataManager_dataManager_Application_Api<API>)
      requires
        // BEGIN MARKER TIME TRIGGERED REQUIRES
        // assume AADL_Requirement
        //   All outgoing event ports must be empty
        old(api).encrypted_log.is_none(),
        old(api).storage_request.is_none(),
        old(api).response_log.is_none(),
        // END MARKER TIME TRIGGERED REQUIRES
      ensures
        // BEGIN MARKER TIME TRIGGERED ENSURES
        // guarantee zeroize_cmd_variable
        //   G: Once a zeroize command is seen, always zeroize.
        final(self).zeroize_cmd == (final(api).zeroize.is_some() || old(self).zeroize_cmd),
        // guarantee Zeroize_Payload
        //   G: Zeroize outgoing responses once an alert is received and when a request has been made.
        final(self).zeroize_cmd && final(api).request_log.is_some() ==>
          IS_ZEROIZED(final(api).response_log.unwrap().payload),
        // END MARKER TIME TRIGGERED ENSURES
    {
          if api.get_zeroize() {
               self.zeroize_cmd = true;
          }

          if let Some(hmd_log) = api.get_HMD_log() { // Send HMD to dataStorage
               if let Some(log) = encrypt(hmd_log) {
                    api.put_encrypted_log(Common::StoredLogFile_Impl {
                         metadata: Common::LogFileMetadata_Impl {
                              guardID: hmd_log.guardID, 
                              deviceID: hmd_log.deviceID, 
                              timestamp: hmd_log.timestamp,
                         }, 
                         encryptedLog: log
                    });
               };
          };

          if let Some(request_log) = api.get_request_log() { // Send Request to dataStorage
               if self.zeroize_cmd { // Abort sending request to dataStorage...zeroize!
                    let zero_response = Common::AnalysisResponse_Impl {
                         header: request_log.header,
                         payload: Common::Response_Impl {
                              request: Common::Request_Impl {
                                   analysisType: Common::AnalysisType::All_Records,
                                   guardID: 0u32,
                                   startTime: 0u64,
                                   endTime: 0u64,
                                   targetID: 0u32,
                              },
                              validLogCount: 0u32,
                              moreAvailable: false,
                              nextStartTime: 0u64,
                              logs: [
                                   Common::Log_Impl {
                                   timestamp: 0u64,
                                   guardID: 0u32,
                                   deviceID: 0u32,
                                   hmdPosition: Common::HMDPosition_Impl {
                                             positionX: 0i32,
                                             positionY: 0i32,
                                             positionZ: 0i32,
                                             orientationX: 0i32,
                                             orientationY: 0i32,
                                             orientationZ: 0i32,
                                             orientationW: 0i32,
                                        },
                                   targetCount: 0u32,
                                   targets: [
                                        Common::TargetObservation_Impl {
                                             targetID: 0u32,
                                             locationX: 0i32,
                                             locationY: 0i32,
                                             locationZ: 0i32,
                                             assessment: Common::TargetAssessment::Unreviewed,
                                        };
                                        Common::Common_TargetObservationArray_Impl_DIM_0
                                   ],
                              };
                                   Common::Common_ResponseLog_Impl_DIM_0
                              ],
                         },
                    };
                    api.put_response_log(zero_response);
                    return;
               }
               api.put_storage_request(request_log);
          }

          if let Some(mut encrypted_response) = api.get_encrypted_response() { // Send Response to logMonitor
               if let Some(response_log) = decrypt(&mut encrypted_response.payload.logs) {
                    api.put_response_log(Common::AnalysisResponse_Impl {
                         header: encrypted_response.header,
                         payload: Common::Response_Impl {
                              request: encrypted_response.payload.request,
                              validLogCount: encrypted_response.payload.validLogCount,
                              moreAvailable: encrypted_response.payload.moreAvailable,
                              nextStartTime: encrypted_response.payload.nextStartTime,
                              logs: response_log,
                         },
                    });
               }
          }




          // if !self.zeroize_cmd {
              
          // }

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
  pub fn encrypt(hmd_log: Common::Log_Impl) -> Option<Common::EncryptedMessage_Impl>
  {
     match to_json(hmd_log){
          Some((mut log, log_len)) => {
               let key = Key::<Aes128Gcm>::try_from(AES_KEY.as_slice()).ok()?;
               let cipher = Aes128Gcm::new(&key);
               let mut rng = SmallRng::from_seed([42; 32]); // To-Do: Adjust the seed
               let mut nonce_array = [0u8; 12];
               rng.fill_bytes(&mut nonce_array);
               let nonce = Nonce::<U12>::try_from(nonce_array.as_slice()).ok()?;
               let ciphertext = log.get_mut(..log_len as usize)?;
               match cipher.encrypt_inout_detached(&nonce, b"", InOutBuf::from(&mut *ciphertext)) {
                    Ok((tag)) => {
                         return Some(Common::EncryptedMessage_Impl {
                              nonce: nonce_array,
                              ciphertext: log,
                              tag: tag.into(),
                              ciphertext_len: log_len as u32,
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
  pub fn decrypt(encrypted_response: &mut Common::EncryptedResponseLog_Impl) -> Option<Common::ResponseLog_Impl>
  {
     let key = Key::<Aes128Gcm>::try_from(AES_KEY.as_slice()).ok()?;
     let cipher = Aes128Gcm::new(&key);

     let mut response_log: Common::ResponseLog_Impl = [Common::Log_Impl::default(); Common::Common_ResponseLog_Impl_DIM_0];

     for (i, log_file) in encrypted_response.iter_mut().enumerate() {
          if (i >= Common::Common_ResponseLog_Impl_DIM_0){
               return None; // Check for valid response entry number
          }
          let nonce = Nonce::<U12>::try_from(log_file.encryptedLog.nonce.as_slice()).ok()?;
          let tag = Tag::<U16>::try_from(log_file.encryptedLog.tag.as_slice()).ok()?;
          let ciphertext = log_file.encryptedLog.ciphertext.get_mut(..log_file.encryptedLog.ciphertext_len as usize)?;
          match cipher.decrypt_inout_detached(&nonce, b"", InOutBuf::from(&mut *ciphertext), &tag) {
               Ok(()) => {
                    // Success: 'ciphertext' now contains the valid plaintext
                    match parse_json(&ciphertext){
                         Some(mut log) => {
                              log.guardID = log_file.metadata.guardID;
                              log.deviceID = log_file.metadata.deviceID;
                              log.timestamp = log_file.metadata.timestamp;
                              response_log[i] = log;
                         },
                         None => {
                              log_info("Parsing log failed"); 
                              return None;
                         },
                    }
               }
               Err(e) => {
                    // Failure: Data is corrupted or tag is wrong. 
                    // DO NOT trust the 'buffer' contents.
                    log::info!("Decryption failed: {}", e);
                    return None;
               }
          }
     }
     return Some(response_log);
  }

  // We have to mirror Log_Impl to allow the #[derive(Deserialize)] macro to be applied
  #[verifier::external]
  #[derive(Deserialize, Serialize)]
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
  #[derive(Deserialize, Serialize)]
  enum TargetAssessment_Mirror {
     Unreviewed = 0,
     Safe = 1,
     Threat = 2,
  }

  #[verifier::external]
  #[derive(Deserialize, Serialize)]
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

  #[verifier::external]
  #[derive(Deserialize, Serialize)]
  struct Stored_Log { // Differs slightly from Log_Impl as it doesn't include timestamp, guardID, or deviceID
     hmdPosition: HMDPosition_Mirror,
     targetCount: u32,
     // Allows JSON to contain targetCount elements instead of all 15
     targets: heapless::Vec<TargetObservation_Mirror, 15>,
  }

  #[verifier::external_body]
  pub fn to_json(hmd_log: Common::Log_Impl) -> Option<(Common::Ciphertext_Impl, u32)>
  {
     let mut targets = heapless::Vec::<TargetObservation_Mirror, 15>::new();

     for i in 0..hmd_log.targetCount as usize {
          if (i >= Common::Common_TargetObservationArray_Impl_DIM_0){
               return None; // Check for invalid targetCount
          }
          if targets.push(TargetObservation_Mirror {
                    targetID: hmd_log.targets[i].targetID,
                    locationX: hmd_log.targets[i].locationX,
                    locationY: hmd_log.targets[i].locationY,
                    locationZ: hmd_log.targets[i].locationZ,
                    assessment: match hmd_log.targets[i].assessment {
                         Common::TargetAssessment::Unreviewed => TargetAssessment_Mirror::Unreviewed,
                         Common::TargetAssessment::Safe => TargetAssessment_Mirror::Safe,
                         Common::TargetAssessment::Threat => TargetAssessment_Mirror::Threat,
               },}).is_err() {
               return None;
          }
     }

     let stored_log = Stored_Log {
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
     };

     let mut plaintext: Common::Ciphertext_Impl = [0u8; Common::Common_Ciphertext_Impl_DIM_0];

     return match serde_json_core::to_slice::<Stored_Log>(&stored_log, &mut plaintext) {
          Ok(bytes_written) =>
          {
               Some((plaintext, bytes_written as u32))
          },
          Err(_err) => 
               None,
     };
  }

  #[verifier::external_body]
  pub fn parse_json(plaintext: &[u8]) -> Option<Common::Log_Impl>
  {
     return match serde_json_core::from_slice::<Stored_Log>(plaintext) {
          Ok((mut data, _consumed)) =>
          {
               let mut targets = [Common::TargetObservation_Impl::default(); Common::Common_TargetObservationArray_Impl_DIM_0];

               for (i, mirror) in data.targets.iter_mut().enumerate() {
                    targets[i] = Common::TargetObservation_Impl {
                         targetID: mirror.targetID,
                         locationX: mirror.locationX,
                         locationY: mirror.locationY,
                         locationZ: mirror.locationZ,
                         assessment: match mirror.assessment {
                              TargetAssessment_Mirror::Unreviewed => Common::TargetAssessment::Unreviewed,
                              TargetAssessment_Mirror::Safe => Common::TargetAssessment::Safe,
                              TargetAssessment_Mirror::Threat => Common::TargetAssessment::Threat,
                         },
                    };
               }

               Some(Common::Log_Impl {
                    timestamp: 0, // This info is available in LogFileMetadata outside of this function
                    guardID: 0, // This info is available in LogFileMetadata outside of this function
                    deviceID: 0, // This info is available in LogFileMetadata outside of this function
                    hmdPosition: Common::HMDPosition_Impl {
                         positionX: data.hmdPosition.positionX,
                         positionY: data.hmdPosition.positionY,
                         positionZ: data.hmdPosition.positionZ,
                         orientationX: data.hmdPosition.orientationX,
                         orientationY: data.hmdPosition.orientationY,
                         orientationZ: data.hmdPosition.orientationZ,
                         orientationW: data.hmdPosition.orientationW,
                    },
                    targetCount: data.targetCount,
                    targets,
               })
          },
          Err(_err) => 
               None,
     };
  }

  // BEGIN MARKER GUMBO METHODS
  pub open spec fn IS_ZEROIZED(response: Common::Response_Impl) -> bool
  {
    MATRICS_Model_Transformations::IS_NULL_REQUEST_spec(response.request) &&
      (response.validLogCount == 0u32) &&
      (response.moreAvailable == false) &&
      (response.nextStartTime == 0u64) &&
      forall|i:int| 0 <= i < response.logs.len() ==> MATRICS_Model_Transformations::IS_NULL_LOG_spec(response.logs[i])
  }
  // END MARKER GUMBO METHODS

}
