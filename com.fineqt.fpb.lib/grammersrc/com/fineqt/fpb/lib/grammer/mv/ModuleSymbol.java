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
package com.fineqt.fpb.lib.grammer.mv;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.Token;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.builtin.BuiltinModule;
import com.fineqt.fpb.lib.grammer.SimplePropertyList;
import com.fineqt.fpb.lib.meta.context.PModuleParsingContext;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.PConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbModuleEV;
import com.fineqt.fpb.lib.model.fpbmodule.PImportType;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.PModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PPropertyList;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplate;
import com.fineqt.fpb.lib.modelview.ConstantMV;
import com.fineqt.fpb.lib.modelview.EnumSetMV;
import com.fineqt.fpb.lib.modelview.FieldMV;
import com.fineqt.fpb.lib.modelview.ModuleElementMV;
import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.modelview.ModuleParMV;
import com.fineqt.fpb.lib.modelview.TemplateMV;
import com.fineqt.fpb.lib.modelview.TypeMV;
import com.fineqt.fpb.lib.modelview.ModuleElementMV.Type;
import com.fineqt.fpb.lib.util.ParserException;
import com.fineqt.fpb.lib.util.T34fpbLiteralParser;

public class ModuleSymbol extends SymbolElement implements ModuleMV {
	public static final String MODULE_JAVA_CLASS_PRP = "ModuleJavaClass";
	public static final String FACTORY_JAVA_CLASS_PRP = "FactoryJavaClass";
	public static final String TYPE_EV_FACTORY_JAVA_CLASS_PRP = "TypeEvFactoryJavaClass";
	
	private PModuleParsingContext parsingContext;	
	private ParserHelper parserHelper;
	private String name;
	private Map<String, ModuleElementMV> elementMap = new HashMap<String, ModuleElementMV>();
	private List<ModuleElementMV> elementList = new ArrayList<ModuleElementMV>();
	private Map<String, ModuleMV> importedModules = new HashMap<String, ModuleMV>();
	protected List<String> pentityTypes = new ArrayList<String>();
	protected List<String> pimportTypes = new ArrayList<String>();
	protected List<String> psubTypes = new ArrayList<String>();
	protected List<String> pentityTemplates = new ArrayList<String>();
	protected List<String> pimportTemplates = new ArrayList<String>();
	protected List<String> pentityConstants = new ArrayList<String>();
	protected List<String> pimportConstants = new ArrayList<String>();
	protected List<String> pentityModulePars = new ArrayList<String>();
	protected List<String> pimportModulePars = new ArrayList<String>();
	protected List<String> pentityEnumSets = new ArrayList<String>();
	protected List<String> pimportEnumSets = new ArrayList<String>();
	private PModule model;
	private PPropertyList variantPropertyList;
	private SimplePropertyList runtimePropertyList;
	private List<ImportElementSpec> importElementSpecList = new ArrayList<ImportElementSpec>();
	
	public ModuleSymbol(PModuleParsingContext parsingContext, ParserHelper parserHelper) {
	    this.parsingContext = parsingContext;
	    this.parserHelper = parserHelper;
	}

	@Override
	public Collection<ModuleElementMV> allModuleElements() {
		return elementMap.values();
	}
	
	/**
	 * 取得所有元素（包括重名的）
	 */
	public List<ModuleElementMV> getModuleElementList() {
		return elementList;
	}
	
    public PModule getModel() {
        return model;
    }

    public void setModel(PModule module) {
        model = module;
    }

    public PPropertyList getVariantPropertyList() {
        return variantPropertyList;
    }

    public void setVariantPropertyList(PPropertyList propertyList) {
        this.variantPropertyList = propertyList;
    }

    public SimplePropertyList getRuntimePropertyList() {
        return runtimePropertyList;
    }

    public void setRuntimePropertyList(SimplePropertyList runtimePropertyList) {
        this.runtimePropertyList = runtimePropertyList;
    }

    public PModuleParsingContext getParsingContext() {
        return parsingContext;
    }
    
	@Override
	public ModuleElementMV pModuleElement(Type type, String name) {
		if (type != null) {
			switch(type) {
			case TYPE:
				return pTypeMV(name);
			case CONSTANT:
				return pConstantMV(name);
			case MODULE_PARAMETER:
				return pModuleParMV(name);
			case TEMPLATE:
				return pTemplateMV(name);
			case ENUM_SET:
				return pEnumSetMV(name);
			}
			assert false;
			return null;
		} else {
			return elementMap.get(name);
		}
	}

