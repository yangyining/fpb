/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PSingle Expression Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPSingleExpressionMatcher()
 * @model extendedMetaData="name='PSingleExpressionMatcher' kind='elementOnly'"
 * @generated
 */
public interface PSingleExpressionMatcher extends PSimpleMatcher {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(PExpressionMatcher)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPSingleExpressionMatcher_Expression()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='expression'"
	 * @generated
	 */
	PExpressionMatcher getExpression();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(PExpressionMatcher value);

} // PSingleExpressionMatcher
