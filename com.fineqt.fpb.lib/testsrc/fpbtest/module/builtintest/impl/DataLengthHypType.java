package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PRecord;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.impl.PRecordTypeExtBase;
import com.fineqt.fpb.lib.value.PValue;

public class DataLengthHypType extends PRecordTypeExtBase {

	public DataLengthHypType(PType pmodel, PModuleExt pmoduleExt) {
		super((PRecord)pmodel, pmoduleExt);
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		return (PValue)DataLengthHypImpl.createValue(this, false);
	}

	@Override
	public PValue createOmitValue() {
		return (PValue)DataLengthHypImpl.createValue(this, true);
	}

	@Override
	public PValue createEmptyValue() {
		return (PValue)DataLengthHypImpl.createEmptyValue(this);
	}

}
