package fpbprotocoltest;

import java.net.SocketException;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocket;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocketFactory;
import com.fineqt.fpb.lib.api.util.IValueDumper;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.protocol.sample.ArpApp;
import com.fineqt.fpb.protocol.sample.HttpGetSample;
import com.fineqt.fpb.protocol.sample.PingApp;
import com.fineqt.fpb.protocol.sample.TcpConnectionSample;
import com.fineqt.fpb.protocol.sample.TracerouteApp;

import fpbtest.FpbTestUtil;

public class SampleTest extends TestCase {
	static Log log = LogFactory.getLog(SampleTest.class);
	
	private static final String LOCAL_MAC = "00:16:D4:17:25:C4";
	private static final String LOCAL_IP = "192.168.11.5";
	
	public void testArp() throws Exception {
		String dstIp = "192.168.11.1";
		//生成Pcap套接字来实现链路层通信
		IPcapSocket socket = createPcapSocket();
		//生成Arp对象
		ArpApp arp = new ArpApp(socket, LOCAL_MAC, LOCAL_IP);
//		arp.setDumpPacket(true);
		//取得目标设备的MAC地址
		String dstMac = arp.askMac(dstIp);
		//打印
		System.out.println("Mac for " + dstIp + " is " + dstMac + ".");
	}

	public void testPing() throws Exception {
		String dstIp = "192.168.11.1";
		//生成Pcap套接字来实现链路层通信
		IPcapSocket socket = createPcapSocket();
		//生成Arp对象
		ArpApp arp = new ArpApp(socket, LOCAL_MAC, LOCAL_IP);
//		arp.setDumpPacket(true);
		//取得目标设备的MAC地址
		String dstMac = arp.askMac(dstIp);
		//生成Ping对象
		PingApp ping = new PingApp(socket, LOCAL_MAC, dstMac, LOCAL_IP);
//		ping.setDumpPacket(true);
		//执行Ping(循环三次)
		ping.ping(3, dstIp);
	}
	

	public void testTraceroute() throws Exception {
		//网关IP地址
        String gatewayIp = "192.168.11.1";
        //目标IP地址
        String dstIp = "64.233.189.147";
		//生成Pcap套接字来实现链路层通信
		IPcapSocket socket = createPcapSocket();
		//生成Arp对象
		ArpApp arp = new ArpApp(socket, LOCAL_MAC, LOCAL_IP);
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
		//网关IP地址
        String gatewayIp = "192.168.11.1";
        //目标IP地址
        String dstIp = "64.233.189.147";
		//生成Pcap套接字来实现链路层通信
		IPcapSocket socket = createPcapSocket();
		//生成Arp对象
		ArpApp arp = new ArpApp(socket, LOCAL_MAC, LOCAL_IP);
//		arp.setDumpPacket(true);
		//取得目标设备的MAC地址
		String dstMac = arp.askMac(gatewayIp);
		//生成Connection对象
		TcpConnectionSample conn = new TcpConnectionSample(socket, LOCAL_MAC, dstMac, LOCAL_IP);
//		conn.setDumpPacket(true);
		assertTrue(conn.openConnection(dstIp, 12923, 80));
		conn.closeConnection();
	}

	public void testHttpGet() throws Exception {
	    //目标主机地址
	    String remoteHost = "www.google.com";
//        String remoteHost = "www.apache.org";
	    //目标端口
	    int remotePort = 80;
	    HttpGetSample sample = new HttpGetSample();
//	    sample.setDumpPacket(true);
	    IValue response = sample.doGetAction(remoteHost, remotePort, "/", 60000);
	    //取得应答报文中的数据
	    assertEquals("200", response.findField("response/responseLine/status").getText());
	    IValue body = response.findField("response/message/httpBody");
//      IValueDumper.INSTANCE.dump(body);
	    byte[] bodyData = IValueSerializer.INSTANCE.encode(body, false);
	    System.out.println(new String(bodyData));
	}
	
	private IPcapSocket createPcapSocket() throws SocketException {
		IPcapSocket socket = IPcapSocketFactory.INSTANCE.createPcapSocket();
		socket.setDevice(FpbTestUtil.getInterface().name);
		return socket;
	}
	
}
