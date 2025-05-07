package com.web19.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web19.model.UserDao;

public class LoginController extends HttpServlet {
	UserDao dao=new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		try {
			String name=dao.SelectOne(id, pw);
			//��� ����ž� ��(�α��ε� ������ �α׾ƿ� ������)
			//session���� -> ���Ӵ� �� ���� (������)�޸� ����
			//������ ���� �������� ������ �⺻ �ð� 30��, ������ �ڵ� ����
			HttpSession session=req.getSession();
			System.out.println(session.getId());
			//session ID �� 10�ʸ��� ���ŵǴ� �� Ȯ�� ����(10�� �ȿ����� ���� ID)
//			session.setMaxInactiveInterval(10);
			session.setAttribute("login", name);
			//application ���� ��� ���
//			ServletContext application= req.getServletContext();
//			application.setAttribute("login", name);
			//��� ���������� �� �� �־�� �� -> index.jsp ���� �ޱ�
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("../");
	}
}
