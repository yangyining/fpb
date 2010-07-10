package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;

public interface StringBlock extends IRecordSetValue {
	StringOneLine getLines1Count();
	IListValue<StringOneLine> getFirst3line();
	IListValue<StringOneLine> getLines1();
	IListValue<StringOneLine> getLines2();
}
