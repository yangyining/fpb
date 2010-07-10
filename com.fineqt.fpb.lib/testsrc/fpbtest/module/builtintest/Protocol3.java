package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;

public interface Protocol3 extends IRecordSetValue {
	IIntegerValue getPrefix();
	IOctetstringValue getData();
}
