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

import java.math.BigInteger;

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.BufferTimeoutException;
import com.fineqt.fpb.lib.api.util.buffer.IEnsurableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.codec.FlagFieldReader;
import com.fineqt.fpb.lib.codec.FlagFieldWriter;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PInteger;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.impl.PPrimitiveTypeExtBase;
import com.fineqt.fpb.lib.util.SerializeUtil;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

public class PIntegerTypeExtImpl extends PPrimitiveTypeExtBase {

	public PIntegerTypeExtImpl(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		assert pmodel instanceof PInteger;
	}
	
	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		PIntegerValue result = (PIntegerValue)super.createNormalValue(paras);
		if (paras.getInitValue() != null) {
			result.assignPValue(paras.getInitValue());
		}
		return result;
	}

	public static class PIntegerEVExt extends PFpbPrimitiveEVExt {
		
		public PIntegerEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		protected int doEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta,
				ByteOrder byteOrder) throws EncodeException {
			assert value instanceof PIntegerValue;
            PFpbTypeEVAttrs priorityAttrs  = 
                (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			PIntegerValue ivalue = (PIntegerValue)value;
			int resultLength = fpbTypeEVAttrs.getLength(priorityAttrs);
			//Encode
			if (cxt.withEncodeAction()) {
				FlagFieldWriter writer = cxt.getFlagFieldWriter();
				try {
					if (writer != null) {
						writer.writeInteger(ivalue.getLong(), resultLength);
					} else {
						if (byteOrder == null || byteOrder == ByteOrder.NONE) {
							throw new EncodeException(ownerTypeMeta, 
									MetaException.CODE.UNSETTED_BYTE_ORDER_PROPERTY_ERROR);
						}
						SerializeUtil.encodeInt4fpb(cxt.getBuffer(), ivalue.getBigInteger(), 
								resultLength, byteOrder);
					}
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
            PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
            int fixedLength = fpbTypeEVAttrs.getLength(priorityAttrs);
            paras.setHypFixedLength(fixedLength);  
            //增量模式处理
            if (cxt.isIncrement() && fixedLength > 0) {
                IEnsurableBitBuffer eBuffer = (IEnsurableBitBuffer)cxt.getOrgInput();
                try {
                    eBuffer.ensureSpace(input.arrayOffset() + input.position(), 
                            fixedLength);
                } catch (BufferTimeoutException e) {
                    throw new DecodeException(targetTypeMeta,  
                            MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, 
                            e);
                }
            }
        }

        @Override
		protected DecodeResult doDecode(DecodeContext cxt, IReadableBitBuffer input, 
		        PTypeElementMeta elementMeta, DecodeParameters paras, DecodeResult result)
		throws DecodeException {
			PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			//Decode
			BigInteger value;
			int length = paras.getHypFixedLength();
			//剩余长度不够并且可选
			if (elementMeta.isOptional() && input.remaining() < length) {
				return result;
			//有实际的数据
			} else {
				try {
					FlagFieldReader reader = cxt.getFlagFieldReader();
					if (reader != null) {
						value = BigInteger.valueOf(reader.readInteger(
								fpbTypeEVAttrs.isSigned(priorityAttrs), 
								length));
					} else {
						value = SerializeUtil.decodeInt4fpb(input, 
								fpbTypeEVAttrs.isSigned(priorityAttrs), 
								length, 
								paras.getByteOrder());
					}
				} catch (BitBufferException e) {
					throw new DecodeException(targetTypeMeta, 
							MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
				}
				PIntegerValue pvalue = (PIntegerValue)targetTypeMeta.createEmptyValue();
				pvalue.setBigInteger(value);
				result.setValueLength(length);
				result.setValue(pvalue);
				return result;
			}			
		}
		
		@Override
		protected int doDump(DumpContext cxt, PValue value,  String valueName,
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
