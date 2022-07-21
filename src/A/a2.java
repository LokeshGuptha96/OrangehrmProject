package A;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class a2 {

	@Test
	@Parameters({"m","n"})
	public void sub(String a, String b) {
		String sum=a+b;
		System.out.println("name reverse="+sum);
}
}
