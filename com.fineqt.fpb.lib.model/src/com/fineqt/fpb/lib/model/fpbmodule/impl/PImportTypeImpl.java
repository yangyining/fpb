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
import com.fineqt.fpb.lib.model.fpbmodule.PImportType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PImport Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportTypeImpl#getImportedModuleName <em>Imported Module Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportTypeImpl#getImportedType <em>Imported Type</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportTypeImpl#getImportedTypeName <em>Imported Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PImportTypeImpl extends PTypeImpl implements PImportType {
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
     * The cached value of the '{@link #getImportedType() <em>Imported Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedType()
     * @generated
     * @ordered
     */
	protected PType importedType;

	/**
     * The default value of the '{@link #getImportedTypeName() <em>Imported Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedTypeName()
     * @generated
     * @ordered
     */
	protected static final String IMPORTED_TYPE_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getImportedTypeName() <em>Imported Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportedTypeName()
     * @generated
     * @ordered
     */
	protected String importedTypeName = IMPORTED_TYPE_NAME_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PImportTypeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PIMPORT_TYPE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_TYPE__IMPORTED_MODULE_NAME, oldImportedModuleName, importedModuleName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PType getImportedType() {
        if (importedType != null && importedType.eIsProxy()) {
            InternalEObject oldImportedType = (InternalEObject)importedType;
            importedType = (PType)eResolveProxy(oldImportedType);
            if (importedType != oldImportedType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FpbmodulePackage.PIMPORT_TYPE__IMPORTED_TYPE, oldImportedType, importedType));
            }
        }
        return importedType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PType basicGetImportedType() {
        return importedType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImportedType(PType newImportedType) {
        PType oldImportedType = importedType;
        importedType = newImportedType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_TYPE__IMPORTED_TYPE, oldImportedType, importedType));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getImportedTypeName() {
        return importedTypeName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImportedTypeName(String newImportedTypeName) {
        String oldImportedTypeName = importedTypeName;
        importedTypeName = newImportedTypeName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_TYPE__IMPORTED_TYPE_NAME, oldImportedTypeName, importedTypeName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FpbmodulePackage.PIMPORT_TYPE__IMPORTED_MODULE_NAME:
                return getImportedModuleName();
            case FpbmodulePackage.PIMPORT_TYPE__IMPORTED_TYPE:
                if (resolve) return getImportedType();
                return basicGetImportedType();
            case FpbmodulePackage.PIMPORT_TYPE__IMPORTED_TYPE_NAME:
                return getImportedTypeName();
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
            case FpbmodulePackage.PIMPORT_TYPE__IMPORTED_MODULE_NAME:
                setImportedModuleName((String)newValue);
                return;
            case FpbmodulePackage.PIMPORT_TYPE__IMPORTED_TYPE:
                setImportedType((PType)newValue);
                return;
            case FpbmodulePackage.PIMPORT_TYPE__IMPORTED_TYPE_NAME:
                setImportedTypeName((String)newValue);
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
            case FpbmodulePackage.PIMPORT_TYPE__IMPORTED_MODULE_NAME:
                setImportedModuleName(IMPORTED_MODULE_NAME_EDEFAULT);
                return;
            case FpbmodulePackage.PIMPORT_TYPE__IMPORTED_TYPE:
                setImportedType((PType)null);
                return;
            case FpbmodulePackage.PIMPORT_TYPE__IMPORTED_TYPE_NAME:
                setImportedTypeName(IMPORTED_TYPE_NAME_EDEFAULT);
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
            case FpbmodulePackage.PIMPORT_TYPE__IMPORTED_MODULE_NAME:
                return IMPORTED_MODULE_NAME_EDEFAULT == null ? importedModuleName != null : !IMPORTED_MODULE_NAME_EDEFAULT.equals(importedModuleName);
            case FpbmodulePackage.PIMPORT_TYPE__IMPORTED_TYPE:
                return importedType != null;
            case FpbmodulePackage.PIMPORT_TYPE__IMPORTED_TYPE_NAME:
                return IMPORTED_TYPE_NAME_EDEFAULT == null ? importedTypeName != null : !IMPORTED_TYPE_NAME_EDEFAULT.equals(importedTypeName);
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
        result.append(", importedTypeName: ");
        result.append(importedTypeName);
        result.append(')');
        return result.toString();
    }

	@Override
	public TypeDerivativeMode getDerivativeMode() {
		return TypeDerivativeMode.IMPORT;
	}

	@Override
	public TypeClass getTypeClass() {
		assert importedType != null;
		return importedType.getTypeClass();
	}

	@Override
	public boolean isContainerType() {
		assert importedType != null;
		return importedType.isContainerType();
	}

	@Override
	public boolean isListType() {
		assert importedType != null;
		return importedType.isListType();
	}

	@Override
	public boolean isPrimitiveType() {
		assert importedType != null;
		return importedType.isPrimitiveType();
	}
	
} //PImportTypeImpl
