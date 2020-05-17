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
				
				String sql = "SELECT * FROM booking";//Query to be execute
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				
				ResultSet resultSet = preparedStatement.executeQuery(); //Query execution.
				
				while(resultSet.next()) {
					Booking booking = new Booking();
					
					booking.setBooking_id(resultSet.getInt("booking_id"));
					booking.setName(resultSet.getString("name"));
					booking.setMail(resultSet.getString("mail"));
					booking.setPackage_id(resultSet.getInt("package_id"));
					booking.setBike_id(resultSet.getInt("bike_id"));
					
					
					
					bookList.add(booking);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error : "+e.getMessage());
				
				Map<String, String> errMsg = new HashMap<String, String>();
				errMsg.put("Error",  e.getMessage());
				
				return errMsg;
				
			}
			
			return pacList;
			
		}
		
		//Fetching a single data from database.
		public Packages get(int package_id){
			Packages packages = new Packages();
			
			
			try {
				
				Connection conn = Configs.getDbConnection();
				
				String sql = "SELECT * FROM package WHERE package_id = ?";//Query to be execute
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, package_id); //binding the parameter value, 1 is for specify first parameter.
				
				ResultSet resultSet = preparedStatement.executeQuery(); //Query execution.
				
				while(resultSet.next()) {
					
					packages.setId(resultSet.getInt("package_id"));
					packages.setPacName(resultSet.getString("package_name"));
					packages.setType(resultSet.getString("package_type"));
					packages.setAmount(resultSet.getInt("package_amount"));
					packages.setDesc(resultSet.getString("package_desc"));
					
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error : "+e.getMessage());
			}
			
			return packages;
			
		}
		
		public boolean add(Packages packages) throws ClassNotFoundException, SQLException {
			
			if(packages != null) {
				
				Connection connection = Configs.getDbConnection();
				String sql = "INSERT INTO `package` (`package_id`,`package_name`, `package_type`, `package_amount`, `package_desc`) " + 
							"VALUES (?,?,?,?,?)";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, packages.getId());
				stmt.setString(2, packages.getPacName());
				stmt.setString(3, packages.getType());
				stmt.setInt(4, packages.getAmount());
				stmt.setString(5, packages.getDesc());
			
				
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
