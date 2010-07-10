package fpbtest;

import com.fineqt.fpb.lib.api.util.IFpbSystem;

import junit.framework.Test;
import junit.framework.TestSuite;

public class FpbTest {
	static final boolean DEBUG = true;
	
	static {
		try {
			long start = System.currentTimeMillis();
			FpbTestUtil.init();
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
		
//		suite.addTest(new TestSuite(PcapSocketImplTest2.class));//没完成

//		suite.addTest(new TestSuite(TextBitsetTest.class));
//		suite.addTest(new TestSuite(PcapSocketImplTest.class));
//		suite.addTest(new TestSuite(BitBufferTest.class));
//		suite.addTest(new TestSuite(BuiltintestModuleTest.class));
//		suite.addTest(new TestSuite(ValueTest.class));
//		suite.addTest(new TestSuite(ConstraintTest.class));
//		suite.addTest(new TestSuite(PModuleExtRegistryTest.class));
//		suite.addTest(new TestSuite(ContextTest.class));
//		suite.addTest(new TestSuite(SerializerTest.class));
//		suite.addTest(new TestSuite(FlagFieldTest.class));
//		suite.addTest(new TestSuite(CompacttestModuleTest.class));
//		suite.addTest(new TestSuite(TemplateTest.class)); 
//		suite.addTest(new TestSuite(ElementExtFactoryTest.class));
		suite.addTest(new TestSuite(LanguageTest.class));
//	    suite.addTest(new TestSuite(SerializerTest2.class));
//		suite.addTest(new TestSuite(TutorialTest.class));
		
//		suite.addTest(new TestSuite(GrammerTest.class));
		
//		suite.addTest(new TestSuite(PerformanceTest.class));
		
//		suite.addTest(new TestSuite(DumperTest.class));
		return suite;
	}
}
