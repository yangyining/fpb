package com.fineqt.fpb.lib.meta.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.fineqt.fpb.lib.grammer.mv.ModuleSymbol;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.modelview.ModuleMV;

public class PModuleParsingContextImpl implements PModuleParsingContext {
    private List<ModuleSymbol> resultList = new ArrayList<ModuleSymbol>();
    private Deque<ModuleSymbol> moduleStack = new LinkedList<ModuleSymbol>();

    @Override
    public ModuleSymbol findModuleInParsing(String moduleName) {
        for (ModuleSymbol symbol : moduleStack) {
            if (symbol.getModuleName().equals(moduleName)) {
                return symbol;
            }
        }
        return null;
    }

    @Override
    public ModuleSymbol peekModuleParsing() {
        return moduleStack.peek();
    }

    @Override
    public ModuleSymbol popModuleInParsing() {
        return moduleStack.pop();
    }

    @Override
    public void pushModuleInParsing(ModuleSymbol moduleInParsing) {
        moduleStack.push(moduleInParsing);        
    }

    @Override
    public Collection<String> getModuleInParsingStack() {
        List<String> names = new ArrayList<String>();
        for (ModuleSymbol symbol : moduleStack) {
            names.add(symbol.getModuleName());
        }
        return names;
    }

    @Override
    public List<ModuleSymbol> getResultList() {
        return resultList;
    }

    @Override
    public ModuleSymbol getResult(String moduleName) {
        for (ModuleSymbol symbol : resultList) {
            if (symbol.getModuleName().equals(moduleName)) {
                return symbol;
            }
        }
        return null;
    }

    @Override
    public List<PModule> getAllResultModel() {
        List<PModule> list = new ArrayList<PModule>();
        for (ModuleSymbol symbol : resultList) {
            list.add(symbol.getModel());
        }
        return list;
    }

    @Override
    public ModuleMV getCreatedModule(String name) {
        //取得已经解决的模块
        ModuleMV result = PModuleExt.Registry.PINSTANCE.getResolvedPModule(name);
        if (result != null) {
            return result;
        }
        //取得堆栈中的模块
        return getResult(name);
    }

}
