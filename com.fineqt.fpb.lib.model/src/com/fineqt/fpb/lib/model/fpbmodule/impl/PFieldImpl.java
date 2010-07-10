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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumItem;
import com.fineqt.fpb.lib.model.fpbmodule.PField;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PField</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFieldImpl#getFieldID <em>Field ID</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFieldImpl#isOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PFieldImpl extends PItemFieldImpl implements PField {
	/**
     * The default value of the '{@link #getFieldID() <em>Field ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFieldID()
     * @generated
     * @ordered
     */
	protected static final int FIELD_ID_EDEFAULT = 0;
	/**
     * The cached value of the '{@link #getFieldID() <em>Field ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFieldID()
     * @generated
     * @ordered
     */
	protected int fieldID = FIELD_ID_EDEFAULT;
	/**
     * This is true if the Field ID attribute has been set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	protected boolean fieldIDESet;
	/**
     * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isOptional()
     * @generated
     * @ordered
     */
	protected static final boolean OPTIONAL_EDEFAULT = false;
	/**
     * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isOptional()
     * @generated
     * @ordered
     */
	protected boolean optional = OPTIONAL_EDEFAULT;
	/**
     * This is true if the Optional attribute has been set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	protected boolean optionalESet;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PFieldImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PFIELD;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getFieldID() {
        return fieldID;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFieldID(int newFieldID) {
        int oldFieldID = fieldID;
        fieldID = newFieldID;
        boolean oldFieldIDESet = fieldIDESet;
        fieldIDESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PFIELD__FIELD_ID, oldFieldID, fieldID, !oldFieldIDESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void unsetFieldID() {
        int oldFieldID = fieldID;
        boolean oldFieldIDESet = fieldIDESet;
        fieldID = FIELD_ID_EDEFAULT;
        fieldIDESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, FpbmodulePackage.PFIELD__FIELD_ID, oldFieldID, FIELD_ID_EDEFAULT, oldFieldIDESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetFieldID() {
        return fieldIDESet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isOptional() {
        return optional;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOptional(boolean newOptional) {
        boolean oldOptional = optional;
        optional = newOptional;
        boolean oldOptionalESet = optionalESet;
        optionalESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PFIELD__OPTIONAL, oldOptional, optional, !oldOptionalESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void unsetOptional() {
        boolean oldOptional = optional;
        boolean oldOptionalESet = optionalESet;
        optional = OPTIONAL_EDEFAULT;
        optionalESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, FpbmodulePackage.PFIELD__OPTIONAL, oldOptional, OPTIONAL_EDEFAULT, oldOptionalESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetOptional() {
        return optionalESet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FpbmodulePackage.PFIELD__FIELD_ID:
                return new Integer(getFieldID());
            case FpbmodulePackage.PFIELD__OPTIONAL:
                return isOptional() ? Boolean.TRUE : Boolean.FALSE;
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
            case FpbmodulePackage.PFIELD__FIELD_ID:
                setFieldID(((Integer)newValue).intValue());
                return;
            case FpbmodulePackage.PFIELD__OPTIONAL:
                setOptional(((Boolean)newValue).booleanValue());
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
            case FpbmodulePackage.PFIELD__FIELD_ID:
                unsetFieldID();
                return;
            case FpbmodulePackage.PFIELD__OPTIONAL:
                unsetOptional();
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
            case FpbmodulePackage.PFIELD__FIELD_ID:
                return isSetFieldID();
            case FpbmodulePackage.PFIELD__OPTIONAL:
                return isSetOptional();
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
        result.append(" (fieldID: ");
        if (fieldIDESet) result.append(fieldID); else result.append("<unset>");
        result.append(", optional: ");
        if (optionalESet) result.append(optional); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //PFieldImpl
