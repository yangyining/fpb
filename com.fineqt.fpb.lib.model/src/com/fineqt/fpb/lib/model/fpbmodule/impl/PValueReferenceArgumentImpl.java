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
import com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument;

import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PValue Reference Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PValueReferenceArgumentImpl#getValueRef <em>Value Ref</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PValueReferenceArgumentImpl#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PValueReferenceArgumentImpl extends PSingleArgumentImpl implements PValueReferenceArgument {
	/**
     * The cached value of the '{@link #getValueRef() <em>Value Ref</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValueRef()
     * @generated
     * @ordered
     */
	protected PValueReferenceMatcher valueRef;

	/**
     * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeName()
     * @generated
     * @ordered
     */
	protected static final String TYPE_NAME_EDEFAULT = null;
	/**
     * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeName()
     * @generated
     * @ordered
     */
	protected String typeName = TYPE_NAME_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PValueReferenceArgumentImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PVALUE_REFERENCE_ARGUMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PValueReferenceMatcher getValueRef() {
        return valueRef;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetValueRef(PValueReferenceMatcher newValueRef, NotificationChain msgs) {
        PValueReferenceMatcher oldValueRef = valueRef;
        valueRef = newValueRef;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__VALUE_REF, oldValueRef, newValueRef);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValueRef(PValueReferenceMatcher newValueRef) {
        if (newValueRef != valueRef) {
            NotificationChain msgs = null;
            if (valueRef != null)
                msgs = ((InternalEObject)valueRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__VALUE_REF, null, msgs);
            if (newValueRef != null)
                msgs = ((InternalEObject)newValueRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__VALUE_REF, null, msgs);
            msgs = basicSetValueRef(newValueRef, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__VALUE_REF, newValueRef, newValueRef));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getTypeName() {
        return typeName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeName(String newTypeName) {
        String oldTypeName = typeName;
        typeName = newTypeName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__TYPE_NAME, oldTypeName, typeName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__VALUE_REF:
                return basicSetValueRef(null, msgs);
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
            case FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__VALUE_REF:
                return getValueRef();
            case FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__TYPE_NAME:
                return getTypeName();
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
            case FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__VALUE_REF:
                setValueRef((PValueReferenceMatcher)newValue);
                return;
            case FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__TYPE_NAME:
                setTypeName((String)newValue);
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
            case FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__VALUE_REF:
                setValueRef((PValueReferenceMatcher)null);
                return;
            case FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__TYPE_NAME:
                setTypeName(TYPE_NAME_EDEFAULT);
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
            case FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__VALUE_REF:
                return valueRef != null;
            case FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT__TYPE_NAME:
                return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
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
        result.append(" (typeName: ");
        result.append(typeName);
        result.append(')');
        return result.toString();
    }

} //PValueReferenceArgumentImpl
