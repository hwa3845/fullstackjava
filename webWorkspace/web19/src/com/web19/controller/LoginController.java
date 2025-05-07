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
			//계속 저장돼야 함(로그인된 브라우저 로그아웃 전까지)
			//session으로 -> 접속당 한 개의 (서버의)메모리 공간
			//별도로 값을 설정하지 않으면 기본 시간 30분, 지나면 자동 갱신
			HttpSession session=req.getSession();
			System.out.println(session.getId());
			//session ID 가 10초마다 갱신되는 것 확인 가능(10초 안에서는 같은 ID)
//			session.setMaxInactiveInterval(10);
			session.setAttribute("login", name);
			//application 으로 얻는 방법
//			ServletContext application= req.getServletContext();
//			application.setAttribute("login", name);
			//모든 페이지에서 볼 수 있어야 함 -> index.jsp 부터 받기
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("../");
	}
}
