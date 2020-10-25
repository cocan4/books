package com.books.serviceTesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.books.beans.Book;
import com.books.exceptions.notAllowedException;
import com.books.service.BookService;
import com.books.util.printTable;

@Component
@Order(2)
public class BookServiceClr implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("~~~~~~~~~~~~~~~~~~~~add book~~~~~~~~~~~~~~~~~~~~~~");
		Book b1 = new Book("harry potter", 1992);
		Book b2= new Book("spiderman", 1998);
		Book b3 = new Book("the life of jack", 2000);
		
		try {
			bookService.addBook(b1);
			bookService.addBook(b2);
			bookService.addBook(b3);
		} catch (notAllowedException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~find books by year~~~~~~~~~~~~~~~~~~~~~~");
		printTable.print(bookService.getBooksByYear(1992));
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~find books by minimum year~~~~~~~~~~~~~~~~~~~~~~");
		printTable.print(bookService.getBooksByMinYear(1990));
	}
	
	

}
