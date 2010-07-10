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
 * A representation of the model object '<em><b>PList Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PListType#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPListType()
 * @model abstract="true"
 *        extendedMetaData="name='PListType' kind='elementOnly'"
 * @generated
 */
public interface PListType extends PEntityType {

	/**
     * Returns the value of the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Item</em>' containment reference.
     * @see #setItem(PListItem)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPListType_Item()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='item'"
     * @generated
     */
	PListItem getItem();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PListType#getItem <em>Item</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Item</em>' containment reference.
     * @see #getItem()
     * @generated
     */
	void setItem(PListItem value);
} // PListType
