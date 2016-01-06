package com.astraltear.basic.mac;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

import com.astraltear.basic.utils.BytesToHexToString;

public class HMACEx {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
		// ����Ű ����
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
		SecretKey key = keyGenerator.generateKey();
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(key);
		Charset charset = Charset.forName("UTF-8");
		String plainText = "���õ� ���� �ٶ��� ��ġ���.";
		// MAC ����
		byte[] macData = mac.doFinal(plainText.getBytes(charset));
		System.out.println(BytesToHexToString.convertToHex(macData));

	}

}
