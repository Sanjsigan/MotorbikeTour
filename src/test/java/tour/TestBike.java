package tour;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import com.ssd.tour.model.Bike;




public class TestBike {

	@Test
	public void BikeTest() {
		int id = 100;
		String model = "model1";
		String Horse = "Horsea122";

		Bike bike = new Bike(id, model, Horse, id);

		assertNotEquals(null, bike);

	}

}
