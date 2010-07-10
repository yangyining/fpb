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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PModule Par</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PModulePar#getModuleParID <em>Module Par ID</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PModulePar#getPmodule <em>Pmodule</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModulePar()
 * @model abstract="true"
 *        extendedMetaData="name='PModulePar' kind='elementOnly'"
 * @generated
 */
public interface PModulePar extends PNamedElement {
	/**
     * Returns the value of the '<em><b>Module Par ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Par ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Module Par ID</em>' attribute.
     * @see #isSetModuleParID()
     * @see #unsetModuleParID()
     * @see #setModuleParID(int)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModulePar_ModuleParID()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='moduleParID'"
     * @generated
     */
	int getModuleParID();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PModulePar#getModuleParID <em>Module Par ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Module Par ID</em>' attribute.
     * @see #isSetModuleParID()
     * @see #unsetModuleParID()
     * @see #getModuleParID()
     * @generated
     */
	void setModuleParID(int value);

	/**
     * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PModulePar#getModuleParID <em>Module Par ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSetModuleParID()
     * @see #getModuleParID()
     * @see #setModuleParID(int)
     * @generated
     */
	void unsetModuleParID();

	/**
     * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PModulePar#getModuleParID <em>Module Par ID</em>}' attribute is set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return whether the value of the '<em>Module Par ID</em>' attribute is set.
     * @see #unsetModuleParID()
     * @see #getModuleParID()
     * @see #setModuleParID(int)
     * @generated
     */
	boolean isSetModuleParID();

	/**
     * Returns the value of the '<em><b>Pmodule</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getModulePars <em>Module Pars</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pmodule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Pmodule</em>' container reference.
     * @see #setPmodule(PModule)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModulePar_Pmodule()
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getModulePars
     * @model opposite="modulePars"
     * @generated
     */
	PModule getPmodule();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PModulePar#getPmodule <em>Pmodule</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pmodule</em>' container reference.
     * @see #getPmodule()
     * @generated
     */
	void setPmodule(PModule value);

} // PModulePar
