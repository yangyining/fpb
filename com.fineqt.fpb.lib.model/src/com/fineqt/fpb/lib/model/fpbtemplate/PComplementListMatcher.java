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
 * A representation of the model object '<em><b>PComplement List Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.PComplementListMatcher#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPComplementListMatcher()
 * @model extendedMetaData="name='PComplementListMatcher' kind='elementOnly'"
 * @generated
 */
public interface PComplementListMatcher extends PSimpleMatcher {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#getPComplementListMatcher_Items()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='items'"
	 * @generated
	 */
	EList<PTemplateMatcher> getItems();

} // PComplementListMatcher