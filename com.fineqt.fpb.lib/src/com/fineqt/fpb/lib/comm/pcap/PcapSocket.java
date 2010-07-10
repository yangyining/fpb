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
package com.fineqt.fpb.lib.comm.pcap;

import com.fineqt.fpb.lib.api.comm.pcap.IPcapPacketCapture;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapPacketDumper;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocket;
/**
 * Pcap库的套接字，是pcap库api的封装接口类。可用于数据包的发送和接受，以及数据包的截取和数据包文件的操作。
 * 
 * @author JiangMin
 *
 */
public interface PcapSocket extends IPcapSocket, IPcapPacketCapture, IPcapPacketDumper, PacketHandler {
	/**
	 * 默认数据包截取数据长度
	 */
	int DEFAULT_SNAPLEN = 1600;
	/**
	 * 默认数据包截取间隔（毫秒）
	 */
	int DEFAULT_PCAP_TIMEOUT = 5;
	/**
	 * 默认promiscuous模式。
	 */
	boolean DEFAULT_PROMISC = false;
}
