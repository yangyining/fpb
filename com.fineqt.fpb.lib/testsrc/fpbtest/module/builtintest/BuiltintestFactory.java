package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.api.value.ICharstringValue;
import com.fineqt.fpb.lib.api.value.IEnumeratedValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.builtin.BuiltinFactory;
import com.fineqt.fpb.lib.meta.PModuleExt;

public interface BuiltintestFactory extends BuiltinFactory {
	BuiltintestFactory INSTANCE = (BuiltintestFactory)PModuleExt.Registry.PINSTANCE.resolvePFactory(
			BuiltintestModule.MODULE_NAME);
	
	IIntegerValue createUINT4();
	
	IIntegerValue createUINT8();

	IIntegerValue createUINT16();

	ICharstringValue createStringToken();
	
	ICharstringValue createStringWS();
	
	StringOneLine createStringOneLine();
	
	IListValue<StringOneLine> createStringMultiLineFix();
	
	IListValue<StringOneLine> createStringMultiLineVar();
	
	DataLengthHyp createDataLengthHyp();
	
	StringBlock createStringBlock();
	
	CaseRecord createCaseRecord();
	
	UnionBlock1 createUnionBlock1();
	
	CaseRecord createCase1();
	
	CaseRecord createCase2();
	
	CaseRecord createCase3();
	
	UnionBlock1 createUnionBlock2();
	
	SetBlock1 createSetBlock1();
	
	Protocol1 createProtocol1();
	
	Payload1 createPayload1();
	
	Protocol2 createProtocol2();
	
	Protocol3 createProtocol3();
	
	LEndianRecord createLEndianRecord();
	
	IEnumeratedValue createFieldName();
	
	EnumRefRecord createEnumRefRecord();
	
	IListValue<IIntegerValue> createUint16List();
	
	IListValue<IIntegerValue> createUint16Set();
	
}
