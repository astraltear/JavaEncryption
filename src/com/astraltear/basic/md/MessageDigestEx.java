package com.astraltear.basic.md;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.astraltear.basic.utils.BytesToHexToString;


public class MessageDigestEx {

	public static void main(String[] args) {
		Charset charset = Charset.forName("UTF-8");
		String plainText="오늘도 별이 바람에 스치운다.";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(plainText.getBytes(charset));
			
			byte hash[] = md.digest();
			
			System.out.println( BytesToHexToString.convertToHex(hash));
			; 
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}

}
