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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.PPropertyList;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.modelview.TypeMV;

abstract public class TypeSymbolBase extends ModuleElementSymbolBase 
implements TypeMV {
	public static final String TYPE_JAVA_CLASS_PRP = "TypeJavaClass";
	
	private PPropertyList variantPropertyList;
	
	public TypeSymbolBase(ModuleMV module) {
		super(module);
	}

	@Override
	public Type getModuleElementType() {
		return Type.TYPE;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("derivativeMode", getDerivativeMode())
			.append("typeClass", getTypeClass())
			.toString();
	}

	public PPropertyList getVariantPropertyList() {
		return variantPropertyList;
	}

	public void setVariantPropertyList(PPropertyList propertyList) {
		this.variantPropertyList = propertyList;
	}
	
	@Override
	public boolean isCompatibleMV(TypeMV dstType) {
		return getRootTypeMV() == dstType.getRootTypeMV();
	}

	@Override
	public EncodingType getEncodingType() {
		PType model = getTypeModel();
		if (model == null) {
			return null;
		}
		return model.getEncode();
	}

	@Override
	protected void doInitModel(ParserHelper cxt) {
		PModule pmodule = cxt.getModuleSymbol().getModel();
		PType typeModel = getTypeModel();
		//加入模块
		pmodule.getTypes().add(typeModel);
		//根据Type自己->Module->被派生类顺序来取得EncodingType
		if (!typeModel.isSetEncode()) {
			EncodingType moduleEncode = pmodule.getEncode();
			if (moduleEncode != null && moduleEncode != EncodingType.NONE) {
				typeModel.setEncode(moduleEncode);
			} else if (getSuperTypeMV() != null){
				EncodingType derivedEncode = getSuperTypeMV().getEncodingType();
				if (derivedEncode != null && derivedEncode != EncodingType.NONE) {
					typeModel.setEncode(derivedEncode);
				}
			}
		}
		//初始EncodeVariant
		if (typeModel.getEncode() == EncodingType.FPB) {
			PFpbTypeEV ev;
			if (typeModel.getVariant() instanceof PFpbTypeEV) {
				ev = (PFpbTypeEV)typeModel.getVariant();
			} else {
				ev = mfactory.createPFpbTypeEV();
				typeModel.setVariant(ev);
			}
			//PropertyList
			PPropertyList prpList;
			if (variantPropertyList == null) {
				prpList = mfactory.createPPropertyList();
			} else {
				//由于一个PropertyList可能对应多个类型所以使用Copy
				prpList = (PPropertyList)EcoreUtil.copy(variantPropertyList);
			}
			ev.setPrpList(prpList);
		}
		//runtime propertyList
		if (runtimePropertyList != null) {
			PType model = getTypeModel();
			assert model != null;
			String value;
			//ElementID
			value = runtimePropertyList.getProperty(ELEMENT_ID_PRP);
			if (value != null) {
				try {
					int id = Integer.parseInt(value);
					model.setTypeID(id);
				} catch (NumberFormatException e) {
					//忽略ID设置
				}
			}
			//TypeJavaClass
			value = runtimePropertyList.getProperty(TYPE_JAVA_CLASS_PRP);
			if (value != null) {
				model.setJavaClass(value);
			}
		}
		//父方法
		super.initModel(cxt);
	}

	abstract public PType getTypeModel();

}
