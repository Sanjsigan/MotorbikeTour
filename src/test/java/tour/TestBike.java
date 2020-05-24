package tour;

import org.junit.Test;

import com.ssd.tour.model.Bike;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestBike {

	@Test
	public void BikeTest() {
		int id = 100;
		String model = "model1";
		String Horse = "Horsea122";

		Bike bike = new Bike(id, model, Horse, id);

		Assert.assertTrue(bike.getModel().equals(model));

	}

}
