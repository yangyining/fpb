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
package com.fineqt.fpb.lib.expression;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.template.impl.PExpressionMatcherExtBase;
import com.fineqt.fpb.lib.value.PPrimitiveValue;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
/**
 * Primitive类型的常量Matcher。
 * @author JiangMin
 *
 */
public class PPrimitiveValueMatcherExt extends PExpressionMatcherExtBase {
	private PPrimitiveValue constValue;
	
	public static PPrimitiveValueMatcherExt create(PPrimitiveValueMatcher pmodel, 
			PTypeElementMeta meta, PModuleExt ownerModule) {
		if (meta.asTypeMeta().isPrimitiveType()) {
			PPrimitiveValue value = (PPrimitiveValue)meta.asTypeMeta().createEmptyValue();
			value.setText(pmodel.getValueDesc());
			return new PPrimitiveValueMatcherExt(pmodel, meta, value, ownerModule);
		}
		throw new IllegalArgumentException(); 
	}
	
	private PPrimitiveValueMatcherExt(PPrimitiveValueMatcher pmodel, PTypeElementMeta meta, 
			PPrimitiveValue value, PModuleExt ownerModule) {
		super(pmodel, meta, ownerModule);
		this.constValue = value;
	}

	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		return (PValue)constValue.clone();
	}

	public PPrimitiveValue getConstValue() {
		return constValue;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("constValue", constValue)
			.toString();
	}
	
}
