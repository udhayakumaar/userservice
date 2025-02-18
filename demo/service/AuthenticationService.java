package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	private final PasswordEncoder passwordEncoder;
	
	public AuthenticationService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	public boolean authenticateUser(String username, String password, String encodedPassword) {
		return passwordEncoder.matches(password, encodedPassword);
	}
}
