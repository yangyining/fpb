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
 * A representation of the literals of the enumeration '<em><b>Pad Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getPadType()
 * @model extendedMetaData="name='PadType'"
 * @generated
 */
public enum PadType implements Enumerator {
	/**
     * The '<em><b>NO</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #NO_VALUE
     * @generated
     * @ordered
     */
	NO(0, "NO", "NO"),

	/**
     * The '<em><b>OCTET</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OCTET_VALUE
     * @generated
     * @ordered
     */
	OCTET(1, "OCTET", "OCTET"),

	/**
     * The '<em><b>OCTET2</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OCTET2_VALUE
     * @generated
     * @ordered
     */
	OCTET2(2, "OCTET2", "OCTET2"), /**
     * The '<em><b>OCTET4</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OCTET4_VALUE
     * @generated
     * @ordered
     */
	OCTET4(3, "OCTET4", "OCTET4"), /**
     * The '<em><b>OCTET8</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OCTET8_VALUE
     * @generated
     * @ordered
     */
	OCTET8(4, "OCTET8", "OCTET8");

	/**
     * The '<em><b>NO</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>No</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #NO
     * @model
     * @generated
     * @ordered
     */
	public static final int NO_VALUE = 0;

	/**
     * The '<em><b>OCTET</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Octet</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OCTET
     * @model
     * @generated
     * @ordered
     */
	public static final int OCTET_VALUE = 1;

	/**
     * The '<em><b>OCTET2</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OCTET2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OCTET2
     * @model
     * @generated
     * @ordered
     */
	public static final int OCTET2_VALUE = 2;

	/**
     * The '<em><b>OCTET4</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OCTET4</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OCTET4
     * @model
     * @generated
     * @ordered
     */
	public static final int OCTET4_VALUE = 3;

	/**
     * The '<em><b>OCTET8</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OCTET8</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OCTET8
     * @model
     * @generated
     * @ordered
     */
	public static final int OCTET8_VALUE = 4;

	/**
     * An array of all the '<em><b>Pad Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final PadType[] VALUES_ARRAY =
		new PadType[] {
            NO,
            OCTET,
            OCTET2,
            OCTET4,
            OCTET8,
        };

	/**
     * A public read-only list of all the '<em><b>Pad Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<PadType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Pad Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static PadType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PadType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Pad Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static PadType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PadType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Pad Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static PadType get(int value) {
        switch (value) {
            case NO_VALUE: return NO;
            case OCTET_VALUE: return OCTET;
            case OCTET2_VALUE: return OCTET2;
            case OCTET4_VALUE: return OCTET4;
            case OCTET8_VALUE: return OCTET8;
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
	private PadType(int value, String name, String literal) {
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
	
} //PadType
