/**
 * Fine Packet Builder, copyright (C) 2007-2009 fineqt.com
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU General Public License for more details at gnu.org.
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbmodule;

import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PLength Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPLengthConstraint()
 * @model extendedMetaData="name='PLengthConstraint' kind='elementOnly'"
 * @generated
 */
public interface PLengthConstraint extends PTypeConstraint {
	/**
     * Returns the value of the '<em><b>Lower Bound</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Lower Bound</em>' containment reference.
     * @see #setLowerBound(PMatcher)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPLengthConstraint_LowerBound()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='lowerBound'"
     * @generated
     */
	PMatcher getLowerBound();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint#getLowerBound <em>Lower Bound</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Lower Bound</em>' containment reference.
     * @see #getLowerBound()
     * @generated
     */
	void setLowerBound(PMatcher value);

	/**
     * Returns the value of the '<em><b>Upper Bound</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Upper Bound</em>' containment reference.
     * @see #setUpperBound(PMatcher)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPLengthConstraint_UpperBound()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='upperBound'"
     * @generated
     */
	PMatcher getUpperBound();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint#getUpperBound <em>Upper Bound</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Upper Bound</em>' containment reference.
     * @see #getUpperBound()
     * @generated
     */
	void setUpperBound(PMatcher value);

} // PLengthConstraint
