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

import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.modelview.FieldMV;
import com.fineqt.fpb.lib.value.PValue;

public interface PFieldExt extends PItemFieldExt, FieldMV {
	String getFieldName();
	String getFullFieldName();
	/**
	 * 字段的ID。
	 * 同一Container中的字段ID从0开始逐一增加。
	 * @return
	 */
	int getFieldID();
	/**
	 * 是否是Optional。
	 * 模型的optional属性的值。
	 * @return
	 */
	boolean isOptional();
	/**
	 * 初期生成时是否应该存在。
	 * 用于Union和optional是true的字段。
	 * @return
	 */
	boolean isDefaultPresent();
	
    int dump(DumpContext cxt, PValue value, int deep) throws DumpException;
	
}
