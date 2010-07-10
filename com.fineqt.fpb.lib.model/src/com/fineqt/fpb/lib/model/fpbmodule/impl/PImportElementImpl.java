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
import com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType;
import com.fineqt.fpb.lib.model.fpbmodule.PImportElement;

import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PImport Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportElementImpl#getRefNameList <em>Ref Name List</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportElementImpl#isAllExcept <em>All Except</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportElementImpl#getElementType <em>Element Type</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportElementImpl#getFromModuleName <em>From Module Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportElementImpl#getPmodule <em>Pmodule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PImportElementImpl extends PModelElementImpl implements PImportElement {
	/**
     * The cached value of the '{@link #getRefNameList() <em>Ref Name List</em>}' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRefNameList()
     * @generated
     * @ordered
     */
	protected EList<String> refNameList;

	/**
     * The default value of the '{@link #isAllExcept() <em>All Except</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAllExcept()
     * @generated
     * @ordered
     */
	protected static final boolean ALL_EXCEPT_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isAllExcept() <em>All Except</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAllExcept()
     * @generated
     * @ordered
     */
	protected boolean allExcept = ALL_EXCEPT_EDEFAULT;

	/**
     * This is true if the All Except attribute has been set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	protected boolean allExceptESet;

	/**
     * The default value of the '{@link #getElementType() <em>Element Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getElementType()
     * @generated
     * @ordered
     */
	protected static final ModuleElementType ELEMENT_TYPE_EDEFAULT = ModuleElementType.TYPE;

	/**
     * The cached value of the '{@link #getElementType() <em>Element Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getElementType()
     * @generated
     * @ordered
     */
	protected ModuleElementType elementType = ELEMENT_TYPE_EDEFAULT;

	/**
     * This is true if the Element Type attribute has been set.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	protected boolean elementTypeESet;

	/**
     * The default value of the '{@link #getFromModuleName() <em>From Module Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFromModuleName()
     * @generated
     * @ordered
     */
	protected static final String FROM_MODULE_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getFromModuleName() <em>From Module Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFromModuleName()
     * @generated
     * @ordered
     */
	protected String fromModuleName = FROM_MODULE_NAME_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PImportElementImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PIMPORT_ELEMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<String> getRefNameList() {
        if (refNameList == null) {
            refNameList = new EDataTypeEList<String>(String.class, this, FpbmodulePackage.PIMPORT_ELEMENT__REF_NAME_LIST);
        }
        return refNameList;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isAllExcept() {
        return allExcept;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAllExcept(boolean newAllExcept) {
        boolean oldAllExcept = allExcept;
        allExcept = newAllExcept;
        boolean oldAllExceptESet = allExceptESet;
        allExceptESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_ELEMENT__ALL_EXCEPT, oldAllExcept, allExcept, !oldAllExceptESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void unsetAllExcept() {
        boolean oldAllExcept = allExcept;
        boolean oldAllExceptESet = allExceptESet;
        allExcept = ALL_EXCEPT_EDEFAULT;
        allExceptESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, FpbmodulePackage.PIMPORT_ELEMENT__ALL_EXCEPT, oldAllExcept, ALL_EXCEPT_EDEFAULT, oldAllExceptESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetAllExcept() {
        return allExceptESet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ModuleElementType getElementType() {
        return elementType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setElementType(ModuleElementType newElementType) {
        ModuleElementType oldElementType = elementType;
        elementType = newElementType == null ? ELEMENT_TYPE_EDEFAULT : newElementType;
        boolean oldElementTypeESet = elementTypeESet;
        elementTypeESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_ELEMENT__ELEMENT_TYPE, oldElementType, elementType, !oldElementTypeESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void unsetElementType() {
        ModuleElementType oldElementType = elementType;
        boolean oldElementTypeESet = elementTypeESet;
        elementType = ELEMENT_TYPE_EDEFAULT;
        elementTypeESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, FpbmodulePackage.PIMPORT_ELEMENT__ELEMENT_TYPE, oldElementType, ELEMENT_TYPE_EDEFAULT, oldElementTypeESet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetElementType() {
        return elementTypeESet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getFromModuleName() {
        return fromModuleName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFromModuleName(String newFromModuleName) {
        String oldFromModuleName = fromModuleName;
        fromModuleName = newFromModuleName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_ELEMENT__FROM_MODULE_NAME, oldFromModuleName, fromModuleName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PModule getPmodule() {
        if (eContainerFeatureID != FpbmodulePackage.PIMPORT_ELEMENT__PMODULE) return null;
        return (PModule)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetPmodule(PModule newPmodule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newPmodule, FpbmodulePackage.PIMPORT_ELEMENT__PMODULE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPmodule(PModule newPmodule) {
        if (newPmodule != eInternalContainer() || (eContainerFeatureID != FpbmodulePackage.PIMPORT_ELEMENT__PMODULE && newPmodule != null)) {
            if (EcoreUtil.isAncestor(this, newPmodule))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPmodule != null)
                msgs = ((InternalEObject)newPmodule).eInverseAdd(this, FpbmodulePackage.PMODULE__IMPORT_ELEMENTS, PModule.class, msgs);
            msgs = basicSetPmodule(newPmodule, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PIMPORT_ELEMENT__PMODULE, newPmodule, newPmodule));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PIMPORT_ELEMENT__PMODULE:
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
            case FpbmodulePackage.PIMPORT_ELEMENT__PMODULE:
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
            case FpbmodulePackage.PIMPORT_ELEMENT__PMODULE:
                return eInternalContainer().eInverseRemove(this, FpbmodulePackage.PMODULE__IMPORT_ELEMENTS, PModule.class, msgs);
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
            case FpbmodulePackage.PIMPORT_ELEMENT__REF_NAME_LIST:
                return getRefNameList();
            case FpbmodulePackage.PIMPORT_ELEMENT__ALL_EXCEPT:
                return isAllExcept() ? Boolean.TRUE : Boolean.FALSE;
            case FpbmodulePackage.PIMPORT_ELEMENT__ELEMENT_TYPE:
                return getElementType();
            case FpbmodulePackage.PIMPORT_ELEMENT__FROM_MODULE_NAME:
                return getFromModuleName();
            case FpbmodulePackage.PIMPORT_ELEMENT__PMODULE:
                return getPmodule();
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
            case FpbmodulePackage.PIMPORT_ELEMENT__REF_NAME_LIST:
                getRefNameList().clear();
                getRefNameList().addAll((Collection<? extends String>)newValue);
                return;
            case FpbmodulePackage.PIMPORT_ELEMENT__ALL_EXCEPT:
                setAllExcept(((Boolean)newValue).booleanValue());
                return;
            case FpbmodulePackage.PIMPORT_ELEMENT__ELEMENT_TYPE:
                setElementType((ModuleElementType)newValue);
                return;
            case FpbmodulePackage.PIMPORT_ELEMENT__FROM_MODULE_NAME:
                setFromModuleName((String)newValue);
                return;
            case FpbmodulePackage.PIMPORT_ELEMENT__PMODULE:
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
            case FpbmodulePackage.PIMPORT_ELEMENT__REF_NAME_LIST:
                getRefNameList().clear();
                return;
            case FpbmodulePackage.PIMPORT_ELEMENT__ALL_EXCEPT:
                unsetAllExcept();
                return;
            case FpbmodulePackage.PIMPORT_ELEMENT__ELEMENT_TYPE:
                unsetElementType();
                return;
            case FpbmodulePackage.PIMPORT_ELEMENT__FROM_MODULE_NAME:
                setFromModuleName(FROM_MODULE_NAME_EDEFAULT);
                return;
            case FpbmodulePackage.PIMPORT_ELEMENT__PMODULE:
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
            case FpbmodulePackage.PIMPORT_ELEMENT__REF_NAME_LIST:
                return refNameList != null && !refNameList.isEmpty();
            case FpbmodulePackage.PIMPORT_ELEMENT__ALL_EXCEPT:
                return isSetAllExcept();
            case FpbmodulePackage.PIMPORT_ELEMENT__ELEMENT_TYPE:
                return isSetElementType();
            case FpbmodulePackage.PIMPORT_ELEMENT__FROM_MODULE_NAME:
                return FROM_MODULE_NAME_EDEFAULT == null ? fromModuleName != null : !FROM_MODULE_NAME_EDEFAULT.equals(fromModuleName);
            case FpbmodulePackage.PIMPORT_ELEMENT__PMODULE:
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
        result.append(" (refNameList: ");
        result.append(refNameList);
        result.append(", allExcept: ");
        if (allExceptESet) result.append(allExcept); else result.append("<unset>");
        result.append(", elementType: ");
        if (elementTypeESet) result.append(elementType); else result.append("<unset>");
        result.append(", fromModuleName: ");
        result.append(fromModuleName);
        result.append(')');
        return result.toString();
    }

} //PImportElementImpl
