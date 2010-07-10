package fpbprotocoltest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.util.IValueDumper;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.api.value.IUnionValue;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.api.value.IValueTextStyle;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.protocol.ProtocolUtils;

public class Ipv4ProtocolsTest extends TestCase {
	private static IValueSerializer ser = IValueSerializer.INSTANCE;
    IModule etherModule = IModuleRegistry.INSTANCE.resolveModule("EtherProtocol");
    IFactory etherFactory = etherModule.getFactory();
    IModule arpModule = IModuleRegistry.INSTANCE.resolveModule("ArpProtocol");
    IModule ipv4Module = IModuleRegistry.INSTANCE.resolveModule("Ipv4Protocol");

//	public void testLoad() {
//        IModule etherModule = IModuleRegistry.INSTANCE.resolveModule("EtherProtocol");
//        assertNotNull(etherModule);
//	}
	
	public void testEncodeDecode() throws Exception {
		byte[] data;
		TextBitset bitset;
		IRecordSetValue etherPrtl;
		IRecordSetValue newEtherPrtl;
		//Ethernet/Arp
		//Create Value
		etherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
		etherPrtl.getField("dstAddress").setTextAs("ff:ff:ff:ff:ff:ff", IValueTextStyle.MAC_ADDRESS);
		etherPrtl.getField("srcAddress").setTextAs("00:16:cf:2d:ce:e4", IValueTextStyle.MAC_ADDRESS);
		etherPrtl.getField("etherType").setText("0x0806");
		
		IRecordSetValue arpPrtl = (IRecordSetValue)etherPrtl.findField("payload/arp", true);
		arpPrtl.getField("operation").setText("1");
		arpPrtl.getField("senderHwAddress").setTextAs("00:16:cf:2d:ce:e2", IValueTextStyle.MAC_ADDRESS);
		arpPrtl.getField("senderProtocolAddress").setTextAs("192.168.1.2", IValueTextStyle.IPV4_ADDRESS);
		arpPrtl.getField("targetHwAddress").setTextAs("00:16:cf:2d:ce:e3", IValueTextStyle.MAC_ADDRESS);
		arpPrtl.getField("targetProtocolAddress").setTextAs("192.168.1.3", IValueTextStyle.IPV4_ADDRESS);
//		IValueDumper.INSTANCE.dump(etherPrtl);
		
		//encode
		ser.calculate(etherPrtl);
		data = ser.encode(etherPrtl, false);
		bitset = new NativeTextBitset(data);
//		System.out.println(bitset.get(TextBitset.HEX));
		
		//decode
		newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, 
				etherModule.getType("EtherProtocol"));
//		IValueDumper.INSTANCE.dump(newEtherPrtl);
		assertEquals(etherPrtl, newEtherPrtl);
		assertTrue(newEtherPrtl.validate(null));
		
		//Ethernet/Ipv4/Icmpv4/
		etherPrtl = createIcmpv4Packet();
		
		ser.calculate(etherPrtl);
//		IValueDumper.INSTANCE.dump(etherPrtl);
		assertEquals("5", etherPrtl.findField("payload/ipv4/header/headerLength").getText());
		assertEquals("28", etherPrtl.findField("payload/ipv4/header/totalLength").getText());
		assertEquals("0000", etherPrtl.findField(
				"payload/ipv4/header/hcs").getText());
		assertEquals("0000", etherPrtl.findField(
				"payload/ipv4/payload/icmpv4/echoRequest/checksum").getText());

		//encode
		data = ser.encode(etherPrtl, false);
		bitset = new NativeTextBitset(data);
//		System.out.println(bitset.get(TextBitset.HEX));		
		
		//decode
		newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, 
				etherModule.getType("EtherProtocol"));
