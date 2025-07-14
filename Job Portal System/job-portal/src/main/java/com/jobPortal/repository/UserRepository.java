package com.jobPortal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobPortal.model.User;

@Repository
public class UserRepository {
	
	@Autowired
	private DataSource datasource;
	
	public void save(User user) {
		
		String sql = "INSERT INTO USERS (userName, email, password, role, enabled) VALUES (?,?,?,?,?)";
		
		try(
			Connection conn = datasource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);){
			
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
			ps.setBoolean(5, user.isEnabled());
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				System.out.println("User Details added in DB");
			}else {
				System.out.println("Details not added");
				return;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User findByEmail(String email) {
		String sql = "SELECT * FROM USERS where email = ? ";
		try(Connection conn = datasource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);){
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setUserName(rs.getString("userName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setEnabled(rs.getBoolean("enabled"));
				
				return user;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addLoginDetails(User user) {
		String sql = "INSERT INTO LOGIN_LOG (userName, email, enabled, dateTime_Logged) VALUES (?,?,?,GETDATE() )";
		
		try(
				Connection conn = datasource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
				
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getEmail());
				ps.setBoolean(3, user.isEnabled());
				
				int rows = ps.executeUpdate();
				if(rows > 0) {
					System.out.println("User Login DateTime added in DB");
				}else {
					System.out.println("Details not added");
					return;
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}
	
}
