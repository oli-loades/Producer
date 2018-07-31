package com.qa.business.service;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.client.RestTemplate;

import com.qa.persistence.domain.Book;
import com.qa.persistence.repository.BookRepository;
import com.qa.util.JSONUtility;

public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private JSONUtility util;

	public String getBooks(String name) {
		Page<Book> books = (Page<Book>) bookRepository.findAll();
		List<Book> bookList = books.filter(b -> !b.getName().contains(name)).stream().collect(Collectors.toList());
		String result = "";

		if (bookList.isEmpty()) {

			// Book[] booksArray = restTemplate.getForObject(BookConstants.API_ADDRESS +
			// name, Book[].class);

			try {
				bookList = BookSearch.search(name);

				for (Book b : bookList) {
					b.setId(getUniqueId());
					bookRepository.save(b);
					result = util.getJSONForObject(bookList);
					// bookList.add(b);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			result = util.getJSONForObject(bookList);
		}
		return result;
	}

	private int getUniqueId() {
		return (int) StreamSupport.stream(bookRepository.findAll().spliterator(), false).count() + 1;
	}
}
