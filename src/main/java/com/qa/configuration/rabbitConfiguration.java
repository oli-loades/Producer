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
	Queue putQueue() {
		return new Queue(com.qa.constants.RabbitConstants.PUT_QUEUE_NAME, false);
	}

	@Bean
	Queue postQueue() {
		return new Queue(com.qa.constants.RabbitConstants.POST_QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(com.qa.constants.RabbitConstants.TOPIC_EXCHANGE_NAME);
	}

	@Bean
	Binding putBinding(Queue putQueue, TopicExchange exchange) {
		return BindingBuilder.bind(putQueue).to(exchange).with("put");
	}

	@Bean
	Binding postBinding(Queue postQueue, TopicExchange exchange) {
		return BindingBuilder.bind(postQueue).to(exchange).with("post");
	}
}
