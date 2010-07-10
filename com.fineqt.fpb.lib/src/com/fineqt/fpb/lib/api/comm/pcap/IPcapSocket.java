package com.fineqt.fpb.lib.api.comm.pcap;

import java.io.IOException;

import com.fineqt.fpb.lib.api.comm.IByteSocket;
/**
 * Pcap套接字接口。使用Pcap库来进行链路层的数据通信。
 * 
 * @author JiangMin
 *
 */
public interface IPcapSocket extends IByteSocket, IPcapSetting  {
	/**
	 * 取得被截取的数据包。
	 * @return 截取的数据包
	 * @throws IOException
	 */
	PcapPacket readPacket() throws IOException;

}
