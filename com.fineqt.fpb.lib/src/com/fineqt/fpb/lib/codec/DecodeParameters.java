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

import com.fineqt.fpb.lib.meta.PPoolableObject;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;

public interface DecodeParameters extends PPoolableObject {
	/**
	 * 上层类的结果对象。
	 * @return
	 */
	DecodeResult getParentResult();
	void setParentResult(DecodeResult result);
	/**
	 * 字节顺序。动态传递的属性，可以是上层类型执行时所用的值。
	 * @return
	 */
	ByteOrder getByteOrder();
	void setByteOrder(ByteOrder byteOrder);
	/**
	 * 取得假定固定长度。默认值为-1,表示没有固定长度。
	 * @return
	 */
	int getHypFixedLength();
	void setHypFixedLength(int fixedLength);
//	/**
//	 * 所在Field或List项目的定义信息。
//	 * @return
//	 */
//	PItemFieldExt getItemFieldMeta();
//	void setItemFieldMeta(PItemFieldExt variant);
	
}
