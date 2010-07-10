package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.api.value.IUnionValue;

public interface UnionBlock1 extends IUnionValue {
	CaseRecord getCase1();
	CaseRecord getCase2();
	CaseRecord getCase3();
}
