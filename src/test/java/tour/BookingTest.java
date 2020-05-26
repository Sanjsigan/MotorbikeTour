package tour;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import com.ssd.tour.model.Booking;

public class BookingTest {

	@Test
	public void TestBooking() {

		int id = 230;
		String name = "user1";
		String mail = "user123@gmail.com";

		Booking booking = new Booking(id, name, mail, id, id, id, id, id);

		assertNotEquals(null, booking);

	}

}
