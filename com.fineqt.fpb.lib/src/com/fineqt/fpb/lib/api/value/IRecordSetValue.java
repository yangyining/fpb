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
/**
 * record和set类型值对象类。
 * 
 * @author JiangMin
 *
 */
public interface IRecordSetValue extends IContainerValue {
	/**
	 * 取得包含字段的个数。
	 * @return
	 */
	int getFieldSize();
	
	/**
	 * 将指定序号的字段设置为omit。
	 * @param fieldIndex 字段序号（0开始）
	 */
    void setFieldOmitted(int fieldIndex);
	
    /**
     * 取得所有字段的名称。
     */
    String[] getFieldNames();
    /**
	 * 将指定序号的字段设置为omit。
     * @param fieldName
     */
    void setFieldOmitted(String fieldName);
}
