package fpbprotocoltest;

import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.value.IBitstringValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;

import junit.framework.TestCase;

public class CommonProtocolsTest extends TestCase {
	public void testBasicTypeAndValues() throws Exception {
		IModule module = IModuleRegistry.INSTANCE.resolveModule("BasicTypeAndValues");
		IFactory factory = module.getFactory();
		IIntegerValue intValue;
//		System.out.println(module);
		//Unsigned Integer
		assertEquals("1", module.getConstant("c_uInt1Max").getValue().getText());
		assertEquals("65535", module.getConstant("c_uInt16Max").getValue().getText());
		assertEquals("18446744073709551615", module.getConstant("c_uInt64Max").getValue().getText());
		assertNotNull(module.getType("UInt"));
		assertNotNull(module.getType("UInt1"));
		intValue = (IIntegerValue)factory.createValue("UInt1");
		assertEquals(0, intValue.getInteger());
		assertTrue(intValue.validate(null));
		intValue.setInteger(2);
		assertFalse(intValue.validate(null));
		assertNotNull(module.getType("UInt64"));
		
		//Singend Integer
		assertEquals("-1", module.getConstant("c_int1Min").getValue().getText());
		assertEquals("0", module.getConstant("c_int1Max").getValue().getText());
		assertEquals("-2147483648", module.getConstant("c_int32Min").getValue().getText());
		assertEquals("2147483647", module.getConstant("c_int32Max").getValue().getText());
		intValue = (IIntegerValue)factory.createValue("Int1");
		assertEquals(0, intValue.getInteger());
		assertTrue(intValue.validate(null));
		intValue.setInteger(2);
		assertFalse(intValue.validate(null));
		assertNotNull(module.getType("Int32"));

		//bitstring
		IBitstringValue bstrValue = (IBitstringValue)factory.createValue("Bit1");
		assertNotNull(bstrValue);
		assertEquals(1, bstrValue.getLength());
		assertEquals("0", bstrValue.getText());
		assertTrue(bstrValue.validate(null));
		bstrValue.setLength(2);
		assertEquals("00", bstrValue.getText());
		assertFalse(bstrValue.validate(null));
		
		bstrValue = (IBitstringValue)factory.createValue("Bit128");
		assertNotNull(bstrValue);
		assertEquals(128, bstrValue.getLength());
		
		//octstring
		IOctetstringValue ostrValue = (IOctetstringValue)factory.createValue("Oct1");
		assertNotNull(ostrValue);
		assertEquals(1, ostrValue.getLength());
		assertEquals("00", ostrValue.getText());
		assertTrue(ostrValue.validate(null));
		ostrValue.setLength(2);
		assertEquals(2, ostrValue.getLength());
		assertEquals("0000", ostrValue.getText());
		assertFalse(ostrValue.validate(null));
		
		ostrValue = (IOctetstringValue)factory.createValue("Oct24");
		assertNotNull(ostrValue);
		assertEquals(24, ostrValue.getLength());
		
		ostrValue = (IOctetstringValue)factory.createValue("Oct0to255");
		assertNotNull(ostrValue);
		assertEquals(0, ostrValue.getLength());
		assertTrue(ostrValue.validate(null));
		ostrValue.setLength(256);
		assertFalse(ostrValue.validate(null));
	}
	
	public void testGlobalEnumSets() throws Exception {
		IModule module = IModuleRegistry.INSTANCE.resolveModule("GlobalEnumSets");
		assertNotNull(module);
//		System.out.println(module);
//		IFactory factory = module.getFactory();
		
	}
}
