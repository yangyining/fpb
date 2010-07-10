/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.impl;

import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher;

import com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType;
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
 * An implementation of the model object '<em><b>PValue Reference Matcher</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceMatcherImpl#getFragments <em>Fragments</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceMatcherImpl#getRefName <em>Ref Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceMatcherImpl#getRefType <em>Ref Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PValueReferenceMatcherImpl extends PExpressionMatcherImpl implements PValueReferenceMatcher {
	/**
	 * The cached value of the '{@link #getFragments() <em>Fragments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragments()
	 * @generated
	 * @ordered
	 */
	protected EList<PValueReferenceFragment> fragments;

	/**
	 * The default value of the '{@link #getRefName() <em>Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefName()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRefName() <em>Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefName()
	 * @generated
	 * @ordered
	 */
	protected String refName = REF_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRefType() <em>Ref Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefType()
	 * @generated
	 * @ordered
	 */
	protected static final ValueReferenceType REF_TYPE_EDEFAULT = ValueReferenceType.CONSTANT;

	/**
	 * The cached value of the '{@link #getRefType() <em>Ref Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefType()
	 * @generated
	 * @ordered
	 */
	protected ValueReferenceType refType = REF_TYPE_EDEFAULT;

	/**
	 * This is true if the Ref Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean refTypeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PValueReferenceMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FpbtemplatePackage.Literals.PVALUE_REFERENCE_MATCHER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PValueReferenceFragment> getFragments() {
		if (fragments == null) {
			fragments = new EObjectContainmentEList<PValueReferenceFragment>(PValueReferenceFragment.class, this, FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__FRAGMENTS);
		}
		return fragments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRefName() {
		return refName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefName(String newRefName) {
		String oldRefName = refName;
		refName = newRefName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__REF_NAME, oldRefName, refName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueReferenceType getRefType() {
		return refType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefType(ValueReferenceType newRefType) {
		ValueReferenceType oldRefType = refType;
		refType = newRefType == null ? REF_TYPE_EDEFAULT : newRefType;
		boolean oldRefTypeESet = refTypeESet;
		refTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__REF_TYPE, oldRefType, refType, !oldRefTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRefType() {
		ValueReferenceType oldRefType = refType;
		boolean oldRefTypeESet = refTypeESet;
		refType = REF_TYPE_EDEFAULT;
		refTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__REF_TYPE, oldRefType, REF_TYPE_EDEFAULT, oldRefTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRefType() {
		return refTypeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__FRAGMENTS:
				return ((InternalEList<?>)getFragments()).basicRemove(otherEnd, msgs);
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
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__FRAGMENTS:
				return getFragments();
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__REF_NAME:
				return getRefName();
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__REF_TYPE:
				return getRefType();
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
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__FRAGMENTS:
				getFragments().clear();
				getFragments().addAll((Collection<? extends PValueReferenceFragment>)newValue);
				return;
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__REF_NAME:
				setRefName((String)newValue);
				return;
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__REF_TYPE:
				setRefType((ValueReferenceType)newValue);
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
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__FRAGMENTS:
				getFragments().clear();
				return;
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__REF_NAME:
				setRefName(REF_NAME_EDEFAULT);
				return;
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__REF_TYPE:
				unsetRefType();
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
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__FRAGMENTS:
				return fragments != null && !fragments.isEmpty();
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__REF_NAME:
				return REF_NAME_EDEFAULT == null ? refName != null : !REF_NAME_EDEFAULT.equals(refName);
			case FpbtemplatePackage.PVALUE_REFERENCE_MATCHER__REF_TYPE:
				return isSetRefType();
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
		result.append(" (refName: ");
		result.append(refName);
		result.append(", refType: ");
		if (refTypeESet) result.append(refType); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //PValueReferenceMatcherImpl
