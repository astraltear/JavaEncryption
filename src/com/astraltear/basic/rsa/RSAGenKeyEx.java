package com.astraltear.basic.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class RSAGenKeyEx {

	public static void main(String[] args) {

		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(1024);
			KeyPair keyPair = generator.generateKeyPair();

			System.out.println("공개키:"+keyPair.getPublic());
			System.out.println("개인키:"+keyPair.getPrivate());
			
			System.out.println("공개키 포맷:"+keyPair.getPublic().getFormat());
			System.out.println("개인키 포맷:"+keyPair.getPrivate().getFormat());

		} catch (NoSuchAlgorithmException e) {
			System.err.println("usage: java AsymmetricKeyMaker <RSA | DSA>");
		}

	}

}
