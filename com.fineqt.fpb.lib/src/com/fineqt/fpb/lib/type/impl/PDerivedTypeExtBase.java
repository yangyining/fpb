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
package com.fineqt.fpb.lib.type.impl;

import java.util.Collection;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.constraint.DiagnosticChain;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.modelview.EnumTypeItemMV;
import com.fineqt.fpb.lib.modelview.FieldMV;
import com.fineqt.fpb.lib.modelview.ListItemMV;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.PEntityTypeExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PDerivedTypeExtBase extends PTypeExtBase {
	protected PTypeExt pSuperType;
	
	public PDerivedTypeExtBase(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
	}

	@Override
	public boolean isContainerType() {
		return pSuperType.isContainerType();
	}

	@Override
	public boolean isListType() {
		return pSuperType.isListType();
	}

	@Override
	public boolean isPrimitiveType() {
		return pSuperType.isPrimitiveType();
	}
	
	@Override
	public PTypeExt getSuperType() {
		return pSuperType;
	}

	@Override
	public void setSuperType(PTypeExt type) {
		pSuperType = type;
	}

	@Override
	public TypeClass getTypeClass() {
		return pSuperType.getTypeClass();
	}
	
	@Override
	public boolean validateFields(PValue value, DiagnosticChain chain) {
		return pSuperType.validateFields(value, chain);
	}

	@Override
	public PEntityTypeExt getRootType() {
		return pSuperType.getRootType();
	}

	@Override
	public FieldMV getFieldMV(String fieldName) {
		return pSuperType.getFieldMV(fieldName);
	}

	@Override
	public ListItemMV getListItemMV() {
		return pSuperType.getListItemMV();
	}

	@Override
	public String[] getFieldNames() {
		return pSuperType.getFieldNames();
	}

	@Override
	public EnumTypeItemMV getEnumTypeItemMV(String itemName) {
		return pSuperType.getEnumTypeItemMV(itemName);
	}

	@Override
	public Collection<String> getEnumTypeItemNames() {
		return pSuperType.getEnumTypeItemNames();
	}

	@Override
	public PFieldExt asFieldMeta() {
		return pSuperType.asFieldMeta();
	}

	@Override
	public PListItemExt asListItemMeta() {
		return pSuperType.asListItemMeta();
	}

	@Override
	public PValue createOmitValue() {
		PValue value = pSuperType.createOmitValue();
		value.pValueMeta(this);
		return value;
	}
	
	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		PValue value = pSuperType.createNormalValue(paras);
		value.pValueMeta(this);
		return value;
	}
	
	@Override
	public PValue createEmptyValue() {
		PValue value = pSuperType.createEmptyValue();
		value.pValueMeta(this);
		return value;
	}

	@Override
	public int getFieldSize() {
		return pSuperType.getFieldSize();
	}

	@Override
	public IType getFieldType(int fieldIndex) {
		return pSuperType.getFieldType(fieldIndex);
	}

	@Override
	public IType getFieldType(String fieldName) {
		return pSuperType.getFieldType(fieldName);
	}

	@Override
	public IType getItemType() {
		return pSuperType.getItemType();
	}

	@Override
	protected void doInit() throws InitMetaException {
		assert pSuperType != null;
		//被派生类型的初始化
		pSuperType.init();
		//父类方法
		super.doInit();
		//加入被派生类型的限制信息
		pconstraints.addConstraint(pSuperType.getConstraints().getAll());
	}
	
	@Override
	public DecodeResult decode(DecodeContext cxt, IReadableBitBuffer input, 
	        PTypeElementMeta elementMeta, DecodeParameters paras)
			throws DecodeException {
	    throw new UnsupportedOperationException();
	}

	@Override
	public int encode(EncodeContext cxt, PValue value, int parentLength,
			PTypeElementMeta elementMeta, ByteOrder byteOrder) throws EncodeException {
        throw new UnsupportedOperationException();
	}
	
	@Override
	public int dump(DumpContext cxt, PValue value, String valueName, 
	        PTypeElementMeta elementMeta, int deep) throws DumpException {
        throw new UnsupportedOperationException();
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.appendSuper(super.toString())
		.append("pSuperType", getSuperType()==null?null:getSuperType().getFullName())
		.toString();
	}	

}
