package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modules.Book;
import com.example.demo.repository.BookRepository;

@SpringBootApplication
public class BookMain {

	public static void main(String[] args) {
		SpringApplication.run(BookMain.class, args);
	}

	
	
	@Autowired
	BookRepository bookRepo;
	
	@PostConstruct
	public void postConsructMethod()
	{
		Book book1=new Book( "Book_1", "Author_1");
		bookRepo.save(book1);
		
		Book book2=new Book( "Book_2", "Author_2");
		bookRepo.save(book2);
	}
}
