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

import com.example.demo.entities.Book;
import com.example.demo.repository.BookRepository;


@RestController
public class BookController
{
	@Autowired
	BookRepository bookRepo;
	
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

	@RequestMapping(value="/books",method=RequestMethod.POST )
	public ResponseEntity<Book> createBook(@RequestBody Book booksToBeCreated)
	{
		
		Book newlyCreatedBook=bookRepo.save(booksToBeCreated);
		
		ResponseEntity respEnt=new ResponseEntity<Book>(newlyCreatedBook, HttpStatus.CREATED);
		
		return respEnt;
		
	}
	
	
	@GetMapping("/books/findbytitle/{titlefromhere}")
	public List<Book> ssgetByTitle(@PathVariable(name="titlefromhere") String title)
	{
		return bookRepo.findByTitle(title);
		
	}
	
	
	@GetMapping("/books/findbyprice/{pricefromhere}")
	public List<Book> ssgetByPrice(@PathVariable(name="pricefromhere") Double price)
	{
		return bookRepo.findByPriceGreaterThan(price);
		
	}
	
	@GetMapping("/books/findbyname/{authorfirstname}")
	public List<Book> getByAuthorFirstName(@PathVariable(name="authorfirstname") String firstName)
	{
		return bookRepo.findByAuthorFirstName(firstName);
		
	}
	
	
	
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
