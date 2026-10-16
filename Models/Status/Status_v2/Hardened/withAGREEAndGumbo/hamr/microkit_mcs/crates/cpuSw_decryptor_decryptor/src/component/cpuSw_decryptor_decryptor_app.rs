// This file will not be overwritten if HAMR codegen is rerun

use data::*;
use crate::bridge::cpuSw_decryptor_decryptor_api::*;
use vstd::prelude::*;
use aes_gcm::{
     aead::{AeadCore, AeadInPlace, consts::{U12,U16}},
     Aes128Gcm, Nonce, Key, KeyInit, Tag
};
use serde::Deserialize;

verus! {

  pub struct cpuSw_decryptor_decryptor {
    // PLACEHOLDER MARKER STATE VARS
    pub cipher: Aes128Gcm,
  }

  impl cpuSw_decryptor_decryptor {
    pub fn new() -> Self
    {
     let key = Key::<Aes128Gcm>::from_slice(b"\xa8\xf0\xe5\x78\xe8\x26\x08\x6d\x30\x42\xa0\x50\x22\xa7\x8b\x26"); // Shared key between client and server
      Self {
        // PLACEHOLDER MARKER STATE VAR INIT
        cipher: Aes128Gcm::new(key),
      }
    }

    pub fn initialize<API: cpuSw_decryptor_decryptor_Put_Api> (
      &mut self,
      api: &mut cpuSw_decryptor_decryptor_Application_Api<API>)
      ensures
        // PLACEHOLDER MARKER INITIALIZATION ENSURES
    {
      // log_info("initialize entrypoint invoked");
    }

    pub fn timeTriggered<API: cpuSw_decryptor_decryptor_Full_Api> (
      &mut self,
      api: &mut cpuSw_decryptor_decryptor_Application_Api<API>)
      requires
        // BEGIN MARKER TIME TRIGGERED REQUIRES
        // assume AADL_Requirement
        //   All outgoing event ports must be empty
        old(api).HMD_log_out.is_none(),
        // END MARKER TIME TRIGGERED REQUIRES
      ensures
        // BEGIN MARKER TIME TRIGGERED ENSURES
        // guarantee Payload_Decrypted
        //   G: Outgoing payload is decrypted.
        final(api).HMD_log_in.is_some() ==> MATRICS_Model_Transformations::AES_128_GCM_DECRYPTS_LOG_spec(final(api).HMD_log_in.unwrap(), final(api).HMD_log_out.unwrap()),
        // END MARKER TIME TRIGGERED ENSURES
    {
          let Some(mut encrypted) = api.get_HMD_log_in() else {
               return;
          };

          let nonce = Nonce::<U12>::from_slice(&encrypted.nonce);
          let tag = Tag::<U16>::from_slice(&encrypted.tag);
          let ciphertext = &mut encrypted.ciphertext[..encrypted.ciphertext_len as usize];
          match self.cipher.decrypt_in_place_detached(&nonce, b"", ciphertext, &tag) {
               Ok(()) => {
                    // Success: 'ciphertext' now contains the valid plaintext
                    match parse_json(&ciphertext){
                         Some(log) => api.put_HMD_log_out(log),
                         None => log_info("Parsing log failed"),
                    }
               }
               Err(e) => {
                    // Failure: Data is corrupted or tag is wrong. 
                    // DO NOT trust the 'buffer' contents.
                    log_info("Decryption failed");
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
  pub fn parse_json(plaintext: &[u8]) -> Option<Common::Log_Impl>
  {
     // We have to mirror Log_Impl to allow the #[derive(Deserialize)] macro to be applied
     #[derive(Deserialize)]
     struct HMDPosition_Mirror {
          positionX: i32,
          positionY: i32,
          positionZ: i32,
          orientationX: i32,
          orientationY: i32,
          orientationZ: i32,
          orientationW: i32,
     }

     #[derive(Deserialize)]
     enum TargetAssessment_Mirror {
          Unreviewed = 0,
          Safe = 1,
          Threat = 2,
     }

     #[derive(Deserialize)]
     struct TargetObservation_Mirror {
          targetID: u32,
          locationX: i32,
          locationY: i32,
          locationZ: i32,
          assessment: TargetAssessment_Mirror,
     }

     #[derive(Deserialize)]
     struct Log_Mirror {
          timestamp: u64,
          guardID: u32,
          deviceID: u32,
          hmdPosition: HMDPosition_Mirror,
          targetCount: u32,
          // Allows JSON to contain targetCount elements instead of all 15
          targets: heapless::Vec<TargetObservation_Mirror, 15>,
     }
     
     return match serde_json_core::from_slice::<Log_Mirror>(plaintext) {
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
                    timestamp: data.timestamp,
                    guardID: data.guardID,
                    deviceID: data.deviceID,
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

  // PLACEHOLDER MARKER GUMBO METHODS

}
