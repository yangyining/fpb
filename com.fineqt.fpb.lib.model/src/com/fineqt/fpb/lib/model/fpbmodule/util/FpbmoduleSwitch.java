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
package com.fineqt.fpb.lib.model.fpbmodule.util;

import com.fineqt.fpb.lib.model.fpbcommon.PModelElement;
import com.fineqt.fpb.lib.model.fpbcommon.PNamedElement;
import com.fineqt.fpb.lib.model.fpbmodule.*;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage
 * @generated
 */
public class FpbmoduleSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static FpbmodulePackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FpbmoduleSwitch() {
        if (modelPackage == null) {
            modelPackage = FpbmodulePackage.eINSTANCE;
        }
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case FpbmodulePackage.DOCUMENT_ROOT: {
                DocumentRoot documentRoot = (DocumentRoot)theEObject;
                T result = caseDocumentRoot(documentRoot);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PADDRESS: {
                PAddress pAddress = (PAddress)theEObject;
                T result = casePAddress(pAddress);
                if (result == null) result = casePPrimitiveType(pAddress);
                if (result == null) result = casePEntityType(pAddress);
                if (result == null) result = casePType(pAddress);
                if (result == null) result = casePEncodedElement(pAddress);
                if (result == null) result = casePNamedElement(pAddress);
                if (result == null) result = casePModelElement(pAddress);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PARGUMENT: {
                PArgument pArgument = (PArgument)theEObject;
                T result = casePArgument(pArgument);
                if (result == null) result = casePModelElement(pArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PARGUMENT_GROUP: {
                PArgumentGroup pArgumentGroup = (PArgumentGroup)theEObject;
                T result = casePArgumentGroup(pArgumentGroup);
                if (result == null) result = casePModelElement(pArgumentGroup);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PBITSTRING: {
                PBitstring pBitstring = (PBitstring)theEObject;
                T result = casePBitstring(pBitstring);
                if (result == null) result = casePStringType(pBitstring);
                if (result == null) result = casePPrimitiveType(pBitstring);
                if (result == null) result = casePEntityType(pBitstring);
                if (result == null) result = casePType(pBitstring);
                if (result == null) result = casePEncodedElement(pBitstring);
                if (result == null) result = casePNamedElement(pBitstring);
                if (result == null) result = casePModelElement(pBitstring);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PBOOLEAN: {
                PBoolean pBoolean = (PBoolean)theEObject;
                T result = casePBoolean(pBoolean);
                if (result == null) result = casePPrimitiveType(pBoolean);
                if (result == null) result = casePEntityType(pBoolean);
                if (result == null) result = casePType(pBoolean);
                if (result == null) result = casePEncodedElement(pBoolean);
                if (result == null) result = casePNamedElement(pBoolean);
                if (result == null) result = casePModelElement(pBoolean);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PBOOLEAN_ARGUMENT: {
                PBooleanArgument pBooleanArgument = (PBooleanArgument)theEObject;
                T result = casePBooleanArgument(pBooleanArgument);
                if (result == null) result = casePSingleArgument(pBooleanArgument);
                if (result == null) result = casePArgument(pBooleanArgument);
                if (result == null) result = casePModelElement(pBooleanArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PCHARSTRING: {
                PCharstring pCharstring = (PCharstring)theEObject;
                T result = casePCharstring(pCharstring);
                if (result == null) result = casePStringType(pCharstring);
                if (result == null) result = casePPrimitiveType(pCharstring);
                if (result == null) result = casePEntityType(pCharstring);
                if (result == null) result = casePType(pCharstring);
                if (result == null) result = casePEncodedElement(pCharstring);
                if (result == null) result = casePNamedElement(pCharstring);
                if (result == null) result = casePModelElement(pCharstring);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PCHARSTRING_ARGUMENT: {
                PCharstringArgument pCharstringArgument = (PCharstringArgument)theEObject;
                T result = casePCharstringArgument(pCharstringArgument);
                if (result == null) result = casePSingleArgument(pCharstringArgument);
                if (result == null) result = casePArgument(pCharstringArgument);
                if (result == null) result = casePModelElement(pCharstringArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PCOMPOUND_CONSTRAINT: {
                PCompoundConstraint pCompoundConstraint = (PCompoundConstraint)theEObject;
                T result = casePCompoundConstraint(pCompoundConstraint);
                if (result == null) result = casePTypeConstraint(pCompoundConstraint);
                if (result == null) result = casePModelElement(pCompoundConstraint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PCONDITION_ARGUMENT: {
                PConditionArgument pConditionArgument = (PConditionArgument)theEObject;
                T result = casePConditionArgument(pConditionArgument);
                if (result == null) result = casePSingleArgument(pConditionArgument);
                if (result == null) result = casePArgument(pConditionArgument);
                if (result == null) result = casePModelElement(pConditionArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PCONSTANT: {
                PConstant pConstant = (PConstant)theEObject;
                T result = casePConstant(pConstant);
                if (result == null) result = casePNamedElement(pConstant);
                if (result == null) result = casePModelElement(pConstant);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PCONTAINER_TYPE: {
                PContainerType pContainerType = (PContainerType)theEObject;
                T result = casePContainerType(pContainerType);
                if (result == null) result = casePEntityType(pContainerType);
                if (result == null) result = casePType(pContainerType);
                if (result == null) result = casePEncodedElement(pContainerType);
                if (result == null) result = casePNamedElement(pContainerType);
                if (result == null) result = casePModelElement(pContainerType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PENCODED_ELEMENT: {
                PEncodedElement pEncodedElement = (PEncodedElement)theEObject;
                T result = casePEncodedElement(pEncodedElement);
                if (result == null) result = casePNamedElement(pEncodedElement);
                if (result == null) result = casePModelElement(pEncodedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PENCODING_VARIANT: {
                PEncodingVariant pEncodingVariant = (PEncodingVariant)theEObject;
                T result = casePEncodingVariant(pEncodingVariant);
                if (result == null) result = casePModelElement(pEncodingVariant);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PENTITY_CONSTANT: {
                PEntityConstant pEntityConstant = (PEntityConstant)theEObject;
                T result = casePEntityConstant(pEntityConstant);
                if (result == null) result = casePConstant(pEntityConstant);
                if (result == null) result = casePNamedElement(pEntityConstant);
                if (result == null) result = casePModelElement(pEntityConstant);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PENTITY_ENUM_SET: {
                PEntityEnumSet pEntityEnumSet = (PEntityEnumSet)theEObject;
                T result = casePEntityEnumSet(pEntityEnumSet);
                if (result == null) result = casePEnumSet(pEntityEnumSet);
                if (result == null) result = casePNamedElement(pEntityEnumSet);
                if (result == null) result = casePModelElement(pEntityEnumSet);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PENTITY_MODULE_PAR: {
                PEntityModulePar pEntityModulePar = (PEntityModulePar)theEObject;
                T result = casePEntityModulePar(pEntityModulePar);
                if (result == null) result = casePModulePar(pEntityModulePar);
                if (result == null) result = casePNamedElement(pEntityModulePar);
                if (result == null) result = casePModelElement(pEntityModulePar);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PENTITY_TYPE: {
                PEntityType pEntityType = (PEntityType)theEObject;
                T result = casePEntityType(pEntityType);
                if (result == null) result = casePType(pEntityType);
                if (result == null) result = casePEncodedElement(pEntityType);
                if (result == null) result = casePNamedElement(pEntityType);
                if (result == null) result = casePModelElement(pEntityType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PENUMERATED: {
                PEnumerated pEnumerated = (PEnumerated)theEObject;
                T result = casePEnumerated(pEnumerated);
                if (result == null) result = casePPrimitiveType(pEnumerated);
                if (result == null) result = casePEntityType(pEnumerated);
                if (result == null) result = casePType(pEnumerated);
                if (result == null) result = casePEncodedElement(pEnumerated);
                if (result == null) result = casePNamedElement(pEnumerated);
                if (result == null) result = casePModelElement(pEnumerated);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PENUMERATED_ITEM: {
                PEnumeratedItem pEnumeratedItem = (PEnumeratedItem)theEObject;
                T result = casePEnumeratedItem(pEnumeratedItem);
                if (result == null) result = casePModelElement(pEnumeratedItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PENUM_ITEM: {
                PEnumItem pEnumItem = (PEnumItem)theEObject;
                T result = casePEnumItem(pEnumItem);
                if (result == null) result = casePModelElement(pEnumItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PENUM_SET: {
                PEnumSet pEnumSet = (PEnumSet)theEObject;
                T result = casePEnumSet(pEnumSet);
                if (result == null) result = casePNamedElement(pEnumSet);
                if (result == null) result = casePModelElement(pEnumSet);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PFIELD: {
                PField pField = (PField)theEObject;
                T result = casePField(pField);
                if (result == null) result = casePItemField(pField);
                if (result == null) result = casePTypedElement(pField);
                if (result == null) result = casePEncodedElement(pField);
                if (result == null) result = casePNamedElement(pField);
                if (result == null) result = casePModelElement(pField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PFIELD_EV: {
                PFieldEV pFieldEV = (PFieldEV)theEObject;
                T result = casePFieldEV(pFieldEV);
                if (result == null) result = casePEncodingVariant(pFieldEV);
                if (result == null) result = casePModelElement(pFieldEV);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PFLOAT: {
                PFloat pFloat = (PFloat)theEObject;
                T result = casePFloat(pFloat);
                if (result == null) result = casePPrimitiveType(pFloat);
                if (result == null) result = casePEntityType(pFloat);
                if (result == null) result = casePType(pFloat);
                if (result == null) result = casePEncodedElement(pFloat);
                if (result == null) result = casePNamedElement(pFloat);
                if (result == null) result = casePModelElement(pFloat);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PFPB_FIELD_EV: {
                PFpbFieldEV pFpbFieldEV = (PFpbFieldEV)theEObject;
                T result = casePFpbFieldEV(pFpbFieldEV);
                if (result == null) result = casePFieldEV(pFpbFieldEV);
                if (result == null) result = casePEncodingVariant(pFpbFieldEV);
                if (result == null) result = casePModelElement(pFpbFieldEV);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PFPB_LIST_ITEM_EV: {
                PFpbListItemEV pFpbListItemEV = (PFpbListItemEV)theEObject;
                T result = casePFpbListItemEV(pFpbListItemEV);
                if (result == null) result = casePListItemEV(pFpbListItemEV);
                if (result == null) result = casePEncodingVariant(pFpbListItemEV);
                if (result == null) result = casePModelElement(pFpbListItemEV);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PFPB_MODULE_EV: {
                PFpbModuleEV pFpbModuleEV = (PFpbModuleEV)theEObject;
                T result = casePFpbModuleEV(pFpbModuleEV);
                if (result == null) result = casePModuleEV(pFpbModuleEV);
                if (result == null) result = casePEncodingVariant(pFpbModuleEV);
                if (result == null) result = casePModelElement(pFpbModuleEV);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PFPB_TYPE_EV: {
                PFpbTypeEV pFpbTypeEV = (PFpbTypeEV)theEObject;
                T result = casePFpbTypeEV(pFpbTypeEV);
                if (result == null) result = casePTypeEV(pFpbTypeEV);
                if (result == null) result = casePEncodingVariant(pFpbTypeEV);
                if (result == null) result = casePModelElement(pFpbTypeEV);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PHEXSTRING: {
                PHexstring pHexstring = (PHexstring)theEObject;
                T result = casePHexstring(pHexstring);
                if (result == null) result = casePStringType(pHexstring);
                if (result == null) result = casePPrimitiveType(pHexstring);
                if (result == null) result = casePEntityType(pHexstring);
                if (result == null) result = casePType(pHexstring);
                if (result == null) result = casePEncodedElement(pHexstring);
                if (result == null) result = casePNamedElement(pHexstring);
                if (result == null) result = casePModelElement(pHexstring);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PIDENTIFIER_ARGUMENT: {
                PIdentifierArgument pIdentifierArgument = (PIdentifierArgument)theEObject;
                T result = casePIdentifierArgument(pIdentifierArgument);
                if (result == null) result = casePSingleArgument(pIdentifierArgument);
                if (result == null) result = casePArgument(pIdentifierArgument);
                if (result == null) result = casePModelElement(pIdentifierArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PIMPORT_CONSTANT: {
                PImportConstant pImportConstant = (PImportConstant)theEObject;
                T result = casePImportConstant(pImportConstant);
                if (result == null) result = casePConstant(pImportConstant);
                if (result == null) result = casePNamedElement(pImportConstant);
                if (result == null) result = casePModelElement(pImportConstant);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PIMPORT_ELEMENT: {
                PImportElement pImportElement = (PImportElement)theEObject;
                T result = casePImportElement(pImportElement);
                if (result == null) result = casePModelElement(pImportElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PIMPORT_ENUM_SET: {
                PImportEnumSet pImportEnumSet = (PImportEnumSet)theEObject;
                T result = casePImportEnumSet(pImportEnumSet);
                if (result == null) result = casePEnumSet(pImportEnumSet);
                if (result == null) result = casePNamedElement(pImportEnumSet);
                if (result == null) result = casePModelElement(pImportEnumSet);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PIMPORT_MODULE_PAR: {
                PImportModulePar pImportModulePar = (PImportModulePar)theEObject;
                T result = casePImportModulePar(pImportModulePar);
                if (result == null) result = casePModulePar(pImportModulePar);
                if (result == null) result = casePNamedElement(pImportModulePar);
                if (result == null) result = casePModelElement(pImportModulePar);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PIMPORT_TYPE: {
                PImportType pImportType = (PImportType)theEObject;
                T result = casePImportType(pImportType);
                if (result == null) result = casePType(pImportType);
                if (result == null) result = casePEncodedElement(pImportType);
                if (result == null) result = casePNamedElement(pImportType);
                if (result == null) result = casePModelElement(pImportType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PINTEGER: {
                PInteger pInteger = (PInteger)theEObject;
                T result = casePInteger(pInteger);
                if (result == null) result = casePPrimitiveType(pInteger);
                if (result == null) result = casePEntityType(pInteger);
                if (result == null) result = casePType(pInteger);
                if (result == null) result = casePEncodedElement(pInteger);
                if (result == null) result = casePNamedElement(pInteger);
                if (result == null) result = casePModelElement(pInteger);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PINTEGER_ARGUMENT: {
                PIntegerArgument pIntegerArgument = (PIntegerArgument)theEObject;
                T result = casePIntegerArgument(pIntegerArgument);
                if (result == null) result = casePSingleArgument(pIntegerArgument);
                if (result == null) result = casePArgument(pIntegerArgument);
                if (result == null) result = casePModelElement(pIntegerArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PITEM_FIELD: {
                PItemField pItemField = (PItemField)theEObject;
                T result = casePItemField(pItemField);
                if (result == null) result = casePTypedElement(pItemField);
                if (result == null) result = casePEncodedElement(pItemField);
                if (result == null) result = casePNamedElement(pItemField);
                if (result == null) result = casePModelElement(pItemField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PLENGTH_CONSTRAINT: {
                PLengthConstraint pLengthConstraint = (PLengthConstraint)theEObject;
                T result = casePLengthConstraint(pLengthConstraint);
                if (result == null) result = casePTypeConstraint(pLengthConstraint);
                if (result == null) result = casePModelElement(pLengthConstraint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PLIST_ARGUMENT: {
                PListArgument pListArgument = (PListArgument)theEObject;
                T result = casePListArgument(pListArgument);
                if (result == null) result = casePArgument(pListArgument);
                if (result == null) result = casePModelElement(pListArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PLIST_CONSTRAINT: {
                PListConstraint pListConstraint = (PListConstraint)theEObject;
                T result = casePListConstraint(pListConstraint);
                if (result == null) result = casePTypeConstraint(pListConstraint);
                if (result == null) result = casePModelElement(pListConstraint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PLIST_ITEM: {
                PListItem pListItem = (PListItem)theEObject;
                T result = casePListItem(pListItem);
                if (result == null) result = casePItemField(pListItem);
                if (result == null) result = casePTypedElement(pListItem);
                if (result == null) result = casePEncodedElement(pListItem);
                if (result == null) result = casePNamedElement(pListItem);
                if (result == null) result = casePModelElement(pListItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PLIST_ITEM_EV: {
                PListItemEV pListItemEV = (PListItemEV)theEObject;
                T result = casePListItemEV(pListItemEV);
                if (result == null) result = casePEncodingVariant(pListItemEV);
                if (result == null) result = casePModelElement(pListItemEV);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PLIST_TYPE: {
                PListType pListType = (PListType)theEObject;
                T result = casePListType(pListType);
                if (result == null) result = casePEntityType(pListType);
                if (result == null) result = casePType(pListType);
                if (result == null) result = casePEncodedElement(pListType);
                if (result == null) result = casePNamedElement(pListType);
                if (result == null) result = casePModelElement(pListType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PMODULE: {
                PModule pModule = (PModule)theEObject;
                T result = casePModule(pModule);
                if (result == null) result = casePEncodedElement(pModule);
                if (result == null) result = casePNamedElement(pModule);
                if (result == null) result = casePModelElement(pModule);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PMODULE_EV: {
                PModuleEV pModuleEV = (PModuleEV)theEObject;
                T result = casePModuleEV(pModuleEV);
                if (result == null) result = casePEncodingVariant(pModuleEV);
                if (result == null) result = casePModelElement(pModuleEV);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PMODULE_PAR: {
                PModulePar pModulePar = (PModulePar)theEObject;
                T result = casePModulePar(pModulePar);
                if (result == null) result = casePNamedElement(pModulePar);
                if (result == null) result = casePModelElement(pModulePar);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.POBJID: {
                PObjid pObjid = (PObjid)theEObject;
                T result = casePObjid(pObjid);
                if (result == null) result = casePPrimitiveType(pObjid);
                if (result == null) result = casePEntityType(pObjid);
                if (result == null) result = casePType(pObjid);
                if (result == null) result = casePEncodedElement(pObjid);
                if (result == null) result = casePNamedElement(pObjid);
                if (result == null) result = casePModelElement(pObjid);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.POCTETSTRING: {
                POctetstring pOctetstring = (POctetstring)theEObject;
                T result = casePOctetstring(pOctetstring);
                if (result == null) result = casePStringType(pOctetstring);
                if (result == null) result = casePPrimitiveType(pOctetstring);
                if (result == null) result = casePEntityType(pOctetstring);
                if (result == null) result = casePType(pOctetstring);
                if (result == null) result = casePEncodedElement(pOctetstring);
                if (result == null) result = casePNamedElement(pOctetstring);
                if (result == null) result = casePModelElement(pOctetstring);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PPATTERN_CONSTRAINT: {
                PPatternConstraint pPatternConstraint = (PPatternConstraint)theEObject;
                T result = casePPatternConstraint(pPatternConstraint);
                if (result == null) result = casePTypeConstraint(pPatternConstraint);
                if (result == null) result = casePModelElement(pPatternConstraint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PPRIMITIVE_TYPE: {
                PPrimitiveType pPrimitiveType = (PPrimitiveType)theEObject;
                T result = casePPrimitiveType(pPrimitiveType);
                if (result == null) result = casePEntityType(pPrimitiveType);
                if (result == null) result = casePType(pPrimitiveType);
                if (result == null) result = casePEncodedElement(pPrimitiveType);
                if (result == null) result = casePNamedElement(pPrimitiveType);
                if (result == null) result = casePModelElement(pPrimitiveType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PPROPERTY: {
                PProperty pProperty = (PProperty)theEObject;
                T result = casePProperty(pProperty);
                if (result == null) result = casePNamedElement(pProperty);
                if (result == null) result = casePModelElement(pProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PPROPERTY_LIST: {
                PPropertyList pPropertyList = (PPropertyList)theEObject;
                T result = casePPropertyList(pPropertyList);
                if (result == null) result = casePModelElement(pPropertyList);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PRECORD: {
                PRecord pRecord = (PRecord)theEObject;
                T result = casePRecord(pRecord);
                if (result == null) result = casePContainerType(pRecord);
                if (result == null) result = casePEntityType(pRecord);
                if (result == null) result = casePType(pRecord);
                if (result == null) result = casePEncodedElement(pRecord);
                if (result == null) result = casePNamedElement(pRecord);
                if (result == null) result = casePModelElement(pRecord);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PRECORD_OF: {
                PRecordOf pRecordOf = (PRecordOf)theEObject;
                T result = casePRecordOf(pRecordOf);
                if (result == null) result = casePListType(pRecordOf);
                if (result == null) result = casePEntityType(pRecordOf);
                if (result == null) result = casePType(pRecordOf);
                if (result == null) result = casePEncodedElement(pRecordOf);
                if (result == null) result = casePNamedElement(pRecordOf);
                if (result == null) result = casePModelElement(pRecordOf);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PSET: {
                PSet pSet = (PSet)theEObject;
                T result = casePSet(pSet);
                if (result == null) result = casePContainerType(pSet);
                if (result == null) result = casePEntityType(pSet);
                if (result == null) result = casePType(pSet);
                if (result == null) result = casePEncodedElement(pSet);
                if (result == null) result = casePNamedElement(pSet);
                if (result == null) result = casePModelElement(pSet);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PSET_OF: {
                PSetOf pSetOf = (PSetOf)theEObject;
                T result = casePSetOf(pSetOf);
                if (result == null) result = casePListType(pSetOf);
                if (result == null) result = casePEntityType(pSetOf);
                if (result == null) result = casePType(pSetOf);
                if (result == null) result = casePEncodedElement(pSetOf);
                if (result == null) result = casePNamedElement(pSetOf);
                if (result == null) result = casePModelElement(pSetOf);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PSINGLE_ARGUMENT: {
                PSingleArgument pSingleArgument = (PSingleArgument)theEObject;
                T result = casePSingleArgument(pSingleArgument);
                if (result == null) result = casePArgument(pSingleArgument);
                if (result == null) result = casePModelElement(pSingleArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PSTRING_TYPE: {
                PStringType pStringType = (PStringType)theEObject;
                T result = casePStringType(pStringType);
                if (result == null) result = casePPrimitiveType(pStringType);
                if (result == null) result = casePEntityType(pStringType);
                if (result == null) result = casePType(pStringType);
                if (result == null) result = casePEncodedElement(pStringType);
                if (result == null) result = casePNamedElement(pStringType);
                if (result == null) result = casePModelElement(pStringType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PSUB_TYPE: {
                PSubType pSubType = (PSubType)theEObject;
                T result = casePSubType(pSubType);
                if (result == null) result = casePType(pSubType);
                if (result == null) result = casePEncodedElement(pSubType);
                if (result == null) result = casePNamedElement(pSubType);
                if (result == null) result = casePModelElement(pSubType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PTYPE: {
                PType pType = (PType)theEObject;
                T result = casePType(pType);
                if (result == null) result = casePEncodedElement(pType);
                if (result == null) result = casePNamedElement(pType);
                if (result == null) result = casePModelElement(pType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PTYPE_CONSTRAINT: {
                PTypeConstraint pTypeConstraint = (PTypeConstraint)theEObject;
                T result = casePTypeConstraint(pTypeConstraint);
                if (result == null) result = casePModelElement(pTypeConstraint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PTYPED_ELEMENT: {
                PTypedElement pTypedElement = (PTypedElement)theEObject;
                T result = casePTypedElement(pTypedElement);
                if (result == null) result = casePEncodedElement(pTypedElement);
                if (result == null) result = casePNamedElement(pTypedElement);
                if (result == null) result = casePModelElement(pTypedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PTYPE_EV: {
                PTypeEV pTypeEV = (PTypeEV)theEObject;
                T result = casePTypeEV(pTypeEV);
                if (result == null) result = casePEncodingVariant(pTypeEV);
                if (result == null) result = casePModelElement(pTypeEV);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PTYPE_REFERENCE_ARGUMENT: {
                PTypeReferenceArgument pTypeReferenceArgument = (PTypeReferenceArgument)theEObject;
                T result = casePTypeReferenceArgument(pTypeReferenceArgument);
                if (result == null) result = casePSingleArgument(pTypeReferenceArgument);
                if (result == null) result = casePArgument(pTypeReferenceArgument);
                if (result == null) result = casePModelElement(pTypeReferenceArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PUNION: {
                PUnion pUnion = (PUnion)theEObject;
                T result = casePUnion(pUnion);
                if (result == null) result = casePContainerType(pUnion);
                if (result == null) result = casePEntityType(pUnion);
                if (result == null) result = casePType(pUnion);
                if (result == null) result = casePEncodedElement(pUnion);
                if (result == null) result = casePNamedElement(pUnion);
                if (result == null) result = casePModelElement(pUnion);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PUNIVERSAL_CHARSTRING: {
                PUniversalCharstring pUniversalCharstring = (PUniversalCharstring)theEObject;
                T result = casePUniversalCharstring(pUniversalCharstring);
                if (result == null) result = casePStringType(pUniversalCharstring);
                if (result == null) result = casePPrimitiveType(pUniversalCharstring);
                if (result == null) result = casePEntityType(pUniversalCharstring);
                if (result == null) result = casePType(pUniversalCharstring);
                if (result == null) result = casePEncodedElement(pUniversalCharstring);
                if (result == null) result = casePNamedElement(pUniversalCharstring);
                if (result == null) result = casePModelElement(pUniversalCharstring);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT: {
                PValueReferenceArgument pValueReferenceArgument = (PValueReferenceArgument)theEObject;
                T result = casePValueReferenceArgument(pValueReferenceArgument);
                if (result == null) result = casePSingleArgument(pValueReferenceArgument);
                if (result == null) result = casePArgument(pValueReferenceArgument);
                if (result == null) result = casePModelElement(pValueReferenceArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case FpbmodulePackage.PVERDICT: {
                PVerdict pVerdict = (PVerdict)theEObject;
                T result = casePVerdict(pVerdict);
                if (result == null) result = casePPrimitiveType(pVerdict);
                if (result == null) result = casePEntityType(pVerdict);
                if (result == null) result = casePType(pVerdict);
                if (result == null) result = casePEncodedElement(pVerdict);
                if (result == null) result = casePNamedElement(pVerdict);
                if (result == null) result = casePModelElement(pVerdict);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDocumentRoot(DocumentRoot object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PAddress</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PAddress</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePAddress(PAddress object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PArgument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PArgument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePArgument(PArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PArgument Group</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PArgument Group</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePArgumentGroup(PArgumentGroup object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PBitstring</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PBitstring</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePBitstring(PBitstring object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PBoolean</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PBoolean</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePBoolean(PBoolean object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PBoolean Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PBoolean Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePBooleanArgument(PBooleanArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCharstring</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCharstring</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCharstring(PCharstring object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCharstring Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCharstring Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCharstringArgument(PCharstringArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCompound Constraint</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCompound Constraint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCompoundConstraint(PCompoundConstraint object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCondition Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCondition Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePConditionArgument(PConditionArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PConstant</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PConstant</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePConstant(PConstant object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PContainer Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PContainer Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePContainerType(PContainerType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PEncoded Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PEncoded Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePEncodedElement(PEncodedElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PEncoding Variant</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PEncoding Variant</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePEncodingVariant(PEncodingVariant object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PEntity Constant</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PEntity Constant</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePEntityConstant(PEntityConstant object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PEntity Enum Set</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PEntity Enum Set</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePEntityEnumSet(PEntityEnumSet object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PEntity Module Par</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PEntity Module Par</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePEntityModulePar(PEntityModulePar object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PEntity Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PEntity Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePEntityType(PEntityType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PEnumerated</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PEnumerated</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePEnumerated(PEnumerated object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PEnumerated Item</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PEnumerated Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePEnumeratedItem(PEnumeratedItem object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PEnum Item</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PEnum Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePEnumItem(PEnumItem object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PEnum Set</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PEnum Set</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePEnumSet(PEnumSet object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PField</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PField</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePField(PField object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PField EV</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PField EV</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePFieldEV(PFieldEV object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PFloat</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PFloat</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePFloat(PFloat object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PFpb Field EV</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PFpb Field EV</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePFpbFieldEV(PFpbFieldEV object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PFpb List Item EV</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PFpb List Item EV</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePFpbListItemEV(PFpbListItemEV object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PFpb Module EV</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PFpb Module EV</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePFpbModuleEV(PFpbModuleEV object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PFpb Type EV</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PFpb Type EV</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePFpbTypeEV(PFpbTypeEV object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PHexstring</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PHexstring</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePHexstring(PHexstring object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PIdentifier Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PIdentifier Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePIdentifierArgument(PIdentifierArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PImport Constant</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PImport Constant</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePImportConstant(PImportConstant object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PImport Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PImport Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePImportElement(PImportElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PImport Enum Set</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PImport Enum Set</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePImportEnumSet(PImportEnumSet object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PImport Module Par</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PImport Module Par</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePImportModulePar(PImportModulePar object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PImport Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PImport Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePImportType(PImportType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PInteger</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PInteger</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePInteger(PInteger object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PInteger Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PInteger Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePIntegerArgument(PIntegerArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PItem Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PItem Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePItemField(PItemField object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PLength Constraint</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PLength Constraint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePLengthConstraint(PLengthConstraint object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PList Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PList Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePListArgument(PListArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PList Constraint</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PList Constraint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePListConstraint(PListConstraint object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PList Item</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PList Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePListItem(PListItem object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PList Item EV</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PList Item EV</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePListItemEV(PListItemEV object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PList Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PList Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePListType(PListType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PModel Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PModel Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePModelElement(PModelElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PModule</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PModule</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePModule(PModule object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PModule EV</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PModule EV</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePModuleEV(PModuleEV object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PModule Par</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PModule Par</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePModulePar(PModulePar object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PNamed Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PNamed Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePNamedElement(PNamedElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PObjid</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PObjid</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePObjid(PObjid object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>POctetstring</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>POctetstring</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePOctetstring(POctetstring object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PPattern Constraint</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PPattern Constraint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePPatternConstraint(PPatternConstraint object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PPrimitive Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PPrimitive Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePPrimitiveType(PPrimitiveType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PProperty</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PProperty</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePProperty(PProperty object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PProperty List</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PProperty List</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePPropertyList(PPropertyList object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PRecord</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PRecord</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePRecord(PRecord object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PRecord Of</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PRecord Of</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePRecordOf(PRecordOf object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PSet</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PSet</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePSet(PSet object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PSet Of</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PSet Of</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePSetOf(PSetOf object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PSingle Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PSingle Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePSingleArgument(PSingleArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PString Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PString Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePStringType(PStringType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PSub Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PSub Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePSubType(PSubType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PType</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PType</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePType(PType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PType Constraint</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PType Constraint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePTypeConstraint(PTypeConstraint object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PTyped Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PTyped Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePTypedElement(PTypedElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PType EV</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PType EV</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePTypeEV(PTypeEV object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PType Reference Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PType Reference Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePTypeReferenceArgument(PTypeReferenceArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PUnion</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PUnion</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePUnion(PUnion object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PUniversal Charstring</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PUniversal Charstring</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePUniversalCharstring(PUniversalCharstring object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PValue Reference Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PValue Reference Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePValueReferenceArgument(PValueReferenceArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PVerdict</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PVerdict</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePVerdict(PVerdict object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
	public T defaultCase(EObject object) {
        return null;
    }

} //FpbmoduleSwitch
