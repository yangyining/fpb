/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.impl;

import com.fineqt.fpb.lib.model.fpbtemplate.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FpbtemplateFactoryImpl extends EFactoryImpl implements FpbtemplateFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FpbtemplateFactory init() {
		try {
			FpbtemplateFactory theFpbtemplateFactory = (FpbtemplateFactory)EPackage.Registry.INSTANCE.getEFactory("http://fpbtemplate.model.lib.fpb.fineqt.com"); 
			if (theFpbtemplateFactory != null) {
				return theFpbtemplateFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FpbtemplateFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FpbtemplateFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FpbtemplatePackage.PANY_MATCHER: return createPAnyMatcher();
			case FpbtemplatePackage.PANY_OR_OMIT_MATCHER: return createPAnyOrOmitMatcher();
			case FpbtemplatePackage.PBITSTRING_MATCHER: return createPBitstringMatcher();
			case FpbtemplatePackage.PCHARSTRING_MATCHER: return createPCharstringMatcher();
			case FpbtemplatePackage.PCOMPLEMENT_LIST_MATCHER: return createPComplementListMatcher();
			case FpbtemplatePackage.PCONTAINER_FIELD_MATCHER: return createPContainerFieldMatcher();
			case FpbtemplatePackage.PCONTAINER_FIELD_MATCHER_ITEM: return createPContainerFieldMatcherItem();
			case FpbtemplatePackage.PENTITY_TEMPLATE: return createPEntityTemplate();
			case FpbtemplatePackage.PHEXSTRING_MATCHER: return createPHexstringMatcher();
			case FpbtemplatePackage.PIMPORT_TEMPLATE: return createPImportTemplate();
			case FpbtemplatePackage.PLIST_FIELD_MATCHER: return createPListFieldMatcher();
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM: return createPListFieldMatcherItem();
			case FpbtemplatePackage.PLIST_VALUE_MATCHER: return createPListValueMatcher();
			case FpbtemplatePackage.PNOT_USED_MATCHER: return createPNotUsedMatcher();
			case FpbtemplatePackage.POCTETSTRING_MATCHER: return createPOctetstringMatcher();
			case FpbtemplatePackage.POMIT_MATCHER: return createPOmitMatcher();
			case FpbtemplatePackage.PPRIMITIVE_VALUE_MATCHER: return createPPrimitiveValueMatcher();
			case FpbtemplatePackage.PRANGE_MATCHER: return createPRangeMatcher();
			case FpbtemplatePackage.PSINGLE_EXPRESSION_MATCHER: return createPSingleExpressionMatcher();
			case FpbtemplatePackage.PSUB_SET_MATCHER: return createPSubSetMatcher();
			case FpbtemplatePackage.PSUPER_SET_MATCHER: return createPSuperSetMatcher();
			case FpbtemplatePackage.PTEMPLATE_PAR: return createPTemplatePar();
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER: return createPTemplateRefMatcher();
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER_PAR: return createPTemplateRefMatcherPar();
			case FpbtemplatePackage.PUNARY_EXPRESSION: return createPUnaryExpression();
			case FpbtemplatePackage.PVALUE_LIST_MATCHER: return createPValueListMatcher();
			case FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT: return createPValueReferenceFragment();
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER: return createPValueReferenceMatcher();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FpbtemplatePackage.VALUE_REFERENCE_TYPE:
				return createValueReferenceTypeFromString(eDataType, initialValue);
			case FpbtemplatePackage.VALUE_REFERENCE_TYPE_OBJECT:
				return createValueReferenceTypeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FpbtemplatePackage.VALUE_REFERENCE_TYPE:
				return convertValueReferenceTypeToString(eDataType, instanceValue);
			case FpbtemplatePackage.VALUE_REFERENCE_TYPE_OBJECT:
				return convertValueReferenceTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PAnyMatcher createPAnyMatcher() {
		PAnyMatcherImpl pAnyMatcher = new PAnyMatcherImpl();
		return pAnyMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PAnyOrOmitMatcher createPAnyOrOmitMatcher() {
		PAnyOrOmitMatcherImpl pAnyOrOmitMatcher = new PAnyOrOmitMatcherImpl();
		return pAnyOrOmitMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PBitstringMatcher createPBitstringMatcher() {
		PBitstringMatcherImpl pBitstringMatcher = new PBitstringMatcherImpl();
		return pBitstringMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCharstringMatcher createPCharstringMatcher() {
		PCharstringMatcherImpl pCharstringMatcher = new PCharstringMatcherImpl();
		return pCharstringMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PComplementListMatcher createPComplementListMatcher() {
		PComplementListMatcherImpl pComplementListMatcher = new PComplementListMatcherImpl();
		return pComplementListMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PContainerFieldMatcher createPContainerFieldMatcher() {
		PContainerFieldMatcherImpl pContainerFieldMatcher = new PContainerFieldMatcherImpl();
		return pContainerFieldMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PContainerFieldMatcherItem createPContainerFieldMatcherItem() {
		PContainerFieldMatcherItemImpl pContainerFieldMatcherItem = new PContainerFieldMatcherItemImpl();
		return pContainerFieldMatcherItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PEntityTemplate createPEntityTemplate() {
		PEntityTemplateImpl pEntityTemplate = new PEntityTemplateImpl();
		return pEntityTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PHexstringMatcher createPHexstringMatcher() {
		PHexstringMatcherImpl pHexstringMatcher = new PHexstringMatcherImpl();
		return pHexstringMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PImportTemplate createPImportTemplate() {
		PImportTemplateImpl pImportTemplate = new PImportTemplateImpl();
		return pImportTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PListFieldMatcher createPListFieldMatcher() {
		PListFieldMatcherImpl pListFieldMatcher = new PListFieldMatcherImpl();
		return pListFieldMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PListFieldMatcherItem createPListFieldMatcherItem() {
		PListFieldMatcherItemImpl pListFieldMatcherItem = new PListFieldMatcherItemImpl();
		return pListFieldMatcherItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PListValueMatcher createPListValueMatcher() {
		PListValueMatcherImpl pListValueMatcher = new PListValueMatcherImpl();
		return pListValueMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PNotUsedMatcher createPNotUsedMatcher() {
		PNotUsedMatcherImpl pNotUsedMatcher = new PNotUsedMatcherImpl();
		return pNotUsedMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public POctetstringMatcher createPOctetstringMatcher() {
		POctetstringMatcherImpl pOctetstringMatcher = new POctetstringMatcherImpl();
		return pOctetstringMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public POmitMatcher createPOmitMatcher() {
		POmitMatcherImpl pOmitMatcher = new POmitMatcherImpl();
		return pOmitMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PPrimitiveValueMatcher createPPrimitiveValueMatcher() {
		PPrimitiveValueMatcherImpl pPrimitiveValueMatcher = new PPrimitiveValueMatcherImpl();
		return pPrimitiveValueMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PRangeMatcher createPRangeMatcher() {
		PRangeMatcherImpl pRangeMatcher = new PRangeMatcherImpl();
		return pRangeMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSingleExpressionMatcher createPSingleExpressionMatcher() {
		PSingleExpressionMatcherImpl pSingleExpressionMatcher = new PSingleExpressionMatcherImpl();
		return pSingleExpressionMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSubSetMatcher createPSubSetMatcher() {
		PSubSetMatcherImpl pSubSetMatcher = new PSubSetMatcherImpl();
		return pSubSetMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSuperSetMatcher createPSuperSetMatcher() {
		PSuperSetMatcherImpl pSuperSetMatcher = new PSuperSetMatcherImpl();
		return pSuperSetMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PTemplatePar createPTemplatePar() {
		PTemplateParImpl pTemplatePar = new PTemplateParImpl();
		return pTemplatePar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PTemplateRefMatcher createPTemplateRefMatcher() {
		PTemplateRefMatcherImpl pTemplateRefMatcher = new PTemplateRefMatcherImpl();
		return pTemplateRefMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PTemplateRefMatcherPar createPTemplateRefMatcherPar() {
		PTemplateRefMatcherParImpl pTemplateRefMatcherPar = new PTemplateRefMatcherParImpl();
		return pTemplateRefMatcherPar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PUnaryExpression createPUnaryExpression() {
		PUnaryExpressionImpl pUnaryExpression = new PUnaryExpressionImpl();
		return pUnaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PValueListMatcher createPValueListMatcher() {
		PValueListMatcherImpl pValueListMatcher = new PValueListMatcherImpl();
		return pValueListMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PValueReferenceFragment createPValueReferenceFragment() {
		PValueReferenceFragmentImpl pValueReferenceFragment = new PValueReferenceFragmentImpl();
		return pValueReferenceFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PValueReferenceMatcher createPValueReferenceMatcher() {
		PValueReferenceMatcherImpl pValueReferenceMatcher = new PValueReferenceMatcherImpl();
		return pValueReferenceMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueReferenceType createValueReferenceTypeFromString(EDataType eDataType, String initialValue) {
		ValueReferenceType result = ValueReferenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValueReferenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueReferenceType createValueReferenceTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createValueReferenceTypeFromString(FpbtemplatePackage.Literals.VALUE_REFERENCE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValueReferenceTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertValueReferenceTypeToString(FpbtemplatePackage.Literals.VALUE_REFERENCE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FpbtemplatePackage getFpbtemplatePackage() {
		return (FpbtemplatePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FpbtemplatePackage getPackage() {
		return FpbtemplatePackage.eINSTANCE;
	}

} //FpbtemplateFactoryImpl
