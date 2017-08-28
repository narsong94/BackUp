package com.snr.javaweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.sun.net.httpserver.HttpServer;

@WebServlet("/index")
public class IndexController extends HttpServlet{
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}
}
