package com.astraltear.basic.md;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.astraltear.basic.utils.BytesToHexToString;


public class MessageDigestEx {

	public static void main(String[] args) {
		Charset charset = Charset.forName("UTF-8");
		String plainText="¿À´Ãµµ º°ÀÌ ¹Ù¶÷¿¡ ½ºÄ¡¿î´Ù.¤¸¤§¼i¯…¤¤¤·œ´Ù°Å¤¿¤Ó¤·ÇØ¤Ä¤±¤¸¤§tµ¦¤¸´õ±â¤¿¤·¤©Èü¤¸¤§°Ô¤À¤¸´õ°Ô¤À";
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
