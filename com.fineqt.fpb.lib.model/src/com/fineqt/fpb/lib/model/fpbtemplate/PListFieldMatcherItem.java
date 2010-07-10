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
 * A representation of the model object '<em><b>PList Field Matcher Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getMatcher <em>Matcher</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getIndexMatcher <em>Index Matcher</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPListFieldMatcherItem()
 * @model extendedMetaData="name='PListFieldMatcherItem' kind='elementOnly'"
 * @generated
 */
public interface PListFieldMatcherItem extends PModelElement {
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
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPListFieldMatcherItem_Matcher()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='matcher'"
	 * @generated
	 */
	PTemplateMatcher getMatcher();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getMatcher <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher</em>' containment reference.
	 * @see #getMatcher()
	 * @generated
	 */
	void setMatcher(PTemplateMatcher value);

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
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPListFieldMatcherItem_IndexMatcher()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='indexMatcher'"
	 * @generated
	 */
	PMatcher getIndexMatcher();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getIndexMatcher <em>Index Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Matcher</em>' containment reference.
	 * @see #getIndexMatcher()
	 * @generated
	 */
	void setIndexMatcher(PMatcher value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #isSetIndex()
	 * @see #unsetIndex()
	 * @see #setIndex(int)
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPListFieldMatcherItem_Index()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='index'"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #isSetIndex()
	 * @see #unsetIndex()
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Unsets the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIndex()
	 * @see #getIndex()
	 * @see #setIndex(int)
	 * @generated
	 */
	void unsetIndex();

	/**
	 * Returns whether the value of the '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getIndex <em>Index</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Index</em>' attribute is set.
	 * @see #unsetIndex()
	 * @see #getIndex()
	 * @see #setIndex(int)
	 * @generated
	 */
	boolean isSetIndex();

} // PListFieldMatcherItem
