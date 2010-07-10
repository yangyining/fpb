package com.fineqt.fpb.lib.api.comm.pcap;

import java.net.SocketException;

import com.fineqt.fpb.lib.comm.pcap.PcapSocketFactoryImpl;

public interface IPcapSocketFactory {
	/**
	 * 全局实例
	 */
	IPcapSocketFactory INSTANCE = new PcapSocketFactoryImpl();
	/**
	 * 取得所在机器的所有网络接口。
	 * @return
	 * @throws SocketException
	 */
	NetworkInterface[] getDeviceList() throws SocketException;
	/**
	 * 创建数据包截取器对象。
	 * @return
	 */
	IPcapPacketCapture createPacketCapture();
	/**
	 * 创建数据包文件操作对象。
	 * @return
	 */
	IPcapPacketDumper createPacketDumper();
	/**
	 * 创建Pcap套接字对象。
	 * @return
	 */
	IPcapSocket createPcapSocket();
	
}
