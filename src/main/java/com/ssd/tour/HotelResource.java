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
import com.ssd.tour.dao.HotelDao;
import com.ssd.tour.model.Hotel;
@Path("one")
public class HotelResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
	
		Object object = HotelDao.getInstance().getAll();

		Gson gson = new Gson();

		if (object instanceof List<?>) { // Data type checking.

			@SuppressWarnings("unchecked")
			List<Hotel> cars = (List<Hotel>) object; // Casting.

			String jsonString = gson.toJson(cars);
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

		Hotel hotel = HotelDao.getInstance().get(carid);

		Gson gson = new Gson();
		String jsonString = gson.toJson(hotel);

		return Response.status(200).entity(jsonString).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void adduser(@FormParam("hotel_id") int hotel_id, @FormParam("hotel_name") String hotel_name,
			@FormParam("hotel_address") String hotel_address, @FormParam("hotel_amount") Double hotel_amount)
			throws ClassNotFoundException, SQLException {

		Hotel hotel = new Hotel();

		hotel.setId(hotel_id);
		hotel.setName(hotel_name);
		hotel.setAddress(hotel_address);
		hotel.setAmount(hotel_amount);

		// boolean result = CarDao.getInstance().add(car);

	}
}
