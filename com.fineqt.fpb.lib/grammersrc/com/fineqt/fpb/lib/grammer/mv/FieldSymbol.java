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
import com.fineqt.fpb.lib.model.fpbmodule.PField;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbFieldEV;
import com.fineqt.fpb.lib.model.fpbmodule.PPropertyList;
import com.fineqt.fpb.lib.modelview.FieldMV;
import com.fineqt.fpb.lib.modelview.TypeMV;

public class FieldSymbol extends SymbolElement implements FieldMV {
	private String fieldName;
	private TypeMV ownerTypeMV;
	private boolean optional;
	private String fieldTypeName;
	private TypeMV fieldTypeMV;
	private PField model;
	private PPropertyList propertyList;
	
	public FieldSymbol(String fieldName, TypeMV ownerTypeMV, boolean optional, 
			String fieldTypeName) {
		this.fieldName = fieldName;
		this.ownerTypeMV = ownerTypeMV;
		this.optional = optional;
		this.fieldTypeName = fieldTypeName;
	}

	@Override
	public String getFieldName() {
		return fieldName;
	}

	@Override
	public TypeMV getFieldTypeMV() {
		return fieldTypeMV;
	}

	@Override
	public TypeMV getOwnerTypeMV() {
		return ownerTypeMV;
	}

	@Override
	public boolean isOptional() {
		return optional;
	}

	@Override
	public String getFieldTypeName() {
		return fieldTypeName;
	}

	public void setFieldTypeMV(TypeMV fieldTypeMV) {
		this.fieldTypeMV = fieldTypeMV;
	}

	public PField getModel() {
		return model;
	}

	public void setModel(PField model) {
		this.model = model;
	}

	public PPropertyList getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(PPropertyList propertyList) {
		this.propertyList = propertyList;
	}

	@Override
	protected void doInitModel(ParserHelper cxt) {
		ContainerTypeSymbol containerType = (ContainerTypeSymbol)ownerTypeMV;
		//加入类
		containerType.getModel().getPfields().add(model);
		//根据Field自己->Type来取得EncodingType
		if (!model.isSetEncode()) {
			EncodingType typeEncode = containerType.getEncodingType();
			if (typeEncode != null && typeEncode != EncodingType.NONE) {
				model.setEncode(typeEncode);
			}
		}
		//初始EncodeVariant
		if (model.getEncode() == EncodingType.FPB) {
			PFpbFieldEV fieldEv;
			if (model.getVariant() instanceof PFpbFieldEV) {
				fieldEv = (PFpbFieldEV)model.getVariant();
			} else {
				fieldEv = mfactory.createPFpbFieldEV();
				model.setVariant(fieldEv);
			}
			//PropertyList
			PPropertyList prpList;
			if (propertyList == null) {
				prpList = mfactory.createPPropertyList();
			} else {
				//由于一个PropertyList可能对应多个字段所以使用Copy
				prpList = (PPropertyList)EcoreUtil.copy(propertyList);
			}
			fieldEv.setPrpList(prpList);
		}
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("fieldName", fieldName)
			.append("fieldTypeName", fieldTypeName)
			.append("optional", optional)
			.append("fieldTypeMV", fieldTypeMV==null?null:fieldTypeMV.getFullName())
			.append("model", model)
			.toString();
	}

}
