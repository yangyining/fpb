package fpbtest;

import java.math.BigDecimal;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.builtin.BuiltinFactory;
import com.fineqt.fpb.lib.builtin.BuiltinModule;
import com.fineqt.fpb.lib.builtin.PBitstringValue;
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.builtin.PFloatValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.constraint.Diagnostic;
import com.fineqt.fpb.lib.constraint.PListConstraintExt;
import com.fineqt.fpb.lib.constraint.PPatternConstraintExt;
import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.constraint.SimpleDiagnostic;
import com.fineqt.fpb.lib.meta.util.PElementExtFactory;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmoduleFactory;
import com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PListConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint;
import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplateFactory;
import com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher;

import fpbtest.module.builtintest.BuiltintestFactory;

public class ConstraintTest extends TestCase {
	static FpbmoduleFactory mFactory = FpbmoduleFactory.eINSTANCE;
	static FpbtemplateFactory mtmpFactory = FpbtemplateFactory.eINSTANCE;
	static PElementExtFactory extFactory = PElementExtFactory.INSTANCE;
	
	public void testTypeConstaint() {
//		BuiltintestModule module = BuiltintestModule.INSTANCE;
		BuiltintestFactory factory = BuiltintestFactory.INSTANCE;
		SimpleDiagnostic chain = new SimpleDiagnostic();

		PIntegerValue intValue = (PIntegerValue)factory.createUINT8();
		intValue.setInteger(1000);
		assertFalse(intValue.pTypeMeta().validate(intValue, chain));
		intValue.setInteger(100);
		assertTrue(intValue.pTypeMeta().validate(intValue, chain));
//		System.out.println(chain);
	}
	
