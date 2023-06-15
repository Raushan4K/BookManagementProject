package com.order.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books implements Serializable {

	private String bookId;

	private String title;

	private String author;

	private double price;

	private int stockQuantity;

}
