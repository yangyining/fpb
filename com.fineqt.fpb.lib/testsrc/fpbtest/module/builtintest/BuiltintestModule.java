package fpbtest.module.builtintest;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.type.PTypeExt;

public interface BuiltintestModule extends PModuleExt {
	BuiltintestModule INSTANCE = (BuiltintestModule)PModuleExt.Registry.PINSTANCE.resolvePModule(
			"builtintest");
	
	String MODULE_NAME = "builtintest";
	
	int UINT4 = MAX_BUILTIN_TYPE + 1;

	int UINT8 = MAX_BUILTIN_TYPE + 2;

	int UINT16 = MAX_BUILTIN_TYPE + 3;
	
	int STRING_TOKEN = MAX_BUILTIN_TYPE + 4;
	
	int STRING_WS = MAX_BUILTIN_TYPE + 5;
	
	int STRING_ONE_LINE = MAX_BUILTIN_TYPE + 6;
	
	int STRING_ONE_LINE__TOKEN1 = 0;
	
	int STRING_ONE_LINE__WS1 = 1;
	
	int STRING_ONE_LINE__TOKEN2 = 2;
	
    int STRING_ONE_LINE__CRLF = 3;

	int STRING_MULTI_LINE_FIX = MAX_BUILTIN_TYPE + 7;
	
	int STRING_MULTI_LINE_VAR = MAX_BUILTIN_TYPE + 8;

	int DATA_LENGTH_HYP = MAX_BUILTIN_TYPE + 9;

	int DATA_LENGTH_HYP__TOTAL_LENGTH = 0;
	
	int DATA_LENGTH_HYP__DATA1_LENGTH = 1;
	
	int DATA_LENGTH_HYP__DATA2_FLAG = 2;
	
	int DATA_LENGTH_HYP__DATA1 = 3;
	
	int DATA_LENGTH_HYP__PAD = 4;
	
	int DATA_LENGTH_HYP__DATA2 = 5;
	
	int DATA_LENGTH_HYP__DATA3 = 6;
	
	int STRING_BLOCK = MAX_BUILTIN_TYPE + 10;
	
	int STRING_BLOCK__LINES1_COUNT = 0;
	
	int STRING_BLOCK__FIRST3_LINE = 1;
	
	int STRING_BLOCK__LINES1 = 2;
	
	int STRING_BLOCK__LINES2 = 3;
	
	int UNION_BLOCK1 = MAX_BUILTIN_TYPE + 11;
	
	int UNION_BLOCK1__CASE1 = 0;
	
	int UNION_BLOCK1__CASE2 = 1;
	
	int UNION_BLOCK1__CASE3 = 2;
	
	int CASE1 = MAX_BUILTIN_TYPE + 12;
	
	int CASE1__CODE = 0;
	
	int CASE1__DATA = 1;
	
	int CASE2 = MAX_BUILTIN_TYPE + 13;
	
	int CASE2__CODE = 0;
	
	int CASE2__DATA = 1;
	
	int CASE3 = MAX_BUILTIN_TYPE + 14;
	
	int CASE3__CODE = 0;
	
	int CASE3__DATA = 1;
	
	int UNION_BLOCK2 = MAX_BUILTIN_TYPE + 15;
	
	int UNION_BLOCK2__CASE1 = 0;
	
	int UNION_BLOCK2__CASE2 = 1;
	
	int UNION_BLOCK2__CASE3 = 2;
	
	int SET_BLOCK1 = MAX_BUILTIN_TYPE + 16;
	
	int SET_BLOCK1__CASE1 = 0;
	
	int SET_BLOCK1__CASE2 = 1;
	
	int PROTOCOL1 = MAX_BUILTIN_TYPE + 17;
	
	int PROTOCOL1__PREFIX = 0;
	
	int PROTOCOL1__PRTLCODE = 1;
	
	int PROTOCOL1__PAYLOAD = 2;
	
