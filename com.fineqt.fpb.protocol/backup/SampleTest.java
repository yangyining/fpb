package fpbprotocoltest;

import junit.framework.TestCase;

import com.fineqt.common.comm.CommTimeoutException;
import com.fineqt.common.comm.CommonSocket;
import com.fineqt.fpb.lib.api.IUnionValue;
import com.fineqt.fpb.lib.api.IValueDumper;
import com.fineqt.fpb.lib.api.IValueSerializer;
import com.fineqt.fpb.lib.comm.pcap.PcapSocket;
import com.fineqt.fpb.lib.comm.pcap.PcapSocketImpl;
import com.fineqt.fpb.lib.meta.context.DebugDecodeContext;
import com.fineqt.fpb.lib.meta.exception.DecodeException;
import com.fineqt.fpb.lib.meta.util.PValueSerializer;
import com.fineqt.fpb.lib.system.FpbSystem;
import com.fineqt.fpb.lib.type.DecodeResult;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;
import com.fineqt.fpb.lib.value.PUnionValue;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PValueTextStyle;
import com.fineqt.fpb.protocol.sample.ArpProtocol;
import com.fineqt.fpb.protocol.sample.EtherProtocol;
import com.fineqt.fpb.protocol.sample.Icmpv4EchoReply;
import com.fineqt.fpb.protocol.sample.Icmpv4EchoRequest;
import com.fineqt.fpb.protocol.sample.Icmpv4Protocol;
import com.fineqt.fpb.protocol.sample.Ipv4Header;
import com.fineqt.fpb.protocol.sample.Ipv4Protocol;
import com.fineqt.fpb.protocol.sample.SampleFactory;
import com.fineqt.fpb.protocol.sample.SampleModule;

import fpbtest.FpbTestUtil;

public class SampleTest extends TestCase {
	static final String LOCAL_MAC = "00:16:D4:17:25:C4";
	static final String LOCAL_IP = "192.168.11.5";
	
	SampleModule module = SampleModule.INSTANCE;
	SampleFactory factory = SampleFactory.INSTANCE;
	PValueSerializer ser = PValueSerializer.PINSTANCE;

