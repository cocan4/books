package com.books.exceptions;

public class notAllowedException extends Exception {

	public notAllowedException(String message) {
		super(message+" operation not allowed");
		
	}

}
