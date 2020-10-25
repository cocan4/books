package com.books.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.books.exceptions.notAllowedException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullName;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}, orphanRemoval = true)
	private List<Book>books=new ArrayList<>();
	
	public void addBook(Book book) throws notAllowedException {
		for (Book book2 : books) {
			if (book.getFullName().equalsIgnoreCase(book2.getFullName())) {
				throw new notAllowedException("cant add book with same id or name---->");
			}
		}
		books.add(book);
	}
}
