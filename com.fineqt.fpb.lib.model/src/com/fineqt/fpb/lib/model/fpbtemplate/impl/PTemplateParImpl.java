/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.impl;

import com.fineqt.fpb.lib.model.fpbcommon.impl.PNamedElementImpl;

import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PTemplate Par</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateParImpl#getBasetype <em>Basetype</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateParImpl#isTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PTemplateParImpl extends PNamedElementImpl implements PTemplatePar {
	/**
	 * The default value of the '{@link #getBasetype() <em>Basetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasetype()
	 * @generated
	 * @ordered
	 */
	protected static final String BASETYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBasetype() <em>Basetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasetype()
	 * @generated
	 * @ordered
	 */
	protected String basetype = BASETYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isTemplate() <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TEMPLATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTemplate() <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemplate()
	 * @generated
	 * @ordered
	 */
	protected boolean template = TEMPLATE_EDEFAULT;

	/**
	 * This is true if the Template attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean templateESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PTemplateParImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FpbtemplatePackage.Literals.PTEMPLATE_PAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBasetype() {
		return basetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasetype(String newBasetype) {
		String oldBasetype = basetype;
		basetype = newBasetype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PTEMPLATE_PAR__BASETYPE, oldBasetype, basetype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(boolean newTemplate) {
		boolean oldTemplate = template;
		template = newTemplate;
		boolean oldTemplateESet = templateESet;
		templateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PTEMPLATE_PAR__TEMPLATE, oldTemplate, template, !oldTemplateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTemplate() {
		boolean oldTemplate = template;
		boolean oldTemplateESet = templateESet;
		template = TEMPLATE_EDEFAULT;
		templateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FpbtemplatePackage.PTEMPLATE_PAR__TEMPLATE, oldTemplate, TEMPLATE_EDEFAULT, oldTemplateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTemplate() {
		return templateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FpbtemplatePackage.PTEMPLATE_PAR__BASETYPE:
				return getBasetype();
			case FpbtemplatePackage.PTEMPLATE_PAR__TEMPLATE:
				return isTemplate() ? Boolean.TRUE : Boolean.FALSE;
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
			case FpbtemplatePackage.PTEMPLATE_PAR__BASETYPE:
				setBasetype((String)newValue);
				return;
			case FpbtemplatePackage.PTEMPLATE_PAR__TEMPLATE:
				setTemplate(((Boolean)newValue).booleanValue());
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
			case FpbtemplatePackage.PTEMPLATE_PAR__BASETYPE:
				setBasetype(BASETYPE_EDEFAULT);
				return;
			case FpbtemplatePackage.PTEMPLATE_PAR__TEMPLATE:
				unsetTemplate();
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
			case FpbtemplatePackage.PTEMPLATE_PAR__BASETYPE:
				return BASETYPE_EDEFAULT == null ? basetype != null : !BASETYPE_EDEFAULT.equals(basetype);
			case FpbtemplatePackage.PTEMPLATE_PAR__TEMPLATE:
				return isSetTemplate();
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
		result.append(" (basetype: ");
		result.append(basetype);
		result.append(", template: ");
		if (templateESet) result.append(template); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //PTemplateParImpl
