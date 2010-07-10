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
package com.fineqt.fpb.lib.type;

import com.fineqt.fpb.lib.value.PValue;

public interface CreatePTypeValueParamaters {
	/**
	 * 取得初始长度，-1则代表无效。
	 * @return
	 */
	int getInitLength();
	/**
	 * 取得初始值，null则代表无效。
	 * @return
	 */
	PValue getInitValue();
}
