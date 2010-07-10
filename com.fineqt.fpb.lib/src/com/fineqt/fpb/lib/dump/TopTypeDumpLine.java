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
package com.fineqt.fpb.lib.dump;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.value.PValue;

public class TopTypeDumpLine extends DumpLineBase {
	private boolean protocol;
	
	public TopTypeDumpLine(PValue value) {
		super(value);
	}

	@Override
	public String getName() {
		return value.pTypeMeta().getFullName();
	}

	public boolean isProtocol() {
		return protocol;
	}

	public void setProtocol(boolean protocol) {
		this.protocol = protocol;
	}

	@Override
	public Type getType() {
		return Type.TOP_TYPE;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.appendSuper(super.toString())
		.append("protocol", protocol)
		.toString();
	}
	
}
