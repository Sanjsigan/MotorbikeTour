package tour;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import com.ssd.tour.model.Hotel;


public class TestHotel {

	@Test

	public void HotelTest() {
		int id = 232;
		String name = "hetel3434";
		String address = "address!@#$~";

		Hotel hotel = new Hotel(id, name, address, id);

		assertNotEquals(null, hotel);
	}

}
