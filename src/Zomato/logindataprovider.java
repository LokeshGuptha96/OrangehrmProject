package Zomato;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class logindataprovider {
	WebDriver d;
	String baseURL="https://www.zomato.com/";
	//@AfterTest
	//public void shutdown() {
		//d.close();
	//}

	@BeforeTest
	public void setup() {
	System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver")	;
	d=new ChromeDriver();
	d.get(baseURL);
	d.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
	d.manage().window().maximize();
	d.manage().deleteAllCookies();
	d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);



	}

	@Test(dataProvider="DP")
	public void searchText(String n ) throws InterruptedException {
		
		WebElement s=d.findElement(By.xpath("//input[@type='number' and @class='sc-60vv3c-0 fyGVHZ sc-cNnxps gvrMJx']"));
				s.sendKeys(n);
	Thread.sleep(40000);
	s.getAttribute("value");
	System.out.println("n"+n);
	}




	@DataProvider(name="DP")
	public Object[][] dataObject(){
		return new Object[][] {
			{"1234567891"},{"1231231231"},{"1234432121"}
		};
	}
}
