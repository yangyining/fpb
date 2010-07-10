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
 * A representation of the model object '<em><b>PType</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PType#isContainerType <em>Container Type</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getDerivativeMode <em>Derivative Mode</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getJavaClass <em>Java Class</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PType#isListType <em>List Type</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PType#isPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getTypeClass <em>Type Class</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getTypeID <em>Type ID</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getPmodule <em>Pmodule</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPType()
 * @model abstract="true"
 *        extendedMetaData="name='PType' kind='elementOnly'"
 * @generated
 */
public interface PType extends PEncodedElement {
	/**
     * Returns the value of the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Container Type</em>' attribute.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPType_ContainerType()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" transient="true" changeable="false" volatile="true" derived="true"
     *        extendedMetaData="kind='attribute' name='containerType'"
     * @generated
     */
	boolean isContainerType();

	/**
     * Returns the value of the '<em><b>Derivative Mode</b></em>' attribute.
     * The default value is <code>"ENTITY"</code>.
     * The literals are from the enumeration {@link com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derivative Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Derivative Mode</em>' attribute.
     * @see com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPType_DerivativeMode()
     * @model default="ENTITY" transient="true" changeable="false" volatile="true" derived="true"
     *        extendedMetaData="kind='attribute' name='derivativeMode'"
     * @generated
     */
	TypeDerivativeMode getDerivativeMode();

	/**
     * Returns the value of the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Java Class</em>' attribute.
     * @see #setJavaClass(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPType_JavaClass()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='javaClass'"
     * @generated
     */
	String getJavaClass();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getJavaClass <em>Java Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Java Class</em>' attribute.
     * @see #getJavaClass()
     * @generated
     */
	void setJavaClass(String value);

	/**
     * Returns the value of the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>List Type</em>' attribute.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPType_ListType()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" transient="true" changeable="false" volatile="true" derived="true"
     *        extendedMetaData="kind='attribute' name='listType'"
     * @generated
     */
	boolean isListType();

	/**
     * Returns the value of the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Primitive Type</em>' attribute.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPType_PrimitiveType()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" transient="true" changeable="false" volatile="true" derived="true"
     *        extendedMetaData="kind='attribute' name='primitiveType'"
     * @generated
     */
	boolean isPrimitiveType();

	/**
     * Returns the value of the '<em><b>Type Class</b></em>' attribute.
     * The default value is <code>"boolean"</code>.
     * The literals are from the enumeration {@link com.fineqt.fpb.lib.model.fpbmodule.TypeClass}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type Class</em>' attribute.
     * @see com.fineqt.fpb.lib.model.fpbmodule.TypeClass
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPType_TypeClass()
     * @model default="boolean" transient="true" changeable="false" volatile="true" derived="true"
     *        extendedMetaData="kind='attribute' name='typeClass'"
     * @generated
     */
	TypeClass getTypeClass();

	/**
     * Returns the value of the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type ID</em>' attribute.
     * @see #isSetTypeID()
     * @see #unsetTypeID()
     * @see #setTypeID(int)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPType_TypeID()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='typeID'"
     * @generated
     */
	int getTypeID();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getTypeID <em>Type ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type ID</em>' attribute.
     * @see #isSetTypeID()
     * @see #unsetTypeID()
     * @see #getTypeID()
     * @generated
     */
	void setTypeID(int value);

	/**
     * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getTypeID <em>Type ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSetTypeID()
     * @see #getTypeID()
     * @see #setTypeID(int)
     * @generated
     */
	void unsetTypeID();

	/**
     * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getTypeID <em>Type ID</em>}' attribute is set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return whether the value of the '<em>Type ID</em>' attribute is set.
     * @see #unsetTypeID()
     * @see #getTypeID()
     * @see #setTypeID(int)
     * @generated
     */
	boolean isSetTypeID();

	/**
     * Returns the value of the '<em><b>Pmodule</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getTypes <em>Types</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pmodule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Pmodule</em>' container reference.
     * @see #setPmodule(PModule)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPType_Pmodule()
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getTypes
     * @model opposite="types"
     * @generated
     */
	PModule getPmodule();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getPmodule <em>Pmodule</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pmodule</em>' container reference.
     * @see #getPmodule()
     * @generated
     */
	void setPmodule(PModule value);

} // PType
