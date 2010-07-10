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
package com.fineqt.fpb.lib.meta.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.api.module.IConstant;
import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModulePar;
import com.fineqt.fpb.lib.api.module.ITemplate;
import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.meta.PConstantExt;
import com.fineqt.fpb.lib.meta.PEnumSetExt;
import com.fineqt.fpb.lib.meta.PFactoryExt;
import com.fineqt.fpb.lib.meta.PImportConstantExt;
import com.fineqt.fpb.lib.meta.PImportEnumSetExt;
import com.fineqt.fpb.lib.meta.PImportModuleParExt;
import com.fineqt.fpb.lib.meta.PModuleEVExt;
import com.fineqt.fpb.lib.meta.PModuleElementExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.PModuleExtEventListener;
import com.fineqt.fpb.lib.meta.PModuleParExt;
import com.fineqt.fpb.lib.meta.context.PModuleInitContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.util.PElementExtFactory;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmoduleFactory;
import com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbModuleEV;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplateFactory;
import com.fineqt.fpb.lib.modelview.ConstantMV;
import com.fineqt.fpb.lib.modelview.EnumSetMV;
import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.modelview.ModuleParMV;
import com.fineqt.fpb.lib.modelview.TemplateMV;
import com.fineqt.fpb.lib.modelview.TypeMV;
import com.fineqt.fpb.lib.modelview.ModuleElementMV.Type;
import com.fineqt.fpb.lib.template.PImportTemplateExt;
import com.fineqt.fpb.lib.template.PTemplateExt;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PEntityTypeExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PImportTypeExt;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PListTypeExt;
import com.fineqt.fpb.lib.type.PSubTypeExt;
import com.fineqt.fpb.lib.type.PTypeEVExtFactory;
import com.fineqt.fpb.lib.type.PTypeExt;

abstract public class PModuleExtBase implements PModuleExt {
	static String LN = System.getProperty("line.separator");
	protected static FpbmoduleFactory fpbmoduleFactory = FpbmoduleFactory.eINSTANCE;
	protected static FpbtemplateFactory fpbtemplateFactory = FpbtemplateFactory.eINSTANCE;
	
	protected String name;
	protected PModule pmodel;
	protected PFactoryExt pfactory;
	protected Map<String, Integer> elementNameIDMap = new HashMap<String, Integer>();
	protected EncodingType encodingType = EncodingType.NONE;
	protected PModuleEVExt pevMeta;
	private Map<String, PModuleExt> importedModuleMap;
	protected List<PTypeExt> ptypes = new ArrayList<PTypeExt>();
	protected List<String> pentityTypes = new ArrayList<String>();
	protected List<String> pimportTypes = new ArrayList<String>();
	protected List<String> psubTypes = new ArrayList<String>();
	protected List<PTemplateExt> pTemplates = new ArrayList<PTemplateExt>();
	protected List<String> pentityTemplates = new ArrayList<String>();
	protected List<String> pimportTemplates = new ArrayList<String>();
	protected List<PConstantExt> pConstants = new ArrayList<PConstantExt>();
	protected List<String> pentityConstants = new ArrayList<String>();
	protected List<String> pimportConstants = new ArrayList<String>();
	protected List<PModuleParExt> pModulePars = new ArrayList<PModuleParExt>();
	protected List<String> pentityModulePars = new ArrayList<String>();
	protected List<String> pimportModulePars = new ArrayList<String>();
	protected List<PEnumSetExt> penumSets = new ArrayList<PEnumSetExt>();
	protected List<String> pentityEnumSets = new ArrayList<String>();
	protected List<String> pimportEnumSets = new ArrayList<String>();
	
	protected List<PModuleExtEventListener> eventLsns = 
		new ArrayList<PModuleExtEventListener>();
	
	private EnumMap<EncodingType, PTypeEVExtFactory> ptypeEvExtFactories = 
		new EnumMap<EncodingType, PTypeEVExtFactory>(EncodingType.class);
	
