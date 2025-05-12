package com.myframework;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	Logger logger=Logger.getLogger(this.getClass().getCanonicalName());

	java.util.Map<String, Controller> handlerMapping=new java.util.HashMap<>();

	private GenericServlet config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		Enumeration<String> enu=config.getInitParameterNames();
		config.getInitParameterNames();
		java.util.Map<String, String> map=new java.util.HashMap<>();
		map.put("/index", "com.my.controller.IndexController");
		map.put("/main", "com.my.controller.MainController");
		map.put("/bbs/list", "com.my.controller.ListController");
		map.put("/bbs/insert", "com.my.controller.InsertController");
		
//		Set<Entry<String, String>> set=map.entrySet();
//		Iterator<Entry<String, String>> ite=set.iterator();
		while(enu.hasMoreElements()) {
			String url=enu.nextElement();
			String val=config.getInitParameter(url);
			try {
				Class clz=Class.forName(val);
				handlerMapping.put(url, (Controller) clz.newInstance());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get방식이든
		try {
			doDo(req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post 방식이든 doDo에서 수행할 수 있도록
		try {
			doDo(req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		logger.info(req.getRequestURL().toString());
//		logger.info(req.getRequestURI());
//		logger.info(req.getContextPath());
		String url=req.getRequestURI();
//		url=url.replace(req.getContextPath(), "");
		url=url.substring(req.getContextPath().length());

		//		if(url.equals("/index")) {
////			controller=new IndexController();
//			info="com.my.controller.IndexController";
//		} else if(url.equals("/main")) {
////			controller=new MainController();
//			info="com.my.controller.MainController";
//		} else if(url.equals("/bbs/list")) {
//			info="com.my.controller.ListController";
//		} else if(url.equals("/bbs/insert")) {
//			info="com.my.controller.InsertController";
//		} else {
//			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//		}
		
		Controller controller=handlerMapping.get(url);
		if(controller==null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		String result=controller.execute(req, resp);
		if(result.startsWith("redirect:")) {
			resp.sendRedirect(result.substring("redirect:".length()));
		} else {
			String prifix="/WEB-INF/views/";
			String suffix=".jsp";
			String viewName=prifix+result+suffix;
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}
