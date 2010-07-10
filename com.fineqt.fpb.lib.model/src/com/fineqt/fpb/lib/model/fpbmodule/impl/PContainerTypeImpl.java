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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PContainerType;
import com.fineqt.fpb.lib.model.fpbmodule.PField;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PContainer Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PContainerTypeImpl#getPfields <em>Pfields</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PContainerTypeImpl extends PEntityTypeImpl implements PContainerType {
	/**
     * The cached value of the '{@link #getPfields() <em>Pfields</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPfields()
     * @generated
     * @ordered
     */
	protected EList<PField> pfields;

//	private PContainerTypeAdapter adapter = new PContainerTypeAdapter();
//	
//	private Map<Integer, PField> fieldMap = new HashMap<Integer, PField>();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected PContainerTypeImpl() {
		super();
//		eAdapters().add(adapter);
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PCONTAINER_TYPE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<PField> getPfields() {
        if (pfields == null) {
            pfields = new EObjectContainmentEList<PField>(PField.class, this, FpbmodulePackage.PCONTAINER_TYPE__PFIELDS);
        }
        return pfields;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PCONTAINER_TYPE__PFIELDS:
                return ((InternalEList<?>)getPfields()).basicRemove(otherEnd, msgs);
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
            case FpbmodulePackage.PCONTAINER_TYPE__PFIELDS:
                return getPfields();
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
            case FpbmodulePackage.PCONTAINER_TYPE__PFIELDS:
                getPfields().clear();
                getPfields().addAll((Collection<? extends PField>)newValue);
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
            case FpbmodulePackage.PCONTAINER_TYPE__PFIELDS:
                getPfields().clear();
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
            case FpbmodulePackage.PCONTAINER_TYPE__PFIELDS:
                return pfields != null && !pfields.isEmpty();
        }
        return super.eIsSet(featureID);
    }

	public boolean isContainerType() {
		return true;
	}

//	@Override
//	public PField getField(int fieldID) {
//		return fieldMap.get(fieldID);
//	}
//	
//	private class PContainerTypeAdapter extends AdapterImpl {
//
//		@SuppressWarnings("unchecked")
//		@Override
//		public void notifyChanged(Notification msg) {
//			PField fieldObj;
//			Collection<PField> fieldObjs;
//			switch(msg.getFeatureID(PContainerType.class)){
//			case FpbmodulePackage.PCONTAINER_TYPE__PFIELDS:
//				switch(msg.getEventType()) {
//				case Notification.ADD:
//					fieldObj = (PField)msg.getNewValue();
//					fieldMap.put(fieldObj.getFieldID(), fieldObj);
//					break;
//				case Notification.ADD_MANY:
//					fieldObjs = (Collection<PField>)msg.getNewValue();
//					for (PField field : fieldObjs) {
//						fieldMap.put(field.getFieldID(), field);
//					}
//					break;
//				case Notification.REMOVE:
//					fieldObj = (PField)msg.getOldValue();
//					fieldMap.remove(fieldObj.getFieldID());
//					break;
//				case Notification.REMOVE_MANY:
//					fieldObjs = (Collection<PField>)msg.getOldValue();
//					for (PField field : fieldObjs) {
//						fieldMap.remove(field.getFieldID());
//					}
//					break;
//				}
//				break;
//			}
//			super.notifyChanged(msg);
//		}
//		
//	}
	
} //PContainerTypeImpl
