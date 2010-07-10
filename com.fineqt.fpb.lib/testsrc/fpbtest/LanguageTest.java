package fpbtest;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.module.IConstant;
import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.module.IModulePar;
import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.IValueDumper;
import com.fineqt.fpb.lib.api.value.IBitstringValue;
import com.fineqt.fpb.lib.api.value.IBooleanValue;
import com.fineqt.fpb.lib.api.value.ICharstringValue;
import com.fineqt.fpb.lib.api.value.IEnumeratedValue;
import com.fineqt.fpb.lib.api.value.IFloatValue;
import com.fineqt.fpb.lib.api.value.IHexstringValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.api.value.IUnionValue;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.api.value.IVerdictValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.util.ParserException;

public class LanguageTest extends TestCase {
	IValueDumper dumper = IValueDumper.INSTANCE;
	IModule module = PModuleExt.Registry.INSTANCE.resolveModule(
			Langtest1Module.MODULE_NAME);
	IFactory factory = module.getFactory();
	
	public void testValidation() throws Exception {
//		System.out.println(module);
//		DiagnosticChain chain = new SimpleDiagnostic();
		//int
		IIntegerValue intValue = (IIntegerValue)factory.createValue("IntType1");
		assertEquals(0, intValue.getInteger());
		assertTrue(intValue.validate(null));
		intValue.setInteger(501);
		assertTrue(intValue.validate(null));
		intValue.setInteger(301);
		assertFalse(intValue.validate(null));
		
		intValue = (IIntegerValue)factory.createValue("PlusInt");
		assertTrue(intValue.validate(null));
		intValue.setInteger(10);
		assertTrue(intValue.validate(null));
		intValue.setInteger(-10);
		assertFalse(intValue.validate(null));

		intValue = (IIntegerValue)factory.createValue("MinusInt");
		assertTrue(intValue.validate(null));
		intValue.setInteger(-10);
		assertTrue(intValue.validate(null));
		intValue.setInteger(10);
		assertFalse(intValue.validate(null));
		
		//float
		IFloatValue floatValue = (IFloatValue)factory.createValue("FloatType1");
		assertEquals(0.0f, floatValue.getFloat());
		assertTrue(floatValue.validate(null));
		floatValue.setFloat(300.0f);
		assertTrue(floatValue.validate(null));
		floatValue.setFloat(300.9f);
		assertFalse(floatValue.validate(null));
		
		floatValue = (IFloatValue)factory.createValue("PlusFloat");
		assertTrue(floatValue.validate(null));
		floatValue.setFloat(10.0f);
		assertTrue(floatValue.validate(null));
		floatValue.setFloat(-10.0f);
		assertFalse(floatValue.validate(null));
		
		floatValue = (IFloatValue)factory.createValue("MinusFloat");
		assertTrue(floatValue.validate(null));
		floatValue.setFloat(-10.0f);
		assertTrue(floatValue.validate(null));
		floatValue.setFloat(10.0f);
		assertFalse(floatValue.validate(null));
		
		//boolean
		IBooleanValue booleanValue = (IBooleanValue)factory.createValue("BooleanType1");
		assertTrue(booleanValue.getBoolean());
		assertTrue(booleanValue.validate(null));
		booleanValue.setBoolean(false);
		assertFalse(booleanValue.validate(null));
		
		//bitstring
		IBitstringValue bstrValue = (IBitstringValue)factory.createValue("BstrType1");
		assertEquals("", bstrValue.getText());
		assertFalse(bstrValue.validate(null));
		bstrValue.setText("01");
		assertEquals("01", bstrValue.getText());
		assertTrue(bstrValue.validate(null));
		bstrValue.setText("0100");
		assertEquals("0100", bstrValue.getText());
		assertFalse(bstrValue.validate(null));
		
		bstrValue = (IBitstringValue)factory.createValue("BstrType2");
		assertFalse(bstrValue.validate(null));
		bstrValue.setText("01");
		assertTrue(bstrValue.validate(null));
		bstrValue.setText("01000");
		assertTrue(bstrValue.validate(null));
		
		//hexstring
		IHexstringValue hstrValue = (IHexstringValue)factory.createValue("HstrType1");
		assertEquals("", hstrValue.getText());
		assertFalse(hstrValue.validate(null));
		hstrValue.setText("F");
		assertEquals("F", hstrValue.getText());
		assertTrue(hstrValue.validate(null));
		hstrValue.setText("F1");
		assertEquals("F1", hstrValue.getText());
		assertFalse(hstrValue.validate(null));
		
		//octetstring
		IOctetstringValue ostrValue = (IOctetstringValue)factory.createValue("OstrType1");
		assertEquals("", ostrValue.getText());
		assertFalse(ostrValue.validate(null));
		ostrValue.setText("FFFF");
		assertEquals("FFFF", ostrValue.getText());
		assertTrue(ostrValue.validate(null));
		ostrValue.setText("4F");
		assertEquals("4F", ostrValue.getText());
		assertFalse(ostrValue.validate(null));
		
		//verdict
		IVerdictValue verdictValue = (IVerdictValue)factory.createValue("VerdictType1"); 
		assertEquals("none", verdictValue.getText());
		assertFalse(verdictValue.validate(null));
		verdictValue.setText("fail");
		assertEquals("fail", verdictValue.getText());
		assertTrue(verdictValue.validate(null));
		verdictValue.setText("inconc");
		assertEquals("inconc", verdictValue.getText());
		assertFalse(verdictValue.validate(null));
		
		//charstring list
		ICharstringValue cstrValue = (ICharstringValue)factory.createValue("SubStringType1");
		assertEquals("", cstrValue.getText());
		assertFalse(cstrValue.validate(null));
		cstrValue.setText("abc");
		assertTrue(cstrValue.validate(null));
		cstrValue.setText("1234");
		assertFalse(cstrValue.validate(null));
		cstrValue.setText("8");
		assertTrue(cstrValue.validate(null));
		
		//enumerated list
		IEnumeratedValue enumValue = (IEnumeratedValue)factory.createValue("SubEnumType1");
		assertEquals("field1", enumValue.getText());
		assertTrue(enumValue.validate(null));
		enumValue.setText("field3");
		assertFalse(enumValue.validate(null));
		enumValue.setText("field2");
		assertTrue(enumValue.validate(null));
		
		//Record1
		IRecordSetValue recordValue = (IRecordSetValue)factory.createValue("Record1");
		intValue = (IIntegerValue)recordValue.getField("uint4Field");
		assertEquals(0, intValue.getInteger());
		cstrValue = (ICharstringValue)recordValue.getField("tokenField");
		assertEquals(4, cstrValue.getLength());
		booleanValue = (IBooleanValue)recordValue.getField("booleanField");
		assertEquals("true", booleanValue.getText());
		bstrValue = (IBitstringValue)recordValue.getField("bstrField");
		assertEquals("0000", bstrValue.getText());
		hstrValue = (IHexstringValue)recordValue.getField("hstrField");
		assertEquals("00", hstrValue.getText());
		ostrValue = (IOctetstringValue)recordValue.getField("ostrField");
		assertEquals("", ostrValue.getText());
		cstrValue = (ICharstringValue)recordValue.getField("cstrField");
		assertTrue(Arrays.equals(new char[]{0, 0, 0}, cstrValue.getValue()));
		enumValue = (IEnumeratedValue)recordValue.getField("enumField");
		assertEquals("field1", enumValue.getText());
		verdictValue = (IVerdictValue)recordValue.getField("verdictField");
		assertEquals("none", verdictValue.getText());
//		dumper.dump(recordValue);
		//validate fail
		assertFalse(recordValue.validate(null));
		
		recordValue.getField("uint4Field").setText("5");
		recordValue.getField("tokenField").setText("abc0");
		recordValue.getField("floatField").setText("1.0");
		recordValue.getField("intField").setText("1");
		recordValue.getField("booleanField").setText("true");
		recordValue.getField("bstrField").setText("1101");
		recordValue.getField("hstrField").setText("AF");
		recordValue.getField("ostrField").setText("00FF");
		recordValue.getField("cstrField").setText("xyz");
		recordValue.getField("enumField").setText("field1");
		recordValue.getField("verdictField").setText("pass");
//		dumper.dump(recordValue);
		//validate success
		assertTrue(recordValue.validate(null));
		recordValue.getField("uint4Field").setText("1");
		assertFalse(recordValue.validate(null));
		recordValue.getField("uint4Field").setText("5");
		assertTrue(recordValue.validate(null));
		recordValue.getField("tokenField").setText("#");
		assertFalse(recordValue.validate(null));
		recordValue.getField("tokenField").setText("abc");
		assertFalse(recordValue.validate(null));
		recordValue.getField("tokenField").setText("abc0");
		assertTrue(recordValue.validate(null));
		recordValue.getField("floatField").setText("10.1");
		assertFalse(recordValue.validate(null));
		recordValue.getField("floatField").setText("20.0");
		assertTrue(recordValue.validate(null));
		recordValue.getField("intField").setText("11");
		assertFalse(recordValue.validate(null));
		recordValue.getField("intField").setText("20");
		assertTrue(recordValue.validate(null));
		recordValue.getField("booleanField").setText("false");
		assertFalse(recordValue.validate(null));
		recordValue.getField("booleanField").setText("true");
		assertTrue(recordValue.validate(null));
		recordValue.getField("bstrField").setText("111");
		assertFalse(recordValue.validate(null));
		recordValue.getField("bstrField").setText("1111");
		assertTrue(recordValue.validate(null));
		recordValue.getField("hstrField").setText("F");
		assertFalse(recordValue.validate(null));
		recordValue.getField("hstrField").setText("FF");
		assertTrue(recordValue.validate(null));
		recordValue.getField("ostrField").setText("ab");
		assertFalse(recordValue.validate(null));
		recordValue.getField("ostrField").setText("11ff");
		assertTrue(recordValue.validate(null));
		recordValue.getField("cstrField").setText("12");
		assertFalse(recordValue.validate(null));
		recordValue.getField("cstrField").setText("123");
		assertTrue(recordValue.validate(null));
		recordValue.getField("enumField").setText("field3");
		assertFalse(recordValue.validate(null));
		recordValue.getField("enumField").setText("field2");
		assertTrue(recordValue.validate(null));
		recordValue.getField("verdictField").setText("inconc");
		assertFalse(recordValue.validate(null));
		recordValue.getField("verdictField").setText("fail");
		assertTrue(recordValue.validate(null));
		
		//SubRecord1_1
		IRecordSetValue subRecord1 = (IRecordSetValue)factory.createValue("SubRecord1_1");
		subRecord1.getField("uint4Field").setText("5");
		subRecord1.getField("tokenField").setText("abcd");
		subRecord1.getField("floatField").setText("20.0");
		subRecord1.getField("intField").setText("20");
		subRecord1.getField("booleanField").setText("true");
		subRecord1.getField("bstrField").setText("1101");
		subRecord1.getField("hstrField").setText("FF");
		subRecord1.getField("ostrField").setText("00FF");
		subRecord1.getField("cstrField").setText("xyz");
		subRecord1.getField("enumField").setText("field1");
		subRecord1.getField("verdictField").setText("pass");
		assertTrue(subRecord1.validate(null));
		
		subRecord1.getField("uint4Field").setText("6");
		assertFalse(subRecord1.validate(null));
		
		//SubRecord1_2
		subRecord1 = (IRecordSetValue)factory.createValue("SubRecord1_2");
		subRecord1.getField("uint4Field").setText("5");
		subRecord1.getField("tokenField").setText("abcd");
		subRecord1.getField("floatField").setText("20.0");
		subRecord1.getField("intField").setText("20");
		subRecord1.getField("booleanField").setText("true");
		subRecord1.getField("bstrField").setText("1101");
		subRecord1.getField("hstrField").setText("FF");
		subRecord1.getField("ostrField").setText("00FF");
		subRecord1.getField("cstrField").setText("xyz");
		subRecord1.getField("enumField").setText("field1");
		subRecord1.getField("verdictField").setText("pass");
		assertTrue(subRecord1.validate(null));
		
		subRecord1.getField("uint4Field").setText("6");
		assertFalse(subRecord1.validate(null));
		subRecord1.getField("uint4Field").setText("5");
		subRecord1.getField("enumField").setText("field2");
		assertTrue(subRecord1.validate(null));
		subRecord1.getField("enumField").setText("field3");
		assertFalse(subRecord1.validate(null));
		
		//Set1
		IRecordSetValue setValue = (IRecordSetValue)factory.createValue("Set1");
		setValue.getField("uint4Field").setText("5");
		assertTrue(setValue.getField("floatField").notPresent());
		assertTrue(setValue.validate(null));
		setValue.getField("uint4Field").setText("11");
		assertFalse(setValue.validate(null));
		setValue.getField("uint4Field").setText("10");
		setValue.setField("floatField", 
				factory.createValue(setValue.getType().getFieldType("floatField")));
		setValue.getField("floatField").setText("1.0");
		assertTrue(setValue.validate(null));
		
		//SubSet1_1
		IRecordSetValue subSet1 = (IRecordSetValue)factory.createValue("SubSet1_1");
		subSet1.getField("uint4Field").setText("5");
		subSet1.setField("floatField", 
				factory.createValue(subSet1.getType().getFieldType("floatField")));
		subSet1.getField("floatField").setText("1.0");
		assertFalse(subSet1.validate(null));
		subSet1.getField("floatField").setText("20.0");
		assertTrue(subSet1.validate(null));
		subSet1.setFieldOmitted("floatField");
		assertTrue(subSet1.getField("floatField").notPresent());
		assertFalse(subSet1.validate(null));
		
		//SubSet1_2
		subSet1 = (IRecordSetValue)factory.createValue("SubSet1_2");
		subSet1.getField("uint4Field").setText("5");
		subSet1.setField("floatField", 
				factory.createValue(subSet1.getType().getFieldType("floatField")));
		subSet1.getField("floatField").setText("11.0");
		assertFalse(subSet1.validate(null));
		subSet1.getField("floatField").setText("20.0");
		assertTrue(subSet1.validate(null));
		
		//record of length
		IListValue<IIntegerValue> recordList1 = 
			(IListValue<IIntegerValue>)factory.createValue("UINT4List");
		assertEquals(0, recordList1.getLength());
		assertFalse(recordList1.validate(null));
		recordList1.setLength(2);
		assertEquals(2, recordList1.getLength());
		assertNotNull(recordList1.getItem(0, true));
		assertNotNull(recordList1.getItem(1, true));
		assertTrue(recordList1.validate(null));
		assertNotNull(recordList1.getItem(3, true));
		assertEquals(4, recordList1.getLength());
		assertFalse(recordList1.validate(null));
		recordList1.setLength(2);
		recordList1.getItem(0).setText("100");
		assertFalse(recordList1.validate(null));
		
		//reocrod of list 1
		recordList1 = (IListValue<IIntegerValue>)factory.createValue("SubUINT4List_1");
		recordList1.setLength(2);
		assertEquals(2, recordList1.getLength());
		assertFalse(recordList1.validate(null));
		recordList1.getItem(0, true).setInteger(1);
		recordList1.getItem(1, true).setInteger(2);
		assertTrue(recordList1.validate(null));
		
		//reocrod of list 2
		recordList1 = (IListValue<IIntegerValue>)factory.createValue("SubUINT4List_2");
		recordList1.setLength(2);
		assertEquals(2, recordList1.getLength());
		recordList1.getItem(0, true).setInteger(1);
		recordList1.getItem(1, true).setInteger(2);
		assertFalse(recordList1.validate(null));
		recordList1.getItem(0, true).setInteger(5);
		recordList1.getItem(1, true).setInteger(6);
		assertTrue(recordList1.validate(null));
		
		//set of length
		recordList1 = 
			(IListValue<IIntegerValue>)factory.createValue("UINT4Set");
		assertEquals(2, recordList1.getLength());
		assertFalse(recordList1.validate(null));
		recordList1.setLength(2);
		assertEquals(2, recordList1.getLength());
		assertNotNull(recordList1.getItem(0, true));
		assertNotNull(recordList1.getItem(1, true));
		assertTrue(recordList1.validate(null));		
		
		//set of list(与顺序无关)
		recordList1 = (IListValue<IIntegerValue>)factory.createValue("SubUINT4Set");
		recordList1.setLength(2);
		assertEquals(2, recordList1.getLength());
		assertFalse(recordList1.validate(null));
		recordList1.getItem(0, true).setInteger(11);
		recordList1.getItem(1, true).setInteger(10);
		assertTrue(recordList1.validate(null));
		
		//union 
		IUnionValue unionValue1 = (IUnionValue)factory.createValue("Union1");
		assertNull(unionValue1.getPresentVariant());
		assertNull(unionValue1.getPresentVariantName());
		assertFalse(unionValue1.validate(null));
		IValue fieldValue = factory.createValue(unionValue1.getType().getFieldType("uint4Field"));
		unionValue1.setField("uint4Field", fieldValue);
		assertEquals(fieldValue, unionValue1.getPresentVariant());
		assertEquals("uint4Field", unionValue1.getPresentVariantName());
		assertFalse(unionValue1.validate(null));
		unionValue1.getPresentVariant().setText("5");
		assertTrue(unionValue1.validate(null));
		
		//union list
		unionValue1 = (IUnionValue)factory.createValue("SubUnion1");
		fieldValue = factory.createValue(unionValue1.getType().getFieldType("uint4Field"));
		unionValue1.setField("uint4Field", fieldValue);		
		unionValue1.getPresentVariant().setText("5");
		assertFalse(unionValue1.validate(null));
		unionValue1.getPresentVariant().setText("9");
		assertTrue(unionValue1.validate(null));
		
	}
	