	@Override
	public List<String> pEntityElements(Type type) {
		switch(type) {
		case TYPE:
			return pentityTypes;
		case CONSTANT:
			return pentityConstants;
		case MODULE_PARAMETER:
			return pentityModulePars;
		case TEMPLATE:
			return pentityTemplates;
		case ENUM_SET:
			return pentityEnumSets;
		}
		assert false;
		return null;
	}

	@Override
	public List<String> pImportElements(Type type) {
		switch(type) {
		case TYPE:
			return pimportTypes;
		case CONSTANT:
			return pimportConstants;
		case MODULE_PARAMETER:
			return pimportModulePars;
		case TEMPLATE:
			return pimportTemplates;
		case ENUM_SET:
			return pimportEnumSets;
		}
		assert false;
		return null;
	}

	@Override
	public ConstantMV pConstantMV(String name) {
		ModuleElementMV result = elementMap.get(name);
		if (result instanceof ConstantMV) {
			return (ConstantMV)result;
		}
		return null;
	}

	@Override
	public ModuleMV pImportedModuleMV(String moduleName) {
		return (ModuleMV)importedModules.get(moduleName);
	}

	@Override
	public ModuleParMV pModuleParMV(String name) {
		ModuleElementMV result = elementMap.get(name);
		if (result instanceof ModuleParMV) {
			return (ModuleParMV)result;
		}
		return null;
	}

	@Override
	public String getModuleName() {
		return name;
	}

	@Override
	public TemplateMV pTemplateMV(String name) {
		ModuleElementMV result = elementMap.get(name);
		if (result instanceof TemplateMV) {
			return (TemplateMV)result;
		}
		return null;
	}

	@Override
	public TypeMV pTypeMV(String name) {
		ModuleElementMV result = elementMap.get(name);
		if (result instanceof TypeMV) {
			return (TypeMV)result;
		}
		return null;
	}

	@Override
	public EnumSetMV pEnumSetMV(String name) {
		ModuleElementMV result = elementMap.get(name);
		if (result instanceof EnumSetMV) {
			return (EnumSetMV)result;
		}
		return null;
	}


	@Override
	public List<String> pSubTypes() {
		return psubTypes;
	}

	@Override
	public ModuleElementMV pModuleElement(String name) {
		ModuleElementMV element = elementMap.get(name);
		if (element == null) {
			return null;
		}
		return element;
	}

	public void addModuleElement(ModuleElementMV element) {
		switch(element.getModuleElementType()) {
		case TYPE:
			addTypeMV((TypeMV)element);
			break;
		case CONSTANT:
			addConstantMV((ConstantMV)element);
			break;
		case ENUM_SET:
			addEnumSetMV((EnumSetMV)element);
			break;
		case MODULE_PARAMETER:
			addModuleParMV((ModuleParMV)element);
			break;
		case TEMPLATE:
			addTemplateMV((TemplateMV)element);
			break;
		}
	}
	
	public void addTypeMV(TypeMV type) {
		addElement(type);
		switch(type.getDerivativeMode()) {
		case ENTITY:
			pentityTypes.add(type.getFullName());
			break;
		case IMPORT:
			pimportTypes.add(type.getFullName());
			break;
		case SUB:
			psubTypes.add(type.getFullName());
			break;
		}
	}
	
	public void addTemplateMV(TemplateMV template) {
		addElement(template);
		if (template.isImport()) {
			pimportTemplates.add(template.getFullName());
		} else {
			pentityTemplates.add(template.getFullName());
		}
	}
	
	public void addConstantMV(ConstantMV constant) {
		addElement(constant);
		if (constant.isImport()) {
			pimportConstants.add(constant.getFullName());
		} else {
			pentityConstants.add(constant.getFullName());
		}
	}
	
	public void addModuleParMV(ModuleParMV modulePar) {
		addElement(modulePar);
		if (modulePar.isImport()) {
			pimportModulePars.add(modulePar.getFullName());
		} else {
			pentityModulePars.add(modulePar.getFullName());
		}
	}

	public void addEnumSetMV(EnumSetMV EnumSet) {
		addElement(EnumSet);
		if (EnumSet.isImport()) {
			pimportEnumSets.add(EnumSet.getFullName());
		} else {
			pentityEnumSets.add(EnumSet.getFullName());
		}
	}
	
