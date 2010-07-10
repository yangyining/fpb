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


public interface IEnsurableBitBuffer extends IWritableBitBuffer {
    //默认超时为1秒
    int DEFAULT_ENSURE_TIMEOUT = 1000;
    /**
     * 设置ensure操作的超时时间。
     * @param millisec 毫秒
     */
    void setEnsureTimeout(int millisec);
    /**
     * 取得ensure操作的超时时间。默认超时为1秒。
     * @return 毫秒
     */
    int getEnsureTimeout();
    /**
     * 确保指定偏移与position之间有指定大小的空间。如果没有足够的空间将会等待put
     * 操作来增长空间，直到空间的大小满足了条件。当持续等待时间超过EnsureTimeout时将会抛出
     * BufferTimeoutException例外，当Eof已被设置时将会返回false.
     * @param bitOffset 计算起始偏移，比特单位。
     * @param bits  确保空间大小
     * @return 是否有足够的空间。如果检索失败并且Eof时则返回false。
     * @throws BufferTimeoutException
     */
    boolean ensureSpace(int bitOffset, int bits) throws BufferTimeoutException;
    /**
     * 确保指定偏移与position之间的缓存中有有连续的字节串。如果没有检索到指定字节串会等待put操作来追加数据，
     * 直到找到检索字节串为止。当持续等待时间超过EnsureTimeout时将会抛出BufferTimeoutException。
     * @param byteOffset 检索起始偏移，字节单位。
     * @param bytes 检索字节串
     * @return 从开始位置到指定字节串的长度(字节单位)，包括指定字节串。如果检索失败并且EOF时则返回-1。
     * @throws BufferTimeoutException
     */
    int ensureBytes(int byteOffset, byte[] bytes) throws BufferTimeoutException;
    /**
     * 设置缓存结束，也就是不会再由于put方法的执行而增长已写空间长度了。
     */
    void setEof();
    /**
     * 缓存内容是否结束。
     * @return
     */
    boolean isEof();
    /**
     * 压缩已使用空间。
     * 丢弃[0, usedSpaceBits)间的已使用空间，将[usedSpaceBits，position)之间的数据拷贝到
     * [0, position-usedSpaceBits],并将position设置为position-usedSpaceBits。
     * @param usedSpaceBits 从0开始的已使用空间长度，比特单位，必须是8的倍数。 
     */
    void compactSpace(int usedSpaceBits);
}
