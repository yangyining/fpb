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

import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.util.PValueDumper;
/**
 * 值对象打印者类。
 * 
 * @author JiangMin
 *
 */
public interface IValueDumper {
	/**
	 * 全局实例。
	 */
	IValueDumper INSTANCE = PValueDumper.PINSTANCE;
	/**
	 * 取得值对象的描述文本。
	 * @param value
	 * @return
	 * @throws DumpException
	 */
	String getDumpStr(IValue value) throws DumpException;
	/**
	 * 打印值对象文本描述到标准输出。
	 * @param value
	 */
	void dump(IValue value);
}
