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

import java.math.BigInteger;

import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IWritableBitBuffer;
import com.fineqt.fpb.lib.meta.MetaConstants;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType;
import com.fineqt.fpb.lib.util.SerializeUtil;
import com.fineqt.fpb.lib.util.TextBitset;

public class FlagFieldWriterImpl implements FlagFieldWriter, MetaConstants{
	//Flag整体的值，不可能为负数，最大有效位为32
	private long flagValue;
	//Flag所拥有的比特长度
	private int dataSize;
	//从Flag所拥有的比特的最高位开始的偏移量
	private int offset;
	private ByteOrder byteOrder;
	private IWritableBitBuffer output;
	
	public FlagFieldWriterImpl(IWritableBitBuffer output, FlagFieldType fieldType, ByteOrder byteOrder) {
		assert fieldType != null;
		assert byteOrder != null;
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
		this.byteOrder = byteOrder;
		this.output = output;
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
	public void writeBits(TextBitset bits) throws BitBufferException {
		int length = bits.size();
		if (offset + length > dataSize) {
			throw new IllegalArgumentException();
		}
		//取得Bits代表的无符号Int
		long value = bits.getAsInteger();
		//覆盖对应位
		flagValue = flagValue | (value << (dataSize - offset - length));
		offset += length;
		if (isFinished()) {
			writeFlagValue();
		}
	}
	
	private void writeFlagValue() throws  BitBufferException {
		SerializeUtil.encodeInt4fpb(output, BigInteger.valueOf(flagValue), dataSize, byteOrder);
	}

	@Override
	public void writeBoolean(boolean bit) throws BitBufferException {
		if (offset + 1 > dataSize) {
			throw new IllegalArgumentException();
		}
		//取得Bits代表的无符号Int
		long value = bit ? 1 : 0;
		//覆盖对应位
		flagValue = flagValue | (value << (dataSize - offset - 1));
		offset++;
		if (isFinished()) {
			writeFlagValue();
		}
	}

	@Override
	public void writeInteger(long intValue, int length) throws BitBufferException {
		if (offset + 1 > dataSize) {
			throw new IllegalArgumentException();
		}
		//取得intValue代表的无符号Int
		long value = intValue & FIX_LENGTH_INT_MASKS[length];
		//覆盖对应位
		flagValue = flagValue | (value << (dataSize - offset - length));
		offset += length;
		if (isFinished()) {
			writeFlagValue();
		}
	}
	
}
