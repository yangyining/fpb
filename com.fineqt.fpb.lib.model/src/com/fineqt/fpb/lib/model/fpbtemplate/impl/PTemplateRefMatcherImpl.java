/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.impl;

import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcherPar;

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
 * An implementation of the model object '<em><b>PTemplate Ref Matcher</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateRefMatcherImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateRefMatcherImpl#getExternalTemplateName <em>External Template Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PTemplateRefMatcherImpl extends PSimpleMatcherImpl implements PTemplateRefMatcher {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<PTemplateRefMatcherPar> parameters;

	/**
	 * The default value of the '{@link #getExternalTemplateName() <em>External Template Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalTemplateName()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTERNAL_TEMPLATE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExternalTemplateName() <em>External Template Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalTemplateName()
	 * @generated
	 * @ordered
	 */
	protected String externalTemplateName = EXTERNAL_TEMPLATE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PTemplateRefMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FpbtemplatePackage.Literals.PTEMPLATE_REF_MATCHER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PTemplateRefMatcherPar> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<PTemplateRefMatcherPar>(PTemplateRefMatcherPar.class, this, FpbtemplatePackage.PTEMPLATE_REF_MATCHER__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExternalTemplateName() {
		return externalTemplateName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalTemplateName(String newExternalTemplateName) {
		String oldExternalTemplateName = externalTemplateName;
		externalTemplateName = newExternalTemplateName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PTEMPLATE_REF_MATCHER__EXTERNAL_TEMPLATE_NAME, oldExternalTemplateName, externalTemplateName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER__PARAMETERS:
				return getParameters();
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER__EXTERNAL_TEMPLATE_NAME:
				return getExternalTemplateName();
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
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends PTemplateRefMatcherPar>)newValue);
				return;
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER__EXTERNAL_TEMPLATE_NAME:
				setExternalTemplateName((String)newValue);
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
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER__PARAMETERS:
				getParameters().clear();
				return;
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER__EXTERNAL_TEMPLATE_NAME:
				setExternalTemplateName(EXTERNAL_TEMPLATE_NAME_EDEFAULT);
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
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case FpbtemplatePackage.PTEMPLATE_REF_MATCHER__EXTERNAL_TEMPLATE_NAME:
				return EXTERNAL_TEMPLATE_NAME_EDEFAULT == null ? externalTemplateName != null : !EXTERNAL_TEMPLATE_NAME_EDEFAULT.equals(externalTemplateName);
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
		result.append(" (externalTemplateName: ");
		result.append(externalTemplateName);
		result.append(')');
		return result.toString();
	}

} //PTemplateRefMatcherImpl
