# AGREE vs. GUMBO Compositional Reasoning

**Model:** `withAGREEAndGumbo`  
**System under analysis:** `GroundStation.Impl` / `GroundStation_Impl` with MCS scheduling  
**Date:** 2026-09-10  
**Scope rule:** Existing leaf/thread component contracts were not changed.

## Executive verdict

| Question | AGREE | GUMBO system specifications | Finding for this model |
|---|---|---|---|
| Can component guarantees justify downstream assumptions? | Yes, automatically within AGREE's synchronous hierarchy. | Yes, through explicit schedule-place assertions and generated VCs. | **Matched** for `firewall -> dataAnalysis`. |
| Can the proof account for the actual MCS order? | No; AGREE intentionally abstracts deployment timing and scheduling. | It reasons about the order declared in `schema`, but HAMR does not establish that this is the deployed MCS order. | **Only conditionally.** The proof is schedule-aware, but schedule conformance is currently an unproved assumption. |
| Can `reportMonitor` justify the WiFi assumptions in the current order? | AGREE can relate them in one synchronous logical step. | It proves the conditions after `reportMonitor` through `END`, but cannot establish them before the first WiFi dispatch. | **Not fully equivalent without an initialization contract or schedule change.** |
| Can local safety claims be exposed and combined at system level? | Yes, through hierarchy and `lift contract`. | Yes, through explicit properties over component aliases, ports, state, and carry chains. | **Matched** for log-monitor forwarding/alerting and zeroization; GUMBO also proves the schema-specific storage-alert route. |
| Does the proof schema generate or constrain the runtime schedule? | Not applicable. | No. The schema drives proof-transition generation only. | **Significant gap:** the proof can use a different order from the deployed system without HAMR reporting it. |
| Does GUMBO currently do everything AGREE does and more? | Mature synchronous assume-guarantee model checking. | Broader schedule/code-oriented proof pipeline, but a more explicit and currently prototype-level system-proof workflow. | **The blanket claim is not yet supported.** The tools overlap, and each currently has an advantage. |

## What the GUMBO composition block actually defines

The composition block is a manually constructed **proof harness** around an already
defined SysML architecture. It does not add components or connections to the system.

| Block | What it means to the verifier | What it does **not** do | Why it is required today |
|---|---|---|---|
| `components` | Assigns short proof aliases to deployed leaf component instances whose GUMBO transitions may be used. | It does not instantiate, bind, or schedule a component. | The proof generator does not derive a convenient proof scope directly from the SysML hierarchy. |
| `ports` | Assigns names to selected connected-port values in the flattened proof state. | It does not declare or connect ports. | System assertions need explicit handles for the values they mention. |
| `state` | Exposes selected component GUMBO state variables in the flattened proof state. | It does not create or implement state. | Assertions cannot otherwise refer conveniently to contract-history variables such as zeroize latches. |
| `schema` | Defines an abstract sequence or partial order of component-contract transitions within one proof frame. Repeated firings use occurrence labels such as `data_manager @ data_manager_2`. | It is not an MCS schedule, does not assign time slices, and does not configure the Microkit scheduler. | The VC generator uses it to decide which component transition occurs between each pair of proof assertions. |
| `property` | Supplies assertions at selected points in that abstract trace, forming a Hoare-style proof outline. | It is not automatically derived from component guarantees. | The verifier needs the particular system theorem and usually its intermediate carry facts stated explicitly. |

This explains why these declarations feel disconnected: most of their information
already exists elsewhere in the architecture or deployment artifacts, but the current
system-proof pipeline requires it to be reintroduced in proof-specific form.

## Significant gap: schema/runtime schedule conformance

| Question | Current behavior |
|---|---|
| Does HAMR generate the Microkit MCS schedule from `composition.schema`? | **No.** |
| Does HAMR check that an existing/generated MCS schedule conforms to the schema? | **No conformance check is currently performed.** |
| What does HAMR generate from the schema? | The abstract transition system and Verus VCs for the GUMBO system properties. |
| What configures runtime dispatch? | A separate generated-then-user-maintained scheduler artifact (`meta.py` in this HAMR output format; older workflows use `microkit.schedule.xml`). |
| What does a successful proof therefore establish? | The property holds for executions conforming to the declared proof schema, assuming the component contracts. It does **not** establish that the deployed MCS execution conforms to that schema. |
| Assurance impact | A stale or incorrect schema can yield a successful proof about an order the deployed system never runs. This is a significant assurance gap whenever schedule order is part of the claim. |

