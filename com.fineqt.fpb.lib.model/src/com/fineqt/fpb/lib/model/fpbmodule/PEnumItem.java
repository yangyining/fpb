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

import com.fineqt.fpb.lib.model.fpbcommon.PModelElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PEnum Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumItem#getCond <em>Cond</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumItem#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEnumItem()
 * @model extendedMetaData="name='PEnumItem' kind='elementOnly'"
 * @generated
 */
public interface PEnumItem extends PModelElement {
	/**
     * Returns the value of the '<em><b>Cond</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Cond</em>' containment reference.
     * @see #setCond(PTypeConstraint)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEnumItem_Cond()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='cond'"
     * @generated
     */
	PTypeConstraint getCond();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumItem#getCond <em>Cond</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cond</em>' containment reference.
     * @see #getCond()
     * @generated
     */
	void setCond(PTypeConstraint value);

	/**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEnumItem_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumItem#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

} // PEnumItem
