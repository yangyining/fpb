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
package com.fineqt.fpb.protocol;

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IReadWritableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.api.value.IBooleanValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.user.PUserTypeEVExtFactoryBase;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.type.impl.PRecordTypeExtBase.PFpbRecordEVExt;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.FpbUtils;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

public class Ipv4TypeEVExtFactory extends PUserTypeEVExtFactoryBase {
    //上下文堆栈字段的定义
	public final static String HEADER_FIELD = "Ipv4Protocol.header";
	private final static String PROTOCOL_FIELD = "protocol";
	
	public static int IPV4_HEADER;
	public static int IPV4_HEADER_SOURCE_ADDRESS;
	public static int IPV4_HEADER_DESTINATION_ADDRESS;
	public static int IPV4_HEADER_PROTOCOL;
	public static int IPV4_HEADER_MORE_FRAGS;
	public static int IPV4_HEADER_FRAGMENT_OFFSET;
	
	@Override
	public void postInitModule(PModuleExt module) throws InitMetaException {
		PContainerTypeExt ipv4HeaderType = (PContainerTypeExt)module.pPType(
				Names.IPV4_HEADER);
		assert ipv4HeaderType != null;
		//取得类型和字段的ID
		IPV4_HEADER = ipv4HeaderType.getID();
		IPV4_HEADER_SOURCE_ADDRESS = ipv4HeaderType.getFieldID(
				Names.IPV4_HEADER_SOURCE_ADDRESS);
		IPV4_HEADER_DESTINATION_ADDRESS = ipv4HeaderType.getFieldID(
				Names.IPV4_HEADER_DESTINATION_ADDRESS);
		IPV4_HEADER_PROTOCOL = ipv4HeaderType.getFieldID(
				Names.IPV4_HEADER_PROTOCOL);
        IPV4_HEADER_MORE_FRAGS = ipv4HeaderType.getFieldID(
                Names.IPV4_HEADER_MORE_FRAGS);
        IPV4_HEADER_FRAGMENT_OFFSET = ipv4HeaderType.getFieldID(
                Names.IPV4_HEADER_FRAGMENT_OFFSET);
	}
	
	@Override
	protected PFpbTypeEVExt createTypeEVExt4FPB(PTypeExt typeMeta,
			PFpbTypeEV evModel) {
		String typeName = typeMeta.getName();
		if (typeName.equals(Names.IPV4_HEADER)) {
			return new HeaderTypeEVExt(evModel);
		}
		return super.createTypeEVExt4FPB(typeMeta, evModel);
	}
	
	private static class HeaderTypeEVExt extends PFpbRecordEVExt {
		final static int CHECKSUM_FIELD_OFFSET = 10 * FpbConstants.OCTET_BITS;
		
		public HeaderTypeEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		public int encode(EncodeContext cxt, PValue value, int parentLength,
		        PTypeElementMeta elementMeta, ByteOrder byteOrder)
				throws EncodeException {
			if (cxt.withEncodeAction()) {
			    IReadWritableBitBuffer buffer = cxt.getBuffer();
				//Header开始位置
				int startOffset = buffer.position();
				int result = super.encode(cxt, value, parentLength, elementMeta, byteOrder);
				//Header结束位置
				int curPosition = cxt.getBuffer().position();
				try {
					//取得Header数据
					assert startOffset % FpbConstants.OCTET_BITS == 0;
					assert curPosition % FpbConstants.OCTET_BITS == 0;
					int byteLen = (curPosition - startOffset) / FpbConstants.OCTET_BITS;
					byte[] headerData = new byte[byteLen];
					buffer.position(startOffset);
					buffer.getByte(headerData);
					//计算Checksum
					byte[] checksum = FpbUtils.internetChecksum(headerData);
					buffer.position(startOffset + CHECKSUM_FIELD_OFFSET);
					buffer.putByte(checksum);
				} catch (BitBufferException e) {
					throw new EncodeException(targetTypeMeta, 
							MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
				}
				//恢复Position
				buffer.position(curPosition);
				return result;
			} else {
				return super.encode(cxt, value, parentLength, elementMeta, byteOrder);
			}
		}

        @Override
        protected DecodeResult doDecode(DecodeContext cxt, IReadableBitBuffer orgInput,
                PTypeElementMeta elementMeta, DecodeParameters paras, DecodeResult selfResult) 
        throws DecodeException {
            DecodeResult rst = super.doDecode(cxt, orgInput, elementMeta, paras, selfResult);
            IRecordSetValue header = (IRecordSetValue)rst.getValue();
            if (header != null) {
                //判断是否为断片
                boolean isFragment = false;
                IBooleanValue moreFrags = (IBooleanValue)header.getField(
                        IPV4_HEADER_MORE_FRAGS);
                if (moreFrags != null && moreFrags.getBoolean()) {
                    isFragment = true;
                } else {
                    IIntegerValue fragOffset = (IIntegerValue)header.getField(
                            IPV4_HEADER_FRAGMENT_OFFSET);
                    if (fragOffset != null && fragOffset.getInteger() > 0) {
                        isFragment = true;
                    }
                }
                //设置protocol字段（非断片情况下）
                if (!isFragment) {
                    IValue protocol = header.getField(IPV4_HEADER_PROTOCOL);
                    if (protocol != null) {
                        cxt.getFieldStackMap().setTopField(PROTOCOL_FIELD, protocol);
                    }
                }
            }
            return rst;
        }
		
	}
	
	interface Names {
		String IPV4_HEADER = "Ipv4Header";
		String IPV4_HEADER_SOURCE_ADDRESS = "sourceAddress";
		String IPV4_HEADER_DESTINATION_ADDRESS = "destinationAddress";
		String IPV4_HEADER_PROTOCOL = "protocol";
		String IPV4_HEADER_MORE_FRAGS = "moreFrags";
		String IPV4_HEADER_FRAGMENT_OFFSET = "fragmentOffset";
	}
	
}
