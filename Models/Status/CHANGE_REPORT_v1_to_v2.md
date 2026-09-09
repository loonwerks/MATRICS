# Hardened Ground Station AADL Change Report: Status v1 to Status v2

## Comparison basis

| Item | Value |
|---|---|
| Baseline | `Models/Status/Status_v1/Hardened` |
| Target | `Models/Status/Status_v2/Hardened/withAGREEOnly/aadl` |
| Report date | 2026-09-08 |
| Git branch / HEAD | `Status-v2` / `a3d3abe` |
| Target state | Current working tree, including uncommitted AADL changes |

This is a source-model comparison. It includes AADL structure, types, properties,
connections, flows, AGREE contracts, and Resolute claims.

The following were deliberately excluded:

- Generated `.aadlbin` files, instantiated `.aaxl2` models, diagrams, JSON, and
  generated HAMR source.
- Eclipse/OSATE project metadata and formatting-only changes.

## Executive summary

Status v2 changes the hardened ground station from a mostly abstract, partially
typed architecture into an explicitly typed HAMR/Microkit model with MCS domains,
C components on a shared virtual processor, structured Wi-Fi messages, explicit
AES-128-GCM framing, and a dedicated encrypted-storage component.

The principal behavioral changes are:

1. Wi-Fi ingress and egress are now explicitly typed and pass through a C
   `wifiDriverVM` component.
2. Incoming encrypted HMD logs are decrypted before reaching `dataManager`.
3. A new `dataManager_sys`, parallel to `wifiDriver_sys`, contains the existing
   `dataManager` and the new `dataStorage` component.
4. `dataManager` is modeled as accepting each plaintext log and producing an
   encrypted storage message. For reads, it sends the request payload to
   `dataStorage`, receives at most ten encrypted records plus continuation
   metadata, decrypts them, and constructs the plaintext analysis response. The
   current contracts do not yet specify these encryption, storage-access, and
   decryption transformations.
5. Zeroize commands enter `dataManager_sys` from `logMonitor` and are delivered to
   both `dataStorage`, which erases persistent records, and `dataManager`, which
   zeroizes later response payloads.
6. The request/response path now carries complete `AnalysisRequest` and
   `AnalysisResponse` messages. Each plaintext response contains routing metadata,
   the echoed request criteria, bounded-result metadata, and at most ten logs before
   the encryptor converts it to an `OutgoingWifiMessage` for monitoring and
   transmission.
7. AGREE monitor and cryptographic contracts were made more precise.
8. MCS scheduling domains 2 through 13 were assigned, with a maximum domain of 15.

## Source-file inventory

| File | Status | Summary |
|---|---|---|
| `Common.aadl` | Changed | Concrete port/message types, fixed-width fields, request/response structures, AES-GCM framing, and encrypted storage-response records |
| `GroundStation.aadl` | Changed | MCS/virtual processor, typed interfaces, new storage component, bindings, and AGREE updates |
| `Hardened_SW.aadl` | Changed | C Wi-Fi VM, `dataManager_sys`, storage process, MCS domains, new data paths, and monitor/crypto contracts |
| `MATRICS_Model_Transformations.aadl` | Changed | Real allow-list values, fixed array metadata, and abstract AES-GCM AGREE functions |
| `Status_v1.aadl` → `Status_v2.aadl` | Renamed logically | Package name changed from `Status_v1` to `Status_v2`; system composition is otherwise unchanged |
| `HMD.aadl` | Unchanged | Byte-identical |
| `HMD_Computer.aadl` | Unchanged | Byte-identical |
| `HMD_HUD.aadl` | Unchanged | Byte-identical |
| `MATRICS_Properties.aadl` | Changed | Named bounds for targets per log and logs per response |

## Data type and external-interface changes

### Device ports

In v1, the Wi-Fi, Bluetooth, and USB device event-data ports had no classifiers.
In v2:

- Wi-Fi receive ports use `IncomingWifiMessage.Impl`.
- Wi-Fi send ports use `OutgoingWifiMessage.Impl`.
- Bluetooth and USB ports remain intentionally opaque but now use
  `DummyMessage.Impl`.

The same classifiers are propagated through the ground-station and hardened-software
system boundaries.

### Header and payload refinements

