package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.business.service.GlossaryService;
import com.qa.persistence.domain.GlossaryEntry;

@RequestMapping("/glossary")
@RestController
public class GlossaryController {
	
	@Autowired
	private GlossaryService glossaryService;
	
	  @CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/get/{keyword}")
	public String getDefinition(@PathVariable String keyword) {
		return glossaryService.getDefiniton(keyword);
	}
	
	  @CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getAll")
	public List<GlossaryEntry> getAll() {
		return glossaryService.getAll();
	}
}
