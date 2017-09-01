package com.snr.javaweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.snr.javaweb.dao.NoticeDao;
import com.snr.javaweb.entity.Notice;
import com.snr.javaweb.entity.NoticeView;

public class JdbcNoticeDao implements NoticeDao{

	public List<NoticeView> getList(int page, String query) {
		
		List<NoticeView> list = null;
		int offset = (page - 1) * 10;

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "SELECT * FROM NoticeView WHERE title like ? order by regDate DESC limit ?, 10";

		// Jdbc 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 / 인증
			Connection conn = DriverManager.getConnection(url, "sist", "cclass"); // dclass

			// 실행
			/* Statement st = conn.createStatement(); */
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, offset);

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			list = new ArrayList<>();

			while (rs.next()) {
				NoticeView n = new NoticeView();

				n.setId(rs.getString("id"));
				n.setTitle(rs.getString("title"));
				n.setWriterId(rs.getString("writerId"));
				n.setWriterName(rs.getString("writerName"));
				n.setContent(rs.getString("content"));
				n.setRegDate(rs.getDate("regDate"));
				n.setHit(rs.getInt("hit"));
				n.setCountCmt(rs.getInt("CountCmt"));
				
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
		return list;
	}

	public int getCount() {

		int count = 0;
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sqlCount = "SELECT COUNT(*) AS count FROM Notice";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(url, "sist", "cclass"); // dclass

			Statement stCount = conn.createStatement();
			ResultSet rsCount = stCount.executeQuery(sqlCount);
			rsCount.next();
			count = rsCount.getInt("count");

			rsCount.close();
			stCount.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public NoticeView get(String id) {
		
		NoticeView n = null;
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "SELECT * FROM NoticeView WHERE id like ?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "sist", "cclass");
			// Statement st = conn.createStatement();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				n = new NoticeView();
				
				n.setId(rs.getString("id"));
				n.setTitle(rs.getString("title"));
				n.setContent(rs.getString("content"));
				n.setRegDate(rs.getDate("regDate"));
				n.setHit(rs.getInt("hit"));
				n.setWriterId(rs.getString("writerId"));
			}

			rs.close();
			st.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	@Override
	public int update(String id, String title, String content) {
		int result = 0;
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "UPDATE Notice SET title=?, content=? WHERE id LIKE ?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "sist", "cclass");
			// Statement st = conn.createStatement();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, id);
			
			result = st.executeUpdate();
			
			st.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int insert(String title, String content) {
		int result = 0;

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "INSERT INTO Notice(title, content) VALUES(?, ?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			
			result = st.executeUpdate();
			
			st.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
