// This file will not be overwritten if HAMR codegen is rerun

use data::*;
use crate::bridge::cpuSw_decryptor_decryptor_api::*;
use vstd::prelude::*;
use base64::{Engine as _, engine::general_purpose};
use aes_gcm::{
     aead::{AeadCore, AeadInPlace},
     Aes128Gcm, Nonce, Key, KeyInit, Tag
};

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
        api.HMD_log_out.unwrap() != api.HMD_log_in.unwrap(),
        // END MARKER TIME TRIGGERED ENSURES
    {
          let encrypted_log = api.get_HMD_log_in();
          if encrypted_log.is_some() {
               let len = encrypted_log.unwrap().iter().position(|&b| b == 0).unwrap_or(64); // Find null byte
               let mut decoded_encrypted_log: Common::encryptedPayload_Impl =  [0; Common::Common_encryptedPayload_Impl_DIM_0]; // Decoded out of base64
               let parsed_log = Common::Log_Impl::default();

               match core::str::from_utf8(&encrypted_log.unwrap()[..len]) {
                    Ok(v) => {
                         let len = general_purpose::STANDARD
                              .decode_slice(v, &mut decoded_encrypted_log)
                              .expect("Buffer too small or invalid base64");
                         

                         // Decrypted Payload structure:
                         // Nonce/Initialization Vector(IV) first 12 bytes, or 96 bits +
                         // Cypher Text
                         // Tag/Checksum last 16 btyes
                         let (remaining, mut tag_parsed) = decoded_encrypted_log.split_at_mut(len-16);
                         let (nonce_parsed, cyphertext) = remaining.split_at_mut(12);
                         tag_parsed = &mut tag_parsed[..16];

                         let nonce = Nonce::from_slice(nonce_parsed);
                         let tag = Tag::from_slice(tag_parsed);

                         match self.cipher.decrypt_in_place_detached(&nonce, b"", cyphertext, &tag) {
                              Ok(()) => {
                                   // Success: 'cyphertext' now contains the valid plaintext
                                   match core::str::from_utf8(cyphertext) {
                                        Ok(v) => {
                                             log::info!("Decrypted Payload: {}", v);
                                        },
                                        Err(e) => panic!("Invalid UTF-8: {}", e),
                                   };
                              }
                              Err(e) => {
                                   // Failure: Data is corrupted or tag is wrong. 
                                   // DO NOT trust the 'buffer' contents.
                                   log::info!("Authentication failed: {}", e);
                              }
                         }
                    },
                    Err(e) => log::info!("Invalid UTF-8: {}", e),
               };

               // api.put_HMD_log_out();
          }
      // log_info("compute entrypoint invoked");
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
