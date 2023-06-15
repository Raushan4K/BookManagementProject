package com.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

	private String bookId;

	private String title;

	private String author;

	private double price;

	private int stockQuantity;

}
