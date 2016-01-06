package com.astraltear.basic.aes;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import com.astraltear.basic.utils.BytesToHexToString;

public class AESCBCWithIvEx {

	public static void main(String[] args) throws GeneralSecurityException {
		// ���Ű ����
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();

		// IV ����
		SecureRandom random = new SecureRandom();
		byte[] ivData = new byte[16]; // 128 bit
		random.nextBytes(ivData);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(ivData);
		Charset charset = Charset.forName("UTF-8");

		// ��ȣȭ
		String plainText = "���õ� ���� �ٶ��� ��ġ���.";
		byte[] encryptData = encrypt(secretKey, ivParameterSpec, plainText.getBytes(charset));
		System.out.println(BytesToHexToString.convertToHex(encryptData));

		// ��ȣȭ
		byte[] plainData = decrypt(secretKey, ivParameterSpec, encryptData);
		System.out.println(new String(plainData, charset));

	}

	public static byte[] encrypt(SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] plainData)
			throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
		byte[] encryptData = cipher.doFinal(plainData);
		return encryptData;
	}

	public static byte[] decrypt(SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] encryptData)
			throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		byte[] plainData = cipher.doFinal(encryptData);
		return plainData;
	}

}