| Type | Status v1 | Status v2 |
|---|---|---|
| `MsgHeader.Impl` | `src`, `dst`: `Unsigned_32` | `client`: `Unsigned_32` |
| `Log.Impl` contents | Timestamp, user ID, suspect counts, and yaw/pitch/roll | Timestamp; guard and device IDs; `HMDPosition`; target count; and up to 15 HMD-relative `TargetObservation` records |
| HMD orientation | Three floating-point yaw/pitch/roll fields | `HMDPosition.Impl`: signed-millimeter position and fixed-point quaternion orientation |
| Target observations | Aggregate suspect counters only | Target ID, three-dimensional location, and `Unreviewed`/`Safe`/`Threat` assessment; no confidence field |
| `Request.Impl` | Unbounded integer fields | Analysis type, guard ID, inclusive time bounds, and optional target ID using fixed-width fields |
| Response metadata fields | `ResponseHeader.Impl`: unbounded `Integer` | Echoed request criteria, valid-log count, continuation flag, and next-start timestamp inline in `Response.Impl` |
| Response log array | `LogArray`: 60 logs, no fixed-size HAMR metadata | `ResponseLog`: `MAX_LOGS_PER_RESPONSE` (currently 10) logs, fixed, 3520 bytes |

`NULL_LOG` was rebuilt for the complete v2 schema. It zeroes the timestamp, guard
and device identifiers, the `HMDPosition`, and all 15 target slots; each null target
uses the `Unreviewed` assessment.

### Analysis requests and responses

In v1, internal request ports carried only `Request.Impl`, response ports carried
`ResponseLog.Impl`, and `AnalysisReport.payload` was an anonymous 100-byte array.
In v2:

- Request ports throughout `dataAnalysis`, `dataManager`, and `logMonitor` carry
  complete `AnalysisRequest.Impl` messages, preserving both the client header and
  request payload.
- `ResponseLog` is a fixed array of `MAX_LOGS_PER_RESPONSE` (currently 10)
  `Log.Impl` values (3520 bytes).
- `Response.Impl` echoes the original `Request.Impl` criteria and contains
  `validLogCount`, `moreAvailable`, `nextStartTime`, and the `ResponseLog.Impl`
  array. It has no request identifier or multipart fields.
- `AnalysisResponse.Impl` replaces the separate response-log and analysis-report
  envelopes. It contains `header: MsgHeader.Impl` and
  `payload: Response.Impl`.
- `AnalysisResponse.Impl` is carried from `dataManager` through `logMonitor` and
  `dataAnalysis` to the encryptor.

Each response returns at most ten logs. If additional applicable logs exist,
`moreAvailable` is true and `nextStartTime` identifies the first omitted log's
timestamp. The client can repeat the same request criteria with that inclusive
timestamp as the new `startTime`. A complete response sets `moreAvailable` false;
an empty complete response has `validLogCount` zero and all log slots set to
`NULL_LOG`.

### AES-128-GCM message framing

Status v2 introduces:

| Type/field | Size calculation | Size |
|---|---|---:|
| `Nonce` | 96 bits ÷ 8 | 12 bytes |
| `Ciphertext` | 4096 − 12-byte nonce − 16-byte tag | 4068 bytes |
| `AuthenticationTag` | 128 bits ÷ 8 | 16 bytes |
| `EncryptedMessage.Impl` | 12 + 4068 + 16 | 4096 bytes total |
| `TargetObservationArray` | 15 target records × 20 bytes | 300 bytes |
| `ResponseLog` | 10 logs × 352 bytes | 3520 bytes |
| `StoredLogFile.Impl` | 16-byte plaintext index + 4096-byte encrypted frame | 4112 bytes |
| `EncryptedLogArray` | 100 stored files × 4112 bytes | 411200 bytes |
| `EncryptedResponseLog` | 10 stored files × 4112 bytes | 41120 bytes |

`EncryptedMessage.Impl` contains the fields `nonce`, `ciphertext`, and `tag`.

