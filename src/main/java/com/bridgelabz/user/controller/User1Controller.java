package com.bridgelabz.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.user.Response;
import com.bridgelabz.user.Dto.LoginDto;
import com.bridgelabz.user.Dto.RegisterDTO;

import com.bridgelabz.user.Service.IuserService;
import com.bridgelabz.user.Utilities.JwtUtilities;
import com.bridgelabz.user.model.User1Model;
import com.bridgelabz.user.repository.IUserRepository;



@RestController
@RequestMapping("/User1")
public class User1Controller {

	@Autowired
	IuserService service;
	
	Logger logger=LoggerFactory.getLogger(User1Controller.class);

	@RequestMapping("/hello")
	public String userInfo() {
		logger.info("info");
		logger.warn("warn");
		logger.debug("debug");
		logger.error("error");
		logger.trace("trace");
		
		return "Hello World";

	}

	@PostMapping("/adduser")
	public ResponseEntity<Response> addUser(@RequestBody RegisterDTO registerdto) {
		User1Model usermodel = service.addUser(registerdto);
		Response response = new Response("user added successfully", usermodel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	

	@GetMapping("/fetch")
	public ResponseEntity<RegisterDTO> fetchUser(@RequestParam String email, @RequestParam String password) {
		RegisterDTO registerdto = service.getUser(email, password);

		Response response = new Response("user fetch successfully using email and password", registerdto);

		return new ResponseEntity<>(registerdto, HttpStatus.OK);
	}

	@GetMapping("/fetchUsers")
	public List<RegisterDTO> getAllUser(@RequestParam String token) {
		List<RegisterDTO> userdata = service.getAllUsers(token);
		Response response = new Response("user fetch successfully ");
		return userdata;
	}

	@DeleteMapping("/deleterecord")
	public ResponseEntity<Response> deleteUser(@RequestHeader String token) {
		service.deleteByToken(token);
		Response response = new Response("user delete successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity updateData(@RequestHeader String token, @RequestBody RegisterDTO registerdto) {
		User1Model registerdto1 = service.updateDataByToken(token, registerdto);
		Response response = new Response("user update successfully", registerdto1);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	/*
	 * @PutMapping("/update/{userFName}") public
	 * ResponseEntity<Response>updateDataByName(@PathVariable String
	 * userFName,@RequestBody RegisterDTO registerdto) { User1Model
	 * usermodel=service.updateData(userFName, registerdto); Response response = new
	 * Response("user update successfully", usermodel); return new
	 * ResponseEntity<>(response, HttpStatus.OK);
	 * 
	 * }
	 * 
	 */
	
	@PostMapping("/Login")
	public ResponseEntity<Response> login(@RequestBody LoginDto logindto) {
		String token=service.login(logindto);
		Response response = new Response("Login Successfully",token);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	 @PutMapping("/Logout")
     public ResponseEntity<Response> logOutUser(@RequestHeader String token) {
         service.logOutUser(token);
         Response response = new Response("User Logout");
         return  new ResponseEntity<>(response, HttpStatus.OK);
     }
	
	/*
	 * @GetMapping("/parseToken") public String
	 * parseToken(@RequestHeader(value="token")String token) { return null;
	 * 
	 * }
	 */
}
