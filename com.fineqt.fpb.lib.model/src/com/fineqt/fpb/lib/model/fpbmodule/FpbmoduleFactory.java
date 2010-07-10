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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage
 * @generated
 */
public interface FpbmoduleFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	FpbmoduleFactory eINSTANCE = com.fineqt.fpb.lib.model.fpbmodule.impl.FpbmoduleFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Document Root</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Document Root</em>'.
     * @generated
     */
	DocumentRoot createDocumentRoot();

	/**
     * Returns a new object of class '<em>PAddress</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PAddress</em>'.
     * @generated
     */
	PAddress createPAddress();

	/**
     * Returns a new object of class '<em>PArgument Group</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PArgument Group</em>'.
     * @generated
     */
	PArgumentGroup createPArgumentGroup();

	/**
     * Returns a new object of class '<em>PBitstring</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PBitstring</em>'.
     * @generated
     */
	PBitstring createPBitstring();

	/**
     * Returns a new object of class '<em>PBoolean</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PBoolean</em>'.
     * @generated
     */
	PBoolean createPBoolean();

	/**
     * Returns a new object of class '<em>PBoolean Argument</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PBoolean Argument</em>'.
     * @generated
     */
	PBooleanArgument createPBooleanArgument();

	/**
     * Returns a new object of class '<em>PCharstring</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PCharstring</em>'.
     * @generated
     */
	PCharstring createPCharstring();

	/**
     * Returns a new object of class '<em>PCharstring Argument</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PCharstring Argument</em>'.
     * @generated
     */
	PCharstringArgument createPCharstringArgument();

	/**
     * Returns a new object of class '<em>PCompound Constraint</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PCompound Constraint</em>'.
     * @generated
     */
	PCompoundConstraint createPCompoundConstraint();

	/**
     * Returns a new object of class '<em>PCondition Argument</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PCondition Argument</em>'.
     * @generated
     */
	PConditionArgument createPConditionArgument();

	/**
     * Returns a new object of class '<em>PEntity Constant</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PEntity Constant</em>'.
     * @generated
     */
	PEntityConstant createPEntityConstant();

	/**
     * Returns a new object of class '<em>PEntity Enum Set</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PEntity Enum Set</em>'.
     * @generated
     */
	PEntityEnumSet createPEntityEnumSet();

	/**
     * Returns a new object of class '<em>PEntity Module Par</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PEntity Module Par</em>'.
     * @generated
     */
	PEntityModulePar createPEntityModulePar();

	/**
     * Returns a new object of class '<em>PEnumerated</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PEnumerated</em>'.
     * @generated
     */
	PEnumerated createPEnumerated();

	/**
     * Returns a new object of class '<em>PEnumerated Item</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PEnumerated Item</em>'.
     * @generated
     */
	PEnumeratedItem createPEnumeratedItem();

	/**
     * Returns a new object of class '<em>PEnum Item</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PEnum Item</em>'.
     * @generated
     */
	PEnumItem createPEnumItem();

	/**
     * Returns a new object of class '<em>PField</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PField</em>'.
     * @generated
     */
	PField createPField();

	/**
     * Returns a new object of class '<em>PField EV</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PField EV</em>'.
     * @generated
     */
	PFieldEV createPFieldEV();

	/**
     * Returns a new object of class '<em>PFloat</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PFloat</em>'.
     * @generated
     */
	PFloat createPFloat();

	/**
     * Returns a new object of class '<em>PFpb Field EV</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PFpb Field EV</em>'.
     * @generated
     */
	PFpbFieldEV createPFpbFieldEV();

	/**
     * Returns a new object of class '<em>PFpb List Item EV</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PFpb List Item EV</em>'.
     * @generated
     */
	PFpbListItemEV createPFpbListItemEV();

	/**
     * Returns a new object of class '<em>PFpb Module EV</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PFpb Module EV</em>'.
     * @generated
     */
	PFpbModuleEV createPFpbModuleEV();

	/**
     * Returns a new object of class '<em>PFpb Type EV</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PFpb Type EV</em>'.
     * @generated
     */
	PFpbTypeEV createPFpbTypeEV();

	/**
     * Returns a new object of class '<em>PHexstring</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PHexstring</em>'.
     * @generated
     */
	PHexstring createPHexstring();

	/**
     * Returns a new object of class '<em>PIdentifier Argument</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PIdentifier Argument</em>'.
     * @generated
     */
	PIdentifierArgument createPIdentifierArgument();

	/**
     * Returns a new object of class '<em>PImport Constant</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PImport Constant</em>'.
     * @generated
     */
	PImportConstant createPImportConstant();

	/**
     * Returns a new object of class '<em>PImport Element</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PImport Element</em>'.
     * @generated
     */
	PImportElement createPImportElement();

	/**
     * Returns a new object of class '<em>PImport Enum Set</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PImport Enum Set</em>'.
     * @generated
     */
	PImportEnumSet createPImportEnumSet();

	/**
     * Returns a new object of class '<em>PImport Module Par</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PImport Module Par</em>'.
     * @generated
     */
	PImportModulePar createPImportModulePar();

	/**
     * Returns a new object of class '<em>PImport Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PImport Type</em>'.
     * @generated
     */
	PImportType createPImportType();

	/**
     * Returns a new object of class '<em>PInteger</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PInteger</em>'.
     * @generated
     */
	PInteger createPInteger();

	/**
     * Returns a new object of class '<em>PInteger Argument</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PInteger Argument</em>'.
     * @generated
     */
	PIntegerArgument createPIntegerArgument();

	/**
     * Returns a new object of class '<em>PItem Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>PItem Field</em>'.
     * @generated
     */
    PItemField createPItemField();

    /**
     * Returns a new object of class '<em>PLength Constraint</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PLength Constraint</em>'.
     * @generated
     */
	PLengthConstraint createPLengthConstraint();

	/**
     * Returns a new object of class '<em>PList Argument</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PList Argument</em>'.
     * @generated
     */
	PListArgument createPListArgument();

	/**
     * Returns a new object of class '<em>PList Constraint</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PList Constraint</em>'.
     * @generated
     */
	PListConstraint createPListConstraint();

	/**
     * Returns a new object of class '<em>PList Item</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PList Item</em>'.
     * @generated
     */
	PListItem createPListItem();

	/**
     * Returns a new object of class '<em>PList Item EV</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PList Item EV</em>'.
     * @generated
     */
	PListItemEV createPListItemEV();

	/**
     * Returns a new object of class '<em>PModule</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PModule</em>'.
     * @generated
     */
	PModule createPModule();

	/**
     * Returns a new object of class '<em>PModule EV</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PModule EV</em>'.
     * @generated
     */
	PModuleEV createPModuleEV();

	/**
     * Returns a new object of class '<em>PObjid</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PObjid</em>'.
     * @generated
     */
	PObjid createPObjid();

	/**
     * Returns a new object of class '<em>POctetstring</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>POctetstring</em>'.
     * @generated
     */
	POctetstring createPOctetstring();

	/**
     * Returns a new object of class '<em>PPattern Constraint</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PPattern Constraint</em>'.
     * @generated
     */
	PPatternConstraint createPPatternConstraint();

	/**
     * Returns a new object of class '<em>PProperty</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PProperty</em>'.
     * @generated
     */
	PProperty createPProperty();

	/**
     * Returns a new object of class '<em>PProperty List</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PProperty List</em>'.
     * @generated
     */
	PPropertyList createPPropertyList();

	/**
     * Returns a new object of class '<em>PRecord</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PRecord</em>'.
     * @generated
     */
	PRecord createPRecord();

	/**
     * Returns a new object of class '<em>PRecord Of</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PRecord Of</em>'.
     * @generated
     */
	PRecordOf createPRecordOf();

	/**
     * Returns a new object of class '<em>PSet</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PSet</em>'.
     * @generated
     */
	PSet createPSet();

	/**
     * Returns a new object of class '<em>PSet Of</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PSet Of</em>'.
     * @generated
     */
	PSetOf createPSetOf();

	/**
     * Returns a new object of class '<em>PSub Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PSub Type</em>'.
     * @generated
     */
	PSubType createPSubType();

	/**
     * Returns a new object of class '<em>PType Constraint</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PType Constraint</em>'.
     * @generated
     */
	PTypeConstraint createPTypeConstraint();

	/**
     * Returns a new object of class '<em>PType EV</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PType EV</em>'.
     * @generated
     */
	PTypeEV createPTypeEV();

	/**
     * Returns a new object of class '<em>PType Reference Argument</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PType Reference Argument</em>'.
     * @generated
     */
	PTypeReferenceArgument createPTypeReferenceArgument();

	/**
     * Returns a new object of class '<em>PUnion</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PUnion</em>'.
     * @generated
     */
	PUnion createPUnion();

	/**
     * Returns a new object of class '<em>PUniversal Charstring</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PUniversal Charstring</em>'.
     * @generated
     */
	PUniversalCharstring createPUniversalCharstring();

	/**
     * Returns a new object of class '<em>PValue Reference Argument</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PValue Reference Argument</em>'.
     * @generated
     */
	PValueReferenceArgument createPValueReferenceArgument();

	/**
     * Returns a new object of class '<em>PVerdict</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>PVerdict</em>'.
     * @generated
     */
	PVerdict createPVerdict();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	FpbmodulePackage getFpbmodulePackage();

} //FpbmoduleFactory