`StoredLogFile.Impl` is the event-data message carried from `dataManager` to
`dataStorage` when writing one record. It combines an `EncryptedMessage.Impl`
frame with plaintext, indexable metadata (guard ID, device ID, and
timestamp). The metadata represents the information encoded in the deterministic
filename `g<guardID>_d<deviceID>_t<timestamp>.hmdlog` and is intended to be
authenticated as AES-GCM associated data even though it is not encrypted. The
combination of guard ID, device ID, and timestamp is the stored-record key; this
relies on one active device per guard and at most one log from that device at any
millisecond in the persistent common time base.

`EncryptedResponseLog.Impl` contains at most ten encrypted stored records returned
by `dataStorage` for one analysis response. The enclosing `EncryptedResponse.Impl`
also carries the original request criteria, valid-record count, and continuation
metadata. `EncryptedLogArray` is not transmitted as a message. It models persistent
on-disk storage: the `logs` data subcomponent of `dataStorage_seL4.Impl` has this
type and is accessed through `dataStorage.log_data`.

Only array types declare `Memory_Properties::Data_Size`. HAMR turns each value into
a generated byte-size constant used by array queue copies, while emitting the array
itself as a native fixed-length C or Rust array. Record elements are ordered C structs
or Rust `repr(C)` structs. The element-size calculations above use the AArch64 ABI shared
by the QEMU and RPi4B targets: 32-bit integer fields and C-compatible enumerations
occupy 4 bytes, 64-bit fields occupy 8 bytes, and ABI padding is included where
required. In particular, `Log.Impl` has 348 bytes of fields plus 4 bytes of trailing
alignment padding. The 64-byte `shortText` calculation uses
HAMR's one-byte C `char` / Rust `u8` representation for `Base_Types::Character`.

### Wi-Fi messages

- `IncomingWifiHeader.Impl` contains a 64-character `route` and a `client` ID.
- `IncomingWifiMessage.Impl` contains that routing header and an
  `EncryptedMessage.Impl` payload.
- `OutgoingWifiMessage.Impl` contains the response's client header and an
  `EncryptedMessage.Impl` payload.
- Only the inbound Wi-Fi header carries `route`. The architecture localizes the
  field to `wifiDriver`; it is not propagated through the analysis/report
  components. The current contracts do not specify the route-selection behavior.

## Architecture and data-flow changes

### Wi-Fi isolation

Status v2 adds `wifiDriverVM`, a C thread in its own process. It is grouped with the
existing Wi-Fi driver under `wifiDriver_sys`:

```text
external Wi-Fi ↔ wifiDriverVM (C) ↔ wifiDriver ↔ internal components
```

The C VM owns the external Wi-Fi-facing ports. The internal `wifiDriver` performs
routing and the existing alert-based transmission gating.

### Data manager and storage grouping

Status v2 adds `dataManager_sys`, structurally parallel to `wifiDriver_sys`. It
contains the existing `dataManager` process and the new `dataStorage` process:

```text
dataManager_sys
  ├── dataManager
  └── dataStorage (C)
```

The system boundary exposes plaintext `HMD_log`, `request_log`, `response_log`, and
the `zeroize` event. Storage write and read traffic remains internal to the system:

```text
dataManager.encrypted_log → dataStorage.encrypted_log
dataManager.storage_request → dataStorage.storage_request
dataStorage.encrypted_response → dataManager.encrypted_response
```

This grouping does not merge the two HAMR components. Each remains isolated in its
own process and has its own assigned MCS domain.

### HMD log and storage path

The v1 path ended at `dataManager`, which directly owned the on-disk plaintext log
array and received zeroize commands. The v2 path is:

```text
IncomingWifiMessage
  → wifiDriver
  → EncryptedMessage
  → decryptor
  → Log
  → dataManager_sys
      → dataManager
      → StoredLogFile
      → dataStorage
  → encrypted on-disk log array
```

Specific changes:

- `decryptor.HMD_log_in` changed from `Log.Impl` to `EncryptedMessage.Impl`.
- `dataManager.HMD_log` remains the plaintext `Log.Impl` output of the decryptor.
- `dataManager` gained `encrypted_log: out event data port
  StoredLogFile.Impl`, carrying the encrypted log together with the plaintext
  metadata needed to select its on-disk filename.
- `dataManager` no longer exposes a data-access feature or owns the persistent log
  array. It receives the system's `zeroize` event directly.
