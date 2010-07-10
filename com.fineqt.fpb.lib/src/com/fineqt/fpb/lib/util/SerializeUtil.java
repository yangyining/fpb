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

import java.math.BigDecimal;
import java.math.BigInteger;

import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IWritableBitBuffer;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;

public class SerializeUtil {
	private final static int BYTE_BITS = 8;
	private final static byte MINUS_COMPLEMENT_BYTE = (byte)0xFF;
	private final static byte PLUS_COMPLEMENT_BYTE = 0;
	
	static public void encodeInt4fpb(IWritableBitBuffer buffer, BigInteger value, int length,
			ByteOrder byteOrder) throws BitBufferException {
		assert length % BYTE_BITS == 0;
		assert length > 0;
		if (byteOrder == null) {
			throw new IllegalArgumentException();
		}
		int lenInBytes = length / BYTE_BITS;
		byte[] valueBytes = value.toByteArray();
		//开始不足的字节值
		byte prefixByte;
		if (value.signum() >= 0) {
			prefixByte = PLUS_COMPLEMENT_BYTE;
		} else {
			prefixByte = MINUS_COMPLEMENT_BYTE;
		}
		switch(byteOrder) {
		case BIGENDIAN:
			//高位不足的字节
			for (int i = 0; i < lenInBytes - valueBytes.length; i++) {
				buffer.putByte(prefixByte);
			}
			//实体字节
			int startOff = valueBytes.length > lenInBytes ? valueBytes.length - lenInBytes : 0;
			for (int i = startOff; i < valueBytes.length; i++) {
				buffer.putByte(valueBytes[i]);
			}
			break;
		case LITTLEENDIAN:
			//实体字节
			int dstLen = valueBytes.length > lenInBytes ? lenInBytes : valueBytes.length;
			for (int i = 0; i < dstLen; i++) {
				buffer.putByte(valueBytes[valueBytes.length - 1 - i]);
			}
			//高位不足的字节
			for (int i = 0; i < lenInBytes - dstLen; i++) {
				buffer.putByte(prefixByte);
			}
			break;
		}
	}
	
	static public BigInteger decodeInt4fpb(IReadableBitBuffer buffer, boolean signed, int length,
			ByteOrder byteOrder) throws BitBufferException {
		assert length % BYTE_BITS == 0;
		assert length > 0;
		int lenInBytes = length / BYTE_BITS;
		byte[] valueBytes = new byte[lenInBytes];
		//读入数据
		buffer.getByte(valueBytes);
		byte[] beBytes;
		//取得BE字节
		if (byteOrder == ByteOrder.BIGENDIAN) {
			beBytes = valueBytes;
		} else {
			beBytes = new byte[valueBytes.length];
			for (int i = 0; i < beBytes.length; i++) {
				beBytes[i] = valueBytes[beBytes.length - i - 1];
			}
		}
		//无符号
		if (!signed) {
			//BigInteger内部自动会判断是否是0，所以用1
			return new BigInteger(1, beBytes);
		//有符号
		} else {
			return new BigInteger(beBytes);
		}
	}

	static public void encodeFloat4fpb(IWritableBitBuffer buffer, BigDecimal value, int length, 
			boolean singed)  throws BitBufferException {
		throw new UnsupportedOperationException();
	}
	
	static public BigDecimal decodeFloat4fpb(IReadableBitBuffer buffer, int length, 
			boolean singed) throws BitBufferException {
		throw new UnsupportedOperationException();
	}
	
	static public void encodeBoolean4fpb(IWritableBitBuffer buffer, boolean value) 
	throws BitBufferException {
		buffer.putBit(value);
	}

	static public boolean decodeBoolean4fpb(IReadableBitBuffer buffer) 
	throws BitBufferException {
		return buffer.getBit();
	}
	
	static public void encodeBitstring4fpb(IWritableBitBuffer buffer, TextBitset bitset) 
	throws BitBufferException {
		buffer.putBit(bitset.getRaw(), bitset.size());
	}
	
	static public TextBitset decodeBitstring4fpb(IReadableBitBuffer buffer, int bits) 
	throws BitBufferException {
		int byteLen = bits + 7 / FpbConstants.OCTET_BITS;
		byte[] byteArray = new byte[byteLen];
		buffer.getBit(byteArray, bits);
		TextBitset bitset = new NativeTextBitset(byteArray);
		bitset.resize(bits);
		return bitset;
	}
	
	static public void encodeHexstring4fpb(IWritableBitBuffer buffer, byte[] value, int bits)  
	throws BitBufferException {
		buffer.putBit(value, bits);
	}
	
	static public void decodeHexstring4fpb(IReadableBitBuffer buffer, byte[] value, int bits) 
	throws BitBufferException {
		buffer.getBit(value, bits);
	}
	
	static public void encodeOctet4fpb(IWritableBitBuffer buffer, byte[] value)  
	throws BitBufferException {
		buffer.putByte(value);
	}

	static public void decodeOctet4fpb(IReadableBitBuffer buffer, byte[] value) 
	throws BitBufferException {
		buffer.getByte(value);
	}
	
	static public void encodeCharstring4fpb(IWritableBitBuffer buffer, char[] value)  
	throws BitBufferException {
		byte[] bytes = new byte[value.length];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte)value[i];
		}
		buffer.putByte(bytes);
	}

	static public void decodeCharstring4fpb(IReadableBitBuffer buffer, char[] value) 
	throws BitBufferException {
		byte[] bytes = new byte[value.length];
		buffer.getByte(bytes);
		for (int i = 0; i < bytes.length; i++) {
			value[i] = (char)bytes[i];
		}
	}
	
	static public void encodeUCharstring4fpb(IWritableBitBuffer buffer, char[] value)  
	throws BitBufferException {
		throw new UnsupportedOperationException();
	}
	
	static public void docodeUCharstring4fpb(IReadableBitBuffer buffer, char[] value) 
	throws BitBufferException {
		throw new UnsupportedOperationException();
	}
}