	int PAYLOAD1 = MAX_BUILTIN_TYPE + 18;
	
	int PAYLOAD1__PRTL2 = 0;
	
	int PAYLOAD1__PRTL3 = 1;
	
	int PAYLOAD1__DATA = 2;
	
	int PROTOCOL2 = MAX_BUILTIN_TYPE + 19;
	
	int PROTOCOL2__DATA = 0;
	
	int PROTOCOL3 = MAX_BUILTIN_TYPE + 20;
	
	int PROTOCOL3__PREFIX = 0;
	
	int PROTOCOL3__DATA = 1;
	
	int LENDIAN_RECORD = MAX_BUILTIN_TYPE + 21;
	
	int LENDIAN_RECORD__INT1 = 0;
	
	int LENDIAN_RECORD__FLAG = 1;
	
	int LENDIAN_RECORD__BITS = 2;
	
	int LENDIAN_RECORD__INT2 = 3;
	
	int LENDIAN_RECORD__INT3 = 4;
	
	int LENDIAN_RECORD__HEXS = 5;
	
	int CASE_RECORD = MAX_BUILTIN_TYPE + 22;
	
	int CASE_RECORD__CODE = 0;
	
	int CASE_RECORD__DATA = 1;
	
	int FIELD_NAME = MAX_BUILTIN_TYPE + 23;
	
	int FIELD_NAME__FIELD1 = 0;
	
	int FIELD_NAME__FIELD2 = 1;
	
	int ENUM_REF_RECORD = MAX_BUILTIN_TYPE + 24;
	
	int ENUM_REF_RECORD__FIELD_NAME = 0;
	
	int ENUM_REF_RECORD__FIELD1 = 1;
	
	int ENUM_REF_RECORD__FIELD2 = 2;
	
	int UINT16_LIST = MAX_BUILTIN_TYPE + 25;
	
	int UINT16_SET = MAX_BUILTIN_TYPE + 26;
	
	interface Names extends BuiltinNames {
		String UINT4 = "UINT4";

		String UINT8 = "UINT8";

		String UINT16 = "UINT16";
		
		String STRING_TOKEN = "StringToken";
		
		String STRING_WS = "StringWS";
		
		String STRING_ONE_LINE = "StringOneLine";
		
		String STRING_ONE_LINE__TOKEN1 = "token1";
		
		String STRING_ONE_LINE__WS1 = "ws1";
		
		String STRING_ONE_LINE__TOKEN2 = "token2";

		String STRING_MULTI_LINE_FIX = "StringMultiLineFix";
		
		String STRING_MULTI_LINE_VAR = "StringMultiLineVar";

		String DATA_LENGTH_HYP = "DataLengthHyp";

		String DATA_LENGTH_HYP__TOTAL_LENGTH = "totalLength";
		
		String DATA_LENGTH_HYP__DATA1_LENGTH = "data1Length";
		
		String DATA_LENGTH_HYP__DATA2_FLAG = "data2Flag";
		
		String DATA_LENGTH_HYP__DATA1 = "data1";
		
		String DATA_LENGTH_HYP__PAD = "pad";
		
		String DATA_LENGTH_HYP__DATA2 = "data2";
		
		String DATA_LENGTH_HYP__DATA3 = "data3";
		
		String STRING_BLOCK = "StringBlock";
		
		String STRING_BLOCK__LINES1_COUNT = "lines1Count";
		
		String STRING_BLOCK__FIRST3_LINE = "first3Line";
		
		String STRING_BLOCK__LINES1 = "lines1";
		
		String STRING_BLOCK__LINES2 = "lines2";
		
		String UNION_BLOCK1 = "UnionBlock1";
		
		String UNION_BLOCK1__CASE1 = "case1";
		
		String UNION_BLOCK1__CASE2 = "case2";
		
		String UNION_BLOCK1__CASE3 = "case3";
		
		String CASE1 = "Case1";
		
