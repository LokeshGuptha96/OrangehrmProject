package paramPackage;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class Addition {
 
	
	@Test
	@Parameters({"m","n"})
	
	
	public void add(int a, int b) {
		int sum=a+b;
		System.out.println("sum of two values="+sum);
		
	}
}
