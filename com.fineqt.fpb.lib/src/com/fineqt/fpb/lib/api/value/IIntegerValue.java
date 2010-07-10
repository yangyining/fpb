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
package com.fineqt.fpb.lib.api.value;

import java.math.BigInteger;

/**
 * integer类型的值对象类。内部以BigInteger形式来保存值,对应任意长度的整数值。
 * 
 * @author JiangMin
 *
 */
public interface IIntegerValue extends IPrimitiveValue {
	/**
	 * 以long形式设置值。
	 * @param value
	 */
    void setLong(long value);
    /**
     * 取得long形式的值。
     * @return
     */
    long getLong();
    /**
     * 以BigInteger形式设置值。
     * @param bigValue
     */
    void setBigInteger(BigInteger bigValue);
    /**
     * 取得BigInteger形式的值。
     * @return
     */
    BigInteger getBigInteger();
	/**
	 * 以int形式设置值。
	 * @param value
	 */
    void setInteger(int value);
    /**
     * 取得int形式的值。
     * @return
     */
    int  getInteger();
}
