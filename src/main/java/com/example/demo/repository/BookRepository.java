package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modules.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> 
{

	List<Book> findByTitle(String title);
	
	List<Book> findByPriceGreaterThan(Double Price);
}