	public void testList() throws Exception {
		//record of length
		IListValue<IIntegerValue> recordList1 = 
			(IListValue<IIntegerValue>)factory.createValue("UINT4List");
		assertEquals(0, recordList1.getLength());
		assertFalse(recordList1.validate(null));
		recordList1.setLength(2);
		assertEquals(2, recordList1.getLength());
		assertNotNull(recordList1.getItem(0, true));
		assertNotNull(recordList1.getItem(1, true));
//		PValueDumper.INSTANCE.dump(recordList1);
		assertTrue(recordList1.validate(null));
		
		
		//reocrod of list 1
		recordList1 = (IListValue<IIntegerValue>)factory.createValue("SubUINT4List_1");
		recordList1.setLength(2);
		assertEquals(2, recordList1.getLength());
		assertFalse(recordList1.validate(null));
		recordList1.getItem(0, true).setInteger(1);
		recordList1.getItem(1, true).setInteger(2);
		assertTrue(recordList1.validate(null));
		
		//reocrod of list 2
		recordList1 = (IListValue<IIntegerValue>)factory.createValue("SubUINT4List_2");
		recordList1.setLength(2);
		assertEquals(2, recordList1.getLength());
		recordList1.getItem(0, true).setInteger(1);
		recordList1.getItem(1, true).setInteger(2);
		assertFalse(recordList1.validate(null));
		recordList1.getItem(0, true).setInteger(5);
		recordList1.getItem(1, true).setInteger(6);
		assertTrue(recordList1.validate(null));
		
		//set of length
		recordList1 = 
			(IListValue<IIntegerValue>)factory.createValue("UINT4Set");
		assertEquals(2, recordList1.getLength());
		assertFalse(recordList1.validate(null));
		recordList1.setLength(2);
		assertEquals(2, recordList1.getLength());
		assertNotNull(recordList1.getItem(0, true));
		assertNotNull(recordList1.getItem(1, true));
		assertTrue(recordList1.validate(null));		
		
		//set of list(与顺序无关)
		recordList1 = (IListValue<IIntegerValue>)factory.createValue("SubUINT4Set");
		recordList1.setLength(2);
		assertEquals(2, recordList1.getLength());
		assertFalse(recordList1.validate(null));
		recordList1.getItem(0, true).setInteger(11);
		recordList1.getItem(1, true).setInteger(10);
		assertTrue(recordList1.validate(null));
		
	}
	
