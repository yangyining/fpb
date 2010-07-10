package fpbtest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.IFpbSystem;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.value.IBitstringValue;
import com.fineqt.fpb.lib.api.value.IBooleanValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.api.value.IUnionValue;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.context.DebugDecodeContext;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;

import fpbtest.module.compacttest.CompacttestModule;

public class CompacttestModuleTest extends TestCase {
	public void testCreateObj() throws Exception {
		IFactory factory = IModuleRegistry.INSTANCE.resolveFactory(
				CompacttestModule.MODULE_NAME);
		//Builtin
		IIntegerValue intValue = (IIntegerValue)factory.createValue(Names.PINTEGER);
		intValue.setInteger(1);
		assertEquals(false, intValue.notPresent());
		assertEquals(1, intValue.getInteger());
//		System.out.println(CompacttestModule.INSTANCE);
		//Record DataLengthHyp
		IRecordSetValue dlhObj = (IRecordSetValue)factory.createValue(Names.DATA_LENGTH_HYP);
		assertEquals(false, dlhObj.getField(Names.DATA_LENGTH_HYP__TOTAL_LENGTH).notPresent());
		assertEquals(false, dlhObj.getField(Names.DATA_LENGTH_HYP__DATA2_FLAG).notPresent());
		assertEquals(true, ((IBooleanValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA2_FLAG)).getBoolean());
		assertEquals(false, dlhObj.getField(Names.DATA_LENGTH_HYP__DATA1).notPresent());
		assertEquals("'0101'B", ((IBitstringValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA1)).getString());
		assertEquals(false, dlhObj.getField(Names.DATA_LENGTH_HYP__PAD).notPresent());
		assertEquals(false, dlhObj.getField(Names.DATA_LENGTH_HYP__DATA2).notPresent());
		assertEquals(true, dlhObj.getField(Names.DATA_LENGTH_HYP__DATA3).notPresent());
		assertEquals(4, ((IOctetstringValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA2)).getLength());
		assertEquals("'FFFF0000'O", ((IOctetstringValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA2)).getString());
		
		//clone
		((IIntegerValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA1_LENGTH)).setInteger(10);
		IRecordSetValue newDlhObj = (IRecordSetValue)dlhObj.clone();
		((IIntegerValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__DATA1_LENGTH)).setInteger(100);
		assertEquals(10, ((IIntegerValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA1_LENGTH)).getInteger());
		assertEquals(100, ((IIntegerValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__DATA1_LENGTH)).getInteger());
		
		//Record StringOneLine
		IRecordSetValue solObj = (IRecordSetValue)factory.createValue(Names.STRING_ONE_LINE);
		assertEquals(false, solObj.getField(Names.STRING_ONE_LINE__TOKEN1).notPresent());
		assertEquals(false, solObj.getField(Names.STRING_ONE_LINE__WS1).notPresent());
		assertEquals(false, solObj.getField(Names.STRING_ONE_LINE__TOKEN2).notPresent());
		
		//RecordOf StringMultiLineFix
		IListValue<IValue> smlfObj = (IListValue<IValue>)factory.createValue(Names.STRING_MULTI_LINE_FIX);
		assertEquals(3, smlfObj.getLength());
		for (int i = 0; i < 3; i++) {
			assertEquals(null, ((IRecordSetValue)smlfObj.getItem(i)));
		}
		
		//RecordOf StringMultiLineVar
		IListValue<IValue> smlvObj = (IListValue<IValue>)factory.createValue(Names.STRING_MULTI_LINE_VAR);
		assertEquals(0, smlvObj.getLength());
		
		//StringBlock
		IRecordSetValue sbObj = (IRecordSetValue)factory.createValue(Names.STRING_BLOCK);
		assertEquals(false, sbObj.getField(Names.STRING_BLOCK__LINES1_COUNT).notPresent());
		assertEquals(false, sbObj.getField(Names.STRING_BLOCK__FIRST3_LINE).notPresent());
		assertEquals(3, ((IListValue<IValue>)sbObj.getField(Names.STRING_BLOCK__FIRST3_LINE)).getLength());
		assertEquals(false, sbObj.getField(Names.STRING_BLOCK__LINES1).notPresent());
		assertEquals(0, ((IListValue<IValue>)sbObj.getField(Names.STRING_BLOCK__LINES1)).getLength());
		assertEquals(false, sbObj.getField(Names.STRING_BLOCK__LINES2).notPresent());
		assertEquals(1, ((IListValue<IValue>)sbObj.getField(Names.STRING_BLOCK__LINES2)).getLength());
		
		//CaseRecord
		IRecordSetValue crObj = (IRecordSetValue)factory.createValue(Names.CASE_RECORD);
		assertEquals(false, crObj.getField(Names.CASE_RECORD__CODE).notPresent());
		assertEquals(false, crObj.getField(Names.CASE_RECORD__DATA).notPresent());
		
		//UnionBlock1
		IUnionValue ub1Obj = (IUnionValue)factory.createValue(Names.UNION_BLOCK1);
		assertEquals("case1", ub1Obj.getPresentVariantName());
		assertEquals(false, ub1Obj.getField("case1").notPresent());
		assertNull(((IValue)ub1Obj.getField("case2")));
		IRecordSetValue case2 = (IRecordSetValue)factory.createValue(Names.CASE2);
		((IIntegerValue)case2.getField(Names.CASE_RECORD__CODE)).setInteger(2);
		((IIntegerValue)case2.getField(Names.CASE_RECORD__DATA)).setInteger(20);
		ub1Obj.setField(Names.UNION_BLOCK1__CASE2, case2);
		assertEquals("case2", ub1Obj.getPresentVariantName());
		assertNotNull(ub1Obj.getField(Names.UNION_BLOCK1__CASE2));
		IRecordSetValue newCase2 = (IRecordSetValue)ub1Obj.getField(Names.UNION_BLOCK1__CASE2);
		assertFalse(newCase2.notPresent());
		assertFalse(newCase2.getField(Names.CASE_RECORD__CODE).notPresent());
		assertFalse(newCase2.getField(Names.CASE_RECORD__DATA).notPresent());
		assertEquals(2, ((IIntegerValue)newCase2.getField(Names.CASE_RECORD__CODE)).getInteger());
		assertEquals(20, ((IIntegerValue)newCase2.getField(Names.CASE_RECORD__DATA)).getInteger());
		
		//Case1, Case2, Case3
		IRecordSetValue case1Obj = (IRecordSetValue)factory.createValue(Names.CASE1);
		assertEquals(false, case1Obj.getField(Names.CASE1__CODE).notPresent());
		assertEquals(false, case1Obj.getField(Names.CASE1__DATA).notPresent());
		IRecordSetValue case2Obj = (IRecordSetValue)factory.createValue(Names.CASE2);
		assertEquals(false, case2Obj.getField(Names.CASE2__CODE).notPresent());
		assertEquals(false, case2Obj.getField(Names.CASE2__DATA).notPresent());
		IRecordSetValue case3Obj = (IRecordSetValue)factory.createValue(Names.CASE3);
		assertEquals(false, case3Obj.getField(Names.CASE3__CODE).notPresent());
		assertEquals(false, case3Obj.getField(Names.CASE3__DATA).notPresent());
		
		//UnionBlock2
		IUnionValue ub2Obj = (IUnionValue)factory.createValue(Names.UNION_BLOCK2);
		assertEquals("case1", ub2Obj.getPresentVariantName());
		assertEquals(false, ub2Obj.getField("case1").notPresent());
		assertNull(((IValue)ub2Obj.getField("case2")));
		
		//SetBlock1
		IRecordSetValue sb1Obj = (IRecordSetValue)factory.createValue(Names.SET_BLOCK1);
		assertEquals(false, sb1Obj.getField(Names.SET_BLOCK1__CASE1).notPresent());
		assertEquals(true, sb1Obj.getField(Names.SET_BLOCK1__CASE2).notPresent());
		
	}

