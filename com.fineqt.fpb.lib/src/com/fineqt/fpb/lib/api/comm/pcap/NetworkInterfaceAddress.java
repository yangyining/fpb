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
package com.fineqt.fpb.lib.api.comm.pcap;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 网络接口上的网络地址。
 */
public class NetworkInterfaceAddress{
	/** 地址 */
	public InetAddress address;
	/** 子网掩码 */
	public InetAddress subnet;
	/** 广播地址。 可能为空. */
	public InetAddress broadcast;
	/** 目标地址（仅对P2P连接有效）. 可能为null. */
	public InetAddress destination;
	
	public NetworkInterfaceAddress(byte[] address,byte[] subnet,byte[] broadcast,byte[] destination){
		try{
			if(address!=null)
				this.address=InetAddress.getByAddress(address);
			if(subnet!=null)
				this.subnet=InetAddress.getByAddress(subnet);
			if(broadcast!=null)
				this.broadcast=InetAddress.getByAddress(broadcast);
			if(destination!=null)
				this.destination=InetAddress.getByAddress(destination);
		}catch(UnknownHostException e){
		}
	}
	public String toString() {
		return new ToStringBuilder(this).
				append("address", address).
				append("subnet", subnet).
				append("broadcast", broadcast).
				append("destination", destination).
				toString();
	}
	
}