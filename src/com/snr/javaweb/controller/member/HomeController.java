package com.snr.javaweb.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.snr.javaweb.dao.MemberRoleDao;
import com.snr.javaweb.dao.jdbc.JdbcMemberDao;
import com.snr.javaweb.dao.jdbc.JdbcMemberRoleDao;

@WebServlet("/member/home")
public class HomeController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Object _memberId = session.getAttribute("id");

		// 로그인한 적이 없다면 일단 로그인
		if (_memberId == null)
			response.sendRedirect("login?returnURL=home");	// 상대경로로 적기
		else {
			String memberId = _memberId.toString();
			MemberRoleDao memberRoleDao = new JdbcMemberRoleDao();

			String roleId = memberRoleDao.getDeafaultRole(memberId);

			System.out.println(roleId);
			
			if (roleId.equals("ROLE_ADMIN"))
				response.sendRedirect("../admin/index");
			else if (roleId.equals("ROLE_STUDENT"))
				response.sendRedirect("../student/index");
			else
				response.sendRedirect("../index");

		}
	}
}
