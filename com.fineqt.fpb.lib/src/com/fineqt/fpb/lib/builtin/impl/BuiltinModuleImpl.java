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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fineqt.fpb.lib.builtin.BuiltinModule;
import com.fineqt.fpb.lib.meta.PConstantExt;
import com.fineqt.fpb.lib.meta.PEnumSetExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.PModuleParExt;
import com.fineqt.fpb.lib.meta.PModuleExt.Registry.ModuleResource;
import com.fineqt.fpb.lib.meta.context.PModuleInitContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.impl.AbstractPModuleExtProxy;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.modelview.ModuleElementMV;
import com.fineqt.fpb.lib.modelview.ModuleElementMV.Type;
import com.fineqt.fpb.lib.template.PTemplateExt;
import com.fineqt.fpb.lib.type.PPrimitiveTypeExt;
import com.fineqt.fpb.lib.type.PStringTypeExt;
import com.fineqt.fpb.lib.type.PTypeExt;

public class BuiltinModuleImpl extends AbstractBuiltinModule {
	private static BuiltinModuleImpl instance;

	private PPrimitiveTypeExt pInteger;
	private PPrimitiveTypeExt pFloat;
	private PPrimitiveTypeExt pObjid;
	private PPrimitiveTypeExt pBoolean;
	private PStringTypeExt pCharstring;
	private PStringTypeExt pUCharstring;
	private PStringTypeExt pBitstring;
	private PStringTypeExt pHexstring;
	private PStringTypeExt pOctetstring;
	private PPrimitiveTypeExt pVerdict;
	
	private BuiltinModuleImpl() {
		super(BuiltinFactoryImpl.init());
	}

	synchronized public static PModuleExt init() throws InitMetaException {
//		System.out.println("init BuiltinModuleImpl");
		PModuleExt moduleMeta = PModuleExt.Registry.PINSTANCE.resolvePModule(
				BuiltinModule.BUILTIN_MODULE_NAME);
		if (moduleMeta != null) {
			return moduleMeta;
		}
		if (instance == null) {
			instance = new BuiltinModuleImpl();

			PModuleExt.Registry.PINSTANCE.register(new AbstractPModuleExtProxy(
					BuiltinModule.BUILTIN_MODULE_NAME){
				@Override
				protected PModuleExt doResolveModule() throws InitMetaException {
					return instance;
				}

                @Override
                public ModuleResource getResource() {
                    throw new UnsupportedOperationException();
                }
				
			});
			
			instance.createModuleContents();
			
			instance.initializeModule();

		}
		return instance;
	}

	@Override
    public void creatModuleContents(PModule model, PModuleInitContext cxt)
            throws InitMetaException {
	    throw new UnsupportedOperationException();        
    }

    @Override
    public void initModule(PModuleInitContext cxt) throws InitMetaException {
        throw new UnsupportedOperationException();        
    }

    @Override
    public void initModuleElements(PModuleInitContext cxt) throws InitMetaException {
        throw new UnsupportedOperationException();        
    }

    @Override
    public void resolveReference(PModuleInitContext cxt) throws InitMetaException {
        throw new UnsupportedOperationException();        
    }

    @Override
	public ModuleElementMV pModuleElement(String name) {
		//只有Type类型元素
		PTypeExt typeMeta = pPType(name);
		if (typeMeta == null) {
			return null;
		}
		return typeMeta;
	}

	@Override
	public ModuleElementMV pModuleElement(Type type, String name) {
		if (type != null) {
			switch(type) {
			case TYPE:
				return pPType(name);
			}
			return null;
		} else {
			return pPType(name);
		}
	}

	@Override
	public Collection<ModuleElementMV> allModuleElements() {
		List<ModuleElementMV> result = new ArrayList<ModuleElementMV>();
		result.addAll(ptypes);
		return result;
	}

	@Override
	public PTypeExt pPType(int typeID) {
		return getBuiltinTypeExt(typeID);
	}

	@Override
	public PTemplateExt pPTemplate(int templateID) {
		return null;
	}

	@Override
	public PConstantExt pPConstant(int constantID) {
		return null;
	}

