package fpbtest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.expression.PPrimitiveValueMatcherExt;
import com.fineqt.fpb.lib.expression.PSingleExpressionMatcherExt;
import com.fineqt.fpb.lib.expression.PValueReferenceMatcherExt;
import com.fineqt.fpb.lib.meta.util.PElementExtFactory;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplateFactory;
import com.fineqt.fpb.lib.model.fpbtemplate.PAnyMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PAnyOrOmitMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PBitstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PComplementListMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem;
import com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate;
import com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem;
import com.fineqt.fpb.lib.model.fpbtemplate.PListValueMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PSuperSetMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType;
import com.fineqt.fpb.lib.template.PTemplateExt;
import com.fineqt.fpb.lib.template.impl.PAnyMatcherExt;
import com.fineqt.fpb.lib.template.impl.PAnyOrOmitMatcherExt;
import com.fineqt.fpb.lib.template.impl.PBitstringMatcherExt;
import com.fineqt.fpb.lib.template.impl.PComplementListMatcherExt;
import com.fineqt.fpb.lib.template.impl.PContainerFieldMatcherExt;
import com.fineqt.fpb.lib.template.impl.PElementPattern;
import com.fineqt.fpb.lib.template.impl.PIntRangeMatcherExt;
import com.fineqt.fpb.lib.template.impl.PListFieldMatcherExt;
import com.fineqt.fpb.lib.template.impl.PRecordOfMatcherExt;
import com.fineqt.fpb.lib.template.impl.PSetOfMatcherExt;
import com.fineqt.fpb.lib.template.impl.PSupersetMatcherExt;
import com.fineqt.fpb.lib.template.impl.PValueListMatcherExt;
import com.fineqt.fpb.lib.value.PPrimitiveValue;

import fpbtest.module.builtintest.BuiltintestModule;

