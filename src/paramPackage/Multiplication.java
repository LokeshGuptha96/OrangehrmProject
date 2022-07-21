package paramPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Multiplication {
	
	@Test
	@Parameters({"m","n"})
 
		public void mul(int a, int b) {
			int P=a*b;
			System.out.println("Multiplication is="+P);
			
		}
}
