package com.astraltear.basic.md;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class Md5Ex {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String input="ajlcjalkewjprnkl2@#$3jfklejvle";
		
		String firstEncode =  Md5Ex.toHexString(Md5Ex.md5Encode(input)).toString().toUpperCase();
		System.out.println(firstEncode );
		
		byte [] secondEncode = Base64.encodeBase64(firstEncode.getBytes());
		
		System.out.println(new String(secondEncode,Charset.defaultCharset()));
	}

	public static byte[] md5Encode(String input) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		return messageDigest.digest(input.getBytes());
	}
	
	public static StringBuffer toHexString(byte[] byteData){
		//convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb;
	}

}
