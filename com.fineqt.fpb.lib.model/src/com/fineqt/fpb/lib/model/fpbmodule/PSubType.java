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
 * A representation of the model object '<em><b>PSub Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PSubType#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PSubType#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PSubType#getSuperTypeName <em>Super Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPSubType()
 * @model extendedMetaData="name='PSubType' kind='elementOnly'"
 * @generated
 */
public interface PSubType extends PType {
	/**
     * Returns the value of the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Constraint</em>' containment reference.
     * @see #setConstraint(PTypeConstraint)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPSubType_Constraint()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='constraint'"
     * @generated
     */
	PTypeConstraint getConstraint();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PSubType#getConstraint <em>Constraint</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Constraint</em>' containment reference.
     * @see #getConstraint()
     * @generated
     */
	void setConstraint(PTypeConstraint value);

	/**
     * Returns the value of the '<em><b>Super Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Super Type</em>' reference.
     * @see #setSuperType(PType)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPSubType_SuperType()
     * @model extendedMetaData="kind='attribute' name='superType'"
     * @generated
     */
	PType getSuperType();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PSubType#getSuperType <em>Super Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Super Type</em>' reference.
     * @see #getSuperType()
     * @generated
     */
	void setSuperType(PType value);

	/**
     * Returns the value of the '<em><b>Super Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Super Type Name</em>' attribute.
     * @see #setSuperTypeName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPSubType_SuperTypeName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='superTypeName'"
     * @generated
     */
	String getSuperTypeName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PSubType#getSuperTypeName <em>Super Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Super Type Name</em>' attribute.
     * @see #getSuperTypeName()
     * @generated
     */
	void setSuperTypeName(String value);

} // PSubType
