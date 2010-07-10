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
package com.fineqt.fpb.lib.model.fpbmodule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type Derivative Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getTypeDerivativeMode()
 * @model extendedMetaData="name='TypeDerivativeMode'"
 * @generated
 */
public enum TypeDerivativeMode implements Enumerator {
	/**
     * The '<em><b>ENTITY</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ENTITY_VALUE
     * @generated
     * @ordered
     */
	ENTITY(0, "ENTITY", "ENTITY"),

	/**
     * The '<em><b>SUB</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SUB_VALUE
     * @generated
     * @ordered
     */
	SUB(1, "SUB", "SUB"),

	/**
     * The '<em><b>IMPORT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #IMPORT_VALUE
     * @generated
     * @ordered
     */
	IMPORT(2, "IMPORT", "IMPORT");

	/**
     * The '<em><b>ENTITY</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENTITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #ENTITY
     * @model
     * @generated
     * @ordered
     */
	public static final int ENTITY_VALUE = 0;

	/**
     * The '<em><b>SUB</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #SUB
     * @model
     * @generated
     * @ordered
     */
	public static final int SUB_VALUE = 1;

	/**
     * The '<em><b>IMPORT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IMPORT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #IMPORT
     * @model
     * @generated
     * @ordered
     */
	public static final int IMPORT_VALUE = 2;

	/**
     * An array of all the '<em><b>Type Derivative Mode</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final TypeDerivativeMode[] VALUES_ARRAY =
		new TypeDerivativeMode[] {
            ENTITY,
            SUB,
            IMPORT,
        };

	/**
     * A public read-only list of all the '<em><b>Type Derivative Mode</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<TypeDerivativeMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Type Derivative Mode</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static TypeDerivativeMode get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            TypeDerivativeMode result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Type Derivative Mode</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static TypeDerivativeMode getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            TypeDerivativeMode result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Type Derivative Mode</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static TypeDerivativeMode get(int value) {
        switch (value) {
            case ENTITY_VALUE: return ENTITY;
            case SUB_VALUE: return SUB;
            case IMPORT_VALUE: return IMPORT;
        }
        return null;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final int value;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final String name;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final String literal;

	/**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private TypeDerivativeMode(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getValue() {
      return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
      return name;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getLiteral() {
      return literal;
    }

	/**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        return literal;
    }
	
} //TypeDerivativeMode
