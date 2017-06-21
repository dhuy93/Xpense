/**
 * 
 */
package com.huyld.xpense.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * @author ldhuy
 *
 */
public class GlobalUtil {

	private static GlobalUtil instance;
	private static Properties props;

	private GlobalUtil() throws IOException {
		Resource resource = new ClassPathResource("/global_settings.properties");
		props = PropertiesLoaderUtils.loadProperties(resource);
	}

	public static String getProperty(String key) throws IOException {
		if (instance == null) {
			instance = new GlobalUtil();
		}
		return props.getProperty(key);
	}
}
