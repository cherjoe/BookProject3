package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> 
{

	List<Book> findByTitle(String title);
	
	List<Book> findByPriceGreaterThan(Double Price);
	
	List<Book> findByAuthorFirstName(String authorName);
	
}
