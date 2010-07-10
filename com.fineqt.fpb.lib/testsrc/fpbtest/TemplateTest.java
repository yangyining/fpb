package fpbtest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.builtin.BuiltinFactory;
import com.fineqt.fpb.lib.builtin.BuiltinModule;
import com.fineqt.fpb.lib.builtin.PBitstringValue;
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.builtin.PHexstringValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.expression.POmitMatcherExt;
import com.fineqt.fpb.lib.expression.PPrimitiveValueMatcherExt;
import com.fineqt.fpb.lib.expression.PValueReferenceMatcherExt;
import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplateFactory;
import com.fineqt.fpb.lib.model.fpbtemplate.PBitstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PHexstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.POctetstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.impl.PBitstringMatcherExt;
import com.fineqt.fpb.lib.template.impl.PCharRangeMatcherExt;
import com.fineqt.fpb.lib.template.impl.PCharstringMatcherExt;
import com.fineqt.fpb.lib.template.impl.PContainerFieldMatcherExt;
import com.fineqt.fpb.lib.template.impl.PElementPattern;
import com.fineqt.fpb.lib.template.impl.PEntityTemplateExtImpl;
import com.fineqt.fpb.lib.template.impl.PHexstringMatcherExt;
import com.fineqt.fpb.lib.template.impl.PIntRangeMatcherExt;
import com.fineqt.fpb.lib.template.impl.PListFieldMatcherExt;
import com.fineqt.fpb.lib.template.impl.PTemplateMatcherExtBase;
import com.fineqt.fpb.lib.template.impl.POctetstringMatcherExt;
import com.fineqt.fpb.lib.template.impl.PRecordOfMatcherExt;
import com.fineqt.fpb.lib.template.impl.PSetOfMatcherExt;
import com.fineqt.fpb.lib.template.impl.PSubsetMatcherExt;
import com.fineqt.fpb.lib.template.impl.PSupersetMatcherExt;
import com.fineqt.fpb.lib.template.impl.PTemplateParMetaImpl;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

import fpbtest.module.builtintest.BuiltintestFactory;
import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.DataLengthHyp;

public class TemplateTest extends TestCase {
	FpbtemplateFactory mfactory = FpbtemplateFactory.eINSTANCE;

