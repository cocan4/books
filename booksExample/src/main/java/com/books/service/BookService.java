package com.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.beans.Book;
import com.books.exceptions.notAllowedException;
import com.books.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;

	public void addBook(Book book) throws notAllowedException {
		List<Book> books = getAllBooks();
		for (Book book2 : books) {
			if (book.getFullName().equalsIgnoreCase(book2.getFullName()) || book.getId() == book2.getId()) {
				throw new notAllowedException("cant add book with same id or name---->");
			}
		}
		bookRepo.save(book);
	}

	public void updateBook(Book book) throws notAllowedException {
		List<Book> books = getAllBooks();
		for (Book book2 : books) {
			if (book.getId() == book2.getId()) {
				bookRepo.saveAndFlush(book);

			}
		}
		throw new notAllowedException("cant update book id ---->");

	}

	public void deleteBook(Book book) {
		bookRepo.delete(book);
		System.out.println("book deleted succesfully");
	}

	public Book getOneBook(int bookID) {
		return bookRepo.getOne(bookID);
	}

	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	public List<Book> getBooksByYear(int year) {
		return bookRepo.findByYear(year);
		
	}
	

	public List<Book> getBooksByMinYear(int year) {
		return bookRepo.findByYearGreaterThan(1990);
		
	}
}
