package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modules.Book;
import com.example.demo.repository.BookRepository;


@RestController
public class BookController
{
	@Autowired
	BookRepository bookRepo;
	
//	@GetMapping("/addbooks")
//	public String addBooks()
//	{
//		Book book1=new Book( "Book1","Publisher1", "Author1",201.00);
//		bookRepo.save(book1);
//		
//		Book book2=new Book( "Book2","Publisher2", "Author2",202.00);
//		bookRepo.save(book2);
//		
//		return "Books have been created!!";
//	}
	
//	@GetMapping("/books")
	@RequestMapping(value="/books", method=RequestMethod.GET, 
			produces= { MediaType.APPLICATION_JSON_VALUE} )
	public List<Book> getBook()
	{
		for(Book book:bookRepo.findAll())
		{
			System.out.println(book);
		}
		return(List<Book>) bookRepo.findAll();
	}

	
//	@RequestMapping(value="/books",method=RequestMethod.POST )
//	public String addBook1(@RequestBody Book bookToBeCreated)
//	{
//		bookRepo.save(bookToBeCreated);
//		
//		return "Book Created";
//	}
//	
////	@RequestMapping(value="/books",method=RequestMethod.POST )
////	public ResponseEntity<Book> addBook2(@RequestBody Book booksToBeCreated)
////	{
////		
////		Book newlyCreatedBook=bookRepo.save(booksToBeCreated);
////		
////		ResponseEntity respEnt=new ResponseEntity<Book>(newlyCreatedBook, HttpStatus.CREATED);
////		
////		return respEnt;
////		
////	}
//	
//	@RequestMapping(value="/books/{idFromHere}",method=RequestMethod.PATCH )
//	public ResponseEntity<Book> updateBook(@PathVariable(name="idFromHere") Long id,@RequestBody Book bookToBeUpdated)
//	{   ResponseEntity respEnt;
//		if(bookRepo.existsById(id))
//		{
//			bookToBeUpdated.setId(id);
//			Book updateBook=bookRepo.save(bookToBeUpdated);
//			
//			respEnt=new ResponseEntity<Book>(updateBook, HttpStatus.ACCEPTED);
//		}
//		else
//		{
//			respEnt=new ResponseEntity<Book>(bookToBeUpdated, HttpStatus.NOT_FOUND);
//			return respEnt;		
//		}
//		return respEnt;	
//		
//		
//	}
//	
//	
//	@RequestMapping(value="/books/{idFromHere}",method=RequestMethod.DELETE )
//	public ResponseEntity<Book> deleteBook(@PathVariable(name="idFromHere") Long id)
//	{  
//		ResponseEntity respEnt;
//		if(bookRepo.existsById(id))
//		{
//		bookRepo.deleteById(id);
//		respEnt=new ResponseEntity<String>("Deleted", HttpStatus.OK);
//		return respEnt;
//		}
//		else
//		{
//		 respEnt=new ResponseEntity<String>("Not Deleted", HttpStatus.NOT_FOUND);
//		 return respEnt;
//		}
		
		
		
		
//	}
	
}
