/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PValue Reference Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getFragments <em>Fragments</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getRefName <em>Ref Name</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getRefType <em>Ref Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPValueReferenceMatcher()
 * @model extendedMetaData="name='PValueReferenceMatcher' kind='elementOnly'"
 * @generated
 */
public interface PValueReferenceMatcher extends PExpressionMatcher {
	/**
	 * Returns the value of the '<em><b>Fragments</b></em>' containment reference list.
	 * The list contents are of type {@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragments</em>' containment reference list.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPValueReferenceMatcher_Fragments()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='fragments'"
	 * @generated
	 */
	EList<PValueReferenceFragment> getFragments();

	/**
	 * Returns the value of the '<em><b>Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Name</em>' attribute.
	 * @see #setRefName(String)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPValueReferenceMatcher_RefName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='refName'"
	 * @generated
	 */
	String getRefName();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getRefName <em>Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Name</em>' attribute.
	 * @see #getRefName()
	 * @generated
	 */
	void setRefName(String value);

	/**
	 * Returns the value of the '<em><b>Ref Type</b></em>' attribute.
	 * The default value is <code>"CONSTANT"</code>.
	 * The literals are from the enumeration {@link com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Type</em>' attribute.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType
	 * @see #isSetRefType()
	 * @see #unsetRefType()
	 * @see #setRefType(ValueReferenceType)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPValueReferenceMatcher_RefType()
	 * @model default="CONSTANT" unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='refType'"
	 * @generated
	 */
	ValueReferenceType getRefType();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getRefType <em>Ref Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Type</em>' attribute.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType
	 * @see #isSetRefType()
	 * @see #unsetRefType()
	 * @see #getRefType()
	 * @generated
	 */
	void setRefType(ValueReferenceType value);

	/**
	 * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getRefType <em>Ref Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRefType()
	 * @see #getRefType()
	 * @see #setRefType(ValueReferenceType)
	 * @generated
	 */
	void unsetRefType();

	/**
	 * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getRefType <em>Ref Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ref Type</em>' attribute is set.
	 * @see #unsetRefType()
	 * @see #getRefType()
	 * @see #setRefType(ValueReferenceType)
	 * @generated
	 */
	boolean isSetRefType();

} // PValueReferenceMatcher
