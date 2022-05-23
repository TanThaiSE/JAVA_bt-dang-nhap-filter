package bai_tap_dang_nhap_filter_jsp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bai_tap_dang_nhap_filter_jsp.connection.MySQLConnection;
import bai_tap_dang_nhap_filter_jsp.pojo.Users;



public class UsersModel {
	public Users getUser(String email,String password) {
		Users users=null;
		Connection conn=MySQLConnection.getConnection();
		String sql="SELECT * FROM users where email=? and password=? ";
		try {
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				users=new Users(result.getLong("id"), result.getString("email"),"",result.getString("fullname"), result.getString("avatar"),result.getInt("role_id"));
			}
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}
}
