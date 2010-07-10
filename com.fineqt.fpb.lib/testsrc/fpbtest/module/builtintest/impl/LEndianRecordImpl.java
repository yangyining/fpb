package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.builtin.PBitstringValue;
import com.fineqt.fpb.lib.builtin.PBooleanValue;
import com.fineqt.fpb.lib.builtin.PHexstringValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.LEndianRecord;

public class LEndianRecordImpl extends PRecordSetValueBase implements LEndianRecord {
	private PIntegerValue int1;
	private PBooleanValue flag;
	private PBitstringValue bits;
	private PIntegerValue int2;
	private PIntegerValue int3;
	private PHexstringValue hexs;
	
	public static LEndianRecord createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitLEndianRecord(meta);
		} else {
			return new LEndianRecordImpl(meta, false);
		}
	}
	
	public static LEndianRecord createEmptyValue(PTypeElementMeta meta) {
		return new LEndianRecordImpl(meta, true);
	}
	
	protected LEndianRecordImpl(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			int1 = (PIntegerValue)createDefaultFieldValue(
					BuiltintestModule.LENDIAN_RECORD__INT1);

			flag = (PBooleanValue)createDefaultFieldValue(
					BuiltintestModule.LENDIAN_RECORD__FLAG);
			
			bits = (PBitstringValue)createDefaultFieldValue(
					BuiltintestModule.LENDIAN_RECORD__BITS);
			
			int2 = (PIntegerValue)createDefaultFieldValue(
					BuiltintestModule.LENDIAN_RECORD__INT2);

			int3 = (PIntegerValue)createDefaultFieldValue(
					BuiltintestModule.LENDIAN_RECORD__INT3);

			hexs = (PHexstringValue)createDefaultFieldValue(
					BuiltintestModule.LENDIAN_RECORD__HEXS);
		}
	}
	
	@Override
	public PIntegerValue getInt1() {
		return int1;
	}
	
	@Override
	public PIntegerValue getInt2() {
		return int2;
	}
	
	@Override
	public PIntegerValue getInt3() {
		return int3;
	}
	
	
	@Override
	public PBitstringValue getBits() {
		return bits;
	}

	@Override
	public PBooleanValue getFlag() {
		return flag;
	}

	@Override
	public PHexstringValue getHexs() {
		return hexs;
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case BuiltintestModule.LENDIAN_RECORD__INT1:
			return int1;
		case BuiltintestModule.LENDIAN_RECORD__FLAG:
			return flag;
		case BuiltintestModule.LENDIAN_RECORD__BITS:
			return bits;
		case BuiltintestModule.LENDIAN_RECORD__INT2:
			return int2;
		case BuiltintestModule.LENDIAN_RECORD__INT3:
			return int3;
		case BuiltintestModule.LENDIAN_RECORD__HEXS:
			return hexs;
		}
		return null;
	}
	
	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case BuiltintestModule.LENDIAN_RECORD__INT1:
			int1 = (PIntegerValue)assignNewFieldValue(fieldId, int1, newValue);
			break;
		case BuiltintestModule.LENDIAN_RECORD__FLAG:
			flag = (PBooleanValue)assignNewFieldValue(fieldId, flag, newValue);
			break;
		case BuiltintestModule.LENDIAN_RECORD__BITS:
			bits = (PBitstringValue)assignNewFieldValue(fieldId, bits, newValue);
			break;
		case BuiltintestModule.LENDIAN_RECORD__INT2:
			int2 = (PIntegerValue)assignNewFieldValue(fieldId, int2, newValue);
			break;
		case BuiltintestModule.LENDIAN_RECORD__INT3:
			int3 = (PIntegerValue)assignNewFieldValue(fieldId, int3, newValue);
			break;
		case BuiltintestModule.LENDIAN_RECORD__HEXS:
			hexs = (PHexstringValue)assignNewFieldValue(fieldId, hexs, newValue);
			break;
		}		
	}
	
	protected static class OmitLEndianRecord extends OmitPRecordSetValueBase 
	implements LEndianRecord {

		public OmitLEndianRecord(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public PIntegerValue getInt1() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getInt2() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getInt3() {
			throw new OmitValueException();
		}

		@Override
		public PBitstringValue getBits() {
			throw new OmitValueException();
		}

		@Override
		public PBooleanValue getFlag() {
			throw new OmitValueException();
		}

		@Override
		public PHexstringValue getHexs() {
			throw new OmitValueException();
		}
		
	}
	
}