	private void addElement(ModuleElementMV element) {
		//加入Map（覆盖已有的）
		if (!element.isImport() || !elementMap.containsKey(element.getName())) {
			elementMap.put(element.getName(), element);
		}
		elementMap.put(element.getFullName(), element);
//		//加入ImportModule
//		if (element.isImport()) {
//			String importModuleName = null;
//			if (element instanceof ImportModuleElementSymbolBase) {
//				importModuleName = 
//					((ImportModuleElementSymbolBase)element).getImportedModuleName();
//			} else if (element instanceof ImportTypeSymbol) {
//				importModuleName = 
//					((ImportTypeSymbol)element).getImportedModuleName();
//			}
//			ModuleMV importModule = mvManager.getModule(importModuleName);
//			if (importModule != null) {
//				importedModules.put(importModuleName, importModule);
//			}
//		}
		//加入List（无条件加入）
		elementList.add(element);
	}

	public void prepareCreatingSymbol() {
        //定义import builtin模块的类型
        addSimpleImportMV(BuiltinModule.BUILTIN_MODULE_NAME, BuiltinModule.BuiltinNames.PINTEGER);
        addSimpleImportMV(BuiltinModule.BUILTIN_MODULE_NAME, BuiltinModule.BuiltinNames.PFLOAT);
        addSimpleImportMV(BuiltinModule.BUILTIN_MODULE_NAME, BuiltinModule.BuiltinNames.POBJID);
        addSimpleImportMV(BuiltinModule.BUILTIN_MODULE_NAME, BuiltinModule.BuiltinNames.PBOOLEAN);
        addSimpleImportMV(BuiltinModule.BUILTIN_MODULE_NAME, BuiltinModule.BuiltinNames.PBITSTRING);
        addSimpleImportMV(BuiltinModule.BUILTIN_MODULE_NAME, BuiltinModule.BuiltinNames.PHEXSTRING);
        addSimpleImportMV(BuiltinModule.BUILTIN_MODULE_NAME, BuiltinModule.BuiltinNames.POCTETSTRING);
        addSimpleImportMV(BuiltinModule.BUILTIN_MODULE_NAME, BuiltinModule.BuiltinNames.PCHARSTRING);
        addSimpleImportMV(BuiltinModule.BUILTIN_MODULE_NAME, BuiltinModule.BuiltinNames.PUCHARSTRING);
        addSimpleImportMV(BuiltinModule.BUILTIN_MODULE_NAME, BuiltinModule.BuiltinNames.PVERDICT);
//      addSimpleImportMV(BuiltinModule.BUILTIN_MODULE_NAME, BuiltinModule.BuiltinNames.PADDRESS);
	}

    public void createNoImportElementSymbol() throws ParserException {
        //压入堆栈
        parsingContext.pushModuleInParsing(this);
        try {
            //编译依赖模块
            for (ImportElementSpec spec : importElementSpecList) {
                String importedModuleName = spec.getModuleName();
                ModuleElementMV.Type targetType = spec.getTargetElementType();
                //判断是否有非Type的循环引用
                if (targetType != ModuleElementMV.Type.TYPE ) {
                    if (parsingContext.findModuleInParsing(importedModuleName) != null) {
                        parserHelper.addErrorMsg(getStartPosition(spec.getStartToken()), 
                                MetaException.CODE.RECURSIVE_MODULE_IMPORT_ERROR, 
                                parsingContext.getModuleInParsingStack());
                        return;
                    }
                }
                //编译
                ModuleMV importModule = parsingContext.getCreatedModule(importedModuleName);
                if (importModule == null) {
                    T34fpbLiteralParser.INSTANCE.createNoImportElementSymbol(
                            importedModuleName, parsingContext);
                }
            }
        } finally {
            //弹出堆栈
            parsingContext.popModuleInParsing();
        }
        
    }
    
    public void createImportElemenSymbol() {
        for (ImportElementSpec spec : importElementSpecList) {
            String importedModuleName = spec.getModuleName();
            ModuleElementMV.Type targetType = spec.getTargetElementType();
            List<String> targetNames = spec.getTargetElementNames();
            //取得已生成模块视图
            ModuleMV importModule = parsingContext.getCreatedModule(importedModuleName);
            if (importModule == null) {
                parserHelper.addErrorMsg(getStartPosition(spec.getStartToken()), 
                        MetaException.CODE.MODULE_NOT_FOUND_REGISTRY_ERROR, 
                        importedModuleName);
                return;
            }
            //导入所有元素
            if (targetType == null) {
                importAllElement(importedModuleName, null, importModule);
            //导入特定类型的所有元素
            } else if (targetNames == null 
                    || targetNames.size() == 0) {
                importAllElement(importedModuleName, targetType, importModule);
            //导入特定元素
            } else {
                importSpecElements(importedModuleName, targetType, targetNames, 
                        importModule);
            }
        }
    }

