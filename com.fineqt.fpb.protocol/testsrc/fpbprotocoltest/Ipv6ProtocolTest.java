package fpbprotocoltest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.util.IValueDumper;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.api.value.IValueTextStyle;
import com.fineqt.fpb.lib.comm.pcap.PcapSocketImpl;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;
import com.fineqt.fpb.protocol.ProtocolUtils;

import fpbtest.FpbTestUtil;

public class Ipv6ProtocolTest extends TestCase {
	private static IValueSerializer ser = IValueSerializer.INSTANCE;
//	public static IIntegerValue AUTH_HEADER_ICV_BYTES;
//	
//	{
//		AUTH_HEADER_ICV_BYTES = BuiltinFactory.BUILTIN_INSTANCE.createInteger();
//		AUTH_HEADER_ICV_BYTES.setInteger(3);
//		FpbSystem.INSTANCE.setAttribute("AUTH_HEADER_ICV_BYTES", AUTH_HEADER_ICV_BYTES);
//	}
	 
	public void testEncodeDecode() throws Exception {
		IModule ipv6Module = IModuleRegistry.INSTANCE.resolveModule("Ipv6Protocol");
		assertNotNull(ipv6Module);
		byte[] data;
		TextBitset bitset;
		IRecordSetValue etherPrtl;
		IRecordSetValue newEtherPrtl;
		IModule etherModule = IModuleRegistry.INSTANCE.resolveModule("EtherProtocol");
		IFactory etherFactory = etherModule.getFactory();
		//ether/ipv6
		etherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
		etherPrtl.getField("etherType").setText("0x86DD");
		etherPrtl.findField("payload/ipv6", true);
		etherPrtl.findField("payload/ipv6/header/sourceAddress")
			.setTextAs("FDEC::BBFF:0:FFFF", IValueTextStyle.IPV6_ADDRESS);
		etherPrtl.findField("payload/ipv6/header/destinationAddress")
			.setTextAs("FDEC::BBFF:1:FFFF", IValueTextStyle.IPV6_ADDRESS);
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/data", true).setText("11FF22FF");
		ser.calculate(etherPrtl);
//		IValueDumper.INSTANCE.dump(etherPrtl);
		
		//encode
		data = ser.encode(etherPrtl, false);
		bitset = new NativeTextBitset(data);
//		System.out.println(bitset.get(TextBitset.HEX));

		//decode
		newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, 
				etherModule.getType("EtherProtocol"));
//		IValueDumper.INSTANCE.dump(newEtherPrtl);
		assertEquals(etherPrtl, newEtherPrtl);
		assertTrue(newEtherPrtl.validate(null));

		//ether/ipv6/HopByHop
		IRecordSetValue extHeader;
		etherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
		etherPrtl.getField("etherType").setText("0x86DD");
		etherPrtl.findField("payload/ipv6/header/nextHeader", true).setText("0");
		extHeader = (IRecordSetValue)etherPrtl.findField(
				"payload/ipv6/payload/extHdrList[0]/hopByHopHeader", true);
		extHeader.getField("nextHeader").setText("59");
		extHeader.findField("options[0]/jumboPayload/optJumboPayloadLength", true).setText("100");
//		extHeader.findField("options[1]/padN", true);
		ser.calculate(etherPrtl);
//		IValueDumper.INSTANCE.dump(etherPrtl);
		
		//encode
		data = ser.encode(etherPrtl, false);
		bitset = new NativeTextBitset(data);
//		System.out.println(bitset.get(TextBitset.HEX));

		//decode
		newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, 
				etherModule.getType("EtherProtocol"));
//		IValueDumper.INSTANCE.dump(newEtherPrtl);
		assertEquals(etherPrtl, newEtherPrtl);
		assertTrue(newEtherPrtl.validate(null));
		
		//ether/ipv6/HopByHop/Routing/Fragment/Auth/DestOption/data
		etherPrtl = createIpv6WithAllExtHeader();
		ser.calculate(etherPrtl);
//		IValueDumper.INSTANCE.dump(etherPrtl);
		assertEquals("AABBCC", etherPrtl.findField(
				"payload/ipv6/payload/extHdrList[3]/authHeader/icv").getText());
		assertEquals("00", etherPrtl.findField(
				"payload/ipv6/payload/extHdrList[3]/authHeader/icvPadding").getText());
		//encode
		data = ser.encode(etherPrtl, false);
		bitset = new NativeTextBitset(data);
