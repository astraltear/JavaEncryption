package com.astraltear.basic.md;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;

public class Md5Ex {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String input="djkr@#$@#$#232424324)#$U@#%#KEEK%#rjwlkrwejrkl";
		
		System.out.println(toHexString(Base64.encodeBase64(md5Encode(input))).toString().toUpperCase());
		System.out.println("6443326D6354613261453753694143454D5A66786A673D3D");
		
//		String firstEncode =  toHexString(md5Encode(input)).toString().toUpperCase();
//		System.out.println(firstEncode );
		
//		Integer integer =  Integer.valueOf(firstEncode, 16);
		
//		System.out.println(bytes);
		
//		byte [] secondEncode = Base64.encodeBase64("00C9A77A8A5F0B92622789CBB9DE6B71".getBytes());
//		byte [] secondEncode = Base64.encodeBase64(md5Encode(input));
		
		
//		System.out.println(secondEncode);
//		System.out.println(new String(secondEncode));
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
