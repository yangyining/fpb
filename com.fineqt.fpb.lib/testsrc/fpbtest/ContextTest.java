package fpbtest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.builtin.BuiltinFactory;
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.codec.SimpleDecodeResult;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.context.EncodeContextImpl;
import com.fineqt.fpb.lib.meta.evattr.CxtAttrFieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.FieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.OwnerFieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.PPath;
import com.fineqt.fpb.lib.meta.evattr.ResultPrpFieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.StackFieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.TypeFieldRefDesc;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.value.PListValue;
import com.fineqt.fpb.lib.value.PValue;

import fpbtest.module.builtintest.BuiltintestFactory;
import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.StringBlock;
import fpbtest.module.builtintest.StringOneLine;

public class ContextTest extends TestCase {
	public void testSimpleContext() {
		BuiltinFactory factory = BuiltinFactory.BUILTIN_INSTANCE;
		EncodeContext cxt = new EncodeContextImpl();
		//push (field1, field2, field2)
		PIntegerValue value = (PIntegerValue)factory.createInteger();
		value.setInteger(1);
		cxt.getFieldStackMap().pushField("field1", value);
		value = (PIntegerValue)factory.createInteger();
		value.setInteger(2);
		cxt.getFieldStackMap().pushField("field2", value);
		value = (PIntegerValue)factory.createInteger();
		value.setInteger(3);
		cxt.getFieldStackMap().pushField("field2", value);
		//pop
		value = (PIntegerValue)cxt.getFieldStackMap().popField("field2");
		assertNotNull(value);
		assertEquals(3, value.getInteger());
		value = (PIntegerValue)cxt.getFieldStackMap().popField("field2");
		assertNotNull(value);
		assertEquals(2, value.getInteger());
		value = (PIntegerValue)cxt.getFieldStackMap().popField("field1");
		assertNotNull(value);
		assertEquals(1, value.getInteger());
		value = (PIntegerValue)cxt.getFieldStackMap().popField("field1");
		assertNull(value);
		value = (PIntegerValue)cxt.getFieldStackMap().popField("field2");
		assertNull(value);
	}
	
	public void testFieldRefDesc() {
		FieldRefDesc desc;
		//DataLenghtHyp.data1 -data1Length
		desc = FieldRefDesc.parse("-data1Length", 
				BuiltintestModule.INSTANCE.getDataLengthHyp(), 
				BuiltintestModule.INSTANCE.getInteger(), null);
		assertEquals(FieldRefDesc.Type.STACK, desc.getType());
		assertEquals("data1Length", ((StackFieldRefDesc)desc).getFieldName());
		assertEquals(0, ((StackFieldRefDesc)desc).getPath().getFragments().length);
		//StringBlock.lines1 ^lines1Count/token1
		desc = FieldRefDesc.parse("^lines1Count/token1", 
				BuiltintestModule.INSTANCE.getStringBlock(), 
				BuiltintestModule.INSTANCE.getStringOneLine(), null);
		assertEquals(FieldRefDesc.Type.OWNER_FIELD, desc.getType());
		assertEquals(2, ((OwnerFieldRefDesc)desc).getPath().getFragments().length);
		assertEquals("lines1Count", ((OwnerFieldRefDesc)desc).getPath().getFragments()[0].getFieldMeta().getFieldName());
		assertEquals("token1", ((OwnerFieldRefDesc)desc).getPath().getFragments()[1].getFieldMeta().getFieldName());
		//DataLenghtHyp +totalLength
		desc = FieldRefDesc.parse("+totalLength", 
				BuiltintestModule.INSTANCE.getDataLengthHyp(), 
				BuiltintestModule.INSTANCE.getDataLengthHyp(), null);
		assertEquals(FieldRefDesc.Type.TYPE_FIELD, desc.getType());
		assertEquals(1, ((TypeFieldRefDesc)desc).getPath().getFragments().length);
		assertEquals("totalLength", ((TypeFieldRefDesc)desc).getPath().getFragments()[0].getFieldMeta().getFieldName());
		//UnionBlock1 $code
		desc = FieldRefDesc.parse("$code", 
				BuiltintestModule.INSTANCE.getDataLengthHyp(), 
				BuiltintestModule.INSTANCE.getInteger(), null);
		assertEquals(FieldRefDesc.Type.CONTEXT_ATTRIBUTE, desc.getType());
		assertEquals("code", ((CxtAttrFieldRefDesc)desc).getAttrName());
		assertEquals(0, ((CxtAttrFieldRefDesc)desc).getPath().getFragments().length);
		//UnionBlock1 $code/token1
		desc = FieldRefDesc.parse("$code/token1", 
				BuiltintestModule.INSTANCE.getDataLengthHyp(), 
				BuiltintestModule.INSTANCE.getStringOneLine(), null);
		assertEquals(FieldRefDesc.Type.CONTEXT_ATTRIBUTE, desc.getType());
		assertEquals("code", ((CxtAttrFieldRefDesc)desc).getAttrName());
		assertEquals(1, ((CxtAttrFieldRefDesc)desc).getPath().getFragments().length);
		assertEquals("token1", ((CxtAttrFieldRefDesc)desc).getPath().getFragments()[0].getFieldMeta().getFieldName());
		//TestDecodeResult @oneline/token1
		desc = FieldRefDesc.parse("@oneLine/token1", BuiltintestModule.INSTANCE.getStringOneLine(), 
				BuiltintestModule.INSTANCE.getStringOneLine(), 
				TestDecodeResult.class);
		assertEquals(FieldRefDesc.Type.RESULT_PROPERTY, desc.getType());
		assertEquals("getOneLine", ((ResultPrpFieldRefDesc)desc).getReadMethod().getName());
		assertEquals(1, ((ResultPrpFieldRefDesc)desc).getPath().getFragments().length);
		assertEquals("token1", ((ResultPrpFieldRefDesc)desc).getPath().getFragments()[0].getFieldMeta().getFieldName());
	}
	
