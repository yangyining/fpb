/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbcommon.impl;

import com.fineqt.fpb.lib.model.fpbcommon.FpbcommonFactory;
import com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage;
import com.fineqt.fpb.lib.model.fpbcommon.PAnnotation;
import com.fineqt.fpb.lib.model.fpbcommon.PModelElement;
import com.fineqt.fpb.lib.model.fpbcommon.PNamedElement;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FpbcommonPackageImpl extends EPackageImpl implements FpbcommonPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pModelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pStringToStringMapEntryEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FpbcommonPackageImpl() {
		super(eNS_URI, FpbcommonFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FpbcommonPackage init() {
		if (isInited) return (FpbcommonPackage)EPackage.Registry.INSTANCE.getEPackage(FpbcommonPackage.eNS_URI);

		// Obtain or create and register package
		FpbcommonPackageImpl theFpbcommonPackage = (FpbcommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof FpbcommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new FpbcommonPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFpbcommonPackage.createPackageContents();

		// Initialize created meta-data
		theFpbcommonPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFpbcommonPackage.freeze();

		return theFpbcommonPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPAnnotation() {
		return pAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAnnotation_Details() {
		return (EReference)pAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPAnnotation_Source() {
		return (EAttribute)pAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAnnotation_PModelElement() {
		return (EReference)pAnnotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPModelElement() {
		return pModelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPModelElement_Annotations() {
		return (EReference)pModelElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPModelElement_Attatchment() {
		return (EAttribute)pModelElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPNamedElement() {
		return pNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPNamedElement_Name() {
		return (EAttribute)pNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPStringToStringMapEntry() {
		return pStringToStringMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPStringToStringMapEntry_Key() {
		return (EAttribute)pStringToStringMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPStringToStringMapEntry_Value() {
		return (EAttribute)pStringToStringMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FpbcommonFactory getFpbcommonFactory() {
		return (FpbcommonFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		pAnnotationEClass = createEClass(PANNOTATION);
		createEReference(pAnnotationEClass, PANNOTATION__DETAILS);
		createEAttribute(pAnnotationEClass, PANNOTATION__SOURCE);
		createEReference(pAnnotationEClass, PANNOTATION__PMODEL_ELEMENT);

		pModelElementEClass = createEClass(PMODEL_ELEMENT);
		createEReference(pModelElementEClass, PMODEL_ELEMENT__ANNOTATIONS);
		createEAttribute(pModelElementEClass, PMODEL_ELEMENT__ATTATCHMENT);

		pNamedElementEClass = createEClass(PNAMED_ELEMENT);
		createEAttribute(pNamedElementEClass, PNAMED_ELEMENT__NAME);

		pStringToStringMapEntryEClass = createEClass(PSTRING_TO_STRING_MAP_ENTRY);
		createEAttribute(pStringToStringMapEntryEClass, PSTRING_TO_STRING_MAP_ENTRY__KEY);
		createEAttribute(pStringToStringMapEntryEClass, PSTRING_TO_STRING_MAP_ENTRY__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pAnnotationEClass.getESuperTypes().add(this.getPModelElement());
		pNamedElementEClass.getESuperTypes().add(this.getPModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(pAnnotationEClass, PAnnotation.class, "PAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPAnnotation_Details(), this.getPStringToStringMapEntry(), null, "details", null, 0, -1, PAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPAnnotation_Source(), theXMLTypePackage.getString(), "source", null, 0, 1, PAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAnnotation_PModelElement(), this.getPModelElement(), this.getPModelElement_Annotations(), "pModelElement", null, 0, 1, PAnnotation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pModelElementEClass, PModelElement.class, "PModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPModelElement_Annotations(), this.getPAnnotation(), this.getPAnnotation_PModelElement(), "annotations", null, 0, -1, PModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPModelElement_Attatchment(), theXMLTypePackage.getAnySimpleType(), "attatchment", null, 0, 1, PModelElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pNamedElementEClass, PNamedElement.class, "PNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPNamedElement_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, PNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pStringToStringMapEntryEClass, Map.Entry.class, "PStringToStringMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPStringToStringMapEntry_Key(), theXMLTypePackage.getString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPStringToStringMapEntry_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (pAnnotationEClass, 
		   source, 
		   new String[] {
			 "name", "PAnnotation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPAnnotation_Details(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "details"
		   });		
		addAnnotation
		  (getPAnnotation_Source(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "source"
		   });		
		addAnnotation
		  (pModelElementEClass, 
		   source, 
		   new String[] {
			 "name", "PModelElement",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPModelElement_Annotations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "annotations"
		   });		
		addAnnotation
		  (getPModelElement_Attatchment(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "attatchment"
		   });		
		addAnnotation
		  (pNamedElementEClass, 
		   source, 
		   new String[] {
			 "name", "PNamedElement",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPNamedElement_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (pStringToStringMapEntryEClass, 
		   source, 
		   new String[] {
			 "name", "PStringToStringMapEntry",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getPStringToStringMapEntry_Key(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "key"
		   });		
		addAnnotation
		  (getPStringToStringMapEntry_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "value"
		   });
	}

} //FpbcommonPackageImpl
