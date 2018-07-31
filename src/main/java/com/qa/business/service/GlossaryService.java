package com.qa.business.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.qa.constants.GlossaryConstants;
import com.qa.persistence.domain.GlossaryEntry;
import com.qa.persistence.repository.GlossaryRepository;

public class GlossaryService {
	
	@Autowired 
	private GlossaryRepository glossaryRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getDefiniton(String keyword) {
		Optional<GlossaryEntry> ge = glossaryRepository.findByKeyword(keyword);
		String def;
		if(ge.isPresent()) {
			def = ge.get().getDefinition();
		}else {
			def = restTemplate.getForObject(GlossaryConstants.API_GET_ADDRESS+keyword, String.class);
		}
		return def;
	}
	
	public List<GlossaryEntry> getAll(){
		List<GlossaryEntry> ge = (List<GlossaryEntry>) glossaryRepository.findAll();
		if(ge.isEmpty()) {
			GlossaryEntry[] geArray = restTemplate.getForObject(GlossaryConstants.API_GET_ALL_ADDRESS, GlossaryEntry[].class);
			ge = Arrays.asList(geArray);
		}
		return ge;
	}
}