	public void testParsePPath() throws Exception {
		BuiltintestFactory factory = BuiltintestFactory.INSTANCE;
		StringBlock strBlock = factory.createStringBlock();
		strBlock.getLines1Count().getToken1().setText("123");
		strBlock.getFirst3line().setItem(2, factory.createStringOneLine());
		strBlock.getFirst3line().getItem(2).getToken1().setText("456");
		//field/field
		String desc = "lines1Count/token1";
		PPath path = PPath.parse(desc, BuiltintestModule.INSTANCE.getStringBlock());
//		System.out.println(path);
		assertEquals(BuiltintestModule.STRING_TOKEN, path.getRefFieldType().getID());
		PValue resultValue = path.findField((PValue)strBlock);
		assertNotNull(resultValue);
		assertTrue(resultValue instanceof PCharstringValue);
		assertEquals("123", ((PCharstringValue)resultValue).getText());

		//listFeild
		desc = "first3Line";
		path = PPath.parse(desc, BuiltintestModule.INSTANCE.getStringBlock());
		assertEquals(BuiltintestModule.STRING_MULTI_LINE_FIX, path.getRefFieldType().getID());
		resultValue = path.findField((PValue)strBlock);
		assertNotNull(resultValue);
		assertTrue(resultValue instanceof PListValue<?>);
		assertEquals(3, ((PListValue<?>)resultValue).getLength());
		
		//listFeild element[index]/field
		desc = "first3Line[2]/token1";
		path = PPath.parse(desc, BuiltintestModule.INSTANCE.getStringBlock());
		assertEquals(BuiltintestModule.STRING_TOKEN, path.getRefFieldType().getID());
		resultValue = path.findField((PValue)strBlock);
		assertNotNull(resultValue);
		assertTrue(resultValue instanceof PCharstringValue);
		assertEquals("456", ((PCharstringValue)resultValue).getText());
		
		//listFeild [index]/token1
		desc = "[2]/token1";
		path = PPath.parse(desc, ((PContainerTypeExt)BuiltintestModule.INSTANCE.getStringBlock())
				.getFieldMeta(BuiltintestModule.STRING_BLOCK__FIRST3_LINE).getType());
		assertEquals(BuiltintestModule.STRING_TOKEN, path.getRefFieldType().getID());
//		System.out.println(path);
		resultValue = path.findField((PValue)strBlock.getFirst3line());
		assertNotNull(resultValue);
		assertTrue(resultValue instanceof PCharstringValue);
		assertEquals("456", ((PCharstringValue)resultValue).getText());
		
	}
	
	public void testIPath() throws Exception {
		BuiltintestFactory factory = BuiltintestFactory.INSTANCE;
		//listFeild element[index]/field
		StringBlock strBlock = factory.createStringBlock();
		strBlock.getLines1Count().getToken1().setText("123");
		strBlock.getFirst3line().setItem(0, factory.createStringOneLine());
		strBlock.getFirst3line().getItem(0).getToken1().setText("44");
		strBlock.getFirst3line().setItem(1, factory.createStringOneLine());
		strBlock.getFirst3line().getItem(1).getToken1().setText("55");
		strBlock.getFirst3line().setItem(2, factory.createStringOneLine());
		strBlock.getFirst3line().getItem(2).getToken1().setText("66");
		assertEquals("44", strBlock.findField("first3Line[0]/token1").getText());
		assertEquals("55", strBlock.findField("first3Line[1]/token1").getText());
		assertEquals("66", strBlock.findField("first3Line[2]/token1").getText());
		assertNull(strBlock.findField("first3Line[3]/token1"));
	}
	
	
	public static class TestDecodeResult extends SimpleDecodeResult {
		private StringOneLine oneLine;

		public StringOneLine getOneLine() {
			return oneLine;
		}

		public void setOneLine(StringOneLine oneLine) {
			this.oneLine = oneLine;
		}
		
	}
}
