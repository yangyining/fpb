/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PPrimitive Value Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher#getValueDesc <em>Value Desc</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPPrimitiveValueMatcher()
 * @model extendedMetaData="name='PPrimitiveValueMatcher' kind='elementOnly'"
 * @generated
 */
public interface PPrimitiveValueMatcher extends PExpressionMatcher {
	/**
	 * Returns the value of the '<em><b>Value Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Desc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Desc</em>' attribute.
	 * @see #setValueDesc(String)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPPrimitiveValueMatcher_ValueDesc()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='valueDesc'"
	 * @generated
	 */
	String getValueDesc();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher#getValueDesc <em>Value Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Desc</em>' attribute.
	 * @see #getValueDesc()
	 * @generated
	 */
	void setValueDesc(String value);

} // PPrimitiveValueMatcher
