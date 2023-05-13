package com.bridgelabz.user.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.user.Dto.LoginDto;
import com.bridgelabz.user.Dto.RegisterDTO;
import com.bridgelabz.user.Exception.UserException;
import com.bridgelabz.user.Utilities.EmailService;
import com.bridgelabz.user.Utilities.JwtUtilities;
import com.bridgelabz.user.model.User1Model;
import com.bridgelabz.user.repository.IUserRepository;

@Service
public class User1Service implements IuserService {

	@Autowired
	IUserRepository userRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	EmailService emailService;

	@Autowired
	JwtUtilities jwtUtility;

	@Override
	public User1Model addUser(RegisterDTO registerdto) {

		if (userRepo.findByUserEmail(registerdto.getUserEmail()).isPresent()) {
			throw new UserException("email id is present");

		} else {

			User1Model userModel = modelMapper.map(registerdto, User1Model.class);
			userModel.setRole("admin");
			userRepo.save(userModel);
			emailService.sendMail(registerdto.getUserEmail(), "Congratulations",
					"hello user welcome to our application");
		}
		return null;
	}

	@Override
	public RegisterDTO getUser(String email, String password) {

		User1Model user = userRepo.findByUserEmailAndUserPassword(email, password).get();
		// RegisterDTO register = modelMapper.map(usermodel, RegisterDTO.class);
		return usertoDto(user);

	}

	@Override
	public void deleteByToken(String token) {
		String email = jwtUtility.getEmailFromToken(token);
		Optional<User1Model> usermodel = userRepo.findByUserEmail(email);
		if (usermodel.isPresent()) {
			if (usermodel.get().isLogin()) {
				userRepo.delete(usermodel.get());

			} else
				throw new UserException("user is not active");
		} else
			throw new UserException("invalid email");

	}

	@Override
	public User1Model updateDataByToken(String token, RegisterDTO registerdto) {
		String email = jwtUtility.getEmailFromToken(token);
		User1Model user = modelMapper.map(registerdto, User1Model.class);

		if (userRepo.findByUserEmail(email).isPresent()) {
			User1Model userModel = userRepo.findByUserEmail(email).get();
			if (userModel.isLogin()) {

			//	User1Model user1 = modelMapper.map(registerdto, User1Model.class);
				userModel.setId(user.getId());

				if (user.getUserFName() == null) {
					user.setUserFName(userModel.getUserFName());
				}
				if (user.getUserLName() == null) {
					user.setUserLName(userModel.getUserLName());
				}
				if (user.getUserEmail() == null) {
					user.setUserEmail(userModel.getUserEmail());
				}
				if (user.getUserMobileNum() == null) {
					user.setUserMobileNum(userModel.getUserMobileNum());
				}
				if (user.getUserSalary() == null) {
					user.setUserSalary(userModel.getUserSalary());
				}
				if (user.getUserPassword() == null) {
					user.setUserPassword(userModel.getUserPassword());
				}
				return userRepo.save(user);
			}
			throw new UserException("please login ");
		}
		throw new UserException("Id is invalid");

	}

	@Override
	public List<RegisterDTO> getAllUsers(String token) {
		if (userRepo.count() == 0) {
			throw new UserException("you dont have any data");
		} 
		if (userRepo.findByUserEmail(token).get().getRole().equals("Admin")) {
			
				List<User1Model> usermodel1 = this.userRepo.findAll();
				List<RegisterDTO> userdto = usermodel1.stream().map(user -> this.usertoDto(user))
						.collect(Collectors.toList());
				return userdto;
		}
		throw new UserException("Not Accessable to You");
		
}
	
	

	/*
	 * @Override public User1Model updateData(String userFName, RegisterDTO
	 * registerdto) { User1Model userModel = userRepo.findByUserFName(userFName);
	 * User1Model user = modelMapper.map(registerdto, User1Model.class);
	 * user.getUserFName(); user.setId(userModel.getId()); if (user.getUserLName()
	 * == null) { user.setUserLName(userModel.getUserLName()); } if
	 * (user.getUserEmail() == null) { user.setUserEmail(userModel.getUserEmail());
	 * } if (user.getUserMobileNum() == null) {
	 * user.setUserMobileNum(userModel.getUserMobileNum()); } if
	 * (user.getUserSalary() == null) {
	 * user.setUserSalary(userModel.getUserSalary()); } if (user.getUserPassword()
	 * == null) { user.setUserPassword(userModel.getUserPassword()); }
	 * 
	 * return userRepo.save(user);
	 * 
	 * }
	 * 
	 */

	public RegisterDTO usertoDto(User1Model user) {
		RegisterDTO registerdto = this.modelMapper.map(user, RegisterDTO.class);
		return registerdto;
	}

	public User1Model dtoToUser(RegisterDTO registerdto) {
		User1Model user = this.modelMapper.map(registerdto, User1Model.class);
		return user;
	}

	@Override
	public String login(LoginDto logindto) {
		if (userRepo.findByUserEmail(logindto.getUserEmail()) != null) {
			if (userRepo.findByUserEmail(logindto.getUserEmail()).get().getUserPassword()
					.equals(logindto.getUserPassword())) {

				String token = jwtUtility.generateToken(logindto);

				User1Model userModel = userRepo.findByUserEmail(logindto.getUserEmail()).get();
				userModel.setLogin(true);

				userRepo.save(userModel);

				return token;

			}
			throw new UserException("Check your Password");

		}
		throw new UserException("check Email");

	}

	@Override
	public void logOutUser(String token) {
		String email = jwtUtility.getEmailFromToken(token);
		Optional<User1Model> usermodel = userRepo.findByUserEmail(email);
		if (usermodel.isPresent()) {
			if (usermodel.get().isLogin()) {
				usermodel.get().setLogin(false);
				userRepo.save(usermodel.get());

			} else
				throw new UserException("user is not active");
		} else
			throw new UserException("invalid email");

	}


	

	

}
