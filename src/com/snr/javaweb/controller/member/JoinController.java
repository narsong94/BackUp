package com.snr.javaweb.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snr.javaweb.dao.MemberDao;
import com.snr.javaweb.dao.jdbc.JdbcMemberDao;
import com.snr.javaweb.entity.Member;

@WebServlet("/member/join")
public class JoinController extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.getRequestDispatcher("/WEB-INF/view/member/join.jsp").forward(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      String id = request.getParameter("id");
      String[] pwds = request.getParameterValues("pwd");
      String moon = request.getParameter("moon");
      String name = request.getParameter("name");
      String gender = request.getParameter("gender");
      String birthday = request.getParameter("birthday");
      String phone = request.getParameter("phone");
      
      MemberDao memberDao = new JdbcMemberDao();
/*      int result = memberDao.insert(id,pwds[0], moon, name, gender, birthday, phone);*/
      Member member = new Member(id,pwds[0], moon, name, gender, birthday, phone);
      int result = memberDao.insert(member);
      
      if(result >0)
         response.sendRedirect("confirm");
      else
         response.sendRedirect("?error=1");
            
   }
   
}