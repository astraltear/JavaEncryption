package com.astraltear.basic.rsa;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyFactoryEx {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// ����Ű�� ����
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(1024);
		
		KeyPair pair = generator.generateKeyPair();
		Key publicKey = pair.getPublic();
		Key privateKey = pair.getPrivate();
		
		System.out.println("����Ű ���� : " + publicKey.getFormat());
		System.out.println("����Ű ���� : " + privateKey.getFormat());
		
		byte[] publicKeyBytes = publicKey.getEncoded();
		byte[] privateKeyBytes = privateKey.getEncoded();
		
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
		PrivateKey priKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
		
		System.out.println(publicKey.equals(pubKey));
		System.out.println(privateKey.equals(priKey));
	}

}
