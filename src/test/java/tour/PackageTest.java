package tour;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.ssd.tour.dao.PackageDao;

public class PackageTest {
	
	@Test
	public void testPackage() {
		Object actual = PackageDao.getInstance().getAll();
		assertNotEquals(null, actual);
	}
	

}
