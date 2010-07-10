package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.Protocol2;

public class Protocol2Impl extends PRecordSetValueBase implements Protocol2 {
	private PIntegerValue data;
	
	public static Protocol2 createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitProtocol2(meta);
		} else {
			return new Protocol2Impl(meta, false);
		}
	}

	public static Protocol2 createEmptyValue(PTypeElementMeta meta) {
		return new Protocol2Impl(meta, true);
	}
	
	protected Protocol2Impl(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			data = (PIntegerValue)createDefaultFieldValue(
					BuiltintestModule.PROTOCOL2__DATA);
		}
	}
	
	@Override
	public PIntegerValue getData() {
		return data;
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case BuiltintestModule.PROTOCOL2__DATA:
			return data;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case BuiltintestModule.PROTOCOL2__DATA:
			data = (PIntegerValue)assignNewFieldValue(fieldId, data, newValue);
			break;
		}		
	}

	protected static class OmitProtocol2 extends OmitPRecordSetValueBase implements Protocol2 {

		public OmitProtocol2(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public PIntegerValue getData() {
			throw new OmitValueException();
		}
		
	}
	
}
