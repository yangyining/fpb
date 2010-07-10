package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.PUnion;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.impl.PUnionTypeExtBase;
import com.fineqt.fpb.lib.value.PValue;

public class UnionBlock1Type extends PUnionTypeExtBase {

	public UnionBlock1Type(PType pmodel, PModuleExt pmoduleExt) {
		super((PUnion)pmodel, pmoduleExt);
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		return (PValue)UnionBlock1Impl.createValue(this, false);
	}

	@Override
	public PValue createOmitValue() {
		return (PValue)UnionBlock1Impl.createValue(this, true);
	}

	@Override
	public PValue createEmptyValue() {
		return (PValue)UnionBlock1Impl.createEmptyValue(this);
	}
	
}
