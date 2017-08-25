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

import com.snr.javaweb.entity.Notice;

@WebServlet("/customer/notice-list")
public class NoticeListController extends HttpServlet {
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Notice> list = null;
		String _title = request.getParameter("title");

		String title = "";

		if(_title != null && !_title.equals(""))
			title = _title;

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "SELECT * FROM Notice WHERE title like ?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "sist", "cclass");
			// Statement st = conn.createStatement();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" + title + "%");
			ResultSet rs = st.executeQuery();

			list = new ArrayList<>();

			while (rs.next()) {
				Notice n = new Notice();

				n.setId(rs.getString("ID"));
				n.setTitle(rs.getString("TITLE"));
				n.setContent(rs.getString("CONTENT"));

				list.add(n);
			}

			rs.close();
			st.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("list", list);

		/*application.setAttribute("x", "어");
		session.setAttribute("x", "세");
		request.setAttribute("x", "리");
		//pageContext.setAttribute("x", "페");
*/
		
		request.getRequestDispatcher("/WEB-INF/view/customer/notice/list.jsp").forward(request, response);
	}
}
