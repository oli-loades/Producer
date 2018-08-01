package com.qa;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


import com.qa.business.service.BookService;
import com.qa.business.service.GlossaryService;
import com.qa.business.service.QuestionService;
import com.qa.sender.Sender;
import com.qa.util.JSONUtility;

@SpringBootApplication
public class Application {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}

}
