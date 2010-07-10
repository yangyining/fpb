package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.api.value.IEnumeratedValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.EnumRefRecord;

public class EnumRefRecordImpl extends PRecordSetValueBase implements EnumRefRecord {
	private IEnumeratedValue fieldName;
	private IIntegerValue field1;
	private IIntegerValue field2;
	
	public static EnumRefRecord createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitEnumRefRecord(meta);
		} else {
			return new EnumRefRecordImpl(meta, false);
		}
	}
	
	public static EnumRefRecord createEmptyValue(PTypeElementMeta meta) {
		return new EnumRefRecordImpl(meta, true);
	}
	
	protected EnumRefRecordImpl(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//设置初始值
			fieldName = (IEnumeratedValue)createDefaultFieldValue( 
					BuiltintestModule.ENUM_REF_RECORD__FIELD_NAME);
			field1 = (IIntegerValue)createDefaultFieldValue( 
					BuiltintestModule.ENUM_REF_RECORD__FIELD1);
			field2 = (IIntegerValue)createDefaultFieldValue( 
					BuiltintestModule.ENUM_REF_RECORD__FIELD2);
		}
	}

	@Override
	public IIntegerValue getField1() {
		return field1;
	}

	@Override
	public IIntegerValue getField2() {
		return field2;
	}

	@Override
	public IEnumeratedValue getFieldName() {
		return fieldName;
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		//取得值
		switch(fieldId) {
		case BuiltintestModule.ENUM_REF_RECORD__FIELD_NAME:
			return (PValue)fieldName;
		case BuiltintestModule.ENUM_REF_RECORD__FIELD1:
			return (PValue)field1;
		case BuiltintestModule.ENUM_REF_RECORD__FIELD2:
			return (PValue)field2;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		//赋值
		switch(fieldId) {
		case BuiltintestModule.ENUM_REF_RECORD__FIELD_NAME:
			fieldName = (IEnumeratedValue)assignNewFieldValue(fieldId, (PValue)fieldName, newValue);
			break;
		case BuiltintestModule.ENUM_REF_RECORD__FIELD1:
			field1 = (IIntegerValue)assignNewFieldValue(fieldId, (PValue)field1, newValue);
			break;
		case BuiltintestModule.ENUM_REF_RECORD__FIELD2:
			field2 = (IIntegerValue)assignNewFieldValue(fieldId, (PValue)field2, newValue);
			break;
		}		
	}
	
	protected static class OmitEnumRefRecord extends OmitPRecordSetValueBase 
	implements EnumRefRecord {

		public OmitEnumRefRecord(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public IIntegerValue getField1() {
			throw new OmitValueException();
		}

		@Override
		public IIntegerValue getField2() {
			throw new OmitValueException();
		}

		@Override
		public IEnumeratedValue getFieldName() {
			throw new OmitValueException();
		}

	}
}
