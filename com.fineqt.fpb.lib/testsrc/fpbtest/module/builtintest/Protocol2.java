package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;

public interface Protocol2 extends IRecordSetValue {
	IIntegerValue getData();
}
