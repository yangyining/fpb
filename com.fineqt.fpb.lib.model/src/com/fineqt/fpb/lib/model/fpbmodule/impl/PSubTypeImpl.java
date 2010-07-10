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
import com.fineqt.fpb.lib.model.fpbmodule.PSubType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PSub Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PSubTypeImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PSubTypeImpl#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PSubTypeImpl#getSuperTypeName <em>Super Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PSubTypeImpl extends PTypeImpl implements PSubType {
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
     * The cached value of the '{@link #getSuperType() <em>Super Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSuperType()
     * @generated
     * @ordered
     */
	protected PType superType;

	/**
     * The default value of the '{@link #getSuperTypeName() <em>Super Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSuperTypeName()
     * @generated
     * @ordered
     */
	protected static final String SUPER_TYPE_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getSuperTypeName() <em>Super Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSuperTypeName()
     * @generated
     * @ordered
     */
	protected String superTypeName = SUPER_TYPE_NAME_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PSubTypeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PSUB_TYPE;
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PSUB_TYPE__CONSTRAINT, oldConstraint, newConstraint);
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
                msgs = ((InternalEObject)constraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PSUB_TYPE__CONSTRAINT, null, msgs);
            if (newConstraint != null)
                msgs = ((InternalEObject)newConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FpbmodulePackage.PSUB_TYPE__CONSTRAINT, null, msgs);
            msgs = basicSetConstraint(newConstraint, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PSUB_TYPE__CONSTRAINT, newConstraint, newConstraint));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PType getSuperType() {
        if (superType != null && superType.eIsProxy()) {
            InternalEObject oldSuperType = (InternalEObject)superType;
            superType = (PType)eResolveProxy(oldSuperType);
            if (superType != oldSuperType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FpbmodulePackage.PSUB_TYPE__SUPER_TYPE, oldSuperType, superType));
            }
        }
        return superType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PType basicGetSuperType() {
        return superType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSuperType(PType newSuperType) {
        PType oldSuperType = superType;
        superType = newSuperType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PSUB_TYPE__SUPER_TYPE, oldSuperType, superType));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getSuperTypeName() {
        return superTypeName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSuperTypeName(String newSuperTypeName) {
        String oldSuperTypeName = superTypeName;
        superTypeName = newSuperTypeName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PSUB_TYPE__SUPER_TYPE_NAME, oldSuperTypeName, superTypeName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PSUB_TYPE__CONSTRAINT:
                return basicSetConstraint(null, msgs);
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
            case FpbmodulePackage.PSUB_TYPE__CONSTRAINT:
                return getConstraint();
            case FpbmodulePackage.PSUB_TYPE__SUPER_TYPE:
                if (resolve) return getSuperType();
                return basicGetSuperType();
            case FpbmodulePackage.PSUB_TYPE__SUPER_TYPE_NAME:
                return getSuperTypeName();
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
            case FpbmodulePackage.PSUB_TYPE__CONSTRAINT:
                setConstraint((PTypeConstraint)newValue);
                return;
            case FpbmodulePackage.PSUB_TYPE__SUPER_TYPE:
                setSuperType((PType)newValue);
                return;
            case FpbmodulePackage.PSUB_TYPE__SUPER_TYPE_NAME:
                setSuperTypeName((String)newValue);
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
            case FpbmodulePackage.PSUB_TYPE__CONSTRAINT:
                setConstraint((PTypeConstraint)null);
                return;
            case FpbmodulePackage.PSUB_TYPE__SUPER_TYPE:
                setSuperType((PType)null);
                return;
            case FpbmodulePackage.PSUB_TYPE__SUPER_TYPE_NAME:
                setSuperTypeName(SUPER_TYPE_NAME_EDEFAULT);
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
            case FpbmodulePackage.PSUB_TYPE__CONSTRAINT:
                return constraint != null;
            case FpbmodulePackage.PSUB_TYPE__SUPER_TYPE:
                return superType != null;
            case FpbmodulePackage.PSUB_TYPE__SUPER_TYPE_NAME:
                return SUPER_TYPE_NAME_EDEFAULT == null ? superTypeName != null : !SUPER_TYPE_NAME_EDEFAULT.equals(superTypeName);
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
        result.append(" (superTypeName: ");
        result.append(superTypeName);
        result.append(')');
        return result.toString();
    }

	@Override
	public TypeDerivativeMode getDerivativeMode() {
		return TypeDerivativeMode.SUB;
	}

	@Override
	public TypeClass getTypeClass() {
		assert superType != null;
		return superType.getTypeClass();
	}

	@Override
	public boolean isContainerType() {
		assert superType != null;
		return superType.isContainerType();
	}

	@Override
	public boolean isListType() {
		assert superType != null;
		return superType.isListType();
	}

	@Override
	public boolean isPrimitiveType() {
		assert superType != null;
		return superType.isPrimitiveType();
	}
	
} //PSubTypeImpl
