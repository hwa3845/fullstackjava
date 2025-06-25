package com.my.sts.components;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.sts.model.DeptVo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {
	private final ObjectMapper objectMapper;
	final KafkaTemplate<String, Object> template;
	
	@KafkaListener(topics = "pic02", groupId = "myGroup")
	public void event(String msg) throws JsonMappingException, JsonProcessingException {
		DeptVo bean=objectMapper.readValue(msg, DeptVo.class);
		try {
			//insert into
			throw new RuntimeException();
		}catch(Exception e) {
			template.send("ex",objectMapper.writeValueAsString(bean));
		}
		System.out.println(bean);
	}
	
	@KafkaListener(topics = "ex", groupId = "myGroup")
	public void back(String msg) throws JsonMappingException, JsonProcessingException {
		DeptVo bean=objectMapper.readValue(msg, DeptVo.class);
		try {
			//delete from
			throw new RuntimeException();
		}catch(Exception e) {
			template.send("ex",objectMapper.writeValueAsString(bean));
		}
		System.out.println(bean);
	}
}
