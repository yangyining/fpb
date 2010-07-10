/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.impl;

import com.fineqt.fpb.lib.model.fpbcommon.impl.PModelElementImpl;

import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PValue Reference Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceFragmentImpl#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceFragmentImpl#getIndexMatcher <em>Index Matcher</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PValueReferenceFragmentImpl extends PModelElementImpl implements PValueReferenceFragment {
	/**
	 * The default value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected String fieldName = FIELD_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIndexMatcher() <em>Index Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexMatcher()
	 * @generated
	 * @ordered
	 */
	protected PMatcher indexMatcher;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PValueReferenceFragmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FpbtemplatePackage.Literals.PVALUE_REFERENCE_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldName(String newFieldName) {
		String oldFieldName = fieldName;
		fieldName = newFieldName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__FIELD_NAME, oldFieldName, fieldName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PMatcher getIndexMatcher() {
		return indexMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIndexMatcher(PMatcher newIndexMatcher, NotificationChain msgs) {
		PMatcher oldIndexMatcher = indexMatcher;
		indexMatcher = newIndexMatcher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__INDEX_MATCHER, oldIndexMatcher, newIndexMatcher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexMatcher(PMatcher newIndexMatcher) {
		if (newIndexMatcher != indexMatcher) {
			NotificationChain msgs = null;
			if (indexMatcher != null)
				msgs = ((InternalEObject)indexMatcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__INDEX_MATCHER, null, msgs);
			if (newIndexMatcher != null)
				msgs = ((InternalEObject)newIndexMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__INDEX_MATCHER, null, msgs);
			msgs = basicSetIndexMatcher(newIndexMatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__INDEX_MATCHER, newIndexMatcher, newIndexMatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__INDEX_MATCHER:
				return basicSetIndexMatcher(null, msgs);
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
			case FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__FIELD_NAME:
				return getFieldName();
			case FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__INDEX_MATCHER:
				return getIndexMatcher();
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
			case FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__FIELD_NAME:
				setFieldName((String)newValue);
				return;
			case FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__INDEX_MATCHER:
				setIndexMatcher((PMatcher)newValue);
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
			case FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__FIELD_NAME:
				setFieldName(FIELD_NAME_EDEFAULT);
				return;
			case FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__INDEX_MATCHER:
				setIndexMatcher((PMatcher)null);
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
			case FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__FIELD_NAME:
				return FIELD_NAME_EDEFAULT == null ? fieldName != null : !FIELD_NAME_EDEFAULT.equals(fieldName);
			case FpbtemplatePackage.PVALUE_REFERENCE_FRAGMENT__INDEX_MATCHER:
				return indexMatcher != null;
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
		result.append(" (fieldName: ");
		result.append(fieldName);
		result.append(')');
		return result.toString();
	}

} //PValueReferenceFragmentImpl
