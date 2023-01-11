package com.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
public class IntegrationConfig {

	@Bean
	public MessageChannel  reciverchanel()
	{
		return new DirectChannel();
	
	}
//	@Bean
//	public MessageChannel  replychannel()
//	{
//		return new DirectChannel();
//	
//	}
	
}
