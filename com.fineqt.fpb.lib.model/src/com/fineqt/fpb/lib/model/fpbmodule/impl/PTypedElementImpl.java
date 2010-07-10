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

import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.PTypedElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PTyped Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypedElementImpl#getPtype <em>Ptype</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypedElementImpl#getPtypeName <em>Ptype Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PTypedElementImpl extends PEncodedElementImpl implements PTypedElement {
	/**
     * The cached value of the '{@link #getPtype() <em>Ptype</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPtype()
     * @generated
     * @ordered
     */
	protected PType ptype;

	/**
     * The default value of the '{@link #getPtypeName() <em>Ptype Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPtypeName()
     * @generated
     * @ordered
     */
	protected static final String PTYPE_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getPtypeName() <em>Ptype Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPtypeName()
     * @generated
     * @ordered
     */
	protected String ptypeName = PTYPE_NAME_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PTypedElementImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PTYPED_ELEMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PType getPtype() {
        if (ptype != null && ptype.eIsProxy()) {
            InternalEObject oldPtype = (InternalEObject)ptype;
            ptype = (PType)eResolveProxy(oldPtype);
            if (ptype != oldPtype) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FpbmodulePackage.PTYPED_ELEMENT__PTYPE, oldPtype, ptype));
            }
        }
        return ptype;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PType basicGetPtype() {
        return ptype;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPtype(PType newPtype) {
        PType oldPtype = ptype;
        ptype = newPtype;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PTYPED_ELEMENT__PTYPE, oldPtype, ptype));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getPtypeName() {
        return ptypeName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPtypeName(String newPtypeName) {
        String oldPtypeName = ptypeName;
        ptypeName = newPtypeName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PTYPED_ELEMENT__PTYPE_NAME, oldPtypeName, ptypeName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FpbmodulePackage.PTYPED_ELEMENT__PTYPE:
                if (resolve) return getPtype();
                return basicGetPtype();
            case FpbmodulePackage.PTYPED_ELEMENT__PTYPE_NAME:
                return getPtypeName();
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
            case FpbmodulePackage.PTYPED_ELEMENT__PTYPE:
                setPtype((PType)newValue);
                return;
            case FpbmodulePackage.PTYPED_ELEMENT__PTYPE_NAME:
                setPtypeName((String)newValue);
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
            case FpbmodulePackage.PTYPED_ELEMENT__PTYPE:
                setPtype((PType)null);
                return;
            case FpbmodulePackage.PTYPED_ELEMENT__PTYPE_NAME:
                setPtypeName(PTYPE_NAME_EDEFAULT);
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
            case FpbmodulePackage.PTYPED_ELEMENT__PTYPE:
                return ptype != null;
            case FpbmodulePackage.PTYPED_ELEMENT__PTYPE_NAME:
                return PTYPE_NAME_EDEFAULT == null ? ptypeName != null : !PTYPE_NAME_EDEFAULT.equals(ptypeName);
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
        result.append(" (ptypeName: ");
        result.append(ptypeName);
        result.append(')');
        return result.toString();
    }

} //PTypedElementImpl
