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
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.dump.DumpLine;
import com.fineqt.fpb.lib.meta.MetaConstants;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.evattr.DisplayFormat;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.POctetstring;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.impl.PStringTypeExtBase;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.SerializeUtil;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

public class POctetstringTypeExtImpl extends PStringTypeExtBase {

	public POctetstringTypeExtImpl(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		assert pmodel instanceof POctetstring;
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		POctetstringValue result = (POctetstringValue)super.createNormalValue(paras);
		if (paras.getInitValue() != null) {
			result.assignPValue(paras.getInitValue());
		}
		if (paras.getInitLength() >= 0) {
			result.setLength(paras.getInitLength());
		}
		return result;
	}

	public static class POctetstringEVExt extends PFpbPrimitiveEVExt {
		
		public POctetstringEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		public int doEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta,
				ByteOrder byteOrder) throws EncodeException {
			assert value instanceof POctetstringValue;
            PFpbTypeEVAttrs priorityAttrs  = 
                (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			POctetstringValue ovalue = (POctetstringValue)value;
			int resultLength = ovalue.getLength() * FpbConstants.OCTET_BITS;
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
					ovalue.setLength(0);
					POctetstringValue padValue = 
						(POctetstringValue)fpbTypeEVAttrs.getPadValue(priorityAttrs);
					int octets = resultLength / MetaConstants.OCTET_BITS;
					if (padValue == null || padValue.getLength() == 0) {
						ovalue.setLength(octets);
					} else {
						byte[] buf = new byte[octets];
						int offset = 0;
						byte[] padBytes = padValue.getValue();
						while(offset < octets) {
							int leftBytes = octets - offset;
							int dstLen = padBytes.length <= leftBytes ? padBytes.length : leftBytes;
							System.arraycopy(padBytes, 0, buf, offset, dstLen);
							offset += dstLen; 
						}
						ovalue.setValue(buf);
					}
				}
			}
			//Encode
			if (cxt.withEncodeAction()) {
				try {
					SerializeUtil.encodeOctet4fpb(cxt.getBuffer(), ovalue.getValue());
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
			DecodeResult parentResult = paras.getParentResult();
			PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			int parentLength = parentResult == null?0:parentResult.getValueLength();
			//根据PadType来取得长度
			int lengthFromPadType = getLengthFromPadType(parentLength, 
					fpbTypeEVAttrs.getPadType(priorityAttrs));
			//预测长度
			int length;
			//Pad
			if (lengthFromPadType >= 0) {
				length = lengthFromPadType;
			} else {
			    length = getPrimitiveHypLength(input, paras.getHypFixedLength());
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
				assert length % FpbConstants.OCTET_BITS == 0;
				byte data[] = new byte[length / FpbConstants.OCTET_BITS];
				try {
					SerializeUtil.decodeOctet4fpb(input, data);
				} catch (BitBufferException e) {
					throw new DecodeException(targetTypeMeta, 
							MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
				}
				POctetstringValue resultValue = (POctetstringValue)targetTypeMeta.createEmptyValue();
				resultValue.setValue(data);
				result.setValueLength(length);
				result.setValue(resultValue);
				return result;
			}
		}
		
		@Override
		protected int doDump(DumpContext cxt, PValue value, String valueName,
		        PTypeElementMeta elementMeta, int deep)
		throws DumpException {
		    PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			assert value instanceof POctetstringValue;
			POctetstringValue ovalue = (POctetstringValue)value;
			int resultLength = ovalue.getLength() * FpbConstants.OCTET_BITS;
			DumpLine line = dumpPrimitive(cxt, value, valueName, elementMeta.getConstraints(),
			        deep, resultLength, priorityAttrs);
			DisplayFormat format = fpbTypeEVAttrs.getFormat(priorityAttrs);
			//设置format
			if (format != null) {
				switch(format) {
				case IPV4_ADDRESS:
				case IPV6_ADDRESS:
				case MAC_ADDRESS:
					line.setFormat(format);
					break;
				}
			}
			return resultLength;
		}
	}
	
}