	public void testEncodeDecode() throws Exception {
		try {
			doTestEncodeDecode();
		} catch (DecodeException e) {
			if (IFpbSystem.INSTANCE.isDebug()) {
				DebugDecodeContext dcxt = (DebugDecodeContext)e.getDecodeContext();
				for (DecodeResult result : dcxt.getNotChainedResults()) {
					System.out.println(result);
				}
//				for (DecodeResult result : dcxt.getAllResults()) {
//					System.out.println(result);
//				}
				System.out.println(dcxt);
			}
			throw e;
		}
		
	}
	
	public void doTestEncodeDecode() throws Exception {
		doRecordEncodeDecode();
		
	}

	private void doRecordEncodeDecode() throws EncodeException,	DecodeException {
		IFactory factory = (IFactory)IModuleRegistry.INSTANCE.resolveFactory(
				CompacttestModule.MODULE_NAME);
		IValueSerializer ser = IValueSerializer.INSTANCE;
		IModule module = (IModule)IModuleRegistry.INSTANCE.resolveModule(
				CompacttestModule.MODULE_NAME);
		byte[] data;
		TextBitset bitset;
		IRecordSetValue newDlhObj;
		IRecordSetValue dlhObj;
		IOctetstringValue data3;
		//DataLengthHyp(encode) without omit
		dlhObj = (IRecordSetValue)factory.createValue(Names.DATA_LENGTH_HYP);
		data3 = (IOctetstringValue)factory.createValue(Names.POCTETSTRING);
		data3.setText("AABBCC");
		dlhObj.setField("data3", data3);
		int len  = ser.calculate(dlhObj);
		assertEquals(11, ((IIntegerValue)dlhObj.getField(Names.DATA_LENGTH_HYP__TOTAL_LENGTH)).getInteger());
		assertEquals(1, ((IIntegerValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA1_LENGTH)).getInteger());
		assertEquals(true, ((IBooleanValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA2_FLAG)).getBoolean());
		assertEquals("0101", ((IBitstringValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA1)).getText());
		assertEquals("101", ((IBitstringValue)dlhObj.getField(Names.DATA_LENGTH_HYP__PAD)).getText());
		assertEquals("FFFF0000", ((IOctetstringValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA2)).getText());
		assertEquals("AABBCC", ((IOctetstringValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA3)).getText());
		assertEquals(88, len);
//		IValueDumper.INSTANCE.dump(dlhObj);
		data = ser.encode(dlhObj, false);
		bitset = new NativeTextBitset(data);
		assertEquals("0B0001ADFFFF0000AABBCC", bitset.get(TextBitset.HEX));
		//DataLengthHyp(decode) without omit
		newDlhObj = (IRecordSetValue)ser.decode(data, module.getType(Names.DATA_LENGTH_HYP));
		assertNotNull(newDlhObj);
		//System.out.println(newDlhObj);
		assertEquals(11, ((IIntegerValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__TOTAL_LENGTH)).getInteger());
		assertEquals(1, ((IIntegerValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__DATA1_LENGTH)).getInteger());
		assertEquals(true, ((IBooleanValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__DATA2_FLAG)).getBoolean());
		assertEquals("0101", ((IBitstringValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__DATA1)).getText());
		assertEquals("101", ((IBitstringValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__PAD)).getText());
		assertEquals("FFFF0000", ((IOctetstringValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__DATA2)).getText());
		assertEquals("AABBCC", ((IOctetstringValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__DATA3)).getText());
		
		//DataLengthHyp(encode) with omit
		dlhObj = (IRecordSetValue)factory.createValue(Names.DATA_LENGTH_HYP);
		dlhObj.setFieldOmitted("data2");
		((IBooleanValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA2_FLAG)).setBoolean(false);
		len  = ser.calculate(dlhObj);
		assertEquals(4, ((IIntegerValue)dlhObj.getField(Names.DATA_LENGTH_HYP__TOTAL_LENGTH)).getInteger());
		assertEquals(1, ((IIntegerValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA1_LENGTH)).getInteger());
		assertEquals(false, ((IBooleanValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA2_FLAG)).getBoolean());
		assertEquals("0101", ((IBitstringValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA1)).getText());
		assertEquals("101", ((IBitstringValue)dlhObj.getField(Names.DATA_LENGTH_HYP__PAD)).getText());
		assertTrue(((IOctetstringValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA2)).notPresent());
		assertTrue(((IOctetstringValue)dlhObj.getField(Names.DATA_LENGTH_HYP__DATA3)).notPresent());
		assertEquals(32, len);
		data = ser.encode(dlhObj, false);
		bitset = new NativeTextBitset(data);
		assertEquals("0400012D", bitset.get(TextBitset.HEX));
		//DataLengthHyp(decode) with omit
		newDlhObj = (IRecordSetValue)ser.decode(data, module.getType(Names.DATA_LENGTH_HYP));
		assertNotNull(newDlhObj);
		//System.out.println(newDlhObj);
		assertEquals(4, ((IIntegerValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__TOTAL_LENGTH)).getInteger());
		assertEquals(1, ((IIntegerValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__DATA1_LENGTH)).getInteger());
		assertEquals(false, ((IBooleanValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__DATA2_FLAG)).getBoolean());
		assertEquals("0101", ((IBitstringValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__DATA1)).getText());
		assertEquals("101", ((IBitstringValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__PAD)).getText());
		assertTrue(((IOctetstringValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__DATA2)).notPresent());
		assertTrue(((IOctetstringValue)newDlhObj.getField(Names.DATA_LENGTH_HYP__DATA3)).notPresent());
	}
	
	interface Names extends CompacttestModule.Names{
	}
	
	
}
