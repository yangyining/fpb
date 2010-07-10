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

import com.fineqt.fpb.lib.model.fpbcommon.impl.PModelElementImpl;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PEnumerated Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumeratedItemImpl#getEnumName <em>Enum Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumeratedItemImpl#getEnumValue <em>Enum Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PEnumeratedItemImpl extends PModelElementImpl implements PEnumeratedItem {
	/**
     * The default value of the '{@link #getEnumName() <em>Enum Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEnumName()
     * @generated
     * @ordered
     */
	protected static final String ENUM_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getEnumName() <em>Enum Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEnumName()
     * @generated
     * @ordered
     */
	protected String enumName = ENUM_NAME_EDEFAULT;

	/**
     * The default value of the '{@link #getEnumValue() <em>Enum Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEnumValue()
     * @generated
     * @ordered
     */
	protected static final int ENUM_VALUE_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getEnumValue() <em>Enum Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEnumValue()
     * @generated
     * @ordered
     */
	protected int enumValue = ENUM_VALUE_EDEFAULT;

	/**
     * This is true if the Enum Value attribute has been set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	protected boolean enumValueESet;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PEnumeratedItemImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PENUMERATED_ITEM;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getEnumName() {
        return enumName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEnumName(String newEnumName) {
        String oldEnumName = enumName;
        enumName = newEnumName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENUMERATED_ITEM__ENUM_NAME, oldEnumName, enumName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getEnumValue() {
        return enumValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEnumValue(int newEnumValue) {
        int oldEnumValue = enumValue;
        enumValue = newEnumValue;
        boolean oldEnumValueESet = enumValueESet;
        enumValueESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PENUMERATED_ITEM__ENUM_VALUE, oldEnumValue, enumValue, !oldEnumValueESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void unsetEnumValue() {
        int oldEnumValue = enumValue;
        boolean oldEnumValueESet = enumValueESet;
        enumValue = ENUM_VALUE_EDEFAULT;
        enumValueESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, FpbmodulePackage.PENUMERATED_ITEM__ENUM_VALUE, oldEnumValue, ENUM_VALUE_EDEFAULT, oldEnumValueESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetEnumValue() {
        return enumValueESet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FpbmodulePackage.PENUMERATED_ITEM__ENUM_NAME:
                return getEnumName();
            case FpbmodulePackage.PENUMERATED_ITEM__ENUM_VALUE:
                return new Integer(getEnumValue());
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
            case FpbmodulePackage.PENUMERATED_ITEM__ENUM_NAME:
                setEnumName((String)newValue);
                return;
            case FpbmodulePackage.PENUMERATED_ITEM__ENUM_VALUE:
                setEnumValue(((Integer)newValue).intValue());
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
            case FpbmodulePackage.PENUMERATED_ITEM__ENUM_NAME:
                setEnumName(ENUM_NAME_EDEFAULT);
                return;
            case FpbmodulePackage.PENUMERATED_ITEM__ENUM_VALUE:
                unsetEnumValue();
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
            case FpbmodulePackage.PENUMERATED_ITEM__ENUM_NAME:
                return ENUM_NAME_EDEFAULT == null ? enumName != null : !ENUM_NAME_EDEFAULT.equals(enumName);
            case FpbmodulePackage.PENUMERATED_ITEM__ENUM_VALUE:
                return isSetEnumValue();
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
        result.append(" (enumName: ");
        result.append(enumName);
        result.append(", enumValue: ");
        if (enumValueESet) result.append(enumValue); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //PEnumeratedItemImpl
