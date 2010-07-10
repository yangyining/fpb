/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;

import org.eclipse.emf.common.util.EList;

import com.fineqt.fpb.lib.model.fpbcommon.PNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PTemplate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplate#getTemplateID <em>Template ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplate()
 * @model abstract="true"
 *        extendedMetaData="name='PTemplate' kind='elementOnly'"
 * @generated
 */
public interface PTemplate extends PNamedElement {
	/**
	 * Returns the value of the '<em><b>Template ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template ID</em>' attribute.
	 * @see #isSetTemplateID()
	 * @see #unsetTemplateID()
	 * @see #setTemplateID(int)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplate_TemplateID()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='templateID'"
	 * @generated
	 */
	int getTemplateID();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplate#getTemplateID <em>Template ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template ID</em>' attribute.
	 * @see #isSetTemplateID()
	 * @see #unsetTemplateID()
	 * @see #getTemplateID()
	 * @generated
	 */
	void setTemplateID(int value);

	/**
	 * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplate#getTemplateID <em>Template ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTemplateID()
	 * @see #getTemplateID()
	 * @see #setTemplateID(int)
	 * @generated
	 */
	void unsetTemplateID();

	/**
	 * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplate#getTemplateID <em>Template ID</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Template ID</em>' attribute is set.
	 * @see #unsetTemplateID()
	 * @see #getTemplateID()
	 * @see #setTemplateID(int)
	 * @generated
	 */
	boolean isSetTemplateID();
	
	String getBasetype();

	EList<PTemplatePar> getParameters();	
} // PTemplate
