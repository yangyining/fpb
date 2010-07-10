/****************************************************************
Fine Packet Builder, copyright (C) 2007-2009 fineqt.com

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
GNU General Public License for more details at gnu.org.
******************************************************************/
package com.fineqt.fpb.lib.grammer;

import static com.fineqt.fpb.lib.grammer.mv.SymbolElement.getStartPosition;

import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.fineqt.fpb.lib.api.value.ICharstringValue;
import com.fineqt.fpb.lib.builtin.BuiltinFactory;
import com.fineqt.fpb.lib.grammer.mv.ContainerTypeSymbol;
import com.fineqt.fpb.lib.grammer.mv.EntityConstantSymbol;
import com.fineqt.fpb.lib.grammer.mv.EntityEnumSetSymbol;
import com.fineqt.fpb.lib.grammer.mv.EntityModuleParSymbol;
import com.fineqt.fpb.lib.grammer.mv.EnumTypeItemSymbol;
import com.fineqt.fpb.lib.grammer.mv.EnumeratedTypeSymbol;
import com.fineqt.fpb.lib.grammer.mv.FieldSymbol;
import com.fineqt.fpb.lib.grammer.mv.ImportTypeSymbol;
import com.fineqt.fpb.lib.grammer.mv.ListItemSymbol;
import com.fineqt.fpb.lib.grammer.mv.ListTypeSymbol;
import com.fineqt.fpb.lib.grammer.mv.ModuleElementSymbolBase;
import com.fineqt.fpb.lib.grammer.mv.ModuleSymbol;
import com.fineqt.fpb.lib.grammer.mv.ParserHelper;
import com.fineqt.fpb.lib.grammer.mv.SubTypeSymbol;
import com.fineqt.fpb.lib.grammer.mv.TypeSymbolBase;
import com.fineqt.fpb.lib.grammer.mv.ValueReferenceSymbol;
import com.fineqt.fpb.lib.meta.context.PModuleParsingContext;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmoduleFactory;
import com.fineqt.fpb.lib.model.fpbmodule.PArgumentGroup;
import com.fineqt.fpb.lib.model.fpbmodule.PBooleanArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PCharstringArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PCompoundConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumItem;
import com.fineqt.fpb.lib.model.fpbmodule.PField;
import com.fineqt.fpb.lib.model.fpbmodule.PIdentifierArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PIntegerArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PListArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PListConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PListItem;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PProperty;
import com.fineqt.fpb.lib.model.fpbmodule.PPropertyList;
import com.fineqt.fpb.lib.model.fpbmodule.PRecord;
import com.fineqt.fpb.lib.model.fpbmodule.PRecordOf;
import com.fineqt.fpb.lib.model.fpbmodule.PSet;
import com.fineqt.fpb.lib.model.fpbmodule.PSetOf;
import com.fineqt.fpb.lib.model.fpbmodule.PSubType;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeReferenceArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PUnion;
import com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplateFactory;
import com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem;
import com.fineqt.fpb.lib.model.fpbtemplate.PExpressionMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PNotUsedMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PPrimitiveValueMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueListMatcher;
import com.fineqt.fpb.lib.modelview.ConstantMV;
import com.fineqt.fpb.lib.modelview.EnumSetMV;
import com.fineqt.fpb.lib.modelview.FieldMV;
import com.fineqt.fpb.lib.modelview.ModuleElementMV;
import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.modelview.ModuleParMV;
import com.fineqt.fpb.lib.modelview.TypeMV;
import com.fineqt.fpb.lib.util.ParserException;

public class T34fpbHelper implements ParserHelper {
	private static FpbtemplateFactory tmpfactory = FpbtemplateFactory.eINSTANCE;
	private static FpbmoduleFactory mfactory = FpbmoduleFactory.eINSTANCE;
	
	public final static int CREATING_SYMBOL = 1;
	public final static int CREATING_MODEL = 2;
	
	private PModuleParsingContext parsingContext;
	private T34fpbParser parser;
	private List<String> grammerErrorMsgs = new ArrayList<String>();
	private ModuleMV moduleMV;
	private int creatingMode = CREATING_MODEL;
	private String resourceName;
	//正在定义中的可被引用模块元素（template, const, modulepar）
	private ModuleElementSymbolBase moduleElementInDefine;
	
	private T34fpbHelper(PModuleParsingContext parsingContext, T34fpbParser parser) {
	    this.parsingContext = parsingContext;
		this.parser = parser;
	}
	
	public static T34fpbHelper createT34fpbHelper(Reader moduleReader, PModuleParsingContext cxt, 
            String resourceName) throws ParserException {
        CharStream input;
        try {
            input = new ANTLRReaderStream(moduleReader);
        } catch (IOException e1) {
            throw new ParserException(e1);
        }
        T34fpbLexer lexer = new T34fpbLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        T34fpbParser parser = new T34fpbParser(tokens);
        T34fpbHelper helper = new T34fpbHelper(cxt, parser);
        helper.setResourceName(resourceName);
        parser.setHelper(helper);
	    return helper;
	}
	
	public void prepareCreatingSymbol() {
		//Mode
		creatingMode = CREATING_SYMBOL;
		//ModuleMV
		ModuleSymbol newModule = new ModuleSymbol(parsingContext, this);
		//加入Context
		parsingContext.getResultList().add(newModule);
        moduleMV = newModule;
        //符号生成的准备
		newModule.prepareCreatingSymbol();
	}
	
	public void createNoImportElementSymbol() throws ParserException {
	    assert creatingMode == CREATING_SYMBOL;
	    //编译模块文件（第一遍）
	    try {
            parser.module();
        } catch (RecognitionException e) {
            throw new ParserException(e, getGrammerErrorMsgs());
        }
        if (hasError()) {
            throw new ParserException(getGrammerErrorMsgs());
        }
	    //生成非Import的元素Symbol，并且递归调用被Import的模块
	    getModuleSymbol().createNoImportElementSymbol();
	}
	
	public void createImportElemenSymbol() {
        assert creatingMode == CREATING_SYMBOL;
	    //生成Import元素
	    getModuleSymbol().createImportElemenSymbol();
	}
	
	public void resolveReference() {
        assert creatingMode == CREATING_SYMBOL;
	    //解决各种元素引用
	    getModuleSymbol().resolveReference();
	}
	
	public void validateModuleElements() {
        assert creatingMode == CREATING_SYMBOL;
	    //验证模型元素完整性
	    getModuleSymbol().validateModuleElements();
	}
	
	public void prepareCreatingModuleModel() {
		//Mode
		creatingMode = CREATING_MODEL;
		
		getModuleSymbol().prepareCreatingModuleModel();
	}
	
	public void createModuleModel() throws ParserException {
        assert creatingMode == CREATING_MODEL;
        //编译模块文件（第二遍）
        try {
            parser.module();
        } catch (RecognitionException e) {
            throw new ParserException(e, getGrammerErrorMsgs());
        }
        if (hasError()) {
            throw new ParserException(getGrammerErrorMsgs());
        }
	}
	
	public void initCreatedModuleModel() throws ParserException {
        assert creatingMode == CREATING_MODEL;
		//模块的初始化
		getModuleSymbol().initModel(this);
        if (hasError()) {
            throw new ParserException(getGrammerErrorMsgs());
        }
	}
	
	@Override
	public ModuleSymbol getModuleSymbol() {
		if (moduleMV instanceof ModuleSymbol)
			return (ModuleSymbol)moduleMV;
		return null;
	}

	public PModule getPModule() {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		return simpleModule.getModel();
	}
	
	public void addErrorMsg(String startPos, String code, Object... msgArgs) {
		String msg = "";
		if (resourceName != null) {
			msg += "["+resourceName+"]";
		} else if (moduleMV != null) {
			msg += "["+moduleMV.getModuleName()+"]";
		}
		if (startPos != null) {
			msg += startPos;
		}
		msg += " " + code + ";" + 
			MessageFormat.format(MetaException.code2msgMap.get(code), msgArgs);
		grammerErrorMsgs.add(msg);
	}
	
	public void addErrorMsg(String msgContent) {
		String msg = "";
		if (resourceName != null) {
			msg += "["+resourceName+"]";
		} else if (moduleMV != null) {
			msg += "["+moduleMV.getModuleName()+"]";
		}
		msg += msgContent;
		grammerErrorMsgs.add(msg);
	}
	