//		IValueDumper.INSTANCE.dump(newEtherPrtl);
		assertEquals("2486", newEtherPrtl.findField(
				"payload/ipv4/header/hcs").getText());
		assertEquals("F7FC", newEtherPrtl.findField(
				"payload/ipv4/payload/icmpv4/echoRequest/checksum").getText());
		newEtherPrtl.findField("payload/ipv4/header/hcs").setText("0000");
		newEtherPrtl.findField("payload/ipv4/payload/icmpv4/echoRequest/checksum").setText("0000");
		assertEquals(etherPrtl, newEtherPrtl);
		assertTrue(newEtherPrtl.validate(null));
	}

	public void testIpv4Fragment() throws Exception {
        byte[] data;
        TextBitset bitset;
        IRecordSetValue etherPrtl;
        IRecordSetValue newEtherPrtl;
	    
        //Ethernet/Ipv4/Icmpv4/ moreFrags=true
        etherPrtl = createIcmpv4Packet();
        etherPrtl.findField("payload/ipv4/header/moreFrags").setText("true");
        
        ser.calculate(etherPrtl);
//        IValueDumper.INSTANCE.dump(etherPrtl);
        
        //encode
        data = ser.encode(etherPrtl, false);
        bitset = new NativeTextBitset(data);
//      System.out.println(bitset.get(TextBitset.HEX));     
        
        //decode
        newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, 
                etherModule.getType("EtherProtocol"));
//        IValueDumper.INSTANCE.dump(newEtherPrtl);
        
        //确保断片的上层协议不被解释
        assertNull(newEtherPrtl.findField("payload/ipv4/payload/icmpv4"));
        assertNotNull(newEtherPrtl.findField("payload/ipv4/payload/data"));
        
        //Ethernet/Ipv4/Icmpv4/ fragmentOffset>0
        etherPrtl = createIcmpv4Packet();
        etherPrtl.findField("payload/ipv4/header/fragmentOffset").setText("10");
        
        ser.calculate(etherPrtl);
//        IValueDumper.INSTANCE.dump(etherPrtl);
        
        //encode
        data = ser.encode(etherPrtl, false);
        bitset = new NativeTextBitset(data);
//      System.out.println(bitset.get(TextBitset.HEX));     
        
        //decode
        newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, 
                etherModule.getType("EtherProtocol"));