The gap was reproduced directly in this model. Temporary HAMR generation was run from
the revised 15-occurrence SysML schema. The generated proof used all 15 occurrences,
but the generated runtime schedule remained the default 12-slot schedule:

| Revised SysML proof schema | Generated runtime schedule |
|---|---|
| 15 component occurrences | 12 component slots plus padding |
| Three `data_manager` and three `data_storage` firings | One `data_manager` and one `data_storage` firing |
| Two `data_analysis` firings | One `data_analysis` firing |
| Omits `bt_driver` and `usb_driver` | Includes both `bt_driver` and `usb_driver` |

Accordingly, schedule-specific results below must be read as **schema-relative proof
results**, not evidence that the current deployed MCS schedule has been verified.

## What a verification condition is

**VC** stands for **verification condition**: a logical proposition that a verifier
must prove. A VC is a proof-engine obligation, not an additional system requirement.

| VC category | Question represented by the VC | Example in this model |
|---|---|---|
| Initialization | Does the required invariant hold in every permitted initial state? | Are the WiFi input conditions true at `START` before any component has executed? |
| Component precondition | Does the state immediately before a dispatch satisfy the component's assumptions? | Does the firewall output satisfy `DataAnalysis.Trusted_Request` before `dataAnalysis` runs? |
| Component transition | Do the incoming facts and component contract imply the asserted outgoing facts? | Does the log-monitor contract imply both alert events after an invalid response? |
| Carry/preservation | Does an established fact remain true across an intervening schema transition? | Does the firewall's allow-list fact survive the transitions before the second `data_analysis` occurrence? |
| Frame induction | Does the end-of-frame state re-establish what the next frame requires? | Do predicates asserted at `END` imply the corresponding predicates at the next `START`? |

| Reported count | Correct interpretation |
|---|---|
| 264 generated system VCs | 264 small obligations produced by expanding eight SysML properties across initialization and the 15 schema occurrences. |
| 265 verified | The 264 generated system VCs plus one shared proof obligation. |
| What the count does **not** mean | It does not mean that the model contains 264 requirements, nor that more VCs necessarily provide stronger assurance. |

## Why GUMBO composition feels like contract duplication

Component contracts are already consumed by the system proof as premises; they are
not supposed to be redeclared semantically. The additional text is mostly explicit
proof structure that AGREE's synchronous composition handles automatically.

| GUMBO composition element | Purpose | Is it a new component contract? | Practical burden |
|---|---|---:|---|
| Component aliases | Identify the deployed component instance used at a schedule place. | No | Every relevant instance must be named. |
| Port aliases | Identify the concrete state representing a connected input or output. | No | Connection facts must be exposed explicitly. |
| State aliases | Make contract state variables available to the system theorem. | No | Internal proof state must be named and tracked. |
| System property | State the cross-component theorem to prove. | No | The desired consequence cannot be inferred automatically because many different theorems are possible. |
| Carry assertion | Record an intermediate fact at a schedule boundary. | No | Facts often must be threaded manually through unrelated dispatches. |
| `START`/`END` assertion | State a cross-frame invariant. | No | Initialization and inductive preservation become explicit obligations. |

The carry assertions are analogous to manually supplied proof cut-points. Although
they are not copies of component contracts in the formal sense, they often repeat or
repackage contract consequences. This is the main source of the additional complexity
seen in this model.

| Current system property | Compositional value |
|---|---|
| `Firewall_Discharges_Trusted_Request` | Genuine cross-component assumption discharge. |
| `ReportMonitor_Establishes_Wifi_Input_Conditions_At_End_Of_Frame` | Genuine producer/consumer reasoning, while also exposing a schema initialization/order boundary. |
| `LogMonitor_Alert_Activates_Storage_Zeroize` | Genuine schema-specific, cross-component route proof. |
| `Storage_Zeroize_Activated_Before_Next_DataManager` | Genuine schema-specific ordering claim: the storage alert activates zeroization before the immediately following data-manager occurrence. Together with `DataStorage_Zeroize_Cache`, this establishes a zeroized cache at that boundary. |
| `DataManager_Zeroize_Payload` | Primarily re-exposes a local component guarantee at system level. |
| `DataStorage_Zeroize_Cache` | Primarily re-exposes a local component guarantee; it is useful as the second link in the storage-zeroization argument. |
| `LogMonitor_Send_Alert` | Primarily re-exposes a local component guarantee at system level. |
| `LogMonitor_Forward_Response` | Primarily re-exposes a local component guarantee at system level. |

