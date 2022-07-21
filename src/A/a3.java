package A;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class a3 {
	@Test
	@Parameters({"Fname"})
 
public void fruit1(String f11) {
	System.out.println("First name"+f11);
 }
	
	@Test
	@Parameters({"Lname"})
 
	public void fruit2(String f21) {
		System.out.println("last name "+f21);
	}
}
