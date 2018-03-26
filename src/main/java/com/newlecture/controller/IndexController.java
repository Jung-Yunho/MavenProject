package com.newlecture.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{

	/*
	public String service(HttpServletRequest request, HttpServletResponse response){
		
		request.setAttribute("model", "index data");
		//request.setAttribute("view", "/WEB-INF/views/index.jsp");

		return "/WEB-INF/views/index.jsp";	//Dispatcher에게 반환해줄 Model/View;
	}
*/
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> model = new HashMap<>();
		model.put("model", "index data");
		
		return new ModelAndView("/WEB-INF/views/index.jsp",model);
	}
}
