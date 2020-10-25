package com.books.serviceTesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.books.beans.Author;
import com.books.beans.Book;
import com.books.exceptions.notAllowedException;
import com.books.service.AuthorService;
import com.books.util.printTable;

@Component
@Order(1)
public class AuthorServiceClr implements CommandLineRunner {
	
	@Autowired
	private AuthorService authorService;

	@Override
	public void run(String... args) throws Exception {
	
		System.out.println("~~~~~~~~~~~~~~~~~~~~add author~~~~~~~~~~~~~~~~~~~~~~");
		Author a1 = new Author();
		a1.setFullName("jack bauer");
		Author a2 = new Author();
		a2.setFullName("jack richer");
		Author a3 = new Author();
		a3.setFullName("jack sparrow");
		Author a4 = new Author();
		a4.setFullName("rick grimes");
		Author a5 = new Author();
		a5.setFullName("batman");
		
		Book b1 = new Book("harry potter", 1992);
		Book b2= new Book("spiderman", 1998);
		Book b3 = new Book("the life of jack", 2000);
		
		try {
			authorService.addAuthor(a1);
			authorService.addAuthor(a2);
			authorService.addAuthor(a3);
			authorService.addAuthor(a4);
			authorService.addAuthor(a5);
		} catch (notAllowedException e) {
			System.out.println(e.getMessage());
		}
		printTable.print(authorService.getAllAuthors());
		System.out.println("~~~~~~~~~~~~~~~~~~~~add author not working~~~~~~~~~~~~~~~~~~~~~~");
		try {
			authorService.addAuthor(a1);
		} catch (notAllowedException e) {
			System.out.println(e.getMessage());;
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~add books to author~~~~~~~~~~~~~~~~~~~~~~");
		
		try {
			a1.addBook(b1);
			a2.addBook(b2);
			a3.addBook(b3);
		} catch (notAllowedException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~update author~~~~~~~~~~~~~~~~~~~~~~");
		try {
			a2.setFullName("batmany");
			authorService.updateAuthor(a1);
			authorService.updateAuthor(a2);
			authorService.updateAuthor(a3);
		} catch (notAllowedException e) {
			System.out.println(e.getMessage());
		}
		printTable.print(authorService.getAllAuthors());
		System.out.println("~~~~~~~~~~~~~~~~~~~~update author not working~~~~~~~~~~~~~~~~~~~~~~");
		try {
			a5.setId(10);
			authorService.updateAuthor(a5);
		} catch (notAllowedException e) {
			System.out.println(e.getMessage());
		}
		printTable.print(authorService.getAllAuthors());
		System.out.println("~~~~~~~~~~~~~~~~~~~~delete author~~~~~~~~~~~~~~~~~~~~~~");
		authorService.deleteAuthor(5);
		printTable.print(authorService.getAllAuthors());
		System.out.println("~~~~~~~~~~~~~~~~~~~~get one author~~~~~~~~~~~~~~~~~~~~~~");
		printTable.print(authorService.getOneAuthor(1));
		System.out.println("~~~~~~~~~~~~~~~~~~~~get author by name~~~~~~~~~~~~~~~~~~~~~~");
		printTable.print(authorService.getAuthorByName("rick grimes"));
	}

}
