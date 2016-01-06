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

		// ��ȣȭ
		String plainText = "���õ� ���� �ٶ��� ��ġ���.";
		Charset charset = Charset.forName("UTF-8");

		// salt ����
		byte[] salt = new byte[8];
		SecureRandom random = new SecureRandom();
		random.nextBytes(salt);
		int iterationCount = 1000; // �ݺ� Ƚ��
		byte[] encryptData = encrypt(password, salt, iterationCount, plainText.getBytes(charset));
		System.out.println(BytesToHexToString.convertToHex(encryptData));

		// ��ȣȭ
		byte[] plainData = decrypt(password, salt, iterationCount, encryptData);
		System.out.println(new String(plainData, charset));

	}

	public static byte[] encrypt(char[] password, byte[] salt, int iterationCount, byte[] plainData)
			throws GeneralSecurityException {
		// �н����带 ����� SecretKey ����
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
		// �н����带 ����� SecretKey ����
		PBEKeySpec keySpec = new PBEKeySpec(password);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		// salt, iteration count�� ���� �Ķ���� ����
		PBEParameterSpec params = new PBEParameterSpec(salt, iterationCount);
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, params);
		byte[] plainData = cipher.doFinal(encryptData);
		return plainData;
	}

}
