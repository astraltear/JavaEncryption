package com.astraltear.basic;

import java.security.Provider;
import java.security.Security;

public class BouncyCastleExam {

	public static void main(String[] args) {
		Provider provider = Security.getProvider("BC");
		
		if (provider != null) {
			System.out.println("Bouncy Castle provider is available");
			System.out.println(provider.getInfo());
			
		} else {
			System.out.println("Bouncy Castle provider is NOT available");
		}

	}

}
