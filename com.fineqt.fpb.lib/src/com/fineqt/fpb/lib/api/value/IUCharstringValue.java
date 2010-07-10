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
 * universal charstring类型值对象类。
 * TODO 尚未实现
 * 
 * @author JiangMin
 *
 */
public interface IUCharstringValue extends IStringValue {
	char[] getValue();
	void setValue(char[] chars);
	/**
	 * Returns the UniversalChar value of the TTCN-3 universal
	 * charstring at position. position 0 denotes the first
	 * UniversalChar of the TTCN-3 universal charstring.
	 * Valid values for position are 0 to length - 1.
	 * @param position
	 * @return
	 */
	char getChar (int position);
	/**
	 * Set the UniversalChar at position to value. Valid values
	 * for position are 0 to length - 1.
	 * @param position
	 * @param value
	 */
	void setChar (int position, char value);

}
