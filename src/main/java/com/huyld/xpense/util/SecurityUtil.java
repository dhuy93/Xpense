/**
 * 
 */
package com.huyld.xpense.util;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author ldhuy
 * Created on: 30/07/2017
 *
 */
public class SecurityUtil {
	private static SecurityUtil instance = null;
	private static byte[] privateKey = "HqqWAwVFDtm0BaL6XRDO".getBytes();
	private static byte[] initializationVector = "WCs9HS".getBytes();
	private static Cipher encryptor;
	private static Cipher decryptor;
	private static final int RADIX = 16;

	private SecurityUtil() {
		try {
			String pk = GlobalUtil.getProperty("private-key");
			if (pk != null && pk.length() > 0) {
				privateKey = pk.getBytes();
			}
		} catch (IOException e) {
			System.err.println("Couldn't load private key. Default key was used");
			e.printStackTrace();
		}

		try {
			String iv = GlobalUtil.getProperty("initialization-vector");
			if (iv != null && iv.length() > 0) {
				initializationVector = iv.getBytes();
			}
		} catch (IOException e) {
			System.err.println("Couldn't load salt. Default salt was used");
			e.printStackTrace();
		}

		SecretKeySpec key = new SecretKeySpec(privateKey, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(initializationVector);
		try {
			encryptor = Cipher.getInstance("AES/CBC/PKCS5Padding");
			decryptor = Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}

		try {
			encryptor.init(Cipher.ENCRYPT_MODE, key, ivSpec);
			decryptor.init(Cipher.DECRYPT_MODE, key, ivSpec);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(String input) {
		if (instance == null) {
			instance = new SecurityUtil();
		}
		String encryptedStr = "";
		try {
			encryptedStr = new String(new BigInteger(encryptor.doFinal(input.getBytes())).toString(RADIX));
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return encryptedStr;
	}

	public static String decrypt(String input) {
		if (instance == null) {
			instance = new SecurityUtil();
		}
		String decryptedStr = "";
		BigInteger bigInt = new BigInteger(input, RADIX);
		try {
			decryptedStr = new String(decryptor.doFinal(bigInt.toByteArray()));
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return decryptedStr;
	}
}
