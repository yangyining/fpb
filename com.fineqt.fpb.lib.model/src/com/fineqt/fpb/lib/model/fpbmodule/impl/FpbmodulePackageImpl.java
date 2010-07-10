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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmoduleFactory;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.ModuleElementType;
import com.fineqt.fpb.lib.model.fpbmodule.OnelineMode;
import com.fineqt.fpb.lib.model.fpbmodule.PAddress;
import com.fineqt.fpb.lib.model.fpbmodule.PArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PArgumentGroup;
import com.fineqt.fpb.lib.model.fpbmodule.PBitstring;
import com.fineqt.fpb.lib.model.fpbmodule.PBoolean;
import com.fineqt.fpb.lib.model.fpbmodule.PBooleanArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PCharstring;
import com.fineqt.fpb.lib.model.fpbmodule.PCharstringArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PCompoundConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PContainerType;
import com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement;
import com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityType;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumItem;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumerated;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem;
import com.fineqt.fpb.lib.model.fpbmodule.PField;
import com.fineqt.fpb.lib.model.fpbmodule.PFieldEV;
import com.fineqt.fpb.lib.model.fpbmodule.PFloat;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbFieldEV;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbListItemEV;
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
import com.fineqt.fpb.lib.model.fpbmodule.PItemField;
import com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PListArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PListConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PListItem;
import com.fineqt.fpb.lib.model.fpbmodule.PListItemEV;
import com.fineqt.fpb.lib.model.fpbmodule.PListType;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.PModuleEV;
import com.fineqt.fpb.lib.model.fpbmodule.PModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PObjid;
import com.fineqt.fpb.lib.model.fpbmodule.POctetstring;
import com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PPrimitiveType;
import com.fineqt.fpb.lib.model.fpbmodule.PProperty;
import com.fineqt.fpb.lib.model.fpbmodule.PPropertyList;
import com.fineqt.fpb.lib.model.fpbmodule.PRecord;
import com.fineqt.fpb.lib.model.fpbmodule.PRecordOf;
import com.fineqt.fpb.lib.model.fpbmodule.PSet;
import com.fineqt.fpb.lib.model.fpbmodule.PSetOf;
import com.fineqt.fpb.lib.model.fpbmodule.PSingleArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PStringType;
import com.fineqt.fpb.lib.model.fpbmodule.PSubType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeReferenceArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PTypedElement;
import com.fineqt.fpb.lib.model.fpbmodule.PUnion;
import com.fineqt.fpb.lib.model.fpbmodule.PUniversalCharstring;
import com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PVerdict;
import com.fineqt.fpb.lib.model.fpbmodule.PadType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode;
import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FpbmodulePackageImpl extends EPackageImpl implements FpbmodulePackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass documentRootEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pAddressEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pArgumentEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pArgumentGroupEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pBitstringEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pBooleanEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pBooleanArgumentEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pCharstringEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pCharstringArgumentEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pCompoundConstraintEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pConditionArgumentEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pConstantEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pContainerTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pEncodedElementEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pEncodingVariantEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pEntityConstantEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pEntityEnumSetEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pEntityModuleParEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pEntityTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pEnumeratedEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pEnumeratedItemEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pEnumItemEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pEnumSetEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pFieldEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pFieldEVEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pFloatEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pFpbFieldEVEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pFpbListItemEVEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pFpbModuleEVEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pFpbTypeEVEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pHexstringEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pIdentifierArgumentEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pImportConstantEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pImportElementEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pImportEnumSetEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pImportModuleParEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pImportTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pIntegerEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pIntegerArgumentEClass = null;

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass pItemFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pLengthConstraintEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pListArgumentEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pListConstraintEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pListItemEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pListItemEVEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pListTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pModuleEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pModuleEVEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pModuleParEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pObjidEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pOctetstringEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pPatternConstraintEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pPrimitiveTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pPropertyEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pPropertyListEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pRecordEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pRecordOfEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pSetEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pSetOfEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pSingleArgumentEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pStringTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pSubTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pTypeConstraintEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pTypedElementEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pTypeEVEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pTypeReferenceArgumentEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pUnionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pUniversalCharstringEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pValueReferenceArgumentEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pVerdictEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum byteOrderEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum encodingTypeEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum flagFieldTypeEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum moduleElementTypeEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum onelineModeEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum padTypeEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum typeClassEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum typeDerivativeModeEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType byteOrderObjectEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType encodingTypeObjectEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType flagFieldTypeObjectEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType moduleElementTypeObjectEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType onelineModeObjectEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType padTypeObjectEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType typeClassObjectEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType typeDerivativeModeObjectEDataType = null;

	/**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage#eNS_URI
     * @see #init()
     * @generated
     */
	private FpbmodulePackageImpl() {
        super(eNS_URI, FpbmoduleFactory.eINSTANCE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

	/**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static FpbmodulePackage init() {
        if (isInited) return (FpbmodulePackage)EPackage.Registry.INSTANCE.getEPackage(FpbmodulePackage.eNS_URI);

        // Obtain or create and register package
        FpbmodulePackageImpl theFpbmodulePackage = (FpbmodulePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof FpbmodulePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new FpbmodulePackageImpl());

        isInited = true;

        // Initialize simple dependencies
        FpbcommonPackage.eINSTANCE.eClass();
        FpbtemplatePackage.eINSTANCE.eClass();
        XMLTypePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theFpbmodulePackage.createPackageContents();

        // Initialize created meta-data
        theFpbmodulePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theFpbmodulePackage.freeze();

        return theFpbmodulePackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDocumentRoot() {
        return documentRootEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDocumentRoot_Mixed() {
        return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_XSISchemaLocation() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_PModule() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPAddress() {
        return pAddressEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPArgument() {
        return pArgumentEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPArgumentGroup() {
        return pArgumentGroupEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPArgumentGroup_Arguments() {
        return (EReference)pArgumentGroupEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPBitstring() {
        return pBitstringEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPBoolean() {
        return pBooleanEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPBooleanArgument() {
        return pBooleanArgumentEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPBooleanArgument_Desc() {
        return (EAttribute)pBooleanArgumentEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPCharstring() {
        return pCharstringEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPCharstringArgument() {
        return pCharstringArgumentEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPCharstringArgument_Desc() {
        return (EAttribute)pCharstringArgumentEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPCompoundConstraint() {
        return pCompoundConstraintEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPCompoundConstraint_Children() {
        return (EReference)pCompoundConstraintEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPConditionArgument() {
        return pConditionArgumentEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPConditionArgument_Condition() {
        return (EReference)pConditionArgumentEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPConditionArgument_TypeName() {
        return (EAttribute)pConditionArgumentEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPConstant() {
        return pConstantEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPConstant_ConstantID() {
        return (EAttribute)pConstantEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPConstant_Pmodule() {
        return (EReference)pConstantEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPContainerType() {
        return pContainerTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPContainerType_Pfields() {
        return (EReference)pContainerTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPEncodedElement() {
        return pEncodedElementEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPEncodedElement_Variant() {
        return (EReference)pEncodedElementEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPEncodedElement_Encode() {
        return (EAttribute)pEncodedElementEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPEncodedElement_TypeEncodingDesc() {
        return (EAttribute)pEncodedElementEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPEncodedElement_TypeEncodingVariantDesc() {
        return (EAttribute)pEncodedElementEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPEncodedElement_TypeExtensionDesc() {
        return (EAttribute)pEncodedElementEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPEncodingVariant() {
        return pEncodingVariantEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPEncodingVariant_EncodedElement() {
        return (EReference)pEncodingVariantEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPEntityConstant() {
        return pEntityConstantEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPEntityConstant_Matcher() {
        return (EReference)pEntityConstantEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPEntityConstant_BaseTypeName() {
        return (EAttribute)pEntityConstantEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPEntityEnumSet() {
        return pEntityEnumSetEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPEntityEnumSet_EnumItems() {
        return (EReference)pEntityEnumSetEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPEntityEnumSet_BaseTypeName() {
        return (EAttribute)pEntityEnumSetEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPEntityModulePar() {
        return pEntityModuleParEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPEntityModulePar_Matcher() {
        return (EReference)pEntityModuleParEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPEntityModulePar_BaseTypeName() {
        return (EAttribute)pEntityModuleParEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPEntityModulePar_Thread() {
        return (EAttribute)pEntityModuleParEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPEntityType() {
        return pEntityTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPEntityType_Constraint() {
        return (EReference)pEntityTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPEnumerated() {
        return pEnumeratedEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPEnumerated_Items() {
        return (EReference)pEnumeratedEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPEnumeratedItem() {
        return pEnumeratedItemEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPEnumeratedItem_EnumName() {
        return (EAttribute)pEnumeratedItemEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPEnumeratedItem_EnumValue() {
        return (EAttribute)pEnumeratedItemEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPEnumItem() {
        return pEnumItemEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPEnumItem_Cond() {
        return (EReference)pEnumItemEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPEnumItem_Name() {
        return (EAttribute)pEnumItemEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPEnumSet() {
        return pEnumSetEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPEnumSet_EnumSetID() {
        return (EAttribute)pEnumSetEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPEnumSet_Pmodule() {
        return (EReference)pEnumSetEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPField() {
        return pFieldEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPField_FieldID() {
        return (EAttribute)pFieldEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPField_Optional() {
        return (EAttribute)pFieldEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPFieldEV() {
        return pFieldEVEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPFieldEV_PrpList() {
        return (EReference)pFieldEVEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPFloat() {
        return pFloatEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPFpbFieldEV() {
        return pFpbFieldEVEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPFpbListItemEV() {
        return pFpbListItemEVEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPFpbModuleEV() {
        return pFpbModuleEVEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPFpbTypeEV() {
        return pFpbTypeEVEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPHexstring() {
        return pHexstringEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPIdentifierArgument() {
        return pIdentifierArgumentEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPIdentifierArgument_Desc() {
        return (EAttribute)pIdentifierArgumentEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPImportConstant() {
        return pImportConstantEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPImportConstant_ImportedConstant() {
        return (EReference)pImportConstantEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPImportConstant_ImportedConstantName() {
        return (EAttribute)pImportConstantEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPImportConstant_ImportedModuleName() {
        return (EAttribute)pImportConstantEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPImportElement() {
        return pImportElementEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPImportElement_RefNameList() {
        return (EAttribute)pImportElementEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPImportElement_AllExcept() {
        return (EAttribute)pImportElementEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPImportElement_ElementType() {
        return (EAttribute)pImportElementEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPImportElement_FromModuleName() {
        return (EAttribute)pImportElementEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPImportElement_Pmodule() {
        return (EReference)pImportElementEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPImportEnumSet() {
        return pImportEnumSetEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPImportEnumSet_ImportedEnumSet() {
        return (EReference)pImportEnumSetEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPImportEnumSet_ImportedEnumSetName() {
        return (EAttribute)pImportEnumSetEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPImportEnumSet_ImportedModuleName() {
        return (EAttribute)pImportEnumSetEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPImportModulePar() {
        return pImportModuleParEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPImportModulePar_ImportedModuleName() {
        return (EAttribute)pImportModuleParEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPImportModulePar_ImportedModulePar() {
        return (EReference)pImportModuleParEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPImportModulePar_ImportedModulePartName() {
        return (EAttribute)pImportModuleParEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPImportType() {
        return pImportTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPImportType_ImportedModuleName() {
        return (EAttribute)pImportTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPImportType_ImportedType() {
        return (EReference)pImportTypeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPImportType_ImportedTypeName() {
        return (EAttribute)pImportTypeEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPInteger() {
        return pIntegerEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPIntegerArgument() {
        return pIntegerArgumentEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPIntegerArgument_Desc() {
        return (EAttribute)pIntegerArgumentEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPItemField() {
        return pItemFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPItemField_Constraint() {
        return (EReference)pItemFieldEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPItemField_EnumItems() {
        return (EReference)pItemFieldEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPItemField_EnumRef() {
        return (EAttribute)pItemFieldEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPLengthConstraint() {
        return pLengthConstraintEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPLengthConstraint_LowerBound() {
        return (EReference)pLengthConstraintEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPLengthConstraint_UpperBound() {
        return (EReference)pLengthConstraintEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPListArgument() {
        return pListArgumentEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPListArgument_Group() {
        return (EReference)pListArgumentEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPListConstraint() {
        return pListConstraintEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPListConstraint_Matcher() {
        return (EReference)pListConstraintEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPListItem() {
        return pListItemEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPListItemEV() {
        return pListItemEVEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPListItemEV_PrpList() {
        return (EReference)pListItemEVEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPListType() {
        return pListTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPListType_Item() {
        return (EReference)pListTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPModule() {
        return pModuleEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPModule_Types() {
        return (EReference)pModuleEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPModule_Constants() {
        return (EReference)pModuleEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPModule_Templates() {
        return (EReference)pModuleEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPModule_ModulePars() {
        return (EReference)pModuleEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPModule_ImportElements() {
        return (EReference)pModuleEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPModule_EnumSets() {
        return (EReference)pModuleEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPModule_FactoryJavaClass() {
        return (EAttribute)pModuleEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPModule_ModuleJavaClass() {
        return (EAttribute)pModuleEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPModule_TypeEvFactoryJavaClass() {
        return (EAttribute)pModuleEClass.getEStructuralFeatures().get(8);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPModuleEV() {
        return pModuleEVEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPModuleEV_PrpList() {
        return (EReference)pModuleEVEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPModulePar() {
        return pModuleParEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPModulePar_ModuleParID() {
        return (EAttribute)pModuleParEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPModulePar_Pmodule() {
        return (EReference)pModuleParEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPObjid() {
        return pObjidEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPOctetstring() {
        return pOctetstringEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPPatternConstraint() {
        return pPatternConstraintEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPPatternConstraint_Matcher() {
        return (EReference)pPatternConstraintEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPPrimitiveType() {
        return pPrimitiveTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPProperty() {
        return pPropertyEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPProperty_Groups() {
        return (EReference)pPropertyEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPPropertyList() {
        return pPropertyListEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPPropertyList_Properties() {
        return (EReference)pPropertyListEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPRecord() {
        return pRecordEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPRecordOf() {
        return pRecordOfEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPSet() {
        return pSetEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPSetOf() {
        return pSetOfEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPSingleArgument() {
        return pSingleArgumentEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPStringType() {
        return pStringTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPSubType() {
        return pSubTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPSubType_Constraint() {
        return (EReference)pSubTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPSubType_SuperType() {
        return (EReference)pSubTypeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPSubType_SuperTypeName() {
        return (EAttribute)pSubTypeEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPType() {
        return pTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPType_ContainerType() {
        return (EAttribute)pTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPType_DerivativeMode() {
        return (EAttribute)pTypeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPType_JavaClass() {
        return (EAttribute)pTypeEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPType_ListType() {
        return (EAttribute)pTypeEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPType_PrimitiveType() {
        return (EAttribute)pTypeEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPType_TypeClass() {
        return (EAttribute)pTypeEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPType_TypeID() {
        return (EAttribute)pTypeEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPType_Pmodule() {
        return (EReference)pTypeEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPTypeConstraint() {
        return pTypeConstraintEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPTypedElement() {
        return pTypedElementEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPTypedElement_Ptype() {
        return (EReference)pTypedElementEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPTypedElement_PtypeName() {
        return (EAttribute)pTypedElementEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPTypeEV() {
        return pTypeEVEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPTypeEV_PrpList() {
        return (EReference)pTypeEVEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPTypeReferenceArgument() {
        return pTypeReferenceArgumentEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPTypeReferenceArgument_TypeName() {
        return (EAttribute)pTypeReferenceArgumentEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPUnion() {
        return pUnionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPUniversalCharstring() {
        return pUniversalCharstringEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPValueReferenceArgument() {
        return pValueReferenceArgumentEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPValueReferenceArgument_ValueRef() {
        return (EReference)pValueReferenceArgumentEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPValueReferenceArgument_TypeName() {
        return (EAttribute)pValueReferenceArgumentEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPVerdict() {
        return pVerdictEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getByteOrder() {
        return byteOrderEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getEncodingType() {
        return encodingTypeEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getFlagFieldType() {
        return flagFieldTypeEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getModuleElementType() {
        return moduleElementTypeEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getOnelineMode() {
        return onelineModeEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getPadType() {
        return padTypeEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getTypeClass() {
        return typeClassEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getTypeDerivativeMode() {
        return typeDerivativeModeEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getByteOrderObject() {
        return byteOrderObjectEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getEncodingTypeObject() {
        return encodingTypeObjectEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getFlagFieldTypeObject() {
        return flagFieldTypeObjectEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getModuleElementTypeObject() {
        return moduleElementTypeObjectEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getOnelineModeObject() {
        return onelineModeObjectEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getPadTypeObject() {
        return padTypeObjectEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getTypeClassObject() {
        return typeClassObjectEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getTypeDerivativeModeObject() {
        return typeDerivativeModeObjectEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FpbmoduleFactory getFpbmoduleFactory() {
        return (FpbmoduleFactory)getEFactoryInstance();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isCreated = false;

	/**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        documentRootEClass = createEClass(DOCUMENT_ROOT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PMODULE);

        pAddressEClass = createEClass(PADDRESS);

        pArgumentEClass = createEClass(PARGUMENT);

        pArgumentGroupEClass = createEClass(PARGUMENT_GROUP);
        createEReference(pArgumentGroupEClass, PARGUMENT_GROUP__ARGUMENTS);

        pBitstringEClass = createEClass(PBITSTRING);

        pBooleanEClass = createEClass(PBOOLEAN);

        pBooleanArgumentEClass = createEClass(PBOOLEAN_ARGUMENT);
        createEAttribute(pBooleanArgumentEClass, PBOOLEAN_ARGUMENT__DESC);

        pCharstringEClass = createEClass(PCHARSTRING);

        pCharstringArgumentEClass = createEClass(PCHARSTRING_ARGUMENT);
        createEAttribute(pCharstringArgumentEClass, PCHARSTRING_ARGUMENT__DESC);

        pCompoundConstraintEClass = createEClass(PCOMPOUND_CONSTRAINT);
        createEReference(pCompoundConstraintEClass, PCOMPOUND_CONSTRAINT__CHILDREN);

        pConditionArgumentEClass = createEClass(PCONDITION_ARGUMENT);
        createEReference(pConditionArgumentEClass, PCONDITION_ARGUMENT__CONDITION);
        createEAttribute(pConditionArgumentEClass, PCONDITION_ARGUMENT__TYPE_NAME);

        pConstantEClass = createEClass(PCONSTANT);
        createEAttribute(pConstantEClass, PCONSTANT__CONSTANT_ID);
        createEReference(pConstantEClass, PCONSTANT__PMODULE);

        pContainerTypeEClass = createEClass(PCONTAINER_TYPE);
        createEReference(pContainerTypeEClass, PCONTAINER_TYPE__PFIELDS);

        pEncodedElementEClass = createEClass(PENCODED_ELEMENT);
        createEReference(pEncodedElementEClass, PENCODED_ELEMENT__VARIANT);
        createEAttribute(pEncodedElementEClass, PENCODED_ELEMENT__ENCODE);
        createEAttribute(pEncodedElementEClass, PENCODED_ELEMENT__TYPE_ENCODING_DESC);
        createEAttribute(pEncodedElementEClass, PENCODED_ELEMENT__TYPE_ENCODING_VARIANT_DESC);
        createEAttribute(pEncodedElementEClass, PENCODED_ELEMENT__TYPE_EXTENSION_DESC);

        pEncodingVariantEClass = createEClass(PENCODING_VARIANT);
        createEReference(pEncodingVariantEClass, PENCODING_VARIANT__ENCODED_ELEMENT);

        pEntityConstantEClass = createEClass(PENTITY_CONSTANT);
        createEReference(pEntityConstantEClass, PENTITY_CONSTANT__MATCHER);
        createEAttribute(pEntityConstantEClass, PENTITY_CONSTANT__BASE_TYPE_NAME);

        pEntityEnumSetEClass = createEClass(PENTITY_ENUM_SET);
        createEReference(pEntityEnumSetEClass, PENTITY_ENUM_SET__ENUM_ITEMS);
        createEAttribute(pEntityEnumSetEClass, PENTITY_ENUM_SET__BASE_TYPE_NAME);

        pEntityModuleParEClass = createEClass(PENTITY_MODULE_PAR);
        createEReference(pEntityModuleParEClass, PENTITY_MODULE_PAR__MATCHER);
        createEAttribute(pEntityModuleParEClass, PENTITY_MODULE_PAR__BASE_TYPE_NAME);
        createEAttribute(pEntityModuleParEClass, PENTITY_MODULE_PAR__THREAD);

        pEntityTypeEClass = createEClass(PENTITY_TYPE);
        createEReference(pEntityTypeEClass, PENTITY_TYPE__CONSTRAINT);

        pEnumeratedEClass = createEClass(PENUMERATED);
        createEReference(pEnumeratedEClass, PENUMERATED__ITEMS);

        pEnumeratedItemEClass = createEClass(PENUMERATED_ITEM);
        createEAttribute(pEnumeratedItemEClass, PENUMERATED_ITEM__ENUM_NAME);
        createEAttribute(pEnumeratedItemEClass, PENUMERATED_ITEM__ENUM_VALUE);

        pEnumItemEClass = createEClass(PENUM_ITEM);
        createEReference(pEnumItemEClass, PENUM_ITEM__COND);
        createEAttribute(pEnumItemEClass, PENUM_ITEM__NAME);

        pEnumSetEClass = createEClass(PENUM_SET);
        createEAttribute(pEnumSetEClass, PENUM_SET__ENUM_SET_ID);
        createEReference(pEnumSetEClass, PENUM_SET__PMODULE);

        pFieldEClass = createEClass(PFIELD);
        createEAttribute(pFieldEClass, PFIELD__FIELD_ID);
        createEAttribute(pFieldEClass, PFIELD__OPTIONAL);

        pFieldEVEClass = createEClass(PFIELD_EV);
        createEReference(pFieldEVEClass, PFIELD_EV__PRP_LIST);

        pFloatEClass = createEClass(PFLOAT);

        pFpbFieldEVEClass = createEClass(PFPB_FIELD_EV);

        pFpbListItemEVEClass = createEClass(PFPB_LIST_ITEM_EV);

        pFpbModuleEVEClass = createEClass(PFPB_MODULE_EV);

        pFpbTypeEVEClass = createEClass(PFPB_TYPE_EV);

        pHexstringEClass = createEClass(PHEXSTRING);

        pIdentifierArgumentEClass = createEClass(PIDENTIFIER_ARGUMENT);
        createEAttribute(pIdentifierArgumentEClass, PIDENTIFIER_ARGUMENT__DESC);

        pImportConstantEClass = createEClass(PIMPORT_CONSTANT);
        createEReference(pImportConstantEClass, PIMPORT_CONSTANT__IMPORTED_CONSTANT);
        createEAttribute(pImportConstantEClass, PIMPORT_CONSTANT__IMPORTED_CONSTANT_NAME);
        createEAttribute(pImportConstantEClass, PIMPORT_CONSTANT__IMPORTED_MODULE_NAME);

        pImportElementEClass = createEClass(PIMPORT_ELEMENT);
        createEAttribute(pImportElementEClass, PIMPORT_ELEMENT__REF_NAME_LIST);
        createEAttribute(pImportElementEClass, PIMPORT_ELEMENT__ALL_EXCEPT);
        createEAttribute(pImportElementEClass, PIMPORT_ELEMENT__ELEMENT_TYPE);
        createEAttribute(pImportElementEClass, PIMPORT_ELEMENT__FROM_MODULE_NAME);
        createEReference(pImportElementEClass, PIMPORT_ELEMENT__PMODULE);

        pImportEnumSetEClass = createEClass(PIMPORT_ENUM_SET);
        createEReference(pImportEnumSetEClass, PIMPORT_ENUM_SET__IMPORTED_ENUM_SET);
        createEAttribute(pImportEnumSetEClass, PIMPORT_ENUM_SET__IMPORTED_ENUM_SET_NAME);
        createEAttribute(pImportEnumSetEClass, PIMPORT_ENUM_SET__IMPORTED_MODULE_NAME);

        pImportModuleParEClass = createEClass(PIMPORT_MODULE_PAR);
        createEAttribute(pImportModuleParEClass, PIMPORT_MODULE_PAR__IMPORTED_MODULE_NAME);
        createEReference(pImportModuleParEClass, PIMPORT_MODULE_PAR__IMPORTED_MODULE_PAR);
        createEAttribute(pImportModuleParEClass, PIMPORT_MODULE_PAR__IMPORTED_MODULE_PART_NAME);

        pImportTypeEClass = createEClass(PIMPORT_TYPE);
        createEAttribute(pImportTypeEClass, PIMPORT_TYPE__IMPORTED_MODULE_NAME);
        createEReference(pImportTypeEClass, PIMPORT_TYPE__IMPORTED_TYPE);
        createEAttribute(pImportTypeEClass, PIMPORT_TYPE__IMPORTED_TYPE_NAME);

        pIntegerEClass = createEClass(PINTEGER);

        pIntegerArgumentEClass = createEClass(PINTEGER_ARGUMENT);
        createEAttribute(pIntegerArgumentEClass, PINTEGER_ARGUMENT__DESC);

        pItemFieldEClass = createEClass(PITEM_FIELD);
        createEReference(pItemFieldEClass, PITEM_FIELD__CONSTRAINT);
        createEReference(pItemFieldEClass, PITEM_FIELD__ENUM_ITEMS);
        createEAttribute(pItemFieldEClass, PITEM_FIELD__ENUM_REF);

        pLengthConstraintEClass = createEClass(PLENGTH_CONSTRAINT);
        createEReference(pLengthConstraintEClass, PLENGTH_CONSTRAINT__LOWER_BOUND);
        createEReference(pLengthConstraintEClass, PLENGTH_CONSTRAINT__UPPER_BOUND);

        pListArgumentEClass = createEClass(PLIST_ARGUMENT);
        createEReference(pListArgumentEClass, PLIST_ARGUMENT__GROUP);

        pListConstraintEClass = createEClass(PLIST_CONSTRAINT);
        createEReference(pListConstraintEClass, PLIST_CONSTRAINT__MATCHER);

        pListItemEClass = createEClass(PLIST_ITEM);

        pListItemEVEClass = createEClass(PLIST_ITEM_EV);
        createEReference(pListItemEVEClass, PLIST_ITEM_EV__PRP_LIST);

        pListTypeEClass = createEClass(PLIST_TYPE);
        createEReference(pListTypeEClass, PLIST_TYPE__ITEM);

        pModuleEClass = createEClass(PMODULE);
        createEReference(pModuleEClass, PMODULE__IMPORT_ELEMENTS);
        createEReference(pModuleEClass, PMODULE__TYPES);
        createEReference(pModuleEClass, PMODULE__CONSTANTS);
        createEReference(pModuleEClass, PMODULE__TEMPLATES);
        createEReference(pModuleEClass, PMODULE__MODULE_PARS);
        createEReference(pModuleEClass, PMODULE__ENUM_SETS);
        createEAttribute(pModuleEClass, PMODULE__FACTORY_JAVA_CLASS);
        createEAttribute(pModuleEClass, PMODULE__MODULE_JAVA_CLASS);
        createEAttribute(pModuleEClass, PMODULE__TYPE_EV_FACTORY_JAVA_CLASS);

        pModuleEVEClass = createEClass(PMODULE_EV);
        createEReference(pModuleEVEClass, PMODULE_EV__PRP_LIST);

        pModuleParEClass = createEClass(PMODULE_PAR);
        createEAttribute(pModuleParEClass, PMODULE_PAR__MODULE_PAR_ID);
        createEReference(pModuleParEClass, PMODULE_PAR__PMODULE);

        pObjidEClass = createEClass(POBJID);

        pOctetstringEClass = createEClass(POCTETSTRING);

        pPatternConstraintEClass = createEClass(PPATTERN_CONSTRAINT);
        createEReference(pPatternConstraintEClass, PPATTERN_CONSTRAINT__MATCHER);

        pPrimitiveTypeEClass = createEClass(PPRIMITIVE_TYPE);

        pPropertyEClass = createEClass(PPROPERTY);
        createEReference(pPropertyEClass, PPROPERTY__GROUPS);

        pPropertyListEClass = createEClass(PPROPERTY_LIST);
        createEReference(pPropertyListEClass, PPROPERTY_LIST__PROPERTIES);

        pRecordEClass = createEClass(PRECORD);

        pRecordOfEClass = createEClass(PRECORD_OF);

        pSetEClass = createEClass(PSET);

        pSetOfEClass = createEClass(PSET_OF);

        pSingleArgumentEClass = createEClass(PSINGLE_ARGUMENT);

        pStringTypeEClass = createEClass(PSTRING_TYPE);

        pSubTypeEClass = createEClass(PSUB_TYPE);
        createEReference(pSubTypeEClass, PSUB_TYPE__CONSTRAINT);
        createEReference(pSubTypeEClass, PSUB_TYPE__SUPER_TYPE);
        createEAttribute(pSubTypeEClass, PSUB_TYPE__SUPER_TYPE_NAME);

        pTypeEClass = createEClass(PTYPE);
        createEAttribute(pTypeEClass, PTYPE__CONTAINER_TYPE);
        createEAttribute(pTypeEClass, PTYPE__DERIVATIVE_MODE);
        createEAttribute(pTypeEClass, PTYPE__JAVA_CLASS);
        createEAttribute(pTypeEClass, PTYPE__LIST_TYPE);
        createEAttribute(pTypeEClass, PTYPE__PRIMITIVE_TYPE);
        createEAttribute(pTypeEClass, PTYPE__TYPE_CLASS);
        createEAttribute(pTypeEClass, PTYPE__TYPE_ID);
        createEReference(pTypeEClass, PTYPE__PMODULE);

        pTypeConstraintEClass = createEClass(PTYPE_CONSTRAINT);

        pTypedElementEClass = createEClass(PTYPED_ELEMENT);
        createEReference(pTypedElementEClass, PTYPED_ELEMENT__PTYPE);
        createEAttribute(pTypedElementEClass, PTYPED_ELEMENT__PTYPE_NAME);

        pTypeEVEClass = createEClass(PTYPE_EV);
        createEReference(pTypeEVEClass, PTYPE_EV__PRP_LIST);

        pTypeReferenceArgumentEClass = createEClass(PTYPE_REFERENCE_ARGUMENT);
        createEAttribute(pTypeReferenceArgumentEClass, PTYPE_REFERENCE_ARGUMENT__TYPE_NAME);

        pUnionEClass = createEClass(PUNION);

        pUniversalCharstringEClass = createEClass(PUNIVERSAL_CHARSTRING);

        pValueReferenceArgumentEClass = createEClass(PVALUE_REFERENCE_ARGUMENT);
        createEReference(pValueReferenceArgumentEClass, PVALUE_REFERENCE_ARGUMENT__VALUE_REF);
        createEAttribute(pValueReferenceArgumentEClass, PVALUE_REFERENCE_ARGUMENT__TYPE_NAME);

        pVerdictEClass = createEClass(PVERDICT);

        // Create enums
        byteOrderEEnum = createEEnum(BYTE_ORDER);
        encodingTypeEEnum = createEEnum(ENCODING_TYPE);
        flagFieldTypeEEnum = createEEnum(FLAG_FIELD_TYPE);
        moduleElementTypeEEnum = createEEnum(MODULE_ELEMENT_TYPE);
        onelineModeEEnum = createEEnum(ONELINE_MODE);
        padTypeEEnum = createEEnum(PAD_TYPE);
        typeClassEEnum = createEEnum(TYPE_CLASS);
        typeDerivativeModeEEnum = createEEnum(TYPE_DERIVATIVE_MODE);

        // Create data types
        byteOrderObjectEDataType = createEDataType(BYTE_ORDER_OBJECT);
        encodingTypeObjectEDataType = createEDataType(ENCODING_TYPE_OBJECT);
        flagFieldTypeObjectEDataType = createEDataType(FLAG_FIELD_TYPE_OBJECT);
        moduleElementTypeObjectEDataType = createEDataType(MODULE_ELEMENT_TYPE_OBJECT);
        onelineModeObjectEDataType = createEDataType(ONELINE_MODE_OBJECT);
        padTypeObjectEDataType = createEDataType(PAD_TYPE_OBJECT);
        typeClassObjectEDataType = createEDataType(TYPE_CLASS_OBJECT);
        typeDerivativeModeObjectEDataType = createEDataType(TYPE_DERIVATIVE_MODE_OBJECT);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isInitialized = false;

	/**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        FpbcommonPackage theFpbcommonPackage = (FpbcommonPackage)EPackage.Registry.INSTANCE.getEPackage(FpbcommonPackage.eNS_URI);
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
        FpbtemplatePackage theFpbtemplatePackage = (FpbtemplatePackage)EPackage.Registry.INSTANCE.getEPackage(FpbtemplatePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        pAddressEClass.getESuperTypes().add(this.getPPrimitiveType());
        pArgumentEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
        pArgumentGroupEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
        pBitstringEClass.getESuperTypes().add(this.getPStringType());
        pBooleanEClass.getESuperTypes().add(this.getPPrimitiveType());
        pBooleanArgumentEClass.getESuperTypes().add(this.getPSingleArgument());
        pCharstringEClass.getESuperTypes().add(this.getPStringType());
        pCharstringArgumentEClass.getESuperTypes().add(this.getPSingleArgument());
        pCompoundConstraintEClass.getESuperTypes().add(this.getPTypeConstraint());
        pConditionArgumentEClass.getESuperTypes().add(this.getPSingleArgument());
        pConstantEClass.getESuperTypes().add(theFpbcommonPackage.getPNamedElement());
        pContainerTypeEClass.getESuperTypes().add(this.getPEntityType());
        pEncodedElementEClass.getESuperTypes().add(theFpbcommonPackage.getPNamedElement());
        pEncodingVariantEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
        pEntityConstantEClass.getESuperTypes().add(this.getPConstant());
        pEntityEnumSetEClass.getESuperTypes().add(this.getPEnumSet());
        pEntityModuleParEClass.getESuperTypes().add(this.getPModulePar());
        pEntityTypeEClass.getESuperTypes().add(this.getPType());
        pEnumeratedEClass.getESuperTypes().add(this.getPPrimitiveType());
        pEnumeratedItemEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
        pEnumItemEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
        pEnumSetEClass.getESuperTypes().add(theFpbcommonPackage.getPNamedElement());
        pFieldEClass.getESuperTypes().add(this.getPItemField());
        pFieldEVEClass.getESuperTypes().add(this.getPEncodingVariant());
        pFloatEClass.getESuperTypes().add(this.getPPrimitiveType());
        pFpbFieldEVEClass.getESuperTypes().add(this.getPFieldEV());
        pFpbListItemEVEClass.getESuperTypes().add(this.getPListItemEV());
        pFpbModuleEVEClass.getESuperTypes().add(this.getPModuleEV());
        pFpbTypeEVEClass.getESuperTypes().add(this.getPTypeEV());
        pHexstringEClass.getESuperTypes().add(this.getPStringType());
        pIdentifierArgumentEClass.getESuperTypes().add(this.getPSingleArgument());
        pImportConstantEClass.getESuperTypes().add(this.getPConstant());
        pImportElementEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
        pImportEnumSetEClass.getESuperTypes().add(this.getPEnumSet());
        pImportModuleParEClass.getESuperTypes().add(this.getPModulePar());
        pImportTypeEClass.getESuperTypes().add(this.getPType());
        pIntegerEClass.getESuperTypes().add(this.getPPrimitiveType());
        pIntegerArgumentEClass.getESuperTypes().add(this.getPSingleArgument());
        pItemFieldEClass.getESuperTypes().add(this.getPTypedElement());
        pLengthConstraintEClass.getESuperTypes().add(this.getPTypeConstraint());
        pListArgumentEClass.getESuperTypes().add(this.getPArgument());
        pListConstraintEClass.getESuperTypes().add(this.getPTypeConstraint());
        pListItemEClass.getESuperTypes().add(this.getPItemField());
        pListItemEVEClass.getESuperTypes().add(this.getPEncodingVariant());
        pListTypeEClass.getESuperTypes().add(this.getPEntityType());
        pModuleEClass.getESuperTypes().add(this.getPEncodedElement());
        pModuleEVEClass.getESuperTypes().add(this.getPEncodingVariant());
        pModuleParEClass.getESuperTypes().add(theFpbcommonPackage.getPNamedElement());
        pObjidEClass.getESuperTypes().add(this.getPPrimitiveType());
        pOctetstringEClass.getESuperTypes().add(this.getPStringType());
        pPatternConstraintEClass.getESuperTypes().add(this.getPTypeConstraint());
        pPrimitiveTypeEClass.getESuperTypes().add(this.getPEntityType());
        pPropertyEClass.getESuperTypes().add(theFpbcommonPackage.getPNamedElement());
        pPropertyListEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
        pRecordEClass.getESuperTypes().add(this.getPContainerType());
        pRecordOfEClass.getESuperTypes().add(this.getPListType());
        pSetEClass.getESuperTypes().add(this.getPContainerType());
        pSetOfEClass.getESuperTypes().add(this.getPListType());
        pSingleArgumentEClass.getESuperTypes().add(this.getPArgument());
        pStringTypeEClass.getESuperTypes().add(this.getPPrimitiveType());
        pSubTypeEClass.getESuperTypes().add(this.getPType());
        pTypeEClass.getESuperTypes().add(this.getPEncodedElement());
        pTypeConstraintEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
        pTypedElementEClass.getESuperTypes().add(this.getPEncodedElement());
        pTypeEVEClass.getESuperTypes().add(this.getPEncodingVariant());
        pTypeReferenceArgumentEClass.getESuperTypes().add(this.getPSingleArgument());
        pUnionEClass.getESuperTypes().add(this.getPContainerType());
        pUniversalCharstringEClass.getESuperTypes().add(this.getPStringType());
        pValueReferenceArgumentEClass.getESuperTypes().add(this.getPSingleArgument());
        pVerdictEClass.getESuperTypes().add(this.getPPrimitiveType());

        // Initialize classes and features; add operations and parameters
        initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PModule(), this.getPModule(), null, "pModule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(pAddressEClass, PAddress.class, "PAddress", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pArgumentEClass, PArgument.class, "PArgument", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pArgumentGroupEClass, PArgumentGroup.class, "PArgumentGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPArgumentGroup_Arguments(), this.getPArgument(), null, "arguments", null, 0, -1, PArgumentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pBitstringEClass, PBitstring.class, "PBitstring", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pBooleanEClass, PBoolean.class, "PBoolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pBooleanArgumentEClass, PBooleanArgument.class, "PBooleanArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPBooleanArgument_Desc(), theXMLTypePackage.getString(), "desc", null, 1, 1, PBooleanArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pCharstringEClass, PCharstring.class, "PCharstring", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pCharstringArgumentEClass, PCharstringArgument.class, "PCharstringArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPCharstringArgument_Desc(), theXMLTypePackage.getString(), "desc", null, 1, 1, PCharstringArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pCompoundConstraintEClass, PCompoundConstraint.class, "PCompoundConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPCompoundConstraint_Children(), this.getPTypeConstraint(), null, "children", null, 0, -1, PCompoundConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pConditionArgumentEClass, PConditionArgument.class, "PConditionArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPConditionArgument_Condition(), this.getPTypeConstraint(), null, "condition", null, 1, 1, PConditionArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPConditionArgument_TypeName(), theXMLTypePackage.getString(), "typeName", null, 0, 1, PConditionArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pConstantEClass, PConstant.class, "PConstant", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPConstant_ConstantID(), theXMLTypePackage.getInt(), "constantID", null, 0, 1, PConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPConstant_Pmodule(), this.getPModule(), this.getPModule_Constants(), "pmodule", null, 0, 1, PConstant.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pContainerTypeEClass, PContainerType.class, "PContainerType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPContainerType_Pfields(), this.getPField(), null, "pfields", null, 0, -1, PContainerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pEncodedElementEClass, PEncodedElement.class, "PEncodedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPEncodedElement_Variant(), this.getPEncodingVariant(), this.getPEncodingVariant_EncodedElement(), "variant", null, 1, 1, PEncodedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPEncodedElement_Encode(), this.getEncodingType(), "encode", "NONE", 0, 1, PEncodedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPEncodedElement_TypeEncodingDesc(), theXMLTypePackage.getString(), "typeEncodingDesc", null, 0, 1, PEncodedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPEncodedElement_TypeEncodingVariantDesc(), theXMLTypePackage.getString(), "typeEncodingVariantDesc", null, 0, 1, PEncodedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPEncodedElement_TypeExtensionDesc(), theXMLTypePackage.getString(), "typeExtensionDesc", null, 0, 1, PEncodedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pEncodingVariantEClass, PEncodingVariant.class, "PEncodingVariant", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPEncodingVariant_EncodedElement(), this.getPEncodedElement(), this.getPEncodedElement_Variant(), "encodedElement", null, 0, 1, PEncodingVariant.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pEntityConstantEClass, PEntityConstant.class, "PEntityConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPEntityConstant_Matcher(), theFpbtemplatePackage.getPMatcher(), null, "matcher", null, 1, 1, PEntityConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPEntityConstant_BaseTypeName(), theXMLTypePackage.getString(), "baseTypeName", null, 1, 1, PEntityConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pEntityEnumSetEClass, PEntityEnumSet.class, "PEntityEnumSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPEntityEnumSet_EnumItems(), this.getPEnumItem(), null, "enumItems", null, 0, -1, PEntityEnumSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPEntityEnumSet_BaseTypeName(), theXMLTypePackage.getString(), "baseTypeName", "integer", 0, 1, PEntityEnumSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pEntityModuleParEClass, PEntityModulePar.class, "PEntityModulePar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPEntityModulePar_Matcher(), theFpbtemplatePackage.getPMatcher(), null, "matcher", null, 1, 1, PEntityModulePar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPEntityModulePar_BaseTypeName(), theXMLTypePackage.getString(), "baseTypeName", null, 1, 1, PEntityModulePar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPEntityModulePar_Thread(), theXMLTypePackage.getBoolean(), "thread", null, 0, 1, PEntityModulePar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pEntityTypeEClass, PEntityType.class, "PEntityType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPEntityType_Constraint(), this.getPTypeConstraint(), null, "constraint", null, 0, 1, PEntityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pEnumeratedEClass, PEnumerated.class, "PEnumerated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPEnumerated_Items(), this.getPEnumeratedItem(), null, "items", null, 0, -1, PEnumerated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pEnumeratedItemEClass, PEnumeratedItem.class, "PEnumeratedItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPEnumeratedItem_EnumName(), theXMLTypePackage.getString(), "enumName", null, 0, 1, PEnumeratedItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPEnumeratedItem_EnumValue(), theXMLTypePackage.getInt(), "enumValue", null, 0, 1, PEnumeratedItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pEnumItemEClass, PEnumItem.class, "PEnumItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPEnumItem_Cond(), this.getPTypeConstraint(), null, "cond", null, 1, 1, PEnumItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPEnumItem_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, PEnumItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pEnumSetEClass, PEnumSet.class, "PEnumSet", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPEnumSet_EnumSetID(), theXMLTypePackage.getInt(), "enumSetID", null, 0, 1, PEnumSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPEnumSet_Pmodule(), this.getPModule(), this.getPModule_EnumSets(), "pmodule", null, 0, 1, PEnumSet.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pFieldEClass, PField.class, "PField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPField_FieldID(), theXMLTypePackage.getInt(), "fieldID", null, 1, 1, PField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPField_Optional(), theXMLTypePackage.getBoolean(), "optional", "false", 0, 1, PField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pFieldEVEClass, PFieldEV.class, "PFieldEV", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPFieldEV_PrpList(), this.getPPropertyList(), null, "prpList", null, 1, 1, PFieldEV.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pFloatEClass, PFloat.class, "PFloat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pFpbFieldEVEClass, PFpbFieldEV.class, "PFpbFieldEV", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pFpbListItemEVEClass, PFpbListItemEV.class, "PFpbListItemEV", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pFpbModuleEVEClass, PFpbModuleEV.class, "PFpbModuleEV", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pFpbTypeEVEClass, PFpbTypeEV.class, "PFpbTypeEV", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pHexstringEClass, PHexstring.class, "PHexstring", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pIdentifierArgumentEClass, PIdentifierArgument.class, "PIdentifierArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPIdentifierArgument_Desc(), theXMLTypePackage.getString(), "desc", null, 1, 1, PIdentifierArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pImportConstantEClass, PImportConstant.class, "PImportConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPImportConstant_ImportedConstant(), this.getPConstant(), null, "importedConstant", null, 0, 1, PImportConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPImportConstant_ImportedConstantName(), theXMLTypePackage.getString(), "importedConstantName", null, 1, 1, PImportConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPImportConstant_ImportedModuleName(), theXMLTypePackage.getString(), "importedModuleName", null, 1, 1, PImportConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pImportElementEClass, PImportElement.class, "PImportElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPImportElement_RefNameList(), theXMLTypePackage.getString(), "refNameList", null, 0, -1, PImportElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPImportElement_AllExcept(), theXMLTypePackage.getBoolean(), "allExcept", null, 0, 1, PImportElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPImportElement_ElementType(), this.getModuleElementType(), "elementType", "TYPE", 1, 1, PImportElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPImportElement_FromModuleName(), theXMLTypePackage.getString(), "fromModuleName", null, 1, 1, PImportElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPImportElement_Pmodule(), this.getPModule(), this.getPModule_ImportElements(), "pmodule", null, 0, 1, PImportElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pImportEnumSetEClass, PImportEnumSet.class, "PImportEnumSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPImportEnumSet_ImportedEnumSet(), this.getPEnumSet(), null, "importedEnumSet", null, 0, 1, PImportEnumSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPImportEnumSet_ImportedEnumSetName(), theXMLTypePackage.getString(), "importedEnumSetName", null, 1, 1, PImportEnumSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPImportEnumSet_ImportedModuleName(), theXMLTypePackage.getString(), "importedModuleName", null, 1, 1, PImportEnumSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pImportModuleParEClass, PImportModulePar.class, "PImportModulePar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPImportModulePar_ImportedModuleName(), theXMLTypePackage.getString(), "importedModuleName", null, 1, 1, PImportModulePar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPImportModulePar_ImportedModulePar(), this.getPModulePar(), null, "importedModulePar", null, 0, 1, PImportModulePar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPImportModulePar_ImportedModulePartName(), theXMLTypePackage.getString(), "importedModulePartName", null, 1, 1, PImportModulePar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pImportTypeEClass, PImportType.class, "PImportType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPImportType_ImportedModuleName(), theXMLTypePackage.getString(), "importedModuleName", null, 1, 1, PImportType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPImportType_ImportedType(), this.getPType(), null, "importedType", null, 0, 1, PImportType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPImportType_ImportedTypeName(), theXMLTypePackage.getString(), "importedTypeName", null, 1, 1, PImportType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pIntegerEClass, PInteger.class, "PInteger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pIntegerArgumentEClass, PIntegerArgument.class, "PIntegerArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPIntegerArgument_Desc(), theXMLTypePackage.getString(), "desc", null, 1, 1, PIntegerArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pItemFieldEClass, PItemField.class, "PItemField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPItemField_Constraint(), this.getPTypeConstraint(), null, "constraint", null, 0, 1, PItemField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPItemField_EnumItems(), this.getPEnumItem(), null, "enumItems", null, 0, -1, PItemField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPItemField_EnumRef(), theXMLTypePackage.getNMTOKEN(), "enumRef", null, 0, 1, PItemField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pLengthConstraintEClass, PLengthConstraint.class, "PLengthConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPLengthConstraint_LowerBound(), theFpbtemplatePackage.getPMatcher(), null, "lowerBound", null, 1, 1, PLengthConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPLengthConstraint_UpperBound(), theFpbtemplatePackage.getPMatcher(), null, "upperBound", null, 1, 1, PLengthConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pListArgumentEClass, PListArgument.class, "PListArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPListArgument_Group(), this.getPArgumentGroup(), null, "group", null, 1, 1, PListArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pListConstraintEClass, PListConstraint.class, "PListConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPListConstraint_Matcher(), theFpbtemplatePackage.getPValueListMatcher(), null, "matcher", null, 1, 1, PListConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pListItemEClass, PListItem.class, "PListItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pListItemEVEClass, PListItemEV.class, "PListItemEV", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPListItemEV_PrpList(), this.getPPropertyList(), null, "prpList", null, 1, 1, PListItemEV.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pListTypeEClass, PListType.class, "PListType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPListType_Item(), this.getPListItem(), null, "item", null, 1, 1, PListType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pModuleEClass, PModule.class, "PModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPModule_ImportElements(), this.getPImportElement(), this.getPImportElement_Pmodule(), "importElements", null, 0, -1, PModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPModule_Types(), this.getPType(), this.getPType_Pmodule(), "types", null, 0, -1, PModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPModule_Constants(), this.getPConstant(), this.getPConstant_Pmodule(), "constants", null, 0, -1, PModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPModule_Templates(), theFpbtemplatePackage.getPTemplate(), null, "templates", null, 0, -1, PModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPModule_ModulePars(), this.getPModulePar(), this.getPModulePar_Pmodule(), "modulePars", null, 0, -1, PModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPModule_EnumSets(), this.getPEnumSet(), this.getPEnumSet_Pmodule(), "enumSets", null, 0, -1, PModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPModule_FactoryJavaClass(), theXMLTypePackage.getString(), "factoryJavaClass", null, 0, 1, PModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPModule_ModuleJavaClass(), theXMLTypePackage.getString(), "moduleJavaClass", null, 0, 1, PModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPModule_TypeEvFactoryJavaClass(), theXMLTypePackage.getString(), "typeEvFactoryJavaClass", null, 0, 1, PModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pModuleEVEClass, PModuleEV.class, "PModuleEV", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPModuleEV_PrpList(), this.getPPropertyList(), null, "prpList", null, 1, 1, PModuleEV.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pModuleParEClass, PModulePar.class, "PModulePar", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPModulePar_ModuleParID(), theXMLTypePackage.getInt(), "moduleParID", null, 0, 1, PModulePar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPModulePar_Pmodule(), this.getPModule(), this.getPModule_ModulePars(), "pmodule", null, 0, 1, PModulePar.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pObjidEClass, PObjid.class, "PObjid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pOctetstringEClass, POctetstring.class, "POctetstring", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pPatternConstraintEClass, PPatternConstraint.class, "PPatternConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPPatternConstraint_Matcher(), theFpbtemplatePackage.getPCharstringMatcher(), null, "matcher", null, 1, 1, PPatternConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pPrimitiveTypeEClass, PPrimitiveType.class, "PPrimitiveType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pPropertyEClass, PProperty.class, "PProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPProperty_Groups(), this.getPArgumentGroup(), null, "groups", null, 0, -1, PProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pPropertyListEClass, PPropertyList.class, "PPropertyList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPPropertyList_Properties(), this.getPProperty(), null, "properties", null, 0, -1, PPropertyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pRecordEClass, PRecord.class, "PRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pRecordOfEClass, PRecordOf.class, "PRecordOf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pSetEClass, PSet.class, "PSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pSetOfEClass, PSetOf.class, "PSetOf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pSingleArgumentEClass, PSingleArgument.class, "PSingleArgument", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pStringTypeEClass, PStringType.class, "PStringType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pSubTypeEClass, PSubType.class, "PSubType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPSubType_Constraint(), this.getPTypeConstraint(), null, "constraint", null, 0, 1, PSubType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPSubType_SuperType(), this.getPType(), null, "superType", null, 0, 1, PSubType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPSubType_SuperTypeName(), theXMLTypePackage.getString(), "superTypeName", null, 1, 1, PSubType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pTypeEClass, PType.class, "PType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPType_ContainerType(), theXMLTypePackage.getBoolean(), "containerType", null, 0, 1, PType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getPType_DerivativeMode(), this.getTypeDerivativeMode(), "derivativeMode", "ENTITY", 0, 1, PType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getPType_JavaClass(), theXMLTypePackage.getString(), "javaClass", null, 0, 1, PType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPType_ListType(), theXMLTypePackage.getBoolean(), "listType", null, 0, 1, PType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getPType_PrimitiveType(), theXMLTypePackage.getBoolean(), "primitiveType", null, 0, 1, PType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getPType_TypeClass(), this.getTypeClass(), "typeClass", "boolean", 0, 1, PType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getPType_TypeID(), theXMLTypePackage.getInt(), "typeID", null, 0, 1, PType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPType_Pmodule(), this.getPModule(), this.getPModule_Types(), "pmodule", null, 0, 1, PType.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pTypeConstraintEClass, PTypeConstraint.class, "PTypeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pTypedElementEClass, PTypedElement.class, "PTypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPTypedElement_Ptype(), this.getPType(), null, "ptype", null, 0, 1, PTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPTypedElement_PtypeName(), theXMLTypePackage.getString(), "ptypeName", null, 0, 1, PTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pTypeEVEClass, PTypeEV.class, "PTypeEV", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPTypeEV_PrpList(), this.getPPropertyList(), null, "prpList", null, 1, 1, PTypeEV.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pTypeReferenceArgumentEClass, PTypeReferenceArgument.class, "PTypeReferenceArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPTypeReferenceArgument_TypeName(), theXMLTypePackage.getString(), "typeName", null, 1, 1, PTypeReferenceArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pUnionEClass, PUnion.class, "PUnion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pUniversalCharstringEClass, PUniversalCharstring.class, "PUniversalCharstring", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(pValueReferenceArgumentEClass, PValueReferenceArgument.class, "PValueReferenceArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPValueReferenceArgument_ValueRef(), theFpbtemplatePackage.getPValueReferenceMatcher(), null, "valueRef", null, 1, 1, PValueReferenceArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPValueReferenceArgument_TypeName(), theXMLTypePackage.getString(), "typeName", null, 1, 1, PValueReferenceArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pVerdictEClass, PVerdict.class, "PVerdict", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Initialize enums and add enum literals
        initEEnum(byteOrderEEnum, ByteOrder.class, "ByteOrder");
        addEEnumLiteral(byteOrderEEnum, ByteOrder.NONE);
        addEEnumLiteral(byteOrderEEnum, ByteOrder.LITTLEENDIAN);
        addEEnumLiteral(byteOrderEEnum, ByteOrder.BIGENDIAN);

        initEEnum(encodingTypeEEnum, EncodingType.class, "EncodingType");
        addEEnumLiteral(encodingTypeEEnum, EncodingType.NONE);
        addEEnumLiteral(encodingTypeEEnum, EncodingType.FPB);
        addEEnumLiteral(encodingTypeEEnum, EncodingType.ASN1);

        initEEnum(flagFieldTypeEEnum, FlagFieldType.class, "FlagFieldType");
        addEEnumLiteral(flagFieldTypeEEnum, FlagFieldType.NONE);
        addEEnumLiteral(flagFieldTypeEEnum, FlagFieldType.OCTET);
        addEEnumLiteral(flagFieldTypeEEnum, FlagFieldType.OCTET2);
        addEEnumLiteral(flagFieldTypeEEnum, FlagFieldType.OCTET4);

        initEEnum(moduleElementTypeEEnum, ModuleElementType.class, "ModuleElementType");
        addEEnumLiteral(moduleElementTypeEEnum, ModuleElementType.TYPE);
        addEEnumLiteral(moduleElementTypeEEnum, ModuleElementType.CONST);
        addEEnumLiteral(moduleElementTypeEEnum, ModuleElementType.MODULEPAR);
        addEEnumLiteral(moduleElementTypeEEnum, ModuleElementType.TEMPLATE);

        initEEnum(onelineModeEEnum, OnelineMode.class, "OnelineMode");
        addEEnumLiteral(onelineModeEEnum, OnelineMode.NONE);
        addEEnumLiteral(onelineModeEEnum, OnelineMode.CRLF);
        addEEnumLiteral(onelineModeEEnum, OnelineMode.CR);
        addEEnumLiteral(onelineModeEEnum, OnelineMode.LF);

        initEEnum(padTypeEEnum, PadType.class, "PadType");
        addEEnumLiteral(padTypeEEnum, PadType.NO);
        addEEnumLiteral(padTypeEEnum, PadType.OCTET);
        addEEnumLiteral(padTypeEEnum, PadType.OCTET2);
        addEEnumLiteral(padTypeEEnum, PadType.OCTET4);
        addEEnumLiteral(padTypeEEnum, PadType.OCTET8);

        initEEnum(typeClassEEnum, TypeClass.class, "TypeClass");
        addEEnumLiteral(typeClassEEnum, TypeClass.BOOLEAN);
        addEEnumLiteral(typeClassEEnum, TypeClass.INTEGER);
        addEEnumLiteral(typeClassEEnum, TypeClass.FLOAT);
        addEEnumLiteral(typeClassEEnum, TypeClass.OBJID);
        addEEnumLiteral(typeClassEEnum, TypeClass.ENUMERATED);
        addEEnumLiteral(typeClassEEnum, TypeClass.OCTETSTRING);
        addEEnumLiteral(typeClassEEnum, TypeClass.CHARSTRING);
        addEEnumLiteral(typeClassEEnum, TypeClass.UNIVERSAL_CHARSTRING);
        addEEnumLiteral(typeClassEEnum, TypeClass.BITSTRING);
        addEEnumLiteral(typeClassEEnum, TypeClass.HEXSTRING);
        addEEnumLiteral(typeClassEEnum, TypeClass.RECORD);
        addEEnumLiteral(typeClassEEnum, TypeClass.SET);
        addEEnumLiteral(typeClassEEnum, TypeClass.UNION);
        addEEnumLiteral(typeClassEEnum, TypeClass.RECORDOF);
        addEEnumLiteral(typeClassEEnum, TypeClass.SETOF);
        addEEnumLiteral(typeClassEEnum, TypeClass.VERDICT);
        addEEnumLiteral(typeClassEEnum, TypeClass.ADDRESS);

        initEEnum(typeDerivativeModeEEnum, TypeDerivativeMode.class, "TypeDerivativeMode");
        addEEnumLiteral(typeDerivativeModeEEnum, TypeDerivativeMode.ENTITY);
        addEEnumLiteral(typeDerivativeModeEEnum, TypeDerivativeMode.SUB);
        addEEnumLiteral(typeDerivativeModeEEnum, TypeDerivativeMode.IMPORT);

        // Initialize data types
        initEDataType(byteOrderObjectEDataType, ByteOrder.class, "ByteOrderObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(encodingTypeObjectEDataType, EncodingType.class, "EncodingTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(flagFieldTypeObjectEDataType, FlagFieldType.class, "FlagFieldTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(moduleElementTypeObjectEDataType, ModuleElementType.class, "ModuleElementTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(onelineModeObjectEDataType, OnelineMode.class, "OnelineModeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(padTypeObjectEDataType, PadType.class, "PadTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(typeClassObjectEDataType, TypeClass.class, "TypeClassObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(typeDerivativeModeObjectEDataType, TypeDerivativeMode.class, "TypeDerivativeModeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations();
    }

	/**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void createExtendedMetaDataAnnotations() {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
        addAnnotation
          (byteOrderEEnum, 
           source, 
           new String[] {
             "name", "ByteOrder"
           });		
        addAnnotation
          (byteOrderObjectEDataType, 
           source, 
           new String[] {
             "name", "ByteOrder:Object",
             "baseType", "ByteOrder"
           });		
        addAnnotation
          (documentRootEClass, 
           source, 
           new String[] {
             "name", "",
             "kind", "mixed"
           });		
        addAnnotation
          (getDocumentRoot_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });		
        addAnnotation
          (getDocumentRoot_XMLNSPrefixMap(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "xmlns:prefix"
           });		
        addAnnotation
          (getDocumentRoot_XSISchemaLocation(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "xsi:schemaLocation"
           });		
        addAnnotation
          (getDocumentRoot_PModule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "PModule",
             "namespace", "##targetNamespace"
           });		
        addAnnotation
          (encodingTypeEEnum, 
           source, 
           new String[] {
             "name", "EncodingType"
           });		
        addAnnotation
          (encodingTypeObjectEDataType, 
           source, 
           new String[] {
             "name", "EncodingType:Object",
             "baseType", "EncodingType"
           });		
        addAnnotation
          (flagFieldTypeEEnum, 
           source, 
           new String[] {
             "name", "FlagFieldType"
           });		
        addAnnotation
          (flagFieldTypeObjectEDataType, 
           source, 
           new String[] {
             "name", "FlagFieldType:Object",
             "baseType", "FlagFieldType"
           });		
        addAnnotation
          (moduleElementTypeEEnum, 
           source, 
           new String[] {
             "name", "ModuleElementType"
           });		
        addAnnotation
          (moduleElementTypeObjectEDataType, 
           source, 
           new String[] {
             "name", "ModuleElementType:Object",
             "baseType", "ModuleElementType"
           });		
        addAnnotation
          (onelineModeEEnum, 
           source, 
           new String[] {
             "name", "OnelineMode"
           });		
        addAnnotation
          (onelineModeObjectEDataType, 
           source, 
           new String[] {
             "name", "OnelineMode:Object",
             "baseType", "OnelineMode"
           });		
        addAnnotation
          (pAddressEClass, 
           source, 
           new String[] {
             "name", "PAddress",
             "kind", "elementOnly"
           });		
        addAnnotation
          (padTypeEEnum, 
           source, 
           new String[] {
             "name", "PadType"
           });		
        addAnnotation
          (padTypeObjectEDataType, 
           source, 
           new String[] {
             "name", "PadType:Object",
             "baseType", "PadType"
           });		
        addAnnotation
          (pArgumentEClass, 
           source, 
           new String[] {
             "name", "PArgument",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pArgumentGroupEClass, 
           source, 
           new String[] {
             "name", "PArgumentGroup",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPArgumentGroup_Arguments(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "arguments"
           });		
        addAnnotation
          (pBitstringEClass, 
           source, 
           new String[] {
             "name", "PBitstring",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pBooleanEClass, 
           source, 
           new String[] {
             "name", "PBoolean",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pBooleanArgumentEClass, 
           source, 
           new String[] {
             "name", "PBooleanArgument",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPBooleanArgument_Desc(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "desc"
           });		
        addAnnotation
          (pCharstringEClass, 
           source, 
           new String[] {
             "name", "PCharstring",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pCharstringArgumentEClass, 
           source, 
           new String[] {
             "name", "PCharstringArgument",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPCharstringArgument_Desc(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "desc"
           });		
        addAnnotation
          (pCompoundConstraintEClass, 
           source, 
           new String[] {
             "name", "PCompoundConstraint",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPCompoundConstraint_Children(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "children"
           });		
        addAnnotation
          (pConditionArgumentEClass, 
           source, 
           new String[] {
             "name", "PConditionArgument",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPConditionArgument_Condition(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "condition"
           });		
        addAnnotation
          (getPConditionArgument_TypeName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "typeName"
           });		
        addAnnotation
          (pConstantEClass, 
           source, 
           new String[] {
             "name", "PConstant",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPConstant_ConstantID(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "constantID"
           });		
        addAnnotation
          (pContainerTypeEClass, 
           source, 
           new String[] {
             "name", "PContainerType",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPContainerType_Pfields(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "pfields"
           });		
        addAnnotation
          (pEncodedElementEClass, 
           source, 
           new String[] {
             "name", "PEncodedElement",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPEncodedElement_Variant(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "variant"
           });		
        addAnnotation
          (getPEncodedElement_Encode(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "encode"
           });		
        addAnnotation
          (getPEncodedElement_TypeEncodingDesc(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "typeEncodingDesc"
           });		
        addAnnotation
          (getPEncodedElement_TypeEncodingVariantDesc(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "typeEncodingVariantDesc"
           });		
        addAnnotation
          (getPEncodedElement_TypeExtensionDesc(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "typeExtensionDesc"
           });		
        addAnnotation
          (pEncodingVariantEClass, 
           source, 
           new String[] {
             "name", "PEncodingVariant",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pEntityConstantEClass, 
           source, 
           new String[] {
             "name", "PEntityConstant",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPEntityConstant_Matcher(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "matcher"
           });		
        addAnnotation
          (getPEntityConstant_BaseTypeName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "baseTypeName"
           });		
        addAnnotation
          (pEntityEnumSetEClass, 
           source, 
           new String[] {
             "name", "PEntityEnumSet",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPEntityEnumSet_EnumItems(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "enumItems"
           });		
        addAnnotation
          (getPEntityEnumSet_BaseTypeName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "baseTypeName"
           });		
        addAnnotation
          (pEntityModuleParEClass, 
           source, 
           new String[] {
             "name", "PEntityModulePar",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPEntityModulePar_Matcher(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "matcher"
           });		
        addAnnotation
          (getPEntityModulePar_BaseTypeName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "baseTypeName"
           });		
        addAnnotation
          (getPEntityModulePar_Thread(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "thread"
           });		
        addAnnotation
          (pEntityTypeEClass, 
           source, 
           new String[] {
             "name", "PEntityType",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPEntityType_Constraint(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "constraint"
           });		
        addAnnotation
          (pEnumeratedEClass, 
           source, 
           new String[] {
             "name", "PEnumerated",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPEnumerated_Items(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "items"
           });		
        addAnnotation
          (pEnumeratedItemEClass, 
           source, 
           new String[] {
             "name", "PEnumeratedItem",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPEnumeratedItem_EnumName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "enumName"
           });		
        addAnnotation
          (getPEnumeratedItem_EnumValue(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "enumValue"
           });		
        addAnnotation
          (pEnumItemEClass, 
           source, 
           new String[] {
             "name", "PEnumItem",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPEnumItem_Cond(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "cond"
           });		
        addAnnotation
          (getPEnumItem_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });		
        addAnnotation
          (pEnumSetEClass, 
           source, 
           new String[] {
             "name", "PEnumSet",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPEnumSet_EnumSetID(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "enumSetID"
           });		
        addAnnotation
          (pFieldEClass, 
           source, 
           new String[] {
             "name", "PField",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPField_FieldID(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "fieldID"
           });		
        addAnnotation
          (getPField_Optional(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "optional"
           });		
        addAnnotation
          (pFieldEVEClass, 
           source, 
           new String[] {
             "name", "PFieldEV",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPFieldEV_PrpList(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "prpList"
           });		
        addAnnotation
          (pFloatEClass, 
           source, 
           new String[] {
             "name", "PFloat",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pFpbFieldEVEClass, 
           source, 
           new String[] {
             "name", "PFpbFieldEV",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pFpbListItemEVEClass, 
           source, 
           new String[] {
             "name", "PFpbListItemEV",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pFpbModuleEVEClass, 
           source, 
           new String[] {
             "name", "PFpbModuleEV",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pFpbTypeEVEClass, 
           source, 
           new String[] {
             "name", "PFpbTypeEV",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pHexstringEClass, 
           source, 
           new String[] {
             "name", "PHexstring",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pIdentifierArgumentEClass, 
           source, 
           new String[] {
             "name", "PIdentifierArgument",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPIdentifierArgument_Desc(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "desc"
           });		
        addAnnotation
          (pImportConstantEClass, 
           source, 
           new String[] {
             "name", "PImportConstant",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPImportConstant_ImportedConstant(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importedConstant"
           });		
        addAnnotation
          (getPImportConstant_ImportedConstantName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importedConstantName"
           });		
        addAnnotation
          (getPImportConstant_ImportedModuleName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importedModuleName"
           });		
        addAnnotation
          (pImportElementEClass, 
           source, 
           new String[] {
             "name", "PImportElement",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPImportElement_RefNameList(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "refNameList"
           });		
        addAnnotation
          (getPImportElement_AllExcept(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "allExcept"
           });		
        addAnnotation
          (getPImportElement_ElementType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "elementType"
           });		
        addAnnotation
          (getPImportElement_FromModuleName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "fromModuleName"
           });		
        addAnnotation
          (pImportEnumSetEClass, 
           source, 
           new String[] {
             "name", "PImportEnumSet",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPImportEnumSet_ImportedEnumSet(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importedEnumSet"
           });		
        addAnnotation
          (getPImportEnumSet_ImportedEnumSetName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importedEnumSetName"
           });		
        addAnnotation
          (getPImportEnumSet_ImportedModuleName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importedModuleName"
           });		
        addAnnotation
          (pImportModuleParEClass, 
           source, 
           new String[] {
             "name", "PImportModulePar",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPImportModulePar_ImportedModuleName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importedModuleName"
           });		
        addAnnotation
          (getPImportModulePar_ImportedModulePar(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importedModulePar"
           });		
        addAnnotation
          (getPImportModulePar_ImportedModulePartName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importedModulePartName"
           });		
        addAnnotation
          (pImportTypeEClass, 
           source, 
           new String[] {
             "name", "PImportType",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPImportType_ImportedModuleName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importedModuleName"
           });		
        addAnnotation
          (getPImportType_ImportedType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importedType"
           });		
        addAnnotation
          (getPImportType_ImportedTypeName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importedTypeName"
           });		
        addAnnotation
          (pIntegerEClass, 
           source, 
           new String[] {
             "name", "PInteger",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pIntegerArgumentEClass, 
           source, 
           new String[] {
             "name", "PIntegerArgument",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPIntegerArgument_Desc(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "desc"
           });		
        addAnnotation
          (pItemFieldEClass, 
           source, 
           new String[] {
             "name", "PItemField",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPItemField_Constraint(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "constraint"
           });		
        addAnnotation
          (getPItemField_EnumItems(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "enumItems"
           });		
        addAnnotation
          (getPItemField_EnumRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "enumRef"
           });		
        addAnnotation
          (pLengthConstraintEClass, 
           source, 
           new String[] {
             "name", "PLengthConstraint",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPLengthConstraint_LowerBound(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "lowerBound"
           });		
        addAnnotation
          (getPLengthConstraint_UpperBound(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "upperBound"
           });		
        addAnnotation
          (pListArgumentEClass, 
           source, 
           new String[] {
             "name", "PListArgument",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPListArgument_Group(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "group"
           });		
        addAnnotation
          (pListConstraintEClass, 
           source, 
           new String[] {
             "name", "PListConstraint",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPListConstraint_Matcher(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "matcher"
           });		
        addAnnotation
          (pListItemEClass, 
           source, 
           new String[] {
             "name", "PListItem",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pListItemEVEClass, 
           source, 
           new String[] {
             "name", "PListItemEV",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPListItemEV_PrpList(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "prpList"
           });		
        addAnnotation
          (pListTypeEClass, 
           source, 
           new String[] {
             "name", "PListType",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPListType_Item(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "item"
           });		
        addAnnotation
          (pModuleEClass, 
           source, 
           new String[] {
             "name", "PModule",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPModule_ImportElements(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "importElements"
           });		
        addAnnotation
          (getPModule_Types(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "types"
           });		
        addAnnotation
          (getPModule_Constants(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "constants"
           });		
        addAnnotation
          (getPModule_Templates(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "templates"
           });		
        addAnnotation
          (getPModule_ModulePars(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "modulePars"
           });		
        addAnnotation
          (getPModule_EnumSets(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "enumSets"
           });		
        addAnnotation
          (getPModule_FactoryJavaClass(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "factoryJavaClass"
           });		
        addAnnotation
          (getPModule_ModuleJavaClass(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "moduleJavaClass"
           });		
        addAnnotation
          (getPModule_TypeEvFactoryJavaClass(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "typeEvFactoryJavaClass"
           });		
        addAnnotation
          (pModuleEVEClass, 
           source, 
           new String[] {
             "name", "PModuleEV",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPModuleEV_PrpList(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "prpList"
           });		
        addAnnotation
          (pModuleParEClass, 
           source, 
           new String[] {
             "name", "PModulePar",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPModulePar_ModuleParID(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "moduleParID"
           });		
        addAnnotation
          (pObjidEClass, 
           source, 
           new String[] {
             "name", "PObjid",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pOctetstringEClass, 
           source, 
           new String[] {
             "name", "POctetstring",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pPatternConstraintEClass, 
           source, 
           new String[] {
             "name", "PPatternConstraint",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPPatternConstraint_Matcher(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "matcher"
           });		
        addAnnotation
          (pPrimitiveTypeEClass, 
           source, 
           new String[] {
             "name", "PPrimitiveType",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pPropertyEClass, 
           source, 
           new String[] {
             "name", "PProperty",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPProperty_Groups(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "groups"
           });		
        addAnnotation
          (pPropertyListEClass, 
           source, 
           new String[] {
             "name", "PPropertyList",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPPropertyList_Properties(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "properties"
           });		
        addAnnotation
          (pRecordEClass, 
           source, 
           new String[] {
             "name", "PRecord",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pRecordOfEClass, 
           source, 
           new String[] {
             "name", "PRecordOf",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pSetEClass, 
           source, 
           new String[] {
             "name", "PSet",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pSetOfEClass, 
           source, 
           new String[] {
             "name", "PSetOf",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pSingleArgumentEClass, 
           source, 
           new String[] {
             "name", "PSingleArgument",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pStringTypeEClass, 
           source, 
           new String[] {
             "name", "PStringType",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pSubTypeEClass, 
           source, 
           new String[] {
             "name", "PSubType",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPSubType_Constraint(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "constraint"
           });		
        addAnnotation
          (getPSubType_SuperType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "superType"
           });		
        addAnnotation
          (getPSubType_SuperTypeName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "superTypeName"
           });		
        addAnnotation
          (pTypeEClass, 
           source, 
           new String[] {
             "name", "PType",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPType_ContainerType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "containerType"
           });		
        addAnnotation
          (getPType_DerivativeMode(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "derivativeMode"
           });		
        addAnnotation
          (getPType_JavaClass(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "javaClass"
           });		
        addAnnotation
          (getPType_ListType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "listType"
           });		
        addAnnotation
          (getPType_PrimitiveType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "primitiveType"
           });		
        addAnnotation
          (getPType_TypeClass(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "typeClass"
           });		
        addAnnotation
          (getPType_TypeID(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "typeID"
           });		
        addAnnotation
          (pTypeConstraintEClass, 
           source, 
           new String[] {
             "name", "PTypeConstraint",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pTypedElementEClass, 
           source, 
           new String[] {
             "name", "PTypedElement",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPTypedElement_Ptype(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "ptype"
           });		
        addAnnotation
          (getPTypedElement_PtypeName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "ptypeName"
           });		
        addAnnotation
          (pTypeEVEClass, 
           source, 
           new String[] {
             "name", "PTypeEV",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPTypeEV_PrpList(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "prpList"
           });		
        addAnnotation
          (pTypeReferenceArgumentEClass, 
           source, 
           new String[] {
             "name", "PTypeReferenceArgument",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPTypeReferenceArgument_TypeName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "typeName"
           });		
        addAnnotation
          (pUnionEClass, 
           source, 
           new String[] {
             "name", "PUnion",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pUniversalCharstringEClass, 
           source, 
           new String[] {
             "name", "PUniversalCharstring",
             "kind", "elementOnly"
           });		
        addAnnotation
          (pValueReferenceArgumentEClass, 
           source, 
           new String[] {
             "name", "PValueReferenceArgument",
             "kind", "elementOnly"
           });		
        addAnnotation
          (getPValueReferenceArgument_ValueRef(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "valueRef"
           });		
        addAnnotation
          (getPValueReferenceArgument_TypeName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "typeName"
           });		
        addAnnotation
          (pVerdictEClass, 
           source, 
           new String[] {
             "name", "PVerdict",
             "kind", "elementOnly"
           });		
        addAnnotation
          (typeClassEEnum, 
           source, 
           new String[] {
             "name", "TypeClass"
           });		
        addAnnotation
          (typeClassObjectEDataType, 
           source, 
           new String[] {
             "name", "TypeClass:Object",
             "baseType", "TypeClass"
           });		
        addAnnotation
          (typeDerivativeModeEEnum, 
           source, 
           new String[] {
             "name", "TypeDerivativeMode"
           });		
        addAnnotation
          (typeDerivativeModeObjectEDataType, 
           source, 
           new String[] {
             "name", "TypeDerivativeMode:Object",
             "baseType", "TypeDerivativeMode"
           });
    }

} //FpbmodulePackageImpl