	private void doTestModule()  throws Exception {
		byte[] data;
		TextBitset bitset;
		EtherProtocol etherPrtl;
		EtherProtocol newEtherPrtl;
		//Ethernet/Arp
		//Create Value
		etherPrtl = factory.createEtherProtocol();
		etherPrtl.getDstAddress().setTextAs("ff:ff:ff:ff:ff:ff", PValueTextStyle.MAC_ADDRESS);
		etherPrtl.getSrcAddress().setTextAs("00:16:cf:2d:ce:e4", PValueTextStyle.MAC_ADDRESS);
		etherPrtl.getEtherType().setInteger(0x0806);

		ArpProtocol arpPrtl = factory.createArpProtocol();
		arpPrtl.getOperation().setInteger(1);
		arpPrtl.getSenderHwAddress().setTextAs("00:16:cf:2d:ce:e2", PValueTextStyle.MAC_ADDRESS);
		arpPrtl.getSenderProtocolAddress().setTextAs("192.168.1.2", PValueTextStyle.IPV4_ADDRESS);
		arpPrtl.getTargetHwAddress().setTextAs("00:16:cf:2d:ce:e3", PValueTextStyle.MAC_ADDRESS);
		arpPrtl.getTargetProtocolAddress().setTextAs("192.168.1.3", PValueTextStyle.IPV4_ADDRESS);
		etherPrtl.getPayload().setField(SampleModule.ETHER_PAYLOAD__ARP, arpPrtl);
//		PValueDumper.INSTANCE.dump(etherPrtl);
		
		//encode
		ser.calculate(etherPrtl);
		data = ser.encode(etherPrtl, false);
		bitset = new NativeTextBitset(data);
//		System.out.println(bitset.get(TextBitset.HEX));
		
		//decode
		newEtherPrtl = (EtherProtocol)ser.decode(data, module.getEtherProtocol());
//		PValueDumper.INSTANCE.dump(newEtherPrtl);
		assertEquals(etherPrtl, newEtherPrtl);
		
		//Ethernet/Ipv4/Icmpv4/
		etherPrtl = factory.createEtherProtocol();
		etherPrtl.getDstAddress().setTextAs("ff:ff:ff:ff:ff:ff", PValueTextStyle.MAC_ADDRESS);
		etherPrtl.getSrcAddress().setTextAs("00:16:cf:2d:ce:e4", PValueTextStyle.MAC_ADDRESS);
		etherPrtl.getEtherType().setInteger(0x0800);
		
		Ipv4Protocol ipv4Prtl = factory.createIpv4Protocol();
		Ipv4Header header = ipv4Prtl.getHeader();
		header.getIdentification().setInteger(1);
		header.getTimeToLive().setInteger(255);
		header.getProtocol().setInteger(1);
		header.getSourceAddress().setTextAs("192.168.11.4", PValueTextStyle.IPV4_ADDRESS);
		header.getDestinationAddress().setTextAs("192.168.11.5", PValueTextStyle.IPV4_ADDRESS);
		etherPrtl.getPayload().setField(SampleModule.ETHER_PAYLOAD__IPV4, ipv4Prtl);
		
		IUnionValue icmpv4Prtl = factory.createIcmpv4Protocol();
		ipv4Prtl.getPayload().setField(SampleModule.IPV4_PAYLOAD__ICMPV4, icmpv4Prtl);
		Icmpv4EchoRequest echoRequest = factory.createIcmpv4EchoRequest();
		icmpv4Prtl.setField(SampleModule.ICMPV4_PROTOCOL__ECHO_REQUEST, echoRequest);
		echoRequest.getIndentifier().setInteger(1);
		echoRequest.getSequenceNumber().setInteger(2);
		
		ser.calculate(etherPrtl);
//		PValueDumper.INSTANCE.dump(etherPrtl);
		
		//encode
		data = ser.encode(etherPrtl, false);
		bitset = new NativeTextBitset(data);
//		System.out.println(bitset.get(TextBitset.HEX));		

		//decode
		newEtherPrtl = (EtherProtocol)ser.decode(data, module.getEtherProtocol());
//		PValueDumper.INSTANCE.dump(newEtherPrtl);

		assertEquals("ipv4", newEtherPrtl.getPayload().getPresentVariantName());
		ipv4Prtl = (Ipv4Protocol)newEtherPrtl.getPayload().getField("ipv4");
		assertNotNull(ipv4Prtl);
		assertEquals("2486", ipv4Prtl.getHeader().getHcs().getText());
		ipv4Prtl.getHeader().getHcs().setText("0000");
		assertEquals("icmpv4", ipv4Prtl.getPayload().getPresentVariantName());
		icmpv4Prtl = (PUnionValue)ipv4Prtl.getPayload().getField("icmpv4");
		assertNotNull(icmpv4Prtl);
		echoRequest = (Icmpv4EchoRequest)icmpv4Prtl.getPresentVariantValue();
		assertEquals("F7FC", echoRequest.getChecksum().getText());
		echoRequest.getChecksum().setText("0000");
		assertEquals(etherPrtl, newEtherPrtl);
	}

