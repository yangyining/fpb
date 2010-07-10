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
import com.fineqt.fpb.lib.model.fpbmodule.PEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PImport Enum Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportEnumSetImpl#getImportedEnumSet <em>Imported Enum Set</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportEnumSetImpl#getImportedEnumSetName <em>Imported Enum Set Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportEnumSetImpl#getImportedModuleName <em>Imported Module Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PImportEnumSetImpl extends PEnumSetImpl implements PImportEnumSet {
	/**
     * The cached value of the '{@link #getImportedEnumSet() <em>Imported Enum Set</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedEnumSet()
     * @generated
     * @ordered
     */
	protected PEnumSet importedEnumSet;

	/**
     * The default value of the '{@link #getImportedEnumSetName() <em>Imported Enum Set Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedEnumSetName()
     * @generated
     * @ordered
     */
	protected static final String IMPORTED_ENUM_SET_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getImportedEnumSetName() <em>Imported Enum Set Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedEnumSetName()
     * @generated
     * @ordered
     */
	protected String importedEnumSetName = IMPORTED_ENUM_SET_NAME_EDEFAULT;

	/**
     * The default value of the '{@link #getImportedModuleName() <em>Imported Module Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedModuleName()
     * @generated
     * @ordered
     */
	protected static final String IMPORTED_MODULE_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getImportedModuleName() <em>Imported Module Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedModuleName()
     * @generated
     * @ordered
     */
	protected String importedModuleName = IMPORTED_MODULE_NAME_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PImportEnumSetImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PIMPORT_ENUM_SET;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PEnumSet getImportedEnumSet() {
        if (importedEnumSet != null && importedEnumSet.eIsProxy()) {
            InternalEObject oldImportedEnumSet = (InternalEObject)importedEnumSet;
            importedEnumSet = (PEnumSet)eResolveProxy(oldImportedEnumSet);
            if (importedEnumSet != oldImportedEnumSet) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_ENUM_SET, oldImportedEnumSet, importedEnumSet));
            }
        }
        return importedEnumSet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PEnumSet basicGetImportedEnumSet() {
        return importedEnumSet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImportedEnumSet(PEnumSet newImportedEnumSet) {
        PEnumSet oldImportedEnumSet = importedEnumSet;
        importedEnumSet = newImportedEnumSet;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_ENUM_SET, oldImportedEnumSet, importedEnumSet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getImportedEnumSetName() {
        return importedEnumSetName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImportedEnumSetName(String newImportedEnumSetName) {
        String oldImportedEnumSetName = importedEnumSetName;
        importedEnumSetName = newImportedEnumSetName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_ENUM_SET_NAME, oldImportedEnumSetName, importedEnumSetName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getImportedModuleName() {
        return importedModuleName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImportedModuleName(String newImportedModuleName) {
        String oldImportedModuleName = importedModuleName;
        importedModuleName = newImportedModuleName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_MODULE_NAME, oldImportedModuleName, importedModuleName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_ENUM_SET:
                if (resolve) return getImportedEnumSet();
                return basicGetImportedEnumSet();
            case FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_ENUM_SET_NAME:
                return getImportedEnumSetName();
            case FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_MODULE_NAME:
                return getImportedModuleName();
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
            case FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_ENUM_SET:
                setImportedEnumSet((PEnumSet)newValue);
                return;
            case FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_ENUM_SET_NAME:
                setImportedEnumSetName((String)newValue);
                return;
            case FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_MODULE_NAME:
                setImportedModuleName((String)newValue);
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
            case FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_ENUM_SET:
                setImportedEnumSet((PEnumSet)null);
                return;
            case FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_ENUM_SET_NAME:
                setImportedEnumSetName(IMPORTED_ENUM_SET_NAME_EDEFAULT);
                return;
            case FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_MODULE_NAME:
                setImportedModuleName(IMPORTED_MODULE_NAME_EDEFAULT);
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
            case FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_ENUM_SET:
                return importedEnumSet != null;
            case FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_ENUM_SET_NAME:
                return IMPORTED_ENUM_SET_NAME_EDEFAULT == null ? importedEnumSetName != null : !IMPORTED_ENUM_SET_NAME_EDEFAULT.equals(importedEnumSetName);
            case FpbmodulePackage.PIMPORT_ENUM_SET__IMPORTED_MODULE_NAME:
                return IMPORTED_MODULE_NAME_EDEFAULT == null ? importedModuleName != null : !IMPORTED_MODULE_NAME_EDEFAULT.equals(importedModuleName);
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
        result.append(" (importedEnumSetName: ");
        result.append(importedEnumSetName);
        result.append(", importedModuleName: ");
        result.append(importedModuleName);
        result.append(')');
        return result.toString();
    }

} //PImportEnumSetImpl
