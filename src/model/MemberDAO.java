package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	static final String URL =  "jdbc:mysql://localhost/club?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	public ArrayList<Member> findAll() {
		ArrayList<Member> list = new ArrayList<Member>();
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "SELECT * FROM member";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int sid = rs.getInt("mid");
				String name = rs.getString("name");
				String adr = rs.getString("adr");

				Member m = new Member(sid, name, adr);
				list.add(m);
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("FindAllエラー"+e.getMessage());
		}

		return list;
	}
	public Member findByMid(int mid) {
		Member m = null;
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "SELECT * FROM member WHERE mid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, mid);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				String name = rs.getString("name");
				String adr = rs.getString("adr");

				m = new Member(mid, name, adr);
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("FindBySidエラー"+e.getMessage());
		}

		return m;
	}
	public void update(Member u) {
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "UPDATE member SET name = ?, adr = ? WHERE mid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getAdr());
			stmt.setInt(3, u.getMid());
			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("UPDATEエラー"+e.getMessage());
		}
	}
	public void insert(Member u) {
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "INSERT INTO member (name,adr) VALUES(?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getAdr());
			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("INSERTエラー"+e.getMessage());
		}
	}
	public void delete(int mid) {
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "DELETE FROM member WHERE mid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, mid);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("UPDATEエラー"+e.getMessage());
		}
	}
}