//		System.out.println(bitset.get(TextBitset.HEX));

		//decode
		newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, 
				etherModule.getType("EtherProtocol"));
		assertEquals("AABBCC00", newEtherPrtl.findField(
				"payload/ipv6/payload/extHdrList[3]/authHeader/icv").getText());
		assertEquals("", newEtherPrtl.findField(
				"payload/ipv6/payload/extHdrList[3]/authHeader/icvPadding").getText());
//		IValueDumper.INSTANCE.dump(newEtherPrtl);
		newEtherPrtl.findField(
				"payload/ipv6/payload/extHdrList[3]/authHeader/icv").setText("AABBCC");
		newEtherPrtl.findField(
				"payload/ipv6/payload/extHdrList[3]/authHeader/icvPadding").setText("00");
		assertEquals(etherPrtl, newEtherPrtl);
		assertTrue(newEtherPrtl.validate(null));
		
		//ether/ipv6/data//icmpv6/echoRequest
		etherPrtl = createEechoRequestMsg();

		ser.calculate(etherPrtl);
//		IValueDumper.INSTANCE.dump(etherPrtl);
//		assertEquals("xxx", etherPrtl.findField("payload/ipv6/header/payloadLength").getText());
		assertEquals("0000", etherPrtl.findField(
				"payload/ipv6/payload/ipv6Data/icmpv6/echoRequest/checksum").getText());
		
		//encode
		data = ser.encode(etherPrtl, false);
		bitset = new NativeTextBitset(data);
//		System.out.println(bitset.get(TextBitset.HEX));		
		
		//decode
		newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, 
				etherModule.getType("EtherProtocol"));
