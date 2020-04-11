package com.example.demo.modules;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="books")
public class Book 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String book_author;
	
	@Column(name="book_name", nullable=false, length=20)
	private String bookName;
	
	
	private Book() {}

	public Book(String name, String author) {
		super();
		this.id = id;
		this.book_author = author;
		this.bookName = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return book_author;
	}

	public void setAuthor(String author) {
		this.book_author = author;
	}

	public String getName() {
		return bookName;
	}

	public void setName(String name) {
		this.bookName = name;
	}

}
