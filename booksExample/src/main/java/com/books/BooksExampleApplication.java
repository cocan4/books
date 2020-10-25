package com.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksExampleApplication.class, args);
		System.out.println("ioc is loaded");
	}

}
