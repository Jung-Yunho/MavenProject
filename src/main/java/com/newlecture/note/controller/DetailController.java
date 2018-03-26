package com.newlecture.note.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class DetailController implements Controller{

	/*
	public String service(HttpServletRequest request, HttpServletResponse response){
		
		request.setAttribute("model", "list data");
		//request.setAttribute("view", "/WEB-INF/views/index.jsp");

		return "/WEB-INF/views/note/detail.jsp";	//Dispatcher에게 반환해줄 Model/View;
	}
*/
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<>();
		model.put("model", "detail data");
		
		return new ModelAndView("/WEB-INF/views/note/detail.jsp",model);
	}
}
