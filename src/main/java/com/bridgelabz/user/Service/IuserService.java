package com.bridgelabz.user.Service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.user.Dto.LoginDto;
import com.bridgelabz.user.Dto.RegisterDTO;
import com.bridgelabz.user.model.User1Model;

public interface IuserService {

	RegisterDTO getUser(String email, String password);

	// public Optional<User1Model>findByUserEmail(String email);
	User1Model addUser(RegisterDTO registerdto);
	// User1Model addUser1(RegisterDTO registerdto);

	User1Model updateDataByToken(String token, RegisterDTO registerdto);

	// List<RegisterDTO> getAllUsers();

	String login(LoginDto logindto);

	void logOutUser(String token);

	void deleteByToken(String token);
	List<RegisterDTO> getAllUsers(String token);

	
	

	
}
