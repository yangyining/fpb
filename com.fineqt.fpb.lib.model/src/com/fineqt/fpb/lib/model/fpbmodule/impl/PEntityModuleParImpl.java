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
import com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar;

import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PEntity Module Par</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityModuleParImpl#getMatcher <em>Matcher</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityModuleParImpl#getBaseTypeName <em>Base Type Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityModuleParImpl#isThread <em>Thread</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PEntityModuleParImpl extends PModuleParImpl implements PEntityModulePar {
	/**
     * The cached value of the '{@link #getMatcher() <em>Matcher</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMatcher()
     * @generated
     * @ordered
     */
	protected PMatcher matcher;

	/**
     * The default value of the '{@link #getBaseTypeName() <em>Base Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBaseTypeName()
     * @generated
     * @ordered
     */
	protected static final String BASE_TYPE_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getBaseTypeName() <em>Base Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBaseTypeName()
     * @generated
     * @ordered
     */
	protected String baseTypeName = BASE_TYPE_NAME_EDEFAULT;

	/**
     * The default value of the '{@link #isThread() <em>Thread</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isThread()
     * @generated
     * @ordered
     */
	protected static final boolean THREAD_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isThread() <em>Thread</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isThread()
     * @generated
     * @ordered
     */
	protected boolean thread = THREAD_EDEFAULT;

	/**
     * This is true if the Thread attribute has been set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	protected boolean threadESet;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PEntityModuleParImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PENTITY_MODULE_PAR;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PMatcher getMatcher() {
        return matcher;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetMatcher(PMatcher newMatcher, NotificationChain msgs) {
        PMatcher oldMatcher = matcher;
        matcher = newMatcher;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENTITY_MODULE_PAR__MATCHER, oldMatcher, newMatcher);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMatcher(PMatcher newMatcher) {
        if (newMatcher != matcher) {
            NotificationChain msgs = null;
            if (matcher != null)
                msgs = ((InternalEObject)matcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PENTITY_MODULE_PAR__MATCHER, null, msgs);
            if (newMatcher != null)
                msgs = ((InternalEObject)newMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PENTITY_MODULE_PAR__MATCHER, null, msgs);
            msgs = basicSetMatcher(newMatcher, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENTITY_MODULE_PAR__MATCHER, newMatcher, newMatcher));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getBaseTypeName() {
        return baseTypeName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBaseTypeName(String newBaseTypeName) {
        String oldBaseTypeName = baseTypeName;
        baseTypeName = newBaseTypeName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENTITY_MODULE_PAR__BASE_TYPE_NAME, oldBaseTypeName, baseTypeName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isThread() {
        return thread;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setThread(boolean newThread) {
        boolean oldThread = thread;
        thread = newThread;
        boolean oldThreadESet = threadESet;
        threadESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENTITY_MODULE_PAR__THREAD, oldThread, thread, !oldThreadESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void unsetThread() {
        boolean oldThread = thread;
        boolean oldThreadESet = threadESet;
        thread = THREAD_EDEFAULT;
        threadESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, FpbmodulePackage.PENTITY_MODULE_PAR__THREAD, oldThread, THREAD_EDEFAULT, oldThreadESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetThread() {
        return threadESet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PENTITY_MODULE_PAR__MATCHER:
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
            case FpbmodulePackage.PENTITY_MODULE_PAR__MATCHER:
                return getMatcher();
            case FpbmodulePackage.PENTITY_MODULE_PAR__BASE_TYPE_NAME:
                return getBaseTypeName();
            case FpbmodulePackage.PENTITY_MODULE_PAR__THREAD:
                return isThread() ? Boolean.TRUE : Boolean.FALSE;
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
            case FpbmodulePackage.PENTITY_MODULE_PAR__MATCHER:
                setMatcher((PMatcher)newValue);
                return;
            case FpbmodulePackage.PENTITY_MODULE_PAR__BASE_TYPE_NAME:
                setBaseTypeName((String)newValue);
                return;
            case FpbmodulePackage.PENTITY_MODULE_PAR__THREAD:
                setThread(((Boolean)newValue).booleanValue());
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
            case FpbmodulePackage.PENTITY_MODULE_PAR__MATCHER:
                setMatcher((PMatcher)null);
                return;
            case FpbmodulePackage.PENTITY_MODULE_PAR__BASE_TYPE_NAME:
                setBaseTypeName(BASE_TYPE_NAME_EDEFAULT);
                return;
            case FpbmodulePackage.PENTITY_MODULE_PAR__THREAD:
                unsetThread();
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
            case FpbmodulePackage.PENTITY_MODULE_PAR__MATCHER:
                return matcher != null;
            case FpbmodulePackage.PENTITY_MODULE_PAR__BASE_TYPE_NAME:
                return BASE_TYPE_NAME_EDEFAULT == null ? baseTypeName != null : !BASE_TYPE_NAME_EDEFAULT.equals(baseTypeName);
            case FpbmodulePackage.PENTITY_MODULE_PAR__THREAD:
                return isSetThread();
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
        result.append(" (baseTypeName: ");
        result.append(baseTypeName);
        result.append(", thread: ");
        if (threadESet) result.append(thread); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //PEntityModuleParImpl
