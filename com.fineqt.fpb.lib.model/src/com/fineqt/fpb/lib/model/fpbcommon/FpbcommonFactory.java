/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbcommon;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage
 * @generated
 */
public interface FpbcommonFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FpbcommonFactory eINSTANCE = com.fineqt.fpb.lib.model.fpbcommon.impl.FpbcommonFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>PAnnotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PAnnotation</em>'.
	 * @generated
	 */
	PAnnotation createPAnnotation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FpbcommonPackage getFpbcommonPackage();

} //FpbcommonFactory
