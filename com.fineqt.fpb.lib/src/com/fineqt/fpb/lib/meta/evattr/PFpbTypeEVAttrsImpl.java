/****************************************************************
Fine Packet Builder, copyright (C) 2007-2009 fineqt.com

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
GNU General Public License for more details at gnu.org.
******************************************************************/
package com.fineqt.fpb.lib.meta.evattr;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.builtin.PBitstringValue;
import com.fineqt.fpb.lib.builtin.PBooleanValue;
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.builtin.PStringValue;
import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.property.PArgumentExt;
import com.fineqt.fpb.lib.meta.property.PArgumentGroupExt;
import com.fineqt.fpb.lib.meta.property.PIdentifierArgumentExt;
import com.fineqt.fpb.lib.meta.property.PListArgumentExt;
import com.fineqt.fpb.lib.meta.property.PPropertyExt;
import com.fineqt.fpb.lib.meta.property.PPropertyListExt;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.OnelineMode;
import com.fineqt.fpb.lib.model.fpbmodule.PadType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeExt;

public class PFpbTypeEVAttrsImpl extends PFpbEVAttrsBase
implements PFpbTypeEVAttrs {
	private static int BYTE_ORDER = 0;
	private static int CASE_DEFAULT = 1;
	private static int CASE_REF = 2;
	private static int LENGTH = 3;
	private static int LENGTH_INCREMENT = 4;
	private static int LENGTH_MULTIPLIER = 5;
	private static int LENGTH_REF = 6;
	private static int ONE_LINE_MODE = 7;
	private static int PAD_TYPE = 8;
	private static int PAD_VALUE = 9;
	private static int PUSH_EMPTY_FIELD = 10;
	private static int REPEAT_REF = 11;
	private static int SELECT_COND = 12;
	private static int SELECT_REF = 13;
	private static int SELECT_REF_REGION = 14;
	private static int PROTOCOL = 15;
	private static int REFRESH_LENGTH_REF = 16;
	private static int REFRESH_REPEAT_REF = 17;
	private static int CASE_REF_REGION = 18;
	private static int SIGNED = 19;
	private static int FORMAT = 20;
	private static int REST_OF_DATA = 21;
	private static int MAX_ID = REST_OF_DATA;

	public static String BYTE_ORDER_NAME = "ByteOrder";
	private static String CASE_DEFAULT_NAME = "CaseDefault";
	private static String CASE_REF_NAME = "CaseRef";
	private static String LENGTH_NAME = "Length";
	private static String LENGTH_INCREMENT_NAME = "LengthIncrement";
	private static String LENGTH_MULTIPLIER_NAME = "LengthMultiplier";
	private static String LENGTH_REF_NAME = "LengthRef";
	private static String ONE_LINE_MODE_NAME = "OneLineMode";
	private static String PAD_TYPE_NAME = "PadType";
	private static String PAD_VALUE_NAME = "PadValue";
	private static String PUSH_EMPTY_FIELD_NAME = "PushEmptyField";
	private static String REPEAT_REF_NAME = "RepeatRef";
	private static String SELECT_COND_NAME = "SelectCond";
	private static String SELECT_REF_NAME = "SelectRef";
	private static String SELECT_REF_REGION_NAME = "SelectRefRegion";
	private static String PROTOCOL_NAME = "Protocol";
	private static String REFRESH_LENGTH_REF_NAME = "RefreshLengthRef";
	private static String REFRESH_REPEAT_REF_NAME = "RefreshRepeatRef";
	private static String CASE_REF_REGION_NAME = "CaseRefRegion";
	private static String SIGNED_NAME = "Signed";
	private static String FORMAT_NAME = "Format";
	private static String REST_OF_DATA_NAME = "RestOfData";
	
	private PFpbTypeEVExt ownerEV;	
	private BitSet changedFlags = new BitSet(MAX_ID + 1);
	private ByteOrder defaultByteOrder = ByteOrder.NONE;
	private ByteOrder byteOrder;
	private PFieldExt caseDefault;
	private FieldRefDesc caseRef;
	private RegionRefDesc caseRefRegion;
	private int length;
	private int lengthIncrement;
	private int lengthMultiplier = 1;
	private FieldRefDesc lengthRef;
	private OnelineMode onelineMode = OnelineMode.NONE;
	private PadType padType = PadType.NO;
	private PStringValue padValue;
	private List<StackFieldOperation> pushEmptyField;
	private FieldRefDesc repeatRef;
	private List<PTypeConstraintExt> selectCond;
	private FieldRefDesc selectRef;
	private RegionRefDesc selectRefRegion;
	private boolean protocol;
	private boolean refreshLengthRef = true;
	private boolean refreshRepeatRef = true;
	private boolean signed;
	private DisplayFormat format;
	private boolean restOfData;
	
	public PFpbTypeEVAttrsImpl(PPropertyListExt prpList, PFpbTypeEVExt ownerEV) 
	throws InitMetaException {
		this.ownerEV = ownerEV;
		if (prpList != null) {
			parsePropertyList(prpList);
		}
	}

	@Override
	public boolean hasSettedAttr() {
		return !changedFlags.isEmpty();
	}

	@Override
	public void setDefaultByteOrder(ByteOrder byteOrder) {
		this.defaultByteOrder = byteOrder;
	}

	@Override
	public ByteOrder getDefaultByteOrder() {
		return defaultByteOrder;
	}

//    public static String BYTE_ORDER_NAME = "ByteOrder";
//    private static String CASE_DEFAULT_NAME = "CaseDefault";
//    private static String CASE_REF_NAME = "CaseRef";
//    private static String LENGTH_NAME = "Length";
//    private static String LENGTH_INCREMENT_NAME = "LengthIncrement";
//    private static String LENGTH_MULTIPLIER_NAME = "LengthMultiplier";
//    private static String LENGTH_REF_NAME = "LengthRef";
//    private static String ONE_LINE_MODE_NAME = "OneLineMode";
//    private static String PAD_TYPE_NAME = "PadType";
//    private static String PAD_VALUE_NAME = "PadValue";
//    private static String PUSH_EMPTY_FIELD_NAME = "PushEmptyField";
//    private static String REPEAT_REF_NAME = "RepeatRef";
//    private static String SELECT_COND_NAME = "SelectCond";
//    private static String SELECT_REF_NAME = "SelectRef";
//    private static String SELECT_REF_REGION_NAME = "SelectRefRegion";
//    private static String PROTOCOL_NAME = "Protocol";
//    private static String REFRESH_LENGTH_REF_NAME = "RefreshLengthRef";
//    private static String REFRESH_REPEAT_REF_NAME = "RefreshRepeatRef";
//    private static String CASE_REF_REGION_NAME = "CaseRefRegion";
//    private static String SIGNED_NAME = "Signed";
//    private static String FORMAT_NAME = "Format";
//    private static String REST_OF_DATA_NAME = "RestOfData";
	
	@Override
    public void overrideNotChangedByChanged(PFpbTypeEVAttrs srcAttrs) {
	    //使用有修改的特性来覆盖没有修改的
	    //ByteOrder
	    if (!isSetByteorder() && srcAttrs.isSetByteorder()) {
	        byteOrder = srcAttrs.getByteorder(null);
	        changedFlags.set(BYTE_ORDER);
	    }
        //CaseDefault
        if (!isSetCaseDefault() && srcAttrs.isSetCaseDefault()) {
            caseDefault = srcAttrs.getCaseDefault(null);
            changedFlags.set(CASE_DEFAULT);
        }
        //CaseRef
        if (!isSetCaseRef() && srcAttrs.isSetCaseRef()) {
            caseRef = srcAttrs.getCaseRef(null);
            changedFlags.set(CASE_REF);
        }
        //Length
        if (!isSetLength() && srcAttrs.isSetLength()) {
            length = srcAttrs.getLength(null);
            changedFlags.set(LENGTH);
        }
        //LengthIncrement
        if (!isSetLengthIncrement() && srcAttrs.isSetLengthIncrement()) {
            lengthIncrement = srcAttrs.getLengthIncrement(null);
            changedFlags.set(LENGTH_INCREMENT);
        }
        //LengthMultiplier
        if (!isSetLengthMultiplier() && srcAttrs.isSetLengthMultiplier()) {
            lengthMultiplier = srcAttrs.getLengthMultiplier(null);
            changedFlags.set(LENGTH_MULTIPLIER);
        }
        //LengthRef
        if (!isSetLengthRef() && srcAttrs.isSetLengthRef()) {
            lengthRef = srcAttrs.getLengthRef(null);
            changedFlags.set(LENGTH_REF);
        }
        //OneLineMode
        if (!isSetOnelineMode() && srcAttrs.isSetOnelineMode()) {
            onelineMode = srcAttrs.getOnelineMode(null);
            changedFlags.set(ONE_LINE_MODE);
        }
        //PadType
        if (!isSetPadType() && srcAttrs.isSetPadType()) {
            padType = srcAttrs.getPadType(null);
            changedFlags.set(PAD_TYPE);
        }
        //PadValue
        if (!isSetPadValue() && srcAttrs.isSetPadValue()) {
            padValue = srcAttrs.getPadValue(null);
            changedFlags.set(PAD_VALUE);
        }
        //PushEmptyField
        if (!isSetPushEmptyField() && srcAttrs.isSetPushEmptyField()) {
            pushEmptyField = srcAttrs.getPushEmptyField(null);
            changedFlags.set(PUSH_EMPTY_FIELD);
        }
        //RepeatRef
        if (!isSetRepeatRef() && srcAttrs.isSetRepeatRef()) {
            repeatRef = srcAttrs.getRepeatRef(null);
            changedFlags.set(REPEAT_REF);
        }
        //SelectCond
        if (!isSetSelectCond() && srcAttrs.isSetSelectCond()) {
            selectCond = srcAttrs.getSelectCond(null);
            changedFlags.set(SELECT_COND);
        }
        //SelectRef
        if (!isSetSelectRef() && srcAttrs.isSetSelectRef()) {
            selectRef = srcAttrs.getSelectRef(null);
            changedFlags.set(SELECT_REF);
        }
        //SelectRefRegion
        if (!isSetSelectRefRegion() && srcAttrs.isSetSelectRefRegion()) {
            selectRefRegion = srcAttrs.getSelectRefRegion(null);
            changedFlags.set(SELECT_REF_REGION);
        }
        //Protocol
        if (!isSetProtocol() && srcAttrs.isSetProtocol()) {
            protocol = srcAttrs.isProtocol(null);
            changedFlags.set(PROTOCOL);
        }
        //RefreshLengthRef
        if (!isSetRefreshLengthRef() && srcAttrs.isSetRefreshLengthRef()) {
            refreshLengthRef = srcAttrs.isRefreshLengthRef(null);
            changedFlags.set(REFRESH_LENGTH_REF);
        }
        //RefreshRepeatRef
        if (!isSetRefreshRepeatRef() && srcAttrs.isSetRefreshRepeatRef()) {
            refreshRepeatRef = srcAttrs.isRefreshRepeatRef(null);
            changedFlags.set(REFRESH_REPEAT_REF);
        }
        //CaseRefRegion
        if (!isSetCaseRefRegion() && srcAttrs.isSetCaseRefRegion()) {
            caseRefRegion = srcAttrs.getCaseRefRegion(null);
            changedFlags.set(CASE_REF_REGION);
        }
        //Signed
        if (!isSetSigned() && srcAttrs.isSetSigned()) {
            signed = srcAttrs.isSigned(null);
            changedFlags.set(SIGNED);
        }
        //Format
        if (!isSetFormat() && srcAttrs.isSetFormat()) {
            format = srcAttrs.getFormat(null);
            changedFlags.set(FORMAT);
        }
        //RestOfData
        if (!isSetRestOfData() && srcAttrs.isSetRestOfData()) {
            restOfData = srcAttrs.isRestOfData(null);
            changedFlags.set(REST_OF_DATA);
        }
	    
    }

    private PModuleExt getPModule() {
		return ownerEV.getOnwerTypeMeta().getPModule();
	}
	
	private void parsePropertyList(PPropertyListExt prpList) {
		//Entity Type Property
		//byteOrder
		if (!parseByteOrder(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(BYTE_ORDER_NAME), BYTE_ORDER_NAME, BYTE_ORDER_FORMAT);
		}
		//length
		if (!parseLength(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(LENGTH_NAME), LENGTH_NAME, SINGLE_INTEGER_FORMAT);
		}
		
		//lengthMultiplier
		if (!parseLengthMultiplier(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(LENGTH_MULTIPLIER_NAME), LENGTH_MULTIPLIER_NAME,
					SINGLE_INTEGER_FORMAT);
		}

		//lengthIncrement
		if (!parseLengthIncrement(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(LENGTH_INCREMENT_NAME), LENGTH_INCREMENT_NAME, 
					SINGLE_INTEGER_FORMAT);
		}
		
		//oneLineMode
		if (!parseOneLineMode(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(ONE_LINE_MODE_NAME), ONE_LINE_MODE_NAME, ONE_LINE_MODE_FORMAT);
		}
		
        //restOfData
        if (!parseRestOfData(prpList)) {
            throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
                    prpList.getProperty(REST_OF_DATA_NAME), REST_OF_DATA, 
                    SINGLE_BOOLEAN_FORMAT);
        }
        
		//refreshLengthRef
		if (!parseRefreshLengthRef(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(REFRESH_LENGTH_REF_NAME), REFRESH_LENGTH_REF_NAME, 
					SINGLE_BOOLEAN_FORMAT);
		}
		
		//signed
		if (!parseSigned(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(SIGNED_NAME), SIGNED_NAME, SINGLE_BOOLEAN_FORMAT);
		}
		
		//protocol
		if (!parseProtocol(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(PROTOCOL_NAME), PROTOCOL_NAME, SINGLE_BOOLEAN_FORMAT);
		}
		
		//pushEmptyField
		if (!parsePushEmptyField(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(PUSH_EMPTY_FIELD_NAME), PUSH_EMPTY_FIELD_NAME, TYPE_POP_FIELD_FORMAT);
		}
		//lengthRef
		if (!parseLengthRef(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(LENGTH_REF_NAME), LENGTH_REF_NAME, SINGLE_REF_FORMAT);
		}
		//selectCond(需在selectRef之前)
		if (!parseSelectCond(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(SELECT_COND_NAME), SELECT_COND_NAME, 
					SINGLE_VALUE_CONSTRAINT_FORMAT);
		}
		//selectRef
		if (!parseSelectRef(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(SELECT_REF_NAME), SELECT_REF_NAME, SINGLE_REF_FORMAT);
		}
		//selectRefRegion
		if (!parseSelectRefRegion(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(SELECT_REF_REGION_NAME), SELECT_REF_REGION_NAME, 
					SINGLE_REGION_FORMAT);
		}
		
		//Union, Set Type Property
		//caseRef
		if (!parseCaseRef(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(CASE_REF_NAME), CASE_REF_NAME, SINGLE_REF_FORMAT);
		}
		
		//caseRefRegion
		if (!parseCaseRefRegion(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(CASE_REF_REGION_NAME), CASE_REF_REGION_NAME, 
					SINGLE_REGION_FORMAT);
		}
		
		//caseDefault
		if (!parseCaseDefault(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(CASE_DEFAULT_NAME), CASE_DEFAULT_NAME);
		}

		//List Property
		//repeatRef
		if (!parseRepeatRef(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(REPEAT_REF_NAME), REPEAT_REF_NAME, SINGLE_REF_FORMAT);
		}
		//refreshRepeatRef
		if (!parseRefreshRepeatRef(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(REFRESH_REPEAT_REF_NAME), REFRESH_REPEAT_REF_NAME, 
					SINGLE_BOOLEAN_FORMAT);
		}
		
		//Bitstring Property
		//padType
		if (!parsePadType(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(PAD_TYPE_NAME), PAD_TYPE_NAME, PAD_TYPE_FORMAT);
		}
		
		//padValue
		if (!parsePadValue(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(PAD_VALUE_NAME), PAD_VALUE_NAME, SINGLE_VALUE_FORMAT);
		}
		
		//format
		if (!parseFormat(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(FORMAT_NAME), FORMAT_NAME, FORMAT_FORMAT);
		}
	}
	
	private boolean parseByteOrder(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(BYTE_ORDER_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleNoValueArgument(property, PArgumentExt.Type.IDENTIFIER);
		if (tempArg == null) {
			return false;
		}
		String name = ((PIdentifierArgumentExt)tempArg).getId();
		byteOrder = ByteOrder.get(name);
		if (byteOrder == null) {
			return false;
		}
		changedFlags.set(BYTE_ORDER);
		return true;
	}

	private boolean parseLength(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(LENGTH_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.INTEGER);
		if (tempArg == null) {
			return false;
		}
		length = ((PIntegerValue)tempArg.getValue()).getInteger();
		changedFlags.set(LENGTH);
		return true;
	}
	
	private boolean parseLengthMultiplier(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(LENGTH_MULTIPLIER_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.INTEGER);
		if (tempArg == null) {
			return false;
		}
		lengthMultiplier = ((PIntegerValue)tempArg.getValue()).getInteger();
		changedFlags.set(LENGTH_MULTIPLIER);
		return true;
	}

	private boolean parseLengthIncrement(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(LENGTH_INCREMENT_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.INTEGER);
		if (tempArg == null) {
			return false;
		}
		lengthIncrement = ((PIntegerValue)tempArg.getValue()).getInteger();
		changedFlags.set(LENGTH_INCREMENT);
		return true;
	}

	private boolean parseOneLineMode(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(ONE_LINE_MODE_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleNoValueArgument(property, PArgumentExt.Type.IDENTIFIER);
		if (tempArg == null) {
			return false;
		}
		String name = ((PIdentifierArgumentExt)tempArg).getId();
		onelineMode = OnelineMode.get(name);
		if (onelineMode == null) {
			return false;
		}
		changedFlags.set(ONE_LINE_MODE);
		return true;
	}

	private boolean parsePadType(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(PAD_TYPE_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleNoValueArgument(property, PArgumentExt.Type.IDENTIFIER);
		if (tempArg == null) {
			return false;
		}
		//padValue
		switch(ownerEV.getTargetTypeMeta().getTypeClass()) {
		case BITSTRING:
		case OCTETSTRING:
			String name = ((PIdentifierArgumentExt)tempArg).getId();
			padType = PadType.get(name);
			break;
		default:
			throw new InitMetaException(
					getPModule(), MetaException.CODE.PAD_PROPERTY_ERROR, property.getName());
		}
		if (padType == null) {
			return false;
		}
		changedFlags.set(PAD_TYPE);
		return true;
	}

	private boolean parseRestOfData(PPropertyListExt prpList) {
        PPropertyExt property = prpList.getProperty(REST_OF_DATA_NAME);
        if (property == null) {
            return true;
        }
        PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.BOOLEAN);
        if (tempArg == null) {
            return false;
        }
        restOfData = ((PBooleanValue)tempArg.getValue()).getBoolean();
        changedFlags.set(REST_OF_DATA);
        return true;
    }
	
	private boolean parseRefreshLengthRef(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(REFRESH_LENGTH_REF_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.BOOLEAN);
		if (tempArg == null) {
			return false;
		}
		refreshLengthRef = ((PBooleanValue)tempArg.getValue()).getBoolean();
		changedFlags.set(REFRESH_LENGTH_REF);
		return true;
	}
	
	private boolean parseRefreshRepeatRef(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(REFRESH_REPEAT_REF_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.BOOLEAN);
		if (tempArg == null) {
			return false;
		}
		refreshRepeatRef = ((PBooleanValue)tempArg.getValue()).getBoolean();
		changedFlags.set(REFRESH_REPEAT_REF);
		return true;
	}
	
	private boolean parseSigned(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(SIGNED_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.BOOLEAN);
		if (tempArg == null) {
			return false;
		}
		signed = ((PBooleanValue)tempArg.getValue()).getBoolean();
		changedFlags.set(SIGNED);
		return true;
	}

	private boolean parseProtocol(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(PROTOCOL_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.BOOLEAN);
		if (tempArg == null) {
			return false;
		}
		protocol = ((PBooleanValue)tempArg.getValue()).getBoolean();
		changedFlags.set(PROTOCOL);
		return true;
	}
	
	private boolean parsePadValue(PPropertyListExt prpList) throws InitMetaException {
		PPropertyExt property = prpList.getProperty(PAD_VALUE_NAME);
		if (property == null) {
			return true;
		}
		if (property.getGroups().size() != 1) {
			return false;
		}
		PArgumentGroupExt group = property.getGroups().get(0);
		if (group.getArguments().size() != 1) {
			return false;
		}
		//padValue
		switch(ownerEV.getTargetTypeMeta().getTypeClass()) {
		case BITSTRING:
			padValue = (PBitstringValue)parseSingleValue(
					property, 
					getPModule().getBitstring());
			break;
		case OCTETSTRING:
			padValue = (POctetstringValue)parseSingleValue(
					property, 
					getPModule().getOctetstring());
			break;
		default:
			throw new InitMetaException(
					getPModule(), MetaException.CODE.PAD_PROPERTY_ERROR, property.getName());
		}
		if (padValue == null) {
			return false;
		}
		changedFlags.set(PAD_VALUE);
		return true;
	}
	
	private boolean parseRepeatRef(PPropertyListExt prpList) throws InitMetaException {
		PPropertyExt property = prpList.getProperty(REPEAT_REF_NAME);
		if (property == null) {
			return true;
		}
		repeatRef = parseSingleFieldRef(property, ownerEV.getOnwerTypeMeta(), 
				ownerEV.getTargetTypeMeta(), null, ownerEV.getDecodeResultClass());
		if (repeatRef == null)
			return false;
		changedFlags.set(REPEAT_REF);
		return true;
	}

	
	private boolean parseCaseDefault(PPropertyListExt prpList) throws InitMetaException {
		PPropertyExt property = prpList.getProperty(CASE_DEFAULT_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleNoValueArgument(property, PArgumentExt.Type.IDENTIFIER);
		if (tempArg == null) {
			return false;
		}
		String fieldName = ((PIdentifierArgumentExt)tempArg).getId();
		caseDefault = 
			((PContainerTypeExt)ownerEV.getTargetTypeMeta()).getFieldMeta(fieldName);
		if (caseDefault == null) {
			throw new InitMetaException(getPModule(), MetaException.CODE.FIELD_NOT_FOUND_ERROR, 
					fieldName, ownerEV.getTargetTypeMeta().getFullName());
		}
		changedFlags.set(CASE_DEFAULT);
		return true;
	}
	
	private boolean parseCaseRef(PPropertyListExt prpList) throws InitMetaException {
		PPropertyExt property = prpList.getProperty(CASE_REF_NAME);
		if (property == null) {
			return true;
		}
		caseRef = parseSingleFieldRef(property, ownerEV.getOnwerTypeMeta(), 
				ownerEV.getTargetTypeMeta(), null, ownerEV.getDecodeResultClass());
		if (caseRef == null)
			return false;
		changedFlags.set(CASE_REF);
		return true;
	}
	
	private boolean parseCaseRefRegion(PPropertyListExt prpList) throws InitMetaException {
		PPropertyExt property = prpList.getProperty(CASE_REF_REGION_NAME);
		if (property == null) {
			return true;
		}
		caseRefRegion = parseSingleRefRegion(property);
		if (caseRefRegion == null)
			return false;
		changedFlags.set(CASE_REF_REGION);
		return true;
	}
	
	private boolean parseSelectRefRegion(PPropertyListExt prpList) 
	throws InitMetaException {
		PPropertyExt property = prpList.getProperty(SELECT_REF_REGION_NAME);
		if (property == null) {
			return true;
		}
		selectRefRegion = parseSingleRefRegion(property);
		if (selectRefRegion == null) {
			return false;
		}
		changedFlags.set(SELECT_REF_REGION);
		return true;
	}
	
	private boolean parseSelectCond(PPropertyListExt prpList) 
	throws InitMetaException {
		PPropertyExt property = prpList.getProperty(SELECT_COND_NAME);
		if (property == null)
			return true;
//		//猜测限制条件的基类型
//		PTypeExt consType = null;
//		if (selectRef != null) {
//			consType = selectRef.getRefFieldType();
//		} else if (selectRefRegion != null){
//			consType = selectRefRegion.getRefFieldType();
//		}
		//编译限制条件
		selectCond = new ArrayList<PTypeConstraintExt>();
		if( parseValueConstraint(property, selectCond, false) ) {
			changedFlags.set(SELECT_COND);
			return true;
		} else {
			return false;
		}
	}
	
	private boolean parseSelectRef(PPropertyListExt prpList) throws InitMetaException {
		PPropertyExt property = prpList.getProperty(SELECT_REF_NAME);
		if (property == null)
			return true;
		PTypeExt defaultTargetType = null;
		//猜测引用字段的默认类型
		if (selectCond != null && selectCond.size() > 0) {
			defaultTargetType = selectCond.get(0).getTargetType();
		}
		//生成引用
		selectRef = parseSingleFieldRef(property, ownerEV.getOnwerTypeMeta(), 
				ownerEV.getTargetTypeMeta(), defaultTargetType, ownerEV.getDecodeResultClass());
		if (selectRef == null)
			return false;
		changedFlags.set(SELECT_REF);
		return true;
	}
	
	private boolean parseLengthRef(PPropertyListExt prpList) throws InitMetaException {
		PPropertyExt property = prpList.getProperty(LENGTH_REF_NAME);
		if (property == null)
			return true;
		lengthRef = parseSingleFieldRef(property, ownerEV.getOnwerTypeMeta(),
				ownerEV.getTargetTypeMeta(), null, ownerEV.getDecodeResultClass());
		if (lengthRef == null)
			return false;
		changedFlags.set(LENGTH_REF);
		return true;
	}
	
	private boolean parsePushEmptyField(PPropertyListExt prpList) throws InitMetaException {
		PPropertyExt property = prpList.getProperty(PUSH_EMPTY_FIELD_NAME);
		if (property == null)
			return true;
		pushEmptyField = new ArrayList<StackFieldOperation>();
		PArgumentExt tempArg;
		//parse group
		if (property.getGroups().size() < 1) {
			return false;
		}
		//group
		for (PArgumentGroupExt group : property.getGroups()) {
			if (group.getArguments().size() != 2) {
				return false;
			}
			//timing
			tempArg = group.getArguments().get(0);
			if (tempArg.getType() != PArgumentExt.Type.LIST) {
				return false;
			}
			List<String> timings = new ArrayList<String>();
			PListArgumentExt list = (PListArgumentExt)tempArg;
			for (PArgumentExt arg : list.getItems()) {
				if (arg.getType() != PArgumentExt.Type.IDENTIFIER) {
					return false;
				}
				timings.add(((PIdentifierArgumentExt)arg).getId());
			}
			//field
			tempArg = group.getArguments().get(1);
			if (!isValueArg(tempArg, TypeClass.CHARSTRING)) {
				return false;
			}
			String field = ((PCharstringValue)tempArg.getValue()).getText();
			StackFieldOperation op = new StackFieldOperation(
					timings.toArray(new String[timings.size()]), field);
			pushEmptyField.add(op);
		}
		changedFlags.set(PUSH_EMPTY_FIELD);
		return true;
	}
	
	private boolean parseFormat(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(FORMAT_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleNoValueArgument(property, PArgumentExt.Type.IDENTIFIER);
		if (tempArg == null) {
			return false;
		}
		String name = ((PIdentifierArgumentExt)tempArg).getId();
		format = DisplayFormat.valueOf(name);
		if (format == null) {
			return false;
		}
		changedFlags.set(FORMAT);
		return true;
	}
	
	@Override
	public int getLengthMultiplier(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null) {
			return priorityAttrs.getLengthMultiplier(null);
		}
		return lengthMultiplier;
	}
	
	@Override
	public ByteOrder getByteorder(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getByteorder(null);
		}
		if (isSetByteorder()) {
			return byteOrder;
		} else {
			return defaultByteOrder;
		}
	}

	@Override
	public int getLengthIncrement(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getLengthIncrement(null);
		}
		return lengthIncrement;
	}

	@Override
	public OnelineMode getOnelineMode(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getOnelineMode(null);
		}
		return onelineMode;
	}

	@Override
	public boolean isRefreshLengthRef(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.isRefreshLengthRef(null);
		}
		return refreshLengthRef;
	}

	@Override
	public FieldRefDesc getLengthRef(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getLengthRef(null);
		}
		return lengthRef;
	}
	
	@Override
	public List<StackFieldOperation> getPushEmptyField(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getPushEmptyField(null);
		}
		return pushEmptyField;
	}
	@Override
	public List<PTypeConstraintExt> getSelectCond(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getSelectCond(null);
		}
		return selectCond;
	}
	@Override
	public FieldRefDesc getSelectRef(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getSelectRef(null);
		}
		return selectRef;
	}
	
	@Override
	public RegionRefDesc getSelectRefRegion(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getSelectRefRegion(null);
		}
		return selectRefRegion;
	}
	
	@Override
	public PadType getPadType(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getPadType(null);
		}
		return padType;
	}

	@Override
	public PStringValue getPadValue(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getPadValue(null);
		}
		return padValue;
	}

	@Override
	public int getLength(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getLength(null);
		}
		return length;
	}

	@Override
	public boolean isSigned(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.isSigned(null);
		}
		return signed;
	}

	@Override
	public boolean isProtocol(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.isProtocol(null);
		}
		return protocol;
	}

	@Override
	public FieldRefDesc getRepeatRef(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getRepeatRef(null);
		}
		return repeatRef;
	}

	@Override
	public boolean isRefreshRepeatRef(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.isRefreshRepeatRef(null);
		}
		return refreshRepeatRef;
	}

	@Override
	public FieldRefDesc getCaseRef(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getCaseRef(null);
		}
		return caseRef;
	}

	@Override
	public RegionRefDesc getCaseRefRegion(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getCaseRefRegion(null);
		}
		return caseRefRegion;
	}
	
	@Override
	public PFieldExt getCaseDefault(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getCaseDefault(null);
		}
		return caseDefault;
	}

	@Override
	public DisplayFormat getFormat(PFpbTypeEVAttrs priorityAttrs) {
		if (priorityAttrs != null ) {
			return priorityAttrs.getFormat(null);
		}
		return format;
	}
	
    @Override
    public boolean isRestOfData(PFpbTypeEVAttrs priorityAttrs) {
        if (priorityAttrs != null ) {
            return priorityAttrs.isRestOfData(null);
        }
        return restOfData;
    }

	

	@Override
	public boolean isSetByteorder() {
		return changedFlags.get(BYTE_ORDER);
	}

	@Override
	public boolean isSetCaseDefault() {
		return changedFlags.get(CASE_DEFAULT);
	}

	@Override
	public boolean isSetCaseRef() {
		return changedFlags.get(CASE_REF);
	}

	@Override
	public boolean isSetCaseRefRegion() {
		return changedFlags.get(CASE_REF_REGION);
	}

	@Override
	public boolean isSetLength() {
		return changedFlags.get(LENGTH);
	}

	@Override
	public boolean isSetLengthIncrement() {
		return changedFlags.get(LENGTH_INCREMENT);
	}

	@Override
	public boolean isSetLengthMultiplier() {
		return changedFlags.get(LENGTH_MULTIPLIER);
	}

	@Override
	public boolean isSetLengthRef() {
		return changedFlags.get(LENGTH_REF);
	}

	@Override
	public boolean isSetOnelineMode() {
		return changedFlags.get(ONE_LINE_MODE);
	}

	@Override
	public boolean isSetPadType() {
		return changedFlags.get(PAD_TYPE);
	}

	@Override
	public boolean isSetPadValue() {
		return changedFlags.get(PAD_VALUE);
	}

	@Override
	public boolean isSetPushEmptyField() {
		return changedFlags.get(PUSH_EMPTY_FIELD);
	}

	@Override
	public boolean isSetProtocol() {
		return changedFlags.get(PROTOCOL);
	}

	@Override
	public boolean isSetRefreshLengthRef() {
		return changedFlags.get(REFRESH_LENGTH_REF);
	}

	@Override
	public boolean isSetRefreshRepeatRef() {
		return changedFlags.get(REFRESH_REPEAT_REF);
	}

	@Override
	public boolean isSetRepeatRef() {
		return changedFlags.get(REPEAT_REF);
	}

	@Override
	public boolean isSetSelectCond() {
		return changedFlags.get(SELECT_COND);
	}

	@Override
	public boolean isSetSelectRef() {
		return changedFlags.get(SELECT_REF);
	}

	@Override
	public boolean isSetSelectRefRegion() {
		return changedFlags.get(SELECT_REF_REGION);
	}

	@Override
	public boolean isSetSigned() {
		return changedFlags.get(SIGNED);
	}

	@Override
	public boolean isSetFormat() {
		return changedFlags.get(FORMAT);
	}

    @Override
    public boolean isSetRestOfData() {
        return changedFlags.get(REST_OF_DATA);
    }

    public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (isSetByteorder()) 
			builder.append("byteOrder", byteOrder);
		if (isSetCaseDefault())
			builder.append("caseDefault", caseDefault);
		if (isSetCaseRef())
			builder.append("caseRef", caseRef);
		if (isSetCaseRefRegion())
			builder.append("caseRefRegion", caseRefRegion);
		if (isSetLength())
			builder.append("length", length);
		if (isSetLengthIncrement())
			builder.append("lengthIncrement", lengthIncrement);
		if (isSetLengthMultiplier())
			builder.append("lengthMultiplier", lengthMultiplier);
		if (isSetLengthRef())
			builder.append("lengthRef", lengthRef);
		if (isSetOnelineMode())
			builder.append("onelineMode", onelineMode);
		if (isSetPadType())
			builder.append("padType", padType);
		if (isSetPadValue())
			builder.append("padValue", padValue);
		if (isSetPushEmptyField())
			builder.append("pushEmptyField", pushEmptyField);
		if (isSetRepeatRef())
			builder.append("repeatRef", repeatRef);
		if (isSetSelectCond())
			builder.append("selectCond", selectCond);
		if (isSetSelectRef())
			builder.append("selectRef", selectRef);
		if (isSetSelectRefRegion())
			builder.append("selectRefRegion", selectRefRegion);
		if (isSetProtocol())
			builder.append("protocol", protocol);
		if (isSetRefreshLengthRef())
			builder.append("refreshLengthRef", refreshLengthRef);
		if (isSetRefreshRepeatRef())
			builder.append("refreshRepeatRef", refreshRepeatRef);
		if (isSetSigned())
			builder.append("signed", signed);
		if (isSetFormat())
			builder.append("format", format);
		return builder.toString();
	}
}
