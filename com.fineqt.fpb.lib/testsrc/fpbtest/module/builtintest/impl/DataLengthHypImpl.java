package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.builtin.PBitstringValue;
import com.fineqt.fpb.lib.builtin.PBooleanValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.DataLengthHyp;

public class DataLengthHypImpl extends PRecordSetValueBase implements DataLengthHyp {
	private PIntegerValue totalLength;
	private PIntegerValue data1Length;
	private PBooleanValue data2Flag;
	private PBitstringValue data1;
	private PBitstringValue pad;
	private POctetstringValue data2;
	private POctetstringValue data3;
	
	public static DataLengthHyp createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitDataLengthHyp(meta);
		} else {
			return new DataLengthHypImpl(meta, false);
		}
	}
	
	public static DataLengthHyp createEmptyValue(PTypeElementMeta meta) {
		return new DataLengthHypImpl(meta, true);
	}
	
	protected DataLengthHypImpl(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//设置初始值
			totalLength = (PIntegerValue)createDefaultFieldValue( 
					BuiltintestModule.DATA_LENGTH_HYP__TOTAL_LENGTH);
			
			data1Length = (PIntegerValue)createDefaultFieldValue(
					BuiltintestModule.DATA_LENGTH_HYP__DATA1_LENGTH);
			
			data2Flag = (PBooleanValue)createDefaultFieldValue(
					BuiltintestModule.DATA_LENGTH_HYP__DATA2_FLAG);
			
			data1 = (PBitstringValue)createDefaultFieldValue(
					BuiltintestModule.DATA_LENGTH_HYP__DATA1);
			
			pad = (PBitstringValue)createDefaultFieldValue(
					BuiltintestModule.DATA_LENGTH_HYP__PAD);
			
			data2 = (POctetstringValue)createDefaultFieldValue(
					BuiltintestModule.DATA_LENGTH_HYP__DATA2);
			
			data3 = (POctetstringValue)createDefaultFieldValue(
					BuiltintestModule.DATA_LENGTH_HYP__DATA3);
		}
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		//取得值
		switch(fieldId) {
		case BuiltintestModule.DATA_LENGTH_HYP__TOTAL_LENGTH:
			return totalLength;
		case BuiltintestModule.DATA_LENGTH_HYP__DATA1_LENGTH:
			return data1Length;
		case BuiltintestModule.DATA_LENGTH_HYP__DATA2_FLAG:
			return data2Flag;
		case BuiltintestModule.DATA_LENGTH_HYP__DATA1:
			return data1;
		case BuiltintestModule.DATA_LENGTH_HYP__PAD:
			return pad;
		case BuiltintestModule.DATA_LENGTH_HYP__DATA2:
			return data2;
		case BuiltintestModule.DATA_LENGTH_HYP__DATA3:
			return data3;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		//赋值
		switch(fieldId) {
		case BuiltintestModule.DATA_LENGTH_HYP__TOTAL_LENGTH:
			totalLength = (PIntegerValue)assignNewFieldValue(fieldId, totalLength, newValue);
			break;
		case BuiltintestModule.DATA_LENGTH_HYP__DATA1_LENGTH:
			data1Length = (PIntegerValue)assignNewFieldValue(fieldId, data1Length, newValue);
			break;
		case BuiltintestModule.DATA_LENGTH_HYP__DATA2_FLAG:
			data2Flag = (PBooleanValue)assignNewFieldValue(fieldId, data2Flag, newValue);
			break;
		case BuiltintestModule.DATA_LENGTH_HYP__DATA1:
			data1 = (PBitstringValue)assignNewFieldValue(fieldId, data1, newValue);
			break;
		case BuiltintestModule.DATA_LENGTH_HYP__PAD:
			pad = (PBitstringValue)assignNewFieldValue(fieldId, pad, newValue);
			break;
		case BuiltintestModule.DATA_LENGTH_HYP__DATA2:
			data2 = (POctetstringValue)assignNewFieldValue(fieldId, data2, newValue);
			break;
		case BuiltintestModule.DATA_LENGTH_HYP__DATA3:
			data3 = (POctetstringValue)assignNewFieldValue(fieldId, data3, newValue);
			break;
		}
	}

	public PIntegerValue getTotalLength() {
		return totalLength;
	}

	public PIntegerValue getData1Length() {
		return data1Length;
	}

	public PBooleanValue getData2Flag() {
		return data2Flag;
	}

	public PBitstringValue getData1() {
		return data1;
	}

	public PBitstringValue getPad() {
		return pad;
	}

	public POctetstringValue getData2() {
		return data2;
	}

	public POctetstringValue getData3() {
		return data3;
	}

	protected static class OmitDataLengthHyp extends OmitPRecordSetValueBase 
	implements DataLengthHyp {

		public OmitDataLengthHyp(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public PBitstringValue getData1() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getData1Length() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getData2() {
			throw new OmitValueException();
		}

		@Override
		public PBooleanValue getData2Flag() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getData3() {
			throw new OmitValueException();
		}

		@Override
		public PBitstringValue getPad() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getTotalLength() {
			throw new OmitValueException();
		}
	}
}
