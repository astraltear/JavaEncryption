package com.astraltear.basic;

import java.security.SecureRandom;

import com.astraltear.basic.utils.BytesToHexToString;

public class SecureRandomEx {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();

		byte bytes[] = new byte[16];
		random.nextBytes(bytes);

		System.out.println(BytesToHexToString.convertToHex(bytes));
	}
}
