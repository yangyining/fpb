package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.api.value.IUnionValue;

public interface Payload1 extends IUnionValue {
	Protocol2 getPrtl2();
	Protocol3 getPrtl3();
	IOctetstringValue getData();
}
