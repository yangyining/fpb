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
package com.fineqt.fpb.lib.meta.exception;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;

public class MetaException extends Exception {
	public final static long serialVersionUID = 0;
	
	public static Map<String, String> code2msgMap = createCode2msgMap();
	
	//Error Code
	public interface CODE {
		//Runtime
		String UNKOWN_ERROR = "UNKOWN_ERROR";
		String UNSUPPORTED_ENCODING_ERROR = "UNSUPPORTED_ENCODING_ERROR";
		String UNSUPPORTED_BYTE_ORDER_ERROR = "UNSUPPORTED_BYTE_ORDER_ERROR";
		String EV_ARGUMENT_FORMAT_ERROR = "EV_ARGUMENT_FORMAT_ERROR";
		String TYPE_NOT_FOUND_ERROR = "TYPE_NOT_FOUND_ERROR";
		String TEMPLATE_NOT_FOUND_ERROR = "TEMPLATE_NOT_FOUND_ERROR";
		String CONSTANT_NOT_FOUND_ERROR = "CONSTANT_NOT_FOUND_ERROR";
		String MODULEPAR_NOT_FOUND_ERROR = "MODULEPAR_NOT_FOUND_ERROR";
		String TEMPLATE_PARAMETER_REQUIRED_ERROR = "TEMPLATE_PARAMETER_REQUIRED_ERROR";
		String MODULE_NOT_IMPORTED_ERROR = "MODULE_NOT_IMPORTED_ERROR";
		String MODULE_NOT_FOUND_REGISTRY_ERROR = "MODULE_NOT_FOUND_REGISTRY_ERROR";
		String ENUM_SET_NOT_FOUND_ERROR = "ENUM_SET_NOT_FOUND_ERROR";
//		String TYPE_CONSTRAINT_FORMAT_ERROR = "TYPE_CONSTRAINT_FORMAT_ERROR";
		String MUST_CONTAINER_TYPE_ERROR = "MUST_CONTAINER_TYPE_ERROR";
		String MUST_LIST_TYPE_ERROR = "MUST_LIST_TYPE_ERROR";
		String FIELD_NOT_FOUND_ERROR = "FIELD_NOT_FOUND_ERROR";
		String PARSE_PPATH_ERROR = "PARSE_PPATH_ERROR";
		String NOT_MATCHED_REF_AND_COND_ERROR = "NOT_MATCHED_REF_AND_COND_ERROR";
//		String SET_INT_VALUE_ERROR = "SET_INT_VALUE_ERROR";
		String INVALID_TYPE_FOR_FLAG_FIELD_ERROR = "INVALID_TYPE_FOR_FLAG_FIELD_ERROR";
		String BIT_BUFFER_EXCEPTION_ERROR = "BIT_BUFFER_EXCEPTION_ERROR";
		String FIELD_REF_DESC_CREATING_ERROR = "FIELD_REF_DESC_CREATING_ERROR";
		String DECODE_RESULT_OBJECT_CREATING_ERROR = "DECODE_RESULT_OBJECT_CREATING_ERROR";
		String NEXT_LINE_NOT_MATCH_ERROR = "NEXT_LINE_NOT_MATCH_ERROR";
		String SELECTED_FIELD_DECODED_FAILED = "SELECTED_FIELD_DECODED_FAILED";
		String NONE_OPTIONAL_FIELD_NOT_DECODED_ERROR = "NONE_OPTIONAL_FIELD_NOT_DECODED_ERROR";
		String ILLEGAL_LITERAL_FORMAT_ERROR = "ILLEGAL_LITERAL_FORMAT_ERROR";
		String FIELD_DECODING_FAILED = "FIELD_DECODING_FAILED";
		String OMIT_FIELD_NOT_ALLOWED_ERROR = "OMIT_FIELD_NOT_ALLOWED_ERROR";
		String NULL_VALUE_ERROR = "NULL_VALUE_ERROR";
		String NOT_SINGLE_VALUE_ERROR = "NOT_SINGLE_VALUE_ERROR";
		String MUST_CONSTANT_EXPRESSION_ERROR = "MUST_CONSTANT_EXPRESSION_ERROR";
		String TEMPLATE_MATCHING_ERROR = "TEMPLATE_MATCHING_ERROR";
		String RECURSIVE_MODULE_IMPORT_ERROR = "RECURSIVE_MODULE_IMPORT_ERROR";
		String NONE_CONDITION_ARGUMENT_TYPE_ERROR = "NONE_CONDITION_ARGUMENT_TYPE_ERROR";
		String TYPE_NOT_COMPATIBLE_ERROR = "TYPE_NOT_COMPATIBLE_ERROR";
		String UNSETTED_BYTE_ORDER_PROPERTY_ERROR = "UNSETTED_BYTE_ORDER_PROPERTY_ERROR";
		String WRONG_FIELD_INDEX_ERROR = "WRONG_FIELD_INDEX_ERROR";
		String UNKNOWN_PROPERTIES_ERROR = "UNKNOWN_PROPERTIES_ERROR";
		String FIELD_NOT_FOUND_IN_STACK_ERROR = "FIELD_NOT_FOUND_IN_STACK_ERROR";
		String REFERENCE_FIELD_TYPE_NOT_SPECIFIED_ERROR = "REFERENCE_FIELD_TYPE_NOT_SPECIFIED_ERROR";
		String PAD_PROPERTY_ERROR = "PAD_PROPERTY_ERROR";
		String LOWER_LAYER_PROTOCOL_WRONG_ERROR = "LOWER_LAYER_PROTOCOL_WRONG_ERROR";
		String LOAD_JAVA_CLASS_ERROR = "LOAD_JAVA_CLASS_ERROR";
		String REFERENCE_REGION_TYPE_NOT_ALLOWED_ERROR = "REFERENCE_REGION_TYPE_NOT_ALLOWED_ERROR";
		//Parser
		String WRONG_ENCODE_LITERAL_ERROR = "WRONG_ENCODE_LITERAL_ERROR";
		String PARSING_MODULE_FILE_ERROR = "PARSING_MODULE_FILE_ERROR";
		String UNDECIDED_OR_WRONG_TYPE_ERROR = "UNDECIDED_OR_WRONG_TYPE_ERROR";
		String ELEMENT_DEFINITION_DUPLICATED_ERROR = "ELEMENT_DEFINITION_DUPLICATED_ERROR";
		String FIELD_DEFINITION_DUPLICATED_ERROR = "FIELD_DEFINITION_DUPLICATED_ERROR";
		String ENUM_ITEM_DEFINITION_DUPLICATED_ERROR = "ENUM_ITEM_DEFINITION_DUPLICATED_ERROR";
		String REFERENCED_ELEMENT_NOT_FOUND_ERROR = "REFERENCED_ELEMENT_NOT_FOUND_ERROR";
		String ELEMENT_REFERENCE_NOT_ALLOWED_ERROR = "ELEMENT_REFERENCE_NOT_ALLOWED_ERROR";
		String RECURSIVE_ELEMENT_REFERENCE_ERROR = "RECURSIVE_ELEMENT_REFERENCE_ERROR";
	}

