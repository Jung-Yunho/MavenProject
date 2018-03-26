package com.newlecture.note.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListController implements Controller{

	/*
	public String service(HttpServletRequest request, HttpServletResponse response){
		
		request.setAttribute("model", "list data");
		//request.setAttribute("view", "/WEB-INF/views/index.jsp");

		return "/WEB-INF/views/note/list.jsp";	//Dispatcher에게 반환해줄 Model/View;
	}
*/
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/note/list.jsp");
		mv.addObject("model", "list data");
		
		return mv;
	}
}
