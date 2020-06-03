package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class KbanDAO {
	static final String URL =  "jdbc:mysql://localhost/kban?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	public ArrayList<Kban> findAll() {
		ArrayList<Kban> list = new ArrayList<Kban>();
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "SELECT * FROM kban ORDER BY hi DESC";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int kid = rs.getInt("kid");
				Timestamp hi = rs.getTimestamp("hi");
				String name = rs.getString("name");
				String bun = rs.getString("bun");

				Kban k = new Kban(kid, hi, name, bun);
				list.add(k);
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("FindAllエラー"+e.getMessage());
		}

		return list;
	}
	public Kban findBykid(int kid) {
		Kban k = null;
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "SELECT * FROM kban WHERE kid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, kid);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				Timestamp hi = rs.getTimestamp("hi");
				String name = rs.getString("name");
				String bun = rs.getString("bun");

				k = new Kban(kid, hi, name, bun);
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("FindByKidエラー"+e.getMessage());
		}

		return k;
	}
	public void insert(Kban k) {
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "INSERT INTO kban (hi,name,bun) VALUES(NOW(),?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, k.getName());
			stmt.setString(2, k.getBun());
			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("INSERTエラー"+e.getMessage());
		}
	}
	public void delete(int kid) {
		try(Connection con = DriverManager.getConnection(URL,USER,PASS);) {
			String sql = "DELETE FROM kban WHERE kid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, kid);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("UPDATEエラー"+e.getMessage());
		}
	}
}
