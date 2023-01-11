package com.DSLtransform.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

//@Configuration
public class ChannelConfig {

	
	
	
	@Bean
	public MessageChannel queueChannel() {
	return MessageChannels.queue().get();
	}
	@Bean
	public MessageChannel publishSubscribe() {
	return MessageChannels.publishSubscribe().get();
	}
	
	
	@Bean
	public IntegrationFlow channelFlow() {
	return IntegrationFlows.from("input")
	.fixedSubscriberChannel()
	.channel("queueChannel")
	.channel(publishSubscribe())
	.channel("output")
	.get();
	}
	
	
	@ServiceActivator(inputChannel = "queueChannel")
	public  String queueChannelImpl(Message<String> message)
	{
		System.err.println("queueChannel Channel Implemetcs");
		return message.getPayload();
	}
	
	@ServiceActivator(inputChannel = "output")
	public  String outputImpl(Message<String> message)
	{
		System.err.println("out put Channel Implemetcs");
		return message.getPayload();
	}
	
	
	
	
}
