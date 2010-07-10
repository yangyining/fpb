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

import com.fineqt.fpb.lib.model.fpbtemplate.PTemplate;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PModule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getImportElements <em>Import Elements</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getTypes <em>Types</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getConstants <em>Constants</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getTemplates <em>Templates</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getModulePars <em>Module Pars</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getEnumSets <em>Enum Sets</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getFactoryJavaClass <em>Factory Java Class</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getModuleJavaClass <em>Module Java Class</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getTypeEvFactoryJavaClass <em>Type Ev Factory Java Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModule()
 * @model extendedMetaData="name='PModule' kind='elementOnly'"
 * @generated
 */
public interface PModule extends PEncodedElement {
	/**
     * Returns the value of the '<em><b>Types</b></em>' containment reference list.
     * The list contents are of type {@link com.fineqt.fpb.lib.model.fpbmodule.PType}.
     * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getPmodule <em>Pmodule</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Types</em>' containment reference list.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModule_Types()
     * @see com.fineqt.fpb.lib.model.fpbmodule.PType#getPmodule
     * @model opposite="pmodule" containment="true"
     *        extendedMetaData="kind='element' name='types'"
     * @generated
     */
	EList<PType> getTypes();

	/**
     * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
     * The list contents are of type {@link com.fineqt.fpb.lib.model.fpbmodule.PConstant}.
     * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbmodule.PConstant#getPmodule <em>Pmodule</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Constants</em>' containment reference list.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModule_Constants()
     * @see com.fineqt.fpb.lib.model.fpbmodule.PConstant#getPmodule
     * @model opposite="pmodule" containment="true"
     *        extendedMetaData="kind='element' name='constants'"
     * @generated
     */
	EList<PConstant> getConstants();

	/**
     * Returns the value of the '<em><b>Templates</b></em>' containment reference list.
     * The list contents are of type {@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplate}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Templates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Templates</em>' containment reference list.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModule_Templates()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='templates'"
     * @generated
     */
	EList<PTemplate> getTemplates();

	/**
     * Returns the value of the '<em><b>Module Pars</b></em>' containment reference list.
     * The list contents are of type {@link com.fineqt.fpb.lib.model.fpbmodule.PModulePar}.
     * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbmodule.PModulePar#getPmodule <em>Pmodule</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Pars</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Module Pars</em>' containment reference list.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModule_ModulePars()
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModulePar#getPmodule
     * @model opposite="pmodule" containment="true"
     *        extendedMetaData="kind='element' name='modulePars'"
     * @generated
     */
	EList<PModulePar> getModulePars();

	/**
     * Returns the value of the '<em><b>Import Elements</b></em>' containment reference list.
     * The list contents are of type {@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement}.
     * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getPmodule <em>Pmodule</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Import Elements</em>' containment reference list.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModule_ImportElements()
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getPmodule
     * @model opposite="pmodule" containment="true"
     *        extendedMetaData="kind='element' name='importElements'"
     * @generated
     */
	EList<PImportElement> getImportElements();

	/**
     * Returns the value of the '<em><b>Enum Sets</b></em>' containment reference list.
     * The list contents are of type {@link com.fineqt.fpb.lib.model.fpbmodule.PEnumSet}.
     * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumSet#getPmodule <em>Pmodule</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Enum Sets</em>' containment reference list.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModule_EnumSets()
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumSet#getPmodule
     * @model opposite="pmodule" containment="true"
     *        extendedMetaData="kind='element' name='enumSets'"
     * @generated
     */
	EList<PEnumSet> getEnumSets();

	/**
     * Returns the value of the '<em><b>Factory Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factory Java Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Factory Java Class</em>' attribute.
     * @see #setFactoryJavaClass(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModule_FactoryJavaClass()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='factoryJavaClass'"
     * @generated
     */
	String getFactoryJavaClass();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getFactoryJavaClass <em>Factory Java Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Factory Java Class</em>' attribute.
     * @see #getFactoryJavaClass()
     * @generated
     */
	void setFactoryJavaClass(String value);

	/**
     * Returns the value of the '<em><b>Module Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Java Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Module Java Class</em>' attribute.
     * @see #setModuleJavaClass(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModule_ModuleJavaClass()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='moduleJavaClass'"
     * @generated
     */
	String getModuleJavaClass();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getModuleJavaClass <em>Module Java Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Module Java Class</em>' attribute.
     * @see #getModuleJavaClass()
     * @generated
     */
	void setModuleJavaClass(String value);

	/**
     * Returns the value of the '<em><b>Type Ev Factory Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Ev Factory Java Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type Ev Factory Java Class</em>' attribute.
     * @see #setTypeEvFactoryJavaClass(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPModule_TypeEvFactoryJavaClass()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='typeEvFactoryJavaClass'"
     * @generated
     */
	String getTypeEvFactoryJavaClass();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getTypeEvFactoryJavaClass <em>Type Ev Factory Java Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type Ev Factory Java Class</em>' attribute.
     * @see #getTypeEvFactoryJavaClass()
     * @generated
     */
	void setTypeEvFactoryJavaClass(String value);
	
//	PType getType(int typeID);

} // PModule
