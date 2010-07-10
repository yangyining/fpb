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

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.meta.evattr.PFpbFieldEVAttrsImpl;
import com.fineqt.fpb.lib.meta.evattr.StackFieldOperation;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.impl.PElementExtBase;
import com.fineqt.fpb.lib.meta.property.PPropertyListExt;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmoduleFactory;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbFieldEV;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbFieldEVAttrs;
import com.fineqt.fpb.lib.type.PFpbFieldEVExt;
import com.fineqt.fpb.lib.type.PTypeEVExt;
import com.fineqt.fpb.lib.value.PValue;

public class PFpbFieldEVExtImpl extends PElementExtBase implements PFpbFieldEVExt {
	protected PFieldExt owner; 
	protected PTypeEVExt typeEVMeta;
	protected PFpbFieldEVAttrs evAttrs;
	
	public PFpbFieldEVExtImpl(PFpbFieldEV pmodel, PFieldExt owner) {
		super(pmodel, owner.getPModule());
		this.owner = owner;
	}

	private PFpbFieldEV getFpbModel() {
		return (PFpbFieldEV)pmodel;
	}
	
	@Override
	public EncodingType getEncodingType() {
		return EncodingType.FPB;
	}

	@Override
	public void init() throws InitMetaException {
		PFpbFieldEV fieldModel = getFpbModel();
		//对于字段的类型初始化
		owner.getType().init();
		//Property List
		PPropertyListExt prpListExt = null;
		if (fieldModel.getPrpList() != null) {
			prpListExt = new PPropertyListExt(fieldModel.getPrpList(), owner); 
			prpListExt.init();
		}
		//EV Attrs
		evAttrs = new PFpbFieldEVAttrsImpl(prpListExt, this);
		//typeEVExt
		PFpbTypeEV typeEV = FpbmoduleFactory.eINSTANCE.createPFpbTypeEV();
		typeEVMeta = owner.getType().createTypeEVExt(typeEV);
		assert typeEVMeta != null;
		typeEVMeta.setInitPropertyList(prpListExt);
		typeEVMeta.setTargetTypeMeta(owner.getType());
		typeEVMeta.setOnwerTypeMeta(owner.getOwner());
		typeEVMeta.init();
		//确定是否有没有使用的特性
		if (prpListExt.getUnusedProperties().size() != 0) {
			throw new InitMetaException(getPModule(), 
					MetaException.CODE.UNKNOWN_PROPERTIES_ERROR,
					prpListExt.getUnusedProperties());
		}
	}
	
	@Override
	public PFieldExt getOwner() {
		return owner;
	}

	@Override
	public List<PTypeConstraintExt> getCaseCond() {
		return evAttrs.getCaseCond();
	}

	@Override
	public PValue getDefaultValue() {
		return evAttrs.getDefaultValue();
	}

	@Override
	public StackFieldOperation getSetField() {
		return evAttrs.getSetField();
	}

	@Override
	public int getDefaultLength() {
		return evAttrs.getDefaultLength();
	}

	@Override
	public boolean isDefaultPresent() {
		return evAttrs.isDefaultPresent();
	}
	
	@Override
	public FlagFieldType getFlagType() {
		return evAttrs.getFlagType();
	}

	@Override
	public PTypeEVExt getTypeEVMeta() {
		return typeEVMeta;
	}

	@Override
	public boolean isOverrideWhole() {
		return evAttrs.isOverrideWhole();
	}

	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("evAttrs", evAttrs)
			.append("typeEVMeta", typeEVMeta)
			.toString();
	}
}
