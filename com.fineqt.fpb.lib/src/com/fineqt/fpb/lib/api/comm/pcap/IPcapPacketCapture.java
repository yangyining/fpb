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

import java.io.IOException;

/**
 * 数据包截取器接口。封装了PCAP的数据包截取功能。
 * 
 * @author JiangMin
 *
 */
public interface IPcapPacketCapture extends IPcapSetting {
	/**
	 * 取得被截取的数据包。在offline（文件读取）状态下，如果返回数据包对象的caplen属性为0，
	 * 则该数据包代表了EOF。
	 * @return 截取的数据包
	 * @throws IOException
	 */
	PcapPacket readPacket() throws IOException;
	/**
	 * 打开离线数据包文件，该截取器将以offline(离线)模式工作。
	 * @param fileName 数据包文件名，需要是pcap格式的文件。
	 * @throws IOException
	 */
	void openOffline(String fileName) throws IOException; 
	/**
	 * 截取指定数字的数据包。截取到的数据包将被传递给已登记的PacketListener对象。
	 * @param count 目标数据包个数、<0代表无限循环。
	 * @throws IOException
	 */
	void capture(int count) throws IOException;
	/**
	 * 加入数据包监听对象。
	 * @param l 被加入数据包监听对象。截取到的数据包将被传递给该对象。
	 */
	void addPacketListener(IPcapPacketListener l);
	/**
	 * 删除数据包监听对象。
	 * @param l 被删除数据包监听对象。
	 */
	void removePacketListener(IPcapPacketListener l);
	/**
	 * 结束数据包的截取，将中断正在执行的capture方法。
	 */
	void endCapture();
	/**
	 * 打开Pcap连接。
	 * @throws IOException
	 */
	void open() throws IOException;
	/**
	 * 关闭Pcap连接，释放资源。
	 * @throws IOException
	 */
	void close() throws IOException;
}
