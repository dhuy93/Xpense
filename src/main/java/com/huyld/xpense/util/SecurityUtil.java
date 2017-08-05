/**
 * 
 */
package com.huyld.xpense.util;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

/**
 * @author ldhuy
 * Created on: 30/07/2017
 *
 */
public class SecurityUtil {
	private static SecurityUtil instance;
	private static String privateKey = "HqqWAwVFDtm0BaL6XRDO";
	private static String salt = "WCs9HS";
	private static TextEncryptor encryptor;
	private static TextEncryptor decryptor;

	private SecurityUtil() {
		try {
			String pk = GlobalUtil.getProperty("private-key");
			if (pk != null) {
				privateKey = pk;
			}
			privateKey = toHex(privateKey);
		} catch (IOException e) {
			System.err.println("Couldn't load private key. Default key was used");
			e.printStackTrace();
		}

		try {
			String s = GlobalUtil.getProperty("salt");
			if (s != null) {
				salt = s;
			}
			salt = toHex(salt);
		} catch (IOException e) {
			System.err.println("Couldn't load salt. Default salt was used");
			e.printStackTrace();
		}

		encryptor = Encryptors.text(privateKey, salt);
		decryptor = encryptor;
	}

	public static String encrypt(String input) {
		if (instance == null) {
			instance = new SecurityUtil();
		}
		return encryptor.encrypt(input);
	}

	public static String decrypt(String input) {
		if (instance == null) {
			instance = new SecurityUtil();
		}
		return decryptor.decrypt(input);
	}
	
	private String toHex(String input) {
		return String.format("%040x", new BigInteger(1, input.getBytes(StandardCharsets.UTF_8)));
	}
}
