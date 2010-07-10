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

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.builtin.PHexstringValue;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PHexstring;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.impl.PStringTypeExtBase;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.SerializeUtil;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

public class PHexstringTypeExtImpl extends PStringTypeExtBase {

	public PHexstringTypeExtImpl(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		assert pmodel instanceof PHexstring;
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		PHexstringValue result = (PHexstringValue)super.createNormalValue(paras);
		if (paras.getInitValue() != null) {
			result.assignPValue(paras.getInitValue());
		}
		if (paras.getInitLength() >= 0) {
			result.setLength(paras.getInitLength());
		}
		return result;
	}

	public static class PHexstringEVExt extends PFpbPrimitiveEVExt {
		
		public PHexstringEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		public int doEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta,
				ByteOrder byteOrder) throws EncodeException {
			assert value instanceof PHexstringValue;
			PHexstringValue hvalue = (PHexstringValue)value;
			int resultLength = hvalue.getLength() * FpbConstants.HEX_BITS;
			//Encode
			if (cxt.withEncodeAction()) {
				try {
					SerializeUtil.encodeHexstring4fpb(cxt.getBuffer(), hvalue.getValue(), resultLength);
				} catch (BitBufferException e) {
					throw new EncodeException(targetTypeMeta, 
							MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
				}
			}
			return resultLength;
		}
		
        @Override
        protected void assumeFixedDecodeLength(DecodeContext cxt,
                IReadableBitBuffer input, PTypeElementMeta elementMeta, 
                DecodeParameters paras, DecodeResult result)
                throws DecodeException {
            DecodeResult parentResult = paras.getParentResult();
            PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
            PValue parentValue = parentResult == null?null:parentResult.getValue();
            try {
                int fixedLength = getFixedLength(cxt, input, parentValue, result, 
                        elementMeta.getConstraints(), 
                        FpbConstants.HEX_BITS, priorityAttrs);
                paras.setHypFixedLength(fixedLength);
            } catch (BitBufferException e) {
                throw new DecodeException(targetTypeMeta, 
                        MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
            }
        }
		
		@Override
		protected DecodeResult doDecode(DecodeContext cxt, IReadableBitBuffer input, 
		        PTypeElementMeta elementMeta, DecodeParameters paras, DecodeResult result)
		throws DecodeException {
			//预测长度
			int length = getPrimitiveHypLength(input, paras.getHypFixedLength());
			assert length >= 0;
			//长度为0
			if (length == 0) {
				result.setValue(targetTypeMeta.createEmptyValue());
				return result;
			//剩余长度不够并且可选
			} else if (elementMeta.isOptional() && input.remaining() < length) {
				return result;
			//有实际的数据
			} else {
				assert length % FpbConstants.HEX_BITS == 0;
                byte data[] = new byte[(length + FpbConstants.HEX_BITS)
                        / FpbConstants.OCTET_BITS];
                try {
                    SerializeUtil.decodeHexstring4fpb(input, data, length);
                } catch (BitBufferException e) {
                    throw new DecodeException(targetTypeMeta,
                            MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
                }
                PHexstringValue resultValue = (PHexstringValue) targetTypeMeta
                        .createEmptyValue();
                resultValue.setValue(data, length / FpbConstants.HEX_BITS);
                result.setValueLength(length);
                result.setValue(resultValue);
                return result;
			}
		}
		
		@Override
		protected int doDump(DumpContext cxt, PValue value, String valueName,
		        PTypeElementMeta elementMeta, int deep) 
		throws DumpException {
			assert value instanceof PHexstringValue;
			PHexstringValue hvalue = (PHexstringValue)value;
			int resultLength = hvalue.getLength() * FpbConstants.HEX_BITS;
			//dump
			dumpPrimitive(cxt, value, valueName, elementMeta.getConstraints(), deep, 
			        resultLength, (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs());
			return resultLength;
		}
		
	}
	
}
