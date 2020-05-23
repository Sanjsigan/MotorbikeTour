package com.ssd.tour.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssd.tour.model.Bike;
import com.ssd.tour.model.Packages;

public class BikeDao {
	private static BikeDao newInstance = new BikeDao();

	public static BikeDao getInstance() {
		return newInstance;
	}

	public Object getAll() {
		List<Bike> bikeList = new ArrayList<Bike>();

		try {

			Connection conn = Configs.getDbConnection();

			String sql = "SELECT * FROM BikeDetails";// Query to be execute
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery(); // Query execution.

			while (resultSet.next()) {
				Bike bike = new Bike();

				bike.setId(resultSet.getInt("bike_id"));
				bike.setModel(resultSet.getString("bike_model"));
				bike.setMaximumHorse(resultSet.getString("bike_horse"));
				bike.setAmount(resultSet.getDouble("bike_amount"));

				bikeList.add(bike);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());

			Map<String, String> errMsg = new HashMap<String, String>();
			errMsg.put("Error", e.getMessage());

			return errMsg;

		}
		return bikeList;

	}

	// Fetching a single data from database.
	public Bike get(int bike_id) {
		Bike bike = new Bike();

		try {

			Connection conn = Configs.getDbConnection();

			String sql = "SELECT * FROM bike WHERE bike_id = ?";// Query to be execute
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, bike_id); // binding the parameter value, 1 is for specify first parameter.

			ResultSet resultSet = preparedStatement.executeQuery(); // Query execution.

			while (resultSet.next()) {

				bike.setId(resultSet.getInt("bike_id"));
				bike.setModel(resultSet.getString("bike_model"));
				bike.setMaximumHorse(resultSet.getString("bike_horse"));
				bike.setAmount(resultSet.getDouble("bike_amount"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}

		return bike;

	}

	public boolean add(Bike bike) throws ClassNotFoundException, SQLException {

		if (bike != null) {

			Connection connection = Configs.getDbConnection();
			String sql = "INSERT INTO `BikeDetails` (`bike_id`,`bike_model`, `bike_horse`, `bike_amount`) "
					+ "VALUES (?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, bike.getId());
			stmt.setString(2, bike.getModel());
			stmt.setString(3, bike.getMaximumHorse());
			stmt.setDouble(4, bike.getAmount());

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
	public boolean updateBook(Bike bike) throws ClassNotFoundException, SQLException {
		if (bike != null) {
			Connection connection = Configs.getDbConnection();
			String sql = "UPDATE book SET bike_name = ?, bike_model = ?, bike_horse = ?, bike_amount=?";
			sql += " WHERE bike_id = ?";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, bike.getId());
			stmt.setString(2, bike.getModel());
			stmt.setString(3, bike.getMaximumHorse());
			stmt.setDouble(4, bike.getAmount());


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
