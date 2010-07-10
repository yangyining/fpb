/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbcommon;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbcommon.FpbcommonFactory
 * @model kind="package"
 * @generated
 */
public interface FpbcommonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fpbcommon";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fpbcommon.model.lib.fpb.fineqt.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fpbcommon";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FpbcommonPackage eINSTANCE = com.fineqt.fpb.lib.model.fpbcommon.impl.FpbcommonPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PModelElementImpl <em>PModel Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.PModelElementImpl
	 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.FpbcommonPackageImpl#getPModelElement()
	 * @generated
	 */
	int PMODEL_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PMODEL_ELEMENT__ANNOTATIONS = 0;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PMODEL_ELEMENT__ATTATCHMENT = 1;

	/**
	 * The number of structural features of the '<em>PModel Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PMODEL_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PAnnotationImpl <em>PAnnotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.PAnnotationImpl
	 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.FpbcommonPackageImpl#getPAnnotation()
	 * @generated
	 */
	int PANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANNOTATION__ANNOTATIONS = PMODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANNOTATION__ATTATCHMENT = PMODEL_ELEMENT__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Details</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANNOTATION__DETAILS = PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANNOTATION__SOURCE = PMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>PModel Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANNOTATION__PMODEL_ELEMENT = PMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>PAnnotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANNOTATION_FEATURE_COUNT = PMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PNamedElementImpl <em>PNamed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.PNamedElementImpl
	 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.FpbcommonPackageImpl#getPNamedElement()
	 * @generated
	 */
	int PNAMED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PNAMED_ELEMENT__ANNOTATIONS = PMODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PNAMED_ELEMENT__ATTATCHMENT = PMODEL_ELEMENT__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PNAMED_ELEMENT__NAME = PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PNamed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PNAMED_ELEMENT_FEATURE_COUNT = PMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PStringToStringMapEntryImpl <em>PString To String Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.PStringToStringMapEntryImpl
	 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.FpbcommonPackageImpl#getPStringToStringMapEntry()
	 * @generated
	 */
	int PSTRING_TO_STRING_MAP_ENTRY = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSTRING_TO_STRING_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSTRING_TO_STRING_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>PString To String Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSTRING_TO_STRING_MAP_ENTRY_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbcommon.PAnnotation <em>PAnnotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PAnnotation</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PAnnotation
	 * @generated
	 */
	EClass getPAnnotation();

	/**
	 * Returns the meta object for the map '{@link com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Details</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getDetails()
	 * @see #getPAnnotation()
	 * @generated
	 */
	EReference getPAnnotation_Details();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getSource()
	 * @see #getPAnnotation()
	 * @generated
	 */
	EAttribute getPAnnotation_Source();

	/**
	 * Returns the meta object for the container reference '{@link com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getPModelElement <em>PModel Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>PModel Element</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getPModelElement()
	 * @see #getPAnnotation()
	 * @generated
	 */
	EReference getPAnnotation_PModelElement();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbcommon.PModelElement <em>PModel Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PModel Element</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PModelElement
	 * @generated
	 */
	EClass getPModelElement();

	/**
	 * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbcommon.PModelElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PModelElement#getAnnotations()
	 * @see #getPModelElement()
	 * @generated
	 */
	EReference getPModelElement_Annotations();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbcommon.PModelElement#getAttatchment <em>Attatchment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attatchment</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PModelElement#getAttatchment()
	 * @see #getPModelElement()
	 * @generated
	 */
	EAttribute getPModelElement_Attatchment();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbcommon.PNamedElement <em>PNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PNamed Element</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PNamedElement
	 * @generated
	 */
	EClass getPNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbcommon.PNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PNamedElement#getName()
	 * @see #getPNamedElement()
	 * @generated
	 */
	EAttribute getPNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>PString To String Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PString To String Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.xml.type.String"
	 *        keyExtendedMetaData="kind='attribute' name='key'"
	 *        valueDataType="org.eclipse.emf.ecore.xml.type.String"
	 *        valueExtendedMetaData="kind='attribute' name='value'"
	 *        extendedMetaData="name='PStringToStringMapEntry' kind='empty'"
	 * @generated
	 */
	EClass getPStringToStringMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPStringToStringMapEntry()
	 * @generated
	 */
	EAttribute getPStringToStringMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPStringToStringMapEntry()
	 * @generated
	 */
	EAttribute getPStringToStringMapEntry_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FpbcommonFactory getFpbcommonFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PAnnotationImpl <em>PAnnotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.PAnnotationImpl
		 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.FpbcommonPackageImpl#getPAnnotation()
		 * @generated
		 */
		EClass PANNOTATION = eINSTANCE.getPAnnotation();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PANNOTATION__DETAILS = eINSTANCE.getPAnnotation_Details();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PANNOTATION__SOURCE = eINSTANCE.getPAnnotation_Source();

		/**
		 * The meta object literal for the '<em><b>PModel Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PANNOTATION__PMODEL_ELEMENT = eINSTANCE.getPAnnotation_PModelElement();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PModelElementImpl <em>PModel Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.PModelElementImpl
		 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.FpbcommonPackageImpl#getPModelElement()
		 * @generated
		 */
		EClass PMODEL_ELEMENT = eINSTANCE.getPModelElement();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PMODEL_ELEMENT__ANNOTATIONS = eINSTANCE.getPModelElement_Annotations();

		/**
		 * The meta object literal for the '<em><b>Attatchment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PMODEL_ELEMENT__ATTATCHMENT = eINSTANCE.getPModelElement_Attatchment();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PNamedElementImpl <em>PNamed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.PNamedElementImpl
		 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.FpbcommonPackageImpl#getPNamedElement()
		 * @generated
		 */
		EClass PNAMED_ELEMENT = eINSTANCE.getPNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PNAMED_ELEMENT__NAME = eINSTANCE.getPNamedElement_Name();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PStringToStringMapEntryImpl <em>PString To String Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.PStringToStringMapEntryImpl
		 * @see com.fineqt.fpb.lib.model.fpbcommon.impl.FpbcommonPackageImpl#getPStringToStringMapEntry()
		 * @generated
		 */
		EClass PSTRING_TO_STRING_MAP_ENTRY = eINSTANCE.getPStringToStringMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PSTRING_TO_STRING_MAP_ENTRY__KEY = eINSTANCE.getPStringToStringMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PSTRING_TO_STRING_MAP_ENTRY__VALUE = eINSTANCE.getPStringToStringMapEntry_Value();

	}

} //FpbcommonPackage
