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
package com.fineqt.fpb.lib.api.util.buffer;


public interface IReadableBitBuffer extends IBitBuffer {
    /**
     * 取得一个字节的数据。
     * @return
     * @throws BufferUnderflowException
     */
    byte getByte() throws BitBufferException;
    /**
     * 取得指定字节的数据并将其存入data参数中。取得字节的长度是data字节数组的长度。
     * @param data
     * @return
     * @throws BufferUnderflowException
     */
    IBitBuffer getByte(byte[] data) throws BitBufferException;
    /**
     * 取得指定字节的数据并将其存入data参数中。取得字节的长度是len参数的值，取得的数据从offset指定的
     * 偏移位置存入data中。
     * @param data 数据缓存，用来存放取得的数据。
     * @param offset data的存放开始偏移，字节单位。
     * @param len 取得数据的长度，字节单位。
     * @return
     * @throws BufferUnderflowException
     */
    IBitBuffer getByte(byte[] data, int offset, int len) throws BitBufferException;

    /**
     * 取出1Bit的数据。
     * @return 规则为 true:1 false:0
     * @throws BufferOverflowException
     */
    boolean getBit() throws BitBufferException;
    
    /**
     * 取得指定长度的数据并将其存入data参数中。
     * data的最后一个字节的指定长度以外的比特也可能会被覆盖。
     * @param data 存放取到数据的缓存，从0比特开始。
     * @param len 读取数据的长度，比特单位。
     * @return
     * @throws BufferUnderflowException
     */
    IBitBuffer getBit(byte[] data, int len) throws BitBufferException;

    /**
     * 取得当前缓存的子集，将只读。返回子集共享父BitBuffer的内部字节缓存，但是有效数据从offset开始，
     * capacity是len。
     * @param offset 子集的开始偏移量。
     * @param len 子集的长度。当len为GET_LEN_BY_SUPER_POSITION时表示使用superBuffer的position
     * 来动态计算长度。当len为GET_LEN_BY_SUPER_CAPACITY时表示使用superBuffer的capacity来动态计算长度。
     * 由于superBuffer的capacity和position是有可能增长的，所以长度可能增长。当len>=0时为固定长度。
     * @return 子集对象。
     */
    IReadableBitBuffer subBitBuffer(int offset, int len);
    
    /**
     * 生成根据当前的position和limit数值来取得读取相应范围内数据的CharSequence对象。
     * 当前arrayOffset+position的位置必须是8的倍数。
     * @return
     */
    CharSequence getAsCharSequence() throws BufferBoundaryException;
}
