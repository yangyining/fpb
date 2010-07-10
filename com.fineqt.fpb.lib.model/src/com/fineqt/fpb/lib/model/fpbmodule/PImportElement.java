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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PImport Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getRefNameList <em>Ref Name List</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#isAllExcept <em>All Except</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getElementType <em>Element Type</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getFromModuleName <em>From Module Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getPmodule <em>Pmodule</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportElement()
 * @model extendedMetaData="name='PImportElement' kind='elementOnly'"
 * @generated
 */
public interface PImportElement extends PModelElement {
	/**
     * Returns the value of the '<em><b>Ref Name List</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Name List</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Ref Name List</em>' attribute list.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportElement_RefNameList()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='element' name='refNameList'"
     * @generated
     */
	EList<String> getRefNameList();

	/**
     * Returns the value of the '<em><b>All Except</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Except</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>All Except</em>' attribute.
     * @see #isSetAllExcept()
     * @see #unsetAllExcept()
     * @see #setAllExcept(boolean)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportElement_AllExcept()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='allExcept'"
     * @generated
     */
	boolean isAllExcept();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#isAllExcept <em>All Except</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>All Except</em>' attribute.
     * @see #isSetAllExcept()
     * @see #unsetAllExcept()
     * @see #isAllExcept()
     * @generated
     */
	void setAllExcept(boolean value);

	/**
     * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#isAllExcept <em>All Except</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSetAllExcept()
     * @see #isAllExcept()
     * @see #setAllExcept(boolean)
     * @generated
     */
	void unsetAllExcept();

	/**
     * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#isAllExcept <em>All Except</em>}' attribute is set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return whether the value of the '<em>All Except</em>' attribute is set.
     * @see #unsetAllExcept()
     * @see #isAllExcept()
     * @see #setAllExcept(boolean)
     * @generated
     */
	boolean isSetAllExcept();

	/**
     * Returns the value of the '<em><b>Element Type</b></em>' attribute.
     * The default value is <code>"TYPE"</code>.
     * The literals are from the enumeration {@link com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Element Type</em>' attribute.
     * @see com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType
     * @see #isSetElementType()
     * @see #unsetElementType()
     * @see #setElementType(ModuleElementType)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportElement_ElementType()
     * @model default="TYPE" unsettable="true" required="true"
     *        extendedMetaData="kind='attribute' name='elementType'"
     * @generated
     */
	ModuleElementType getElementType();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getElementType <em>Element Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Element Type</em>' attribute.
     * @see com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType
     * @see #isSetElementType()
     * @see #unsetElementType()
     * @see #getElementType()
     * @generated
     */
	void setElementType(ModuleElementType value);

	/**
     * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getElementType <em>Element Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSetElementType()
     * @see #getElementType()
     * @see #setElementType(ModuleElementType)
     * @generated
     */
	void unsetElementType();

	/**
     * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getElementType <em>Element Type</em>}' attribute is set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return whether the value of the '<em>Element Type</em>' attribute is set.
     * @see #unsetElementType()
     * @see #getElementType()
     * @see #setElementType(ModuleElementType)
     * @generated
     */
	boolean isSetElementType();

	/**
     * Returns the value of the '<em><b>From Module Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Module Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>From Module Name</em>' attribute.
     * @see #setFromModuleName(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportElement_FromModuleName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='fromModuleName'"
     * @generated
     */
	String getFromModuleName();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getFromModuleName <em>From Module Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>From Module Name</em>' attribute.
     * @see #getFromModuleName()
     * @generated
     */
	void setFromModuleName(String value);

	/**
     * Returns the value of the '<em><b>Pmodule</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getImportElements <em>Import Elements</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pmodule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Pmodule</em>' container reference.
     * @see #setPmodule(PModule)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPImportElement_Pmodule()
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getImportElements
     * @model opposite="importElements"
     * @generated
     */
	PModule getPmodule();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getPmodule <em>Pmodule</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pmodule</em>' container reference.
     * @see #getPmodule()
     * @generated
     */
	void setPmodule(PModule value);

} // PImportElement
