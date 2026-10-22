# `logMonitor`: AGREE, GUMBO, Implementation, and Verus Contracts

## Conclusion

AGREE is the ground truth for this analysis.

For executions that fit within `31536000` dispatches, the composed GUMBO
monitor, verdict handler, and generated alert routing implement both AGREE
guarantees:

- `Alert` emits `alert_out` and `storage_alert_out` exactly when a response has
  no unused request.
- `Forward_Response` copies `response_log_in` to `response_log_out` exactly when
  a response is present and no alert has occurred through the current dispatch.

This conclusion relies on the ground station's maintenance policy: it is
rebooted at least once every 365 days. Each reboot starts a new execution and a
fresh R2U2 history. Under the assumptions below, the numeric history bound
covers every execution between reboots.

## Operational assumption

The `31536000`-dispatch bound is justified by the following deployment
assumptions:

1. The ground station is taken through maintenance and rebooted no later than
   365 days after its preceding boot.
2. A reboot is an execution boundary for both the AGREE requirement and the
   runtime monitor.
3. A request from before a reboot cannot authorize a response after the reboot,
   and an alert from before a reboot does not suppress forwarding after it.

The third assumption is necessary because neither the AGREE temporal history
nor the R2U2 temporal history is persisted across a reboot. If a request or
alert obligation must survive maintenance, it must instead be represented by
persistent state and included in both specifications.

With these assumptions, the full system lifetime is a sequence of independent
boot-to-reboot executions, each no longer than the configured history window.

## Source-of-truth requirements

The AGREE requirements are in
[`Hardened_SW.aadl`](../../../../aadl/Hardened_SW.aadl):

```aadl
eq is_valid: bool =
    if event(request_log) and event(response_log_in)
    then true
    else event(response_log_in) => Yesterday(
        Since(
            not(event(response_log_in)),
            event(request_log)
        )
    );

guarantee Alert:
    if event(response_log_in) and not(is_valid)
    then event(alert_out) and event(storage_alert_out)
    else not(event(alert_out)) and not(event(storage_alert_out));

guarantee Forward_Response:
    if event(response_log_in) and Historically(not(event(alert_out)))
    then event(response_log_out) and (response_log_out = response_log_in)
    else not(event(response_log_out));
```

The corresponding GUMBO monitor is:

```aadl
monitor
    guarantee No_Response_Without_Request:
        HasEvent(response_log_in) ->:
            (HasEvent(request_log) or
             (!HasEvent(response_log_in)
                Since[1, 31536000] HasEvent(request_log)));

    guarantee Historically_No_Alert:
        Historically[0, 31536000] (
            HasEvent(response_log_in) ->:
                (HasEvent(request_log) or
                 (!HasEvent(response_log_in)
                    Since[1, 31536000] HasEvent(request_log))));

    alert No_Response_Without_Request on alert_out;
    alert No_Response_Without_Request on storage_alert_out;
```

HAMR lowers these formulas without changing their bounds in
[`spec.c2po`](src/component/spec.c2po).

## Initialization and dispatch order

At each boot, [`lib.rs`](src/lib.rs) initializes the application and then calls
`r2u2_monitor_initialize`. That function installs a new `R2U2Monitor`, so no
temporal verdict history carries over from the preceding boot.

The dispatch ordering is then:

1. `r2u2_monitor_pre_timeTriggered` peeks at `request_log` and
   `response_log_in` and loads both event-presence values into R2U2.
2. [`timeTriggered`](src/component/cpuSw_logMonitor_logMonitor_app.rs) dequeues
   `request_log` so the input is clear for the next frame. It does not dequeue
   `response_log_in` and does not write any output.
3. `r2u2_monitor_post_timeTriggered` steps R2U2 and obtains the current verdicts.
4. The generated code passes the `No_Response_Without_Request` verdict and then
   the `Historically_No_Alert` verdict to
   [`handle_r2u2_verdict`](src/component/r2u2_monitor.rs).
5. The handler dequeues `response_log_in`. It writes `response_log_out` only for
   a true `Historically_No_Alert` verdict.
6. After both handler calls, generated code emits both alert events when
   `No_Response_Without_Request` is false.

The monitor therefore observes both inputs before either input is consumed. The
request is consumed by `timeTriggered`; the response is consumed by the verdict
handler.

## Proof of the `Alert` requirement

### Step 1: Identify the AGREE validity condition

AGREE accepts a response in either of two ways:

- `request_log` and `response_log_in` occur together; or
- an earlier `request_log` has not already been followed by a
  `response_log_in`.

`Yesterday(Since(...))` makes the second check end at the preceding dispatch.
The current response therefore does not invalidate the request that authorizes
it.

The complete AGREE behavior is:

| Current observation and prior history | `is_valid` | Required alerts |
|---|---:|---|
| No `response_log_in` event | true | neither alert |
| Request and response together | true | neither alert |
| Response after an unused request | true | neither alert |
| Response without an unused request | false | both alerts |

### Step 2: Match the GUMBO validity condition

`No_Response_Without_Request` starts with an implication from
`HasEvent(response_log_in)`. With no response, it is true, matching AGREE.

For a current response, `HasEvent(request_log)` covers the same-dispatch request
case. The remaining expression searches offsets 1 through `31536000` for an
earlier request and requires no intervening response:

```text
!HasEvent(response_log_in)
    Since[1, 31536000] HasEvent(request_log)
```

