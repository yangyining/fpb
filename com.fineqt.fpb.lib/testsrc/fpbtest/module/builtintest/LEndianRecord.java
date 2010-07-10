package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.api.value.IBitstringValue;
import com.fineqt.fpb.lib.api.value.IBooleanValue;
import com.fineqt.fpb.lib.api.value.IHexstringValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;

public interface LEndianRecord extends IRecordSetValue {
	IIntegerValue getInt1();
	IBooleanValue getFlag();
	IBitstringValue getBits();
	IIntegerValue getInt2();
	IIntegerValue getInt3();
	IHexstringValue getHexs();
}
