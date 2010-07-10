/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbcommon.impl;

import com.fineqt.fpb.lib.model.fpbcommon.*;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
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
public class FpbcommonFactoryImpl extends EFactoryImpl implements FpbcommonFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FpbcommonFactory init() {
		try {
			FpbcommonFactory theFpbcommonFactory = (FpbcommonFactory)EPackage.Registry.INSTANCE.getEFactory("http://fpbcommon.model.lib.fpb.fineqt.com"); 
			if (theFpbcommonFactory != null) {
				return theFpbcommonFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FpbcommonFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FpbcommonFactoryImpl() {
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
			case FpbcommonPackage.PANNOTATION: return createPAnnotation();
			case FpbcommonPackage.PSTRING_TO_STRING_MAP_ENTRY: return (EObject)createPStringToStringMapEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PAnnotation createPAnnotation() {
		PAnnotationImpl pAnnotation = new PAnnotationImpl();
		return pAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createPStringToStringMapEntry() {
		PStringToStringMapEntryImpl pStringToStringMapEntry = new PStringToStringMapEntryImpl();
		return pStringToStringMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FpbcommonPackage getFpbcommonPackage() {
		return (FpbcommonPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FpbcommonPackage getPackage() {
		return FpbcommonPackage.eINSTANCE;
	}

} //FpbcommonFactoryImpl
