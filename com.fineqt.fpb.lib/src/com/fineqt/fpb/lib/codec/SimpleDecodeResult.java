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
package com.fineqt.fpb.lib.codec;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.value.PValue;

public class SimpleDecodeResult implements DecodeResult {
	protected PValue value;
	protected int valueLength;
	
	@Override
	public PValue getValue() {
		return value;
	}

	@Override
	public int getValueLength() {
		return valueLength;
	}

	@Override
	public void setValue(PValue value) {
		this.value = value;
	}

	@Override
	public void setValueLength(int length) {
		valueLength = length;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("value", value)
		.append("valueLength", valueLength)
		.toString();
	}
}
