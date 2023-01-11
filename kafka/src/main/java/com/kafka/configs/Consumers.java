package com.kafka.configs;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component

public class Consumers {

	@KafkaListener(topics = "studentrequestsformspring", groupId = "student")
	public void listenGroupFoo(String message) {
		System.out.println("Received Message in group foo: " + message);
	}
}