	public void testConstant() throws Exception {
		IConstant constVar;
		//intVar1
		constVar = module.getConstant("intVar1");
		assertNotNull(constVar);
		assertEquals("UINT4", constVar.getType().getName());
		PIntegerValue intVar1Value = (PIntegerValue)constVar.getValue();
		assertEquals(1, intVar1Value.getInteger());
		
		//enumVar1
		constVar = module.getConstant("enumVar1");
		assertNotNull(constVar);
		assertEquals("SubEnumType1", constVar.getType().getName());
		IEnumeratedValue enumVar1Value = (IEnumeratedValue)constVar.getValue();
		assertEquals("field2", enumVar1Value.getEnumName());
		
		//enumVar2
		constVar = module.getConstant("enumVar2");
		assertNotNull(constVar);
		assertEquals("SubEnumType1", constVar.getType().getName());
		IEnumeratedValue enumVar2Value = (IEnumeratedValue)constVar.getValue();
		assertEquals("field2", enumVar2Value.getEnumName());
		
		//intListVar1
		constVar = module.getConstant("intListVar1");
		assertNotNull(constVar);
		assertEquals("UINT4List", constVar.getType().getName());
		IListValue<IIntegerValue> intListVar1Value = 
			(IListValue<IIntegerValue>)constVar.getValue();
		assertEquals(3, intListVar1Value.getLength());
		assertEquals(1, intListVar1Value.getItem(0).getInteger());
		assertNull(intListVar1Value.getItem(1));
		assertEquals(2, intListVar1Value.getItem(2).getInteger());
		
		//intListVar2
		constVar = module.getConstant("intListVar2");
		assertNotNull(constVar);
		assertEquals("UINT4List", constVar.getType().getName());
		IListValue<IIntegerValue> intListVar2Value = 
			(IListValue<IIntegerValue>)constVar.getValue();
		assertEquals(5, intListVar2Value.getLength());
		assertEquals(3, intListVar2Value.getItem(0).getInteger());
		assertEquals(4, intListVar2Value.getItem(1).getInteger());
		assertNull(intListVar2Value.getItem(2));
		assertEquals(5, intListVar2Value.getItem(3).getInteger());
		assertTrue(intListVar2Value.getItem(4).notPresent());
		
		//setVar1
		constVar = module.getConstant("setVar1");
		assertNotNull(constVar);
		assertEquals("Set1", constVar.getType().getName());
		IRecordSetValue setVar1Value = (IRecordSetValue)constVar.getValue();
		assertEquals("5", setVar1Value.getField("uint4Field").getText());
		assertEquals("20.0", setVar1Value.getField("floatField").getText());
		
		//setVar1
		constVar = module.getConstant("setVar2");
		assertNotNull(constVar);
		assertEquals("Set1", constVar.getType().getName());
		IRecordSetValue setVar2Value = (IRecordSetValue)constVar.getValue();
		assertEquals("6", setVar2Value.getField("uint4Field").getText());
		assertEquals("21.0", setVar2Value.getField("floatField").getText());
		
		//unionVar1
		constVar = module.getConstant("unionVar1");
		assertNotNull(constVar);
		assertEquals("Union1", constVar.getType().getName());
		IUnionValue unionVar1Value = (IUnionValue)constVar.getValue();
		assertEquals("uint4Field", unionVar1Value.getPresentVariantName());
		assertEquals("9", unionVar1Value.getPresentVariant().getText());
		
		//test copy
		IConstant constVar1 = module.getConstant("intVar1");
		IConstant constVar2 = module.getConstant("intVar1");
		assertSame(constVar1, constVar2);
		assertNotSame(constVar1.getValue(), constVar2.getValue());
		assertEquals(constVar1.getValue(), constVar2.getValue());
		
		//test validation
		constVar = module.getConstant("intVar1");
		assertTrue(constVar.getValue().validate(null));
		constVar = module.getConstant("intVar2");
		assertFalse(constVar.getValue().validate(null));
		
		//myRecordOfArray
		IConstant multiRecordOfArray = module.getConstant("multiRecordOfArray");
		assertNotNull(multiRecordOfArray);
		assertEquals("MyMultiRecordOfType", multiRecordOfArray.getType().getName());
		IListValue<IListValue<IIntegerValue>> multiArrayValue = 
			(IListValue<IListValue<IIntegerValue>>)multiRecordOfArray.getValue();
		assertEquals(3, multiArrayValue.getLength());
		assertEquals(3, multiArrayValue.getItem(1).getLength());
		assertEquals(2, multiArrayValue.getItem(1).getItem(2).getInteger());
		assertEquals(2, multiArrayValue.getItem(2).getLength());
		assertEquals(1, multiArrayValue.getItem(2).getItem(1).getInteger());
		
		//intItemValue2
		constVar = module.getConstant("intItemValue2");
		assertNotNull(constVar);
		assertEquals("2", constVar.getValue().getText());
		
	}
	
