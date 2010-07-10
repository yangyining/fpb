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
 * 用来生成数据包截取文件，或将数据包的数据写入数据包截取文件。
 * @author JiangMin
 *
 */
public interface IPcapPacketDumper extends IPcapSetting {
	/**
	 * 打开数据包截取文件。
	 * @param device 设备名称。
	 * @param fileName 数据包截取文件名称。
	 * @throws IOException
	 */
	void openDump(String device, String fileName)  throws IOException;
	/**
	 * 将数据包写入文件。
	 * @param packet 目标数据包对象。
	 * @throws IOException
	 */
	void dump(PcapPacket packet) throws IOException;
	/**
	 * 将缓存中的数据更新入文件。
	 * @throws IOException
	 */
	void flushDump() throws IOException;
	/**
	 * 关闭Pcap连接，释放资源。
	 * @throws IOException
	 */
	void close() throws IOException;	
}
