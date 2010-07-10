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
 * A representation of the model object '<em><b>PImport Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportType#getImportedModuleName <em>Imported Module Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportType#getImportedType <em>Imported Type</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportType#getImportedTypeName <em>Imported Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportType()
 * @model extendedMetaData="name='PImportType' kind='elementOnly'"
 * @generated
 */
public interface PImportType extends PType {
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
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportType_ImportedModuleName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='importedModuleName'"
     * @generated
     */
	String getImportedModuleName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportType#getImportedModuleName <em>Imported Module Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Module Name</em>' attribute.
     * @see #getImportedModuleName()
     * @generated
     */
	void setImportedModuleName(String value);

	/**
     * Returns the value of the '<em><b>Imported Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Imported Type</em>' reference.
     * @see #setImportedType(PType)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportType_ImportedType()
     * @model extendedMetaData="kind='attribute' name='importedType'"
     * @generated
     */
	PType getImportedType();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportType#getImportedType <em>Imported Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Type</em>' reference.
     * @see #getImportedType()
     * @generated
     */
	void setImportedType(PType value);

	/**
     * Returns the value of the '<em><b>Imported Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Imported Type Name</em>' attribute.
     * @see #setImportedTypeName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportType_ImportedTypeName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='importedTypeName'"
     * @generated
     */
	String getImportedTypeName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportType#getImportedTypeName <em>Imported Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Type Name</em>' attribute.
     * @see #getImportedTypeName()
     * @generated
     */
	void setImportedTypeName(String value);

} // PImportType
