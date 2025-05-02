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
	//�ƹ���
//	Logger logger = Logger.getAnonymousLogger();
	//���� ���� ��� �� (�α׸� ��� ��ü�� �����ΰ��� ����)
	//'�� Ŭ������ ����ϴ� �α״� �̰��̴�'
	Logger logger = Logger.getLogger("com.mvc.controller.IndexController");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//setLevel�� ��� ���� ������ �� ���� (��: warning �̻󿡼��� �α� ���)
		logger.setLevel(Level.WARNING);
		logger.log(Level.INFO,"call IndexController..");
		RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
		rd.forward(req, resp);
	}
}
