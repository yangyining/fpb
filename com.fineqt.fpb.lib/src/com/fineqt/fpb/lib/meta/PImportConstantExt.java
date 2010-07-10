package com.fineqt.fpb.lib.meta;

public interface PImportConstantExt extends PConstantExt {
	String getImportedModuleName();
	String getImportedConstantName();
	PConstantExt getImportedConstant();
	void setImportedConstant(PConstantExt cons);
}
