package fpbprotocoltest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fineqt.fpb.lib.api.module.IConstant;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.util.IValueDumper;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;
import com.fineqt.fpb.protocol.ProtocolUtils;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;

public class SimDataUtils {
	private static IValueSerializer ser = IValueSerializer.INSTANCE;
	
	public static void saveSimRecordListToFile(String moduleName, String constName, String fileName) 
	throws EncodeException, IOException {
		byte[] data;
		TextBitset bitset;
	    @SuppressWarnings("unchecked")
		IListValue<IRecordSetValue> recList = getConstValue(moduleName,
				constName);
	    assert recList != null;
//	    System.out.println(recList);
	    saveConstValue(fileName, recList);
	}

	public static void saveConstValue(String fileName,
			IListValue<IRecordSetValue> recList) throws EncodeException,
			FileNotFoundException, IOException {
		byte[] data;
		TextBitset bitset;
		//encode
		ser.calculate(recList);
		data = ser.encode(recList, false);
		bitset = new NativeTextBitset(data);
		System.out.println(bitset.get(TextBitset.HEX));

		FileOutputStream ost = new FileOutputStream(new File(fileName));
		try {
			ost.write(bitset.getRaw());
		} finally {
			ost.close();
		}
	}

	public static IListValue<IRecordSetValue> getConstValue(String moduleName,
			String constName) {
		IModule simModule = IModuleRegistry.INSTANCE.resolveModule(moduleName);
	    assert simModule != null; 
		//recList
	    IConstant cstRecList = simModule.getConstant(constName);
	    assert cstRecList != null;
	    @SuppressWarnings("unchecked")
	    IListValue<IRecordSetValue> recList = (IListValue<IRecordSetValue>)cstRecList.getValue();
		return recList;
	}
	
	public static IListValue<IRecordSetValue> loadSimRecordListFromFile(
			String moduleName, String typeName, String fileName) 
	throws DecodeException, IOException {
		byte[] buf = new byte[1024];
	    IModule simModule = IModuleRegistry.INSTANCE.resolveModule(moduleName);
	    assert simModule != null;
	    FileInputStream ist = new FileInputStream(new File(fileName));
	    ByteArrayBuffer bytesBuf = new ByteArrayBuffer();
	    try {
	    	int len = ist.read(buf);
	    	while (len > 0) {
	    		bytesBuf.write(buf, 0, len);
	    		len = ist.read(buf);
	    	}
	    } finally {
	    	ist.close();
	    }
		//decode
	    @SuppressWarnings("unchecked")
		IListValue<IRecordSetValue> newRecList = (IListValue<IRecordSetValue>)ProtocolUtils.decode(
				bytesBuf.getRawData(), simModule.getType(typeName));
		IValueDumper.INSTANCE.dump(newRecList);
		return newRecList;
	}

}
