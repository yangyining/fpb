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

import java.nio.ByteBuffer;

import com.fineqt.fpb.lib.api.IContainerValue;
import com.fineqt.fpb.lib.api.IIntegerValue;
import com.fineqt.fpb.lib.api.IOctetstringValue;
import com.fineqt.fpb.lib.api.IRecordSetValue;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.EncodeException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.user.PUserTypeEVExtFactoryBase;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.type.impl.PRecordTypeExtBase.PFpbRecordEVExt;
import com.fineqt.fpb.lib.util.BitBuffer;
import com.fineqt.fpb.lib.util.BitBufferException;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.FpbUtils;
import com.fineqt.fpb.lib.value.PValue;

public class UdpTypeEVExtFactory extends PUserTypeEVExtFactoryBase {

	@Override
	protected PFpbTypeEVExt createTypeEVExt4FPB(PTypeExt typeMeta,
			PFpbTypeEV evModel) {
		String typeName = typeMeta.getName();
		if (Names.UDP_PROTOCOL.equals(typeName)) {
			return new UdpTcpProtocolTypeEVExt(evModel, true);
		}
		return super.createTypeEVExt4FPB(typeMeta, evModel);
	}
	
	public static class UdpTcpProtocolTypeEVExt extends PFpbRecordEVExt {
		private final static int UDP_CHECKSUM_FIELD_OFFSET = 6 * FpbConstants.OCTET_BITS;
		private final static int TCP_CHECKSUM_FIELD_OFFSET = 16 * FpbConstants.OCTET_BITS;
		private final static int V4_PSEUDO_HEADER_BYTES = 12;
		private final static int V6_PSEUDO_HEADER_BYTES = 40;
		private final static byte UDP_NEXT_HEADER = 17;
		private final static byte TCP_NEXT_HEADER = 6;
		
		private boolean isUdp;
		
		public UdpTcpProtocolTypeEVExt(PFpbTypeEV model, boolean isUdp) {
			super(model);
			this.isUdp = isUdp;
		}
		
