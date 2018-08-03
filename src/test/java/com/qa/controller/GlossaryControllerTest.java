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

import com.qa.business.service.GlossaryService;
import com.qa.persistence.domain.GlossaryEntry;

@RunWith(MockitoJUnitRunner.class)
public class GlossaryControllerTest {

	private static List<GlossaryEntry> MOCK_LIST;
	private final GlossaryEntry MOCK_VALUE = new GlossaryEntry();
	private final String MOCK_STRING = "mock";

	@InjectMocks
	private GlossaryController endpoint;

	@Mock
	private GlossaryService service;

	@Before
	public void setup() {
		MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(MOCK_VALUE);
		endpoint.setGlossaryService(service);
	}

	@Test
	public void testGetAll() {
		Mockito.when(service.getAll()).thenReturn(MOCK_LIST);
		Assert.assertEquals(MOCK_LIST, endpoint.getAll());
	}

	@Test
	public void testGet() {
		Mockito.when(service.getDefiniton(MOCK_STRING)).thenReturn(MOCK_STRING);
		Assert.assertEquals(MOCK_STRING, endpoint.getDefinition(MOCK_STRING));
	}
}
