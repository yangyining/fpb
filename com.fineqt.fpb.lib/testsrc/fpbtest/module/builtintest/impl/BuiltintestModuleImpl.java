package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.meta.user.PUserModuleExtBase;
import com.fineqt.fpb.lib.type.PTypeExt;

import fpbtest.module.builtintest.BuiltintestModule;

public class BuiltintestModuleImpl extends PUserModuleExtBase implements BuiltintestModule {
	
	@Override
	public PTypeExt getCase1() {
		return pPType(CASE1);
	}

	@Override
	public PTypeExt getCase2() {
		return pPType(CASE2);
	}

	@Override
	public PTypeExt getCase3() {
		return pPType(CASE3);
	}

	@Override
	public PTypeExt getCaseRecord() {
		return pPType(CASE_RECORD);
	}

	@Override
	public PTypeExt getDataLengthHyp() {
		return pPType(DATA_LENGTH_HYP);
	}

	@Override
	public PTypeExt getEnumRefRecord() {
		return pPType(ENUM_REF_RECORD);
	}

	@Override
	public PTypeExt getFieldName() {
		return pPType(FIELD_NAME);
	}

	@Override
	public PTypeExt getLEndianRecord() {
		return pPType(LENDIAN_RECORD);
	}

	@Override
	public PTypeExt getPayload1() {
		return pPType(PAYLOAD1);
	}

	@Override
	public PTypeExt getProtocol1() {
		return pPType(PROTOCOL1);
	}

	@Override
	public PTypeExt getProtocol2() {
		return pPType(PROTOCOL2);
	}

	@Override
	public PTypeExt getProtocol3() {
		return pPType(PROTOCOL3);
	}

	@Override
	public PTypeExt getSetBlock1() {
		return pPType(SET_BLOCK1);
	}

	@Override
	public PTypeExt getStringBlock() {
		return pPType(STRING_BLOCK);
	}

	@Override
	public PTypeExt getStringMultiLineFix() {
		return pPType(STRING_MULTI_LINE_FIX);
	}

	@Override
	public PTypeExt getStringMultiLineVar() {
		return pPType(STRING_MULTI_LINE_VAR);
	}

	@Override
	public PTypeExt getStringOneLine() {
		return pPType(STRING_ONE_LINE);
	}

	@Override
	public PTypeExt getStringToken() {
		return pPType(STRING_TOKEN);
	}

	@Override
	public PTypeExt getStringWS() {
		return pPType(STRING_WS);
	}

	@Override
	public PTypeExt getUint16() {
		return pPType(UINT16);
	}

	@Override
	public PTypeExt getUint16List() {
		return pPType(UINT16_LIST);
	}

	@Override
	public PTypeExt getUint16Set() {
		return pPType(UINT16_SET);
	}

	@Override
	public PTypeExt getUint4() {
		return pPType(UINT4);
	}

	@Override
	public PTypeExt getUint8() {
		return pPType(UINT8);
	}

	@Override
	public PTypeExt getUnionBlock1() {
		return pPType(UNION_BLOCK1);
	}

	@Override
	public PTypeExt getUnionBlock2() {
		return pPType(UNION_BLOCK2);
	}

}
