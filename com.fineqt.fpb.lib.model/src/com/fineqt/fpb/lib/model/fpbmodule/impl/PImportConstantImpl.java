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
import com.fineqt.fpb.lib.model.fpbmodule.PConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PImportConstant;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PImport Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportConstantImpl#getImportedConstant <em>Imported Constant</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportConstantImpl#getImportedConstantName <em>Imported Constant Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportConstantImpl#getImportedModuleName <em>Imported Module Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PImportConstantImpl extends PConstantImpl implements PImportConstant {
	/**
     * The cached value of the '{@link #getImportedConstant() <em>Imported Constant</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedConstant()
     * @generated
     * @ordered
     */
	protected PConstant importedConstant;

	/**
     * The default value of the '{@link #getImportedConstantName() <em>Imported Constant Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedConstantName()
     * @generated
     * @ordered
     */
	protected static final String IMPORTED_CONSTANT_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getImportedConstantName() <em>Imported Constant Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedConstantName()
     * @generated
     * @ordered
     */
	protected String importedConstantName = IMPORTED_CONSTANT_NAME_EDEFAULT;

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
	protected PImportConstantImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PIMPORT_CONSTANT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PConstant getImportedConstant() {
        if (importedConstant != null && importedConstant.eIsProxy()) {
            InternalEObject oldImportedConstant = (InternalEObject)importedConstant;
            importedConstant = (PConstant)eResolveProxy(oldImportedConstant);
            if (importedConstant != oldImportedConstant) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_CONSTANT, oldImportedConstant, importedConstant));
            }
        }
        return importedConstant;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PConstant basicGetImportedConstant() {
        return importedConstant;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImportedConstant(PConstant newImportedConstant) {
        PConstant oldImportedConstant = importedConstant;
        importedConstant = newImportedConstant;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_CONSTANT, oldImportedConstant, importedConstant));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getImportedConstantName() {
        return importedConstantName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImportedConstantName(String newImportedConstantName) {
        String oldImportedConstantName = importedConstantName;
        importedConstantName = newImportedConstantName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_CONSTANT_NAME, oldImportedConstantName, importedConstantName));
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
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_MODULE_NAME, oldImportedModuleName, importedModuleName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_CONSTANT:
                if (resolve) return getImportedConstant();
                return basicGetImportedConstant();
            case FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_CONSTANT_NAME:
                return getImportedConstantName();
            case FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_MODULE_NAME:
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
            case FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_CONSTANT:
                setImportedConstant((PConstant)newValue);
                return;
            case FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_CONSTANT_NAME:
                setImportedConstantName((String)newValue);
                return;
            case FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_MODULE_NAME:
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
            case FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_CONSTANT:
                setImportedConstant((PConstant)null);
                return;
            case FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_CONSTANT_NAME:
                setImportedConstantName(IMPORTED_CONSTANT_NAME_EDEFAULT);
                return;
            case FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_MODULE_NAME:
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
            case FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_CONSTANT:
                return importedConstant != null;
            case FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_CONSTANT_NAME:
                return IMPORTED_CONSTANT_NAME_EDEFAULT == null ? importedConstantName != null : !IMPORTED_CONSTANT_NAME_EDEFAULT.equals(importedConstantName);
            case FpbmodulePackage.PIMPORT_CONSTANT__IMPORTED_MODULE_NAME:
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
        result.append(" (importedConstantName: ");
        result.append(importedConstantName);
        result.append(", importedModuleName: ");
        result.append(importedModuleName);
        result.append(')');
        return result.toString();
    }

	@Override
	public String getBaseTypeName() {
		if (importedConstant != null) {
			return importedConstant.getBaseTypeName();
		}
		return null;
	}

} //PImportConstantImpl
