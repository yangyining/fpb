/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.impl;

import com.fineqt.fpb.lib.model.fpbcommon.impl.PModelElementImpl;

import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;
import com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;

import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PList Field Matcher Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PListFieldMatcherItemImpl#getMatcher <em>Matcher</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PListFieldMatcherItemImpl#getIndexMatcher <em>Index Matcher</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PListFieldMatcherItemImpl#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PListFieldMatcherItemImpl extends PModelElementImpl implements PListFieldMatcherItem {
	/**
	 * The cached value of the '{@link #getMatcher() <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatcher()
	 * @generated
	 * @ordered
	 */
	protected PTemplateMatcher matcher;

	/**
	 * The cached value of the '{@link #getIndexMatcher() <em>Index Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexMatcher()
	 * @generated
	 * @ordered
	 */
	protected PMatcher indexMatcher;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * This is true if the Index attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean indexESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PListFieldMatcherItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FpbtemplatePackage.Literals.PLIST_FIELD_MATCHER_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PTemplateMatcher getMatcher() {
		return matcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatcher(PTemplateMatcher newMatcher, NotificationChain msgs) {
		PTemplateMatcher oldMatcher = matcher;
		matcher = newMatcher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__MATCHER, oldMatcher, newMatcher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatcher(PTemplateMatcher newMatcher) {
		if (newMatcher != matcher) {
			NotificationChain msgs = null;
			if (matcher != null)
				msgs = ((InternalEObject)matcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__MATCHER, null, msgs);
			if (newMatcher != null)
				msgs = ((InternalEObject)newMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__MATCHER, null, msgs);
			msgs = basicSetMatcher(newMatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__MATCHER, newMatcher, newMatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PMatcher getIndexMatcher() {
		return indexMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIndexMatcher(PMatcher newIndexMatcher, NotificationChain msgs) {
		PMatcher oldIndexMatcher = indexMatcher;
		indexMatcher = newIndexMatcher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX_MATCHER, oldIndexMatcher, newIndexMatcher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexMatcher(PMatcher newIndexMatcher) {
		if (newIndexMatcher != indexMatcher) {
			NotificationChain msgs = null;
			if (indexMatcher != null)
				msgs = ((InternalEObject)indexMatcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX_MATCHER, null, msgs);
			if (newIndexMatcher != null)
				msgs = ((InternalEObject)newIndexMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX_MATCHER, null, msgs);
			msgs = basicSetIndexMatcher(newIndexMatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX_MATCHER, newIndexMatcher, newIndexMatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		boolean oldIndexESet = indexESet;
		indexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX, oldIndex, index, !oldIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIndex() {
		int oldIndex = index;
		boolean oldIndexESet = indexESet;
		index = INDEX_EDEFAULT;
		indexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX, oldIndex, INDEX_EDEFAULT, oldIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIndex() {
		return indexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__MATCHER:
				return basicSetMatcher(null, msgs);
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX_MATCHER:
				return basicSetIndexMatcher(null, msgs);
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
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__MATCHER:
				return getMatcher();
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX_MATCHER:
				return getIndexMatcher();
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX:
				return new Integer(getIndex());
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
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__MATCHER:
				setMatcher((PTemplateMatcher)newValue);
				return;
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX_MATCHER:
				setIndexMatcher((PMatcher)newValue);
				return;
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX:
				setIndex(((Integer)newValue).intValue());
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
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__MATCHER:
				setMatcher((PTemplateMatcher)null);
				return;
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX_MATCHER:
				setIndexMatcher((PMatcher)null);
				return;
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX:
				unsetIndex();
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
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__MATCHER:
				return matcher != null;
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX_MATCHER:
				return indexMatcher != null;
			case FpbtemplatePackage.PLIST_FIELD_MATCHER_ITEM__INDEX:
				return isSetIndex();
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
		result.append(" (index: ");
		if (indexESet) result.append(index); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //PListFieldMatcherItemImpl
