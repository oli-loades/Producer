package com.qa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.business.service.BookService;

//@RequestMapping("/book")
@RestController
public class BookController {
	
	@Autowired
	public BookService bookService;

	@RequestMapping("book/search/{name}")
	@ResponseBody
	public String searchBooks(@PathVariable("name") String name) {
		return bookService.getBooks(name);
		//return "java book";
	}
}
