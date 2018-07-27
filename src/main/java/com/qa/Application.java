package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.qa.sender.Sender;

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

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}

}
