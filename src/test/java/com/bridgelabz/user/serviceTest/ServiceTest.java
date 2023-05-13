package com.bridgelabz.user.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.bridgelabz.user.Service.User1Service;
import com.bridgelabz.user.model.User1Model;
import com.bridgelabz.user.repository.IUserRepository;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
	
	
	IUserRepository repo = Mockito.mock(IUserRepository.class);

	
	@InjectMocks
	User1Service userService;
	
	
	List<User1Model> userModel=new ArrayList<>();
	@Test
	public void whenFetchDataAllUserShouldReturnData() {
	User1Model userModel1=new User1Model();                   
	User1Model userModel2=new User1Model();                   
	userModel.add(userModel1);
	userModel.add(userModel2);
	when(repo.findAll()).thenReturn(userModel);
	assertEquals(2,repo.findAll().size());
}
}
