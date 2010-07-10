package fpbtest.module.compacttest;

import com.fineqt.fpb.lib.builtin.BuiltinModule;

public interface CompacttestModule extends BuiltinModule {
	
	String MODULE_NAME = "compacttest";
	
//	int UINT4 = MAX_BUILTIN_TYPE + 1;
//
//	int UINT8 = MAX_BUILTIN_TYPE + 2;
//
//	int UINT16 = MAX_BUILTIN_TYPE + 3;
//	
//	int STRING_TOKEN = MAX_BUILTIN_TYPE + 4;
//	
//	int STRING_WS = MAX_BUILTIN_TYPE + 5;
//	
//	int STRING_ONE_LINE = MAX_BUILTIN_TYPE + 6;
//	
//	int STRING_ONE_LINE__TOKEN1 = 0;
//	
//	int STRING_ONE_LINE__WS1 = 1;
//	
//	int STRING_ONE_LINE__TOKEN2 = 2;
//
//	int STRING_MULTI_LINE_FIX = MAX_BUILTIN_TYPE + 7;
//	
//	int STRING_MULTI_LINE_VAR = MAX_BUILTIN_TYPE + 8;
//
//	int DATA_LENGTH_HYP = MAX_BUILTIN_TYPE + 9;
//
//	int DATA_LENGTH_HYP__TOTAL_LENGTH = 0;
//	
//	int DATA_LENGTH_HYP__DATA1_LENGTH = 1;
//	
//	int DATA_LENGTH_HYP__DATA2_FLAG = 2;
//	
//	int DATA_LENGTH_HYP__DATA1 = 3;
//	
//	int DATA_LENGTH_HYP__PAD = 4;
//	
//	int DATA_LENGTH_HYP__DATA2 = 5;
//	
//	int DATA_LENGTH_HYP__DATA3 = 6;
//	
//	int STRING_BLOCK = MAX_BUILTIN_TYPE + 10;
//	
//	int STRING_BLOCK__LINES1_COUNT = 0;
//	
//	int STRING_BLOCK__FIRST3_LINE = 1;
//	
//	int STRING_BLOCK__LINES1 = 2;
//	
//	int STRING_BLOCK__LINES2 = 3;
//	
//	int UNION_BLOCK1 = MAX_BUILTIN_TYPE + 11;
//	
//	int UNION_BLOCK1__CASE1 = 0;
//	
//	int UNION_BLOCK1__CASE2 = 1;
//	
//	int UNION_BLOCK1__CASE3 = 2;
//	
//	int CASE1 = MAX_BUILTIN_TYPE + 12;
//	
//	int CASE1__CODE = 0;
//	
//	int CASE1__DATA = 1;
//	
//	int CASE2 = MAX_BUILTIN_TYPE + 13;
//	
//	int CASE2__CODE = 0;
//	
//	int CASE2__DATA = 1;
//	
//	int CASE3 = MAX_BUILTIN_TYPE + 14;
//	
//	int CASE3__CODE = 0;
//	
//	int CASE3__DATA = 1;
//	
//	int UNION_BLOCK2 = MAX_BUILTIN_TYPE + 15;
//	
//	int UNION_BLOCK2__CASE1 = 0;
//	
//	int UNION_BLOCK2__CASE2 = 1;
//	
//	int UNION_BLOCK2__CASE3 = 2;
//	
//	int SET_BLOCK1 = MAX_BUILTIN_TYPE + 16;
//	
//	int SET_BLOCK1__CASE1 = 0;
//	
//	int SET_BLOCK1__CASE2 = 1;
//
//	int CASE_RECORD = MAX_BUILTIN_TYPE + 17;
//	
//	int CASE_RECORD__CODE = 0;
//	
//	int CASE_RECORD__DATA = 1;
	
	
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
		
		String CASE_RECORD = "CaseRecord";
		
		String CASE_RECORD__CODE = "code";
		
		String CASE_RECORD__DATA = "data";
		
	}	
}