The last four properties are not logical tautologies, but they add little evidence of
composition by themselves. They were retained for traceability and to demonstrate
the current workflow, not because GUMBO requires every local guarantee to be restated
at system level.

## Where Verus fits

| Stage | AGREE analysis | GUMBO system-specification analysis |
|---:|---|---|
| 1 | AADL component and system AGREE contracts | AADL/SysML GUMBO component contracts and system `composition` |
| 2 | Translation to a synchronous Lustre model | HAMR generation of a Rust system-proof model and VCs |
| 3 | JKind model checking/k-induction | Verus verification, using its SMT backend |
| 4 | Model-level results and counterexample traces | Verified or failed obligations at generated schedule transitions |

GUMBO is the specification language, but the system proof exercised here does rely on
Verus. Verus proves the generated schema/state proof model under the component
contracts. A successful system proof therefore does **not** by itself show that every
handwritten component implementation satisfies its contract. Rust implementations
can be verified separately against generated GUMBO contracts; the C `dataStorage`
implementation remains trusted unless supported by separate implementation evidence.
It also does not show that the executable MCS schedule conforms to the proof schema.

AGREE remains a model-level analysis: it reasons over the synchronous architectural
abstraction and does not claim that the MCS schedule or generated implementation is a
refinement of that abstraction.

## Is AGREE's synchronous model sufficient here, even with MCS?

For the current requirements, the answer is **probably yes**. The relevant distinction
is whether MCS ordering is part of the property—not merely whether MCS is the selected
deployment platform.

| Property or evidence goal | Synchronous AGREE sufficient? | Additional value from the current GUMBO system proof |
|---|---:|---|
| Invalid data never propagates | Yes, at the architectural stream level. | Can locate the fact at particular dispatch boundaries. |
| Valid data is transformed/forwarded correctly | Yes, at the architectural stream level. | Can show the scheduled producer-to-consumer carry. |
| Alert implies zeroization | Yes, as an assume-guarantee safety relation. | Can prove that the alert reaches storage before the next data-manager occurrence in the declared schema. |
| One-frame versus next-frame delivery | Only if the distinction is abstracted away. | Explicitly distinguishes the two. |
| Maximum response time or freshness | No schedule/timing proof. | Potentially useful, although those properties are not required here. |
| Safe initialization before the first dispatch | Only to the extent represented by AGREE initialization semantics. | Exposes unconstrained first-frame state, as the WiFi probe demonstrated. |
| Generated code satisfies component contracts | No direct implementation proof. | Possible for supported verified implementations, but not established for every component here. |
| MCS implementation refines the synchronous model | No. | Not established: the properties are schema-relative, and schema/runtime conformance is not generated or checked. |

The current proof schema places WiFi before `reportMonitor`. AGREE can relate their ports
within one logical synchronous step, whereas that declared order means a newly produced
report is consumed in a later frame. Because the stated requirements are
safety properties and explicitly do not require promptness, that latency distinction
does not presently invalidate the intended behavior. It matters only if freshness,
first-frame behavior, or exact within-frame causality becomes a requirement.

Therefore, MCS does not by itself create a need for GUMBO system specifications. AGREE
is the clearer primary compositional tool for this model's current safety goals. GUMBO
adds distinct value only where schedule-state behavior or implementation conformance
must be part of the assurance case.

### Example: zeroize before the next storage read

One security requirement for which dispatch order would be essential is:

> If `logMonitor` raises a storage-zeroize alert, `dataStorage` shall zeroize its
> cache before the next dispatch of `dataManager` that could retrieve stored data.

This would be a confidentiality requirement, not merely a promptness requirement.

| Dispatch order after the alert | Consequence | Assessment |
|---|---|---|
| `logMonitor(alert) -> dataStorage(zeroize) -> dataManager(read)` | The read can observe only zeroized storage. | Safe |
| `logMonitor(alert) -> dataManager(read) -> dataStorage(zeroize)` | The read can retrieve the old record after zeroization was requested but before it occurred. | Unsafe |

The revised SysML proof schema contains the critical subsequence:

```text
logMonitor -> dataStorage_3 -> dataManager_3
```

