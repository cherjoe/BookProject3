package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modules.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>
{
	
}
