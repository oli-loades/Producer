package com.qa.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.QuestionService;
import com.qa.persistence.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerTest {

	private static final List<Question> MOCK_VALUE = new ArrayList<>();

	@InjectMocks
	private QuestionController endpoint;
	
	@Mock
	private QuestionService service;
	
	@Before
	public void setup() {
	 endpoint.setQuestionService(service);
	}
	
	@Test
	public void testGetAll() {
		Mockito.when(service.getAll()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAll());
	}


}
