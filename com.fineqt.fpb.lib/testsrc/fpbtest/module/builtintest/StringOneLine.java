package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.api.value.ICharstringValue;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;

public interface StringOneLine extends IRecordSetValue {
	ICharstringValue getToken1();
	ICharstringValue getWs1();
	ICharstringValue getToken2();
	IOctetstringValue getCrlf();
}
