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
 * A representation of the literals of the enumeration '<em><b>Type Class</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getTypeClass()
 * @model extendedMetaData="name='TypeClass'"
 * @generated
 */
public enum TypeClass implements Enumerator {
	/**
     * The '<em><b>Boolean</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #BOOLEAN_VALUE
     * @generated
     * @ordered
     */
	BOOLEAN(0, "boolean", "boolean"),

	/**
     * The '<em><b>Integer</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INTEGER_VALUE
     * @generated
     * @ordered
     */
	INTEGER(1, "integer", "integer"),

	/**
     * The '<em><b>Float</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #FLOAT_VALUE
     * @generated
     * @ordered
     */
	FLOAT(2, "float", "float"),

	/**
     * The '<em><b>Objid</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OBJID_VALUE
     * @generated
     * @ordered
     */
	OBJID(3, "objid", "objid"),

	/**
     * The '<em><b>Enumerated</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ENUMERATED_VALUE
     * @generated
     * @ordered
     */
	ENUMERATED(4, "enumerated", "enumerated"),

	/**
     * The '<em><b>Octetstring</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OCTETSTRING_VALUE
     * @generated
     * @ordered
     */
	OCTETSTRING(5, "octetstring", "octetstring"),

	/**
     * The '<em><b>Charstring</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #CHARSTRING_VALUE
     * @generated
     * @ordered
     */
	CHARSTRING(6, "charstring", "charstring"),

	/**
     * The '<em><b>Universal Charstring</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #UNIVERSAL_CHARSTRING_VALUE
     * @generated
     * @ordered
     */
	UNIVERSAL_CHARSTRING(7, "universalCharstring", "universal_charstring"),

	/**
     * The '<em><b>Bitstring</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #BITSTRING_VALUE
     * @generated
     * @ordered
     */
	BITSTRING(8, "bitstring", "bitstring"),

	/**
     * The '<em><b>Hexstring</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #HEXSTRING_VALUE
     * @generated
     * @ordered
     */
	HEXSTRING(9, "hexstring", "hexstring"),

	/**
     * The '<em><b>Record</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #RECORD_VALUE
     * @generated
     * @ordered
     */
	RECORD(10, "record", "record"),

	/**
     * The '<em><b>Set</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SET_VALUE
     * @generated
     * @ordered
     */
	SET(11, "set", "set"),

	/**
     * The '<em><b>Union</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #UNION_VALUE
     * @generated
     * @ordered
     */
	UNION(12, "union", "union"),

	/**
     * The '<em><b>Recordof</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #RECORDOF_VALUE
     * @generated
     * @ordered
     */
	RECORDOF(13, "recordof", "recordof"),

	/**
     * The '<em><b>Setof</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SETOF_VALUE
     * @generated
     * @ordered
     */
	SETOF(14, "setof", "setof"),

	/**
     * The '<em><b>Verdict</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #VERDICT_VALUE
     * @generated
     * @ordered
     */
	VERDICT(15, "verdict", "verdict"),

	/**
     * The '<em><b>Address</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ADDRESS_VALUE
     * @generated
     * @ordered
     */
	ADDRESS(16, "address", "address");

	/**
     * The '<em><b>Boolean</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Boolean</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #BOOLEAN
     * @model name="boolean"
     * @generated
     * @ordered
     */
	public static final int BOOLEAN_VALUE = 0;

	/**
     * The '<em><b>Integer</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Integer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INTEGER
     * @model name="integer"
     * @generated
     * @ordered
     */
	public static final int INTEGER_VALUE = 1;

	/**
     * The '<em><b>Float</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Float</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #FLOAT
     * @model name="float"
     * @generated
     * @ordered
     */
	public static final int FLOAT_VALUE = 2;

	/**
     * The '<em><b>Objid</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Objid</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OBJID
     * @model name="objid"
     * @generated
     * @ordered
     */
	public static final int OBJID_VALUE = 3;

	/**
     * The '<em><b>Enumerated</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Enumerated</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #ENUMERATED
     * @model name="enumerated"
     * @generated
     * @ordered
     */
	public static final int ENUMERATED_VALUE = 4;

