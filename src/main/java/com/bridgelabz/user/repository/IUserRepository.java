package com.bridgelabz.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bridgelabz.user.model.User1Model;

@Repository
public interface IUserRepository extends JpaRepository<User1Model, Integer> {

	public User1Model findByUserFName(String userFName);

	public Optional<User1Model> findByUserEmailAndUserPassword(String userEmail, String userPassword);

	public Optional<User1Model> findByUserEmail(String useremail);

	public User1Model findByUserPassword(String password);

	// public void save(int id);
	public User1Model deleteById(int id);
	// public Optional<User1Model> deleteById(Optional<User1Model> usermodel);

	public void deleteById(User1Model user1Model);

}
