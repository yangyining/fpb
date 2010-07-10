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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage
 * @generated
 */
public class FpbtemplateAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FpbtemplatePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FpbtemplateAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FpbtemplatePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FpbtemplateSwitch<Adapter> modelSwitch =
		new FpbtemplateSwitch<Adapter>() {
			@Override
			public Adapter casePAnyMatcher(PAnyMatcher object) {
				return createPAnyMatcherAdapter();
			}
			@Override
			public Adapter casePAnyOrOmitMatcher(PAnyOrOmitMatcher object) {
				return createPAnyOrOmitMatcherAdapter();
			}
			@Override
			public Adapter casePBitstringMatcher(PBitstringMatcher object) {
				return createPBitstringMatcherAdapter();
			}
			@Override
			public Adapter casePCharstringMatcher(PCharstringMatcher object) {
				return createPCharstringMatcherAdapter();
			}
			@Override
			public Adapter casePComplementListMatcher(PComplementListMatcher object) {
				return createPComplementListMatcherAdapter();
			}
			@Override
			public Adapter casePContainerFieldMatcher(PContainerFieldMatcher object) {
				return createPContainerFieldMatcherAdapter();
			}
			@Override
			public Adapter casePContainerFieldMatcherItem(PContainerFieldMatcherItem object) {
				return createPContainerFieldMatcherItemAdapter();
			}
			@Override
			public Adapter casePEntityTemplate(PEntityTemplate object) {
				return createPEntityTemplateAdapter();
			}
			@Override
			public Adapter casePExpressionMatcher(PExpressionMatcher object) {
				return createPExpressionMatcherAdapter();
			}
			@Override
			public Adapter casePHexstringMatcher(PHexstringMatcher object) {
				return createPHexstringMatcherAdapter();
			}
			@Override
			public Adapter casePImportTemplate(PImportTemplate object) {
				return createPImportTemplateAdapter();
			}
			@Override
			public Adapter casePListFieldMatcher(PListFieldMatcher object) {
				return createPListFieldMatcherAdapter();
			}
			@Override
			public Adapter casePListFieldMatcherItem(PListFieldMatcherItem object) {
				return createPListFieldMatcherItemAdapter();
			}
			@Override
			public Adapter casePListValueMatcher(PListValueMatcher object) {
				return createPListValueMatcherAdapter();
			}
			@Override
			public Adapter casePMatcher(PMatcher object) {
				return createPMatcherAdapter();
			}
			@Override
			public Adapter casePNotUsedMatcher(PNotUsedMatcher object) {
				return createPNotUsedMatcherAdapter();
			}
			@Override
			public Adapter casePOctetstringMatcher(POctetstringMatcher object) {
				return createPOctetstringMatcherAdapter();
			}
			@Override
			public Adapter casePOmitMatcher(POmitMatcher object) {
				return createPOmitMatcherAdapter();
			}
			@Override
			public Adapter casePPrimitiveValueMatcher(PPrimitiveValueMatcher object) {
				return createPPrimitiveValueMatcherAdapter();
			}
			@Override
			public Adapter casePRangeMatcher(PRangeMatcher object) {
				return createPRangeMatcherAdapter();
			}
			@Override
			public Adapter casePSimpleMatcher(PSimpleMatcher object) {
				return createPSimpleMatcherAdapter();
			}
			@Override
			public Adapter casePSingleExpressionMatcher(PSingleExpressionMatcher object) {
				return createPSingleExpressionMatcherAdapter();
			}
			@Override
			public Adapter casePSubSetMatcher(PSubSetMatcher object) {
				return createPSubSetMatcherAdapter();
			}
			@Override
			public Adapter casePSuperSetMatcher(PSuperSetMatcher object) {
				return createPSuperSetMatcherAdapter();
			}
			@Override
			public Adapter casePTemplate(PTemplate object) {
				return createPTemplateAdapter();
			}
			@Override
			public Adapter casePTemplateMatcher(PTemplateMatcher object) {
				return createPTemplateMatcherAdapter();
			}
			@Override
			public Adapter casePTemplatePar(PTemplatePar object) {
				return createPTemplateParAdapter();
			}
			@Override
			public Adapter casePTemplateRefMatcher(PTemplateRefMatcher object) {
				return createPTemplateRefMatcherAdapter();
			}
			@Override
			public Adapter casePTemplateRefMatcherPar(PTemplateRefMatcherPar object) {
				return createPTemplateRefMatcherParAdapter();
			}
			@Override
			public Adapter casePUnaryExpression(PUnaryExpression object) {
				return createPUnaryExpressionAdapter();
			}
			@Override
			public Adapter casePValueListMatcher(PValueListMatcher object) {
				return createPValueListMatcherAdapter();
			}
			@Override
			public Adapter casePValueReferenceFragment(PValueReferenceFragment object) {
				return createPValueReferenceFragmentAdapter();
			}
			@Override
			public Adapter casePValueReferenceMatcher(PValueReferenceMatcher object) {
				return createPValueReferenceMatcherAdapter();
			}
			@Override
			public Adapter casePModelElement(PModelElement object) {
				return createPModelElementAdapter();
			}
			@Override
			public Adapter casePNamedElement(PNamedElement object) {
				return createPNamedElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PAnyMatcher <em>PAny Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PAnyMatcher
	 * @generated
	 */
	public Adapter createPAnyMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PAnyOrOmitMatcher <em>PAny Or Omit Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PAnyOrOmitMatcher
	 * @generated
	 */
	public Adapter createPAnyOrOmitMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PBitstringMatcher <em>PBitstring Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PBitstringMatcher
	 * @generated
	 */
	public Adapter createPBitstringMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher <em>PCharstring Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher
	 * @generated
	 */
	public Adapter createPCharstringMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PComplementListMatcher <em>PComplement List Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PComplementListMatcher
	 * @generated
	 */
	public Adapter createPComplementListMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcher <em>PContainer Field Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcher
	 * @generated
	 */
	public Adapter createPContainerFieldMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem <em>PContainer Field Matcher Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem
	 * @generated
	 */
	public Adapter createPContainerFieldMatcherItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate <em>PEntity Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate
	 * @generated
	 */
	public Adapter createPEntityTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PExpressionMatcher <em>PExpression Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PExpressionMatcher
	 * @generated
	 */
	public Adapter createPExpressionMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PHexstringMatcher <em>PHexstring Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PHexstringMatcher
	 * @generated
	 */
	public Adapter createPHexstringMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate <em>PImport Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate
	 * @generated
	 */
	public Adapter createPImportTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcher <em>PList Field Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcher
	 * @generated
	 */
	public Adapter createPListFieldMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem <em>PList Field Matcher Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem
	 * @generated
	 */
	public Adapter createPListFieldMatcherItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListValueMatcher <em>PList Value Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PListValueMatcher
	 * @generated
	 */
	public Adapter createPListValueMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PMatcher <em>PMatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PMatcher
	 * @generated
	 */
	public Adapter createPMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PNotUsedMatcher <em>PNot Used Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PNotUsedMatcher
	 * @generated
	 */
	public Adapter createPNotUsedMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.POctetstringMatcher <em>POctetstring Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.POctetstringMatcher
	 * @generated
	 */
	public Adapter createPOctetstringMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.POmitMatcher <em>POmit Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.POmitMatcher
	 * @generated
	 */
	public Adapter createPOmitMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher <em>PPrimitive Value Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher
	 * @generated
	 */
	public Adapter createPPrimitiveValueMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher <em>PRange Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher
	 * @generated
	 */
	public Adapter createPRangeMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PSimpleMatcher <em>PSimple Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PSimpleMatcher
	 * @generated
	 */
	public Adapter createPSimpleMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher <em>PSingle Expression Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher
	 * @generated
	 */
	public Adapter createPSingleExpressionMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PSubSetMatcher <em>PSub Set Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PSubSetMatcher
	 * @generated
	 */
	public Adapter createPSubSetMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PSuperSetMatcher <em>PSuper Set Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PSuperSetMatcher
	 * @generated
	 */
	public Adapter createPSuperSetMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplate <em>PTemplate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplate
	 * @generated
	 */
	public Adapter createPTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher <em>PTemplate Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher
	 * @generated
	 */
	public Adapter createPTemplateMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar <em>PTemplate Par</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar
	 * @generated
	 */
	public Adapter createPTemplateParAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher <em>PTemplate Ref Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher
	 * @generated
	 */
	public Adapter createPTemplateRefMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcherPar <em>PTemplate Ref Matcher Par</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcherPar
	 * @generated
	 */
	public Adapter createPTemplateRefMatcherParAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression <em>PUnary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression
	 * @generated
	 */
	public Adapter createPUnaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher <em>PValue List Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher
	 * @generated
	 */
	public Adapter createPValueListMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment <em>PValue Reference Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment
	 * @generated
	 */
	public Adapter createPValueReferenceFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher <em>PValue Reference Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher
	 * @generated
	 */
	public Adapter createPValueReferenceMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbcommon.PModelElement <em>PModel Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PModelElement
	 * @generated
	 */
	public Adapter createPModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbcommon.PNamedElement <em>PNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PNamedElement
	 * @generated
	 */
	public Adapter createPNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //FpbtemplateAdapterFactory
