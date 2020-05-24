package tour;

import org.junit.Test;

import com.ssd.tour.model.Users;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class UserTest {
	
	
	@Test
	
	public void TestUser() {
		int id= 987;
		String name="user1";
		String address="adderess123";
		int mobile =0765432134;
		String password ="sdf@#$5ss";
		
		

         Users user = new Users(id,name,address,mobile,password, password);
		
	     Assert.assertTrue(user.getAddress().equals(address));
	     Assert.assertTrue(user.getPassword().equals(password));
	     

	}
}
