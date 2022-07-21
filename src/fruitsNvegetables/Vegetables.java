package fruitsNvegetables;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Vegetables {
	@Test
	@Parameters({"veg11","veg12"})
 
public void fruit1(String v11,String v12) {
	System.out.println("First half Fruit delivered was "+v11+""+v12);
 }
	
	@Test
	@Parameters({"veg21","veg22"})
 
	public void fruit2(String v21, String v22) {
		System.out.println("second  Fruit delivered was "+v21+""+v22);
	}



}
