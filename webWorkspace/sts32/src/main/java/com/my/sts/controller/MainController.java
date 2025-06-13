package com.my.sts.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/")
	public String index() {
		return "home";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/ex01")
	public @ResponseBody String ex01(Principal principal) {
		String name=principal.getName();
		return "ex01 page" + name;
	}
	
	@GetMapping("/ex02")
	public @ResponseBody String ex02(Authentication auth) {
		String name=auth.getName();
		Collection<? extends GrantedAuthority> list=auth.getAuthorities();
		boolean result=auth.isAuthenticated();
		User principal=(User) auth.getPrincipal();
		log.debug(principal.toString());
		return "ex02 page<br>"+name+"<br/>"+list+"<br/>"+result;
	}
	
	@GetMapping("/ex03")
	public @ResponseBody String ex03(@AuthenticationPrincipal User user) {
		log.debug(user.toString());
		return "ex03 page";
	}
	
	@GetMapping("/ex04")
	public @ResponseBody String ex04() {
		SecurityContext ctxt=SecurityContextHolder.getContext();
		Authentication auth = ctxt.getAuthentication();
		String name=auth.getName();
		return "ex04 page "+name;
	}
}
