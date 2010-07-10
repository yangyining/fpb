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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PImportElement;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.PModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PModule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl#getImportElements <em>Import Elements</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl#getConstants <em>Constants</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl#getTemplates <em>Templates</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl#getModulePars <em>Module Pars</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl#getEnumSets <em>Enum Sets</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl#getFactoryJavaClass <em>Factory Java Class</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl#getModuleJavaClass <em>Module Java Class</em>}</li>
 *   <li>{@link com.fineqt.fpb.lib.model.fpbmodule.impl.PModuleImpl#getTypeEvFactoryJavaClass <em>Type Ev Factory Java Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PModuleImpl extends PEncodedElementImpl implements PModule {
	/**
     * The cached value of the '{@link #getImportElements() <em>Import Elements</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImportElements()
     * @generated
     * @ordered
     */
	protected EList<PImportElement> importElements;

	/**
     * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypes()
     * @generated
     * @ordered
     */
	protected EList<PType> types;

	/**
     * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConstants()
     * @generated
     * @ordered
     */
	protected EList<PConstant> constants;

	/**
     * The cached value of the '{@link #getTemplates() <em>Templates</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTemplates()
     * @generated
     * @ordered
     */
	protected EList<PTemplate> templates;

	/**
     * The cached value of the '{@link #getModulePars() <em>Module Pars</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getModulePars()
     * @generated
     * @ordered
     */
	protected EList<PModulePar> modulePars;

	/**
     * The cached value of the '{@link #getEnumSets() <em>Enum Sets</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEnumSets()
     * @generated
     * @ordered
     */
	protected EList<PEnumSet> enumSets;

/**
     * The default value of the '{@link #getFactoryJavaClass() <em>Factory Java Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFactoryJavaClass()
     * @generated
     * @ordered
     */
	protected static final String FACTORY_JAVA_CLASS_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getFactoryJavaClass() <em>Factory Java Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFactoryJavaClass()
     * @generated
     * @ordered
     */
	protected String factoryJavaClass = FACTORY_JAVA_CLASS_EDEFAULT;

	/**
     * The default value of the '{@link #getModuleJavaClass() <em>Module Java Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getModuleJavaClass()
     * @generated
     * @ordered
     */
	protected static final String MODULE_JAVA_CLASS_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getModuleJavaClass() <em>Module Java Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getModuleJavaClass()
     * @generated
     * @ordered
     */
	protected String moduleJavaClass = MODULE_JAVA_CLASS_EDEFAULT;

	/**
     * The default value of the '{@link #getTypeEvFactoryJavaClass() <em>Type Ev Factory Java Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeEvFactoryJavaClass()
     * @generated
     * @ordered
     */
	protected static final String TYPE_EV_FACTORY_JAVA_CLASS_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getTypeEvFactoryJavaClass() <em>Type Ev Factory Java Class</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeEvFactoryJavaClass()
     * @generated
     * @ordered
     */
	protected String typeEvFactoryJavaClass = TYPE_EV_FACTORY_JAVA_CLASS_EDEFAULT;

	//	private PModuleAdapter adapter = new PModuleAdapter();
//	
//	private Map<Integer, PType> typeMap = new HashMap<Integer, PType>();
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected PModuleImpl() {
		super();
//		eAdapters().add(adapter);
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpbmodulePackage.Literals.PMODULE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<PType> getTypes() {
        if (types == null) {
            types = new EObjectContainmentWithInverseEList<PType>(PType.class, this, FpbmodulePackage.PMODULE__TYPES, FpbmodulePackage.PTYPE__PMODULE);
        }
        return types;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<PConstant> getConstants() {
        if (constants == null) {
            constants = new EObjectContainmentWithInverseEList<PConstant>(PConstant.class, this, FpbmodulePackage.PMODULE__CONSTANTS, FpbmodulePackage.PCONSTANT__PMODULE);
        }
        return constants;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<PTemplate> getTemplates() {
        if (templates == null) {
            templates = new EObjectContainmentEList<PTemplate>(PTemplate.class, this, FpbmodulePackage.PMODULE__TEMPLATES);
        }
        return templates;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<PModulePar> getModulePars() {
        if (modulePars == null) {
            modulePars = new EObjectContainmentWithInverseEList<PModulePar>(PModulePar.class, this, FpbmodulePackage.PMODULE__MODULE_PARS, FpbmodulePackage.PMODULE_PAR__PMODULE);
        }
        return modulePars;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<PImportElement> getImportElements() {
        if (importElements == null) {
            importElements = new EObjectContainmentWithInverseEList<PImportElement>(PImportElement.class, this, FpbmodulePackage.PMODULE__IMPORT_ELEMENTS, FpbmodulePackage.PIMPORT_ELEMENT__PMODULE);
        }
        return importElements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<PEnumSet> getEnumSets() {
        if (enumSets == null) {
            enumSets = new EObjectContainmentWithInverseEList<PEnumSet>(PEnumSet.class, this, FpbmodulePackage.PMODULE__ENUM_SETS, FpbmodulePackage.PENUM_SET__PMODULE);
        }
        return enumSets;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getFactoryJavaClass() {
        return factoryJavaClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFactoryJavaClass(String newFactoryJavaClass) {
        String oldFactoryJavaClass = factoryJavaClass;
        factoryJavaClass = newFactoryJavaClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PMODULE__FACTORY_JAVA_CLASS, oldFactoryJavaClass, factoryJavaClass));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getModuleJavaClass() {
        return moduleJavaClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setModuleJavaClass(String newModuleJavaClass) {
        String oldModuleJavaClass = moduleJavaClass;
        moduleJavaClass = newModuleJavaClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PMODULE__MODULE_JAVA_CLASS, oldModuleJavaClass, moduleJavaClass));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getTypeEvFactoryJavaClass() {
        return typeEvFactoryJavaClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeEvFactoryJavaClass(String newTypeEvFactoryJavaClass) {
        String oldTypeEvFactoryJavaClass = typeEvFactoryJavaClass;
        typeEvFactoryJavaClass = newTypeEvFactoryJavaClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpbmodulePackage.PMODULE__TYPE_EV_FACTORY_JAVA_CLASS, oldTypeEvFactoryJavaClass, typeEvFactoryJavaClass));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PMODULE__IMPORT_ELEMENTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getImportElements()).basicAdd(otherEnd, msgs);
            case FpbmodulePackage.PMODULE__TYPES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypes()).basicAdd(otherEnd, msgs);
            case FpbmodulePackage.PMODULE__CONSTANTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstants()).basicAdd(otherEnd, msgs);
            case FpbmodulePackage.PMODULE__MODULE_PARS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getModulePars()).basicAdd(otherEnd, msgs);
            case FpbmodulePackage.PMODULE__ENUM_SETS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEnumSets()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FpbmodulePackage.PMODULE__IMPORT_ELEMENTS:
                return ((InternalEList<?>)getImportElements()).basicRemove(otherEnd, msgs);
            case FpbmodulePackage.PMODULE__TYPES:
                return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
            case FpbmodulePackage.PMODULE__CONSTANTS:
                return ((InternalEList<?>)getConstants()).basicRemove(otherEnd, msgs);
            case FpbmodulePackage.PMODULE__TEMPLATES:
                return ((InternalEList<?>)getTemplates()).basicRemove(otherEnd, msgs);
            case FpbmodulePackage.PMODULE__MODULE_PARS:
                return ((InternalEList<?>)getModulePars()).basicRemove(otherEnd, msgs);
            case FpbmodulePackage.PMODULE__ENUM_SETS:
                return ((InternalEList<?>)getEnumSets()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FpbmodulePackage.PMODULE__IMPORT_ELEMENTS:
                return getImportElements();
            case FpbmodulePackage.PMODULE__TYPES:
                return getTypes();
            case FpbmodulePackage.PMODULE__CONSTANTS:
                return getConstants();
            case FpbmodulePackage.PMODULE__TEMPLATES:
                return getTemplates();
            case FpbmodulePackage.PMODULE__MODULE_PARS:
                return getModulePars();
            case FpbmodulePackage.PMODULE__ENUM_SETS:
                return getEnumSets();
            case FpbmodulePackage.PMODULE__FACTORY_JAVA_CLASS:
                return getFactoryJavaClass();
            case FpbmodulePackage.PMODULE__MODULE_JAVA_CLASS:
                return getModuleJavaClass();
            case FpbmodulePackage.PMODULE__TYPE_EV_FACTORY_JAVA_CLASS:
                return getTypeEvFactoryJavaClass();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FpbmodulePackage.PMODULE__IMPORT_ELEMENTS:
                getImportElements().clear();
                getImportElements().addAll((Collection<? extends PImportElement>)newValue);
                return;
            case FpbmodulePackage.PMODULE__TYPES:
                getTypes().clear();
                getTypes().addAll((Collection<? extends PType>)newValue);
                return;
            case FpbmodulePackage.PMODULE__CONSTANTS:
                getConstants().clear();
                getConstants().addAll((Collection<? extends PConstant>)newValue);
                return;
            case FpbmodulePackage.PMODULE__TEMPLATES:
                getTemplates().clear();
                getTemplates().addAll((Collection<? extends PTemplate>)newValue);
                return;
            case FpbmodulePackage.PMODULE__MODULE_PARS:
                getModulePars().clear();
                getModulePars().addAll((Collection<? extends PModulePar>)newValue);
                return;
            case FpbmodulePackage.PMODULE__ENUM_SETS:
                getEnumSets().clear();
                getEnumSets().addAll((Collection<? extends PEnumSet>)newValue);
                return;
            case FpbmodulePackage.PMODULE__FACTORY_JAVA_CLASS:
                setFactoryJavaClass((String)newValue);
                return;
            case FpbmodulePackage.PMODULE__MODULE_JAVA_CLASS:
                setModuleJavaClass((String)newValue);
                return;
            case FpbmodulePackage.PMODULE__TYPE_EV_FACTORY_JAVA_CLASS:
                setTypeEvFactoryJavaClass((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case FpbmodulePackage.PMODULE__IMPORT_ELEMENTS:
                getImportElements().clear();
                return;
            case FpbmodulePackage.PMODULE__TYPES:
                getTypes().clear();
                return;
            case FpbmodulePackage.PMODULE__CONSTANTS:
                getConstants().clear();
                return;
            case FpbmodulePackage.PMODULE__TEMPLATES:
                getTemplates().clear();
                return;
            case FpbmodulePackage.PMODULE__MODULE_PARS:
                getModulePars().clear();
                return;
            case FpbmodulePackage.PMODULE__ENUM_SETS:
                getEnumSets().clear();
                return;
            case FpbmodulePackage.PMODULE__FACTORY_JAVA_CLASS:
                setFactoryJavaClass(FACTORY_JAVA_CLASS_EDEFAULT);
                return;
            case FpbmodulePackage.PMODULE__MODULE_JAVA_CLASS:
                setModuleJavaClass(MODULE_JAVA_CLASS_EDEFAULT);
                return;
            case FpbmodulePackage.PMODULE__TYPE_EV_FACTORY_JAVA_CLASS:
                setTypeEvFactoryJavaClass(TYPE_EV_FACTORY_JAVA_CLASS_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case FpbmodulePackage.PMODULE__IMPORT_ELEMENTS:
                return importElements != null && !importElements.isEmpty();
            case FpbmodulePackage.PMODULE__TYPES:
                return types != null && !types.isEmpty();
            case FpbmodulePackage.PMODULE__CONSTANTS:
                return constants != null && !constants.isEmpty();
            case FpbmodulePackage.PMODULE__TEMPLATES:
                return templates != null && !templates.isEmpty();
            case FpbmodulePackage.PMODULE__MODULE_PARS:
                return modulePars != null && !modulePars.isEmpty();
            case FpbmodulePackage.PMODULE__ENUM_SETS:
                return enumSets != null && !enumSets.isEmpty();
            case FpbmodulePackage.PMODULE__FACTORY_JAVA_CLASS:
                return FACTORY_JAVA_CLASS_EDEFAULT == null ? factoryJavaClass != null : !FACTORY_JAVA_CLASS_EDEFAULT.equals(factoryJavaClass);
            case FpbmodulePackage.PMODULE__MODULE_JAVA_CLASS:
                return MODULE_JAVA_CLASS_EDEFAULT == null ? moduleJavaClass != null : !MODULE_JAVA_CLASS_EDEFAULT.equals(moduleJavaClass);
            case FpbmodulePackage.PMODULE__TYPE_EV_FACTORY_JAVA_CLASS:
                return TYPE_EV_FACTORY_JAVA_CLASS_EDEFAULT == null ? typeEvFactoryJavaClass != null : !TYPE_EV_FACTORY_JAVA_CLASS_EDEFAULT.equals(typeEvFactoryJavaClass);
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (factoryJavaClass: ");
        result.append(factoryJavaClass);
        result.append(", moduleJavaClass: ");
        result.append(moduleJavaClass);
        result.append(", typeEvFactoryJavaClass: ");
        result.append(typeEvFactoryJavaClass);
        result.append(')');
        return result.toString();
    }

//	@Override
//	public PType getType(int typeID) {
//		return typeMap.get(typeID);
//	}
//
//	private class PModuleAdapter extends AdapterImpl {
//
//		@SuppressWarnings("unchecked")
//		@Override
//		public void notifyChanged(Notification msg) {
//			PType typeObj;
//			Collection<PType> typeObjs;
//			switch(msg.getFeatureID(PModule.class)){
//			case FpbmodulePackage.PMODULE__TYPES:
//				switch(msg.getEventType()) {
//				case Notification.ADD:
//					typeObj = (PType)msg.getNewValue();
//					typeMap.put(typeObj.getTypeID(), typeObj);
//					break;
//				case Notification.ADD_MANY:
//					typeObjs = (Collection<PType>)msg.getNewValue();
//					for (PType type : typeObjs) {
//						typeMap.put(type.getTypeID(), type);
//					}
//					break;
//				case Notification.REMOVE:
//					typeObj = (PType)msg.getOldValue();
//					typeMap.remove(typeObj.getTypeID());
//					break;
//				case Notification.REMOVE_MANY:
//					typeObjs = (Collection<PType>)msg.getOldValue();
//					for (PType type : typeObjs) {
//						typeMap.remove(type.getTypeID());
//					}
//					break;
//				}
//				break;
//			}
//			super.notifyChanged(msg);
//		}
//		
//	}
	
	
} //PModuleImpl