	public PModuleExtBase() {
	}
	
	public PModuleExtBase(PFactoryExt factory) {
		pPFactory(factory);
	}
	
	@Override
	public void addEventListener(PModuleExtEventListener lsn) {
		eventLsns.add(lsn);
	}

	@Override
	public boolean removeEventListener(PModuleExtEventListener lsn) {
		return eventLsns.remove(lsn);
	}

	@Override
	public PFactoryExt pPFactory() {
		return pfactory;
	}

	@Override
	public void pPFactory(PFactoryExt factory) {
		assert factory != null;
		pfactory = factory;
		factory.setPModule(this);
		//作为监听器
		addEventListener(factory);
	}

	@Override
	public PTypeEVExtFactory pTypeEVExtFactory(EncodingType encoding) {
		PTypeEVExtFactory result = ptypeEvExtFactories.get(encoding);
		if (result != null)
			return result;
		return PModuleExt.Registry.PINSTANCE.getTypeEVExtFactory(encoding);
	}

	@Override
	public void pTypeEVExtFactory(PTypeEVExtFactory factory) {
		assert factory != null;
		ptypeEvExtFactories.put(factory.supportEncoding(), factory);
		//作为监听器
		addEventListener(factory);
	}

	@Override
	public String getModuleName() {
		return name;
	}

	private Map<String, PModuleExt> pImportedModuleMap() {
		if (importedModuleMap == null)
			importedModuleMap = new HashMap<String, PModuleExt>();
		return importedModuleMap;
	}

	@Override
	public Collection<PModuleExt> pImportedModules() {
		return pImportedModuleMap().values();
	}

	@Override
	public PModuleExt pImportedModule(String moduleName) {
		return pImportedModuleMap().get(moduleName);
	}

	@Override
	public ModuleMV pImportedModuleMV(String moduleName) {
		return pImportedModule(moduleName);
	}

	@Override
	public List<PTypeExt> pTypes() {
		return Collections.unmodifiableList(ptypes);
	}
	
	@Override
	public List<PConstantExt> pConstants() {
		return Collections.unmodifiableList(pConstants);
	}

	@Override
	public List<PTemplateExt> pTemplates() {
		return Collections.unmodifiableList(pTemplates);
	}

	@Override
	public List<PModuleParExt> pModulePars() {
		return Collections.unmodifiableList(pModulePars);
	}

	@Override
	public List<String> pSubTypes() {
		return Collections.unmodifiableList(psubTypes);
	}
	
	@Override
	public List<String> pEntityElements(Type type) {
		switch(type) {
		case TYPE:
			return Collections.unmodifiableList(pentityTypes);
		case CONSTANT:
			return Collections.unmodifiableList(pentityConstants);
		case MODULE_PARAMETER:
			return Collections.unmodifiableList(pentityModulePars);
		case TEMPLATE:
			return Collections.unmodifiableList(pentityTemplates);
		case ENUM_SET:
			return Collections.unmodifiableList(pentityEnumSets);
		}
		assert false;
		return null;
	}

	@Override
	public List<String> pImportElements(Type type) {
		switch(type) {
		case TYPE:
			return Collections.unmodifiableList(pimportTypes);
		case CONSTANT:
			return Collections.unmodifiableList(pimportConstants);
		case MODULE_PARAMETER:
			return Collections.unmodifiableList(pimportModulePars);
		case TEMPLATE:
			return Collections.unmodifiableList(pimportTemplates);
		case ENUM_SET:
			return Collections.unmodifiableList(pimportEnumSets);
		}
		assert false;
		return null;
	}
	
	@Override
	public PTypeExt pPType(String typeName) {
		Integer id = elementNameIDMap.get(typeName);
		if (id == null) {
			return null;
		}
		return pPType(id);
	}
	
	@Override
	public PTemplateExt pPTemplate(String templateName) {
		Integer id = elementNameIDMap.get(templateName);
		if (id == null) {
			return null;
		}
		return pPTemplate(id);
	}

