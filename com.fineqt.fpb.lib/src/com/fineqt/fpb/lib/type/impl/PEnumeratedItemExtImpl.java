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

import com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem;
import com.fineqt.fpb.lib.type.PEnumeratedItemExt;

public class PEnumeratedItemExtImpl implements PEnumeratedItemExt {
	private PEnumeratedItem model;
	private int id;
	
	public PEnumeratedItemExtImpl(PEnumeratedItem model, int id) {
		this.model = model;
		this.id = id;
	}

	@Override
	public int getEnumID() {
		return id;
	}

	@Override
	public String getEnumName() {
		return model.getEnumName();
	}

	@Override
	public int getEnumValue() {
		return model.getEnumValue();
	}

	@Override
	public PEnumeratedItem getModel() {
		return model;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("id", id)
			.append("name", getEnumName())
			.append("value", getEnumValue())
			.toString();
	}
}
