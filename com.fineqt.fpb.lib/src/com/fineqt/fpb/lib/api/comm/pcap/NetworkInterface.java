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

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 网络接口类。
 */
public class NetworkInterface {
	/**
	 * 网络接口名称。
	 */
	public String name;
	/** 网络接口描述 (e.g., "3Com ..."). 可能为null.*/
	public String description;
	/** 是否是loopback接口 */
	public boolean loopback;
	/** 该网络接口上被设置的网络地址。可能为null，如果它是非IP网络，比如NetBios */
	public NetworkInterfaceAddress[] addresses;
	
	public NetworkInterface(String name, String description, boolean loopback, NetworkInterfaceAddress[] addresses) {
		this.name = name;
		this.description = description;
		this.loopback = loopback;
		this.addresses = addresses;
	}

	public String toString() {
		return new ToStringBuilder(this).
				append("name", name).
				append("description", description).
				append("loopback", loopback).
				append("addresses", addresses).
				toString();
	}
	
}