	@Override
	public boolean hasError() {
		return grammerErrorMsgs.size() > 0;
	}

	public boolean isCreatingSymbol() {
		return creatingMode == CREATING_SYMBOL;
	}
	
	public boolean isCreatingModel() {
		return creatingMode == CREATING_MODEL;
	}
	
	public boolean nextTokenIsEnumeratedItemId() {
		String typename = parser.peekTypeScope();
		if (typename == null)
			return false;
		TypeMV type = getModuleMV().pTypeMV(typename);
		if (type == null || type.getTypeClass() != TypeClass.ENUMERATED) {
			return false;
		} 
		Token nextToken = parser.getTokenStream().LT(1);
		return type.getEnumTypeItemMV(nextToken.getText()) != null;
	}
	
	public void moduleRule(Token startToken, String name) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		PModule pmodule = simpleModule.getModel();
		if (isCreatingSymbol()) {
			simpleModule.setName(name);
			simpleModule.setStartToken(startToken);
		} else {
			assert pmodule != null;
			pmodule.setName(name);
		}
	}
	
	public ContainerTypeSymbol structDefBodyRule(Token startToken, TypeClass typeClass, String typeName) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		PModule pmodule = simpleModule.getModel();
		if (isCreatingSymbol()) {
			switch(typeClass) {
			case RECORD:
			case SET:
				ContainerTypeSymbol type = new ContainerTypeSymbol(moduleMV, 
						typeName, typeClass);
				type.setStartToken(startToken);
				simpleModule.addTypeMV(type);
				return type;
			}
			assert false;
			return null;
		} else {
			ContainerTypeSymbol type = (ContainerTypeSymbol)simpleModule.pTypeMV(typeName);			
			switch(typeClass) {
			case RECORD:
				PRecord record = mfactory.createPRecord();
				record.setName(typeName);
				pmodule.getTypes().add(record);
				type.setModel(record);
				break;
			case SET:
				PSet set = mfactory.createPSet();
				set.setName(typeName);
				pmodule.getTypes().add(set);
				type.setModel(set);
				break;
			default:
				assert false;
				break;
			}
			return type;
		}
	}
	
	public void structFieldDefRule(Token startToken, Object ownerTypeObj, 
			String fieldTypeName, String fieldName, boolean optional, PTypeConstraint subTypeSpec) {
		ContainerTypeSymbol ownerType = (ContainerTypeSymbol)ownerTypeObj;
		if (isCreatingSymbol()) {
			FieldSymbol field = new FieldSymbol(fieldName, ownerType, 
					optional, fieldTypeName);
			field.setStartToken(startToken);
			ownerType.addFieldMV(field);
		} else {
			PField field = mfactory.createPField();
			field.setName(fieldName);
			field.setPtypeName(fieldTypeName);
			field.setOptional(optional);
			field.setConstraint(subTypeSpec);
			FieldSymbol fieldSymbol = (FieldSymbol)ownerType.getFieldMV(fieldName);
			fieldSymbol.setModel(field);
		}
	}

	public ContainerTypeSymbol unionDefBodyRule(Token startToken, String typeName) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingSymbol()) {
			ContainerTypeSymbol type = new ContainerTypeSymbol(moduleMV, 
					typeName, TypeClass.UNION);
			type.setStartToken(startToken);
			simpleModule.addTypeMV(type);
			return type;
		} else {
			ContainerTypeSymbol type = (ContainerTypeSymbol)simpleModule.pTypeMV(typeName);
			PUnion union = mfactory.createPUnion();
			union.setName(typeName);
			type.setModel(union);
			return type;
		}
	}

	public void unionFieldDefRule(Token startToken, Object ownerTypeObj, 
			String fieldTypeName, String fieldName, PTypeConstraint subTypeSpec) {
		ContainerTypeSymbol ownerType = (ContainerTypeSymbol)ownerTypeObj;
		if (isCreatingSymbol()) {
			FieldSymbol field = new FieldSymbol(fieldName, ownerType, 
					false, fieldTypeName);
			field.setStartToken(startToken);
			ownerType.addFieldMV(field);
		} else {
			FieldSymbol fieldSymbol = (FieldSymbol)ownerType.getFieldMV(fieldName); 
			PField field = mfactory.createPField();
			field.setName(fieldName);
			field.setPtypeName(fieldTypeName);
			field.setConstraint(subTypeSpec);
			fieldSymbol.setModel(field);
		}
	}
	
	public ListTypeSymbol structOfDefBodyRule(Token startToken, TypeClass typeClass, 
			String typeName, String itemTypeName, PTypeConstraint lenCons, 
			PTypeConstraint itemTypeSpec) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingSymbol()) {
			ListTypeSymbol type = new ListTypeSymbol(moduleMV, typeName, typeClass, itemTypeName);
			simpleModule.addTypeMV(type);
			return type;
		} else {
			//Type
			ListTypeSymbol type = (ListTypeSymbol)simpleModule.pTypeMV(typeName);
			switch(typeClass) {
			case RECORDOF:
				PRecordOf recordOf = mfactory.createPRecordOf();
				recordOf.setName(typeName);
				recordOf.setConstraint(lenCons);
				type.setModel(recordOf);
				break;
			case SETOF:
				PSetOf setOf = mfactory.createPSetOf();
				setOf.setName(typeName);
				setOf.setConstraint(lenCons);
				type.setModel(setOf);
				break;
			default:
				assert false;
				break;
			}
			//Item
			PListItem itemModel = mfactory.createPListItem();
			itemModel.setPtypeName(itemTypeName);
			itemModel.setConstraint(itemTypeSpec);
			type.getListItem().setModel(itemModel);
			return type;
		}
		
	}
	
	public EnumeratedTypeSymbol enumDefBodyRule(Token startToken, String typeName) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingSymbol()) {
			EnumeratedTypeSymbol type = new EnumeratedTypeSymbol(simpleModule, typeName, 
					TypeClass.ENUMERATED);
			type.setStartToken(startToken);
			simpleModule.addTypeMV(type);
			return type;
		} else {
			EnumeratedTypeSymbol type = (EnumeratedTypeSymbol)simpleModule.pTypeMV(typeName);
			return type;
		}
	}
	
	public void enumerationRule(Token startToken, String enumName, String minus, 
			String number, EnumeratedTypeSymbol enumType) {
		if (isCreatingSymbol()) {
			if (enumType != null) {
				EnumTypeItemSymbol item = new EnumTypeItemSymbol(enumName, minus, number);
				item.setStartToken(startToken);
				enumType.addItem(item);
			}
		}
	}
	
	public SubTypeSymbol subTypeDefRule(Token startToken, String typeName, String baseTypeName, 
			PTypeConstraint subTypeSpec) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingSymbol()) {
			SubTypeSymbol subtype = new SubTypeSymbol(simpleModule, baseTypeName, typeName);
			subtype.setStartToken(startToken);
			simpleModule.addTypeMV(subtype);
			return subtype;
		} else {
			SubTypeSymbol subtypeSymbol = (SubTypeSymbol)simpleModule.pTypeMV(typeName); 
			PSubType subtype = mfactory.createPSubType();
			subtype.setName(typeName);
			subtype.setSuperTypeName(baseTypeName);
			subtype.setConstraint(subTypeSpec);
			subtypeSymbol.setModel(subtype);
			return subtypeSymbol;
		}
	}
	
	public EntityEnumSetSymbol enumSetDefRule(Token startToken, String setName, 
			String baseTypeName, List<PEnumItem> enumList) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingSymbol()) {
			EntityEnumSetSymbol enumSet = new EntityEnumSetSymbol(simpleModule, 
					setName, baseTypeName);
			enumSet.setStartToken(startToken);
			simpleModule.addEnumSetMV(enumSet);
			return enumSet;
		} else {
			EntityEnumSetSymbol enumSetSymbol = 
				(EntityEnumSetSymbol)simpleModule.pEnumSetMV(setName);
			if (enumSetSymbol == null) {
				return null;
			}
			PEntityEnumSet enumSet = mfactory.createPEntityEnumSet();
			enumSet.setName(setName);
			enumSet.setBaseTypeName(baseTypeName);
			//items
			for (PEnumItem enumItem : enumList) {
				enumSet.getEnumItems().add(enumItem);
			}
			enumSetSymbol.setModel(enumSet);
			return enumSetSymbol;
		}
	}
	
	public void enumItemRule(Token startToken, List<PEnumItem> enumList, String itemName, 
			PTypeConstraint typeCons) {
		if (isCreatingModel()) {
			PEnumItem item = mfactory.createPEnumItem();
			item.setName(itemName);
			item.setCond(typeCons);
			enumList.add(item);
		}
	}
	
	public void encodeAttribRule(Token startToken, Object targetElement, List<String> ids, 
			String strText) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingModel()) {
			EncodingType encode = EncodingType.get(strText);
			if (encode == null) {
				addErrorMsg(getStartPosition(startToken), 
						MetaException.CODE.WRONG_ENCODE_LITERAL_ERROR, 
						strText);
				return;
			}
			//moduleDef
			if (targetElement instanceof ModuleSymbol) {
				PModule module = ((ModuleSymbol)targetElement).getModel();
				//Module
				if (ids == null || ids.size() == 0) {
					module.setEncode(encode);
				//Type(排除Import类型)
				} else {
					//设置encode
					for (String typeName : ids) {
						TypeMV type = simpleModule.pTypeMV(typeName);
						if (type == null || type.isImport()) {
							addErrorMsg(getStartPosition(startToken), 
									MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
									typeName, simpleModule.getModuleName());
							continue;
						}
						TypeSymbolBase symbolType = (TypeSymbolBase)type;
						symbolType.getTypeModel().setEncode(encode);
					}
				}
			//typeDef
			} else if (targetElement instanceof TypeSymbolBase) {
				TypeSymbolBase symbolType = (TypeSymbolBase)targetElement;
				//Type
				if (ids == null || ids.size() == 0) {
					//设置encode
					symbolType.getTypeModel().setEncode(encode);
				//Field
				} else {
					if (symbolType instanceof ContainerTypeSymbol) {
						for (int i = 0; i < ids.size(); i++) {
							String fieldName = ids.get(i);
							//设置encode
							ContainerTypeSymbol containerType = (ContainerTypeSymbol)symbolType;
							FieldSymbol field = (FieldSymbol)containerType.getFieldMV(fieldName);
							if (field == null) {
								addErrorMsg(getStartPosition(startToken), 
										MetaException.CODE.FIELD_NOT_FOUND_ERROR,
										fieldName, symbolType.getFullName());
								continue;
							}
							field.getModel().setEncode(encode);
						}
					} else {
						addErrorMsg(getStartPosition(startToken), 
								MetaException.CODE.MUST_CONTAINER_TYPE_ERROR,
								symbolType.getFullName());
					}
				}
			//importDef
			} else if (targetElement instanceof List<?>) {
				@SuppressWarnings("unchecked")
				List<ModuleElementMV> elements = (List<ModuleElementMV>)targetElement;
				//All Type
				if (ids == null || ids.size() == 0) {
					for (ModuleElementMV element : elements) {
						//Type
						if (element instanceof ImportTypeSymbol) {
							ImportTypeSymbol symbol = (ImportTypeSymbol)element;
							symbol.getModel().setEncode(encode);
						}
					}
				//Special Type
				} else {
					Set<String> idSet = new HashSet<String>(ids);
					for (ModuleElementMV element : elements) {
						if (idSet.contains(element.getName())) {
							if (element instanceof ImportTypeSymbol) {
								ImportTypeSymbol symbol = (ImportTypeSymbol)element;
								symbol.getModel().setEncode(encode);
							}
							idSet.remove(element.getName());
						}
						if (idSet.size() == 0) {
							break;
						}
					}
				}
			}
		}
	}

	public void variantAttribRule1(Token startToken, Object targetElement, List<String> ids) {
		if (isCreatingModel()) {
			//moduleDef
			if (targetElement instanceof ModuleSymbol) {
				//压入属性的目标类型(当类型唯一时)
				if (ids != null && ids.size() == 1) {
					parser.setTopTypeScope(ids.get(0));
				}
			//typeDef
			} else if (targetElement instanceof TypeSymbolBase) {
				TypeSymbolBase symbolType = (TypeSymbolBase)targetElement;
				//压入属性的目标类型(为类型时)
				if (ids == null || ids.size() == 0) {
					parser.setTopTypeScope(symbolType.getFullName());
				//压入属性的目标类型(当字段唯一时)
				} else if (ids.size() == 1) {
					if (symbolType instanceof ContainerTypeSymbol) {
						ContainerTypeSymbol containerType = (ContainerTypeSymbol)symbolType;
						String fieldName = ids.get(0);
						FieldSymbol field = (FieldSymbol)containerType.getFieldMV(fieldName);
						if (field != null) {
							parser.setTopTypeScope(field.getFieldTypeMV().getFullName());
						}
					} else if (symbolType instanceof ListTypeSymbol) {
						ListTypeSymbol listType = (ListTypeSymbol)symbolType;
						TypeMV itemType = listType.getListItem().getItemTypeMV();
						if (itemType != null) {
							parser.setTopTypeScope(itemType.getFullName());
						}
					}
				}
			//importDef
			} else if (targetElement instanceof List<?>) {
				@SuppressWarnings("unchecked")
				List<ModuleElementMV> elements = (List<ModuleElementMV>)targetElement;
				//类型唯一
				if ((ids == null || ids.size() == 0) && elements.size() == 1) {
					ModuleElementMV element = elements.get(0);
					if (element instanceof ImportTypeSymbol) {
						parser.setTopTypeScope(element.getFullName());
					}
				//指定一个类型
				} else if (ids.size() == 1) {
					String targetName = ids.get(0);
					for (ModuleElementMV element : elements) {
						//Type
						if (element instanceof ImportTypeSymbol && 
								element.getName().equals(targetName)) {
							parser.setTopTypeScope(element.getFullName());
						}
					}
				}
			}
		}
	}
	
	public void variantAttribRule2(Token startToken, Object targetElement, List<String> ids,
			PPropertyList prpList) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingModel()) {
			//moduleDef
			if (targetElement instanceof ModuleSymbol) {
				//Module
				if (ids == null || ids.size() == 0) {
					simpleModule.setVariantPropertyList(prpList);
				//Type(排除Import类型)
				} else {
					for (String typeName : ids) {
						TypeMV type = simpleModule.pTypeMV(typeName);
						if (type == null || type.isImport()) {
							addErrorMsg(getStartPosition(startToken), 
									MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
									typeName, simpleModule.getModuleName());
							continue;
						}
						TypeSymbolBase symbolType = (TypeSymbolBase)type;
						symbolType.setVariantPropertyList(prpList);
					}
				}
			//typeDef
			} else if (targetElement instanceof TypeSymbolBase) {
				TypeSymbolBase symbolType = (TypeSymbolBase)targetElement;
				//Type
				if (ids == null || ids.size() == 0) {
					symbolType.setVariantPropertyList(prpList);
				//Field
				} else {
					if (symbolType instanceof ContainerTypeSymbol) {
						for (String fieldName : ids) {
							ContainerTypeSymbol containerType = (ContainerTypeSymbol)symbolType;
							FieldSymbol field = (FieldSymbol)containerType.getFieldMV(fieldName);
							if (field == null) {
								addErrorMsg(getStartPosition(startToken), 
										MetaException.CODE.FIELD_NOT_FOUND_ERROR,
										fieldName, symbolType.getFullName());
								continue;
							}
							field.setPropertyList(prpList);
						}
					} else if (symbolType instanceof ListTypeSymbol) {
						//与ID无关
						ListTypeSymbol listType = (ListTypeSymbol)symbolType;
						listType.getListItem().setPropertyList(prpList);
					} else {
						addErrorMsg(getStartPosition(startToken), 
								MetaException.CODE.MUST_CONTAINER_TYPE_ERROR,
								symbolType.getFullName());
					}
				}
			//importDef
			} else if (targetElement instanceof List<?>) {
				@SuppressWarnings("unchecked")
				List<ModuleElementMV> elements = (List<ModuleElementMV>)targetElement;
				//All Type
				if (ids == null || ids.size() == 0) {
					for (ModuleElementMV element : elements) {
						//Type
						if (element instanceof ImportTypeSymbol) {
							ImportTypeSymbol symbol = (ImportTypeSymbol)element;
							symbol.setVariantPropertyList(prpList);
						}
					}
				//Special Type
				} else {
					Set<String> idSet = new HashSet<String>(ids);
					for (ModuleElementMV element : elements) {
						if (idSet.contains(element.getName())) {
							if (element instanceof ImportTypeSymbol) {
								ImportTypeSymbol symbol = (ImportTypeSymbol)element;
								symbol.setVariantPropertyList(prpList);
							}
							idSet.remove(element.getName());
						}
						if (idSet.size() == 0) {
							break;
						}
					}
				}
			}
		}
	}
	
	public void runtimeAttribRule(Token startToken, Object targetElement, List<String> ids,
			SimplePropertyList prpList) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingModel()) {
			//moduleDef
			if (targetElement instanceof ModuleSymbol) {
				//Module
				if (ids == null || ids.size() == 0) {
					simpleModule.setRuntimePropertyList(prpList);
				//Type(排除Import类型)
				} else {
					for (String typeName : ids) {
						TypeMV type = simpleModule.pTypeMV(typeName);
						if (type == null || type.isImport()) {
							addErrorMsg(getStartPosition(startToken), 
									MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
									typeName, simpleModule.getModuleName());
							continue;
						}
						TypeSymbolBase symbolType = (TypeSymbolBase)type;
						symbolType.setRuntimePropertyList(prpList);
					}
				}
			//single element(type)
			} else if (targetElement instanceof ModuleElementSymbolBase) {
				ModuleElementSymbolBase symbolElement = (ModuleElementSymbolBase)targetElement;
				//Type
				if (ids == null || ids.size() == 0) {
					symbolElement.setRuntimePropertyList(prpList);
				}
				
			//element list(constant, modularPar)
			} else if (targetElement instanceof List<?>) {
				@SuppressWarnings("unchecked")
				List<ModuleElementMV> elements = (List<ModuleElementMV>)targetElement;
				//All Element
				if (ids == null || ids.size() == 0) {
					for (ModuleElementMV element : elements) {
						if (element instanceof ModuleElementSymbolBase) {
							ModuleElementSymbolBase symbol = (ModuleElementSymbolBase)element;
							symbol.setRuntimePropertyList(prpList);
						}
					}
				//Special Element
				} else {
					Set<String> idSet = new HashSet<String>(ids);
					for (ModuleElementMV element : elements) {
						if (idSet.contains(element.getName())) {
							if (element instanceof ModuleElementSymbolBase) {
								ModuleElementSymbolBase symbol = (ModuleElementSymbolBase)element;
								symbol.setRuntimePropertyList(prpList);
							}
							idSet.remove(element.getName());
						}
						if (idSet.size() == 0) {
							break;
						}
					}
				}
			}
		}		
	}
	
	public void enumAttribRule1(Token startToken, Object targetElement, String fieldName) {
		if (isCreatingModel()) {
			//moduleDef
			if (targetElement instanceof ModuleSymbol) {
				//忽略
			//typeDef
			} else if (targetElement instanceof TypeSymbolBase) {
				TypeSymbolBase symbolType = (TypeSymbolBase)targetElement;
				if (symbolType instanceof ContainerTypeSymbol) {
					ContainerTypeSymbol containerType = (ContainerTypeSymbol)symbolType;
					FieldSymbol field = (FieldSymbol)containerType.getFieldMV(fieldName);
					if (field != null) {
						//压入属性的目标类型
						parser.setTopTypeScope(field.getFieldTypeMV().getFullName());
					}
				} else if (symbolType instanceof ListTypeSymbol) {
					ListTypeSymbol listType = (ListTypeSymbol)symbolType;
					TypeMV itemType = listType.getListItem().getItemTypeMV();
					if (itemType != null) {
						//压入属性的目标类型
						parser.setTopTypeScope(itemType.getFullName());
					}
				}
			//importDef
			} else if (targetElement instanceof List<?>) {
				//忽略，Import类型不可以对字段进行设置
			}
		}
	}

	public void enumAttribRule2(Token startToken, Object targetElement, String fieldName, 
			List<PEnumItem> enumList) {
		if (isCreatingModel()) {
			//moduleDef
			if (targetElement instanceof ModuleSymbol) {
				//忽略
			//typeDef
			} else if (targetElement instanceof TypeSymbolBase) {
				TypeSymbolBase symbolType = (TypeSymbolBase)targetElement;
				if (symbolType instanceof ContainerTypeSymbol) {
					ContainerTypeSymbol containerType = (ContainerTypeSymbol)symbolType;
					FieldSymbol field = (FieldSymbol)containerType.getFieldMV(fieldName);
					if (field != null) {
						if (field.getModel() != null) {
							field.getModel().getEnumItems().addAll(enumList);
						}
					} else {
						addErrorMsg(getStartPosition(startToken), 
								MetaException.CODE.FIELD_NOT_FOUND_ERROR,
								fieldName, symbolType.getFullName());
					}
				} else if (symbolType instanceof ListTypeSymbol) {
					ListTypeSymbol listType = (ListTypeSymbol)symbolType;
					if (listType.getListItem().getModel() != null) {
						listType.getListItem().getModel().getEnumItems().addAll(enumList);
					}
				} else {
					addErrorMsg(getStartPosition(startToken), 
							MetaException.CODE.MUST_CONTAINER_TYPE_ERROR,
							symbolType.getFullName());
				}
			//importDef
			} else if (targetElement instanceof List<?>) {
				//Import类型不可以对字段进行设置
			}
		}
	}
	
	public void enumRefAttribRule(Token startToken, Object targetElement, String fieldName, 
			String enumSetName) {
		if (isCreatingModel()) {
			//moduleDef
			if (targetElement instanceof ModuleSymbol) {
				//忽略
			//typeDef
			} else if (targetElement instanceof TypeSymbolBase) {
				TypeSymbolBase symbolType = (TypeSymbolBase)targetElement;
				//取得EnumSet
				EnumSetMV enumSet = moduleMV.pEnumSetMV(enumSetName);
				if (enumSet == null) {
					addErrorMsg(getStartPosition(startToken), 
							MetaException.CODE.ENUM_SET_NOT_FOUND_ERROR,
							enumSetName, moduleMV.getModuleName());
					return;
				}
				if (symbolType instanceof ContainerTypeSymbol) {
					ContainerTypeSymbol containerType = (ContainerTypeSymbol)symbolType;
					//取得Field
					FieldSymbol field = (FieldSymbol)containerType.getFieldMV(fieldName);
					if (field == null) {
						addErrorMsg(getStartPosition(startToken), 
								MetaException.CODE.FIELD_NOT_FOUND_ERROR,
								fieldName, symbolType.getFullName());
						return;
					}
					if (!enumSet.getBaseTypeMV().isCompatibleMV(field.getFieldTypeMV())) {
						addErrorMsg(getStartPosition(startToken), 
								MetaException.CODE.TYPE_NOT_COMPATIBLE_ERROR,
								field.getFieldTypeMV().getFullName(),
								enumSet.getBaseTypeMV().getFullName());
						return;
					}
					if (field.getModel() != null) {
						field.getModel().setEnumRef(enumSetName);
					}
				} else if (symbolType instanceof ListTypeSymbol) {
					ListTypeSymbol listType = (ListTypeSymbol)symbolType;
					ListItemSymbol item = listType.getListItem();
					assert item != null;
					if (item.getModel() == null) {
						return;
					}
					if (!enumSet.getBaseTypeMV().isCompatibleMV(item.getItemTypeMV())) {
						addErrorMsg(getStartPosition(startToken), 
								MetaException.CODE.TYPE_NOT_COMPATIBLE_ERROR,
								item.getItemTypeMV().getFullName(),
								enumSet.getBaseTypeMV().getFullName());
						return;
					}
					item.getModel().setEnumRef(enumSetName);
				} else {
					addErrorMsg(getStartPosition(startToken), 
							MetaException.CODE.MUST_CONTAINER_TYPE_ERROR,
							symbolType.getFullName());
				}
			//importDef
			} else if (targetElement instanceof List<?>) {
				//忽略，Import类型不可以对字段进行设置
			}
		}
		
	}
	
	public PPropertyList propertyListRule() {
		if (isCreatingModel()) {
			return mfactory.createPPropertyList();
		}
		return null;
	}
	

	public PProperty propertyRule(Token startToken, String prpName, PPropertyList prpList) {
		if (isCreatingModel()) {
			PProperty prp = mfactory.createPProperty();
			prp.setName(prpName);
			prpList.getProperties().add(prp);
			return prp;
		}
		return null;
	}
	
	public PArgumentGroup argumentGroupRule(PProperty prp) {
		if (isCreatingModel()) {
			PArgumentGroup group = mfactory.createPArgumentGroup();
			prp.getGroups().add(group);
			return group;
		}
		return null;
	}
	
	public PListArgument listArgumentRule(PArgumentGroup argGroup) {
		if (isCreatingModel()) {
			PListArgument listArg = mfactory.createPListArgument();
			listArg.setGroup(mfactory.createPArgumentGroup());
			argGroup.getArguments().add(listArg);
			return listArg;
		}
		return null;
	}
	
	public void integerArgumentRule(Token startToken, Token minus, PMatcher matcher, PArgumentGroup argGroup) {
		if (isCreatingModel()) {
			PIntegerArgument arg = mfactory.createPIntegerArgument();
			PPrimitiveValueMatcher primMatcher = (PPrimitiveValueMatcher)matcher;
			String desc = primMatcher.getValueDesc();
			if (minus != null) {
			    desc = "-" + desc;
			}
			arg.setDesc(desc);
			argGroup.getArguments().add(arg);
		}
	}
	
	public void booleanArgumentRule(Token startToken, PMatcher matcher, PArgumentGroup argGroup) {
		if (isCreatingModel()) {
			PBooleanArgument arg = mfactory.createPBooleanArgument();
			PPrimitiveValueMatcher primMatcher = (PPrimitiveValueMatcher)matcher;
			arg.setDesc(primMatcher.getValueDesc());
			argGroup.getArguments().add(arg);
		}
	}
	

	public void charStringArgumentRule(Token startToken, PMatcher matcher, PArgumentGroup argGroup) {
		if (isCreatingModel()) {
			PCharstringArgument arg = mfactory.createPCharstringArgument();
			PPrimitiveValueMatcher primMatcher = (PPrimitiveValueMatcher)matcher;
			arg.setDesc(primMatcher.getValueDesc());
			argGroup.getArguments().add(arg);
		}
	}
	
	public void identifierArgumentRule(Token startToken, String idText, PArgumentGroup argGroup) {
		if (isCreatingModel()) {
			PIdentifierArgument arg = mfactory.createPIdentifierArgument();
			arg.setDesc(idText);
			argGroup.getArguments().add(arg);
		}
	}

	public void conditionArgumentRule1(Token startToken, String condTypeName) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingModel()) {
			//压入指定类型
			if (condTypeName != null) {
				if (moduleMV.pTypeMV(condTypeName) != null) {
					parser.setTopTypeScope(condTypeName);
				} else {
					addErrorMsg(getStartPosition(startToken), 
							MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
							condTypeName, simpleModule.getModuleName());
				}
			//无法确定目标类型
			} else if (parser.peekTypeScope() == null) {
				String upperScopeName = parser.peekTypeScope(1);
				if (upperScopeName != null) {
					parser.setTopTypeScope(upperScopeName);
				} else {
					addErrorMsg(getStartPosition(startToken), 
							MetaException.CODE.UNDECIDED_OR_WRONG_TYPE_ERROR,
							"Unknown");
				}
			}
		}
	}
	
	public void conditionArgumentRule2(Token startToken, String condTypeName, 
			PTypeConstraint typeCons, PArgumentGroup argGroup) {
		if (isCreatingModel()) {
			PConditionArgument condArg = mfactory.createPConditionArgument();
			if (condTypeName != null) {
				condArg.setTypeName(condTypeName);
			} else {
				condArg.setTypeName(parser.peekTypeScope());
			}
			condArg.setCondition(typeCons);
			argGroup.getArguments().add(condArg);
		}
	}
	
	public PTypeConstraint stringLengthRule(Token startToken, PMatcher lowerBound, 
			PMatcher upperBound, boolean hasUpperBound) {
		if (isCreatingModel()) {
			PLengthConstraint lenCons = mfactory.createPLengthConstraint();
			lenCons.setLowerBound(lowerBound);
			//UpperBound没有设置的情况(认为是固定长度)
			if (!hasUpperBound) {
				assert upperBound == null;
				upperBound = (PMatcher)EcoreUtil.copy(lowerBound);
			}
			lenCons.setUpperBound(upperBound);
			return lenCons;
		}
		return null;
	}
	
	public PMatcher rangeDefRule(Token startToken, PMatcher lowerBound, 
			PMatcher upperBound) {
		if (isCreatingModel()) {
			PRangeMatcher rangeMatcher = tmpfactory.createPRangeMatcher();
			rangeMatcher.setLowerBound(lowerBound);
			rangeMatcher.setUpperBound(upperBound);
			return rangeMatcher;
		}
		return null;
	}

	public PMatcher charStringMatchRule(Token startToken, String strText) {
		if (isCreatingModel()) {
			PCharstringMatcher matcher = tmpfactory.createPCharstringMatcher();
			matcher.setDesc(strText);
			return matcher;
		}
		return null;
	}
	
	public PTypeConstraint allowedValuesRule1(Token startToken, List<PMatcher> matcherList) {
		if (isCreatingModel()) {
			PListConstraint listCons = mfactory.createPListConstraint();
			PValueListMatcher listMatcher = tmpfactory.createPValueListMatcher();
			for (PMatcher matcher : matcherList) {
				//其他Rule出错是可能会是null
				if (matcher != null) {
					listMatcher.getItems().add((PTemplateMatcher)matcher);
				}
			}
			listCons.setMatcher(listMatcher);
			return listCons;
		}
		return null;
	}
	
	public PTypeConstraint allowedValuesRule2(Token startToken, PMatcher matcher) {
		if (isCreatingModel()) {
			PPatternConstraint ptnCons = mfactory.createPPatternConstraint();
			ptnCons.setMatcher((PCharstringMatcher)matcher);
			return ptnCons;
		}
		return null;
	}
	
	public PTypeConstraint subTypeSpecRule(Token startToken, PTypeConstraint cons1, 
			PTypeConstraint cons2) {
		if (isCreatingModel()) {
			if (cons2 == null) {
				return cons1;
			} else {
				PCompoundConstraint cmpCons = mfactory.createPCompoundConstraint();
				//其他Rule出错是可能会是null
				if (cons1 != null) {
					cmpCons.getChildren().add(cons1);
				}
				cmpCons.getChildren().add(cons2);
				return cmpCons;
			}
		}
		return null;
	}
	
	public void simplePropertyRule(Token startToken, String name, String value, 
			SimplePropertyList prpList) {
		SimpleProperty prp = new SimpleProperty(name, value);
		prpList.add(prp);
	}
	
	public String freeTextRule(Token txtToken) {
		ICharstringValue strValue = BuiltinFactory.BUILTIN_INSTANCE.createCharstring();
		strValue.setString(txtToken.getText());
		return strValue.getText();
	}
	
	public PMatcher createBitStringValue(Token token) {
		if (isCreatingModel()) {
			String typename = parser.peekTypeScope();
			String text = token.getText();
			return createPrimitiveValueMatcher(typename, token, TypeClass.BITSTRING, 
					text.substring(1, text.length() - 2));
		}
		return null;
	}

	public PMatcher createOctetStringValue(Token token) {
		if (isCreatingModel()) {
			String typename = parser.peekTypeScope();
			String text = token.getText();
			return createPrimitiveValueMatcher(typename, token, TypeClass.OCTETSTRING, 
					text.substring(1, text.length() - 2));
		}
		return null;
	}

	public PMatcher createHexStringValue(Token token) {
		if (isCreatingModel()) {
			String typename = parser.peekTypeScope();
			String text = token.getText();
			return createPrimitiveValueMatcher(typename, token, TypeClass.HEXSTRING, 
					text.substring(1, text.length() - 2));
		}
		return null;
	}
	

	public PMatcher createBooleanValue(Token token) {
		if (isCreatingModel()) {
			String typename = parser.peekTypeScope();
			String text = token.getText();
			return createPrimitiveValueMatcher(typename, token, TypeClass.BOOLEAN, 
					text);
		}
		return null;
	}
	
	public PMatcher createIntegerValue(Token token) {
		if (isCreatingModel()) {
			String typename = parser.peekTypeScope();
			String text = token.getText();
			return createPrimitiveValueMatcher(typename, token, TypeClass.INTEGER, 
					text);
		}
		return null;
	}
	
	public PMatcher createVerdictValue(Token token) {
		if (isCreatingModel()) {
			String typename = parser.peekTypeScope();
			String text = token.getText();
			return createPrimitiveValueMatcher(typename, token, TypeClass.VERDICT, 
					text);
		}
		return null;
	}
	
	public PMatcher createCharStringValueNormal(Token token) {
		if (isCreatingModel()) {
			String typename = parser.peekTypeScope();
			String text = token.getText();
			text = text.substring(1, text.length() - 1);
			text = text.replace("\"\"", "\"");
			return createPrimitiveValueMatcher(typename, token, TypeClass.CHARSTRING, 
					text);
		}
		return null;
	}

	public PMatcher createFloatValue(Token token) {
		if (isCreatingModel()) {
			String typename = parser.peekTypeScope();
			String text = token.getText();
			return createPrimitiveValueMatcher(typename, token, TypeClass.FLOAT, 
					text);
		}
		return null;
	}

	public PMatcher createOmitValue(Token token) {
		if (isCreatingModel()) {
			String typename = parser.peekTypeScope();
			assert typename != null;
			TypeMV type = getModuleMV().pTypeMV(typename);
			if (type == null) {
				addErrorMsg(getStartPosition(token), 
						MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
						typename);
				return null;
			}
			return tmpfactory.createPOmitMatcher();
		}
		return null;
	}
	
	public PMatcher createEnumeratedValue(Token token) {
		if (isCreatingModel()) {
			String typename = parser.peekTypeScope();
			if (typename == null) {
				addErrorMsg(getStartPosition(token), 
						MetaException.CODE.UNDECIDED_OR_WRONG_TYPE_ERROR, 
						"?");
				return null;
			}
			String text = token.getText();
			return createPrimitiveValueMatcher(typename, token, TypeClass.ENUMERATED, 
					text);
		}
		return null;
	}
	
	public PMatcher fieldExpressionListRule(Token startToken) {
		if (isCreatingModel()) {
			//取得类型
			TypeMV type = peekTypeScopeType(startToken);
			if (type == null) {
				return null;
			}
			//Conatainer
			if (type.isContainerType()) {
				return tmpfactory.createPContainerFieldMatcher();
			//List
			} else if (type.isListType()) {
				return tmpfactory.createPListFieldMatcher();
			//Wrong
			} else {
				addErrorMsg(getStartPosition(startToken), 
						MetaException.CODE.UNDECIDED_OR_WRONG_TYPE_ERROR, 
						parser.peekTypeScope());
				return null;
			}
		}
		return null;
	}
	
	public Object fieldExpressionSpecRule1(Token startToken, PMatcher parentMatcher) {
		if (isCreatingModel()) {
			if (parentMatcher == null)
				return null;
			if (parentMatcher instanceof PContainerFieldMatcher) {
				PContainerFieldMatcher parent = (PContainerFieldMatcher)parentMatcher;
				PContainerFieldMatcherItem item = tmpfactory.createPContainerFieldMatcherItem();
				parent.getItems().add(item);
				return item;
			} else if (parentMatcher instanceof  PListFieldMatcher) {
				PListFieldMatcher parent = (PListFieldMatcher)parentMatcher;
				PListFieldMatcherItem item = tmpfactory.createPListFieldMatcherItem();
				parent.getItems().add(item);
				return item;
			} else {
				assert false;
			}
		}
		return null;
	}

	public void fieldExpressionSpecRule2(Token startToken, PMatcher fieldMatcher, Object fieldItem) {
		if (isCreatingModel()) {
			if (fieldItem == null || fieldMatcher == null) 
				return;
			if (fieldItem instanceof PContainerFieldMatcherItem) {
				PContainerFieldMatcherItem item = (PContainerFieldMatcherItem)fieldItem;
				item.setMatcher((PTemplateMatcher)fieldMatcher);
			} else if (fieldItem instanceof PListFieldMatcherItem) {
				PListFieldMatcherItem item = (PListFieldMatcherItem)fieldItem;
				item.setMatcher((PTemplateMatcher)fieldMatcher);
			} else {
				assert false;
			}
		}
		return;
	}
	
	public void fieldReferenceRule1(Token startToken, String fieldName, String parentTypeName, 
			Object fieldItem) {
		if (isCreatingModel()) {
			TypeMV type = getType(startToken, parentTypeName);
			if (type == null)
				return;
			if (!(fieldItem instanceof PContainerFieldMatcherItem)) {
				addErrorMsg(getStartPosition(startToken), 
						MetaException.CODE.MUST_CONTAINER_TYPE_ERROR,
						parser.peekTypeScope());
				return;
			}
			FieldMV fieldMeta = type.getFieldMV(fieldName);
			if (fieldMeta == null) {
				addErrorMsg(getStartPosition(startToken), 
						MetaException.CODE.FIELD_NOT_FOUND_ERROR,
						fieldName, parser.peekTypeScope());
				return;
			}
			PContainerFieldMatcherItem item = (PContainerFieldMatcherItem)fieldItem;
			item.setFieldName(fieldName);
			//设置Field的TypeScope
			parser.setTopTypeScope(fieldMeta.getFieldTypeMV().getFullName());
		}
	}
	
	public void fieldReferenceRule2(Token startToken, PMatcher indexMatcher, 
			String parentTypeName, Object fieldItem) {
		if (isCreatingModel()) {
			TypeMV type = getType(startToken, parentTypeName);
			if (type == null)
				return;
			if (!(fieldItem instanceof PListFieldMatcherItem)) {
				addErrorMsg(getStartPosition(startToken), 
						MetaException.CODE.MUST_LIST_TYPE_ERROR,
						parser.peekTypeScope());
				return;
			}
			PListFieldMatcherItem item = (PListFieldMatcherItem)fieldItem;
			item.setIndexMatcher(indexMatcher);
			//设置Field的TypeScope
			parser.setTopTypeScope(type.getListItemMV().getItemTypeName());
		}
	}
	
	public PNotUsedMatcher createNotUseMatcher() {
		if (isCreatingModel()) {
			return tmpfactory.createPNotUsedMatcher();
		}
		return null;
	}
	
	public PMatcher arrayExpressionRule(Token startToken) {
		if (isCreatingModel()) {
			//取得类型
			TypeMV type = peekTypeScopeType(startToken);
			if (type == null) {
				return null;
			}
			//Conatainer
			if (type.isContainerType()) {
				return tmpfactory.createPContainerFieldMatcher();
			//List
			} else if (type.isListType()) {
				return tmpfactory.createPListFieldMatcher();
			//Wrong
			} else {
				addErrorMsg(getStartPosition(startToken), 
						MetaException.CODE.UNDECIDED_OR_WRONG_TYPE_ERROR, 
						parser.peekTypeScope());
				return null;
			}
		}
		return null;
	}

	public Object arrayElementExpressionSpecRule1(Token startToken, PMatcher parentMatcher, 
			String parentTypeName, int elementIndex ) {
		if (isCreatingModel()) {
			if (parentMatcher == null)
				return null;
			TypeMV parentType = getType(startToken, parentTypeName);
			if (parentType == null) 
				return null;
			if (parentMatcher instanceof PContainerFieldMatcher) {
				//设置Field的TypeScope
				String fieldNames[] = parentType.getFieldNames();
				if (elementIndex >= fieldNames.length) {
					addErrorMsg(getStartPosition(startToken), 
							MetaException.CODE.WRONG_FIELD_INDEX_ERROR, 
							elementIndex, parentTypeName, fieldNames.length);
					return null;
				}
				parser.setTopTypeScope(parentType.getFieldMV(
						fieldNames[elementIndex]).getFieldTypeMV().getFullName());
				//生成Item
				PContainerFieldMatcher parent = (PContainerFieldMatcher)parentMatcher;
				PContainerFieldMatcherItem item = tmpfactory.createPContainerFieldMatcherItem();
				item.setFieldName(fieldNames[elementIndex]);
				parent.getItems().add(item);
				return item;
			} else if (parentMatcher instanceof  PListFieldMatcher) {
				//设置Field的TypeScope
				parser.setTopTypeScope(parentType.getListItemMV().getItemTypeName());
				//生成Item
				PListFieldMatcher parent = (PListFieldMatcher)parentMatcher;
				PListFieldMatcherItem item = tmpfactory.createPListFieldMatcherItem();
				item.setIndex(elementIndex);
				parent.getItems().add(item);
				return item;
			} else {
				assert false;
			}
		}
		return null;
	}

	public void arrayElementExpressionSpecRule2(Token startToken, PMatcher itemMatcher, 
			Object fieldItem) {
		if (isCreatingModel()) {
			if (fieldItem == null)
				return;
			if (fieldItem instanceof PContainerFieldMatcherItem) {
//			    System.out.println(((PContainerFieldMatcherItem)fieldItem).getFieldName()
//			            +":"+itemMatcher);
				((PContainerFieldMatcherItem)fieldItem).setMatcher((PTemplateMatcher)itemMatcher);
			} else if (fieldItem instanceof PListFieldMatcherItem) {
				((PListFieldMatcherItem)fieldItem).setMatcher((PTemplateMatcher)itemMatcher);
			} else {
				assert false;
			}
		}
	}
	
	public EntityConstantSymbol singleConstDefRule1(Token startToken, String baseTypeName, 
			String constName) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingSymbol()) {
			EntityConstantSymbol constant = new EntityConstantSymbol(simpleModule, 
					constName, baseTypeName);
			constant.setStartToken(startToken);
			simpleModule.addConstantMV(constant);
			return constant;
		} else {
			EntityConstantSymbol constSymbol = 
				(EntityConstantSymbol)simpleModule.pConstantMV(constName);
			if (constSymbol == null) {
				return null;
			}
			//设置当前元素
			moduleElementInDefine = constSymbol;
			//生成模型
			PEntityConstant model = mfactory.createPEntityConstant();
			model.setName(constName);
			model.setBaseTypeName(baseTypeName);
			constSymbol.setModel(model);
			return constSymbol;
		}
	}

	public void singleConstDefRule2(Token startToken, PMatcher matcher, Object newConst) {
		if (isCreatingModel()) {
			moduleElementInDefine = null;
			EntityConstantSymbol symbol = (EntityConstantSymbol)newConst;
			if (symbol != null) {
				symbol.getModel().setMatcher(matcher);
			}
		}
	}
	
	public EntityModuleParSymbol singleModuleParDefRule1(Token startToken, boolean isThread,
			String baseTypeName, String mparName) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingSymbol()) {
			EntityModuleParSymbol mpar = new EntityModuleParSymbol(simpleModule, 
					mparName, baseTypeName);
			mpar.setStartToken(startToken);
			simpleModule.addModuleParMV(mpar);
			return mpar;
		} else {
			EntityModuleParSymbol mparSymbol = 
				(EntityModuleParSymbol)simpleModule.pModuleParMV(mparName);
			if (mparSymbol == null) {
				return null;
			}
			//设置当前元素
			moduleElementInDefine =  mparSymbol;
			//生成模型
			PEntityModulePar model = mfactory.createPEntityModulePar();
			model.setName(mparName);
			model.setBaseTypeName(baseTypeName);
			model.setThread(isThread);
			mparSymbol.setModel(model);
			return mparSymbol;
		}
	}

	public void singleModuleParDefRule2(Token startToken, PMatcher matcher, 
			Object newMpar) {
		if (isCreatingModel()) {
			moduleElementInDefine = null;
			EntityModuleParSymbol mparSymbol = (EntityModuleParSymbol)newMpar;
			if (mparSymbol != null) {
				mparSymbol.getModel().setMatcher(matcher);
			}
		}
	}	
	
	public void importSpecRule1(Token startToken, String importedModuleName, 
			List<Object> newImportList) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingSymbol()) {
			simpleModule.addImportAll(startToken, importedModuleName);
		} else {
			ModuleMV importModule = getImportModule(startToken, importedModuleName);
			if ( importModule == null ) {
				return;
			}
			//导入所有的实体模块元素和子类型
			Collection<ModuleElementMV> elements = importModule.allModuleElements();
			for (ModuleElementMV element : elements) {
				if (!element.isImport()) {
					Object symbol = simpleModule.pModuleElement(element.getFullName());
					if (symbol != null) {
						newImportList.add(symbol);
					}
				}
			}
		}
	}
	
	public void importTypeDefSpecRule1(Token startToken, String importedModuleName, 
			List<String> importedTypeNames, List<Object> newImportList) {
		importElementSpecRule1(startToken, importedModuleName, importedTypeNames, 
				newImportList, ModuleElementMV.Type.TYPE);
	}
	
	public void importTypeDefSpecRule2(Token startToken, String importedModuleName,
			List<Object> newImportList) {
		importElementSpecRule2(startToken, importedModuleName, newImportList, 
				ModuleElementMV.Type.TYPE);
	}
	
	public void importConstSpecRule1(Token startToken, String importedModuleName, 
			List<String> importedTypeNames, List<Object> newImportList) {
		importElementSpecRule1(startToken, importedModuleName, importedTypeNames, 
				newImportList, ModuleElementMV.Type.CONSTANT);
	}
	
	public void importConstSpecRule2(Token startToken, String importedModuleName,
			List<Object> newImportList) {
		importElementSpecRule2(startToken, importedModuleName, newImportList, 
				ModuleElementMV.Type.CONSTANT);
	}
	
	public void importModuleParSpecRule1(Token startToken, String importedModuleName, 
			List<String> importedTypeNames, List<Object> newImportList) {
		importElementSpecRule1(startToken, importedModuleName, importedTypeNames, 
				newImportList, ModuleElementMV.Type.MODULE_PARAMETER);
	}
	
	public void importModuleParSpecRule2(Token startToken, String importedModuleName,
			List<Object> newImportList) {
		importElementSpecRule2(startToken, importedModuleName, newImportList, 
				ModuleElementMV.Type.MODULE_PARAMETER);
	}
	
	public void importEnumSetSpecRule1(Token startToken, String importedModuleName, 
			List<String> importedTypeNames, List<Object> newImportList) {
		importElementSpecRule1(startToken, importedModuleName, importedTypeNames, 
				newImportList, ModuleElementMV.Type.ENUM_SET);
	}
	
	public void importEnumSetSpecRule2(Token startToken, String importedModuleName,
			List<Object> newImportList) {
		importElementSpecRule2(startToken, importedModuleName, newImportList, 
				ModuleElementMV.Type.ENUM_SET);
	}
	
	public void importTemplateSpecRule1(Token startToken, String importedModuleName, 
			List<String> importedTypeNames, List<Object> newImportList) {
		importElementSpecRule1(startToken, importedModuleName, importedTypeNames, 
				newImportList, ModuleElementMV.Type.TEMPLATE);
	}
	
	public void importTemplateSpecRule2(Token startToken, String importedModuleName,
			List<Object> newImportList) {
		importElementSpecRule2(startToken, importedModuleName, newImportList, 
				ModuleElementMV.Type.TEMPLATE);
	}
	
	private void importElementSpecRule1(Token startToken, String importedModuleName, 
			List<String> importedElementNames, List<Object> newImportList, 
			ModuleElementMV.Type elementType) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingSymbol()) {
		    simpleModule.addImportSpecElements(startToken, importedModuleName, elementType, 
		            importedElementNames);
		} else {
			for (String elementName : importedElementNames) {
				String fullName = importedModuleName + "." + elementName;
				ModuleElementMV symbol = simpleModule.pModuleElement(elementType, fullName);
				if (symbol != null) {
					newImportList.add(symbol);
				}
			}
		}
	}
	
	public ValueReferenceSymbol referencedValueRule(Token startToken, String refElementName) {
		if (isCreatingModel()) {
			int dotIndex = refElementName.indexOf('.');
			String fieldName = null;
			if (dotIndex >= 0) {
				String moduleName = refElementName.substring(0, dotIndex);
				String elementName = refElementName.substring(dotIndex + 1);
				//外部模块不存在
				if (moduleMV.pImportedModuleMV(moduleName) == null) {
					refElementName = moduleName;
					fieldName = elementName;
				}
			}
			//生成
			ValueReferenceSymbol symbol = new ValueReferenceSymbol(moduleMV, moduleElementInDefine, 
					refElementName, peekTypeScopeType(startToken), parser.inConstScope());
			symbol.setStartToken(startToken);
			if (fieldName != null) {
				symbol.addFieldFragment(fieldName);
			}
			return symbol;
		}
		return null;
	}
	
	public void extendedFieldReferenceRule1(Token startToken, ValueReferenceSymbol symbol, 
			String fieldName) {
		if (isCreatingModel()) {
			if (symbol != null) {
				symbol.addFieldFragment(fieldName);
			}
		}
	}

	public void extendedFieldReferenceRule2(Token startToken, ValueReferenceSymbol symbol, 
			PMatcher indexMatcher) {
		if (isCreatingModel()) {
			if (symbol != null) {
				symbol.addIndexFragment(indexMatcher);
			}
		}
	}
	
	public PUnaryExpression unaryExpressionRule(Token startToken, String unaryOp, 
			PMatcher matcher) {
		if (isCreatingModel()) {
			PUnaryExpression model = tmpfactory.createPUnaryExpression();
			if (unaryOp != null) {
				TypeMV type = peekTypeScopeType(startToken);
				if (type.getTypeClass() != TypeClass.INTEGER && 
						type.getTypeClass() != TypeClass.FLOAT) {
					addErrorMsg(getStartPosition(startToken), 
							MetaException.CODE.UNDECIDED_OR_WRONG_TYPE_ERROR, 
							type.getFullName());
					return null;
				}
				model.setOperator(unaryOp);
			}
			model.setPrimary((PExpressionMatcher)matcher);
			return model;
		}
		return null;
	}
	
	public PMatcher singleExpressionRule(Token startToken, PExpressionMatcher expression) {
		if (isCreatingModel()) {
			if (expression == null)
				return null;
			PSingleExpressionMatcher model = tmpfactory.createPSingleExpressionMatcher();
			model.setExpression(expression);
			return model;
		}
		return null;
	}
	
	public ValueReferenceSymbol valueRefArgumentRule1(Token startToken, String refElementName) {
		if (isCreatingModel()) {
			int dotIndex = refElementName.indexOf('.');
			String fieldName = null;
			if (dotIndex >= 0) {
				String moduleName = refElementName.substring(0, dotIndex);
				String elementName = refElementName.substring(dotIndex + 1);
				//外部模块不存在
				if (moduleMV.pImportedModuleMV(moduleName) == null) {
					refElementName = moduleName;
					fieldName = elementName;
				}
			}
			//取得引用元素的类型
			ModuleElementMV refElement = moduleMV.pModuleElement(refElementName);
			if (refElement == null) {
				addErrorMsg(getStartPosition(startToken), 
						MetaException.CODE.REFERENCED_ELEMENT_NOT_FOUND_ERROR, 
						refElementName);
				return null;
			}
			TypeMV baseType;
			switch(refElement.getModuleElementType()) {
			case CONSTANT:
				baseType = ((ConstantMV)refElement).getBaseTypeMV();
				break;
			case MODULE_PARAMETER:
				baseType = ((ModuleParMV)refElement).getBaseTypeMV();
				break;
			default:
				addErrorMsg(getStartPosition(startToken), 
						MetaException.CODE.ELEMENT_REFERENCE_NOT_ALLOWED_ERROR, 
						refElementName);
				return null;
			}
			//生成
			ValueReferenceSymbol symbol = new ValueReferenceSymbol(moduleMV, null, 
					refElementName, baseType, false);
			symbol.setStartToken(startToken);
			if (fieldName != null) {
				symbol.addFieldFragment(fieldName);
			}
			//初始化(没有所属元素，所以单独初始化)
			symbol.initModel(this);
			return symbol;
		}
		return null;
	}
	
	public void valueRefArgumentRule2(Token startToken, ValueReferenceSymbol symbol, 
			PArgumentGroup argGroup) {
		if (isCreatingModel()) {
			if (symbol == null) {
				return;
			}
			PValueReferenceArgument argModel = mfactory.createPValueReferenceArgument();
			argModel.setTypeName(symbol.getBaseType().getFullName());
			argModel.setValueRef(symbol.getModel());
			argGroup.getArguments().add(argModel);
		}
	}
	
	public void typeRefArgumentRule(Token startToken, String typeName, 
			PArgumentGroup argGroup) {
		if (isCreatingModel()) {
			if (getType(startToken, typeName)== null) {
				return;
			}
			PTypeReferenceArgument argModel = mfactory.createPTypeReferenceArgument();
			argModel.setTypeName(typeName);
			argGroup.getArguments().add(argModel);
		}
	}
	
	private void importElementSpecRule2(Token startToken, String importedModuleName,
			List<Object> newImportList, ModuleElementMV.Type elementType) {
		ModuleSymbol simpleModule = (ModuleSymbol)moduleMV;
		if (isCreatingSymbol()) {
			simpleModule.addImportTypeAll(startToken, importedModuleName, elementType);
		} else {
			ModuleMV importModule = getImportModule(startToken, importedModuleName);
			if ( importModule == null ) {
				return;
			}
			Collection<ModuleElementMV> elements = importModule.allModuleElements();
			for (ModuleElementMV importElement : elements) {
				if (!importElement.isImport()) {
					String fullName = importElement.getFullName();
					ModuleElementMV newElement = simpleModule.pModuleElement(elementType, fullName);
					if (newElement == null) {
						newImportList.add(newElement);
					}
				}
			}
		}
	}
	
	private ModuleMV getImportModule(Token startToken, String moduleName) {
		ModuleMV importModule = parsingContext.getCreatedModule(moduleName);
		if (importModule == null) {
			addErrorMsg(getStartPosition(startToken),
					MetaException.CODE.MODULE_NOT_FOUND_REGISTRY_ERROR, 
					moduleName);
		}
		return importModule;
	}
	
	private TypeMV peekTypeScopeType(Token startToken) {
		String typename = parser.peekTypeScope();
		if (typename == null) {
			addErrorMsg(getStartPosition(startToken), 
					MetaException.CODE.UNDECIDED_OR_WRONG_TYPE_ERROR, 
					"?");
			return null;
		}
		return getType(startToken, typename);
	}

	private TypeMV getType(Token startToken, String typename) {
		TypeMV type = moduleMV.pTypeMV(typename);
		if (type == null) {
			addErrorMsg(getStartPosition(startToken), 
					MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
					typename, moduleMV.getModuleName());
			return null;
		}
		return type;
	}
	
	
	public void reset() {
		grammerErrorMsgs = new ArrayList<String>();;
	}
	
	public List<String> getGrammerErrorMsgs() {
		return grammerErrorMsgs;
	}

	private PMatcher createPrimitiveValueMatcher(String typename, Token token, 
			TypeClass targetClass, String text) {
		if (typename == null) {
			addErrorMsg(getStartPosition(token), 
					MetaException.CODE.UNDECIDED_OR_WRONG_TYPE_ERROR, 
					" Unknown");
			return null;
		}
		TypeMV type = getModuleMV().pTypeMV(typename);
		if (type == null) {
			addErrorMsg(getStartPosition(token), 
					MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
					typename);
			return null;
		}
		if (targetClass != type.getTypeClass()) {
			addErrorMsg(getStartPosition(token), 
					MetaException.CODE.UNDECIDED_OR_WRONG_TYPE_ERROR, 
					typename);
			return null;
		}
		PPrimitiveValueMatcher matcher = tmpfactory.createPPrimitiveValueMatcher();
		//去掉前后缀
		matcher.setValueDesc(text);
		return matcher;
	}

	public ModuleMV getModuleMV() {
		return moduleMV;
	}

	public void setModuleMV(ModuleMV moduleMV) {
		this.moduleMV = moduleMV;
	}

	public int getCreatingMode() {
		return creatingMode;
	}

	public void setCreatingMode(int creatingMode) {
		this.creatingMode = creatingMode;
	}
	
	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

    public T34fpbParser getParser() {
        return parser;
    }
	
}
