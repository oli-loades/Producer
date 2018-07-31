package com.qa.business.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import com.qa.constants.BookConstants;
import com.qa.persistence.domain.Book;
import com.qa.util.JSONUtility;


import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class BookSearch {

	  private static JSONUtility json = new JSONUtility();
	  private static final String APPLICATION_NAME = "QA-WebGame";
	  @SuppressWarnings("null")
	  private static ArrayList<Book> queryGoogleBooks(JsonFactory jsonFactory, String query) throws Exception {
	      
	      ArrayList<Book> bookList = new ArrayList<Book>();
	      int rating =0;
	      
	      
	      final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
	              .setApplicationName(APPLICATION_NAME)
	              .setGoogleClientRequestInitializer(new BooksRequestInitializer(BookConstants.API_KEY)).build();

	      List volumesList = books.volumes().list(query+" for beginner kids");
	      
	      Volumes volumes = volumesList.execute();

	      for (Volume volume : volumes.getItems()) {
	          
	          
	    	  Book book = new Book(); 
	          Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
	        
	          book.setName(volumeInfo.getTitle());
	          book.setAuthor(volumeInfo.getAuthors());
	          book.setDescripton(volumeInfo.getDescription());
	          if (volumeInfo.getRatingsCount() != null && volumeInfo.getRatingsCount() > 0) {
	          rating =(int) Math.round(volumeInfo.getAverageRating().doubleValue());}
	          book.setRating(rating);
	          book.setLinkToBook(volumeInfo.getInfoLink());
	          bookList.add(book);

	      }
	     // return json.getJSONForObject(bookList);
	      return bookList;
	      }
	  

	  public static ArrayList<Book> search(String bookName) throws Exception {
	      JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
	      return queryGoogleBooks(jsonFactory, bookName);

	  }
	  

	  
}
