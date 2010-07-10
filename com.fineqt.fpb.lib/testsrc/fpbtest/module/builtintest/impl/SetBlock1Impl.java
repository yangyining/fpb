package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.CaseRecord;
import fpbtest.module.builtintest.SetBlock1;

public class SetBlock1Impl extends PRecordSetValueBase implements SetBlock1 {
	CaseRecord case1;
	CaseRecord case2;

	public static SetBlock1 createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitSetBlock1(meta);
		} else {
			return new SetBlock1Impl(meta, false);
		}
	}
	
	public static SetBlock1 createEmptyValue(PTypeElementMeta meta) {
		return new SetBlock1Impl(meta, true);
	}
	
	protected SetBlock1Impl(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//设置初始值
			case1 = (CaseRecord)createDefaultFieldValue( 
					BuiltintestModule.SET_BLOCK1__CASE1);
			case2 = (CaseRecord)createDefaultFieldValue( 
					BuiltintestModule.SET_BLOCK1__CASE2);
		}
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		//取得值
		switch(fieldId) {
		case BuiltintestModule.SET_BLOCK1__CASE1:
			return (PValue)case1;
		case BuiltintestModule.SET_BLOCK1__CASE2:
			return (PValue)case2;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		//赋值
		switch(fieldId) {
		case BuiltintestModule.SET_BLOCK1__CASE1:
			case1 = (CaseRecord)assignNewFieldValue(fieldId, (PValue)case1, newValue);
			break;
		case BuiltintestModule.SET_BLOCK1__CASE2:
			case2 = (CaseRecord)assignNewFieldValue(fieldId, (PValue)case2, newValue);
			break;
		}
	}

	@Override
	public CaseRecord getCase1() {
		return case1;
	}

	@Override
	public CaseRecord getCase2() {
		return case2;
	}
	
	protected static class OmitSetBlock1 extends OmitPRecordSetValueBase 
	implements SetBlock1 {

		public OmitSetBlock1(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public CaseRecord getCase1() {
			throw new OmitValueException();
		}

		@Override
		public CaseRecord getCase2() {
			throw new OmitValueException();
		}
		
	}	
}
