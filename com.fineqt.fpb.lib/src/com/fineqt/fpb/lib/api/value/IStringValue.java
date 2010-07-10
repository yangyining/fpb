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
 * 各种串类型(bitstring, octetstring, hexstring, charstring, ucharstring)的基类。
 * @author JiangMin
 *
 */
public interface IStringValue extends IPrimitiveValue {
	/**
	 * 取得该串值TTCN规格的描述字符串。
	 * @return
	 */
	String getString();
	/**
	 * 根据TTCN规格描述字符串来设置该对象的值。
	 * @param literal 设置文本，以下是一些例子。
	 * 		bitstring	'101'B
	 * 		hexstring	'FA0'H
	 * 		octetstring	'FFAA00'O
	 * 		charstring	"ab-f"
	 */
	void setString(String literal);
	/**
	 * 取得该串值的长度。
	 * 长度根据char,octet,hex,bit等元素类型的不同，分别代表以1Octet, 1Octet, 4Bit, 1Bit为单位的长度。
	 * @return
	 */
	int getLength();
	/**
	 * 设置该串值的长度。
	 * 如果长度与现在的长度不同，将会由于长度的改变使内部的数据内容被删除或增加。
	 * @param len 设置长度。
	 */
	void setLength(int len);
}
