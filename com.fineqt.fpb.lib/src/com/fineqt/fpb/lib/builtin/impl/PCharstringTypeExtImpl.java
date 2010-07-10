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

import java.util.regex.Matcher;

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.BufferBoundaryException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PCharstring;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.impl.PStringTypeExtBase;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.SerializeUtil;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

public class PCharstringTypeExtImpl extends PStringTypeExtBase {

	public PCharstringTypeExtImpl(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		assert pmodel instanceof PCharstring;
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		PCharstringValue result = (PCharstringValue)super.createNormalValue(paras);
		if (paras.getInitValue() != null) {
			result.assignPValue(paras.getInitValue());
		}
		if (paras.getInitLength() >= 0) {
			result.setLength(paras.getInitLength());
		}
		return result;
	}

	public static class PCharstringEVExt extends PFpbPrimitiveEVExt {
		
		public PCharstringEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		public int doEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta,
				ByteOrder byteOrder) throws EncodeException {
			assert value instanceof PCharstringValue;
			PCharstringValue cvalue = (PCharstringValue)value;
			int resultLength = cvalue.getLength() * FpbConstants.CHAR_BITS;
			//Encode
			if (cxt.withEncodeAction()) {
				try {
					SerializeUtil.encodeCharstring4fpb(cxt.getBuffer(), cvalue.getValue());
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
                        FpbConstants.OCTET_BITS, priorityAttrs);
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
			//固定长度
			int length = paras.getHypFixedLength();
			//由Pattern来决定长度
			if (length < 0) {
				Matcher matcher = elementMeta.getConstraints().getThreadStringMatcher();
				if (matcher != null) {
					try {
                        matcher.reset(input.getAsCharSequence());
                    } catch (BufferBoundaryException e) {
                        throw new DecodeException(targetTypeMeta, 
                                MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
                    }
					if (matcher.lookingAt()) {
						length = (matcher.end() - matcher.start()) * FpbConstants.CHAR_BITS;
					} else {
						length = 0;
					}
				}
			}
			//Input剩余长度
			if (length < 0) {
				length = input.remaining();
			}
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
				assert length % FpbConstants.CHAR_BITS == 0;
				char data[] = new char[length / FpbConstants.CHAR_BITS];
				try {
					SerializeUtil.decodeCharstring4fpb(input, data);
				} catch (BitBufferException e) {
					throw new DecodeException(targetTypeMeta, 
							MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
				}
				PCharstringValue resultValue = (PCharstringValue)targetTypeMeta.createEmptyValue();
				resultValue.setValue(data);
				result.setValue(resultValue);
				result.setValueLength(length);
			}			
			return result;
		}		

		@Override
		protected int doDump(DumpContext cxt, PValue value, String valueName,
		        PTypeElementMeta elementMeta, int deep)
		throws DumpException {
			assert value instanceof PCharstringValue;
			PCharstringValue cvalue = (PCharstringValue)value;
			int resultLength = cvalue.getLength() * FpbConstants.CHAR_BITS;
			//dump
			dumpPrimitive(cxt, value, valueName, elementMeta.getConstraints(), deep, 
			        resultLength, (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs());
			return resultLength;
		}
		
	}
	
}
