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

import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.api.value.IPath;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.constraint.DiagnosticChain;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.evattr.PPath;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.impl.PModuleElementExtBase;
import com.fineqt.fpb.lib.meta.util.MetaUtils;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeEV;
import com.fineqt.fpb.lib.modelview.EnumTypeItemMV;
import com.fineqt.fpb.lib.modelview.FieldMV;
import com.fineqt.fpb.lib.modelview.ListItemMV;
import com.fineqt.fpb.lib.modelview.TypeMV;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PTypeEVAttrs;
import com.fineqt.fpb.lib.type.PTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeEVExtFactory;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PTypeExtBase extends PModuleElementExtBase 
implements PTypeExt, PTypeElementMeta {
	protected SimplePTypeConstraintStorage pconstraints = new SimplePTypeConstraintStorage(); 
	protected PTypeEVExt pevMeta;
	private int ptypeID;
    //用于deocode,encode, dump的优先类型编码变量
    protected PTypeEVExt priorityTypeEVMeta;
	
	public PTypeExtBase(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		this.ptypeID = pmodel.getTypeID();
	}

    @Override
    public PTypeEVAttrs getPriorityAttrs() {
        return null;
    }

    @Override
    public PTypeEVExt getPriorityVariant() {
        return priorityTypeEVMeta;
    }

    @Override
    public boolean isOptional() {
        return false;
    }

    @Override
	public String getFullName() {
		return pmoduleExt.getModuleName() + '.' + getName();
	}

	@Override
	public int getID() {
		return ptypeID;
	}

	@Override
	public Type getModuleElementType() {
		return Type.TYPE;
	}

	@Override
	public EncodingType getEncodingType() {
		if (pevMeta == null)
			return EncodingType.NONE;
		return pevMeta.getEncodingType();
	}

	@Override
	public IPath createPath(String pathDesc) throws MetaException {
		return PPath.parse(pathDesc, this);
	}

	@Override
	public PTypeEVExt createTypeEVExt(PTypeEV typeEV) {
		if (typeEV == null) {
			throw new IllegalArgumentException();
		}
		if (typeEV instanceof PFpbTypeEV) {
			PTypeEVExtFactory factory = pmoduleExt.pTypeEVExtFactory(EncodingType.FPB);
			if (factory == null) {
				throw new IllegalStateException("Unsupported type encoding" + EncodingType.FPB );
			}
			PTypeEVExt result = factory.createTypeEVExt(this, typeEV);
			return result;
		} else {
			throw new IllegalStateException("Unsupported type ev model" + typeEV );
		}
	}

	@Override
	public IModule getModule() {
		return pmoduleExt;
	}

	@Override
	public FieldMV getFieldMV(String fieldName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String[] getFieldNames() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListItemMV getListItemMV() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EnumTypeItemMV getEnumTypeItemMV(String itemName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<String> getEnumTypeItemNames() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public PFieldExt asFieldMeta() {
		//由于是PTypeElementMeta的方法，只有PFieldExt才返回
		return null;
	}

	@Override
	public PListItemExt asListItemMeta() {
		//由于是PTypeElementMeta的方法，只有PListItemExt才返回
		return null;
	}
	
	@Override
	protected void doInit() throws InitMetaException {
//		System.out.println("doInit:"+getName());
		//首先初始化被派生类型，解决派生层次依赖
		if (getSuperType() != null) {
			getSuperType().init();
		}
		//设置EV对象（在Import或Sub类型时EV对象可能为空）
		PTypeEV pevmodel = (PTypeEV)((PType)pmodel).getVariant();
		if (pevmodel != null) {
			pevMeta = createTypeEVExt(pevmodel);
			if (pevMeta != null) {
				pevMeta.setTargetTypeMeta(this);
				pevMeta.setOnwerTypeMeta(this);
				pevMeta.init();
			}
		}
        //设置优先类型编码变量(在派生关系中找到第一个有效的EV)
        if (pevMeta != null) {
            priorityTypeEVMeta = pevMeta;
        }
        if (priorityTypeEVMeta == null || !priorityTypeEVMeta.hasSettedAttr()) {
            priorityTypeEVMeta = MetaUtils.findValidTypeEVMeta(this, priorityTypeEVMeta);
        }
		
	}
	
	@Override
	public PTypeEVExt getEVMeta() {
		return pevMeta;
	}

	@Override
	public PValue createNormalValue() {
		//使用限制条件作为参数（因为限制条件是随着类型的派生而累积的，所以对于Sub和Import类型也适用）
		return createNormalValue(pconstraints);
	}
	
	@Override
	public PTypeExt asTypeMeta() {
		return this;
	}

	@Override
	public boolean isCompatible(PTypeExt dstType) {
		return getRootType() == dstType.getRootType();
	}
	
	@Override
	public TypeMV getRootTypeMV() {
		return getRootType();
	}
	
	@Override
	public TypeMV getSuperTypeMV() {
		return getSuperType();
	}

	public boolean isCompatibleMV(TypeMV dstType) {
		return getRootTypeMV() == dstType.getRootTypeMV();
	}
	
	@Override
	public DecodeResult decode(DecodeContext cxt, IReadableBitBuffer input, 
	        PTypeElementMeta elementMeta, DecodeParameters paras)
			throws DecodeException {
		DecodeResult result;
		PTypeEVExt dstVariant = elementMeta.getPriorityVariant();
	    // 没有有效的EncodeVariant设置
        if (dstVariant == null) {
            throw new DecodeException(this,
                    MetaException.CODE.UNSUPPORTED_ENCODING_ERROR, EncodingType.NONE);
        }
		switch(dstVariant.getEncodingType()) {
		case FPB:
			result = decode4fpb(cxt, input, elementMeta, paras);
			break;
		default:
			throw new DecodeException(this, 
					MetaException.CODE.UNSUPPORTED_ENCODING_ERROR, 
					dstVariant.getEncodingType());
		}
		return result;
	}

	@Override
	public int encode(EncodeContext cxt, PValue value, int parentLength, 
	        PTypeElementMeta elementMeta, 
			ByteOrder byteOrder) throws EncodeException {
	    PTypeEVExt variant = elementMeta.getPriorityVariant();
        // 没有有效的EncodeVariant设置
        if (variant == null) {
            throw new EncodeException(this,
                    MetaException.CODE.UNSUPPORTED_ENCODING_ERROR, EncodingType.NONE);
        }
		switch(variant.getEncodingType()) {
		case FPB:
			return encode4fpb(cxt, value, parentLength, (PFpbTypeEVExt)variant, 
			        elementMeta, byteOrder);
		default:
			throw new EncodeException(this, 
					MetaException.CODE.UNSUPPORTED_ENCODING_ERROR, 
					variant.getEncodingType());
		}
	}
	
	@Override
	public int dump(DumpContext cxt, PValue value, String valueName, 
	        PTypeElementMeta elementMeta, int deep)
			throws DumpException {
        PTypeEVExt variant = elementMeta.getPriorityVariant();
        // 没有有效的EncodeVariant设置
        if (variant == null) {
            throw new DumpException(this,
                    MetaException.CODE.UNSUPPORTED_ENCODING_ERROR, EncodingType.NONE);
        }
		switch(variant.getEncodingType()) {
		case FPB:
			return dump4fpb(cxt, value, valueName, (PFpbTypeEVExt)variant, 
			        elementMeta, deep);
		default:
			throw new DumpException(this, 
					MetaException.CODE.UNSUPPORTED_ENCODING_ERROR, 
					variant.getEncodingType());
		}
	}

	protected DecodeResult decode4fpb(DecodeContext cxt, IReadableBitBuffer input, 
	        PTypeElementMeta elementMeta, DecodeParameters paras) 
	throws DecodeException {
		PFpbTypeEVExt variant = (PFpbTypeEVExt)elementMeta.getPriorityVariant();
		return variant.decode(cxt, input, elementMeta, paras);
	}

	protected int encode4fpb(EncodeContext cxt, PValue value, int parentLength,
	        PFpbTypeEVExt variant, PTypeElementMeta elementMeta, ByteOrder byteOrder) 
	throws EncodeException {
	   return variant.encode(cxt, value, parentLength, elementMeta, byteOrder);
	}

	protected int dump4fpb(DumpContext cxt, PValue value, String valueName, 
	        PFpbTypeEVExt variant, PTypeElementMeta elementMeta, int deep)
			throws DumpException {
		return variant.dump(cxt, value, valueName, elementMeta, 
		        deep);
	}
	
	@Override
	public PTypeConstraintStorage getConstraints() {
		return pconstraints;
	}

	@Override
	public boolean validate(PValue value, DiagnosticChain chain, PTypeConstraintStorage constraint) {
		if( !constraint.validate(value, chain) ) {
			return false;
		}
		//TODO 在Constraint中如果有List限制，在保证List限制的各个项目值对象的字段都符合限制条件的前提下
		//，因该可以省略以下的字段验证。
		return validateFields(value, chain);
	}

	@Override
	public boolean validate(PValue value, DiagnosticChain chain) {
		if ( !pconstraints.validate(value, chain) ) {
			return false;
		}
		//TODO 同前
		return validateFields(value, chain);
	}

	@Override
	public boolean validateFields(PValue value, DiagnosticChain chain) {
		return true;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this); 
		builder.append("name", getName());
		builder.append("module", getPModule().getModuleName());
		builder.append("encodingType", getEncodingType());
		builder.append("pconstraints", pconstraints);
//		if (pevmodel != null) {
//			builder.getStringBuffer().append(LN+TAB);
//		} 
//		builder.append("pevmodel", pevmodel);
		if (pevMeta != null) {
			builder.getStringBuffer().append(LN+TAB);
		} 
		builder.append("pevMeta", pevMeta);
		return builder.toString();
	}

}
