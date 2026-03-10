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

// This file will not be overwritten if codegen is rerun

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
  // BEGIN MARKER GUMBO VERUS MARKER
  pub open spec fn Since_spec(
    a: bool,
    b: bool,
    prev_result: bool) -> bool
  {
    b ||
      (a && prev_result)
  }
  // END MARKER GUMBO VERUS MARKER
}
