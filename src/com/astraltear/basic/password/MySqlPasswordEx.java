package com.astraltear.basic.password;

import java.security.MessageDigest;

import com.astraltear.basic.utils.BytesToHexToString;

public class MySqlPasswordEx {

	public static void main(String[] args) {
		String password="helloWord";
		String digest = encryptPW(password);
		System.out.println(digest);
	}
	
	private static String encryptPW(String password) {
		byte digest [] = null;
		
//		SHA1을 두 번 적용한다.
		digest = getHash(password.getBytes());
		digest = getHash(digest);
		
		StringBuilder sb = new StringBuilder(1+digest.length);
		sb.append("*");
		sb.append(BytesToHexToString.convertToHex(digest).toUpperCase());
		return sb.toString();
		
	}

	public static byte[] getHash(byte[] input) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md.digest(input);
	}
	

}
