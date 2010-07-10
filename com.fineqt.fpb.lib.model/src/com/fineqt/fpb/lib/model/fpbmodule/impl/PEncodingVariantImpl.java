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

import com.fineqt.fpb.lib.model.fpbcommon.impl.PModelElementImpl;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement;
import com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PEncoding Variant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodingVariantImpl#getEncodedElement <em>Encoded Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PEncodingVariantImpl extends PModelElementImpl implements PEncodingVariant {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PEncodingVariantImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PENCODING_VARIANT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PEncodedElement getEncodedElement() {
        if (eContainerFeatureID != FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT) return null;
        return (PEncodedElement)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetEncodedElement(PEncodedElement newEncodedElement, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newEncodedElement, FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEncodedElement(PEncodedElement newEncodedElement) {
        if (newEncodedElement != eInternalContainer() || (eContainerFeatureID != FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT && newEncodedElement != null)) {
            if (EcoreUtil.isAncestor(this, newEncodedElement))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newEncodedElement != null)
                msgs = ((InternalEObject)newEncodedElement).eInverseAdd(this, FpbmodulePackage.PENCODED_ELEMENT__VARIANT, PEncodedElement.class, msgs);
            msgs = basicSetEncodedElement(newEncodedElement, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT, newEncodedElement, newEncodedElement));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetEncodedElement((PEncodedElement)otherEnd, msgs);
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
            case FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT:
                return basicSetEncodedElement(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID) {
            case FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT:
                return eInternalContainer().eInverseRemove(this, FpbmodulePackage.PENCODED_ELEMENT__VARIANT, PEncodedElement.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT:
                return getEncodedElement();
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
            case FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT:
                setEncodedElement((PEncodedElement)newValue);
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
            case FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT:
                setEncodedElement((PEncodedElement)null);
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
            case FpbmodulePackage.PENCODING_VARIANT__ENCODED_ELEMENT:
                return getEncodedElement() != null;
        }
        return super.eIsSet(featureID);
    }
/*
	@Override
	public boolean isSetAny() {
		return false;
	}
*/
} //PEncodingVariantImpl
