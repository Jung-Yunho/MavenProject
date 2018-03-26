package com.newlecture.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherController extends HttpServlet {
	
	private Map<String, Controller> urlMap;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		String pathUrl = config.getInitParameter("path");
		if(pathUrl == null)
			pathUrl = "/WEB-INF/mapper.properties";
		
		String pathSystem = config.getServletContext().getRealPath(pathUrl);
		FileInputStream fis;
		try {
			fis = new FileInputStream(pathSystem);
			Properties prop = new Properties();	//파일입출력이 가능한 맵
			prop.load(fis);
			
			urlMap = new HashMap<>();
			for(Object key : prop.keySet()) {
				try {
					String url = String.valueOf(key);
					String className = String.valueOf(prop.get(key));
					Controller controller = (Controller)Class.forName(className).newInstance();
					urlMap.put(url, controller);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
	      
		String ctxPath = request.getContextPath();
		String requestUrl = request.getRequestURI();
		String viewUrl = null;
		
		requestUrl = requestUrl.replace(ctxPath,"");
	      //out.printf("getRequestURL : %s<br />\n", request.getRequestURL());
	      //out.printf("getRequestURI : %s<br />\n", request.getRequestURI());
	      //out.printf("getContextPath : %s<br />\n", request.getContextPath());
	      //out.printf("getMethod : %s<br />\n", request.getMethod());
	      //out.printf("getQueryString : %s<br />\n", request.getQueryString());	
		/*
		Map<String,Controller> map = new HashMap<>();
		map.put("/index.htm", new IndexController());
		map.put("/notice/list.htm", new ListController());
		 */
		
		Controller controller = urlMap.get(requestUrl);
		
		if(controller != null) {
			viewUrl = controller.service(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
			dispatcher.forward(request,response);
		}
		else
			response.sendRedirect("/error404");
		
		//prop.save(fos, null);	//	저장 메서드
		//prop.load(fis);			//	입력 메서드
		
		//String[] urls = new String[] {"/index.htm","/notice/list.htm"};
		//Controller[] ctrl = new Controller[] {new IndexController(),new ListController()};
		
		/*
		for(String url : map.keySet()) {
			if(url.equals(requestUrl)) {
				viewUrl = map.get(url).service(request, response);
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
				dispatcher.forward(request,response);
				
				break;
			}
		}
		
		if(viewUrl == null)
			response.sendRedirect("/error404");
		*/
		/*
		switch(viewUrl) {
			case "/index.htm":{
				viewUrl = ctrl[0].service(request, response);
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
				dispatcher.forward(request,response);
			}
			case "/notice/list.htm":{
				viewUrl = ctrl[1].service(request, response);
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
				dispatcher.forward(request,response);
			}
			default:{
				response.sendRedirect("/error404");
			}
		}
		*/
		/*
		String viewUrl = "";
		if("index 라는 요청이 들어오면")
			viewUrl = new IndexController().service(request, response);*/
		/*
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
		
		dispatcher.forward(request,response);
		*/
		/*request.setAttribute("model", "MVC");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		
		dispatcher.forward(request,response);*/
	}
}
