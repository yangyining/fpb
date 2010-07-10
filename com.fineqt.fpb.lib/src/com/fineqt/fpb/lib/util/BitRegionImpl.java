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
package com.fineqt.fpb.lib.util;

import java.security.InvalidParameterException;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BitRegionImpl implements BitRegion, Cloneable {
	final protected static int BYTE_BITS = 8;
	private int offset;
	private int len;
	
	public BitRegionImpl() {
	}
	
	public BitRegionImpl(int offset, int len) {
		this.len = len;
		this.offset = offset;
	}
	
	public int getLen() {
		return len;
	}

	public int getOffset() {
		return offset;
	}
	
	public void setLen(int len) {
		if (len < 0)
			throw new InvalidParameterException();
		this.len = len;
	}

	public void setOffset(int offset) {
		if (offset < 0)
			throw new InvalidParameterException();
		this.offset = offset;
	}

	public int getLeftMaskBits() {
		return offset % BYTE_BITS;
	}

	public int getRightMaskBits() {
		int mod = (offset + len) % BYTE_BITS;
		if (mod == 0)
			return 0;
		return BYTE_BITS - mod;
	}
	
	public int getByteLen() {
		return (int)Math.ceil((double)(getLeftMaskBits()+len) / 
				(double)BYTE_BITS);
	}

	public int getByteOffset() {
		return offset / BYTE_BITS;
	}

	@Override
	public Object clone() {
		return new BitRegionImpl(offset, len);
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("offset", offset)
			.append("len", len)
			.toString();
	}
}