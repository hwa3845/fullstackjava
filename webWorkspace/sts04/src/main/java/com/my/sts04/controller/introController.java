package com.my.sts04.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.sts04.DeptDao;

@Controller
public class introController {
	Logger log=LoggerFactory.getLogger(getClass());
	
	@Autowired
	DeptDao deptDao;

	@RequestMapping("/intro")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("intro");
	}
	
	@RequestMapping("/ex02")
	public ModelAndView ex02(HttpServletResponse response) throws Exception {
		System.out.println(response);
		return new ModelAndView("ex02");
	}
	
	@RequestMapping("/ex03")
	public String ex03(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(request.getMethod());
		return "ex03";
	}
	
	@RequestMapping("/ex04")
	public String ex04(String id,int su) {
		log.debug(id);
		log.debug(su+"");
		deptDao.func01();
		return "ex04";
	}
	
	
}
