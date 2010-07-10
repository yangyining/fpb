package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PSetOf;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.impl.PSetOfTypeExtBase;

public class Uint16SetType extends PSetOfTypeExtBase {

	public Uint16SetType(PType pmodel, PModuleExt pmoduleExt) {
		super((PSetOf)pmodel, pmoduleExt);
	}

	public static class PTypeEVExt4Fpb extends PFpbSetOfEVExt {

		public PTypeEVExt4Fpb(PFpbTypeEV model) {
			super(model);
		}
		
	}
}
