package paramPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Division {
	@Test
	@Parameters({"m","n"})
 
		public void Div(int a, int b) {
			int D=a/b;
			System.out.println("Division is="+D);
			
		}
}
