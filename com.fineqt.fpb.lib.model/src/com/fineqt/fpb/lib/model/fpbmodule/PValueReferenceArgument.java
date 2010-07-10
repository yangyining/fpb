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

import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PValue Reference Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument#getValueRef <em>Value Ref</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPValueReferenceArgument()
 * @model extendedMetaData="name='PValueReferenceArgument' kind='elementOnly'"
 * @generated
 */
public interface PValueReferenceArgument extends PSingleArgument {
	/**
     * Returns the value of the '<em><b>Value Ref</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value Ref</em>' containment reference.
     * @see #setValueRef(PValueReferenceMatcher)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPValueReferenceArgument_ValueRef()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='valueRef'"
     * @generated
     */
	PValueReferenceMatcher getValueRef();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument#getValueRef <em>Value Ref</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Ref</em>' containment reference.
     * @see #getValueRef()
     * @generated
     */
	void setValueRef(PValueReferenceMatcher value);

	/**
     * Returns the value of the '<em><b>Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type Name</em>' attribute.
     * @see #setTypeName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPValueReferenceArgument_TypeName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='typeName'"
     * @generated
     */
	String getTypeName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument#getTypeName <em>Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type Name</em>' attribute.
     * @see #getTypeName()
     * @generated
     */
	void setTypeName(String value);

} // PValueReferenceArgument
