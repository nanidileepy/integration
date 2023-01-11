package com.kafka.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaConfigs {

	@Configuration
	public class KafkaTopicConfig {
	    
	
	   

	    @Bean
	    public KafkaAdmin kafkaAdmin() {
	        Map<String, Object> configs = new HashMap<>();
	        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
	        return new KafkaAdmin(configs);
	    }
	    
	    @Bean
	    public NewTopic topic1() {
	         return new NewTopic("studentrequestsformspring", 5, (short) 1);
	    }
	}
}
