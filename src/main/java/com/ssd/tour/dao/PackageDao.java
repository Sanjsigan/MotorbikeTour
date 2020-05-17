package com.ssd.tour.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssd.tour.model.Packages;
import com.ssd.tour.model.Users;



public class PackageDao {
	private static PackageDao newInstance = new PackageDao();

	public static PackageDao getInstance() {
		return newInstance;
	}

	private PackageDao() {

	}
	
	//Fetching data from database.
		public Object getAll(){
			List<Packages> pacList = new ArrayList<Packages>();
			
			
			try {
				
				Connection conn = Configs.getDbConnection();
				
				String sql = "SELECT * FROM package";//Query to be execute
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				
				ResultSet resultSet = preparedStatement.executeQuery(); //Query execution.
				
				while(resultSet.next()) {
					Packages packages = new Packages();
					
					packages.setId(resultSet.getInt("package_id"));
					packages.setPacName(resultSet.getString("package_name"));
					packages.setType(resultSet.getString("package_type"));
					packages.setAmount(resultSet.getInt("package_amount"));
					packages.setDesc(resultSet.getString("package_desc"));
					
					
					
					pacList.add(packages);
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
