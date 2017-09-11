package com.snr.javaweb.controller.customer;

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

@WebServlet("/customer/notice/list")
public class NoticeListController extends HttpServlet{
	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String _title = request.getParameter("title");
		String _page = request.getParameter("p");

		int page = 1; // ������ �ȵ��� �� �⺻��
		String query = ""; // �⺻��

		if (_page != null && !_page.equals(""))
			page = Integer.parseInt(_page);
		
		if (_title != null && !_title.equals(""))
			query = _title;

		/*<dao �κ� - db ���� �ڵ�>*/
		NoticeDao noticeDao = new JdbcNoticeDao();
		
		request.setAttribute("list", noticeDao.getList(page, query));
		request.setAttribute("count", noticeDao.getCount());
		/* db �ٲ��� �� dao������ �ٲٸ� �Ǵ� ���� ���� */
		
		// response.sendRedirect("notice.jsp"); //�ƿ� ���� ���
		request.getRequestDispatcher("/WEB-INF/view/customer/notice/list.jsp").forward(request, response); // �̾ ���
	}

}