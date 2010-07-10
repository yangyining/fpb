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
package com.fineqt.fpb.lib.meta.property;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.util.PElementExtFactory;
import com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PValueReferenceArgumentExt extends PValueArgumentExtBase {
	private PTypeExt refType; 
	private PMatcherExt refValueMatcher;
	
	public PValueReferenceArgumentExt(PValueReferenceArgument pmodel,
			PTypeElementMeta ownerMeta) {
		super(pmodel, ownerMeta);
	}

	@Override
	public Type getType() {
		return Type.VALUE_REFERENCE;
	}

	@Override
	public PValue getValue() {
		try {
			return refValueMatcher.valueOf(null);
		} catch (TemplateMatchingExption e) {
			//不可能发生
			throw new RuntimeException(e);
		}
	}

	@Override
	public TypeClass getValueTypeClass() {
		return refType.getTypeClass();
	}

	@Override
	protected void doInit() throws InitMetaException {
		PValueReferenceArgument argModel = (PValueReferenceArgument)pmodel;
		assert argModel.getTypeName() != null;
		assert argModel.getValueRef() != null;
		//type
		refType = getPModule().pPType(argModel.getTypeName());
		if (refType == null) {
			throw new InitMetaException(getPModule(), MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
					argModel.getTypeName(), getPModule().getModuleName());
		}
		//valueReference
		refValueMatcher = PElementExtFactory.INSTANCE.createMatcher(refType, 
				argModel.getValueRef(), null);
		assert refValueMatcher != null;
		//父方法
		super.doInit();
	}

	public PTypeExt getRefType() {
		return refType;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("refType", refType==null?null:refType.getFullName())
			.append("refValueMatcher", refValueMatcher)
			.toString();
	}
	
}
