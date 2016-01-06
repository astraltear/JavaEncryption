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
		// 인증키 생성
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
		SecretKey key = keyGenerator.generateKey();
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(key);
		Charset charset = Charset.forName("UTF-8");
		String plainText = "오늘도 별이 바람에 스치운다.";
		// MAC 생성
		byte[] macData = mac.doFinal(plainText.getBytes(charset));
		System.out.println(BytesToHexToString.convertToHex(macData));

	}

}
