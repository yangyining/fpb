/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PUnary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression#getPrimary <em>Primary</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPUnaryExpression()
 * @model extendedMetaData="name='PUnaryExpression' kind='elementOnly'"
 * @generated
 */
public interface PUnaryExpression extends PExpressionMatcher {
	/**
	 * Returns the value of the '<em><b>Primary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary</em>' containment reference.
	 * @see #setPrimary(PExpressionMatcher)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPUnaryExpression_Primary()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='primary'"
	 * @generated
	 */
	PExpressionMatcher getPrimary();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression#getPrimary <em>Primary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary</em>' containment reference.
	 * @see #getPrimary()
	 * @generated
	 */
	void setPrimary(PExpressionMatcher value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPUnaryExpression_Operator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='operator'"
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

} // PUnaryExpression
