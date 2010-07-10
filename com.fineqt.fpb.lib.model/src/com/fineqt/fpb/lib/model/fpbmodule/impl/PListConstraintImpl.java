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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PListConstraint;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PList Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PListConstraintImpl#getMatcher <em>Matcher</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PListConstraintImpl extends PTypeConstraintImpl implements PListConstraint {
	/**
     * The cached value of the '{@link #getMatcher() <em>Matcher</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMatcher()
     * @generated
     * @ordered
     */
	protected PValueListMatcher matcher;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PListConstraintImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PLIST_CONSTRAINT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PValueListMatcher getMatcher() {
        return matcher;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetMatcher(PValueListMatcher newMatcher, NotificationChain msgs) {
        PValueListMatcher oldMatcher = matcher;
        matcher = newMatcher;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PLIST_CONSTRAINT__MATCHER, oldMatcher, newMatcher);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMatcher(PValueListMatcher newMatcher) {
        if (newMatcher != matcher) {
            NotificationChain msgs = null;
            if (matcher != null)
                msgs = ((InternalEObject)matcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PLIST_CONSTRAINT__MATCHER, null, msgs);
            if (newMatcher != null)
                msgs = ((InternalEObject)newMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PLIST_CONSTRAINT__MATCHER, null, msgs);
            msgs = basicSetMatcher(newMatcher, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PLIST_CONSTRAINT__MATCHER, newMatcher, newMatcher));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PLIST_CONSTRAINT__MATCHER:
                return basicSetMatcher(null, msgs);
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
            case FpbmodulePackage.PLIST_CONSTRAINT__MATCHER:
                return getMatcher();
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
            case FpbmodulePackage.PLIST_CONSTRAINT__MATCHER:
                setMatcher((PValueListMatcher)newValue);
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
            case FpbmodulePackage.PLIST_CONSTRAINT__MATCHER:
                setMatcher((PValueListMatcher)null);
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
            case FpbmodulePackage.PLIST_CONSTRAINT__MATCHER:
                return matcher != null;
        }
        return super.eIsSet(featureID);
    }

	@Override
	public PListConstraint rsetMatcher(PValueListMatcher value) {
		setMatcher(value);
		return this;
	}

} //PListConstraintImpl