//        IValueDumper.INSTANCE.dump(newEtherPrtl);
        
        //确保断片的上层协议不被解释
        assertNull(newEtherPrtl.findField("payload/ipv4/payload/icmpv4"));
        assertNotNull(newEtherPrtl.findField("payload/ipv4/payload/data"));
	}
	
	public void testAssignValue() throws Exception {
		//Ethernet/Ipv4/Icmpv4/
		IRecordSetValue etherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
		etherPrtl.getField("dstAddress").setTextAs("ff:ff:ff:ff:ff:ff", IValueTextStyle.MAC_ADDRESS);
		etherPrtl.getField("srcAddress").setTextAs("00:16:cf:2d:ce:e4", IValueTextStyle.MAC_ADDRESS);
		etherPrtl.getField("etherType").setText("0x0800");
		
		IRecordSetValue ipv4Prtl = (IRecordSetValue)etherPrtl.findField("payload/ipv4", true);
		IRecordSetValue header = (IRecordSetValue)ipv4Prtl.getField("header");
		header.getField("identification").setText("1");
		header.getField("timeToLive").setText("255");
		header.getField("protocol").setText("1");
		header.getField("sourceAddress").setTextAs("192.168.11.4", IValueTextStyle.IPV4_ADDRESS);
		header.getField("destinationAddress").setTextAs("192.168.11.5", IValueTextStyle.IPV4_ADDRESS);
		
		IRecordSetValue echoRequest = (IRecordSetValue)ipv4Prtl.findField(
				"payload/icmpv4/echoRequest", true);
		echoRequest.getField("identifier").setText("1");
		echoRequest.getField("sequenceNumber").setText("2");
		
//		IValueDumper.INSTANCE.dump(etherPrtl);
//		System.out.println(etherPrtl);

		//assignValue
		IRecordSetValue newEtherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
		((PValue)newEtherPrtl).assignPValue((PValue)etherPrtl);
//		IValueDumper.INSTANCE.dump(newEtherPrtl);
//		System.out.println(newEtherPrtl);
		
		//check equals for assign
		IRecordSetValue newIpv4Prtl = (IRecordSetValue)newEtherPrtl.findField("payload/ipv4");
		assertNotNull(newIpv4Prtl);
		IUnionValue newIcmpv4Prtl = (IUnionValue)newIpv4Prtl.findField("payload/icmpv4");
		assertNotNull(newIcmpv4Prtl);
		
		assertTrue(newEtherPrtl != etherPrtl);
		assertTrue(newIpv4Prtl != ipv4Prtl);
		IValue icmpv4Prtl = etherPrtl.findField("payload/ipv4/payload/icmpv4");
		assertNotNull(icmpv4Prtl);
		assertTrue(newIcmpv4Prtl != icmpv4Prtl);
		assertEquals(icmpv4Prtl, newIcmpv4Prtl);
		assertEquals(ipv4Prtl, newIpv4Prtl);
		assertEquals(etherPrtl, newEtherPrtl);
		
		//check not equals for change
		IRecordSetValue newEchoRequest = (IRecordSetValue)newIcmpv4Prtl.getPresentVariant();
		newEchoRequest.getField("identifier").setText("99");
		assertFalse(icmpv4Prtl.equals(newIcmpv4Prtl));
		assertFalse(ipv4Prtl.equals(newIpv4Prtl));
		assertFalse(etherPrtl.equals(newEtherPrtl));
	}
	
	public void testIcmpv4Protocol() throws Exception {
		IModule etherModule = IModuleRegistry.INSTANCE.resolveModule("EtherProtocol");
		IType etherPrtlType = etherModule.getType("EtherProtocol");
		IFactory etherFactory = etherModule.getFactory();
		IValue resultValue;
		IRecordSetValue etherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
		etherPrtl.getField("etherType").setText("0x0800");
		etherPrtl.findField("payload/ipv4/header/protocol", true).setText("1");
		etherPrtl.findField("payload/ipv4/payload/icmpv4/echoRequest", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/payload/icmpv4/echoRequest"));

		etherPrtl.findField("payload/ipv4/payload/icmpv4/echoReply", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/payload/icmpv4/echoReply"));

		etherPrtl.findField("payload/ipv4/payload/icmpv4/infoRequest", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/payload/icmpv4/infoRequest"));

		etherPrtl.findField("payload/ipv4/payload/icmpv4/infoReply", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/payload/icmpv4/infoReply"));

		etherPrtl.findField("payload/ipv4/payload/icmpv4/tsRequest", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/payload/icmpv4/tsRequest"));

		etherPrtl.findField("payload/ipv4/payload/icmpv4/tsReply", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/payload/icmpv4/tsReply"));
	}
	
	public void testIpv4Protocol() throws Exception {
		IModule etherModule = IModuleRegistry.INSTANCE.resolveModule("EtherProtocol");
		IType etherPrtlType = etherModule.getType("EtherProtocol");
		IFactory etherFactory = etherModule.getFactory();
		IModule ipv4Module = IModuleRegistry.INSTANCE.resolveModule("Ipv4Protocol");
		IFactory ipv4Factory = ipv4Module.getFactory();
		IValue resultValue;
		IRecordSetValue etherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
		etherPrtl.getField("etherType").setText("0x0800");
		etherPrtl.findField("payload/ipv4/header/protocol", true).setText("0");//无效协议
		//option
		etherPrtl.findField("payload/ipv4/header/options[0]/security", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/header/options[0]/security"));
		
		etherPrtl.findField("payload/ipv4/header/options[1]/lssr", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/header/options[1]/lssr"));

		etherPrtl.findField("payload/ipv4/header/options[2]/ssrr", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/header/options[2]/ssrr"));
		
		etherPrtl.findField("payload/ipv4/header/options[3]/rr", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/header/options[3]/rr"));
		
		etherPrtl.findField("payload/ipv4/header/options[4]/streamid", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/header/options[4]/streamid"));
		
		etherPrtl.findField("payload/ipv4/header/options[5]/timestamp", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/header/options[5]/timestamp"));
		
		etherPrtl.findField("payload/ipv4/header/options[6]/routerAlert", true);
		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
		assertNotNull(resultValue.findField("payload/ipv4/header/options[6]/routerAlert"));
		
//		IBitstringValue lastOption;
//		lastOption = ((IBitstringValue)etherPrtl.findField(
//				"payload/ipv4/header/options[7]/last", true));
//		resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
//		assertNotNull(resultValue.findField("payload/ipv4/header/options[7]/last"));
		
		IValue orgValue = ipv4Factory.createValue("SsrrOption");
		checkEncodeAndDecode(orgValue, ipv4Module.getType("SsrrOption"));
	}
	
	//测试协议循环嵌套，ether/ipv4/ipv6/ipv4
	public void testIpv4Ipv6Stack() throws Exception {
        IModule etherModule = IModuleRegistry.INSTANCE.resolveModule("EtherProtocol");
        IType etherPrtlType = etherModule.getType("EtherProtocol");
        IFactory etherFactory = etherModule.getFactory();
        IRecordSetValue etherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
        etherPrtl.getField("etherType").setText("0x0800");
        etherPrtl.findField("payload/ipv4/header/protocol", true).setText("41");//IPv6
        etherPrtl.findField("payload/ipv4/payload/ipv6/payload/ipv6Data/ipv4", true);
        etherPrtl.findField("payload/ipv4/payload/ipv6/header/nextHeader").setText("4");//IPv4
        etherPrtl.findField("payload/ipv4/payload/ipv6/payload/ipv6Data/ipv4/payload/data", 
                true).setText("AABBCC");

        IValue resultValue = checkEncodeAndDecode(etherPrtl, etherPrtlType);
        resultValue.findField("payload/ipv4/header/hcs").setText("0000");
        resultValue.findField("payload/ipv4/payload/ipv6/payload/ipv6Data/ipv4/header/hcs")
                .setText("0000");
        assertEquals(etherPrtl, resultValue);
        
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
	
    private IRecordSetValue createIcmpv4Packet() throws MetaException {
        IRecordSetValue etherPrtl;
        etherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
        etherPrtl.getField("dstAddress").setTextAs("ff:ff:ff:ff:ff:ff", IValueTextStyle.MAC_ADDRESS);
        etherPrtl.getField("srcAddress").setTextAs("00:16:cf:2d:ce:e4", IValueTextStyle.MAC_ADDRESS);
        etherPrtl.getField("etherType").setText("0x0800");
        
        IRecordSetValue ipv4Prtl = (IRecordSetValue)etherPrtl.findField("payload/ipv4", true);
        IRecordSetValue header = (IRecordSetValue)ipv4Prtl.getField("header");
        header.getField("identification").setText("1");
        header.getField("timeToLive").setText("255");
        header.getField("protocol").setText("1");
        header.getField("sourceAddress").setTextAs("192.168.11.4", IValueTextStyle.IPV4_ADDRESS);
        header.getField("destinationAddress").setTextAs("192.168.11.5", IValueTextStyle.IPV4_ADDRESS);
        
        IRecordSetValue echoRequest = (IRecordSetValue)ipv4Prtl.findField(
                "payload/icmpv4/echoRequest", true);
        echoRequest.getField("identifier").setText("1");
        echoRequest.getField("sequenceNumber").setText("2");
        return etherPrtl;
    }
    
}
