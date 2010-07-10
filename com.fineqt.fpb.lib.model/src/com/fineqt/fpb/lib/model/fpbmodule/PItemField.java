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
 * A representation of the model object '<em><b>PItem Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PItemField#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PItemField#getEnumItems <em>Enum Items</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PItemField#getEnumRef <em>Enum Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPItemField()
 * @model extendedMetaData="name='PItemField' kind='elementOnly'"
 * @generated
 */
public interface PItemField extends PTypedElement {
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
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPItemField_Constraint()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='constraint'"
     * @generated
     */
    PTypeConstraint getConstraint();

    /**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PItemField#getConstraint <em>Constraint</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Constraint</em>' containment reference.
     * @see #getConstraint()
     * @generated
     */
    void setConstraint(PTypeConstraint value);

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
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPItemField_EnumItems()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='enumItems'"
     * @generated
     */
    EList<PEnumItem> getEnumItems();

    /**
     * Returns the value of the '<em><b>Enum Ref</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enum Ref</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enum Ref</em>' attribute.
     * @see #setEnumRef(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPItemField_EnumRef()
     * @model dataType="org.eclipse.emf.ecore.xml.type.NMTOKEN"
     *        extendedMetaData="kind='attribute' name='enumRef'"
     * @generated
     */
    String getEnumRef();

    /**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PItemField#getEnumRef <em>Enum Ref</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enum Ref</em>' attribute.
     * @see #getEnumRef()
     * @generated
     */
    void setEnumRef(String value);

} // PItemField
