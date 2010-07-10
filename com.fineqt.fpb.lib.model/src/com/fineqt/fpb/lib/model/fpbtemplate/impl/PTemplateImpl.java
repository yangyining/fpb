/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.fineqt.fpb.lib.model.fpbcommon.impl.PNamedElementImpl;
import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PTemplate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateImpl#getTemplateID <em>Template ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PTemplateImpl extends PNamedElementImpl implements PTemplate {
	/**
	 * The default value of the '{@link #getTemplateID() <em>Template ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateID()
	 * @generated
	 * @ordered
	 */
	protected static final int TEMPLATE_ID_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getTemplateID() <em>Template ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateID()
	 * @generated
	 * @ordered
	 */
	protected int templateID = TEMPLATE_ID_EDEFAULT;
	/**
	 * This is true if the Template ID attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean templateIDESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FpbtemplatePackage.Literals.PTEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTemplateID() {
		return templateID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateID(int newTemplateID) {
		int oldTemplateID = templateID;
		templateID = newTemplateID;
		boolean oldTemplateIDESet = templateIDESet;
		templateIDESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PTEMPLATE__TEMPLATE_ID, oldTemplateID, templateID, !oldTemplateIDESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTemplateID() {
		int oldTemplateID = templateID;
		boolean oldTemplateIDESet = templateIDESet;
		templateID = TEMPLATE_ID_EDEFAULT;
		templateIDESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FpbtemplatePackage.PTEMPLATE__TEMPLATE_ID, oldTemplateID, TEMPLATE_ID_EDEFAULT, oldTemplateIDESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTemplateID() {
		return templateIDESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FpbtemplatePackage.PTEMPLATE__TEMPLATE_ID:
				return new Integer(getTemplateID());
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
			case FpbtemplatePackage.PTEMPLATE__TEMPLATE_ID:
				setTemplateID(((Integer)newValue).intValue());
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
			case FpbtemplatePackage.PTEMPLATE__TEMPLATE_ID:
				unsetTemplateID();
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
			case FpbtemplatePackage.PTEMPLATE__TEMPLATE_ID:
				return isSetTemplateID();
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
		result.append(" (templateID: ");
		if (templateIDESet) result.append(templateID); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //PTemplateImpl
