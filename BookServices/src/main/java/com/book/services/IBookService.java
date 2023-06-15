package com.book.services;

import java.util.List;

import com.book.model.Books;

public interface IBookService {
	//create book details and save to db --post operation
	public Books saveAllBooks(Books book);

	//get all books from db -- get operation
	public List<Books> getAllBooks();

	//get single book details by using bookId
	public Books getBookById(String bookId);
	
	//update books
	public String updateBook(Books book);
	
	//remove all book
	
	public String removeBook(Books book);
	
	//remove books by bookId
	
	public String removeBookById(String bookId);
	
	
	

}
