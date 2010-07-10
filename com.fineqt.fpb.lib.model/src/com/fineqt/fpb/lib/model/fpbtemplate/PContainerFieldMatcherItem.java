/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;

import com.fineqt.fpb.lib.model.fpbcommon.PModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PContainer Field Matcher Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem#getMatcher <em>Matcher</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem#getFieldName <em>Field Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPContainerFieldMatcherItem()
 * @model extendedMetaData="name='PContainerFieldMatcherItem' kind='elementOnly'"
 * @generated
 */
public interface PContainerFieldMatcherItem extends PModelElement {
	/**
	 * Returns the value of the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matcher</em>' containment reference.
	 * @see #setMatcher(PTemplateMatcher)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPContainerFieldMatcherItem_Matcher()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='matcher'"
	 * @generated
	 */
	PTemplateMatcher getMatcher();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem#getMatcher <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher</em>' containment reference.
	 * @see #getMatcher()
	 * @generated
	 */
	void setMatcher(PTemplateMatcher value);

	/**
	 * Returns the value of the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Name</em>' attribute.
	 * @see #setFieldName(String)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPContainerFieldMatcherItem_FieldName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='fieldName'"
	 * @generated
	 */
	String getFieldName();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem#getFieldName <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Name</em>' attribute.
	 * @see #getFieldName()
	 * @generated
	 */
	void setFieldName(String value);

} // PContainerFieldMatcherItem
