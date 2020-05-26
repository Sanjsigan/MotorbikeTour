package tour;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.Test;

import com.ssd.tour.model.Packages;

public class TestPackage {
	
	@Test
	public void PackageTest() {
		
	int id=987;
	String name="pac34";
	String type ="type34";
	int amount=87766;
	String desc ="desc@#";
	
	Packages packages = new Packages(id,name,type,amount,desc);
	
	assertNotEquals(null, packages);
		
	}

}
