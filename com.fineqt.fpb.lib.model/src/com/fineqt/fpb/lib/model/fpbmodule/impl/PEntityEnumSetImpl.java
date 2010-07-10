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
import com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumItem;

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
 * An implementation of the model object '<em><b>PEntity Enum Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityEnumSetImpl#getEnumItems <em>Enum Items</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityEnumSetImpl#getBaseTypeName <em>Base Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PEntityEnumSetImpl extends PEnumSetImpl implements PEntityEnumSet {
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
     * The default value of the '{@link #getBaseTypeName() <em>Base Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBaseTypeName()
     * @generated
     * @ordered
     */
	protected static final String BASE_TYPE_NAME_EDEFAULT = "integer";

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
     * This is true if the Base Type Name attribute has been set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	protected boolean baseTypeNameESet;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PEntityEnumSetImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PENTITY_ENUM_SET;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<PEnumItem> getEnumItems() {
        if (enumItems == null) {
            enumItems = new EObjectContainmentEList<PEnumItem>(PEnumItem.class, this, FpbmodulePackage.PENTITY_ENUM_SET__ENUM_ITEMS);
        }
        return enumItems;
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
        boolean oldBaseTypeNameESet = baseTypeNameESet;
        baseTypeNameESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENTITY_ENUM_SET__BASE_TYPE_NAME, oldBaseTypeName, baseTypeName, !oldBaseTypeNameESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void unsetBaseTypeName() {
        String oldBaseTypeName = baseTypeName;
        boolean oldBaseTypeNameESet = baseTypeNameESet;
        baseTypeName = BASE_TYPE_NAME_EDEFAULT;
        baseTypeNameESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, FpbmodulePackage.PENTITY_ENUM_SET__BASE_TYPE_NAME, oldBaseTypeName, BASE_TYPE_NAME_EDEFAULT, oldBaseTypeNameESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetBaseTypeName() {
        return baseTypeNameESet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PENTITY_ENUM_SET__ENUM_ITEMS:
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
            case FpbmodulePackage.PENTITY_ENUM_SET__ENUM_ITEMS:
                return getEnumItems();
            case FpbmodulePackage.PENTITY_ENUM_SET__BASE_TYPE_NAME:
                return getBaseTypeName();
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
            case FpbmodulePackage.PENTITY_ENUM_SET__ENUM_ITEMS:
                getEnumItems().clear();
                getEnumItems().addAll((Collection<? extends PEnumItem>)newValue);
                return;
            case FpbmodulePackage.PENTITY_ENUM_SET__BASE_TYPE_NAME:
                setBaseTypeName((String)newValue);
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
            case FpbmodulePackage.PENTITY_ENUM_SET__ENUM_ITEMS:
                getEnumItems().clear();
                return;
            case FpbmodulePackage.PENTITY_ENUM_SET__BASE_TYPE_NAME:
                unsetBaseTypeName();
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
            case FpbmodulePackage.PENTITY_ENUM_SET__ENUM_ITEMS:
                return enumItems != null && !enumItems.isEmpty();
            case FpbmodulePackage.PENTITY_ENUM_SET__BASE_TYPE_NAME:
                return isSetBaseTypeName();
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
        if (baseTypeNameESet) result.append(baseTypeName); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //PEntityEnumSetImpl
