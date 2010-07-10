/**
 * Fine Packet Builder, copyright (C) 2007-2009 fineqt.com
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU General Public License for more details at gnu.org.
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbmodule.impl;

import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PPropertyList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PFpb Type EV</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PFpbTypeEVImpl extends PTypeEVImpl implements PFpbTypeEV {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PFpbTypeEVImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PFPB_TYPE_EV;
    }
/*
	@Override
	public boolean isSetAny() {
		if (super.isSetAny())
			return true;
		return isSetByteorder() || getCaseRef() != null || getCaseRefRegion() != null|| 
		getCaseDefault() != null || isSetLength() || 
		isSetOnelineMode() || isSetLengthMultiplier() || isSetLengthIncrement() || isSetRefreshLengthRef() ||
		getLengthRef() != null || isSetPadType() || getPadValue() != null ||
		isSetProtocol() || getRepeatRef() != null ||
		getSelectRef() != null || getSelectRefRegion() != null || getSelectCond() != null || 
		isSetSigned() || getPopField() != null;
	}
*/	
} //PFpbTypeEVImpl
