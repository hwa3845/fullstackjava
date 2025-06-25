package com.my.sts.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {

	private final KafkaTemplate<String, String> template;
	
	@KafkaListener(topics = "someTopic")
	public void func(String msg) {
		System.out.println("call event..."+msg);
	}
}