	@Override
	public PConstantExt pPConstant(String constantName) {
		Integer id = elementNameIDMap.get(constantName);
		if (id == null) {
			return null;
		}
		return pPConstant(id);
	}
	
	@Override
	public PModuleParExt pPModulePar(String moduleParName) {
		Integer id = elementNameIDMap.get(moduleParName);
		if (id == null) {
			return null;
		}
		return pPModulePar(id);
	}

	@Override
	public PEnumSetExt pPEnumSet(String enumSetName) {
		Integer id = elementNameIDMap.get(enumSetName);
		if (id == null) {
			return null;
		}
		return pPEnumSet(id);
	}

	@Override
	public List<PEnumSetExt> pEnumSets() {
		return Collections.unmodifiableList(penumSets);
	}

	@Override
	public ITemplate getTemplate(int typeID) {
		return pPTemplate(typeID);
	}

	@Override
	public ITemplate getTemplate(String typeName) {
		return pPTemplate(typeName);
	}

	@Override
	public ByteOrder pByteOrder() {
		if (pevMeta != null) {
			return pevMeta.getByteOrder();
		}
		return ByteOrder.NONE;
	}

	@Override
	public EncodingType pEncodingType() {
		return encodingType;
	}

	@Override
	public PModuleEVExt pEVMeta() {
		return pevMeta;
	}
	
	@Override
	public IFactory getFactory() {
		return pfactory;
	}

	@Override
	public IType getType(int typeID) {
		return pPType(typeID);
	}

	@Override
	public IType getType(String typeName) {
		return pPType(typeName);
	}

	@Override
	public TemplateMV pTemplateMV(String name) {
		return pPTemplate(name);
	}

	@Override
	public TypeMV pTypeMV(String name) {
		return pPType(name);
	}


	@Override
	public IConstant getConstant(int constantID) {
		return pPConstant(constantID);
	}

	@Override
	public IConstant getConstant(String constantName) {
		return pPConstant(constantName);
	}

	@Override
	public IModulePar getModulePar(int moduleParID) {
		return pPModulePar(moduleParID);
	}

	@Override
	public IModulePar getModulePar(String moduleParName) {
		return pPModulePar(moduleParName);
	}

	@Override
	public ConstantMV pConstantMV(String name) {
		return pPConstant(name);
	}

	@Override
	public ModuleParMV pModuleParMV(String name) {
		return pPModulePar(name);
	}

	@Override
	public EnumSetMV pEnumSetMV(String name) {
		return pPEnumSet(name);
	}

	@Override
	public String[] getConstantNames() {
		List<String> names = new ArrayList<String>();
		if (pConstants != null) {
			for (PConstantExt constant : pConstants) {
				names.add(constant.getFullName());
			}
		}
		return names.toArray(new String[names.size()]);
	}

	@Override
	public String[] getModuleParNames() {
		List<String> names = new ArrayList<String>();
		if (pModulePars != null) {
			for (PModuleParExt modulePar : pModulePars) {
				names.add(modulePar.getFullName());
			}
		}
		return names.toArray(new String[names.size()]);
	}

	@Override
	public String[] getTemplateNames() {
		List<String> names = new ArrayList<String>();
		if (pTemplates != null) {
			for (PTemplateExt template : pTemplates) {
				names.add(template.getFullName());
			}
		}
		return names.toArray(new String[names.size()]);
	}

	@Override
	public String[] getTypeNames() {
		List<String> names = new ArrayList<String>();
		for (PTypeExt type : ptypes) {
			names.add(type.getFullName());
		}
		return names.toArray(new String[names.size()]);
	}

