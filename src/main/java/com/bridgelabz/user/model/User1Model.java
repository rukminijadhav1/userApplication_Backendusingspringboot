package com.bridgelabz.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User1Model {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String userFName;
	private String userLName;

	private String userEmail;
	private Long userMobileNum;
	private Double userSalary;
	private String userPassword;
	private String role;
	

	private boolean isLogin = false;

	

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public int getId() {
		return id;
	}

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

	public void setId(int id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	


	
	
	

}
