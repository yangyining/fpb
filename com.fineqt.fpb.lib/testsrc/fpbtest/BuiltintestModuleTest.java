package fpbtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.api.value.IUnionValue;
import com.fineqt.fpb.lib.system.ResourceManager;

import fpbtest.module.builtintest.BuiltintestFactory;
import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.CaseRecord;
import fpbtest.module.builtintest.DataLengthHyp;
import fpbtest.module.builtintest.LEndianRecord;
import fpbtest.module.builtintest.SetBlock1;
import fpbtest.module.builtintest.StringBlock;
import fpbtest.module.builtintest.StringOneLine;

public class BuiltintestModuleTest extends TestCase {
	
	public void _testLoadModuleFile() throws Exception {
		Resource resource = ResourceManager.INSTANCE.getResourceSet().createResource(
				URI.createFileURI("./protocol/Builtintest.module"));
		resource.load(null);
//		DocumentRoot root = (DocumentRoot)resource.getContents().get(0);
//		PModule module = root.getPModule();
//		System.out.println(resource.getURIFragment(module));

////		EObject object = resource.getEObject("//@pModule/@types.18/@pfields.5/@variant/@typeEV/@prpList");
//		EObject object = resource.getEObject(
//				"//@pModule/@types.18/@pfields.5/@variant/@typeEV/@prpList/@properties.0/@groups.0/@arguments.0/@condition/@matcher");
//		System.out.println(object);
////		PPropertyList prpList = (PPropertyList)object;
////		PListConstraint lstCons = (PListConstraint)object;
//		PValueListMatcher vlstMatcher = (PValueListMatcher)object;
//		PPrimitiveValueMatcher pvMatcher = FpbtemplateFactory.eINSTANCE.createPPrimitiveValueMatcher();
//		vlstMatcher.getItems().add(pvMatcher);

		resource.save(System.out, null);
	}
	