The lower bound of `1` is the bounded-past counterpart of AGREE's `Yesterday`.
Offset 0 is the current dispatch, so it is excluded from the interval in which
`!HasEvent(response_log_in)` must hold. The current response can therefore use
an earlier, still-unused request.

Within the bound, `No_Response_Without_Request` is false exactly when all three
facts hold:

1. `response_log_in` occurs now;
2. `request_log` does not occur now; and
3. no unused request exists in the bounded prior history.

That is exactly the case in which AGREE makes `is_valid` false.

### Step 3: Match the alert outputs

The two GUMBO `alert` mappings cause generated code to call both
`put_alert_out()` and `put_storage_alert_out()` for a false
`No_Response_Without_Request` verdict. For a true verdict, neither port is
written.

Thus, while the authorizing request is within `31536000` dispatches, the GUMBO
verdict and generated routing satisfy both branches of AGREE `Alert`: both
alerts occur for an invalid response, and neither occurs otherwise.

## Proof of the `Forward_Response` requirement

### Step 1: Relate `Historically_No_Alert` to AGREE

AGREE permits forwarding only when `response_log_in` occurs and
`Historically(not(event(alert_out)))` is true. `Historically` includes the
current dispatch, so a response that causes an alert must not be forwarded.

`Historically_No_Alert` applies bounded `Historically` to the same
response-validity condition used by `No_Response_Without_Request`. It is
therefore true exactly when no alert-causing violation has occurred in the
retained history, including the current dispatch. This is the bounded form of
AGREE's historical condition.

### Step 2: Match the handler behavior

The handler's Verus postcondition states that `response_log_out` contains the
same value as `response_log_in` exactly when all of the following hold:

- `response_log_in` is present;
- the handler is processing `Historically_No_Alert`; and
- the verdict is `Some(true)`.

In every other case, the postcondition requires `response_log_out` to be empty.
The implementation follows that contract: it obtains the response with
`get_response_log_in()` and passes that exact value to
`put_response_log_out(response)` only for `Some(true)`. `Some(false)` and
`None` do not forward. Treating `None` this way is conservative.

### Step 3: Account for the generated call order

The handler first receives the `No_Response_Without_Request` verdict. That enum
case performs no action, so `response_log_out` remains empty. The second call
receives `Historically_No_Alert` and makes the forwarding decision. Generated
alert routing runs afterward.

This ordering still represents AGREE's same-dispatch semantics because
`Historically_No_Alert` includes the current response-validity result. When the
current response makes that result false, the handler receives a false
historical verdict and does not forward before the generated code emits the
alerts.

Therefore, while the retained history covers the execution, the handler
implements both the event condition and the payload-equality condition in
AGREE `Forward_Response`.

## What the Verus contracts establish

The contracts divide responsibility so that the application, handler, and
generated monitor cannot satisfy the requirements by competing writes.

| Code | Contract responsibility |
|---|---|
| `timeTriggered` | Requires all outgoing event ports to be empty and leaves `response_log_out`, `alert_out`, and `storage_alert_out` unchanged. |
| `handle_r2u2_verdict` | Requires `response_log_out` to be empty, leaves both alert ports unchanged, forwards the exact response only for a true `Historically_No_Alert` verdict, and otherwise leaves `response_log_out` empty. |
| Generated monitor post-hook | Is the sole writer of the two alert ports and writes both for a false `No_Response_Without_Request` verdict. |

The API contracts in
[`cpuSw_logMonitor_logMonitor_api.rs`](src/bridge/cpuSw_logMonitor_logMonitor_api.rs)
support the payload argument: `get_response_log_in()` returns the ghost value of
`response_log_in`, and `put_response_log_out(value)` establishes that
`response_log_out == Some(value)` while preserving the other ports.

These contracts establish the application-level output policy assuming the
R2U2 verdicts have the meanings specified by the GUMBO formulas. They do not
turn the bounded GUMBO history into AGREE's unbounded history.

## Maintenance horizon and residual limitation

The component period is 1000 ms, so the bounds count seconds:

- `31536000` dispatches are exactly 365 days.

All three GUMBO interval positions use `31536000`. The maintenance assumption
makes this the maximum length of one boot-to-reboot execution. Consequently,
the bounded monitor does not forget any history that AGREE can observe within
the same execution.

The finite bound would become observable if maintenance were delayed beyond
365 days or if temporal obligations were expected to cross a reboot. In that
case, two differences would arise.

First, AGREE remembers an unused request indefinitely. After `31536000`
dispatches, `No_Response_Without_Request` can forget that request and emit both
alerts for a response that AGREE still considers valid. Because the same
validity condition is inside `Historically_No_Alert`, GUMBO also withholds that
response, whereas AGREE emits no alert and forwards it.

Second, the outer `Historically[0, 31536000]` creates another difference after
a long execution: an alert older than the retained window is forgotten. GUMBO
can then allow a later response to be forwarded, while AGREE's unbounded
`Historically(not(event(alert_out)))` remains false for the rest of the
execution.

Under the stated maintenance and reset assumptions, these cases are
unreachable and the formulas are equivalent for every boot-to-reboot
execution. If equivalence must hold without relying on annual reboots, MLTL
mission time `M` would express the full-mission horizon directly:

```text
Since[1, M]
Historically[0, M]
Since[1, M]
```

If the numeric bounds are retained, the annual reboot policy and the absence of
cross-reboot temporal obligations remain part of the assurance argument.