		@Override
		public int encode(EncodeContext cxt, PValue value, int parentLength,
				PTypeConstraintStorage constraint, ByteOrder byteOrder, PFpbTypeEVAttrs priorityAttrs)
				throws EncodeException {
			if (cxt.withEncodeAction()) {
				BitBuffer buffer = cxt.getBuffer();
				//UDP开始位置
				int startOffset = buffer.position();
				int result = super.encode(cxt, value, parentLength, constraint, byteOrder, 
						priorityAttrs);
				//UDP结束位置
				int curPosition = cxt.getBuffer().position();
				try {
					assert startOffset % FpbConstants.OCTET_BITS == 0;
					assert curPosition % FpbConstants.OCTET_BITS == 0;
					IRecordSetValue ipHeader;
					byte[] pseudoBlock;
					int upperPrtlBytes = (curPosition - startOffset) / FpbConstants.OCTET_BITS;
					//取得IPV4 Header
					ipHeader = (IRecordSetValue)cxt.getFieldStackMap().peekField(
							Ipv4TypeEVExtFactory.HEADER_FIELD);
					if (ipHeader != null) {
						pseudoBlock = createUdpv4PseudoHeader(cxt, (IContainerValue)value, 
								ipHeader, upperPrtlBytes, startOffset);
					} else {
						//取得IPV6 Header
						ipHeader = (IRecordSetValue)cxt.getFieldStackMap().peekField(
								Ipv6TypeEVExtFactory.HEADER_FIELD);
						if (ipHeader != null) {
							pseudoBlock = createUdpv6PseudoHeader(cxt, (IContainerValue)value, 
									ipHeader, upperPrtlBytes, startOffset);
						} else {
							throw new EncodeException(targetTypeMeta, 
									MetaException.CODE.LOWER_LAYER_PROTOCOL_WRONG_ERROR, 
									"Ipv4Protocol or Ipv6Protocol");
						}
					}
					//计算Checksum
					byte[] checksum = FpbUtils.internetChecksum(pseudoBlock);
					if (isUdp) {
						buffer.position(startOffset + UDP_CHECKSUM_FIELD_OFFSET);
						//UDP的特殊处理0x0000->0xFFFF
						if (checksum[0] == 0 && checksum[1] == 0) {
							checksum[0] = (byte)0xFF;
							checksum[1] = (byte)0xFF;
						}
					} else {
						buffer.position(startOffset + TCP_CHECKSUM_FIELD_OFFSET);
					}
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
		
		private byte[] createUdpv4PseudoHeader(EncodeContext cxt, IContainerValue udpPrtl, 
				IRecordSetValue ipv4Header, int upperPrtlBytes, int startOffset) 
		throws BitBufferException {
			byte[] pseudoBlock = new byte[V4_PSEUDO_HEADER_BYTES + upperPrtlBytes];
			ByteBuffer pseudoBuffer = ByteBuffer.wrap(pseudoBlock);
			//填充虚头部数据
			IOctetstringValue oStr; 
			//ipv4 source address
			oStr = (IOctetstringValue)ipv4Header.getField(
					Ipv4TypeEVExtFactory.IPV4_HEADER_SOURCE_ADDRESS);
			pseudoBuffer.put(oStr.getValue());
			//ipv4 destination address
			oStr = (IOctetstringValue)ipv4Header.getField(
					Ipv4TypeEVExtFactory.IPV4_HEADER_DESTINATION_ADDRESS);
			pseudoBuffer.put(oStr.getValue());
			//zero
			pseudoBuffer.position(pseudoBuffer.position() + 1);
			//ipv4 protocol
			IIntegerValue iValue = (IIntegerValue)ipv4Header.getField(
					Ipv4TypeEVExtFactory.IPV4_HEADER_PROTOCOL);
			pseudoBuffer.put((byte)iValue.getInteger());
			//udp length
			pseudoBuffer.putShort((short)upperPrtlBytes);
			//取得UDP数据并填充
			BitBuffer encodeBuffer = cxt.getBuffer();
			encodeBuffer.position(startOffset);
			encodeBuffer.getByte(pseudoBlock, V4_PSEUDO_HEADER_BYTES,  upperPrtlBytes);
			return pseudoBlock;
		}

		private byte[] createUdpv6PseudoHeader(EncodeContext cxt, IContainerValue udpPrtl, 
				IRecordSetValue ipv6Header, int upperPrtlBytes, int startOffset) 
		throws BitBufferException {
			byte[] pseudoBlock = new byte[V6_PSEUDO_HEADER_BYTES + upperPrtlBytes];
			ByteBuffer pseudoBuffer = ByteBuffer.wrap(pseudoBlock);
			IOctetstringValue address;
			//Source Address
			address = (IOctetstringValue)ipv6Header.getField(
					Ipv6TypeEVExtFactory.IPV6_HEADER_SOURCE_ADDRESS);
			assert address != null;
			pseudoBuffer.put(address.getValue());
			//Destination Address
			address = (IOctetstringValue)ipv6Header.getField(
					Ipv6TypeEVExtFactory.IPV6_HEADER_DESTINATION_ADDRESS);
			assert address != null;
			pseudoBuffer.put(address.getValue());
			//Upper Layer Packet Length
			pseudoBuffer.putInt(upperPrtlBytes);
			//3octet zero
			pseudoBuffer.position(pseudoBuffer.position() + 3);
			//Next Header
			if (isUdp) {
				pseudoBuffer.put(UDP_NEXT_HEADER);
			} else {
				pseudoBuffer.put(TCP_NEXT_HEADER);
			}
			//取得UDP数据并填充
			BitBuffer encodeBuffer = cxt.getBuffer();
			encodeBuffer.position(startOffset);
			encodeBuffer.getByte(pseudoBlock, V6_PSEUDO_HEADER_BYTES,  upperPrtlBytes);
			return pseudoBlock;
		}
		
	}

	interface Names {
		String UDP_PROTOCOL = "UdpProtocol";
	}

}
