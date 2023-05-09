// automatically generated by the FlatBuffers compiler, do not modify
// @generated
extern crate alloc;
extern crate flatbuffers;
use alloc::boxed::Box;
use alloc::string::{String, ToString};
use alloc::vec::Vec;
use core::mem;
use core::cmp::Ordering;
use self::flatbuffers::{EndianScalar, Follow};
use super::*;
pub enum ModelRatiosOffset {}
#[derive(Copy, Clone, PartialEq)]

/// Settings for the skeletal model that are ratios.
/// These values range from 0 to 1.
pub struct ModelRatios<'a> {
  pub _tab: flatbuffers::Table<'a>,
}

impl<'a> flatbuffers::Follow<'a> for ModelRatios<'a> {
  type Inner = ModelRatios<'a>;
  #[inline]
  unsafe fn follow(buf: &'a [u8], loc: usize) -> Self::Inner {
    Self { _tab: flatbuffers::Table::new(buf, loc) }
  }
}

impl<'a> ModelRatios<'a> {
  pub const VT_IMPUTE_WAIST_FROM_CHEST_HIP: flatbuffers::VOffsetT = 4;
  pub const VT_IMPUTE_WAIST_FROM_CHEST_LEGS: flatbuffers::VOffsetT = 6;
  pub const VT_IMPUTE_HIP_FROM_CHEST_LEGS: flatbuffers::VOffsetT = 8;
  pub const VT_IMPUTE_HIP_FROM_WAIST_LEGS: flatbuffers::VOffsetT = 10;
  pub const VT_INTERP_HIP_LEGS: flatbuffers::VOffsetT = 12;
  pub const VT_INTERP_KNEE_TRACKER_ANKLE: flatbuffers::VOffsetT = 14;

  #[inline]
  pub unsafe fn init_from_table(table: flatbuffers::Table<'a>) -> Self {
    ModelRatios { _tab: table }
  }
  #[allow(unused_mut)]
  pub fn create<'bldr: 'args, 'args: 'mut_bldr, 'mut_bldr>(
    _fbb: &'mut_bldr mut flatbuffers::FlatBufferBuilder<'bldr>,
    args: &'args ModelRatiosArgs
  ) -> flatbuffers::WIPOffset<ModelRatios<'bldr>> {
    let mut builder = ModelRatiosBuilder::new(_fbb);
    if let Some(x) = args.interp_knee_tracker_ankle { builder.add_interp_knee_tracker_ankle(x); }
    if let Some(x) = args.interp_hip_legs { builder.add_interp_hip_legs(x); }
    if let Some(x) = args.impute_hip_from_waist_legs { builder.add_impute_hip_from_waist_legs(x); }
    if let Some(x) = args.impute_hip_from_chest_legs { builder.add_impute_hip_from_chest_legs(x); }
    if let Some(x) = args.impute_waist_from_chest_legs { builder.add_impute_waist_from_chest_legs(x); }
    if let Some(x) = args.impute_waist_from_chest_hip { builder.add_impute_waist_from_chest_hip(x); }
    builder.finish()
  }


  #[inline]
  pub fn impute_waist_from_chest_hip(&self) -> Option<f32> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<f32>(ModelRatios::VT_IMPUTE_WAIST_FROM_CHEST_HIP, None)}
  }
  #[inline]
  pub fn impute_waist_from_chest_legs(&self) -> Option<f32> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<f32>(ModelRatios::VT_IMPUTE_WAIST_FROM_CHEST_LEGS, None)}
  }
  #[inline]
  pub fn impute_hip_from_chest_legs(&self) -> Option<f32> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<f32>(ModelRatios::VT_IMPUTE_HIP_FROM_CHEST_LEGS, None)}
  }
  #[inline]
  pub fn impute_hip_from_waist_legs(&self) -> Option<f32> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<f32>(ModelRatios::VT_IMPUTE_HIP_FROM_WAIST_LEGS, None)}
  }
  /// Hip's yaw and roll is set to the average of legs when 1.0
  #[inline]
  pub fn interp_hip_legs(&self) -> Option<f32> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<f32>(ModelRatios::VT_INTERP_HIP_LEGS, None)}
  }
  /// Knee trackers' yaw and roll is set to the ankle's when 1.0
  #[inline]
  pub fn interp_knee_tracker_ankle(&self) -> Option<f32> {
    // Safety:
    // Created from valid Table for this object
    // which contains a valid value in this slot
    unsafe { self._tab.get::<f32>(ModelRatios::VT_INTERP_KNEE_TRACKER_ANKLE, None)}
  }
}

