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
package com.fineqt.fpb.lib.builtin.impl;

import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.builtin.PFloatValue;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFloat;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.impl.PPrimitiveTypeExtBase;
import com.fineqt.fpb.lib.util.SerializeUtil;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

public class PFloatTypeExtImpl extends PPrimitiveTypeExtBase {

	public PFloatTypeExtImpl(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		assert pmodel instanceof PFloat;
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		PFloatValue result = (PFloatValue)super.createNormalValue(paras);
		if (paras.getInitValue() != null) {
			result.assignPValue(paras.getInitValue());
		}
		return result;
	}

	public static class PFloatEVExt extends PFpbPrimitiveEVExt {
		
		public PFloatEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		public int doEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta,
				ByteOrder byteOrder) throws EncodeException {
			assert value instanceof PFloatValue;
            PFpbTypeEVAttrs priorityAttrs  = 
                (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			PFloatValue fvalue = (PFloatValue)value;
			int resultLength = fpbTypeEVAttrs.getLength(priorityAttrs);
			//Encode
			if (cxt.withEncodeAction()) {
				try {
					SerializeUtil.encodeFloat4fpb(cxt.getBuffer(), fvalue.getBigDecimal(), 
							resultLength, fpbTypeEVAttrs.isSigned(priorityAttrs));
				} catch (BitBufferException e) {
					throw new EncodeException(targetTypeMeta, 
							MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
				}
			}
			return resultLength;
		}
		
		@Override
		protected int doDump(DumpContext cxt, PValue value, String valueName,
		        PTypeElementMeta elementMeta, int deep) 
		throws DumpException {
		    PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			int resultLength = fpbTypeEVAttrs.getLength(priorityAttrs);
			//dump
			dumpPrimitive(cxt, value, valueName, elementMeta.getConstraints(), deep, 
			        resultLength, priorityAttrs);
			return resultLength;
		}
		
	}
	
}
