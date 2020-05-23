package com.ssd.tour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

import com.ssd.tour.dao.PackageDao;
import com.ssd.tour.dao.UserDao;
import com.ssd.tour.model.Packages;
import com.ssd.tour.model.Users;
import com.google.gson.Gson;

@Path("pvmst")
public class OurPackages {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		
		Object object = PackageDao.getInstance().getAll();
		
		Gson gson = new Gson();
		
		if(object instanceof List<?>) { //Data type  checking.
			
			@SuppressWarnings("unchecked")
			List<Packages> packages = (List<Packages>)object; //Casting.
			
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
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAPackage(@PathParam("id") String id) {
		
		int pacid = Integer.parseInt(id);
		
		Packages packages = PackageDao.getInstance().get(pacid);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(packages);
		
		return Response
				.status(200)
				.entity(jsonString)
				.build();
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addPackage(@FormParam("package_id") int package_id,
							@FormParam("package_name") String package_name,
							@FormParam("package_type") String package_type,
							@FormParam("package_amount") int package_amount,
							@FormParam("package_desc") String package_desc
						)
									throws ClassNotFoundException, SQLException {
		
		Packages packages= new Packages();
		
		packages.setId(package_id);
		packages.setPacName(package_name);
		packages.setType(package_type);
		packages.setAmount(package_amount);
		packages.setDesc(package_desc);
	
		

	
	}
}


