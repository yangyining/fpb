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
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.PModulePar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PModule Par</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleParImpl#getModuleParID <em>Module Par ID</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleParImpl#getPmodule <em>Pmodule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PModuleParImpl extends PNamedElementImpl implements PModulePar {
	/**
     * The default value of the '{@link #getModuleParID() <em>Module Par ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getModuleParID()
     * @generated
     * @ordered
     */
	protected static final int MODULE_PAR_ID_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getModuleParID() <em>Module Par ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getModuleParID()
     * @generated
     * @ordered
     */
	protected int moduleParID = MODULE_PAR_ID_EDEFAULT;

	/**
     * This is true if the Module Par ID attribute has been set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	protected boolean moduleParIDESet;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PModuleParImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PMODULE_PAR;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getModuleParID() {
        return moduleParID;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setModuleParID(int newModuleParID) {
        int oldModuleParID = moduleParID;
        moduleParID = newModuleParID;
        boolean oldModuleParIDESet = moduleParIDESet;
        moduleParIDESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PMODULE_PAR__MODULE_PAR_ID, oldModuleParID, moduleParID, !oldModuleParIDESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void unsetModuleParID() {
        int oldModuleParID = moduleParID;
        boolean oldModuleParIDESet = moduleParIDESet;
        moduleParID = MODULE_PAR_ID_EDEFAULT;
        moduleParIDESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, FpbmodulePackage.PMODULE_PAR__MODULE_PAR_ID, oldModuleParID, MODULE_PAR_ID_EDEFAULT, oldModuleParIDESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetModuleParID() {
        return moduleParIDESet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PModule getPmodule() {
        if (eContainerFeatureID != FpbmodulePackage.PMODULE_PAR__PMODULE) return null;
        return (PModule)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetPmodule(PModule newPmodule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newPmodule, FpbmodulePackage.PMODULE_PAR__PMODULE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPmodule(PModule newPmodule) {
        if (newPmodule != eInternalContainer() || (eContainerFeatureID != FpbmodulePackage.PMODULE_PAR__PMODULE && newPmodule != null)) {
            if (EcoreUtil.isAncestor(this, newPmodule))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPmodule != null)
                msgs = ((InternalEObject)newPmodule).eInverseAdd(this, FpbmodulePackage.PMODULE__MODULE_PARS, PModule.class, msgs);
            msgs = basicSetPmodule(newPmodule, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PMODULE_PAR__PMODULE, newPmodule, newPmodule));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PMODULE_PAR__PMODULE:
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
            case FpbmodulePackage.PMODULE_PAR__PMODULE:
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
            case FpbmodulePackage.PMODULE_PAR__PMODULE:
                return eInternalContainer().eInverseRemove(this, FpbmodulePackage.PMODULE__MODULE_PARS, PModule.class, msgs);
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
            case FpbmodulePackage.PMODULE_PAR__MODULE_PAR_ID:
                return new Integer(getModuleParID());
            case FpbmodulePackage.PMODULE_PAR__PMODULE:
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
            case FpbmodulePackage.PMODULE_PAR__MODULE_PAR_ID:
                setModuleParID(((Integer)newValue).intValue());
                return;
            case FpbmodulePackage.PMODULE_PAR__PMODULE:
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
            case FpbmodulePackage.PMODULE_PAR__MODULE_PAR_ID:
                unsetModuleParID();
                return;
            case FpbmodulePackage.PMODULE_PAR__PMODULE:
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
            case FpbmodulePackage.PMODULE_PAR__MODULE_PAR_ID:
                return isSetModuleParID();
            case FpbmodulePackage.PMODULE_PAR__PMODULE:
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
        result.append(" (moduleParID: ");
        if (moduleParIDESet) result.append(moduleParID); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //PModuleParImpl
