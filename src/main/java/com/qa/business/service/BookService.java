package com.qa.business.service;


import java.util.List;


import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.qa.constants.BookConstants;
import com.qa.persistence.domain.Book;
import com.qa.persistence.repository.BookRepository;
import com.qa.sender.Sender;
import com.qa.util.JSONUtility;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private JSONUtility util;
	
	@Autowired
	private Sender sender;

	public String getBooks(String name) {
		Page<Book> books = (Page<Book>) bookRepository.findAll();
		List<Book> bookList = books.filter(b -> b.getName().contains(name)).stream().collect(Collectors.toList());
		String result = "";

		if (bookList.isEmpty()) {

			try {
				bookList = BookSearch.search(name);

				for (Book b : bookList) {
					b.setId(getUniqueId());
					bookRepository.save(b);
					result = util.getJSONForObject(bookList);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			result = util.getJSONForObject(bookList);
		}
		sender.send(BookConstants.REQUEST_MSG);
		return result;
	}

	private int getUniqueId() {
		return (int) StreamSupport.stream(bookRepository.findAll().spliterator(), false).count() + 1;
	}
}
