package fpbprotocoltest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.api.value.IValueTextStyle;
import com.fineqt.fpb.lib.comm.pcap.PcapSocketImpl;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.protocol.ProtocolUtils;

import fpbtest.FpbTestUtil;

public class TcpProtocolTest extends TestCase {
	private static IValueSerializer ser = IValueSerializer.INSTANCE;
	IModule etherModule = IModuleRegistry.INSTANCE.resolveModule("EtherProtocol");
	IType etherPrtlType = etherModule.getType("EtherProtocol");
	IFactory etherFactory = etherModule.getFactory();

	public void testTcpv4() throws Exception {
		byte[] data;
		IRecordSetValue etherPrtl;
		IRecordSetValue newEtherPrtl;
		//ether/ipv4/tcp
		etherPrtl = createTcpv4Protocol();

		//calculate
		ser.calculate(etherPrtl);
//		IValueDumper.INSTANCE.dump(etherPrtl);

		//encode
		data = ser.encode(etherPrtl, false);
		
		//decode
		newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, etherPrtlType);
//		IValueDumper.INSTANCE.dump(newEtherPrtl);
		assertEquals("244D", newEtherPrtl.findField(
				"payload/ipv4/header/hcs").getText());
		assertEquals("2040", newEtherPrtl.findField(
				"payload/ipv4/payload/tcp/header/checksum").getText());
		newEtherPrtl.findField("payload/ipv4/header/hcs").setText("0000");
		newEtherPrtl.findField("payload/ipv4/payload/tcp/header/checksum").setText("0000");
		assertEquals(etherPrtl, newEtherPrtl);
		assertTrue(newEtherPrtl.validate(null));
	}

	public void testTcpv6() throws Exception {
		byte[] data;
		IRecordSetValue etherPrtl;
		IRecordSetValue newEtherPrtl;
		//ether/ipv6/tcp
		etherPrtl = createTcpv6Protocol();

		//calculate
		ser.calculate(etherPrtl);
//		IValueDumper.INSTANCE.dump(etherPrtl);

		//encode
		data = ser.encode(etherPrtl, false);
		
		//decode
		newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, etherPrtlType);
