package com.books.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.beans.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

	public List<Author>findByFullName(String name);
		
}
