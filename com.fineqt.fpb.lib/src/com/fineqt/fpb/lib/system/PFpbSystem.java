package com.fineqt.fpb.lib.system;
import com.fineqt.fpb.lib.api.util.IFpbSystem;
import com.fineqt.fpb.lib.type.PTypeExt;

public interface PFpbSystem extends IFpbSystem {
	PFpbSystem PINSTANCE = new FpbSystemImpl();
	PTypeExt.InternalValueFactory getInternalValueFactory();
	void setInternalValueFactory(PTypeExt.InternalValueFactory factory);
}
