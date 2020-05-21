package com.ssd.tour.model;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BookingTest {

	@Test

	public void TestBooking() {
		
		int id =230;
	    String name ="user1";
	    String mail ="user123@gmail.com";
	    
	    Booking booking = new Booking(id,name,mail,id,id);
	    
	    Assert.assertTrue(booking.getMail().equals(mail));
	   Assert.assertTrue(booking.getName().equals(name));
	}

}
