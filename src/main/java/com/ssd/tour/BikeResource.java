package com.ssd.tour;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.ssd.tour.dao.BikeDao;
import com.ssd.tour.model.Bike;

public class BikeResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		// Jackson
		// GSON
		Object object = BikeDao.getInstance().getAll();

		Gson gson = new Gson();

		if (object instanceof List<?>) { // Data type checking.

			@SuppressWarnings("unchecked")
			List<Bike> bike = (List<Bike>) object; // Casting.

			String jsonString = gson.toJson(bike);
			return Response.status(200).entity(jsonString).build();
		} else {
			@SuppressWarnings("unchecked")
			Map<String, String> errMsg = (Map<String, String>) object; // Casting.

			String jsonString = gson.toJson(errMsg);
			return Response.status(200).entity(jsonString).build();
		}

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAUser(@PathParam("id") String id) {

		int carid = Integer.parseInt(id);

		Bike bike = BikeDao.getInstance().get(carid);

		Gson gson = new Gson();
		String jsonString = gson.toJson(bike);

		return Response.status(200).entity(jsonString).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addBike(@FormParam("bike_id") int id, @FormParam("bike_model") String model,
			@FormParam("bike_horse") String hourse, @FormParam("bike_amount") Double amount)
			throws ClassNotFoundException, SQLException {

		Bike bike = new Bike();

		bike.setId(id);
		bike.setModel(model);
		bike.setMaximumHorse(hourse);
		bike.setAmount(amount);

		// boolean result = CarDao.getInstance().add(car);

	}
}
