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
 * A representation of the model object '<em><b>PTemplate Ref Matcher Par</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcherPar#getMatcher <em>Matcher</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplateRefMatcherPar()
 * @model extendedMetaData="name='PTemplateRefMatcherPar' kind='elementOnly'"
 * @generated
 */
public interface PTemplateRefMatcherPar extends PModelElement {
	/**
	 * Returns the value of the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matcher</em>' containment reference.
	 * @see #setMatcher(PMatcher)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPTemplateRefMatcherPar_Matcher()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='matcher'"
	 * @generated
	 */
	PMatcher getMatcher();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcherPar#getMatcher <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher</em>' containment reference.
	 * @see #getMatcher()
	 * @generated
	 */
	void setMatcher(PMatcher value);

} // PTemplateRefMatcherPar
