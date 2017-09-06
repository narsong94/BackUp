package com.snr.javaweb.controller.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snr.javaweb.dao.NoticeDao;
import com.snr.javaweb.dao.jdbc.JdbcNoticeDao;
import com.snr.javaweb.entity.Notice;

@WebServlet("/member/agree")
public class AgreeController extends HttpServlet{
	@Override

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/member/agree.jsp").forward(request, response); // 이어서 출발
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	      String _agree = request.getParameter("agree");
	      String agree = "no";
	      
	      if(_agree !=null && !_agree.equals(""))
	         agree= _agree;
	      
	      System.out.println(_agree);
	      
	      if(!agree.equals("ok"))
	         response.sendRedirect("agree?error=1");
	      else
	         response.sendRedirect("join");
	}


}