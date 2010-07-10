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

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage
 * @generated
 */
public class FpbmoduleAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static FpbmodulePackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FpbmoduleAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = FpbmodulePackage.eINSTANCE;
        }
    }

	/**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
	@Override
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

	/**
     * The switch the delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FpbmoduleSwitch<Adapter> modelSwitch =
		new FpbmoduleSwitch<Adapter>() {
            @Override
            public Adapter caseDocumentRoot(DocumentRoot object) {
                return createDocumentRootAdapter();
            }
            @Override
            public Adapter casePAddress(PAddress object) {
                return createPAddressAdapter();
            }
            @Override
            public Adapter casePArgument(PArgument object) {
                return createPArgumentAdapter();
            }
            @Override
            public Adapter casePArgumentGroup(PArgumentGroup object) {
                return createPArgumentGroupAdapter();
            }
            @Override
            public Adapter casePBitstring(PBitstring object) {
                return createPBitstringAdapter();
            }
            @Override
            public Adapter casePBoolean(PBoolean object) {
                return createPBooleanAdapter();
            }
            @Override
            public Adapter casePBooleanArgument(PBooleanArgument object) {
                return createPBooleanArgumentAdapter();
            }
            @Override
            public Adapter casePCharstring(PCharstring object) {
                return createPCharstringAdapter();
            }
            @Override
            public Adapter casePCharstringArgument(PCharstringArgument object) {
                return createPCharstringArgumentAdapter();
            }
            @Override
            public Adapter casePCompoundConstraint(PCompoundConstraint object) {
                return createPCompoundConstraintAdapter();
            }
            @Override
            public Adapter casePConditionArgument(PConditionArgument object) {
                return createPConditionArgumentAdapter();
            }
            @Override
            public Adapter casePConstant(PConstant object) {
                return createPConstantAdapter();
            }
            @Override
            public Adapter casePContainerType(PContainerType object) {
                return createPContainerTypeAdapter();
            }
            @Override
            public Adapter casePEncodedElement(PEncodedElement object) {
                return createPEncodedElementAdapter();
            }
            @Override
            public Adapter casePEncodingVariant(PEncodingVariant object) {
                return createPEncodingVariantAdapter();
            }
            @Override
            public Adapter casePEntityConstant(PEntityConstant object) {
                return createPEntityConstantAdapter();
            }
            @Override
            public Adapter casePEntityEnumSet(PEntityEnumSet object) {
                return createPEntityEnumSetAdapter();
            }
            @Override
            public Adapter casePEntityModulePar(PEntityModulePar object) {
                return createPEntityModuleParAdapter();
            }
            @Override
            public Adapter casePEntityType(PEntityType object) {
                return createPEntityTypeAdapter();
            }
            @Override
            public Adapter casePEnumerated(PEnumerated object) {
                return createPEnumeratedAdapter();
            }
            @Override
            public Adapter casePEnumeratedItem(PEnumeratedItem object) {
                return createPEnumeratedItemAdapter();
            }
            @Override
            public Adapter casePEnumItem(PEnumItem object) {
                return createPEnumItemAdapter();
            }
            @Override
            public Adapter casePEnumSet(PEnumSet object) {
                return createPEnumSetAdapter();
            }
            @Override
            public Adapter casePField(PField object) {
                return createPFieldAdapter();
            }
            @Override
            public Adapter casePFieldEV(PFieldEV object) {
                return createPFieldEVAdapter();
            }
            @Override
            public Adapter casePFloat(PFloat object) {
                return createPFloatAdapter();
            }
            @Override
            public Adapter casePFpbFieldEV(PFpbFieldEV object) {
                return createPFpbFieldEVAdapter();
            }
            @Override
            public Adapter casePFpbListItemEV(PFpbListItemEV object) {
                return createPFpbListItemEVAdapter();
            }
            @Override
            public Adapter casePFpbModuleEV(PFpbModuleEV object) {
                return createPFpbModuleEVAdapter();
            }
            @Override
            public Adapter casePFpbTypeEV(PFpbTypeEV object) {
                return createPFpbTypeEVAdapter();
            }
            @Override
            public Adapter casePHexstring(PHexstring object) {
                return createPHexstringAdapter();
            }
            @Override
            public Adapter casePIdentifierArgument(PIdentifierArgument object) {
                return createPIdentifierArgumentAdapter();
            }
            @Override
            public Adapter casePImportConstant(PImportConstant object) {
                return createPImportConstantAdapter();
            }
            @Override
            public Adapter casePImportElement(PImportElement object) {
                return createPImportElementAdapter();
            }
            @Override
            public Adapter casePImportEnumSet(PImportEnumSet object) {
                return createPImportEnumSetAdapter();
            }
            @Override
            public Adapter casePImportModulePar(PImportModulePar object) {
                return createPImportModuleParAdapter();
            }
            @Override
            public Adapter casePImportType(PImportType object) {
                return createPImportTypeAdapter();
            }
            @Override
            public Adapter casePInteger(PInteger object) {
                return createPIntegerAdapter();
            }
            @Override
            public Adapter casePIntegerArgument(PIntegerArgument object) {
                return createPIntegerArgumentAdapter();
            }
            @Override
            public Adapter casePItemField(PItemField object) {
                return createPItemFieldAdapter();
            }
            @Override
            public Adapter casePLengthConstraint(PLengthConstraint object) {
                return createPLengthConstraintAdapter();
            }
            @Override
            public Adapter casePListArgument(PListArgument object) {
                return createPListArgumentAdapter();
            }
            @Override
            public Adapter casePListConstraint(PListConstraint object) {
                return createPListConstraintAdapter();
            }
            @Override
            public Adapter casePListItem(PListItem object) {
                return createPListItemAdapter();
            }
            @Override
            public Adapter casePListItemEV(PListItemEV object) {
                return createPListItemEVAdapter();
            }
            @Override
            public Adapter casePListType(PListType object) {
                return createPListTypeAdapter();
            }
            @Override
            public Adapter casePModule(PModule object) {
                return createPModuleAdapter();
            }
            @Override
            public Adapter casePModuleEV(PModuleEV object) {
                return createPModuleEVAdapter();
            }
            @Override
            public Adapter casePModulePar(PModulePar object) {
                return createPModuleParAdapter();
            }
            @Override
            public Adapter casePObjid(PObjid object) {
                return createPObjidAdapter();
            }
            @Override
            public Adapter casePOctetstring(POctetstring object) {
                return createPOctetstringAdapter();
            }
            @Override
            public Adapter casePPatternConstraint(PPatternConstraint object) {
                return createPPatternConstraintAdapter();
            }
            @Override
            public Adapter casePPrimitiveType(PPrimitiveType object) {
                return createPPrimitiveTypeAdapter();
            }
            @Override
            public Adapter casePProperty(PProperty object) {
                return createPPropertyAdapter();
            }
            @Override
            public Adapter casePPropertyList(PPropertyList object) {
                return createPPropertyListAdapter();
            }
            @Override
            public Adapter casePRecord(PRecord object) {
                return createPRecordAdapter();
            }
            @Override
            public Adapter casePRecordOf(PRecordOf object) {
                return createPRecordOfAdapter();
            }
            @Override
            public Adapter casePSet(PSet object) {
                return createPSetAdapter();
            }
            @Override
            public Adapter casePSetOf(PSetOf object) {
                return createPSetOfAdapter();
            }
            @Override
            public Adapter casePSingleArgument(PSingleArgument object) {
                return createPSingleArgumentAdapter();
            }
            @Override
            public Adapter casePStringType(PStringType object) {
                return createPStringTypeAdapter();
            }
            @Override
            public Adapter casePSubType(PSubType object) {
                return createPSubTypeAdapter();
            }
            @Override
            public Adapter casePType(PType object) {
                return createPTypeAdapter();
            }
            @Override
            public Adapter casePTypeConstraint(PTypeConstraint object) {
                return createPTypeConstraintAdapter();
            }
            @Override
            public Adapter casePTypedElement(PTypedElement object) {
                return createPTypedElementAdapter();
            }
            @Override
            public Adapter casePTypeEV(PTypeEV object) {
                return createPTypeEVAdapter();
            }
            @Override
            public Adapter casePTypeReferenceArgument(PTypeReferenceArgument object) {
                return createPTypeReferenceArgumentAdapter();
            }
            @Override
            public Adapter casePUnion(PUnion object) {
                return createPUnionAdapter();
            }
            @Override
            public Adapter casePUniversalCharstring(PUniversalCharstring object) {
                return createPUniversalCharstringAdapter();
            }
            @Override
            public Adapter casePValueReferenceArgument(PValueReferenceArgument object) {
                return createPValueReferenceArgumentAdapter();
            }
            @Override
            public Adapter casePVerdict(PVerdict object) {
                return createPVerdictAdapter();
            }
            @Override
            public Adapter casePModelElement(PModelElement object) {
                return createPModelElementAdapter();
            }
            @Override
            public Adapter casePNamedElement(PNamedElement object) {
                return createPNamedElementAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

	/**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
	@Override
	public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot
     * @generated
     */
	public Adapter createDocumentRootAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PAddress <em>PAddress</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PAddress
     * @generated
     */
	public Adapter createPAddressAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PArgument <em>PArgument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PArgument
     * @generated
     */
	public Adapter createPArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PArgumentGroup <em>PArgument Group</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PArgumentGroup
     * @generated
     */
	public Adapter createPArgumentGroupAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PBitstring <em>PBitstring</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PBitstring
     * @generated
     */
	public Adapter createPBitstringAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PBoolean <em>PBoolean</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PBoolean
     * @generated
     */
	public Adapter createPBooleanAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PBooleanArgument <em>PBoolean Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PBooleanArgument
     * @generated
     */
	public Adapter createPBooleanArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PCharstring <em>PCharstring</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PCharstring
     * @generated
     */
	public Adapter createPCharstringAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PCharstringArgument <em>PCharstring Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PCharstringArgument
     * @generated
     */
	public Adapter createPCharstringArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PCompoundConstraint <em>PCompound Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PCompoundConstraint
     * @generated
     */
	public Adapter createPCompoundConstraintAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument <em>PCondition Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument
     * @generated
     */
	public Adapter createPConditionArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PConstant <em>PConstant</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PConstant
     * @generated
     */
	public Adapter createPConstantAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PContainerType <em>PContainer Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PContainerType
     * @generated
     */
	public Adapter createPContainerTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement <em>PEncoded Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEncodedElement
     * @generated
     */
	public Adapter createPEncodedElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant <em>PEncoding Variant</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEncodingVariant
     * @generated
     */
	public Adapter createPEncodingVariantAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant <em>PEntity Constant</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant
     * @generated
     */
	public Adapter createPEntityConstantAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet <em>PEntity Enum Set</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet
     * @generated
     */
	public Adapter createPEntityEnumSetAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar <em>PEntity Module Par</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar
     * @generated
     */
	public Adapter createPEntityModuleParAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEntityType <em>PEntity Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEntityType
     * @generated
     */
	public Adapter createPEntityTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumerated <em>PEnumerated</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumerated
     * @generated
     */
	public Adapter createPEnumeratedAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem <em>PEnumerated Item</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem
     * @generated
     */
	public Adapter createPEnumeratedItemAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumItem <em>PEnum Item</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumItem
     * @generated
     */
	public Adapter createPEnumItemAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PEnumSet <em>PEnum Set</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PEnumSet
     * @generated
     */
	public Adapter createPEnumSetAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PField <em>PField</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PField
     * @generated
     */
	public Adapter createPFieldAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PFieldEV <em>PField EV</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFieldEV
     * @generated
     */
	public Adapter createPFieldEVAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PFloat <em>PFloat</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFloat
     * @generated
     */
	public Adapter createPFloatAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PFpbFieldEV <em>PFpb Field EV</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFpbFieldEV
     * @generated
     */
	public Adapter createPFpbFieldEVAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PFpbListItemEV <em>PFpb List Item EV</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFpbListItemEV
     * @generated
     */
	public Adapter createPFpbListItemEVAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PFpbModuleEV <em>PFpb Module EV</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFpbModuleEV
     * @generated
     */
	public Adapter createPFpbModuleEVAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV <em>PFpb Type EV</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV
     * @generated
     */
	public Adapter createPFpbTypeEVAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PHexstring <em>PHexstring</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PHexstring
     * @generated
     */
	public Adapter createPHexstringAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PIdentifierArgument <em>PIdentifier Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PIdentifierArgument
     * @generated
     */
	public Adapter createPIdentifierArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportConstant <em>PImport Constant</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportConstant
     * @generated
     */
	public Adapter createPImportConstantAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportElement <em>PImport Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportElement
     * @generated
     */
	public Adapter createPImportElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet <em>PImport Enum Set</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet
     * @generated
     */
	public Adapter createPImportEnumSetAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar <em>PImport Module Par</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar
     * @generated
     */
	public Adapter createPImportModuleParAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PImportType <em>PImport Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PImportType
     * @generated
     */
	public Adapter createPImportTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PInteger <em>PInteger</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PInteger
     * @generated
     */
	public Adapter createPIntegerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PIntegerArgument <em>PInteger Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PIntegerArgument
     * @generated
     */
	public Adapter createPIntegerArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PItemField <em>PItem Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PItemField
     * @generated
     */
    public Adapter createPItemFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint <em>PLength Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint
     * @generated
     */
	public Adapter createPLengthConstraintAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PListArgument <em>PList Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListArgument
     * @generated
     */
	public Adapter createPListArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PListConstraint <em>PList Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListConstraint
     * @generated
     */
	public Adapter createPListConstraintAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PListItem <em>PList Item</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListItem
     * @generated
     */
	public Adapter createPListItemAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PListItemEV <em>PList Item EV</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListItemEV
     * @generated
     */
	public Adapter createPListItemEVAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PListType <em>PList Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PListType
     * @generated
     */
	public Adapter createPListTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbcommon.PModelElement <em>PModel Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbcommon.PModelElement
     * @generated
     */
	public Adapter createPModelElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PModule <em>PModule</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModule
     * @generated
     */
	public Adapter createPModuleAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PModuleEV <em>PModule EV</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModuleEV
     * @generated
     */
	public Adapter createPModuleEVAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PModulePar <em>PModule Par</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PModulePar
     * @generated
     */
	public Adapter createPModuleParAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbcommon.PNamedElement <em>PNamed Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbcommon.PNamedElement
     * @generated
     */
	public Adapter createPNamedElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PObjid <em>PObjid</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PObjid
     * @generated
     */
	public Adapter createPObjidAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.POctetstring <em>POctetstring</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.POctetstring
     * @generated
     */
	public Adapter createPOctetstringAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint <em>PPattern Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint
     * @generated
     */
	public Adapter createPPatternConstraintAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PPrimitiveType <em>PPrimitive Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PPrimitiveType
     * @generated
     */
	public Adapter createPPrimitiveTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PProperty <em>PProperty</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PProperty
     * @generated
     */
	public Adapter createPPropertyAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PPropertyList <em>PProperty List</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PPropertyList
     * @generated
     */
	public Adapter createPPropertyListAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PRecord <em>PRecord</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PRecord
     * @generated
     */
	public Adapter createPRecordAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PRecordOf <em>PRecord Of</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PRecordOf
     * @generated
     */
	public Adapter createPRecordOfAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PSet <em>PSet</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PSet
     * @generated
     */
	public Adapter createPSetAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PSetOf <em>PSet Of</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PSetOf
     * @generated
     */
	public Adapter createPSetOfAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PSingleArgument <em>PSingle Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PSingleArgument
     * @generated
     */
	public Adapter createPSingleArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PStringType <em>PString Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PStringType
     * @generated
     */
	public Adapter createPStringTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PSubType <em>PSub Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PSubType
     * @generated
     */
	public Adapter createPSubTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PType <em>PType</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PType
     * @generated
     */
	public Adapter createPTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint <em>PType Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint
     * @generated
     */
	public Adapter createPTypeConstraintAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypedElement <em>PTyped Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PTypedElement
     * @generated
     */
	public Adapter createPTypedElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypeEV <em>PType EV</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PTypeEV
     * @generated
     */
	public Adapter createPTypeEVAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PTypeReferenceArgument <em>PType Reference Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PTypeReferenceArgument
     * @generated
     */
	public Adapter createPTypeReferenceArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PUnion <em>PUnion</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PUnion
     * @generated
     */
	public Adapter createPUnionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PUniversalCharstring <em>PUniversal Charstring</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PUniversalCharstring
     * @generated
     */
	public Adapter createPUniversalCharstringAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument <em>PValue Reference Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument
     * @generated
     */
	public Adapter createPValueReferenceArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.fineqt.fpb.lib.model.fpbmodule.PVerdict <em>PVerdict</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.fineqt.fpb.lib.model.fpbmodule.PVerdict
     * @generated
     */
	public Adapter createPVerdictAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
	public Adapter createEObjectAdapter() {
        return null;
    }

} //FpbmoduleAdapterFactory
