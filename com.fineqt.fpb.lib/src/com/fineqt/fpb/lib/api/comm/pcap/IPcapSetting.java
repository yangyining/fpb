package com.fineqt.fpb.lib.api.comm.pcap;

import java.net.SocketException;
/**
 * PCAP库设置功能接口。
 * 
 * @author JiangMin
 *
 */
public interface IPcapSetting {
	/**
	 * 设置PCAP参数。
	 * @param device 设备名
	 * @param snaplen 从实际的数据包截取的有效数据长度
	 * @param promisc 是否将网卡设定成promiscuous模式。如果是promiscuous模式，网卡将读入网上流过的
	 * 所有的数据包，包括不是发给自己的数据包。
	 * @param pcapTimeout 是数据包截取间隔。
	 */
	void setPcapSetting(String device, int snaplen, boolean promisc, int pcapTimeout);
	/**
	 * 设置数据包过滤条件。需在open函数执行好之后执行。
	 * @param condition 过滤条件。condition的设定方法可以参照WinPcap用户手册的
	 * “Filtering expression syntax”章节
	 * @param optimize 是否对过滤条件优化。
	 * @throws SocketException
	 */
	void setFilter(String condition, boolean optimize) throws SocketException;
	/**
	 * 取得目标操作设备（网络适配器）的名称。
	 * @return
	 */
	String getDevice();
	/**
	 * 设置目标操作设备（网络适配器）的名称。
	 * @param device
	 */
	void setDevice(String device);
}
