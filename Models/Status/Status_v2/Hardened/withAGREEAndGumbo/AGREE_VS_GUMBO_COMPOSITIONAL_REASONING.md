# AGREE vs. GUMBO Compositional Reasoning

**Model:** `withAGREEAndGumbo`  
**System:** `GroundStation.Impl` / `GroundStation_Impl`, MCS selected  
**Date:** 2026-09-10  
**Current experiment:** one schedule-dependent storage-zeroization property  
**Scope:** component contracts were not changed; OSATE was not invoked or modified.

## Executive verdict

| Question | AGREE | GUMBO system specifications | Verdict for this model |
|---|---|---|---|
| Does the proof engine scale modularly? | Yes. Hierarchical assume-guarantee reasoning avoids flattening the complete implementation. | Reasonably. Each property produces independent VCs over component contracts rather than component code. | Both are modular, but in different abstractions. |
| Does the specification effort scale comparably? | Usually yes: architecture, component contracts, and hierarchy drive composition directly. | Not currently. The author supplies aliases, a duplicate proof schedule, the theorem, and supporting place assertions. | **AGREE advantage.** |
| Does adding a property disturb existing proofs? | Usually localized by hierarchy and compositional analysis. | No logical coupling: concrete properties are verified independently. | Good GUMBO modularity. |
| Does proof volume grow predictably? | Tool-managed; the model does not expose one proof outline per transition. | Yes, but visibly: approximately one Pre/Next pair per schema transition, per concrete property, plus boundary and independence VCs. | GUMBO is predictable but verbose. |
| Can AGREE prove the physical MCS dispatch order? | No; it reasons over synchronous logical ticks. | It can prove a theorem about a declared schema. | GUMBO adds an order-aware proof abstraction. |
| Is the declared schema tied to the generated MCS schedule? | Not applicable. | No automatic generation or conformance check was observed. | **Major assurance and maintenance gap.** |
| Does this proof establish that the C/VM storage implementation really zeroizes? | No; implementation evidence is external. | No. The system proof trusts the non-Rust `dataStorage` GUMBO contract. | Tie; external evidence is still required. |
| Is GUMBO currently “AGREE++”? | — | It adds schedule-place and potential code-level reasoning, but loses much of AGREE's compositional automation. | **No, not as a strict superset today.** |

## The single retained theorem

The composition now contains one concrete property:
`Zeroize_Storage_Before_Next_DataManager`.

| Schema point | Assertion | Contract used |
|---|---|---|
| `after log_monitor` | An invalid response implies `storage_alert` is sent. | `LogMonitor.Send_Alert` |
| `after data_storage_3` | The same trigger implies the storage zeroize latch is active and the encrypted-log cache is zeroized. | `DataStorage.zeroize_cmd_variable` and `DataStorage.Zeroize_Cache` |
| Shared boundary | `after data_storage_3` is also immediately `before data_manager_3` in the declared schema. | Schema sequencing |

The proof chain is:

```text
invalid response
  -> logMonitor sends storage_alert
  -> dataStorage dispatches
  -> dataStorage latches zeroize and zeroizes cache
  -> next declared dataManager dispatch
```

### What the theorem establishes

| Established relative to the schema | Not established |
|---|---|
| The log-monitor contract entails the storage alert for the invalid-response condition. | That the generated MCS schedule conforms to this schema. |
| The storage contract entails an active zeroize latch and zeroized cache after `data_storage_3`. | That the C/VM storage implementation conforms to its contract. |
| The zeroized-cache assertion holds at the schema place immediately before `data_manager_3`. | That `encrypted_response` is zeroized or that dataManager's returned payload is zeroized; the storage contract does not state either fact. |
| No data-manager transition occurs between `log_monitor` and `data_storage_3` in this schema. | Timing, promptness, or a bound on the physical time to zeroize. |

“Processed by dataStorage” therefore has a precise model-level meaning here:
`zeroize_cmd` is active and `IS_ZEROIZED_ENCRYPTED_LOG_ARRAY(cache)` holds.
It does not, by itself, specify the value of storage's outgoing response.

## Scalability: three separate questions

### 1. Proof-engine scalability

| Factor | Growth behavior | This model |
|---|---|---|
| Linear schema transitions | Roughly two transition VCs per occurrence per property, plus initialization, end, and frame closure. | 15 occurrences produce 33 generated VCs for one property. |
| Number of concrete properties | Approximately linear because each property gets an independent proof module. | Eight properties produced 264 generated VCs; one produces 33. |
| Shared connection checks | Added once per composition, not once per property. | Verus reports one additional shared obligation. |
| `split`/independence | Adds per-property non-blocking/preservation VCs and shared commutativity VCs for may-happen-in-parallel pairs. | Not exercised by this linear schema; broad splits can approach quadratic pair growth. |
| SMT query coupling | VCs are small and independent rather than one monolithic implementation proof. | The simplified proof verifies quickly after dependencies are built. |

