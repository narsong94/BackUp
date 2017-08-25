import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.snr.javaweb.entity.Notice;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/nana")
public class Nana extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// UTF-8로 보냄
		response.setCharacterEncoding("UTF-8");
		// 크롬에서 컨텐트 타입 알려줌
		response.setContentType("text/html; chatset=UTF-8");

		// 문자 단위 특화
		PrintWriter out = response.getWriter();

		// 바이트 단위 특화
		/*
		 * OutputStream os = response.getOutputStream(); PrintStream out = new
		 * PrintStream(os);
		 */

		List<Notice> list = null;
		String title = request.getParameter("title");

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

		/* ------------------view------------------------------- */
		out.write("\r\n");
		out.write("\r\n");
		out.write("<!DOCTYPE html>\r\n");
		out.write("<html>\r\n");
		out.write("<head>\r\n");
		out.write("<meta charset=\"UTF-8\">\r\n");
		out.write("<title>Insert title here</title>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("\t<form action=\"notice\" method=\"get\">\r\n");
		out.write("\t\t<label>검색</label> \r\n");
		out.write("\t\t<input type=\"text\" name=\"title\"/> \r\n");
		out.write("\t\t<input type=\"submit\" />\r\n");
		out.write("\t</form>\r\n");
		out.write("\t<div>result : ");
		out.write("</div>\r\n");

		for (Notice n : list)
			out.println(n.getTitle() + "<br />");
		out.write("</body>\r\n");
		out.write("</html>");
	}
}