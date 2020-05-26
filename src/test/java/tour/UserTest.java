package tour;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.ssd.tour.model.Users;

public class UserTest {

	@Test
	public void TestUser() {
		int id = 987;
		String name = "user1";
		String address = "adderess123";
		int mobile = 0765432134;
		String password = "sdf@#$5ss";

		Users user = new Users(id, name, address, mobile, password, password);

		assertNotEquals(null, user);

	}
}
