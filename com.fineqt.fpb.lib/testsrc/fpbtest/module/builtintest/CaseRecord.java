package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;

public interface CaseRecord extends IRecordSetValue {
	IIntegerValue getCode();
	IIntegerValue getData();
}
