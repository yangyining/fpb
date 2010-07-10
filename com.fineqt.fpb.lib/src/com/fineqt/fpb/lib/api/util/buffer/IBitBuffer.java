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
package com.fineqt.fpb.lib.api.util.buffer;


/**
 * 以比特为单位的缓存块。
 * 类似于NIO的ByteBuffer，不过这里以字节为存储单位。内部以Byte数组来保存数据，
 * 并且这个byte数组可以根据需要自动增长。除特别指定外，各个方法的参数和返回值都是以比特为单位。
 * @author JiangMin
 *
 */
public interface IBitBuffer {
	int BYTE_BITS = 8;
	/**
	 * 用于subBuffer方法的len参数
	 */
	public static int GET_LEN_BY_SUPER_POSITION = -1;
	/**
	 * 用于subBuffer方法的len参数
	 */
	public static int GET_LEN_BY_SUPER_CAPACITY = -2;
	/**
	 * 取得内部数组，当对该数组进行操作时回改变BitBuffer对象的内容。
	 * @return
	 */
	byte[] array();
	/**
	 * array返回数组中有效数据的开始偏移量。比特为单位。
	 * @return
	 */
	int arrayOffset();
    /**
     * 取得内部缓存现在的容量。
     * @return
     */
    int capacity();
    /**
     * 清空缓存。position设为0,limit设为capacity的值；所有Mark被删除。
     * @return
     */
    IBitBuffer clear();
    /**
     * 是否有空闲的空间。
     * @return
     */
    boolean hasRemaining();
    /**
     * 返回剩闲空间大小。
     * @return limit-position
     */
    int remaining();
    /**
     * 取得limit的值。limit是get或put操作时第一个禁止操作比特的索引。
     * @return
     */
    int limit();
    /**
     * 设置limit的值。limit是get或put操作时第一个禁止操作比特的索引。
     * 
     * @param limit limit的值，如果为-1则表示取得的limit值始终与capapcity相同。
     * @return
     */
    IBitBuffer limit(int limit);
    /**
     * 是否是使用capacity来作为limit的值。
     * @return
     */
    boolean useCapacityAsLimit();
    /**
     * 返回position的值。
     * @return
     */
    int position();
    /**
     * 设置position的值。
     * @param position
     * @return
     */
    IBitBuffer position(int position);
    /**
     * 将当前的position标记为mark。
     * @return
     */
    IBitBuffer mark();
    /**
     * 将position设置为前一个被设置的mark，并且mark的值不会被改变。
     * @return
     */
    IBitBuffer reset();
    /**
     * 回转当前位置。将position设为0，用于从新读写数据。
     * @return
     */
    IBitBuffer rewind();
}
