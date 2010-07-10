package fpbtest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.builtin.PHexstringValue;
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.meta.util.PValueDumper;
import com.fineqt.fpb.lib.meta.util.PValueSerializer;
import com.fineqt.fpb.lib.value.PValue;

import fpbtest.module.builtintest.BuiltintestFactory;
import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.DataLengthHyp;
import fpbtest.module.builtintest.LEndianRecord;
import fpbtest.module.builtintest.Protocol1;
import fpbtest.module.builtintest.Protocol2;

public class DumperTest extends TestCase {
	static PValueSerializer ser = PValueSerializer.PINSTANCE;

	public void testBuiltinCase() throws Exception {
		System.out.println(BuiltintestModule.INSTANCE);		
		BuiltintestFactory factory = BuiltintestFactory.INSTANCE;
		String dumpStr;
		PValueDumper dumper = PValueDumper.PINSTANCE;
		// protocol1/protocol2
		Protocol1 prtl1 = factory.createProtocol1();
		prtl1.getPrefix().setInteger(0x11);
		prtl1.getPrtlcode().setInteger(0x20);
		Protocol2 prtl2 = factory.createProtocol2();
		prtl2.getData().setInteger(11);
		prtl1.getPayload().setField(BuiltintestModule.PAYLOAD1__PRTL2, prtl2);
		dumpStr = dumper.getDumpStr((PValue)prtl1);
		System.out.println(dumpStr);

		// LEndianRecord
		LEndianRecord lerObj = factory.createLEndianRecord();
		lerObj.getInt1().setInteger(0x1);
		lerObj.getFlag().setBoolean(true);
		lerObj.getBits().setText("010");
		lerObj.getInt2().setInteger(0x33);
		lerObj.getInt3().setInteger(0x4455);
		PHexstringValue hexsObj = (PHexstringValue)factory.createHexstring();
		hexsObj.setText("ABCD");
		lerObj.setField(BuiltintestModule.LENDIAN_RECORD__HEXS, hexsObj);
		dumpStr = dumper.getDumpStr((PValue)lerObj);
		System.out.println(dumpStr);
		
		// DataLengthHyp(ext value)
		DataLengthHyp dlhObj = factory.createDataLengthHyp();
		String bitsLiteral = "";
		for (int i = 0; i < 100; i++) {
			bitsLiteral += i % 2 == 0 ? "0" : "1";
		}
		dlhObj.getData1().setText(bitsLiteral);
		POctetstringValue data3 = (POctetstringValue)factory.createOctetstring();
		byte[] bytes = new byte[100];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte)i;
		}
		data3.setValue(bytes);
		dlhObj.setField("data3", data3);
		ser.calculate((PValue)dlhObj);
		dumpStr = dumper.getDumpStr((PValue)dlhObj);
		System.out.println(dumpStr);

		//Primitive Type
		IIntegerValue uint16 = factory.createUINT16();
		uint16.setInteger(100);
		dumpStr = dumper.getDumpStr((PValue)uint16);
		System.out.println(dumpStr);
		
		PCharstringValue strValue = (PCharstringValue)factory.createCharstring();
		strValue.setValue("abcd".toCharArray());
		dumpStr = dumper.getDumpStr(strValue);
		System.out.println(dumpStr);
		
	}
	
}
