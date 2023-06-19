package com.lcwd.rating.exception;

public class ResourceNotFondException extends RuntimeException{

	public ResourceNotFondException() {
		super("Resource not found on server !!");
	}
	public ResourceNotFondException(String message) {
		super(message);
	}
}