For a linear schema, the observed growth is:

| Configuration | Concrete properties | Schema occurrences | Generated system VCs | Verus result | Generated proof Rust |
|---|---:|---:|---:|---:|---:|
| Previous composition | 8 | 15 | 264 | 265 verified, 0 errors | 4,992 lines |
| Simplified composition | 1 | 15 | 33 | 34 verified, 0 errors | 1,892 lines |
| Reduction | 87.5% | none | 87.5% | 87.2% fewer verified obligations | 62.1% fewer lines |

The engine is modular enough for larger systems, but the generated proof still includes
uniform, mostly trivial VCs for all 15 schema transitions. One small two-step theorem
therefore produces 33 generated obligations and nearly 1,900 lines of generated Rust.

### 2. Authoring and maintenance scalability

| Author burden | AGREE | GUMBO system property |
|---|---|---|
| Identify components | Derived from the AADL hierarchy and contract placement. | Declare proof aliases for every component appearing in the schema. |
| Identify connections/values | Refer to architectural ports directly. | Add selected port aliases to flattened `SystemState`. |
| Expose history/state | Native temporal operators and equations. | Alias component GUMBO state variables; often add explicit recurrence state. |
| Define execution order | Not part of synchronous AGREE reasoning. | Manually write a schema, including repeated occurrence labels. |
| Supply intermediate facts | Mostly handled by synchronous composition and induction. | Often restate carry assertions at relevant schedule places. |
| Diagnose failure | Model-level result and counterexample trace. | Generated Rust VC at a transition; manually map it back to the model assertion. |
| Keep deployment synchronized | No claim about physical schedule. | Manually keep schema and runtime schedule aligned; no automatic check here. |

This is where GUMBO currently scales worse than AGREE. The proof obligations scale
predictably, but the human must construct and maintain a second description of execution
and a Hoare-style proof outline. The local HAMR documentation itself describes system
specifications as a “usable prototype” with manual supporting assertions.

### 3. Assurance scalability

| Assurance link | Status |
|---|---|
| SysML theorem -> generated VCs | Generated automatically by HAMR. |
| VCs -> theorem over component contracts and schema | Verified by Verus. |
| Rust components -> their GUMBO contracts | Can be discharged separately with Verus when implementations are supported and verified. |
| C/VM `dataStorage` -> its GUMBO contract | **Trusted in this model**, not proved by Verus. |
| Declared schema -> generated MCS schedule | **Not established automatically.** |
| Abstract dispatch/channel semantics -> deployed runtime | Part of the trusted HAMR execution-model correspondence. |

The most serious scalability issue is not solver time. It is assurance maintenance:
each schedule change requires manually updating the proof schema and independently
checking the runtime schedule, while the tool can still report a successful proof if
the two have drifted apart.

## Composition vocabulary after simplification

| Section | Retained content | Why it remains |
|---|---|---|
| `components` | Ten leaf-instance aliases | All appear in the requested 15-occurrence proof schema. |
| `ports` | `log_response_in`, `storage_alert` | They state the trigger and logMonitor's emitted event. |
| `state` | `log_is_valid`, `data_storage_zeroize_cmd`, `data_storage_cache` | They state invalidity and what “processed/zeroized” means. |
| `schema` | Requested 15 occurrences | It defines the abstract trace to which the theorem applies. |
| `property` | One property with two place assertions | It is the only retained system theorem. |
| Composition helper functions | None | The removed properties were their only users. |

These declarations are not new architectural components, ports, or executable state.
They are aliases and control points for a generated proof harness. That distinction
explains why they look duplicative: they repeat architecture and scheduling information
in a proof-specific vocabulary.

## Declared proof schema versus generated runtime schedule

The runtime evidence inspected is
[`hamr/microkit_mcs_sysml/meta.py`](hamr/microkit_mcs_sysml/meta.py).

| Declared SysML proof schema | Generated `meta.py` runtime schedule |
|---|---|
| 15 component occurrences | 12 component slots plus padding |
| Three data-manager occurrences | One data-manager occurrence |
| Three data-storage occurrences | One data-storage occurrence |
| Two data-analysis occurrences | One data-analysis occurrence |
| Omits Bluetooth and USB | Includes Bluetooth and USB |
| Critical local sequence: `log_monitor -> data_storage_3 -> data_manager_3` | Cyclic precedence: `logMonitor -> encryptor -> reportMonitor -> bt -> usb -> dataStorage -> pad -> wifiVM -> wifi -> decryptor -> firewall -> dataAnalysis -> dataManager` |

