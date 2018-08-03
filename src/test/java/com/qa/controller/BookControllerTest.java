package com.qa.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.BookService;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {
	
	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private BookController endpoint;
	
	@Mock
	private BookService service;
	
	@Before
	public void setup() {
	 endpoint.setBookService(service);
	}
	
	@Test
	public void testGetAll() {
		Mockito.when(service.getBooks(MOCK_VALUE)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.searchBooks(MOCK_VALUE));
	}

}
