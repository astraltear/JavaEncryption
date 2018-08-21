package com.astraltear.basic.springsecurity;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordEncoderGeneratorSpring {

//	It's normal to get a different value each time you hash a value with BCrypt, 
//	because salt is generated randomly. In this tutorial
	
	public static void main(String[] args) {
		
		int i = 0;
		
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		StandardPasswordEncoder standardPasswordEncoder  = new StandardPasswordEncoder();
		
		String salt = BCrypt.gensalt(12);
		
		System.out.println("salt["+salt+"]");
		
		
		
		System.out.println("result==>"+bCryptEncoder.matches("123456", "$2a$10$f.PtOO1JmU/jeAzuYPDPUuosPEU.Wt52M.7opzJw1PAmoFcFnBMt2"));
		System.out.println("result==>"+bCryptEncoder.matches("123456", "$2a$10$JZKYsaFtwbmM1KgoQoc4qu/u6yUR6qqL02JrkJWjdVyc8c7ch8yVa"));
		System.out.println("result==>"+bCryptEncoder.matches("123456", "$2a$10$dVVc65vxHfA0sKXDCf4pxu3NzDDCWZiutV6qY5BJ778Ji.iyoHxeG"));
		System.out.println("result==>"+bCryptEncoder.matches("123456", "$2a$10$ZSYze0mbxd8vR7FLcSECvelgtuVg9nLfvlV3yKODxLiJnGkLeqSKC"));
		System.out.println("result==>"+bCryptEncoder.matches("123456", "$2a$10$5.BHU4C3e5IGZnpCzPvZpuejOWb7yMiK.p4ua.u7o7x03SR8iR9Km"));
		System.out.println("result==>"+bCryptEncoder.matches("123456", "$2a$10$qK2KwpvAWeI5O./gBxm5b.Q.OO8O3JxdJ/c8uKg4GUQjCnzpE/4C2"));
		System.out.println("result==>"+bCryptEncoder.matches("123456", "$2a$10$LscsZOW0OLDsXsas0Ww1lODLRGxvUPipCm1PTkxfasxTc0eDdPCxi"));
		
		
		while (i < 10) {
			String password="123456";
			String bCryptPassword = bCryptEncoder.encode(password);
			System.out.println("result==>"+bCryptEncoder.matches(password, bCryptPassword));
			
			
//			String standarPassword = standardPasswordEncoder.encode(password);
//			System.out.println("bCryptPassword["+bCryptPassword+"]standarPassword["+standarPassword+"]BCrypt.hashpw["+BCrypt.hashpw(password, salt)+"]");
			i++;
		}
	}

}
