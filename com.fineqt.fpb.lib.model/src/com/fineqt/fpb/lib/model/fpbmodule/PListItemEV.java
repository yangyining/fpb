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
 * A representation of the model object '<em><b>PList Item EV</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PListItemEV#getPrpList <em>Prp List</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPListItemEV()
 * @model extendedMetaData="name='PListItemEV' kind='elementOnly'"
 * @generated
 */
public interface PListItemEV extends PEncodingVariant {
	/**
     * Returns the value of the '<em><b>Prp List</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prp List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Prp List</em>' containment reference.
     * @see #setPrpList(PPropertyList)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPListItemEV_PrpList()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='prpList'"
     * @generated
     */
	PPropertyList getPrpList();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PListItemEV#getPrpList <em>Prp List</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Prp List</em>' containment reference.
     * @see #getPrpList()
     * @generated
     */
	void setPrpList(PPropertyList value);

} // PListItemEV
