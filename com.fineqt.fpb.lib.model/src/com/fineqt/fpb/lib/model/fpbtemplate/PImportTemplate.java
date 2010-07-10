/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PImport Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate#getImportedModuleName <em>Imported Module Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate#getImportedTemplate <em>Imported Template</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate#getImportedTemplateName <em>Imported Template Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPImportTemplate()
 * @model extendedMetaData="name='PImportTemplate' kind='elementOnly'"
 * @generated
 */
public interface PImportTemplate extends PTemplate {
	/**
	 * Returns the value of the '<em><b>Imported Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Module Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Module Name</em>' attribute.
	 * @see #setImportedModuleName(String)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPImportTemplate_ImportedModuleName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='importedModuleName'"
	 * @generated
	 */
	String getImportedModuleName();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate#getImportedModuleName <em>Imported Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Module Name</em>' attribute.
	 * @see #getImportedModuleName()
	 * @generated
	 */
	void setImportedModuleName(String value);

	/**
	 * Returns the value of the '<em><b>Imported Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Template</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Template</em>' reference.
	 * @see #setImportedTemplate(PTemplate)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPImportTemplate_ImportedTemplate()
	 * @model extendedMetaData="kind='attribute' name='importedTemplate'"
	 * @generated
	 */
	PTemplate getImportedTemplate();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate#getImportedTemplate <em>Imported Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Template</em>' reference.
	 * @see #getImportedTemplate()
	 * @generated
	 */
	void setImportedTemplate(PTemplate value);

	/**
	 * Returns the value of the '<em><b>Imported Template Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Template Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Template Name</em>' attribute.
	 * @see #setImportedTemplateName(String)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPImportTemplate_ImportedTemplateName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='importedTemplateName'"
	 * @generated
	 */
	String getImportedTemplateName();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate#getImportedTemplateName <em>Imported Template Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Template Name</em>' attribute.
	 * @see #getImportedTemplateName()
	 * @generated
	 */
	void setImportedTemplateName(String value);

} // PImportTemplate
