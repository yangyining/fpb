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
package com.fineqt.fpb.lib.meta.util;

import java.lang.reflect.Constructor;
import java.util.List;

import com.fineqt.fpb.lib.constraint.PCompoundConstraintExt;
import com.fineqt.fpb.lib.constraint.PLengthConstraintExt;
import com.fineqt.fpb.lib.constraint.PListConstraintExt;
import com.fineqt.fpb.lib.constraint.PPatternConstraintExt;
import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.expression.PExpressionExt;
import com.fineqt.fpb.lib.expression.PExpressionExtImpl;
import com.fineqt.fpb.lib.expression.POmitMatcherExt;
import com.fineqt.fpb.lib.expression.PPrimitiveValueMatcherExt;
import com.fineqt.fpb.lib.expression.PSingleExpressionMatcherExt;
import com.fineqt.fpb.lib.expression.PUnaryExpressionExt;
import com.fineqt.fpb.lib.expression.PValueReferenceMatcherExt;
import com.fineqt.fpb.lib.meta.PConstantExt;
import com.fineqt.fpb.lib.meta.PEnumSetExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.PModuleParExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.impl.PEntityConstantExtImpl;
import com.fineqt.fpb.lib.meta.impl.PEntityEnumSetExtImpl;
import com.fineqt.fpb.lib.meta.impl.PEntityModuleParExtImpl;
import com.fineqt.fpb.lib.meta.impl.PImportConstantExtImpl;
import com.fineqt.fpb.lib.meta.impl.PImportEnumSetExtImpl;
import com.fineqt.fpb.lib.meta.impl.PImportModuleParExtImpl;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PCompoundConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PContainerType;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumerated;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem;
import com.fineqt.fpb.lib.model.fpbmodule.PField;
import com.fineqt.fpb.lib.model.fpbmodule.PFieldEV;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbFieldEV;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbListItemEV;
import com.fineqt.fpb.lib.model.fpbmodule.PImportConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PImportType;
import com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PListConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PListItem;
import com.fineqt.fpb.lib.model.fpbmodule.PListItemEV;
import com.fineqt.fpb.lib.model.fpbmodule.PListType;
import com.fineqt.fpb.lib.model.fpbmodule.PModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PRecord;
import com.fineqt.fpb.lib.model.fpbmodule.PRecordOf;
import com.fineqt.fpb.lib.model.fpbmodule.PSet;
import com.fineqt.fpb.lib.model.fpbmodule.PSetOf;
import com.fineqt.fpb.lib.model.fpbmodule.PSubType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PUnion;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;
import com.fineqt.fpb.lib.model.fpbtemplate.PAnyMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PAnyOrOmitMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PBitstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PComplementListMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate;
import com.fineqt.fpb.lib.model.fpbtemplate.PHexstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate;
import com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PListValueMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PNotUsedMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.POctetstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.POmitMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PSubSetMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PSuperSetMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplate;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateExt;
import com.fineqt.fpb.lib.template.impl.PAnyMatcherExt;
import com.fineqt.fpb.lib.template.impl.PAnyOrOmitMatcherExt;
import com.fineqt.fpb.lib.template.impl.PBitstringMatcherExt;
import com.fineqt.fpb.lib.template.impl.PCharRangeMatcherExt;
import com.fineqt.fpb.lib.template.impl.PCharstringMatcherExt;
import com.fineqt.fpb.lib.template.impl.PComplementListMatcherExt;
import com.fineqt.fpb.lib.template.impl.PContainerFieldMatcherExt;
import com.fineqt.fpb.lib.template.impl.PEntityTemplateExtImpl;
import com.fineqt.fpb.lib.template.impl.PFloatRangeMatcherExt;
import com.fineqt.fpb.lib.template.impl.PHexstringMatcherExt;
import com.fineqt.fpb.lib.template.impl.PImportTemplateExtImpl;
import com.fineqt.fpb.lib.template.impl.PIntRangeMatcherExt;
import com.fineqt.fpb.lib.template.impl.PListFieldMatcherExt;
import com.fineqt.fpb.lib.template.impl.PListValueMatcherBase;
import com.fineqt.fpb.lib.template.impl.PNotUsedMatcherExt;
import com.fineqt.fpb.lib.template.impl.POctetstringMatcherExt;
import com.fineqt.fpb.lib.template.impl.PRecordOfMatcherExt;
import com.fineqt.fpb.lib.template.impl.PSetOfMatcherExt;
import com.fineqt.fpb.lib.template.impl.PSubsetMatcherExt;
import com.fineqt.fpb.lib.template.impl.PSupersetMatcherExt;
import com.fineqt.fpb.lib.template.impl.PTemplateRefMatcherExt;
import com.fineqt.fpb.lib.template.impl.PValueListMatcherExt;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PEnumeratedItemExt;
import com.fineqt.fpb.lib.type.PEnumeratedTypeExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PItemFieldEVExt;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PListTypeExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.type.impl.PEnumeratedItemExtImpl;
import com.fineqt.fpb.lib.type.impl.PFieldExtImpl;
import com.fineqt.fpb.lib.type.impl.PFpbFieldEVExtImpl;
import com.fineqt.fpb.lib.type.impl.PFpbListItemEVExtImpl;
import com.fineqt.fpb.lib.type.impl.PImportTypeExtImpl;
import com.fineqt.fpb.lib.type.impl.PListItemExtImpl;
import com.fineqt.fpb.lib.type.impl.PSubTypeExtImpl;
import com.fineqt.fpb.lib.type.impl.SimpleEnumeratedType;
import com.fineqt.fpb.lib.type.impl.SimpleRecordOfType;
import com.fineqt.fpb.lib.type.impl.SimpleRecordType;
import com.fineqt.fpb.lib.type.impl.SimpleSetOfType;
import com.fineqt.fpb.lib.type.impl.SimpleSetType;
import com.fineqt.fpb.lib.type.impl.SimpleUnionType;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PElementExtFactoryImpl implements PElementExtFactory {

	@Override
	public PMatcherExt createMatcher(PTypeElementMeta baseType, PMatcher model, 
			PMatcherExt parentMatcher) {
		assert baseType != null;
		assert model != null;
		PMatcherExt result = null;
		switch(model.eClass().getClassifierID()) {
		case FpbtemplatePackage.PCOMPLEMENT_LIST_MATCHER:
			result = createComplementList((PComplementListMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PVALUE_LIST_MATCHER:
			result = createValueList((PValueListMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PANY_MATCHER:
			result = createAny((PAnyMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PANY_OR_OMIT_MATCHER:
			result = createAnyOrOmit((PAnyOrOmitMatcher)model, baseType, parentMatcher);
			break;
		case FpbtemplatePackage.POMIT_MATCHER:
			result = createOmit((POmitMatcher)model, baseType, parentMatcher);
			break;
		case FpbtemplatePackage.PNOT_USED_MATCHER:
			result = createNotUsed((PNotUsedMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PRANGE_MATCHER:
			result = createRangeMatcher((PRangeMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PBITSTRING_MATCHER:
			result = createBitstring((PBitstringMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PHEXSTRING_MATCHER:
			result = createHexstring((PHexstringMatcher)model, baseType);
			break;
		case FpbtemplatePackage.POCTETSTRING_MATCHER:
			result = createOctetstring((POctetstringMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PCHARSTRING_MATCHER:
			result = createCharstring((PCharstringMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PSUB_SET_MATCHER:
			result = createSubSet((PSubSetMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PSUPER_SET_MATCHER:
			result = createSuperSet((PSuperSetMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PPRIMITIVE_VALUE_MATCHER:
			result = createPrimitiveValue((PPrimitiveValueMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PCONTAINER_FIELD_MATCHER:
			result = createContainerField((PContainerFieldMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PLIST_FIELD_MATCHER:
			result = createListField((PListFieldMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PLIST_VALUE_MATCHER:
			result = createListValue((PListValueMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PTEMPLATE_REF_MATCHER:
			result = createTemplateRef((PTemplateRefMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER:
			result = createValueRefMatcher((PValueReferenceMatcher)model, baseType);
			break;
		case FpbtemplatePackage.PUNARY_EXPRESSION:
			result = createUnaryExpression((PUnaryExpression)model, baseType);
			break;
		case FpbtemplatePackage.PSINGLE_EXPRESSION_MATCHER:
			result = createSingleExpressionMatcher(
						(PSingleExpressionMatcher)model, baseType);
			break;
		default:
			assert false;
			break;
		}
		//初始化
		result.init();
		return result;
	}
	
	protected PMatcherExt createUnaryExpression(PUnaryExpression model, PTypeElementMeta baseType) {
		return new PUnaryExpressionExt(model, baseType);
	}
	
	protected PMatcherExt createSingleExpressionMatcher(PSingleExpressionMatcher model, 
			PTypeElementMeta baseType) {
		return new PSingleExpressionMatcherExt(model, baseType);
	}
	
	protected PMatcherExt createComplementList(PComplementListMatcher model, 
			PTypeElementMeta baseType) {
		PComplementListMatcherExt matcher = new PComplementListMatcherExt(model, baseType);
		return matcher;
	}
	
	protected PMatcherExt createValueList(PValueListMatcher model, 
			PTypeElementMeta baseType) {
		//ValueList
		PValueListMatcherExt matcher = new PValueListMatcherExt(model, baseType);
		return matcher;
	}
	
	protected PMatcherExt createAny(PAnyMatcher model, 
			PTypeElementMeta baseType) {
		PAnyMatcherExt matcher = new PAnyMatcherExt(model, baseType);
		return matcher;
	}
	
	protected PMatcherExt createAnyOrOmit(PAnyOrOmitMatcher model, 
			PTypeElementMeta baseType, 
			PMatcherExt parentMatcher) {
		assert parentMatcher != null;
		PAnyOrOmitMatcherExt matcher = new PAnyOrOmitMatcherExt(model, baseType, 
				parentMatcher.getMatcherMeta());
		return matcher;
	}
	
	protected PMatcherExt createOmit(POmitMatcher model, PTypeElementMeta baseType, 
			PMatcherExt parentMatcher) {
		assert parentMatcher != null;
		POmitMatcherExt matcher = new POmitMatcherExt(model, baseType, 
				parentMatcher.getMatcherMeta());
		return matcher;
	}

	protected PMatcherExt createNotUsed(PNotUsedMatcher model, 
			PTypeElementMeta baseType) {
		PNotUsedMatcherExt matcher = new PNotUsedMatcherExt(model, baseType);
		return matcher;
	}
	
	protected PMatcherExt createRangeMatcher(PRangeMatcher model, 
			PTypeElementMeta baseType) {
		PMatcherExt matcher = null;
		switch(baseType.asTypeMeta().getTypeClass()) {
		case INTEGER:
			matcher = new PIntRangeMatcherExt(model, baseType);
			break;
		case FLOAT:
			matcher = new PFloatRangeMatcherExt(model, baseType);
			break;
		case CHARSTRING:
			matcher = new PCharRangeMatcherExt(model, baseType);
			break;
		default:
			assert false;
		}
		return matcher;
	}
	
	protected PMatcherExt createBitstring(PBitstringMatcher model, 
			PTypeElementMeta baseType) {
		PMatcherExt matcher = PBitstringMatcherExt.create(model, baseType);
		return matcher;
	}
	
	protected PMatcherExt createHexstring(PHexstringMatcher model, 
			PTypeElementMeta baseType) {
		PMatcherExt matcher = PHexstringMatcherExt.create(model, baseType);
		return matcher;
	}
	
	protected PMatcherExt createOctetstring(POctetstringMatcher model, 
			PTypeElementMeta baseType) {
		PMatcherExt matcher = POctetstringMatcherExt.create(model, baseType);
		return matcher;
	}
	
	protected PMatcherExt createCharstring(PCharstringMatcher model, 
			PTypeElementMeta baseType) {
		PMatcherExt matcher = PCharstringMatcherExt.create(model, baseType);
		return matcher;
	}
	
	protected PMatcherExt createSubSet(PSubSetMatcher model, 
			PTypeElementMeta baseType) {
		if (baseType.asTypeMeta().getTypeClass() != TypeClass.SETOF) {
			throw new IllegalArgumentException();
		}
		PSubsetMatcherExt matcher = new PSubsetMatcherExt(model, baseType);
		return matcher;
	}
	
	protected PMatcherExt createSuperSet(PSuperSetMatcher model, 
			PTypeElementMeta baseType) {
		if (baseType.asTypeMeta().getTypeClass() != TypeClass.SETOF) {
			throw new IllegalArgumentException();
		}
		PSupersetMatcherExt matcher = new PSupersetMatcherExt(model, baseType);
		return matcher;
	}
	
	protected PMatcherExt createPrimitiveValue(PPrimitiveValueMatcher model, 
			PTypeElementMeta baseType) {
		PPrimitiveValueMatcherExt matcher;
		try {
			matcher = PPrimitiveValueMatcherExt.create(model, baseType);
		} catch (IllegalLiteralFormatException e) {
			throw new InitMetaException(
					baseType.getPModule(),
					MetaException.CODE.ILLEGAL_LITERAL_FORMAT_ERROR, 
					e, " parsing primitive type of " + baseType.asTypeMeta().getFullName());
		}
		return matcher;
	}
	
	protected PMatcherExt createContainerField(PContainerFieldMatcher model, 
			PTypeElementMeta baseType) {
		PContainerFieldMatcherExt matcher = new PContainerFieldMatcherExt(model, baseType);
		return matcher;
	}
	
	protected PMatcherExt createListField(PListFieldMatcher model, 
			PTypeElementMeta baseType) {
		PListFieldMatcherExt matcher = new PListFieldMatcherExt(model, baseType);
		return matcher;
	}
	
	protected PMatcherExt createListValue(PListValueMatcher model, 
			PTypeElementMeta baseType) {
		PListValueMatcherBase matcher = null;
		switch(baseType.asTypeMeta().getTypeClass()) {
		case RECORDOF:
			matcher = new PRecordOfMatcherExt(model, baseType);
			break;
		case SETOF:
			matcher = new PSetOfMatcherExt(model, baseType);
			break;
		default:
			assert false;
			break;
		}
		return matcher;
	}

	protected PMatcherExt createTemplateRef(PTemplateRefMatcher model, 
			PTypeElementMeta baseType) {
		//Matcher
		PTemplateRefMatcherExt matcher = new PTemplateRefMatcherExt(model, baseType);
		return matcher;
	}

	protected PMatcherExt createValueRefMatcher(PValueReferenceMatcher model, 
			PTypeElementMeta baseType) {
		PValueReferenceMatcherExt matcher = new PValueReferenceMatcherExt(model, baseType);
		return matcher;
	}
	
	@Override
	public PTemplateExt createTemplate(PModuleExt module, PTemplate model) {
		PTemplateExt template;
		if (model instanceof PEntityTemplate) {
			template = new PEntityTemplateExtImpl((PEntityTemplate)model, module);
		} else {
			template = new PImportTemplateExtImpl((PImportTemplate)model, module);
		}
		return template;
	}

	@Override
	public PConstantExt createConstant(PModuleExt module, PConstant model) {
		PConstantExt constant;
		if (model instanceof PEntityConstant) {
			constant = new PEntityConstantExtImpl((PEntityConstant)model, module);
		} else {
			constant = new PImportConstantExtImpl((PImportConstant)model, module);
		}
		return constant;
	}

	@Override
	public PModuleParExt createModulePar(PModuleExt module, PModulePar model) {
		PModuleParExt modulePar;
		if (model instanceof PEntityModulePar) {
			modulePar = new PEntityModuleParExtImpl((PEntityModulePar)model, module);
		} else {
			modulePar = new PImportModuleParExtImpl((PImportModulePar)model, module);
		}
		return modulePar;
	}

	@Override
	public PEnumSetExt createEnumSet(PModuleExt module, PEnumSet model) {
		PEnumSetExt result;
		if (model instanceof PEntityEnumSet) {
			result = new PEntityEnumSetExtImpl((PEntityEnumSet)model, module);
		} else {
			result = new PImportEnumSetExtImpl((PImportEnumSet)model, module);
		}
		return result;
	}

	@Override
	public PTypeExt createCompactType(PModuleExt module, PType model) {
		PTypeExt result = null;
		switch(model.eClass().getClassifierID()) {
		case FpbmodulePackage.PIMPORT_TYPE:
			result = new PImportTypeExtImpl((PImportType)model, module);
			break;
		case FpbmodulePackage.PSUB_TYPE:
			result = new PSubTypeExtImpl((PSubType)model, module);
			break;
		case FpbmodulePackage.PRECORD:
			result = new SimpleRecordType((PRecord)model, module);
			break;
		case FpbmodulePackage.PSET:
			result = new SimpleSetType((PSet)model, module);
			break;
		case FpbmodulePackage.PRECORD_OF:
			result = new SimpleRecordOfType((PRecordOf)model, module);
			break;
		case FpbmodulePackage.PSET_OF:
			result = new SimpleSetOfType((PSetOf)model, module);
			break;
		case FpbmodulePackage.PUNION:
			result = new SimpleUnionType((PUnion)model, module);
			break;
		case FpbmodulePackage.PENUMERATED:
			result = new SimpleEnumeratedType((PEnumerated)model, module);
			break;
		default:
			assert false;
			break;
		}
		//完成类型内部的详细内容
		completeTypeDetail(model, result);
		return result;
	}

	@Override
	public <T extends PTypeExt> T createType(Class<T> cls, PModuleExt module,
			PType model) throws InitMetaException {
		T result;
		try {
			Constructor<T> constructor = cls.getConstructor(PType.class, PModuleExt.class);
			result = constructor.newInstance(model, module);
		} catch (Exception e) {
			throw new InitMetaException(module, MetaException.CODE.UNKOWN_ERROR, e);
		} 
		//完成类型内部的详细内容
		completeTypeDetail(model, result);
		return result;
	}

	@Override
	public PTypeConstraintExt createTypeConstraint(PTypeExt targetType,
			PTypeConstraint model) {
		PTypeConstraintExt result = null;
		switch(model.eClass().getClassifierID()) {
		case FpbmodulePackage.PLENGTH_CONSTRAINT:
			result = new PLengthConstraintExt((PLengthConstraint)model, targetType);
			break;
		case FpbmodulePackage.PLIST_CONSTRAINT:
			result = new PListConstraintExt((PListConstraint)model, targetType);
			break;
		case FpbmodulePackage.PPATTERN_CONSTRAINT:
			result = new PPatternConstraintExt((PPatternConstraint)model, targetType);
			break;
		case FpbmodulePackage.PCOMPOUND_CONSTRAINT:
			result = new PCompoundConstraintExt((PCompoundConstraint)model, targetType);
			break;
		default:
			assert false;
			break;
		}
		//初始化
		result.init();
		return result;
	}

	@Override
	public PExpressionExt createExpression(PTypeExt basetype, PMatcher model) {
		PMatcherExt matcher = createMatcher(basetype, model, null);
		PExpressionExt exp = new PExpressionExtImpl(basetype, matcher);
		return exp;
	}

	@Override
	public PFieldExt createField(PTypeExt owner, PField model) {
		return new PFieldExtImpl(model, owner);
	}

	@Override
	public PListItemExt createListItem(PTypeExt owner, PListItem model) {
		return new PListItemExtImpl(model, owner);
	}
	
	@Override
	public PItemFieldEVExt createFieldEV(PFieldExt owner, PFieldEV model) {
		if (model instanceof PFpbFieldEV) {
			return new PFpbFieldEVExtImpl((PFpbFieldEV)model, owner);
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public PItemFieldEVExt createListItemEV(PListItemExt owner,
			PListItemEV model) {
		if (model instanceof PFpbListItemEV) {
			return new PFpbListItemEVExtImpl((PFpbListItemEV)model, owner);
		}
		return null;
	}

	private <T extends PTypeExt> void completeTypeDetail(PType model, T result) {
		//生成FieldExt
		if (result instanceof PContainerTypeExt) {
			PContainerTypeExt containerExt = (PContainerTypeExt)result;
			PContainerType containerModel = (PContainerType)model;
			List<PField> fields = containerModel.getPfields();
			for (int i = 0; i < fields.size(); i++) {
				PField field = fields.get(i);
				field.setFieldID(i);
				PFieldExt fieldExt = createField(result, field);
				containerExt.addFieldMeta(fieldExt);
			}
		//生成ListItemExt
		} else if (result instanceof PListTypeExt) {
			PListTypeExt listExt = (PListTypeExt)result;
			PListType listModel = (PListType)model;
			assert listModel.getItem() != null;
			PListItemExt itemExt = createListItem(result, listModel.getItem());
			listExt.setItemMeta(itemExt);
		//生成PEnumeratedItemExt
		} else if (result instanceof PEnumeratedTypeExt) {
			PEnumeratedTypeExt enumTypeExt = (PEnumeratedTypeExt)result;
			PEnumerated enumModel = (PEnumerated)model;
			List<PEnumeratedItem> items = enumModel.getItems();
			for (int i = 0; i < items.size(); i++) {
				PEnumeratedItemExt itemExt = new PEnumeratedItemExtImpl(items.get(i), i);
				enumTypeExt.addItem(itemExt);
			}
		}
	}
	
}
