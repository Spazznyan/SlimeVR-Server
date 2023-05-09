// automatically generated by the FlatBuffers compiler, do not modify

import * as flatbuffers from 'flatbuffers';



export class OSCTrackersSetting implements flatbuffers.IUnpackableObject<OSCTrackersSettingT> {
  bb: flatbuffers.ByteBuffer|null = null;
  bb_pos = 0;
  __init(i:number, bb:flatbuffers.ByteBuffer):OSCTrackersSetting {
  this.bb_pos = i;
  this.bb = bb;
  return this;
}

static getRootAsOSCTrackersSetting(bb:flatbuffers.ByteBuffer, obj?:OSCTrackersSetting):OSCTrackersSetting {
  return (obj || new OSCTrackersSetting()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

static getSizePrefixedRootAsOSCTrackersSetting(bb:flatbuffers.ByteBuffer, obj?:OSCTrackersSetting):OSCTrackersSetting {
  bb.setPosition(bb.position() + flatbuffers.SIZE_PREFIX_LENGTH);
  return (obj || new OSCTrackersSetting()).__init(bb.readInt32(bb.position()) + bb.position(), bb);
}

head():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 4);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

chest():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 6);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

waist():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 8);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

knees():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 10);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

feet():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 12);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

elbows():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 14);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

hands():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 16);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

accessory():boolean {
  const offset = this.bb!.__offset(this.bb_pos, 18);
  return offset ? !!this.bb!.readInt8(this.bb_pos + offset) : false;
}

static startOSCTrackersSetting(builder:flatbuffers.Builder) {
  builder.startObject(8);
}

static addHead(builder:flatbuffers.Builder, head:boolean) {
  builder.addFieldInt8(0, +head, +false);
}

static addChest(builder:flatbuffers.Builder, chest:boolean) {
  builder.addFieldInt8(1, +chest, +false);
}

static addWaist(builder:flatbuffers.Builder, waist:boolean) {
  builder.addFieldInt8(2, +waist, +false);
}

static addKnees(builder:flatbuffers.Builder, knees:boolean) {
  builder.addFieldInt8(3, +knees, +false);
}

static addFeet(builder:flatbuffers.Builder, feet:boolean) {
  builder.addFieldInt8(4, +feet, +false);
}

static addElbows(builder:flatbuffers.Builder, elbows:boolean) {
  builder.addFieldInt8(5, +elbows, +false);
}

static addHands(builder:flatbuffers.Builder, hands:boolean) {
  builder.addFieldInt8(6, +hands, +false);
}

static addAccessory(builder:flatbuffers.Builder, accessory:boolean) {
  builder.addFieldInt8(7, +accessory, +false);
}

static endOSCTrackersSetting(builder:flatbuffers.Builder):flatbuffers.Offset {
  const offset = builder.endObject();
  return offset;
}

static createOSCTrackersSetting(builder:flatbuffers.Builder, head:boolean, chest:boolean, waist:boolean, knees:boolean, feet:boolean, elbows:boolean, hands:boolean, accessory:boolean):flatbuffers.Offset {
  OSCTrackersSetting.startOSCTrackersSetting(builder);
  OSCTrackersSetting.addHead(builder, head);
  OSCTrackersSetting.addChest(builder, chest);
  OSCTrackersSetting.addWaist(builder, waist);
  OSCTrackersSetting.addKnees(builder, knees);
  OSCTrackersSetting.addFeet(builder, feet);
  OSCTrackersSetting.addElbows(builder, elbows);
  OSCTrackersSetting.addHands(builder, hands);
  OSCTrackersSetting.addAccessory(builder, accessory);
  return OSCTrackersSetting.endOSCTrackersSetting(builder);
}

unpack(): OSCTrackersSettingT {
  return new OSCTrackersSettingT(
    this.head(),
    this.chest(),
    this.waist(),
    this.knees(),
    this.feet(),
    this.elbows(),
    this.hands(),
    this.accessory()
  );
}


unpackTo(_o: OSCTrackersSettingT): void {
  _o.head = this.head();
  _o.chest = this.chest();
  _o.waist = this.waist();
  _o.knees = this.knees();
  _o.feet = this.feet();
  _o.elbows = this.elbows();
  _o.hands = this.hands();
  _o.accessory = this.accessory();
}
}

export class OSCTrackersSettingT implements flatbuffers.IGeneratedObject {
constructor(
  public head: boolean = false,
  public chest: boolean = false,
  public waist: boolean = false,
  public knees: boolean = false,
  public feet: boolean = false,
  public elbows: boolean = false,
  public hands: boolean = false,
  public accessory: boolean = false
){}


pack(builder:flatbuffers.Builder): flatbuffers.Offset {
  return OSCTrackersSetting.createOSCTrackersSetting(builder,
    this.head,
    this.chest,
    this.waist,
    this.knees,
    this.feet,
    this.elbows,
    this.hands,
    this.accessory
  );
}
}
