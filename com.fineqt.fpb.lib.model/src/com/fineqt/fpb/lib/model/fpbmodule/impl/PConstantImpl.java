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

import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PConstant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PConstantImpl#getConstantID <em>Constant ID</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PConstantImpl#getPmodule <em>Pmodule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PConstantImpl extends PNamedElementImpl implements PConstant {
	/**
     * The default value of the '{@link #getConstantID() <em>Constant ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConstantID()
     * @generated
     * @ordered
     */
	protected static final int CONSTANT_ID_EDEFAULT = 0;
	/**
     * The cached value of the '{@link #getConstantID() <em>Constant ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConstantID()
     * @generated
     * @ordered
     */
	protected int constantID = CONSTANT_ID_EDEFAULT;
	/**
     * This is true if the Constant ID attribute has been set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	protected boolean constantIDESet;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PConstantImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PCONSTANT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getConstantID() {
        return constantID;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setConstantID(int newConstantID) {
        int oldConstantID = constantID;
        constantID = newConstantID;
        boolean oldConstantIDESet = constantIDESet;
        constantIDESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PCONSTANT__CONSTANT_ID, oldConstantID, constantID, !oldConstantIDESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void unsetConstantID() {
        int oldConstantID = constantID;
        boolean oldConstantIDESet = constantIDESet;
        constantID = CONSTANT_ID_EDEFAULT;
        constantIDESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, FpbmodulePackage.PCONSTANT__CONSTANT_ID, oldConstantID, CONSTANT_ID_EDEFAULT, oldConstantIDESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetConstantID() {
        return constantIDESet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PModule getPmodule() {
        if (eContainerFeatureID != FpbmodulePackage.PCONSTANT__PMODULE) return null;
        return (PModule)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetPmodule(PModule newPmodule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newPmodule, FpbmodulePackage.PCONSTANT__PMODULE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPmodule(PModule newPmodule) {
        if (newPmodule != eInternalContainer() || (eContainerFeatureID != FpbmodulePackage.PCONSTANT__PMODULE && newPmodule != null)) {
            if (EcoreUtil.isAncestor(this, newPmodule))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPmodule != null)
                msgs = ((InternalEObject)newPmodule).eInverseAdd(this, FpbmodulePackage.PMODULE__CONSTANTS, PModule.class, msgs);
            msgs = basicSetPmodule(newPmodule, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PCONSTANT__PMODULE, newPmodule, newPmodule));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PCONSTANT__PMODULE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetPmodule((PModule)otherEnd, msgs);
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
            case FpbmodulePackage.PCONSTANT__PMODULE:
                return basicSetPmodule(null, msgs);
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
            case FpbmodulePackage.PCONSTANT__PMODULE:
                return eInternalContainer().eInverseRemove(this, FpbmodulePackage.PMODULE__CONSTANTS, PModule.class, msgs);
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
            case FpbmodulePackage.PCONSTANT__CONSTANT_ID:
                return new Integer(getConstantID());
            case FpbmodulePackage.PCONSTANT__PMODULE:
                return getPmodule();
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
            case FpbmodulePackage.PCONSTANT__CONSTANT_ID:
                setConstantID(((Integer)newValue).intValue());
                return;
            case FpbmodulePackage.PCONSTANT__PMODULE:
                setPmodule((PModule)newValue);
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
            case FpbmodulePackage.PCONSTANT__CONSTANT_ID:
                unsetConstantID();
                return;
            case FpbmodulePackage.PCONSTANT__PMODULE:
                setPmodule((PModule)null);
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
            case FpbmodulePackage.PCONSTANT__CONSTANT_ID:
                return isSetConstantID();
            case FpbmodulePackage.PCONSTANT__PMODULE:
                return getPmodule() != null;
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
        result.append(" (constantID: ");
        if (constantIDESet) result.append(constantID); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //PConstantImpl
