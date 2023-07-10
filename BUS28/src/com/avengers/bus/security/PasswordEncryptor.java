package com.avengers.bus.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordEncryptor {
	public static String encryptPassword(String password) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] hashBytes = messageDigest.digest(password.getBytes());
		return Base64.getEncoder().encodeToString(hashBytes);
	}
}
