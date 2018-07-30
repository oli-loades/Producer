package com.qa.persistence.domain;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "index", type = "book")
public class Book {
	private String name;
	private List<String> author;
	private String descripton;
	private int rating;
	private String linkToBook;
	
	
	
	public Book(String name, List<String> author, String descripton, int rating, String linkToBook) {
		this.name = name;
		this.author = author;
		this.descripton = descripton;
		this.rating = rating;

		this.linkToBook = linkToBook;
	}

	public Book() {
		
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<String> getAuthor() {
		return author;
	}



	public void setAuthor(List<String> list) {
		this.author = list;
	}



	public String getDescripton() {
		return descripton;
	}



	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int d) {
		this.rating = d;
	}



	public String getLinkToBook() {
		return linkToBook;
	}



	public void setLinkToBook(String linkToBook) {
		this.linkToBook = linkToBook;
	}

}
