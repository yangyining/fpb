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
/**
 * 表示在字节数据中比特区域。
 * 
 * @author JiangMin
 */
public interface BitRegion extends Cloneable {
	/**
	 * 取得比特区域的开始偏移量。0开始。
	 * @return
	 */
	int getOffset();
	/**
	 * 取得比特区域的长度。
	 * @return
	 */
	int getLen();
	/**
	 * 设置比特区域的开始偏移量。0开始。
	 * @param offset
	 */
	void setOffset(int offset);
	/**
	 * 设置比特区域的长度。
	 * @param len
	 */
	void setLen(int len);
	/**
	 * 取得比特区域的字节偏移量。
	 * 如果比特偏移量不是字节的倍数，则最开始的比特所在的字节位置被返回。
	 * @return
	 */
	int getByteOffset();
	/**
	 * 取得最先一个字节的头部不属于目标比特范围的比特数。
	 * @return
	 */
	int getLeftMaskBits();
	/**
	 * 取得最后一个字节的尾部不属于目标比特范围的比特数。
	 * @return
	 */
	int getRightMaskBits();
	/**
	 * 从第一个比特所在的字节直到最后一个比特所在的字节范围内所存在的字节数。
	 * @return
	 */
	int getByteLen();

	/**
	 * 复制该对象
	 * @return
	 */
	Object clone();
	
}