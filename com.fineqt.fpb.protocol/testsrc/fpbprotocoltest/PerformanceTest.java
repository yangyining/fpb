package fpbprotocoltest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.api.value.IPath;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.api.value.IValueTextStyle;
import com.fineqt.fpb.protocol.ProtocolUtils;

public class PerformanceTest extends TestCase {
	private static IValueSerializer ser = IValueSerializer.INSTANCE;
	
	public void testICMPEncodeDecode() throws Exception {
		IModule etherModule = IModuleRegistry.INSTANCE.resolveModule("EtherProtocol");
		IFactory etherFactory = etherModule.getFactory();
		long start;
		int cnt = 10000 * 1;
		
		//确保以前的孤立对象都被回收
		gc();
		
		start = System.currentTimeMillis();
		//Ethernet/Ipv4/Icmpv4/
		encodeDecodeIcmpv4_1(etherModule, etherFactory, cnt);
		System.out.println("encodeDecodeIcmpv4_1 spend:"+(System.currentTimeMillis()-start));

		//确保以前的孤立对象都被回收
		gc();
		
		start = System.currentTimeMillis();
		//Ethernet/Ipv4/Icmpv4/
		encodeDecodeIcmpv4_2(etherModule, etherFactory, cnt);
		System.out.println("encodeDecodeIcmpv4_2 spend:"+(System.currentTimeMillis()-start));

		//确保以前的孤立对象都被回收
		gc();
		
		start = System.currentTimeMillis();
		//Ethernet/Ipv4/Icmpv4/
		decodeIcmpv4_1(etherModule, etherFactory, cnt);
		System.out.println("decodeIcmpv4_1 spend:"+(System.currentTimeMillis()-start));

		//确保以前的孤立对象都被回收
		gc();
	}

	private void gc() throws InterruptedException {
		System.gc();
		Thread.sleep(500);
		System.gc();
		Thread.sleep(500);
	}

	private void encodeDecodeIcmpv4_1(IModule etherModule, IFactory etherFactory, int cnt)
			throws Exception {
		IRecordSetValue etherPrtl;
		IRecordSetValue newEtherPrtl;
		byte[] data;
		for (int i = 0; i < cnt; i++) {
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
			echoRequest.getField("data", true).setText("01020304050607080910111213141516171819");
			
			ser.calculate(etherPrtl);
	//		IValueDumper.INSTANCE.dump(etherPrtl);
	
			//encode
			data = ser.encode(etherPrtl, false);
			
			//decode
			newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, 
					etherModule.getType("EtherProtocol"));
	//		IValueDumper.INSTANCE.dump(newEtherPrtl);
			assertNotNull(newEtherPrtl);
		}
	}

	private void encodeDecodeIcmpv4_2(IModule etherModule, IFactory etherFactory, int cnt)
	throws Exception {
		IRecordSetValue etherPrtl;
		IRecordSetValue newEtherPrtl;
		IType etherPrtlType = etherModule.getType("EtherProtocol");
		byte[] payloadData = new byte[] {
			0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09,
			0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19
		};
		IPath path1 = etherPrtlType.createPath("payload/ipv4");
		IType ipv4PrtlType = path1.getRefFieldType();
		IPath path2 =  ipv4PrtlType.createPath("payload/icmpv4/echoRequest");
			
		
		byte[] data;
		for (int i = 0; i < cnt; i++) {
			etherPrtl = (IRecordSetValue)etherFactory.createValue("EtherProtocol");
			etherPrtl.getField("dstAddress").setTextAs("ff:ff:ff:ff:ff:ff", IValueTextStyle.MAC_ADDRESS);
			etherPrtl.getField("srcAddress").setTextAs("00:16:cf:2d:ce:e4", IValueTextStyle.MAC_ADDRESS);
			((IIntegerValue)etherPrtl.getField("etherType")).setInteger(0x0800);
			
			IRecordSetValue ipv4Prtl = (IRecordSetValue)etherPrtl.findField(path1, true);
			IRecordSetValue header = (IRecordSetValue)ipv4Prtl.getField("header");
			((IIntegerValue)header.getField("identification")).setInteger(1);
			((IIntegerValue)header.getField("timeToLive")).setInteger(255);
			((IIntegerValue)header.getField("protocol")).setInteger(1);
			header.getField("sourceAddress").setTextAs("192.168.11.4", IValueTextStyle.IPV4_ADDRESS);
			header.getField("destinationAddress").setTextAs("192.168.11.5", IValueTextStyle.IPV4_ADDRESS);
			
			IRecordSetValue echoRequest = (IRecordSetValue)ipv4Prtl.findField(
					path2, true);
			((IIntegerValue)echoRequest.getField("identifier")).setInteger(1);
			((IIntegerValue)echoRequest.getField("sequenceNumber")).setInteger(2);
			((IOctetstringValue)echoRequest.getField("data", true)).setValue(payloadData);
			
			ser.calculate(etherPrtl);
//			IValueDumper.INSTANCE.dump(etherPrtl);
		
			//encode
			data = ser.encode(etherPrtl, false);
			
			//decode
			newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, 
					etherModule.getType("EtherProtocol"));
//			IValueDumper.INSTANCE.dump(newEtherPrtl);
			assertNotNull(newEtherPrtl);
		}
	}
	
	private void decodeIcmpv4_1(IModule etherModule, IFactory etherFactory, int cnt)
	throws Exception {
		IRecordSetValue etherPrtl;
		IRecordSetValue newEtherPrtl;
		byte[] data;
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
		echoRequest.getField("data", true).setText("01020304050607080910111213141516171819");
		
		ser.calculate(etherPrtl);
	//		IValueDumper.INSTANCE.dump(etherPrtl);
	
		//encode
		data = ser.encode(etherPrtl, false);
		
		for (int i = 0; i < cnt; i++) {
			//decode
			newEtherPrtl = (IRecordSetValue)ProtocolUtils.decode(data, 
					etherModule.getType("EtherProtocol"));
//			IValueDumper.INSTANCE.dump(newEtherPrtl);
			assertNotNull(newEtherPrtl);
		}
	}

}
