package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PUnionValue;
import com.fineqt.fpb.lib.value.SimpleUnionValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.CaseRecord;
import fpbtest.module.builtintest.UnionBlock1;

public class UnionBlock1Impl extends SimpleUnionValue implements UnionBlock1{
	
	public static PUnionValue createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitUnionBlock1(meta);
		} else {
			return new UnionBlock1Impl(meta, false);
		}
	}
	
	public static PUnionValue createEmptyValue(PTypeElementMeta meta) {
		return new UnionBlock1Impl(meta, true);
	}
	
	protected UnionBlock1Impl(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta, empty);
	}

	@Override
	public CaseRecord getCase1() {
		return (CaseRecord)pGetFieldByID(BuiltintestModule.UNION_BLOCK1__CASE1);
	}

	@Override
	public CaseRecord getCase2() {
		return (CaseRecord)pGetFieldByID(BuiltintestModule.UNION_BLOCK1__CASE2);
	}

	@Override
	public CaseRecord getCase3() {
		return (CaseRecord)pGetFieldByID(BuiltintestModule.UNION_BLOCK1__CASE3);
	}

	protected static class OmitUnionBlock1 extends OmitPUnionValue implements UnionBlock1 {

		public OmitUnionBlock1(PTypeElementMeta valueMeta) {
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

		@Override
		public CaseRecord getCase3() {
			throw new OmitValueException();
		}

	}	
}
