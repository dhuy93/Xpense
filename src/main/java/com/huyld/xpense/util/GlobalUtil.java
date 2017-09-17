/**
 * 
 */
package com.huyld.xpense.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Properties;

import org.springframework.context.i18n.LocaleContextHolder;
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
	private static String encoding = "UTF-8";
	private static String timeFormat;
	private static Locale locale = LocaleContextHolder.getLocale();

	private GlobalUtil() throws IOException {
		Resource resource = new ClassPathResource("/global_settings.properties");
		props = PropertiesLoaderUtils.loadProperties(resource);

		timeFormat = props.getProperty("format.date");
	}

	public static String getProperty(String key) throws IOException {
		if (instance == null) {
			instance = new GlobalUtil();
		}
		return props.getProperty(key);
	}

	/**
	 * @return the timeFormat
	 */
	public static String getTimeFormat() {
		return timeFormat;
	}

	/**
	 * @return the locale
	 */
	public static Locale getLocale() {
		return locale;
	}
}