| Step in the current order | Relevant fact |
|---|---|
| `logMonitor` raises the storage alert | The next two schema occurrences are `dataStorage_3` and then `dataManager_3`. |
| `dataStorage_3` dispatches | It latches the alert as an active zeroize command; its separate cache guarantee establishes a zeroized cache. |
| `dataManager_3` dispatches | Its next schema occurrence is after storage zeroization. |

AGREE can prove a synchronous relationship such as `storage_alert =>
cache_is_zeroized`, but it does not prove that the deployed schedule prevents a
`dataManager` dispatch from occurring physically between detection and zeroization.
A schedule-aware GUMBO property could provide that additional evidence.

This ordering requirement is represented in the SysML composition by the combination
of `Storage_Zeroize_Activated_Before_Next_DataManager` and
`DataStorage_Zeroize_Cache`. The first proves alert-to-latch ordering at the shared
`after data_storage_3` / `before data_manager_3` boundary; the second proves that an
active storage-zeroize latch implies a zeroized cache at every storage occurrence.
This is a theorem of the proof schema, not yet a theorem about the runtime schedule.

## Refined interpretation of “AGREE++”

| Possible meaning of “AGREE++” | Supported by this comparison? | Finding |
|---|---:|---|
| Strict superset of AGREE's compositional automation | No | GUMBO currently requires more explicit aliases, state, assertions, and carry chains. |
| Broader specification vocabulary and lifecycle | Partly | GUMBO spans model contracts, schedule-aware system proof, testing, and a path to implementation verification. |
| Better model-level counterexample analysis | No | AGREE/JKind currently provides the more mature model-level experience. |
| More deployment-aware reasoning | Partly | GUMBO can name and prove facts at declared schedule boundaries, but current tooling does not tie those boundaries to the deployed MCS schedule. |
| Automatically stronger assurance | No | Strength depends on the properties stated, component contracts proved, and trusted implementations. |

For this model, GUMBO is better described as a **broader but more manual assurance
path**, not as a strict successor to AGREE's compositional reasoning.

## Evidence basis

