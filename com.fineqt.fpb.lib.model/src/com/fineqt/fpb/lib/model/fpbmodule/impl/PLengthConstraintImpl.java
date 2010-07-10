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
import com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint;

import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PLength Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PLengthConstraintImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PLengthConstraintImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PLengthConstraintImpl extends PTypeConstraintImpl implements PLengthConstraint {
	/**
     * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLowerBound()
     * @generated
     * @ordered
     */
	protected PMatcher lowerBound;

	/**
     * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getUpperBound()
     * @generated
     * @ordered
     */
	protected PMatcher upperBound;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PLengthConstraintImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PLENGTH_CONSTRAINT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PMatcher getLowerBound() {
        return lowerBound;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetLowerBound(PMatcher newLowerBound, NotificationChain msgs) {
        PMatcher oldLowerBound = lowerBound;
        lowerBound = newLowerBound;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PLENGTH_CONSTRAINT__LOWER_BOUND, oldLowerBound, newLowerBound);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLowerBound(PMatcher newLowerBound) {
        if (newLowerBound != lowerBound) {
            NotificationChain msgs = null;
            if (lowerBound != null)
                msgs = ((InternalEObject)lowerBound).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PLENGTH_CONSTRAINT__LOWER_BOUND, null, msgs);
            if (newLowerBound != null)
                msgs = ((InternalEObject)newLowerBound).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PLENGTH_CONSTRAINT__LOWER_BOUND, null, msgs);
            msgs = basicSetLowerBound(newLowerBound, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PLENGTH_CONSTRAINT__LOWER_BOUND, newLowerBound, newLowerBound));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PMatcher getUpperBound() {
        return upperBound;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetUpperBound(PMatcher newUpperBound, NotificationChain msgs) {
        PMatcher oldUpperBound = upperBound;
        upperBound = newUpperBound;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PLENGTH_CONSTRAINT__UPPER_BOUND, oldUpperBound, newUpperBound);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setUpperBound(PMatcher newUpperBound) {
        if (newUpperBound != upperBound) {
            NotificationChain msgs = null;
            if (upperBound != null)
                msgs = ((InternalEObject)upperBound).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PLENGTH_CONSTRAINT__UPPER_BOUND, null, msgs);
            if (newUpperBound != null)
                msgs = ((InternalEObject)newUpperBound).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PLENGTH_CONSTRAINT__UPPER_BOUND, null, msgs);
            msgs = basicSetUpperBound(newUpperBound, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PLENGTH_CONSTRAINT__UPPER_BOUND, newUpperBound, newUpperBound));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PLENGTH_CONSTRAINT__LOWER_BOUND:
                return basicSetLowerBound(null, msgs);
            case FpbmodulePackage.PLENGTH_CONSTRAINT__UPPER_BOUND:
                return basicSetUpperBound(null, msgs);
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
            case FpbmodulePackage.PLENGTH_CONSTRAINT__LOWER_BOUND:
                return getLowerBound();
            case FpbmodulePackage.PLENGTH_CONSTRAINT__UPPER_BOUND:
                return getUpperBound();
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
            case FpbmodulePackage.PLENGTH_CONSTRAINT__LOWER_BOUND:
                setLowerBound((PMatcher)newValue);
                return;
            case FpbmodulePackage.PLENGTH_CONSTRAINT__UPPER_BOUND:
                setUpperBound((PMatcher)newValue);
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
            case FpbmodulePackage.PLENGTH_CONSTRAINT__LOWER_BOUND:
                setLowerBound((PMatcher)null);
                return;
            case FpbmodulePackage.PLENGTH_CONSTRAINT__UPPER_BOUND:
                setUpperBound((PMatcher)null);
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
            case FpbmodulePackage.PLENGTH_CONSTRAINT__LOWER_BOUND:
                return lowerBound != null;
            case FpbmodulePackage.PLENGTH_CONSTRAINT__UPPER_BOUND:
                return upperBound != null;
        }
        return super.eIsSet(featureID);
    }

} //PLengthConstraintImpl
