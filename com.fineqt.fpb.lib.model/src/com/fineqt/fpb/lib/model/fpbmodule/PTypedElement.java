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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PTyped Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PTypedElement#getPtype <em>Ptype</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PTypedElement#getPtypeName <em>Ptype Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPTypedElement()
 * @model abstract="true"
 *        extendedMetaData="name='PTypedElement' kind='elementOnly'"
 * @generated
 */
public interface PTypedElement extends PEncodedElement {
	/**
     * Returns the value of the '<em><b>Ptype</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ptype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Ptype</em>' reference.
     * @see #setPtype(PType)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPTypedElement_Ptype()
     * @model extendedMetaData="kind='attribute' name='ptype'"
     * @generated
     */
	PType getPtype();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypedElement#getPtype <em>Ptype</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ptype</em>' reference.
     * @see #getPtype()
     * @generated
     */
	void setPtype(PType value);

	/**
     * Returns the value of the '<em><b>Ptype Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ptype Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Ptype Name</em>' attribute.
     * @see #setPtypeName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPTypedElement_PtypeName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='ptypeName'"
     * @generated
     */
	String getPtypeName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypedElement#getPtypeName <em>Ptype Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ptype Name</em>' attribute.
     * @see #getPtypeName()
     * @generated
     */
	void setPtypeName(String value);

} // PTypedElement
