package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PRecordOf;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.impl.PRecordOfTypeExtBase;
import com.fineqt.fpb.lib.value.PValue;

public class StringMultiLineFixType extends PRecordOfTypeExtBase {

	public StringMultiLineFixType(PType pmodel, PModuleExt pmoduleExt) {
		super((PRecordOf)pmodel, pmoduleExt);
	}

	
	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		return super.createNormalValue(paras);
	}

}
