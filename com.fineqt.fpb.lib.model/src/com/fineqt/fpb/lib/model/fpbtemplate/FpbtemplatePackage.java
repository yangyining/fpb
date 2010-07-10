/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate;

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
 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplateFactory
 * @model kind="package"
 * @generated
 */
public interface FpbtemplatePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fpbtemplate";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fpbtemplate.model.lib.fpb.fineqt.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fpbtemplate";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FpbtemplatePackage eINSTANCE = com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl.init();

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PMatcherImpl <em>PMatcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPMatcher()
	 * @generated
	 */
	int PMATCHER = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PMATCHER__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PMATCHER__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
	 * The number of structural features of the '<em>PMatcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PMATCHER_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateMatcherImpl <em>PTemplate Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPTemplateMatcher()
	 * @generated
	 */
	int PTEMPLATE_MATCHER = 25;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_MATCHER__ANNOTATIONS = PMATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_MATCHER__ATTATCHMENT = PMATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_MATCHER__IF_PRESENT = PMATCHER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_MATCHER__LENGTH_RESTRICTION = PMATCHER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PTemplate Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_MATCHER_FEATURE_COUNT = PMATCHER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PSimpleMatcherImpl <em>PSimple Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PSimpleMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPSimpleMatcher()
	 * @generated
	 */
	int PSIMPLE_MATCHER = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSIMPLE_MATCHER__ANNOTATIONS = PTEMPLATE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSIMPLE_MATCHER__ATTATCHMENT = PTEMPLATE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSIMPLE_MATCHER__IF_PRESENT = PTEMPLATE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSIMPLE_MATCHER__LENGTH_RESTRICTION = PTEMPLATE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The number of structural features of the '<em>PSimple Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSIMPLE_MATCHER_FEATURE_COUNT = PTEMPLATE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PAnyMatcherImpl <em>PAny Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PAnyMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPAnyMatcher()
	 * @generated
	 */
	int PANY_MATCHER = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANY_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANY_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANY_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANY_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The number of structural features of the '<em>PAny Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANY_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PAnyOrOmitMatcherImpl <em>PAny Or Omit Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PAnyOrOmitMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPAnyOrOmitMatcher()
	 * @generated
	 */
	int PANY_OR_OMIT_MATCHER = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANY_OR_OMIT_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANY_OR_OMIT_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANY_OR_OMIT_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANY_OR_OMIT_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The number of structural features of the '<em>PAny Or Omit Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANY_OR_OMIT_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PBitstringMatcherImpl <em>PBitstring Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PBitstringMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPBitstringMatcher()
	 * @generated
	 */
	int PBITSTRING_MATCHER = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PBITSTRING_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PBITSTRING_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PBITSTRING_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PBITSTRING_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PBITSTRING_MATCHER__DESC = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PBitstring Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PBITSTRING_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PCharstringMatcherImpl <em>PCharstring Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PCharstringMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPCharstringMatcher()
	 * @generated
	 */
	int PCHARSTRING_MATCHER = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCHARSTRING_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCHARSTRING_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCHARSTRING_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCHARSTRING_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCHARSTRING_MATCHER__DESC = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PCharstring Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCHARSTRING_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PComplementListMatcherImpl <em>PComplement List Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PComplementListMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPComplementListMatcher()
	 * @generated
	 */
	int PCOMPLEMENT_LIST_MATCHER = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCOMPLEMENT_LIST_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCOMPLEMENT_LIST_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCOMPLEMENT_LIST_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCOMPLEMENT_LIST_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCOMPLEMENT_LIST_MATCHER__ITEMS = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PComplement List Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCOMPLEMENT_LIST_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PContainerFieldMatcherImpl <em>PContainer Field Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PContainerFieldMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPContainerFieldMatcher()
	 * @generated
	 */
	int PCONTAINER_FIELD_MATCHER = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTAINER_FIELD_MATCHER__ANNOTATIONS = PTEMPLATE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTAINER_FIELD_MATCHER__ATTATCHMENT = PTEMPLATE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTAINER_FIELD_MATCHER__IF_PRESENT = PTEMPLATE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTAINER_FIELD_MATCHER__LENGTH_RESTRICTION = PTEMPLATE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTAINER_FIELD_MATCHER__ITEMS = PTEMPLATE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PContainer Field Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTAINER_FIELD_MATCHER_FEATURE_COUNT = PTEMPLATE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PContainerFieldMatcherItemImpl <em>PContainer Field Matcher Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PContainerFieldMatcherItemImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPContainerFieldMatcherItem()
	 * @generated
	 */
	int PCONTAINER_FIELD_MATCHER_ITEM = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTAINER_FIELD_MATCHER_ITEM__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTAINER_FIELD_MATCHER_ITEM__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTAINER_FIELD_MATCHER_ITEM__MATCHER = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTAINER_FIELD_MATCHER_ITEM__FIELD_NAME = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PContainer Field Matcher Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCONTAINER_FIELD_MATCHER_ITEM_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PEntityTemplateImpl <em>PEntity Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PEntityTemplateImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPEntityTemplate()
	 * @generated
	 */
	int PENTITY_TEMPLATE = 7;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PHexstringMatcherImpl <em>PHexstring Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PHexstringMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPHexstringMatcher()
	 * @generated
	 */
	int PHEXSTRING_MATCHER = 9;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PImportTemplateImpl <em>PImport Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PImportTemplateImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPImportTemplate()
	 * @generated
	 */
	int PIMPORT_TEMPLATE = 10;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PListFieldMatcherImpl <em>PList Field Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PListFieldMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPListFieldMatcher()
	 * @generated
	 */
	int PLIST_FIELD_MATCHER = 11;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PListFieldMatcherItemImpl <em>PList Field Matcher Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PListFieldMatcherItemImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPListFieldMatcherItem()
	 * @generated
	 */
	int PLIST_FIELD_MATCHER_ITEM = 12;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PListValueMatcherImpl <em>PList Value Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PListValueMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPListValueMatcher()
	 * @generated
	 */
	int PLIST_VALUE_MATCHER = 13;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PNotUsedMatcherImpl <em>PNot Used Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PNotUsedMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPNotUsedMatcher()
	 * @generated
	 */
	int PNOT_USED_MATCHER = 15;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.POctetstringMatcherImpl <em>POctetstring Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.POctetstringMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPOctetstringMatcher()
	 * @generated
	 */
	int POCTETSTRING_MATCHER = 16;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.POmitMatcherImpl <em>POmit Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.POmitMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPOmitMatcher()
	 * @generated
	 */
	int POMIT_MATCHER = 17;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PPrimitiveValueMatcherImpl <em>PPrimitive Value Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PPrimitiveValueMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPPrimitiveValueMatcher()
	 * @generated
	 */
	int PPRIMITIVE_VALUE_MATCHER = 18;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PRangeMatcherImpl <em>PRange Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PRangeMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPRangeMatcher()
	 * @generated
	 */
	int PRANGE_MATCHER = 19;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PSubSetMatcherImpl <em>PSub Set Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PSubSetMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPSubSetMatcher()
	 * @generated
	 */
	int PSUB_SET_MATCHER = 22;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PSuperSetMatcherImpl <em>PSuper Set Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PSuperSetMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPSuperSetMatcher()
	 * @generated
	 */
	int PSUPER_SET_MATCHER = 23;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateImpl <em>PTemplate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPTemplate()
	 * @generated
	 */
	int PTEMPLATE = 24;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE__ANNOTATIONS = FpbcommonPackage.PNAMED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE__ATTATCHMENT = FpbcommonPackage.PNAMED_ELEMENT__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE__NAME = FpbcommonPackage.PNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Template ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE__TEMPLATE_ID = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PTemplate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_FEATURE_COUNT = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENTITY_TEMPLATE__ANNOTATIONS = PTEMPLATE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENTITY_TEMPLATE__ATTATCHMENT = PTEMPLATE__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENTITY_TEMPLATE__NAME = PTEMPLATE__NAME;

	/**
	 * The feature id for the '<em><b>Template ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENTITY_TEMPLATE__TEMPLATE_ID = PTEMPLATE__TEMPLATE_ID;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENTITY_TEMPLATE__PARAMETERS = PTEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENTITY_TEMPLATE__MATCHER = PTEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Basetype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENTITY_TEMPLATE__BASETYPE = PTEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>PEntity Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENTITY_TEMPLATE_FEATURE_COUNT = PTEMPLATE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PExpressionMatcherImpl <em>PExpression Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PExpressionMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPExpressionMatcher()
	 * @generated
	 */
	int PEXPRESSION_MATCHER = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEXPRESSION_MATCHER__ANNOTATIONS = PMATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEXPRESSION_MATCHER__ATTATCHMENT = PMATCHER__ATTATCHMENT;

	/**
	 * The number of structural features of the '<em>PExpression Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEXPRESSION_MATCHER_FEATURE_COUNT = PMATCHER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHEXSTRING_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHEXSTRING_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHEXSTRING_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHEXSTRING_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHEXSTRING_MATCHER__DESC = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PHexstring Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHEXSTRING_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIMPORT_TEMPLATE__ANNOTATIONS = PTEMPLATE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIMPORT_TEMPLATE__ATTATCHMENT = PTEMPLATE__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIMPORT_TEMPLATE__NAME = PTEMPLATE__NAME;

	/**
	 * The feature id for the '<em><b>Template ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIMPORT_TEMPLATE__TEMPLATE_ID = PTEMPLATE__TEMPLATE_ID;

	/**
	 * The feature id for the '<em><b>Imported Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIMPORT_TEMPLATE__IMPORTED_MODULE_NAME = PTEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imported Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIMPORT_TEMPLATE__IMPORTED_TEMPLATE = PTEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Imported Template Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIMPORT_TEMPLATE__IMPORTED_TEMPLATE_NAME = PTEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>PImport Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIMPORT_TEMPLATE_FEATURE_COUNT = PTEMPLATE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_FIELD_MATCHER__ANNOTATIONS = PTEMPLATE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_FIELD_MATCHER__ATTATCHMENT = PTEMPLATE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_FIELD_MATCHER__IF_PRESENT = PTEMPLATE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_FIELD_MATCHER__LENGTH_RESTRICTION = PTEMPLATE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_FIELD_MATCHER__ITEMS = PTEMPLATE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PList Field Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_FIELD_MATCHER_FEATURE_COUNT = PTEMPLATE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_FIELD_MATCHER_ITEM__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_FIELD_MATCHER_ITEM__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_FIELD_MATCHER_ITEM__MATCHER = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_FIELD_MATCHER_ITEM__INDEX_MATCHER = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_FIELD_MATCHER_ITEM__INDEX = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>PList Field Matcher Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_FIELD_MATCHER_ITEM_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_VALUE_MATCHER__ANNOTATIONS = PTEMPLATE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_VALUE_MATCHER__ATTATCHMENT = PTEMPLATE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_VALUE_MATCHER__IF_PRESENT = PTEMPLATE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_VALUE_MATCHER__LENGTH_RESTRICTION = PTEMPLATE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_VALUE_MATCHER__ITEMS = PTEMPLATE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PList Value Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLIST_VALUE_MATCHER_FEATURE_COUNT = PTEMPLATE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PNOT_USED_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PNOT_USED_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PNOT_USED_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PNOT_USED_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The number of structural features of the '<em>PNot Used Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PNOT_USED_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POCTETSTRING_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POCTETSTRING_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POCTETSTRING_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POCTETSTRING_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POCTETSTRING_MATCHER__DESC = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>POctetstring Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POCTETSTRING_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POMIT_MATCHER__ANNOTATIONS = PEXPRESSION_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POMIT_MATCHER__ATTATCHMENT = PEXPRESSION_MATCHER__ATTATCHMENT;

	/**
	 * The number of structural features of the '<em>POmit Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POMIT_MATCHER_FEATURE_COUNT = PEXPRESSION_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PPRIMITIVE_VALUE_MATCHER__ANNOTATIONS = PEXPRESSION_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PPRIMITIVE_VALUE_MATCHER__ATTATCHMENT = PEXPRESSION_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Value Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PPRIMITIVE_VALUE_MATCHER__VALUE_DESC = PEXPRESSION_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PPrimitive Value Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PPRIMITIVE_VALUE_MATCHER_FEATURE_COUNT = PEXPRESSION_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRANGE_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRANGE_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRANGE_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRANGE_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRANGE_MATCHER__LOWER_BOUND = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRANGE_MATCHER__UPPER_BOUND = PSIMPLE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PRange Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRANGE_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PSingleExpressionMatcherImpl <em>PSingle Expression Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PSingleExpressionMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPSingleExpressionMatcher()
	 * @generated
	 */
	int PSINGLE_EXPRESSION_MATCHER = 21;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSINGLE_EXPRESSION_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSINGLE_EXPRESSION_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSINGLE_EXPRESSION_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSINGLE_EXPRESSION_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSINGLE_EXPRESSION_MATCHER__EXPRESSION = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PSingle Expression Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSINGLE_EXPRESSION_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSUB_SET_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSUB_SET_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSUB_SET_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSUB_SET_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSUB_SET_MATCHER__ITEMS = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PSub Set Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSUB_SET_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSUPER_SET_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSUPER_SET_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSUPER_SET_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSUPER_SET_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSUPER_SET_MATCHER__ITEMS = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PSuper Set Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSUPER_SET_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateParImpl <em>PTemplate Par</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateParImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPTemplatePar()
	 * @generated
	 */
	int PTEMPLATE_PAR = 26;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_PAR__ANNOTATIONS = FpbcommonPackage.PNAMED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_PAR__ATTATCHMENT = FpbcommonPackage.PNAMED_ELEMENT__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_PAR__NAME = FpbcommonPackage.PNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Basetype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_PAR__BASETYPE = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_PAR__TEMPLATE = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PTemplate Par</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_PAR_FEATURE_COUNT = FpbcommonPackage.PNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateRefMatcherImpl <em>PTemplate Ref Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateRefMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPTemplateRefMatcher()
	 * @generated
	 */
	int PTEMPLATE_REF_MATCHER = 27;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_REF_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_REF_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_REF_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_REF_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_REF_MATCHER__PARAMETERS = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>External Template Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_REF_MATCHER__EXTERNAL_TEMPLATE_NAME = PSIMPLE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PTemplate Ref Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_REF_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateRefMatcherParImpl <em>PTemplate Ref Matcher Par</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateRefMatcherParImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPTemplateRefMatcherPar()
	 * @generated
	 */
	int PTEMPLATE_REF_MATCHER_PAR = 28;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_REF_MATCHER_PAR__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_REF_MATCHER_PAR__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_REF_MATCHER_PAR__MATCHER = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PTemplate Ref Matcher Par</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTEMPLATE_REF_MATCHER_PAR_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PUnaryExpressionImpl <em>PUnary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PUnaryExpressionImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPUnaryExpression()
	 * @generated
	 */
	int PUNARY_EXPRESSION = 29;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUNARY_EXPRESSION__ANNOTATIONS = PEXPRESSION_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUNARY_EXPRESSION__ATTATCHMENT = PEXPRESSION_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Primary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUNARY_EXPRESSION__PRIMARY = PEXPRESSION_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUNARY_EXPRESSION__OPERATOR = PEXPRESSION_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PUnary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUNARY_EXPRESSION_FEATURE_COUNT = PEXPRESSION_MATCHER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueListMatcherImpl <em>PValue List Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueListMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPValueListMatcher()
	 * @generated
	 */
	int PVALUE_LIST_MATCHER = 30;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_LIST_MATCHER__ANNOTATIONS = PSIMPLE_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_LIST_MATCHER__ATTATCHMENT = PSIMPLE_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>If Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_LIST_MATCHER__IF_PRESENT = PSIMPLE_MATCHER__IF_PRESENT;

	/**
	 * The feature id for the '<em><b>Length Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_LIST_MATCHER__LENGTH_RESTRICTION = PSIMPLE_MATCHER__LENGTH_RESTRICTION;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_LIST_MATCHER__ITEMS = PSIMPLE_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PValue List Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_LIST_MATCHER_FEATURE_COUNT = PSIMPLE_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceFragmentImpl <em>PValue Reference Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceFragmentImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPValueReferenceFragment()
	 * @generated
	 */
	int PVALUE_REFERENCE_FRAGMENT = 31;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_REFERENCE_FRAGMENT__ANNOTATIONS = FpbcommonPackage.PMODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_REFERENCE_FRAGMENT__ATTATCHMENT = FpbcommonPackage.PMODEL_ELEMENT__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_REFERENCE_FRAGMENT__FIELD_NAME = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_REFERENCE_FRAGMENT__INDEX_MATCHER = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>PValue Reference Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_REFERENCE_FRAGMENT_FEATURE_COUNT = FpbcommonPackage.PMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceMatcherImpl <em>PValue Reference Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceMatcherImpl
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPValueReferenceMatcher()
	 * @generated
	 */
	int PVALUE_REFERENCE_MATCHER = 32;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_REFERENCE_MATCHER__ANNOTATIONS = PEXPRESSION_MATCHER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attatchment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_REFERENCE_MATCHER__ATTATCHMENT = PEXPRESSION_MATCHER__ATTATCHMENT;

	/**
	 * The feature id for the '<em><b>Fragments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_REFERENCE_MATCHER__FRAGMENTS = PEXPRESSION_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_REFERENCE_MATCHER__REF_NAME = PEXPRESSION_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_REFERENCE_MATCHER__REF_TYPE = PEXPRESSION_MATCHER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>PValue Reference Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVALUE_REFERENCE_MATCHER_FEATURE_COUNT = PEXPRESSION_MATCHER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType <em>Value Reference Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getValueReferenceType()
	 * @generated
	 */
	int VALUE_REFERENCE_TYPE = 33;

	/**
	 * The meta object id for the '<em>Value Reference Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getValueReferenceTypeObject()
	 * @generated
	 */
	int VALUE_REFERENCE_TYPE_OBJECT = 34;

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PAnyMatcher <em>PAny Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PAny Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PAnyMatcher
	 * @generated
	 */
	EClass getPAnyMatcher();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PAnyOrOmitMatcher <em>PAny Or Omit Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PAny Or Omit Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PAnyOrOmitMatcher
	 * @generated
	 */
	EClass getPAnyOrOmitMatcher();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PBitstringMatcher <em>PBitstring Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PBitstring Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PBitstringMatcher
	 * @generated
	 */
	EClass getPBitstringMatcher();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PBitstringMatcher#getDesc <em>Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PBitstringMatcher#getDesc()
	 * @see #getPBitstringMatcher()
	 * @generated
	 */
	EAttribute getPBitstringMatcher_Desc();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher <em>PCharstring Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCharstring Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher
	 * @generated
	 */
	EClass getPCharstringMatcher();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher#getDesc <em>Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher#getDesc()
	 * @see #getPCharstringMatcher()
	 * @generated
	 */
	EAttribute getPCharstringMatcher_Desc();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PComplementListMatcher <em>PComplement List Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PComplement List Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PComplementListMatcher
	 * @generated
	 */
	EClass getPComplementListMatcher();

	/**
	 * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbtemplate.PComplementListMatcher#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PComplementListMatcher#getItems()
	 * @see #getPComplementListMatcher()
	 * @generated
	 */
	EReference getPComplementListMatcher_Items();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcher <em>PContainer Field Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PContainer Field Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcher
	 * @generated
	 */
	EClass getPContainerFieldMatcher();

	/**
	 * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcher#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcher#getItems()
	 * @see #getPContainerFieldMatcher()
	 * @generated
	 */
	EReference getPContainerFieldMatcher_Items();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem <em>PContainer Field Matcher Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PContainer Field Matcher Item</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem
	 * @generated
	 */
	EClass getPContainerFieldMatcherItem();

	/**
	 * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem#getMatcher <em>Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem#getMatcher()
	 * @see #getPContainerFieldMatcherItem()
	 * @generated
	 */
	EReference getPContainerFieldMatcherItem_Matcher();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem#getFieldName <em>Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Name</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem#getFieldName()
	 * @see #getPContainerFieldMatcherItem()
	 * @generated
	 */
	EAttribute getPContainerFieldMatcherItem_FieldName();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate <em>PEntity Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PEntity Template</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate
	 * @generated
	 */
	EClass getPEntityTemplate();

	/**
	 * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate#getParameters()
	 * @see #getPEntityTemplate()
	 * @generated
	 */
	EReference getPEntityTemplate_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate#getMatcher <em>Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate#getMatcher()
	 * @see #getPEntityTemplate()
	 * @generated
	 */
	EReference getPEntityTemplate_Matcher();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate#getBasetype <em>Basetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Basetype</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate#getBasetype()
	 * @see #getPEntityTemplate()
	 * @generated
	 */
	EAttribute getPEntityTemplate_Basetype();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PExpressionMatcher <em>PExpression Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PExpression Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PExpressionMatcher
	 * @generated
	 */
	EClass getPExpressionMatcher();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PHexstringMatcher <em>PHexstring Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PHexstring Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PHexstringMatcher
	 * @generated
	 */
	EClass getPHexstringMatcher();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PHexstringMatcher#getDesc <em>Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PHexstringMatcher#getDesc()
	 * @see #getPHexstringMatcher()
	 * @generated
	 */
	EAttribute getPHexstringMatcher_Desc();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate <em>PImport Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PImport Template</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate
	 * @generated
	 */
	EClass getPImportTemplate();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate#getImportedModuleName <em>Imported Module Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imported Module Name</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate#getImportedModuleName()
	 * @see #getPImportTemplate()
	 * @generated
	 */
	EAttribute getPImportTemplate_ImportedModuleName();

	/**
	 * Returns the meta object for the reference '{@link com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate#getImportedTemplate <em>Imported Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Imported Template</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate#getImportedTemplate()
	 * @see #getPImportTemplate()
	 * @generated
	 */
	EReference getPImportTemplate_ImportedTemplate();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate#getImportedTemplateName <em>Imported Template Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imported Template Name</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate#getImportedTemplateName()
	 * @see #getPImportTemplate()
	 * @generated
	 */
	EAttribute getPImportTemplate_ImportedTemplateName();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcher <em>PList Field Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PList Field Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcher
	 * @generated
	 */
	EClass getPListFieldMatcher();

	/**
	 * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcher#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcher#getItems()
	 * @see #getPListFieldMatcher()
	 * @generated
	 */
	EReference getPListFieldMatcher_Items();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem <em>PList Field Matcher Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PList Field Matcher Item</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem
	 * @generated
	 */
	EClass getPListFieldMatcherItem();

	/**
	 * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getMatcher <em>Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getMatcher()
	 * @see #getPListFieldMatcherItem()
	 * @generated
	 */
	EReference getPListFieldMatcherItem_Matcher();

	/**
	 * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getIndexMatcher <em>Index Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getIndexMatcher()
	 * @see #getPListFieldMatcherItem()
	 * @generated
	 */
	EReference getPListFieldMatcherItem_IndexMatcher();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem#getIndex()
	 * @see #getPListFieldMatcherItem()
	 * @generated
	 */
	EAttribute getPListFieldMatcherItem_Index();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListValueMatcher <em>PList Value Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PList Value Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PListValueMatcher
	 * @generated
	 */
	EClass getPListValueMatcher();

	/**
	 * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbtemplate.PListValueMatcher#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PListValueMatcher#getItems()
	 * @see #getPListValueMatcher()
	 * @generated
	 */
	EReference getPListValueMatcher_Items();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PMatcher <em>PMatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PMatcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PMatcher
	 * @generated
	 */
	EClass getPMatcher();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PNotUsedMatcher <em>PNot Used Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PNot Used Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PNotUsedMatcher
	 * @generated
	 */
	EClass getPNotUsedMatcher();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.POctetstringMatcher <em>POctetstring Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>POctetstring Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.POctetstringMatcher
	 * @generated
	 */
	EClass getPOctetstringMatcher();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.POctetstringMatcher#getDesc <em>Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.POctetstringMatcher#getDesc()
	 * @see #getPOctetstringMatcher()
	 * @generated
	 */
	EAttribute getPOctetstringMatcher_Desc();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.POmitMatcher <em>POmit Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>POmit Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.POmitMatcher
	 * @generated
	 */
	EClass getPOmitMatcher();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher <em>PPrimitive Value Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PPrimitive Value Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher
	 * @generated
	 */
	EClass getPPrimitiveValueMatcher();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher#getValueDesc <em>Value Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Desc</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher#getValueDesc()
	 * @see #getPPrimitiveValueMatcher()
	 * @generated
	 */
	EAttribute getPPrimitiveValueMatcher_ValueDesc();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher <em>PRange Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PRange Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher
	 * @generated
	 */
	EClass getPRangeMatcher();

	/**
	 * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lower Bound</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher#getLowerBound()
	 * @see #getPRangeMatcher()
	 * @generated
	 */
	EReference getPRangeMatcher_LowerBound();

	/**
	 * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Upper Bound</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher#getUpperBound()
	 * @see #getPRangeMatcher()
	 * @generated
	 */
	EReference getPRangeMatcher_UpperBound();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PSimpleMatcher <em>PSimple Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PSimple Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PSimpleMatcher
	 * @generated
	 */
	EClass getPSimpleMatcher();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher <em>PSingle Expression Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PSingle Expression Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher
	 * @generated
	 */
	EClass getPSingleExpressionMatcher();

	/**
	 * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher#getExpression()
	 * @see #getPSingleExpressionMatcher()
	 * @generated
	 */
	EReference getPSingleExpressionMatcher_Expression();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PSubSetMatcher <em>PSub Set Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PSub Set Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PSubSetMatcher
	 * @generated
	 */
	EClass getPSubSetMatcher();

	/**
	 * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbtemplate.PSubSetMatcher#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PSubSetMatcher#getItems()
	 * @see #getPSubSetMatcher()
	 * @generated
	 */
	EReference getPSubSetMatcher_Items();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PSuperSetMatcher <em>PSuper Set Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PSuper Set Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PSuperSetMatcher
	 * @generated
	 */
	EClass getPSuperSetMatcher();

	/**
	 * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbtemplate.PSuperSetMatcher#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PSuperSetMatcher#getItems()
	 * @see #getPSuperSetMatcher()
	 * @generated
	 */
	EReference getPSuperSetMatcher_Items();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplate <em>PTemplate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PTemplate</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplate
	 * @generated
	 */
	EClass getPTemplate();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplate#getTemplateID <em>Template ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template ID</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplate#getTemplateID()
	 * @see #getPTemplate()
	 * @generated
	 */
	EAttribute getPTemplate_TemplateID();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher <em>PTemplate Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PTemplate Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher
	 * @generated
	 */
	EClass getPTemplateMatcher();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher#isIfPresent <em>If Present</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>If Present</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher#isIfPresent()
	 * @see #getPTemplateMatcher()
	 * @generated
	 */
	EAttribute getPTemplateMatcher_IfPresent();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher#getLengthRestriction <em>Length Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length Restriction</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher#getLengthRestriction()
	 * @see #getPTemplateMatcher()
	 * @generated
	 */
	EAttribute getPTemplateMatcher_LengthRestriction();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar <em>PTemplate Par</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PTemplate Par</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar
	 * @generated
	 */
	EClass getPTemplatePar();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar#getBasetype <em>Basetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Basetype</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar#getBasetype()
	 * @see #getPTemplatePar()
	 * @generated
	 */
	EAttribute getPTemplatePar_Basetype();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar#isTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar#isTemplate()
	 * @see #getPTemplatePar()
	 * @generated
	 */
	EAttribute getPTemplatePar_Template();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher <em>PTemplate Ref Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PTemplate Ref Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher
	 * @generated
	 */
	EClass getPTemplateRefMatcher();

	/**
	 * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher#getParameters()
	 * @see #getPTemplateRefMatcher()
	 * @generated
	 */
	EReference getPTemplateRefMatcher_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher#getExternalTemplateName <em>External Template Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Template Name</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher#getExternalTemplateName()
	 * @see #getPTemplateRefMatcher()
	 * @generated
	 */
	EAttribute getPTemplateRefMatcher_ExternalTemplateName();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcherPar <em>PTemplate Ref Matcher Par</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PTemplate Ref Matcher Par</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcherPar
	 * @generated
	 */
	EClass getPTemplateRefMatcherPar();

	/**
	 * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcherPar#getMatcher <em>Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcherPar#getMatcher()
	 * @see #getPTemplateRefMatcherPar()
	 * @generated
	 */
	EReference getPTemplateRefMatcherPar_Matcher();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression <em>PUnary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PUnary Expression</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression
	 * @generated
	 */
	EClass getPUnaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression#getPrimary <em>Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Primary</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression#getPrimary()
	 * @see #getPUnaryExpression()
	 * @generated
	 */
	EReference getPUnaryExpression_Primary();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression#getOperator()
	 * @see #getPUnaryExpression()
	 * @generated
	 */
	EAttribute getPUnaryExpression_Operator();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher <em>PValue List Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PValue List Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher
	 * @generated
	 */
	EClass getPValueListMatcher();

	/**
	 * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher#getItems()
	 * @see #getPValueListMatcher()
	 * @generated
	 */
	EReference getPValueListMatcher_Items();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment <em>PValue Reference Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PValue Reference Fragment</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment
	 * @generated
	 */
	EClass getPValueReferenceFragment();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment#getFieldName <em>Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Name</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment#getFieldName()
	 * @see #getPValueReferenceFragment()
	 * @generated
	 */
	EAttribute getPValueReferenceFragment_FieldName();

	/**
	 * Returns the meta object for the containment reference '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment#getIndexMatcher <em>Index Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment#getIndexMatcher()
	 * @see #getPValueReferenceFragment()
	 * @generated
	 */
	EReference getPValueReferenceFragment_IndexMatcher();

	/**
	 * Returns the meta object for class '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher <em>PValue Reference Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PValue Reference Matcher</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher
	 * @generated
	 */
	EClass getPValueReferenceMatcher();

	/**
	 * Returns the meta object for the containment reference list '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getFragments <em>Fragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragments</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getFragments()
	 * @see #getPValueReferenceMatcher()
	 * @generated
	 */
	EReference getPValueReferenceMatcher_Fragments();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getRefName <em>Ref Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref Name</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getRefName()
	 * @see #getPValueReferenceMatcher()
	 * @generated
	 */
	EAttribute getPValueReferenceMatcher_RefName();

	/**
	 * Returns the meta object for the attribute '{@link com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref Type</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher#getRefType()
	 * @see #getPValueReferenceMatcher()
	 * @generated
	 */
	EAttribute getPValueReferenceMatcher_RefType();

	/**
	 * Returns the meta object for enum '{@link com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType <em>Value Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Value Reference Type</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType
	 * @generated
	 */
	EEnum getValueReferenceType();

	/**
	 * Returns the meta object for data type '{@link com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType <em>Value Reference Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Value Reference Type Object</em>'.
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType
	 * @model instanceClass="com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType"
	 *        extendedMetaData="name='ValueReferenceType:Object' baseType='ValueReferenceType'"
	 * @generated
	 */
	EDataType getValueReferenceTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FpbtemplateFactory getFpbtemplateFactory();

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
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PAnyMatcherImpl <em>PAny Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PAnyMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPAnyMatcher()
		 * @generated
		 */
		EClass PANY_MATCHER = eINSTANCE.getPAnyMatcher();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PAnyOrOmitMatcherImpl <em>PAny Or Omit Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PAnyOrOmitMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPAnyOrOmitMatcher()
		 * @generated
		 */
		EClass PANY_OR_OMIT_MATCHER = eINSTANCE.getPAnyOrOmitMatcher();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PBitstringMatcherImpl <em>PBitstring Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PBitstringMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPBitstringMatcher()
		 * @generated
		 */
		EClass PBITSTRING_MATCHER = eINSTANCE.getPBitstringMatcher();

		/**
		 * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PBITSTRING_MATCHER__DESC = eINSTANCE.getPBitstringMatcher_Desc();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PCharstringMatcherImpl <em>PCharstring Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PCharstringMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPCharstringMatcher()
		 * @generated
		 */
		EClass PCHARSTRING_MATCHER = eINSTANCE.getPCharstringMatcher();

		/**
		 * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PCHARSTRING_MATCHER__DESC = eINSTANCE.getPCharstringMatcher_Desc();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PComplementListMatcherImpl <em>PComplement List Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PComplementListMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPComplementListMatcher()
		 * @generated
		 */
		EClass PCOMPLEMENT_LIST_MATCHER = eINSTANCE.getPComplementListMatcher();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCOMPLEMENT_LIST_MATCHER__ITEMS = eINSTANCE.getPComplementListMatcher_Items();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PContainerFieldMatcherImpl <em>PContainer Field Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PContainerFieldMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPContainerFieldMatcher()
		 * @generated
		 */
		EClass PCONTAINER_FIELD_MATCHER = eINSTANCE.getPContainerFieldMatcher();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCONTAINER_FIELD_MATCHER__ITEMS = eINSTANCE.getPContainerFieldMatcher_Items();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PContainerFieldMatcherItemImpl <em>PContainer Field Matcher Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PContainerFieldMatcherItemImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPContainerFieldMatcherItem()
		 * @generated
		 */
		EClass PCONTAINER_FIELD_MATCHER_ITEM = eINSTANCE.getPContainerFieldMatcherItem();

		/**
		 * The meta object literal for the '<em><b>Matcher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCONTAINER_FIELD_MATCHER_ITEM__MATCHER = eINSTANCE.getPContainerFieldMatcherItem_Matcher();

		/**
		 * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PCONTAINER_FIELD_MATCHER_ITEM__FIELD_NAME = eINSTANCE.getPContainerFieldMatcherItem_FieldName();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PEntityTemplateImpl <em>PEntity Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PEntityTemplateImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPEntityTemplate()
		 * @generated
		 */
		EClass PENTITY_TEMPLATE = eINSTANCE.getPEntityTemplate();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PENTITY_TEMPLATE__PARAMETERS = eINSTANCE.getPEntityTemplate_Parameters();

		/**
		 * The meta object literal for the '<em><b>Matcher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PENTITY_TEMPLATE__MATCHER = eINSTANCE.getPEntityTemplate_Matcher();

		/**
		 * The meta object literal for the '<em><b>Basetype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PENTITY_TEMPLATE__BASETYPE = eINSTANCE.getPEntityTemplate_Basetype();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PExpressionMatcherImpl <em>PExpression Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PExpressionMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPExpressionMatcher()
		 * @generated
		 */
		EClass PEXPRESSION_MATCHER = eINSTANCE.getPExpressionMatcher();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PHexstringMatcherImpl <em>PHexstring Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PHexstringMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPHexstringMatcher()
		 * @generated
		 */
		EClass PHEXSTRING_MATCHER = eINSTANCE.getPHexstringMatcher();

		/**
		 * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHEXSTRING_MATCHER__DESC = eINSTANCE.getPHexstringMatcher_Desc();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PImportTemplateImpl <em>PImport Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PImportTemplateImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPImportTemplate()
		 * @generated
		 */
		EClass PIMPORT_TEMPLATE = eINSTANCE.getPImportTemplate();

		/**
		 * The meta object literal for the '<em><b>Imported Module Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIMPORT_TEMPLATE__IMPORTED_MODULE_NAME = eINSTANCE.getPImportTemplate_ImportedModuleName();

		/**
		 * The meta object literal for the '<em><b>Imported Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIMPORT_TEMPLATE__IMPORTED_TEMPLATE = eINSTANCE.getPImportTemplate_ImportedTemplate();

		/**
		 * The meta object literal for the '<em><b>Imported Template Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIMPORT_TEMPLATE__IMPORTED_TEMPLATE_NAME = eINSTANCE.getPImportTemplate_ImportedTemplateName();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PListFieldMatcherImpl <em>PList Field Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PListFieldMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPListFieldMatcher()
		 * @generated
		 */
		EClass PLIST_FIELD_MATCHER = eINSTANCE.getPListFieldMatcher();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLIST_FIELD_MATCHER__ITEMS = eINSTANCE.getPListFieldMatcher_Items();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PListFieldMatcherItemImpl <em>PList Field Matcher Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PListFieldMatcherItemImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPListFieldMatcherItem()
		 * @generated
		 */
		EClass PLIST_FIELD_MATCHER_ITEM = eINSTANCE.getPListFieldMatcherItem();

		/**
		 * The meta object literal for the '<em><b>Matcher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLIST_FIELD_MATCHER_ITEM__MATCHER = eINSTANCE.getPListFieldMatcherItem_Matcher();

		/**
		 * The meta object literal for the '<em><b>Index Matcher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLIST_FIELD_MATCHER_ITEM__INDEX_MATCHER = eINSTANCE.getPListFieldMatcherItem_IndexMatcher();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLIST_FIELD_MATCHER_ITEM__INDEX = eINSTANCE.getPListFieldMatcherItem_Index();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PListValueMatcherImpl <em>PList Value Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PListValueMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPListValueMatcher()
		 * @generated
		 */
		EClass PLIST_VALUE_MATCHER = eINSTANCE.getPListValueMatcher();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLIST_VALUE_MATCHER__ITEMS = eINSTANCE.getPListValueMatcher_Items();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PMatcherImpl <em>PMatcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPMatcher()
		 * @generated
		 */
		EClass PMATCHER = eINSTANCE.getPMatcher();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PNotUsedMatcherImpl <em>PNot Used Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PNotUsedMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPNotUsedMatcher()
		 * @generated
		 */
		EClass PNOT_USED_MATCHER = eINSTANCE.getPNotUsedMatcher();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.POctetstringMatcherImpl <em>POctetstring Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.POctetstringMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPOctetstringMatcher()
		 * @generated
		 */
		EClass POCTETSTRING_MATCHER = eINSTANCE.getPOctetstringMatcher();

		/**
		 * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POCTETSTRING_MATCHER__DESC = eINSTANCE.getPOctetstringMatcher_Desc();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.POmitMatcherImpl <em>POmit Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.POmitMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPOmitMatcher()
		 * @generated
		 */
		EClass POMIT_MATCHER = eINSTANCE.getPOmitMatcher();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PPrimitiveValueMatcherImpl <em>PPrimitive Value Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PPrimitiveValueMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPPrimitiveValueMatcher()
		 * @generated
		 */
		EClass PPRIMITIVE_VALUE_MATCHER = eINSTANCE.getPPrimitiveValueMatcher();

		/**
		 * The meta object literal for the '<em><b>Value Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PPRIMITIVE_VALUE_MATCHER__VALUE_DESC = eINSTANCE.getPPrimitiveValueMatcher_ValueDesc();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PRangeMatcherImpl <em>PRange Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PRangeMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPRangeMatcher()
		 * @generated
		 */
		EClass PRANGE_MATCHER = eINSTANCE.getPRangeMatcher();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRANGE_MATCHER__LOWER_BOUND = eINSTANCE.getPRangeMatcher_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRANGE_MATCHER__UPPER_BOUND = eINSTANCE.getPRangeMatcher_UpperBound();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PSimpleMatcherImpl <em>PSimple Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PSimpleMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPSimpleMatcher()
		 * @generated
		 */
		EClass PSIMPLE_MATCHER = eINSTANCE.getPSimpleMatcher();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PSingleExpressionMatcherImpl <em>PSingle Expression Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PSingleExpressionMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPSingleExpressionMatcher()
		 * @generated
		 */
		EClass PSINGLE_EXPRESSION_MATCHER = eINSTANCE.getPSingleExpressionMatcher();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSINGLE_EXPRESSION_MATCHER__EXPRESSION = eINSTANCE.getPSingleExpressionMatcher_Expression();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PSubSetMatcherImpl <em>PSub Set Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PSubSetMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPSubSetMatcher()
		 * @generated
		 */
		EClass PSUB_SET_MATCHER = eINSTANCE.getPSubSetMatcher();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSUB_SET_MATCHER__ITEMS = eINSTANCE.getPSubSetMatcher_Items();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PSuperSetMatcherImpl <em>PSuper Set Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PSuperSetMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPSuperSetMatcher()
		 * @generated
		 */
		EClass PSUPER_SET_MATCHER = eINSTANCE.getPSuperSetMatcher();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSUPER_SET_MATCHER__ITEMS = eINSTANCE.getPSuperSetMatcher_Items();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateImpl <em>PTemplate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPTemplate()
		 * @generated
		 */
		EClass PTEMPLATE = eINSTANCE.getPTemplate();

		/**
		 * The meta object literal for the '<em><b>Template ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PTEMPLATE__TEMPLATE_ID = eINSTANCE.getPTemplate_TemplateID();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateMatcherImpl <em>PTemplate Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPTemplateMatcher()
		 * @generated
		 */
		EClass PTEMPLATE_MATCHER = eINSTANCE.getPTemplateMatcher();

		/**
		 * The meta object literal for the '<em><b>If Present</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PTEMPLATE_MATCHER__IF_PRESENT = eINSTANCE.getPTemplateMatcher_IfPresent();

		/**
		 * The meta object literal for the '<em><b>Length Restriction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PTEMPLATE_MATCHER__LENGTH_RESTRICTION = eINSTANCE.getPTemplateMatcher_LengthRestriction();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateParImpl <em>PTemplate Par</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateParImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPTemplatePar()
		 * @generated
		 */
		EClass PTEMPLATE_PAR = eINSTANCE.getPTemplatePar();

		/**
		 * The meta object literal for the '<em><b>Basetype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PTEMPLATE_PAR__BASETYPE = eINSTANCE.getPTemplatePar_Basetype();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PTEMPLATE_PAR__TEMPLATE = eINSTANCE.getPTemplatePar_Template();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateRefMatcherImpl <em>PTemplate Ref Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateRefMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPTemplateRefMatcher()
		 * @generated
		 */
		EClass PTEMPLATE_REF_MATCHER = eINSTANCE.getPTemplateRefMatcher();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PTEMPLATE_REF_MATCHER__PARAMETERS = eINSTANCE.getPTemplateRefMatcher_Parameters();

		/**
		 * The meta object literal for the '<em><b>External Template Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PTEMPLATE_REF_MATCHER__EXTERNAL_TEMPLATE_NAME = eINSTANCE.getPTemplateRefMatcher_ExternalTemplateName();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateRefMatcherParImpl <em>PTemplate Ref Matcher Par</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PTemplateRefMatcherParImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPTemplateRefMatcherPar()
		 * @generated
		 */
		EClass PTEMPLATE_REF_MATCHER_PAR = eINSTANCE.getPTemplateRefMatcherPar();

		/**
		 * The meta object literal for the '<em><b>Matcher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PTEMPLATE_REF_MATCHER_PAR__MATCHER = eINSTANCE.getPTemplateRefMatcherPar_Matcher();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PUnaryExpressionImpl <em>PUnary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PUnaryExpressionImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPUnaryExpression()
		 * @generated
		 */
		EClass PUNARY_EXPRESSION = eINSTANCE.getPUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Primary</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PUNARY_EXPRESSION__PRIMARY = eINSTANCE.getPUnaryExpression_Primary();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUNARY_EXPRESSION__OPERATOR = eINSTANCE.getPUnaryExpression_Operator();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueListMatcherImpl <em>PValue List Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueListMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPValueListMatcher()
		 * @generated
		 */
		EClass PVALUE_LIST_MATCHER = eINSTANCE.getPValueListMatcher();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PVALUE_LIST_MATCHER__ITEMS = eINSTANCE.getPValueListMatcher_Items();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceFragmentImpl <em>PValue Reference Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceFragmentImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPValueReferenceFragment()
		 * @generated
		 */
		EClass PVALUE_REFERENCE_FRAGMENT = eINSTANCE.getPValueReferenceFragment();

		/**
		 * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PVALUE_REFERENCE_FRAGMENT__FIELD_NAME = eINSTANCE.getPValueReferenceFragment_FieldName();

		/**
		 * The meta object literal for the '<em><b>Index Matcher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PVALUE_REFERENCE_FRAGMENT__INDEX_MATCHER = eINSTANCE.getPValueReferenceFragment_IndexMatcher();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceMatcherImpl <em>PValue Reference Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.PValueReferenceMatcherImpl
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getPValueReferenceMatcher()
		 * @generated
		 */
		EClass PVALUE_REFERENCE_MATCHER = eINSTANCE.getPValueReferenceMatcher();

		/**
		 * The meta object literal for the '<em><b>Fragments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PVALUE_REFERENCE_MATCHER__FRAGMENTS = eINSTANCE.getPValueReferenceMatcher_Fragments();

		/**
		 * The meta object literal for the '<em><b>Ref Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PVALUE_REFERENCE_MATCHER__REF_NAME = eINSTANCE.getPValueReferenceMatcher_RefName();

		/**
		 * The meta object literal for the '<em><b>Ref Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PVALUE_REFERENCE_MATCHER__REF_TYPE = eINSTANCE.getPValueReferenceMatcher_RefType();

		/**
		 * The meta object literal for the '{@link com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType <em>Value Reference Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getValueReferenceType()
		 * @generated
		 */
		EEnum VALUE_REFERENCE_TYPE = eINSTANCE.getValueReferenceType();

		/**
		 * The meta object literal for the '<em>Value Reference Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType
		 * @see com.fineqt.fpb.lib.model.fpbtemplate.impl.FpbtemplatePackageImpl#getValueReferenceTypeObject()
		 * @generated
		 */
		EDataType VALUE_REFERENCE_TYPE_OBJECT = eINSTANCE.getValueReferenceTypeObject();

	}

} //FpbtemplatePackage
