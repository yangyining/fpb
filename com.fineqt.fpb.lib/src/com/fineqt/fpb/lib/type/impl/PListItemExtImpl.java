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
import com.fineqt.fpb.lib.meta.util.PElementExtFactory;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PListItem;
import com.fineqt.fpb.lib.model.fpbmodule.PListItemEV;
import com.fineqt.fpb.lib.modelview.TypeMV;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PItemFieldEVExt;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PListItemExtImpl extends PItemFiedExtBase implements PListItemExt {
	private String itemTypeName;

	public PListItemExtImpl(PListItem model, PTypeExt owner) {
		super(model, owner.getPModule());
		this.owner = owner;
		itemTypeName = model.getPtypeName();
	}
	
	@Override
    protected PItemFieldEVExt createEVExt() {
        PListItem model = (PListItem)pmodel;
        if (model.getVariant() != null) {
            PItemFieldEVExt evMeta = PElementExtFactory.INSTANCE.createListItemEV(this, 
                    (PListItemEV)model.getVariant());
            evMeta.init();
            return evMeta;
        }
        return null;
    }

	@Override
	public PFieldExt asFieldMeta() {
		return null;
	}

	@Override
	public PListItemExt asListItemMeta() {
		return this;
	}

	@Override
	public String getItemTypeName() {
		return itemTypeName;
	}

	@Override
	public TypeMV getItemTypeMV() {
		return asTypeMeta();
	}

	@Override
	public TypeMV getOwnerTypeMV() {
		return getOwner();
	}
	
	@Override
    public boolean isOptional() {
        return true;
    }

	
    @Override
	public PValue createDefaultValue(boolean forcePresent) {
		return createDefaultValue();
	}

	@Override
    public PValue createDefaultValue() {
        PValue result;
        result = type.createNormalValue(createValueParas);
        result.pValueMeta(this);
        return result;
    }

    @Override
	public DecodeResult decode(DecodeContext cxt, IReadableBitBuffer input,
			DecodeResult parentResult, ByteOrder byteOrder) throws DecodeException{
		DecodeResult result;
		DecodeParameters paras;
        //生成参数并解码
        paras = cxt.createDecodeParas(parentResult, byteOrder);
        result = rootType.decode(cxt, input, this, paras);
		//回收参数对象
		cxt.returnDecodeParas(paras);
		return result;
	}

	@Override
	public int dump(DumpContext cxt, PValue value, String valueName, int deep) 
	throws DumpException {
          return rootType.dump(cxt, value, valueName, this, deep);
	}

	@Override
	public int encode(EncodeContext cxt, PValue value, int parentLength,
			ByteOrder byteOrder) throws EncodeException {
        return rootType.encode(cxt, value, parentLength, this, byteOrder);
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("type", type==null?null:type.getName())
			.appendSuper(super.toString())
			.toString();
	}
	
}
