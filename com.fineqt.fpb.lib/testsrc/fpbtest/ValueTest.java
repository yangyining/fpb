package fpbtest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.value.IEnumeratedValue;
import com.fineqt.fpb.lib.builtin.BuiltinFactory;
import com.fineqt.fpb.lib.builtin.PBitstringValue;
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.builtin.PHexstringValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;
import com.fineqt.fpb.lib.util.TextBitset;

import fpbtest.module.builtintest.BuiltintestFactory;
import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.EnumRefRecord;

public class ValueTest extends TestCase {
	static BuiltinFactory builtinFactory = BuiltinFactory.BUILTIN_INSTANCE;
	
	public void testCharstringValue() {
		PCharstringValue value = (PCharstringValue)builtinFactory.createCharstring();
		assertFalse(value.notPresent());
		assertEquals("\"\"", value.getString());
		//保留原来的数据
		value.setLength(2);
		assertEquals(2, value.getLength());
		value.setChar(0, 'a');
		value.setChar(1, 'b');
		assertEquals("ab", new String(value.getValue()));
		value.setLength(3);
		assertEquals(3, value.getLength());
		assertEquals('a', value.getChar(0));
		assertEquals('b', value.getChar(1));
		value.setLength(1);
		assertEquals(1, value.getLength());
		assertEquals('a', value.getChar(0));
		//setString
		value.setString("\"ab\"\"c\"");
		assertEquals("ab\"c", new String(value.getValue()));
		assertEquals("\"ab\"\"c\"", value.getString());
		
		try {
			value.setString("\"ab\"c\"");
			fail();
		} catch (IllegalLiteralFormatException e) {
		}
		//clone
		PCharstringValue newValue = (PCharstringValue)value.clone();
		assertEquals("\"ab\"\"c\"", newValue.getString());
		assertEquals(value, newValue);
	}
	
	public void testBitstringValue() {
		PBitstringValue value = (PBitstringValue)builtinFactory.createBitstring();
		assertFalse(value.notPresent());
		assertEquals(value.getString(), "''B");
		//保留原来的数据
		value.setLength(2);
		assertEquals(2, value.getLength());
		value.setBit(0, 0);
		value.setBit(1, 1);
		assertEquals("01", value.getValue().get(TextBitset.BIN));
		value.setLength(3);
		assertEquals(3, value.getLength());
		assertEquals(0, value.getBit(0));
		assertEquals(1, value.getBit(1));
		value.setLength(1);
		assertEquals(1, value.getLength());
		assertEquals(0, value.getBit(0));
		//setString
		value.setString("'101'B");
		assertEquals("101", value.getValue().get(TextBitset.BIN));
		assertEquals("'101'B", value.getString());
		
		try {
			value.setString("'1x1'B");
			fail();
		} catch (IllegalLiteralFormatException e) {
		}
		//clone
		PBitstringValue newValue = (PBitstringValue)value.clone();
		assertEquals("'101'B", newValue.getString());
		assertEquals(value, newValue);
	}
	
	public void testHexstringValue() {
		PHexstringValue value = (PHexstringValue)builtinFactory.createHexstring();
		assertFalse(value.notPresent());
		assertEquals(value.getString(), "''H");
		//保留原来的数据
		value.setLength(2);
		assertEquals(2, value.getLength());
		value.setHex(0, 5);
		value.setHex(1, 0xA);
		assertEquals(5, value.getHex(0));
		assertEquals(0xA, value.getHex(1));
		value.setLength(3);
		assertEquals(3, value.getLength());
		assertEquals(5, value.getHex(0));
		assertEquals(0xA, value.getHex(1));
		value.setLength(1);
		assertEquals(1, value.getLength());
		assertEquals(5, value.getHex(0));
		//setString
		value.setString("'5AF'H");
		assertEquals(5, value.getHex(0));
		assertEquals(0xA, value.getHex(1));
		assertEquals(0xF, value.getHex(2));
		assertEquals("'5AF'H", value.getString());
		try {
			value.setString("'Fx5'H");
			fail();
		} catch (IllegalLiteralFormatException e) {
		}
		//clone
		PHexstringValue newValue = (PHexstringValue)value.clone();
		assertEquals("'5AF'H", newValue.getString());
		assertEquals(value, newValue);
	}

