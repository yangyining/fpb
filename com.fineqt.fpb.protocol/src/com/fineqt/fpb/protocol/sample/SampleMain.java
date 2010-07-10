/*************************************************************************
Protocol Meter, copyright (C) 2007-2008 fineqt.com

Protocol Meter is free software; you can redistribute it and/or modify it 
under the terms of version 2.1 of the GNU Lesser General Public License as 
published by the Free Software Foundation.

Protocol Meter is distributed in the hope that it will be useful, but WITHOUT 
ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
License for more details at gnu.org.
**************************************************************************/
package com.fineqt.fpb.protocol.sample;

import java.net.SocketException;

import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocket;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocketFactory;
import com.fineqt.fpb.lib.api.comm.pcap.NetworkInterface;
import com.fineqt.fpb.lib.api.util.IFpbSystem;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.value.IValue;

public class SampleMain {
	//本地的物理地址
	private static final String LOCAL_MAC = "00:16:D4:17:25:C4";
	//本地的IP地址
	private static final String LOCAL_IP = "192.168.11.5";
	//FPB的安装根目录
	private static final String FPB_HOME = "D:/work/ttcnworkspace/com.fineqt.fpb.lib";
	//FPB协议定义文件所在的目录，通常是FPB的安装根目录下的protocol目录。
	private static final String FPB_PROTOCOL_FOLDER = 
		"D:/work/ttcnworkspace/com.fineqt.fpb.protocol/protocol";
	//网络接口数组
	private static NetworkInterface[] ifs;
	//默认使用网络接口序号
	final static int INTERFACE_INDEX = 1;
	
	public static void main(String[] args) throws Exception {
		//FPB系统初始化
		IFpbSystem.INSTANCE.init(FPB_HOME, FPB_PROTOCOL_FOLDER);
		
		SampleMain main = new SampleMain();
		//Arp
		main.testArp();
		//Ping
		main.testPing();
		//TraceRoute
		main.testTraceroute();
		//TCP Connection
		main.testTcpConnect();
		//HTTP GET
		main.testHttpGet();
	}
	
	public void testArp() throws Exception {
        System.out.println("--------------- do testArp ---------------");
		String dstIp = "192.168.11.1";
		//生成Pcap套接字来实现链路层通信
		IPcapSocket socket = IPcapSocketFactory.INSTANCE.createPcapSocket();
		socket.setDevice(getInterface().name);
		//生成Arp对象
		ArpApp arp = new ArpApp(socket, LOCAL_MAC, LOCAL_IP);
		//设置是否打印数据通信内容
		arp.setDumpPacket(true);
		//取得目标设备的MAC地址
		String dstMac = arp.askMac(dstIp);
		//打印
		System.out.println("Mac for " + dstIp + " is " + dstMac + ".");
	}

	public void testPing() throws Exception {
        System.out.println("--------------- do testPing ---------------");
		String dstIp = "192.168.11.1";
		//生成Pcap套接字来实现链路层通信
		IPcapSocket socket = IPcapSocketFactory.INSTANCE.createPcapSocket();
		socket.setDevice(getInterface().name);
		//生成Arp对象
		ArpApp arp = new ArpApp(socket, LOCAL_MAC, LOCAL_IP);
		//设置是否打印数据通信内容
		arp.setDumpPacket(true);
		//取得目标设备的MAC地址
		String dstMac = arp.askMac(dstIp);
		//生成Ping对象
		PingApp ping = new PingApp(socket, LOCAL_MAC, dstMac, LOCAL_IP);
		//设置是否打印数据通信内容
		ping.setDumpPacket(true);
		//执行Ping(循环三次)
		ping.ping(3, dstIp);
	}
	

	public void testTraceroute() throws Exception {
        System.out.println("--------------- do testTraceroute ---------------");
		//网关IP地址
        String gatewayIp = "192.168.11.1";
        //目标IP地址
        String dstIp = "64.233.189.147";
		//生成Pcap套接字来实现链路层通信
		IPcapSocket socket = IPcapSocketFactory.INSTANCE.createPcapSocket();
		socket.setDevice(getInterface().name);
		//生成Arp对象
		ArpApp arp = new ArpApp(socket, LOCAL_MAC, LOCAL_IP);
		//设置是否打印数据通信内容
//		arp.setDumpPacket(true);
		//取得目标设备的MAC地址
		String dstMac = arp.askMac(gatewayIp);
		//生成Ping对象
		TracerouteApp trace = new TracerouteApp(socket, LOCAL_MAC, dstMac, LOCAL_IP);
//		trace.setDumpPacket(true);
		//执行
		trace.trace(dstIp);
	}
	
	public void testTcpConnect() throws Exception {
        System.out.println("--------------- do testTcpConnect ---------------");
		//网关IP地址
        String gatewayIp = "192.168.11.1";
        //目标IP地址
        String dstIp = "64.233.189.147";
		//生成Pcap套接字来实现链路层通信
		IPcapSocket socket = IPcapSocketFactory.INSTANCE.createPcapSocket();
		socket.setDevice(getInterface().name);
		//生成Arp对象
		ArpApp arp = new ArpApp(socket, LOCAL_MAC, LOCAL_IP);
		//设置是否打印数据通信内容
		arp.setDumpPacket(true);
		//取得目标设备的MAC地址
		String dstMac = arp.askMac(gatewayIp);
		//生成Connection对象
		TcpConnectionSample conn = new TcpConnectionSample(socket, LOCAL_MAC, dstMac, LOCAL_IP);
		//设置是否打印数据通信内容
		conn.setDumpPacket(true);
		if (!conn.openConnection(dstIp, 12923, 80)) {
			assert false;
		}
		conn.closeConnection();
	}

    public void testHttpGet() throws Exception {
        System.out.println("--------------- do testHttpGet ---------------");
        //目标主机地址
        String remoteHost = "www.google.com";
//        String remoteHost = "www.apache.org";
        //目标端口
        int remotePort = 80;
        HttpGetSample sample = new HttpGetSample();
        //设置是否打印数据通信内容
        sample.setDumpPacket(true);
        //执行HTTP GET动作（取得URI为/的资源，超时时间为1分钟）
        IValue response = sample.doGetAction(remoteHost, remotePort, "/", 60000);
        //取得应答报文中的数据并打印至标准输出
        assert "200".equals(response.findField("response/responseLine/status").getText());
        IValue body = response.findField("response/message/httpBody");
//        IValueDumper.INSTANCE.dump(body);
        byte[] bodyData = IValueSerializer.INSTANCE.encode(body, false);
        System.out.println(new String(bodyData));
    }
	
	public static NetworkInterface getInterface() throws SocketException {
		if (ifs == null) {
			ifs = IPcapSocketFactory.INSTANCE.getDeviceList();
		}
		return ifs[INTERFACE_INDEX];
	}
	
}