    public void resolveReference() {
        //解决SubType引用的类型和模块
        resolveSubTypeRef();
        
        //解决List或Container,EnumSet等实体元素内的类型引用
        resolveTypeRefOfEntityElement();
        
        //解决Import元素的引用
        resolveImportElementRef();
    }
    
    public void validateModuleElements() {
        Set<String> gotElementNames = new HashSet<String>();
        for (ModuleElementMV element : elementList) {
            String fullName = element.getFullName();
            //模型元素名称重复
            if (gotElementNames.contains(fullName)) {
                SymbolElement sele = (SymbolElement)element;
                parserHelper.addErrorMsg(
                        sele.getStartPosition(), 
                        MetaException.CODE.ELEMENT_DEFINITION_DUPLICATED_ERROR, 
                        fullName);
            } else {
                gotElementNames.add(fullName);
            }
            //字段名称重复检测
            if (element instanceof ContainerTypeSymbol) {
                ContainerTypeSymbol csymbol = (ContainerTypeSymbol)element;
                List<FieldMV> fieldList = csymbol.getFieldList();
                Set<String> gotFieldNames = new HashSet<String>();
                for (FieldMV field : fieldList) {
                    if (gotFieldNames.contains(field.getFieldName())) {
                        FieldSymbol fele = (FieldSymbol)field;
                        parserHelper.addErrorMsg(fele.getStartPosition(), 
                                MetaException.CODE.FIELD_DEFINITION_DUPLICATED_ERROR, 
                                field.getFieldName());
                    } else {
                        gotFieldNames.add(field.getFieldName());
                    }
                }
            }
            //枚举项目名称重复检测
            if (element instanceof EnumeratedTypeSymbol) {
                EnumeratedTypeSymbol esymbol = (EnumeratedTypeSymbol)element;
                Set<String> gotItemNames = new HashSet<String>();
                for (EnumTypeItemSymbol item : esymbol.getItems()) {
                    String enumName = item.getModel().getEnumName();
                    if (gotItemNames.contains(enumName)) {
                        parserHelper.addErrorMsg(item.getStartPosition(), 
                                MetaException.CODE.ENUM_ITEM_DEFINITION_DUPLICATED_ERROR, 
                                enumName);
                    } else {
                        gotItemNames.add(enumName);
                    }
                }
            }
        }
    }
    
    public void prepareCreatingModuleModel() {
        //PModule创建和加入模型结果
        PModule pmodule = mfactory.createPModule();
        setModel(pmodule);
        
        //定义import builtin模块的类型
        setBuiltinTypeModel(BuiltinModule.BUILTIN_MODULE_NAME, 
                BuiltinModule.BuiltinNames.PINTEGER, BuiltinModule.PINTEGER);
        setBuiltinTypeModel(BuiltinModule.BUILTIN_MODULE_NAME, 
                BuiltinModule.BuiltinNames.PFLOAT, BuiltinModule.PFLOAT);
        setBuiltinTypeModel(BuiltinModule.BUILTIN_MODULE_NAME, 
                BuiltinModule.BuiltinNames.POBJID, BuiltinModule.POBJID);
        setBuiltinTypeModel(BuiltinModule.BUILTIN_MODULE_NAME, 
                BuiltinModule.BuiltinNames.PBOOLEAN, BuiltinModule.PBOOLEAN);
        setBuiltinTypeModel(BuiltinModule.BUILTIN_MODULE_NAME, 
                BuiltinModule.BuiltinNames.PBITSTRING, BuiltinModule.PBITSTRING);
        setBuiltinTypeModel(BuiltinModule.BUILTIN_MODULE_NAME, 
                BuiltinModule.BuiltinNames.PHEXSTRING, BuiltinModule.PHEXSTRING);
        setBuiltinTypeModel(BuiltinModule.BUILTIN_MODULE_NAME, 
                BuiltinModule.BuiltinNames.POCTETSTRING, BuiltinModule.POCTETSTRING);
        setBuiltinTypeModel(BuiltinModule.BUILTIN_MODULE_NAME, 
                BuiltinModule.BuiltinNames.PCHARSTRING, BuiltinModule.PCHARSTRING);
        setBuiltinTypeModel(BuiltinModule.BUILTIN_MODULE_NAME, 
                BuiltinModule.BuiltinNames.PUCHARSTRING, BuiltinModule.PUCHARSTRING);
        setBuiltinTypeModel(BuiltinModule.BUILTIN_MODULE_NAME, 
                BuiltinModule.BuiltinNames.PVERDICT, BuiltinModule.PVERDICT);
//      setBuiltinTypeModel(BuiltinModule.BUILTIN_MODULE_NAME, 
//              BuiltinModule.BuiltinNames.PADDRESS, BuiltinModule.PADDRESS);
        
    }
    
