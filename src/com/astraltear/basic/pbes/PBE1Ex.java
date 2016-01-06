package com.astraltear.basic.pbes;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import com.astraltear.basic.utils.BytesToHexToString;

public class PBE1Ex {

	public static void main(String[] args) throws GeneralSecurityException {
		char[] password = "ekfdpwKWLA*30**#)!".toCharArray();

		// 암호화
		String plainText = "오늘도 별이 바람에 스치운다.";
		Charset charset = Charset.forName("UTF-8");

		// salt 생성
		byte[] salt = new byte[8];
		SecureRandom random = new SecureRandom();
		random.nextBytes(salt);
		int iterationCount = 1000; // 반복 횟수
		byte[] encryptData = encrypt(password, salt, iterationCount, plainText.getBytes(charset));
		System.out.println(BytesToHexToString.convertToHex(encryptData));

		// 복호화
		byte[] plainData = decrypt(password, salt, iterationCount, encryptData);
		System.out.println(new String(plainData, charset));

	}

	public static byte[] encrypt(char[] password, byte[] salt, int iterationCount, byte[] plainData)
			throws GeneralSecurityException {
		// 패스워드를 사용한 SecretKey 생성
		PBEKeySpec keySpec = new PBEKeySpec(password);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		PBEParameterSpec params = new PBEParameterSpec(salt, iterationCount);
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, params);
		byte[] encryptData = cipher.doFinal(plainData);
		return encryptData;
	}

	public static byte[] decrypt(char[] password, byte[] salt, int iterationCount, byte[] encryptData)
			throws GeneralSecurityException {
		// 패스워드를 사용한 SecretKey 생성
		PBEKeySpec keySpec = new PBEKeySpec(password);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		// salt, iteration count를 위한 파라미터 생성
		PBEParameterSpec params = new PBEParameterSpec(salt, iterationCount);
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, params);
		byte[] plainData = cipher.doFinal(encryptData);
		return plainData;
	}

}
