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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.huyld.xpense.model.User;
import com.huyld.xpense.model.UserDetails;

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
	
	public static String escapeHtml(String input) {
		String result = "";
		try {
			result = URLEncoder.encode(input, encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String unescapeHtml(String input) {
		String result = "";
		try {
			result = URLDecoder.decode(input, encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
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

	public static User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		User user = userDetails.getUser();
		return user;
	}
}
