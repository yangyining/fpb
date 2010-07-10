/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.fineqt.fpb.lib.model.fpbtemplate.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.fineqt.fpb.lib.model.fpbcommon.FpbcommonPackage;
import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplateFactory;
import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage;
import com.fineqt.fpb.lib.model.fpbtemplate.PAnyMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PAnyOrOmitMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PBitstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PComplementListMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem;
import com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate;
import com.fineqt.fpb.lib.model.fpbtemplate.PExpressionMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PHexstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate;
import com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem;
import com.fineqt.fpb.lib.model.fpbtemplate.PListValueMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PNotUsedMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.POctetstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.POmitMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PSimpleMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PSubSetMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PSuperSetMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplate;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcherPar;
import com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FpbtemplatePackageImpl extends EPackageImpl implements FpbtemplatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pAnyMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pAnyOrOmitMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pBitstringMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pCharstringMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pComplementListMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pContainerFieldMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pContainerFieldMatcherItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pEntityTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pExpressionMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pHexstringMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pImportTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pListFieldMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pListFieldMatcherItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pListValueMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pNotUsedMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pOctetstringMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pOmitMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pPrimitiveValueMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pRangeMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pSimpleMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pSingleExpressionMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pSubSetMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pSuperSetMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pTemplateMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pTemplateParEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pTemplateRefMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pTemplateRefMatcherParEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pUnaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pValueListMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pValueReferenceFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pValueReferenceMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum valueReferenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType valueReferenceTypeObjectEDataType = null;

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
	 * @see com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FpbtemplatePackageImpl() {
		super(eNS_URI, FpbtemplateFactory.eINSTANCE);
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
	public static FpbtemplatePackage init() {
		if (isInited) return (FpbtemplatePackage)EPackage.Registry.INSTANCE.getEPackage(FpbtemplatePackage.eNS_URI);

		// Obtain or create and register package
		FpbtemplatePackageImpl theFpbtemplatePackage = (FpbtemplatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof FpbtemplatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new FpbtemplatePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		FpbcommonPackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFpbtemplatePackage.createPackageContents();

		// Initialize created meta-data
		theFpbtemplatePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFpbtemplatePackage.freeze();

		return theFpbtemplatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPAnyMatcher() {
		return pAnyMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPAnyOrOmitMatcher() {
		return pAnyOrOmitMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPBitstringMatcher() {
		return pBitstringMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPBitstringMatcher_Desc() {
		return (EAttribute)pBitstringMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCharstringMatcher() {
		return pCharstringMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPCharstringMatcher_Desc() {
		return (EAttribute)pCharstringMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPComplementListMatcher() {
		return pComplementListMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPComplementListMatcher_Items() {
		return (EReference)pComplementListMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPContainerFieldMatcher() {
		return pContainerFieldMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPContainerFieldMatcher_Items() {
		return (EReference)pContainerFieldMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPContainerFieldMatcherItem() {
		return pContainerFieldMatcherItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPContainerFieldMatcherItem_Matcher() {
		return (EReference)pContainerFieldMatcherItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPContainerFieldMatcherItem_FieldName() {
		return (EAttribute)pContainerFieldMatcherItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPEntityTemplate() {
		return pEntityTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPEntityTemplate_Parameters() {
		return (EReference)pEntityTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPEntityTemplate_Matcher() {
		return (EReference)pEntityTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPEntityTemplate_Basetype() {
		return (EAttribute)pEntityTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPExpressionMatcher() {
		return pExpressionMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPHexstringMatcher() {
		return pHexstringMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPHexstringMatcher_Desc() {
		return (EAttribute)pHexstringMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPImportTemplate() {
		return pImportTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPImportTemplate_ImportedModuleName() {
		return (EAttribute)pImportTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPImportTemplate_ImportedTemplate() {
		return (EReference)pImportTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPImportTemplate_ImportedTemplateName() {
		return (EAttribute)pImportTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPListFieldMatcher() {
		return pListFieldMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPListFieldMatcher_Items() {
		return (EReference)pListFieldMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPListFieldMatcherItem() {
		return pListFieldMatcherItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPListFieldMatcherItem_Matcher() {
		return (EReference)pListFieldMatcherItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPListFieldMatcherItem_IndexMatcher() {
		return (EReference)pListFieldMatcherItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPListFieldMatcherItem_Index() {
		return (EAttribute)pListFieldMatcherItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPListValueMatcher() {
		return pListValueMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPListValueMatcher_Items() {
		return (EReference)pListValueMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPMatcher() {
		return pMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPNotUsedMatcher() {
		return pNotUsedMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPOctetstringMatcher() {
		return pOctetstringMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPOctetstringMatcher_Desc() {
		return (EAttribute)pOctetstringMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPOmitMatcher() {
		return pOmitMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPPrimitiveValueMatcher() {
		return pPrimitiveValueMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPPrimitiveValueMatcher_ValueDesc() {
		return (EAttribute)pPrimitiveValueMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPRangeMatcher() {
		return pRangeMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRangeMatcher_LowerBound() {
		return (EReference)pRangeMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRangeMatcher_UpperBound() {
		return (EReference)pRangeMatcherEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPSimpleMatcher() {
		return pSimpleMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPSingleExpressionMatcher() {
		return pSingleExpressionMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPSingleExpressionMatcher_Expression() {
		return (EReference)pSingleExpressionMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPSubSetMatcher() {
		return pSubSetMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPSubSetMatcher_Items() {
		return (EReference)pSubSetMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPSuperSetMatcher() {
		return pSuperSetMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPSuperSetMatcher_Items() {
		return (EReference)pSuperSetMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPTemplate() {
		return pTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPTemplate_TemplateID() {
		return (EAttribute)pTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPTemplateMatcher() {
		return pTemplateMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPTemplateMatcher_IfPresent() {
		return (EAttribute)pTemplateMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPTemplateMatcher_LengthRestriction() {
		return (EAttribute)pTemplateMatcherEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPTemplatePar() {
		return pTemplateParEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPTemplatePar_Basetype() {
		return (EAttribute)pTemplateParEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPTemplatePar_Template() {
		return (EAttribute)pTemplateParEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPTemplateRefMatcher() {
		return pTemplateRefMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPTemplateRefMatcher_Parameters() {
		return (EReference)pTemplateRefMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPTemplateRefMatcher_ExternalTemplateName() {
		return (EAttribute)pTemplateRefMatcherEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPTemplateRefMatcherPar() {
		return pTemplateRefMatcherParEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPTemplateRefMatcherPar_Matcher() {
		return (EReference)pTemplateRefMatcherParEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPUnaryExpression() {
		return pUnaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPUnaryExpression_Primary() {
		return (EReference)pUnaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPUnaryExpression_Operator() {
		return (EAttribute)pUnaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPValueListMatcher() {
		return pValueListMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPValueListMatcher_Items() {
		return (EReference)pValueListMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPValueReferenceFragment() {
		return pValueReferenceFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPValueReferenceFragment_FieldName() {
		return (EAttribute)pValueReferenceFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPValueReferenceFragment_IndexMatcher() {
		return (EReference)pValueReferenceFragmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPValueReferenceMatcher() {
		return pValueReferenceMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPValueReferenceMatcher_Fragments() {
		return (EReference)pValueReferenceMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPValueReferenceMatcher_RefName() {
		return (EAttribute)pValueReferenceMatcherEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPValueReferenceMatcher_RefType() {
		return (EAttribute)pValueReferenceMatcherEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getValueReferenceType() {
		return valueReferenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getValueReferenceTypeObject() {
		return valueReferenceTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FpbtemplateFactory getFpbtemplateFactory() {
		return (FpbtemplateFactory)getEFactoryInstance();
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
		pAnyMatcherEClass = createEClass(PANY_MATCHER);

		pAnyOrOmitMatcherEClass = createEClass(PANY_OR_OMIT_MATCHER);

		pBitstringMatcherEClass = createEClass(PBITSTRING_MATCHER);
		createEAttribute(pBitstringMatcherEClass, PBITSTRING_MATCHER__DESC);

		pCharstringMatcherEClass = createEClass(PCHARSTRING_MATCHER);
		createEAttribute(pCharstringMatcherEClass, PCHARSTRING_MATCHER__DESC);

		pComplementListMatcherEClass = createEClass(PCOMPLEMENT_LIST_MATCHER);
		createEReference(pComplementListMatcherEClass, PCOMPLEMENT_LIST_MATCHER__ITEMS);

		pContainerFieldMatcherEClass = createEClass(PCONTAINER_FIELD_MATCHER);
		createEReference(pContainerFieldMatcherEClass, PCONTAINER_FIELD_MATCHER__ITEMS);

		pContainerFieldMatcherItemEClass = createEClass(PCONTAINER_FIELD_MATCHER_ITEM);
		createEReference(pContainerFieldMatcherItemEClass, PCONTAINER_FIELD_MATCHER_ITEM__MATCHER);
		createEAttribute(pContainerFieldMatcherItemEClass, PCONTAINER_FIELD_MATCHER_ITEM__FIELD_NAME);

		pEntityTemplateEClass = createEClass(PENTITY_TEMPLATE);
		createEReference(pEntityTemplateEClass, PENTITY_TEMPLATE__PARAMETERS);
		createEReference(pEntityTemplateEClass, PENTITY_TEMPLATE__MATCHER);
		createEAttribute(pEntityTemplateEClass, PENTITY_TEMPLATE__BASETYPE);

		pExpressionMatcherEClass = createEClass(PEXPRESSION_MATCHER);

		pHexstringMatcherEClass = createEClass(PHEXSTRING_MATCHER);
		createEAttribute(pHexstringMatcherEClass, PHEXSTRING_MATCHER__DESC);

		pImportTemplateEClass = createEClass(PIMPORT_TEMPLATE);
		createEAttribute(pImportTemplateEClass, PIMPORT_TEMPLATE__IMPORTED_MODULE_NAME);
		createEReference(pImportTemplateEClass, PIMPORT_TEMPLATE__IMPORTED_TEMPLATE);
		createEAttribute(pImportTemplateEClass, PIMPORT_TEMPLATE__IMPORTED_TEMPLATE_NAME);

		pListFieldMatcherEClass = createEClass(PLIST_FIELD_MATCHER);
		createEReference(pListFieldMatcherEClass, PLIST_FIELD_MATCHER__ITEMS);

		pListFieldMatcherItemEClass = createEClass(PLIST_FIELD_MATCHER_ITEM);
		createEReference(pListFieldMatcherItemEClass, PLIST_FIELD_MATCHER_ITEM__MATCHER);
		createEReference(pListFieldMatcherItemEClass, PLIST_FIELD_MATCHER_ITEM__INDEX_MATCHER);
		createEAttribute(pListFieldMatcherItemEClass, PLIST_FIELD_MATCHER_ITEM__INDEX);

		pListValueMatcherEClass = createEClass(PLIST_VALUE_MATCHER);
		createEReference(pListValueMatcherEClass, PLIST_VALUE_MATCHER__ITEMS);

		pMatcherEClass = createEClass(PMATCHER);

		pNotUsedMatcherEClass = createEClass(PNOT_USED_MATCHER);

		pOctetstringMatcherEClass = createEClass(POCTETSTRING_MATCHER);
		createEAttribute(pOctetstringMatcherEClass, POCTETSTRING_MATCHER__DESC);

		pOmitMatcherEClass = createEClass(POMIT_MATCHER);

		pPrimitiveValueMatcherEClass = createEClass(PPRIMITIVE_VALUE_MATCHER);
		createEAttribute(pPrimitiveValueMatcherEClass, PPRIMITIVE_VALUE_MATCHER__VALUE_DESC);

		pRangeMatcherEClass = createEClass(PRANGE_MATCHER);
		createEReference(pRangeMatcherEClass, PRANGE_MATCHER__LOWER_BOUND);
		createEReference(pRangeMatcherEClass, PRANGE_MATCHER__UPPER_BOUND);

		pSimpleMatcherEClass = createEClass(PSIMPLE_MATCHER);

		pSingleExpressionMatcherEClass = createEClass(PSINGLE_EXPRESSION_MATCHER);
		createEReference(pSingleExpressionMatcherEClass, PSINGLE_EXPRESSION_MATCHER__EXPRESSION);

		pSubSetMatcherEClass = createEClass(PSUB_SET_MATCHER);
		createEReference(pSubSetMatcherEClass, PSUB_SET_MATCHER__ITEMS);

		pSuperSetMatcherEClass = createEClass(PSUPER_SET_MATCHER);
		createEReference(pSuperSetMatcherEClass, PSUPER_SET_MATCHER__ITEMS);

		pTemplateEClass = createEClass(PTEMPLATE);
		createEAttribute(pTemplateEClass, PTEMPLATE__TEMPLATE_ID);

		pTemplateMatcherEClass = createEClass(PTEMPLATE_MATCHER);
		createEAttribute(pTemplateMatcherEClass, PTEMPLATE_MATCHER__IF_PRESENT);
		createEAttribute(pTemplateMatcherEClass, PTEMPLATE_MATCHER__LENGTH_RESTRICTION);

		pTemplateParEClass = createEClass(PTEMPLATE_PAR);
		createEAttribute(pTemplateParEClass, PTEMPLATE_PAR__BASETYPE);
		createEAttribute(pTemplateParEClass, PTEMPLATE_PAR__TEMPLATE);

		pTemplateRefMatcherEClass = createEClass(PTEMPLATE_REF_MATCHER);
		createEReference(pTemplateRefMatcherEClass, PTEMPLATE_REF_MATCHER__PARAMETERS);
		createEAttribute(pTemplateRefMatcherEClass, PTEMPLATE_REF_MATCHER__EXTERNAL_TEMPLATE_NAME);

		pTemplateRefMatcherParEClass = createEClass(PTEMPLATE_REF_MATCHER_PAR);
		createEReference(pTemplateRefMatcherParEClass, PTEMPLATE_REF_MATCHER_PAR__MATCHER);

		pUnaryExpressionEClass = createEClass(PUNARY_EXPRESSION);
		createEReference(pUnaryExpressionEClass, PUNARY_EXPRESSION__PRIMARY);
		createEAttribute(pUnaryExpressionEClass, PUNARY_EXPRESSION__OPERATOR);

		pValueListMatcherEClass = createEClass(PVALUE_LIST_MATCHER);
		createEReference(pValueListMatcherEClass, PVALUE_LIST_MATCHER__ITEMS);

		pValueReferenceFragmentEClass = createEClass(PVALUE_REFERENCE_FRAGMENT);
		createEAttribute(pValueReferenceFragmentEClass, PVALUE_REFERENCE_FRAGMENT__FIELD_NAME);
		createEReference(pValueReferenceFragmentEClass, PVALUE_REFERENCE_FRAGMENT__INDEX_MATCHER);

		pValueReferenceMatcherEClass = createEClass(PVALUE_REFERENCE_MATCHER);
		createEReference(pValueReferenceMatcherEClass, PVALUE_REFERENCE_MATCHER__FRAGMENTS);
		createEAttribute(pValueReferenceMatcherEClass, PVALUE_REFERENCE_MATCHER__REF_NAME);
		createEAttribute(pValueReferenceMatcherEClass, PVALUE_REFERENCE_MATCHER__REF_TYPE);

		// Create enums
		valueReferenceTypeEEnum = createEEnum(VALUE_REFERENCE_TYPE);

		// Create data types
		valueReferenceTypeObjectEDataType = createEDataType(VALUE_REFERENCE_TYPE_OBJECT);
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
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		FpbcommonPackage theFpbcommonPackage = (FpbcommonPackage)EPackage.Registry.INSTANCE.getEPackage(FpbcommonPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pAnyMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pAnyOrOmitMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pBitstringMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pCharstringMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pComplementListMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pContainerFieldMatcherEClass.getESuperTypes().add(this.getPTemplateMatcher());
		pContainerFieldMatcherItemEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
		pEntityTemplateEClass.getESuperTypes().add(this.getPTemplate());
		pExpressionMatcherEClass.getESuperTypes().add(this.getPMatcher());
		pHexstringMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pImportTemplateEClass.getESuperTypes().add(this.getPTemplate());
		pListFieldMatcherEClass.getESuperTypes().add(this.getPTemplateMatcher());
		pListFieldMatcherItemEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
		pListValueMatcherEClass.getESuperTypes().add(this.getPTemplateMatcher());
		pMatcherEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
		pNotUsedMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pOctetstringMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pOmitMatcherEClass.getESuperTypes().add(this.getPExpressionMatcher());
		pPrimitiveValueMatcherEClass.getESuperTypes().add(this.getPExpressionMatcher());
		pRangeMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pSimpleMatcherEClass.getESuperTypes().add(this.getPTemplateMatcher());
		pSingleExpressionMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pSubSetMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pSuperSetMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pTemplateEClass.getESuperTypes().add(theFpbcommonPackage.getPNamedElement());
		pTemplateMatcherEClass.getESuperTypes().add(this.getPMatcher());
		pTemplateParEClass.getESuperTypes().add(theFpbcommonPackage.getPNamedElement());
		pTemplateRefMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pTemplateRefMatcherParEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
		pUnaryExpressionEClass.getESuperTypes().add(this.getPExpressionMatcher());
		pValueListMatcherEClass.getESuperTypes().add(this.getPSimpleMatcher());
		pValueReferenceFragmentEClass.getESuperTypes().add(theFpbcommonPackage.getPModelElement());
		pValueReferenceMatcherEClass.getESuperTypes().add(this.getPExpressionMatcher());

		// Initialize classes and features; add operations and parameters
		initEClass(pAnyMatcherEClass, PAnyMatcher.class, "PAnyMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pAnyOrOmitMatcherEClass, PAnyOrOmitMatcher.class, "PAnyOrOmitMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pBitstringMatcherEClass, PBitstringMatcher.class, "PBitstringMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPBitstringMatcher_Desc(), theXMLTypePackage.getString(), "desc", null, 1, 1, PBitstringMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pCharstringMatcherEClass, PCharstringMatcher.class, "PCharstringMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPCharstringMatcher_Desc(), theXMLTypePackage.getString(), "desc", null, 1, 1, PCharstringMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pComplementListMatcherEClass, PComplementListMatcher.class, "PComplementListMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPComplementListMatcher_Items(), this.getPTemplateMatcher(), null, "items", null, 0, -1, PComplementListMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pContainerFieldMatcherEClass, PContainerFieldMatcher.class, "PContainerFieldMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPContainerFieldMatcher_Items(), this.getPContainerFieldMatcherItem(), null, "items", null, 0, -1, PContainerFieldMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pContainerFieldMatcherItemEClass, PContainerFieldMatcherItem.class, "PContainerFieldMatcherItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPContainerFieldMatcherItem_Matcher(), this.getPTemplateMatcher(), null, "matcher", null, 1, 1, PContainerFieldMatcherItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPContainerFieldMatcherItem_FieldName(), theXMLTypePackage.getString(), "fieldName", null, 1, 1, PContainerFieldMatcherItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pEntityTemplateEClass, PEntityTemplate.class, "PEntityTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPEntityTemplate_Parameters(), this.getPTemplatePar(), null, "parameters", null, 0, -1, PEntityTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPEntityTemplate_Matcher(), this.getPMatcher(), null, "matcher", null, 1, 1, PEntityTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPEntityTemplate_Basetype(), theXMLTypePackage.getString(), "basetype", null, 1, 1, PEntityTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pExpressionMatcherEClass, PExpressionMatcher.class, "PExpressionMatcher", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pHexstringMatcherEClass, PHexstringMatcher.class, "PHexstringMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPHexstringMatcher_Desc(), theXMLTypePackage.getString(), "desc", null, 1, 1, PHexstringMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pImportTemplateEClass, PImportTemplate.class, "PImportTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPImportTemplate_ImportedModuleName(), theXMLTypePackage.getString(), "importedModuleName", null, 1, 1, PImportTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPImportTemplate_ImportedTemplate(), this.getPTemplate(), null, "importedTemplate", null, 0, 1, PImportTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPImportTemplate_ImportedTemplateName(), theXMLTypePackage.getString(), "importedTemplateName", null, 1, 1, PImportTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pListFieldMatcherEClass, PListFieldMatcher.class, "PListFieldMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPListFieldMatcher_Items(), this.getPListFieldMatcherItem(), null, "items", null, 0, -1, PListFieldMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pListFieldMatcherItemEClass, PListFieldMatcherItem.class, "PListFieldMatcherItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPListFieldMatcherItem_Matcher(), this.getPTemplateMatcher(), null, "matcher", null, 1, 1, PListFieldMatcherItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPListFieldMatcherItem_IndexMatcher(), this.getPMatcher(), null, "indexMatcher", null, 0, 1, PListFieldMatcherItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPListFieldMatcherItem_Index(), theXMLTypePackage.getInt(), "index", null, 0, 1, PListFieldMatcherItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pListValueMatcherEClass, PListValueMatcher.class, "PListValueMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPListValueMatcher_Items(), this.getPMatcher(), null, "items", null, 0, -1, PListValueMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pMatcherEClass, PMatcher.class, "PMatcher", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pNotUsedMatcherEClass, PNotUsedMatcher.class, "PNotUsedMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pOctetstringMatcherEClass, POctetstringMatcher.class, "POctetstringMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPOctetstringMatcher_Desc(), theXMLTypePackage.getString(), "desc", null, 1, 1, POctetstringMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pOmitMatcherEClass, POmitMatcher.class, "POmitMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pPrimitiveValueMatcherEClass, PPrimitiveValueMatcher.class, "PPrimitiveValueMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPPrimitiveValueMatcher_ValueDesc(), theXMLTypePackage.getString(), "valueDesc", null, 1, 1, PPrimitiveValueMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pRangeMatcherEClass, PRangeMatcher.class, "PRangeMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPRangeMatcher_LowerBound(), this.getPMatcher(), null, "lowerBound", null, 1, 1, PRangeMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPRangeMatcher_UpperBound(), this.getPMatcher(), null, "upperBound", null, 1, 1, PRangeMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pSimpleMatcherEClass, PSimpleMatcher.class, "PSimpleMatcher", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pSingleExpressionMatcherEClass, PSingleExpressionMatcher.class, "PSingleExpressionMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPSingleExpressionMatcher_Expression(), this.getPExpressionMatcher(), null, "expression", null, 1, 1, PSingleExpressionMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pSubSetMatcherEClass, PSubSetMatcher.class, "PSubSetMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPSubSetMatcher_Items(), this.getPTemplateMatcher(), null, "items", null, 0, -1, PSubSetMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pSuperSetMatcherEClass, PSuperSetMatcher.class, "PSuperSetMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPSuperSetMatcher_Items(), this.getPTemplateMatcher(), null, "items", null, 0, -1, PSuperSetMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pTemplateEClass, PTemplate.class, "PTemplate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPTemplate_TemplateID(), theXMLTypePackage.getInt(), "templateID", null, 0, 1, PTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pTemplateMatcherEClass, PTemplateMatcher.class, "PTemplateMatcher", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPTemplateMatcher_IfPresent(), theXMLTypePackage.getBoolean(), "ifPresent", null, 0, 1, PTemplateMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPTemplateMatcher_LengthRestriction(), theXMLTypePackage.getString(), "lengthRestriction", null, 0, 1, PTemplateMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pTemplateParEClass, PTemplatePar.class, "PTemplatePar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPTemplatePar_Basetype(), theXMLTypePackage.getString(), "basetype", null, 1, 1, PTemplatePar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPTemplatePar_Template(), theXMLTypePackage.getBoolean(), "template", null, 1, 1, PTemplatePar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pTemplateRefMatcherEClass, PTemplateRefMatcher.class, "PTemplateRefMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPTemplateRefMatcher_Parameters(), this.getPTemplateRefMatcherPar(), null, "parameters", null, 0, -1, PTemplateRefMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPTemplateRefMatcher_ExternalTemplateName(), theXMLTypePackage.getString(), "externalTemplateName", null, 1, 1, PTemplateRefMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pTemplateRefMatcherParEClass, PTemplateRefMatcherPar.class, "PTemplateRefMatcherPar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPTemplateRefMatcherPar_Matcher(), this.getPMatcher(), null, "matcher", null, 1, 1, PTemplateRefMatcherPar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pUnaryExpressionEClass, PUnaryExpression.class, "PUnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPUnaryExpression_Primary(), this.getPExpressionMatcher(), null, "primary", null, 1, 1, PUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPUnaryExpression_Operator(), theXMLTypePackage.getString(), "operator", null, 0, 1, PUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pValueListMatcherEClass, PValueListMatcher.class, "PValueListMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPValueListMatcher_Items(), this.getPTemplateMatcher(), null, "items", null, 0, -1, PValueListMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pValueReferenceFragmentEClass, PValueReferenceFragment.class, "PValueReferenceFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPValueReferenceFragment_FieldName(), theXMLTypePackage.getString(), "fieldName", null, 0, 1, PValueReferenceFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPValueReferenceFragment_IndexMatcher(), this.getPMatcher(), null, "indexMatcher", null, 0, 1, PValueReferenceFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pValueReferenceMatcherEClass, PValueReferenceMatcher.class, "PValueReferenceMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPValueReferenceMatcher_Fragments(), this.getPValueReferenceFragment(), null, "fragments", null, 0, -1, PValueReferenceMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPValueReferenceMatcher_RefName(), theXMLTypePackage.getString(), "refName", null, 1, 1, PValueReferenceMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPValueReferenceMatcher_RefType(), this.getValueReferenceType(), "refType", "CONSTANT", 1, 1, PValueReferenceMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(valueReferenceTypeEEnum, ValueReferenceType.class, "ValueReferenceType");
		addEEnumLiteral(valueReferenceTypeEEnum, ValueReferenceType.CONSTANT);
		addEEnumLiteral(valueReferenceTypeEEnum, ValueReferenceType.MODULEPAR);
		addEEnumLiteral(valueReferenceTypeEEnum, ValueReferenceType.TEMPLATEPAR);

		// Initialize data types
		initEDataType(valueReferenceTypeObjectEDataType, ValueReferenceType.class, "ValueReferenceTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

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
		  (pAnyMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PAnyMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (pAnyOrOmitMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PAnyOrOmitMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (pBitstringMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PBitstringMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPBitstringMatcher_Desc(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "desc"
		   });		
		addAnnotation
		  (pCharstringMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PCharstringMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPCharstringMatcher_Desc(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "desc"
		   });		
		addAnnotation
		  (pComplementListMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PComplementListMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPComplementListMatcher_Items(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "items"
		   });		
		addAnnotation
		  (pContainerFieldMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PContainerFieldMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPContainerFieldMatcher_Items(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "items"
		   });		
		addAnnotation
		  (pContainerFieldMatcherItemEClass, 
		   source, 
		   new String[] {
			 "name", "PContainerFieldMatcherItem",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPContainerFieldMatcherItem_Matcher(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "matcher"
		   });		
		addAnnotation
		  (getPContainerFieldMatcherItem_FieldName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "fieldName"
		   });		
		addAnnotation
		  (pEntityTemplateEClass, 
		   source, 
		   new String[] {
			 "name", "PEntityTemplate",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPEntityTemplate_Parameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameters"
		   });		
		addAnnotation
		  (getPEntityTemplate_Matcher(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "matcher"
		   });		
		addAnnotation
		  (getPEntityTemplate_Basetype(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "basetype"
		   });		
		addAnnotation
		  (pExpressionMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PExpressionMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (pHexstringMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PHexstringMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPHexstringMatcher_Desc(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "desc"
		   });		
		addAnnotation
		  (pImportTemplateEClass, 
		   source, 
		   new String[] {
			 "name", "PImportTemplate",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPImportTemplate_ImportedModuleName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "importedModuleName"
		   });		
		addAnnotation
		  (getPImportTemplate_ImportedTemplate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "importedTemplate"
		   });		
		addAnnotation
		  (getPImportTemplate_ImportedTemplateName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "importedTemplateName"
		   });		
		addAnnotation
		  (pListFieldMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PListFieldMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPListFieldMatcher_Items(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "items"
		   });		
		addAnnotation
		  (pListFieldMatcherItemEClass, 
		   source, 
		   new String[] {
			 "name", "PListFieldMatcherItem",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPListFieldMatcherItem_Matcher(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "matcher"
		   });		
		addAnnotation
		  (getPListFieldMatcherItem_IndexMatcher(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "indexMatcher"
		   });		
		addAnnotation
		  (getPListFieldMatcherItem_Index(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "index"
		   });		
		addAnnotation
		  (pListValueMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PListValueMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPListValueMatcher_Items(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "items"
		   });		
		addAnnotation
		  (pMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (pNotUsedMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PNotUsedMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (pOctetstringMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "POctetstringMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPOctetstringMatcher_Desc(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "desc"
		   });		
		addAnnotation
		  (pOmitMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "POmitMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (pPrimitiveValueMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PPrimitiveValueMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPPrimitiveValueMatcher_ValueDesc(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "valueDesc"
		   });		
		addAnnotation
		  (pRangeMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PRangeMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPRangeMatcher_LowerBound(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "lowerBound"
		   });		
		addAnnotation
		  (getPRangeMatcher_UpperBound(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "upperBound"
		   });		
		addAnnotation
		  (pSimpleMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PSimpleMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (pSingleExpressionMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PSingleExpressionMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPSingleExpressionMatcher_Expression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "expression"
		   });		
		addAnnotation
		  (pSubSetMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PSubSetMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPSubSetMatcher_Items(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "items"
		   });		
		addAnnotation
		  (pSuperSetMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PSuperSetMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPSuperSetMatcher_Items(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "items"
		   });		
		addAnnotation
		  (pTemplateEClass, 
		   source, 
		   new String[] {
			 "name", "PTemplate",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPTemplate_TemplateID(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "templateID"
		   });		
		addAnnotation
		  (pTemplateMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PTemplateMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPTemplateMatcher_IfPresent(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ifPresent"
		   });		
		addAnnotation
		  (getPTemplateMatcher_LengthRestriction(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lengthRestriction"
		   });		
		addAnnotation
		  (pTemplateParEClass, 
		   source, 
		   new String[] {
			 "name", "PTemplatePar",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPTemplatePar_Basetype(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "basetype"
		   });		
		addAnnotation
		  (getPTemplatePar_Template(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "template"
		   });		
		addAnnotation
		  (pTemplateRefMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PTemplateRefMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPTemplateRefMatcher_Parameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameters"
		   });		
		addAnnotation
		  (getPTemplateRefMatcher_ExternalTemplateName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "externalTemplateName"
		   });		
		addAnnotation
		  (pTemplateRefMatcherParEClass, 
		   source, 
		   new String[] {
			 "name", "PTemplateRefMatcherPar",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPTemplateRefMatcherPar_Matcher(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "matcher"
		   });		
		addAnnotation
		  (pUnaryExpressionEClass, 
		   source, 
		   new String[] {
			 "name", "PUnaryExpression",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPUnaryExpression_Primary(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "primary"
		   });		
		addAnnotation
		  (getPUnaryExpression_Operator(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operator"
		   });		
		addAnnotation
		  (pValueListMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PValueListMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPValueListMatcher_Items(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "items"
		   });		
		addAnnotation
		  (pValueReferenceFragmentEClass, 
		   source, 
		   new String[] {
			 "name", "PValueReferenceFragment",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPValueReferenceFragment_FieldName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fieldName"
		   });		
		addAnnotation
		  (getPValueReferenceFragment_IndexMatcher(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "indexMatcher"
		   });		
		addAnnotation
		  (pValueReferenceMatcherEClass, 
		   source, 
		   new String[] {
			 "name", "PValueReferenceMatcher",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPValueReferenceMatcher_Fragments(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fragments"
		   });		
		addAnnotation
		  (getPValueReferenceMatcher_RefName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "refName"
		   });		
		addAnnotation
		  (getPValueReferenceMatcher_RefType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "refType"
		   });		
		addAnnotation
		  (valueReferenceTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "ValueReferenceType"
		   });		
		addAnnotation
		  (valueReferenceTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ValueReferenceType:Object",
			 "baseType", "ValueReferenceType"
		   });
	}

} //FpbtemplatePackageImpl
