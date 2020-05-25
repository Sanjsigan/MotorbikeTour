package com.ssd.tour.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssd.tour.model.Booking;
import com.ssd.tour.model.Packages;

public class BookingDao {
	
	private static BookingDao newInstance = new BookingDao();

	public static BookingDao getInstance() {
		return newInstance;
	}

	private BookingDao() {

	}
	
	//Fetching data from database.
		public Object getAll(){
			List<Booking> bookList = new ArrayList<Booking>();
			
			
			try {
				
				Connection conn = Configs.getDbConnection();
				
				String sql = "SELECT * FROM pvmst_booking";//Query to be execute
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				
				ResultSet resultSet = preparedStatement.executeQuery(); //Query execution.
				
				while(resultSet.next()) {
					Booking booking = new Booking();
					
					booking.setBooking_id(resultSet.getInt("booking_id"));
					booking.setName(resultSet.getString("name"));
					booking.setMail(resultSet.getString("mail"));
					booking.setPackage_id(resultSet.getInt("package_id"));
					booking.setBike_id(resultSet.getInt("bike_id"));
					booking.setQuantity(resultSet.getInt("quantity"));
					booking.setDays(resultSet.getInt("days"));
					booking.setAddCard(resultSet.getInt("card"));
					
					
					
					bookList.add(booking);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error : "+e.getMessage());
				
				Map<String, String> errMsg = new HashMap<String, String>();
				errMsg.put("Error",  e.getMessage());
				
				return errMsg;
				
			}
			
			return bookList;
			
		}
		
		//Fetching a single data from database.
		public Booking get(int package_id){
			Booking booking = new Booking();
			
			
			try {
				
				Connection conn = Configs.getDbConnection();
				
				String sql = "SELECT * FROM pvmst_booking WHERE booking_id = ?";//Query to be execute
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, package_id); //binding the parameter value, 1 is for specify first parameter.
				
				ResultSet resultSet = preparedStatement.executeQuery(); //Query execution.
				
				while(resultSet.next()) {
					
					booking.setBooking_id(resultSet.getInt("booking_id"));
					booking.setName(resultSet.getString("name"));
					booking.setMail(resultSet.getString("mail"));
					booking.setPackage_id(resultSet.getInt("package_id"));
					booking.setBike_id(resultSet.getInt("bike_id"));
					booking.setQuantity(resultSet.getInt("quantity"));
					booking.setDays(resultSet.getInt("days"));
					booking.setAddCard(resultSet.getInt("card"));
					
					
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error : "+e.getMessage());
			}
			
			return booking;
			
		}
		
		public boolean add(Booking booking) throws ClassNotFoundException, SQLException {
			
			if(booking != null) {
				
				Connection connection = Configs.getDbConnection();
				String sql = "INSERT INTO `booking` (`booking_id`,`name`, `type`, `package_id`, `bike_id`,`quantity`,`days`,`card`) " + 
							"VALUES (?,?,?,?,?)";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, booking.getBooking_id());
				stmt.setString(2, booking.getName());
				stmt.setString(3, booking.getMail());
				stmt.setInt(4, booking.getPackage_id());
				stmt.setInt(5, booking.getBike_id());
				stmt.setInt(6, booking.getQuantity());
				stmt.setInt(7, booking.getDays());
				stmt.setInt(7, booking.getAddCard());
			
				
				int count = stmt.executeUpdate();
				
				if(count > 0) {
					System.out.println("Successfull Added");
					return true;
				} else {
					System.out.println("Error occured");
				}
								
			}
			
			return false;
			
		}
		

}
