package com.kafkaintegration.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaintegration.flow.IntegrationGateways;

@RestController
@RequestMapping("/main")
public class Endpoint {
	@Autowired
	private IntegrationGateways gays;

	@GetMapping("/get/{s}")
	public String messagesent(@PathVariable String s) {
		System.err.println("data in controller");
		gays.send(s);
		return s;
	}

	@GetMapping("/")
	public Student k() {
		return new Student();
	}
}
