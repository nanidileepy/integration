package com.kafkaintegration.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.kafka.dsl.Kafka;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class Flows {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Value("${kafka.topic.spring-integration-kafka}")
	String topicName;

	@Bean
	public IntegrationFlow flow1() {
		return IntegrationFlows.from("dataSendToKafka").filter(s -> s != null).transform(String.class, this::m)
				.handle(Kafka.outboundChannelAdapter(kafkaTemplate).topic(topicName).messageKey("Dileep")).get();
	}

	public String m(String s) {
		System.err.println("data in transformer");

		return s + "Dileep";
	}
}