//		IValueDumper.INSTANCE.dump(newEtherPrtl);
		assertEquals("7FBA", newEtherPrtl.findField(
				"payload/ipv6/payload/ipv6Data/icmpv6/echoRequest/checksum").getText());
		newEtherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/echoRequest/checksum").setText("0000");
		assertEquals(etherPrtl, newEtherPrtl);
		assertTrue(newEtherPrtl.validate(null));
		
	}

	public void testIpv6Fragment() throws Exception {
	    //TODO
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
		//ether/ipv6/HopByHop/Routing/Fragment/Auth/DestOption/data
		etherPrtl = createIpv6WithAllExtHeader();
		ser.calculate(etherPrtl);
		//encode
		data = ser.encode(etherPrtl, false);
		//send
		socket.write(data);
		
		//ether/ipv6/data//icmpv6/echoRequest
		etherPrtl = createEechoRequestMsg();
		ser.calculate(etherPrtl);
		//encode
		data = ser.encode(etherPrtl, false);
		//send
		socket.write(data);
		
		socket.close();
	}
	
	
	public void testIcmpv6Protocol() throws Exception {
		IModule icmpv6Module = IModuleRegistry.INSTANCE.resolveModule("Icmpv6Protocol");
		assertNotNull(icmpv6Module);
		IModule etherModule = IModuleRegistry.INSTANCE.resolveModule("EtherProtocol");
		IType etherPrtlType = etherModule.getType("EtherProtocol");
		IFactory etherFactory = etherModule.getFactory();
		IRecordSetValue etherPrtl;
		IValue msg;
		etherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
		etherPrtl.getField("etherType").setText("0x86DD");
		etherPrtl.findField("payload/ipv6/header/nextHeader", true).setText("58");
		
		//DestinationUnreachable
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/dstUnreachable", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//PacketTooBig
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/packetTooBig", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//TimeExceeded
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/timeExceeded", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//ParameterProblem
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/paraProblem", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//EchoRequest
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/echoRequest", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//EchoReply
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/echoReply", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//RouterSolicitation
		msg = etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/routerSol", true);
		msg.findField("options/srcLinkLayerAddr", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//RouterAdvertisement
		msg = etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/routerAdv", true);
		msg.findField("options/srcLinkLayerAddr", true);
		msg.findField("options/mtuOption", true);
		msg.findField("options/prefixInfo", true);
		msg.findField("options/advInterval", true);
		msg.findField("options/homeAgentInfo", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//NeighborSolicitation
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/nbrSol", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//NeighborAdvertisement
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/nbrAdv", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//Redirect
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/redirect", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//MldQueryV2
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/mldQueryV2", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//MldReportV2
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/mldReportV2", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
		//MldDone
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/icmpv6/mldDone", true);
		checkEncodeAndDecode(etherPrtl, etherPrtlType);
	}
	
	private IRecordSetValue createIpv6WithAllExtHeader()
	throws MetaException {
		IModule etherModule = IModuleRegistry.INSTANCE.resolveModule("EtherProtocol");
		IFactory etherFactory = etherModule.getFactory();
		IRecordSetValue etherPrtl;
		IRecordSetValue extHeader;
		etherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
		etherPrtl.getField("etherType").setText("0x86DD");
		etherPrtl.findField("payload/ipv6/header/nextHeader", true).setText("0");
		//hopByHop
		extHeader = (IRecordSetValue)etherPrtl.findField(
				"payload/ipv6/payload/extHdrList[0]/hopByHopHeader", true);
		extHeader.getField("nextHeader").setText("43");
		extHeader.findField("options[0]/jumboPayload/optJumboPayloadLength", true).setText("100");
		//routing
		extHeader = (IRecordSetValue)etherPrtl.findField(
				"payload/ipv6/payload/extHdrList[1]/routingHeader", true);
		extHeader.getField("nextHeader").setText("44");
		extHeader.getField("routingType").setText("0");
		extHeader.findField("routingHeaderData/addressList[0]", true)
				.setTextAs("FDEC::BBFF:2:FFFF", IValueTextStyle.IPV6_ADDRESS);
		//fragment
		extHeader = (IRecordSetValue)etherPrtl.findField(
				"payload/ipv6/payload/extHdrList[2]/fragmentHeader", true);
		extHeader.getField("nextHeader").setText("51");
		//auth
		extHeader = (IRecordSetValue)etherPrtl.findField(
				"payload/ipv6/payload/extHdrList[3]/authHeader", true);
		extHeader.getField("nextHeader").setText("60");
		extHeader.getField("icv", true).setText("AABBCC");
		//extHeader.getField("icvPadding", true);
		//DestOption
		extHeader = (IRecordSetValue)etherPrtl.findField(
				"payload/ipv6/payload/extHdrList[4]/destOptionHeader", true);
		extHeader.getField("nextHeader").setText("59");
		extHeader.findField("destOptionList[0]/homeAddressOption/homeAddress", true)
				.setTextAs("FDEC::BBFF:3:FFFF", IValueTextStyle.IPV6_ADDRESS);
		((IOctetstringValue)extHeader.findField("destOptionList[1]/padN/padding", true))
				.setLength(2);
		//data
		etherPrtl.findField("payload/ipv6/payload/ipv6Data/data", true).setText("11FF22FF");
		return etherPrtl;
	}

	private IRecordSetValue createEechoRequestMsg()
		throws MetaException {
		IModule etherModule = IModuleRegistry.INSTANCE.resolveModule("EtherProtocol");
		IFactory etherFactory = etherModule.getFactory();
		IRecordSetValue etherPrtl;
		etherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
		etherPrtl.getField("etherType").setText("0x86DD");
		etherPrtl.findField("payload/ipv6/header/nextHeader", true).setText("58");
		IRecordSetValue echoRequest = (IRecordSetValue)etherPrtl.findField(
				"payload/ipv6/payload/ipv6Data/icmpv6/echoRequest", true);
		echoRequest.getField("identifier").setText("1");
		echoRequest.getField("sequenceNumber").setText("2");
		return etherPrtl;
	}

	private IValue checkEncodeAndDecode(IValue valueToEncode, IType hypType) throws Exception {
//		System.out.println("Before Encode:");
//		IValueDumper.INSTANCE.dump(valueToEncode);
		ser.calculate(valueToEncode);
		
		byte[] data = ser.encode(valueToEncode, false);
//		System.out.println("Before Decode:");
//		IValueDumper.INSTANCE.dump(valueToEncode);

		IValue resultValue = ProtocolUtils.decode(data, hypType);
//		System.out.println("After Decode:");
//		IValueDumper.INSTANCE.dump(resultValue);
		return resultValue;
	}
	
	
}
