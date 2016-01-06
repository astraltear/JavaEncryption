package com.astraltear.basic.md;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.astraltear.basic.utils.BytesToHexToString;

public class ChecksumEx {

	public static void main(String[] args) {
		File file = new File("files/apache-tomcat-8.0.30.zip");
		System.out.println(file.exists());

		String md5Str = "9f496da626e553208aad5950ba5fbd01";
		InputStream inputStream = null;
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("MD5");
			inputStream = new BufferedInputStream(new FileInputStream(file));

			byte buffer[] = new byte[1024];
			int read = -1;
			while ((read = inputStream.read(buffer)) != -1) {
				md.update(buffer, 0, read);
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		byte hash[] = md.digest();
		System.out.println("md5Str:" + md5Str);
		System.out.println("hash:" + BytesToHexToString.convertToHex(hash));
		System.out.println(md5Str.equalsIgnoreCase(BytesToHexToString.convertToHex(hash)));
	}

}
