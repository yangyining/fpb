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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PModuleEV;
import com.fineqt.fpb.lib.model.fpbmodule.PPropertyList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PModule EV</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleEVImpl#getPrpList <em>Prp List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PModuleEVImpl extends PEncodingVariantImpl implements PModuleEV {
	/**
     * The cached value of the '{@link #getPrpList() <em>Prp List</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPrpList()
     * @generated
     * @ordered
     */
	protected PPropertyList prpList;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PModuleEVImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PMODULE_EV;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PPropertyList getPrpList() {
        return prpList;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetPrpList(PPropertyList newPrpList, NotificationChain msgs) {
        PPropertyList oldPrpList = prpList;
        prpList = newPrpList;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PMODULE_EV__PRP_LIST, oldPrpList, newPrpList);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPrpList(PPropertyList newPrpList) {
        if (newPrpList != prpList) {
            NotificationChain msgs = null;
            if (prpList != null)
                msgs = ((InternalEObject)prpList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PMODULE_EV__PRP_LIST, null, msgs);
            if (newPrpList != null)
                msgs = ((InternalEObject)newPrpList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PMODULE_EV__PRP_LIST, null, msgs);
            msgs = basicSetPrpList(newPrpList, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PMODULE_EV__PRP_LIST, newPrpList, newPrpList));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PMODULE_EV__PRP_LIST:
                return basicSetPrpList(null, msgs);
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
            case FpbmodulePackage.PMODULE_EV__PRP_LIST:
                return getPrpList();
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
            case FpbmodulePackage.PMODULE_EV__PRP_LIST:
                setPrpList((PPropertyList)newValue);
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
            case FpbmodulePackage.PMODULE_EV__PRP_LIST:
                setPrpList((PPropertyList)null);
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
            case FpbmodulePackage.PMODULE_EV__PRP_LIST:
                return prpList != null;
        }
        return super.eIsSet(featureID);
    }
//
//	@Override
//	public boolean isSetAny() {
//		return super.isSetAny();
//	}
	
} //PModuleEVImpl
