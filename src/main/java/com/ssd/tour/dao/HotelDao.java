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

public class HotelDao {
	private static HotelDao newInstance = new HotelDao();

	public static HotelDao getInstance() {
		return newInstance;
	}

	public Object getAll() {
		List<Hotel> hotelList = new ArrayList<Hotel>();

		try {

			Connection conn = Configs.getDbConnection();

			String sql = "SELECT * FROM HotelDetails";// Query to be execute
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery(); // Query execution.

			while (resultSet.next()) {
				Hotel hotel = new Hotel();

				hotel.setId(resultSet.getInt("hotel_id"));
				hotel.setName(resultSet.getString("hotel_name"));
				hotel.setAddress(resultSet.getString("hotel_address"));
				hotel.setAmount(resultSet.getDouble("hotel_amount"));

				hotelList.add(hotel);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());

			Map<String, String> errMsg = new HashMap<String, String>();
			errMsg.put("Error", e.getMessage());

			return errMsg;

		}
		return hotelList;

	}

	// Fetching a single data from database.
	public Hotel get(int hotel_id) {
		Hotel hotel = new Hotel();

		try {

			Connection conn = Configs.getDbConnection();

			String sql = "SELECT * FROM hotel WHERE hotel_id = ?";// Query to be execute
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, hotel_id); // binding the parameter value, 1 is for specify first parameter.

			ResultSet resultSet = preparedStatement.executeQuery(); // Query execution.

			while (resultSet.next()) {

				hotel.setId(resultSet.getInt("hotel_id"));
				hotel.setName(resultSet.getString("hotel_name"));
				hotel.setAddress(resultSet.getString("hotel_address"));
				hotel.setAmount(resultSet.getDouble("hotel_amount"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}

		return hotel;

	}

	public boolean add(Hotel hotel) throws ClassNotFoundException, SQLException {

		if (hotel != null) {

			Connection connection = Configs.getDbConnection();
			String sql = "INSERT INTO `HotelDetails` (`hotel_id`,`hotel_name`, `hotel_address`, `hotel_amount`) "
					+ "VALUES (?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, hotel.getId());
			stmt.setString(2, hotel.getName());
			stmt.setString(3, hotel.getAddress());
			stmt.setDouble(4, hotel.getAmount());

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

}
