package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.Payload1;
import fpbtest.module.builtintest.Protocol1;

public class Protocol1Impl extends PRecordSetValueBase implements Protocol1{
	private PIntegerValue prefix;
	private PIntegerValue prtlcode;
	private Payload1 payload;
	
	public static Protocol1 createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitProtocol1(meta);
		} else {
			return new Protocol1Impl(meta, false);
		}
	}

	public static Protocol1 createEmptyValue(PTypeElementMeta meta) {
		return new Protocol1Impl(meta, true);
	}
	
	protected Protocol1Impl(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			prefix = (PIntegerValue)createDefaultFieldValue(
					BuiltintestModule.PROTOCOL1__PREFIX);
			
			prtlcode = (PIntegerValue)createDefaultFieldValue(
					BuiltintestModule.PROTOCOL1__PRTLCODE);
			
			payload = (Payload1)createDefaultFieldValue(
					BuiltintestModule.PROTOCOL1__PAYLOAD);
			
		}
	}
	
	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case BuiltintestModule.PROTOCOL1__PREFIX:
			return prefix;
		case BuiltintestModule.PROTOCOL1__PRTLCODE:
			return prtlcode;
		case BuiltintestModule.PROTOCOL1__PAYLOAD:
			return (PValue)payload;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case BuiltintestModule.PROTOCOL1__PREFIX:
			prefix = (PIntegerValue)assignNewFieldValue(fieldId, prefix, newValue);
			break;
		case BuiltintestModule.PROTOCOL1__PRTLCODE:
			prtlcode = (PIntegerValue)assignNewFieldValue(fieldId, prtlcode, newValue);
			break;
		case BuiltintestModule.PROTOCOL1__PAYLOAD:
			payload = (Payload1)assignNewFieldValue(fieldId, (PValue)payload, newValue);
			break;
		}		
	}

	@Override
	public Payload1 getPayload() {
		return payload;
	}

	@Override
	public PIntegerValue getPrefix() {
		return prefix;
	}

	@Override
	public PIntegerValue getPrtlcode() {
		return prtlcode;
	}

	protected static class OmitProtocol1 extends OmitPRecordSetValueBase implements Protocol1 {

		public OmitProtocol1(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public Payload1 getPayload() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getPrefix() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getPrtlcode() {
			throw new OmitValueException();
		}
		
	}
	
}
