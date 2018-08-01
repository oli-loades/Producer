package com.qa.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.constants.RabbitConstants;

@Component
public class Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(String msg) {
		 rabbitTemplate.convertAndSend(RabbitConstants.TOPIC_EXCHANGE_NAME, RabbitConstants.QUEUE_NAME, msg);
	}

}
