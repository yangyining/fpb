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
package com.fineqt.fpb.lib.meta.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.fineqt.fpb.lib.builtin.impl.AbstractBuiltinModule;
import com.fineqt.fpb.lib.meta.PConstantExt;
import com.fineqt.fpb.lib.meta.PEnumSetExt;
import com.fineqt.fpb.lib.meta.PFactoryExt;
import com.fineqt.fpb.lib.meta.PModuleElementExt;
import com.fineqt.fpb.lib.meta.PModuleExtEventListener;
import com.fineqt.fpb.lib.meta.PModuleParExt;
import com.fineqt.fpb.lib.meta.context.PModuleInitContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.util.PElementExtFactory;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.PConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.PModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplate;
import com.fineqt.fpb.lib.modelview.ModuleElementMV;
import com.fineqt.fpb.lib.modelview.ModuleElementMV.Type;
import com.fineqt.fpb.lib.template.PTemplateExt;
import com.fineqt.fpb.lib.type.PTypeExt;

abstract public class PUserModuleExtBase extends AbstractBuiltinModule {
	protected Map<Integer, PModuleElementExt> elements = new HashMap<Integer, PModuleElementExt>();
	
	public PUserModuleExtBase() {
	}

	public PUserModuleExtBase(PFactoryExt factory) {
		super(factory);
	}
	
	protected void initializeModule() throws InitMetaException {
		assert pmodel != null;
		//Encoding
		EncodingType encoding = pmodel.getEncode();
		if (!encoding.equals(EncodingType.NONE)) {
			encodingType = encoding;
		}
		super.initializeModule();
	}
	
	@Override
    public void creatModuleContents(PModule model, PModuleInitContext cxt)
            throws InitMetaException {
        assert model != null;
        pmodel = model;
        createModuleContents();        
    }

    @Override
    public void initModule(PModuleInitContext cxt) throws InitMetaException {
        //前置事件
        for (PModuleExtEventListener lsn : eventLsns) {
            lsn.preInitModule(this);
        }

        //初始化所有模块本身
        initializeModule();
        
        //后置事件
        for (PModuleExtEventListener lsn : eventLsns) {
            lsn.postInitModule(this);
        }
    }

    @Override
    public void initModuleElements(PModuleInitContext cxt) throws InitMetaException {
        //初始化所有的元素
        for (PModuleElementExt item : elements.values()) {
            item.init();
        }
    }

    @Override
    public void resolveReference(PModuleInitContext cxt) throws InitMetaException {
        //解决ImportedType引用的类型和模型
        resolveImportedTypeRef(cxt);

        //解决ImportConstant引用的常数和模块
        resolveImportedConsRef(cxt);
        
        //解决ImportModulepar引用的模块参数和模块
        resolveImportedMparRef(cxt);
        
        //解决ImportTemplate引用的模板和模块
        resolveImportedTempRef(cxt);

        //解决ImportEnumSet引用的枚举集合和模块
        resolveImportedEnumSetRef(cxt);
        
        //解决SubType引用的类型和模型
        resolveSubTypeRef();
        
        //解决Field或ListItem引用的类型和模型
        resolveFieldTypeRef();
        
//      System.out.println(this);
    }

    protected void createModuleContents() throws InitMetaException {
		assert pmodel != null;
		super.createModuleContents();
		
		//Types
		for (PType typeModel : pmodel.getTypes()) {
			PTypeExt typeMeta;
			if (typeModel.getJavaClass() != null) {
				try {
					@SuppressWarnings("unchecked")
					Class<PTypeExt> typeClass = (Class<PTypeExt>)Class.forName(typeModel.getJavaClass());
					typeMeta = PElementExtFactory.INSTANCE.createType(typeClass, this, typeModel);					
				} catch (ClassNotFoundException e) {
					throw new InitMetaException(this, MetaException.CODE.UNKOWN_ERROR, e);
				}
			} else {
				typeMeta = PElementExtFactory.INSTANCE.createCompactType(this, typeModel);
			}
			//Module中加入该类型
			addType(typeMeta);
		}
		
		//Constant
		for (PConstant cons : pmodel.getConstants()) {
			PConstantExt meta = PElementExtFactory.INSTANCE.createConstant(this, cons);
			addConstant(meta);
		}
		
		//ModulePar
		for (PModulePar mpar : pmodel.getModulePars()) {
			PModuleParExt meta = PElementExtFactory.INSTANCE.createModulePar(this, mpar);
			addModulePar(meta);
		}
		
		//Template
		for (PTemplate temp : pmodel.getTemplates()) {
			PTemplateExt meta = PElementExtFactory.INSTANCE.createTemplate(this, temp);
			addTemplate(meta);
		}
		
		//EnumSet
		for (PEnumSet enumSet : pmodel.getEnumSets()) {
			PEnumSetExt meta = PElementExtFactory.INSTANCE.createEnumSet(this, enumSet);
			addEnumSet(meta);
		}

//		System.out.println(this);
		
	}
	
