package com.fineqt.fpb.lib.type.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.meta.PEnumItemExt;
import com.fineqt.fpb.lib.meta.PEnumSetExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.impl.PElementExtBase;
import com.fineqt.fpb.lib.meta.impl.PEnumItemExtImpl;
import com.fineqt.fpb.lib.meta.util.MetaUtils;
import com.fineqt.fpb.lib.meta.util.PElementExtFactory;
import com.fineqt.fpb.lib.model.fpbcommon.PModelElement;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumItem;
import com.fineqt.fpb.lib.model.fpbmodule.PItemField;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.PFpbItemFieldEVExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PItemFieldEVExt;
import com.fineqt.fpb.lib.type.PItemFieldExt;
import com.fineqt.fpb.lib.type.PTypeEVAttrs;
import com.fineqt.fpb.lib.type.PTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PItemFiedExtBase extends PElementExtBase implements PItemFieldExt {
    protected PTypeExt owner;
    protected PTypeExt type;
    protected PTypeExt rootType;
    protected PItemFieldEVExt pevMeta;
    protected List<PEnumItemExt> enumItems;
    protected PTypeConstraintStorage constraints = new SimplePTypeConstraintStorage();
    protected CreateFieldValueParas createValueParas = new CreateFieldValueParas();

    //用于deocode,encode, dump的优先类型编码变量
    protected PTypeEVExt priorityTypeEVMeta;
    //用于deocode,encode, dump的优先类型编码变量属性
    protected PTypeEVAttrs priorityAttrs;
    
    public PItemFiedExtBase(PModelElement pmodel, PModuleExt pmoduleExt) {
        super(pmodel, pmoduleExt);
    }

    @Override
    public PTypeEVAttrs getPriorityAttrs() {
        return priorityAttrs;
    }

    @Override
    public PTypeEVExt getPriorityVariant() {
        return priorityTypeEVMeta;
    }

    @Override
    public void init() throws InitMetaException {
        PItemField model = (PItemField)pmodel;
        assert type != null;
        //先对依赖的类型进行初始化
        type.init();
        rootType = type.getRootType();
        //加入目标类型的限制信息
        constraints.addConstraint(type.getConstraints().getAll());
        //编译自己限制信息
        if (model.getConstraint() != null) {
            PTypeConstraintExt cons = PElementExtFactory.INSTANCE.createTypeConstraint(type, 
                    model.getConstraint());
            constraints.addConstraint(cons);
        }
        //设置EV信息
        pevMeta = createEVExt();
        //EnumItems
        List<PEnumItem> items = model.getEnumItems();
        if (items.size() > 0) {
            enumItems = new ArrayList<PEnumItemExt>();
            for (PEnumItem enumItem : items) {
                PEnumItemExt itemMeta = new PEnumItemExtImpl(enumItem, type);
                itemMeta.init();
                enumItems.add(itemMeta);
            }
        }
        //enumRef
        if (enumItems == null && model.getEnumRef() != null) {
            PEnumSetExt setExt = type.getPModule().pPEnumSet(model.getEnumRef());
            if (setExt == null) {
                throw new InitMetaException(getPModule(), 
                        MetaException.CODE.ENUM_SET_NOT_FOUND_ERROR, 
                        model.getEnumRef(), type.getPModule().getModuleName());
            } else {
                //依赖枚举标签集合的初始化
                setExt.init();
            }
            enumItems = new ArrayList<PEnumItemExt>();
            for (PEnumItemExt item : setExt.getEnumItems()) {
                enumItems.add(item);
            }
        }
        //PValue生成参数
        createValueParas.init();
        //设置优先类型编码变量(在派生关系中找到第一个有效的EV)
        if (pevMeta != null) {
            priorityTypeEVMeta = pevMeta.getTypeEVMeta();
        }
        if (priorityTypeEVMeta == null || !priorityTypeEVMeta.hasSettedAttr()) {
            priorityTypeEVMeta = MetaUtils.findValidTypeEVMeta(type, priorityTypeEVMeta);
        }
        //优先类型编码变量属性
        if (priorityTypeEVMeta != null) {
            assert priorityTypeEVMeta.getEncodingType() == getEncodingType();
            switch(getEncodingType()) {
            case FPB:
                PFpbItemFieldEVExt fpbEVExt = (PFpbItemFieldEVExt)getEVMeta();
                //完全覆盖类型的EV属性，完全使用字段的EV信息
                if (fpbEVExt.isOverrideWhole()) {
                    priorityTypeEVMeta = fpbEVExt.getTypeEVMeta();
                //使用字段的EV信息，但是使用原类型的EV属性覆盖字段中没有设置的
                } else {
                    priorityTypeEVMeta = MetaUtils.findValidTypeEVMeta(type, priorityTypeEVMeta);                    
                    PFpbTypeEVExt fpbTypeEVExt = (PFpbTypeEVExt)getEVMeta().getTypeEVMeta();
                    if (fpbTypeEVExt != null) {
                        //覆盖字段中没有设置的
                        PFpbTypeEVAttrs fieldTypeEVAttrs = fpbTypeEVExt.getFpbTypeEVAttrs();
                        fieldTypeEVAttrs.overrideNotChangedByChanged(
                                (PFpbTypeEVAttrs)priorityTypeEVMeta.getTypeEVAttrs());
                        priorityAttrs = fieldTypeEVAttrs;
                    }
                }
                break;
            default:
              throw new InitMetaException(getPModule(), 
                      MetaException.CODE.UNSUPPORTED_ENCODING_ERROR, 
                      getEVMeta().getEncodingType());
            }
        }
    }
    
    @Override
    public List<PEnumItemExt> getEnumItems() {
        if (enumItems == null) {
            return Collections.emptyList();
        } 
        return Collections.unmodifiableList(enumItems);
    }

    @Override
    public PTypeExt asTypeMeta() {
        return type;
    }

    @Override
    public EncodingType getEncodingType() {
        if (pevMeta == null) {
            return EncodingType.NONE;
        }
        return pevMeta.getEncodingType();
    }

    @Override
    public PTypeExt getOwner() {
        return owner;
    }

    @Override
    public void setType(PTypeExt typeMeta) {
        type = typeMeta;
    }

    @Override
    public PTypeExt getType() {
        return type;
    }

    @Override
    public PModuleExt getPModule() {
        return owner.getPModule();
    }

    @Override
    public PItemFieldEVExt getEVMeta() {
        return pevMeta;
    }

    @Override
    public PTypeConstraintStorage getConstraints() {
        return constraints;
    }

    @Override
    public PValue createEmptyValue() {
        PValue result = type.createEmptyValue();
        result.pValueMeta(this);
        return result;
    }

    @Override
    public PValue createOmitValue() {
        PValue result = type.createOmitValue();
        result.pValueMeta(this);
        return result;
    }
    public String toString() {
        return new ToStringBuilder(this)
//            .append("pevMeta", pevMeta)
            .append("constraints", constraints)
            .append("priorityTypeEVMeta", priorityTypeEVMeta)
            .append("priorityAttrs", priorityAttrs)
//          .append("createValueParas", createValueParas)
            .toString();
    }
    

    abstract protected PItemFieldEVExt createEVExt();
    
    
    protected class CreateFieldValueParas implements CreatePTypeValueParamaters {
        private PValue defaultValue;
        private int defaultLength;
        
        public void init() {
            PFpbItemFieldEVExt fpbEvMeta = null;
            if (pevMeta instanceof PFpbItemFieldEVExt) {
                fpbEvMeta = (PFpbItemFieldEVExt)pevMeta;
            }
            //FixedValue
            defaultValue = constraints.getFixedValue();
            //DefaultValue
            if (defaultValue == null && fpbEvMeta != null) {
                defaultValue = fpbEvMeta.getDefaultValue();
            }

            //FixedLength
            defaultLength = constraints.getFixedLength();
            //DefaultLength
            if (defaultLength < 0 && fpbEvMeta != null) {
                defaultLength = fpbEvMeta.getDefaultLength();
            }
        }
        
        @Override
        public int getInitLength() {
            return defaultLength;
        }

        @Override
        public PValue getInitValue() {
            return defaultValue;
        }

        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("initLength", getInitLength())
                .append("initValue", getInitValue())
                .toString();
        }
        
    }
    
}
