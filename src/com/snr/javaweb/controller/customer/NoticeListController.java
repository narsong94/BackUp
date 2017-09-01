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

@WebServlet("/customer/notice-list")
public class NoticeListController extends HttpServlet{
	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String _title = request.getParameter("title");
		String _page = request.getParameter("p");

		int page = 1; // 전달이 안됐을 때 기본값
		String query = ""; // 기본값

		if (_page != null && !_page.equals(""))
			page = Integer.parseInt(_page);
		
		if (_title != null && !_title.equals(""))
			query = _title;

		/*<dao 부분 - db 관련 코드>*/
		NoticeDao noticeDao = new JdbcNoticeDao();
		
		request.setAttribute("list", noticeDao.getList(page, query));
		request.setAttribute("count", noticeDao.getCount());
		/* db 바꼈을 때 dao에서만 바꾸면 되는 편리함 가짐 */
		
		// response.sendRedirect("notice.jsp"); //아예 새로 출발
		request.getRequestDispatcher("/WEB-INF/view/customer/notice/list.jsp").forward(request, response); // 이어서 출발
	}

}