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

import com.fineqt.fpb.lib.model.fpbcommon.PNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PConstant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PConstant#getConstantID <em>Constant ID</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PConstant#getPmodule <em>Pmodule</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPConstant()
 * @model abstract="true"
 *        extendedMetaData="name='PConstant' kind='elementOnly'"
 * @generated
 */
public interface PConstant extends PNamedElement {
	/**
     * Returns the value of the '<em><b>Constant ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Constant ID</em>' attribute.
     * @see #isSetConstantID()
     * @see #unsetConstantID()
     * @see #setConstantID(int)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPConstant_ConstantID()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='constantID'"
     * @generated
     */
	int getConstantID();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PConstant#getConstantID <em>Constant ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Constant ID</em>' attribute.
     * @see #isSetConstantID()
     * @see #unsetConstantID()
     * @see #getConstantID()
     * @generated
     */
	void setConstantID(int value);

	/**
     * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PConstant#getConstantID <em>Constant ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSetConstantID()
     * @see #getConstantID()
     * @see #setConstantID(int)
     * @generated
     */
	void unsetConstantID();

	/**
     * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PConstant#getConstantID <em>Constant ID</em>}' attribute is set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return whether the value of the '<em>Constant ID</em>' attribute is set.
     * @see #unsetConstantID()
     * @see #getConstantID()
     * @see #setConstantID(int)
     * @generated
     */
	boolean isSetConstantID();

	/**
     * Returns the value of the '<em><b>Pmodule</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getConstants <em>Constants</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pmodule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Pmodule</em>' container reference.
     * @see #setPmodule(PModule)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPConstant_Pmodule()
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getConstants
     * @model opposite="constants"
     * @generated
     */
	PModule getPmodule();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PConstant#getPmodule <em>Pmodule</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pmodule</em>' container reference.
     * @see #getPmodule()
     * @generated
     */
	void setPmodule(PModule value);
	
	String getBaseTypeName();	

} // PConstant