	public void testValue() {
		EtherProtocol etherPrtl;
		//create value
		etherPrtl = factory.createEtherProtocol();
		etherPrtl.getDstAddress().setTextAs("ff:ff:ff:ff:ff:ff", PValueTextStyle.MAC_ADDRESS);
		etherPrtl.getSrcAddress().setTextAs("00:16:cf:2d:ce:e4", PValueTextStyle.MAC_ADDRESS);
		etherPrtl.getEtherType().setInteger(0x0800);
		
		Ipv4Protocol ipv4Prtl = factory.createIpv4Protocol();
		Ipv4Header header = ipv4Prtl.getHeader();
		header.getIdentification().setInteger(1);
		header.getTimeToLive().setInteger(255);
		header.getProtocol().setInteger(1);
		header.getSourceAddress().setTextAs("192.168.11.4", PValueTextStyle.IPV4_ADDRESS);
		header.getDestinationAddress().setTextAs("192.168.11.5", PValueTextStyle.IPV4_ADDRESS);
		etherPrtl.getPayload().setField(SampleModule.ETHER_PAYLOAD__IPV4, ipv4Prtl);
		
		IUnionValue icmpv4Prtl = factory.createIcmpv4Protocol();
		ipv4Prtl.getPayload().setField(SampleModule.IPV4_PAYLOAD__ICMPV4, icmpv4Prtl);
		Icmpv4EchoRequest echoRequest = factory.createIcmpv4EchoRequest();
		icmpv4Prtl.setField(SampleModule.ICMPV4_PROTOCOL__ECHO_REQUEST, echoRequest);
		echoRequest.getIndentifier().setInteger(1);
		echoRequest.getSequenceNumber().setInteger(2);

		IValueDumper.INSTANCE.dump(etherPrtl);
		System.out.println(etherPrtl);

		//assignValue
		EtherProtocol newEtherPrtl = factory.createEtherProtocol();
		((PValue)newEtherPrtl).assignPValue((PValue)etherPrtl);
		IValueDumper.INSTANCE.dump(newEtherPrtl);
		System.out.println(newEtherPrtl);
		
		//check equals for assign
		Ipv4Protocol newIpv4Prtl = (Ipv4Protocol)newEtherPrtl.getPayload().getPresentVariantValue();
		assertNotNull(newIpv4Prtl);
		PUnionValue newIcmpv4Prtl = (PUnionValue)newIpv4Prtl.getPayload().getPresentVariantValue();
		assertNotNull(newIcmpv4Prtl);
		
		assertTrue(newEtherPrtl != etherPrtl);
		assertTrue(newIpv4Prtl != ipv4Prtl);
		assertTrue(newIcmpv4Prtl != icmpv4Prtl);
		assertEquals(icmpv4Prtl, newIcmpv4Prtl);
		assertEquals(ipv4Prtl, newIpv4Prtl);
		assertEquals(etherPrtl, newEtherPrtl);
		
		//check not equals for change
		Icmpv4EchoRequest newEchoRequest = (Icmpv4EchoRequest)newIcmpv4Prtl.pGetPresentVariant();
		newEchoRequest.getIndentifier().setInteger(99);
		assertFalse(icmpv4Prtl.equals(newIcmpv4Prtl));
		assertFalse(ipv4Prtl.equals(newIpv4Prtl));
		assertFalse(etherPrtl.equals(newEtherPrtl));
		
	}
	
	public void testModule() throws Exception {
		try {
			doTestModule();
		} catch (DecodeException e) {
			if (FpbSystem.INSTANCE.isDebug()) {
				DebugDecodeContext dcxt = (DebugDecodeContext)e.getDecodeContext();
				for (DecodeResult result : dcxt.getNotChainedResults()) {
					System.out.println(result);
				}
//				for (DecodeResult result : dcxt.getAllResults()) {
//					System.out.println(result);
//				}
				System.out.println(dcxt);
			}
			throw e;
		}
	}
	
	public void testArp() throws Exception {
		//生成Pcap套接字来实现链路层通信
		PcapSocketImpl socket = new PcapSocketImpl(FpbTestUtil.getInterface().name);
		//生成Arp对象
		Arp arp = new Arp(socket, LOCAL_MAC, LOCAL_IP);
		//取得目标设备的MAC地址
		String dstMac = arp.askMac("192.168.11.1");
		//打印
		System.out.println(dstMac);
	}
	
	public void testPing() throws Exception {
		//生成Pcap套接字来实现链路层通信
		PcapSocketImpl socket = new PcapSocketImpl(FpbTestUtil.getInterface().name);
		//生成Arp对象
		Arp arp = new Arp(socket, LOCAL_MAC, LOCAL_IP);
		//取得目标设备的MAC地址
		String dstMac = arp.askMac("192.168.11.1");
		//生成Ping对象
		Ping ping = new Ping(socket, LOCAL_MAC, dstMac, LOCAL_IP);
		//执行Ping(循环三次)
		ping.ping(3, "192.168.11.1");
	}
	
