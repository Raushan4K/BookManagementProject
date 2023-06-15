package com.book.exception;

public class ResourceNotFound extends RuntimeException {
	
	public ResourceNotFound() {
		super("Resources not found  !! ");

	}

	public ResourceNotFound(String message)
	{
		super(message);

	}
	

}
