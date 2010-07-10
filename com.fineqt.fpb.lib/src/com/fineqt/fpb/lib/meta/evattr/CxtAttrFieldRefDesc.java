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
package com.fineqt.fpb.lib.meta.evattr;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.meta.context.CommonContext;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class CxtAttrFieldRefDesc extends FieldRefDesc {
	private String attrName;
	
	public CxtAttrFieldRefDesc(String attrName, String pathDesc, PTypeExt targetType) 
	throws MetaException {
		if (targetType == null)
			throw new IllegalArgumentException();
		this.attrName = attrName;
		//PPath
		createPPath(pathDesc, targetType);
	}

	@Override
	public Type getType() {
		return Type.CONTEXT_ATTRIBUTE;
	}

	public String getAttrName() {
		return attrName;
	}
	
	public PValue findRefValue(CommonContext cxt) {
		Object obj = cxt.getAttribute(attrName);
		if (obj == null || !(obj instanceof PValue))
			return null;
		PValue rootField = (PValue)obj;
		return path.findField(rootField);
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.appendSuper(super.toString())
			.append("attrName", attrName)
			.toString();
	}
}