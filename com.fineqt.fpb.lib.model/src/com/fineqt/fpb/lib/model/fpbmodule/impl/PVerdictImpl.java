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

import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PVerdict;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PVerdict</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PVerdictImpl extends PPrimitiveTypeImpl implements PVerdict {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PVerdictImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PVERDICT;
    }

	public TypeClass getTypeClass() {
		return TypeClass.VERDICT;
	}
} //PVerdictImpl
