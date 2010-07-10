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
 * A representation of the model object '<em><b>PEntity Enum Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet#getEnumItems <em>Enum Items</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet#getBaseTypeName <em>Base Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEntityEnumSet()
 * @model extendedMetaData="name='PEntityEnumSet' kind='elementOnly'"
 * @generated
 */
public interface PEntityEnumSet extends PEnumSet {
	/**
     * Returns the value of the '<em><b>Enum Items</b></em>' containment reference list.
     * The list contents are of type {@link com.fineqt.fpb.lib.model.fpbmodule.PEnumItem}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Enum Items</em>' containment reference list.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEntityEnumSet_EnumItems()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='enumItems'"
     * @generated
     */
	EList<PEnumItem> getEnumItems();

	/**
     * Returns the value of the '<em><b>Base Type Name</b></em>' attribute.
     * The default value is <code>"integer"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Base Type Name</em>' attribute.
     * @see #isSetBaseTypeName()
     * @see #unsetBaseTypeName()
     * @see #setBaseTypeName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEntityEnumSet_BaseTypeName()
     * @model default="integer" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='baseTypeName'"
     * @generated
     */
	String getBaseTypeName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet#getBaseTypeName <em>Base Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Type Name</em>' attribute.
     * @see #isSetBaseTypeName()
     * @see #unsetBaseTypeName()
     * @see #getBaseTypeName()
     * @generated
     */
	void setBaseTypeName(String value);

	/**
     * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet#getBaseTypeName <em>Base Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSetBaseTypeName()
     * @see #getBaseTypeName()
     * @see #setBaseTypeName(String)
     * @generated
     */
	void unsetBaseTypeName();

	/**
     * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet#getBaseTypeName <em>Base Type Name</em>}' attribute is set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return whether the value of the '<em>Base Type Name</em>' attribute is set.
     * @see #unsetBaseTypeName()
     * @see #getBaseTypeName()
     * @see #setBaseTypeName(String)
     * @generated
     */
	boolean isSetBaseTypeName();

} // PEntityEnumSet
