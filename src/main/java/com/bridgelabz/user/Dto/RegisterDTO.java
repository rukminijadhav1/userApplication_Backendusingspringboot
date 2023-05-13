package com.bridgelabz.user.Dto;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class RegisterDTO {
	private String userFName;
	private String userLName;
	
	private String userEmail;
	private Long userMobileNum;
	private Double userSalary;
	private String userPassword;
	
	
	public String getUserFName() {
		return userFName;
	}
	public String getUserLName() {
		return userLName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public Long getUserMobileNum() {
		return userMobileNum;
	}
	public Double getUserSalary() {
		return userSalary;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}
	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setUserMobileNum(Long userMobileNum) {
		this.userMobileNum = userMobileNum;
	}
	public void setUserSalary(Double userSalary) {
		this.userSalary = userSalary;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}


