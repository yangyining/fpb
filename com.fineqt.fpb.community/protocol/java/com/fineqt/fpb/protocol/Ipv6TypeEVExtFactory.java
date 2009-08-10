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

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.user.PUserTypeEVExtFactoryBase;
import com.fineqt.fpb.lib.type.PContainerTypeExt;

public class Ipv6TypeEVExtFactory extends PUserTypeEVExtFactoryBase {
	public final static String HEADER_FIELD = "Ipv6Protocol.header";
	
	public static int IPV6_HEADER;
	public static int IPV6_HEADER_SOURCE_ADDRESS;
	public static int IPV6_HEADER_DESTINATION_ADDRESS;
	
	@Override
	public void postInitModule(PModuleExt module) throws InitMetaException {
		PContainerTypeExt ipv6HeaderType = (PContainerTypeExt)module.pPType(
				Names.IPV6_HEADER);
		assert ipv6HeaderType != null;
		//取得类型和字段的ID
		IPV6_HEADER = ipv6HeaderType.getID();
		IPV6_HEADER_SOURCE_ADDRESS = ipv6HeaderType.getFieldID(
				Names.IPV6_HEADER_SOURCE_ADDRESS);
		IPV6_HEADER_DESTINATION_ADDRESS = ipv6HeaderType.getFieldID(
				Names.IPV6_HEADER_DESTINATION_ADDRESS);
		
	}
	
	interface Names {
		String IPV6_HEADER = "Ipv6Header";
		String IPV6_HEADER_SOURCE_ADDRESS = "sourceAddress";
		String IPV6_HEADER_DESTINATION_ADDRESS = "destinationAddress";
	}
	
}
