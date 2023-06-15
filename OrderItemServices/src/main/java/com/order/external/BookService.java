package com.order.external;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.model.Books;

@Service
@org.springframework.cloud.openfeign.FeignClient(name = "BOOK-SERVICE")
public interface BookService {

	@GetMapping("/book/getBookById/{bookId}")
	public Books getBookById(@PathVariable(name = "bookId") Long bookId);

}
