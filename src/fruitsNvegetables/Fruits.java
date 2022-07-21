package fruitsNvegetables;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Fruits {
	@Test
	@Parameters({"fruit11","fruit12"})
 
public void fruit1(String f11,String f12) {
	System.out.println("First half Fruit delivered was "+f11+""+f12);
 }
	
	@Test
	@Parameters({"fruit21","fruit22"})
 
	public void fruit2(String f21, String f22) {
		System.out.println("second  Fruit delivered was "+f21+""+f22);
	}
}