	public void testOctetstringValue() {
		POctetstringValue value = (POctetstringValue)builtinFactory.createOctetstring();
		assertFalse(value.notPresent());
		assertEquals(value.getString(), "''O");
		//保留原来的数据
		value.setLength(2);
		assertEquals(2, value.getLength());
		value.setOctet(0, 5);
		value.setOctet(1, 0xFA);
		assertEquals(5, value.getOctet(0));
		assertEquals(0xFA, value.getOctet(1));
		value.setLength(3);
		assertEquals(3, value.getLength());
		assertEquals(5, value.getOctet(0));
		assertEquals(0xFA, value.getOctet(1));
		value.setLength(1);
		assertEquals(1, value.getLength());
		assertEquals(5, value.getOctet(0));
		//setString
		value.setString("'05FABC'O");
		assertEquals(5, value.getOctet(0));
		assertEquals(0xFA, value.getOctet(1));
		assertEquals(0xBC, value.getOctet(2));
		assertEquals("'05FABC'O", value.getString());
		try {
			value.setString("'0Fx5'O");
			fail();
		} catch (IllegalLiteralFormatException e) {
		}
		//clone
		POctetstringValue newValue = (POctetstringValue)value.clone();
		assertEquals("'05FABC'O", newValue.getString());
		assertEquals(value, newValue);
	}
	
	public void testEnumValue() {
//		System.out.println(BuiltintestModule.INSTANCE);
		//FieldName
		IEnumeratedValue value = BuiltintestFactory.INSTANCE.createFieldName();
		assertFalse(value.notPresent());
		assertEquals(BuiltintestModule.FIELD_NAME__FIELD1, value.getEnumID());
		assertEquals(BuiltintestModule.Names.FIELD_NAME__FIELD1, value.getEnumName());
		assertEquals(10, value.getEnumValue());
		
		value.setEnumByID(BuiltintestModule.FIELD_NAME__FIELD2);
		assertEquals(BuiltintestModule.FIELD_NAME__FIELD2, value.getEnumID());
		assertEquals(BuiltintestModule.Names.FIELD_NAME__FIELD2, value.getEnumName());
		assertEquals(20, value.getEnumValue());
		
		value.setEnumByName(BuiltintestModule.Names.FIELD_NAME__FIELD1);
		assertEquals(BuiltintestModule.FIELD_NAME__FIELD1, value.getEnumID());
		assertEquals(BuiltintestModule.Names.FIELD_NAME__FIELD1, value.getEnumName());
		assertEquals(10, value.getEnumValue());
		
		//EnumRefRecord
		EnumRefRecord refRecord = BuiltintestFactory.INSTANCE.createEnumRefRecord();
		IEnumeratedValue fieldName = refRecord.getFieldName();
		assertFalse(fieldName.notPresent());
		assertEquals(BuiltintestModule.FIELD_NAME__FIELD2, fieldName.getEnumID());
		assertEquals(BuiltintestModule.Names.FIELD_NAME__FIELD2, fieldName.getEnumName());
		assertEquals(20, fieldName.getEnumValue());
		assertTrue(refRecord.getField1().notPresent());
		assertTrue(refRecord.getField2().notPresent());
	}
	
	public void testCreateDerivedTypeValue() {
		//sub type
		PIntegerValue uint16 = (PIntegerValue)BuiltintestFactory.INSTANCE.createUINT16();
		assertEquals("builtintest.UINT16", uint16.pTypeMeta().getFullName());
		assertEquals("builtin.integer", uint16.pTypeMeta().getSuperType().getFullName());
		//import type
		PIntegerValue biltinInt = (PIntegerValue)BuiltintestFactory.INSTANCE.createInteger();
		assertEquals("builtin.integer", biltinInt.pTypeMeta().getFullName());
		assertEquals("builtin.integer", biltinInt.pTypeMeta().getSuperType().getFullName());
	}
	
}