	/**
	 * 使用ICMPv4协议实现的Ping协议。
	 * 使用ICMPv4协议的Echo Request和Echo Reply报文来实现Ping应用。
	 */
	public static class Ping {
		private static SampleModule module = SampleModule.INSTANCE;
		private static SampleFactory factory = SampleFactory.INSTANCE;
		private static IValueSerializer ser = IValueSerializer.INSTANCE;
		private static int ICMP_REQUEST_DATA_BYTES = 32;
		private String srcMac;
		private String dstMac;
		private String srcIp;
		private PcapSocket socket;
		private int timeout = CommonSocket.DEFAULT_TIMEOUT;
		
		/**
		 * 构造函数
		 * @param socket PCAP套接字
		 * @param srcMac 源设备的MAC地址
		 * @param dstMac 目标设备的MAC地址
		 * @param srcIp 源设备的IP地址
		 */
		public Ping(PcapSocket socket, String srcMac, String dstMac, String srcIp) {
			this.socket = socket;
			this.srcMac = srcMac;
			this.dstMac = dstMac;
			this.srcIp = srcIp;
		}
		/**
		 * 生成ICMPv4的Echo Request报文数据包。协议栈为Ethernet/IPv4/ICMPv4。
		 * @param dstIp 目标设备的IP地址。
		 * @param icmpId Echo Request中的标识符
		 * @param icmpSeq Echo Request中的序号
		 * @return
		 */
		private EtherProtocol createPingRequest(String dstIp, int icmpId, int icmpSeq) {
			EtherProtocol etherPrtl = factory.createEtherProtocol();
			etherPrtl.getDstAddress().setTextAs(dstMac, PValueTextStyle.MAC_ADDRESS);
			etherPrtl.getSrcAddress().setTextAs(srcMac, PValueTextStyle.MAC_ADDRESS);
			etherPrtl.getEtherType().setInteger(0x0800);
			
			Ipv4Protocol ipv4Prtl = factory.createIpv4Protocol();
			Ipv4Header header = ipv4Prtl.getHeader();
			header.getIdentification().setInteger(1);
			header.getTimeToLive().setInteger(255);
			header.getProtocol().setInteger(1);
			header.getSourceAddress().setTextAs(srcIp, PValueTextStyle.IPV4_ADDRESS);
			header.getDestinationAddress().setTextAs(dstIp, PValueTextStyle.IPV4_ADDRESS);
			etherPrtl.getPayload().setField(SampleModule.ETHER_PAYLOAD__IPV4, ipv4Prtl);
			
			IUnionValue icmpv4Prtl = factory.createIcmpv4Protocol();
			ipv4Prtl.getPayload().setField(SampleModule.IPV4_PAYLOAD__ICMPV4, icmpv4Prtl);
			Icmpv4EchoRequest echoRequest = factory.createIcmpv4EchoRequest();
			icmpv4Prtl.setField(SampleModule.ICMPV4_PROTOCOL__ECHO_REQUEST, echoRequest);
			echoRequest.getIndentifier().setInteger(icmpId);
			echoRequest.getSequenceNumber().setInteger(icmpSeq);
			
			byte[] data = new byte[ICMP_REQUEST_DATA_BYTES];
			for (int i = 0; i < data.length; i++) {
				data[i] = (byte)i;
			}
			echoRequest.getData().setValue(data);
			return etherPrtl;
		}
		/**
		 * 根据指示的目标设备IP地址通过ICMPv4协议来检验源设备到目标设备的网路是否连通。检验结果会被打印在
		 * 标准输出中。
		 * @param cnt 检验次数，即Echo请求的发送次数。
		 * @param dstIp 目标设备的IP地址
		 * @throws Exception
		 */
		public void ping(int cnt, String dstIp) throws Exception {
			byte[] resData = new byte[1514];
			socket.setTimeout(timeout);
			//打开套接字
			socket.open();
			try {
				//设置Pcap套接字的过滤条件。（过滤条件的书写规则可以参考WinPcap的用户手册）
				socket.setFilter("ip dst " + srcIp + " and icmp", true);
				//生成随机的ICMP Echo请求的标识符
				int icmpId = (int)(Math.random() * 0xFFFF);
				//进行多次Ping检验
				for (int i = 0; i < cnt; i++) {
					//ICMP Echo请求的序号
					int seqNo = i;
					//生成ICMP Echo请求报文
					EtherProtocol pingRequest = createPingRequest(dstIp, icmpId, seqNo);
					//对报文数据包内的可计算字段进行自动计算（这里是IP协议的HeaderLength和TotalLength字段）
					ser.calculate(pingRequest);
					//打印报文内容
					IValueDumper.INSTANCE.dump(pingRequest);
					//编码
					byte data[] = ser.encode(pingRequest, false);
					//发送编码数据
					socket.write(data);
					//起始时间
					long startTime = System.currentTimeMillis();
					//已花费时间（计算超时）
					long totalTime = 0;
					//循环接收数据包直到超时
					while (totalTime < timeout) {
						//接收数据
						int len;
						try {
							len = socket.read(resData);
						} catch (CommTimeoutException e) {
							totalTime = timeout;
							break;
						}
						//解码（底层协议为Ethernet所以使用EtherProtocol作为推测类型）
						EtherProtocol pingResponse = (EtherProtocol)ser.decode(resData, 0, len, 
								module.getEtherProtocol());
						//打印报文
						IValueDumper.INSTANCE.dump(pingResponse);
						//取得花费时间
						totalTime = System.currentTimeMillis() - startTime;
						//从EthernetProtocol的Payload字段里取出IPv4协议字段
						Ipv4Protocol ipv4Prtl = pingResponse.getPayload().getIpv4();
						if (ipv4Prtl == null) {
							continue;
						}
						//从Ipv4Protocol地Payload字段里取出Icmpv4协议字段
						Icmpv4Protocol icmpv4Prtl = ipv4Prtl.getPayload().getIcmpv4();
						if (icmpv4Prtl == null) {
							continue;
						}
						//从Icmpv4Protocol中取出EchoReply字段
						Icmpv4EchoReply echoReply = icmpv4Prtl.getEchoReply();
						if (echoReply == null) {
							continue;
						}
						//判断EchoReply的标识符和序号是否与EchoRequest的一致
						if (echoReply.getIndentifier().getInteger() != icmpId || 
								echoReply.getSequenceNumber().getInteger() != seqNo) {
							continue;
						}
						//取得目标设备的IP地址
						String tempIp = ipv4Prtl.getHeader().getSourceAddress().getTextAs(
								PValueTextStyle.IPV4_ADDRESS);
						//取得EchoReply中的Data字段的长度（字节数）
						int dataLen = echoReply.getData().getLength();
						//取得IPv4的TTL字段值
						int ttl = ipv4Prtl.getHeader().getTimeToLive().getInteger();
						//打印检验结果
						String msg = "Reply from " + tempIp + " bytes=" + dataLen + " time<=" +
	                    totalTime/1000.0 + "(s)" + " TTL=" + ttl;
						System.out.println(msg);
						break;
					}
					//判断是否超时
					if (totalTime >= timeout) {
						System.out.println("timeout");
					}
				}
			} finally {
				//关闭套接字
				socket.close();
			}
		}
		
	}
	/**
	 * Arp协议的实现。
	 * 使用ARP协议根据目标设备的IP地址来取得目标设备的MAC地址。
	 */
	public static class Arp {
		private static SampleModule module = SampleModule.INSTANCE;
		private static SampleFactory factory = SampleFactory.INSTANCE;
		private static PValueSerializer ser = PValueSerializer.PINSTANCE;
		private String srcMac;
		private String srcIp;
		private PcapSocket socket;
		private int timeout = CommonSocket.DEFAULT_TIMEOUT;
		
