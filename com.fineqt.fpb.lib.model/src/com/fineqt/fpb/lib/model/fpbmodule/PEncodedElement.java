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
 * A representation of the model object '<em><b>PEncoded Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getVariant <em>Variant</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getEncode <em>Encode</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getTypeEncodingDesc <em>Type Encoding Desc</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getTypeEncodingVariantDesc <em>Type Encoding Variant Desc</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getTypeExtensionDesc <em>Type Extension Desc</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEncodedElement()
 * @model abstract="true"
 *        extendedMetaData="name='PEncodedElement' kind='elementOnly'"
 * @generated
 */
public interface PEncodedElement extends PNamedElement {
	/**
     * Returns the value of the '<em><b>Variant</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant#getEncodedElement <em>Encoded Element</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variant</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Variant</em>' containment reference.
     * @see #setVariant(PEncodingVariant)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEncodedElement_Variant()
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant#getEncodedElement
     * @model opposite="encodedElement" containment="true" required="true"
     *        extendedMetaData="kind='element' name='variant'"
     * @generated
     */
	PEncodingVariant getVariant();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getVariant <em>Variant</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Variant</em>' containment reference.
     * @see #getVariant()
     * @generated
     */
	void setVariant(PEncodingVariant value);

	/**
     * Returns the value of the '<em><b>Encode</b></em>' attribute.
     * The default value is <code>"NONE"</code>.
     * The literals are from the enumeration {@link com.fineqt.fpb.lib.model.fpbmodule.EncodingType}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Encode</em>' attribute.
     * @see com.fineqt.fpb.lib.model.fpbmodule.EncodingType
     * @see #isSetEncode()
     * @see #unsetEncode()
     * @see #setEncode(EncodingType)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEncodedElement_Encode()
     * @model default="NONE" unsettable="true"
     *        extendedMetaData="kind='attribute' name='encode'"
     * @generated
     */
	EncodingType getEncode();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getEncode <em>Encode</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Encode</em>' attribute.
     * @see com.fineqt.fpb.lib.model.fpbmodule.EncodingType
     * @see #isSetEncode()
     * @see #unsetEncode()
     * @see #getEncode()
     * @generated
     */
	void setEncode(EncodingType value);

	/**
     * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getEncode <em>Encode</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSetEncode()
     * @see #getEncode()
     * @see #setEncode(EncodingType)
     * @generated
     */
	void unsetEncode();

	/**
     * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getEncode <em>Encode</em>}' attribute is set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return whether the value of the '<em>Encode</em>' attribute is set.
     * @see #unsetEncode()
     * @see #getEncode()
     * @see #setEncode(EncodingType)
     * @generated
     */
	boolean isSetEncode();

	/**
     * Returns the value of the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Encoding Desc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type Encoding Desc</em>' attribute.
     * @see #setTypeEncodingDesc(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEncodedElement_TypeEncodingDesc()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='typeEncodingDesc'"
     * @generated
     */
	String getTypeEncodingDesc();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getTypeEncodingDesc <em>Type Encoding Desc</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type Encoding Desc</em>' attribute.
     * @see #getTypeEncodingDesc()
     * @generated
     */
	void setTypeEncodingDesc(String value);

	/**
     * Returns the value of the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Encoding Variant Desc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type Encoding Variant Desc</em>' attribute.
     * @see #setTypeEncodingVariantDesc(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEncodedElement_TypeEncodingVariantDesc()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='typeEncodingVariantDesc'"
     * @generated
     */
	String getTypeEncodingVariantDesc();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getTypeEncodingVariantDesc <em>Type Encoding Variant Desc</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type Encoding Variant Desc</em>' attribute.
     * @see #getTypeEncodingVariantDesc()
     * @generated
     */
	void setTypeEncodingVariantDesc(String value);

	/**
     * Returns the value of the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Extension Desc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type Extension Desc</em>' attribute.
     * @see #setTypeExtensionDesc(String)
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPEncodedElement_TypeExtensionDesc()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='typeExtensionDesc'"
     * @generated
     */
	String getTypeExtensionDesc();

	/**
     * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getTypeExtensionDesc <em>Type Extension Desc</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type Extension Desc</em>' attribute.
     * @see #getTypeExtensionDesc()
     * @generated
     */
	void setTypeExtensionDesc(String value);

} // PEncodedElement
