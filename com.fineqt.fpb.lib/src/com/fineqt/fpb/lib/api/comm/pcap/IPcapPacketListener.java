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


/**
 * 数据包监听器。可以登记到数据包截取器（PacketCapture）中，用来监听截取到的数据包。
 * @author JiangMin
 *
 */
public interface IPcapPacketListener {
	/**
	 * 书包到达事件处理方法。
	 * @param packet 到达的数据包。
	 */
	void packetArrived(PcapPacket packet);
}
