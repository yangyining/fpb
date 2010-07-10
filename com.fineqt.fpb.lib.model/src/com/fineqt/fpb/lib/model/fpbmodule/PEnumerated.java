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
 * A representation of the model object '<em><b>PEnumerated</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumerated#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEnumerated()
 * @model extendedMetaData="name='PEnumerated' kind='elementOnly'"
 * @generated
 */
public interface PEnumerated extends PPrimitiveType {

	/**
     * Returns the value of the '<em><b>Items</b></em>' containment reference list.
     * The list contents are of type {@link com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Items</em>' containment reference list.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEnumerated_Items()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='items'"
     * @generated
     */
	EList<PEnumeratedItem> getItems();
} // PEnumerated
