package com.my.sts.controller;

import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class mainController {
	
	@GetMapping("/")
	public ResponseEntity<?> index() {
		String url="https://dummyjson.com/carts";
		RestTemplate template;
		template=new RestTemplate();
		
//		ResponseEntity<Map> result=template.getForEntity(url, Map.class);
//		return result;
//		Map result=template.getForObject(url, Map.class);
//		return ResponseEntity.ok(result);
		
		//get방식으로 접근하지만 요청은 post 방식이고 싶을 때
//		return template.postForEntity(url, null, String.class);
		
		Map req=Map.of("limit","1");
		  //JSON 형식 (헤더 값 아직 못 찾음)
		  RequestEntity<Map> requestEntity = RequestEntity
		        .post(url)
		        .contentType(MediaType.APPLICATION_JSON)
		        .header("x-authorization", "abcd")
		        .header("custom-header", "fffff")
		        .body(req);
		return template.exchange(url, HttpMethod.POST, requestEntity, String.class, Map.of("limit", "1"));

	}
}
