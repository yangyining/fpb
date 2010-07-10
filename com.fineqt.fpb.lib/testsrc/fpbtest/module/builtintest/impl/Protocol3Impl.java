package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.Protocol3;

public class Protocol3Impl extends PRecordSetValueBase implements Protocol3{
	private PIntegerValue prefix;
	private POctetstringValue data;
	
	public static Protocol3 createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitProtocol3(meta);
		} else {
			return new Protocol3Impl(meta, false);
		}
	}

	public static Protocol3 createEmptyValue(PTypeElementMeta meta) {
		return new Protocol3Impl(meta, true);
	}
	
	protected Protocol3Impl(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			prefix = (PIntegerValue)createDefaultFieldValue(
					BuiltintestModule.PROTOCOL3__PREFIX);
			
			data = (POctetstringValue)createDefaultFieldValue(
					BuiltintestModule.PROTOCOL3__DATA);
		}
	}
	
	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case BuiltintestModule.PROTOCOL3__PREFIX:
			return prefix;
		case BuiltintestModule.PROTOCOL3__DATA:
			return data;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case BuiltintestModule.PROTOCOL3__PREFIX:
			prefix = (PIntegerValue)assignNewFieldValue(fieldId, prefix, newValue);
			break;
		case BuiltintestModule.PROTOCOL3__DATA:
			data = (POctetstringValue)assignNewFieldValue(fieldId, data, newValue);
			break;
		}
	}

	@Override
	public POctetstringValue getData() {
		return data;
	}

	@Override
	public PIntegerValue getPrefix() {
		return prefix;
	}

	protected static class OmitProtocol3 extends OmitPRecordSetValueBase implements Protocol3 {

		public OmitProtocol3(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public POctetstringValue getData() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getPrefix() {
			throw new OmitValueException();
		}

		
	}
	
}
