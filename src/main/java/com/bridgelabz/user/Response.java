package com.bridgelabz.user;



public class Response {

	String message;
	Object user;

	public Response(String message, Object userModel) {

		this.message = message;
		this.user = userModel;
	}

	public Response(String message) {
		this.message=message;

	}

	public String getMessage() {
		return message;
	}

	public Object getUser() {
		return user;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setUser(Object userModel) {
		this.user = userModel;
	}

}
