package tour;

import org.junit.Assert;
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
	
	Assert.assertTrue(packages.getPacName().equals(name));
	Assert.assertTrue( packages.getType().equals(type));
	Assert.assertTrue( packages.getDesc().equals(desc));
		
	}

}
