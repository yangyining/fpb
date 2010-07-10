package fpbprotocoltest;

import java.math.BigDecimal;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.fineqt.fpb.lib.api.util.IFpbSystem;

public class FpbProtocolTest {
	static final boolean DEBUG = true;
	
	static {
		try {
			long start = System.currentTimeMillis();
			FpbProtocolTestUtil.init();
			System.out.println("init spend:"+(System.currentTimeMillis()-start));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[] args) {
        junit.textui.TestRunner.run (suite());

	}

	public static Test suite() {
		TestSuite suite= new TestSuite("All JUnit Tests");
		IFpbSystem.INSTANCE.setDebug(DEBUG);

		suite.addTest(new TestSuite(CommonProtocolsTest.class));
		suite.addTest(new TestSuite(Ipv4ProtocolsTest.class));
		suite.addTest(new TestSuite(Ipv6ProtocolTest.class));
		suite.addTest(new TestSuite(UdpProtocolTest.class));
		suite.addTest(new TestSuite(TcpProtocolTest.class));
        suite.addTest(new TestSuite(HttpProtocolTest.class));
        suite.addTest(new TestSuite(SampleTest.class));

//		suite.addTest(new TestSuite(PerformanceTest.class));
		return suite;
	}
	
}