	protected void addType(PTypeExt result) {
		int ptypeID = result.getID();
		String name = result.getName();
		//加入各个集合
		ptypes.add(result);
		String fullName = result.getFullName();
		switch(result.getDerivativeMode()) {
		case ENTITY:
			elementNameIDMap.put(name, ptypeID);
			//以全称登记
			elementNameIDMap.put(fullName, ptypeID);
			pentityTypes.add(fullName);
			break;
		case IMPORT:
			//如果已有已有其他元素的定义则不覆盖
			if (!elementNameIDMap.containsKey(name)) {
				elementNameIDMap.put(name, ptypeID);
			}
			//以全称登记
			elementNameIDMap.put(fullName, ptypeID);
			pimportTypes.add(fullName);
			break;
		case SUB:
			elementNameIDMap.put(name, ptypeID);
			//以全称登记
			elementNameIDMap.put(fullName, ptypeID);
			psubTypes.add(fullName);
			break;
		}
	}
	
	private void addModuleElement(PModuleElementExt element) {
		int id = element.getID();
		String name = element.getName();
		String fullName = element.getFullName();
		List<String> targetList = null;
		if (!element.isImport()) {
			elementNameIDMap.put(name, id);
			//以全称登记
			elementNameIDMap.put(fullName, id);
			switch(element.getModuleElementType()) {
			case CONSTANT:
				targetList = pentityConstants;
				break;
			case ENUM_SET:
				targetList = pentityEnumSets;
				break;
			case MODULE_PARAMETER:
				targetList = pentityModulePars;
				break;
			case TEMPLATE:
				targetList = pentityTemplates;
				break;
			default:
				//Type不包括在内
				assert false;
				break;
			}
		} else {
			//如果已有已有其他元素的定义则不覆盖
			if (!elementNameIDMap.containsKey(name)) {
				elementNameIDMap.put(name, id);
			}
			//全称
			elementNameIDMap.put(fullName, id);
			switch(element.getModuleElementType()) {
			case CONSTANT:
				targetList = pimportConstants;
				break;
			case ENUM_SET:
				targetList = pimportEnumSets;
				break;
			case MODULE_PARAMETER:
				targetList = pimportModulePars;
				break;
			case TEMPLATE:
				targetList = pimportTemplates;
				break;
			default:
				//Type不包括在内
				assert false;
				break;
			}
		}
		//加入名称列表
		assert targetList != null;
		targetList.add(fullName);
	}
	
	protected void addConstant(PConstantExt constant) {
		//加入各个集合
		pConstants.add(constant);
		addModuleElement(constant);
	}

	protected void addTemplate(PTemplateExt template) {
		//加入各个集合
		pTemplates.add(template);
		addModuleElement(template);
	}

	protected void addModulePar(PModuleParExt modulePar) {
		//加入各个集合
		pModulePars.add(modulePar);
		addModuleElement(modulePar);
	}
	
	protected void addEnumSet(PEnumSetExt enumSet) {
		//加入各个集合
		penumSets.add(enumSet);
		addModuleElement(enumSet);
	}
	
	protected PModuleEVExt createModuleEVExt(PEncodingVariant evModel) throws InitMetaException {
		switch(encodingType) {
		case FPB:
			return new PFpbModuleEVExtImpl((PFpbModuleEV)evModel, this);
		case NONE:
			return null;
		default:
			throw new InitMetaException(this, "Unsupported encoding of " + encodingType);
		}
	}
	
	/**
	 * 解决ImportType引用的类型和模块
	 */
	protected void resolveImportedTypeRef(PModuleInitContext cxt) 
	throws InitMetaException {
		for (String fullName : pimportTypes) {
			PImportTypeExt importTypeExt = (PImportTypeExt)getType(fullName);
			assert importTypeExt != null;
			PModuleExt importedModule = resolveImportedModule(
					importTypeExt.getImportedModuleName(), cxt);
			if (importedModule == null) {
				throw new InitMetaException(this, MetaException.CODE.MODULE_NOT_IMPORTED_ERROR, 
						importTypeExt.getImportedModuleName(), getModuleName());
			}
			PTypeExt importedType = importedModule.pPType(importTypeExt.getImportedTypeName());
			if (importedType == null) {
				throw new InitMetaException(this, MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
						importTypeExt.getImportedTypeName(), 
						importTypeExt.getImportedModuleName());
			}
			importTypeExt.setSuperType(importedType);
		}
	}
	
