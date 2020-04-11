package com.example.demo;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.modules.Book;
import com.example.demo.repository.BookRepository;

@SpringBootApplication
public class BookMain {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(BookMain.class, args);
		
		String [] beanNames=context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String bean:beanNames)
		{
			System.out.println(bean);
		}
//		SpringApplication.run(BookMain.class, args);
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