public class ElementExtFactoryTest extends TestCase {
	public void testSimpleMatcher() throws Exception {
		FpbtemplateFactory mfactory = FpbtemplateFactory.eINSTANCE;
		PElementExtFactory factory = PElementExtFactory.INSTANCE;
		BuiltintestModule module = BuiltintestModule.INSTANCE;
		//primitive
		PPrimitiveValueMatcher pvMatcherM = mfactory.createPPrimitiveValueMatcher();
		pvMatcherM.setValueDesc("123");
		PPrimitiveValueMatcherExt pvMatcher = (PPrimitiveValueMatcherExt)factory.createMatcher(
				module.getInteger(), pvMatcherM, null, module);
		assertEquals(TypeClass.INTEGER, pvMatcher.getConstValue().pTypeMeta().getTypeClass());
		assertEquals("123", pvMatcher.getConstValue().getText());
		//bitstring
		PBitstringMatcher bsMatcherM = mfactory.createPBitstringMatcher();
		bsMatcherM.setDesc("1?0*");
		PBitstringMatcherExt bstrMatcher = (PBitstringMatcherExt)factory.createMatcher(
				module.getBitstring(), bsMatcherM, null, module);
		assertEquals(4, bstrMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(0).getType());
		assertEquals(PElementPattern.Type.Any, bstrMatcher.getElements().get(1).getType());
		assertEquals(PElementPattern.Type.Value, bstrMatcher.getElements().get(2).getType());
		assertEquals(PElementPattern.Type.AnyOrNone, bstrMatcher.getElements().get(3).getType());
		//range(integer)
		PRangeMatcher rangeMatcherM = mfactory.createPRangeMatcher();
		rangeMatcherM.setLowerBound(createPrmMatcher("100"));
		rangeMatcherM.setUpperBound(createPrmMatcher("999"));
		PIntRangeMatcherExt rangeMatcher = (PIntRangeMatcherExt)factory.createMatcher(
				module.getInteger(), rangeMatcherM, null, module);
		assertEquals(100, rangeMatcher.getLowerBound().intValue());
		assertEquals(999, rangeMatcher.getUpperBound().intValue());
		//any
		PAnyMatcher anyMatcherM = mfactory.createPAnyMatcher();
		PAnyMatcherExt anyMatcher = (PAnyMatcherExt)factory.createMatcher(
				module.getInteger(), anyMatcherM, null, module);
		assertNotNull(anyMatcher);
		//complement list(int 1 3-4)
		PComplementListMatcher clMatcherM = mfactory.createPComplementListMatcher();
		clMatcherM.getItems().add(createPrmMatcher("1"));
		PRangeMatcher clItem2M = mfactory.createPRangeMatcher();
		clItem2M.setLowerBound(createPrmMatcher("3"));
		clItem2M.setUpperBound(createPrmMatcher("4"));		
		clMatcherM.getItems().add(clItem2M);
		PComplementListMatcherExt clMatcher = (PComplementListMatcherExt)factory.createMatcher(
				module.getInteger(), clMatcherM, null, module);
		assertEquals(2, clMatcher.getItems().size());
		assertTrue(clMatcher.getItems().get(0) instanceof PSingleExpressionMatcherExt);
		assertTrue(clMatcher.getItems().get(1) instanceof PIntRangeMatcherExt);
		//value list(int 1 3-4)
		PValueListMatcher valMatcherM = mfactory.createPValueListMatcher();
		valMatcherM.getItems().add(createPrmMatcher("1"));
		PRangeMatcher valItem2M = mfactory.createPRangeMatcher();
		valItem2M.setLowerBound(createPrmMatcher("3"));
		valItem2M.setUpperBound(createPrmMatcher("4"));		
		valMatcherM.getItems().add(valItem2M);
		PValueListMatcherExt valMatcher = (PValueListMatcherExt)factory.createMatcher(
				module.getInteger(), valMatcherM, null, module);
		assertEquals(2, valMatcher.getItems().size());
		assertTrue(valMatcher.getItems().get(0) instanceof PSingleExpressionMatcherExt);
		assertTrue(valMatcher.getItems().get(1) instanceof PIntRangeMatcherExt);
		//superset (int 2, 3)
		PSuperSetMatcher ssMatcherM = mfactory.createPSuperSetMatcher();
		ssMatcherM.getItems().add(createPrmMatcher("2"));
		ssMatcherM.getItems().add(createPrmMatcher("3"));
		PSupersetMatcherExt ssMatcher = (PSupersetMatcherExt)factory.createMatcher(
				module.getUint16Set(), ssMatcherM, null, module);
		ssMatcher.init();
		assertEquals(2, ssMatcher.getItems().size());
		assertEquals("2", ((PPrimitiveValue)ssMatcher.getItems().get(0)).getText());
		assertEquals("3", ((PPrimitiveValue)ssMatcher.getItems().get(1)).getText());
		//container field(totalLength(2), data3(*))
		PContainerFieldMatcher cfMatcherM = mfactory.createPContainerFieldMatcher();
		PContainerFieldMatcherItem cfItem1M = mfactory.createPContainerFieldMatcherItem();
		cfItem1M.setFieldName("totalLength");
		cfItem1M.setMatcher(createPrmMatcher("2"));
		cfMatcherM.getItems().add(cfItem1M);
		PContainerFieldMatcherItem cfItem2M = mfactory.createPContainerFieldMatcherItem();
		cfItem2M.setFieldName("data3");
		PAnyOrOmitMatcher cfItem2MathcerM = mfactory.createPAnyOrOmitMatcher();
		cfItem2M.setMatcher(cfItem2MathcerM);
		cfMatcherM.getItems().add(cfItem2M);
		PContainerFieldMatcherExt cfMatcher = (PContainerFieldMatcherExt)factory.createMatcher(
				module.getDataLengthHyp(), cfMatcherM, null, module);
		assertEquals(2, cfMatcher.getItems().size());
		assertEquals("totalLength", cfMatcher.getItems().get(0).getFieldMeta().getFieldName());
		assertTrue(cfMatcher.getItems().get(0).getMatcher() instanceof PSingleExpressionMatcherExt);
		assertEquals("data3", cfMatcher.getItems().get(1).getFieldMeta().getFieldName());
		assertTrue(cfMatcher.getItems().get(1).getMatcher() instanceof PAnyOrOmitMatcherExt);
		//list field(0(2), 3(?))
		PListFieldMatcher lfMatcherM = mfactory.createPListFieldMatcher();
		PListFieldMatcherItem lfItem1M = mfactory.createPListFieldMatcherItem();
		lfItem1M.setIndex(0);
		lfItem1M.setMatcher(createPrmMatcher("2"));
		lfMatcherM.getItems().add(lfItem1M);
		PListFieldMatcherItem lfItem2M = mfactory.createPListFieldMatcherItem();
		lfItem2M.setIndex(3);
		PAnyMatcher lfItem2MathcerM = mfactory.createPAnyMatcher();
		lfItem2M.setMatcher(lfItem2MathcerM);
		lfMatcherM.getItems().add(lfItem2M);
		PListFieldMatcherExt lfMatcher = (PListFieldMatcherExt)factory.createMatcher(
				module.getUint16List(), lfMatcherM, null, module);
		assertEquals(2, cfMatcher.getItems().size());
		assertEquals(0, lfMatcher.getItems().get(0).getIndex(null));
		assertTrue(lfMatcher.getItems().get(0).getMatcher() instanceof PSingleExpressionMatcherExt);
		assertEquals(3, lfMatcher.getItems().get(1).getIndex(null));
		assertTrue(lfMatcher.getItems().get(1).getMatcher() instanceof PAnyMatcherExt);
		//record of value(0, ?, *)
		PListValueMatcher roMatcherM = mfactory.createPListValueMatcher();
		PPrimitiveValueMatcher roItem1M = mfactory.createPPrimitiveValueMatcher();
		roItem1M.setValueDesc("0");
		roMatcherM.getItems().add(roItem1M);
		PAnyMatcher roItem2M = mfactory.createPAnyMatcher();
		roMatcherM.getItems().add(roItem2M);
		PAnyOrOmitMatcher roItem3M = mfactory.createPAnyOrOmitMatcher();
		roMatcherM.getItems().add(roItem3M);
		PRecordOfMatcherExt roMatcher = (PRecordOfMatcherExt)factory.createMatcher(
				module.getUint16List(), roMatcherM, null, module); 
		assertEquals(3, roMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Value, roMatcher.getElements().get(0).getType());
		assertEquals(PElementPattern.Type.Any, roMatcher.getElements().get(1).getType());
		assertEquals(PElementPattern.Type.AnyOrNone, roMatcher.getElements().get(2).getType());
		//set of value(0, ?, *)
		PListValueMatcher soMatcherM = mfactory.createPListValueMatcher();
		PPrimitiveValueMatcher soItem1M = mfactory.createPPrimitiveValueMatcher();
		soItem1M.setValueDesc("0");
		soMatcherM.getItems().add(soItem1M);
		PAnyMatcher soItem2M = mfactory.createPAnyMatcher();
		soMatcherM.getItems().add(soItem2M);
		PAnyOrOmitMatcher soItem3M = mfactory.createPAnyOrOmitMatcher();
		soMatcherM.getItems().add(soItem3M);
		PSetOfMatcherExt soMatcher = (PSetOfMatcherExt)factory.createMatcher(
				module.getUint16Set(), soMatcherM, null, module); 
		assertEquals(3, soMatcher.getElements().size());
		assertEquals(PElementPattern.Type.Value, soMatcher.getElements().get(0).getType());
		assertEquals(PElementPattern.Type.Any, soMatcher.getElements().get(1).getType());
		assertEquals(PElementPattern.Type.AnyOrNone, soMatcher.getElements().get(2).getType());
		//value reference
		PValueReferenceMatcher tvrMathcerM = mfactory.createPValueReferenceMatcher();
		tvrMathcerM.setRefName("par1");
		tvrMathcerM.setRefType(ValueReferenceType.TEMPLATEPAR);
		PValueReferenceMatcherExt tprMathcer = (PValueReferenceMatcherExt)factory.createMatcher(
				module.getInteger(), tvrMathcerM, null, module);
		assertEquals("par1", tprMathcer.getRefName());

		//Template reference(省略)
	}
	
	public void testSimpleTemplate() throws Exception {
		FpbtemplateFactory mfactory = FpbtemplateFactory.eINSTANCE;
		PElementExtFactory factory = PElementExtFactory.INSTANCE;
		BuiltintestModule module = BuiltintestModule.INSTANCE;
		PEntityTemplate tm = mfactory.createPEntityTemplate();
		tm.setBasetype("UINT16");
		PPrimitiveValueMatcher pvMatcherM = mfactory.createPPrimitiveValueMatcher();
		pvMatcherM.setValueDesc("123");
		tm.setMatcher(pvMatcherM);
		PTemplateExt template = factory.createTemplate(module, tm);
		template.init();
		assertEquals(module.getUint16(), template.getBasetype());
		PPrimitiveValueMatcherExt pvMatcher = (PPrimitiveValueMatcherExt)template.getMatcher();
		assertEquals(TypeClass.INTEGER, pvMatcher.getConstValue().pTypeMeta().getTypeClass());
		assertEquals("123", pvMatcher.getConstValue().getText());
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
