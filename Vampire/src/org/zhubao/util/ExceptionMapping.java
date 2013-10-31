package org.zhubao.util;

import java.util.Properties;

public class ExceptionMapping {

	protected static final String PROPS_NAME = "error_code.properties";
	protected static Properties props = PropertiesUtil
			.loadProperties(PROPS_NAME);
	/**
	 * Lookup error message based on error code.
	 * 
	 * @param errorCode
	 * @return
	 */
	public static String lookUpErrorMessage(Integer errorCode) {
		String errorMessage = props.getProperty(errorCode.toString());
		return errorMessage;
	}

}