package com.astraltear.basic;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class EncryptionKeyMaker {

	public static void main(String[] args) {
		String algorithm = "RSA";
		
       try {
           KeyPair keyPair = KeyPairGenerator.getInstance(algorithm).generateKeyPair();

           System.out.println(keyPair.getPublic());
           System.out.println(keyPair.getPrivate());

         } catch (NoSuchAlgorithmException e) {
           System.err.println(
             "usage: java AsymmetricKeyMaker <RSA | DSA>");
         }


	}

}
