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

		// ��ȣȭ
		String plainText = "���õ� ���� �ٶ��� ��ġ���.";
		Charset charset = Charset.forName("UTF-8");

		// salt ����
		byte[] salt = new byte[8];
		SecureRandom random = new SecureRandom();
		random.nextBytes(salt);
		int iterationCount = 1000; // �ݺ� Ƚ��

		// �н����带 �̿��� SecretKey ����
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, 128);
		SecretKey secretKey = new SecretKeySpec(keyFactory.generateSecret(keySpec).getEncoded(), "AES");
		byte[] encryptData = encrypt(secretKey, plainText.getBytes(charset));
		System.out.println(BytesToHexToString.convertToHex(encryptData));

		// ��ȣȭ
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
