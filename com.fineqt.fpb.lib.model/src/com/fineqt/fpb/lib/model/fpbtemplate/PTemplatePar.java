/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;

import com.fineqt.fpb.lib.model.fpbcommon.PNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PTemplate Par</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar#getBasetype <em>Basetype</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar#isTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplatePar()
 * @model extendedMetaData="name='PTemplatePar' kind='elementOnly'"
 * @generated
 */
public interface PTemplatePar extends PNamedElement {
	/**
	 * Returns the value of the '<em><b>Basetype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basetype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basetype</em>' attribute.
	 * @see #setBasetype(String)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplatePar_Basetype()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='basetype'"
	 * @generated
	 */
	String getBasetype();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar#getBasetype <em>Basetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basetype</em>' attribute.
	 * @see #getBasetype()
	 * @generated
	 */
	void setBasetype(String value);

	/**
	 * Returns the value of the '<em><b>Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' attribute.
	 * @see #isSetTemplate()
	 * @see #unsetTemplate()
	 * @see #setTemplate(boolean)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplatePar_Template()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 *        extendedMetaData="kind='attribute' name='template'"
	 * @generated
	 */
	boolean isTemplate();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar#isTemplate <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' attribute.
	 * @see #isSetTemplate()
	 * @see #unsetTemplate()
	 * @see #isTemplate()
	 * @generated
	 */
	void setTemplate(boolean value);

	/**
	 * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar#isTemplate <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTemplate()
	 * @see #isTemplate()
	 * @see #setTemplate(boolean)
	 * @generated
	 */
	void unsetTemplate();

	/**
	 * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar#isTemplate <em>Template</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Template</em>' attribute is set.
	 * @see #unsetTemplate()
	 * @see #isTemplate()
	 * @see #setTemplate(boolean)
	 * @generated
	 */
	boolean isSetTemplate();

} // PTemplatePar
