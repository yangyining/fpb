package fpbtest.module.builtintest.impl;

import java.security.InvalidParameterException;

import com.fineqt.fpb.lib.api.value.IEnumeratedValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.meta.user.PUserFactoryExtBase;
import com.fineqt.fpb.lib.type.PTypeExt;

import fpbtest.module.builtintest.BuiltintestFactory;
import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.CaseRecord;
import fpbtest.module.builtintest.DataLengthHyp;
import fpbtest.module.builtintest.EnumRefRecord;
import fpbtest.module.builtintest.LEndianRecord;
import fpbtest.module.builtintest.Payload1;
import fpbtest.module.builtintest.Protocol1;
import fpbtest.module.builtintest.Protocol2;
import fpbtest.module.builtintest.Protocol3;
import fpbtest.module.builtintest.SetBlock1;
import fpbtest.module.builtintest.StringBlock;
import fpbtest.module.builtintest.StringOneLine;
import fpbtest.module.builtintest.UnionBlock1;

public class BuiltintestFactoryImpl extends PUserFactoryExtBase implements BuiltintestFactory {
	protected IValue doCreate(PTypeExt type, ValueMode mode) {
		if (type.getPModule() != getPModule()) {
			throw new InvalidParameterException("Different module");
		}
		return doCreate(type.getID(), mode);
	}

	protected IValue doCreate(int typeID, ValueMode mode) {
		switch(typeID) {
		case BuiltintestModule.UINT4:
			return doCreateUINT4(mode);
		case BuiltintestModule.UINT8:
			return doCreateUINT8(mode);
		case BuiltintestModule.UINT16:
			return doCreateUINT16(mode);
		case BuiltintestModule.STRING_TOKEN:
			return doCreateStringToken(mode);
		case BuiltintestModule.STRING_WS:
			return doCreateStringWS(mode);
		case BuiltintestModule.STRING_ONE_LINE:
			return doCreateStringOneLine(mode);
		case BuiltintestModule.STRING_MULTI_LINE_FIX:
			return doCreateStringMultiLineFix(mode);
		case BuiltintestModule.STRING_MULTI_LINE_VAR:
			return doCreateStringMultiLineVar(mode);
		case BuiltintestModule.DATA_LENGTH_HYP:
			return doCreateDataLengthHyp(mode);
		case BuiltintestModule.STRING_BLOCK:
			return doCreateStringBlock(mode);
		case BuiltintestModule.CASE_RECORD:
			return doCreateCaseRecord(mode);
		case BuiltintestModule.UNION_BLOCK1:
			return doCreateUnionBlock1(mode);
		case BuiltintestModule.CASE1:
			return doCreateCase1(mode);
		case BuiltintestModule.CASE2:
			return doCreateCase2(mode);
		case BuiltintestModule.CASE3:
			return doCreateCase3(mode);
		case BuiltintestModule.UNION_BLOCK2:
			return doCreateUnionBlock2(mode);
		case BuiltintestModule.SET_BLOCK1:
			return doCreateSetBlock1(mode);
		case BuiltintestModule.PROTOCOL1:
			return doCreateProtocol1(mode);
		case BuiltintestModule.PAYLOAD1:
			return doCreatePayload1(mode);
		case BuiltintestModule.PROTOCOL2:
			return doCreateProtocol2(mode);
		case BuiltintestModule.PROTOCOL3:
			return doCreateProtocol3(mode);
		case BuiltintestModule.LENDIAN_RECORD:
			return doCreateLEndianRecord(mode);
		case BuiltintestModule.FIELD_NAME:
			return doCreateFieldName(mode);
		case BuiltintestModule.ENUM_REF_RECORD:
			return doCreateEnumRefRecord(mode);
		case BuiltintestModule.UINT16_LIST:
			return doCreateUint16List(mode);
		case BuiltintestModule.UINT16_SET:
			return doCreateUint16Set(mode);
		}
		return createBuiltin(typeID, mode);
	}
	
	@Override
	public PIntegerValue createUINT16() {
		return doCreateUINT16(ValueMode.DEFAULT);
	}

	protected PIntegerValue doCreateUINT16(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (PIntegerValue)createObjByMode(mode, module.getUint16());
	}
	
	@Override
	public PIntegerValue createUINT4() {
		return doCreateUINT4(ValueMode.DEFAULT);
	}

	protected PIntegerValue doCreateUINT4(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (PIntegerValue)createObjByMode(mode, module.getUint4());
	}
	
	@Override
	public PIntegerValue createUINT8() {
		return doCreateUINT8(ValueMode.DEFAULT);
	}

	protected PIntegerValue doCreateUINT8(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (PIntegerValue)createObjByMode(mode, module.getUint8());
	}
	
	@Override
	public IListValue<StringOneLine> createStringMultiLineFix() {
		return doCreateStringMultiLineFix(ValueMode.DEFAULT);
	}

	@SuppressWarnings("unchecked")
	protected IListValue<StringOneLine> doCreateStringMultiLineFix(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (IListValue<StringOneLine>)createObjByMode(mode, module.getStringMultiLineFix());
	}
	
	@Override
	public IListValue<StringOneLine> createStringMultiLineVar() {
		return doCreateStringMultiLineVar(ValueMode.DEFAULT);
	}

	@SuppressWarnings("unchecked")
	protected IListValue<StringOneLine> doCreateStringMultiLineVar(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (IListValue<StringOneLine>)createObjByMode(mode, module.getStringMultiLineVar());
	}
	
	@Override
	public StringOneLine createStringOneLine() {
		return doCreateStringOneLine(ValueMode.DEFAULT);
	}

