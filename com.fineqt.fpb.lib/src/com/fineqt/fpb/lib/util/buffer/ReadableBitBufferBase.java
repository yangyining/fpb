/*************************************************************************
Protocol Meter, copyright (C) 2007-2008 fineqt.com

Protocol Meter is free software; you can redistribute it and/or modify it 
under the terms of version 2.1 of the GNU Lesser General Public License as 
published by the Free Software Foundation.

Protocol Meter is distributed in the hope that it will be useful, but WITHOUT 
ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
License for more details at gnu.org.
**************************************************************************/
package com.fineqt.fpb.lib.util.buffer;

import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.BufferBoundaryException;
import com.fineqt.fpb.lib.api.util.buffer.BufferUnderflowException;
import com.fineqt.fpb.lib.api.util.buffer.IBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.util.BitRegion;
import com.fineqt.fpb.lib.util.BitRegionImpl;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.TextBitset;

abstract public class ReadableBitBufferBase extends BitBufferBase 
implements IReadableBitBuffer {

    public ReadableBitBufferBase(int position, int limit) {
        super(position, limit);
    }

    @Override
    public IBitBuffer getBit(byte[] data, int len)
            throws BufferUnderflowException {
        int pos = nextGetIndex(len);
        BitRegion bufRegion = new BitRegionImpl(pos, len);
        byte[] getdata = prepareGetBit(bufRegion);
        //设置取得数据
        System.arraycopy(getdata, 0, data, 0, bufRegion.getByteLen());      
        return this;
    }

    @Override
    public boolean getBit() throws BitBufferException {
        int pos = nextGetIndex(1);
        BitRegion bufRegion = new BitRegionImpl(pos, 1);
        byte[] getdata = prepareGetBit(bufRegion);
        return (getdata[0] & 0xFF) == 0x80;
    }
    
    private byte[] prepareGetBit(BitRegion bufRegion) {
        TextBitset tmpBits = getTempBits();
        byte[] buf = getBuf();
        //取得数据
        byte[] getdata = new byte[bufRegion.getByteLen()];
        System.arraycopy(buf, bufRegion.getByteOffset(), getdata, 0, 
                bufRegion.getByteLen());
        //将尾部多余位清零
        if (bufRegion.getRightMaskBits() > 0) {
            getdata[bufRegion.getByteLen()-1] = (byte)(getdata[bufRegion.getByteLen()-1] 
                   & getTailByteMask(bufRegion.getRightMaskBits()));
        }
        //去除头部多余位
        if (bufRegion.getLeftMaskBits() > 0) {
            tmpBits.setRaw(getdata);
            tmpBits.shiftLeft(bufRegion.getLeftMaskBits());
            getdata = tmpBits.getRaw();
        }
        return getdata;
    }
    
    final private int getTailByteMask(int tailBits) {
        return 0xFF << tailBits;
    }
    
    @Override
    public byte getByte() throws BitBufferException {
        //非字节边界开始
        if (!positionIsByteBorder()) {
            byte tmpdata[] = new byte[1];
            getBit(tmpdata, BYTE_BITS);
            return tmpdata[0];
        //字节边界开始
        } else {
            int pos = nextGetIndex(BYTE_BITS);
            byte[] buf = getBuf();
            int bytePos = pos / BYTE_BITS;
            return buf[bytePos];
        }
    }
    @Override
    public IBitBuffer getByte(byte[] data, int byteOffset, int byteLen)
            throws BitBufferException {
        //非字节边界开始
        if (!positionIsByteBorder()) {
            if (byteOffset > 0) {
                byte tmpdata[] = new byte[byteLen];
                getBit(tmpdata, BYTE_BITS * byteLen);
                System.arraycopy(tmpdata, 0, data, byteOffset, byteLen);
            } else {
                getBit(data, BYTE_BITS * byteLen);
            }
        //字节边界开始
        } else {
            int pos = nextGetIndex(BYTE_BITS * byteLen);
            byte[] buf = getBuf();
            int bytePos = pos / BYTE_BITS;
            System.arraycopy(buf, bytePos, data, byteOffset, byteLen);
        }
        return this;
    }
    @Override
    public IBitBuffer getByte(byte[] data) throws BitBufferException {
        return getByte(data, 0, data.length);
    }
    @Override
    public CharSequence getAsCharSequence() throws BufferBoundaryException {
        return new BitBufferCharSequence();
    }
 
    protected class BitBufferCharSequence implements CharSequence {
        //BitBuffer缓存的开始偏移（字节单位）
        private int offset;
        //有效数据长度（字节单位）
        private int length;
        
        public BitBufferCharSequence() throws BufferBoundaryException {
            if( (arrayOffset() + position()) % FpbConstants.CHAR_BITS != 0) {
                throw new BufferBoundaryException(arrayOffset() + position(), 
                        FpbConstants.CHAR_BITS);
            }
            offset = (arrayOffset() + position()) / FpbConstants.CHAR_BITS;
            if (remaining() % FpbConstants.CHAR_BITS != 0) {
                throw new BufferBoundaryException(remaining(), 
                        FpbConstants.CHAR_BITS);
            }
            length = remaining() / FpbConstants.CHAR_BITS;
        }
        
        private BitBufferCharSequence(int offset, int length) {
            this.offset = offset;
            this.length = length;
        }

        @Override
        public char charAt(int index) {
            if (index >= length)
                throw new IllegalArgumentException();
            return (char)getBuf()[offset + index];
        }

        @Override
        public int length() {
            return length;
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            if (start >= length || end > length || start > end) {
                throw new IllegalArgumentException();
            }
            return new BitBufferCharSequence(offset+start, end - start);
        }
        
    }
    
}
