package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.qa.business.service.BookService;
import com.qa.persistence.repository.BookRepository;
import com.qa.sender.Sender;
import com.qa.util.JSONUtility;

@SpringBootApplication
public class Application {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	Sender sender() {
		return new Sender();
	}

	@Bean
	BookService bookService() {
		return new BookService();
	}

	@Bean
	JSONUtility util() {
		return new JSONUtility();
	}

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}

}
