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
 * A representation of the model object '<em><b>PList Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PListArgument#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPListArgument()
 * @model extendedMetaData="name='PListArgument' kind='elementOnly'"
 * @generated
 */
public interface PListArgument extends PArgument {
	/**
     * Returns the value of the '<em><b>Group</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Group</em>' containment reference.
     * @see #setGroup(PArgumentGroup)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPListArgument_Group()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='group'"
     * @generated
     */
	PArgumentGroup getGroup();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PListArgument#getGroup <em>Group</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Group</em>' containment reference.
     * @see #getGroup()
     * @generated
     */
	void setGroup(PArgumentGroup value);

} // PListArgument
