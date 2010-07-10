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
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PType</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeImpl#isContainerType <em>Container Type</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeImpl#getDerivativeMode <em>Derivative Mode</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeImpl#getJavaClass <em>Java Class</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeImpl#isListType <em>List Type</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeImpl#isPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeImpl#getTypeClass <em>Type Class</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeImpl#getTypeID <em>Type ID</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeImpl#getPmodule <em>Pmodule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PTypeImpl extends PEncodedElementImpl implements PType {
	/**
     * The default value of the '{@link #isContainerType() <em>Container Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isContainerType()
     * @generated
     * @ordered
     */
	protected static final boolean CONTAINER_TYPE_EDEFAULT = false;

	/**
     * The default value of the '{@link #getDerivativeMode() <em>Derivative Mode</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDerivativeMode()
     * @generated
     * @ordered
     */
	protected static final TypeDerivativeMode DERIVATIVE_MODE_EDEFAULT = TypeDerivativeMode.ENTITY;

	/**
     * The default value of the '{@link #getJavaClass() <em>Java Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getJavaClass()
     * @generated
     * @ordered
     */
	protected static final String JAVA_CLASS_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getJavaClass() <em>Java Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getJavaClass()
     * @generated
     * @ordered
     */
	protected String javaClass = JAVA_CLASS_EDEFAULT;

	/**
     * The default value of the '{@link #isListType() <em>List Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isListType()
     * @generated
     * @ordered
     */
	protected static final boolean LIST_TYPE_EDEFAULT = false;

	/**
     * The default value of the '{@link #isPrimitiveType() <em>Primitive Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isPrimitiveType()
     * @generated
     * @ordered
     */
	protected static final boolean PRIMITIVE_TYPE_EDEFAULT = false;

	/**
     * The default value of the '{@link #getTypeClass() <em>Type Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeClass()
     * @generated
     * @ordered
     */
	protected static final TypeClass TYPE_CLASS_EDEFAULT = TypeClass.BOOLEAN;

	/**
     * The default value of the '{@link #getTypeID() <em>Type ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeID()
     * @generated
     * @ordered
     */
	protected static final int TYPE_ID_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getTypeID() <em>Type ID</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeID()
     * @generated
     * @ordered
     */
	protected int typeID = TYPE_ID_EDEFAULT;

	/**
     * This is true if the Type ID attribute has been set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	protected boolean typeIDESet;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PTypeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PTYPE;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isContainerType() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TypeDerivativeMode getDerivativeMode() {
		throw new UnsupportedOperationException();
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getJavaClass() {
        return javaClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setJavaClass(String newJavaClass) {
        String oldJavaClass = javaClass;
        javaClass = newJavaClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PTYPE__JAVA_CLASS, oldJavaClass, javaClass));
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isListType() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isPrimitiveType() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TypeClass getTypeClass() {
		throw new UnsupportedOperationException();
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getTypeID() {
        return typeID;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeID(int newTypeID) {
        int oldTypeID = typeID;
        typeID = newTypeID;
        boolean oldTypeIDESet = typeIDESet;
        typeIDESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PTYPE__TYPE_ID, oldTypeID, typeID, !oldTypeIDESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void unsetTypeID() {
        int oldTypeID = typeID;
        boolean oldTypeIDESet = typeIDESet;
        typeID = TYPE_ID_EDEFAULT;
        typeIDESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, FpbmodulePackage.PTYPE__TYPE_ID, oldTypeID, TYPE_ID_EDEFAULT, oldTypeIDESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetTypeID() {
        return typeIDESet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PModule getPmodule() {
        if (eContainerFeatureID != FpbmodulePackage.PTYPE__PMODULE) return null;
        return (PModule)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetPmodule(PModule newPmodule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newPmodule, FpbmodulePackage.PTYPE__PMODULE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPmodule(PModule newPmodule) {
        if (newPmodule != eInternalContainer() || (eContainerFeatureID != FpbmodulePackage.PTYPE__PMODULE && newPmodule != null)) {
            if (EcoreUtil.isAncestor(this, newPmodule))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPmodule != null)
                msgs = ((InternalEObject)newPmodule).eInverseAdd(this, FpbmodulePackage.PMODULE__TYPES, PModule.class, msgs);
            msgs = basicSetPmodule(newPmodule, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PTYPE__PMODULE, newPmodule, newPmodule));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PTYPE__PMODULE:
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
            case FpbmodulePackage.PTYPE__PMODULE:
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
            case FpbmodulePackage.PTYPE__PMODULE:
                return eInternalContainer().eInverseRemove(this, FpbmodulePackage.PMODULE__TYPES, PModule.class, msgs);
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
            case FpbmodulePackage.PTYPE__CONTAINER_TYPE:
                return isContainerType() ? Boolean.TRUE : Boolean.FALSE;
            case FpbmodulePackage.PTYPE__DERIVATIVE_MODE:
                return getDerivativeMode();
            case FpbmodulePackage.PTYPE__JAVA_CLASS:
                return getJavaClass();
            case FpbmodulePackage.PTYPE__LIST_TYPE:
                return isListType() ? Boolean.TRUE : Boolean.FALSE;
            case FpbmodulePackage.PTYPE__PRIMITIVE_TYPE:
                return isPrimitiveType() ? Boolean.TRUE : Boolean.FALSE;
            case FpbmodulePackage.PTYPE__TYPE_CLASS:
                return getTypeClass();
            case FpbmodulePackage.PTYPE__TYPE_ID:
                return new Integer(getTypeID());
            case FpbmodulePackage.PTYPE__PMODULE:
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
            case FpbmodulePackage.PTYPE__JAVA_CLASS:
                setJavaClass((String)newValue);
                return;
            case FpbmodulePackage.PTYPE__TYPE_ID:
                setTypeID(((Integer)newValue).intValue());
                return;
            case FpbmodulePackage.PTYPE__PMODULE:
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
            case FpbmodulePackage.PTYPE__JAVA_CLASS:
                setJavaClass(JAVA_CLASS_EDEFAULT);
                return;
            case FpbmodulePackage.PTYPE__TYPE_ID:
                unsetTypeID();
                return;
            case FpbmodulePackage.PTYPE__PMODULE:
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
            case FpbmodulePackage.PTYPE__CONTAINER_TYPE:
                return isContainerType() != CONTAINER_TYPE_EDEFAULT;
            case FpbmodulePackage.PTYPE__DERIVATIVE_MODE:
                return getDerivativeMode() != DERIVATIVE_MODE_EDEFAULT;
            case FpbmodulePackage.PTYPE__JAVA_CLASS:
                return JAVA_CLASS_EDEFAULT == null ? javaClass != null : !JAVA_CLASS_EDEFAULT.equals(javaClass);
            case FpbmodulePackage.PTYPE__LIST_TYPE:
                return isListType() != LIST_TYPE_EDEFAULT;
            case FpbmodulePackage.PTYPE__PRIMITIVE_TYPE:
                return isPrimitiveType() != PRIMITIVE_TYPE_EDEFAULT;
            case FpbmodulePackage.PTYPE__TYPE_CLASS:
                return getTypeClass() != TYPE_CLASS_EDEFAULT;
            case FpbmodulePackage.PTYPE__TYPE_ID:
                return isSetTypeID();
            case FpbmodulePackage.PTYPE__PMODULE:
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
        result.append(" (javaClass: ");
        result.append(javaClass);
        result.append(", typeID: ");
        if (typeIDESet) result.append(typeID); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //PTypeImpl
