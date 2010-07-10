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
 * A representation of the model object '<em><b>PImport Module Par</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar#getImportedModuleName <em>Imported Module Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar#getImportedModulePar <em>Imported Module Par</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar#getImportedModulePartName <em>Imported Module Part Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportModulePar()
 * @model extendedMetaData="name='PImportModulePar' kind='elementOnly'"
 * @generated
 */
public interface PImportModulePar extends PModulePar {
	/**
     * Returns the value of the '<em><b>Imported Module Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Module Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Imported Module Name</em>' attribute.
     * @see #setImportedModuleName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportModulePar_ImportedModuleName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='importedModuleName'"
     * @generated
     */
	String getImportedModuleName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar#getImportedModuleName <em>Imported Module Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Module Name</em>' attribute.
     * @see #getImportedModuleName()
     * @generated
     */
	void setImportedModuleName(String value);

	/**
     * Returns the value of the '<em><b>Imported Module Par</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Module Par</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Imported Module Par</em>' reference.
     * @see #setImportedModulePar(PModulePar)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportModulePar_ImportedModulePar()
     * @model extendedMetaData="kind='attribute' name='importedModulePar'"
     * @generated
     */
	PModulePar getImportedModulePar();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar#getImportedModulePar <em>Imported Module Par</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Module Par</em>' reference.
     * @see #getImportedModulePar()
     * @generated
     */
	void setImportedModulePar(PModulePar value);

	/**
     * Returns the value of the '<em><b>Imported Module Part Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Module Part Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Imported Module Part Name</em>' attribute.
     * @see #setImportedModulePartName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportModulePar_ImportedModulePartName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='importedModulePartName'"
     * @generated
     */
	String getImportedModulePartName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar#getImportedModulePartName <em>Imported Module Part Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Module Part Name</em>' attribute.
     * @see #getImportedModulePartName()
     * @generated
     */
	void setImportedModulePartName(String value);

} // PImportModulePar
