package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.modules.Author;
import com.example.demo.repository.AuthorRepository;

@RestController
public class AuthorController
{
	@Autowired
	AuthorRepository authorRepo;
	
	@GetMapping("/addauthor")
	public String addAuthor()
	{
		Author author1=new Author("firstName1", "lastName1","email1");
		authorRepo.save(author1);
		
		Author author2=new Author("firstName2", "lastName2","email2");
		authorRepo.save(author2);
		
		return "Authors have been created!!";
	}
	
//	@GetMapping("/author")
	@RequestMapping(value="/authors", method=RequestMethod.GET, 
			produces= {MediaType.APPLICATION_JSON_VALUE} )
	public List<Author> getAuthor()
	{
		return(List<Author>) authorRepo.findAll();
	}

	
	@RequestMapping(value="/authors",method=RequestMethod.POST )
	public String addAuthor1(@RequestBody Author authorToBeCreated)
	{
		authorRepo.save(authorToBeCreated);
		
		return "Author Created";
	}
	
//	@RequestMapping(value="/books",method=RequestMethod.POST )
//	public ResponseEntity<Book> addBook2(@RequestBody Book booksToBeCreated)
//	{
//		
//		Book newlyCreatedBook=bookRepo.save(booksToBeCreated);
//		
//		ResponseEntity respEnt=new ResponseEntity<Book>(newlyCreatedBook, HttpStatus.CREATED);
//		
//		return respEnt;
//		
//	}
	
	@RequestMapping(value="/authors/{idFromHere}",method=RequestMethod.PATCH )
	public ResponseEntity<Author> updateAuthor(@PathVariable(name="idFromHere") Long id,@RequestBody Author authorToBeUpdated)
	{   ResponseEntity respEnt;
		if(authorRepo.existsById(id))
		{
			authorToBeUpdated.setId(id);
			Author updateAuthor=authorRepo.save(authorToBeUpdated);
			
			respEnt=new ResponseEntity<Author>(updateAuthor, HttpStatus.ACCEPTED);
		}
		else
		{
			respEnt=new ResponseEntity<Author>(authorToBeUpdated, HttpStatus.NOT_FOUND);
			return respEnt;		
		}
		return respEnt;	
		
		
	}
	
	
	@RequestMapping(value="/authors/{idFromHere}",method=RequestMethod.DELETE )
	public ResponseEntity<Author> deleteAuthor(@PathVariable(name="idFromHere") Long id)
	{  
		ResponseEntity respEnt;
		if(authorRepo.existsById(id))
		{
		authorRepo.deleteById(id);
		respEnt=new ResponseEntity<String>("Deleted", HttpStatus.OK);
		return respEnt;
		}
		else
		{
		 respEnt=new ResponseEntity<String>("Not Deleted", HttpStatus.NOT_FOUND);
		 return respEnt;
		}
		
		
		
		
	}
	
	@RequestMapping(value="/authors/{idFromHere}",method=RequestMethod.GET )
	public Optional<Author> getAuthorById(@PathVariable(name="idFromHere") Long id)
	{  
		if(authorRepo.existsById(id))
		{
			Optional<Author> author=authorRepo.findById(id);
			return author;
		}
		else
		{
			return null;
		}
		
	}

}