	@Override
	protected <T extends PTypeExt> T createTypeExt(Class<T> cls, PType pmodel,
			int ptypeID) {
		T result = super.createTypeExt(cls, pmodel, ptypeID);
		elements.put(ptypeID, result);
		return result;
	}

	protected void addType(PTypeExt result) {
		super.addType(result);
		elements.put(result.getID(), result);
	}
	
	@Override
	protected void addConstant(PConstantExt constant) {
		super.addConstant(constant);
		elements.put(constant.getID(), constant);
		
	}

	@Override
	protected void addEnumSet(PEnumSetExt enumSet) {
		super.addEnumSet(enumSet);
		elements.put(enumSet.getID(), enumSet);
	}

	@Override
	protected void addModulePar(PModuleParExt modulePar) {
		super.addModulePar(modulePar);
		elements.put(modulePar.getID(), modulePar);
	}

	@Override
	protected void addTemplate(PTemplateExt template) {
		super.addTemplate(template);
		elements.put(template.getID(), template);
	}

	@Override
	public PTypeExt pPType(int typeID) {
		PModuleElementExt element = elements.get(typeID);
		if (element == null)
			return null;
		return element.getModuleElementType() == PModuleElementExt.Type.TYPE ? 
				(PTypeExt)element : null;
	}

	@Override
	public PTemplateExt pPTemplate(int templateID) {
		PModuleElementExt element = elements.get(templateID);
		if (element == null)
			return null;
		return element.getModuleElementType() == PModuleElementExt.Type.TEMPLATE ? 
				(PTemplateExt)element : null;
	}

	@Override
	public PConstantExt pPConstant(int constantID) {
		PModuleElementExt element = elements.get(constantID);
		if (element == null)
			return null;
		return element.getModuleElementType() == PModuleElementExt.Type.CONSTANT ? 
				(PConstantExt)element : null;
	}

	@Override
	public PModuleParExt pPModulePar(int moduleParID) {
		PModuleElementExt element = elements.get(moduleParID);
		if (element == null)
			return null;
		return element.getModuleElementType() == PModuleElementExt.Type.MODULE_PARAMETER ? 
				(PModuleParExt)element : null;
	}

	@Override
	public PEnumSetExt pPEnumSet(int enumSetID) {
		PModuleElementExt element = elements.get(enumSetID);
		if (element == null)
			return null;
		return element.getModuleElementType() == PModuleElementExt.Type.ENUM_SET ? 
				(PEnumSetExt)element : null;
	}
	
	@Override
	public Collection<ModuleElementMV> allModuleElements() {
		ArrayList<ModuleElementMV> result = new ArrayList<ModuleElementMV>();
		result.addAll(elements.values());
		return result;
	}

	@Override
	public ModuleElementMV pModuleElement(String name) {
		Integer id = elementNameIDMap.get(name);
		if (id == null) {
			return null;
		}
		PModuleElementExt element = elements.get(id);
		if (element == null)
			return null;
		return element;
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
			Integer id = elementNameIDMap.get(name);
			if (id == null) {
				return null;
			}
			return elements.get(id);
		}
	}
	
	@Override
	public PTypeExt getBitstring() {
		return pPType(PBITSTRING);
	}

	@Override
	public PTypeExt getBoolean() {
		return pPType(PBOOLEAN);
	}

	@Override
	public PTypeExt getCharstring() {
		return pPType(PCHARSTRING);
	}

	@Override
	public PTypeExt getFloat() {
		return pPType(PFLOAT);
	}

	@Override
	public PTypeExt getHexstring() {
		return pPType(PHEXSTRING);
	}

	@Override
	public PTypeExt getInteger() {
		return pPType(PINTEGER);
	}

	@Override
	public PTypeExt getObjid() {
		return pPType(POBJID);
	}

	@Override
	public PTypeExt getOctetstring() {
		return pPType(POCTETSTRING);
	}

	@Override
	public PTypeExt getUniversalCharstring() {
		return pPType(PUCHARSTRING);
	}

	@Override
	public PTypeExt getVerdict() {
		return pPType(PVERDICT);
	}
	
//	private void setEmptyTypeEv(PType typemodel, EncodingType encoding) {
//		switch (encoding) {
//		case FPB:
//			setFpbTypeEV(typemodel);
//			break;
//		case ASN1:
//			assert false;
//			break;
//		default:
//			break;
//		}
//	}

}
