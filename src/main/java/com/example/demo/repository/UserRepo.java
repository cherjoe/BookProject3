package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.User;

public interface UserRepo extends CrudRepository<User, Long>
{

}
