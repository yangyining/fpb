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


public interface IWritableBitBuffer extends IBitBuffer {
    /**
     * put操作是否是不受limit和capacity的限制。在不受限制的情况下当position由于put操作而
     * 超过了limit或capacity，则limit和capacity会自动增加。
     * @return
     */
    boolean isUnlimitedPut();
    /**
     * 将一个字节的数据写入缓存块中。
     * @param data
     * @return
     * @throws BufferOverflowException
     */
    IBitBuffer putByte(byte data) throws BitBufferException;
    /**
     * 将字节数组内的所有数据写入缓存块中。
     * @param data
     * @return
     * @throws BufferOverflowException
     */
    IBitBuffer putByte(byte[] data) throws BitBufferException;
    /**
     * 将字节数组内的指定数据写入缓存块中。
     * @param data 写入数据内容
     * @param offset 目标数据开始偏移，字节为单位，0开始。
     * @param len 目标数据的长度，字节为单位。
     * @return
     * @throws BufferOverflowException
     */
    IBitBuffer putByte(byte[] data, int offset, int len) 
    throws BitBufferException;
    /**
     * 将指定长度的数据以比特为单位存入BitBuffer中。
     * @param data 被存入的数据,从0比特开始。
     * @param len 被存入数据的长度，位单位。
     * @return
     * @throws BufferOverflowException
     */
    IBitBuffer putBit(byte[] data, int len) throws BitBufferException;
    /**
     * 将1Bit的数据存入BitBuffer中。
     * @param bit 存入规则为 true:1 false:0
     * @return
     * @throws BufferOverflowException
     */
    IBitBuffer putBit(boolean bit) throws BitBufferException;
//  /**
//  * 存入buffer中的所有数据。
//  * @param buffer
//  */
// BitBuffer put(BitBuffer buffer) throws BufferOverflowException;
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
    
}
