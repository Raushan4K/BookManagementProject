package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.model.Books;

public interface IBookRepository extends JpaRepository<Books, String> {
	
	

}
