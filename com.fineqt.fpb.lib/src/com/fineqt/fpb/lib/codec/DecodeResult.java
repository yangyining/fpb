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
package com.fineqt.fpb.lib.codec;

import com.fineqt.fpb.lib.value.PValue;

public interface DecodeResult {
	PValue getValue();
	void setValue(PValue value);
	/**
	 * 当前计算所得长度。该长度并不一定是该节点的实际长度，而是当前处理子节点前的所有子节点的长度和。
	 * @return
	 */
	int getValueLength();
	void setValueLength(int length);
}
