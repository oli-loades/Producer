package com.qa.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.qa.constants.BookConstants;
import com.qa.persistence.domain.Book;
import com.qa.persistence.repository.BookRepository;
import com.qa.util.JSONUtility;


public class BookService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private JSONUtility util;
	
	public String getBooks(String name) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		books.stream().filter(b -> b.getName().contains(name));
		String result ;
		if(books.isEmpty()) {
		 result = restTemplate.getForObject(BookConstants.API_ADDRESS, String.class);
		}else {
			result = util.getJSONForObject(books);
		}
		return result;
	}
}
