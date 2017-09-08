package com.snr.javaweb.controller.admin.notice;

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

import com.snr.javaweb.dao.MemberRoleDao;
import com.snr.javaweb.dao.NoticeDao;
import com.snr.javaweb.dao.jdbc.JdbcMemberRoleDao;
import com.snr.javaweb.dao.jdbc.JdbcNoticeDao;
import com.snr.javaweb.entity.Notice;

@WebServlet("/admin/notice/list")
public class NoticeListController extends HttpServlet{
	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// 인증한 적이 있는지 없다면 로그인 하고와
		
		
		// 왔니? 왔다면 인정정보 줘 그걸로 역할이 admin인지 확인하자
		/*
		String id = request.getParameter("p");
		MemberRoleDao memberRoleDao = new JdbcMemberRoleDao();
		boolean roleHas = memberRoleDao.hasRole(id, "ROLE_ADMIN");*/
		
		// 없다면 에러-권한 없음  페이지로 넘어감
		
		
		String _title = request.getParameter("title");
		String _page = request.getParameter("p");

		int page = 1; 
		String query = "";
		if (_page != null && !_page.equals(""))
			page = Integer.parseInt(_page);
		
		if (_title != null && !_title.equals(""))
			query = _title;

		NoticeDao noticeDao = new JdbcNoticeDao();
		
		request.setAttribute("list", noticeDao.getList(page, query));
		request.setAttribute("count", noticeDao.getCount());
		
		request.getRequestDispatcher("/WEB-INF/view/admin/notice/list.jsp").forward(request, response); // �̾ ���
	}

}