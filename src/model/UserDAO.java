package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	static final String URL =  "jdbc:mysql://localhost/hanbai?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	public User login(String uname, String pass) {
		User u = null;
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "SELECT * FROM user WHERE uname = ? and pass = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, uname);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				int uid = rs.getInt("uid");
				String mail = rs.getString("mail");

				u = new User(uid, uname, pass, mail);
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("認証失敗。"+e.getMessage());
		}
		return u;
	}
}