- `dataManager_sys` exposes the plaintext log, request, response, and zeroize
  interfaces required by the rest of `SW_seL4.hardened`.
- The encrypted write and read connections between `dataManager` and `dataStorage`
  are internal to `dataManager_sys`.
- New `dataStorage` inputs are `encrypted_log`, `storage_request`, and `zeroize`;
  its new `encrypted_response` output returns at most ten encrypted records with
  the request and continuation metadata needed downstream.
- `dataStorage` owns `logs: EncryptedLogArray`, with read/write data access.
- The stored array retains `Requires_Data_Confidentiality => true` and
  `Encrypted => AES_GCM`.

### Zeroization path

The zeroize connection changed from:

```text
logMonitor.alert → dataManager.zeroize
```

to:

```text
logMonitor.alert_out → dataManager_sys.zeroize
                                      ├──→ dataStorage.zeroize
                                      └──→ dataManager.zeroize
```

At the `SW_seL4.hardened` level, the `dataManager_sys` instance is named
`dataManager`; therefore the external connection is written
`logMonitor.alert_out → dataManager.zeroize`. Inside the system, that boundary port
fans out directly to both contained processes. `dataStorage` owns persistent
erasure; `dataManager` uses the same command to ensure later requested response
payloads are zeroized.

### Analysis response path

The storage read and response path now contains explicit request, encrypted-record,
plaintext-response, and outbound-ciphertext transitions:

```text
dataAnalysis.AnalysisRequest
  → dataManager
  → AnalysisRequest
  → dataStorage
  → EncryptedAnalysisResponse
  → dataManager
  → AnalysisResponse
  → logMonitor
  → dataAnalysis
  → encryptor
  → OutgoingWifiMessage
  → reportMonitor
  → wifiDriver
  → wifiDriverVM
  → external Wi-Fi
```

The storage request is `AnalysisRequest.Impl`, and the storage return is
`EncryptedAnalysisResponse.Impl`. The return message preserves the client header
and original `Request.Impl`, then adds the valid-record count, `moreAvailable`,
`nextStartTime`, and bounded encrypted-record array. `dataManager` converts the
returned encrypted records into `AnalysisResponse.Impl`. The outbound encryptor
then converts that response to `OutgoingWifiMessage.Impl`, which is used by both
report-monitor message ports and the Wi-Fi driver's internal response input.

### Connection and flow normalization

Connections in `SW_seL4.hardened` were renumbered into functional groups. Important
v2 connection identifiers are:

| Connection | Meaning |
|---|---|
| `c10` | `wifiDriver.HMD_log` → `decryptor.HMD_log_in` |
| `c11` | `decryptor.HMD_log_out` → `dataManager_sys.HMD_log` |
| `c12` | `dataAnalysis.analysis_report` → `encryptor.analysis_report_in` |
| `c13` | `reportMonitor.analysis_report_out` → `wifiDriver.analysis_report` |
| `c17` | `logMonitor.alert_out` → `dataManager_sys.zeroize` |
| `c19` | `encryptor.analysis_report_out` → `reportMonitor.analysis_report_in` |
| `c21` | `wifiDriver.analysis_request` → `firewall.analysis_request_in` |
| `c22` | `firewall.analysis_request_out` → `dataAnalysis.analysis_request` |

Within `dataManager_sys.Impl`, internal connection `c4` carries
`dataManager.encrypted_log` to `dataStorage.encrypted_log`. Connections `c5` and
`c6` fan out the system's `zeroize` event to `dataStorage.zeroize` and
`dataManager.zeroize`, respectively. Connection `c7` carries
`dataManager.storage_request` to `dataStorage.storage_request`, and `c8` returns
`dataStorage.encrypted_response` to `dataManager.encrypted_response`.

The `dataManager_sys` type declares `HMD_log` as a flow sink. Internal connections
route that input to `dataManager` and route `dataManager.encrypted_log` to
`dataStorage`; no implementation-level flow specification connects those two
internal segments.

## HAMR, Microkit, and MCS changes

The ground-station processor now specifies:

- `Frame_Period => 1000ms`
- `Clock_Period => 1ms`
- `CASE_Scheduling::Max_Domain => 15`
- `HAMR::Platform => (Microkit)`
- Default `HAMR::Microkit_Language => Rust`

