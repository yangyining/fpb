package fpbtest;

import java.net.SocketException;

import com.fineqt.fpb.lib.api.comm.pcap.NetworkInterface;
import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.IFpbSystem;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.util.buffer.IEnsurableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IWritableBitBuffer;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.comm.pcap.PcapSocketImpl;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DebugDecodeContext;
import com.fineqt.fpb.lib.system.FpbSystemImpl;
import com.fineqt.fpb.lib.type.impl.SimpleFpbTypeEVExtFactory;

public class FpbTestUtil {
	static {
		if (isWindows()) {
			WORKSPACE_PATH = "D:/work/scalaws/";
		} else {
			WORKSPACE_PATH = "/home/jm/linuxws/";
		}
	}
	public final static String WORKSPACE_PATH;
	public final static String PBUILDER_LIB_PROJECT_PATH = WORKSPACE_PATH + "com.fineqt.fpb.lib/";

	public final static String TEST_PROTOCOL_PATH = PBUILDER_LIB_PROJECT_PATH + "test/protocol/";
	
	public static boolean isWindows() {
		String osName = System.getProperty("os.name").toLowerCase();
		return osName.contains("windows");
	}

	public static void init() throws Exception {
		IFpbSystem.INSTANCE.init(PBUILDER_LIB_PROJECT_PATH, null);
		PModuleExt.Registry.PINSTANCE.registerTypeEVExtFactory(
				new SimpleFpbTypeEVExtFactory());
		PModuleExt.Registry.PINSTANCE.register(new FpbSystemImpl.FileModuleProxy(
				FpbTestUtil.TEST_PROTOCOL_PATH + "compacttest.module"));
		PModuleExt.Registry.PINSTANCE.register(new FpbSystemImpl.FileModuleProxy(
				FpbTestUtil.TEST_PROTOCOL_PATH + "builtintest.module"));
		PModuleExt.Registry.PINSTANCE.register(new FpbSystemImpl.FileModuleProxy(
				FpbTestUtil.TEST_PROTOCOL_PATH + "langtest1.module"));
		PModuleExt.Registry.PINSTANCE.register(new FpbSystemImpl.FileModuleProxy(
				FpbTestUtil.TEST_PROTOCOL_PATH + "langtest2.module"));
		PModuleExt.Registry.PINSTANCE.register(new FpbSystemImpl.FileModuleProxy(
				FpbTestUtil.TEST_PROTOCOL_PATH + "langtest3.module"));
        PModuleExt.Registry.PINSTANCE.register(new FpbSystemImpl.FileModuleProxy(
                FpbTestUtil.TEST_PROTOCOL_PATH + "langtest4.module"));
        PModuleExt.Registry.PINSTANCE.register(new FpbSystemImpl.FileModuleProxy(
                FpbTestUtil.TEST_PROTOCOL_PATH + "langtest5.module"));
        PModuleExt.Registry.PINSTANCE.register(new FpbSystemImpl.FileModuleProxy(
                FpbTestUtil.TEST_PROTOCOL_PATH + "builtintest2.module"));
        PModuleExt.Registry.PINSTANCE.register(new FpbSystemImpl.FileModuleProxy(
                FpbTestUtil.TEST_PROTOCOL_PATH + "tutorial.module"));
	}
	
	static NetworkInterface[] ifs;
	
	final static int INTERFACE_INDEX = 1;
	
	public static NetworkInterface getInterface() throws SocketException {
		if (ifs == null) {
			ifs = PcapSocketImpl.getDeviceList();
		}
		return ifs[INTERFACE_INDEX];
	}
	
    private static IValueSerializer ser = IValueSerializer.INSTANCE;
	
    public static IValue decode(byte[] data, IType hypType) throws DecodeException {
        try {
            return ser.decode(data, hypType);
        } catch (DecodeException e) {
            logDecodeException(e);
            throw e;
        }
    }

    public static IValue decode(byte[] data, int offset, int len, IType hypType) 
    throws DecodeException {
        try {
            return ser.decode(data, offset, len, hypType);
        } catch (DecodeException e) {
            logDecodeException(e);
            throw e;
        }
    }

    public static IValue incrementDecode(IEnsurableBitBuffer buffer, IType hypType) 
    throws DecodeException {
        try {
            return ser.incrementDecode(buffer, hypType);
        } catch (DecodeException e) {
            logDecodeException(e);
            throw e;
        }
    }
    
    private static void logDecodeException(DecodeException e) {
        if (IFpbSystem.INSTANCE.isDebug()) {
            DebugDecodeContext dcxt = (DebugDecodeContext)e.getDecodeContext();
            for (int i = 0; i < dcxt.getNotChainedResults().size(); i++) {
                System.out.println("NotChainedResults["+i+"]:"+dcxt.getNotChainedResults().get(i));
            }
            for (int i = 0; i < dcxt.getAllResults().size(); i++) {
                System.out.println("AllResults["+i+"]:"+dcxt.getAllResults().get(i));
            }
            System.out.println("DebugDecodeContext:"+dcxt);
        }
    }
	
    public static class IncrementPutDataJob implements Runnable {
        private int multi = 3;
        private byte[] bytesToPut;
        private IWritableBitBuffer writeBuf;
        
        public IncrementPutDataJob(byte[] bytesToPut, IWritableBitBuffer writeBuf) {
            this.bytesToPut = bytesToPut;
            this.writeBuf = writeBuf;
        }

        @Override
        public void run() {
            try {
                int i = 0;
                for (; i < bytesToPut.length / multi; i++) {
                    int offset = i * multi;
                    //一个字节
                    writeBuf.putByte(bytesToPut[offset]);
                    //两个字节
                    writeBuf.putByte(bytesToPut, offset + 1, 2);
                    Thread.sleep(3);
                }
                if ( i * multi < bytesToPut.length) {
                    writeBuf.putByte(bytesToPut, i * multi, bytesToPut.length - i * multi);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
    
    
}