| Evidence | AGREE side | GUMBO side |
|---|---|---|
| Language/semantics reference | [AGREE Users Guide](../withAGREEOnly/AGREE_Users_Guide.pdf), especially pp. 6-7, 65-68, and 77-79. | Local HAMR system-property guide: `HAMR-agent-context/doc/gumbo-system-properties.md`. |
| Component contracts inspected | [`aadl/GroundStation.aadl`](aadl/GroundStation.aadl) and [`aadl/Hardened_SW.aadl`](aadl/Hardened_SW.aadl). | The matching GUMBO annexes in AADL and SysML; they were not edited for this comparison. |
| System specification | Existing AGREE hierarchy, including process-level `lift contract`. | `ground_station_contracts` in [`sysml/GroundStation.sysml`](sysml/GroundStation.sysml#L723). The revised multi-firing schema and ordering requirement are SysML-only. |
| Executed checker | Not rerun; this work did not invoke or modify OSATE. | SysML type check, temporary HAMR code generation, and temporary Verus proof. |
| Generated-output policy | N/A | All generated proof artifacts were placed under `/private/tmp`; checked-in `hamr` directories were not changed. |

## Reasoning model: side-by-side

| Dimension | AGREE | GUMBO system specifications | Practical consequence |
|---|---|---|---|
| Primary abstraction | Synchronous dataflow node for each component contract. | A sequence/partial order of component-contract transitions over explicit proof state. | AGREE is compact; GUMBO exposes order dependencies in the proof schema. |
| Composition unit | AADL hierarchy: parent assumptions/guarantees plus direct child contracts. | A top-level `composition` with component, port, and state aliases. | GUMBO requires the proof boundary to be written explicitly. |
| Assumption discharge | A child's assumption is proved from parent assumptions and sibling guarantees. | A component's compute assumptions become pre-assertion VCs at its schedule place. | Missing carry facts appear at a specific dispatch boundary. |
| Parent/system guarantee | Proved from parent assumptions and child guarantees. | Written as assertions at `before`, `after`, labels, `START`, or `END`. | GUMBO can state exactly when a fact becomes true. |
| Contract lifting | `lift contract` exposes a one-thread process contract at its parent boundary. | No direct `lift contract` counterpart was used; leaf threads are aliased directly and their contracts are folded into VCs. | The GUMBO proof is flatter and more explicit in this model. |
| Time model | Logical ticks; AGREE abstracts timing and treats most port communication synchronously. | Declared schema steps and cross-frame `START`/`END` obligations. | GUMBO detects schema-level first-frame and producer-before-consumer issues that AGREE may abstract; runtime correspondence is separate. |
| Initialization | Initial values and guarded `pre`/`->` expressions within the synchronous model. | Component `initialize` guarantees must establish any assertion required at `START`. | Uninitialized output-event conditions cannot simply be assumed. |
| History | Native temporal operators and k-induction. | Explicit state plus PLTL helper functions; cross-frame invariants use `START`/`END`. | Translation is possible, but is not purely syntactic. |
| Scheduling | Not an AGREE proof input. | Linear, split/join, repeated-occurrence, and labeled proof schemas. | GUMBO can prove properties for the modeled schema family, but conformance to runtime scheduling is currently assumed. |
| Parallel/independent steps | Abstracted by synchronous composition. | Expressible through schema `split` branches and commutativity VCs. | GUMBO can reason about declared independence; deployment correspondence remains external. |
| Proof engine | AGREE translation to Lustre and JKind model checking/k-induction. | HAMR-generated Verus VCs discharged by Verus/Z3. | Failure reports and debugging workflows differ. |
| Failure evidence | Model-checker counterexample traces and hierarchical result views. | Failed Verus VC at a named schedule transition; current tooling does not provide an equivalent model-level trace. | AGREE is currently friendlier for behavioral counterexample exploration. |
| Implementation link | Lowest-level contracts are trusted until verified by some external method. | Rust component code can be verified against generated GUMBO contracts; non-Rust contracts remain trusted. | GUMBO can extend the assurance chain into code, but only for supported implementations. |
| Tool maturity | Established OSATE analysis workflow. | System specifications are documented as a usable prototype. | GUMBO currently needs more manual carry assertions and generated-code diagnosis. |

## Contract and proof syntax mapping

| Intent | AGREE form | GUMBO component/system form |
|---|---|---|
| Environment obligation | `assume A: P;` | Component `assume A: P;`; system proof must establish `P` at the component's pre-place. |
| Component behavior | `guarantee G: Q;` | Component `guarantee G: Q;`; the generated postcondition becomes a premise after that component runs. |
| Parent behavior | Parent `guarantee G: Q;` | `property G { after component: Q; }` plus every required carry assertion. |
| Previous value | `pre(x)` / `Yesterday(P)` with initialization | `In(x)` and an explicit `initialize` guarantee. |
| Persistent past fact | `Historically(P)` / `Once(P)` | State recurrence or a GUMBO PLTL helper, then alias that state in the composition. |
| Hierarchical pass-through | `lift contract;` | Direct leaf aliasing plus explicit system properties; no implicit lift was relied upon. |
| Cross-frame invariant | Inductive synchronous property. | `at START: I; ... at END: I;`, producing initialization and post-to-pre VCs. |

## SysML order used by the GUMBO proof

This is the proof schema, not the generated runtime MCS schedule.

| Order | Alias | Ground-station thread | Relevant proof role |
|---:|---|---|---|
| 1 | `wifi_vm` | WiFi VM bridge | Preserves carried facts; VM/C boundary. |
| 2 | `wifi` | WiFi driver | Consumes `IncomingAlert` and `Trusted_Report` assumptions. |
| 3 | `decryptor` | Decryptor | Pipeline step. |
| 4 | `data_manager_1` | Data manager, occurrence 1 | First data-manager transition. |
| 5 | `data_storage_1` | Storage, occurrence 1 | First storage transition. |
| 6 | `firewall` | Firewall | Establishes trusted-request condition. |
| 7 | `data_analysis_1` | Data analysis, occurrence 1 | Consumes `Trusted_Request`. |
| 8 | `data_manager_2` | Data manager, occurrence 2 | Second data-manager transition. |
| 9 | `data_storage_2` | Storage, occurrence 2 | Second storage transition. |
| 10 | `log_monitor` | Log monitor | Validates responses and emits data-manager/storage alerts. |
| 11 | `data_storage_3` | Storage, occurrence 3 | Latches the storage alert and establishes its cache guarantee. |
| 12 | `data_manager_3` | Data manager, occurrence 3 | First data-manager transition after the storage alert/zeroize step. |
| 13 | `data_analysis_2` | Data analysis, occurrence 2 | Consumes the carried trusted-request condition again. |
| 14 | `encryptor` | Encryptor | Pipeline step. |
| 15 | `report_monitor` | Report monitor | Establishes trusted/no-report-on-alert conditions at `END`. |

`bt_driver` and `usb_driver` are intentionally absent from the proof schema. They remain
architectural components and therefore still appeared in HAMR's independently generated
default runtime schedule.

## AGREE claim to GUMBO property traceability

| AGREE claim or composition obligation | AGREE source | GUMBO system property | Strength/status |
|---|---|---|---|
| Firewall output is allow-listed, discharging `DataAnalysis.Trusted_Request`. | `Forward_Request` in [`Hardened_SW.aadl`](aadl/Hardened_SW.aadl#L573); assumption in [`GroundStation.aadl`](aadl/GroundStation.aadl#L250). | `Firewall_Discharges_Trusted_Request` | **Exact and verified.** |
| Alert and report are mutually exclusive, and an outgoing report has an allow-listed client. | WiFi assumptions in [`GroundStation.aadl`](aadl/GroundStation.aadl#L68); report-monitor claims in [`Hardened_SW.aadl`](aadl/Hardened_SW.aadl#L368). | `ReportMonitor_Establishes_Wifi_Input_Conditions_At_End_Of_Frame` | **Exact at and after `reportMonitor`; partial as an assumption-discharge theorem because WiFi runs earlier.** |
| A latched data-manager zeroize command with a request produces a zeroized response payload. | `Zeroize_Payload` in [`GroundStation.aadl`](aadl/GroundStation.aadl#L132) and the parent system claim in [`Hardened_SW.aadl`](aadl/Hardened_SW.aadl#L663). | `DataManager_Zeroize_Payload` | **Exact and verified.** |
| A latched storage zeroize command leaves the encrypted-log cache zeroized. | `Zeroize_Cache` in [`GroundStation.aadl`](aadl/GroundStation.aadl#L197). | `DataStorage_Zeroize_Cache` | **Exact and verified, with a trusted non-Rust component contract.** |
| An invalid response sends both the data-manager and storage alerts; otherwise neither is sent. | `Alert` in [`Hardened_SW.aadl`](aadl/Hardened_SW.aadl#L256). | `LogMonitor_Send_Alert` | **Exact and verified.** |
| A response is forwarded exactly when a response event exists and no alert has historically been recorded. | `Forward_Response` in [`Hardened_SW.aadl`](aadl/Hardened_SW.aadl#L260). | `LogMonitor_Forward_Response` | **Exact and verified.** |
| The storage alert emitted by the log monitor reaches storage before storage runs. | Derived by composing log-monitor alerting, the SysML connection, the declared schema order, and storage's zeroize latch. | `LogMonitor_Alert_Activates_Storage_Zeroize` | **Verified GUMBO schema-specific theorem; this is more concrete than the individual AGREE claims, but does not establish runtime-schedule conformance.** |
| Storage zeroization is activated after an invalid-response alert and before the next `dataManager` occurrence. | New order-dependent assurance requirement; no direct AGREE counterpart was added. | `Storage_Zeroize_Activated_Before_Next_DataManager`, combined with `DataStorage_Zeroize_Cache`, in [`sysml/GroundStation.sysml`](sysml/GroundStation.sysml#L860) | **Verified relative to the SysML schema.** The shared `after data_storage_3` / `before data_manager_3` boundary has an active zeroize latch and a zeroized cache under the trusted storage contract. Runtime-schedule conformance is not established. |

## GUMBO proof chains

| Property | Producer assertion | Carries | Consumer/final assertion | Result |
|---|---|---|---|---|
| `Firewall_Discharges_Trusted_Request` | After `firewall`: request event implies allow-listed client. | Carried through the intervening occurrences. | Both `data_analysis_1` and `data_analysis_2` preconditions are discharged. | Proven |
| `ReportMonitor_Establishes_Wifi_Input_Conditions_At_End_Of_Frame` | After `report_monitor`: alert implies no report; report implies allow-listed client. | None; `report_monitor` is the final schema occurrence. | The facts hold at the shared `after report_monitor` / `END` boundary. | Proven within the frame |
| `DataManager_Zeroize_Payload` | Data-manager state and request event. | Re-established independently. | The local zeroized-response implication holds after all three data-manager occurrences. | Proven |
| `DataStorage_Zeroize_Cache` | Storage zeroize latch. | Re-established independently. | The zeroized-cache implication holds after all three storage occurrences. | Proven; storage contract trusted |
| `LogMonitor_Send_Alert` | Response-event and `is_valid` state. | None. | After `logMonitor`: both alert events iff the response is invalid. | Proven |
| `LogMonitor_Forward_Response` | Response-event and historical no-alert state. | None. | After `logMonitor`: exact event/value forwarding or no output event. | Proven |
| `LogMonitor_Alert_Activates_Storage_Zeroize` | After `log_monitor`: invalid response implies storage alert. | None; `data_storage_3` follows immediately. | After `data_storage_3`: storage's zeroize state is active. | Proven |
| `Storage_Zeroize_Activated_Before_Next_DataManager` | After `log_monitor`: invalid response implies storage alert. | None. | At `after data_storage_3` / `before data_manager_3`: storage's zeroize state is active. Combined with `DataStorage_Zeroize_Cache`, the cache is zeroized there. | Proven relative to schema; storage contract trusted |

## WiFi assumption boundary

| Point in reasoning | AGREE view | GUMBO/schema view |
|---|---|---|
| Producer | `reportMonitor` guarantees alert/report exclusion and trusted destination. | Same component guarantees establish both facts after schema step 15. |
| Consumer | WiFi assumptions can be considered in the same synchronous logical composition. | WiFi consumes the assumptions at schema step 2. |
| Frame boundary | Abstracted by the synchronous model. | The facts carry from `reportMonitor` through `END`, but an invariant also needs the same facts at `START`. |
| First dispatch | Governed by AGREE's initialized synchronous semantics. | No `reportMonitor.initialize` guarantee constrains `analysis_report_out` or `alert_out`, so `START` is unconstrained. |
| Sound result retained in the model | AGREE assumption-discharge obligation. | End-of-frame establishment only; the property name deliberately does not claim full WiFi discharge. |

### First-frame proof probe

| Probe | Expected obligation | Verus result | Interpretation |
|---|---|---|---|
| Add the two WiFi conditions at `START`, carry them after `wifi_vm`, and invoke WiFi. | Initialization guarantees must imply the `START` predicate. | `162 verified, 1 error`; failure in `vc_init_state` on the `START` postcondition. | The unchanged component contracts do not establish the first-frame invariant. |
| Counterexample state | `report_out = Some(report)` with a client not in the allow list, or both `report_alert` and `report_out` present initially. | Such a state is not excluded by any `reportMonitor.initialize` guarantee. | WiFi executes before `reportMonitor` can constrain those ports. |
| Ways to close the gap | Add report-monitor output initialization guarantees; place `reportMonitor` before WiFi; or add a justified initialization/environment constraint. | Not applied. | The first option changes a component contract; the second changes scheduling; both were outside this task. |

## “Everything AGREE can do and more” scorecard

| Capability | AGREE | GUMBO today | Relative result |
|---|---:|---:|---|
| Local assume/guarantee component contracts | Yes | Yes | Tie |
| Synchronous hierarchical assumption discharge | Strong, direct | Possible when expressed as schedule assertions; more manual | AGREE advantage |
| Automatic one-thread process lifting | Yes | Not used/available as an equivalent automatic mechanism here | AGREE advantage |
| Native temporal model-checking workflow | Yes | State/PLTL translation plus Verus invariants | AGREE advantage for directness |
| Counterexample trace at model level | Yes | Failed VC location; no equivalent trace exercised | AGREE advantage |
| Explicit schedule-schema reasoning | No | Yes | GUMBO advantage at the proof-model level |
| Automatic schema-to-runtime schedule generation | N/A | No | Significant GUMBO/HAMR gap |
| Automatic runtime-schedule conformance check | N/A | No | Significant GUMBO/HAMR gap |
| Assertions at intermediate dispatch boundaries | No schedule boundary to name | Yes | GUMBO advantage |
| Partial-order/split schedule families | No | Yes | GUMBO advantage |
| Order-specific end-to-end route proof | Abstract only | Yes for the declared schema; demonstrated for log-monitor alert to storage zeroization | Conditional GUMBO advantage |
| Generated Rust implementation conformance path | External to AGREE | Integrated with GUMBO/Verus for supported Rust components | GUMBO advantage |
| Non-Rust implementation conformance | External evidence required | External evidence still required | Tie |
| Current workflow maturity | Mature | Usable prototype with manual carries and generated-code issues | AGREE advantage |

**Bottom line:** GUMBO is not simply a strict superset of AGREE's compositional reasoning today. It adds schema-aware composition and a path toward code-level assurance, while AGREE remains more direct and mature for synchronous hierarchical assume-guarantee proof and counterexample analysis. Calling the current GUMBO proof "deployment-aware" without qualification would overstate the result: until schema/runtime conformance is generated or checked, the deployment link is an external assumption.

## Verification results

| Check | Artifact | Result | Notes |
|---|---|---|---|
| SysML type check | Final checked-in SysML model | **Well-formed** | Four existing warnings: OS not provided for the two virtual processors; Linux assumed. |
| Temporary HAMR generation | Eight-property, 15-occurrence SysML composition | **264 system VCs generated** | Eight concrete properties; no checked-in HAMR output changed. |
| Temporary Verus proof | `sys_ground_station_contracts_proof` | **265 verified, 0 errors** | 264 generated system VCs plus one shared proof obligation. |
| Schema/runtime comparison | Temporary generated `meta.py` | **Mismatch observed** | The proof uses 15 occurrences and omits Bluetooth/USB; runtime generation produced 12 component slots, single occurrences, and included Bluetooth/USB. |
| Earlier first-frame WiFi probe | Temporary stronger property on the prior schema | **162 verified, 1 error** | Expected initialization failure; the failing property was not committed, and this diagnostic was not rerun because the relevant `wifi_vm -> wifi` prefix is unchanged. |
| AADL composition | Outside this pass | **Not changed or run** | The revised repeated-occurrence composition is intentionally SysML-only; OSATE was neither invoked nor modified. |
| Leaf/thread component contract diff | Git diff review | **No changes** | Only the top-level SysML composition and this report were updated in this pass. |

## Trusted base and tool limitations observed

| Item | AGREE impact | GUMBO impact | Treatment in this report |
|---|---|---|---|
| `dataStorage` is C/non-Rust | Its lowest-level behavior still needs external implementation evidence. | HAMR explicitly marks its GUMBO contract as trusted; Verus does not discharge it against C code. | Storage-related system theorems are valid conditional on that contract. |
| Uninterpreted AES-GCM relations | Cryptographic behavior is axiomatized at model level. | The same relations are specification functions without an implementation proof here. | No cryptographic correctness claim is added by the system proof. |
| SysML field named `'metadata'` | N/A | Current generated Rust uses an invalid quoted field name. | Corrected only in temporary generated output before Verus. |
| Inferred quantifier trigger placement | N/A | Current code generation places some `#[trigger]` annotations before `forall`, which Verus rejects. | Corrected only in temporary generated output before Verus. |
| Model-level failure presentation | AGREE reports hierarchical results/counterexamples. | Prototype proof reports generated Rust VC locations. | The report maps each VC result back to a named system property. |
| Schema/runtime schedule disconnect | N/A | Proof schema neither generates nor is checked against the executable scheduler configuration. | All order-specific GUMBO findings are explicitly qualified as schema-relative. |

## Files changed

| File | Change | Component contracts changed? |
|---|---|---:|
| [`sysml/GroundStation.sysml`](sysml/GroundStation.sysml#L723) | Changed the proof schema to the requested 15 occurrences, omitted Bluetooth/USB from that schema, labeled repeated firings, and realigned the eight proof outlines. | No |
| `AGREE_VS_GUMBO_COMPOSITIONAL_REASONING.md` | Documented the composition vocabulary, revised schema, verification result, and significant schema/runtime conformance gap. | No |

## Property review checklist

| Review question | Current answer |
|---|---|
| Do the eight SysML properties state meaningful security/safety behavior rather than tautologies? | They are not tautologies, but four exercise genuine cross-component or schedule reasoning; four primarily re-expose local guarantees for traceability. |
| Are all eight properties necessary to demonstrate compositional parity with AGREE? | No. The four local restatements could be removed from the composition without removing their component contracts; the new ordering property is deliberately stronger than an AGREE claim in this model. |
| Do the firewall and data-analysis contracts compose? | Yes; verified. |
| Do the report-monitor and WiFi contracts fully compose under the first schema frame? | No; the initialization gap is explicit. |
| Is storage zeroization tied to the log-monitor alert path? | Yes within the declared schema; the alert-to-zeroize activation route and zeroize-to-zero-cache property are both verified. Runtime conformance remains unproved. |
| Are any leaf/thread contracts changed to make the proof pass? | No. |
| Does the verified SysML schema prove the deployed runtime uses the same order? | No. HAMR currently neither generates the runtime schedule from the schema nor checks conformance. |
| Was the AADL composition changed or executed? | No; this pass was explicitly limited to the SysML model, and OSATE remained untouched. |
