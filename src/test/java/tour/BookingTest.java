package tour;

import org.junit.Test;

import com.ssd.tour.model.Booking;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BookingTest {

	@Test

	public void TestBooking() {

		int id = 230;
		String name = "user1";
		String mail = "user123@gmail.com";

		Booking booking = new Booking(id, name, mail, id, id, id, id, id);

		Assert.assertTrue(booking.getMail().equals(mail));
		Assert.assertTrue(booking.getName().equals(name));
	}

}
