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

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.meta.evattr.PFpbListItemEVAttrsImpl;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.impl.PElementExtBase;
import com.fineqt.fpb.lib.meta.property.PPropertyListExt;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmoduleFactory;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbListItemEV;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PFpbListItemEVAttrs;
import com.fineqt.fpb.lib.type.PFpbListItemEVExt;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PTypeEVExt;
import com.fineqt.fpb.lib.value.PValue;

public class PFpbListItemEVExtImpl extends PElementExtBase implements PFpbListItemEVExt {
	protected PListItemExt owner; 
	protected PTypeEVExt typeEVMeta;
	protected PFpbListItemEVAttrs evAttrs;
	
	public PFpbListItemEVExtImpl(PFpbListItemEV pmodel, PListItemExt owner) {
		super(pmodel, owner.getPModule());
		this.owner = owner;
	}

	private PFpbListItemEV getFpbModel() {
		return (PFpbListItemEV)pmodel;
	}
	
	@Override
	public EncodingType getEncodingType() {
		return EncodingType.FPB;
	}

	@Override
	public void init() throws InitMetaException {
		PFpbListItemEV itemModel = getFpbModel();
		//对于字段的类型初始化
		owner.getType().init();
		//Property List
		PPropertyListExt prpListExt = null;
		if (itemModel.getPrpList() != null) {
			prpListExt = new PPropertyListExt(itemModel.getPrpList(), owner); 
			prpListExt.init();
		}
		//EV Attrs
		evAttrs = new PFpbListItemEVAttrsImpl(prpListExt, this);
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
	public PListItemExt getOwner() {
		return owner;
	}

	@Override
	public PTypeEVExt getTypeEVMeta() {
		return typeEVMeta;
	}

	@Override
	public boolean isOverrideWhole() {
		return evAttrs.isOverrideWhole();
	}

	@Override
    public int getDefaultLength() {
        return evAttrs.getDefaultLength();
    }

    @Override
    public PValue getDefaultValue() {
        return evAttrs.getDefaultValue();
    }

    public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("evAttrs", evAttrs)
			.append("typeEVMeta", typeEVMeta)
			.toString();
	}
	
}
