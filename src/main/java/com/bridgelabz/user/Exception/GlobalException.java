package com.bridgelabz.user.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bridgelabz.user.Response;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value=UserException.class)
	public Response handleUserException(UserException exception) {
		
		return new Response(exception.getMessage(),null);
		
	}

}
