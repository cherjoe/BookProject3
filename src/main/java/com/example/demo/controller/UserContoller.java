package com.example.demo.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import com.example.demo.uimodels.UserRequestModel;
import com.example.demo.uimodels.UserResponseModel;

@RestController
@RequestMapping("/users")
public class UserContoller 
{
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public List<UserResponseModel> getUsers()
	{
		return (List<UserResponseModel>) userService.getUsers();
	}

	@RequestMapping(value="/",method=RequestMethod.POST )
	public UserResponseModel createUser(@RequestBody @Valid UserRequestModel user)
	{
		return userService.saveUser(user);
	}
}