	public void testCreateObj() throws Exception {
		BuiltintestFactory factory = BuiltintestFactory.INSTANCE;
//		System.out.println(BuiltintestModule.INSTANCE);

		//Builtin Type
		IIntegerValue intValue = factory.createInteger();
		intValue.setInteger(1);
		assertEquals(false, intValue.notPresent());
		assertEquals(1, intValue.getInteger());

		//Record DataLengthHyp
		DataLengthHyp dlhObj = factory.createDataLengthHyp();
		assertEquals(false, dlhObj.getTotalLength().notPresent());
		assertEquals(false, dlhObj.getData1Length().notPresent());
		assertEquals(false, dlhObj.getData2Flag().notPresent());
		assertEquals(true, dlhObj.getData2Flag().getBoolean());
		assertEquals(false, dlhObj.getData1().notPresent());
		assertEquals("'0101'B", dlhObj.getData1().getString());
		assertEquals(false, dlhObj.getPad().notPresent());
		assertEquals(false, dlhObj.getData2().notPresent());
		assertEquals(true, dlhObj.getData3().notPresent());
		assertEquals(4, dlhObj.getData2().getLength());
		assertEquals("'FFFF0000'O", dlhObj.getData2().getString());
		assertEquals(false, 
				dlhObj.getField(BuiltintestModule.DATA_LENGTH_HYP__DATA3, true).notPresent());
		//clone
		dlhObj.getData1Length().setInteger(10);
		DataLengthHyp newDlhObj = (DataLengthHyp)dlhObj.clone();
		newDlhObj.getData1Length().setInteger(100);
		assertEquals(10, dlhObj.getData1Length().getInteger());
		assertEquals(100, newDlhObj.getData1Length().getInteger());
		assertEquals(false, newDlhObj.getData3().notPresent());
		
		//Record StringOneLine
		StringOneLine solObj = factory.createStringOneLine();
		assertEquals(false, solObj.getToken1().notPresent());
		assertEquals(false, solObj.getWs1().notPresent());
		assertEquals(false, solObj.getToken2().notPresent());
		
		//RecordOf StringMultiLineFix
		IListValue<StringOneLine> smlfObj = factory.createStringMultiLineFix();
		assertEquals(3, smlfObj.getLength());
		for (int i = 0; i < 3; i++) {
			assertNull(smlfObj.getItem(i));
		}
		//RecordOf StringMultiLineVar
		IListValue<StringOneLine> smlvObj = factory.createStringMultiLineVar();
		assertEquals(0, smlvObj.getLength());
		//StringBlock
		StringBlock sbObj = factory.createStringBlock();
		assertEquals(false, sbObj.getLines1Count().notPresent());
		assertEquals(false, sbObj.getFirst3line().notPresent());
		assertEquals(3, sbObj.getFirst3line().getLength());
		assertEquals(false, sbObj.getLines1().notPresent());
		assertEquals(0, sbObj.getLines1().getLength());
		assertEquals(false, sbObj.getLines2().notPresent());
		assertEquals(1, sbObj.getLines2().getLength());
		//CaseRecord
		CaseRecord crObj = factory.createCaseRecord();
		assertEquals(false, crObj.getCode().notPresent());
		assertEquals(false, crObj.getData().notPresent());
		//UnionBlock1
		IUnionValue ub1Obj = factory.createUnionBlock1();
		assertEquals("case1", ub1Obj.getPresentVariantName());
		assertEquals(false, ub1Obj.getField("case1").notPresent());
		assertNull(ub1Obj.getField("case2"));
		CaseRecord case2 = factory.createCase2();
		case2.getCode().setInteger(2);
		case2.getData().setInteger(20);
		ub1Obj.setField(BuiltintestModule.UNION_BLOCK1__CASE2, case2);
		assertEquals("case2", ub1Obj.getPresentVariantName());
		assertNotNull(ub1Obj.getPresentVariant());
		CaseRecord newCase2 = (CaseRecord)ub1Obj.getPresentVariant();
		assertFalse(newCase2.notPresent());
		assertFalse(newCase2.getCode().notPresent());
		assertFalse(newCase2.getData().notPresent());
		assertEquals(2, newCase2.getCode().getInteger());
		assertEquals(20, newCase2.getData().getInteger());
		//Case1, Case2, Case3
		CaseRecord case1Obj = factory.createCase1();
		assertEquals(false, case1Obj.getCode().notPresent());
		assertEquals(false, case1Obj.getData().notPresent());
		CaseRecord case2Obj = factory.createCase2();
		assertEquals(false, case2Obj.getCode().notPresent());
		assertEquals(false, case2Obj.getData().notPresent());
		CaseRecord case3Obj = factory.createCase3();
		assertEquals(false, case3Obj.getCode().notPresent());
		assertEquals(false, case3Obj.getData().notPresent());
		//UnionBlock2
		IUnionValue ub2Obj = factory.createUnionBlock2();
		assertEquals("case1", ub2Obj.getPresentVariantName());
		assertEquals(false, ub2Obj.getField("case1").notPresent());
		assertNull(ub2Obj.getField("case2"));
		//SetBlock1
		SetBlock1 sb1Obj = factory.createSetBlock1();
		assertEquals(false, sb1Obj.getCase1().notPresent());
		assertEquals(true, sb1Obj.getCase2().notPresent());
		//LEndianRecord
		LEndianRecord lerObj = factory.createLEndianRecord();
		assertEquals(false, lerObj.getInt1().notPresent());
		assertEquals(false, lerObj.getFlag().notPresent());
		assertEquals(false, lerObj.getBits().notPresent());
		assertEquals(false, lerObj.getInt2().notPresent());
		assertEquals(false, lerObj.getInt3().notPresent());
		
	}
	
	public void _testRegex() {
		Matcher matcher = Pattern.compile("[ \\t]*").matcher(" 0\r\n");
		assertEquals(true, matcher.lookingAt());
		assertEquals(0, matcher.start());
		assertEquals(1, matcher.end());
	}
}
