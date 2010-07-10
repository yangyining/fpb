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
 * A representation of the model object '<em><b>PImport Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportConstant#getImportedConstant <em>Imported Constant</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportConstant#getImportedConstantName <em>Imported Constant Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportConstant#getImportedModuleName <em>Imported Module Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportConstant()
 * @model extendedMetaData="name='PImportConstant' kind='elementOnly'"
 * @generated
 */
public interface PImportConstant extends PConstant {
	/**
     * Returns the value of the '<em><b>Imported Constant</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Constant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Imported Constant</em>' reference.
     * @see #setImportedConstant(PConstant)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportConstant_ImportedConstant()
     * @model extendedMetaData="kind='attribute' name='importedConstant'"
     * @generated
     */
	PConstant getImportedConstant();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportConstant#getImportedConstant <em>Imported Constant</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Constant</em>' reference.
     * @see #getImportedConstant()
     * @generated
     */
	void setImportedConstant(PConstant value);

	/**
     * Returns the value of the '<em><b>Imported Constant Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Constant Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Imported Constant Name</em>' attribute.
     * @see #setImportedConstantName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportConstant_ImportedConstantName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='importedConstantName'"
     * @generated
     */
	String getImportedConstantName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportConstant#getImportedConstantName <em>Imported Constant Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Constant Name</em>' attribute.
     * @see #getImportedConstantName()
     * @generated
     */
	void setImportedConstantName(String value);

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
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportConstant_ImportedModuleName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='importedModuleName'"
     * @generated
     */
	String getImportedModuleName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportConstant#getImportedModuleName <em>Imported Module Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Module Name</em>' attribute.
     * @see #getImportedModuleName()
     * @generated
     */
	void setImportedModuleName(String value);

} // PImportConstant
