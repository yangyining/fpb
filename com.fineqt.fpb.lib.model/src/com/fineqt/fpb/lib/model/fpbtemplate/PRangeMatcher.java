/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PRange Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPRangeMatcher()
 * @model extendedMetaData="name='PRangeMatcher' kind='elementOnly'"
 * @generated
 */
public interface PRangeMatcher extends PSimpleMatcher {
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' containment reference.
	 * @see #setLowerBound(PMatcher)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPRangeMatcher_LowerBound()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='lowerBound'"
	 * @generated
	 */
	PMatcher getLowerBound();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher#getLowerBound <em>Lower Bound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' containment reference.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(PMatcher value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' containment reference.
	 * @see #setUpperBound(PMatcher)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPRangeMatcher_UpperBound()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='upperBound'"
	 * @generated
	 */
	PMatcher getUpperBound();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher#getUpperBound <em>Upper Bound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' containment reference.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(PMatcher value);

} // PRangeMatcher
