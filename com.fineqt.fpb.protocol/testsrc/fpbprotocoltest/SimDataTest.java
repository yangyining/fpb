package fpbprotocoltest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fineqt.fpb.lib.api.module.IConstant;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.util.IValueDumper;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.value.ICharstringValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;
import com.fineqt.fpb.protocol.ProtocolUtils;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import junit.framework.TestCase;
import static fpbprotocoltest.SimDataUtils.*;

public class SimDataTest extends TestCase {
	private static IValueSerializer ser = IValueSerializer.INSTANCE;
	
//	public void _testSimDataJM() throws Exception {
//		byte[] data;
//		TextBitset bitset;
//	    IModule simModule = IModuleRegistry.INSTANCE.resolveModule("SimDataJM");
//	    assertNotNull(simModule);
//	    System.out.println(simModule);
	    
//	    //recValue
//	    IConstant cstRecValue = simModule.getConstant("simRec1");
//	    IRecordSetValue simRec1 = (IRecordSetValue)cstRecValue.getValue();
//	    System.out.println(simRec1);
//	    //encode
//		ser.calculate(simRec1);
//		data = ser.encode(simRec1, false);
//		bitset = new NativeTextBitset(data);
//		System.out.println(bitset.get(TextBitset.HEX));
//		//decode
//	    @SuppressWarnings("unchecked")
//		IRecordSetValue newRec1 = (IRecordSetValue)ProtocolUtils.decode(data, 
//				simModule.getType("SimRecord"));
//		IValueDumper.INSTANCE.dump(newRec1);
	    
//		//recList
//	    IConstant cstRecList = simModule.getConstant("recList");
//	    assertNotNull(cstRecList);
//	    @SuppressWarnings("unchecked")
//	    IListValue<IRecordSetValue> recList = (IListValue<IRecordSetValue>)cstRecList.getValue();
//	    assertNotNull(recList);
////	    System.out.println(recList);
//	    //encode
//		ser.calculate(recList);
//		data = ser.encode(recList, false);
//		bitset = new NativeTextBitset(data);
//		System.out.println(bitset.get(TextBitset.HEX));
//
//		//decode
//	    @SuppressWarnings("unchecked")
//		IListValue<IRecordSetValue> newRecList = (IListValue<IRecordSetValue>)ProtocolUtils.decode(data, 
//				simModule.getType("SimRecordList"));
//		IValueDumper.INSTANCE.dump(newRecList);
		
//	}
	final private static String SIM_FILE = "d:/simDataFile.sim";
	final private static String INPUT_SIM_FILE = "d:/eth_xmit.raw";
	final private static String LN = "\r\n";
	
	public void _testSaveToFile() throws Exception {
		SimDataUtils.saveSimRecordListToFile("SimDataJM", "recList", "simDataFile.sim");
		SimDataUtils.loadSimRecordListFromFile("SimDataJM", "SimRecordList", "simDataFile.sim");
	}

	public void testLoadFromFile() throws Exception {
		SimDataUtils.loadSimRecordListFromFile("SimDataJM", "SimRecordList", INPUT_SIM_FILE);
	}
	
	public void _testLongString() throws Exception {
	    IModule simModule = IModuleRegistry.INSTANCE.resolveModule("SimDataJM");
	    assertNotNull(simModule); 
	    IConstant httpdata = simModule.getConstant("httpdata");
	    ICharstringValue strValue = (ICharstringValue)httpdata.getValue();
	    System.out.println("strValue:"+strValue.getString());
	}
}
