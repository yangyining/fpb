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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PAnnotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PAnnotationImpl#getDetails <em>Details</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PAnnotationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbcommon.impl.PAnnotationImpl#getPModelElement <em>PModel Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PAnnotationImpl extends PModelElementImpl implements PAnnotation {
	/**
	 * The cached value of the '{@link #getDetails() <em>Details</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetails()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> details;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FpbcommonPackage.Literals.PANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getDetails() {
		if (details == null) {
			details = new EcoreEMap<String,String>(FpbcommonPackage.Literals.PSTRING_TO_STRING_MAP_ENTRY, PStringToStringMapEntryImpl.class, this, FpbcommonPackage.PANNOTATION__DETAILS);
		}
		return details;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbcommonPackage.PANNOTATION__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PModelElement getPModelElement() {
		if (eContainerFeatureID != FpbcommonPackage.PANNOTATION__PMODEL_ELEMENT) return null;
		return (PModelElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPModelElement(PModelElement newPModelElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPModelElement, FpbcommonPackage.PANNOTATION__PMODEL_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPModelElement(PModelElement newPModelElement) {
		if (newPModelElement != eInternalContainer() || (eContainerFeatureID != FpbcommonPackage.PANNOTATION__PMODEL_ELEMENT && newPModelElement != null)) {
			if (EcoreUtil.isAncestor(this, newPModelElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPModelElement != null)
				msgs = ((InternalEObject)newPModelElement).eInverseAdd(this, FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS, PModelElement.class, msgs);
			msgs = basicSetPModelElement(newPModelElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbcommonPackage.PANNOTATION__PMODEL_ELEMENT, newPModelElement, newPModelElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FpbcommonPackage.PANNOTATION__PMODEL_ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPModelElement((PModelElement)otherEnd, msgs);
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
			case FpbcommonPackage.PANNOTATION__DETAILS:
				return ((InternalEList<?>)getDetails()).basicRemove(otherEnd, msgs);
			case FpbcommonPackage.PANNOTATION__PMODEL_ELEMENT:
				return basicSetPModelElement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case FpbcommonPackage.PANNOTATION__PMODEL_ELEMENT:
				return eInternalContainer().eInverseRemove(this, FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS, PModelElement.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FpbcommonPackage.PANNOTATION__DETAILS:
				if (coreType) return getDetails();
				else return getDetails().map();
			case FpbcommonPackage.PANNOTATION__SOURCE:
				return getSource();
			case FpbcommonPackage.PANNOTATION__PMODEL_ELEMENT:
				return getPModelElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FpbcommonPackage.PANNOTATION__DETAILS:
				((EStructuralFeature.Setting)getDetails()).set(newValue);
				return;
			case FpbcommonPackage.PANNOTATION__SOURCE:
				setSource((String)newValue);
				return;
			case FpbcommonPackage.PANNOTATION__PMODEL_ELEMENT:
				setPModelElement((PModelElement)newValue);
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
			case FpbcommonPackage.PANNOTATION__DETAILS:
				getDetails().clear();
				return;
			case FpbcommonPackage.PANNOTATION__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case FpbcommonPackage.PANNOTATION__PMODEL_ELEMENT:
				setPModelElement((PModelElement)null);
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
			case FpbcommonPackage.PANNOTATION__DETAILS:
				return details != null && !details.isEmpty();
			case FpbcommonPackage.PANNOTATION__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
			case FpbcommonPackage.PANNOTATION__PMODEL_ELEMENT:
				return getPModelElement() != null;
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
		result.append(" (source: ");
		result.append(source);
		result.append(')');
		return result.toString();
	}

} //PAnnotationImpl
