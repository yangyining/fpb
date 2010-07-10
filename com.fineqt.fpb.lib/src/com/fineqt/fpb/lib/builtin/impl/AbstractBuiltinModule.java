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
package com.fineqt.fpb.lib.builtin.impl;

import org.eclipse.emf.ecore.EClass;

import com.fineqt.fpb.lib.builtin.BuiltinModule;
import com.fineqt.fpb.lib.meta.PFactoryExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.impl.PModuleExtBase;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PContainerType;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityType;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumItem;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumerated;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem;
import com.fineqt.fpb.lib.model.fpbmodule.PField;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbFieldEV;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbModuleEV;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PImportType;
import com.fineqt.fpb.lib.model.fpbmodule.PListConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PSubType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint;
import com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher;
import com.fineqt.fpb.lib.system.ResourceManager;
import com.fineqt.fpb.lib.type.PTypeExt;

abstract public class AbstractBuiltinModule extends PModuleExtBase 
implements BuiltinModule {
	public AbstractBuiltinModule() {
	}

	public AbstractBuiltinModule(PFactoryExt factory) {
		super(factory);
	}

	protected void createModuleContents() {
		assert pmodel != null;
		name = pmodel.getName();
	}

	protected void initializeModule() throws InitMetaException {
		//初始化EV Meta
		if (pmodel.getVariant() != null) {
			pevMeta = createModuleEVExt(pmodel.getVariant());
			if (pevMeta != null) {
				pevMeta.init();
			}
		}
	}
	
	protected PTypeExt getBuiltinTypeExt(int typeID) {
		switch(typeID) {
		case PINTEGER:
			return getInteger();
		case PFLOAT:
			return getFloat();
		case POBJID:
			return getObjid();
		case PBOOLEAN:
			return getBoolean();
		case PCHARSTRING:
			return getCharstring();
		case PUCHARSTRING:
			return getUniversalCharstring();
		case PBITSTRING:
			return getBitstring();
		case PHEXSTRING:
			return getHexstring();
		case POCTETSTRING:
			return getOctetstring();
		case PVERDICT:
			return getVerdict();
		}
		return null;
	}
	
	protected PModule createPModuleModel(String name, EncodingType encoding) {
		PModule model = fpbmoduleFactory.createPModule();
		model.setName(name);
		model.setEncode(encoding);
		if (encoding != null) {
			switch(encoding) {
			case FPB:
				PFpbModuleEV ev = fpbmoduleFactory.createPFpbModuleEV();
				model.setVariant(ev);
				break;
			}
		}
		//保存在ResourceManager中
		ResourceManager.INSTANCE.saveModule(model);
		return model;
	}

	protected PField createPFieldModel(String name, EncodingType encoding) {
		PField fieldModel = fpbmoduleFactory.createPField();
		fieldModel.setName(name);
		fieldModel.setEncode(encoding);
		if (encoding != null) {
			switch(encoding) {
			case FPB:
				PFpbFieldEV ev = fpbmoduleFactory.createPFpbFieldEV();
				fieldModel.setVariant(ev);
				break;
			}
		}
		return fieldModel;
	}
	
	protected PEntityType createPEntityTypeModel(EClass eClass, String name, PTypeConstraint constraint) {
		if ( !FpbmodulePackage.Literals.PENTITY_TYPE.isSuperTypeOf(eClass) ) {
			throw new IllegalArgumentException();
		}
		PEntityType typeModel = (PEntityType)fpbmoduleFactory.create(eClass);
		typeModel.setName(name);
		typeModel.setConstraint(constraint);
		pmodel.getTypes().add(typeModel);
		return typeModel;
	}
	
	protected void setFpbTypeEV(PType typeModel) {
		typeModel.setEncode(EncodingType.FPB);
		//生成EV
		PFpbTypeEV ev = fpbmoduleFactory.createPFpbTypeEV();
		typeModel.setVariant(ev);
	}
	
	protected void setFieldEnumItems(PField fieldModel, Object[][] enumItems) {
		for (int i = 0; i < enumItems.length; i++) {
			Object[] itemDesc = enumItems[i];
			PEnumItem itemModel = fpbmoduleFactory.createPEnumItem();
			itemModel.setName((String)itemDesc[0]);
			itemModel.setCond((PTypeConstraint)itemDesc[1]);
			fieldModel.getEnumItems().add(itemModel);
		}
	}
	
	protected PSubType createPSubTypeModel(String name, String superTypeName, 
			PTypeConstraint constraint) {
		//生成模型
		PSubType model = fpbmoduleFactory.createPSubType();
		model.setName(name);
		model.setSuperTypeName(superTypeName);
		model.setConstraint(constraint);
		return model;
	}

	protected PImportType addPImportedTypeModel(PModule model, int typeID, 
			String importedModuleName, String importedTypeName) {
		PImportType type = createPImportedTypeModel(typeID, 
				importedModuleName, importedTypeName);
		model.getTypes().add(type);
		return type;
	}
	
	protected PImportType createPImportedTypeModel(int typeID, 
			String importedModuleName, String importedTypeName) {
		//生成模型
		PImportType model = fpbmoduleFactory.createPImportType();
		model.setTypeID(typeID);
		model.setImportedModuleName(importedModuleName);
		model.setImportedTypeName(importedTypeName);
		return model;
	}
	
	protected PField addField(PContainerType containerModel, String fieldName, String typeName, 
			boolean optional, PTypeConstraint constraint, String enumRef) {
		PField fieldModel = fpbmoduleFactory.createPField();
		fieldModel.setName(fieldName);
		fieldModel.setPtypeName(typeName);
		fieldModel.setOptional(optional);
		fieldModel.setConstraint(constraint);
		fieldModel.setEnumRef(enumRef);
		containerModel.getPfields().add(fieldModel);
		
		return fieldModel;
	}

	protected PEnumeratedItem addEnumItem(PEnumerated enumModel, String enumName, int enumValue) {
		PEnumeratedItem item = fpbmoduleFactory.createPEnumeratedItem();
		item.setEnumName(enumName);
		item.setEnumValue(enumValue);
		enumModel.getItems().add(item);
		return item;
	}
	
	protected PListConstraint createPListConstraint() {
		PListConstraint cons = fpbmoduleFactory.createPListConstraint();
		return cons;
	}
	
	protected PPatternConstraint createPPatternConstraint() {
		PPatternConstraint cons = fpbmoduleFactory.createPPatternConstraint();
		return cons;
	}
	
	protected PValueListMatcher createPValueListMatcher() {
		PValueListMatcher matcher = fpbtemplateFactory.createPValueListMatcher();
		return matcher;
	}
	
	protected PCharstringMatcher createPCharstringMatcher(String pattern) {
		PCharstringMatcher matcher = fpbtemplateFactory.createPCharstringMatcher();
		matcher.setDesc(pattern);
		return matcher;
	}
	
	protected PPrimitiveValueMatcher createPPrimitiveValueMatcher(String valueDesc) {
		PPrimitiveValueMatcher matcher = fpbtemplateFactory.createPPrimitiveValueMatcher();
		matcher.setValueDesc(valueDesc);
		return matcher;
	}
	
}
