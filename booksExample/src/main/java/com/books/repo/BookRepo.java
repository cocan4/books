package com.books.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.beans.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

	public List<Book>findByYear(int year);
	public List<Book>findByYearGreaterThan(int year);
}
