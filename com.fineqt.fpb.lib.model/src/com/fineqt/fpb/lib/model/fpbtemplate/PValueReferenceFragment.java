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
 * A representation of the model object '<em><b>PValue Reference Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment#getIndexMatcher <em>Index Matcher</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPValueReferenceFragment()
 * @model extendedMetaData="name='PValueReferenceFragment' kind='elementOnly'"
 * @generated
 */
public interface PValueReferenceFragment extends PModelElement {
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
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPValueReferenceFragment_FieldName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='fieldName'"
	 * @generated
	 */
	String getFieldName();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment#getFieldName <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Name</em>' attribute.
	 * @see #getFieldName()
	 * @generated
	 */
	void setFieldName(String value);

	/**
	 * Returns the value of the '<em><b>Index Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Matcher</em>' containment reference.
	 * @see #setIndexMatcher(PMatcher)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPValueReferenceFragment_IndexMatcher()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='indexMatcher'"
	 * @generated
	 */
	PMatcher getIndexMatcher();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment#getIndexMatcher <em>Index Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Matcher</em>' containment reference.
	 * @see #getIndexMatcher()
	 * @generated
	 */
	void setIndexMatcher(PMatcher value);

} // PValueReferenceFragment
