package com.example.demo;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.sound.sampled.AudioFileFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;

@SpringBootApplication
public class BookMain {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(BookMain.class, args);
		
		String [] beanNames=context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String bean:beanNames)
		{
//			System.out.println(bean);
		}
//		SpringApplication.run(BookMain.class, args);
	}

	
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	AuthorRepository authorRepo;
	
	@PostConstruct   //Inserting Values in Database
	public void postConsructMethod()
	{
		Author author1=new Author("abc", "efg", "dfdfg@djfh");
		authorRepo.save(author1);
		
		Author author2=new Author("ghf", "efdffg", "ddgdgfdfg@djfh");
		authorRepo.save(author2);
		
		
		Book book1=new Book( "Book_1","Publisher_1", author1,100.0);
		bookRepo.save(book1);
		
		Book book2=new Book( "Book_2","Publisher_2", author2,101.0);
		bookRepo.save(book2);
	}
	
}
