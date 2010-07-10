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

import com.fineqt.fpb.lib.model.fpbcommon.PNamedElement;
import com.fineqt.fpb.lib.model.fpbcommon.PModelElement;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PEnum Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumSet#getEnumSetID <em>Enum Set ID</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumSet#getPmodule <em>Pmodule</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEnumSet()
 * @model abstract="true"
 *        extendedMetaData="name='PEnumSet' kind='elementOnly'"
 * @generated
 */
public interface PEnumSet extends PNamedElement {
	/**
     * Returns the value of the '<em><b>Enum Set ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Set ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Enum Set ID</em>' attribute.
     * @see #isSetEnumSetID()
     * @see #unsetEnumSetID()
     * @see #setEnumSetID(int)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEnumSet_EnumSetID()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='enumSetID'"
     * @generated
     */
	int getEnumSetID();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumSet#getEnumSetID <em>Enum Set ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enum Set ID</em>' attribute.
     * @see #isSetEnumSetID()
     * @see #unsetEnumSetID()
     * @see #getEnumSetID()
     * @generated
     */
	void setEnumSetID(int value);

	/**
     * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumSet#getEnumSetID <em>Enum Set ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSetEnumSetID()
     * @see #getEnumSetID()
     * @see #setEnumSetID(int)
     * @generated
     */
	void unsetEnumSetID();

	/**
     * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumSet#getEnumSetID <em>Enum Set ID</em>}' attribute is set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return whether the value of the '<em>Enum Set ID</em>' attribute is set.
     * @see #unsetEnumSetID()
     * @see #getEnumSetID()
     * @see #setEnumSetID(int)
     * @generated
     */
	boolean isSetEnumSetID();

	/**
     * Returns the value of the '<em><b>Pmodule</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getEnumSets <em>Enum Sets</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pmodule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Pmodule</em>' container reference.
     * @see #setPmodule(PModule)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEnumSet_Pmodule()
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getEnumSets
     * @model opposite="enumSets"
     * @generated
     */
	PModule getPmodule();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumSet#getPmodule <em>Pmodule</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pmodule</em>' container reference.
     * @see #getPmodule()
     * @generated
     */
	void setPmodule(PModule value);

} // PEnumSet
