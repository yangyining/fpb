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

import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadWritableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.util.BitRegion;
import com.fineqt.fpb.lib.util.BitRegionImpl;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;


/**
 * 不支持并行操作，需要在外部同步化。
 * 
 * @author JiangMin
 *
 */
public class SimpleBitBuffer extends ReadableBitBufferBase implements IReadWritableBitBuffer {
	final public static int DEFAULT_INIT_CAPACITY = 16 * BYTE_BITS;

	private byte[] buf;
    private TextBitset tempBits;
    //put时是否自动增长
    protected boolean unlimitedPut;
	//缓存容量
    private int capacity;
    
	public SimpleBitBuffer() {
		this(DEFAULT_INIT_CAPACITY, false);
	}

	public SimpleBitBuffer(int capacity, boolean unlimitedPut) {
		super(0, capacity);
		this.capacity = capacity;
		this.unlimitedPut = unlimitedPut;
	}

	public SimpleBitBuffer(int capacity) {
		this(capacity, false);
	}

	/**
	 * 
	 * @param buf buf内的数据有可能由于BitBuffer的操作而改变。
	 */
	public SimpleBitBuffer(byte[] buf) {
		super(0, buf.length * BYTE_BITS);
		this.buf = buf;
		this.capacity = buf.length * BYTE_BITS;
		unlimitedPut = false;
	}
	
    @Override
    public boolean isUnlimitedPut() {
        return unlimitedPut;
    }

    @Override
    public IBitBuffer flip() {
        limit = position;
        position = 0;
        mark = -1;
        return this;
    }
    
    @Override
    public IBitBuffer putBit(byte[] data, int len)
            throws BitBufferException {
        int pos = nextPutIndex(len, unlimitedPut);
        BitRegion bufRegion = new BitRegionImpl(pos, len);
        byte[] buf = getBuf();
        data = preparePutBit(data, len, bufRegion, buf); 
        //拷贝设置数据
        System.arraycopy(data, 0, buf, bufRegion.getByteOffset(), bufRegion.getByteLen());
        return this;
    }

    @Override
    public IBitBuffer putBit(boolean bit) throws BitBufferException {
        int pos = nextPutIndex(1, unlimitedPut);
        BitRegion bufRegion = new BitRegionImpl(pos, 1);
        byte[] buf = getBuf();
        byte[] data = new byte[1];
        if (bit) {
            data[0] = (byte)0x80;
        } else {
            data[0] = (byte)0;
        }
        data = preparePutBit(data, 1, bufRegion, buf); 
        //拷贝设置数据
        System.arraycopy(data, 0, buf, bufRegion.getByteOffset(), bufRegion.getByteLen());
        return this;
    }

    private byte[] preparePutBit(byte[] data, int len, BitRegion bufRegion,
            byte[] buf) {
        TextBitset tmpBits = getTempBits();
        //有头部多余数据
        if (bufRegion.getLeftMaskBits() > 0) {
            tmpBits.resize(0);
            //头部第一字节，并清除后部空数据
            tmpBits.append(buf[bufRegion.getByteOffset()]);
            tmpBits.resize(bufRegion.getLeftMaskBits());
            //追加剩余字节
            tmpBits.append(data, 0, bytesInBits(len));
            data = tmpBits.getRaw();
        }
        return data;
    }
    
    @Override
    public IBitBuffer putByte(byte data) throws BitBufferException {
        //非字节边界开始
        if (!positionIsByteBorder()) {
            byte[] tmpdata = new byte[1];
            tmpdata[0] = data;
            putBit(tmpdata, BYTE_BITS);
        //字节边界开始
        } else {
            int pos = nextPutIndex(BYTE_BITS, unlimitedPut);
            byte[] buf = getBuf();
            int bytePos = pos / BYTE_BITS;
            buf[bytePos] = data;
        }
        return this;
    }
    @Override
    public IBitBuffer putByte(byte[] data, int byteOffset, int byteLen)
            throws BitBufferException {
        //非字节边界开始
        if (!positionIsByteBorder()) {
            if (byteOffset > 0) {
                byte[] tmpdata = new byte[byteLen];
                System.arraycopy(data, byteOffset, tmpdata, byteOffset, byteLen);
                putBit(tmpdata, BYTE_BITS * byteLen);
            } else {
                putBit(data, BYTE_BITS * byteLen);
            }
        //字节边界开始
        } else {
            int pos = nextPutIndex(BYTE_BITS * byteLen, unlimitedPut);
            byte[] buf = getBuf();
            int bytePos = pos / BYTE_BITS;
            System.arraycopy(data, byteOffset, buf, bytePos, byteLen);
        }
        return this;
    }
    @Override
    public IBitBuffer putByte(byte[] data) throws BitBufferException {
        return putByte(data, 0, data.length);
    }

	@Override
	protected void capacity(int newCapacity) {
		this.capacity = newCapacity;
	}

	@Override
	public int capacity() {
		return capacity;
	}

	@Override
	public IReadableBitBuffer subBitBuffer(int offset, int len) {
		return new SubReadOnlyBitBuffer(this, offset, len);
	}

    @Override
    protected TextBitset getTempBits() {
    	if (tempBits == null) {
    		tempBits = new NativeTextBitset();
    	}
    	return tempBits;
    }

	@Override
	protected byte[] getBuf() {
		int bufLen = bytesInBits(arrayOffset() + capacity());
		//新建
		if (buf == null) {
			buf = new byte[bufLen];
		}
		//扩展容量
		if (buf.length  < bufLen && isUnlimitedPut()) {
			byte[] orgBytes = buf;
			buf = new byte[bufLen];
			System.arraycopy(orgBytes, 0, buf, 0, orgBytes.length);
		}
		return buf;
	}
    
}
