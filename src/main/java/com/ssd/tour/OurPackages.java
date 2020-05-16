package com.ssd.tour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ssd.tour.model.Packages;
import com.google.gson.Gson;

@Path("pvmst")
public class OurPackages {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		// Jackson
		// GSON

		List<Packages> packages = getpackFromDb();

		Gson gson = new Gson();
		String jsonString = gson.toJson(packages);

		return Response.status(200).entity(jsonString).build();

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getApac(@PathParam("id") String id) {

		int pacid = Integer.parseInt(id);

		Packages packages = getpackFromDb(pacid);

		Gson gson = new Gson();
		String jsonString = gson.toJson(packages);

		return Response.status(200).entity(jsonString).build();

	}

	// Fetching data from database.
	public List<Packages> getpackFromDb() {
		List<Packages> pacList = new ArrayList<Packages>();

		String connURL = "jdbc:mysql://localhost:3306/pvmst";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(connURL, "root", "sanjsi");

			String sql = "SELECT * FROM package";// Query to be execute
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery(); // Query execution.

			while (resultSet.next()) {
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
			System.out.println("Error : " + e.getMessage());
		}

		return pacList;

	}

	// Fetching a single data from database.
	public Packages getpackFromDb(int id) {
		Packages packages = new Packages();

		String connURL = "jdbc:mysql://localhost:3306/pvmst";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(connURL, "root", "sanjsi");

			String sql = "SELECT * FROM package WHERE package_id = ?";// Query to be execute
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id); // binding the parameter value, 1 is for specify first parameter.

			ResultSet resultSet = preparedStatement.executeQuery(); // Query execution.

			while (resultSet.next()) {

				packages.setId(resultSet.getInt("package_id"));
				packages.setPacName(resultSet.getString("package_name"));
				packages.setType(resultSet.getString("package_type"));
				packages.setAmount(resultSet.getInt("package_amount"));
				packages.setDesc(resultSet.getString("package_desc"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}

		return packages;

	}
}

// Database Simulation.
//	public List<Car> getCars(){
//		List<Car> carList = new ArrayList<Car>();
//		
//		Car car = new Car(1, "520D", "BMW", 2020);
//		carList.add(car);
//		
//		Car car1 = new Car(2, "Axio", "Toyota", 2017);
//		carList.add(car1);
//		
//		Car car2 = new Car(3, "A7", "Audi", 2020);
//		carList.add(car2);
//		
//		
//		return carList;
//	}
