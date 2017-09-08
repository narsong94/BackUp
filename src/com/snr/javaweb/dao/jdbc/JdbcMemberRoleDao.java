package com.snr.javaweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.snr.javaweb.dao.MemberRoleDao;

public class JdbcMemberRoleDao implements MemberRoleDao {

	@Override
	public String getDeafaultRole(String memberId) {

		String roleId = "";

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String sql = "select * from MemberRole where memberId=? and defaultRole=1;";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "sist", "cclass");
			// Statement st = conn.createStatement();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, memberId);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				roleId = rs.getString("roleId");
			}

			rs.close();
			st.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roleId;
	}
}
