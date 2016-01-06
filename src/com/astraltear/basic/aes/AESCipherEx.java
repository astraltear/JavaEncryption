package com.astraltear.basic.aes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESCipherEx {

	public static void main(String[] args) throws GeneralSecurityException, IOException {
		// 비밀키 생성
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		String transformation = "AES/ECB/PKCS5Padding";
		File plainFile = new File("files/plain.txt");
		File encryptFile = new File("files/encrypt.txt");
		File decryptFile = new File("files/decrypt.txt");

		{
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			InputStream input = null;
			OutputStream output = null;
			try {
				input = new BufferedInputStream(new FileInputStream(plainFile));
				output = new BufferedOutputStream(new FileOutputStream(encryptFile));
				int read = 0;
				byte[] inBuf = new byte[1024];
				byte[] outBuf = null;
				while ((read = input.read(inBuf)) != -1) {
					outBuf = cipher.update(inBuf, 0, read);
					if (outBuf != null) {
						output.write(outBuf);
					}
				}
				outBuf = cipher.doFinal();
				output.write(outBuf);
			} finally {
				if (output != null)
					try {
						output.close();
					} catch (IOException ie) {
					}
				if (input != null)
					try {
						input.close();
					} catch (IOException ie) {
					}
			}
		}

		{
			// 파일 복호화
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			InputStream input = null;
			OutputStream output = null;
			try {
				input = new BufferedInputStream(new FileInputStream(encryptFile));
				output = new BufferedOutputStream(new FileOutputStream(decryptFile));
				int read = 0;
				byte[] inBuf = new byte[1024];
				byte[] outBuf = null;
				while ((read = input.read(inBuf)) != -1) {
					outBuf = cipher.update(inBuf, 0, read);
					if (outBuf != null) {
						output.write(outBuf);
					}
				}
				outBuf = cipher.doFinal();
				output.write(outBuf);
			} finally {
				if (output != null)
					try {
						output.close();
					} catch (IOException ie) {
					}
				if (input != null)
					try {
						input.close();
					} catch (IOException ie) {
					}
			}
		}

		System.out.println("END");
	}

}
