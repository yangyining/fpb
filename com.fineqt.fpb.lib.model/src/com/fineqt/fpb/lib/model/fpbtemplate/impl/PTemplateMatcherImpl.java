/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.impl;

import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PTemplate Matcher</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateMatcherImpl#isIfPresent <em>If Present</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateMatcherImpl#getLengthRestriction <em>Length Restriction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PTemplateMatcherImpl extends PMatcherImpl implements PTemplateMatcher {
	/**
	 * The default value of the '{@link #isIfPresent() <em>If Present</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIfPresent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IF_PRESENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIfPresent() <em>If Present</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIfPresent()
	 * @generated
	 * @ordered
	 */
	protected boolean ifPresent = IF_PRESENT_EDEFAULT;

	/**
	 * This is true if the If Present attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean ifPresentESet;

	/**
	 * The default value of the '{@link #getLengthRestriction() <em>Length Restriction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLengthRestriction()
	 * @generated
	 * @ordered
	 */
	protected static final String LENGTH_RESTRICTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLengthRestriction() <em>Length Restriction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLengthRestriction()
	 * @generated
	 * @ordered
	 */
	protected String lengthRestriction = LENGTH_RESTRICTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PTemplateMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FpbtemplatePackage.Literals.PTEMPLATE_MATCHER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIfPresent() {
		return ifPresent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfPresent(boolean newIfPresent) {
		boolean oldIfPresent = ifPresent;
		ifPresent = newIfPresent;
		boolean oldIfPresentESet = ifPresentESet;
		ifPresentESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PTEMPLATE_MATCHER__IF_PRESENT, oldIfPresent, ifPresent, !oldIfPresentESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIfPresent() {
		boolean oldIfPresent = ifPresent;
		boolean oldIfPresentESet = ifPresentESet;
		ifPresent = IF_PRESENT_EDEFAULT;
		ifPresentESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FpbtemplatePackage.PTEMPLATE_MATCHER__IF_PRESENT, oldIfPresent, IF_PRESENT_EDEFAULT, oldIfPresentESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIfPresent() {
		return ifPresentESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLengthRestriction() {
		return lengthRestriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLengthRestriction(String newLengthRestriction) {
		String oldLengthRestriction = lengthRestriction;
		lengthRestriction = newLengthRestriction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PTEMPLATE_MATCHER__LENGTH_RESTRICTION, oldLengthRestriction, lengthRestriction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FpbtemplatePackage.PTEMPLATE_MATCHER__IF_PRESENT:
				return isIfPresent() ? Boolean.TRUE : Boolean.FALSE;
			case FpbtemplatePackage.PTEMPLATE_MATCHER__LENGTH_RESTRICTION:
				return getLengthRestriction();
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
			case FpbtemplatePackage.PTEMPLATE_MATCHER__IF_PRESENT:
				setIfPresent(((Boolean)newValue).booleanValue());
				return;
			case FpbtemplatePackage.PTEMPLATE_MATCHER__LENGTH_RESTRICTION:
				setLengthRestriction((String)newValue);
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
			case FpbtemplatePackage.PTEMPLATE_MATCHER__IF_PRESENT:
				unsetIfPresent();
				return;
			case FpbtemplatePackage.PTEMPLATE_MATCHER__LENGTH_RESTRICTION:
				setLengthRestriction(LENGTH_RESTRICTION_EDEFAULT);
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
			case FpbtemplatePackage.PTEMPLATE_MATCHER__IF_PRESENT:
				return isSetIfPresent();
			case FpbtemplatePackage.PTEMPLATE_MATCHER__LENGTH_RESTRICTION:
				return LENGTH_RESTRICTION_EDEFAULT == null ? lengthRestriction != null : !LENGTH_RESTRICTION_EDEFAULT.equals(lengthRestriction);
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
		result.append(" (ifPresent: ");
		if (ifPresentESet) result.append(ifPresent); else result.append("<unset>");
		result.append(", lengthRestriction: ");
		result.append(lengthRestriction);
		result.append(')');
		return result.toString();
	}

} //PTemplateMatcherImpl
