package fpbprotocoltest;

import java.net.SocketException;

import com.fineqt.fpb.lib.api.comm.pcap.NetworkInterface;
import com.fineqt.fpb.lib.api.util.IFpbSystem;
import com.fineqt.fpb.lib.comm.pcap.PcapSocketImpl;

public class FpbProtocolTestUtil {
	static {
		if (isWindows()) {
			WORKSPACE_PATH = "D:/work/scalaws/";
		} else {
			WORKSPACE_PATH = "/home/jm/linuxws/";
		}
	}
	public final static String WORKSPACE_PATH;
	public final static String PBUILDER_LIB_PROJECT_PATH = WORKSPACE_PATH + "com.fineqt.fpb.lib/";
	public final static String PROTOCOL_PROJECT_PATH = "com.fineqt.fpb.protocol/";
	public final static String TEST_PROTOCOL_PATH = WORKSPACE_PATH + 
			PROTOCOL_PROJECT_PATH + "protocol/";
	
	public static boolean isWindows() {
		String osName = System.getProperty("os.name").toLowerCase();
		return osName.contains("windows");
	}

	public static void init() throws Exception {
		IFpbSystem.INSTANCE.init(PBUILDER_LIB_PROJECT_PATH, TEST_PROTOCOL_PATH);
	}
	
	static NetworkInterface[] ifs;
	
	final static int INTERFACE_INDEX = 1;
	
	public static NetworkInterface getInterface() throws SocketException {
		if (ifs == null) {
			ifs = PcapSocketImpl.getDeviceList();
		}
		return ifs[INTERFACE_INDEX];
	}
	
}
