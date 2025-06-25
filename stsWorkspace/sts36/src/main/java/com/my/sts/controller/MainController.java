package com.my.sts.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {
	private final KafkaTemplate<String, String> template;
	
	@GetMapping("/")
	public String index(String msg) {
		template.send("someTopic", msg);
		return msg;
	}
	
}
