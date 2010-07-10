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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.builtin.PBitstringValue;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.codec.FlagFieldReader;
import com.fineqt.fpb.lib.codec.FlagFieldWriter;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PBitstring;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.impl.PStringTypeExtBase;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.SerializeUtil;
import com.fineqt.fpb.lib.util.TextBitset;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

public class PBitstringTypeExtImpl extends PStringTypeExtBase {

	public PBitstringTypeExtImpl(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		assert pmodel instanceof PBitstring;
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		PBitstringValue result = (PBitstringValue)super.createNormalValue(paras);
		if (paras.getInitValue() != null) {
			result.assignPValue(paras.getInitValue());
		}
		if (paras.getInitLength() >= 0) {
			result.setLength(paras.getInitLength());
		}
		return result;
	}

	public static class PBitstringEVExt extends PFpbPrimitiveEVExt {
		
		public PBitstringEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		public void init() throws InitMetaException {
			super.init();
		}
		
		@Override
		public int doEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta,
				ByteOrder byteOrder) throws EncodeException {
			assert value instanceof PBitstringValue;
            PFpbTypeEVAttrs priorityAttrs  = 
                (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			PBitstringValue bvalue = (PBitstringValue)value;
			int resultLength = bvalue.getLength();
			//根据PadType来取得长度
			int lengthFromPadType = getLengthFromPadType(parentLength, 
					fpbTypeEVAttrs.getPadType(priorityAttrs));
			if (lengthFromPadType >= 0) {
				resultLength = lengthFromPadType;
			}
			//字段值计算
			if (cxt.withCalculateAction()) {
				//set pad value
				if (lengthFromPadType >= 0) {
					bvalue.setLength(0);
					PBitstringValue padValue = 
						(PBitstringValue)fpbTypeEVAttrs.getPadValue(priorityAttrs);
					if (padValue == null || padValue.getLength() == 0) {
						bvalue.setLength(resultLength);
					} else {
						TextBitset bitset = padValue.getValue();
						TextBitset dstBitset = new NativeTextBitset();
						while(dstBitset.size() < resultLength) {
							dstBitset.append(bitset);
						}
						dstBitset.resize(resultLength);
						bvalue.setValue(dstBitset);
					}
				}
			}
			//Encode
			if (cxt.withEncodeAction()) {
				FlagFieldWriter writer = cxt.getFlagFieldWriter();
				try {
					if (writer != null) {
						writer.writeBits(bvalue.getValue());
					} else {
						SerializeUtil.encodeBitstring4fpb(cxt.getBuffer(), bvalue.getValue());
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
            DecodeResult parentResult = paras.getParentResult();
            PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
            PValue parentValue = parentResult == null?null:parentResult.getValue();
            try {
                int fixedLength = getFixedLength(cxt, input, parentValue, result, 
                        elementMeta.getConstraints(), 
                        FpbConstants.BIT_BITS, priorityAttrs);
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
			DecodeResult parentResult = paras.getParentResult();
			PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			int parentLength = parentResult == null?0:parentResult.getValueLength();
			//根据PadType来取得长度
			int lengthFromPadType = getLengthFromPadType(parentLength, 
					fpbTypeEVAttrs.getPadType(priorityAttrs));
			int length;
			//Pad
			if (lengthFromPadType >= 0) {
				length = lengthFromPadType;
			//Normal
			} else {
			    length = getPrimitiveHypLength(input, paras.getHypFixedLength());
			}
			//长度为0
			if (length == 0) {
	            result.setValue(targetTypeMeta.createEmptyValue());
				return result;
			//剩余长度不够并且可选
			} else if (elementMeta.isOptional() && input.remaining() < length) {
				return result;
			//有实际的数据
			} else {
				try {
					TextBitset bitset;
					FlagFieldReader reader = cxt.getFlagFieldReader();
					if (reader != null) {
						bitset = reader.readBits(length);
					} else {
						bitset = SerializeUtil.decodeBitstring4fpb(input, length);
					}
					PBitstringValue resultValue = 
						(PBitstringValue)targetTypeMeta.createEmptyValue();
					resultValue.setValue(bitset);
					result.setValueLength(length);
					result.setValue(resultValue);
					return result;
				} catch (BitBufferException e) {
					throw new DecodeException(targetTypeMeta, 
							MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
				}
			}
		}

		@Override
		protected int doDump(DumpContext cxt, PValue value, String valueName,
		        PTypeElementMeta elementMeta, int deep) 
		throws DumpException {
			assert value instanceof PBitstringValue;
			PBitstringValue bvalue = (PBitstringValue)value;
			int resultLength = bvalue.getLength();
			//dump
			dumpPrimitive(cxt, value, valueName, elementMeta.getConstraints(), deep, 
			        resultLength, (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs());
			return resultLength;
		}

		public String toString() {
			return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.toString();
		}
	}
	
}
