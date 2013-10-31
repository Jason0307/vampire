/**
 * 
 */
package org.zhubao.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author Jason.Zhu
 * @date   2013-6-9上午8:39:18
 * @email jasonzhu@augmentum.com.cn
 */
public class PropertiesUtil {
	public static Logger logger = Logger.getLogger(PropertiesUtil.class);

	public static Properties loadProperties(String filePath){
		Properties properties = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(Thread.currentThread().getContextClassLoader().getResource(filePath).getPath());
			properties.load(fis);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		
		return properties;
	}
	
}
