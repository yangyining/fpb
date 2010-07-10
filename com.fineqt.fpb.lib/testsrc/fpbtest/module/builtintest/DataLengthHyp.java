package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.api.value.IBitstringValue;
import com.fineqt.fpb.lib.api.value.IBooleanValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;

public interface DataLengthHyp extends IRecordSetValue {
	IIntegerValue getTotalLength();
	IIntegerValue getData1Length();
	IBooleanValue getData2Flag();
	IBitstringValue getData1();
	IBitstringValue getPad();
	IOctetstringValue getData2();
	IOctetstringValue getData3();
}
