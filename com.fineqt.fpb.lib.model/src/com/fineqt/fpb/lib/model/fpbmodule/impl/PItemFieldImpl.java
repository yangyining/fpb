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
import com.fineqt.fpb.lib.model.fpbmodule.PEnumItem;
import com.fineqt.fpb.lib.model.fpbmodule.PItemField;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PItem Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PItemFieldImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PItemFieldImpl#getEnumItems <em>Enum Items</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PItemFieldImpl#getEnumRef <em>Enum Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PItemFieldImpl extends PTypedElementImpl implements PItemField {
    /**
     * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConstraint()
     * @generated
     * @ordered
     */
    protected PTypeConstraint constraint;

    /**
     * The cached value of the '{@link #getEnumItems() <em>Enum Items</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnumItems()
     * @generated
     * @ordered
     */
    protected EList<PEnumItem> enumItems;

    /**
     * The default value of the '{@link #getEnumRef() <em>Enum Ref</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnumRef()
     * @generated
     * @ordered
     */
    protected static final String ENUM_REF_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEnumRef() <em>Enum Ref</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnumRef()
     * @generated
     * @ordered
     */
    protected String enumRef = ENUM_REF_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PItemFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PITEM_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PTypeConstraint getConstraint() {
        return constraint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetConstraint(PTypeConstraint newConstraint, NotificationChain msgs) {
        PTypeConstraint oldConstraint = constraint;
        constraint = newConstraint;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PITEM_FIELD__CONSTRAINT, oldConstraint, newConstraint);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConstraint(PTypeConstraint newConstraint) {
        if (newConstraint != constraint) {
            NotificationChain msgs = null;
            if (constraint != null)
                msgs = ((InternalEObject)constraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PITEM_FIELD__CONSTRAINT, null, msgs);
            if (newConstraint != null)
                msgs = ((InternalEObject)newConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PITEM_FIELD__CONSTRAINT, null, msgs);
            msgs = basicSetConstraint(newConstraint, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PITEM_FIELD__CONSTRAINT, newConstraint, newConstraint));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PEnumItem> getEnumItems() {
        if (enumItems == null) {
            enumItems = new EObjectContainmentEList<PEnumItem>(PEnumItem.class, this, FpbmodulePackage.PITEM_FIELD__ENUM_ITEMS);
        }
        return enumItems;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEnumRef() {
        return enumRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnumRef(String newEnumRef) {
        String oldEnumRef = enumRef;
        enumRef = newEnumRef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PITEM_FIELD__ENUM_REF, oldEnumRef, enumRef));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PITEM_FIELD__CONSTRAINT:
                return basicSetConstraint(null, msgs);
            case FpbmodulePackage.PITEM_FIELD__ENUM_ITEMS:
                return ((InternalEList<?>)getEnumItems()).basicRemove(otherEnd, msgs);
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
            case FpbmodulePackage.PITEM_FIELD__CONSTRAINT:
                return getConstraint();
            case FpbmodulePackage.PITEM_FIELD__ENUM_ITEMS:
                return getEnumItems();
            case FpbmodulePackage.PITEM_FIELD__ENUM_REF:
                return getEnumRef();
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
            case FpbmodulePackage.PITEM_FIELD__CONSTRAINT:
                setConstraint((PTypeConstraint)newValue);
                return;
            case FpbmodulePackage.PITEM_FIELD__ENUM_ITEMS:
                getEnumItems().clear();
                getEnumItems().addAll((Collection<? extends PEnumItem>)newValue);
                return;
            case FpbmodulePackage.PITEM_FIELD__ENUM_REF:
                setEnumRef((String)newValue);
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
            case FpbmodulePackage.PITEM_FIELD__CONSTRAINT:
                setConstraint((PTypeConstraint)null);
                return;
            case FpbmodulePackage.PITEM_FIELD__ENUM_ITEMS:
                getEnumItems().clear();
                return;
            case FpbmodulePackage.PITEM_FIELD__ENUM_REF:
                setEnumRef(ENUM_REF_EDEFAULT);
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
            case FpbmodulePackage.PITEM_FIELD__CONSTRAINT:
                return constraint != null;
            case FpbmodulePackage.PITEM_FIELD__ENUM_ITEMS:
                return enumItems != null && !enumItems.isEmpty();
            case FpbmodulePackage.PITEM_FIELD__ENUM_REF:
                return ENUM_REF_EDEFAULT == null ? enumRef != null : !ENUM_REF_EDEFAULT.equals(enumRef);
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
        result.append(" (enumRef: ");
        result.append(enumRef);
        result.append(')');
        return result.toString();
    }

} //PItemFieldImpl
