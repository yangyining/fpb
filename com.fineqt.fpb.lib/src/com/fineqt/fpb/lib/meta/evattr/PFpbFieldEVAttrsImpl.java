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

import com.fineqt.fpb.lib.builtin.PBooleanValue;
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
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
import com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbFieldEVAttrs;
import com.fineqt.fpb.lib.type.PFpbFieldEVExt;
import com.fineqt.fpb.lib.value.PValue;

public class PFpbFieldEVAttrsImpl extends PFpbEVAttrsBase 
implements PFpbFieldEVAttrs {
	private static int CASE_COND = 0;
	private static int DEFAULT_LENGTH = 1;
	private static int DEFAULT_VALUE = 2;
	private static int FLAG_TYPE = 3;
	private static int SET_FIELD = 4;
	private static int DEFAULT_PRESENT = 5;
	private static int OVERRIDE_WHOLE = 6;
	private static int MAX_ID = OVERRIDE_WHOLE;
	
	private static String CASE_COND_NAME = "CaseCond";
	private static String DEFAULT_LENGTH_NAME = "DefaultLength";
	private static String DEFAULT_VALUE_NAME = "DefaultValue";
	private static String FLAG_TYPE_NAME = "FlagType";
	private static String SET_FIELD_NAME = "SetField";
	private static String DEFAULT_PRESENT_NAME = "DefaultPresent";
	private static String OVERRIDE_WHOLE_NAME = "OverrideWhole";
	
	private PFpbFieldEVExt ownerEV;
	private BitSet changedFlags = new BitSet(MAX_ID + 1);
	private List<PTypeConstraintExt> caseCond;
	private int defaultLength = -1;
	private PValue defaultValue;
	private FlagFieldType flagType = FlagFieldType.NONE;
	private StackFieldOperation setField;
	private boolean defaultPresent = false;
	private boolean overrideWhole = false;
	
	public PFpbFieldEVAttrsImpl(PPropertyListExt prpList, PFpbFieldEVExt ownerEV) {
		this.ownerEV = ownerEV;
		if (prpList != null) {
			initPropertyList(prpList);
		}
	}

	private PModuleExt getPModule() {
		return ownerEV.getOwner().getPModule();
	}
	
	private void initPropertyList(PPropertyListExt prpList) {
		//defaultLength
		if (!parseDefaultLength(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(DEFAULT_LENGTH_NAME), DEFAULT_LENGTH_NAME, 
					SINGLE_INTEGER_FORMAT);
		}
		//flagType
		if (!parseFlagType(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(FLAG_TYPE_NAME), FLAG_TYPE_NAME, FLAG_TYPE_FORMAT);
		}
		//defaultPresent
		if (!parseDefaultPresent(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(DEFAULT_PRESENT_NAME), DEFAULT_PRESENT_NAME, 
					SINGLE_BOOLEAN_FORMAT);
		}
		//overrideWhole
		if (!parseOverrideWhole(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(OVERRIDE_WHOLE_NAME), OVERRIDE_WHOLE_NAME, 
					SINGLE_BOOLEAN_FORMAT);
		}
		//caseCond
		if (!parseCaseCond(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(CASE_COND_NAME), CASE_COND_NAME, SINGLE_VALUE_CONSTRAINT_FORMAT);
		}
		//defaultValue
		if (!parseDefaultValue(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(DEFAULT_VALUE_NAME), DEFAULT_VALUE_NAME, SINGLE_VALUE_FORMAT);
		}
		//setField
		if (!parseSetField(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(SET_FIELD_NAME), SET_FIELD_NAME, FIELD_POP_FIELD_FORMAT);
		}
	}
	
	private boolean parseDefaultLength(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(DEFAULT_LENGTH_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.INTEGER);
		if (tempArg == null) {
			return false;
		}
		defaultLength = ((PIntegerValue)tempArg.getValue()).getInteger();
		changedFlags.set(DEFAULT_LENGTH);
		return true;
	}

	private boolean parseFlagType(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(FLAG_TYPE_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleNoValueArgument(property, PArgumentExt.Type.IDENTIFIER);
		if (tempArg == null) {
			return false;
		}
		String id = ((PIdentifierArgumentExt)tempArg).getId();
		flagType = FlagFieldType.get(id);
		if (flagType == null) {
			return false;
		}
		changedFlags.set(FLAG_TYPE);
		return true;
	}
	
	private boolean parseDefaultPresent(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(DEFAULT_PRESENT_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.BOOLEAN);
		if (tempArg == null) {
			return false;
		}
		defaultPresent = ((PBooleanValue)tempArg.getValue()).getBoolean();
		changedFlags.set(DEFAULT_PRESENT);
		return true;
	}

	private boolean parseOverrideWhole(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(OVERRIDE_WHOLE_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.BOOLEAN);
		if (tempArg == null) {
			return false;
		}
		overrideWhole = ((PBooleanValue)tempArg.getValue()).getBoolean();
		changedFlags.set(OVERRIDE_WHOLE);
		return true;
	}
	
	private boolean parseSetField(PPropertyListExt prpList) throws InitMetaException {
		PPropertyExt property = prpList.getProperty(SET_FIELD_NAME);
		if (property == null)
			return true;
		setField = parsePushPopFieldTiming(property);
		if (setField == null) {
			return false;
		}
		changedFlags.set(SET_FIELD);
		return true;
	}
	
	private boolean parseCaseCond(PPropertyListExt prpList) throws InitMetaException {
		PPropertyExt property = prpList.getProperty(CASE_COND_NAME);
		if (property == null)
			return true;
//		//猜测限制条件的基类型
//		PTypeExt consType = null;
//		PTypeEVExt fieldOwnerTypeEV = ownerEV.getOwner().getOwner().getEVMeta();
//		if (fieldOwnerTypeEV instanceof PFpbTypeEVExt) {
//			PFpbTypeEVExt fpbEv = (PFpbTypeEVExt)fieldOwnerTypeEV;
//			PFpbTypeEVAttrs fpbAttrs = fpbEv.getFpbTypeEVAttrs();
//			if (fpbAttrs != null) {
//				if (fpbAttrs.getCaseRef(null) != null) {
//					consType = fpbAttrs.getCaseRef(null).getRefFieldType();
//				} else if (fpbAttrs.getCaseRefRegion(null) != null) {
//					consType = fpbAttrs.getCaseRefRegion(null).getRefFieldType();
//				}
//			}
//		}
		//编译限制条件
		caseCond = new ArrayList<PTypeConstraintExt>();
		if (!parseValueConstraint(property, caseCond, false)) {
			return false;
		}
		changedFlags.set(CASE_COND);
		return true;
	}
	
	private boolean parseDefaultValue(PPropertyListExt prpList) throws InitMetaException {
		PPropertyExt property = prpList.getProperty(DEFAULT_VALUE_NAME);
		if (property == null)
			return true;
		defaultValue = parseSingleValue(property, ownerEV.getOwner().getType());
		if (defaultValue == null) {
			return false;
		}
		changedFlags.set(DEFAULT_VALUE);
		return true;
	}
	
	
	
	private StackFieldOperation parsePushPopFieldTiming(PPropertyExt property) {
        PFieldExt ownerFieldMeta = (PFieldExt)ownerEV.getOwner();
		PArgumentExt tempArg;
		if (property.getGroups().size() != 1) {
			return null;
		}
		//group
		PArgumentGroupExt group = property.getGroups().get(0);
		if (group.getArguments().size() != 1 && group.getArguments().size() != 2) {
			return null;
		}
		//timing
		tempArg = group.getArguments().get(0);
		if (tempArg.getType() != PArgumentExt.Type.LIST) {
			return null;
		}
		List<String> timings = new ArrayList<String>();
		PListArgumentExt list = (PListArgumentExt)tempArg;
		for (PArgumentExt arg : list.getItems()) {
			if (arg.getType() != PArgumentExt.Type.IDENTIFIER) {
				return null;
			}
			timings.add(((PIdentifierArgumentExt)arg).getId());
		}
		//field
		String field = ownerFieldMeta.getFieldName();
		if (group.getArguments().size() == 2) {
			tempArg = group.getArguments().get(1);
			if (!isValueArg(tempArg, TypeClass.CHARSTRING)) {
				return null;
			}
			field = ((PCharstringValue)tempArg.getValue()).getText().trim();
		}
		return new StackFieldOperation(timings.toArray(new String[timings.size()]), field);
	}
	
	@Override
	public List<PTypeConstraintExt> getCaseCond() {
		return caseCond;
	}

	@Override
	public int getDefaultLength() {
		return defaultLength;
	}

	@Override
	public PValue getDefaultValue() {
		return defaultValue;
	}

	@Override
	public FlagFieldType getFlagType() {
		return flagType;
	}

	@Override
	public StackFieldOperation getSetField() {
		return setField;
	}

	@Override
	public boolean isDefaultPresent() {
		return defaultPresent;
	}

	@Override
	public boolean isOverrideWhole() {
		return overrideWhole;
	}

	@Override
	public boolean isSetCaseCond() {
		return changedFlags.get(CASE_COND);
	}

	@Override
	public boolean isSetDefaultLength() {
		return changedFlags.get(DEFAULT_LENGTH);
	}

	@Override
	public boolean isSetDefaultPresent() {
		return changedFlags.get(DEFAULT_PRESENT);
	}

	@Override
	public boolean isSetDefaultValue() {
		return changedFlags.get(DEFAULT_VALUE);
	}

	@Override
	public boolean isSetFlagType() {
		return changedFlags.get(FLAG_TYPE);
	}

	@Override
	public boolean isSetOverrideWhole() {
		return changedFlags.get(OVERRIDE_WHOLE);
	}

	@Override
	public boolean isSetSetField() {
		return changedFlags.get(SET_FIELD);
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		if (isSetCaseCond()) 
			builder.append("caseCond", caseCond);
		if (isSetDefaultLength()) 
			builder.append("defaultLength", defaultLength);
		if (isSetDefaultValue()) 
			builder.append("defaultValue", defaultValue);
		if (isSetFlagType()) 
			builder.append("flagType", flagType);
		if (isSetSetField()) 
			builder.append("setField", setField);
		if (isSetDefaultPresent()) 
			builder.append("defaultPresent", defaultPresent);
		if (isSetOverrideWhole()) 
			builder.append("overrideWhole", overrideWhole);
		return builder.toString();
	}
}
