package A;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class a1 {

	@Test
	@Parameters({"m","n"})
	public void sub(String a, String b) {
		String sum=b+a;
		System.out.println("name="+sum);
}
}