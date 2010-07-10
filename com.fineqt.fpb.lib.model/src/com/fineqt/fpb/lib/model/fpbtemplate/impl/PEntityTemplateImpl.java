/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;
import com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PEntity Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PEntityTemplateImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PEntityTemplateImpl#getMatcher <em>Matcher</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PEntityTemplateImpl#getBasetype <em>Basetype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PEntityTemplateImpl extends PTemplateImpl implements PEntityTemplate {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<PTemplatePar> parameters;

	/**
	 * The cached value of the '{@link #getMatcher() <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatcher()
	 * @generated
	 * @ordered
	 */
	protected PMatcher matcher;

	/**
	 * The default value of the '{@link #getBasetype() <em>Basetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasetype()
	 * @generated
	 * @ordered
	 */
	protected static final String BASETYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBasetype() <em>Basetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasetype()
	 * @generated
	 * @ordered
	 */
	protected String basetype = BASETYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PEntityTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FpbtemplatePackage.Literals.PENTITY_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PTemplatePar> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<PTemplatePar>(PTemplatePar.class, this, FpbtemplatePackage.PENTITY_TEMPLATE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PMatcher getMatcher() {
		return matcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatcher(PMatcher newMatcher, NotificationChain msgs) {
		PMatcher oldMatcher = matcher;
		matcher = newMatcher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PENTITY_TEMPLATE__MATCHER, oldMatcher, newMatcher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatcher(PMatcher newMatcher) {
		if (newMatcher != matcher) {
			NotificationChain msgs = null;
			if (matcher != null)
				msgs = ((InternalEObject)matcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbtemplatePackage.PENTITY_TEMPLATE__MATCHER, null, msgs);
			if (newMatcher != null)
				msgs = ((InternalEObject)newMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FpbtemplatePackage.PENTITY_TEMPLATE__MATCHER, null, msgs);
			msgs = basicSetMatcher(newMatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PENTITY_TEMPLATE__MATCHER, newMatcher, newMatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBasetype() {
		return basetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasetype(String newBasetype) {
		String oldBasetype = basetype;
		basetype = newBasetype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PENTITY_TEMPLATE__BASETYPE, oldBasetype, basetype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FpbtemplatePackage.PENTITY_TEMPLATE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case FpbtemplatePackage.PENTITY_TEMPLATE__MATCHER:
				return basicSetMatcher(null, msgs);
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
			case FpbtemplatePackage.PENTITY_TEMPLATE__PARAMETERS:
				return getParameters();
			case FpbtemplatePackage.PENTITY_TEMPLATE__MATCHER:
				return getMatcher();
			case FpbtemplatePackage.PENTITY_TEMPLATE__BASETYPE:
				return getBasetype();
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
			case FpbtemplatePackage.PENTITY_TEMPLATE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends PTemplatePar>)newValue);
				return;
			case FpbtemplatePackage.PENTITY_TEMPLATE__MATCHER:
				setMatcher((PMatcher)newValue);
				return;
			case FpbtemplatePackage.PENTITY_TEMPLATE__BASETYPE:
				setBasetype((String)newValue);
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
			case FpbtemplatePackage.PENTITY_TEMPLATE__PARAMETERS:
				getParameters().clear();
				return;
			case FpbtemplatePackage.PENTITY_TEMPLATE__MATCHER:
				setMatcher((PMatcher)null);
				return;
			case FpbtemplatePackage.PENTITY_TEMPLATE__BASETYPE:
				setBasetype(BASETYPE_EDEFAULT);
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
			case FpbtemplatePackage.PENTITY_TEMPLATE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case FpbtemplatePackage.PENTITY_TEMPLATE__MATCHER:
				return matcher != null;
			case FpbtemplatePackage.PENTITY_TEMPLATE__BASETYPE:
				return BASETYPE_EDEFAULT == null ? basetype != null : !BASETYPE_EDEFAULT.equals(basetype);
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
		result.append(" (basetype: ");
		result.append(basetype);
		result.append(')');
		return result.toString();
	}

} //PEntityTemplateImpl