	@Override
	public PModuleParExt pPModulePar(int moduleParID) {
		return null;
	}

	@Override
	public PEnumSetExt pPEnumSet(int enumSetID) {
		return null;
	}

	public PPrimitiveTypeExt getInteger() {
		return pInteger;
	}

	@Override
	public PStringTypeExt getBitstring() {
		return pBitstring;
	}

	@Override
	public PPrimitiveTypeExt getBoolean() {
		return pBoolean;
	}

	@Override
	public PStringTypeExt getCharstring() {
		return pCharstring;
	}

	@Override
	public PPrimitiveTypeExt getFloat() {
		return pFloat;
	}

	@Override
	public PPrimitiveTypeExt getHexstring() {
		return pHexstring;
	}

	@Override
	public PPrimitiveTypeExt getObjid() {
		return pObjid;
	}

	@Override
	public PStringTypeExt getOctetstring() {
		return pOctetstring;
	}

	@Override
	public PStringTypeExt getUniversalCharstring() {
		return pUCharstring;
	}

	@Override
	public PPrimitiveTypeExt getVerdict() {
		return pVerdict;
	}

	protected void createModuleContents() {
		PType tempmodel;
		//TypeEVExtFactory
		pTypeEVExtFactory(BuiltinFpbTypeEVExtFactoryImpl.init());
		
		//生成Module的模型
		pmodel = createPModuleModel(BUILTIN_MODULE_NAME, null);

		super.createModuleContents();
		
		//生成PTypeExt和它的模型
		tempmodel = createPEntityTypeModel(FPBPKG_L.PINTEGER, BuiltinNames.PINTEGER, null);
		pInteger = createTypeExt(PIntegerTypeExtImpl.class, tempmodel, PINTEGER);
		
		tempmodel = createPEntityTypeModel(FPBPKG_L.PFLOAT, BuiltinNames.PFLOAT, null);
		pFloat = createTypeExt(PFloatTypeExtImpl.class, tempmodel, PFLOAT);
		
		tempmodel = createPEntityTypeModel(FPBPKG_L.POBJID, BuiltinNames.POBJID, null);
		pObjid = createTypeExt(PObjidTypeExtImpl.class, tempmodel, POBJID);
		
		tempmodel = createPEntityTypeModel(FPBPKG_L.PBOOLEAN, BuiltinNames.PBOOLEAN, null);
		pBoolean = createTypeExt(PBooleanTypeExtImpl.class, tempmodel, PBOOLEAN);
		
		tempmodel = createPEntityTypeModel(FPBPKG_L.PCHARSTRING, BuiltinNames.PCHARSTRING, null);
		pCharstring = createTypeExt(PCharstringTypeExtImpl.class, tempmodel, PCHARSTRING);
		
		tempmodel = createPEntityTypeModel(FPBPKG_L.PUNIVERSAL_CHARSTRING, 
				BuiltinNames.PUCHARSTRING, null);
		pUCharstring = createTypeExt(PUCharstringTypeExtImpl.class, tempmodel, PUCHARSTRING);
		
		tempmodel = createPEntityTypeModel(FPBPKG_L.PBITSTRING, BuiltinNames.PBITSTRING, null);
		pBitstring = createTypeExt(PBitstringTypeExtImpl.class, tempmodel, PBITSTRING);
		
		tempmodel = createPEntityTypeModel(FPBPKG_L.PHEXSTRING, BuiltinNames.PHEXSTRING, null);
		pHexstring = createTypeExt(PHexstringTypeExtImpl.class, tempmodel, PHEXSTRING);
		
		tempmodel = createPEntityTypeModel(FPBPKG_L.POCTETSTRING, BuiltinNames.POCTETSTRING, null);
		pOctetstring = createTypeExt(POctetstringTypeExtImpl.class, tempmodel, POCTETSTRING);
		
		tempmodel = createPEntityTypeModel(FPBPKG_L.PVERDICT, BuiltinNames.PVERDICT, null);
		pVerdict = createTypeExt(PVerdictTypeExtImpl.class, tempmodel, PVERDICT);
		
	}

	protected void initializeModule() throws InitMetaException{
		super.initializeModule();
	}
	
}
