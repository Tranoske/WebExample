package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShohinDAO {
	static final String URL =  "jdbc:mysql://localhost/hanbai?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	public Shohin findBySid(int sid) {
		Shohin s = null;
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "SELECT * FROM shouhin WHERE sid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, sid);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				String sname = rs.getString("sname");
				int tanka = rs.getInt("tanka");

				s = new Shohin(sid, sname, tanka);
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("FindBySidエラー"+e.getMessage());
		}

		return s;
	}
	public ArrayList<Shohin> findAll() {
		ArrayList<Shohin> list = new ArrayList<Shohin>();
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "SELECT * FROM shouhin";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				int tanka = rs.getInt("tanka");

				Shohin s = new Shohin(sid, sname, tanka);
				list.add(s);
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("FindAllエラー"+e.getMessage());
		}

		return list;
	}
	public void update(Shohin s) {
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "UPDATE shouhin SET sname = ?, tanka = ? WHERE sid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, s.getName());
			stmt.setInt(2, s.getTanka());
			stmt.setInt(3, s.getSid());
			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("UPDATEエラー"+e.getMessage());
		}
	}
	public void insert(Shohin s) {
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "INSERT INTO shouhin (sname,tanka) VALUES(?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, s.getName());
			stmt.setInt(2, s.getTanka());
			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("INSERTエラー"+e.getMessage());
		}
	}
	public void delete(int sid) {
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "DELETE FROM shouhin WHERE sid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, sid);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("UPDATEエラー"+e.getMessage());
		}
	}
}