	protected StringOneLine doCreateStringOneLine(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (StringOneLine)createObjByMode(mode, module.getStringOneLine());
	}
	
	@Override
	public PCharstringValue createStringToken() {
		return doCreateStringToken(ValueMode.DEFAULT);
	}

	protected PCharstringValue doCreateStringToken(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (PCharstringValue)createObjByMode(mode, module.getStringToken());
	}
	
	@Override
	public PCharstringValue createStringWS() {
		return doCreateStringWS(ValueMode.DEFAULT);
	}
	
	protected PCharstringValue doCreateStringWS(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (PCharstringValue)createObjByMode(mode, module.getStringWS());
	}
	
	@Override
	public DataLengthHyp createDataLengthHyp() {
		return doCreateDataLengthHyp(ValueMode.DEFAULT);
	}

	protected DataLengthHyp doCreateDataLengthHyp(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (DataLengthHyp)createObjByMode(mode, module.getDataLengthHyp());
	}
	
	@Override
	public CaseRecord createCase1() {
		return doCreateCase1(ValueMode.DEFAULT);
	}

	protected CaseRecord doCreateCase1(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (CaseRecord)createObjByMode(mode, module.getCase1());
	}
	
	@Override
	public CaseRecord createCase2() {
		return doCreateCase2(ValueMode.DEFAULT);
	}

	protected CaseRecord doCreateCase2(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (CaseRecord)createObjByMode(mode, module.getCase2());
	}
	
	@Override
	public CaseRecord createCase3() {
		return doCreateCase3(ValueMode.DEFAULT);
	}

	protected CaseRecord doCreateCase3(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (CaseRecord)createObjByMode(mode, module.getCase3());
	}
	
	@Override
	public CaseRecord createCaseRecord() {
		return doCreateCaseRecord(ValueMode.DEFAULT);
	}

	protected CaseRecord doCreateCaseRecord(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (CaseRecord)createObjByMode(mode, module.getCaseRecord());
	}
	
	@Override
	public SetBlock1 createSetBlock1() {
		return doCreateSetBlock1(ValueMode.DEFAULT);
	}

	protected SetBlock1 doCreateSetBlock1(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (SetBlock1)createObjByMode(mode, module.getSetBlock1());
	}
	
	@Override
	public StringBlock createStringBlock() {
		return doCreateStringBlock(ValueMode.DEFAULT);
	}

	protected StringBlock doCreateStringBlock(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (StringBlock)createObjByMode(mode, module.getStringBlock());
	}
	
	@Override
	public UnionBlock1 createUnionBlock1() {
		return doCreateUnionBlock1(ValueMode.DEFAULT);
	}

	protected UnionBlock1 doCreateUnionBlock1(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (UnionBlock1)createObjByMode(mode, module.getUnionBlock1());
	}
	
	@Override
	public UnionBlock1 createUnionBlock2() {
		return doCreateUnionBlock2(ValueMode.DEFAULT);
	}

	protected UnionBlock1 doCreateUnionBlock2(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (UnionBlock1)createObjByMode(mode, module.getUnionBlock2());
	}

	@Override
	public Payload1 createPayload1() {
		return doCreatePayload1(ValueMode.DEFAULT);
	}

	protected Payload1 doCreatePayload1(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (Payload1)createObjByMode(mode, module.getPayload1());
	}
	
	@Override
	public Protocol1 createProtocol1() {
		return doCreateProtocol1(ValueMode.DEFAULT);
	}

	protected Protocol1 doCreateProtocol1(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (Protocol1)createObjByMode(mode, module.getProtocol1());
	}

	@Override
	public Protocol2 createProtocol2() {
		return doCreateProtocol2(ValueMode.DEFAULT);
	}

	protected Protocol2 doCreateProtocol2(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (Protocol2)createObjByMode(mode, module.getProtocol2());
	}

	@Override
	public Protocol3 createProtocol3() {
		return doCreateProtocol3(ValueMode.DEFAULT);
	}

	protected Protocol3 doCreateProtocol3(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (Protocol3)createObjByMode(mode, module.getProtocol3());
	}

	@Override
	public LEndianRecord createLEndianRecord() {
		return doCreateLEndianRecord(ValueMode.DEFAULT);
	}

	public LEndianRecord doCreateLEndianRecord(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (LEndianRecord)createObjByMode(mode, module.getLEndianRecord());
	}

	@Override
	public EnumRefRecord createEnumRefRecord() {
		return doCreateEnumRefRecord(ValueMode.DEFAULT);
	}

	public EnumRefRecord doCreateEnumRefRecord(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (EnumRefRecord)createObjByMode(mode, module.getEnumRefRecord());
	}
	
	@Override
	public IEnumeratedValue createFieldName() {
		return doCreateFieldName(ValueMode.DEFAULT);
	}
	
	public IEnumeratedValue doCreateFieldName(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (IEnumeratedValue)createObjByMode(mode, module.getFieldName());
	}

	@Override
	public IListValue<IIntegerValue> createUint16List() {
		return doCreateUint16List(ValueMode.DEFAULT);
	}

	@SuppressWarnings("unchecked")
	protected IListValue<IIntegerValue> doCreateUint16List(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (IListValue<IIntegerValue>)createObjByMode(mode, module.getUint16List());
	}

	@Override
	public IListValue<IIntegerValue> createUint16Set() {
		return doCreateUint16Set(ValueMode.DEFAULT);
	}

	@SuppressWarnings("unchecked")
	protected IListValue<IIntegerValue> doCreateUint16Set(ValueMode mode) {
		BuiltintestModule module = (BuiltintestModule)pmodule;
		return (IListValue<IIntegerValue>)createObjByMode(mode, module.getUint16Set());
	}
	
}