impl flatbuffers::Verifiable for ModelRatios<'_> {
  #[inline]
  fn run_verifier(
    v: &mut flatbuffers::Verifier, pos: usize
  ) -> Result<(), flatbuffers::InvalidFlatbuffer> {
    use self::flatbuffers::Verifiable;
    v.visit_table(pos)?
     .visit_field::<f32>("impute_waist_from_chest_hip", Self::VT_IMPUTE_WAIST_FROM_CHEST_HIP, false)?
     .visit_field::<f32>("impute_waist_from_chest_legs", Self::VT_IMPUTE_WAIST_FROM_CHEST_LEGS, false)?
     .visit_field::<f32>("impute_hip_from_chest_legs", Self::VT_IMPUTE_HIP_FROM_CHEST_LEGS, false)?
     .visit_field::<f32>("impute_hip_from_waist_legs", Self::VT_IMPUTE_HIP_FROM_WAIST_LEGS, false)?
     .visit_field::<f32>("interp_hip_legs", Self::VT_INTERP_HIP_LEGS, false)?
     .visit_field::<f32>("interp_knee_tracker_ankle", Self::VT_INTERP_KNEE_TRACKER_ANKLE, false)?
     .finish();
    Ok(())
  }
}
pub struct ModelRatiosArgs {
    pub impute_waist_from_chest_hip: Option<f32>,
    pub impute_waist_from_chest_legs: Option<f32>,
    pub impute_hip_from_chest_legs: Option<f32>,
    pub impute_hip_from_waist_legs: Option<f32>,
    pub interp_hip_legs: Option<f32>,
    pub interp_knee_tracker_ankle: Option<f32>,
}
impl<'a> Default for ModelRatiosArgs {
  #[inline]
  fn default() -> Self {
    ModelRatiosArgs {
      impute_waist_from_chest_hip: None,
      impute_waist_from_chest_legs: None,
      impute_hip_from_chest_legs: None,
      impute_hip_from_waist_legs: None,
      interp_hip_legs: None,
      interp_knee_tracker_ankle: None,
    }
  }
}

pub struct ModelRatiosBuilder<'a: 'b, 'b> {
  fbb_: &'b mut flatbuffers::FlatBufferBuilder<'a>,
  start_: flatbuffers::WIPOffset<flatbuffers::TableUnfinishedWIPOffset>,
}
impl<'a: 'b, 'b> ModelRatiosBuilder<'a, 'b> {
  #[inline]
  pub fn add_impute_waist_from_chest_hip(&mut self, impute_waist_from_chest_hip: f32) {
    self.fbb_.push_slot_always::<f32>(ModelRatios::VT_IMPUTE_WAIST_FROM_CHEST_HIP, impute_waist_from_chest_hip);
  }
  #[inline]
  pub fn add_impute_waist_from_chest_legs(&mut self, impute_waist_from_chest_legs: f32) {
    self.fbb_.push_slot_always::<f32>(ModelRatios::VT_IMPUTE_WAIST_FROM_CHEST_LEGS, impute_waist_from_chest_legs);
  }
  #[inline]
  pub fn add_impute_hip_from_chest_legs(&mut self, impute_hip_from_chest_legs: f32) {
    self.fbb_.push_slot_always::<f32>(ModelRatios::VT_IMPUTE_HIP_FROM_CHEST_LEGS, impute_hip_from_chest_legs);
  }
  #[inline]
  pub fn add_impute_hip_from_waist_legs(&mut self, impute_hip_from_waist_legs: f32) {
    self.fbb_.push_slot_always::<f32>(ModelRatios::VT_IMPUTE_HIP_FROM_WAIST_LEGS, impute_hip_from_waist_legs);
  }
  #[inline]
  pub fn add_interp_hip_legs(&mut self, interp_hip_legs: f32) {
    self.fbb_.push_slot_always::<f32>(ModelRatios::VT_INTERP_HIP_LEGS, interp_hip_legs);
  }
  #[inline]
  pub fn add_interp_knee_tracker_ankle(&mut self, interp_knee_tracker_ankle: f32) {
    self.fbb_.push_slot_always::<f32>(ModelRatios::VT_INTERP_KNEE_TRACKER_ANKLE, interp_knee_tracker_ankle);
  }
  #[inline]
  pub fn new(_fbb: &'b mut flatbuffers::FlatBufferBuilder<'a>) -> ModelRatiosBuilder<'a, 'b> {
    let start = _fbb.start_table();
    ModelRatiosBuilder {
      fbb_: _fbb,
      start_: start,
    }
  }
  #[inline]
  pub fn finish(self) -> flatbuffers::WIPOffset<ModelRatios<'a>> {
    let o = self.fbb_.end_table(self.start_);
    flatbuffers::WIPOffset::new(o.value())
  }
}

impl core::fmt::Debug for ModelRatios<'_> {
  fn fmt(&self, f: &mut core::fmt::Formatter<'_>) -> core::fmt::Result {
    let mut ds = f.debug_struct("ModelRatios");
      ds.field("impute_waist_from_chest_hip", &self.impute_waist_from_chest_hip());
      ds.field("impute_waist_from_chest_legs", &self.impute_waist_from_chest_legs());
      ds.field("impute_hip_from_chest_legs", &self.impute_hip_from_chest_legs());
      ds.field("impute_hip_from_waist_legs", &self.impute_hip_from_waist_legs());
      ds.field("interp_hip_legs", &self.interp_hip_legs());
      ds.field("interp_knee_tracker_ankle", &self.interp_knee_tracker_ankle());
      ds.finish()
  }
}
