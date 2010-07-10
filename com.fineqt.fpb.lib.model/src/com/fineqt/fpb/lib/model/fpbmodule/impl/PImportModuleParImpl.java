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
import com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PModulePar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PImport Module Par</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportModuleParImpl#getImportedModuleName <em>Imported Module Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportModuleParImpl#getImportedModulePar <em>Imported Module Par</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportModuleParImpl#getImportedModulePartName <em>Imported Module Part Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PImportModuleParImpl extends PModuleParImpl implements PImportModulePar {
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
     * The cached value of the '{@link #getImportedModulePar() <em>Imported Module Par</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedModulePar()
     * @generated
     * @ordered
     */
	protected PModulePar importedModulePar;

	/**
     * The default value of the '{@link #getImportedModulePartName() <em>Imported Module Part Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedModulePartName()
     * @generated
     * @ordered
     */
	protected static final String IMPORTED_MODULE_PART_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getImportedModulePartName() <em>Imported Module Part Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedModulePartName()
     * @generated
     * @ordered
     */
	protected String importedModulePartName = IMPORTED_MODULE_PART_NAME_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PImportModuleParImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PIMPORT_MODULE_PAR;
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
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_NAME, oldImportedModuleName, importedModuleName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PModulePar getImportedModulePar() {
        if (importedModulePar != null && importedModulePar.eIsProxy()) {
            InternalEObject oldImportedModulePar = (InternalEObject)importedModulePar;
            importedModulePar = (PModulePar)eResolveProxy(oldImportedModulePar);
            if (importedModulePar != oldImportedModulePar) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_PAR, oldImportedModulePar, importedModulePar));
            }
        }
        return importedModulePar;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PModulePar basicGetImportedModulePar() {
        return importedModulePar;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImportedModulePar(PModulePar newImportedModulePar) {
        PModulePar oldImportedModulePar = importedModulePar;
        importedModulePar = newImportedModulePar;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_PAR, oldImportedModulePar, importedModulePar));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getImportedModulePartName() {
        return importedModulePartName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImportedModulePartName(String newImportedModulePartName) {
        String oldImportedModulePartName = importedModulePartName;
        importedModulePartName = newImportedModulePartName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_PART_NAME, oldImportedModulePartName, importedModulePartName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_NAME:
                return getImportedModuleName();
            case FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_PAR:
                if (resolve) return getImportedModulePar();
                return basicGetImportedModulePar();
            case FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_PART_NAME:
                return getImportedModulePartName();
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
            case FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_NAME:
                setImportedModuleName((String)newValue);
                return;
            case FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_PAR:
                setImportedModulePar((PModulePar)newValue);
                return;
            case FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_PART_NAME:
                setImportedModulePartName((String)newValue);
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
            case FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_NAME:
                setImportedModuleName(IMPORTED_MODULE_NAME_EDEFAULT);
                return;
            case FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_PAR:
                setImportedModulePar((PModulePar)null);
                return;
            case FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_PART_NAME:
                setImportedModulePartName(IMPORTED_MODULE_PART_NAME_EDEFAULT);
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
            case FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_NAME:
                return IMPORTED_MODULE_NAME_EDEFAULT == null ? importedModuleName != null : !IMPORTED_MODULE_NAME_EDEFAULT.equals(importedModuleName);
            case FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_PAR:
                return importedModulePar != null;
            case FpbmodulePackage.PIMPORT_MODULE_PAR__IMPORTED_MODULE_PART_NAME:
                return IMPORTED_MODULE_PART_NAME_EDEFAULT == null ? importedModulePartName != null : !IMPORTED_MODULE_PART_NAME_EDEFAULT.equals(importedModulePartName);
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
        result.append(" (importedModuleName: ");
        result.append(importedModuleName);
        result.append(", importedModulePartName: ");
        result.append(importedModulePartName);
        result.append(')');
        return result.toString();
    }

} //PImportModuleParImpl
