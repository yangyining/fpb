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

import com.fineqt.fpb.lib.model.fpbmodule.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmoduleFactory;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType;
import com.fineqt.fpb.lib.model.fpbmodule.OnelineMode;
import com.fineqt.fpb.lib.model.fpbmodule.PAddress;
import com.fineqt.fpb.lib.model.fpbmodule.PArgumentGroup;
import com.fineqt.fpb.lib.model.fpbmodule.PBitstring;
import com.fineqt.fpb.lib.model.fpbmodule.PBoolean;
import com.fineqt.fpb.lib.model.fpbmodule.PBooleanArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PCharstring;
import com.fineqt.fpb.lib.model.fpbmodule.PCharstringArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PCompoundConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumItem;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumerated;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem;
import com.fineqt.fpb.lib.model.fpbmodule.PField;
import com.fineqt.fpb.lib.model.fpbmodule.PFieldEV;
import com.fineqt.fpb.lib.model.fpbmodule.PFloat;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbFieldEV;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbModuleEV;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PHexstring;
import com.fineqt.fpb.lib.model.fpbmodule.PIdentifierArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PImportConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PImportElement;
import com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PImportType;
import com.fineqt.fpb.lib.model.fpbmodule.PInteger;
import com.fineqt.fpb.lib.model.fpbmodule.PIntegerArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PListArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PListConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.PModuleEV;
import com.fineqt.fpb.lib.model.fpbmodule.PObjid;
import com.fineqt.fpb.lib.model.fpbmodule.POctetstring;
import com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PProperty;
import com.fineqt.fpb.lib.model.fpbmodule.PPropertyList;
import com.fineqt.fpb.lib.model.fpbmodule.PRecord;
import com.fineqt.fpb.lib.model.fpbmodule.PRecordOf;
import com.fineqt.fpb.lib.model.fpbmodule.PSet;
import com.fineqt.fpb.lib.model.fpbmodule.PSetOf;
import com.fineqt.fpb.lib.model.fpbmodule.PSubType;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PUnion;
import com.fineqt.fpb.lib.model.fpbmodule.PUniversalCharstring;
import com.fineqt.fpb.lib.model.fpbmodule.PVerdict;
import com.fineqt.fpb.lib.model.fpbmodule.PadType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FpbmoduleFactoryImpl extends EFactoryImpl implements FpbmoduleFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static FpbmoduleFactory init() {
        try {
            FpbmoduleFactory theFpbmoduleFactory = (FpbmoduleFactory)EPackage.Registry.INSTANCE.getEFactory("http://fpbmodule.model.lib.fpb.fineqt.com"); 
            if (theFpbmoduleFactory != null) {
                return theFpbmoduleFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new FpbmoduleFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FpbmoduleFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case FpbmodulePackage.DOCUMENT_ROOT: return createDocumentRoot();
            case FpbmodulePackage.PADDRESS: return createPAddress();
            case FpbmodulePackage.PARGUMENT_GROUP: return createPArgumentGroup();
            case FpbmodulePackage.PBITSTRING: return createPBitstring();
            case FpbmodulePackage.PBOOLEAN: return createPBoolean();
            case FpbmodulePackage.PBOOLEAN_ARGUMENT: return createPBooleanArgument();
            case FpbmodulePackage.PCHARSTRING: return createPCharstring();
            case FpbmodulePackage.PCHARSTRING_ARGUMENT: return createPCharstringArgument();
            case FpbmodulePackage.PCOMPOUND_CONSTRAINT: return createPCompoundConstraint();
            case FpbmodulePackage.PCONDITION_ARGUMENT: return createPConditionArgument();
            case FpbmodulePackage.PENTITY_CONSTANT: return createPEntityConstant();
            case FpbmodulePackage.PENTITY_ENUM_SET: return createPEntityEnumSet();
            case FpbmodulePackage.PENTITY_MODULE_PAR: return createPEntityModulePar();
            case FpbmodulePackage.PENUMERATED: return createPEnumerated();
            case FpbmodulePackage.PENUMERATED_ITEM: return createPEnumeratedItem();
            case FpbmodulePackage.PENUM_ITEM: return createPEnumItem();
            case FpbmodulePackage.PFIELD: return createPField();
            case FpbmodulePackage.PFIELD_EV: return createPFieldEV();
            case FpbmodulePackage.PFLOAT: return createPFloat();
            case FpbmodulePackage.PFPB_FIELD_EV: return createPFpbFieldEV();
            case FpbmodulePackage.PFPB_LIST_ITEM_EV: return createPFpbListItemEV();
            case FpbmodulePackage.PFPB_MODULE_EV: return createPFpbModuleEV();
            case FpbmodulePackage.PFPB_TYPE_EV: return createPFpbTypeEV();
            case FpbmodulePackage.PHEXSTRING: return createPHexstring();
            case FpbmodulePackage.PIDENTIFIER_ARGUMENT: return createPIdentifierArgument();
            case FpbmodulePackage.PIMPORT_CONSTANT: return createPImportConstant();
            case FpbmodulePackage.PIMPORT_ELEMENT: return createPImportElement();
            case FpbmodulePackage.PIMPORT_ENUM_SET: return createPImportEnumSet();
            case FpbmodulePackage.PIMPORT_MODULE_PAR: return createPImportModulePar();
            case FpbmodulePackage.PIMPORT_TYPE: return createPImportType();
            case FpbmodulePackage.PINTEGER: return createPInteger();
            case FpbmodulePackage.PINTEGER_ARGUMENT: return createPIntegerArgument();
            case FpbmodulePackage.PITEM_FIELD: return createPItemField();
            case FpbmodulePackage.PLENGTH_CONSTRAINT: return createPLengthConstraint();
            case FpbmodulePackage.PLIST_ARGUMENT: return createPListArgument();
            case FpbmodulePackage.PLIST_CONSTRAINT: return createPListConstraint();
            case FpbmodulePackage.PLIST_ITEM: return createPListItem();
            case FpbmodulePackage.PLIST_ITEM_EV: return createPListItemEV();
            case FpbmodulePackage.PMODULE: return createPModule();
            case FpbmodulePackage.PMODULE_EV: return createPModuleEV();
            case FpbmodulePackage.POBJID: return createPObjid();
            case FpbmodulePackage.POCTETSTRING: return createPOctetstring();
            case FpbmodulePackage.PPATTERN_CONSTRAINT: return createPPatternConstraint();
            case FpbmodulePackage.PPROPERTY: return createPProperty();
            case FpbmodulePackage.PPROPERTY_LIST: return createPPropertyList();
            case FpbmodulePackage.PRECORD: return createPRecord();
            case FpbmodulePackage.PRECORD_OF: return createPRecordOf();
            case FpbmodulePackage.PSET: return createPSet();
            case FpbmodulePackage.PSET_OF: return createPSetOf();
            case FpbmodulePackage.PSUB_TYPE: return createPSubType();
            case FpbmodulePackage.PTYPE_CONSTRAINT: return createPTypeConstraint();
            case FpbmodulePackage.PTYPE_EV: return createPTypeEV();
            case FpbmodulePackage.PTYPE_REFERENCE_ARGUMENT: return createPTypeReferenceArgument();
            case FpbmodulePackage.PUNION: return createPUnion();
            case FpbmodulePackage.PUNIVERSAL_CHARSTRING: return createPUniversalCharstring();
            case FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT: return createPValueReferenceArgument();
            case FpbmodulePackage.PVERDICT: return createPVerdict();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case FpbmodulePackage.BYTE_ORDER:
                return createByteOrderFromString(eDataType, initialValue);
            case FpbmodulePackage.ENCODING_TYPE:
                return createEncodingTypeFromString(eDataType, initialValue);
            case FpbmodulePackage.FLAG_FIELD_TYPE:
                return createFlagFieldTypeFromString(eDataType, initialValue);
            case FpbmodulePackage.MODULE_ELEMENT_TYPE:
                return createModuleElementTypeFromString(eDataType, initialValue);
            case FpbmodulePackage.ONELINE_MODE:
                return createOnelineModeFromString(eDataType, initialValue);
            case FpbmodulePackage.PAD_TYPE:
                return createPadTypeFromString(eDataType, initialValue);
            case FpbmodulePackage.TYPE_CLASS:
                return createTypeClassFromString(eDataType, initialValue);
            case FpbmodulePackage.TYPE_DERIVATIVE_MODE:
                return createTypeDerivativeModeFromString(eDataType, initialValue);
            case FpbmodulePackage.BYTE_ORDER_OBJECT:
                return createByteOrderObjectFromString(eDataType, initialValue);
            case FpbmodulePackage.ENCODING_TYPE_OBJECT:
                return createEncodingTypeObjectFromString(eDataType, initialValue);
            case FpbmodulePackage.FLAG_FIELD_TYPE_OBJECT:
                return createFlagFieldTypeObjectFromString(eDataType, initialValue);
            case FpbmodulePackage.MODULE_ELEMENT_TYPE_OBJECT:
                return createModuleElementTypeObjectFromString(eDataType, initialValue);
            case FpbmodulePackage.ONELINE_MODE_OBJECT:
                return createOnelineModeObjectFromString(eDataType, initialValue);
            case FpbmodulePackage.PAD_TYPE_OBJECT:
                return createPadTypeObjectFromString(eDataType, initialValue);
            case FpbmodulePackage.TYPE_CLASS_OBJECT:
                return createTypeClassObjectFromString(eDataType, initialValue);
            case FpbmodulePackage.TYPE_DERIVATIVE_MODE_OBJECT:
                return createTypeDerivativeModeObjectFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case FpbmodulePackage.BYTE_ORDER:
                return convertByteOrderToString(eDataType, instanceValue);
            case FpbmodulePackage.ENCODING_TYPE:
                return convertEncodingTypeToString(eDataType, instanceValue);
            case FpbmodulePackage.FLAG_FIELD_TYPE:
                return convertFlagFieldTypeToString(eDataType, instanceValue);
            case FpbmodulePackage.MODULE_ELEMENT_TYPE:
                return convertModuleElementTypeToString(eDataType, instanceValue);
            case FpbmodulePackage.ONELINE_MODE:
                return convertOnelineModeToString(eDataType, instanceValue);
            case FpbmodulePackage.PAD_TYPE:
                return convertPadTypeToString(eDataType, instanceValue);
            case FpbmodulePackage.TYPE_CLASS:
                return convertTypeClassToString(eDataType, instanceValue);
            case FpbmodulePackage.TYPE_DERIVATIVE_MODE:
                return convertTypeDerivativeModeToString(eDataType, instanceValue);
            case FpbmodulePackage.BYTE_ORDER_OBJECT:
                return convertByteOrderObjectToString(eDataType, instanceValue);
            case FpbmodulePackage.ENCODING_TYPE_OBJECT:
                return convertEncodingTypeObjectToString(eDataType, instanceValue);
            case FpbmodulePackage.FLAG_FIELD_TYPE_OBJECT:
                return convertFlagFieldTypeObjectToString(eDataType, instanceValue);
            case FpbmodulePackage.MODULE_ELEMENT_TYPE_OBJECT:
                return convertModuleElementTypeObjectToString(eDataType, instanceValue);
            case FpbmodulePackage.ONELINE_MODE_OBJECT:
                return convertOnelineModeObjectToString(eDataType, instanceValue);
            case FpbmodulePackage.PAD_TYPE_OBJECT:
                return convertPadTypeObjectToString(eDataType, instanceValue);
            case FpbmodulePackage.TYPE_CLASS_OBJECT:
                return convertTypeClassObjectToString(eDataType, instanceValue);
            case FpbmodulePackage.TYPE_DERIVATIVE_MODE_OBJECT:
                return convertTypeDerivativeModeObjectToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DocumentRoot createDocumentRoot() {
        DocumentRootImpl documentRoot = new DocumentRootImpl();
        return documentRoot;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PAddress createPAddress() {
        PAddressImpl pAddress = new PAddressImpl();
        return pAddress;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PArgumentGroup createPArgumentGroup() {
        PArgumentGroupImpl pArgumentGroup = new PArgumentGroupImpl();
        return pArgumentGroup;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PBitstring createPBitstring() {
        PBitstringImpl pBitstring = new PBitstringImpl();
        return pBitstring;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PBoolean createPBoolean() {
        PBooleanImpl pBoolean = new PBooleanImpl();
        return pBoolean;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PBooleanArgument createPBooleanArgument() {
        PBooleanArgumentImpl pBooleanArgument = new PBooleanArgumentImpl();
        return pBooleanArgument;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PCharstring createPCharstring() {
        PCharstringImpl pCharstring = new PCharstringImpl();
        return pCharstring;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PCharstringArgument createPCharstringArgument() {
        PCharstringArgumentImpl pCharstringArgument = new PCharstringArgumentImpl();
        return pCharstringArgument;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PCompoundConstraint createPCompoundConstraint() {
        PCompoundConstraintImpl pCompoundConstraint = new PCompoundConstraintImpl();
        return pCompoundConstraint;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PConditionArgument createPConditionArgument() {
        PConditionArgumentImpl pConditionArgument = new PConditionArgumentImpl();
        return pConditionArgument;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PEntityConstant createPEntityConstant() {
        PEntityConstantImpl pEntityConstant = new PEntityConstantImpl();
        return pEntityConstant;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PEntityEnumSet createPEntityEnumSet() {
        PEntityEnumSetImpl pEntityEnumSet = new PEntityEnumSetImpl();
        return pEntityEnumSet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PEntityModulePar createPEntityModulePar() {
        PEntityModuleParImpl pEntityModulePar = new PEntityModuleParImpl();
        return pEntityModulePar;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PEnumerated createPEnumerated() {
        PEnumeratedImpl pEnumerated = new PEnumeratedImpl();
        return pEnumerated;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PEnumeratedItem createPEnumeratedItem() {
        PEnumeratedItemImpl pEnumeratedItem = new PEnumeratedItemImpl();
        return pEnumeratedItem;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PEnumItem createPEnumItem() {
        PEnumItemImpl pEnumItem = new PEnumItemImpl();
        return pEnumItem;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PField createPField() {
        PFieldImpl pField = new PFieldImpl();
        return pField;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PFieldEV createPFieldEV() {
        PFieldEVImpl pFieldEV = new PFieldEVImpl();
        return pFieldEV;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PFloat createPFloat() {
        PFloatImpl pFloat = new PFloatImpl();
        return pFloat;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PFpbFieldEV createPFpbFieldEV() {
        PFpbFieldEVImpl pFpbFieldEV = new PFpbFieldEVImpl();
        return pFpbFieldEV;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PFpbListItemEV createPFpbListItemEV() {
        PFpbListItemEVImpl pFpbListItemEV = new PFpbListItemEVImpl();
        return pFpbListItemEV;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PFpbModuleEV createPFpbModuleEV() {
        PFpbModuleEVImpl pFpbModuleEV = new PFpbModuleEVImpl();
        return pFpbModuleEV;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PFpbTypeEV createPFpbTypeEV() {
        PFpbTypeEVImpl pFpbTypeEV = new PFpbTypeEVImpl();
        return pFpbTypeEV;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PHexstring createPHexstring() {
        PHexstringImpl pHexstring = new PHexstringImpl();
        return pHexstring;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PIdentifierArgument createPIdentifierArgument() {
        PIdentifierArgumentImpl pIdentifierArgument = new PIdentifierArgumentImpl();
        return pIdentifierArgument;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PImportConstant createPImportConstant() {
        PImportConstantImpl pImportConstant = new PImportConstantImpl();
        return pImportConstant;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PImportElement createPImportElement() {
        PImportElementImpl pImportElement = new PImportElementImpl();
        return pImportElement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PImportEnumSet createPImportEnumSet() {
        PImportEnumSetImpl pImportEnumSet = new PImportEnumSetImpl();
        return pImportEnumSet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PImportModulePar createPImportModulePar() {
        PImportModuleParImpl pImportModulePar = new PImportModuleParImpl();
        return pImportModulePar;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PImportType createPImportType() {
        PImportTypeImpl pImportType = new PImportTypeImpl();
        return pImportType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PInteger createPInteger() {
        PIntegerImpl pInteger = new PIntegerImpl();
        return pInteger;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PIntegerArgument createPIntegerArgument() {
        PIntegerArgumentImpl pIntegerArgument = new PIntegerArgumentImpl();
        return pIntegerArgument;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PItemField createPItemField() {
        PItemFieldImpl pItemField = new PItemFieldImpl();
        return pItemField;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PLengthConstraint createPLengthConstraint() {
        PLengthConstraintImpl pLengthConstraint = new PLengthConstraintImpl();
        return pLengthConstraint;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PListArgument createPListArgument() {
        PListArgumentImpl pListArgument = new PListArgumentImpl();
        return pListArgument;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PListConstraint createPListConstraint() {
        PListConstraintImpl pListConstraint = new PListConstraintImpl();
        return pListConstraint;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PListItem createPListItem() {
        PListItemImpl pListItem = new PListItemImpl();
        return pListItem;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PListItemEV createPListItemEV() {
        PListItemEVImpl pListItemEV = new PListItemEVImpl();
        return pListItemEV;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PModule createPModule() {
        PModuleImpl pModule = new PModuleImpl();
        return pModule;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PModuleEV createPModuleEV() {
        PModuleEVImpl pModuleEV = new PModuleEVImpl();
        return pModuleEV;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PObjid createPObjid() {
        PObjidImpl pObjid = new PObjidImpl();
        return pObjid;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public POctetstring createPOctetstring() {
        POctetstringImpl pOctetstring = new POctetstringImpl();
        return pOctetstring;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PPatternConstraint createPPatternConstraint() {
        PPatternConstraintImpl pPatternConstraint = new PPatternConstraintImpl();
        return pPatternConstraint;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PProperty createPProperty() {
        PPropertyImpl pProperty = new PPropertyImpl();
        return pProperty;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PPropertyList createPPropertyList() {
        PPropertyListImpl pPropertyList = new PPropertyListImpl();
        return pPropertyList;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PRecord createPRecord() {
        PRecordImpl pRecord = new PRecordImpl();
        return pRecord;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PRecordOf createPRecordOf() {
        PRecordOfImpl pRecordOf = new PRecordOfImpl();
        return pRecordOf;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PSet createPSet() {
        PSetImpl pSet = new PSetImpl();
        return pSet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PSetOf createPSetOf() {
        PSetOfImpl pSetOf = new PSetOfImpl();
        return pSetOf;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PSubType createPSubType() {
        PSubTypeImpl pSubType = new PSubTypeImpl();
        return pSubType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PTypeConstraint createPTypeConstraint() {
        PTypeConstraintImpl pTypeConstraint = new PTypeConstraintImpl();
        return pTypeConstraint;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PTypeEV createPTypeEV() {
        PTypeEVImpl pTypeEV = new PTypeEVImpl();
        return pTypeEV;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PTypeReferenceArgument createPTypeReferenceArgument() {
        PTypeReferenceArgumentImpl pTypeReferenceArgument = new PTypeReferenceArgumentImpl();
        return pTypeReferenceArgument;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PUnion createPUnion() {
        PUnionImpl pUnion = new PUnionImpl();
        return pUnion;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PUniversalCharstring createPUniversalCharstring() {
        PUniversalCharstringImpl pUniversalCharstring = new PUniversalCharstringImpl();
        return pUniversalCharstring;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PValueReferenceArgument createPValueReferenceArgument() {
        PValueReferenceArgumentImpl pValueReferenceArgument = new PValueReferenceArgumentImpl();
        return pValueReferenceArgument;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PVerdict createPVerdict() {
        PVerdictImpl pVerdict = new PVerdictImpl();
        return pVerdict;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ByteOrder createByteOrderFromString(EDataType eDataType, String initialValue) {
        ByteOrder result = ByteOrder.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertByteOrderToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EncodingType createEncodingTypeFromString(EDataType eDataType, String initialValue) {
        EncodingType result = EncodingType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEncodingTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FlagFieldType createFlagFieldTypeFromString(EDataType eDataType, String initialValue) {
        FlagFieldType result = FlagFieldType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertFlagFieldTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ModuleElementType createModuleElementTypeFromString(EDataType eDataType, String initialValue) {
        ModuleElementType result = ModuleElementType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertModuleElementTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OnelineMode createOnelineModeFromString(EDataType eDataType, String initialValue) {
        OnelineMode result = OnelineMode.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertOnelineModeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PadType createPadTypeFromString(EDataType eDataType, String initialValue) {
        PadType result = PadType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertPadTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeClass createTypeClassFromString(EDataType eDataType, String initialValue) {
        TypeClass result = TypeClass.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertTypeClassToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeDerivativeMode createTypeDerivativeModeFromString(EDataType eDataType, String initialValue) {
        TypeDerivativeMode result = TypeDerivativeMode.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertTypeDerivativeModeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ByteOrder createByteOrderObjectFromString(EDataType eDataType, String initialValue) {
        return createByteOrderFromString(FpbmodulePackage.Literals.BYTE_ORDER, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertByteOrderObjectToString(EDataType eDataType, Object instanceValue) {
        return convertByteOrderToString(FpbmodulePackage.Literals.BYTE_ORDER, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EncodingType createEncodingTypeObjectFromString(EDataType eDataType, String initialValue) {
        return createEncodingTypeFromString(FpbmodulePackage.Literals.ENCODING_TYPE, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEncodingTypeObjectToString(EDataType eDataType, Object instanceValue) {
        return convertEncodingTypeToString(FpbmodulePackage.Literals.ENCODING_TYPE, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FlagFieldType createFlagFieldTypeObjectFromString(EDataType eDataType, String initialValue) {
        return createFlagFieldTypeFromString(FpbmodulePackage.Literals.FLAG_FIELD_TYPE, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertFlagFieldTypeObjectToString(EDataType eDataType, Object instanceValue) {
        return convertFlagFieldTypeToString(FpbmodulePackage.Literals.FLAG_FIELD_TYPE, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ModuleElementType createModuleElementTypeObjectFromString(EDataType eDataType, String initialValue) {
        return createModuleElementTypeFromString(FpbmodulePackage.Literals.MODULE_ELEMENT_TYPE, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertModuleElementTypeObjectToString(EDataType eDataType, Object instanceValue) {
        return convertModuleElementTypeToString(FpbmodulePackage.Literals.MODULE_ELEMENT_TYPE, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OnelineMode createOnelineModeObjectFromString(EDataType eDataType, String initialValue) {
        return createOnelineModeFromString(FpbmodulePackage.Literals.ONELINE_MODE, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertOnelineModeObjectToString(EDataType eDataType, Object instanceValue) {
        return convertOnelineModeToString(FpbmodulePackage.Literals.ONELINE_MODE, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PadType createPadTypeObjectFromString(EDataType eDataType, String initialValue) {
        return createPadTypeFromString(FpbmodulePackage.Literals.PAD_TYPE, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertPadTypeObjectToString(EDataType eDataType, Object instanceValue) {
        return convertPadTypeToString(FpbmodulePackage.Literals.PAD_TYPE, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeClass createTypeClassObjectFromString(EDataType eDataType, String initialValue) {
        return createTypeClassFromString(FpbmodulePackage.Literals.TYPE_CLASS, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertTypeClassObjectToString(EDataType eDataType, Object instanceValue) {
        return convertTypeClassToString(FpbmodulePackage.Literals.TYPE_CLASS, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeDerivativeMode createTypeDerivativeModeObjectFromString(EDataType eDataType, String initialValue) {
        return createTypeDerivativeModeFromString(FpbmodulePackage.Literals.TYPE_DERIVATIVE_MODE, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertTypeDerivativeModeObjectToString(EDataType eDataType, Object instanceValue) {
        return convertTypeDerivativeModeToString(FpbmodulePackage.Literals.TYPE_DERIVATIVE_MODE, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FpbmodulePackage getFpbmodulePackage() {
        return (FpbmodulePackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static FpbmodulePackage getPackage() {
        return FpbmodulePackage.eINSTANCE;
    }

} //FpbmoduleFactoryImpl
