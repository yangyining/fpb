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
import com.fineqt.fpb.lib.model.fpbcommon.impl.PModelElementImpl;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumItem;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumSet;

import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PEnum Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumSetImpl#getEnumSetID <em>Enum Set ID</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumSetImpl#getPmodule <em>Pmodule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PEnumSetImpl extends PNamedElementImpl implements PEnumSet {
	/**
     * The default value of the '{@link #getEnumSetID() <em>Enum Set ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEnumSetID()
     * @generated
     * @ordered
     */
	protected static final int ENUM_SET_ID_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getEnumSetID() <em>Enum Set ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEnumSetID()
     * @generated
     * @ordered
     */
	protected int enumSetID = ENUM_SET_ID_EDEFAULT;

	/**
     * This is true if the Enum Set ID attribute has been set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	protected boolean enumSetIDESet;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PEnumSetImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PENUM_SET;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getEnumSetID() {
        return enumSetID;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEnumSetID(int newEnumSetID) {
        int oldEnumSetID = enumSetID;
        enumSetID = newEnumSetID;
        boolean oldEnumSetIDESet = enumSetIDESet;
        enumSetIDESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENUM_SET__ENUM_SET_ID, oldEnumSetID, enumSetID, !oldEnumSetIDESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void unsetEnumSetID() {
        int oldEnumSetID = enumSetID;
        boolean oldEnumSetIDESet = enumSetIDESet;
        enumSetID = ENUM_SET_ID_EDEFAULT;
        enumSetIDESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, FpbmodulePackage.PENUM_SET__ENUM_SET_ID, oldEnumSetID, ENUM_SET_ID_EDEFAULT, oldEnumSetIDESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetEnumSetID() {
        return enumSetIDESet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PModule getPmodule() {
        if (eContainerFeatureID != FpbmodulePackage.PENUM_SET__PMODULE) return null;
        return (PModule)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetPmodule(PModule newPmodule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newPmodule, FpbmodulePackage.PENUM_SET__PMODULE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPmodule(PModule newPmodule) {
        if (newPmodule != eInternalContainer() || (eContainerFeatureID != FpbmodulePackage.PENUM_SET__PMODULE && newPmodule != null)) {
            if (EcoreUtil.isAncestor(this, newPmodule))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPmodule != null)
                msgs = ((InternalEObject)newPmodule).eInverseAdd(this, FpbmodulePackage.PMODULE__ENUM_SETS, PModule.class, msgs);
            msgs = basicSetPmodule(newPmodule, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENUM_SET__PMODULE, newPmodule, newPmodule));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PENUM_SET__PMODULE:
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
            case FpbmodulePackage.PENUM_SET__PMODULE:
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
            case FpbmodulePackage.PENUM_SET__PMODULE:
                return eInternalContainer().eInverseRemove(this, FpbmodulePackage.PMODULE__ENUM_SETS, PModule.class, msgs);
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
            case FpbmodulePackage.PENUM_SET__ENUM_SET_ID:
                return new Integer(getEnumSetID());
            case FpbmodulePackage.PENUM_SET__PMODULE:
                return getPmodule();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FpbmodulePackage.PENUM_SET__ENUM_SET_ID:
                setEnumSetID(((Integer)newValue).intValue());
                return;
            case FpbmodulePackage.PENUM_SET__PMODULE:
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
            case FpbmodulePackage.PENUM_SET__ENUM_SET_ID:
                unsetEnumSetID();
                return;
            case FpbmodulePackage.PENUM_SET__PMODULE:
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
            case FpbmodulePackage.PENUM_SET__ENUM_SET_ID:
                return isSetEnumSetID();
            case FpbmodulePackage.PENUM_SET__PMODULE:
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
        result.append(" (enumSetID: ");
        if (enumSetIDESet) result.append(enumSetID); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //PEnumSetImpl
