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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.api.util.buffer.BufferOverflowException;
import com.fineqt.fpb.lib.api.util.buffer.BufferUnderflowException;
import com.fineqt.fpb.lib.api.util.buffer.IBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.InvalidMarkException;
import com.fineqt.fpb.lib.util.FpbUtils;
import com.fineqt.fpb.lib.util.TextBitset;

abstract public class BitBufferBase implements IBitBuffer {
    // 不变条件: mark <= position <= limit <= capacity
	//标记，相对于arrayOffset
    protected int mark = -1;
	//当前位置，相对于arrayOffset
    protected int position;
    //array中数据的开始位置，绝对位置,比特单位
    protected int arrayOffset;
    //当前限制位置（不包含本身），如果<0则表示与capacity值相同，相对于arrayOffset
    protected int limit;

    public BitBufferBase(int position, int limit) {
    	this.position = position;
    	this.limit = limit;
    }

	@Override
	public byte[] array() {
		return getBuf();
	}
	@Override
	public int arrayOffset() {
		return arrayOffset;
	}
	/**
	 * 设置新的容量
	 * @param newCapacity
	 */
	abstract protected void capacity(int newCapacity);
	
	@Override
	public int position() {
		return position;
	}
	@Override
	public IBitBuffer position(int newPosition) {
		if ((newPosition > limit()) || (newPosition < 0))
		    throw new IllegalArgumentException();
		position = newPosition;
		if (mark > position) mark = -1;
		return this;
	}
	@Override
	public int limit() {
		if (limit < 0)
			return capacity();
		return limit;
	}
	@Override
	public IBitBuffer limit(int newLimit) {
		if ((newLimit > capacity()))
		    throw new IllegalArgumentException();
		limit = newLimit;
		if (position > limit()) 
			position = limit();
		if (mark > limit()) 
			mark = -1;
		return this;
	}
	@Override
    public boolean useCapacityAsLimit() {
        return limit < 0;
    }
    @Override
	public IBitBuffer mark() {
		mark = position;
		return this;
	}
	@Override
	public IBitBuffer reset() {
    	if (mark < 0)
    	    throw new InvalidMarkException();
    	position = mark;
    	return this;
	}
	@Override
	public IBitBuffer clear() {
		position = 0;
		limit = capacity();
		mark = -1;
		return this;
	}
	@Override
	public IBitBuffer rewind() {
		position = 0;
		mark = -1;
		return this;
	}
	@Override
	public int remaining() {
		return limit() - position;
	}
	@Override
	public boolean hasRemaining() {
		return position < limit();
	}

	abstract protected TextBitset getTempBits();
    /**
     * 必须在nextPutIndex等改变capacity的方法执行之后才执行。
     * @return
     */
    abstract protected byte[] getBuf();
    
	final protected boolean positionIsByteBorder() {
		return (arrayOffset + position) % BYTE_BITS == 0;
	}
	

	protected static int bytesInBits(int capacity) {
    	return (capacity + 7) / BYTE_BITS;
    }
    
    /**
     * Checks the current position against the limit, throwing a {@link
     * BufferUnderflowException} if it is not smaller than the limit, and then
     * increments the position. </p>
     *
     * @return  The current position value, before it is incremented
     */
    final protected int nextGetIndex() throws BufferUnderflowException {                
        if (position >= limit())
            throw new BufferUnderflowException(limit(), position);
        position++;
        return arrayOffset + position;
    }

    final protected int nextGetIndex(int nb) throws BufferUnderflowException{           
        if (limit() - position < nb)
            throw new BufferUnderflowException(limit(), position + nb);
        int p = position;
        position += nb;
        return arrayOffset + p;
    }

    /**
     * Checks the current position against the limit, throwing a {@link
     * BufferOverflowException} if it is not smaller than the limit, and then
     * increments the position. </p>
     *
     * @return  The current position value, before it is incremented
     */
    final protected int nextPutIndex(boolean increment) throws BufferOverflowException {             
        return nextPutIndex(1, increment);
    }

    final protected int nextPutIndex(int nb, boolean increment) throws BufferOverflowException{
        //可以自动增长
        if (increment) {
            if (limit() - position < nb) {
                int dstlimit = position + nb;
                //增长空间
                while (dstlimit > capacity()) {
                    capacity(capacity() * 2) ;
                }
                //如果是有限制limit
                if (limit() - position < nb) {
                    limit = capacity();
                }
            }
        //不可自动增长
        } else {
            if (limit() - position < nb)
                throw new BufferOverflowException();
        }
        int p = position;
        position += nb;
        return arrayOffset + p;
    }
    
//    /**
//     * Checks the given index against the limit, throwing an {@link
//     * IndexOutOfBoundsException} if it is not smaller than the limit
//     * or is smaller than zero.
//     */
//    final protected int checkIndex(int i) {			
//		if ((i < 0) || (i >= limit()))
//		    throw new IndexOutOfBoundsException();
//		return i;
//    }
//
//    final protected int checkIndex(int i, int nb) {		
//		if ((i < 0) || (nb > limit() - i))
//		    throw new IndexOutOfBoundsException();
//		return i;
//    }
    
    public String toString() {
    	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE); 
    	builder.append("position", position)
	    	.append("limit", limit)	
	    	.append("capacity", capacity())	
	    	.append("arrayOffset", arrayOffset)	
	    	.append("mark", mark);	
    	builder.append("\n");
    	builder.append("buf", FpbUtils.getHexDump(getBuf(), 16));
    	return builder.toString();
    }
    
}
