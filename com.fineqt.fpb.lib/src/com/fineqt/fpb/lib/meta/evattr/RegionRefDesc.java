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

import com.fineqt.fpb.lib.type.PTypeExt;

public class RegionRefDesc {
    public final static String DEFAULT_REF_FIELD_TYPE = "integer";
	private int offset;
	private int length;
	private PTypeExt refFieldType;
	
	public RegionRefDesc(int offset, int length, PTypeExt refFieldType) {
		this.offset = offset;
		this.length = length;
		this.refFieldType = refFieldType;
	}
	
	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	
	}
	/**
	 * 取得引用目标字段的类型。
	 * @return
	 */
	public PTypeExt getRefFieldType() {
	    return refFieldType;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("offset", offset)
			.append("length", length)
			.toString();
	}
}