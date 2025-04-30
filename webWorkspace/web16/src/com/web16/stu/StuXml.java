package com.web16.stu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StuXml extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/xml");	//xml ∏ÌΩ√«ÿ¡‡æﬂ 
		PrintWriter out=resp.getWriter();
		
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.print("<stus>");
		for(int i=0; i<5; i++) {
			out.print("<stu>");
			out.print("<num>"+(1000+i)+"</num>");
			out.print("<name>user"+(1+i)+"</name>");
			out.print("<kor>"+(90+i)+"</kor>");
			out.print("<eng>"+(80+i)+"</eng>");
			out.print("<math>"+(70+i)+"</math>");
			out.print("</stu>");
		}
		out.print("</stus>");
		out.close();
	}
}