	//Error Message
	static private Map<String, String> createCode2msgMap(){
		Map<String, String> map = new HashMap<String, String>();
		//Runtime
		map.put(CODE.UNKOWN_ERROR, "{0}");
		map.put(CODE.UNSUPPORTED_ENCODING_ERROR, "Encoding of {0} is not supported.");
		map.put(CODE.UNSUPPORTED_BYTE_ORDER_ERROR, "ByteOrder of {0} is not supported.");
		map.put(CODE.EV_ARGUMENT_FORMAT_ERROR, 
				"Argument of [{0}] for {1} is wrong format, right format is {2}.");
		map.put(CODE.TYPE_NOT_FOUND_ERROR, "Type of {0} not found in module {1}.");
		map.put(CODE.TEMPLATE_NOT_FOUND_ERROR, "Template of {0} not found in module {1}.");
		map.put(CODE.CONSTANT_NOT_FOUND_ERROR, "Constant of {0} not found in module {1}.");
		map.put(CODE.MODULEPAR_NOT_FOUND_ERROR, "Modulepar of {0} not found in module {1}.");
		map.put(CODE.MODULE_NOT_IMPORTED_ERROR, "Module of {0} can''t be imported into module {1}.");
		map.put(CODE.MODULE_NOT_FOUND_REGISTRY_ERROR, "Module of {0} is not found in global registry.");
		map.put(CODE.ENUM_SET_NOT_FOUND_ERROR, "EnumSet of {0} is not found in module {1}.");
//		map.put(CODE.TYPE_CONSTRAINT_FORMAT_ERROR, "Type constraint of [{0}] is wrong format, must satisfy the TTCN-3 type constraint format.");
		map.put(CODE.MUST_CONTAINER_TYPE_ERROR, "Type of {0} is not container type.");
		map.put(CODE.MUST_LIST_TYPE_ERROR, "Type of {0} is not list type.");
		map.put(CODE.FIELD_NOT_FOUND_ERROR, "Field of {0} is not found in type of {1}.");
		map.put(CODE.PARSE_PPATH_ERROR, "Parse PPath error. detail:{0}");
		map.put(CODE.NOT_MATCHED_REF_AND_COND_ERROR, "Field reference of {0} and condition must be pair.");
//		map.put(CODE.SET_INT_VALUE_ERROR, "Can't set int value to PValue of this type {0}.");
		map.put(CODE.INVALID_TYPE_FOR_FLAG_FIELD_ERROR, "Root type of flag field must be one of bitstring, integer or boolean. but current type is {0}");
		map.put(CODE.BIT_BUFFER_EXCEPTION_ERROR, "Error occurred in wrting data into or reading data from BitBuff.");
		map.put(CODE.FIELD_REF_DESC_CREATING_ERROR, "Error occurred in creating the field reference description object.");
		map.put(CODE.DECODE_RESULT_OBJECT_CREATING_ERROR, "Error occurred in creating decode result object.");
		map.put(CODE.NEXT_LINE_NOT_MATCH_ERROR, "Next line symbol not matched. Require {0} , but is {1}.");
		map.put(CODE.SELECTED_FIELD_DECODED_FAILED, "Decoding for the selected field of {0} in type {1} is failed.");
		map.put(CODE.NONE_OPTIONAL_FIELD_NOT_DECODED_ERROR, "None optional field of {0} in set type {1} has not been decoded.");
		map.put(CODE.ILLEGAL_LITERAL_FORMAT_ERROR, "Illegal leteral format error when {0}.");
		map.put(CODE.FIELD_DECODING_FAILED, "Decoding for field of {0} is failed.");
		map.put(CODE.OMIT_FIELD_NOT_ALLOWED_ERROR, "Field or type of {0} can''t be omit.");
		map.put(CODE.NULL_VALUE_ERROR, "Null value is occurred.");
		map.put(CODE.NOT_SINGLE_VALUE_ERROR, "Template must be single value in valueOf action.");
		map.put(CODE.TEMPLATE_PARAMETER_REQUIRED_ERROR, "Template parameter of {0} in type of {1} is required.");
		map.put(CODE.MUST_CONSTANT_EXPRESSION_ERROR, "Must be constant expression in {0}.");
		map.put(CODE.TEMPLATE_MATCHING_ERROR, "Template or Matcher''s matching or valueOf operation error.");
		map.put(CODE.RECURSIVE_MODULE_IMPORT_ERROR, "Recursive module importing occurred, importing stack is {0}. Only type can be imported recursively.");
		map.put(CODE.NONE_CONDITION_ARGUMENT_TYPE_ERROR, "Type for condition argument of property {0} can''t be found or referenced.");
		map.put(CODE.TYPE_NOT_COMPATIBLE_ERROR, "Type of {0} and {1} is not compatible.");
		map.put(CODE.UNSETTED_BYTE_ORDER_PROPERTY_ERROR, "Porperty of byte order is not setted or unknown.");
		map.put(CODE.WRONG_FIELD_INDEX_ERROR, "Field index of {0} is wrong for type {1}, the field number is {2}");
		map.put(CODE.UNKNOWN_PROPERTIES_ERROR, "Properties of {0} are unknown.");
		map.put(CODE.FIELD_NOT_FOUND_IN_STACK_ERROR, "Field of {0} is not found in the field stack.");
		map.put(CODE.REFERENCE_FIELD_TYPE_NOT_SPECIFIED_ERROR, "Field reference of {0} in property {1} must be specified with type name.");
		map.put(CODE.PAD_PROPERTY_ERROR, "Parsing pad relating property of {0} error. PadType or PadValue property can only be assignned to Bitstring or Octetstring type.");
		map.put(CODE.LOWER_LAYER_PROTOCOL_WRONG_ERROR, "Lower layer protocol must be {0}.");
		map.put(CODE.LOAD_JAVA_CLASS_ERROR, "Loading for java class of {0} failed.");
		map.put(CODE.REFERENCE_REGION_TYPE_NOT_ALLOWED_ERROR, "Reference Region in property {0} with type of {1} is not allowed, allowed type is {2}.");
		//Parser
		map.put(CODE.WRONG_ENCODE_LITERAL_ERROR, "Literal for encoding of {0} is wrong, the expected is one of " + EncodingType.VALUES + ".");
		map.put(CODE.UNDECIDED_OR_WRONG_TYPE_ERROR, "Target type can''t be decided or the type is not appropriate for current operation. Target type is {0}.");
		map.put(CODE.PARSING_MODULE_FILE_ERROR, "Parsing module file of {0} failed for:\n {1}");
		map.put(CODE.ELEMENT_DEFINITION_DUPLICATED_ERROR, "Definiton of element {0} is duplicated.");
		map.put(CODE.FIELD_DEFINITION_DUPLICATED_ERROR, "Definiton of field {0} is duplicated.");
		map.put(CODE.ENUM_ITEM_DEFINITION_DUPLICATED_ERROR, "Definiton of enumeration type item {0} is duplicated.");
		map.put(CODE.REFERENCED_ELEMENT_NOT_FOUND_ERROR, "Element to be reference of {0} is not found.");
		map.put(CODE.ELEMENT_REFERENCE_NOT_ALLOWED_ERROR, "Element of {0} can not be referenced at this position.");
		map.put(CODE.RECURSIVE_ELEMENT_REFERENCE_ERROR, "Reference of {0} is recursive reference.");
		return map;
	}
	
	private String code;
	
	public MetaException(String code, Throwable cause, Object... msgArgs) {
		super(code + ";" + MessageFormat.format(code2msgMap.get(code), msgArgs), cause);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
