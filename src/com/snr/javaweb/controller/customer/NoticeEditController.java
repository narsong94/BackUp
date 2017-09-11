package com.snr.javaweb.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snr.javaweb.dao.NoticeDao;
import com.snr.javaweb.dao.jdbc.JdbcNoticeDao;
import com.snr.javaweb.entity.Notice;

@WebServlet("/customer/notice/edit")
public class NoticeEditController extends HttpServlet {
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		NoticeDao noticeDao = new JdbcNoticeDao();
		
		request.setAttribute("notice", noticeDao.get(id));
		
		request.getRequestDispatcher("/WEB-INF/view/customer/notice/edit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		NoticeDao noticeDao = new JdbcNoticeDao();
		
		noticeDao.update(id, title, content);
		
		response.sendRedirect("detail?id="+id);
	}
}
