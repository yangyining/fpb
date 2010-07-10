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
 * A representation of the model object '<em><b>PEntity Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant#getMatcher <em>Matcher</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant#getBaseTypeName <em>Base Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEntityConstant()
 * @model extendedMetaData="name='PEntityConstant' kind='elementOnly'"
 * @generated
 */
public interface PEntityConstant extends PConstant {
	/**
     * Returns the value of the '<em><b>Matcher</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Matcher</em>' containment reference.
     * @see #setMatcher(PMatcher)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEntityConstant_Matcher()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='matcher'"
     * @generated
     */
	PMatcher getMatcher();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant#getMatcher <em>Matcher</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Matcher</em>' containment reference.
     * @see #getMatcher()
     * @generated
     */
	void setMatcher(PMatcher value);

	/**
     * Returns the value of the '<em><b>Base Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Base Type Name</em>' attribute.
     * @see #setBaseTypeName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEntityConstant_BaseTypeName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='baseTypeName'"
     * @generated
     */
	String getBaseTypeName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant#getBaseTypeName <em>Base Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Type Name</em>' attribute.
     * @see #getBaseTypeName()
     * @generated
     */
	void setBaseTypeName(String value);

} // PEntityConstant