A `virt_proc` virtual processor was added. `wifiDriverVM` and the `dataStorage`
process nested under `dataManager_sys` are both bound to this existing virtual
processor and explicitly use C.

| Domain | Component |
|---:|---|
| 2 | `wifiDriverVM` |
| 3 | `wifiDriver` |
| 4 | `decryptor` |
| 5 | `firewall` |
| 6 | `dataAnalysis` |
| 7 | `dataManager` |
| 8 | `logMonitor` |
| 9 | `encryptor` |
| 10 | `reportMonitor` |
| 11 | `btDriver` |
| 12 | `usbDriver` |
| 13 | `dataStorage` |

All ground-station computational threads now explicitly use a periodic 1000 ms
dispatch and a 1048576-byte stack. `wifiDriverVM` additionally declares a 150 ms
execution time.

## AGREE contract changes

Except for the two invalid v1 report-monitor alert guarantees described below, the
behavioral obligations represented by the v1 guarantees are retained. Duplicate v1
declarations at the thread and process levels were consolidated where responsibility
moved. Some guarantees were also refined to match the updated types and event
behavior.

### Shared contract vocabulary

The allow list changed from placeholder values `1, 2, 3, 4` to the unsigned integer
representations of:

- `192.168.1.101`
- `192.168.1.102`
- `192.168.1.103`
- `192.168.1.104`

In the AGREE constant, each address is written as IPv4 octet arithmetic. This
preserves the full unsigned value while avoiding oversized decimal tokens that the
front end attempts to parse as signed 32-bit integers.

The following uninterpreted AGREE abstractions were added for AES-128-GCM:

- `AES_128_GCM_DECRYPTS_LOG`, a relation between an encrypted message and a
  decrypted log
- `AES_128_GCM_ENCRYPTS_RESPONSE`, a relation between a plaintext response and an
  encrypted message

These define the abstraction boundary used by component contracts. They do not, by
themselves, prove a concrete AES implementation correct.

### `wifiDriver`

- Trust checks now use `header.client` instead of `header.dst`.
- The alert feature was normalized to an event port named `alert_in`.
- When transmission is permitted, `wifiSend` must contain the same
  `OutgoingWifiMessage` received on `analysis_report`; v1 constrained only the
  presence of an output event.

### `dataManager`

The v1 `Zeroize_Payload` guarantee is retained on the `dataManager` thread. The
system's `zeroize` event is connected directly to the thread through
`dataManager_seL4.Impl`; after zeroize, a requested response payload must be
zero-valued. The thread contract is lifted through the process implementation so it
is available for compositional reasoning. The storage write/read ports express the
new encrypted storage path architecturally, but do not yet have behavioral
encryption, persistence, retrieval, or decryption guarantees.

### `dataManager_sys`

The v1 `Zeroize_Payload` guarantee is also stated at the `dataManager_sys` boundary,
which can observe `zeroize`, `request_log`, and `response_log`. Its obligation is
retained and strengthened: after zeroize, a requested `AnalysisResponse.payload`
must contain a null request, a zero `validLogCount`, a false `moreAvailable` flag, a
zero `nextStartTime`, and only `NULL_LOG` entries. The boundary guarantee can be
supported compositionally by the lifted `dataManager` guarantee and the direct
zeroize, request, and response connections.

### `dataStorage`

The v1 `Zeroize_Cache` guarantee moved with persistent-storage ownership from
`dataManager` to `dataStorage`. The component now has an abstract `cache` view of
its persistent `EncryptedLogArray`. Once a `zeroize` event has occurred, the
refined guarantee requires every byte of every record's nonce, ciphertext, and
authentication tag to remain zero.

The guarantee remains on the `dataStorage` thread. It is not lifted through
`dataStorage_seL4.Impl`: that process implementation contains both the thread and
the persistent `logs` data subcomponent, so a blanket single-subcomponent lift is
not valid. The `logs` subcomponent remains necessary to represent the persistent
state, carry the storage confidentiality/encryption properties, and provide the
explicit data-access connection to the storage thread.

### `logMonitor`

- The alert output was renamed `alert_out` consistently at the thread and process
  boundaries and corrected to an event port.