| Observation | Consequence |
|---|---|
| Runtime inspection does place dataStorage after logMonitor and before the next cyclic dataManager occurrence. | The broad intended precedence appears present by manual inspection. |
| The runtime crosses the major-frame boundary and contains intervening dispatches absent from the proof's local sequence. | The verified 15-occurrence trace is not the generated executable trace. |
| HAMR generated the proof crate and runtime schedule independently. | A successful Verus run does not certify schedule conformance. |

Until conformance is generated or checked, the result must be stated as:

> If execution conforms to the declared composition schema, and every referenced
> component satisfies its GUMBO contract, then storage is zeroized at the boundary
> immediately before `data_manager_3`.

It must not be stated as an unconditional theorem of the deployed MCS system.

## AGREE and GUMBO side by side

| Dimension | AGREE | GUMBO system specifications |
|---|---|---|
| Primary abstraction | Synchronous dataflow over logical ticks. | Contract transitions over explicitly named schedule places. |
| Composition | Hierarchical assume-guarantee reasoning. | Generated Hoare-style VCs over flattened proof state. |
| Order sensitivity | Does not model physical dispatch order. | Can distinguish before/after dispatches in the declared schema. |
| Property declaration | Parent guarantee or assumption discharge. | Concrete property plus supporting place assertions. |
| Contract reuse | Child contracts consumed through hierarchy; `lift contract` supports wrappers. | Leaf contracts copied into the proof crate and projected per property. |
| Temporal reasoning | Native temporal operators and k-induction. | Explicit state, `In`, PLTL helpers, and `START`/`END` invariants. |
| Proof engine | Lustre/JKind model checking and induction. | HAMR-generated Verus/SMT VCs. |
| Failure feedback | Model-level counterexample traces. | Failed generated VC; current mapping is more manual. |
| Implementation path | Lowest-level implementation conformance is external. | Rust code can be verified against generated contracts; unsupported/non-Rust code remains trusted. |
| Best fit here | Compact proof of synchronous safety relationships. | A focused claim whose requirement explicitly depends on dispatch order. |

## Practical recommendation

| Use | Recommendation |
|---|---|
| Existing synchronous safety and functional requirements | Keep AGREE as the primary compositional analysis. |
| Dispatch-order-sensitive confidentiality requirement | Retain the one focused GUMBO system property. |
| Local component guarantees | Keep them only in component contracts; do not restate them as system properties merely for traceability. |
| Runtime schedule assurance | Add a generated schema-to-`meta.py` conformance check before treating the GUMBO theorem as deployment evidence. |
| Storage implementation assurance | Verify or test the C/VM storage implementation against the zeroize contract; the current system proof trusts it. |
| Future GUMBO properties | Add only when they prove a genuinely cross-component or schedule-specific requirement unavailable in AGREE. |

## Verification evidence

| Check | Result | Notes |
|---|---|---|
| SysML type check | **Well-formed** | Four pre-existing virtual-processor OS warnings; Linux assumed. |
| Temporary HAMR generation | **33 system VCs generated for one property** | Generated outside the checked-in HAMR tree. |
| Temporary Verus proof | **34 verified, 0 errors** | Includes one shared obligation; generated `metadata`/trigger syntax defects were corrected only in temporary output. |
| Component contracts | **Unchanged** | The system-property simplification did not alter leaf/thread contracts. |
| AADL/OSATE | **Untouched** | Neither was modified or executed. |
| Runtime comparison | **Schema mismatch remains** | Based on the supplied `hamr/microkit_mcs_sysml/meta.py`. |

## Files changed

| File | Change |
|---|---|
| [`sysml/GroundStation.sysml`](sysml/GroundStation.sysml) | Removed seven system properties, unused proof aliases, and the unused composition helper; strengthened the one retained property to include zeroized cache state. |
| `AGREE_VS_GUMBO_COMPOSITIONAL_REASONING.md` | Reframed the comparison around scalability and the single zeroize-ordering theorem. |
| `reports/workflow-status.md` | Recorded the simplified SysGUMBOSysSpecCheck run and audit status. |

## Property review

| Review question | Current answer |
|---|---|
| Is there exactly one concrete GUMBO system property? | Yes. |
| Does it combine alert emission, storage processing, and the before-data-manager boundary? | Yes, relative to the declared schema. |
| Does it change any component contract? | No. |
| Does it prove the outgoing storage response is zeroized? | No; that is absent from the storage component contract. |
| Does it prove the C/VM implementation zeroizes memory? | No; the storage contract is explicitly trusted. |
| Does it prove the generated MCS schedule conforms? | No; that remains the largest gap. |