	public void testSimple2() throws Exception {
		BuiltinModule module = BuiltinModule.BUILTIN_INSTANCE;
		BuiltinFactory factory = BuiltinFactory.BUILTIN_INSTANCE;
		SimpleDiagnostic chain = new SimpleDiagnostic();
		//length fix(10)
		PLengthConstraint lenModel = mFactory.createPLengthConstraint();
		lenModel.setLowerBound(createPrmMatcher("10"));
		lenModel.setUpperBound(createPrmMatcher("10"));
		
		PTypeConstraintExt lenCons = (PTypeConstraintExt)extFactory.createTypeConstraint(
				module.getBitstring(), lenModel);
		assertNotNull(lenCons);
		
		PBitstringValue bitsValue = (PBitstringValue)factory.createBitstring();
		bitsValue.setLength(10);
		assertTrue(lenCons.validate(bitsValue, chain));
		assertEquals(Diagnostic.PASS, chain.getSeverity());
		chain = new SimpleDiagnostic();		

		bitsValue.setLength(9);
		assertFalse(lenCons.validate(bitsValue, chain));
		assertEquals(Diagnostic.FAIL, chain.getSeverity());
		assertEquals(1, chain.getChildren().size());

		chain = new SimpleDiagnostic();		
		bitsValue.setLength(11);
		assertFalse(lenCons.validate(bitsValue, chain));
		assertEquals(Diagnostic.FAIL, chain.getSeverity());
		assertEquals(1, chain.getChildren().size());
		
		//length range(1..5)
		lenModel = mFactory.createPLengthConstraint();
		lenModel.setLowerBound(createPrmMatcher("1"));
		lenModel.setUpperBound(createPrmMatcher("5"));
		lenCons = (PTypeConstraintExt)extFactory.createTypeConstraint(
				module.getBitstring(), lenModel);
		assertNotNull(lenCons);		
		
		bitsValue = (PBitstringValue)factory.createBitstring();
		chain = new SimpleDiagnostic();		
		bitsValue.setLength(3);
		assertTrue(lenCons.validate(bitsValue, chain));
		assertEquals(Diagnostic.PASS, chain.getSeverity());
		
		chain = new SimpleDiagnostic();		
		bitsValue.setLength(0);
		assertFalse(lenCons.validate(bitsValue, chain));
		assertEquals(Diagnostic.FAIL, chain.getSeverity());
		assertEquals(1, chain.getChildren().size());
		
		chain = new SimpleDiagnostic();		
		bitsValue.setLength(6);
		assertFalse(lenCons.validate(bitsValue, chain));
		assertEquals(Diagnostic.FAIL, chain.getSeverity());
		assertEquals(1, chain.getChildren().size());
		
		//pattern
		PPatternConstraint patModel = mFactory.createPPatternConstraint();
		PCharstringMatcher patMatcher = mtmpFactory.createPCharstringMatcher();
		patMatcher.setDesc("1a*9");
		patModel.setMatcher(patMatcher);
		PPatternConstraintExt patCons = (PPatternConstraintExt)extFactory.createTypeConstraint(
				module.getCharstring(), patModel);
		assertNotNull(patCons);
		
		PCharstringValue chstrValue = (PCharstringValue)factory.createCharstring();
		chain = new SimpleDiagnostic();		
		chstrValue.setValue("1aaa9".toCharArray());
		assertTrue(patCons.validate(chstrValue, chain));
		assertEquals(Diagnostic.PASS, chain.getSeverity());
		
		chain = new SimpleDiagnostic();		
		chstrValue.setValue("1aaa1".toCharArray());
		assertFalse(patCons.validate(chstrValue, chain));
		assertEquals(Diagnostic.FAIL, chain.getSeverity());
		assertEquals(1, chain.getChildren().size());
		
		//list single("xyz")
		PListConstraint lstModel = mFactory.createPListConstraint();
		PValueListMatcher lstMatcher = mtmpFactory.createPValueListMatcher();
		lstMatcher.getItems().add(createPrmMatcher("xyz"));
		lstModel.setMatcher(lstMatcher);
		PListConstraintExt lstCons = (PListConstraintExt)extFactory.createTypeConstraint(
				module.getCharstring(), lstModel);
		assertNotNull(lstCons);
		
		chain = new SimpleDiagnostic();		
		chstrValue = (PCharstringValue)factory.createCharstring();
		chstrValue.setValue("xyz".toCharArray());
		assertTrue(lstCons.validate(chstrValue, chain));
		assertEquals(Diagnostic.PASS, chain.getSeverity());
		
		chain = new SimpleDiagnostic();		
		chstrValue = (PCharstringValue)factory.createCharstring();
		chstrValue.setValue("aaaq".toCharArray());
		assertFalse(lstCons.validate(chstrValue, chain));
		assertEquals(Diagnostic.FAIL, chain.getSeverity());
		assertEquals(1, chain.getChildren().size());
		
		//list with int range(1, 5..9)
		lstModel = mFactory.createPListConstraint();
		lstMatcher = mtmpFactory.createPValueListMatcher();
		lstMatcher.getItems().add(createPrmMatcher("1"));		
		PRangeMatcher rangeMatcher = mtmpFactory.createPRangeMatcher();
		rangeMatcher.setLowerBound(createPrmMatcher("5"));
		rangeMatcher.setUpperBound(createPrmMatcher("9"));
		lstMatcher.getItems().add(rangeMatcher);
		lstModel.setMatcher(lstMatcher);
		lstCons = (PListConstraintExt)extFactory.createTypeConstraint(
				module.getInteger(), lstModel);
		assertNotNull(lstCons);
		
		chain = new SimpleDiagnostic();		
		PIntegerValue intValue = (PIntegerValue)factory.createInteger();
		intValue.setInteger(1);
		assertTrue(lstCons.validate(intValue, chain));
		assertEquals(Diagnostic.PASS, chain.getSeverity());
		
		chain = new SimpleDiagnostic();		
		intValue = (PIntegerValue)factory.createInteger();
		intValue.setInteger(6);
		assertTrue(lstCons.validate(intValue, chain));
		assertEquals(Diagnostic.PASS, chain.getSeverity());
		
		chain = new SimpleDiagnostic();		
		intValue = (PIntegerValue)factory.createInteger();
		intValue.setInteger(10);
		assertFalse(lstCons.validate(intValue, chain));
		assertEquals(Diagnostic.FAIL, chain.getSeverity());
		assertEquals(1, chain.getChildren().size());
		
		//list with int range(1, 5.1 .. 9.4)
		lstModel = mFactory.createPListConstraint();
		lstMatcher = mtmpFactory.createPValueListMatcher();
		lstMatcher.getItems().add(createPrmMatcher("1"));		
		rangeMatcher = mtmpFactory.createPRangeMatcher();
		rangeMatcher.setLowerBound(createPrmMatcher("5.1"));
		rangeMatcher.setUpperBound(createPrmMatcher("9.4"));
		lstMatcher.getItems().add(rangeMatcher);
		lstModel.setMatcher(lstMatcher);
		lstCons = (PListConstraintExt)extFactory.createTypeConstraint(
				module.getFloat(), lstModel);
		assertNotNull(lstCons);
		
		chain = new SimpleDiagnostic();		
		PFloatValue floatValue = (PFloatValue)factory.createFloat();
		floatValue.setBigDecimal(new BigDecimal("1"));
		assertTrue(lstCons.validate(floatValue, chain));
		assertEquals(Diagnostic.PASS, chain.getSeverity());
		
		chain = new SimpleDiagnostic();		
		floatValue = (PFloatValue)factory.createFloat();
		floatValue.setFloat(5.2f);
		assertTrue(lstCons.validate(floatValue, chain));
		assertEquals(Diagnostic.PASS, chain.getSeverity());
		
		chain = new SimpleDiagnostic();		
		floatValue = (PFloatValue)factory.createFloat();
		floatValue.setFloat(10);
		assertFalse(lstCons.validate(floatValue, chain));
		assertEquals(Diagnostic.FAIL, chain.getSeverity());
		assertEquals(1, chain.getChildren().size());
		
//		//charset('1', 'a'..'z')
//		lstModel = mFactory.createPListConstraint();
//		lstMatcher = mtmpFactory.createPValueListMatcher();
//		prmMatcher = mtmpFactory.createPPrimitiveValueMatcher();
//		prmMatcher.setValueDesc("1");
//		lstMatcher.getItems().add(prmMatcher);		
//		rangeMatcher = mtmpFactory.createPRangeMatcher();
//		rangeMatcher.setLowerBound(createPrmMatcher("a")"a");
//		rangeMatcher.setUpperBound("z");
//		lstMatcher.getItems().add(rangeMatcher);
//		lstModel.setMatcher(lstMatcher);
//		lstCons = (PListConstraintExt)extFactory.createTypeConstraint(
//				module.getCharstring(), lstModel);
//		assertNotNull(lstCons);
//		
//		chstrValue = (PCharstringValue)factory.createCharstring();
//		chain = new SimpleDiagnostic();		
//		chstrValue.setValue("az1".toCharArray());
//		assertTrue(lstCons.validate(chstrValue, chain));
//		assertEquals(Diagnostic.PASS, chain.getSeverity());
		
		chain = new SimpleDiagnostic();		
		chstrValue.setValue("az9".toCharArray());
		assertFalse(lstCons.validate(chstrValue, chain));
		assertEquals(Diagnostic.FAIL, chain.getSeverity());
		assertEquals(1, chain.getChildren().size());
		
		
	}
	
	private PSingleExpressionMatcher createPrmMatcher(String valueDesc) {
		PSingleExpressionMatcher expMatcher = 
			FpbtemplateFactory.eINSTANCE.createPSingleExpressionMatcher();
		PPrimitiveValueMatcher prmMatcher = 
			FpbtemplateFactory.eINSTANCE.createPPrimitiveValueMatcher();
		prmMatcher.setValueDesc(valueDesc);
		expMatcher.setExpression(prmMatcher);
		return expMatcher;
	}
	
}
