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

import java.util.List;

import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.property.PArgumentExt;
import com.fineqt.fpb.lib.meta.property.PArgumentGroupExt;
import com.fineqt.fpb.lib.meta.property.PConditionArgumentExt;
import com.fineqt.fpb.lib.meta.property.PPropertyExt;
import com.fineqt.fpb.lib.meta.property.PTypeReferenceArgumentExt;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PFpbEVAttrsBase {
	protected static final String TYPE_POP_FIELD_FORMAT = "'(' '[' 'ENCODE' | 'DECODE' | 'CALCULATE' | 'GETSIZE' ']', \"fieldName\" ')' ...";
	protected static final String FIELD_POP_FIELD_FORMAT = "'(' '[' 'ENCODE' | 'DECODE' | 'CALCULATE' | 'GETSIZE' ']' [, \"fieldName\"] ')'";
	protected static final String FIELD_PUSH_FIELD_FORMAT = "'(' '[' 'ENCODE' | 'DECODE' | 'CALCULATE' | 'GETSIZE' ']' [, \"fieldName\"] ')'";
	protected static final String SINGLE_REF_FORMAT = "'(' \"[-+$^@]field\" [, '#'typeReference ] ')'";
	protected static final String SINGLE_VALUE_CONSTRAINT_FORMAT = "'(' typeReference '('Type Constraint Literal')' ')'";
	protected static final String SINGLE_REGION_FORMAT = "'(' offset, length [, '#'typeReference ] ')'";
	protected static final String SINGLE_VALUE_FORMAT = "'('Type Constraint Literal')'";
	protected static final String BYTE_ORDER_FORMAT = "'(' 'BIG_ENDIAN' | 'LITTLE_ENDIAN' | 'NONE')'";
	protected static final String ONE_LINE_MODE_FORMAT = "'(' 'NONE' | 'CRLF' | 'CR' | 'LF' ')'";
	protected static final String PAD_TYPE_FORMAT = "'(' 'NO' | 'OCTET' | 'OCTET2' | 'OCTET4' | 'OCTET8' ')'";
	protected static final String SINGLE_BOOLEAN_FORMAT = "'(' BooleanArgument ')'";
	protected static final String SINGLE_INTEGER_FORMAT = "'(' IntegerArgument ')'";
	protected static final String FLAG_TYPE_FORMAT = "'(' 'NONE' | 'OCTET' | '2OCTET' | '4OCTET' ')'";
	protected static final String FORMAT_FORMAT = "'(' 'IPV4_ADDRESS' | 'IPV6_ADDRESS' | 'MAC_ADDRESS' ')'";
	
	protected static PArgumentExt getSingleNoValueArgument(PPropertyExt property, 
			PArgumentExt.Type targetArgType) {
		if (property.getGroups().size() != 1) {
			return null;
		}
		PArgumentGroupExt group = property.getGroups().get(0);
		if (group.getArguments().size() != 1) {
			return null;
		}
		PArgumentExt tempArg = group.getArguments().get(0);
		if (tempArg.isValueArgument() || tempArg.getType() != targetArgType) {
			return null;
		}
		return tempArg;
	}
	
	protected static PArgumentExt getSingleValueArgument(PPropertyExt property, 
			TypeClass targetTypeClass) {
		if (property.getGroups().size() != 1) {
			return null;
		}
		PArgumentGroupExt group = property.getGroups().get(0);
		if (group.getArguments().size() != 1) {
			return null;
		}
		PArgumentExt tempArg = group.getArguments().get(0);
		if (!isValueArg(tempArg, targetTypeClass)) {
			return null;
		}
		return tempArg;
	}
	
	protected static boolean isValueArg(PArgumentExt argument, TypeClass targetTypeClass) {
		if (argument == null)
			return false;
		return argument.isValueArgument() && 
				argument.getValueTypeClass() == targetTypeClass;
	}
	
	/**
	 * 解析padValue, defaultValue等值的描述，只能是Primitive的值。
	 * @return
	 * @throws InitMetaException
	 */
	protected static PValue parseSingleValue(PPropertyExt property, PTypeExt typeMeta) 
	throws InitMetaException {
		PArgumentExt tempArg;
		if (property.getGroups().size() != 1) {
			return null;
		}
		PArgumentGroupExt group = property.getGroups().get(0);
		if (group.getArguments().size() != 1) {
			return null;
		}
		//value
		tempArg = group.getArguments().get(0);
		if (tempArg.getType() != PArgumentExt.Type.CONDITION) {
			return null;
		}
		//强制生成限制条件
		PConditionArgumentExt condArg = (PConditionArgumentExt)tempArg;
		PValue result = condArg.getFixedValue();
		if (result == null) {
			return null;
		}
		return result;
	}
	
	/**
	 * 解析lengthRef, caseRef, selectRef等字段引用的描述
	 * @return 失败返回null
	 */
	protected static FieldRefDesc parseSingleFieldRef(PPropertyExt property, PTypeExt evOwnerType, 
			PTypeExt evTargetType, PTypeExt defaultTargetType, 
			Class<? extends DecodeResult> decodeResultClass) {
		PArgumentExt tempArg;
		if (property.getGroups().size() != 1) {
			return null;
		}
		//group
		PArgumentGroupExt group = property.getGroups().get(0);
		if (group.getArguments().size() != 1 && group.getArguments().size() != 2) {
			return null;
		}
		//refDesc
		tempArg = group.getArguments().get(0);
		if (!isValueArg(tempArg, TypeClass.CHARSTRING)) {
			return null;
		}
		String refDesc = ((PCharstringValue)tempArg.getValue()).getText().trim();
		//typeName
		PTypeExt targetType = null;
		if (group.getArguments().size() == 2) {
			tempArg = group.getArguments().get(1);
			if (tempArg.getType() != PArgumentExt.Type.TYPE_REFERENCE) {
				return null;
			}
			targetType = ((PTypeReferenceArgumentExt)tempArg).getRefType();
		}
		if (targetType == null) {
			if (defaultTargetType == null) {
				if (refDesc.length() > 0 ) {
					char prefix = refDesc.charAt(0);
					switch(prefix){
					case FieldRefDesc.STACK_FIELD_PREFIX:
					case FieldRefDesc.CXT_ATTR_PREFIX:
					case FieldRefDesc.RESULT_PROPERTY_PREFIX:
						throw new InitMetaException(evOwnerType.getPModule(), 
								MetaException.CODE.REFERENCE_FIELD_TYPE_NOT_SPECIFIED_ERROR, 
								refDesc, property.getName());
					}
				}
				targetType = evTargetType;
			} else {
				targetType = defaultTargetType;
			}
		}
		FieldRefDesc ref = FieldRefDesc.parse(refDesc, evOwnerType, 
				targetType, decodeResultClass);
		return ref;
	}
	
	/**
	 * 解析selectValue, caseValue等类型限制的描述
	 * @return
	 */
	protected static boolean parseValueConstraint(PPropertyExt property, 
			List<PTypeConstraintExt> targetList, boolean multiGroup) {
		PArgumentExt tempArg;
		if (property.getGroups().size() < 1) {
			return false;
		}
		if (!multiGroup && property.getGroups().size() > 1) {
			return false;
		}
		//group
		for (PArgumentGroupExt group : property.getGroups()) {
			if (group.getArguments().size() != 1) {
				return false;
			}
			//typeConstraint
			tempArg = group.getArguments().get(0);
			if (tempArg.getType() != PArgumentExt.Type.CONDITION) {
				return false;
			}
			PConditionArgumentExt condArg = (PConditionArgumentExt)tempArg;
			assert condArg.getCondition() != null;
			targetList.add(condArg.getCondition());
		}
		return true;
	}
	
	/**
	 * 解析caseRefRegion，和selectRefRegion等单一值区域的引用
	 * @return 如果失败返回null
	 */
	protected static RegionRefDesc parseSingleRefRegion(PPropertyExt property) {
		if (property.getGroups().size() != 1) {
			return null;
		}
		PArgumentGroupExt group = property.getGroups().get(0);
		if (group.getArguments().size() < 2) {
			return null;
		}
		//offset
		PArgumentExt tempArg = group.getArguments().get(0);
		if (!isValueArg(tempArg, TypeClass.INTEGER)) {
			return null;
		}
		int offset = ((PIntegerValue)tempArg.getValue()).getInteger();
		//length
		tempArg = group.getArguments().get(1);
		if (!isValueArg(tempArg, TypeClass.INTEGER)) {
			return null;
		}
		int length = ((PIntegerValue)tempArg.getValue()).getInteger();
        //refRegionType
		PTypeExt refRegionType;
	    if (group.getArguments().size() >= 3) {
	        tempArg = group.getArguments().get(2);
            if (tempArg.getType() != PArgumentExt.Type.TYPE_REFERENCE) {
                return null;
            }
            refRegionType = ((PTypeReferenceArgumentExt)tempArg).getRefType();
	    } else {
	        refRegionType = (PTypeExt)property.getPModule().getType(
	                RegionRefDesc.DEFAULT_REF_FIELD_TYPE);
	    }
	    assert refRegionType != null;
	    switch(refRegionType.getTypeClass()){
	    case INTEGER:
	    case OCTETSTRING:
	    case CHARSTRING:
	        break;
	    default:
            throw new InitMetaException(property.getPModule(), 
                    MetaException.CODE.REFERENCE_REGION_TYPE_NOT_ALLOWED_ERROR, 
                    property.getName(), refRegionType.getTypeClass(), 
                    new TypeClass[]{TypeClass.INTEGER, TypeClass.OCTETSTRING, TypeClass.CHARSTRING});
	    }
		return new RegionRefDesc(offset, length, refRegionType);
	}

}
