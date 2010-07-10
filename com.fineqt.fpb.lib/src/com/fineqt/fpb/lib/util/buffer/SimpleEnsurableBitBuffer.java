package com.fineqt.fpb.lib.util.buffer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.BufferBoundaryException;
import com.fineqt.fpb.lib.api.util.buffer.BufferTimeoutException;
import com.fineqt.fpb.lib.api.util.buffer.BufferUnderflowException;
import com.fineqt.fpb.lib.api.util.buffer.IBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IEnsurableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.util.BitRegion;
import com.fineqt.fpb.lib.util.BitRegionImpl;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;


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
public class SimpleEnsurableBitBuffer extends BitBufferBase 
implements IEnsurableBitBuffer {
    final public static int DEFAULT_INIT_CAPACITY = 16 * BYTE_BITS;

    private byte[] buf;
    private TextBitset tempBits;
    //缓存容量
    private int capacity;
    //是否外部的输入已经结束
    private boolean eof;
    //超时时间，毫秒单位
    private int ensureTimeout = DEFAULT_ENSURE_TIMEOUT;
    //写操作锁
    private ReentrantLock writeLock = new ReentrantLock();
    //有写操作发生条件
    private Condition wroteCond = writeLock.newCondition();
    
    public SimpleEnsurableBitBuffer() {
        super(0, -1);
        capacity = DEFAULT_INIT_CAPACITY;
    }

    @Override
    public int ensureBytes(int byteOffset, byte[] bytes)
            throws BufferTimeoutException {
        if (!positionIsByteBorder()) {
            throw new IllegalArgumentException();
        }
        writeLock.lock();
        try {
            while(true) {
                int posInBytes = position() / BYTE_BITS;
                //有足够容量
                if (posInBytes -  byteOffset >= bytes.length) {
                    //匹配数据
                    byte[] buf = getBuf();
//                    System.out.println("getBuf:<<"+new String(buf, 0, posInBytes)+">>");
                    for (int i = byteOffset; i <= ( posInBytes - bytes.length ); i++) {
                        boolean hasUnMatchByte = false;
                        //匹配
                        for (int j = 0; j < bytes.length; j++) {
                            if (buf[i+j] != bytes[j]) {
                                hasUnMatchByte = true;
                                break;
                            }
                        }
                        //匹配成功
                        if (!hasUnMatchByte) {
                            return i - byteOffset + bytes.length;
                        }
                    }
                }
                if (eof) {
                    return -1;
                }
                try {
                    if (!wroteCond.await(ensureTimeout, TimeUnit.MILLISECONDS)) {
                        throw new BufferTimeoutException();
                    }
                //外部中断
                } catch (InterruptedException e) {
                    return -1;
                }
            }
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean ensureSpace(int bitOffset, int bits) throws BufferTimeoutException {
        writeLock.lock();
        try {
            while(position() - bitOffset < bits) {
                if (eof) {
                    return false;
                }
                try {
                    if (!wroteCond.await(ensureTimeout, TimeUnit.MILLISECONDS)) {
                        throw new BufferTimeoutException();
                    }
                //外部中断
                } catch (InterruptedException e) {
                    return false;
                }
            }
            return true;
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public int getEnsureTimeout() {
        return ensureTimeout;
    }

    @Override
    public void setEnsureTimeout(int millisec) {
        ensureTimeout = millisec;        
    }

    @Override
    public void setEof() {
        writeLock.lock();
        try {
            eof = true;        
            //通知
            wroteCond.signal();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean isEof() {
        return eof;
    }

    @Override
    public boolean isUnlimitedPut() {
        return true;
    }

    @Override
    public IBitBuffer putBit(byte[] data, int len)
            throws BitBufferException {
        writeLock.lock();
        try {
            int pos = nextPutIndex(len, true);
            BitRegion bufRegion = new BitRegionImpl(pos, len);
            byte[] buf = getBuf();
            data = preparePutBit(data, len, bufRegion, buf); 
            //拷贝设置数据
            System.arraycopy(data, 0, buf, bufRegion.getByteOffset(), bufRegion.getByteLen());
            //通知
            wroteCond.signal();
            return this;
        } finally {
            writeLock.unlock();            
        }
    }

    @Override
    public IBitBuffer putBit(boolean bit) throws BitBufferException {
        writeLock.lock();
        try {
            int pos = nextPutIndex(1, true);
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
            //通知
            wroteCond.signal();
            return this;
        } finally {
            writeLock.unlock();            
        }
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
        writeLock.lock();
        try {
            //非字节边界开始
            if (!positionIsByteBorder()) {
                byte[] tmpdata = new byte[1];
                tmpdata[0] = data;
                putBit(tmpdata, BYTE_BITS);
            //字节边界开始
            } else {
                int pos = nextPutIndex(BYTE_BITS, true);
                byte[] buf = getBuf();
                int bytePos = pos / BYTE_BITS;
                buf[bytePos] = data;
                //通知
                wroteCond.signal();
            }
            return this;
        } finally {
            writeLock.unlock();            
        }
    }
    @Override
    public IBitBuffer putByte(byte[] data, int byteOffset, int byteLen)
            throws BitBufferException {
        writeLock.lock();
        try {
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
                int pos = nextPutIndex(BYTE_BITS * byteLen, true);
                byte[] buf = getBuf();
                int bytePos = pos / BYTE_BITS;
                System.arraycopy(data, byteOffset, buf, bytePos, byteLen);
                //通知
                wroteCond.signal();
            }
            return this;
        } finally {
            writeLock.unlock();            
        }
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
    public IBitBuffer clear() {
        //对position有修改，所以加锁
        writeLock.lock();
        try {
            return super.clear();
        } finally {
            writeLock.unlock();            
        }
    }

    @Override
    public IBitBuffer position(int newPosition) {
        //对position有修改，所以加锁
        writeLock.lock();
        try {
            return super.position(newPosition);
        } finally {
            writeLock.unlock();            
        }
    }

    @Override
    public IBitBuffer reset() {
        //对position有修改，所以加锁
        writeLock.lock();
        try {
            return super.reset();
        } finally {
            writeLock.unlock();            
        }
    }

    @Override
    public IBitBuffer rewind() {
        //对position有修改，所以加锁
        writeLock.lock();
        try {
            return super.rewind();
        } finally {
            writeLock.unlock();            
        }
    }

    @Override
    public IBitBuffer limit(int newLimit) {
        //固定为-1，即可以无限扩展的
        throw new UnsupportedOperationException();
    }

    @Override
    public void compactSpace(int usedSpaceBits) {
        if (usedSpaceBits > position) {
            throw new IllegalArgumentException();
        }
        if (usedSpaceBits % FpbConstants.OCTET_BITS != 0) {
            throw new IllegalArgumentException();
        }
        //对position有修改，所以加锁
        writeLock.lock();
        try {
            position = position - usedSpaceBits;
            BitRegion bufRegion = new BitRegionImpl(usedSpaceBits, position);
            byte[] buf = getBuf();
            //拷贝设置数据
            System.arraycopy(buf, bufRegion.getByteOffset(), buf, 0, bufRegion.getByteLen());
        } finally {
            writeLock.unlock();            
        }
    }

    @Override
    public IReadableBitBuffer subBitBuffer(int offset, int len) {
        return new ConcurrentSubReadOnlyBitBuffer(this, offset, len);
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
    
    class ConcurrentSubReadOnlyBitBuffer extends SubReadOnlyBitBuffer {

        public ConcurrentSubReadOnlyBitBuffer(IBitBuffer superBuffer, int offset, int len) {
            super(superBuffer, offset, len);
        }

        @Override
        public int capacity() {
            //使用了父Buffer的capacity，所以加锁
            writeLock.lock();
            try {
                return super.capacity();
            } finally {
                writeLock.unlock();            
            }
        }

        @Override
        public IReadableBitBuffer subBitBuffer(int offset, int len) {
            return new ConcurrentSubReadOnlyBitBuffer(this, offset, len);
        }

        @Override
        public CharSequence getAsCharSequence() throws BufferBoundaryException {
            return new ConcurrentBitBufferCharSequence();
        }

        @Override
        public boolean getBit() throws BitBufferException {
            writeLock.lock();
            try {
                return super.getBit();
            } finally {
                writeLock.unlock();            
            }
        }

        @Override
        public IBitBuffer getBit(byte[] data, int len) throws BufferUnderflowException {
            writeLock.lock();
            try {
                return super.getBit(data, len);
            } finally {
                writeLock.unlock();            
            }
        }

        @Override
        public byte getByte() throws BitBufferException {
            writeLock.lock();
            try {
                return super.getByte();
            } finally {
                writeLock.unlock();            
            }
        }

        @Override
        public IBitBuffer getByte(byte[] data, int byteOffset, int byteLen)
                throws BitBufferException {
            writeLock.lock();
            try {
                return super.getByte(data, byteOffset, byteLen);
            } finally {
                writeLock.unlock();            
            }
        }

        @Override
        public IBitBuffer getByte(byte[] data) throws BitBufferException {
            writeLock.lock();
            try {
                return super.getByte(data);
            } finally {
                writeLock.unlock();            
            }
        }
        
        class ConcurrentBitBufferCharSequence extends BitBufferCharSequence {

            public ConcurrentBitBufferCharSequence() throws BufferBoundaryException {
            }

            @Override
            public char charAt(int index) {
                //使用了父Buffer的getBuf()，所以加锁
                writeLock.lock();
                try {
                    return super.charAt(index);
                } finally {
                    writeLock.unlock();            
                }
            }

            
        }
        
    }
    
}
