package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PRecord;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.impl.PRecordTypeExtBase;
import com.fineqt.fpb.lib.value.PValue;

public class Protocol1Type extends PRecordTypeExtBase {

	public Protocol1Type(PType pmodel, PModuleExt pmoduleExt) {
		super((PRecord)pmodel, pmoduleExt);
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		return (PValue)Protocol1Impl.createValue(this, false);
	}

	@Override
	public PValue createOmitValue() {
		return (PValue)Protocol1Impl.createValue(this, true);
	}

	@Override
	public PValue createEmptyValue() {
		return (PValue)Protocol1Impl.createEmptyValue(this);
	}


}
