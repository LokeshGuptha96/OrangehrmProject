package paramPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Subtraction {
	
	@Test
	@Parameters({"m","n"})
	public void sub(int a, int b) {
		int r=a-b;
		System.out.println("sub is="+r);
		
	}
}
