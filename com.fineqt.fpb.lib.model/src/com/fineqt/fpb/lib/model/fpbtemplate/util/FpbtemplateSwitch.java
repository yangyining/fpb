/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.util;

import com.fineqt.fpb.lib.model.fpbcommon.PModelElement;
import com.fineqt.fpb.lib.model.fpbcommon.PNamedElement;

import com.fineqt.fpb.lib.model.fpbtemplate.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage
 * @generated
 */
public class FpbtemplateSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FpbtemplatePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FpbtemplateSwitch() {
		if (modelPackage == null) {
			modelPackage = FpbtemplatePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FpbtemplatePackage.PANY_MATCHER: {
				PAnyMatcher pAnyMatcher = (PAnyMatcher)theEObject;
				T result = casePAnyMatcher(pAnyMatcher);
				if (result == null) result = casePSimpleMatcher(pAnyMatcher);
				if (result == null) result = casePTemplateMatcher(pAnyMatcher);
				if (result == null) result = casePMatcher(pAnyMatcher);
				if (result == null) result = casePModelElement(pAnyMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PANY_OR_OMIT_MATCHER: {
				PAnyOrOmitMatcher pAnyOrOmitMatcher = (PAnyOrOmitMatcher)theEObject;
				T result = casePAnyOrOmitMatcher(pAnyOrOmitMatcher);
				if (result == null) result = casePSimpleMatcher(pAnyOrOmitMatcher);
				if (result == null) result = casePTemplateMatcher(pAnyOrOmitMatcher);
				if (result == null) result = casePMatcher(pAnyOrOmitMatcher);
				if (result == null) result = casePModelElement(pAnyOrOmitMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PBITSTRING_MATCHER: {
				PBitstringMatcher pBitstringMatcher = (PBitstringMatcher)theEObject;
				T result = casePBitstringMatcher(pBitstringMatcher);
				if (result == null) result = casePSimpleMatcher(pBitstringMatcher);
				if (result == null) result = casePTemplateMatcher(pBitstringMatcher);
				if (result == null) result = casePMatcher(pBitstringMatcher);
				if (result == null) result = casePModelElement(pBitstringMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PCHARSTRING_MATCHER: {
				PCharstringMatcher pCharstringMatcher = (PCharstringMatcher)theEObject;
				T result = casePCharstringMatcher(pCharstringMatcher);
				if (result == null) result = casePSimpleMatcher(pCharstringMatcher);
				if (result == null) result = casePTemplateMatcher(pCharstringMatcher);
				if (result == null) result = casePMatcher(pCharstringMatcher);
				if (result == null) result = casePModelElement(pCharstringMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PCOMPLEMENT_LIST_MATCHER: {
				PComplementListMatcher pComplementListMatcher = (PComplementListMatcher)theEObject;
				T result = casePComplementListMatcher(pComplementListMatcher);
				if (result == null) result = casePSimpleMatcher(pComplementListMatcher);
				if (result == null) result = casePTemplateMatcher(pComplementListMatcher);
				if (result == null) result = casePMatcher(pComplementListMatcher);
				if (result == null) result = casePModelElement(pComplementListMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PCONTAINER_FIELD_MATCHER: {
				PContainerFieldMatcher pContainerFieldMatcher = (PContainerFieldMatcher)theEObject;
				T result = casePContainerFieldMatcher(pContainerFieldMatcher);
				if (result == null) result = casePTemplateMatcher(pContainerFieldMatcher);
				if (result == null) result = casePMatcher(pContainerFieldMatcher);
				if (result == null) result = casePModelElement(pContainerFieldMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PCONTAINER_FIELD_MATCHER_ITEM: {
				PContainerFieldMatcherItem pContainerFieldMatcherItem = (PContainerFieldMatcherItem)theEObject;
				T result = casePContainerFieldMatcherItem(pContainerFieldMatcherItem);
				if (result == null) result = casePModelElement(pContainerFieldMatcherItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PENTITY_TEMPLATE: {
				PEntityTemplate pEntityTemplate = (PEntityTemplate)theEObject;
				T result = casePEntityTemplate(pEntityTemplate);
				if (result == null) result = casePTemplate(pEntityTemplate);
				if (result == null) result = casePNamedElement(pEntityTemplate);
				if (result == null) result = casePModelElement(pEntityTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PEXPRESSION_MATCHER: {
				PExpressionMatcher pExpressionMatcher = (PExpressionMatcher)theEObject;
				T result = casePExpressionMatcher(pExpressionMatcher);
				if (result == null) result = casePMatcher(pExpressionMatcher);
				if (result == null) result = casePModelElement(pExpressionMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PHEXSTRING_MATCHER: {
				PHexstringMatcher pHexstringMatcher = (PHexstringMatcher)theEObject;
				T result = casePHexstringMatcher(pHexstringMatcher);
				if (result == null) result = casePSimpleMatcher(pHexstringMatcher);
				if (result == null) result = casePTemplateMatcher(pHexstringMatcher);
				if (result == null) result = casePMatcher(pHexstringMatcher);
				if (result == null) result = casePModelElement(pHexstringMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PIMPORT_TEMPLATE: {
				PImportTemplate pImportTemplate = (PImportTemplate)theEObject;
				T result = casePImportTemplate(pImportTemplate);
				if (result == null) result = casePTemplate(pImportTemplate);
				if (result == null) result = casePNamedElement(pImportTemplate);
				if (result == null) result = casePModelElement(pImportTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PLIST_FIELD_MATCHER: {
				PListFieldMatcher pListFieldMatcher = (PListFieldMatcher)theEObject;
				T result = casePListFieldMatcher(pListFieldMatcher);
				if (result == null) result = casePTemplateMatcher(pListFieldMatcher);
				if (result == null) result = casePMatcher(pListFieldMatcher);
				if (result == null) result = casePModelElement(pListFieldMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM: {
				PListFieldMatcherItem pListFieldMatcherItem = (PListFieldMatcherItem)theEObject;
				T result = casePListFieldMatcherItem(pListFieldMatcherItem);
				if (result == null) result = casePModelElement(pListFieldMatcherItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PLIST_VALUE_MATCHER: {
				PListValueMatcher pListValueMatcher = (PListValueMatcher)theEObject;
				T result = casePListValueMatcher(pListValueMatcher);
				if (result == null) result = casePTemplateMatcher(pListValueMatcher);
				if (result == null) result = casePMatcher(pListValueMatcher);
				if (result == null) result = casePModelElement(pListValueMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PMATCHER: {
				PMatcher pMatcher = (PMatcher)theEObject;
				T result = casePMatcher(pMatcher);
				if (result == null) result = casePModelElement(pMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PNOT_USED_MATCHER: {
				PNotUsedMatcher pNotUsedMatcher = (PNotUsedMatcher)theEObject;
				T result = casePNotUsedMatcher(pNotUsedMatcher);
				if (result == null) result = casePSimpleMatcher(pNotUsedMatcher);
				if (result == null) result = casePTemplateMatcher(pNotUsedMatcher);
				if (result == null) result = casePMatcher(pNotUsedMatcher);
				if (result == null) result = casePModelElement(pNotUsedMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.POCTETSTRING_MATCHER: {
				POctetstringMatcher pOctetstringMatcher = (POctetstringMatcher)theEObject;
				T result = casePOctetstringMatcher(pOctetstringMatcher);
				if (result == null) result = casePSimpleMatcher(pOctetstringMatcher);
				if (result == null) result = casePTemplateMatcher(pOctetstringMatcher);
				if (result == null) result = casePMatcher(pOctetstringMatcher);
				if (result == null) result = casePModelElement(pOctetstringMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.POMIT_MATCHER: {
				POmitMatcher pOmitMatcher = (POmitMatcher)theEObject;
				T result = casePOmitMatcher(pOmitMatcher);
				if (result == null) result = casePExpressionMatcher(pOmitMatcher);
				if (result == null) result = casePMatcher(pOmitMatcher);
				if (result == null) result = casePModelElement(pOmitMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PPRIMITIVE_VALUE_MATCHER: {
				PPrimitiveValueMatcher pPrimitiveValueMatcher = (PPrimitiveValueMatcher)theEObject;
				T result = casePPrimitiveValueMatcher(pPrimitiveValueMatcher);
				if (result == null) result = casePExpressionMatcher(pPrimitiveValueMatcher);
				if (result == null) result = casePMatcher(pPrimitiveValueMatcher);
				if (result == null) result = casePModelElement(pPrimitiveValueMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PRANGE_MATCHER: {
				PRangeMatcher pRangeMatcher = (PRangeMatcher)theEObject;
				T result = casePRangeMatcher(pRangeMatcher);
				if (result == null) result = casePSimpleMatcher(pRangeMatcher);
				if (result == null) result = casePTemplateMatcher(pRangeMatcher);
				if (result == null) result = casePMatcher(pRangeMatcher);
				if (result == null) result = casePModelElement(pRangeMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PSIMPLE_MATCHER: {
				PSimpleMatcher pSimpleMatcher = (PSimpleMatcher)theEObject;
				T result = casePSimpleMatcher(pSimpleMatcher);
				if (result == null) result = casePTemplateMatcher(pSimpleMatcher);
				if (result == null) result = casePMatcher(pSimpleMatcher);
				if (result == null) result = casePModelElement(pSimpleMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PSINGLE_EXPRESSION_MATCHER: {
				PSingleExpressionMatcher pSingleExpressionMatcher = (PSingleExpressionMatcher)theEObject;
				T result = casePSingleExpressionMatcher(pSingleExpressionMatcher);
				if (result == null) result = casePSimpleMatcher(pSingleExpressionMatcher);
				if (result == null) result = casePTemplateMatcher(pSingleExpressionMatcher);
				if (result == null) result = casePMatcher(pSingleExpressionMatcher);
				if (result == null) result = casePModelElement(pSingleExpressionMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PSUB_SET_MATCHER: {
				PSubSetMatcher pSubSetMatcher = (PSubSetMatcher)theEObject;
				T result = casePSubSetMatcher(pSubSetMatcher);
				if (result == null) result = casePSimpleMatcher(pSubSetMatcher);
				if (result == null) result = casePTemplateMatcher(pSubSetMatcher);
				if (result == null) result = casePMatcher(pSubSetMatcher);
				if (result == null) result = casePModelElement(pSubSetMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PSUPER_SET_MATCHER: {
				PSuperSetMatcher pSuperSetMatcher = (PSuperSetMatcher)theEObject;
				T result = casePSuperSetMatcher(pSuperSetMatcher);
				if (result == null) result = casePSimpleMatcher(pSuperSetMatcher);
				if (result == null) result = casePTemplateMatcher(pSuperSetMatcher);
				if (result == null) result = casePMatcher(pSuperSetMatcher);
				if (result == null) result = casePModelElement(pSuperSetMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PTEMPLATE: {
				PTemplate pTemplate = (PTemplate)theEObject;
				T result = casePTemplate(pTemplate);
				if (result == null) result = casePNamedElement(pTemplate);
				if (result == null) result = casePModelElement(pTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PTEMPLATE_MATCHER: {
				PTemplateMatcher pTemplateMatcher = (PTemplateMatcher)theEObject;
				T result = casePTemplateMatcher(pTemplateMatcher);
				if (result == null) result = casePMatcher(pTemplateMatcher);
				if (result == null) result = casePModelElement(pTemplateMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PTEMPLATE_PAR: {
				PTemplatePar pTemplatePar = (PTemplatePar)theEObject;
				T result = casePTemplatePar(pTemplatePar);
				if (result == null) result = casePNamedElement(pTemplatePar);
				if (result == null) result = casePModelElement(pTemplatePar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER: {
				PTemplateRefMatcher pTemplateRefMatcher = (PTemplateRefMatcher)theEObject;
				T result = casePTemplateRefMatcher(pTemplateRefMatcher);
				if (result == null) result = casePSimpleMatcher(pTemplateRefMatcher);
				if (result == null) result = casePTemplateMatcher(pTemplateRefMatcher);
				if (result == null) result = casePMatcher(pTemplateRefMatcher);
				if (result == null) result = casePModelElement(pTemplateRefMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER_PAR: {
				PTemplateRefMatcherPar pTemplateRefMatcherPar = (PTemplateRefMatcherPar)theEObject;
				T result = casePTemplateRefMatcherPar(pTemplateRefMatcherPar);
				if (result == null) result = casePModelElement(pTemplateRefMatcherPar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PUNARY_EXPRESSION: {
				PUnaryExpression pUnaryExpression = (PUnaryExpression)theEObject;
				T result = casePUnaryExpression(pUnaryExpression);
				if (result == null) result = casePExpressionMatcher(pUnaryExpression);
				if (result == null) result = casePMatcher(pUnaryExpression);
				if (result == null) result = casePModelElement(pUnaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PVALUE_LIST_MATCHER: {
				PValueListMatcher pValueListMatcher = (PValueListMatcher)theEObject;
				T result = casePValueListMatcher(pValueListMatcher);
				if (result == null) result = casePSimpleMatcher(pValueListMatcher);
				if (result == null) result = casePTemplateMatcher(pValueListMatcher);
				if (result == null) result = casePMatcher(pValueListMatcher);
				if (result == null) result = casePModelElement(pValueListMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT: {
				PValueReferenceFragment pValueReferenceFragment = (PValueReferenceFragment)theEObject;
				T result = casePValueReferenceFragment(pValueReferenceFragment);
				if (result == null) result = casePModelElement(pValueReferenceFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER: {
				PValueReferenceMatcher pValueReferenceMatcher = (PValueReferenceMatcher)theEObject;
				T result = casePValueReferenceMatcher(pValueReferenceMatcher);
				if (result == null) result = casePExpressionMatcher(pValueReferenceMatcher);
				if (result == null) result = casePMatcher(pValueReferenceMatcher);
				if (result == null) result = casePModelElement(pValueReferenceMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PAny Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PAny Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePAnyMatcher(PAnyMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PAny Or Omit Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PAny Or Omit Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePAnyOrOmitMatcher(PAnyOrOmitMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PBitstring Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PBitstring Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePBitstringMatcher(PBitstringMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PCharstring Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PCharstring Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCharstringMatcher(PCharstringMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PComplement List Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PComplement List Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePComplementListMatcher(PComplementListMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PContainer Field Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PContainer Field Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePContainerFieldMatcher(PContainerFieldMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PContainer Field Matcher Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PContainer Field Matcher Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePContainerFieldMatcherItem(PContainerFieldMatcherItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PEntity Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PEntity Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePEntityTemplate(PEntityTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PExpression Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PExpression Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePExpressionMatcher(PExpressionMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PHexstring Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PHexstring Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePHexstringMatcher(PHexstringMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PImport Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PImport Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePImportTemplate(PImportTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PList Field Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PList Field Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePListFieldMatcher(PListFieldMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PList Field Matcher Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PList Field Matcher Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePListFieldMatcherItem(PListFieldMatcherItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PList Value Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PList Value Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePListValueMatcher(PListValueMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PMatcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PMatcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePMatcher(PMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PNot Used Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PNot Used Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePNotUsedMatcher(PNotUsedMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>POctetstring Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>POctetstring Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePOctetstringMatcher(POctetstringMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>POmit Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>POmit Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePOmitMatcher(POmitMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PPrimitive Value Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PPrimitive Value Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePPrimitiveValueMatcher(PPrimitiveValueMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PRange Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PRange Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePRangeMatcher(PRangeMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PSimple Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PSimple Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePSimpleMatcher(PSimpleMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PSingle Expression Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PSingle Expression Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePSingleExpressionMatcher(PSingleExpressionMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PSub Set Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PSub Set Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePSubSetMatcher(PSubSetMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PSuper Set Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PSuper Set Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePSuperSetMatcher(PSuperSetMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PTemplate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PTemplate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePTemplate(PTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PTemplate Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PTemplate Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePTemplateMatcher(PTemplateMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PTemplate Par</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PTemplate Par</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePTemplatePar(PTemplatePar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PTemplate Ref Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PTemplate Ref Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePTemplateRefMatcher(PTemplateRefMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PTemplate Ref Matcher Par</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PTemplate Ref Matcher Par</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePTemplateRefMatcherPar(PTemplateRefMatcherPar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PUnary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PUnary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePUnaryExpression(PUnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PValue List Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PValue List Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePValueListMatcher(PValueListMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PValue Reference Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PValue Reference Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePValueReferenceFragment(PValueReferenceFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PValue Reference Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PValue Reference Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePValueReferenceMatcher(PValueReferenceMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePModelElement(PModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PNamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PNamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePNamedElement(PNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //FpbtemplateSwitch
