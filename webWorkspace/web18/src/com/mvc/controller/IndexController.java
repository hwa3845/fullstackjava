package com.mvc.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController extends HttpServlet {
//	Logger logger = Logger.getGlobal();
	//아무나
//	Logger logger = Logger.getAnonymousLogger();
	//직접 만들어서 찍는 것 (로그를 찍는 주체가 누구인가에 따라)
	//'이 클래스가 사용하는 로그는 이것이다'
	Logger logger = Logger.getLogger("com.mvc.controller.IndexController");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//setLevel로 출력 범위 설정할 수 있음 (예: warning 이상에서만 로그 찍기)
		logger.setLevel(Level.WARNING);
		logger.log(Level.INFO,"call IndexController..");
		RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
		rd.forward(req, resp);
	}
}
