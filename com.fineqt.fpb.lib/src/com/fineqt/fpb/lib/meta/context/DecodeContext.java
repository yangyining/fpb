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
package com.fineqt.fpb.lib.meta.context;

import com.fineqt.fpb.lib.api.util.buffer.IWritableBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.codec.FlagFieldReader;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.type.PTypeExt;

public interface DecodeContext extends CommonContext {
	void setOrgInput(IWritableBitBuffer buf);
	IWritableBitBuffer getOrgInput();
	/**
	 * 设置假定目标解码类型。
	 * @param hypeType
	 */
	void setHypType(PTypeExt hypeType);
	/**
	 * 取得假定目标解码类型。
	 * @return
	 */
	PTypeExt getHypType();
	FlagFieldReader getFlagFieldReader();
	void setFlagFieldReader(FlagFieldReader reader);
	/**
	 * 创建解码参数对象
	 * @param optional
	 * @param parentResult
	 * @param variant
	 * @param constraint
	 * @param byteOrder
	 * @param priorityAttrs
	 * @return
	 */
//	DecodeParameters createDecodeParas(boolean optional, 
//			DecodeResult parentResult, PTypeEVExt variant, PTypeConstraintStorage constraint,
//			ByteOrder byteOrder, PTypeEVAttrs priorityAttrs);
      DecodeParameters createDecodeParas(DecodeResult parentResult, 
          ByteOrder byteOrder);
	/**
	 * 回收解码参数对象
	 * @param paras
	 */
	void returnDecodeParas(DecodeParameters paras);
	/**
	 * 是否是增量解码。
	 * 如果是增量解码的话，getOrgInput()方法将返回类型为IEnsurableBitBuffer的缓存。
	 * @return
	 */
	boolean isIncrement();
//  void setRepairDecodeError(boolean repair);
//  boolean isRepairDecodeError();
//  void setHasDecodeError(boolean hasError);
//  boolean isHasDecodeError();
}