//		IValueDumper.INSTANCE.dump(newEtherPrtl);
		assertEquals("43BE", newEtherPrtl.findField(
				"payload/ipv6/payload/ipv6Data/tcp/header/checksum").getText());
		newEtherPrtl.findField("payload/ipv6/payload/ipv6Data/tcp/header/checksum").setText("0000");
		assertEquals(etherPrtl, newEtherPrtl);
		assertTrue(newEtherPrtl.validate(null));
	}
	
	/**
	 * 需要通过WireShark在外部观察数据包正确与否
	 * @throws Exception
	 */
	public void _testSendByPcap() throws Exception {
		//生成Pcap套接字来实现链路层通信
		PcapSocketImpl socket = new PcapSocketImpl(FpbTestUtil.getInterface().name);
		socket.open();
		
		IRecordSetValue etherPrtl;
		byte[] data;
		//ether/ipv4/tcp
		etherPrtl = createTcpv4Protocol();
		ser.calculate(etherPrtl);
		//encode
		data = ser.encode(etherPrtl, false);
		//send
		socket.write(data);

		//ether/ipv6/tcp
		etherPrtl = createTcpv6Protocol();
		ser.calculate(etherPrtl);
		//encode
		data = ser.encode(etherPrtl, false);
		//send
		socket.write(data);
		
		socket.close();
	}
	
	
	private IRecordSetValue createTcpv4Protocol() throws MetaException {
		IRecordSetValue etherPrtl;
		//ether/ipv4/udp
		etherPrtl = (IRecordSetValue)etherFactory.createValue(etherPrtlType);
		etherPrtl.getField("dstAddress").setTextAs("ff:ff:ff:ff:ff:ff", IValueTextStyle.MAC_ADDRESS);
		etherPrtl.getField("srcAddress").setTextAs("00:16:cf:2d:ce:e4", IValueTextStyle.MAC_ADDRESS);
		etherPrtl.getField("etherType").setText("0x0800");
		
		IRecordSetValue ipv4Prtl = (IRecordSetValue)etherPrtl.findField("payload/ipv4", true);
		IRecordSetValue header = (IRecordSetValue)ipv4Prtl.getField("header");
		header.getField("identification").setText("1");
		header.getField("timeToLive").setText("255");
		header.getField("protocol").setText("6");
		header.getField("sourceAddress").setTextAs("192.168.11.4", IValueTextStyle.IPV4_ADDRESS);
		header.getField("destinationAddress").setTextAs("192.168.11.5", IValueTextStyle.IPV4_ADDRESS);

		IRecordSetValue tcpPrtl = (IRecordSetValue)ipv4Prtl.findField(
				"payload/tcp", true);
		tcpPrtl.findField("header/sourcePort").setText("1111");
		tcpPrtl.findField("header/destinationPort").setText("2222");
		tcpPrtl.findField("payload/data", true).setText("11FF22FF");
		//tcp options
		tcpPrtl.findField("header/options[0]/nop", true);
		tcpPrtl.findField("header/options[1]/maxSs", true);
		tcpPrtl.findField("header/options[2]/windowScale", true);
		tcpPrtl.findField("header/options[3]/sackPermitted", true);
		tcpPrtl.findField("header/options[4]/sack", true);
		tcpPrtl.findField("header/options[5]/echo", true);
		tcpPrtl.findField("header/options[6]/echoReply", true);
		tcpPrtl.findField("header/options[7]/timestamp", true);
		tcpPrtl.findField("header/options[8]/last", true);
		return etherPrtl;
	}

	private IRecordSetValue createTcpv6Protocol() throws MetaException {
		IRecordSetValue etherPrtl;
		//ether/ipv4/udp
		etherPrtl = (IRecordSetValue)etherFactory.createValue(etherPrtlType);
		etherPrtl.getField("dstAddress").setTextAs("ff:ff:ff:ff:ff:ff", IValueTextStyle.MAC_ADDRESS);
		etherPrtl.getField("srcAddress").setTextAs("00:16:cf:2d:ce:e4", IValueTextStyle.MAC_ADDRESS);
		etherPrtl.getField("etherType").setText("0x86DD");
		
		IRecordSetValue ipv6Prtl = (IRecordSetValue)etherPrtl.findField("payload/ipv6", true);
		IRecordSetValue header = (IRecordSetValue)ipv6Prtl.getField("header");
		header.getField("hopLimit").setText("255");
		header.getField("nextHeader").setText("6");
		header.getField("sourceAddress").setTextAs("FDEC::BBFF:1:FFFF", IValueTextStyle.IPV6_ADDRESS);
		header.getField("destinationAddress").setTextAs("FDEC::BBFF:2:FFFF", IValueTextStyle.IPV6_ADDRESS);

		IRecordSetValue tcpPrtl = (IRecordSetValue)ipv6Prtl.findField(
				"payload/ipv6Data/tcp", true);
		tcpPrtl.findField("header/sourcePort").setText("1111");
		tcpPrtl.findField("header/destinationPort").setText("2222");
		tcpPrtl.findField("payload/data", true).setText("11FF22FF");
		//tcp options
		tcpPrtl.findField("header/options[0]/nop", true);
		tcpPrtl.findField("header/options[1]/maxSs", true);
		tcpPrtl.findField("header/options[2]/windowScale", true);
		tcpPrtl.findField("header/options[3]/sackPermitted", true);
		tcpPrtl.findField("header/options[4]/sack", true);
		tcpPrtl.findField("header/options[5]/echo", true);
		tcpPrtl.findField("header/options[6]/echoReply", true);
		tcpPrtl.findField("header/options[7]/timestamp", true);
		tcpPrtl.findField("header/options[8]/last", true);
		return etherPrtl;
	}
	
}
