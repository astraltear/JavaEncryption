package com.astraltear.basic.pbes;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.astraltear.basic.utils.BytesToHexToString;

public class PBE2Ex {

	public static void main(String[] args) throws GeneralSecurityException {
		char[] password = "mynameiskhan".toCharArray();

		// 암호화
		String plainText = "오늘도 별이 바람에 스치운다.";
		Charset charset = Charset.forName("UTF-8");

		// salt 생성
		byte[] salt = new byte[8];
		SecureRandom random = new SecureRandom();
		random.nextBytes(salt);
		int iterationCount = 1000; // 반복 횟수

		// 패스워드를 이용한 SecretKey 생성
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, 128);
		SecretKey secretKey = new SecretKeySpec(keyFactory.generateSecret(keySpec).getEncoded(), "AES");
		byte[] encryptData = encrypt(secretKey, plainText.getBytes(charset));
		System.out.println(BytesToHexToString.convertToHex(encryptData));

		// 복호화
		byte[] plainData = decrypt(secretKey, encryptData);
		System.out.println(new String(plainData, charset));

	}

	public static byte[] encrypt(SecretKey secretKey, byte[] plainData) throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptData = cipher.doFinal(plainData);
		return encryptData;
	}

	public static byte[] decrypt(SecretKey secretKey, byte[] encryptData) throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] plainData = cipher.doFinal(encryptData);
		return plainData;
	}

}
