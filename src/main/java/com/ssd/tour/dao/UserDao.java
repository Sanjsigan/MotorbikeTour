package com.ssd.tour.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssd.tour.model.Hotel;
import com.ssd.tour.model.Users;

public class UserDao {

	private static UserDao newInstance = new UserDao();

	public static UserDao getInstance() {
		return newInstance;
	}

	private UserDao() {

	}

	public Users LoginChecker(String email, String password) {
		Users user = new Users();
		
		try {
			
			Connection connection = Configs.getDbConnection();
			String sql = "SELECT * FROM signup WHERE user_email=? AND password=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				user = new Users();
				user.setId(rs.getInt("id"));
				user.setMail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("username"));
				user.setRole(USER_ROLES.valueOf(rs.getString("role")));
			}
 			connection.close();
 			
 			return user;
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		return user;
	}

	// Fetching data from database.
	public Object getAll() {
		List<Users> carList = new ArrayList<Users>();

		try {

			Connection conn = Configs.getDbConnection();

			String sql = "SELECT * FROM signup";// Query to be execute
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery(); // Query execution.

			while (resultSet.next()) {
				Users user = new Users();

				user.setId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("user_name"));
				user.setAddress(resultSet.getString("user_address"));
				user.setMobile(resultSet.getInt("user_mobile"));
				user.setMail(resultSet.getString("user_email"));
				user.setPassword(resultSet.getString("password"));

				carList.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());

			Map<String, String> errMsg = new HashMap<String, String>();
			errMsg.put("Error", e.getMessage());

			return errMsg;

		}

		return carList;

	}

	// Fetching a single data from database.
	public Users get(int user_id) {
		Users user = new Users();

		try {

			Connection conn = Configs.getDbConnection();

			String sql = "SELECT * FROM user WHERE user_id = ?";// Query to be execute
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, user_id); // binding the parameter value, 1 is for specify first parameter.

			ResultSet resultSet = preparedStatement.executeQuery(); // Query execution.

			while (resultSet.next()) {

				user.setId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("user_name"));
				user.setAddress(resultSet.getString("user_address"));
				user.setMobile(resultSet.getInt("user_mobile"));
				user.setMail(resultSet.getString("user_email"));
				user.setPassword(resultSet.getString("password"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}

		return user;

	}

	public boolean add(Users user) throws ClassNotFoundException, SQLException {

		if (user != null) {

			Connection connection = Configs.getDbConnection();
			String sql = "INSERT INTO `signup` (`user_id`,`user_name`, `user_address`, `user_mobile`, `user_email`,`password`) "
					+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, user.getId());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getAddress());
			stmt.setInt(4, user.getMobile());
			stmt.setString(5, user.getMail());
			stmt.setString(6, user.getPassword());

			int count = stmt.executeUpdate();

			if (count > 0) {
				System.out.println("Successfull Added");
				return true;
			} else {
				System.out.println("Error occured");
			}

		}

		return false;

	}
	public boolean updatUser(Users user) throws ClassNotFoundException, SQLException {
		if (user != null) {
			Connection connection = Configs.getDbConnection();
			String sql = "UPDATE signup SET user_name = ?, user_address = ?, user_mobile = ?,user_email = ?,password = ?";
			sql += " WHERE user_id = ?";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, user.getId());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getAddress());
			stmt.setInt(4, user.getMobile());
			stmt.setString(5, user.getMail());
			stmt.setString(6, user.getPassword());

			int count = stmt.executeUpdate();

			if (count > 0) {
				System.out.println("Successfull updated");
				return true;
			} else {
				System.out.println("Error occured");
			}
		}
		return false;
	}

}
