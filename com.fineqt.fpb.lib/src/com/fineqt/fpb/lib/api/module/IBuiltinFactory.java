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
package com.fineqt.fpb.lib.api.module;

import com.fineqt.fpb.lib.api.value.IBitstringValue;
import com.fineqt.fpb.lib.api.value.IBooleanValue;
import com.fineqt.fpb.lib.api.value.ICharstringValue;
import com.fineqt.fpb.lib.api.value.IFloatValue;
import com.fineqt.fpb.lib.api.value.IHexstringValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IObjidValue;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.api.value.IUCharstringValue;
import com.fineqt.fpb.lib.api.value.IVerdictValue;

/**
 * builtin模块的值对象工厂接口。
 * 
 * @author JiangMin
 *
 */
public interface IBuiltinFactory  {

	/**
	 * 创建integer类型的值对象。
	 * @return
	 */
	IIntegerValue createInteger();
	/**
	 * 创建float类型的值对象。
	 * @return
	 */
	IFloatValue createFloat();
	/**
	 * 创建objid类型的值对象。
	 * @return
	 */
	IObjidValue createObjid();
	/**
	 * 创建boolean类型的值对象。
	 * @return
	 */
	IBooleanValue createBoolean();
	/**
	 * 创建charstring类型的值对象。
	 * @return
	 */
	ICharstringValue createCharstring();
	/**
	 * 创建universal charstring类型的值对象。
	 * @return
	 */
	IUCharstringValue createUCharstring();
	/**
	 * 创建bitstring类型的值对象。
	 * @return
	 */
	IBitstringValue createBitstring();
	/**
	 * 创建hexstring类型的值对象。
	 * @return
	 */
	IHexstringValue createHexstring();
	/**
	 * 创建octetstring类型的值对象。
	 * @return
	 */
	IOctetstringValue createOctetstring();
	/**
	 * 创建verdict类型的值对象。
	 * @return
	 */
	IVerdictValue createVerdict();

}