	public void testBitstringStringMatcher() throws Exception {
		PTypeExt bstrType = BuiltinModule.BUILTIN_INSTANCE.getBitstring();
		//Bitstring
		PBitstringMatcherExt bstrMatcher;
		PBitstringValue bstrValue = (PBitstringValue)BuiltinFactory.BUILTIN_INSTANCE.createBitstring();
		PBitstringMatcher mmodel = mfactory.createPBitstringMatcher();
		//Value
		mmodel.setDesc("10");
		bstrMatcher = PBitstringMatcherExt.create(mmodel, bstrType);
		assertEquals(1, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(0).getType());
		bstrValue.setText("10");
		assertTrue(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("1");
		assertFalse(bstrMatcher.match(bstrValue, null));
		//Any
		mmodel.setDesc("?");
		bstrMatcher = PBitstringMatcherExt.create(mmodel, bstrType);
		assertEquals(1, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Any, bstrMatcher.getElements().get(0).getType());
		bstrValue.setText("10");
		assertFalse(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("1");
		assertTrue(bstrMatcher.match(bstrValue, null));
		//AnyOrNone
		mmodel.setDesc("*");
		bstrMatcher = PBitstringMatcherExt.create(mmodel, bstrType);
		assertEquals(1, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.AnyOrNone, bstrMatcher.getElements().get(0).getType());
		bstrValue.setText("10");
		assertTrue(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("1");
		assertTrue(bstrMatcher.match(bstrValue, null));
		//1*0?
		mmodel.setDesc("1*0?");
		bstrMatcher = PBitstringMatcherExt.create(mmodel, bstrType);
		assertEquals(4, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(0).getType());
		assertEquals(PElementPattern.Type.AnyOrNone, bstrMatcher.getElements().get(1).getType());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(2).getType());
		assertEquals(PElementPattern.Type.Any, bstrMatcher.getElements().get(3).getType());
		bstrValue.setText("101");
		assertTrue(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("11100");
		assertTrue(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("11110");
		assertFalse(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("0");
		assertFalse(bstrMatcher.match(bstrValue, null));
		//11?*01?*
		mmodel.setDesc("11?*01?*");
		bstrMatcher = PBitstringMatcherExt.create(mmodel, bstrType);
		assertEquals(6, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(0).getType());
		assertEquals(PElementPattern.Type.Any, bstrMatcher.getElements().get(1).getType());
		assertEquals(PElementPattern.Type.AnyOrNone, bstrMatcher.getElements().get(2).getType());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(3).getType());
		assertEquals(PElementPattern.Type.Any, bstrMatcher.getElements().get(4).getType());
		assertEquals(PElementPattern.Type.AnyOrNone, bstrMatcher.getElements().get(5).getType());
		bstrValue.setText("11011011");
		assertTrue(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("1101101100");
		assertTrue(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("110000000");
		assertFalse(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("110000001");
		assertFalse(bstrMatcher.match(bstrValue, null));
		
		//1* length 3
		mmodel.setDesc("1*");
		bstrMatcher = PBitstringMatcherExt.create(mmodel, bstrType);
		bstrMatcher.setLengthRestriction(new PTemplateMatcherExtBase.LengthRange(3, 3));
		bstrValue.setText("111");
		assertTrue(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("011");
		assertFalse(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("11111");
		assertFalse(bstrMatcher.match(bstrValue, null));
	}
	
	public void testHexstringStringMatcher() throws Exception {
		PTypeExt hstrType = BuiltinModule.BUILTIN_INSTANCE.getHexstring();
		//Bitstring
		PHexstringMatcherExt bstrMatcher;
		PHexstringValue strValue = (PHexstringValue)BuiltinFactory.BUILTIN_INSTANCE.createHexstring();
		PHexstringMatcher mmodel = mfactory.createPHexstringMatcher();
		//Value
		mmodel.setDesc("1A");
		bstrMatcher = PHexstringMatcherExt.create(mmodel, hstrType);
		assertEquals(1, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(0).getType());
		strValue.setText("1A");
		assertTrue(bstrMatcher.match(strValue, null));
		strValue.setText("1");
		assertFalse(bstrMatcher.match(strValue, null));
		//Any
		mmodel.setDesc("?");
		bstrMatcher = PHexstringMatcherExt.create(mmodel, hstrType);
		assertEquals(1, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Any, bstrMatcher.getElements().get(0).getType());
		strValue.setText("1A");
		assertFalse(bstrMatcher.match(strValue, null));
		strValue.setText("1");
		assertTrue(bstrMatcher.match(strValue, null));
		//AnyOrNone
		mmodel.setDesc("*");
		bstrMatcher = PHexstringMatcherExt.create(mmodel, hstrType);
		assertEquals(1, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.AnyOrNone, bstrMatcher.getElements().get(0).getType());
		strValue.setText("1A");
		assertTrue(bstrMatcher.match(strValue, null));
		strValue.setText("1");
		assertTrue(bstrMatcher.match(strValue, null));
		//3*F?
		mmodel.setDesc("3*F?");
		bstrMatcher = PHexstringMatcherExt.create(mmodel, hstrType);
		assertEquals(4, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(0).getType());
		assertEquals(PElementPattern.Type.AnyOrNone, bstrMatcher.getElements().get(1).getType());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(2).getType());
		assertEquals(PElementPattern.Type.Any, bstrMatcher.getElements().get(3).getType());
		strValue.setText("3F0");
		assertTrue(bstrMatcher.match(strValue, null));
		strValue.setText("311F0");
		assertTrue(bstrMatcher.match(strValue, null));
		strValue.setText("31111");
		assertFalse(bstrMatcher.match(strValue, null));
		strValue.setText("0");
		assertFalse(bstrMatcher.match(strValue, null));
	}
	
	public void testOctetstringStringMatcher() throws Exception {
		PTypeExt hstrType = BuiltinModule.BUILTIN_INSTANCE.getOctetstring();
		//Bitstring
		POctetstringMatcherExt bstrMatcher;
		POctetstringValue bstrValue = (POctetstringValue)BuiltinFactory.BUILTIN_INSTANCE.createOctetstring();
		POctetstringMatcher mmodel = mfactory.createPOctetstringMatcher();
		//Value
		mmodel.setDesc("11AA");
		bstrMatcher = POctetstringMatcherExt.create(mmodel, hstrType);
		assertEquals(1, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(0).getType());
		bstrValue.setText("11AA");
		assertTrue(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("11");
		assertFalse(bstrMatcher.match(bstrValue, null));
		//Any
		mmodel.setDesc("?");
		bstrMatcher = POctetstringMatcherExt.create(mmodel, hstrType);
		assertEquals(1, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Any, bstrMatcher.getElements().get(0).getType());
		bstrValue.setText("11AA");
		assertFalse(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("11");
		assertTrue(bstrMatcher.match(bstrValue, null));
		//AnyOrNone
		mmodel.setDesc("*");
		bstrMatcher = POctetstringMatcherExt.create(mmodel, hstrType);
		assertEquals(1, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.AnyOrNone, bstrMatcher.getElements().get(0).getType());
		bstrValue.setText("11AA");
		assertTrue(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("11");
		assertTrue(bstrMatcher.match(bstrValue, null));
		//3*F?
		mmodel.setDesc("33*FF?");
		bstrMatcher = POctetstringMatcherExt.create(mmodel, hstrType);
		assertEquals(4, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(0).getType());
		assertEquals(PElementPattern.Type.AnyOrNone, bstrMatcher.getElements().get(1).getType());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(2).getType());
		assertEquals(PElementPattern.Type.Any, bstrMatcher.getElements().get(3).getType());
		bstrValue.setText("33FF00");
		assertTrue(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("332211FF00");
		assertTrue(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("3322111100");
		assertFalse(bstrMatcher.match(bstrValue, null));
		bstrValue.setText("00");
		assertFalse(bstrMatcher.match(bstrValue, null));
	}
	
	public void testCharstringMatcher() throws Exception {
		PTypeExt hstrType = BuiltinModule.BUILTIN_INSTANCE.getCharstring();
		PCharstringMatcherExt matcher;
		PCharstringValue cstrValue = (PCharstringValue)BuiltinFactory.BUILTIN_INSTANCE.createCharstring();
		PCharstringMatcher mmodel = mfactory.createPCharstringMatcher();
		//A??C
		mmodel.setDesc("A..C");
		matcher = PCharstringMatcherExt.create(mmodel, hstrType);
		cstrValue.setText("A->C");
		assertTrue(matcher.match(cstrValue, null));
		cstrValue.setText("AAC");
		assertFalse(matcher.match(cstrValue, null));
		//A*A
		mmodel.setDesc("A(.)*A");
		matcher = PCharstringMatcherExt.create(mmodel, hstrType);
		cstrValue.setText("ABBA");
		assertTrue(matcher.match(cstrValue, null));
		cstrValue.setText("AA");
		assertTrue(matcher.match(cstrValue, null));
		cstrValue.setText("AC");
		assertFalse(matcher.match(cstrValue, null));
		//A* length 3
		mmodel.setDesc("A(.)*");
		matcher = PCharstringMatcherExt.create(mmodel, hstrType);
		matcher.setLengthRestriction(new PTemplateMatcherExtBase.LengthRange(3, 3));
		cstrValue.setText("ABB");
		assertTrue(matcher.match(cstrValue, null));
		cstrValue.setText("ABBbbb");
		assertFalse(matcher.match(cstrValue, null));
	}
	
	public void testConstPrimitiveValueMatcher() throws Exception {
		PPrimitiveValueMatcherExt matcher;
		//charstring valueof
		PPrimitiveValueMatcher model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("xyz");
		matcher = PPrimitiveValueMatcherExt.create(model, BuiltinModule.BUILTIN_INSTANCE.getCharstring());
		PCharstringValue cstrValue = (PCharstringValue)BuiltinFactory.BUILTIN_INSTANCE.createCharstring();
		cstrValue.setText("xyz");
		PCharstringValue cstrValue2 = (PCharstringValue)matcher.valueOf(null);
		assertNotSame(cstrValue, cstrValue2);
		assertEquals(cstrValue, cstrValue2);
		
	}
	
	public void testRangeMatcher() throws Exception {
		PRangeMatcher mmodel = mfactory.createPRangeMatcher();
		//integer
		mmodel.setLowerBound(createPrmMatcher("120"));
		mmodel.setUpperBound(createPrmMatcher("1000"));
		PIntRangeMatcherExt intMatcher = new PIntRangeMatcherExt(mmodel, 
				BuiltintestModule.INSTANCE.getUint8());
		intMatcher.init();
		PIntegerValue intValue = (PIntegerValue)BuiltintestFactory.INSTANCE.createUINT8();
		intValue.setInteger(130);
		assertTrue(intMatcher.match(intValue, null));
		//模版限制
		intValue.setInteger(10);
		assertFalse(intMatcher.match(intValue, null));
		
		//char
		mmodel.setLowerBound(createPrmMatcher("a"));
		mmodel.setUpperBound(createPrmMatcher("z"));
		PCharRangeMatcherExt charMatcher = new PCharRangeMatcherExt(mmodel, 
				BuiltintestModule.INSTANCE.getCharstring());
		charMatcher.init();
		PCharstringValue charValue = (PCharstringValue)BuiltintestFactory.INSTANCE.createCharstring();
		charValue.setLength(1);
		charValue.setChar(0, 'a');
		assertTrue(charMatcher.match(charValue, null));
		charValue.setChar(0, 'A');
		assertFalse(charMatcher.match(charValue, null));
		charValue.setLength(2);
		charValue.setChar(0, 'a');
		charValue.setChar(1, 'a');
		assertEquals(2, charValue.getLength());
		assertFalse(charMatcher.match(charValue, null));
		
	}
	
	public void testSetValueMatcher() throws Exception {
		BuiltintestModule module = BuiltintestModule.INSTANCE;
		BuiltintestFactory factory = BuiltintestFactory.INSTANCE;
		PIntegerValue intValue;
		IListValue<IIntegerValue> intList;
		//Superset(2, 3)
		PSupersetMatcherExt superMatcher = new PSupersetMatcherExt(null, module.getUint16Set());
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(2);
		superMatcher.getItems().add(intValue);
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(3);
		superMatcher.getItems().add(intValue);
		//2
		intList = factory.createUint16Set();
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(2);
		intList.appendItem(intValue);
		assertFalse(superMatcher.match((PValue)intList, null));
		//1, 2, 3
		intList = factory.createUint16Set();
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(1);
		intList.appendItem(intValue);
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(2);
		intList.appendItem(intValue);
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(3);
		intList.appendItem(intValue);
		assertTrue(superMatcher.match((PValue)intList, null));
		
		//Superset(2) length 2
		superMatcher = new PSupersetMatcherExt(null, module.getUint16Set());
		superMatcher.setLengthRestriction(new PTemplateMatcherExtBase.LengthRange(2, 2));
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(2);
		superMatcher.getItems().add(intValue);		
		//2
		intList = factory.createUint16Set();
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(2);
		intList.appendItem(intValue);
		assertFalse(superMatcher.match((PValue)intList, null));

		//2
		intList = factory.createUint16Set();
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(2);
		intList.appendItem(intValue);
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(3);
		intList.appendItem(intValue);
		assertTrue(superMatcher.match((PValue)intList, null));
		
		//Subset(2, 3)
		PSubsetMatcherExt subMatcher = new PSubsetMatcherExt(null, module.getUint16Set());
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(2);
		subMatcher.getItems().add(intValue);
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(3);
		subMatcher.getItems().add(intValue);
		//2
		intList = factory.createUint16Set();
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(2);
		intList.appendItem(intValue);
		assertTrue(subMatcher.match((PValue)intList, null));
		//4, 5
		intList = factory.createUint16Set();
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(4);
		intList.appendItem(intValue);
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(5);
		intList.appendItem(intValue);
		assertFalse(subMatcher.match((PValue)intList, null));

		//Subset(2) length 2
		subMatcher = new PSubsetMatcherExt(null, module.getUint16Set());
		subMatcher.setLengthRestriction(new PTemplateMatcherExtBase.LengthRange(2, 2));
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(2);
		subMatcher.getItems().add(intValue);
		//2
		intList = factory.createUint16Set();
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(2);
		intList.appendItem(intValue);
		assertFalse(subMatcher.match((PValue)intList, null));
		//2, 3
		intList = factory.createUint16Set();
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(2);
		intList.appendItem(intValue);
		intValue = (PIntegerValue)factory.createUINT16();
		intValue.setInteger(3);
		intList.appendItem(intValue);
		assertTrue(subMatcher.match((PValue)intList, null));
	}
	
	//TODO error
	public void _testFieldSpecListMatcher() throws Exception {
		BuiltintestModule module = BuiltintestModule.INSTANCE;
//		BuiltintestFactory factory = BuiltintestFactory.INSTANCE;
		PContainerFieldMatcherExt.Item citem;
		PMatcherExt itemMatcher;
		//Record
		PContainerTypeExt dlhType = (PContainerTypeExt)module.getDataLengthHyp();
		PContainerFieldMatcherExt recordMatcher = new PContainerFieldMatcherExt(null, dlhType);
		citem = new PContainerFieldMatcherExt.Item(
				dlhType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__TOTAL_LENGTH));
		PPrimitiveValueMatcher model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("10");
		itemMatcher = PPrimitiveValueMatcherExt.create(model, module.getUint8());
		citem.setMatcher(itemMatcher);
		recordMatcher.getItems().add(citem);
		citem = new PContainerFieldMatcherExt.Item(
				dlhType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__DATA1_LENGTH));
		model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("20");
		itemMatcher = PPrimitiveValueMatcherExt.create(model, module.getUint16());
		citem.setMatcher(itemMatcher);
		recordMatcher.getItems().add(citem);
		citem = new PContainerFieldMatcherExt.Item(
				dlhType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__DATA2_FLAG));
		model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("true");
		itemMatcher = PPrimitiveValueMatcherExt.create(model, module.getBoolean());
		citem.setMatcher(itemMatcher);
		recordMatcher.getItems().add(citem);
		citem = new PContainerFieldMatcherExt.Item(
				dlhType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__DATA1));
		model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("101");
		itemMatcher = PPrimitiveValueMatcherExt.create(model, module.getBitstring());
		citem.setMatcher(itemMatcher);
		recordMatcher.getItems().add(citem);
		citem = new PContainerFieldMatcherExt.Item(
				dlhType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__PAD));
		model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("1100");
		itemMatcher = PPrimitiveValueMatcherExt.create(model, module.getBitstring());
		citem.setMatcher(itemMatcher);
		recordMatcher.getItems().add(citem);
		citem = new PContainerFieldMatcherExt.Item(
				dlhType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__DATA2));
		itemMatcher = new POmitMatcherExt(null, dlhType.getFieldMeta(
				BuiltintestModule.DATA_LENGTH_HYP__DATA2), dlhType);
		citem.setMatcher(itemMatcher);
		recordMatcher.getItems().add(citem);
		citem = new PContainerFieldMatcherExt.Item(
				dlhType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__DATA3));
		model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("11FF");
		itemMatcher = PPrimitiveValueMatcherExt.create(model, dlhType.getFieldMeta(
				BuiltintestModule.DATA_LENGTH_HYP__DATA3));
//		itemMatcher.setIfPresent(true);
		citem.setMatcher(itemMatcher);
		recordMatcher.getItems().add(citem);
		//valueOf
		DataLengthHyp dlhObj = (DataLengthHyp)recordMatcher.valueOf(null);
//		PValueDumper.INSTANCE.dump(dlhObj);
		//match success
		assertTrue(recordMatcher.match((PValue)dlhObj, null));
		//match success ifPresent
		dlhObj.setFieldOmitted(BuiltintestModule.DATA_LENGTH_HYP__DATA3);
		assertTrue(recordMatcher.match((PValue)dlhObj, null));
		//match failed
		dlhObj.getTotalLength().setInteger(99);
		assertFalse(recordMatcher.match((PValue)dlhObj, null));

		//List(0, 10) (2, 30) length 3
		PListFieldMatcherExt.Item litem;
		PListFieldMatcherExt listMatcher = new PListFieldMatcherExt(null, module.getUint16List());
		listMatcher.setLengthRestriction(new PTemplateMatcherExtBase.LengthRange(3, 3));
		litem = new PListFieldMatcherExt.StaticItem(0);
		model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("10");
		itemMatcher = PPrimitiveValueMatcherExt.create(model, module.getUint16());
		litem.setMatcher(itemMatcher);
		listMatcher.getItems().add(litem);
		litem = new PListFieldMatcherExt.StaticItem(2);
		model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("30");
		itemMatcher = PPrimitiveValueMatcherExt.create(model, module.getUint16());
		litem.setMatcher(itemMatcher);
		listMatcher.getItems().add(litem);
		//valueOf
		@SuppressWarnings("unchecked")
		IListValue<IIntegerValue> listValue = (IListValue<IIntegerValue>)listMatcher.valueOf(null);
		assertEquals(3, listValue.getLength());
//		PValueDumper.INSTANCE.dump(listValue);
		//match success
		assertTrue(listMatcher.match((PValue)listValue, null));
		//match fail
		listValue.getItem(0).setInteger(99);
		assertFalse(listMatcher.match((PValue)listValue, null));
		//match fail length
		listValue.getItem(0).setInteger(10);
		assertTrue(listMatcher.match((PValue)listValue, null));
		listValue.setLength(5);
		assertFalse(listMatcher.match((PValue)listValue, null));
	}
	
	//TODO error
	public void _testListValueMatcher() throws Exception {
		BuiltintestModule module = BuiltintestModule.INSTANCE;
		PPrimitiveValueMatcherExt valueMatcher;
		PElementPattern.PListValueElementPattern valuePattern;
		PRecordOfMatcherExt rofMatcher;
		PSetOfMatcherExt sofMatcher;
		//record of (1, 2) 
		rofMatcher = new PRecordOfMatcherExt(null, module.getUint16List());
		PPrimitiveValueMatcher model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("1");
		valueMatcher = PPrimitiveValueMatcherExt.create(model, module.getUint16()); 
		valuePattern = new PElementPattern.PListValueElementPattern(valueMatcher);
		rofMatcher.getElements().add(valuePattern);
		model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("2");
		valueMatcher = PPrimitiveValueMatcherExt.create(model, module.getUint16()); 
		valuePattern = new PElementPattern.PListValueElementPattern(valueMatcher);
		rofMatcher.getElements().add(valuePattern);
		rofMatcher.init();
		//valueOf
		@SuppressWarnings("unchecked")
		IListValue<IIntegerValue> listValue = (IListValue<IIntegerValue>)rofMatcher.valueOf(null);
		assertEquals(2, listValue.getLength());
		//match
		assertTrue(rofMatcher.match((PValue)listValue, null));
		listValue.getItem(0).setInteger(99);
		assertFalse(rofMatcher.match((PValue)listValue, null));
		
		//Set of (1, 2)
		sofMatcher = new PSetOfMatcherExt(null, module.getUint16Set());
		model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("1");
		valueMatcher = PPrimitiveValueMatcherExt.create(model, module.getUint16()); 
		valuePattern = new PElementPattern.PListValueElementPattern(valueMatcher);
		sofMatcher.getElements().add(valuePattern);
		model = mfactory.createPPrimitiveValueMatcher();
		model.setValueDesc("2");
		valueMatcher = PPrimitiveValueMatcherExt.create(model, module.getUint16()); 
		valuePattern = new PElementPattern.PListValueElementPattern(valueMatcher);
		sofMatcher.getElements().add(valuePattern);
		sofMatcher.init();
		//valueOf
		@SuppressWarnings("unchecked")
		IListValue<IIntegerValue> setValue = (IListValue<IIntegerValue>)sofMatcher.valueOf(null);
		assertEquals(2, setValue.getLength());
		//match
		assertTrue(sofMatcher.match((PValue)setValue, null));
		setValue.getItem(0).setInteger(99);
		assertFalse(sofMatcher.match((PValue)setValue, null));
		setValue.getItem(0).setInteger(2);
		setValue.getItem(1).setInteger(1);
		assertTrue(sofMatcher.match((PValue)setValue, null));
		
		//TODO 省略了带?和*的模板
	}
	//TODO error
	public void _testSimpleTemplate() throws Exception {
		BuiltintestModule module = BuiltintestModule.INSTANCE;
		BuiltintestFactory factory = BuiltintestFactory.INSTANCE;
		//Matcher template integer tmpa(integer para1) :=  para1
		PValueReferenceMatcher mmodel = mfactory.createPValueReferenceMatcher();
		mmodel.setRefName("para1");
		mmodel.setRefType(ValueReferenceType.TEMPLATEPAR);
		PValueReferenceMatcherExt matcher = new PValueReferenceMatcherExt(mmodel, module.getUint8());
		matcher.init();
		PEntityTemplateExtImpl tmpa = new PEntityTemplateExtImpl(module.getUint8(), matcher);
		PTemplateParMetaImpl para1 = new PTemplateParMetaImpl(false, module.getUint8(), "para1");
		tmpa.getParMetas().add(para1);
		tmpa.init();
		//match
		IIntegerValue srcValue = factory.createInteger();
		srcValue.setInteger(10);
		IIntegerValue paraValue = factory.createInteger();
		paraValue.setInteger(100);
		assertFalse(tmpa.matchPValue((PValue)srcValue, true, paraValue));
		paraValue.setInteger(10);
		assertTrue(tmpa.matchPValue((PValue)srcValue, true, paraValue));
		//类型限制UINT8(0.255)
		srcValue.setInteger(256);
		paraValue.setInteger(256);
		assertFalse(tmpa.matchPValue((PValue)srcValue, true, paraValue));
		//valueOf
		paraValue = factory.createInteger();
		paraValue.setInteger(100);		
		IIntegerValue resultValue = (IIntegerValue)tmpa.pValueOf(paraValue);
		assertNotSame(paraValue, resultValue);
		assertEquals(paraValue, resultValue);
	}
	
	private PPrimitiveValueMatcher createPrmMatcher(String valueDesc) {
		PPrimitiveValueMatcher prmMatcher = 
			FpbtemplateFactory.eINSTANCE.createPPrimitiveValueMatcher();
		prmMatcher.setValueDesc(valueDesc);
		return prmMatcher;
	}
	
}