		String CASE1__CODE = "code";
		
		String CASE1__DATA = "data";
		
		String CASE2 = "Case2";
		
		String CASE2__CODE = "code";
		
		String CASE2__DATA = "data";
		
		String CASE3 = "Case3";
		
		String CASE3__CODE = "code";
		
		String CASE3__DATA = "data";
		
		String UNION_BLOCK2 = "UnionBlock2";
		
		String UNION_BLOCK2__CASE1 = "case1";
		
		String UNION_BLOCK2__CASE2 = "case2";
		
		String UNION_BLOCK2__CASE3 = "case3";
		
		String SET_BLOCK1 = "SetBlock1";
		
		String SET_BLOCK1__CASE1 = "case1";
		
		String SET_BLOCK1__CASE2 = "case2";
		
		String PROTOCOL1 = "Protocol1";
		
		String PROTOCOL1__PREFIX = "prefix";
		
		String PROTOCOL1__PRTLCODE = "prtlcode";
		
		String PROTOCOL1__PAYLOAD = "payload";
		
		String PAYLOAD1 = "Payload1";
		
		String PAYLOAD1__PRTL2 = "prtl2";
		
		String PAYLOAD1__PRTL3 = "prtl3";
		
		String PAYLOAD1__DATA = "data";
		
		String PROTOCOL2 = "Protocol2";
		
		String PROTOCOL2__DATA = "data";
		
		String PROTOCOL3 = "Protocol3";
		
		String PROTOCOL3__PREFIX = "prefix";
		
		String PROTOCOL3__DATA = "data";
		
		String LENDIAN_RECORD = "LEndianRecord";
		
		String LENDIAN_RECORD__INT1 = "int1";
		
		String LENDIAN_RECORD__FLAG = "flag";
		
		String LENDIAN_RECORD__BITS = "bits";
		
		String LENDIAN_RECORD__INT2 = "int2";
		
		String LENDIAN_RECORD__INT3 = "int3";
		
		String LENDIAN_RECORD__HEXS = "hexs";
		
		String CASE_RECORD = "CaseRecord";
		
		String CASE_RECORD__CODE = "code";
		
		String CASE_RECORD__DATA = "data";
		
		String FIELD_NAME = "FieldName";
		
		String FIELD_NAME__FIELD1 = "FIELD1";
		
		String FIELD_NAME__FIELD2 = "FIELD2";
		
		String ENUM_REF_RECORD = "EnumRefRecord";
		
		String ENUM_REF_RECORD__FIELD_NAME = "fieldName";
		
		String ENUM_REF_RECORD__FIELD1 = "field1";
		
		String ENUM_REF_RECORD__FIELD2 = "field2";
		
		String UINT16_LIST = "UINT16List";
		
		String UINT16_SET = "UINT16Set";
		
	}
	
	PTypeExt getUint4();
	
	PTypeExt getUint8();
	
	PTypeExt getUint16();
	
	PTypeExt getStringToken();
	
	PTypeExt getStringWS();
	
	PTypeExt getStringOneLine();
	
	PTypeExt getStringMultiLineFix();
	
	PTypeExt getStringMultiLineVar();
	
	PTypeExt getDataLengthHyp();
	
	PTypeExt getStringBlock();
	
	PTypeExt getCaseRecord();
	
	PTypeExt getUnionBlock1();
	
	PTypeExt getCase1();
	
	PTypeExt getCase2();
	
	PTypeExt getCase3();
	
	PTypeExt getUnionBlock2();
	
	PTypeExt getSetBlock1();
	
	PTypeExt getProtocol1();
	
	PTypeExt getPayload1();
	
	PTypeExt getProtocol2();
	
	PTypeExt getProtocol3();
	
	PTypeExt getLEndianRecord();
	
	PTypeExt getFieldName();
	
	PTypeExt getEnumRefRecord();
	
	PTypeExt getUint16List();
	
	PTypeExt getUint16Set();
}
