package com.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.beans.Author;
import com.books.exceptions.notAllowedException;
import com.books.repo.AuthorRepo;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepo authorRepo;

	public void addAuthor(Author author) throws notAllowedException {
		List<Author> authors = getAllAuthors();
		for (Author author2 : authors) {
			if (author.getId() == author2.getId()) {
				throw new notAllowedException("cant add author with same id");
			}
		}
		authorRepo.save(author);
	}

	public void updateAuthor(Author author) throws notAllowedException {
		List<Author> authors = getAllAuthors();
		for (Author author2 : authors) {
			if (author.getId() == author2.getId()) {
				authorRepo.saveAndFlush(author);
				return;
			}
			
		}
		throw new notAllowedException("cant update author id");
	}

	public void deleteAuthor(int authorID) {
		authorRepo.deleteById(authorID);;
	}

	public Author getOneAuthor(int authorID) {
		return authorRepo.getOne(authorID);
	}

	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}
	public List<Author>getAuthorByName(String fullName){
		return authorRepo.findByFullName(fullName);
	}
}
