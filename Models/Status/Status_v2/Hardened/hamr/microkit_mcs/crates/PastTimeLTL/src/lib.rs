#![cfg_attr(not(test), no_std)]

#![allow(non_camel_case_types)]
#![allow(non_snake_case)]
#![allow(non_upper_case_globals)]

#![allow(dead_code)]
#![allow(static_mut_refs)]
#![allow(unused_imports)]
#![allow(unused_macros)]
#![allow(unused_parens)]
#![allow(unused_unsafe)]
#![allow(unused_variables)]

#![feature(proc_macro_hygiene)]
#![cfg_attr(not(verus_keep_ghost), feature(stmt_expr_attributes))]

// This file will not be overwritten if HAMR codegen is rerun

use data::*;
use vstd::prelude::*;

macro_rules! implies {
  ($lhs: expr, $rhs: expr) => {
    !$lhs || $rhs
  };
}

macro_rules! impliesL {
  ($lhs: expr, $rhs: expr) => {
    !$lhs | $rhs
  };
}

// BEGIN MARKER GUMBO RUST MARKER
pub fn Since(
  a: bool,
  b: bool,
  prev_result: bool) -> bool
{
  b |
    a & prev_result
}
// END MARKER GUMBO RUST MARKER

verus! {


  pub open spec fn Once(a: Seq<bool>, time_step: nat) -> bool 
     decreases time_step
  {
     if time_step == 0 {
          a[0 as int]
     } else {
          Once(a, (time_step - 1) as nat) || (time_step < a.len() && a[time_step as int])
     }
  }

  pub open spec fn Since_spec(
    a: bool,
    b: bool,
    prev_result: bool) -> bool
  {
    b ||
      (a && prev_result)
  }

}
