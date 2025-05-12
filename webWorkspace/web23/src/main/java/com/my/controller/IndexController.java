package com.my.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myframework.Controller;

//url 맵핑 하지 않아도 frontcontroller가 받을 예정
public class IndexController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		return "index";
	}
}
