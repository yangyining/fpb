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
 * verdict值对象类型。
 * 
 * @author JiangMin
 *
 */
public interface IVerdictValue extends IPrimitiveValue {
	/**
	 * Returns the integer value of verdicttype, the integer is one of the
	 * following constants: ERROR, FAIL, INCONC, NONE, PASS
	 * 返回值对象的值，包括ERROR、 FAIL、 INCONC、 NONE和PASS。
	 * @return
	 */
	int getVerdict();

	/**
	 * 设置值对象的值。
	 * @param value 被设置值，包括ERROR、 FAIL、 INCONC、 NONE和PASS。
	 */
	void setVerdict(int value);
	
	int NONE = 0;
	
	int PASS  = 1;
	
	int INCONC = 2;
	
	int FAIL = 3;
	
	int ERROR = 4;

}