	/**
     * The '<em><b>Octetstring</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Octetstring</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OCTETSTRING
     * @model name="octetstring"
     * @generated
     * @ordered
     */
	public static final int OCTETSTRING_VALUE = 5;

	/**
     * The '<em><b>Charstring</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Charstring</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #CHARSTRING
     * @model name="charstring"
     * @generated
     * @ordered
     */
	public static final int CHARSTRING_VALUE = 6;

	/**
     * The '<em><b>Universal Charstring</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Universal Charstring</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #UNIVERSAL_CHARSTRING
     * @model name="universalCharstring" literal="universal_charstring"
     * @generated
     * @ordered
     */
	public static final int UNIVERSAL_CHARSTRING_VALUE = 7;

	/**
     * The '<em><b>Bitstring</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bitstring</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #BITSTRING
     * @model name="bitstring"
     * @generated
     * @ordered
     */
	public static final int BITSTRING_VALUE = 8;

	/**
     * The '<em><b>Hexstring</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hexstring</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #HEXSTRING
     * @model name="hexstring"
     * @generated
     * @ordered
     */
	public static final int HEXSTRING_VALUE = 9;

	/**
     * The '<em><b>Record</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Record</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #RECORD
     * @model name="record"
     * @generated
     * @ordered
     */
	public static final int RECORD_VALUE = 10;

	/**
     * The '<em><b>Set</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Set</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #SET
     * @model name="set"
     * @generated
     * @ordered
     */
	public static final int SET_VALUE = 11;

	/**
     * The '<em><b>Union</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Union</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #UNION
     * @model name="union"
     * @generated
     * @ordered
     */
	public static final int UNION_VALUE = 12;

	/**
     * The '<em><b>Recordof</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Recordof</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #RECORDOF
     * @model name="recordof"
     * @generated
     * @ordered
     */
	public static final int RECORDOF_VALUE = 13;

	/**
     * The '<em><b>Setof</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Setof</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #SETOF
     * @model name="setof"
     * @generated
     * @ordered
     */
	public static final int SETOF_VALUE = 14;

	/**
     * The '<em><b>Verdict</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Verdict</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #VERDICT
     * @model name="verdict"
     * @generated
     * @ordered
     */
	public static final int VERDICT_VALUE = 15;

	/**
     * The '<em><b>Address</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Address</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #ADDRESS
     * @model name="address"
     * @generated
     * @ordered
     */
	public static final int ADDRESS_VALUE = 16;

	/**
     * An array of all the '<em><b>Type Class</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final TypeClass[] VALUES_ARRAY =
		new TypeClass[] {
            BOOLEAN,
            INTEGER,
            FLOAT,
            OBJID,
            ENUMERATED,
            OCTETSTRING,
            CHARSTRING,
            UNIVERSAL_CHARSTRING,
            BITSTRING,
            HEXSTRING,
            RECORD,
            SET,
            UNION,
            RECORDOF,
            SETOF,
            VERDICT,
            ADDRESS,
        };

	/**
     * A public read-only list of all the '<em><b>Type Class</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<TypeClass> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Type Class</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static TypeClass get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            TypeClass result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Type Class</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static TypeClass getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            TypeClass result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Type Class</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static TypeClass get(int value) {
        switch (value) {
            case BOOLEAN_VALUE: return BOOLEAN;
            case INTEGER_VALUE: return INTEGER;
            case FLOAT_VALUE: return FLOAT;
            case OBJID_VALUE: return OBJID;
            case ENUMERATED_VALUE: return ENUMERATED;
            case OCTETSTRING_VALUE: return OCTETSTRING;
            case CHARSTRING_VALUE: return CHARSTRING;
            case UNIVERSAL_CHARSTRING_VALUE: return UNIVERSAL_CHARSTRING;
            case BITSTRING_VALUE: return BITSTRING;
            case HEXSTRING_VALUE: return HEXSTRING;
            case RECORD_VALUE: return RECORD;
            case SET_VALUE: return SET;
            case UNION_VALUE: return UNION;
            case RECORDOF_VALUE: return RECORDOF;
            case SETOF_VALUE: return SETOF;
            case VERDICT_VALUE: return VERDICT;
            case ADDRESS_VALUE: return ADDRESS;
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
	private TypeClass(int value, String name, String literal) {
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
	
} //TypeClass
