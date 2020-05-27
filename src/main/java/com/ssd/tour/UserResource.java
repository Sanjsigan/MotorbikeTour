package com.ssd.tour;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.ssd.tour.dao.UserDao;
import com.ssd.tour.model.Users;

@Path("user")
public class UserResource {

	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response userLogin(@FormParam("email") String email, @FormParam("password") String password)
			throws URISyntaxException {

		Users user = UserDao.getInstance().LoginChecker(email, password);
		Gson gson = new Gson();

		if (user.getName() != null && user.getName().length() > 0) {
			String jsonString = gson.toJson(user);

			return Response.status(200).entity(jsonString).build();
		} else {
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("MESSAGE", "Invalid login details");
//			
//			String jsonString = gson.toJson(map);
//			
//			return Response
//					.status(200)
//					.entity(jsonString)
//					.build();

			return Response.seeOther(new URI("http://localhost:8080/tour/login.jsp")).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		// Jackson
		// GSON
		Object object = UserDao.getInstance().getAll();

		Gson gson = new Gson();

		if (object instanceof List<?>) {

			@SuppressWarnings("unchecked")
			List<Users> cars = (List<Users>) object; // Casting.

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

		Users user = UserDao.getInstance().get(carid);

		Gson gson = new Gson();
		String jsonString = gson.toJson(user);

		return Response.status(200).entity(jsonString).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void adduser(@FormParam("user_id") int id, @FormParam("user_name") String name,
			@FormParam("user_address") String address, @FormParam("user_mobile") int mobile,
			@FormParam("user_email") String email, @FormParam("password") String password)
			throws ClassNotFoundException, SQLException {

		Users user = new Users();

		user.setId(id);
		user.setName(name);
		user.setAddress(address);
		user.setMobile(mobile);
		user.setMail(email);
		user.setMail(password);

	}

}
