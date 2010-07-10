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
package com.fineqt.fpb.lib.util.buffer;

import com.fineqt.fpb.lib.api.util.buffer.IBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;

public class SubReadOnlyBitBuffer extends ReadableBitBufferBase {
	private IBitBuffer superBuffer;
    private TextBitset tempBits;
    private int offset;
    private int len;
    
	/**
	 * 
	 * @param superBuffer 父集对象。
	 * @param offset 子集的开始偏移位置。
	 * @param len 当len为GET_LEN_BY_SUPER_POSITION时表示使用superBuffer的position来动态计算长度。
	 * 当len为GET_LEN_BY_SUPER_CAPACITY时表示使用superBuffer的capacity来动态计算长度。
	 * 由于superBuffer的capacity和position是有可能增长的，所以长度可能增长。
	 */
	public SubReadOnlyBitBuffer(IBitBuffer superBuffer, int offset, int len) {
		super(0, len<0?-1:len);
		this.superBuffer = superBuffer;
		this.arrayOffset = superBuffer.arrayOffset() + offset;
		this.offset = offset;
		this.len = len;
	}

	@Override
	protected byte[] getBuf() {
		return superBuffer.array();
	}

	@Override
	protected TextBitset getTempBits() {
    	if (tempBits == null) {
    		tempBits = new NativeTextBitset();
    	}
    	return tempBits;
	}

	@Override
	protected void capacity(int newCapacity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int capacity() {
		if (len == GET_LEN_BY_SUPER_CAPACITY) {
			return superBuffer.capacity() - offset;
		} else if (len == GET_LEN_BY_SUPER_POSITION) {
			return superBuffer.position() - offset;
		} else {
			return len;
		}
	}

	@Override
	public IReadableBitBuffer subBitBuffer(int offset, int len) {
		return new SubReadOnlyBitBuffer(this, offset, len);
	}

}
