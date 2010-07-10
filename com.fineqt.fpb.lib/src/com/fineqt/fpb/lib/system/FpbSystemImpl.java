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
package com.fineqt.fpb.lib.system;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.builtin.BuiltinModule;
import com.fineqt.fpb.lib.builtin.impl.BuiltinModuleImpl;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.PModuleExt.Registry.ModuleResource;
import com.fineqt.fpb.lib.meta.context.PModuleInitContext;
import com.fineqt.fpb.lib.meta.context.PModuleInitContextImpl;
import com.fineqt.fpb.lib.meta.context.PModuleParsingContext;
import com.fineqt.fpb.lib.meta.context.PModuleParsingContextImpl;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.impl.AbstractPModuleExtProxy;
import com.fineqt.fpb.lib.type.PTypeExt.InternalValueFactory;
import com.fineqt.fpb.lib.type.impl.DefaultInternalValueFactory;
import com.fineqt.fpb.lib.type.impl.SimpleFpbTypeEVExtFactory;
import com.fineqt.fpb.lib.util.ParserException;
import com.fineqt.fpb.lib.util.T34fpbLiteralParser;

public class FpbSystemImpl extends SimpleScopeContext 
implements PFpbSystem {
	//环境变量名称
	public static final String FPB_HOME_ENV = "FPB_HOME";
	public static final String MODULE_FILE_EXT = "module";
	
	private static final String MODULE_FILE_EXT_WITH_DOT = "." + MODULE_FILE_EXT;
	private static final String WIN_PKTBUILDER_LIB_FILE = "fpblib.dll";
	private static final String LINUX_PKTBUILDER_LIB_FILE = "libfpb.so";
	private static final String DEFAULT_ROOT_FOLDER = ".";
	private static final String DEFAULT_PROTOCOL_FOLDER = "protocol";
	
	//FPB系统的根目录
	private File fpbHomeFolder;
	
	//FPB库文件路径
	private File fpbLibFile;
	
	//是否处于调试模式
	private boolean debug;
	
	//FPB协议定义文件目录
	private File fpbProtocolFolder;
	
	//内部值对象工厂
	private InternalValueFactory internalValueFactory = new DefaultInternalValueFactory();
	
	public FpbSystemImpl() {
		super(null);
	}

	@Override
	public void init(String fpbHomeFolderPath, String fpbProtocolFolderPath) 
	throws IOException {
		//ToStringStyle
		ToStringBuilder.setDefaultStyle(ToStringStyle.SHORT_PREFIX_STYLE);
		//FpbHomeFolder
		if (fpbHomeFolderPath != null) {
			fpbHomeFolder = new File(fpbHomeFolderPath);
		} else {
			String env = System.getenv(FPB_HOME_ENV);
			if (env != null) {
				fpbHomeFolder = new File(env);
			} else {
				fpbHomeFolder = new File(DEFAULT_ROOT_FOLDER);
			}
		}
		checkOSPathExist("Pakcet Builder Core Root Folder", fpbHomeFolder);
		//FpbProtocolFolder
		if (fpbProtocolFolderPath != null) {
			fpbProtocolFolder = new File(fpbProtocolFolderPath);
		} else {
			fpbProtocolFolder = new File(fpbHomeFolder, DEFAULT_PROTOCOL_FOLDER);
		}
		//FpbLibraryFile
		if (isWindows()) {
			fpbLibFile = new File(fpbHomeFolder, WIN_PKTBUILDER_LIB_FILE);
		} else {
			fpbLibFile = new File(fpbHomeFolder, LINUX_PKTBUILDER_LIB_FILE);
		}
		checkOSPathExist("Library File", fpbLibFile);
		// Load Library
//		System.out.println("LIBRARY_FILE:" + pktbuilderLibFile);
		loadLibrary();
		// 登记内部模块
		registerModule();
	}
	
	@Override
	public void init() throws IOException{
		init(null, null);
	}

	@Override
	public boolean isDebug() {
		return debug;
	}

	@Override
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	private void loadLibrary() throws IOException {
		System.load(fpbLibFile.getAbsolutePath());
	}

	private void registerModule() {
		//登记FPB编码变量工厂对象
		PModuleExt.Registry.PINSTANCE.registerTypeEVExtFactory(
				new SimpleFpbTypeEVExtFactory());
		//Builtin模块
		BuiltinModuleImpl.init();
		PModuleExt.Registry.PINSTANCE.resolveModule(BuiltinModule.BUILTIN_MODULE_NAME);
		
		//协议目录内的文件
		File[] moduleFiles = fpbProtocolFolder.listFiles(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(MODULE_FILE_EXT_WITH_DOT);
			}
		});
		if (moduleFiles != null) {
			for (File file : moduleFiles) {
				if (!file.isFile()) {
					continue;
				}
				PModuleExt.Registry.Proxy proxy = new FileModuleProxy(file);
				PModuleExt.Registry.PINSTANCE.register(proxy);
//				System.out.println("Register Module File:"+file.getAbsolutePath() + 
//						", name:" + proxy.getModuleName());
			}
		}
	}
	
	@Override
	public File getFpbHomeFolder() {
		return fpbHomeFolder;
	}
	
	@Override
	public File getFpbProtocolFolder() {
		return fpbProtocolFolder;
	}

	@Override
	public InternalValueFactory getInternalValueFactory() {
		return internalValueFactory;
	}

	@Override
	public void setInternalValueFactory(InternalValueFactory factory) {
		internalValueFactory = factory;
	}

	private static boolean isWindows() {
		String osName = System.getProperty("os.name").toLowerCase();
		return osName.contains("windows");
	}
	
	private static void checkOSPathExist(String name, File osPath)
	throws IOException {
		if (!osPath.exists()) {
			throw new IOException("Can't find the path for [" + name + "] of "
					+ osPath + ".");
		}
	}

	public static class FileModuleProxy extends AbstractPModuleExtProxy {
		private File file;

		public FileModuleProxy(String filePath) {
			this(new File(filePath));
		}
		
		public FileModuleProxy(File file) {
			super(extractModuleName(file));
			this.file = file;
		}

		@Override
		protected PModuleExt doResolveModule() throws InitMetaException {
			try {
			    //编译模块文件
			    PModuleParsingContext parsingCxt = new PModuleParsingContextImpl();
				T34fpbLiteralParser.INSTANCE.parseModuleModel(moduleName, parsingCxt);
				assert parsingCxt.getResultList().size() > 0;
				//创建模块对象
				PModuleInitContext initCxt = new PModuleInitContextImpl();
				initCxt.getModelsForInit().addAll(parsingCxt.getAllResultModel());
				T34fpbLiteralParser.INSTANCE.createModuleExt(initCxt);
				//登记所有新生成的模块
				for (PModuleExt meta : initCxt.getResultList()) {
                    PModuleExt.Registry.PINSTANCE.setResolvedPModule(meta);
                }
				return initCxt.getResult(moduleName);
			} catch (ParserException e) {
				throw new InitMetaException(
						null,
						MetaException.CODE.PARSING_MODULE_FILE_ERROR, 
						e,
						file, 
						e.getMessage());
			}
		}
		
		@Override
        public ModuleResource getResource() {
		    return new ModuleResource() {

                @Override
                public Reader createReader() throws IOException {
                    return new FileReader(file);
                }

                @Override
                public String getName() {
                    return file.getAbsolutePath();
                }
		        
		    };
        }

        private static String extractModuleName(File file) {
			String name = file.getName();
			if(! name.endsWith(MODULE_FILE_EXT_WITH_DOT)) {
				throw new IllegalArgumentException();
			}
			return name.substring(0, name.length() - MODULE_FILE_EXT_WITH_DOT.length());
		}
	}
	
}
