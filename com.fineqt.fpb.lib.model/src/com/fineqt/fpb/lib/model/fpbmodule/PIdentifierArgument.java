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
 * A representation of the model object '<em><b>PIdentifier Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PIdentifierArgument#getDesc <em>Desc</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPIdentifierArgument()
 * @model extendedMetaData="name='PIdentifierArgument' kind='elementOnly'"
 * @generated
 */
public interface PIdentifierArgument extends PSingleArgument {
	/**
     * Returns the value of the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Desc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Desc</em>' attribute.
     * @see #setDesc(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPIdentifierArgument_Desc()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='desc'"
     * @generated
     */
	String getDesc();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PIdentifierArgument#getDesc <em>Desc</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Desc</em>' attribute.
     * @see #getDesc()
     * @generated
     */
	void setDesc(String value);

} // PIdentifierArgument
