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
import com.ssd.tour.dao.BookingDao;
import com.ssd.tour.model.Booking;


public class BookingResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		
		Object object = BookingDao.getInstance().getAll();
		
		Gson gson = new Gson();
		
		if(object instanceof List<?>) { //Data type  checking.
			
			@SuppressWarnings("unchecked")
			List<Booking> packages = (List<Booking>)object; //Casting.
			
			String jsonString = gson.toJson(packages);
			return Response
					.status(200)
					.entity(jsonString)
					.build();
		} else {
			@SuppressWarnings("unchecked")
			Map<String, String> errMsg = (Map<String, String>)object; //Casting.
			
			String jsonString = gson.toJson(errMsg);
			return Response
					.status(200)
					.entity(jsonString)
					.build();
		}
		
	}
	
	@GET
	@Path("{booking_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAPackage(@PathParam("id") String id) {
		
		int bookid = Integer.parseInt(id);
		
		Booking booking = BookingDao.getInstance().get(bookid);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(booking);
		
		return Response
				.status(200)
				.entity(jsonString)
				.build();
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addPackage(@FormParam("booking_id") int id,
							@FormParam("name") String name,
							@FormParam("mail") String mail,
							@FormParam("package_id") int package_id,
							@FormParam("bike_id") int bike_id
						)
									throws ClassNotFoundException, SQLException {
		
		Booking booking= new Booking();
		
		booking.setPackage_id(id);
		booking.setName(name);
		booking.setMail(mail);
		booking.setPackage_id(package_id);
		booking.setBike_id(bike_id);
	
		
		//boolean result = CarDao.getInstance().add(car);
	
	}

}
