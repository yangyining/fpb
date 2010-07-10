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
 * A representation of the literals of the enumeration '<em><b>Module Element Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#getModuleElementType()
 * @model extendedMetaData="name='ModuleElementType'"
 * @generated
 */
public enum ModuleElementType implements Enumerator {
	/**
     * The '<em><b>TYPE</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #TYPE_VALUE
     * @generated
     * @ordered
     */
	TYPE(0, "TYPE", "TYPE"),

	/**
     * The '<em><b>CONST</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #CONST_VALUE
     * @generated
     * @ordered
     */
	CONST(1, "CONST", "CONST"),

	/**
     * The '<em><b>MODULEPAR</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #MODULEPAR_VALUE
     * @generated
     * @ordered
     */
	MODULEPAR(2, "MODULEPAR", "MODULE_PAR"), /**
     * The '<em><b>TEMPLATE</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #TEMPLATE_VALUE
     * @generated
     * @ordered
     */
	TEMPLATE(3, "TEMPLATE", "TEMPLATE");

	/**
     * The '<em><b>TYPE</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #TYPE
     * @model
     * @generated
     * @ordered
     */
	public static final int TYPE_VALUE = 0;

	/**
     * The '<em><b>CONST</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Const</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #CONST
     * @model
     * @generated
     * @ordered
     */
	public static final int CONST_VALUE = 1;

	/**
     * The '<em><b>MODULEPAR</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODULEPAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #MODULEPAR
     * @model literal="MODULE_PAR"
     * @generated
     * @ordered
     */
	public static final int MODULEPAR_VALUE = 2;

	/**
     * The '<em><b>TEMPLATE</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Template</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #TEMPLATE
     * @model
     * @generated
     * @ordered
     */
	public static final int TEMPLATE_VALUE = 3;

	/**
     * An array of all the '<em><b>Module Element Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final ModuleElementType[] VALUES_ARRAY =
		new ModuleElementType[] {
            TYPE,
            CONST,
            MODULEPAR,
            TEMPLATE,
        };

	/**
     * A public read-only list of all the '<em><b>Module Element Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<ModuleElementType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Module Element Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ModuleElementType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ModuleElementType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Module Element Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ModuleElementType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ModuleElementType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Module Element Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ModuleElementType get(int value) {
        switch (value) {
            case TYPE_VALUE: return TYPE;
            case CONST_VALUE: return CONST;
            case MODULEPAR_VALUE: return MODULEPAR;
            case TEMPLATE_VALUE: return TEMPLATE;
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
	private ModuleElementType(int value, String name, String literal) {
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
	
} //ModuleElementType
