package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.api.value.IEnumeratedValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;

public interface EnumRefRecord extends IRecordSetValue {
	IEnumeratedValue getFieldName();
	IIntegerValue getField1();
	IIntegerValue getField2();
}
