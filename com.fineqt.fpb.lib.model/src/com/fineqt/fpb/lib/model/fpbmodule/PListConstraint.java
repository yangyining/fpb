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

import com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PList Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PListConstraint#getMatcher <em>Matcher</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPListConstraint()
 * @model extendedMetaData="name='PListConstraint' kind='elementOnly'"
 * @generated
 */
public interface PListConstraint extends PTypeConstraint {
	/**
     * Returns the value of the '<em><b>Matcher</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Matcher</em>' containment reference.
     * @see #setMatcher(PValueListMatcher)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPListConstraint_Matcher()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='matcher'"
     * @generated
     */
	PValueListMatcher getMatcher();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PListConstraint#getMatcher <em>Matcher</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Matcher</em>' containment reference.
     * @see #getMatcher()
     * @generated
     */
	void setMatcher(PValueListMatcher value);
	
	PListConstraint rsetMatcher(PValueListMatcher value);

} // PListConstraint
