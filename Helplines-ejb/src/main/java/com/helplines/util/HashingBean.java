package com.helplines.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingBean {

	public String hashString(String password) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] md = messageDigest.digest(password.getBytes());
			BigInteger number = new BigInteger(1, md);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
