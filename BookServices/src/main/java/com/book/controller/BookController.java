package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Books;
import com.book.repository.IBookRepository;
import com.book.services.BookServicesImplementation;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookServicesImplementation bookService;
	@Autowired
	IBookRepository bookRepo;

	@PostMapping
	public ResponseEntity<Books> createBookDetails(@RequestBody Books book) {
		Books saveAllBooks = bookService.saveAllBooks(book);

		return new ResponseEntity<>(saveAllBooks, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Books>> getAllBooks() {
		List<Books> allBooks = bookService.getAllBooks();
		return new ResponseEntity<List<Books>>(allBooks, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/{bookId}") public ResponseEntity<Books>
	 * getBookById(@PathVariable String bookId) { Books bookById =
	 * bookService.getBookById(bookId); return new ResponseEntity<Books>(bookById,
	 * HttpStatus.OK); }
	 */

	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> deleteBookById(@PathVariable String bookId) {
		String msg = bookService.removeBookById(bookId);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteBook(@PathVariable Books book) {
		String msg = bookService.removeBook(book);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateBook(@RequestBody Books book) {
		String msg = bookService.updateBook(book);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping("/purchase/{id}")
	public Books purchaseBookById(@PathVariable String id) {
		Books puchaseBook = bookService.puchaseBook(id);
		return puchaseBook;
	}

	@GetMapping("/getBookById/{bookId}")
	public ResponseEntity<?> getBookById(@PathVariable String bookId) {
		Books bookById = bookService.getBookById(bookId);
		return new ResponseEntity<>(bookById, HttpStatus.ACCEPTED);
	}
	
	

}
