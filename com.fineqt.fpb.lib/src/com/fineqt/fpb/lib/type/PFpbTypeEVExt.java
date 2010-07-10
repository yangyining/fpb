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

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

public interface PFpbTypeEVExt extends PTypeEVExt {
	int encode(EncodeContext cxt, PValue value, int parentLength, 
	        PTypeElementMeta elementMeta, ByteOrder byteOrder)
	throws EncodeException;
	
	DecodeResult decode(DecodeContext cxt, IReadableBitBuffer input, 
	        PTypeElementMeta elementMeta, DecodeParameters paras) 
	throws DecodeException;
	
	int dump(DumpContext cxt, PValue value, String valueName, PTypeElementMeta elementMeta,  
	        int deep) 
	throws DumpException;
	
//	/**
//	 * 是否由字段拥有（在字段中定义）。
//	 * 如果返回值为false，则为由类型拥有。
//	 * @return
//	 */
//	boolean isOwnerByField();
	PFpbTypeEVAttrs getFpbTypeEVAttrs();
	Class<? extends DecodeResult> getDecodeResultClass();
}
