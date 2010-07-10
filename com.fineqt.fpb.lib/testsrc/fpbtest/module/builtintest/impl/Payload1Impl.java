package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PUnionValue;
import com.fineqt.fpb.lib.value.SimpleUnionValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.Payload1;
import fpbtest.module.builtintest.Protocol2;
import fpbtest.module.builtintest.Protocol3;

public class Payload1Impl extends SimpleUnionValue implements Payload1{

	public static PUnionValue createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitPayload1(meta);
		} else {
			return new Payload1Impl(meta, false);
		}
	}
	
	public static PUnionValue createEmptyValue(PTypeElementMeta meta) {
		return new Payload1Impl(meta, true);
	}
	
	protected Payload1Impl(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta, empty);
	}

	@Override
	public POctetstringValue getData() {
		return (POctetstringValue)pGetFieldByID(BuiltintestModule.PAYLOAD1__DATA);
	}

	@Override
	public Protocol2 getPrtl2() {
		return (Protocol2)pGetFieldByID(BuiltintestModule.PAYLOAD1__PRTL2);
	}

	@Override
	public Protocol3 getPrtl3() {
		return (Protocol3)pGetFieldByID(BuiltintestModule.PAYLOAD1__PRTL3);
	}

	protected static class OmitPayload1 extends OmitPUnionValue implements Payload1 {

		public OmitPayload1(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public POctetstringValue getData() {
			throw new OmitValueException();
		}

		@Override
		public Protocol2 getPrtl2() {
			throw new OmitValueException();
		}

		@Override
		public Protocol3 getPrtl3() {
			throw new OmitValueException();
		}

	}	
	
}
