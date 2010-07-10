package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.CaseRecord;

public class CaseRecordImpl extends PRecordSetValueBase implements CaseRecord {
	private PIntegerValue code;
	private PIntegerValue data;
	
	public static CaseRecord createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitCaseRecord(meta);
		} else {
			return new CaseRecordImpl(meta, false);
		}
	}

	public static CaseRecord createEmptyValue(PTypeElementMeta meta) {
		return new CaseRecordImpl(meta, true);
	}
	
	protected CaseRecordImpl(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			code = (PIntegerValue)createDefaultFieldValue(
					BuiltintestModule.CASE_RECORD__CODE);
			
			data = (PIntegerValue)createDefaultFieldValue(
					BuiltintestModule.CASE_RECORD__DATA);
		}
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case BuiltintestModule.CASE_RECORD__CODE:
			return code;
		case BuiltintestModule.CASE_RECORD__DATA:
			return data;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case BuiltintestModule.CASE_RECORD__CODE:
			code = (PIntegerValue)assignNewFieldValue(fieldId, code, newValue);
			break;
		case BuiltintestModule.CASE_RECORD__DATA:
			data = (PIntegerValue)assignNewFieldValue(fieldId, data, newValue);
			break;
		}
	}

	public PIntegerValue getCode() {
		return code;
	}

	public PIntegerValue getData() {
		return data;
	}

	protected static class OmitCaseRecord extends OmitPRecordSetValueBase implements CaseRecord {

		public OmitCaseRecord(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public PIntegerValue getCode() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getData() {
			throw new OmitValueException();
		}
		
	}
}
