/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage
 * @generated
 */
public interface FpbtemplateFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FpbtemplateFactory eINSTANCE = com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplateFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>PAny Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PAny Matcher</em>'.
	 * @generated
	 */
	PAnyMatcher createPAnyMatcher();

	/**
	 * Returns a new object of class '<em>PAny Or Omit Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PAny Or Omit Matcher</em>'.
	 * @generated
	 */
	PAnyOrOmitMatcher createPAnyOrOmitMatcher();

	/**
	 * Returns a new object of class '<em>PBitstring Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PBitstring Matcher</em>'.
	 * @generated
	 */
	PBitstringMatcher createPBitstringMatcher();

	/**
	 * Returns a new object of class '<em>PCharstring Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PCharstring Matcher</em>'.
	 * @generated
	 */
	PCharstringMatcher createPCharstringMatcher();

	/**
	 * Returns a new object of class '<em>PComplement List Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PComplement List Matcher</em>'.
	 * @generated
	 */
	PComplementListMatcher createPComplementListMatcher();

	/**
	 * Returns a new object of class '<em>PContainer Field Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PContainer Field Matcher</em>'.
	 * @generated
	 */
	PContainerFieldMatcher createPContainerFieldMatcher();

	/**
	 * Returns a new object of class '<em>PContainer Field Matcher Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PContainer Field Matcher Item</em>'.
	 * @generated
	 */
	PContainerFieldMatcherItem createPContainerFieldMatcherItem();

	/**
	 * Returns a new object of class '<em>PEntity Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PEntity Template</em>'.
	 * @generated
	 */
	PEntityTemplate createPEntityTemplate();

	/**
	 * Returns a new object of class '<em>PHexstring Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PHexstring Matcher</em>'.
	 * @generated
	 */
	PHexstringMatcher createPHexstringMatcher();

	/**
	 * Returns a new object of class '<em>PImport Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PImport Template</em>'.
	 * @generated
	 */
	PImportTemplate createPImportTemplate();

	/**
	 * Returns a new object of class '<em>PList Field Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PList Field Matcher</em>'.
	 * @generated
	 */
	PListFieldMatcher createPListFieldMatcher();

	/**
	 * Returns a new object of class '<em>PList Field Matcher Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PList Field Matcher Item</em>'.
	 * @generated
	 */
	PListFieldMatcherItem createPListFieldMatcherItem();

	/**
	 * Returns a new object of class '<em>PList Value Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PList Value Matcher</em>'.
	 * @generated
	 */
	PListValueMatcher createPListValueMatcher();

	/**
	 * Returns a new object of class '<em>PNot Used Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PNot Used Matcher</em>'.
	 * @generated
	 */
	PNotUsedMatcher createPNotUsedMatcher();

	/**
	 * Returns a new object of class '<em>POctetstring Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>POctetstring Matcher</em>'.
	 * @generated
	 */
	POctetstringMatcher createPOctetstringMatcher();

	/**
	 * Returns a new object of class '<em>POmit Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>POmit Matcher</em>'.
	 * @generated
	 */
	POmitMatcher createPOmitMatcher();

	/**
	 * Returns a new object of class '<em>PPrimitive Value Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PPrimitive Value Matcher</em>'.
	 * @generated
	 */
	PPrimitiveValueMatcher createPPrimitiveValueMatcher();

	/**
	 * Returns a new object of class '<em>PRange Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PRange Matcher</em>'.
	 * @generated
	 */
	PRangeMatcher createPRangeMatcher();

	/**
	 * Returns a new object of class '<em>PSingle Expression Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PSingle Expression Matcher</em>'.
	 * @generated
	 */
	PSingleExpressionMatcher createPSingleExpressionMatcher();

	/**
	 * Returns a new object of class '<em>PSub Set Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PSub Set Matcher</em>'.
	 * @generated
	 */
	PSubSetMatcher createPSubSetMatcher();

	/**
	 * Returns a new object of class '<em>PSuper Set Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PSuper Set Matcher</em>'.
	 * @generated
	 */
	PSuperSetMatcher createPSuperSetMatcher();

	/**
	 * Returns a new object of class '<em>PTemplate Par</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PTemplate Par</em>'.
	 * @generated
	 */
	PTemplatePar createPTemplatePar();

	/**
	 * Returns a new object of class '<em>PTemplate Ref Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PTemplate Ref Matcher</em>'.
	 * @generated
	 */
	PTemplateRefMatcher createPTemplateRefMatcher();

	/**
	 * Returns a new object of class '<em>PTemplate Ref Matcher Par</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PTemplate Ref Matcher Par</em>'.
	 * @generated
	 */
	PTemplateRefMatcherPar createPTemplateRefMatcherPar();

	/**
	 * Returns a new object of class '<em>PUnary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PUnary Expression</em>'.
	 * @generated
	 */
	PUnaryExpression createPUnaryExpression();

	/**
	 * Returns a new object of class '<em>PValue List Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PValue List Matcher</em>'.
	 * @generated
	 */
	PValueListMatcher createPValueListMatcher();

	/**
	 * Returns a new object of class '<em>PValue Reference Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PValue Reference Fragment</em>'.
	 * @generated
	 */
	PValueReferenceFragment createPValueReferenceFragment();

	/**
	 * Returns a new object of class '<em>PValue Reference Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PValue Reference Matcher</em>'.
	 * @generated
	 */
	PValueReferenceMatcher createPValueReferenceMatcher();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FpbtemplatePackage getFpbtemplatePackage();

} //FpbtemplateFactory