	/**
	 * 解决ImportTemplate引用的模板和模块
	 */
	protected void resolveImportedTempRef(PModuleInitContext cxt) {
		for (String fullName : pimportTemplates) {
			PImportTemplateExt tempExt = (PImportTemplateExt)getTemplate(fullName);
			assert tempExt != null;
			PModuleExt importedModule = resolveImportedModule(
					tempExt.getImportedModuleName(), cxt);
			if (importedModule == null) {
				throw new InitMetaException(this, MetaException.CODE.MODULE_NOT_IMPORTED_ERROR, 
						tempExt.getImportedModuleName(), getModuleName());
			}
			PTemplateExt importedTemp = importedModule.pPTemplate(
					tempExt.getImportedTemplateName());
			if (importedTemp == null) {
				throw new InitMetaException(this, MetaException.CODE.TEMPLATE_NOT_FOUND_ERROR, 
						tempExt.getImportedTemplateName(),
						tempExt.getImportedModuleName());
			}
			tempExt.setImportedTemplate(importedTemp);
		}
	}
	
	/**
	 * 解决ImportConstant引用的常数和模块
	 */
	protected void resolveImportedConsRef(PModuleInitContext cxt) {
		for (String fullName : pimportConstants) {
			PImportConstantExt consExt = (PImportConstantExt)getConstant(fullName);
			assert consExt != null;
			PModuleExt importedModule = resolveImportedModule(
					consExt.getImportedModuleName(), cxt);
			if (importedModule == null) {
				throw new InitMetaException(this, MetaException.CODE.MODULE_NOT_IMPORTED_ERROR, 
						consExt.getImportedModuleName(), getModuleName());
			}
			PConstantExt importedCons = importedModule.pPConstant(
					consExt.getImportedConstantName());
			if (importedCons == null) {
				throw new InitMetaException(this, MetaException.CODE.CONSTANT_NOT_FOUND_ERROR, 
						consExt.getImportedConstantName(), consExt.getImportedModuleName());
			}
			consExt.setImportedConstant(importedCons);
		}
	}
	
	/**
	 * 解决ImportModulepar引用的模块参数和模块
	 */
	protected void resolveImportedMparRef(PModuleInitContext cxt) {
		for (String fullName : pimportModulePars) {
			PImportModuleParExt mparExt = (PImportModuleParExt)getModulePar(fullName);
			assert mparExt != null;
			PModuleExt importedModule = resolveImportedModule(
					mparExt.getImportedModuleName(), cxt);
			if (importedModule == null) {
				throw new InitMetaException(this, MetaException.CODE.MODULE_NOT_IMPORTED_ERROR, 
						mparExt.getImportedModuleName(), getModuleName());
			}
			PModuleParExt importedMpar = importedModule.pPModulePar(
					mparExt.getImportedModuleParName());
			if (importedMpar == null) {
				throw new InitMetaException(this, MetaException.CODE.MODULEPAR_NOT_FOUND_ERROR, 
						mparExt.getImportedModuleParName(),
						mparExt.getImportedModuleName());
			}
			mparExt.setImportedModulePar(importedMpar);
		}
	}
	
	/**
	 * 解决ImportEnumSet引用的常数和模块
	 */
	protected void resolveImportedEnumSetRef(PModuleInitContext cxt) {
		for (String fullName : pimportEnumSets) {
			PImportEnumSetExt enumSetExt = (PImportEnumSetExt)pPEnumSet(fullName);
			assert enumSetExt != null;
			PModuleExt importedModule = resolveImportedModule(
					enumSetExt.getImportedModuleName(), cxt);
			if (importedModule == null) {
				throw new InitMetaException(this, MetaException.CODE.MODULE_NOT_IMPORTED_ERROR, 
						enumSetExt.getImportedModuleName(), getModuleName());
			}
			PEnumSetExt importedEnumSet = importedModule.pPEnumSet(
					enumSetExt.getImportedEnumSetName());
			if (importedEnumSet == null) {
				throw new InitMetaException(this, MetaException.CODE.CONSTANT_NOT_FOUND_ERROR, 
						enumSetExt.getImportedEnumSetName(), enumSetExt.getImportedModuleName());
			}
			enumSetExt.setImportedEnumSet(importedEnumSet);
		}
	}
	
