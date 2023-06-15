package com.book.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_table")
public class Books {
	@Id
	private String bookId;

	private String title;

	private String author;

	private double price;

	private int stockQuantity;

}
