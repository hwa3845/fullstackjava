package com.my.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter01 implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init1");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("dofilter1");
		PrintWriter out= response.getWriter();
		out.println("<h1>before filter1</h1>");
//		out.close();
		chain.doFilter(request, response);
		//io 안 끊고 request, response 매개변수로 전달하면 누적돼서 같은 IO로 호출됨
		out.println("<h1>after filter1</h1>");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

}
