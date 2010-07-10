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

import com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmoduleFactory
 * @model kind="package"
 * @generated
 */
public interface FpbmodulePackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "fpbmodule";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://fpbmodule.model.lib.fpb.fineqt.com";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "fpbmodule";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	FpbmodulePackage eINSTANCE = com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl.init();

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.DocumentRootImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getDocumentRoot()
     * @generated
     */
	int DOCUMENT_ROOT = 0;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
     * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
     * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
     * The feature id for the '<em><b>PModule</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT__PMODULE = 3;

	/**
     * The number of structural features of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PStringTypeImpl <em>PString Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PStringTypeImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPStringType()
     * @generated
     */
	int PSTRING_TYPE = 60;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PBitstringImpl <em>PBitstring</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PBitstringImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPBitstring()
     * @generated
     */
	int PBITSTRING = 4;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PBooleanImpl <em>PBoolean</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PBooleanImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPBoolean()
     * @generated
     */
	int PBOOLEAN = 5;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PCharstringImpl <em>PCharstring</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PCharstringImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPCharstring()
     * @generated
     */
	int PCHARSTRING = 7;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PContainerTypeImpl <em>PContainer Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PContainerTypeImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPContainerType()
     * @generated
     */
	int PCONTAINER_TYPE = 12;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumeratedImpl <em>PEnumerated</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumeratedImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEnumerated()
     * @generated
     */
	int PENUMERATED = 19;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodedElementImpl <em>PEncoded Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodedElementImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEncodedElement()
     * @generated
     */
	int PENCODED_ELEMENT = 13;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODED_ELEMENT__ANNOTATIONS = FpbcommonPackage.PNAMED_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODED_ELEMENT__ATTATCHMENT = FpbcommonPackage.PNAMED_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODED_ELEMENT__NAME = FpbcommonPackage.PNAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODED_ELEMENT__VARIANT = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODED_ELEMENT__ENCODE = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODED_ELEMENT__TYPE_ENCODING_DESC = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODED_ELEMENT__TYPE_ENCODING_VARIANT_DESC = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODED_ELEMENT__TYPE_EXTENSION_DESC = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The number of structural features of the '<em>PEncoded Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODED_ELEMENT_FEATURE_COUNT = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodingVariantImpl <em>PEncoding Variant</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodingVariantImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEncodingVariant()
     * @generated
     */
	int PENCODING_VARIANT = 14;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PUnionImpl <em>PUnion</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PUnionImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPUnion()
     * @generated
     */
	int PUNION = 67;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PUniversalCharstringImpl <em>PUniversal Charstring</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PUniversalCharstringImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPUniversalCharstring()
     * @generated
     */
	int PUNIVERSAL_CHARSTRING = 68;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PVerdictImpl <em>PVerdict</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PVerdictImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPVerdict()
     * @generated
     */
	int PVERDICT = 70;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.ByteOrder <em>Byte Order</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.ByteOrder
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getByteOrder()
     * @generated
     */
	int BYTE_ORDER = 71;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeImpl <em>PType</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPType()
     * @generated
     */
	int PTYPE = 62;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__ANNOTATIONS = PENCODED_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__ATTATCHMENT = PENCODED_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__NAME = PENCODED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__VARIANT = PENCODED_ELEMENT__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__ENCODE = PENCODED_ELEMENT__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__TYPE_ENCODING_DESC = PENCODED_ELEMENT__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__TYPE_ENCODING_VARIANT_DESC = PENCODED_ELEMENT__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__TYPE_EXTENSION_DESC = PENCODED_ELEMENT__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__CONTAINER_TYPE = PENCODED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__DERIVATIVE_MODE = PENCODED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__JAVA_CLASS = PENCODED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__LIST_TYPE = PENCODED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__PRIMITIVE_TYPE = PENCODED_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__TYPE_CLASS = PENCODED_ELEMENT_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__TYPE_ID = PENCODED_ELEMENT_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE__PMODULE = PENCODED_ELEMENT_FEATURE_COUNT + 7;

	/**
     * The number of structural features of the '<em>PType</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_FEATURE_COUNT = PENCODED_ELEMENT_FEATURE_COUNT + 8;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityTypeImpl <em>PEntity Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityTypeImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEntityType()
     * @generated
     */
	int PENTITY_TYPE = 18;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__ANNOTATIONS = PTYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__ATTATCHMENT = PTYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__NAME = PTYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__VARIANT = PTYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__ENCODE = PTYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__TYPE_ENCODING_DESC = PTYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__TYPE_ENCODING_VARIANT_DESC = PTYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__TYPE_EXTENSION_DESC = PTYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__CONTAINER_TYPE = PTYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__DERIVATIVE_MODE = PTYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__JAVA_CLASS = PTYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__LIST_TYPE = PTYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__PRIMITIVE_TYPE = PTYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__TYPE_CLASS = PTYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__TYPE_ID = PTYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__PMODULE = PTYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE__CONSTRAINT = PTYPE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PEntity Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_TYPE_FEATURE_COUNT = PTYPE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PPrimitiveTypeImpl <em>PPrimitive Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PPrimitiveTypeImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPPrimitiveType()
     * @generated
     */
	int PPRIMITIVE_TYPE = 52;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__ANNOTATIONS = PENTITY_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__ATTATCHMENT = PENTITY_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__NAME = PENTITY_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__VARIANT = PENTITY_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__ENCODE = PENTITY_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__TYPE_ENCODING_DESC = PENTITY_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__TYPE_ENCODING_VARIANT_DESC = PENTITY_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__TYPE_EXTENSION_DESC = PENTITY_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__CONTAINER_TYPE = PENTITY_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__DERIVATIVE_MODE = PENTITY_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__JAVA_CLASS = PENTITY_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__LIST_TYPE = PENTITY_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__PRIMITIVE_TYPE = PENTITY_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__TYPE_CLASS = PENTITY_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__TYPE_ID = PENTITY_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__PMODULE = PENTITY_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE__CONSTRAINT = PENTITY_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>PPrimitive Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPRIMITIVE_TYPE_FEATURE_COUNT = PENTITY_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PAddressImpl <em>PAddress</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PAddressImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPAddress()
     * @generated
     */
	int PADDRESS = 1;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__ANNOTATIONS = PPRIMITIVE_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__ATTATCHMENT = PPRIMITIVE_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__NAME = PPRIMITIVE_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__VARIANT = PPRIMITIVE_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__ENCODE = PPRIMITIVE_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__TYPE_ENCODING_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__TYPE_ENCODING_VARIANT_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__TYPE_EXTENSION_DESC = PPRIMITIVE_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__CONTAINER_TYPE = PPRIMITIVE_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__DERIVATIVE_MODE = PPRIMITIVE_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__JAVA_CLASS = PPRIMITIVE_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__LIST_TYPE = PPRIMITIVE_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__PRIMITIVE_TYPE = PPRIMITIVE_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__TYPE_CLASS = PPRIMITIVE_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__TYPE_ID = PPRIMITIVE_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__PMODULE = PPRIMITIVE_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS__CONSTRAINT = PPRIMITIVE_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>PAddress</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PADDRESS_FEATURE_COUNT = PPRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PArgumentImpl <em>PArgument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PArgumentImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPArgument()
     * @generated
     */
	int PARGUMENT = 2;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARGUMENT__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARGUMENT__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
     * The number of structural features of the '<em>PArgument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARGUMENT_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PArgumentGroupImpl <em>PArgument Group</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PArgumentGroupImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPArgumentGroup()
     * @generated
     */
	int PARGUMENT_GROUP = 3;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARGUMENT_GROUP__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARGUMENT_GROUP__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARGUMENT_GROUP__ARGUMENTS = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PArgument Group</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARGUMENT_GROUP_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeEVImpl <em>PType EV</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeEVImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPTypeEV()
     * @generated
     */
	int PTYPE_EV = 65;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbTypeEVImpl <em>PFpb Type EV</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbTypeEVImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPFpbTypeEV()
     * @generated
     */
	int PFPB_TYPE_EV = 29;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__ANNOTATIONS = PPRIMITIVE_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__ATTATCHMENT = PPRIMITIVE_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__NAME = PPRIMITIVE_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__VARIANT = PPRIMITIVE_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__ENCODE = PPRIMITIVE_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__TYPE_ENCODING_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__TYPE_ENCODING_VARIANT_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__TYPE_EXTENSION_DESC = PPRIMITIVE_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__CONTAINER_TYPE = PPRIMITIVE_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__DERIVATIVE_MODE = PPRIMITIVE_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__JAVA_CLASS = PPRIMITIVE_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__LIST_TYPE = PPRIMITIVE_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__PRIMITIVE_TYPE = PPRIMITIVE_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__TYPE_CLASS = PPRIMITIVE_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__TYPE_ID = PPRIMITIVE_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__PMODULE = PPRIMITIVE_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE__CONSTRAINT = PPRIMITIVE_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>PString Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSTRING_TYPE_FEATURE_COUNT = PPRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__ANNOTATIONS = PSTRING_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__ATTATCHMENT = PSTRING_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__NAME = PSTRING_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__VARIANT = PSTRING_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__ENCODE = PSTRING_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__TYPE_ENCODING_DESC = PSTRING_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__TYPE_ENCODING_VARIANT_DESC = PSTRING_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__TYPE_EXTENSION_DESC = PSTRING_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__CONTAINER_TYPE = PSTRING_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__DERIVATIVE_MODE = PSTRING_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__JAVA_CLASS = PSTRING_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__LIST_TYPE = PSTRING_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__PRIMITIVE_TYPE = PSTRING_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__TYPE_CLASS = PSTRING_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__TYPE_ID = PSTRING_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__PMODULE = PSTRING_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING__CONSTRAINT = PSTRING_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>PBitstring</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBITSTRING_FEATURE_COUNT = PSTRING_TYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__ANNOTATIONS = PPRIMITIVE_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__ATTATCHMENT = PPRIMITIVE_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__NAME = PPRIMITIVE_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__VARIANT = PPRIMITIVE_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__ENCODE = PPRIMITIVE_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__TYPE_ENCODING_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__TYPE_ENCODING_VARIANT_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__TYPE_EXTENSION_DESC = PPRIMITIVE_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__CONTAINER_TYPE = PPRIMITIVE_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__DERIVATIVE_MODE = PPRIMITIVE_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__JAVA_CLASS = PPRIMITIVE_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__LIST_TYPE = PPRIMITIVE_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__PRIMITIVE_TYPE = PPRIMITIVE_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__TYPE_CLASS = PPRIMITIVE_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__TYPE_ID = PPRIMITIVE_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__PMODULE = PPRIMITIVE_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN__CONSTRAINT = PPRIMITIVE_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>PBoolean</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN_FEATURE_COUNT = PPRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PSingleArgumentImpl <em>PSingle Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PSingleArgumentImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPSingleArgument()
     * @generated
     */
	int PSINGLE_ARGUMENT = 59;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSINGLE_ARGUMENT__ANNOTATIONS = PARGUMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSINGLE_ARGUMENT__ATTATCHMENT = PARGUMENT__ATTATCHMENT;

	/**
     * The number of structural features of the '<em>PSingle Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSINGLE_ARGUMENT_FEATURE_COUNT = PARGUMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PBooleanArgumentImpl <em>PBoolean Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PBooleanArgumentImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPBooleanArgument()
     * @generated
     */
	int PBOOLEAN_ARGUMENT = 6;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN_ARGUMENT__ANNOTATIONS = PSINGLE_ARGUMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN_ARGUMENT__ATTATCHMENT = PSINGLE_ARGUMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN_ARGUMENT__DESC = PSINGLE_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PBoolean Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PBOOLEAN_ARGUMENT_FEATURE_COUNT = PSINGLE_ARGUMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__ANNOTATIONS = PSTRING_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__ATTATCHMENT = PSTRING_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__NAME = PSTRING_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__VARIANT = PSTRING_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__ENCODE = PSTRING_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__TYPE_ENCODING_DESC = PSTRING_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__TYPE_ENCODING_VARIANT_DESC = PSTRING_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__TYPE_EXTENSION_DESC = PSTRING_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__CONTAINER_TYPE = PSTRING_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__DERIVATIVE_MODE = PSTRING_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__JAVA_CLASS = PSTRING_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__LIST_TYPE = PSTRING_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__PRIMITIVE_TYPE = PSTRING_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__TYPE_CLASS = PSTRING_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__TYPE_ID = PSTRING_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__PMODULE = PSTRING_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING__CONSTRAINT = PSTRING_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>PCharstring</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING_FEATURE_COUNT = PSTRING_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PCharstringArgumentImpl <em>PCharstring Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PCharstringArgumentImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPCharstringArgument()
     * @generated
     */
	int PCHARSTRING_ARGUMENT = 8;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING_ARGUMENT__ANNOTATIONS = PSINGLE_ARGUMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING_ARGUMENT__ATTATCHMENT = PSINGLE_ARGUMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING_ARGUMENT__DESC = PSINGLE_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PCharstring Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCHARSTRING_ARGUMENT_FEATURE_COUNT = PSINGLE_ARGUMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeConstraintImpl <em>PType Constraint</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeConstraintImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPTypeConstraint()
     * @generated
     */
	int PTYPE_CONSTRAINT = 63;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_CONSTRAINT__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_CONSTRAINT__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
     * The number of structural features of the '<em>PType Constraint</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_CONSTRAINT_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PCompoundConstraintImpl <em>PCompound Constraint</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PCompoundConstraintImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPCompoundConstraint()
     * @generated
     */
	int PCOMPOUND_CONSTRAINT = 9;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCOMPOUND_CONSTRAINT__ANNOTATIONS = PTYPE_CONSTRAINT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCOMPOUND_CONSTRAINT__ATTATCHMENT = PTYPE_CONSTRAINT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Children</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCOMPOUND_CONSTRAINT__CHILDREN = PTYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PCompound Constraint</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCOMPOUND_CONSTRAINT_FEATURE_COUNT = PTYPE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PConditionArgumentImpl <em>PCondition Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PConditionArgumentImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPConditionArgument()
     * @generated
     */
	int PCONDITION_ARGUMENT = 10;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONDITION_ARGUMENT__ANNOTATIONS = PSINGLE_ARGUMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONDITION_ARGUMENT__ATTATCHMENT = PSINGLE_ARGUMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONDITION_ARGUMENT__CONDITION = PSINGLE_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONDITION_ARGUMENT__TYPE_NAME = PSINGLE_ARGUMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>PCondition Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONDITION_ARGUMENT_FEATURE_COUNT = PSINGLE_ARGUMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PConstantImpl <em>PConstant</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PConstantImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPConstant()
     * @generated
     */
	int PCONSTANT = 11;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONSTANT__ANNOTATIONS = FpbcommonPackage.PNAMED_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONSTANT__ATTATCHMENT = FpbcommonPackage.PNAMED_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONSTANT__NAME = FpbcommonPackage.PNAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Constant ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONSTANT__CONSTANT_ID = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONSTANT__PMODULE = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>PConstant</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONSTANT_FEATURE_COUNT = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__ANNOTATIONS = PENTITY_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__ATTATCHMENT = PENTITY_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__NAME = PENTITY_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__VARIANT = PENTITY_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__ENCODE = PENTITY_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__TYPE_ENCODING_DESC = PENTITY_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__TYPE_ENCODING_VARIANT_DESC = PENTITY_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__TYPE_EXTENSION_DESC = PENTITY_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__CONTAINER_TYPE = PENTITY_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__DERIVATIVE_MODE = PENTITY_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__JAVA_CLASS = PENTITY_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__LIST_TYPE = PENTITY_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__PRIMITIVE_TYPE = PENTITY_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__TYPE_CLASS = PENTITY_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__TYPE_ID = PENTITY_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__PMODULE = PENTITY_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__CONSTRAINT = PENTITY_TYPE__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Pfields</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE__PFIELDS = PENTITY_TYPE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PContainer Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PCONTAINER_TYPE_FEATURE_COUNT = PENTITY_TYPE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODING_VARIANT__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODING_VARIANT__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Encoded Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODING_VARIANT__ENCODED_ELEMENT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PEncoding Variant</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENCODING_VARIANT_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityConstantImpl <em>PEntity Constant</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityConstantImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEntityConstant()
     * @generated
     */
	int PENTITY_CONSTANT = 15;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_CONSTANT__ANNOTATIONS = PCONSTANT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_CONSTANT__ATTATCHMENT = PCONSTANT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_CONSTANT__NAME = PCONSTANT__NAME;

	/**
     * The feature id for the '<em><b>Constant ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_CONSTANT__CONSTANT_ID = PCONSTANT__CONSTANT_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_CONSTANT__PMODULE = PCONSTANT__PMODULE;

	/**
     * The feature id for the '<em><b>Matcher</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_CONSTANT__MATCHER = PCONSTANT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Base Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_CONSTANT__BASE_TYPE_NAME = PCONSTANT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>PEntity Constant</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_CONSTANT_FEATURE_COUNT = PCONSTANT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleParImpl <em>PModule Par</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleParImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPModulePar()
     * @generated
     */
	int PMODULE_PAR = 48;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityModuleParImpl <em>PEntity Module Par</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityModuleParImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEntityModulePar()
     * @generated
     */
	int PENTITY_MODULE_PAR = 17;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumeratedItemImpl <em>PEnumerated Item</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumeratedItemImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEnumeratedItem()
     * @generated
     */
	int PENUMERATED_ITEM = 20;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumItemImpl <em>PEnum Item</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumItemImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEnumItem()
     * @generated
     */
	int PENUM_ITEM = 21;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumSetImpl <em>PEnum Set</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumSetImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEnumSet()
     * @generated
     */
	int PENUM_SET = 22;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUM_SET__ANNOTATIONS = FpbcommonPackage.PNAMED_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUM_SET__ATTATCHMENT = FpbcommonPackage.PNAMED_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUM_SET__NAME = FpbcommonPackage.PNAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Enum Set ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUM_SET__ENUM_SET_ID = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUM_SET__PMODULE = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>PEnum Set</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUM_SET_FEATURE_COUNT = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityEnumSetImpl <em>PEntity Enum Set</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityEnumSetImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEntityEnumSet()
     * @generated
     */
	int PENTITY_ENUM_SET = 16;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_ENUM_SET__ANNOTATIONS = PENUM_SET__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_ENUM_SET__ATTATCHMENT = PENUM_SET__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_ENUM_SET__NAME = PENUM_SET__NAME;

	/**
     * The feature id for the '<em><b>Enum Set ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_ENUM_SET__ENUM_SET_ID = PENUM_SET__ENUM_SET_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_ENUM_SET__PMODULE = PENUM_SET__PMODULE;

	/**
     * The feature id for the '<em><b>Enum Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_ENUM_SET__ENUM_ITEMS = PENUM_SET_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Base Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_ENUM_SET__BASE_TYPE_NAME = PENUM_SET_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>PEntity Enum Set</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_ENUM_SET_FEATURE_COUNT = PENUM_SET_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE_PAR__ANNOTATIONS = FpbcommonPackage.PNAMED_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE_PAR__ATTATCHMENT = FpbcommonPackage.PNAMED_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE_PAR__NAME = FpbcommonPackage.PNAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Module Par ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE_PAR__MODULE_PAR_ID = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE_PAR__PMODULE = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>PModule Par</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE_PAR_FEATURE_COUNT = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_MODULE_PAR__ANNOTATIONS = PMODULE_PAR__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_MODULE_PAR__ATTATCHMENT = PMODULE_PAR__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_MODULE_PAR__NAME = PMODULE_PAR__NAME;

	/**
     * The feature id for the '<em><b>Module Par ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_MODULE_PAR__MODULE_PAR_ID = PMODULE_PAR__MODULE_PAR_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_MODULE_PAR__PMODULE = PMODULE_PAR__PMODULE;

	/**
     * The feature id for the '<em><b>Matcher</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_MODULE_PAR__MATCHER = PMODULE_PAR_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Base Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_MODULE_PAR__BASE_TYPE_NAME = PMODULE_PAR_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Thread</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_MODULE_PAR__THREAD = PMODULE_PAR_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>PEntity Module Par</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENTITY_MODULE_PAR_FEATURE_COUNT = PMODULE_PAR_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__ANNOTATIONS = PPRIMITIVE_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__ATTATCHMENT = PPRIMITIVE_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__NAME = PPRIMITIVE_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__VARIANT = PPRIMITIVE_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__ENCODE = PPRIMITIVE_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__TYPE_ENCODING_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__TYPE_ENCODING_VARIANT_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__TYPE_EXTENSION_DESC = PPRIMITIVE_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__CONTAINER_TYPE = PPRIMITIVE_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__DERIVATIVE_MODE = PPRIMITIVE_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__JAVA_CLASS = PPRIMITIVE_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__LIST_TYPE = PPRIMITIVE_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__PRIMITIVE_TYPE = PPRIMITIVE_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__TYPE_CLASS = PPRIMITIVE_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__TYPE_ID = PPRIMITIVE_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__PMODULE = PPRIMITIVE_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__CONSTRAINT = PPRIMITIVE_TYPE__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED__ITEMS = PPRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PEnumerated</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED_FEATURE_COUNT = PPRIMITIVE_TYPE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED_ITEM__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED_ITEM__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Enum Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED_ITEM__ENUM_NAME = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Enum Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED_ITEM__ENUM_VALUE = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>PEnumerated Item</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUMERATED_ITEM_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUM_ITEM__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUM_ITEM__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Cond</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUM_ITEM__COND = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUM_ITEM__NAME = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>PEnum Item</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PENUM_ITEM_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypedElementImpl <em>PTyped Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PTypedElementImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPTypedElement()
     * @generated
     */
	int PTYPED_ELEMENT = 64;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPED_ELEMENT__ANNOTATIONS = PENCODED_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPED_ELEMENT__ATTATCHMENT = PENCODED_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPED_ELEMENT__NAME = PENCODED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPED_ELEMENT__VARIANT = PENCODED_ELEMENT__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPED_ELEMENT__ENCODE = PENCODED_ELEMENT__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPED_ELEMENT__TYPE_ENCODING_DESC = PENCODED_ELEMENT__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPED_ELEMENT__TYPE_ENCODING_VARIANT_DESC = PENCODED_ELEMENT__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPED_ELEMENT__TYPE_EXTENSION_DESC = PENCODED_ELEMENT__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Ptype</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPED_ELEMENT__PTYPE = PENCODED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Ptype Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPED_ELEMENT__PTYPE_NAME = PENCODED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>PTyped Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPED_ELEMENT_FEATURE_COUNT = PENCODED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PItemFieldImpl <em>PItem Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PItemFieldImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPItemField()
     * @generated
     */
    int PITEM_FIELD = 39;

    /**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__ANNOTATIONS = PTYPED_ELEMENT__ANNOTATIONS;

    /**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__ATTATCHMENT = PTYPED_ELEMENT__ATTATCHMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__NAME = PTYPED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__VARIANT = PTYPED_ELEMENT__VARIANT;

    /**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__ENCODE = PTYPED_ELEMENT__ENCODE;

    /**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__TYPE_ENCODING_DESC = PTYPED_ELEMENT__TYPE_ENCODING_DESC;

    /**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__TYPE_ENCODING_VARIANT_DESC = PTYPED_ELEMENT__TYPE_ENCODING_VARIANT_DESC;

    /**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__TYPE_EXTENSION_DESC = PTYPED_ELEMENT__TYPE_EXTENSION_DESC;

    /**
     * The feature id for the '<em><b>Ptype</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__PTYPE = PTYPED_ELEMENT__PTYPE;

    /**
     * The feature id for the '<em><b>Ptype Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__PTYPE_NAME = PTYPED_ELEMENT__PTYPE_NAME;

    /**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__CONSTRAINT = PTYPED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Enum Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__ENUM_ITEMS = PTYPED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Enum Ref</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD__ENUM_REF = PTYPED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>PItem Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PITEM_FIELD_FEATURE_COUNT = PTYPED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFieldImpl <em>PField</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFieldImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPField()
     * @generated
     */
	int PFIELD = 23;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__ANNOTATIONS = PITEM_FIELD__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__ATTATCHMENT = PITEM_FIELD__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__NAME = PITEM_FIELD__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__VARIANT = PITEM_FIELD__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__ENCODE = PITEM_FIELD__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__TYPE_ENCODING_DESC = PITEM_FIELD__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__TYPE_ENCODING_VARIANT_DESC = PITEM_FIELD__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__TYPE_EXTENSION_DESC = PITEM_FIELD__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Ptype</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__PTYPE = PITEM_FIELD__PTYPE;

	/**
     * The feature id for the '<em><b>Ptype Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__PTYPE_NAME = PITEM_FIELD__PTYPE_NAME;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__CONSTRAINT = PITEM_FIELD__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Enum Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__ENUM_ITEMS = PITEM_FIELD__ENUM_ITEMS;

	/**
     * The feature id for the '<em><b>Enum Ref</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__ENUM_REF = PITEM_FIELD__ENUM_REF;

	/**
     * The feature id for the '<em><b>Field ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__FIELD_ID = PITEM_FIELD_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Optional</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD__OPTIONAL = PITEM_FIELD_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>PField</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD_FEATURE_COUNT = PITEM_FIELD_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFieldEVImpl <em>PField EV</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFieldEVImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPFieldEV()
     * @generated
     */
	int PFIELD_EV = 24;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD_EV__ANNOTATIONS = PENCODING_VARIANT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD_EV__ATTATCHMENT = PENCODING_VARIANT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Encoded Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD_EV__ENCODED_ELEMENT = PENCODING_VARIANT__ENCODED_ELEMENT;

	/**
     * The feature id for the '<em><b>Prp List</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD_EV__PRP_LIST = PENCODING_VARIANT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PField EV</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFIELD_EV_FEATURE_COUNT = PENCODING_VARIANT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFloatImpl <em>PFloat</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFloatImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPFloat()
     * @generated
     */
	int PFLOAT = 25;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__ANNOTATIONS = PPRIMITIVE_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__ATTATCHMENT = PPRIMITIVE_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__NAME = PPRIMITIVE_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__VARIANT = PPRIMITIVE_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__ENCODE = PPRIMITIVE_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__TYPE_ENCODING_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__TYPE_ENCODING_VARIANT_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__TYPE_EXTENSION_DESC = PPRIMITIVE_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__CONTAINER_TYPE = PPRIMITIVE_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__DERIVATIVE_MODE = PPRIMITIVE_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__JAVA_CLASS = PPRIMITIVE_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__LIST_TYPE = PPRIMITIVE_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__PRIMITIVE_TYPE = PPRIMITIVE_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__TYPE_CLASS = PPRIMITIVE_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__TYPE_ID = PPRIMITIVE_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__PMODULE = PPRIMITIVE_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT__CONSTRAINT = PPRIMITIVE_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>PFloat</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFLOAT_FEATURE_COUNT = PPRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbFieldEVImpl <em>PFpb Field EV</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbFieldEVImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPFpbFieldEV()
     * @generated
     */
	int PFPB_FIELD_EV = 26;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_FIELD_EV__ANNOTATIONS = PFIELD_EV__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_FIELD_EV__ATTATCHMENT = PFIELD_EV__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Encoded Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_FIELD_EV__ENCODED_ELEMENT = PFIELD_EV__ENCODED_ELEMENT;

	/**
     * The feature id for the '<em><b>Prp List</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_FIELD_EV__PRP_LIST = PFIELD_EV__PRP_LIST;

	/**
     * The number of structural features of the '<em>PFpb Field EV</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_FIELD_EV_FEATURE_COUNT = PFIELD_EV_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PListItemEVImpl <em>PList Item EV</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PListItemEVImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPListItemEV()
     * @generated
     */
	int PLIST_ITEM_EV = 44;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM_EV__ANNOTATIONS = PENCODING_VARIANT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM_EV__ATTATCHMENT = PENCODING_VARIANT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Encoded Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM_EV__ENCODED_ELEMENT = PENCODING_VARIANT__ENCODED_ELEMENT;

	/**
     * The feature id for the '<em><b>Prp List</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM_EV__PRP_LIST = PENCODING_VARIANT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PList Item EV</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM_EV_FEATURE_COUNT = PENCODING_VARIANT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbListItemEVImpl <em>PFpb List Item EV</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbListItemEVImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPFpbListItemEV()
     * @generated
     */
	int PFPB_LIST_ITEM_EV = 27;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_LIST_ITEM_EV__ANNOTATIONS = PLIST_ITEM_EV__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_LIST_ITEM_EV__ATTATCHMENT = PLIST_ITEM_EV__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Encoded Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_LIST_ITEM_EV__ENCODED_ELEMENT = PLIST_ITEM_EV__ENCODED_ELEMENT;

	/**
     * The feature id for the '<em><b>Prp List</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_LIST_ITEM_EV__PRP_LIST = PLIST_ITEM_EV__PRP_LIST;

	/**
     * The number of structural features of the '<em>PFpb List Item EV</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_LIST_ITEM_EV_FEATURE_COUNT = PLIST_ITEM_EV_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PHexstringImpl <em>PHexstring</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PHexstringImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPHexstring()
     * @generated
     */
	int PHEXSTRING = 30;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PIntegerImpl <em>PInteger</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PIntegerImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPInteger()
     * @generated
     */
	int PINTEGER = 37;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PListTypeImpl <em>PList Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PListTypeImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPListType()
     * @generated
     */
	int PLIST_TYPE = 45;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl <em>PModule</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPModule()
     * @generated
     */
	int PMODULE = 46;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleEVImpl <em>PModule EV</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleEVImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPModuleEV()
     * @generated
     */
	int PMODULE_EV = 47;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE_EV__ANNOTATIONS = PENCODING_VARIANT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE_EV__ATTATCHMENT = PENCODING_VARIANT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Encoded Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE_EV__ENCODED_ELEMENT = PENCODING_VARIANT__ENCODED_ELEMENT;

	/**
     * The feature id for the '<em><b>Prp List</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE_EV__PRP_LIST = PENCODING_VARIANT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PModule EV</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE_EV_FEATURE_COUNT = PENCODING_VARIANT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbModuleEVImpl <em>PFpb Module EV</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbModuleEVImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPFpbModuleEV()
     * @generated
     */
	int PFPB_MODULE_EV = 28;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_MODULE_EV__ANNOTATIONS = PMODULE_EV__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_MODULE_EV__ATTATCHMENT = PMODULE_EV__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Encoded Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_MODULE_EV__ENCODED_ELEMENT = PMODULE_EV__ENCODED_ELEMENT;

	/**
     * The feature id for the '<em><b>Prp List</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_MODULE_EV__PRP_LIST = PMODULE_EV__PRP_LIST;

	/**
     * The number of structural features of the '<em>PFpb Module EV</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_MODULE_EV_FEATURE_COUNT = PMODULE_EV_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_EV__ANNOTATIONS = PENCODING_VARIANT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_EV__ATTATCHMENT = PENCODING_VARIANT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Encoded Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_EV__ENCODED_ELEMENT = PENCODING_VARIANT__ENCODED_ELEMENT;

	/**
     * The feature id for the '<em><b>Prp List</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_EV__PRP_LIST = PENCODING_VARIANT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PType EV</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_EV_FEATURE_COUNT = PENCODING_VARIANT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_TYPE_EV__ANNOTATIONS = PTYPE_EV__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_TYPE_EV__ATTATCHMENT = PTYPE_EV__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Encoded Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_TYPE_EV__ENCODED_ELEMENT = PTYPE_EV__ENCODED_ELEMENT;

	/**
     * The feature id for the '<em><b>Prp List</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_TYPE_EV__PRP_LIST = PTYPE_EV__PRP_LIST;

	/**
     * The number of structural features of the '<em>PFpb Type EV</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PFPB_TYPE_EV_FEATURE_COUNT = PTYPE_EV_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__ANNOTATIONS = PSTRING_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__ATTATCHMENT = PSTRING_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__NAME = PSTRING_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__VARIANT = PSTRING_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__ENCODE = PSTRING_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__TYPE_ENCODING_DESC = PSTRING_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__TYPE_ENCODING_VARIANT_DESC = PSTRING_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__TYPE_EXTENSION_DESC = PSTRING_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__CONTAINER_TYPE = PSTRING_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__DERIVATIVE_MODE = PSTRING_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__JAVA_CLASS = PSTRING_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__LIST_TYPE = PSTRING_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__PRIMITIVE_TYPE = PSTRING_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__TYPE_CLASS = PSTRING_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__TYPE_ID = PSTRING_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__PMODULE = PSTRING_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING__CONSTRAINT = PSTRING_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>PHexstring</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PHEXSTRING_FEATURE_COUNT = PSTRING_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PIdentifierArgumentImpl <em>PIdentifier Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PIdentifierArgumentImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPIdentifierArgument()
     * @generated
     */
	int PIDENTIFIER_ARGUMENT = 31;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIDENTIFIER_ARGUMENT__ANNOTATIONS = PSINGLE_ARGUMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIDENTIFIER_ARGUMENT__ATTATCHMENT = PSINGLE_ARGUMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIDENTIFIER_ARGUMENT__DESC = PSINGLE_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PIdentifier Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIDENTIFIER_ARGUMENT_FEATURE_COUNT = PSINGLE_ARGUMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportConstantImpl <em>PImport Constant</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PImportConstantImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPImportConstant()
     * @generated
     */
	int PIMPORT_CONSTANT = 32;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_CONSTANT__ANNOTATIONS = PCONSTANT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_CONSTANT__ATTATCHMENT = PCONSTANT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_CONSTANT__NAME = PCONSTANT__NAME;

	/**
     * The feature id for the '<em><b>Constant ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_CONSTANT__CONSTANT_ID = PCONSTANT__CONSTANT_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_CONSTANT__PMODULE = PCONSTANT__PMODULE;

	/**
     * The feature id for the '<em><b>Imported Constant</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_CONSTANT__IMPORTED_CONSTANT = PCONSTANT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Imported Constant Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_CONSTANT__IMPORTED_CONSTANT_NAME = PCONSTANT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Imported Module Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_CONSTANT__IMPORTED_MODULE_NAME = PCONSTANT_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>PImport Constant</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_CONSTANT_FEATURE_COUNT = PCONSTANT_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportElementImpl <em>PImport Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PImportElementImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPImportElement()
     * @generated
     */
	int PIMPORT_ELEMENT = 33;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ELEMENT__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ELEMENT__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Ref Name List</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ELEMENT__REF_NAME_LIST = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>All Except</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ELEMENT__ALL_EXCEPT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Element Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ELEMENT__ELEMENT_TYPE = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>From Module Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ELEMENT__FROM_MODULE_NAME = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ELEMENT__PMODULE = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The number of structural features of the '<em>PImport Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ELEMENT_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportEnumSetImpl <em>PImport Enum Set</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PImportEnumSetImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPImportEnumSet()
     * @generated
     */
	int PIMPORT_ENUM_SET = 34;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ENUM_SET__ANNOTATIONS = PENUM_SET__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ENUM_SET__ATTATCHMENT = PENUM_SET__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ENUM_SET__NAME = PENUM_SET__NAME;

	/**
     * The feature id for the '<em><b>Enum Set ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ENUM_SET__ENUM_SET_ID = PENUM_SET__ENUM_SET_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ENUM_SET__PMODULE = PENUM_SET__PMODULE;

	/**
     * The feature id for the '<em><b>Imported Enum Set</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ENUM_SET__IMPORTED_ENUM_SET = PENUM_SET_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Imported Enum Set Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ENUM_SET__IMPORTED_ENUM_SET_NAME = PENUM_SET_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Imported Module Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ENUM_SET__IMPORTED_MODULE_NAME = PENUM_SET_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>PImport Enum Set</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_ENUM_SET_FEATURE_COUNT = PENUM_SET_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportModuleParImpl <em>PImport Module Par</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PImportModuleParImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPImportModulePar()
     * @generated
     */
	int PIMPORT_MODULE_PAR = 35;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_MODULE_PAR__ANNOTATIONS = PMODULE_PAR__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_MODULE_PAR__ATTATCHMENT = PMODULE_PAR__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_MODULE_PAR__NAME = PMODULE_PAR__NAME;

	/**
     * The feature id for the '<em><b>Module Par ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_MODULE_PAR__MODULE_PAR_ID = PMODULE_PAR__MODULE_PAR_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_MODULE_PAR__PMODULE = PMODULE_PAR__PMODULE;

	/**
     * The feature id for the '<em><b>Imported Module Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_MODULE_PAR__IMPORTED_MODULE_NAME = PMODULE_PAR_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Imported Module Par</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_MODULE_PAR__IMPORTED_MODULE_PAR = PMODULE_PAR_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Imported Module Part Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_MODULE_PAR__IMPORTED_MODULE_PART_NAME = PMODULE_PAR_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>PImport Module Par</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_MODULE_PAR_FEATURE_COUNT = PMODULE_PAR_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportTypeImpl <em>PImport Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PImportTypeImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPImportType()
     * @generated
     */
	int PIMPORT_TYPE = 36;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__ANNOTATIONS = PTYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__ATTATCHMENT = PTYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__NAME = PTYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__VARIANT = PTYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__ENCODE = PTYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__TYPE_ENCODING_DESC = PTYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__TYPE_ENCODING_VARIANT_DESC = PTYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__TYPE_EXTENSION_DESC = PTYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__CONTAINER_TYPE = PTYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__DERIVATIVE_MODE = PTYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__JAVA_CLASS = PTYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__LIST_TYPE = PTYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__PRIMITIVE_TYPE = PTYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__TYPE_CLASS = PTYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__TYPE_ID = PTYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__PMODULE = PTYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Imported Module Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__IMPORTED_MODULE_NAME = PTYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Imported Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__IMPORTED_TYPE = PTYPE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Imported Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE__IMPORTED_TYPE_NAME = PTYPE_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>PImport Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PIMPORT_TYPE_FEATURE_COUNT = PTYPE_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__ANNOTATIONS = PPRIMITIVE_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__ATTATCHMENT = PPRIMITIVE_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__NAME = PPRIMITIVE_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__VARIANT = PPRIMITIVE_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__ENCODE = PPRIMITIVE_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__TYPE_ENCODING_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__TYPE_ENCODING_VARIANT_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__TYPE_EXTENSION_DESC = PPRIMITIVE_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__CONTAINER_TYPE = PPRIMITIVE_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__DERIVATIVE_MODE = PPRIMITIVE_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__JAVA_CLASS = PPRIMITIVE_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__LIST_TYPE = PPRIMITIVE_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__PRIMITIVE_TYPE = PPRIMITIVE_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__TYPE_CLASS = PPRIMITIVE_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__TYPE_ID = PPRIMITIVE_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__PMODULE = PPRIMITIVE_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER__CONSTRAINT = PPRIMITIVE_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>PInteger</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER_FEATURE_COUNT = PPRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PIntegerArgumentImpl <em>PInteger Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PIntegerArgumentImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPIntegerArgument()
     * @generated
     */
	int PINTEGER_ARGUMENT = 38;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER_ARGUMENT__ANNOTATIONS = PSINGLE_ARGUMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER_ARGUMENT__ATTATCHMENT = PSINGLE_ARGUMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER_ARGUMENT__DESC = PSINGLE_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PInteger Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PINTEGER_ARGUMENT_FEATURE_COUNT = PSINGLE_ARGUMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PLengthConstraintImpl <em>PLength Constraint</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PLengthConstraintImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPLengthConstraint()
     * @generated
     */
	int PLENGTH_CONSTRAINT = 40;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLENGTH_CONSTRAINT__ANNOTATIONS = PTYPE_CONSTRAINT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLENGTH_CONSTRAINT__ATTATCHMENT = PTYPE_CONSTRAINT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Lower Bound</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLENGTH_CONSTRAINT__LOWER_BOUND = PTYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Upper Bound</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLENGTH_CONSTRAINT__UPPER_BOUND = PTYPE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>PLength Constraint</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLENGTH_CONSTRAINT_FEATURE_COUNT = PTYPE_CONSTRAINT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PListArgumentImpl <em>PList Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PListArgumentImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPListArgument()
     * @generated
     */
	int PLIST_ARGUMENT = 41;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ARGUMENT__ANNOTATIONS = PARGUMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ARGUMENT__ATTATCHMENT = PARGUMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Group</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ARGUMENT__GROUP = PARGUMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PList Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ARGUMENT_FEATURE_COUNT = PARGUMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PListConstraintImpl <em>PList Constraint</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PListConstraintImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPListConstraint()
     * @generated
     */
	int PLIST_CONSTRAINT = 42;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_CONSTRAINT__ANNOTATIONS = PTYPE_CONSTRAINT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_CONSTRAINT__ATTATCHMENT = PTYPE_CONSTRAINT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Matcher</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_CONSTRAINT__MATCHER = PTYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PList Constraint</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_CONSTRAINT_FEATURE_COUNT = PTYPE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PListItemImpl <em>PList Item</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PListItemImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPListItem()
     * @generated
     */
	int PLIST_ITEM = 43;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__ANNOTATIONS = PITEM_FIELD__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__ATTATCHMENT = PITEM_FIELD__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__NAME = PITEM_FIELD__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__VARIANT = PITEM_FIELD__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__ENCODE = PITEM_FIELD__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__TYPE_ENCODING_DESC = PITEM_FIELD__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__TYPE_ENCODING_VARIANT_DESC = PITEM_FIELD__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__TYPE_EXTENSION_DESC = PITEM_FIELD__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Ptype</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__PTYPE = PITEM_FIELD__PTYPE;

	/**
     * The feature id for the '<em><b>Ptype Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__PTYPE_NAME = PITEM_FIELD__PTYPE_NAME;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__CONSTRAINT = PITEM_FIELD__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Enum Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__ENUM_ITEMS = PITEM_FIELD__ENUM_ITEMS;

	/**
     * The feature id for the '<em><b>Enum Ref</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM__ENUM_REF = PITEM_FIELD__ENUM_REF;

	/**
     * The number of structural features of the '<em>PList Item</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_ITEM_FEATURE_COUNT = PITEM_FIELD_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__ANNOTATIONS = PENTITY_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__ATTATCHMENT = PENTITY_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__NAME = PENTITY_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__VARIANT = PENTITY_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__ENCODE = PENTITY_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__TYPE_ENCODING_DESC = PENTITY_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__TYPE_ENCODING_VARIANT_DESC = PENTITY_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__TYPE_EXTENSION_DESC = PENTITY_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__CONTAINER_TYPE = PENTITY_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__DERIVATIVE_MODE = PENTITY_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__JAVA_CLASS = PENTITY_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__LIST_TYPE = PENTITY_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__PRIMITIVE_TYPE = PENTITY_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__TYPE_CLASS = PENTITY_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__TYPE_ID = PENTITY_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__PMODULE = PENTITY_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__CONSTRAINT = PENTITY_TYPE__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE__ITEM = PENTITY_TYPE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PList Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLIST_TYPE_FEATURE_COUNT = PENTITY_TYPE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__ANNOTATIONS = PENCODED_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__ATTATCHMENT = PENCODED_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__NAME = PENCODED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__VARIANT = PENCODED_ELEMENT__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__ENCODE = PENCODED_ELEMENT__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__TYPE_ENCODING_DESC = PENCODED_ELEMENT__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__TYPE_ENCODING_VARIANT_DESC = PENCODED_ELEMENT__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__TYPE_EXTENSION_DESC = PENCODED_ELEMENT__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Import Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__IMPORT_ELEMENTS = PENCODED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Types</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__TYPES = PENCODED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Constants</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__CONSTANTS = PENCODED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Templates</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__TEMPLATES = PENCODED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Module Pars</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__MODULE_PARS = PENCODED_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Enum Sets</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__ENUM_SETS = PENCODED_ELEMENT_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Factory Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__FACTORY_JAVA_CLASS = PENCODED_ELEMENT_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>Module Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__MODULE_JAVA_CLASS = PENCODED_ELEMENT_FEATURE_COUNT + 7;

	/**
     * The feature id for the '<em><b>Type Ev Factory Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE__TYPE_EV_FACTORY_JAVA_CLASS = PENCODED_ELEMENT_FEATURE_COUNT + 8;

	/**
     * The number of structural features of the '<em>PModule</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PMODULE_FEATURE_COUNT = PENCODED_ELEMENT_FEATURE_COUNT + 9;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PObjidImpl <em>PObjid</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PObjidImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPObjid()
     * @generated
     */
	int POBJID = 49;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__ANNOTATIONS = PPRIMITIVE_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__ATTATCHMENT = PPRIMITIVE_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__NAME = PPRIMITIVE_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__VARIANT = PPRIMITIVE_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__ENCODE = PPRIMITIVE_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__TYPE_ENCODING_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__TYPE_ENCODING_VARIANT_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__TYPE_EXTENSION_DESC = PPRIMITIVE_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__CONTAINER_TYPE = PPRIMITIVE_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__DERIVATIVE_MODE = PPRIMITIVE_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__JAVA_CLASS = PPRIMITIVE_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__LIST_TYPE = PPRIMITIVE_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__PRIMITIVE_TYPE = PPRIMITIVE_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__TYPE_CLASS = PPRIMITIVE_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__TYPE_ID = PPRIMITIVE_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__PMODULE = PPRIMITIVE_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID__CONSTRAINT = PPRIMITIVE_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>PObjid</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POBJID_FEATURE_COUNT = PPRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.POctetstringImpl <em>POctetstring</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.POctetstringImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPOctetstring()
     * @generated
     */
	int POCTETSTRING = 50;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__ANNOTATIONS = PSTRING_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__ATTATCHMENT = PSTRING_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__NAME = PSTRING_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__VARIANT = PSTRING_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__ENCODE = PSTRING_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__TYPE_ENCODING_DESC = PSTRING_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__TYPE_ENCODING_VARIANT_DESC = PSTRING_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__TYPE_EXTENSION_DESC = PSTRING_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__CONTAINER_TYPE = PSTRING_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__DERIVATIVE_MODE = PSTRING_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__JAVA_CLASS = PSTRING_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__LIST_TYPE = PSTRING_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__PRIMITIVE_TYPE = PSTRING_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__TYPE_CLASS = PSTRING_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__TYPE_ID = PSTRING_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__PMODULE = PSTRING_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING__CONSTRAINT = PSTRING_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>POctetstring</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POCTETSTRING_FEATURE_COUNT = PSTRING_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PPatternConstraintImpl <em>PPattern Constraint</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PPatternConstraintImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPPatternConstraint()
     * @generated
     */
	int PPATTERN_CONSTRAINT = 51;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPATTERN_CONSTRAINT__ANNOTATIONS = PTYPE_CONSTRAINT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPATTERN_CONSTRAINT__ATTATCHMENT = PTYPE_CONSTRAINT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Matcher</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPATTERN_CONSTRAINT__MATCHER = PTYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PPattern Constraint</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPATTERN_CONSTRAINT_FEATURE_COUNT = PTYPE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PPropertyImpl <em>PProperty</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PPropertyImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPProperty()
     * @generated
     */
	int PPROPERTY = 53;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPROPERTY__ANNOTATIONS = FpbcommonPackage.PNAMED_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPROPERTY__ATTATCHMENT = FpbcommonPackage.PNAMED_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPROPERTY__NAME = FpbcommonPackage.PNAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPROPERTY__GROUPS = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PProperty</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPROPERTY_FEATURE_COUNT = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PPropertyListImpl <em>PProperty List</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PPropertyListImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPPropertyList()
     * @generated
     */
	int PPROPERTY_LIST = 54;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPROPERTY_LIST__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPROPERTY_LIST__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPROPERTY_LIST__PROPERTIES = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PProperty List</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PPROPERTY_LIST_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PRecordImpl <em>PRecord</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PRecordImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPRecord()
     * @generated
     */
	int PRECORD = 55;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PRecordOfImpl <em>PRecord Of</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PRecordOfImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPRecordOf()
     * @generated
     */
	int PRECORD_OF = 56;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PSetImpl <em>PSet</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PSetImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPSet()
     * @generated
     */
	int PSET = 57;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PSetOfImpl <em>PSet Of</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PSetOfImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPSetOf()
     * @generated
     */
	int PSET_OF = 58;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__ANNOTATIONS = PCONTAINER_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__ATTATCHMENT = PCONTAINER_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__NAME = PCONTAINER_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__VARIANT = PCONTAINER_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__ENCODE = PCONTAINER_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__TYPE_ENCODING_DESC = PCONTAINER_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__TYPE_ENCODING_VARIANT_DESC = PCONTAINER_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__TYPE_EXTENSION_DESC = PCONTAINER_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__CONTAINER_TYPE = PCONTAINER_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__DERIVATIVE_MODE = PCONTAINER_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__JAVA_CLASS = PCONTAINER_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__LIST_TYPE = PCONTAINER_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__PRIMITIVE_TYPE = PCONTAINER_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__TYPE_CLASS = PCONTAINER_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__TYPE_ID = PCONTAINER_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__PMODULE = PCONTAINER_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__CONSTRAINT = PCONTAINER_TYPE__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Pfields</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD__PFIELDS = PCONTAINER_TYPE__PFIELDS;

	/**
     * The number of structural features of the '<em>PRecord</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_FEATURE_COUNT = PCONTAINER_TYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__ANNOTATIONS = PLIST_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__ATTATCHMENT = PLIST_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__NAME = PLIST_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__VARIANT = PLIST_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__ENCODE = PLIST_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__TYPE_ENCODING_DESC = PLIST_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__TYPE_ENCODING_VARIANT_DESC = PLIST_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__TYPE_EXTENSION_DESC = PLIST_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__CONTAINER_TYPE = PLIST_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__DERIVATIVE_MODE = PLIST_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__JAVA_CLASS = PLIST_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__LIST_TYPE = PLIST_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__PRIMITIVE_TYPE = PLIST_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__TYPE_CLASS = PLIST_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__TYPE_ID = PLIST_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__PMODULE = PLIST_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__CONSTRAINT = PLIST_TYPE__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF__ITEM = PLIST_TYPE__ITEM;

	/**
     * The number of structural features of the '<em>PRecord Of</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECORD_OF_FEATURE_COUNT = PLIST_TYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__ANNOTATIONS = PCONTAINER_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__ATTATCHMENT = PCONTAINER_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__NAME = PCONTAINER_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__VARIANT = PCONTAINER_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__ENCODE = PCONTAINER_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__TYPE_ENCODING_DESC = PCONTAINER_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__TYPE_ENCODING_VARIANT_DESC = PCONTAINER_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__TYPE_EXTENSION_DESC = PCONTAINER_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__CONTAINER_TYPE = PCONTAINER_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__DERIVATIVE_MODE = PCONTAINER_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__JAVA_CLASS = PCONTAINER_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__LIST_TYPE = PCONTAINER_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__PRIMITIVE_TYPE = PCONTAINER_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__TYPE_CLASS = PCONTAINER_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__TYPE_ID = PCONTAINER_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__PMODULE = PCONTAINER_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__CONSTRAINT = PCONTAINER_TYPE__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Pfields</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET__PFIELDS = PCONTAINER_TYPE__PFIELDS;

	/**
     * The number of structural features of the '<em>PSet</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_FEATURE_COUNT = PCONTAINER_TYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__ANNOTATIONS = PLIST_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__ATTATCHMENT = PLIST_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__NAME = PLIST_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__VARIANT = PLIST_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__ENCODE = PLIST_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__TYPE_ENCODING_DESC = PLIST_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__TYPE_ENCODING_VARIANT_DESC = PLIST_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__TYPE_EXTENSION_DESC = PLIST_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__CONTAINER_TYPE = PLIST_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__DERIVATIVE_MODE = PLIST_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__JAVA_CLASS = PLIST_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__LIST_TYPE = PLIST_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__PRIMITIVE_TYPE = PLIST_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__TYPE_CLASS = PLIST_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__TYPE_ID = PLIST_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__PMODULE = PLIST_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__CONSTRAINT = PLIST_TYPE__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF__ITEM = PLIST_TYPE__ITEM;

	/**
     * The number of structural features of the '<em>PSet Of</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSET_OF_FEATURE_COUNT = PLIST_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PSubTypeImpl <em>PSub Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PSubTypeImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPSubType()
     * @generated
     */
	int PSUB_TYPE = 61;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__ANNOTATIONS = PTYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__ATTATCHMENT = PTYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__NAME = PTYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__VARIANT = PTYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__ENCODE = PTYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__TYPE_ENCODING_DESC = PTYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__TYPE_ENCODING_VARIANT_DESC = PTYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__TYPE_EXTENSION_DESC = PTYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__CONTAINER_TYPE = PTYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__DERIVATIVE_MODE = PTYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__JAVA_CLASS = PTYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__LIST_TYPE = PTYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__PRIMITIVE_TYPE = PTYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__TYPE_CLASS = PTYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__TYPE_ID = PTYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__PMODULE = PTYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__CONSTRAINT = PTYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Super Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__SUPER_TYPE = PTYPE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Super Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE__SUPER_TYPE_NAME = PTYPE_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>PSub Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PSUB_TYPE_FEATURE_COUNT = PTYPE_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeReferenceArgumentImpl <em>PType Reference Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeReferenceArgumentImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPTypeReferenceArgument()
     * @generated
     */
	int PTYPE_REFERENCE_ARGUMENT = 66;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_REFERENCE_ARGUMENT__ANNOTATIONS = PSINGLE_ARGUMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_REFERENCE_ARGUMENT__ATTATCHMENT = PSINGLE_ARGUMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_REFERENCE_ARGUMENT__TYPE_NAME = PSINGLE_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>PType Reference Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PTYPE_REFERENCE_ARGUMENT_FEATURE_COUNT = PSINGLE_ARGUMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__ANNOTATIONS = PCONTAINER_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__ATTATCHMENT = PCONTAINER_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__NAME = PCONTAINER_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__VARIANT = PCONTAINER_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__ENCODE = PCONTAINER_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__TYPE_ENCODING_DESC = PCONTAINER_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__TYPE_ENCODING_VARIANT_DESC = PCONTAINER_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__TYPE_EXTENSION_DESC = PCONTAINER_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__CONTAINER_TYPE = PCONTAINER_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__DERIVATIVE_MODE = PCONTAINER_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__JAVA_CLASS = PCONTAINER_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__LIST_TYPE = PCONTAINER_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__PRIMITIVE_TYPE = PCONTAINER_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__TYPE_CLASS = PCONTAINER_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__TYPE_ID = PCONTAINER_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__PMODULE = PCONTAINER_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__CONSTRAINT = PCONTAINER_TYPE__CONSTRAINT;

	/**
     * The feature id for the '<em><b>Pfields</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION__PFIELDS = PCONTAINER_TYPE__PFIELDS;

	/**
     * The number of structural features of the '<em>PUnion</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNION_FEATURE_COUNT = PCONTAINER_TYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__ANNOTATIONS = PSTRING_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__ATTATCHMENT = PSTRING_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__NAME = PSTRING_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__VARIANT = PSTRING_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__ENCODE = PSTRING_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__TYPE_ENCODING_DESC = PSTRING_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__TYPE_ENCODING_VARIANT_DESC = PSTRING_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__TYPE_EXTENSION_DESC = PSTRING_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__CONTAINER_TYPE = PSTRING_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__DERIVATIVE_MODE = PSTRING_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__JAVA_CLASS = PSTRING_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__LIST_TYPE = PSTRING_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__PRIMITIVE_TYPE = PSTRING_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__TYPE_CLASS = PSTRING_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__TYPE_ID = PSTRING_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__PMODULE = PSTRING_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING__CONSTRAINT = PSTRING_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>PUniversal Charstring</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PUNIVERSAL_CHARSTRING_FEATURE_COUNT = PSTRING_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PValueReferenceArgumentImpl <em>PValue Reference Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PValueReferenceArgumentImpl
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPValueReferenceArgument()
     * @generated
     */
	int PVALUE_REFERENCE_ARGUMENT = 69;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVALUE_REFERENCE_ARGUMENT__ANNOTATIONS = PSINGLE_ARGUMENT__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVALUE_REFERENCE_ARGUMENT__ATTATCHMENT = PSINGLE_ARGUMENT__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Value Ref</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVALUE_REFERENCE_ARGUMENT__VALUE_REF = PSINGLE_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Type Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVALUE_REFERENCE_ARGUMENT__TYPE_NAME = PSINGLE_ARGUMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>PValue Reference Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVALUE_REFERENCE_ARGUMENT_FEATURE_COUNT = PSINGLE_ARGUMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__ANNOTATIONS = PPRIMITIVE_TYPE__ANNOTATIONS;

	/**
     * The feature id for the '<em><b>Attatchment</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__ATTATCHMENT = PPRIMITIVE_TYPE__ATTATCHMENT;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__NAME = PPRIMITIVE_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Variant</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__VARIANT = PPRIMITIVE_TYPE__VARIANT;

	/**
     * The feature id for the '<em><b>Encode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__ENCODE = PPRIMITIVE_TYPE__ENCODE;

	/**
     * The feature id for the '<em><b>Type Encoding Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__TYPE_ENCODING_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_DESC;

	/**
     * The feature id for the '<em><b>Type Encoding Variant Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__TYPE_ENCODING_VARIANT_DESC = PPRIMITIVE_TYPE__TYPE_ENCODING_VARIANT_DESC;

	/**
     * The feature id for the '<em><b>Type Extension Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__TYPE_EXTENSION_DESC = PPRIMITIVE_TYPE__TYPE_EXTENSION_DESC;

	/**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__CONTAINER_TYPE = PPRIMITIVE_TYPE__CONTAINER_TYPE;

	/**
     * The feature id for the '<em><b>Derivative Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__DERIVATIVE_MODE = PPRIMITIVE_TYPE__DERIVATIVE_MODE;

	/**
     * The feature id for the '<em><b>Java Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__JAVA_CLASS = PPRIMITIVE_TYPE__JAVA_CLASS;

	/**
     * The feature id for the '<em><b>List Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__LIST_TYPE = PPRIMITIVE_TYPE__LIST_TYPE;

	/**
     * The feature id for the '<em><b>Primitive Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__PRIMITIVE_TYPE = PPRIMITIVE_TYPE__PRIMITIVE_TYPE;

	/**
     * The feature id for the '<em><b>Type Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__TYPE_CLASS = PPRIMITIVE_TYPE__TYPE_CLASS;

	/**
     * The feature id for the '<em><b>Type ID</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__TYPE_ID = PPRIMITIVE_TYPE__TYPE_ID;

	/**
     * The feature id for the '<em><b>Pmodule</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__PMODULE = PPRIMITIVE_TYPE__PMODULE;

	/**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT__CONSTRAINT = PPRIMITIVE_TYPE__CONSTRAINT;

	/**
     * The number of structural features of the '<em>PVerdict</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PVERDICT_FEATURE_COUNT = PPRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.EncodingType <em>Encoding Type</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.EncodingType
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getEncodingType()
     * @generated
     */
	int ENCODING_TYPE = 72;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType <em>Flag Field Type</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getFlagFieldType()
     * @generated
     */
	int FLAG_FIELD_TYPE = 73;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType <em>Module Element Type</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getModuleElementType()
     * @generated
     */
	int MODULE_ELEMENT_TYPE = 74;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.OnelineMode <em>Oneline Mode</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.OnelineMode
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getOnelineMode()
     * @generated
     */
	int ONELINE_MODE = 75;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.PadType <em>Pad Type</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.PadType
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPadType()
     * @generated
     */
	int PAD_TYPE = 76;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.TypeClass <em>Type Class</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.TypeClass
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getTypeClass()
     * @generated
     */
	int TYPE_CLASS = 77;

	/**
     * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode <em>Type Derivative Mode</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getTypeDerivativeMode()
     * @generated
     */
	int TYPE_DERIVATIVE_MODE = 78;

	/**
     * The meta object id for the '<em>Byte Order Object</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.ByteOrder
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getByteOrderObject()
     * @generated
     */
	int BYTE_ORDER_OBJECT = 79;

	/**
     * The meta object id for the '<em>Encoding Type Object</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.EncodingType
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getEncodingTypeObject()
     * @generated
     */
	int ENCODING_TYPE_OBJECT = 80;

	/**
     * The meta object id for the '<em>Flag Field Type Object</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getFlagFieldTypeObject()
     * @generated
     */
	int FLAG_FIELD_TYPE_OBJECT = 81;

	/**
     * The meta object id for the '<em>Module Element Type Object</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getModuleElementTypeObject()
     * @generated
     */
	int MODULE_ELEMENT_TYPE_OBJECT = 82;

	/**
     * The meta object id for the '<em>Oneline Mode Object</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.OnelineMode
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getOnelineModeObject()
     * @generated
     */
	int ONELINE_MODE_OBJECT = 83;

	/**
     * The meta object id for the '<em>Pad Type Object</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.PadType
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPadTypeObject()
     * @generated
     */
	int PAD_TYPE_OBJECT = 84;

	/**
     * The meta object id for the '<em>Type Class Object</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.TypeClass
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getTypeClassObject()
     * @generated
     */
	int TYPE_CLASS_OBJECT = 85;


	/**
     * The meta object id for the '<em>Type Derivative Mode Object</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode
     * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getTypeDerivativeModeObject()
     * @generated
     */
	int TYPE_DERIVATIVE_MODE_OBJECT = 86;


	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Document Root</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot
     * @generated
     */
	EClass getDocumentRoot();

	/**
     * Returns the meta object for the attribute list '{@link com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot#getMixed()
     * @see #getDocumentRoot()
     * @generated
     */
	EAttribute getDocumentRoot_Mixed();

	/**
     * Returns the meta object for the map '{@link com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot#getXMLNSPrefixMap()
     * @see #getDocumentRoot()
     * @generated
     */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
     * Returns the meta object for the map '{@link com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XSI Schema Location</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot#getXSISchemaLocation()
     * @see #getDocumentRoot()
     * @generated
     */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot#getPModule <em>PModule</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>PModule</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot#getPModule()
     * @see #getDocumentRoot()
     * @generated
     */
	EReference getDocumentRoot_PModule();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PAddress <em>PAddress</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PAddress</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PAddress
     * @generated
     */
	EClass getPAddress();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PArgument <em>PArgument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PArgument</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PArgument
     * @generated
     */
	EClass getPArgument();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PArgumentGroup <em>PArgument Group</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PArgument Group</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PArgumentGroup
     * @generated
     */
	EClass getPArgumentGroup();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PArgumentGroup#getArguments <em>Arguments</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Arguments</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PArgumentGroup#getArguments()
     * @see #getPArgumentGroup()
     * @generated
     */
	EReference getPArgumentGroup_Arguments();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PBitstring <em>PBitstring</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PBitstring</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PBitstring
     * @generated
     */
	EClass getPBitstring();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PBoolean <em>PBoolean</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PBoolean</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PBoolean
     * @generated
     */
	EClass getPBoolean();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PBooleanArgument <em>PBoolean Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PBoolean Argument</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PBooleanArgument
     * @generated
     */
	EClass getPBooleanArgument();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PBooleanArgument#getDesc <em>Desc</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Desc</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PBooleanArgument#getDesc()
     * @see #getPBooleanArgument()
     * @generated
     */
	EAttribute getPBooleanArgument_Desc();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PCharstring <em>PCharstring</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PCharstring</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PCharstring
     * @generated
     */
	EClass getPCharstring();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PCharstringArgument <em>PCharstring Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PCharstring Argument</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PCharstringArgument
     * @generated
     */
	EClass getPCharstringArgument();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PCharstringArgument#getDesc <em>Desc</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Desc</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PCharstringArgument#getDesc()
     * @see #getPCharstringArgument()
     * @generated
     */
	EAttribute getPCharstringArgument_Desc();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PCompoundConstraint <em>PCompound Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PCompound Constraint</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PCompoundConstraint
     * @generated
     */
	EClass getPCompoundConstraint();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PCompoundConstraint#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Children</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PCompoundConstraint#getChildren()
     * @see #getPCompoundConstraint()
     * @generated
     */
	EReference getPCompoundConstraint_Children();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument <em>PCondition Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PCondition Argument</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument
     * @generated
     */
	EClass getPConditionArgument();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Condition</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument#getCondition()
     * @see #getPConditionArgument()
     * @generated
     */
	EReference getPConditionArgument_Condition();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument#getTypeName <em>Type Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument#getTypeName()
     * @see #getPConditionArgument()
     * @generated
     */
	EAttribute getPConditionArgument_TypeName();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PConstant <em>PConstant</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PConstant</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PConstant
     * @generated
     */
	EClass getPConstant();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PConstant#getConstantID <em>Constant ID</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Constant ID</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PConstant#getConstantID()
     * @see #getPConstant()
     * @generated
     */
	EAttribute getPConstant_ConstantID();

	/**
     * Returns the meta object for the container reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PConstant#getPmodule <em>Pmodule</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Pmodule</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PConstant#getPmodule()
     * @see #getPConstant()
     * @generated
     */
	EReference getPConstant_Pmodule();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PContainerType <em>PContainer Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PContainer Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PContainerType
     * @generated
     */
	EClass getPContainerType();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PContainerType#getPfields <em>Pfields</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Pfields</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PContainerType#getPfields()
     * @see #getPContainerType()
     * @generated
     */
	EReference getPContainerType_Pfields();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement <em>PEncoded Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PEncoded Element</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement
     * @generated
     */
	EClass getPEncodedElement();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getVariant <em>Variant</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Variant</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getVariant()
     * @see #getPEncodedElement()
     * @generated
     */
	EReference getPEncodedElement_Variant();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getEncode <em>Encode</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Encode</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getEncode()
     * @see #getPEncodedElement()
     * @generated
     */
	EAttribute getPEncodedElement_Encode();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getTypeEncodingDesc <em>Type Encoding Desc</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type Encoding Desc</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getTypeEncodingDesc()
     * @see #getPEncodedElement()
     * @generated
     */
	EAttribute getPEncodedElement_TypeEncodingDesc();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getTypeEncodingVariantDesc <em>Type Encoding Variant Desc</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type Encoding Variant Desc</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getTypeEncodingVariantDesc()
     * @see #getPEncodedElement()
     * @generated
     */
	EAttribute getPEncodedElement_TypeEncodingVariantDesc();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getTypeExtensionDesc <em>Type Extension Desc</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type Extension Desc</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement#getTypeExtensionDesc()
     * @see #getPEncodedElement()
     * @generated
     */
	EAttribute getPEncodedElement_TypeExtensionDesc();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant <em>PEncoding Variant</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PEncoding Variant</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant
     * @generated
     */
	EClass getPEncodingVariant();

	/**
     * Returns the meta object for the container reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant#getEncodedElement <em>Encoded Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Encoded Element</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant#getEncodedElement()
     * @see #getPEncodingVariant()
     * @generated
     */
	EReference getPEncodingVariant_EncodedElement();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant <em>PEntity Constant</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PEntity Constant</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant
     * @generated
     */
	EClass getPEntityConstant();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant#getMatcher <em>Matcher</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Matcher</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant#getMatcher()
     * @see #getPEntityConstant()
     * @generated
     */
	EReference getPEntityConstant_Matcher();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant#getBaseTypeName <em>Base Type Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Type Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant#getBaseTypeName()
     * @see #getPEntityConstant()
     * @generated
     */
	EAttribute getPEntityConstant_BaseTypeName();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet <em>PEntity Enum Set</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PEntity Enum Set</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet
     * @generated
     */
	EClass getPEntityEnumSet();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet#getEnumItems <em>Enum Items</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Enum Items</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet#getEnumItems()
     * @see #getPEntityEnumSet()
     * @generated
     */
	EReference getPEntityEnumSet_EnumItems();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet#getBaseTypeName <em>Base Type Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Type Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet#getBaseTypeName()
     * @see #getPEntityEnumSet()
     * @generated
     */
	EAttribute getPEntityEnumSet_BaseTypeName();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar <em>PEntity Module Par</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PEntity Module Par</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar
     * @generated
     */
	EClass getPEntityModulePar();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#getMatcher <em>Matcher</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Matcher</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#getMatcher()
     * @see #getPEntityModulePar()
     * @generated
     */
	EReference getPEntityModulePar_Matcher();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#getBaseTypeName <em>Base Type Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Type Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#getBaseTypeName()
     * @see #getPEntityModulePar()
     * @generated
     */
	EAttribute getPEntityModulePar_BaseTypeName();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#isThread <em>Thread</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Thread</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar#isThread()
     * @see #getPEntityModulePar()
     * @generated
     */
	EAttribute getPEntityModulePar_Thread();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityType <em>PEntity Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PEntity Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityType
     * @generated
     */
	EClass getPEntityType();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityType#getConstraint <em>Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Constraint</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityType#getConstraint()
     * @see #getPEntityType()
     * @generated
     */
	EReference getPEntityType_Constraint();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumerated <em>PEnumerated</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PEnumerated</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumerated
     * @generated
     */
	EClass getPEnumerated();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumerated#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Items</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumerated#getItems()
     * @see #getPEnumerated()
     * @generated
     */
	EReference getPEnumerated_Items();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem <em>PEnumerated Item</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PEnumerated Item</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem
     * @generated
     */
	EClass getPEnumeratedItem();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem#getEnumName <em>Enum Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enum Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem#getEnumName()
     * @see #getPEnumeratedItem()
     * @generated
     */
	EAttribute getPEnumeratedItem_EnumName();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem#getEnumValue <em>Enum Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enum Value</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem#getEnumValue()
     * @see #getPEnumeratedItem()
     * @generated
     */
	EAttribute getPEnumeratedItem_EnumValue();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumItem <em>PEnum Item</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PEnum Item</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumItem
     * @generated
     */
	EClass getPEnumItem();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumItem#getCond <em>Cond</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Cond</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumItem#getCond()
     * @see #getPEnumItem()
     * @generated
     */
	EReference getPEnumItem_Cond();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumItem#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumItem#getName()
     * @see #getPEnumItem()
     * @generated
     */
	EAttribute getPEnumItem_Name();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumSet <em>PEnum Set</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PEnum Set</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumSet
     * @generated
     */
	EClass getPEnumSet();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumSet#getEnumSetID <em>Enum Set ID</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enum Set ID</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumSet#getEnumSetID()
     * @see #getPEnumSet()
     * @generated
     */
	EAttribute getPEnumSet_EnumSetID();

	/**
     * Returns the meta object for the container reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumSet#getPmodule <em>Pmodule</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Pmodule</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumSet#getPmodule()
     * @see #getPEnumSet()
     * @generated
     */
	EReference getPEnumSet_Pmodule();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PField <em>PField</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PField</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PField
     * @generated
     */
	EClass getPField();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PField#getFieldID <em>Field ID</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Field ID</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PField#getFieldID()
     * @see #getPField()
     * @generated
     */
	EAttribute getPField_FieldID();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PField#isOptional <em>Optional</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Optional</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PField#isOptional()
     * @see #getPField()
     * @generated
     */
	EAttribute getPField_Optional();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PFieldEV <em>PField EV</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PField EV</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFieldEV
     * @generated
     */
	EClass getPFieldEV();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PFieldEV#getPrpList <em>Prp List</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Prp List</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFieldEV#getPrpList()
     * @see #getPFieldEV()
     * @generated
     */
	EReference getPFieldEV_PrpList();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PFloat <em>PFloat</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PFloat</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFloat
     * @generated
     */
	EClass getPFloat();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PFpbFieldEV <em>PFpb Field EV</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PFpb Field EV</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFpbFieldEV
     * @generated
     */
	EClass getPFpbFieldEV();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PFpbListItemEV <em>PFpb List Item EV</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PFpb List Item EV</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFpbListItemEV
     * @generated
     */
	EClass getPFpbListItemEV();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PFpbModuleEV <em>PFpb Module EV</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PFpb Module EV</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFpbModuleEV
     * @generated
     */
	EClass getPFpbModuleEV();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV <em>PFpb Type EV</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PFpb Type EV</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV
     * @generated
     */
	EClass getPFpbTypeEV();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PHexstring <em>PHexstring</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PHexstring</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PHexstring
     * @generated
     */
	EClass getPHexstring();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PIdentifierArgument <em>PIdentifier Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PIdentifier Argument</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PIdentifierArgument
     * @generated
     */
	EClass getPIdentifierArgument();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PIdentifierArgument#getDesc <em>Desc</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Desc</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PIdentifierArgument#getDesc()
     * @see #getPIdentifierArgument()
     * @generated
     */
	EAttribute getPIdentifierArgument_Desc();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportConstant <em>PImport Constant</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PImport Constant</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportConstant
     * @generated
     */
	EClass getPImportConstant();

	/**
     * Returns the meta object for the reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportConstant#getImportedConstant <em>Imported Constant</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Imported Constant</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportConstant#getImportedConstant()
     * @see #getPImportConstant()
     * @generated
     */
	EReference getPImportConstant_ImportedConstant();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportConstant#getImportedConstantName <em>Imported Constant Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Imported Constant Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportConstant#getImportedConstantName()
     * @see #getPImportConstant()
     * @generated
     */
	EAttribute getPImportConstant_ImportedConstantName();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportConstant#getImportedModuleName <em>Imported Module Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Imported Module Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportConstant#getImportedModuleName()
     * @see #getPImportConstant()
     * @generated
     */
	EAttribute getPImportConstant_ImportedModuleName();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement <em>PImport Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PImport Element</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportElement
     * @generated
     */
	EClass getPImportElement();

	/**
     * Returns the meta object for the attribute list '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getRefNameList <em>Ref Name List</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Ref Name List</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getRefNameList()
     * @see #getPImportElement()
     * @generated
     */
	EAttribute getPImportElement_RefNameList();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#isAllExcept <em>All Except</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>All Except</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportElement#isAllExcept()
     * @see #getPImportElement()
     * @generated
     */
	EAttribute getPImportElement_AllExcept();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getElementType <em>Element Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Element Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getElementType()
     * @see #getPImportElement()
     * @generated
     */
	EAttribute getPImportElement_ElementType();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getFromModuleName <em>From Module Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>From Module Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getFromModuleName()
     * @see #getPImportElement()
     * @generated
     */
	EAttribute getPImportElement_FromModuleName();

	/**
     * Returns the meta object for the container reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getPmodule <em>Pmodule</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Pmodule</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportElement#getPmodule()
     * @see #getPImportElement()
     * @generated
     */
	EReference getPImportElement_Pmodule();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet <em>PImport Enum Set</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PImport Enum Set</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet
     * @generated
     */
	EClass getPImportEnumSet();

	/**
     * Returns the meta object for the reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet#getImportedEnumSet <em>Imported Enum Set</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Imported Enum Set</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet#getImportedEnumSet()
     * @see #getPImportEnumSet()
     * @generated
     */
	EReference getPImportEnumSet_ImportedEnumSet();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet#getImportedEnumSetName <em>Imported Enum Set Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Imported Enum Set Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet#getImportedEnumSetName()
     * @see #getPImportEnumSet()
     * @generated
     */
	EAttribute getPImportEnumSet_ImportedEnumSetName();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet#getImportedModuleName <em>Imported Module Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Imported Module Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet#getImportedModuleName()
     * @see #getPImportEnumSet()
     * @generated
     */
	EAttribute getPImportEnumSet_ImportedModuleName();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar <em>PImport Module Par</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PImport Module Par</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar
     * @generated
     */
	EClass getPImportModulePar();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar#getImportedModuleName <em>Imported Module Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Imported Module Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar#getImportedModuleName()
     * @see #getPImportModulePar()
     * @generated
     */
	EAttribute getPImportModulePar_ImportedModuleName();

	/**
     * Returns the meta object for the reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar#getImportedModulePar <em>Imported Module Par</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Imported Module Par</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar#getImportedModulePar()
     * @see #getPImportModulePar()
     * @generated
     */
	EReference getPImportModulePar_ImportedModulePar();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar#getImportedModulePartName <em>Imported Module Part Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Imported Module Part Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar#getImportedModulePartName()
     * @see #getPImportModulePar()
     * @generated
     */
	EAttribute getPImportModulePar_ImportedModulePartName();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportType <em>PImport Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PImport Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportType
     * @generated
     */
	EClass getPImportType();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportType#getImportedModuleName <em>Imported Module Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Imported Module Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportType#getImportedModuleName()
     * @see #getPImportType()
     * @generated
     */
	EAttribute getPImportType_ImportedModuleName();

	/**
     * Returns the meta object for the reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportType#getImportedType <em>Imported Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Imported Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportType#getImportedType()
     * @see #getPImportType()
     * @generated
     */
	EReference getPImportType_ImportedType();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportType#getImportedTypeName <em>Imported Type Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Imported Type Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportType#getImportedTypeName()
     * @see #getPImportType()
     * @generated
     */
	EAttribute getPImportType_ImportedTypeName();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PInteger <em>PInteger</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PInteger</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PInteger
     * @generated
     */
	EClass getPInteger();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PIntegerArgument <em>PInteger Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PInteger Argument</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PIntegerArgument
     * @generated
     */
	EClass getPIntegerArgument();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PIntegerArgument#getDesc <em>Desc</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Desc</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PIntegerArgument#getDesc()
     * @see #getPIntegerArgument()
     * @generated
     */
	EAttribute getPIntegerArgument_Desc();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PItemField <em>PItem Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>PItem Field</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PItemField
     * @generated
     */
    EClass getPItemField();

    /**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PItemField#getConstraint <em>Constraint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Constraint</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PItemField#getConstraint()
     * @see #getPItemField()
     * @generated
     */
    EReference getPItemField_Constraint();

    /**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PItemField#getEnumItems <em>Enum Items</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Enum Items</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PItemField#getEnumItems()
     * @see #getPItemField()
     * @generated
     */
    EReference getPItemField_EnumItems();

    /**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PItemField#getEnumRef <em>Enum Ref</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enum Ref</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PItemField#getEnumRef()
     * @see #getPItemField()
     * @generated
     */
    EAttribute getPItemField_EnumRef();

    /**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint <em>PLength Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PLength Constraint</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint
     * @generated
     */
	EClass getPLengthConstraint();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint#getLowerBound <em>Lower Bound</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Lower Bound</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint#getLowerBound()
     * @see #getPLengthConstraint()
     * @generated
     */
	EReference getPLengthConstraint_LowerBound();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint#getUpperBound <em>Upper Bound</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Upper Bound</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint#getUpperBound()
     * @see #getPLengthConstraint()
     * @generated
     */
	EReference getPLengthConstraint_UpperBound();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PListArgument <em>PList Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PList Argument</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListArgument
     * @generated
     */
	EClass getPListArgument();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PListArgument#getGroup <em>Group</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Group</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListArgument#getGroup()
     * @see #getPListArgument()
     * @generated
     */
	EReference getPListArgument_Group();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PListConstraint <em>PList Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PList Constraint</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListConstraint
     * @generated
     */
	EClass getPListConstraint();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PListConstraint#getMatcher <em>Matcher</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Matcher</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListConstraint#getMatcher()
     * @see #getPListConstraint()
     * @generated
     */
	EReference getPListConstraint_Matcher();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PListItem <em>PList Item</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PList Item</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListItem
     * @generated
     */
	EClass getPListItem();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PListItemEV <em>PList Item EV</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PList Item EV</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListItemEV
     * @generated
     */
	EClass getPListItemEV();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PListItemEV#getPrpList <em>Prp List</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Prp List</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListItemEV#getPrpList()
     * @see #getPListItemEV()
     * @generated
     */
	EReference getPListItemEV_PrpList();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PListType <em>PList Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PList Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListType
     * @generated
     */
	EClass getPListType();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PListType#getItem <em>Item</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Item</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListType#getItem()
     * @see #getPListType()
     * @generated
     */
	EReference getPListType_Item();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule <em>PModule</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PModule</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule
     * @generated
     */
	EClass getPModule();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getTypes <em>Types</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Types</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getTypes()
     * @see #getPModule()
     * @generated
     */
	EReference getPModule_Types();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getConstants <em>Constants</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Constants</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getConstants()
     * @see #getPModule()
     * @generated
     */
	EReference getPModule_Constants();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getTemplates <em>Templates</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Templates</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getTemplates()
     * @see #getPModule()
     * @generated
     */
	EReference getPModule_Templates();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getModulePars <em>Module Pars</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Module Pars</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getModulePars()
     * @see #getPModule()
     * @generated
     */
	EReference getPModule_ModulePars();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getImportElements <em>Import Elements</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Import Elements</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getImportElements()
     * @see #getPModule()
     * @generated
     */
	EReference getPModule_ImportElements();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getEnumSets <em>Enum Sets</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Enum Sets</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getEnumSets()
     * @see #getPModule()
     * @generated
     */
	EReference getPModule_EnumSets();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getFactoryJavaClass <em>Factory Java Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Factory Java Class</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getFactoryJavaClass()
     * @see #getPModule()
     * @generated
     */
	EAttribute getPModule_FactoryJavaClass();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getModuleJavaClass <em>Module Java Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Module Java Class</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getModuleJavaClass()
     * @see #getPModule()
     * @generated
     */
	EAttribute getPModule_ModuleJavaClass();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule#getTypeEvFactoryJavaClass <em>Type Ev Factory Java Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type Ev Factory Java Class</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule#getTypeEvFactoryJavaClass()
     * @see #getPModule()
     * @generated
     */
	EAttribute getPModule_TypeEvFactoryJavaClass();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PModuleEV <em>PModule EV</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PModule EV</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModuleEV
     * @generated
     */
	EClass getPModuleEV();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PModuleEV#getPrpList <em>Prp List</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Prp List</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModuleEV#getPrpList()
     * @see #getPModuleEV()
     * @generated
     */
	EReference getPModuleEV_PrpList();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PModulePar <em>PModule Par</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PModule Par</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModulePar
     * @generated
     */
	EClass getPModulePar();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PModulePar#getModuleParID <em>Module Par ID</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Module Par ID</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModulePar#getModuleParID()
     * @see #getPModulePar()
     * @generated
     */
	EAttribute getPModulePar_ModuleParID();

	/**
     * Returns the meta object for the container reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PModulePar#getPmodule <em>Pmodule</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Pmodule</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModulePar#getPmodule()
     * @see #getPModulePar()
     * @generated
     */
	EReference getPModulePar_Pmodule();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PObjid <em>PObjid</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PObjid</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PObjid
     * @generated
     */
	EClass getPObjid();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.POctetstring <em>POctetstring</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>POctetstring</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.POctetstring
     * @generated
     */
	EClass getPOctetstring();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint <em>PPattern Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PPattern Constraint</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint
     * @generated
     */
	EClass getPPatternConstraint();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint#getMatcher <em>Matcher</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Matcher</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint#getMatcher()
     * @see #getPPatternConstraint()
     * @generated
     */
	EReference getPPatternConstraint_Matcher();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PPrimitiveType <em>PPrimitive Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PPrimitive Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PPrimitiveType
     * @generated
     */
	EClass getPPrimitiveType();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PProperty <em>PProperty</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PProperty</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PProperty
     * @generated
     */
	EClass getPProperty();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PProperty#getGroups <em>Groups</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Groups</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PProperty#getGroups()
     * @see #getPProperty()
     * @generated
     */
	EReference getPProperty_Groups();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PPropertyList <em>PProperty List</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PProperty List</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PPropertyList
     * @generated
     */
	EClass getPPropertyList();

	/**
     * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbmodule.PPropertyList#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Properties</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PPropertyList#getProperties()
     * @see #getPPropertyList()
     * @generated
     */
	EReference getPPropertyList_Properties();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PRecord <em>PRecord</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PRecord</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PRecord
     * @generated
     */
	EClass getPRecord();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PRecordOf <em>PRecord Of</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PRecord Of</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PRecordOf
     * @generated
     */
	EClass getPRecordOf();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PSet <em>PSet</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PSet</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PSet
     * @generated
     */
	EClass getPSet();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PSetOf <em>PSet Of</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PSet Of</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PSetOf
     * @generated
     */
	EClass getPSetOf();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PSingleArgument <em>PSingle Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PSingle Argument</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PSingleArgument
     * @generated
     */
	EClass getPSingleArgument();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PStringType <em>PString Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PString Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PStringType
     * @generated
     */
	EClass getPStringType();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PSubType <em>PSub Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PSub Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PSubType
     * @generated
     */
	EClass getPSubType();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PSubType#getConstraint <em>Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Constraint</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PSubType#getConstraint()
     * @see #getPSubType()
     * @generated
     */
	EReference getPSubType_Constraint();

	/**
     * Returns the meta object for the reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PSubType#getSuperType <em>Super Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Super Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PSubType#getSuperType()
     * @see #getPSubType()
     * @generated
     */
	EReference getPSubType_SuperType();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PSubType#getSuperTypeName <em>Super Type Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Super Type Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PSubType#getSuperTypeName()
     * @see #getPSubType()
     * @generated
     */
	EAttribute getPSubType_SuperTypeName();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PType <em>PType</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PType</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PType
     * @generated
     */
	EClass getPType();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#isContainerType <em>Container Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Container Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PType#isContainerType()
     * @see #getPType()
     * @generated
     */
	EAttribute getPType_ContainerType();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getDerivativeMode <em>Derivative Mode</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Derivative Mode</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PType#getDerivativeMode()
     * @see #getPType()
     * @generated
     */
	EAttribute getPType_DerivativeMode();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getJavaClass <em>Java Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Java Class</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PType#getJavaClass()
     * @see #getPType()
     * @generated
     */
	EAttribute getPType_JavaClass();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#isListType <em>List Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>List Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PType#isListType()
     * @see #getPType()
     * @generated
     */
	EAttribute getPType_ListType();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#isPrimitiveType <em>Primitive Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Primitive Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PType#isPrimitiveType()
     * @see #getPType()
     * @generated
     */
	EAttribute getPType_PrimitiveType();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getTypeClass <em>Type Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type Class</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PType#getTypeClass()
     * @see #getPType()
     * @generated
     */
	EAttribute getPType_TypeClass();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getTypeID <em>Type ID</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type ID</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PType#getTypeID()
     * @see #getPType()
     * @generated
     */
	EAttribute getPType_TypeID();

	/**
     * Returns the meta object for the container reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PType#getPmodule <em>Pmodule</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Pmodule</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PType#getPmodule()
     * @see #getPType()
     * @generated
     */
	EReference getPType_Pmodule();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint <em>PType Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PType Constraint</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint
     * @generated
     */
	EClass getPTypeConstraint();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypedElement <em>PTyped Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PTyped Element</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PTypedElement
     * @generated
     */
	EClass getPTypedElement();

	/**
     * Returns the meta object for the reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypedElement#getPtype <em>Ptype</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ptype</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PTypedElement#getPtype()
     * @see #getPTypedElement()
     * @generated
     */
	EReference getPTypedElement_Ptype();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypedElement#getPtypeName <em>Ptype Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ptype Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PTypedElement#getPtypeName()
     * @see #getPTypedElement()
     * @generated
     */
	EAttribute getPTypedElement_PtypeName();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypeEV <em>PType EV</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PType EV</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PTypeEV
     * @generated
     */
	EClass getPTypeEV();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypeEV#getPrpList <em>Prp List</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Prp List</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PTypeEV#getPrpList()
     * @see #getPTypeEV()
     * @generated
     */
	EReference getPTypeEV_PrpList();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypeReferenceArgument <em>PType Reference Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PType Reference Argument</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PTypeReferenceArgument
     * @generated
     */
	EClass getPTypeReferenceArgument();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypeReferenceArgument#getTypeName <em>Type Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PTypeReferenceArgument#getTypeName()
     * @see #getPTypeReferenceArgument()
     * @generated
     */
	EAttribute getPTypeReferenceArgument_TypeName();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PUnion <em>PUnion</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PUnion</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PUnion
     * @generated
     */
	EClass getPUnion();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PUniversalCharstring <em>PUniversal Charstring</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PUniversal Charstring</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PUniversalCharstring
     * @generated
     */
	EClass getPUniversalCharstring();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument <em>PValue Reference Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PValue Reference Argument</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument
     * @generated
     */
	EClass getPValueReferenceArgument();

	/**
     * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument#getValueRef <em>Value Ref</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value Ref</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument#getValueRef()
     * @see #getPValueReferenceArgument()
     * @generated
     */
	EReference getPValueReferenceArgument_ValueRef();

	/**
     * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument#getTypeName <em>Type Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type Name</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument#getTypeName()
     * @see #getPValueReferenceArgument()
     * @generated
     */
	EAttribute getPValueReferenceArgument_TypeName();

	/**
     * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbmodule.PVerdict <em>PVerdict</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>PVerdict</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PVerdict
     * @generated
     */
	EClass getPVerdict();

	/**
     * Returns the meta object for enum '{@link com.fineqt.fpb.lib.model.fpbmodule.ByteOrder <em>Byte Order</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Byte Order</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.ByteOrder
     * @generated
     */
	EEnum getByteOrder();

	/**
     * Returns the meta object for enum '{@link com.fineqt.fpb.lib.model.fpbmodule.EncodingType <em>Encoding Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Encoding Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.EncodingType
     * @generated
     */
	EEnum getEncodingType();

	/**
     * Returns the meta object for enum '{@link com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType <em>Flag Field Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Flag Field Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType
     * @generated
     */
	EEnum getFlagFieldType();

	/**
     * Returns the meta object for enum '{@link com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType <em>Module Element Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Module Element Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType
     * @generated
     */
	EEnum getModuleElementType();

	/**
     * Returns the meta object for enum '{@link com.fineqt.fpb.lib.model.fpbmodule.OnelineMode <em>Oneline Mode</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Oneline Mode</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.OnelineMode
     * @generated
     */
	EEnum getOnelineMode();

	/**
     * Returns the meta object for enum '{@link com.fineqt.fpb.lib.model.fpbmodule.PadType <em>Pad Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Pad Type</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PadType
     * @generated
     */
	EEnum getPadType();

	/**
     * Returns the meta object for enum '{@link com.fineqt.fpb.lib.model.fpbmodule.TypeClass <em>Type Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Type Class</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.TypeClass
     * @generated
     */
	EEnum getTypeClass();

	/**
     * Returns the meta object for enum '{@link com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode <em>Type Derivative Mode</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Type Derivative Mode</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode
     * @generated
     */
	EEnum getTypeDerivativeMode();

	/**
     * Returns the meta object for data type '{@link com.fineqt.fpb.lib.model.fpbmodule.ByteOrder <em>Byte Order Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Byte Order Object</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.ByteOrder
     * @model instanceClass="com.fineqt.fpb.lib.model.fpbmodule.ByteOrder"
     *        extendedMetaData="name='ByteOrder:Object' baseType='ByteOrder'"
     * @generated
     */
	EDataType getByteOrderObject();

	/**
     * Returns the meta object for data type '{@link com.fineqt.fpb.lib.model.fpbmodule.EncodingType <em>Encoding Type Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Encoding Type Object</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.EncodingType
     * @model instanceClass="com.fineqt.fpb.lib.model.fpbmodule.EncodingType"
     *        extendedMetaData="name='EncodingType:Object' baseType='EncodingType'"
     * @generated
     */
	EDataType getEncodingTypeObject();

	/**
     * Returns the meta object for data type '{@link com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType <em>Flag Field Type Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Flag Field Type Object</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType
     * @model instanceClass="com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType"
     *        extendedMetaData="name='FlagFieldType:Object' baseType='FlagFieldType'"
     * @generated
     */
	EDataType getFlagFieldTypeObject();

	/**
     * Returns the meta object for data type '{@link com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType <em>Module Element Type Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Module Element Type Object</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType
     * @model instanceClass="com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType"
     *        extendedMetaData="name='ModuleElementType:Object' baseType='ModuleElementType'"
     * @generated
     */
	EDataType getModuleElementTypeObject();

	/**
     * Returns the meta object for data type '{@link com.fineqt.fpb.lib.model.fpbmodule.OnelineMode <em>Oneline Mode Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Oneline Mode Object</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.OnelineMode
     * @model instanceClass="com.fineqt.fpb.lib.model.fpbmodule.OnelineMode"
     *        extendedMetaData="name='OnelineMode:Object' baseType='OnelineMode'"
     * @generated
     */
	EDataType getOnelineModeObject();

	/**
     * Returns the meta object for data type '{@link com.fineqt.fpb.lib.model.fpbmodule.PadType <em>Pad Type Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Pad Type Object</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PadType
     * @model instanceClass="com.fineqt.fpb.lib.model.fpbmodule.PadType"
     *        extendedMetaData="name='PadType:Object' baseType='PadType'"
     * @generated
     */
	EDataType getPadTypeObject();

	/**
     * Returns the meta object for data type '{@link com.fineqt.fpb.lib.model.fpbmodule.TypeClass <em>Type Class Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Type Class Object</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.TypeClass
     * @model instanceClass="com.fineqt.fpb.lib.model.fpbmodule.TypeClass"
     *        extendedMetaData="name='TypeClass:Object' baseType='TypeClass'"
     * @generated
     */
	EDataType getTypeClassObject();

	/**
     * Returns the meta object for data type '{@link com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode <em>Type Derivative Mode Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Type Derivative Mode Object</em>'.
     * @see com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode
     * @model instanceClass="com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode"
     *        extendedMetaData="name='TypeDerivativeMode:Object' baseType='TypeDerivativeMode'"
     * @generated
     */
	EDataType getTypeDerivativeModeObject();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	FpbmoduleFactory getFpbmoduleFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.DocumentRootImpl <em>Document Root</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.DocumentRootImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getDocumentRoot()
         * @generated
         */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
         * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
         * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
         * The meta object literal for the '<em><b>PModule</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DOCUMENT_ROOT__PMODULE = eINSTANCE.getDocumentRoot_PModule();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PAddressImpl <em>PAddress</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PAddressImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPAddress()
         * @generated
         */
		EClass PADDRESS = eINSTANCE.getPAddress();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PArgumentImpl <em>PArgument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PArgumentImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPArgument()
         * @generated
         */
		EClass PARGUMENT = eINSTANCE.getPArgument();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PArgumentGroupImpl <em>PArgument Group</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PArgumentGroupImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPArgumentGroup()
         * @generated
         */
		EClass PARGUMENT_GROUP = eINSTANCE.getPArgumentGroup();

		/**
         * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PARGUMENT_GROUP__ARGUMENTS = eINSTANCE.getPArgumentGroup_Arguments();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PBitstringImpl <em>PBitstring</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PBitstringImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPBitstring()
         * @generated
         */
		EClass PBITSTRING = eINSTANCE.getPBitstring();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PBooleanImpl <em>PBoolean</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PBooleanImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPBoolean()
         * @generated
         */
		EClass PBOOLEAN = eINSTANCE.getPBoolean();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PBooleanArgumentImpl <em>PBoolean Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PBooleanArgumentImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPBooleanArgument()
         * @generated
         */
		EClass PBOOLEAN_ARGUMENT = eINSTANCE.getPBooleanArgument();

		/**
         * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PBOOLEAN_ARGUMENT__DESC = eINSTANCE.getPBooleanArgument_Desc();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PCharstringImpl <em>PCharstring</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PCharstringImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPCharstring()
         * @generated
         */
		EClass PCHARSTRING = eINSTANCE.getPCharstring();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PCharstringArgumentImpl <em>PCharstring Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PCharstringArgumentImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPCharstringArgument()
         * @generated
         */
		EClass PCHARSTRING_ARGUMENT = eINSTANCE.getPCharstringArgument();

		/**
         * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PCHARSTRING_ARGUMENT__DESC = eINSTANCE.getPCharstringArgument_Desc();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PCompoundConstraintImpl <em>PCompound Constraint</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PCompoundConstraintImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPCompoundConstraint()
         * @generated
         */
		EClass PCOMPOUND_CONSTRAINT = eINSTANCE.getPCompoundConstraint();

		/**
         * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PCOMPOUND_CONSTRAINT__CHILDREN = eINSTANCE.getPCompoundConstraint_Children();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PConditionArgumentImpl <em>PCondition Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PConditionArgumentImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPConditionArgument()
         * @generated
         */
		EClass PCONDITION_ARGUMENT = eINSTANCE.getPConditionArgument();

		/**
         * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PCONDITION_ARGUMENT__CONDITION = eINSTANCE.getPConditionArgument_Condition();

		/**
         * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PCONDITION_ARGUMENT__TYPE_NAME = eINSTANCE.getPConditionArgument_TypeName();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PConstantImpl <em>PConstant</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PConstantImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPConstant()
         * @generated
         */
		EClass PCONSTANT = eINSTANCE.getPConstant();

		/**
         * The meta object literal for the '<em><b>Constant ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PCONSTANT__CONSTANT_ID = eINSTANCE.getPConstant_ConstantID();

		/**
         * The meta object literal for the '<em><b>Pmodule</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PCONSTANT__PMODULE = eINSTANCE.getPConstant_Pmodule();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PContainerTypeImpl <em>PContainer Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PContainerTypeImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPContainerType()
         * @generated
         */
		EClass PCONTAINER_TYPE = eINSTANCE.getPContainerType();

		/**
         * The meta object literal for the '<em><b>Pfields</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PCONTAINER_TYPE__PFIELDS = eINSTANCE.getPContainerType_Pfields();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodedElementImpl <em>PEncoded Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodedElementImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEncodedElement()
         * @generated
         */
		EClass PENCODED_ELEMENT = eINSTANCE.getPEncodedElement();

		/**
         * The meta object literal for the '<em><b>Variant</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PENCODED_ELEMENT__VARIANT = eINSTANCE.getPEncodedElement_Variant();

		/**
         * The meta object literal for the '<em><b>Encode</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PENCODED_ELEMENT__ENCODE = eINSTANCE.getPEncodedElement_Encode();

		/**
         * The meta object literal for the '<em><b>Type Encoding Desc</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PENCODED_ELEMENT__TYPE_ENCODING_DESC = eINSTANCE.getPEncodedElement_TypeEncodingDesc();

		/**
         * The meta object literal for the '<em><b>Type Encoding Variant Desc</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PENCODED_ELEMENT__TYPE_ENCODING_VARIANT_DESC = eINSTANCE.getPEncodedElement_TypeEncodingVariantDesc();

		/**
         * The meta object literal for the '<em><b>Type Extension Desc</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PENCODED_ELEMENT__TYPE_EXTENSION_DESC = eINSTANCE.getPEncodedElement_TypeExtensionDesc();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodingVariantImpl <em>PEncoding Variant</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEncodingVariantImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEncodingVariant()
         * @generated
         */
		EClass PENCODING_VARIANT = eINSTANCE.getPEncodingVariant();

		/**
         * The meta object literal for the '<em><b>Encoded Element</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PENCODING_VARIANT__ENCODED_ELEMENT = eINSTANCE.getPEncodingVariant_EncodedElement();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityConstantImpl <em>PEntity Constant</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityConstantImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEntityConstant()
         * @generated
         */
		EClass PENTITY_CONSTANT = eINSTANCE.getPEntityConstant();

		/**
         * The meta object literal for the '<em><b>Matcher</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PENTITY_CONSTANT__MATCHER = eINSTANCE.getPEntityConstant_Matcher();

		/**
         * The meta object literal for the '<em><b>Base Type Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PENTITY_CONSTANT__BASE_TYPE_NAME = eINSTANCE.getPEntityConstant_BaseTypeName();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityEnumSetImpl <em>PEntity Enum Set</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityEnumSetImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEntityEnumSet()
         * @generated
         */
		EClass PENTITY_ENUM_SET = eINSTANCE.getPEntityEnumSet();

		/**
         * The meta object literal for the '<em><b>Enum Items</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PENTITY_ENUM_SET__ENUM_ITEMS = eINSTANCE.getPEntityEnumSet_EnumItems();

		/**
         * The meta object literal for the '<em><b>Base Type Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PENTITY_ENUM_SET__BASE_TYPE_NAME = eINSTANCE.getPEntityEnumSet_BaseTypeName();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityModuleParImpl <em>PEntity Module Par</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityModuleParImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEntityModulePar()
         * @generated
         */
		EClass PENTITY_MODULE_PAR = eINSTANCE.getPEntityModulePar();

		/**
         * The meta object literal for the '<em><b>Matcher</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PENTITY_MODULE_PAR__MATCHER = eINSTANCE.getPEntityModulePar_Matcher();

		/**
         * The meta object literal for the '<em><b>Base Type Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PENTITY_MODULE_PAR__BASE_TYPE_NAME = eINSTANCE.getPEntityModulePar_BaseTypeName();

		/**
         * The meta object literal for the '<em><b>Thread</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PENTITY_MODULE_PAR__THREAD = eINSTANCE.getPEntityModulePar_Thread();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityTypeImpl <em>PEntity Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEntityTypeImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEntityType()
         * @generated
         */
		EClass PENTITY_TYPE = eINSTANCE.getPEntityType();

		/**
         * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PENTITY_TYPE__CONSTRAINT = eINSTANCE.getPEntityType_Constraint();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumeratedImpl <em>PEnumerated</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumeratedImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEnumerated()
         * @generated
         */
		EClass PENUMERATED = eINSTANCE.getPEnumerated();

		/**
         * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PENUMERATED__ITEMS = eINSTANCE.getPEnumerated_Items();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumeratedItemImpl <em>PEnumerated Item</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumeratedItemImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEnumeratedItem()
         * @generated
         */
		EClass PENUMERATED_ITEM = eINSTANCE.getPEnumeratedItem();

		/**
         * The meta object literal for the '<em><b>Enum Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PENUMERATED_ITEM__ENUM_NAME = eINSTANCE.getPEnumeratedItem_EnumName();

		/**
         * The meta object literal for the '<em><b>Enum Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PENUMERATED_ITEM__ENUM_VALUE = eINSTANCE.getPEnumeratedItem_EnumValue();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumItemImpl <em>PEnum Item</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumItemImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEnumItem()
         * @generated
         */
		EClass PENUM_ITEM = eINSTANCE.getPEnumItem();

		/**
         * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PENUM_ITEM__COND = eINSTANCE.getPEnumItem_Cond();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PENUM_ITEM__NAME = eINSTANCE.getPEnumItem_Name();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumSetImpl <em>PEnum Set</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PEnumSetImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPEnumSet()
         * @generated
         */
		EClass PENUM_SET = eINSTANCE.getPEnumSet();

		/**
         * The meta object literal for the '<em><b>Enum Set ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PENUM_SET__ENUM_SET_ID = eINSTANCE.getPEnumSet_EnumSetID();

		/**
         * The meta object literal for the '<em><b>Pmodule</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PENUM_SET__PMODULE = eINSTANCE.getPEnumSet_Pmodule();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFieldImpl <em>PField</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFieldImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPField()
         * @generated
         */
		EClass PFIELD = eINSTANCE.getPField();

		/**
         * The meta object literal for the '<em><b>Field ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PFIELD__FIELD_ID = eINSTANCE.getPField_FieldID();

		/**
         * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PFIELD__OPTIONAL = eINSTANCE.getPField_Optional();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFieldEVImpl <em>PField EV</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFieldEVImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPFieldEV()
         * @generated
         */
		EClass PFIELD_EV = eINSTANCE.getPFieldEV();

		/**
         * The meta object literal for the '<em><b>Prp List</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PFIELD_EV__PRP_LIST = eINSTANCE.getPFieldEV_PrpList();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFloatImpl <em>PFloat</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFloatImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPFloat()
         * @generated
         */
		EClass PFLOAT = eINSTANCE.getPFloat();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbFieldEVImpl <em>PFpb Field EV</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbFieldEVImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPFpbFieldEV()
         * @generated
         */
		EClass PFPB_FIELD_EV = eINSTANCE.getPFpbFieldEV();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbListItemEVImpl <em>PFpb List Item EV</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbListItemEVImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPFpbListItemEV()
         * @generated
         */
		EClass PFPB_LIST_ITEM_EV = eINSTANCE.getPFpbListItemEV();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbModuleEVImpl <em>PFpb Module EV</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbModuleEVImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPFpbModuleEV()
         * @generated
         */
		EClass PFPB_MODULE_EV = eINSTANCE.getPFpbModuleEV();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbTypeEVImpl <em>PFpb Type EV</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PFpbTypeEVImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPFpbTypeEV()
         * @generated
         */
		EClass PFPB_TYPE_EV = eINSTANCE.getPFpbTypeEV();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PHexstringImpl <em>PHexstring</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PHexstringImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPHexstring()
         * @generated
         */
		EClass PHEXSTRING = eINSTANCE.getPHexstring();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PIdentifierArgumentImpl <em>PIdentifier Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PIdentifierArgumentImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPIdentifierArgument()
         * @generated
         */
		EClass PIDENTIFIER_ARGUMENT = eINSTANCE.getPIdentifierArgument();

		/**
         * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIDENTIFIER_ARGUMENT__DESC = eINSTANCE.getPIdentifierArgument_Desc();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportConstantImpl <em>PImport Constant</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PImportConstantImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPImportConstant()
         * @generated
         */
		EClass PIMPORT_CONSTANT = eINSTANCE.getPImportConstant();

		/**
         * The meta object literal for the '<em><b>Imported Constant</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PIMPORT_CONSTANT__IMPORTED_CONSTANT = eINSTANCE.getPImportConstant_ImportedConstant();

		/**
         * The meta object literal for the '<em><b>Imported Constant Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIMPORT_CONSTANT__IMPORTED_CONSTANT_NAME = eINSTANCE.getPImportConstant_ImportedConstantName();

		/**
         * The meta object literal for the '<em><b>Imported Module Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIMPORT_CONSTANT__IMPORTED_MODULE_NAME = eINSTANCE.getPImportConstant_ImportedModuleName();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportElementImpl <em>PImport Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PImportElementImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPImportElement()
         * @generated
         */
		EClass PIMPORT_ELEMENT = eINSTANCE.getPImportElement();

		/**
         * The meta object literal for the '<em><b>Ref Name List</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIMPORT_ELEMENT__REF_NAME_LIST = eINSTANCE.getPImportElement_RefNameList();

		/**
         * The meta object literal for the '<em><b>All Except</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIMPORT_ELEMENT__ALL_EXCEPT = eINSTANCE.getPImportElement_AllExcept();

		/**
         * The meta object literal for the '<em><b>Element Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIMPORT_ELEMENT__ELEMENT_TYPE = eINSTANCE.getPImportElement_ElementType();

		/**
         * The meta object literal for the '<em><b>From Module Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIMPORT_ELEMENT__FROM_MODULE_NAME = eINSTANCE.getPImportElement_FromModuleName();

		/**
         * The meta object literal for the '<em><b>Pmodule</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PIMPORT_ELEMENT__PMODULE = eINSTANCE.getPImportElement_Pmodule();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportEnumSetImpl <em>PImport Enum Set</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PImportEnumSetImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPImportEnumSet()
         * @generated
         */
		EClass PIMPORT_ENUM_SET = eINSTANCE.getPImportEnumSet();

		/**
         * The meta object literal for the '<em><b>Imported Enum Set</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PIMPORT_ENUM_SET__IMPORTED_ENUM_SET = eINSTANCE.getPImportEnumSet_ImportedEnumSet();

		/**
         * The meta object literal for the '<em><b>Imported Enum Set Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIMPORT_ENUM_SET__IMPORTED_ENUM_SET_NAME = eINSTANCE.getPImportEnumSet_ImportedEnumSetName();

		/**
         * The meta object literal for the '<em><b>Imported Module Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIMPORT_ENUM_SET__IMPORTED_MODULE_NAME = eINSTANCE.getPImportEnumSet_ImportedModuleName();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportModuleParImpl <em>PImport Module Par</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PImportModuleParImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPImportModulePar()
         * @generated
         */
		EClass PIMPORT_MODULE_PAR = eINSTANCE.getPImportModulePar();

		/**
         * The meta object literal for the '<em><b>Imported Module Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIMPORT_MODULE_PAR__IMPORTED_MODULE_NAME = eINSTANCE.getPImportModulePar_ImportedModuleName();

		/**
         * The meta object literal for the '<em><b>Imported Module Par</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PIMPORT_MODULE_PAR__IMPORTED_MODULE_PAR = eINSTANCE.getPImportModulePar_ImportedModulePar();

		/**
         * The meta object literal for the '<em><b>Imported Module Part Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIMPORT_MODULE_PAR__IMPORTED_MODULE_PART_NAME = eINSTANCE.getPImportModulePar_ImportedModulePartName();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PImportTypeImpl <em>PImport Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PImportTypeImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPImportType()
         * @generated
         */
		EClass PIMPORT_TYPE = eINSTANCE.getPImportType();

		/**
         * The meta object literal for the '<em><b>Imported Module Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIMPORT_TYPE__IMPORTED_MODULE_NAME = eINSTANCE.getPImportType_ImportedModuleName();

		/**
         * The meta object literal for the '<em><b>Imported Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PIMPORT_TYPE__IMPORTED_TYPE = eINSTANCE.getPImportType_ImportedType();

		/**
         * The meta object literal for the '<em><b>Imported Type Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PIMPORT_TYPE__IMPORTED_TYPE_NAME = eINSTANCE.getPImportType_ImportedTypeName();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PIntegerImpl <em>PInteger</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PIntegerImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPInteger()
         * @generated
         */
		EClass PINTEGER = eINSTANCE.getPInteger();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PIntegerArgumentImpl <em>PInteger Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PIntegerArgumentImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPIntegerArgument()
         * @generated
         */
		EClass PINTEGER_ARGUMENT = eINSTANCE.getPIntegerArgument();

		/**
         * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PINTEGER_ARGUMENT__DESC = eINSTANCE.getPIntegerArgument_Desc();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PItemFieldImpl <em>PItem Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PItemFieldImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPItemField()
         * @generated
         */
        EClass PITEM_FIELD = eINSTANCE.getPItemField();

        /**
         * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PITEM_FIELD__CONSTRAINT = eINSTANCE.getPItemField_Constraint();

        /**
         * The meta object literal for the '<em><b>Enum Items</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PITEM_FIELD__ENUM_ITEMS = eINSTANCE.getPItemField_EnumItems();

        /**
         * The meta object literal for the '<em><b>Enum Ref</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PITEM_FIELD__ENUM_REF = eINSTANCE.getPItemField_EnumRef();

        /**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PLengthConstraintImpl <em>PLength Constraint</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PLengthConstraintImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPLengthConstraint()
         * @generated
         */
		EClass PLENGTH_CONSTRAINT = eINSTANCE.getPLengthConstraint();

		/**
         * The meta object literal for the '<em><b>Lower Bound</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PLENGTH_CONSTRAINT__LOWER_BOUND = eINSTANCE.getPLengthConstraint_LowerBound();

		/**
         * The meta object literal for the '<em><b>Upper Bound</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PLENGTH_CONSTRAINT__UPPER_BOUND = eINSTANCE.getPLengthConstraint_UpperBound();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PListArgumentImpl <em>PList Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PListArgumentImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPListArgument()
         * @generated
         */
		EClass PLIST_ARGUMENT = eINSTANCE.getPListArgument();

		/**
         * The meta object literal for the '<em><b>Group</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PLIST_ARGUMENT__GROUP = eINSTANCE.getPListArgument_Group();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PListConstraintImpl <em>PList Constraint</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PListConstraintImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPListConstraint()
         * @generated
         */
		EClass PLIST_CONSTRAINT = eINSTANCE.getPListConstraint();

		/**
         * The meta object literal for the '<em><b>Matcher</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PLIST_CONSTRAINT__MATCHER = eINSTANCE.getPListConstraint_Matcher();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PListItemImpl <em>PList Item</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PListItemImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPListItem()
         * @generated
         */
		EClass PLIST_ITEM = eINSTANCE.getPListItem();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PListItemEVImpl <em>PList Item EV</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PListItemEVImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPListItemEV()
         * @generated
         */
		EClass PLIST_ITEM_EV = eINSTANCE.getPListItemEV();

		/**
         * The meta object literal for the '<em><b>Prp List</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PLIST_ITEM_EV__PRP_LIST = eINSTANCE.getPListItemEV_PrpList();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PListTypeImpl <em>PList Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PListTypeImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPListType()
         * @generated
         */
		EClass PLIST_TYPE = eINSTANCE.getPListType();

		/**
         * The meta object literal for the '<em><b>Item</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PLIST_TYPE__ITEM = eINSTANCE.getPListType_Item();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl <em>PModule</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPModule()
         * @generated
         */
		EClass PMODULE = eINSTANCE.getPModule();

		/**
         * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PMODULE__TYPES = eINSTANCE.getPModule_Types();

		/**
         * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PMODULE__CONSTANTS = eINSTANCE.getPModule_Constants();

		/**
         * The meta object literal for the '<em><b>Templates</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PMODULE__TEMPLATES = eINSTANCE.getPModule_Templates();

		/**
         * The meta object literal for the '<em><b>Module Pars</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PMODULE__MODULE_PARS = eINSTANCE.getPModule_ModulePars();

		/**
         * The meta object literal for the '<em><b>Import Elements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PMODULE__IMPORT_ELEMENTS = eINSTANCE.getPModule_ImportElements();

		/**
         * The meta object literal for the '<em><b>Enum Sets</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PMODULE__ENUM_SETS = eINSTANCE.getPModule_EnumSets();

		/**
         * The meta object literal for the '<em><b>Factory Java Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PMODULE__FACTORY_JAVA_CLASS = eINSTANCE.getPModule_FactoryJavaClass();

		/**
         * The meta object literal for the '<em><b>Module Java Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PMODULE__MODULE_JAVA_CLASS = eINSTANCE.getPModule_ModuleJavaClass();

		/**
         * The meta object literal for the '<em><b>Type Ev Factory Java Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PMODULE__TYPE_EV_FACTORY_JAVA_CLASS = eINSTANCE.getPModule_TypeEvFactoryJavaClass();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleEVImpl <em>PModule EV</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleEVImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPModuleEV()
         * @generated
         */
		EClass PMODULE_EV = eINSTANCE.getPModuleEV();

		/**
         * The meta object literal for the '<em><b>Prp List</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PMODULE_EV__PRP_LIST = eINSTANCE.getPModuleEV_PrpList();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleParImpl <em>PModule Par</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleParImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPModulePar()
         * @generated
         */
		EClass PMODULE_PAR = eINSTANCE.getPModulePar();

		/**
         * The meta object literal for the '<em><b>Module Par ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PMODULE_PAR__MODULE_PAR_ID = eINSTANCE.getPModulePar_ModuleParID();

		/**
         * The meta object literal for the '<em><b>Pmodule</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PMODULE_PAR__PMODULE = eINSTANCE.getPModulePar_Pmodule();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PObjidImpl <em>PObjid</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PObjidImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPObjid()
         * @generated
         */
		EClass POBJID = eINSTANCE.getPObjid();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.POctetstringImpl <em>POctetstring</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.POctetstringImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPOctetstring()
         * @generated
         */
		EClass POCTETSTRING = eINSTANCE.getPOctetstring();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PPatternConstraintImpl <em>PPattern Constraint</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PPatternConstraintImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPPatternConstraint()
         * @generated
         */
		EClass PPATTERN_CONSTRAINT = eINSTANCE.getPPatternConstraint();

		/**
         * The meta object literal for the '<em><b>Matcher</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PPATTERN_CONSTRAINT__MATCHER = eINSTANCE.getPPatternConstraint_Matcher();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PPrimitiveTypeImpl <em>PPrimitive Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PPrimitiveTypeImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPPrimitiveType()
         * @generated
         */
		EClass PPRIMITIVE_TYPE = eINSTANCE.getPPrimitiveType();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PPropertyImpl <em>PProperty</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PPropertyImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPProperty()
         * @generated
         */
		EClass PPROPERTY = eINSTANCE.getPProperty();

		/**
         * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PPROPERTY__GROUPS = eINSTANCE.getPProperty_Groups();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PPropertyListImpl <em>PProperty List</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PPropertyListImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPPropertyList()
         * @generated
         */
		EClass PPROPERTY_LIST = eINSTANCE.getPPropertyList();

		/**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PPROPERTY_LIST__PROPERTIES = eINSTANCE.getPPropertyList_Properties();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PRecordImpl <em>PRecord</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PRecordImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPRecord()
         * @generated
         */
		EClass PRECORD = eINSTANCE.getPRecord();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PRecordOfImpl <em>PRecord Of</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PRecordOfImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPRecordOf()
         * @generated
         */
		EClass PRECORD_OF = eINSTANCE.getPRecordOf();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PSetImpl <em>PSet</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PSetImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPSet()
         * @generated
         */
		EClass PSET = eINSTANCE.getPSet();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PSetOfImpl <em>PSet Of</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PSetOfImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPSetOf()
         * @generated
         */
		EClass PSET_OF = eINSTANCE.getPSetOf();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PSingleArgumentImpl <em>PSingle Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PSingleArgumentImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPSingleArgument()
         * @generated
         */
		EClass PSINGLE_ARGUMENT = eINSTANCE.getPSingleArgument();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PStringTypeImpl <em>PString Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PStringTypeImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPStringType()
         * @generated
         */
		EClass PSTRING_TYPE = eINSTANCE.getPStringType();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PSubTypeImpl <em>PSub Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PSubTypeImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPSubType()
         * @generated
         */
		EClass PSUB_TYPE = eINSTANCE.getPSubType();

		/**
         * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PSUB_TYPE__CONSTRAINT = eINSTANCE.getPSubType_Constraint();

		/**
         * The meta object literal for the '<em><b>Super Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PSUB_TYPE__SUPER_TYPE = eINSTANCE.getPSubType_SuperType();

		/**
         * The meta object literal for the '<em><b>Super Type Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PSUB_TYPE__SUPER_TYPE_NAME = eINSTANCE.getPSubType_SuperTypeName();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeImpl <em>PType</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPType()
         * @generated
         */
		EClass PTYPE = eINSTANCE.getPType();

		/**
         * The meta object literal for the '<em><b>Container Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PTYPE__CONTAINER_TYPE = eINSTANCE.getPType_ContainerType();

		/**
         * The meta object literal for the '<em><b>Derivative Mode</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PTYPE__DERIVATIVE_MODE = eINSTANCE.getPType_DerivativeMode();

		/**
         * The meta object literal for the '<em><b>Java Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PTYPE__JAVA_CLASS = eINSTANCE.getPType_JavaClass();

		/**
         * The meta object literal for the '<em><b>List Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PTYPE__LIST_TYPE = eINSTANCE.getPType_ListType();

		/**
         * The meta object literal for the '<em><b>Primitive Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PTYPE__PRIMITIVE_TYPE = eINSTANCE.getPType_PrimitiveType();

		/**
         * The meta object literal for the '<em><b>Type Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PTYPE__TYPE_CLASS = eINSTANCE.getPType_TypeClass();

		/**
         * The meta object literal for the '<em><b>Type ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PTYPE__TYPE_ID = eINSTANCE.getPType_TypeID();

		/**
         * The meta object literal for the '<em><b>Pmodule</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PTYPE__PMODULE = eINSTANCE.getPType_Pmodule();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeConstraintImpl <em>PType Constraint</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeConstraintImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPTypeConstraint()
         * @generated
         */
		EClass PTYPE_CONSTRAINT = eINSTANCE.getPTypeConstraint();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypedElementImpl <em>PTyped Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PTypedElementImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPTypedElement()
         * @generated
         */
		EClass PTYPED_ELEMENT = eINSTANCE.getPTypedElement();

		/**
         * The meta object literal for the '<em><b>Ptype</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PTYPED_ELEMENT__PTYPE = eINSTANCE.getPTypedElement_Ptype();

		/**
         * The meta object literal for the '<em><b>Ptype Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PTYPED_ELEMENT__PTYPE_NAME = eINSTANCE.getPTypedElement_PtypeName();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeEVImpl <em>PType EV</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeEVImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPTypeEV()
         * @generated
         */
		EClass PTYPE_EV = eINSTANCE.getPTypeEV();

		/**
         * The meta object literal for the '<em><b>Prp List</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PTYPE_EV__PRP_LIST = eINSTANCE.getPTypeEV_PrpList();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeReferenceArgumentImpl <em>PType Reference Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PTypeReferenceArgumentImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPTypeReferenceArgument()
         * @generated
         */
		EClass PTYPE_REFERENCE_ARGUMENT = eINSTANCE.getPTypeReferenceArgument();

		/**
         * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PTYPE_REFERENCE_ARGUMENT__TYPE_NAME = eINSTANCE.getPTypeReferenceArgument_TypeName();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PUnionImpl <em>PUnion</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PUnionImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPUnion()
         * @generated
         */
		EClass PUNION = eINSTANCE.getPUnion();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PUniversalCharstringImpl <em>PUniversal Charstring</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PUniversalCharstringImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPUniversalCharstring()
         * @generated
         */
		EClass PUNIVERSAL_CHARSTRING = eINSTANCE.getPUniversalCharstring();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PValueReferenceArgumentImpl <em>PValue Reference Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PValueReferenceArgumentImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPValueReferenceArgument()
         * @generated
         */
		EClass PVALUE_REFERENCE_ARGUMENT = eINSTANCE.getPValueReferenceArgument();

		/**
         * The meta object literal for the '<em><b>Value Ref</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PVALUE_REFERENCE_ARGUMENT__VALUE_REF = eINSTANCE.getPValueReferenceArgument_ValueRef();

		/**
         * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PVALUE_REFERENCE_ARGUMENT__TYPE_NAME = eINSTANCE.getPValueReferenceArgument_TypeName();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PVerdictImpl <em>PVerdict</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.PVerdictImpl
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPVerdict()
         * @generated
         */
		EClass PVERDICT = eINSTANCE.getPVerdict();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.ByteOrder <em>Byte Order</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.ByteOrder
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getByteOrder()
         * @generated
         */
		EEnum BYTE_ORDER = eINSTANCE.getByteOrder();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.EncodingType <em>Encoding Type</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.EncodingType
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getEncodingType()
         * @generated
         */
		EEnum ENCODING_TYPE = eINSTANCE.getEncodingType();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType <em>Flag Field Type</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getFlagFieldType()
         * @generated
         */
		EEnum FLAG_FIELD_TYPE = eINSTANCE.getFlagFieldType();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType <em>Module Element Type</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getModuleElementType()
         * @generated
         */
		EEnum MODULE_ELEMENT_TYPE = eINSTANCE.getModuleElementType();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.OnelineMode <em>Oneline Mode</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.OnelineMode
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getOnelineMode()
         * @generated
         */
		EEnum ONELINE_MODE = eINSTANCE.getOnelineMode();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.PadType <em>Pad Type</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.PadType
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPadType()
         * @generated
         */
		EEnum PAD_TYPE = eINSTANCE.getPadType();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.TypeClass <em>Type Class</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.TypeClass
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getTypeClass()
         * @generated
         */
		EEnum TYPE_CLASS = eINSTANCE.getTypeClass();

		/**
         * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode <em>Type Derivative Mode</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getTypeDerivativeMode()
         * @generated
         */
		EEnum TYPE_DERIVATIVE_MODE = eINSTANCE.getTypeDerivativeMode();

		/**
         * The meta object literal for the '<em>Byte Order Object</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.ByteOrder
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getByteOrderObject()
         * @generated
         */
		EDataType BYTE_ORDER_OBJECT = eINSTANCE.getByteOrderObject();

		/**
         * The meta object literal for the '<em>Encoding Type Object</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.EncodingType
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getEncodingTypeObject()
         * @generated
         */
		EDataType ENCODING_TYPE_OBJECT = eINSTANCE.getEncodingTypeObject();

		/**
         * The meta object literal for the '<em>Flag Field Type Object</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getFlagFieldTypeObject()
         * @generated
         */
		EDataType FLAG_FIELD_TYPE_OBJECT = eINSTANCE.getFlagFieldTypeObject();

		/**
         * The meta object literal for the '<em>Module Element Type Object</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getModuleElementTypeObject()
         * @generated
         */
		EDataType MODULE_ELEMENT_TYPE_OBJECT = eINSTANCE.getModuleElementTypeObject();

		/**
         * The meta object literal for the '<em>Oneline Mode Object</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.OnelineMode
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getOnelineModeObject()
         * @generated
         */
		EDataType ONELINE_MODE_OBJECT = eINSTANCE.getOnelineModeObject();

		/**
         * The meta object literal for the '<em>Pad Type Object</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.PadType
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getPadTypeObject()
         * @generated
         */
		EDataType PAD_TYPE_OBJECT = eINSTANCE.getPadTypeObject();

		/**
         * The meta object literal for the '<em>Type Class Object</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.TypeClass
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getTypeClassObject()
         * @generated
         */
		EDataType TYPE_CLASS_OBJECT = eINSTANCE.getTypeClassObject();

		/**
         * The meta object literal for the '<em>Type Derivative Mode Object</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode
         * @see com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmodulePackageImpl#getTypeDerivativeModeObject()
         * @generated
         */
		EDataType TYPE_DERIVATIVE_MODE_OBJECT = eINSTANCE.getTypeDerivativeModeObject();

	}

} //FpbmodulePackage
