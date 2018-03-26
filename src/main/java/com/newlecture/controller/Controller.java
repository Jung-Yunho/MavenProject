package com.newlecture.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String service(HttpServletRequest request, HttpServletResponse response);
}
