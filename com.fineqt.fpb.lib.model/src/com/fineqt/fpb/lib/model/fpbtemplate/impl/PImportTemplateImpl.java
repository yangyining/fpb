/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;
import com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplate;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PImport Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PImportTemplateImpl#getImportedModuleName <em>Imported Module Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PImportTemplateImpl#getImportedTemplate <em>Imported Template</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PImportTemplateImpl#getImportedTemplateName <em>Imported Template Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PImportTemplateImpl extends PTemplateImpl implements PImportTemplate {
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
	 * The cached value of the '{@link #getImportedTemplate() <em>Imported Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedTemplate()
	 * @generated
	 * @ordered
	 */
	protected PTemplate importedTemplate;

	/**
	 * The default value of the '{@link #getImportedTemplateName() <em>Imported Template Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedTemplateName()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORTED_TEMPLATE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImportedTemplateName() <em>Imported Template Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedTemplateName()
	 * @generated
	 * @ordered
	 */
	protected String importedTemplateName = IMPORTED_TEMPLATE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PImportTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FpbtemplatePackage.Literals.PIMPORT_TEMPLATE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_MODULE_NAME, oldImportedModuleName, importedModuleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PTemplate getImportedTemplate() {
		if (importedTemplate != null && importedTemplate.eIsProxy()) {
			InternalEObject oldImportedTemplate = (InternalEObject)importedTemplate;
			importedTemplate = (PTemplate)eResolveProxy(oldImportedTemplate);
			if (importedTemplate != oldImportedTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_TEMPLATE, oldImportedTemplate, importedTemplate));
			}
		}
		return importedTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PTemplate basicGetImportedTemplate() {
		return importedTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportedTemplate(PTemplate newImportedTemplate) {
		PTemplate oldImportedTemplate = importedTemplate;
		importedTemplate = newImportedTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_TEMPLATE, oldImportedTemplate, importedTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImportedTemplateName() {
		return importedTemplateName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportedTemplateName(String newImportedTemplateName) {
		String oldImportedTemplateName = importedTemplateName;
		importedTemplateName = newImportedTemplateName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_TEMPLATE_NAME, oldImportedTemplateName, importedTemplateName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_MODULE_NAME:
				return getImportedModuleName();
			case FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_TEMPLATE:
				if (resolve) return getImportedTemplate();
				return basicGetImportedTemplate();
			case FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_TEMPLATE_NAME:
				return getImportedTemplateName();
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
			case FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_MODULE_NAME:
				setImportedModuleName((String)newValue);
				return;
			case FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_TEMPLATE:
				setImportedTemplate((PTemplate)newValue);
				return;
			case FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_TEMPLATE_NAME:
				setImportedTemplateName((String)newValue);
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
			case FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_MODULE_NAME:
				setImportedModuleName(IMPORTED_MODULE_NAME_EDEFAULT);
				return;
			case FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_TEMPLATE:
				setImportedTemplate((PTemplate)null);
				return;
			case FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_TEMPLATE_NAME:
				setImportedTemplateName(IMPORTED_TEMPLATE_NAME_EDEFAULT);
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
			case FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_MODULE_NAME:
				return IMPORTED_MODULE_NAME_EDEFAULT == null ? importedModuleName != null : !IMPORTED_MODULE_NAME_EDEFAULT.equals(importedModuleName);
			case FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_TEMPLATE:
				return importedTemplate != null;
			case FpbtemplatePackage.PIMPORT_TEMPLATE__IMPORTED_TEMPLATE_NAME:
				return IMPORTED_TEMPLATE_NAME_EDEFAULT == null ? importedTemplateName != null : !IMPORTED_TEMPLATE_NAME_EDEFAULT.equals(importedTemplateName);
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
		result.append(", importedTemplateName: ");
		result.append(importedTemplateName);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getBasetype() {
		if (importedTemplate != null) {
			return importedTemplate.getBasetype();
		}
		return null;
	}

	@Override
	public EList<PTemplatePar> getParameters() {
		if (importedTemplate != null) {
			return importedTemplate.getParameters();
		}
		return null;
	}

} //PImportTemplateImpl
