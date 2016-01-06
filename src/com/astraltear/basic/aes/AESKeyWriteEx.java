package com.astraltear.basic.aes;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESKeyWriteEx {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		
		byte[] keyData = secretKey.getEncoded();
		
		System.out.println("Algorithm :"+ secretKey.getAlgorithm());
		System.out.println("Format:"+secretKey.getFormat());
		
		File keyFile = new File("files/scretKey.raw");
		OutputStream out = new BufferedOutputStream(new FileOutputStream(keyFile));
		
		out.write(keyData);
		out.close();
	}

}
