package com.ssd.tour.model;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestHotel {
	
	
	@Test
	
	public void HotelTest() {
		int id=232;
		String name="hetel3434";
		String address ="address!@#$~";
		
		Hotel hotel = new Hotel(id, name, address, id);
		
		Assert.assertTrue( hotel.getName().equals(name));
		Assert.assertTrue( hotel.getAddress().equals(address));
	}

}
