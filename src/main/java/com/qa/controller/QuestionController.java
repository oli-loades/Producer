package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.business.service.QuestionService;
import com.qa.persistence.domain.Question;

@RequestMapping("/question")
@RestController
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	 @CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/getAll")
	 public List<Question> getAll(){
		 return questionService.getAll();
	 }
}
