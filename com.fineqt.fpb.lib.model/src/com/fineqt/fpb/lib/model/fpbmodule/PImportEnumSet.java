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
 * A representation of the model object '<em><b>PImport Enum Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet#getImportedEnumSet <em>Imported Enum Set</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet#getImportedEnumSetName <em>Imported Enum Set Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet#getImportedModuleName <em>Imported Module Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportEnumSet()
 * @model extendedMetaData="name='PImportEnumSet' kind='elementOnly'"
 * @generated
 */
public interface PImportEnumSet extends PEnumSet {
	/**
     * Returns the value of the '<em><b>Imported Enum Set</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Enum Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Imported Enum Set</em>' reference.
     * @see #setImportedEnumSet(PEnumSet)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportEnumSet_ImportedEnumSet()
     * @model extendedMetaData="kind='attribute' name='importedEnumSet'"
     * @generated
     */
	PEnumSet getImportedEnumSet();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet#getImportedEnumSet <em>Imported Enum Set</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Enum Set</em>' reference.
     * @see #getImportedEnumSet()
     * @generated
     */
	void setImportedEnumSet(PEnumSet value);

	/**
     * Returns the value of the '<em><b>Imported Enum Set Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Enum Set Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Imported Enum Set Name</em>' attribute.
     * @see #setImportedEnumSetName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportEnumSet_ImportedEnumSetName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='importedEnumSetName'"
     * @generated
     */
	String getImportedEnumSetName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet#getImportedEnumSetName <em>Imported Enum Set Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Enum Set Name</em>' attribute.
     * @see #getImportedEnumSetName()
     * @generated
     */
	void setImportedEnumSetName(String value);

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
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportEnumSet_ImportedModuleName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='importedModuleName'"
     * @generated
     */
	String getImportedModuleName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet#getImportedModuleName <em>Imported Module Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Module Name</em>' attribute.
     * @see #getImportedModuleName()
     * @generated
     */
	void setImportedModuleName(String value);

} // PImportEnumSet
