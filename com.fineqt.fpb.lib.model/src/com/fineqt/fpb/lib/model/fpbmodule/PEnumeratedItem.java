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
 * A representation of the model object '<em><b>PEnumerated Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem#getEnumName <em>Enum Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem#getEnumValue <em>Enum Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEnumeratedItem()
 * @model extendedMetaData="name='PEnumeratedItem' kind='elementOnly'"
 * @generated
 */
public interface PEnumeratedItem extends PModelElement {
	/**
     * Returns the value of the '<em><b>Enum Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Enum Name</em>' attribute.
     * @see #setEnumName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEnumeratedItem_EnumName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='enumName'"
     * @generated
     */
	String getEnumName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem#getEnumName <em>Enum Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enum Name</em>' attribute.
     * @see #getEnumName()
     * @generated
     */
	void setEnumName(String value);

	/**
     * Returns the value of the '<em><b>Enum Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Enum Value</em>' attribute.
     * @see #isSetEnumValue()
     * @see #unsetEnumValue()
     * @see #setEnumValue(int)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEnumeratedItem_EnumValue()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='enumValue'"
     * @generated
     */
	int getEnumValue();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem#getEnumValue <em>Enum Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enum Value</em>' attribute.
     * @see #isSetEnumValue()
     * @see #unsetEnumValue()
     * @see #getEnumValue()
     * @generated
     */
	void setEnumValue(int value);

	/**
     * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem#getEnumValue <em>Enum Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSetEnumValue()
     * @see #getEnumValue()
     * @see #setEnumValue(int)
     * @generated
     */
	void unsetEnumValue();

	/**
     * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem#getEnumValue <em>Enum Value</em>}' attribute is set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return whether the value of the '<em>Enum Value</em>' attribute is set.
     * @see #unsetEnumValue()
     * @see #getEnumValue()
     * @see #setEnumValue(int)
     * @generated
     */
	boolean isSetEnumValue();

} // PEnumeratedItem
