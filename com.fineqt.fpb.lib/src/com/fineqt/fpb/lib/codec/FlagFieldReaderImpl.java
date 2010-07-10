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

import static com.fineqt.fpb.lib.util.FpbUtils.FIX_LENGTH_INT_MASKS;

import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.meta.MetaConstants;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.SerializeUtil;
import com.fineqt.fpb.lib.util.TextBitset;

public class FlagFieldReaderImpl implements FlagFieldReader, MetaConstants {
	//Flag整体的值，不可能为负数，最大有效位为32
	private long flagValue;
	//Flag所拥有的比特长度
	private int dataSize;
	//从Flag所拥有的比特的最高位开始的偏移量
	private int offset;
	
	public FlagFieldReaderImpl(IReadableBitBuffer input, FlagFieldType fieldType, 
			ByteOrder byteOrder) throws BitBufferException {
		//size
		switch(fieldType) {
		case OCTET:
			dataSize = OCTET_BITS;
			break;
		case OCTET2:
			dataSize = OCTET_BITS * 2;
			break;
		case OCTET4:
			dataSize = OCTET_BITS * 4;
			break;
		case NONE:
			throw new IllegalArgumentException();
		}
		//read value
		flagValue = SerializeUtil.decodeInt4fpb(input, false, dataSize, 
				byteOrder).longValue();
	}
	
	@Override
	public long getFlagValue() {
		return flagValue;
	}

	@Override
	public long getOffset() {
		return offset;
	}

	@Override
	public boolean isFinished() {
		return offset >= dataSize;
	}

	@Override
	public TextBitset readBits(int length) {
		if (offset + length > dataSize) {
			throw new IllegalArgumentException();
		}
		TextBitset bits = new NativeTextBitset();
		bits.resize(INT_BITS);
		bits.setAsInteger(flagValue);
		bits.shiftLeft(offset+INT_BITS-dataSize);
		bits.resize(length);
		offset += length;
		return bits;
	}

	@Override
	public boolean readBoolean() {
		if (offset + 1 > dataSize) {
			throw new IllegalStateException();
		}
		long value = flagValue >> (dataSize - offset - 1) & FIX_LENGTH_INT_MASKS[0];
		offset++;
		return value > 0;
	}

	@Override
	public long readInteger(boolean signed, int length) {
		if (offset + length > dataSize) {
			throw new IllegalArgumentException();
		}
		long result;
		//有符号
		if (signed) {
			//转换成Int然后去掉低位
			int intValue = (int)(flagValue << (INT_BITS - dataSize + offset) & 0xFFFFFFFF);
			result = intValue >> (INT_BITS - length);
		//无符号
		} else {
			long tmpvalue = flagValue >> (dataSize - offset - length);
			result = tmpvalue & FIX_LENGTH_INT_MASKS[length - 1];
		}
		offset += length;
		return result;
	}

}
