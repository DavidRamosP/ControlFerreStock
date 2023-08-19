package com.cibertec.FerreStockApp.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncriptadorPassword {

	public static void main(String[] args) {
		
		System.out.println(EncriptadorPassword.encode("password1"));
	}

	
	static String encode(String password) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
}
