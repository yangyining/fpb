/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.impl;

import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;
import com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PPrimitive Value Matcher</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PPrimitiveValueMatcherImpl#getValueDesc <em>Value Desc</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PPrimitiveValueMatcherImpl extends PExpressionMatcherImpl implements PPrimitiveValueMatcher {
	/**
	 * The default value of the '{@link #getValueDesc() <em>Value Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueDesc()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_DESC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValueDesc() <em>Value Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueDesc()
	 * @generated
	 * @ordered
	 */
	protected String valueDesc = VALUE_DESC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PPrimitiveValueMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FpbtemplatePackage.Literals.PPRIMITIVE_VALUE_MATCHER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueDesc() {
		return valueDesc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueDesc(String newValueDesc) {
		String oldValueDesc = valueDesc;
		valueDesc = newValueDesc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PPRIMITIVE_VALUE_MATCHER__VALUE_DESC, oldValueDesc, valueDesc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FpbtemplatePackage.PPRIMITIVE_VALUE_MATCHER__VALUE_DESC:
				return getValueDesc();
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
			case FpbtemplatePackage.PPRIMITIVE_VALUE_MATCHER__VALUE_DESC:
				setValueDesc((String)newValue);
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
			case FpbtemplatePackage.PPRIMITIVE_VALUE_MATCHER__VALUE_DESC:
				setValueDesc(VALUE_DESC_EDEFAULT);
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
			case FpbtemplatePackage.PPRIMITIVE_VALUE_MATCHER__VALUE_DESC:
				return VALUE_DESC_EDEFAULT == null ? valueDesc != null : !VALUE_DESC_EDEFAULT.equals(valueDesc);
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
		result.append(" (valueDesc: ");
		result.append(valueDesc);
		result.append(')');
		return result.toString();
	}

} //PPrimitiveValueMatcherImpl
