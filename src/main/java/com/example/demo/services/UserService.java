package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.uimodels.UserRequestModel;
import com.example.demo.uimodels.UserResponseModel;

@Service    //This Class Interacts with Repository
public class UserService
{
	@Autowired
	UserRepo userRepo;
	
	public List<UserResponseModel> getUsers()
	{
		//Check the permission and more business logic
		List<UserResponseModel> userResponseArray=new ArrayList<UserResponseModel>();
		ModelMapper modelMapper= new ModelMapper();
		
		for(User user: userRepo.findAll())
		{
			userResponseArray.add(modelMapper.map(user, UserResponseModel.class));
		}
		return userResponseArray;
	}

	public UserResponseModel saveUser(UserRequestModel userRequest)
	{	
		ModelMapper modelMapper= new ModelMapper();
		User user=userRepo.save(modelMapper.map(userRequest, User.class));
		//password encrypted
		return modelMapper.map(user, UserResponseModel.class);
	}
}
