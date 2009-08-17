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

import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IReadWritableBitBuffer;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.user.PUserTypeEVExtFactoryBase;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.type.impl.PRecordTypeExtBase.PFpbRecordEVExt;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.FpbUtils;
import com.fineqt.fpb.lib.value.PValue;

public class Ipv4TypeEVExtFactory extends PUserTypeEVExtFactoryBase {
	public final static String HEADER_FIELD = "Ipv4Protocol.header";
	
	public static int IPV4_HEADER;
	public static int IPV4_HEADER_SOURCE_ADDRESS;
	public static int IPV4_HEADER_DESTINATION_ADDRESS;
	public static int IPV4_HEADER_PROTOCOL;
	
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
				PTypeConstraintStorage constraint, ByteOrder byteOrder, PFpbTypeEVAttrs priorityAttrs)
				throws EncodeException {
			if (cxt.withEncodeAction()) {
			    IReadWritableBitBuffer buffer = cxt.getBuffer();
				//Header开始位置
				int startOffset = buffer.position();
				int result = super.encode(cxt, value, parentLength, constraint, byteOrder, 
						priorityAttrs);
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
				return super.encode(cxt, value, parentLength, constraint, byteOrder, 
						priorityAttrs);
			}
		}
		
	}
	
	interface Names {
		String IPV4_HEADER = "Ipv4Header";
		String IPV4_HEADER_SOURCE_ADDRESS = "sourceAddress";
		String IPV4_HEADER_DESTINATION_ADDRESS = "destinationAddress";
		String IPV4_HEADER_PROTOCOL = "protocol";
	}
	
}
