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
package com.fineqt.fpb.lib.meta.impl;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.meta.PEnumSetExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumSet;
import com.fineqt.fpb.lib.modelview.TypeMV;

abstract public class PEnumSetExtBase extends PModuleElementExtBase implements PEnumSetExt {
	private int enumSetID;
	
	public PEnumSetExtBase(PEnumSet pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		enumSetID = pmodel.getEnumSetID();
	}

	@Override
	public Type getModuleElementType() {
		return Type.ENUM_SET;
	}

	@Override
	public int getID() {
		return enumSetID;
	}
	
	@Override
	public TypeMV getBaseTypeMV() {
		return getBaseType();
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("id", getID())
			.append("name", getName())
			.append("import", isImport())
			.toString();
	}
	
}
