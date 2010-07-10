package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;

public interface Protocol1 extends IRecordSetValue {
	IIntegerValue getPrefix();
	IIntegerValue getPrtlcode();
	Payload1 getPayload();
}
