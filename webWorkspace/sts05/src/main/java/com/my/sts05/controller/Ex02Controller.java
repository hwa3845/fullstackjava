package com.my.sts05.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex02Controller {

	@RequestMapping("/ex11.do")
	public ModelAndView ex11() {
		return new ModelAndView("ex01","msg","hello1");
	}
	
	@RequestMapping("/ex12.do")
	public String ex11(HttpServletRequest req) {
		req.setAttribute("msg", "hello2");
		return "ex01";
	}
	
	@RequestMapping("/ex13.do")
	public String ex11(Model model) {
		model.addAttribute("msg","hello3");
		return "ex01";
	}
	
	@RequestMapping("/ex14.do")
	public String ex12(@RequestParam(value = "id") String id) {
		System.out.println("param id:"+id);
		return "ex01";
	}

	@RequestMapping("/ex15.do")
	public String ex13(String id) {
		//넘어오는 파라미터 값과 변수명이 같으면 생략 가능
		//다르면 어노테이션으로 명세
		System.out.println("param id:"+id);
		return "ex01";
	}
	
}
