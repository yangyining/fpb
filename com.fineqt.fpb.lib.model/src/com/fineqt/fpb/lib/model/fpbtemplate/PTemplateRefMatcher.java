/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PTemplate Ref Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher#getExternalTemplateName <em>External Template Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplateRefMatcher()
 * @model extendedMetaData="name='PTemplateRefMatcher' kind='elementOnly'"
 * @generated
 */
public interface PTemplateRefMatcher extends PSimpleMatcher {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcherPar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplateRefMatcher_Parameters()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='parameters'"
	 * @generated
	 */
	EList<PTemplateRefMatcherPar> getParameters();

	/**
	 * Returns the value of the '<em><b>External Template Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Template Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Template Name</em>' attribute.
	 * @see #setExternalTemplateName(String)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplateRefMatcher_ExternalTemplateName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='externalTemplateName'"
	 * @generated
	 */
	String getExternalTemplateName();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher#getExternalTemplateName <em>External Template Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Template Name</em>' attribute.
	 * @see #getExternalTemplateName()
	 * @generated
	 */
	void setExternalTemplateName(String value);

} // PTemplateRefMatcher
