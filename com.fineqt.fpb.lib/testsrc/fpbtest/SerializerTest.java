package fpbtest;

import static com.fineqt.fpb.lib.util.SerializeUtil.decodeInt4fpb;
import static com.fineqt.fpb.lib.util.SerializeUtil.encodeInt4fpb;

import java.math.BigInteger;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.IFpbSystem;
import com.fineqt.fpb.lib.api.util.buffer.IReadWritableBitBuffer;
import com.fineqt.fpb.lib.api.value.IEnumeratedValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.api.value.IUnionValue;
import com.fineqt.fpb.lib.builtin.PBitstringValue;
import com.fineqt.fpb.lib.builtin.PBooleanValue;
import com.fineqt.fpb.lib.builtin.PHexstringValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.context.DebugDecodeContext;
import com.fineqt.fpb.lib.meta.util.PValueDumper;
import com.fineqt.fpb.lib.meta.util.PValueSerializer;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;
import com.fineqt.fpb.lib.util.buffer.SimpleBitBuffer;
import com.fineqt.fpb.lib.value.PUnionValue;
import com.fineqt.fpb.lib.value.PValue;

import fpbtest.module.builtintest.BuiltintestFactory;
import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.CaseRecord;
import fpbtest.module.builtintest.DataLengthHyp;
import fpbtest.module.builtintest.EnumRefRecord;
import fpbtest.module.builtintest.LEndianRecord;
import fpbtest.module.builtintest.Protocol1;
import fpbtest.module.builtintest.Protocol2;
import fpbtest.module.builtintest.Protocol3;
import fpbtest.module.builtintest.SetBlock1;
import fpbtest.module.builtintest.StringBlock;
import fpbtest.module.builtintest.StringOneLine;
public class SerializerTest extends TestCase {
	
