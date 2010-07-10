package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PSet;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.impl.PSetTypeExtBase;
import com.fineqt.fpb.lib.value.PValue;

public class SetBlock1Type extends PSetTypeExtBase {

	public SetBlock1Type(PType pmodel, PModuleExt pmoduleExt) {
		super((PSet)pmodel, pmoduleExt);
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		return (PValue)SetBlock1Impl.createValue(this, false);
	}

	@Override
	public PValue createOmitValue() {
		return (PValue)SetBlock1Impl.createValue(this, true);
	}

	@Override
	public PValue createEmptyValue() {
		return (PValue)SetBlock1Impl.createEmptyValue(this);
	}

}