	public void testModulePar() throws Exception {
		IModulePar mparVar;
		//intMpar1
		mparVar = module.getModulePar("intMpar1");
		assertNotNull(mparVar);
		assertEquals("UINT4", mparVar.getType().getName());
		IIntegerValue intVar1Value = (IIntegerValue)mparVar.getValue();
		assertEquals(1, intVar1Value.getInteger());
		
		//intMpar2
		mparVar = module.getModulePar("intMpar2");
		assertNotNull(mparVar);
		assertEquals("UINT4", mparVar.getType().getName());
		assertNull(mparVar.getValue());
		IIntegerValue intValue = (IIntegerValue)factory.createValue("UINT4");
		intValue.setInteger(2);
		mparVar.setInitValue(intValue);
		IIntegerValue intVar2Value = (IIntegerValue)mparVar.getValue();
		assertEquals(2, intVar2Value.getInteger());
		
		//strMpar1
		mparVar = module.getModulePar("strMpar1");
		assertNotNull(mparVar);
		assertEquals("StringToken", mparVar.getType().getName());
		ICharstringValue strMpar1Value = (ICharstringValue)mparVar.getValue();
		assertEquals("abc", strMpar1Value.getText());
		
		//strMpar2
		mparVar = module.getModulePar("strMpar2");
		assertNotNull(mparVar);
		assertEquals("StringToken", mparVar.getType().getName());
		assertNull(mparVar.getValue());
		
		//fMpar1
		mparVar = module.getModulePar("fMpar1");
		assertNotNull(mparVar);
		assertEquals("FloatType1", mparVar.getType().getName());
		IFloatValue fMpar1Value = (IFloatValue)mparVar.getValue();
		assertEquals(100.0f, fMpar1Value.getFloat());

		//intMpar3 mpar reference
		mparVar = module.getModulePar("intMpar4");
		assertNotNull(mparVar);
		assertEquals("UINT4", mparVar.getType().getName());
		IIntegerValue intVar4Value = (IIntegerValue)mparVar.getValue();
		assertEquals(1, intVar4Value.getInteger());
		
		//intMpar3
		mparVar = module.getModulePar("intMpar3");
		assertNotNull(mparVar);
		assertEquals("UINT4", mparVar.getType().getName());
		IIntegerValue intVar3Value = (IIntegerValue)mparVar.getValue();
		assertEquals(3, intVar3Value.getInteger());
		
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; i++) {
			service.submit(new Callable<Integer>(){
				@Override
				public Integer call() throws Exception {
					IModulePar mpar = module.getModulePar("intMpar3");
					IIntegerValue localValue = (IIntegerValue)factory.createValue("UINT4");
					mpar.setLocalValue(localValue);
					int cnt = 50;
					for (int i = 0; i < cnt; i++) {
						localValue.setInteger(i);
						IIntegerValue value = (IIntegerValue )mpar.getValue();
						assertEquals(i, value.getInteger());
						assertNotSame(localValue, value);
//						System.out.println(Thread.currentThread().getName()+":"+value.getInteger());
						Thread.sleep((int)(Math.random() * 10));
					}
					return 1;
				}
			});
		}
		service.shutdown();
		service.awaitTermination(10, TimeUnit.SECONDS);
	}
	
	public void testImportElement() throws Exception {
		//langtest2
		IModule module2 = PModuleExt.Registry.INSTANCE.resolveModule("langtest2");
		assertNotNull(module2);
		//import type
		IFactory factory2 = module2.getFactory();
		IType type1 = module2.getType("UINT4");
		assertNotNull(type1);
		assertSame(type1, module2.getType("langtest1.UINT4"));
		IIntegerValue intValue = (IIntegerValue)factory2.createValue(type1);
		assertEquals(0, intValue.getInteger());
		assertTrue(intValue.validate(null));
		intValue.setInteger(16);
		assertFalse(intValue.validate(null));
		//sub import type
		type1 = module2.getType("UINT4_1");
		intValue = (IIntegerValue)factory2.createValue(type1);		
		assertEquals(0, intValue.getInteger());
		assertFalse(intValue.validate(null));
		intValue.setInteger(5);
		assertTrue(intValue.validate(null));
		//oether type
		assertNotNull(module2.getType("StringToken"));
		assertNotNull(module2.getType("EnumType1"));
		assertNotNull(module2.getType("UINT4List"));
		assertEquals(20, module2.getTypeNames().length);
		//import constant
		assertEquals("1", module2.getConstant("intVar1").getValue().getText());
		assertNotNull(module2.getConstant("intVar2"));
		assertNotNull(module2.getConstant("enumVar1"));
		assertNotNull(module2.getConstant("intListVar1"));
		assertNotNull(module2.getConstant("intListVar2"));
		assertNotNull(module2.getConstant("setVar1"));
		assertNotNull(module2.getConstant("setVar2"));
		assertNotNull(module2.getConstant("unionVar1"));
		assertEquals(15, module2.getConstantNames().length);
		//import modulepar
		assertEquals("1", module2.getModulePar("intMpar1").getValue().getText());
		assertNotNull(module2.getModulePar("intMpar2"));
		assertNotNull(module2.getModulePar("strMpar1"));
		assertNotNull(module2.getModulePar("strMpar2"));
		assertNotNull(module2.getModulePar("fMpar1"));
		assertNotNull(module2.getModulePar("intMpar3"));
		assertEquals(7, module2.getModuleParNames().length);
		
		//langtest3
		IModule module3 = PModuleExt.Registry.INSTANCE.resolveModule("langtest3");
		assertNotNull(module3);
		//import type
		type1 = module3.getType("UINT4_1");
		assertNotNull(type1);
		assertSame(type1, module3.getType("langtest2.UINT4_1"));
		assertEquals(16, module3.getTypeNames().length);
		//import constant
		assertEquals(0, module3.getConstantNames().length);
		//import modulepar
		assertEquals(0, module3.getModuleParNames().length);
	}
	
	public void testModuleSymbolError() throws Exception {
		try {
		    GrammerTest.parseModule("langtest4");
			fail();
		} catch (ParserException e) {
//			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("ELEMENT_DEFINITION_DUPLICATED_ERROR"));
			assertTrue(e.getMessage().contains("TYPE_NOT_FOUND_ERROR"));
			assertTrue(e.getMessage().contains("FIELD_DEFINITION_DUPLICATED_ERROR"));
			assertTrue(e.getMessage().contains("ENUM_ITEM_DEFINITION_DUPLICATED_ERROR"));
		}
	}
	
	public void testInitModelError() throws Exception {
		try {
			IModule module5 = GrammerTest.parseModule("langtest5");
			System.out.println(module5.getConstant("recaVar1"));
			System.out.println(module5.getConstant("reccVar1"));
			fail();
		} catch (ParserException e) {
//			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("FIELD_NOT_FOUND_ERROR"));
			assertTrue(e.getMessage().contains("RECURSIVE_ELEMENT_REFERENCE_ERROR"));
			assertTrue(e.getMessage().contains("ELEMENT_REFERENCE_NOT_ALLOWED_ERROR"));
		}
	}
	
	public void testComplexRecord() throws Exception {
		//Composite Record
		IConstant recl1Var1 = module.getConstant("recl1Var1");
		IRecordSetValue recValue = (IRecordSetValue)recl1Var1.getValue();
		assertNotNull(recValue);
		assertEquals("1", recValue.findField("field1").getText());
		assertEquals("11", recValue.findField("field2/field1").getText());
		assertEquals("111", recValue.findField("field2/field2/field1").getText());
		
		//Referenced Value
		IConstant recl3Var1 = module.getConstant("recl3Var1");
		recValue = (IRecordSetValue)recl3Var1.getValue();
		assertNotNull(recValue);
		assertEquals("111", recValue.findField("field1").getText());
		assertEquals("222.0", recValue.findField("field2").getText());
		
		IConstant recl2Var1 = module.getConstant("recl2Var1");
		recValue = (IRecordSetValue)recl2Var1.getValue();
//		IValueDumper.INSTANCE.dump(recValue);
		assertNotNull(recValue);
		assertEquals("11", recValue.findField("field1").getText());
		assertEquals("111", recValue.findField("field2/field1").getText());
		assertEquals("222.0", recValue.findField("field2/field2").getText());
		
		//findField
		IValue newValue = factory.createValue("RecordLevel1");
		assertNull(newValue.findField("field2/field2/field2"));
		newValue.findField("field2/field2/field2", true).setText("1.1");
		assertEquals("1.1", newValue.findField("field2/field2/field2").getText());
		
	}
	
	public void _testRecursiveRefTypeRecord() throws Exception {
        //langtest2
        IModule module2 = PModuleExt.Registry.INSTANCE.resolveModule("langtest2");
//        System.out.println(module2);
        assertNotNull(module2);
        //测试限制条件的重叠覆盖
        IFactory factory2 = module2.getFactory();
        IRecordSetValue recB = (IRecordSetValue)factory2.createValue("RecordB");
        recB.getField("fieldStr").setText("abc");
        assertTrue(recB.validate(null));
        recB.getField("fieldStr").setText("1");
        assertFalse(recB.validate(null));
        //测试字段在循环引用类型时字段所继承的子类型限制条件仍然有效
        recB = (IRecordSetValue)factory2.createValue("RecordB");
        recB.getField("fieldStr").setText("abc");
        recB.findField("fieldA", true);
        recB.findField("fieldA/fieldInt").setText("10");
        recB.findField("fieldA/fieldB/fieldStr").setText("abc");
        assertTrue(recB.validate(null));
        recB.findField("fieldA/fieldB/fieldStr").setText("efg");
        assertFalse(recB.validate(null));
        
	}
}
