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
 * A representation of the model object '<em><b>PEncoding Variant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant#getEncodedElement <em>Encoded Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEncodingVariant()
 * @model abstract="true"
 *        extendedMetaData="name='PEncodingVariant' kind='elementOnly'"
 * @generated
 */
public interface PEncodingVariant extends PModelElement {
	/**
     * Returns the value of the '<em><b>Encoded Element</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getVariant <em>Variant</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encoded Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Encoded Element</em>' container reference.
     * @see #setEncodedElement(PEncodedElement)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEncodingVariant_EncodedElement()
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getVariant
     * @model opposite="variant"
     * @generated
     */
	PEncodedElement getEncodedElement();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant#getEncodedElement <em>Encoded Element</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Encoded Element</em>' container reference.
     * @see #getEncodedElement()
     * @generated
     */
	void setEncodedElement(PEncodedElement value);
	/**
	 * 判断是否有任何属性被设置了。
	 * @return
	 */
/*
	boolean isSetAny();
*/	
} // PEncodingVariant
