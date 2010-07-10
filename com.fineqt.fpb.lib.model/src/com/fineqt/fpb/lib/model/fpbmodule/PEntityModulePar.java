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

import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PEntity Module Par</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#getMatcher <em>Matcher</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#getBaseTypeName <em>Base Type Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#isThread <em>Thread</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEntityModulePar()
 * @model extendedMetaData="name='PEntityModulePar' kind='elementOnly'"
 * @generated
 */
public interface PEntityModulePar extends PModulePar {
	/**
     * Returns the value of the '<em><b>Matcher</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Matcher</em>' containment reference.
     * @see #setMatcher(PMatcher)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEntityModulePar_Matcher()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='matcher'"
     * @generated
     */
	PMatcher getMatcher();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#getMatcher <em>Matcher</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Matcher</em>' containment reference.
     * @see #getMatcher()
     * @generated
     */
	void setMatcher(PMatcher value);

	/**
     * Returns the value of the '<em><b>Base Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Base Type Name</em>' attribute.
     * @see #setBaseTypeName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEntityModulePar_BaseTypeName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='baseTypeName'"
     * @generated
     */
	String getBaseTypeName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#getBaseTypeName <em>Base Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Type Name</em>' attribute.
     * @see #getBaseTypeName()
     * @generated
     */
	void setBaseTypeName(String value);

	/**
     * Returns the value of the '<em><b>Thread</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thread</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Thread</em>' attribute.
     * @see #isSetThread()
     * @see #unsetThread()
     * @see #setThread(boolean)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEntityModulePar_Thread()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='thread'"
     * @generated
     */
	boolean isThread();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#isThread <em>Thread</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Thread</em>' attribute.
     * @see #isSetThread()
     * @see #unsetThread()
     * @see #isThread()
     * @generated
     */
	void setThread(boolean value);

	/**
     * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#isThread <em>Thread</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSetThread()
     * @see #isThread()
     * @see #setThread(boolean)
     * @generated
     */
	void unsetThread();

	/**
     * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#isThread <em>Thread</em>}' attribute is set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return whether the value of the '<em>Thread</em>' attribute is set.
     * @see #unsetThread()
     * @see #isThread()
     * @see #setThread(boolean)
     * @generated
     */
	boolean isSetThread();

} // PEntityModulePar