	@Override
	protected void doInitModel(ParserHelper cxt) {
		//module variant propertyList
		EncodingType moduleEncode = model.getEncode();
		if (moduleEncode != null && moduleEncode != EncodingType.NONE) {
			switch(moduleEncode) {
			case FPB:
				PFpbModuleEV moduleEV = mfactory.createPFpbModuleEV();
				if (variantPropertyList != null) {
					moduleEV.setPrpList(variantPropertyList);
				} else {
					moduleEV.setPrpList(mfactory.createPPropertyList());
				}
				model.setVariant(moduleEV);
				break;
			default:
				assert false;
				break;
			}
		}
		//module runtime propertyList
		if (runtimePropertyList != null) {
			String value;
			//ModuleJavaClass
			value = runtimePropertyList.getProperty(MODULE_JAVA_CLASS_PRP);
			if (value != null) {
				model.setModuleJavaClass(value);
			}
			//FactoryJavaClass
			value = runtimePropertyList.getProperty(FACTORY_JAVA_CLASS_PRP);
			if (value != null) {
				model.setFactoryJavaClass(value);
			}
			//TypeEvFactoryJavaClass
			value = runtimePropertyList.getProperty(TYPE_EV_FACTORY_JAVA_CLASS_PRP);
			if (value != null) {
				model.setTypeEvFactoryJavaClass(value);
			}
		}
		//elements
		for (ModuleElementMV element : elementMap.values()) {
			SymbolElement symbol = (SymbolElement)element;
			symbol.initModel(cxt);
		}
		//检验循环引用(在所有的ValueReference初始化结束之后)
		validateValueReference(cxt);
        //分配ID
        assignModuleElementID();
	}
	
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        builder.append("module name", getModuleName());
        builder.append(LN);
        for (int i = 0; i < pentityTypes.size(); i++) {
            builder.append("pentityTypes["+i+"]: " + elementMap.get(pentityTypes.get(i)));
            builder.append(LN);
        }
        for (int i = 0; i < pimportTypes.size(); i++) {
            builder.append("pimportTypes["+i+"]: " + elementMap.get(pimportTypes.get(i)));
            builder.append(LN);
        }
        for (int i = 0; i < psubTypes.size(); i++) {
            builder.append("psubTypes["+i+"]: " +  elementMap.get(psubTypes.get(i)));
            builder.append(LN);
        }
        for (int i = 0; i < pentityTemplates.size(); i++) {
            builder.append("pentityTemplates["+i+"]: " +  elementMap.get(pentityTemplates.get(i)));
            builder.append(LN);
        }
        for (int i = 0; i < pimportTemplates.size(); i++) {
            builder.append("pimportTemplates["+i+"]: " +  elementMap.get(pimportTemplates.get(i)));
            builder.append(LN);
        }
        for (int i = 0; i < pentityConstants.size(); i++) {
            builder.append("pentityConstants["+i+"]: " +  elementMap.get(pentityConstants.get(i)));
            builder.append(LN);
        }
        for (int i = 0; i < pimportConstants.size(); i++) {
            builder.append("pimportConstants["+i+"]: " +  elementMap.get(pimportConstants.get(i)));
            builder.append(LN);
        }
        for (int i = 0; i < pentityModulePars.size(); i++) {
            builder.append("pentityModulePars["+i+"]: " +  elementMap.get(pentityModulePars.get(i)));
            builder.append(LN);
        }
        for (int i = 0; i < pimportModulePars.size(); i++) {
            builder.append("pimportModulePars["+i+"]: " +  elementMap.get(pimportModulePars.get(i)));
            builder.append(LN);
        }
        for (int i = 0; i < pentityEnumSets.size(); i++) {
            builder.append("pentityEnumSets["+i+"]: " +  elementMap.get(pentityEnumSets.get(i)));
            builder.append(LN);
        }
        for (int i = 0; i < pimportEnumSets.size(); i++) {
            builder.append("pimportEnumSets["+i+"]: " +  elementMap.get(pimportEnumSets.get(i)));
            builder.append(LN);
        }
        return builder.toString();
    }

    private void resolveImportElementRef() {
        List<String> fullNames;
        //Type
        fullNames = pImportElements(ModuleElementMV.Type.TYPE);
        for (String name : fullNames) {
            ImportTypeSymbol symbol = (ImportTypeSymbol)pTypeMV(name);
            symbol.resolveImportRef();
        }
        //Constant
        fullNames = pImportElements(ModuleElementMV.Type.CONSTANT);
        for (String name : fullNames) {
            ImportConstantSymbol symbol = (ImportConstantSymbol)pConstantMV(name);
            symbol.resolveImportRef();
        }
        //ModulePar
        fullNames = pImportElements(ModuleElementMV.Type.MODULE_PARAMETER);
        for (String name : fullNames) {
            ImportModuleParSymbol symbol = (ImportModuleParSymbol)pModuleParMV(name);
            symbol.resolveImportRef();
        }
        //EnumSet
        fullNames = pImportElements(ModuleElementMV.Type.ENUM_SET);
        for (String name : fullNames) {
            ImportEnumSetSymbol symbol = (ImportEnumSetSymbol)pEnumSetMV(name);
            symbol.resolveImportRef();
        }
        //Template
        fullNames = pImportElements(ModuleElementMV.Type.TEMPLATE);
        for (String name : fullNames) {
            ImportTemplateSymbol symbol = (ImportTemplateSymbol)pTemplateMV(name);
            symbol.resolveImportRef();
        }
        
    }
    
    private void resolveSubTypeRef() {
        for (String fullName : pSubTypes()) {
            SubTypeSymbol type = (SubTypeSymbol)pTypeMV(fullName);
            TypeMV superType = pTypeMV(type.getSuperTypeName());
            if (superType == null) {
                parserHelper.addErrorMsg(
                        type.getStartPosition(), 
                        MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
                        type.getSuperTypeName(), getModuleName());
                continue;
            }
            type.setSuperType(superType);
        }
    }
    
    private void resolveTypeRefOfEntityElement() {
        for (String  fullName : pEntityElements(ModuleElementMV.Type.TYPE)) {
            TypeMV type = pTypeMV(fullName);
            //处理ContainerType(record, set, union)
            if (type instanceof ContainerTypeSymbol) {
                ContainerTypeSymbol containerType = (ContainerTypeSymbol)type;
                for (String  fieldName : containerType.getFieldNames()) {
                    FieldSymbol field = (FieldSymbol)containerType.getFieldMV(fieldName);
//                    System.out.println("fieldName:"+fieldName);
                    assert field.getFieldTypeName() != null;
                    TypeMV fieldType = pTypeMV(field.getFieldTypeName());
                    if (fieldType == null) {
                        parserHelper.addErrorMsg(
                                field.getStartPosition(), 
                                MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
                                field.getFieldTypeName(), getModuleName());
                        continue;
                    }
                    field.setFieldTypeMV(fieldType);
                }
            //处理ListType(setOf, recordOf)
            } else if (type instanceof ListTypeSymbol) {
                ListTypeSymbol listType = (ListTypeSymbol)type;
                ListItemSymbol item = listType.getListItem();
                assert item.getItemTypeName() != null;
                TypeMV itemType = pTypeMV(item.getItemTypeName());
                if (itemType == null) {
                    parserHelper.addErrorMsg(
                            listType.getStartPosition(), 
                            MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
                            item.getItemTypeName(), getModuleName());
                    continue;
                }
                item.setItemTypeMV(itemType);
            }
        }
        //EnumSet
        for (String fullName : pEntityElements(ModuleElementMV.Type.ENUM_SET)) {
            EntityEnumSetSymbol entityElement = 
                (EntityEnumSetSymbol)pEnumSetMV(fullName);
            setBaseType(entityElement);
        }
        //Constant
        for (String fullName : pEntityElements(ModuleElementMV.Type.CONSTANT)) {
            EntityConstantSymbol entityElement = 
                (EntityConstantSymbol)pConstantMV(fullName);
            setBaseType(entityElement);
        }
        //ModulePar
        for (String fullName : pEntityElements(ModuleElementMV.Type.MODULE_PARAMETER)) {
            EntityModuleParSymbol entityElement = 
                (EntityModuleParSymbol)pModuleParMV(fullName);
            setBaseType(entityElement);
        }
        //Template
        for (String fullName : pEntityElements(ModuleElementMV.Type.TEMPLATE)) {
            EntityTemplateSymbol entityElement = 
                (EntityTemplateSymbol)pTemplateMV(fullName);
            setBaseType(entityElement);
        }
        
    }
    
    private boolean setBaseType(EntityModuleElementSymbolBase entityElement) {
        assert entityElement.getBaseTypeName() != null;
        TypeMV baseType = pTypeMV(entityElement.getBaseTypeName());
        if (baseType == null) {
            parserHelper.addErrorMsg(
                    entityElement.getStartPosition(), 
                    MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
                    entityElement.getBaseTypeName(), getModuleName());
            return false;
        }
        entityElement.setBaseType(baseType);
        return true;
    }
    
    

    private void importSpecElements(String importedModuleName,
            ModuleElementMV.Type targetType, List<String> targetNames, ModuleMV importModule) {
        for (String elementName : targetNames) {
            String fullName = importedModuleName+"."+elementName;
            if(pModuleElement(targetType, fullName) == null) {
                ModuleElementMV newSymbol = createImportSymbol(targetType,
                        importedModuleName, elementName);
                addModuleElement(newSymbol);
            }
        }
    }

    private ModuleElementMV createImportSymbol(ModuleElementMV.Type targetType,
            String importedModuleName, String elementName) {
        ModuleElementMV newSymbol = null;
        switch(targetType) {
        case TYPE:
            newSymbol = new ImportTypeSymbol(this, importedModuleName,
                    elementName);
            break;
        case CONSTANT:
            newSymbol = new ImportConstantSymbol(this, importedModuleName,
                    elementName);
            break;
        case ENUM_SET:
            newSymbol = new ImportEnumSetSymbol(this, importedModuleName,
                    elementName);
            break;
        case MODULE_PARAMETER:
            newSymbol = new ImportModuleParSymbol(this, importedModuleName,
                    elementName);
            break;
        case TEMPLATE:
            newSymbol = new ImportTemplateSymbol(this, importedModuleName,
                    elementName);
            break;
        }
        return newSymbol;
    }

    private void importAllElement(String importedModuleName,
            ModuleElementMV.Type targetType, ModuleMV importModule) {
        Collection<ModuleElementMV> elements = importModule.allModuleElements();
        for (ModuleElementMV element : elements) {
            if (!element.isImport() && (targetType == null 
                    || element.getModuleElementType() == targetType)) {
                String fullName = element.getFullName();
                if (pModuleElement(targetType, fullName) == null) {
                    ModuleElementMV newSymbol = createImportSymbol(
                            element.getModuleElementType(),
                            importedModuleName, element.getName());
                    assert newSymbol != null;
                    addModuleElement(newSymbol);
                }
            }
        }
    }
    
    public void addImportAll(Token startToken, String importedModuleName) {
        ImportElementSpec spec = new ImportElementSpec(startToken, importedModuleName);
        importElementSpecList.add(spec);
    }

    public void addImportTypeAll(Token startToken, String importedModuleName, 
            ModuleElementMV.Type targetElementType) {
        ImportElementSpec spec = new ImportElementSpec(startToken, importedModuleName);
        spec.setTargetElementType(targetElementType);
        importElementSpecList.add(spec);
    }
    
    public void addImportSpecElements(Token startToken, String importedModuleName, 
            ModuleElementMV.Type targetElementType, List<String> targetElementNames) {
        ImportElementSpec spec = new ImportElementSpec(startToken, importedModuleName);
        spec.setTargetElementType(targetElementType);
        spec.setTargetElementNames(targetElementNames);
        importElementSpecList.add(spec);
    }
    
    private void assignModuleElementID() {
        PModule pmodule = getModel();
        int startId = BuiltinModule.MAX_BUILTIN_TYPE + 1;
        for (PType type : pmodule.getTypes()) {
            if (!type.isSetTypeID()) {
                type.setTypeID(startId++);
            }
        }
        for (PConstant cons : pmodule.getConstants()) {
            if (!cons.isSetConstantID()) {
                cons.setConstantID(startId++);
            }
        }
        for (PModulePar mpar : pmodule.getModulePars()) {
            if (!mpar.isSetModuleParID()) {
                mpar.setModuleParID(startId++);
            }
        }
        for (PTemplate temp : pmodule.getTemplates()) {
            if (!temp.isSetTemplateID()) {
                temp.setTemplateID(startId++);
            }
        }
        for (PEnumSet eset : pmodule.getEnumSets()) {
            if (!eset.isSetEnumSetID()) {
                eset.setEnumSetID(startId++);
            }
        }
    }
    private void addSimpleImportMV(String importedModuleName, 
            String importedTypeName) {
        ImportTypeSymbol importType = new ImportTypeSymbol(this, 
                importedModuleName, importedTypeName); 
        addTypeMV(importType);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    private void validateValueReference(ParserHelper cxt) {
        List<String> names;
        //Constant
        names = pEntityElements(ModuleElementMV.Type.CONSTANT);
        for (String name : names) {
            EntityConstantSymbol symbol = (EntityConstantSymbol)pConstantMV(name);
            List<ValueReferenceSymbol> refs = symbol.getRefValues();
//          System.out.println("topElement:"+symbol);
            for (ValueReferenceSymbol refSymbol : refs) {
                if (findRecursiveValueRef(symbol, refSymbol.getRefElement())) {
                    cxt.addErrorMsg(refSymbol.getStartPosition(), 
                            MetaException.CODE.RECURSIVE_ELEMENT_REFERENCE_ERROR, 
                            refSymbol.getModel().getRefName());
                    return;
                }
            }
        }
        //ModulePar
        names = pEntityElements(ModuleElementMV.Type.MODULE_PARAMETER);
        for (String name : names) {
            EntityModuleParSymbol symbol = (EntityModuleParSymbol)pModuleParMV(name);
            List<ValueReferenceSymbol> refs = symbol.getRefValues();
            for (ValueReferenceSymbol refSymbol : refs) {
                if (findRecursiveValueRef(symbol, refSymbol.getRefElement())) {
                    cxt.addErrorMsg(refSymbol.getStartPosition(), 
                            MetaException.CODE.RECURSIVE_ELEMENT_REFERENCE_ERROR, 
                            refSymbol.getModel().getRefName());
                    return;
                }
            }
        }
        //Template
        //TODO template reference
    }
    
    private void setBuiltinTypeModel(String importedModuleName, String importedTypeName, int id) {
        ImportTypeSymbol typeSymbol = (ImportTypeSymbol)pTypeMV(
                importedModuleName+"."+importedTypeName);
        assert typeSymbol != null;
        //生成模型
        PImportType model = typeSymbol.getModel();
        model.setImportedModuleName(importedModuleName);
        model.setImportedTypeName(importedTypeName);
        model.setTypeID(id);
    }
    
    private boolean findRecursiveValueRef(ModuleElementMV topElement, ModuleElementMV refElement) {
        if (topElement == refElement)
            return true;
//      System.out.println("refElement:"+refElement);
        if (refElement instanceof ModuleElementSymbolBase) {
            ModuleElementSymbolBase refSymbol = (ModuleElementSymbolBase)refElement;
            for (ValueReferenceSymbol valueRef : refSymbol.getRefValues()) {
                if (findRecursiveValueRef(topElement, valueRef.getRefElement()))
                    return true;
            }
        }
        return false;
    }
    
    
    private static class ImportElementSpec {
        private Token startToken;
        private String moduleName;
        private ModuleElementMV.Type targetElementType;
        private List<String> targetElementNames;
        
        public ImportElementSpec(Token startToken, String moduleName) {
            super();
            this.moduleName = moduleName;
            this.startToken = startToken;
        }

        public ModuleElementMV.Type getTargetElementType() {
            return targetElementType;
        }

        public void setTargetElementType(ModuleElementMV.Type targetElementType) {
            this.targetElementType = targetElementType;
        }

        public List<String> getTargetElementNames() {
            return targetElementNames;
        }

        public void setTargetElementNames(List<String> targetElementNames) {
            this.targetElementNames = targetElementNames;
        }

        public String getModuleName() {
            return moduleName;
        }

        public Token getStartToken() {
            return startToken;
        }
        
        public String toString() {
            return new ToStringBuilder(this)
            .append("moduleName", moduleName)
            .append("targetElementType", targetElementType)
            .append("targetElementNames", targetElementNames)
            .toString();
        }
    }

    public ParserHelper getParserHelper() {
        return parserHelper;
    }

}
