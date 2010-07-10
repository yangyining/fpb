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
package com.fineqt.fpb.lib.dump;

import com.fineqt.fpb.lib.meta.evattr.DisplayFormat;
import com.fineqt.fpb.lib.util.BitRegion;
import com.fineqt.fpb.lib.value.PValue;

public interface DumpLine {
	enum Type{TOP_TYPE, FIELD};
	Type getType();
	boolean isPrimitive();
	boolean isContainer();
	boolean isList();
	PValue getValue();
	BitRegion getValueRegion();
	void setValueRegion(BitRegion region);
	String getName();
	int getDeep();
	void setDeep(int deep);
	/**
	 * 取得显示格式。
	 * @return
	 */
	DisplayFormat getFormat();
	/**
	 * 设置显示格式。
	 * @param format
	 */
	void setFormat(DisplayFormat format);
}
