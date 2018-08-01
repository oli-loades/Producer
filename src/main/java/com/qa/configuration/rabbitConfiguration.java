package com.qa.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitConfiguration {

	@Bean
	Queue Queue() {
		return new Queue(com.qa.constants.RabbitConstants.QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(com.qa.constants.RabbitConstants.TOPIC_EXCHANGE_NAME);
	}

	@Bean
	Binding Binding(Queue putQueue, TopicExchange exchange) {
		return BindingBuilder.bind(putQueue).to(exchange).with("request");
	}

}
