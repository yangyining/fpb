/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PTemplate Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher#isIfPresent <em>If Present</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher#getLengthRestriction <em>Length Restriction</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplateMatcher()
 * @model abstract="true"
 *        extendedMetaData="name='PTemplateMatcher' kind='elementOnly'"
 * @generated
 */
public interface PTemplateMatcher extends PMatcher {
	/**
	 * Returns the value of the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If Present</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If Present</em>' attribute.
	 * @see #isSetIfPresent()
	 * @see #unsetIfPresent()
	 * @see #setIfPresent(boolean)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplateMatcher_IfPresent()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='ifPresent'"
	 * @generated
	 */
	boolean isIfPresent();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher#isIfPresent <em>If Present</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Present</em>' attribute.
	 * @see #isSetIfPresent()
	 * @see #unsetIfPresent()
	 * @see #isIfPresent()
	 * @generated
	 */
	void setIfPresent(boolean value);

	/**
	 * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher#isIfPresent <em>If Present</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIfPresent()
	 * @see #isIfPresent()
	 * @see #setIfPresent(boolean)
	 * @generated
	 */
	void unsetIfPresent();

	/**
	 * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher#isIfPresent <em>If Present</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>If Present</em>' attribute is set.
	 * @see #unsetIfPresent()
	 * @see #isIfPresent()
	 * @see #setIfPresent(boolean)
	 * @generated
	 */
	boolean isSetIfPresent();

	/**
	 * Returns the value of the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length Restriction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length Restriction</em>' attribute.
	 * @see #setLengthRestriction(String)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplateMatcher_LengthRestriction()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='lengthRestriction'"
	 * @generated
	 */
	String getLengthRestriction();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher#getLengthRestriction <em>Length Restriction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length Restriction</em>' attribute.
	 * @see #getLengthRestriction()
	 * @generated
	 */
	void setLengthRestriction(String value);

} // PTemplateMatcher
