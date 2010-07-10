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

import java.math.BigDecimal;

/**
 * float类型值对象类。能够保存任意精度的浮点数，内部以BigDecimal形式来保存值。
 * 
 * @author JiangMin
 *
 */
public interface IFloatValue extends IPrimitiveValue {
	/**
	 * 以double形式设置值。
	 * @param value
	 */
	void setDouble(double value);
	/**
	 * 取得值对象double形式的值。
	 * @return
	 */
	double getDouble();
	/**
	 * 以BigDecimal形式设置值。
	 * @param bigValue
	 */
	void setBigDecimal(BigDecimal bigValue);
	/**
	 * 取得值对象BigDecimal形式的值。
	 * @return
	 */
	BigDecimal getBigDecimal();
	/**
	 * 取得值对象float形式的值。
	 * @return
	 */
	float getFloat();
	/**
	 * 以float形式设置值。
	 * @param value
	 */
	void  setFloat(float value);
}
