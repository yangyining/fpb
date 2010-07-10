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

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 数据包对象，用来存放通过pcap库取得的数据包。
 * 
 * @author JiangMin
 *
 */
public class PcapPacket {
	/** 截取的时间 (秒) */
	public long sec;

	/** 截取的时间 (微秒) */
	public long usec;

	/** 数据包内截取到的数据长度 */
	public int caplen;

	/** 数据包的实际长度 */
	public int len;

	/** 截取到的数据包内数据 */
	public byte[] data;
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("sec", new Date(sec*1000))
			.append("usec", usec)
			.append("caplen", caplen)
			.append("len", len)
			.toString();
	}
}