	public void testCalculateAndSize() throws Exception {
		BuiltintestFactory factory = BuiltintestFactory.INSTANCE;
		PValueSerializer ser = PValueSerializer.PINSTANCE;
//		System.out.println(BuiltintestModule.INSTANCE);
		//DataLengthHyp(calculate)
		DataLengthHyp dlhObj = factory.createDataLengthHyp();
//		System.out.println(dlhObj);
		assertEquals(0, dlhObj.getTotalLength().getInteger());
		assertEquals(0, dlhObj.getData1Length().getInteger());
		assertEquals(0, dlhObj.getPad().getLength());
		int len = ser.calculate((PValue)dlhObj);
//		System.out.println(dlhObj);
		assertEquals(64, len);
		assertEquals("101", dlhObj.getPad().getText());
		assertEquals(8, dlhObj.getTotalLength().getInteger());
		assertEquals(1, dlhObj.getData1Length().getInteger());

		//DataLengthHyp(size only)
		dlhObj = factory.createDataLengthHyp();
		len = ser.getSize((PValue)dlhObj);
		assertEquals(64, len);
		assertEquals("", dlhObj.getPad().getText());
		assertEquals(0, dlhObj.getTotalLength().getInteger());
		assertEquals(0, dlhObj.getData1Length().getInteger());
		
		//StringBlock(calculate)
		StringBlock sbObj = createStringBlock(factory);
		assertEquals("", sbObj.getLines1Count().getToken1().getText());
		assertEquals(2, sbObj.getLines1().getLength());
		len = ser.calculate((PValue)sbObj);
//		System.out.println(sbObj);
//		dumper.dump(sbObj);
		assertEquals("2", sbObj.getLines1Count().getToken1().getText());
		assertEquals(3*8 + 3*3*8 + 2*3*8 + 1*3*8 + 8, len);
		
		//StringBlock(size only)
		sbObj = createStringBlock(factory);
		len = ser.getSize((PValue)sbObj);
		assertEquals("", sbObj.getLines1Count().getToken1().getText());
		assertEquals(2*8 + 3*3*8 + 2*3*8 + 1*3*8 + 8, len);
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

	static BuiltintestFactory factory = BuiltintestFactory.INSTANCE;
	static BuiltintestModule module = BuiltintestModule.INSTANCE;
	static PValueSerializer ser = PValueSerializer.PINSTANCE;
	static PValueDumper dumper = PValueDumper.PINSTANCE;

	public void doTestEncodeDecode() throws Exception {
		doRecordEncodeDecode();
		
		doTextListEncodeDecode();
		
		doUnionEncodeDecode();
		
		doSetEncodeDecode();
		
		doProtocolStack();
		
		doLittleEndianEncodeDecode();
		
		doEnumField();
		
		doListEncodeDecode();
	}

	private void doListEncodeDecode() throws Exception {
		byte[] data;
		TextBitset bitset;
		IListValue<IIntegerValue> list = factory.createUint16List();
		list.setLength(2);
		list.getItem(0, true).setInteger(1);
		list.getItem(1, true).setInteger(2);
		//encode
		data = ser.encode((PValue)list, false);
		bitset = new NativeTextBitset(data);
		assertEquals("00010002", bitset.get(TextBitset.HEX));
		//decode
		@SuppressWarnings("unchecked")
		IListValue<IIntegerValue> newList = (IListValue<IIntegerValue>)ser.decode(data, module.getUint16List());
		assertEquals(2, newList.getLength());
		assertEquals(1, newList.getItem(0).getInteger());
		assertEquals(2, newList.getItem(1).getInteger());
	}
	
	private void doEnumField() throws Exception {
//	    System.out.println(module);
		byte[] data;
		TextBitset bitset;
		EnumRefRecord refRecord = factory.createEnumRefRecord();
		IEnumeratedValue fieldName = refRecord.getFieldName();
		IIntegerValue intValue = factory.createInteger();
		intValue.setInteger(0x0202);
		refRecord.setField(BuiltintestModule.ENUM_REF_RECORD__FIELD2, intValue);
		assertFalse(fieldName.notPresent());
		assertEquals(BuiltintestModule.FIELD_NAME__FIELD2, fieldName.getEnumID());
		assertEquals(BuiltintestModule.Names.FIELD_NAME__FIELD2, fieldName.getEnumName());
		assertEquals(20, fieldName.getEnumValue());
//		dumper.dump(refRecord);
		//encode
		data = ser.encode((PValue)refRecord, false);
		bitset = new NativeTextBitset(data);
		assertEquals("140202", bitset.get(TextBitset.HEX));
		//decode
		EnumRefRecord newRefRecord = (EnumRefRecord)ser.decode(data, module.getEnumRefRecord());
//		dumper.dump(newRefRecord);
		fieldName = newRefRecord.getFieldName();
		assertFalse(fieldName.notPresent());
		assertEquals(BuiltintestModule.FIELD_NAME__FIELD2, fieldName.getEnumID());
		assertEquals(BuiltintestModule.Names.FIELD_NAME__FIELD2, fieldName.getEnumName());
		assertEquals(20, fieldName.getEnumValue());
		assertTrue(newRefRecord.getField1().notPresent());
		assertFalse(newRefRecord.getField2().notPresent());
		assertEquals(0x0202, newRefRecord.getField2().getInteger());
	}
	
	private void doProtocolStack() throws Exception {
		byte[] data;
		TextBitset bitset;
		// protocol1/protocol2
		Protocol1 prtl1 = factory.createProtocol1();
		prtl1.getPrefix().setInteger(0x11);
		prtl1.getPrtlcode().setInteger(0x20);
		Protocol2 prtl2 = factory.createProtocol2();
		prtl2.getData().setInteger(0x3344);
		prtl1.getPayload().setField(BuiltintestModule.PAYLOAD1__PRTL2, prtl2);
		data = ser.encode((PValue)prtl1, false);
		bitset = new NativeTextBitset(data);
		assertEquals("11203344", bitset.get(TextBitset.HEX));
//		dumper.dump(prtl1);
		
		Protocol1 newPrtl1 = (Protocol1)ser.decode(data, module.getProtocol1());
		assertFalse(newPrtl1.notPresent());
		assertEquals(0x11, newPrtl1.getPrefix().getInteger());
		assertEquals(0x20, newPrtl1.getPrtlcode().getInteger());
		assertFalse(newPrtl1.getPayload().notPresent());
		assertEquals("prtl2", newPrtl1.getPayload().getPresentVariantName());
		prtl2 = (Protocol2)newPrtl1.getPayload().getPresentVariant();
		assertFalse(prtl2.notPresent());
		assertEquals(0x3344, prtl2.getData().getInteger());
		
		// protocol1/protocol3
		prtl1 = factory.createProtocol1();
		prtl1.getPrefix().setInteger(0x11);
		prtl1.getPrtlcode().setInteger(0x0);
		Protocol3 prtl3 = factory.createProtocol3();
		assertEquals(0x3000, prtl3.getPrefix().getInteger());
		prtl3.getData().setText("3344");
		prtl1.getPayload().setField(BuiltintestModule.PAYLOAD1__PRTL3, prtl3);
		data = ser.encode((PValue)prtl1, false);
		bitset = new NativeTextBitset(data);
		assertEquals("110030003344", bitset.get(TextBitset.HEX));
		
		newPrtl1 = (Protocol1)ser.decode(data, module.getProtocol1());
		assertFalse(newPrtl1.notPresent());
		assertEquals(0x11, newPrtl1.getPrefix().getInteger());
		assertEquals(0x0, newPrtl1.getPrtlcode().getInteger());
		assertFalse(newPrtl1.getPayload().notPresent());
		assertEquals("prtl3", newPrtl1.getPayload().getPresentVariantName());
		prtl3 = (Protocol3)newPrtl1.getPayload().getPresentVariant();
		assertFalse(prtl3.notPresent());
		assertEquals("3344", prtl3.getData().getText());
		
		// protocol1/data
		prtl1 = factory.createProtocol1();
		prtl1.getPrefix().setInteger(0x11);
		prtl1.getPrtlcode().setInteger(0x0);
		POctetstringValue payloadData = (POctetstringValue)factory.createOctetstring();
		payloadData.setText("3344");
		prtl1.getPayload().setField(BuiltintestModule.PAYLOAD1__DATA, payloadData);
		data = ser.encode((PValue)prtl1, false);
		bitset = new NativeTextBitset(data);
		assertEquals("11003344", bitset.get(TextBitset.HEX));
		
		newPrtl1 = (Protocol1)ser.decode(data, module.getProtocol1());
		assertFalse(newPrtl1.notPresent());
		assertEquals(0x11, newPrtl1.getPrefix().getInteger());
		assertEquals(0x0, newPrtl1.getPrtlcode().getInteger());
		assertFalse(newPrtl1.getPayload().notPresent());
		assertEquals("data", newPrtl1.getPayload().getPresentVariantName());
		payloadData = (POctetstringValue)newPrtl1.getPayload().getPresentVariant();
		assertEquals("3344", payloadData.getText());
	}
	
	private void doSetEncodeDecode() throws Exception {
		byte[] data;
		TextBitset bitset;
		//SetBlock1(encode)
		SetBlock1 sb1Obj = factory.createSetBlock1();
		sb1Obj.getCase1().getCode().setInteger(1);
		sb1Obj.getCase1().getData().setInteger(10);
		CaseRecord case2 = factory.createCase2();
		case2.getCode().setInteger(2);
		case2.getData().setInteger(20);
		sb1Obj.setField(BuiltintestModule.SET_BLOCK1__CASE2, case2);
		data = ser.encode((PValue)sb1Obj, false);
		bitset = new NativeTextBitset(data);
		assertEquals("01000A020014", bitset.get(TextBitset.HEX));
		//SetBlock1(decode)
		SetBlock1 newSb1Obj = (SetBlock1)ser.decode(data, module.getSetBlock1());
		assertFalse(newSb1Obj.notPresent());
		assertFalse(newSb1Obj.getCase1().notPresent());
		assertEquals(1, newSb1Obj.getCase1().getCode().getInteger());
		assertEquals(10, newSb1Obj.getCase1().getData().getInteger());
		assertFalse(newSb1Obj.getCase2().notPresent());
		assertEquals(2, newSb1Obj.getCase2().getCode().getInteger());
		assertEquals(20, newSb1Obj.getCase2().getData().getInteger());
		
		//SetBlock1(encode)
		sb1Obj = factory.createSetBlock1();
		sb1Obj.getCase1().getCode().setInteger(1);
		sb1Obj.getCase1().getData().setInteger(10);
		data = ser.encode((PValue)sb1Obj, false);
		bitset = new NativeTextBitset(data);
		assertEquals("01000A", bitset.get(TextBitset.HEX));
		//SetBlock1(decode)
		newSb1Obj = (SetBlock1)ser.decode(data, module.getSetBlock1());
		assertFalse(newSb1Obj.notPresent());
		assertFalse(newSb1Obj.getCase1().notPresent());
		assertEquals(1, newSb1Obj.getCase1().getCode().getInteger());
		assertEquals(10, newSb1Obj.getCase1().getData().getInteger());
		assertTrue(newSb1Obj.getCase2().notPresent());
		
		//TODO decode not by caseRef case
		
	}
	
	private void doUnionEncodeDecode() throws EncodeException, DecodeException {
		byte[] data;
		TextBitset bitset;
		//UnionBlock1(encode)
		IUnionValue ub1Obj = factory.createUnionBlock1();
		CaseRecord case2 = factory.createCase2();
		case2.getCode().setInteger(2);
		case2.getData().setInteger(20);
		ub1Obj.setField(BuiltintestModule.UNION_BLOCK1__CASE2, case2);
		data = ser.encode((PValue)ub1Obj, false);
		bitset = new NativeTextBitset(data);
		assertEquals("020014", bitset.get(TextBitset.HEX));
		//UnionBlock1(decode)
		PUnionValue newUb1Obj = (PUnionValue)ser.decode(data, module.getUnionBlock1());
		assertEquals("case2", newUb1Obj.getPresentVariantName());
		CaseRecord newCase2 = (CaseRecord)newUb1Obj.pGetPresentVariant();
		assertFalse(newCase2.notPresent());
		assertFalse(newCase2.getCode().notPresent());
		assertFalse(newCase2.getData().notPresent());
		assertEquals(2, newCase2.getCode().getInteger());
		assertEquals(20, newCase2.getData().getInteger());
		
		//TODO decode not by caseRef case
		
	}

	private void doLittleEndianEncodeDecode() throws EncodeException,
			DecodeException {
		byte[] data;
		TextBitset bitset;
		//LEndianRecord(encode)
		LEndianRecord lerObj = factory.createLEndianRecord();
		lerObj.getInt1().setInteger(0x1);
		lerObj.getFlag().setBoolean(true);
		lerObj.getBits().setText("010");
		lerObj.getInt2().setInteger(0x33);
		lerObj.getInt3().setInteger(0x4455);
		PHexstringValue hexsObj = (PHexstringValue)factory.createHexstring();
		hexsObj.setText("ABCD");
		lerObj.setField(BuiltintestModule.LENDIAN_RECORD__HEXS, hexsObj);
		data = ser.encode((PValue)lerObj, false);
		bitset = new NativeTextBitset(data);
		assertEquals("331A5544ABCD", bitset.get(TextBitset.HEX));
		//LEndianRecord(decode)
		LEndianRecord newLerObj = (LEndianRecord)ser.decode(data, module.getLEndianRecord());
		assertNotNull(newLerObj);
		assertEquals(0x1, newLerObj.getInt1().getInteger());
		assertEquals(true, newLerObj.getFlag().getBoolean());
		assertEquals("010", newLerObj.getBits().getText());
		assertEquals(0x33, newLerObj.getInt2().getInteger());
		assertEquals(0x4455, newLerObj.getInt3().getInteger());
		assertFalse(newLerObj.getHexs().notPresent());
		assertEquals("ABCD", newLerObj.getHexs().getText());
	}

	private void doTextListEncodeDecode() throws EncodeException, DecodeException {
		byte[] data;
		TextBitset bitset;
		//StringOneLine
		StringOneLine solObj = factory.createStringOneLine();
		solObj.getToken1().setText("token1");
		solObj.getWs1().setText(" ");
		solObj.getToken2().setText("token2");
		data = ser.encode((PValue)solObj, false);
		bitset = new NativeTextBitset(data);
		assertEquals("746F6B656E3120746F6B656E320D0A", bitset.get(TextBitset.HEX));
		StringOneLine newSolObj = (StringOneLine)ser.decode(data, module.getStringOneLine());
		assertEquals("token1", newSolObj.getToken1().getText());
		assertEquals(" ", newSolObj.getWs1().getText());
		assertEquals("token2", newSolObj.getToken2().getText());
		
		//StringBlock(encode)
		StringBlock sbObj = createStringBlock(factory);
		ser.calculate((PValue)sbObj);
//		PValueDumper.PINSTANCE.dump(sbObj);
		assertEquals("2", sbObj.getLines1Count().getToken1().getText());
		assertEquals("", sbObj.getLines1Count().getWs1().getText());
		assertEquals("", sbObj.getLines1Count().getToken2().getText());
		assertEquals(3, sbObj.getFirst3line().getLength());
		assertEquals("0", sbObj.getFirst3line().getItem(0).getToken1().getText());
		assertEquals("1", sbObj.getFirst3line().getItem(1).getToken1().getText());
		assertEquals("2", sbObj.getFirst3line().getItem(2).getToken1().getText());
		assertEquals(2, sbObj.getLines1().getLength());
		assertEquals("0", sbObj.getLines1().getItem(0).getToken1().getText());
		assertEquals("1", sbObj.getLines1().getItem(1).getToken1().getText());
		assertEquals(1, sbObj.getLines2().getLength());
		assertEquals(" ", sbObj.getLines2().getItem(0).getWs1().getText());
		assertEquals("0", sbObj.getLines2().getItem(0).getToken2().getText());
		data = ser.encode((PValue)sbObj, false);
		bitset = new NativeTextBitset(data);
		assertEquals("320D0A300D0A310D0A320D0A300D0A310D0A20300D0A", bitset.get(TextBitset.HEX));
		//StringBlock(decode)
		StringBlock newSbObj = (StringBlock)ser.decode(data, module.getStringBlock());
		assertEquals("2", newSbObj.getLines1Count().getToken1().getText());
		assertEquals("", newSbObj.getLines1Count().getWs1().getText());
		assertEquals("", newSbObj.getLines1Count().getToken2().getText());
		assertEquals(3, newSbObj.getFirst3line().getLength());
		assertEquals("0", newSbObj.getFirst3line().getItem(0).getToken1().getText());
		assertEquals("1", newSbObj.getFirst3line().getItem(1).getToken1().getText());
		assertEquals("2", newSbObj.getFirst3line().getItem(2).getToken1().getText());
		assertEquals(2, newSbObj.getLines1().getLength());
		assertEquals("0", newSbObj.getLines1().getItem(0).getToken1().getText());
		assertEquals("1", newSbObj.getLines1().getItem(1).getToken1().getText());
		assertEquals(1, newSbObj.getLines2().getLength());
		assertEquals(" ", newSbObj.getLines2().getItem(0).getWs1().getText());
		assertEquals("0", newSbObj.getLines2().getItem(0).getToken2().getText());
	}

	private void doRecordEncodeDecode() throws EncodeException,
			DecodeException {
		byte[] data;
		TextBitset bitset;
		DataLengthHyp newDlhObj;
		DataLengthHyp dlhObj;
		POctetstringValue data3;
		//DataLengthHyp(encode) without omit
		dlhObj = factory.createDataLengthHyp();
		data3 = (POctetstringValue)factory.createOctetstring();
		data3.setText("AABBCC");
		dlhObj.setField("data3", data3);
		int len  = ser.calculate((PValue)dlhObj);
		assertEquals(11, dlhObj.getTotalLength().getInteger());
		assertEquals(1, dlhObj.getData1Length().getInteger());
		assertEquals(true, dlhObj.getData2Flag().getBoolean());
		assertEquals("0101", dlhObj.getData1().getText());
		assertEquals("101", dlhObj.getPad().getText());
		assertEquals("FFFF0000", dlhObj.getData2().getText());
		assertEquals("AABBCC", dlhObj.getData3().getText());
		assertEquals(88, len);
		data = ser.encode((PValue)dlhObj, false);
		bitset = new NativeTextBitset(data);
		assertEquals("0B0001ADFFFF0000AABBCC", bitset.get(TextBitset.HEX));
		//DataLengthHyp(decode) without omit
		newDlhObj = (DataLengthHyp)ser.decode(data, module.getDataLengthHyp());
		assertNotNull(newDlhObj);
//		System.out.println(newDlhObj);
		assertEquals(11, newDlhObj.getTotalLength().getInteger());
		assertEquals(1, newDlhObj.getData1Length().getInteger());
		assertEquals(true, newDlhObj.getData2Flag().getBoolean());
		assertEquals("0101", newDlhObj.getData1().getText());
		assertEquals("101", newDlhObj.getPad().getText());
		assertEquals("FFFF0000", newDlhObj.getData2().getText());
		assertEquals("AABBCC", newDlhObj.getData3().getText());

		//DataLengthHyp(encode) with omit
		dlhObj = factory.createDataLengthHyp();
		dlhObj.setFieldOmitted("data2");
		dlhObj.getData2Flag().setBoolean(false);
		len  = ser.calculate((PValue)dlhObj);
		assertEquals(4, dlhObj.getTotalLength().getInteger());
		assertEquals(1, dlhObj.getData1Length().getInteger());
		assertEquals(false, dlhObj.getData2Flag().getBoolean());
		assertEquals("0101", dlhObj.getData1().getText());
		assertEquals("101", dlhObj.getPad().getText());
		assertTrue(dlhObj.getData2().notPresent());
		assertTrue(dlhObj.getData3().notPresent());
		assertEquals(32, len);
		data = ser.encode((PValue)dlhObj, false);
		bitset = new NativeTextBitset(data);
		assertEquals("0400012D", bitset.get(TextBitset.HEX));
		//DataLengthHyp(decode) with omit
		newDlhObj = (DataLengthHyp)ser.decode(data, module.getDataLengthHyp());
		assertNotNull(newDlhObj);
//		System.out.println(newDlhObj);
		assertEquals(4, newDlhObj.getTotalLength().getInteger());
		assertEquals(1, newDlhObj.getData1Length().getInteger());
		assertEquals(false, newDlhObj.getData2Flag().getBoolean());
		assertEquals("0101", newDlhObj.getData1().getText());
		assertEquals("101", newDlhObj.getPad().getText());
		assertTrue(newDlhObj.getData2().notPresent());
		assertTrue(newDlhObj.getData3().notPresent());
	}
	
	public void testEmptyValue() throws Exception {
		BuiltintestFactory factory = BuiltintestFactory.INSTANCE;
		//DataLengthHyp
		PContainerTypeExt tmpType = (PContainerTypeExt)BuiltintestModule.INSTANCE.pPType(BuiltintestModule.DATA_LENGTH_HYP);
		PFieldExt fieldMeta;
		DataLengthHyp dlhObj = (DataLengthHyp)factory.createEmptyPValue(tmpType);
		//totalLength
		fieldMeta = tmpType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__TOTAL_LENGTH);
		PIntegerValue totalLength = (PIntegerValue)fieldMeta.createEmptyValue();
		totalLength.setInteger(10);
		dlhObj.setField(BuiltintestModule.DATA_LENGTH_HYP__TOTAL_LENGTH, totalLength);
		//data1Length
		fieldMeta = tmpType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__DATA1_LENGTH);
		PIntegerValue data1Length = (PIntegerValue)fieldMeta.createEmptyValue();
		data1Length.setInteger(20);
		dlhObj.setField(BuiltintestModule.DATA_LENGTH_HYP__DATA1_LENGTH, data1Length);
		//data2Flag
		fieldMeta = tmpType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__DATA2_FLAG);
		PBooleanValue data2Flag = (PBooleanValue)fieldMeta.createEmptyValue();
		data2Flag.setBoolean(true);
		dlhObj.setField(BuiltintestModule.DATA_LENGTH_HYP__DATA2_FLAG, data2Flag);
		//data1
		fieldMeta = tmpType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__DATA1);
		PBitstringValue data1 = (PBitstringValue)fieldMeta.createEmptyValue();
		dlhObj.setField(BuiltintestModule.DATA_LENGTH_HYP__DATA1, data1);
		//pad
		fieldMeta = tmpType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__PAD);
		PBitstringValue pad = (PBitstringValue)fieldMeta.createEmptyValue();
		dlhObj.setField(BuiltintestModule.DATA_LENGTH_HYP__PAD, pad);
		//data2
		fieldMeta = tmpType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__DATA2);
		POctetstringValue data2 = (POctetstringValue)fieldMeta.createEmptyValue();
		dlhObj.setField(BuiltintestModule.DATA_LENGTH_HYP__DATA2, data2);
		//data3
		fieldMeta = tmpType.getFieldMeta(BuiltintestModule.DATA_LENGTH_HYP__DATA3);
		POctetstringValue data3 = (POctetstringValue)fieldMeta.createOmitValue();
		dlhObj.setField(BuiltintestModule.DATA_LENGTH_HYP__DATA3, data3);
		assertEquals(10, dlhObj.getTotalLength().getInteger());
		assertEquals(20, dlhObj.getData1Length().getInteger());
		assertEquals(true, dlhObj.getData2Flag().getBoolean());
		assertEquals("''B", dlhObj.getData1().getString());
		assertEquals("''B", dlhObj.getPad().getString());
		assertEquals("''O", dlhObj.getData2().getString());
		assertEquals("omit", dlhObj.getData3().getString());
	}
	
	private StringBlock createStringBlock(BuiltintestFactory factory) {
		StringBlock sbObj = factory.createStringBlock();
		sbObj.getLines1().setLength(2);
		for (int i = 0; i < sbObj.getFirst3line().getLength(); i++) {
			StringOneLine oneline = factory.createStringOneLine();
			oneline.getToken1().setText(Integer.toString(i));
			sbObj.getFirst3line().setItem(i, oneline);
		}
		for (int i = 0; i < sbObj.getLines1().getLength(); i++) {
			StringOneLine oneline = factory.createStringOneLine();
			oneline.getToken1().setText(Integer.toString(i));
			sbObj.getLines1().setItem(i, oneline);
		}
		for (int i = 0; i < sbObj.getLines2().getLength(); i++) {
			StringOneLine oneline = factory.createStringOneLine();
			oneline.getWs1().setText(" ");
			oneline.getToken2().setText(Integer.toString(i));
			sbObj.getLines2().setItem(i, oneline);
		}
		return sbObj;
	}
	
	public void testFpbUtil() throws Exception {
		//byte
		doTestSerializeUtilByte();
		//short
		doTestSerializeUtilShort();
		//int
		doTestSerializeUtilInt();
	}

	private void doTestSerializeUtilByte() throws Exception {
		final int bit_len = 8; 
		BigInteger inputValue;
		BigInteger outputValue;
		IReadWritableBitBuffer buffer;
		//unsigned byte big_endian
		//255
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(255);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(255), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//0
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//16
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(16);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(16), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);

		//singed byte big_endian
		//-128
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(-128);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(-128), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//0
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//127
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(127);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(127), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		
		//unsigned byte little_endian
		//255
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(255);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(255), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//0
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//16
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(16);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(16), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);

		//singed byte little_endian
		//-128
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(-128);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(-128), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//0
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//127
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(127);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(127), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
	}
	
	private void doTestSerializeUtilShort()  throws Exception {
		final int bit_len = 16; 
		BigInteger inputValue;
		BigInteger outputValue;
		IReadWritableBitBuffer buffer;
		//unsigned big_endian
		//65535
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(65535);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0xFF), buffer.array()[0]);
		assertEquals((byte)(0xFF), buffer.array()[1]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//0
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[0]);
		assertEquals((byte)(0), buffer.array()[1]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//16
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(16);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[0]);
		assertEquals((byte)(16), buffer.array()[1]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);

		//singed big_endian
		//-0x8000
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf((short)0x8000);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0x80), buffer.array()[0]);
		assertEquals((byte)(0), buffer.array()[1]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//0
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[0]);
		assertEquals((byte)(0), buffer.array()[1]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//0xEFFF
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf((short)0xEFFF);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0xEF), buffer.array()[0]);
		assertEquals((byte)(0xFF), buffer.array()[1]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		
		//unsigned big_endian
		//65535
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(65535);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0xFF), buffer.array()[1]);
		assertEquals((byte)(0xFF), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//0
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[1]);
		assertEquals((byte)(0), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//16
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(16);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[1]);
		assertEquals((byte)(16), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);

		//singed little_endian
		//-0x8000
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf((short)0x8000);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0x80), buffer.array()[1]);
		assertEquals((byte)(0), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//0
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[0]);
		assertEquals((byte)(0), buffer.array()[1]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//0xEFFF
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf((short)0xEFFF);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0xEF), buffer.array()[1]);
		assertEquals((byte)(0xFF), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
	}
	
	private void doTestSerializeUtilInt()  throws Exception {
		final int bit_len = 32; 
		BigInteger inputValue;
		BigInteger outputValue;
		IReadWritableBitBuffer buffer;
		//unsigned big_endian
		//0xFFFFFFFF
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0xFFFFFFFFL);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0xFF), buffer.array()[0]);
		assertEquals((byte)(0xFF), buffer.array()[1]);
		assertEquals((byte)(0xFF), buffer.array()[2]);
		assertEquals((byte)(0xFF), buffer.array()[3]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//0
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[0]);
		assertEquals((byte)(0), buffer.array()[1]);
		assertEquals((byte)(0), buffer.array()[2]);
		assertEquals((byte)(0), buffer.array()[3]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//0x00302010
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0x00302010L);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0x00), buffer.array()[0]);
		assertEquals((byte)(0x30), buffer.array()[1]);
		assertEquals((byte)(0x20), buffer.array()[2]);
		assertEquals((byte)(0x10), buffer.array()[3]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);

		//singed big_endian
		//-0x80000000
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf((int)0x80000000L);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0x80), buffer.array()[0]);
		assertEquals((byte)(0), buffer.array()[1]);
		assertEquals((byte)(0), buffer.array()[2]);
		assertEquals((byte)(0), buffer.array()[3]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//0
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[0]);
		assertEquals((byte)(0), buffer.array()[1]);
		assertEquals((byte)(0), buffer.array()[2]);
		assertEquals((byte)(0), buffer.array()[3]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//-2
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(-2);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0xFF), buffer.array()[0]);
		assertEquals((byte)(0xFF), buffer.array()[1]);
		assertEquals((byte)(0xFF), buffer.array()[2]);
		assertEquals((byte)(0xFE), buffer.array()[3]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		//0xEFFFFFFF
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf((int)0xEFFFFFFFL);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.BIGENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0xEF), buffer.array()[0]);
		assertEquals((byte)(0xFF), buffer.array()[1]);
		assertEquals((byte)(0xFF), buffer.array()[2]);
		assertEquals((byte)(0xFF), buffer.array()[3]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.BIGENDIAN);
		assertEquals(inputValue, outputValue);
		
		//unsigned LITTLE_ENDIAN
		//0xFFFFFFFF
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0xFFFFFFFFL);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0xFF), buffer.array()[3]);
		assertEquals((byte)(0xFF), buffer.array()[2]);
		assertEquals((byte)(0xFF), buffer.array()[1]);
		assertEquals((byte)(0xFF), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//0
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[3]);
		assertEquals((byte)(0), buffer.array()[2]);
		assertEquals((byte)(0), buffer.array()[1]);
		assertEquals((byte)(0), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//0x00302010
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0x00302010L);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0x00), buffer.array()[3]);
		assertEquals((byte)(0x30), buffer.array()[2]);
		assertEquals((byte)(0x20), buffer.array()[1]);
		assertEquals((byte)(0x10), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, false, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);

		//singed LITTLE_ENDIAN
		//-0x80000000
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf((int)0x80000000L);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0x80), buffer.array()[3]);
		assertEquals((byte)(0), buffer.array()[2]);
		assertEquals((byte)(0), buffer.array()[1]);
		assertEquals((byte)(0), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//0
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(0);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0), buffer.array()[3]);
		assertEquals((byte)(0), buffer.array()[2]);
		assertEquals((byte)(0), buffer.array()[1]);
		assertEquals((byte)(0), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//-2
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf(-2);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0xFE), buffer.array()[0]);
		assertEquals((byte)(0xFF), buffer.array()[1]);
		assertEquals((byte)(0xFF), buffer.array()[2]);
		assertEquals((byte)(0xFF), buffer.array()[3]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
		//0xEFFFFFFF
		buffer = new SimpleBitBuffer(bit_len);
		inputValue = BigInteger.valueOf((int)0xEFFFFFFFL);
		encodeInt4fpb(buffer, inputValue, bit_len, ByteOrder.LITTLEENDIAN);
		buffer.flip();
		assertEquals(bit_len, buffer.limit());
		assertEquals((byte)(0xEF), buffer.array()[3]);
		assertEquals((byte)(0xFF), buffer.array()[2]);
		assertEquals((byte)(0xFF), buffer.array()[1]);
		assertEquals((byte)(0xFF), buffer.array()[0]);
		outputValue = decodeInt4fpb(buffer, true, bit_len, ByteOrder.LITTLEENDIAN);
		assertEquals(inputValue, outputValue);
	}
}
