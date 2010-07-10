/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbcommon;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PModel Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbcommon.PModelElement#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbcommon.PModelElement#getAttatchment <em>Attatchment</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage#getPModelElement()
 * @model abstract="true"
 *        extendedMetaData="name='PModelElement' kind='elementOnly'"
 * @generated
 */
public interface PModelElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link com.fineqt.fpb.lib.model.fpbcommon.PAnnotation}.
	 * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getPModelElement <em>PModel Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage#getPModelElement_Annotations()
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getPModelElement
	 * @model opposite="pModelElement" containment="true"
	 *        extendedMetaData="kind='element' name='annotations'"
	 * @generated
	 */
	EList<PAnnotation> getAnnotations();

	/**
	 * Returns the value of the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attatchment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attatchment</em>' attribute.
	 * @see #setAttatchment(Object)
	 * @see com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage#getPModelElement_Attatchment()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" transient="true"
	 *        extendedMetaData="kind='attribute' name='attatchment'"
	 * @generated
	 */
	Object getAttatchment();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbcommon.PModelElement#getAttatchment <em>Attatchment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attatchment</em>' attribute.
	 * @see #getAttatchment()
	 * @generated
	 */
	void setAttatchment(Object value);

} // PModelElement
