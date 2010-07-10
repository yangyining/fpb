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

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.util.PElementExtFactory;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PField;
import com.fineqt.fpb.lib.model.fpbmodule.PFieldEV;
import com.fineqt.fpb.lib.modelview.TypeMV;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbFieldEVExt;
import com.fineqt.fpb.lib.type.PItemFieldEVExt;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PFieldExtImpl extends PItemFiedExtBase implements PFieldExt {
	private int fieldID;
	private boolean optional;
	private String fieldName;
	private String fieldTypeName;
	/**
	 * 用于optional的字段，表示初始时是否存在。
	 */
	private boolean defaultPresent;
	
	public PFieldExtImpl(PField model, PTypeExt owner) {
		super(model, owner.getPModule());
		fieldID = model.getFieldID();
		optional = model.isOptional();
		fieldName = model.getName();
		fieldTypeName = model.getPtypeName();
		this.owner = owner;
	}

	@Override
	public void init() throws InitMetaException {
	    super.init();
		//defaultPresent
		if (pevMeta instanceof PFpbFieldEVExt) {
			PFpbFieldEVExt fpbEvMeta = (PFpbFieldEVExt)pevMeta;
			defaultPresent = fpbEvMeta.isDefaultPresent();
		}
	}

	@Override
    protected PItemFieldEVExt createEVExt() {
        PField model = (PField)pmodel;
        if (model.getVariant() != null) {
            PItemFieldEVExt evMeta = PElementExtFactory.INSTANCE.createFieldEV(this, 
                    (PFieldEV)model.getVariant());
            evMeta.init();
            return evMeta;
        }
        return null;
    }

	@Override
	public PFieldExt asFieldMeta() {
		return this;
	}

	@Override
	public PListItemExt asListItemMeta() {
		return null;
	}

	@Override
	public boolean isOptional() {
		return optional;
	}

	@Override
	public boolean isDefaultPresent() {
		return defaultPresent;
	}

	@Override
	public int getFieldID() {
		return fieldID;
	}

	@Override
	public String getFieldName() {
		return fieldName;
	}

	@Override
	public String getFullFieldName() {
		if (owner != null) {
			return owner.getFullName()+"."+fieldName;
		}
		return fieldName;
	}

	@Override
	public String getFieldTypeName() {
		return fieldTypeName;
	}

    @Override
	public PValue createDefaultValue(boolean forcePresent) {
		PValue result;
		//Optional默认是Omit
		if (isOptional() && !defaultPresent && !forcePresent) {
			result = type.createOmitValue();
		} else {
			result = type.createNormalValue(createValueParas);
		}
		result.pValueMeta(this);
		return result;
	}

	@Override
	public PValue createDefaultValue() {
		return createDefaultValue(false);
	}

	@Override
	public TypeMV getFieldTypeMV() {
		return asTypeMeta();
	}

	@Override
	public TypeMV getOwnerTypeMV() {
		return getOwner();
	}

	@Override
	public DecodeResult decode(DecodeContext cxt, IReadableBitBuffer input,
			DecodeResult parentResult, ByteOrder byteOrder) throws DecodeException {
		DecodeResult result;
		DecodeParameters paras;
		//生成参数并解码
        paras = cxt.createDecodeParas(parentResult, byteOrder);
        result = rootType.decode(cxt, input, this, paras);
		// 设置omit值
		if (result.getValue() == null && optional) {
			result.setValue(createOmitValue());
		}
		//回收参数对象
		cxt.returnDecodeParas(paras);
		return result;
	}

	@Override
	public int dump(DumpContext cxt, PValue value, int deep) throws DumpException {
        return rootType.dump(cxt, value, getFieldName(), this, deep);
	}

	@Override
	public int encode(EncodeContext cxt, PValue value, int parentLength,
			ByteOrder byteOrder) throws EncodeException {
        return rootType.encode(cxt, value, parentLength, this, byteOrder);
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("fieldName", getFieldName())
			.append("fieldID", getFieldID())
			.append("type", type==null?null:type.getName())
			.append("optional", isOptional())
			.append("defaultPresent", defaultPresent)
			.appendSuper(super.toString())
			.toString();
	}
	
}
