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
package com.fineqt.fpb.lib.api.util;

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.buffer.IEnsurableBitBuffer;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.util.PValueSerializer;
/**
 * 值对象串行化执行者类。
 * 
 * @author JiangMin
 *
 */
public interface IValueSerializer {
	/**
	 * 全局实例。
	 */
	IValueSerializer INSTANCE = PValueSerializer.PINSTANCE;
	/**
	 * 对值对象进行编码，返回编码后的字节数组。
	 * @param value 目标值对象。
	 * @param doCalculating 是否同时进行自动计算。
	 * @return 编码后的字节数组
	 * @throws EncodeException
	 */
	byte[] encode(IValue value, boolean doCalculating) throws EncodeException;
	/**
	 * 对已编码数据进行解码，返回解码后得到的对应值对象。
	 * @param data 目标被解码数据。
	 * @param hypType 解码依据类型。
	 * @return 解码后得到的对应值对象
	 * @throws DecodeException
	 */
	IValue decode(byte[] data, IType hypType) throws DecodeException;
	/**
	 * 对指定范围的已编码数据进行解码，返回解码后得到的对应值对象。
	 * @param data 目标被解码数据。
	 * @param offset 目标数据范围偏移量，字节为单位。
	 * @param len 目标数据范围长度，字节为单位。
	 * @param hypType 解码依据类型。
	 * @return 解码后得到的对应值对象
	 * @throws DecodeException
	 */
	IValue decode(byte[] data, int offset, int len, IType hypType) throws DecodeException;
	/**
	 * 
     * 对已编码数据进行解码，返回解码后得到的对应值对象。
     * @param data 目标被解码数据。
     * @param hypType 解码依据类型。
     * @param resultValueLen 用于返回解码所用数据的长度(比特单位)，目标长度被设置在resultValueLen[0]中。
     * @return 解码后得到的对应值对象
	 * @throws DecodeException
	 */
    IValue decode(byte[] data, IType hypType, int[] resultValueLen) throws DecodeException;
    /**
     * 对指定范围的已编码数据进行解码，返回解码后得到的对应值对象。
     * @param data 目标被解码数据。
     * @param offset 目标数据范围偏移量，字节为单位。
     * @param len 目标数据范围长度，字节为单位。
     * @param hypType 解码依据类型。
     * @param resultValueLen 用于返回解码所用数据的长度(比特单位)，目标长度被设置在resultValueLen[0]中。
     * @return 解码后得到的对应值对象
     * @throws DecodeException
     */
    IValue decode(byte[] data, int offset, int len, IType hypType, int[] resultValueLen) 
    throws DecodeException;
	/**
	 * 对已编码数据进行增量解码，返回解码后得到的对应值对象。
	 * 主要用于http等基于流协议的解码。
	 * @param buffer 目标被解码数据缓存。
	 * @param hypType 解码依据类型。
	 * @return 解码后得到的对应值对象
	 * @throws DecodeException
	 */
	IValue incrementDecode(IEnsurableBitBuffer buffer, IType hypType) throws DecodeException;
    /**
     * 对已编码数据进行增量解码，返回解码后得到的对应值对象。
     * 主要用于http等基于流协议的解码。
     * @param buffer 目标被解码数据缓存。
     * @param hypType 解码依据类型。
     * @param resultValueLen 用于返回解码所用数据的长度(比特单位)，目标长度被设置在resultValueLen[0]中。
     * @return 解码后得到的对应值对象
     * @throws DecodeException
     */
    IValue incrementDecode(IEnsurableBitBuffer buffer, IType hypType, int[] resultValueLen)
    throws DecodeException;
	/**
	 * 根据模块中定义的自动计算规则来自动计算值对象或它的子字段的值。
	 * @param value 目标值对象。
	 * @return 值对象的长度，比特为单位。
	 * @throws EncodeException
	 */
	int calculate(IValue value) throws EncodeException;
	/**
	 * 取得值对象的长度，比特为单位。
	 * @param value 目标值对象。
	 * @return
	 * @throws EncodeException
	 */
	int getSize(IValue value) throws EncodeException;
}