- The `Since` expression was reformatted without a semantic change.
- Response forwarding changed from checking only `is_valid` to requiring that no
  alert has occurred historically. Thus the monitor remains closed after an alert.

### `reportMonitor`

- Report ports now carry `OutgoingWifiMessage.Impl`.
- The alert output was renamed `alert_out` consistently at the thread and process
  boundaries and corrected from event-data to event.
- The invalid v1 `Alert1` and `Alert2` guarantees were replaced by one `Alert`
  guarantee. It requires an alert when either trigger holds and prohibits an alert
  only when neither trigger holds, avoiding the contradictory v1 negative branches.
- Destination trust checks now use `header.client` rather than `header.dst`.

### `decryptor`

The v1 `Payload_Decrypted` guarantee ID and description are retained. When an
encrypted input event occurs, `AES_128_GCM_DECRYPTS_LOG` must hold between the
incoming encrypted message and outgoing log. The relational form avoids AGREE's
restriction against constrained function output types, which applies because
`Log.Impl` contains the `TargetAssessment` enumeration. The contract does not
require an output event and does not specify authentication, invalid-input handling,
or behavior when no input event occurs.

### `encryptor`

The encryptor now transforms `AnalysisResponse.Impl` into
`OutgoingWifiMessage.Impl`. The v1 `Payload_Encrypted` guarantee ID and description
are retained. On an input event, `AES_128_GCM_ENCRYPTS_RESPONSE` must hold between
the complete incoming `Response.Impl` payload and the outgoing
`EncryptedMessage.Impl` payload. The incoming response includes the echoed request
criteria, valid-log count,
continuation metadata, and logs. The relational form avoids generating a structured
4096-byte function result during AGREE analysis. The guarantee does not require an
output event or constrain behavior when no input event occurs.

The v1 `Header_Unencrypted` guarantee ID, description, and header-equality
constraint are also retained.

### `firewall` and `dataAnalysis`

Trusted-source checks now use `header.client` instead of the removed `header.src`
field. Firewall forwarding behavior is otherwise unchanged.

## Resolute claim updates

Resolute arguments were updated to follow the new architecture and types:

- Firewall connection reference changed to normalized connection `c22`.
- Report monitoring/encryption claims now use `OutgoingWifiMessage.Impl`.
- The monitor-alert connection check now recognizes the canonical `alert_out`
  name used by both monitor threads.
- Wi-Fi authorization refers to the nested C VM thread under `wifiDriver_sys`.
- Data-manager claims now traverse `dataManager_sys` to the contained process and
  thread (`dataManager.dataManager.dataManager`).
- Secure-storage ownership now traverses `dataManager_sys` and identifies the
  contained storage thread (`dataManager.dataStorage.dataStorage`), rather than the
  v1 data-manager thread.

## Known limitations and deferred work

1. AES-128-GCM is represented by uninterpreted AGREE functions. Concrete algorithm,
   key handling, authentication-tag verification, and nonce-uniqueness proofs remain
   implementation-level obligations. The current payload guarantees also do not
   specify event production, authentication failure handling, or behavior without
   an input event.
2. The zeroize contract uses the abstract AGREE stream `cache` because the
   backing data-access storage is not directly observable in the contract. Proving
   that `cache` denotes the actual `dataStorage.log_data` contents remains an
   implementation-level obligation.
3. The typed storage ports express the intended write and read transformations, but
   no current component contract constrains `dataManager.encrypted_log` to be the
   AES-128-GCM encryption of `HMD_log`, requires `dataStorage` to persist received
   records, relates `storage_request` to `encrypted_response` and its continuation
   metadata, or requires `dataManager` to decrypt the returned records into
   `response_log`.
4. The Resolute storage rule checks that an `Encrypted` property is present on
   on-disk confidential data; it does not check that the property's value is
   specifically `AES_GCM` or prove that the stored values are ciphertext.
5. This comparison is static and source-based. OSATE, AGREE verification, HAMR code
   generation, and scheduling analysis were not run while preparing the report.
6. Generated instance models and diagrams were excluded and may be stale relative
   to the current AADL working tree.

## Maintaining this record

This report is a consolidated snapshot of the current v1-to-v2 differences. When the
model changes, revise the affected sections directly so the report continues to
describe the current model rather than accumulating an append-only change log.
