/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbcommon.impl;

import com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage;
import com.fineqt.fpb.lib.model.fpbcommon.PAnnotation;
import com.fineqt.fpb.lib.model.fpbcommon.PModelElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PModel Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PModelElementImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PModelElementImpl#getAttatchment <em>Attatchment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PModelElementImpl extends EObjectImpl implements PModelElement {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<PAnnotation> annotations;

	/**
	 * The default value of the '{@link #getAttatchment() <em>Attatchment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttatchment()
	 * @generated
	 * @ordered
	 */
	protected static final Object ATTATCHMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttatchment() <em>Attatchment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttatchment()
	 * @generated
	 * @ordered
	 */
	protected Object attatchment = ATTATCHMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FpbcommonPackage.Literals.PMODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PAnnotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentWithInverseEList<PAnnotation>(PAnnotation.class, this, FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS, FpbcommonPackage.PANNOTATION__PMODEL_ELEMENT);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAttatchment() {
		return attatchment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttatchment(Object newAttatchment) {
		Object oldAttatchment = attatchment;
		attatchment = newAttatchment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT, oldAttatchment, attatchment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotations()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS:
				return getAnnotations();
			case FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT:
				return getAttatchment();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends PAnnotation>)newValue);
				return;
			case FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT:
				setAttatchment(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT:
				setAttatchment(ATTATCHMENT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT:
				return ATTATCHMENT_EDEFAULT == null ? attatchment != null : !ATTATCHMENT_EDEFAULT.equals(attatchment);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (attatchment: ");
		result.append(attatchment);
		result.append(')');
		return result.toString();
	}

} //PModelElementImpl