		/**
		 * 构造函数
		 * @param socket Pcap套接字。
		 * @param srcMac 源设备的MAC地址。
		 * @param srcIp 源设备的IP地址。
		 */
		public Arp(PcapSocket socket, String srcMac, String srcIp) {
			this.socket = socket;
			this.srcMac = srcMac;
			this.srcIp = srcIp;
		}
		/**
		 * 生成ARP请求报文。协议栈为Ehternet/Arp.
		 * @param dstIp
		 * @return
		 */
		private EtherProtocol createArpRequest(String dstIp) {
			//Ethernet
			EtherProtocol etherPrtl = factory.createEtherProtocol();
			etherPrtl.getDstAddress().setTextAs("ff:ff:ff:ff:ff:ff", PValueTextStyle.MAC_ADDRESS);
			etherPrtl.getSrcAddress().setTextAs(srcMac, PValueTextStyle.MAC_ADDRESS);
			etherPrtl.getEtherType().setInteger(0x0806);
			//Arp
			ArpProtocol arpPrtl = factory.createArpProtocol();
			arpPrtl.getOperation().setInteger(1);
			arpPrtl.getSenderHwAddress().setTextAs(srcMac, PValueTextStyle.MAC_ADDRESS);
			arpPrtl.getSenderProtocolAddress().setTextAs(srcIp, PValueTextStyle.IPV4_ADDRESS);
			arpPrtl.getTargetHwAddress().setTextAs("00:00:00:00:00:00", PValueTextStyle.MAC_ADDRESS);
			arpPrtl.getTargetProtocolAddress().setTextAs(dstIp, PValueTextStyle.IPV4_ADDRESS);
			etherPrtl.getPayload().setField(SampleModule.ETHER_PAYLOAD__ARP, arpPrtl);
			return etherPrtl;
		}
		/**
		 * 根据目标设备的IP地址来取得目标设备的MAC地址。
		 * @param dstIp 目标设备的IP地址。
		 * @return 目标设备的MAC地址文本描述。
		 * @throws Exception
		 */
		public String askMac(String dstIp) throws Exception {
			byte[] resData = new byte[1514];
			socket.setTimeout(timeout);
			//打开套接字
			socket.open();
			try {
				//设置Pcap套接字的过滤条件。（过滤条件的书写规则可以参考WinPcap的用户手册）
				socket.setFilter("ether dst " + srcMac + " and arp", true);
				//生成ARP请求报文
				EtherProtocol arpRequest = createArpRequest(dstIp);
				//对报文数据包内的可计算字段进行自动计算（这里是Arp协议的Hlen和Plen字段）
				ser.calculate(arpRequest);
				IValueDumper.INSTANCE.dump(arpRequest);
				//编码
				byte data[] = ser.encode(arpRequest, false);
				//发送编码数据
				socket.write(data);
				//接收应答数据
				int len = socket.read(resData);
				//解码（底层协议为Ethernet所以使用EtherProtocol作为推测类型）
				EtherProtocol arpResponse = (EtherProtocol)ser.decode(resData, 0, len, 
						module.getEtherProtocol());
				//打印解码后的ARP应答报文对象
				IValueDumper.INSTANCE.dump(arpResponse);
				//从EthernetProtocol的Payload字段取得ARP协议字段
				ArpProtocol arpPrtl = arpResponse.getPayload().getArp();
				//取得ARP协议的SenderHwAddress从而得到目标设备的MAC地址
				return arpPrtl.getSenderHwAddress().getTextAs(PValueTextStyle.MAC_ADDRESS);
			} finally {
				//关闭套接字
				socket.close();
			}
		}

		public int getTimeout() {
			return timeout;
		}

		public void setTimeout(int timeout) {
			this.timeout = timeout;
		}

		public String getSrcMac() {
			return srcMac;
		}

		public String getSrcIp() {
			return srcIp;
		}
		
	}
}
