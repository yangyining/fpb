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

import com.fineqt.fpb.lib.meta.evattr.DisplayFormat;
import com.fineqt.fpb.lib.util.BitRegion;
import com.fineqt.fpb.lib.value.PValue;

abstract public class DumpLineBase implements DumpLine {
	protected PValue value;
	protected int deep;
	protected BitRegion valueRegion;
	protected DisplayFormat format;
	
	public DumpLineBase(PValue value) {
		this.value = value;
	}
	
	@Override
	public int getDeep() {
		return deep;
	}

	@Override
	public PValue getValue() {
		return value;
	}

	@Override
	public BitRegion getValueRegion() {
		return valueRegion;
	}

	@Override
	public boolean isContainer() {
		return value.isContainer();
	}

	@Override
	public boolean isList() {
		return value.isList();
	}

	@Override
	public boolean isPrimitive() {
		return value.isPrimitive();
	}

	@Override
	public void setDeep(int deep) {
		this.deep = deep;
	}

	@Override
	public void setValueRegion(BitRegion region) {
		valueRegion = region;
	}
	
	@Override
	public DisplayFormat getFormat() {
		return format;
	}

	@Override
	public void setFormat(DisplayFormat format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("name", getName())
		.append("deep", deep)
		.append("valueRegion", getValueRegion())
		.append("value", value)
		.append("format", format)
		.toString();
	}
}
