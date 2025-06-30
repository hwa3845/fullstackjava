package com.my.sts.controller;

import java.nio.file.AccessDeniedException;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.sts.service.JwtService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApiController {
	final JwtService jwtService;

	@GetMapping("/")
	public String index() {
		return "index page";
	}
	
	@PostMapping("/login")
	public String jwtCreate(@RequestBody Map<String, String> map) throws AccessDeniedException {
		System.out.println(map);
		if(map.get("username").equals("user01") && map.get("password").equals("1234"))
			return jwtService.jwtCreate(map.get("username"));
		else throw new AccessDeniedException("없는 사용자입니다.");
	}
	
	@GetMapping("/dept/")
	public String dept() {
		return "dept list page";
	}
	
	@GetMapping("/emp/")
	public String emp() {
		return "emp list page";
	}
}
