/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbcommon;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PAnnotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getDetails <em>Details</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getSource <em>Source</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getPModelElement <em>PModel Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage#getPAnnotation()
 * @model extendedMetaData="name='PAnnotation' kind='elementOnly'"
 * @generated
 */
public interface PAnnotation extends PModelElement {
	/**
	 * Returns the value of the '<em><b>Details</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Details</em>' map.
	 * @see com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage#getPAnnotation_Details()
	 * @model mapType="com.fineqt.fpb.lib.model.fpbcommon.PStringToStringMapEntry<org.eclipse.emf.ecore.xml.type.String, org.eclipse.emf.ecore.xml.type.String>"
	 *        extendedMetaData="kind='element' name='details'"
	 * @generated
	 */
	EMap<String, String> getDetails();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage#getPAnnotation_Source()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='source'"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>PModel Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.fineqt.fpb.lib.model.fpbcommon.PModelElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PModel Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PModel Element</em>' container reference.
	 * @see #setPModelElement(PModelElement)
	 * @see com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage#getPAnnotation_PModelElement()
	 * @see com.fineqt.fpb.lib.model.fpbcommon.PModelElement#getAnnotations
	 * @model opposite="annotations"
	 * @generated
	 */
	PModelElement getPModelElement();

	/**
	 * Sets the value of the '{@link com.fineqt.fpb.lib.model.fpbcommon.PAnnotation#getPModelElement <em>PModel Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PModel Element</em>' container reference.
	 * @see #getPModelElement()
	 * @generated
	 */
	void setPModelElement(PModelElement value);

} // PAnnotation
