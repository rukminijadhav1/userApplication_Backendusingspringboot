package com.bridgelabz.user.Dto;

import org.springframework.stereotype.Component;

@Component
public class LoginDto {

	private String userEmail;
	private String userPassword;
	
	
	public String getUserEmail() {
		return userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

	
}