	/**
	 * 解决SubType引用的类型和模型
	 */
	protected void resolveSubTypeRef() throws InitMetaException {
		for (String fullName : psubTypes) {
			PSubTypeExt subTypeExt = (PSubTypeExt)getType(fullName);
			assert subTypeExt != null;
			PTypeExt superType = pPType(subTypeExt.getSuperTypeName());
			if (superType == null) {
				throw new InitMetaException(this, MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
						subTypeExt.getSuperTypeName(), getModuleName());
			}
			subTypeExt.setSuperType(superType);
		}
	}
	/**
	 * 解决Field或ListItem引用的类型和模型
	 * @throws InitMetaException
	 */
	protected void resolveFieldTypeRef() throws InitMetaException {
		for (String fullName : pentityTypes) {
			PEntityTypeExt entityTypeExt = (PEntityTypeExt)getType(fullName);
			assert entityTypeExt != null;
			if (entityTypeExt.isContainerType()) {
				PContainerTypeExt ctype = (PContainerTypeExt)entityTypeExt;
				for (PFieldExt fieldExt : ctype.getAllFields()) {
					String fieldTypeName = fieldExt.getFieldTypeName();
					//取得类型定义
					PTypeExt type = ctype.getPModule().pPType(fieldTypeName);
					if (type == null) {
						throw new InitMetaException(this, MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
								fieldTypeName, ctype.getPModule().getModuleName());
					}
					//设置
					fieldExt.setType(type);
				}
			} else if (entityTypeExt.isListType()) {
				PListTypeExt ltype = (PListTypeExt)entityTypeExt;
				PListItemExt item = ltype.getItemMeta();
				String itemTypeName = item.getItemTypeName();
				//取得类型定义
				PTypeExt type = ltype.getPModule().pPType(itemTypeName);
				if (type == null) {
					throw new InitMetaException(this, MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
							itemTypeName, ltype.getPModule().getModuleName());
				}
				//设置
				item.setType(type);
			}
		}
	}
	
	
	protected <T extends PTypeExt> T createTypeExt(Class<T> cls, PType pmodel, int ptypeID) 
	throws InitMetaException {
		pmodel.setTypeID(ptypeID);
		T result = PElementExtFactory.INSTANCE.createType(cls, this, pmodel);
		//Module中加入该类型
		addType(result);
		return result;
	}

	private PModuleExt resolveImportedModule(String importedModuleName, PModuleInitContext cxt) {
		PModuleExt importedModule = pImportedModule(importedModuleName);
		if (importedModule == null) {
//			importedModule = PModuleExt.Registry.PINSTANCE.resolvePModule(importedModuleName);
		    importedModule = cxt.getCreatedModule(importedModuleName);
			if (importedModule != null) {
				pImportedModuleMap().put(importedModuleName, importedModule);
			}
		}
		return importedModule;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("module name", getModuleName());
		builder.append("pfactory", pfactory);
		builder.append("ptypeEvExtFactories", ptypeEvExtFactories);
		builder.append(LN);
		for (int i = 0; i < ptypes.size(); i++) {
			builder.append("type["+i+"]", ptypes.get(i));
			builder.append(LN);
		}
		for (int i = 0; i < penumSets.size(); i++) {
			builder.append("enumset["+i+"]", penumSets.get(i));
			builder.append(LN);
		}
		return builder.toString();
	}
	
}
