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
package com.fineqt.fpb.lib.model.fpbmodule.impl;

import com.fineqt.fpb.lib.model.fpbcommon.impl.PNamedElementImpl;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement;
import com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PEncoded Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodedElementImpl#getVariant <em>Variant</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodedElementImpl#getEncode <em>Encode</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodedElementImpl#getTypeEncodingDesc <em>Type Encoding Desc</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodedElementImpl#getTypeEncodingVariantDesc <em>Type Encoding Variant Desc</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodedElementImpl#getTypeExtensionDesc <em>Type Extension Desc</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PEncodedElementImpl extends PNamedElementImpl implements PEncodedElement {
	/**
     * The cached value of the '{@link #getVariant() <em>Variant</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariant()
     * @generated
     * @ordered
     */
	protected PEncodingVariant variant;

	/**
     * The default value of the '{@link #getEncode() <em>Encode</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEncode()
     * @generated
     * @ordered
     */
	protected static final EncodingType ENCODE_EDEFAULT = EncodingType.NONE;

	/**
     * The cached value of the '{@link #getEncode() <em>Encode</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEncode()
     * @generated
     * @ordered
     */
	protected EncodingType encode = ENCODE_EDEFAULT;

	/**
     * This is true if the Encode attribute has been set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	protected boolean encodeESet;

	/**
     * The default value of the '{@link #getTypeEncodingDesc() <em>Type Encoding Desc</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeEncodingDesc()
     * @generated
     * @ordered
     */
	protected static final String TYPE_ENCODING_DESC_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getTypeEncodingDesc() <em>Type Encoding Desc</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeEncodingDesc()
     * @generated
     * @ordered
     */
	protected String typeEncodingDesc = TYPE_ENCODING_DESC_EDEFAULT;

	/**
     * The default value of the '{@link #getTypeEncodingVariantDesc() <em>Type Encoding Variant Desc</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeEncodingVariantDesc()
     * @generated
     * @ordered
     */
	protected static final String TYPE_ENCODING_VARIANT_DESC_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getTypeEncodingVariantDesc() <em>Type Encoding Variant Desc</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeEncodingVariantDesc()
     * @generated
     * @ordered
     */
	protected String typeEncodingVariantDesc = TYPE_ENCODING_VARIANT_DESC_EDEFAULT;

	/**
     * The default value of the '{@link #getTypeExtensionDesc() <em>Type Extension Desc</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeExtensionDesc()
     * @generated
     * @ordered
     */
	protected static final String TYPE_EXTENSION_DESC_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getTypeExtensionDesc() <em>Type Extension Desc</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeExtensionDesc()
     * @generated
     * @ordered
     */
	protected String typeExtensionDesc = TYPE_EXTENSION_DESC_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PEncodedElementImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PENCODED_ELEMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PEncodingVariant getVariant() {
        return variant;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetVariant(PEncodingVariant newVariant, NotificationChain msgs) {
        PEncodingVariant oldVariant = variant;
        variant = newVariant;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENCODED_ELEMENT__VARIANT, oldVariant, newVariant);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVariant(PEncodingVariant newVariant) {
        if (newVariant != variant) {
            NotificationChain msgs = null;
            if (variant != null)
                msgs = ((InternalEObject)variant).eInverseRemove(this, FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT, PEncodingVariant.class, msgs);
            if (newVariant != null)
                msgs = ((InternalEObject)newVariant).eInverseAdd(this, FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT, PEncodingVariant.class, msgs);
            msgs = basicSetVariant(newVariant, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENCODED_ELEMENT__VARIANT, newVariant, newVariant));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EncodingType getEncode() {
        return encode;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEncode(EncodingType newEncode) {
        EncodingType oldEncode = encode;
        encode = newEncode == null ? ENCODE_EDEFAULT : newEncode;
        boolean oldEncodeESet = encodeESet;
        encodeESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENCODED_ELEMENT__ENCODE, oldEncode, encode, !oldEncodeESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void unsetEncode() {
        EncodingType oldEncode = encode;
        boolean oldEncodeESet = encodeESet;
        encode = ENCODE_EDEFAULT;
        encodeESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, FpbmodulePackage.PENCODED_ELEMENT__ENCODE, oldEncode, ENCODE_EDEFAULT, oldEncodeESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetEncode() {
        return encodeESet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getTypeEncodingDesc() {
        return typeEncodingDesc;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeEncodingDesc(String newTypeEncodingDesc) {
        String oldTypeEncodingDesc = typeEncodingDesc;
        typeEncodingDesc = newTypeEncodingDesc;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENCODED_ELEMENT__TYPE_ENCODING_DESC, oldTypeEncodingDesc, typeEncodingDesc));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getTypeEncodingVariantDesc() {
        return typeEncodingVariantDesc;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeEncodingVariantDesc(String newTypeEncodingVariantDesc) {
        String oldTypeEncodingVariantDesc = typeEncodingVariantDesc;
        typeEncodingVariantDesc = newTypeEncodingVariantDesc;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENCODED_ELEMENT__TYPE_ENCODING_VARIANT_DESC, oldTypeEncodingVariantDesc, typeEncodingVariantDesc));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getTypeExtensionDesc() {
        return typeExtensionDesc;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeExtensionDesc(String newTypeExtensionDesc) {
        String oldTypeExtensionDesc = typeExtensionDesc;
        typeExtensionDesc = newTypeExtensionDesc;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENCODED_ELEMENT__TYPE_EXTENSION_DESC, oldTypeExtensionDesc, typeExtensionDesc));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PENCODED_ELEMENT__VARIANT:
                if (variant != null)
                    msgs = ((InternalEObject)variant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PENCODED_ELEMENT__VARIANT, null, msgs);
                return basicSetVariant((PEncodingVariant)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PENCODED_ELEMENT__VARIANT:
                return basicSetVariant(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FpbmodulePackage.PENCODED_ELEMENT__VARIANT:
                return getVariant();
            case FpbmodulePackage.PENCODED_ELEMENT__ENCODE:
                return getEncode();
            case FpbmodulePackage.PENCODED_ELEMENT__TYPE_ENCODING_DESC:
                return getTypeEncodingDesc();
            case FpbmodulePackage.PENCODED_ELEMENT__TYPE_ENCODING_VARIANT_DESC:
                return getTypeEncodingVariantDesc();
            case FpbmodulePackage.PENCODED_ELEMENT__TYPE_EXTENSION_DESC:
                return getTypeExtensionDesc();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FpbmodulePackage.PENCODED_ELEMENT__VARIANT:
                setVariant((PEncodingVariant)newValue);
                return;
            case FpbmodulePackage.PENCODED_ELEMENT__ENCODE:
                setEncode((EncodingType)newValue);
                return;
            case FpbmodulePackage.PENCODED_ELEMENT__TYPE_ENCODING_DESC:
                setTypeEncodingDesc((String)newValue);
                return;
            case FpbmodulePackage.PENCODED_ELEMENT__TYPE_ENCODING_VARIANT_DESC:
                setTypeEncodingVariantDesc((String)newValue);
                return;
            case FpbmodulePackage.PENCODED_ELEMENT__TYPE_EXTENSION_DESC:
                setTypeExtensionDesc((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case FpbmodulePackage.PENCODED_ELEMENT__VARIANT:
                setVariant((PEncodingVariant)null);
                return;
            case FpbmodulePackage.PENCODED_ELEMENT__ENCODE:
                unsetEncode();
                return;
            case FpbmodulePackage.PENCODED_ELEMENT__TYPE_ENCODING_DESC:
                setTypeEncodingDesc(TYPE_ENCODING_DESC_EDEFAULT);
                return;
            case FpbmodulePackage.PENCODED_ELEMENT__TYPE_ENCODING_VARIANT_DESC:
                setTypeEncodingVariantDesc(TYPE_ENCODING_VARIANT_DESC_EDEFAULT);
                return;
            case FpbmodulePackage.PENCODED_ELEMENT__TYPE_EXTENSION_DESC:
                setTypeExtensionDesc(TYPE_EXTENSION_DESC_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case FpbmodulePackage.PENCODED_ELEMENT__VARIANT:
                return variant != null;
            case FpbmodulePackage.PENCODED_ELEMENT__ENCODE:
                return isSetEncode();
            case FpbmodulePackage.PENCODED_ELEMENT__TYPE_ENCODING_DESC:
                return TYPE_ENCODING_DESC_EDEFAULT == null ? typeEncodingDesc != null : !TYPE_ENCODING_DESC_EDEFAULT.equals(typeEncodingDesc);
            case FpbmodulePackage.PENCODED_ELEMENT__TYPE_ENCODING_VARIANT_DESC:
                return TYPE_ENCODING_VARIANT_DESC_EDEFAULT == null ? typeEncodingVariantDesc != null : !TYPE_ENCODING_VARIANT_DESC_EDEFAULT.equals(typeEncodingVariantDesc);
            case FpbmodulePackage.PENCODED_ELEMENT__TYPE_EXTENSION_DESC:
                return TYPE_EXTENSION_DESC_EDEFAULT == null ? typeExtensionDesc != null : !TYPE_EXTENSION_DESC_EDEFAULT.equals(typeExtensionDesc);
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (encode: ");
        if (encodeESet) result.append(encode); else result.append("<unset>");
        result.append(", typeEncodingDesc: ");
        result.append(typeEncodingDesc);
        result.append(", typeEncodingVariantDesc: ");
        result.append(typeEncodingVariantDesc);
        result.append(", typeExtensionDesc: ");
        result.append(typeExtensionDesc);
        result.append(')');
        return result.toString();
    }

} //PEncodedElementImpl
