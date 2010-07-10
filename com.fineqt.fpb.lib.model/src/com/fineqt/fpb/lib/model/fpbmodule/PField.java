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

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PField</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PField#getFieldID <em>Field ID</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PField#isOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPField()
 * @model extendedMetaData="name='PField' kind='elementOnly'"
 * @generated
 */
public interface PField extends PItemField {

	/**
     * Returns the value of the '<em><b>Field ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Field ID</em>' attribute.
     * @see #isSetFieldID()
     * @see #unsetFieldID()
     * @see #setFieldID(int)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPField_FieldID()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
     *        extendedMetaData="kind='attribute' name='fieldID'"
     * @generated
     */
	int getFieldID();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PField#getFieldID <em>Field ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Field ID</em>' attribute.
     * @see #isSetFieldID()
     * @see #unsetFieldID()
     * @see #getFieldID()
     * @generated
     */
	void setFieldID(int value);

	/**
     * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PField#getFieldID <em>Field ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSetFieldID()
     * @see #getFieldID()
     * @see #setFieldID(int)
     * @generated
     */
	void unsetFieldID();

	/**
     * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PField#getFieldID <em>Field ID</em>}' attribute is set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return whether the value of the '<em>Field ID</em>' attribute is set.
     * @see #unsetFieldID()
     * @see #getFieldID()
     * @see #setFieldID(int)
     * @generated
     */
	boolean isSetFieldID();

	/**
     * Returns the value of the '<em><b>Optional</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Optional</em>' attribute.
     * @see #isSetOptional()
     * @see #unsetOptional()
     * @see #setOptional(boolean)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPField_Optional()
     * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='optional'"
     * @generated
     */
	boolean isOptional();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PField#isOptional <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Optional</em>' attribute.
     * @see #isSetOptional()
     * @see #unsetOptional()
     * @see #isOptional()
     * @generated
     */
	void setOptional(boolean value);

	/**
     * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PField#isOptional <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSetOptional()
     * @see #isOptional()
     * @see #setOptional(boolean)
     * @generated
     */
	void unsetOptional();

	/**
     * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PField#isOptional <em>Optional</em>}' attribute is set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return whether the value of the '<em>Optional</em>' attribute is set.
     * @see #unsetOptional()
     * @see #isOptional()
     * @see #setOptional(boolean)
     * @generated
     */
	boolean isSetOptional();
} // PField
