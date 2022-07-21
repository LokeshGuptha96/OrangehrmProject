package o;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class o1 {
	WebDriver dv;
    String baseURL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
   // @AfterTest
    //void shutdown() {
    //	dv.close();
    //}
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","/usr/bin/Chromedriver");
		dv=new ChromeDriver();
		dv.get(baseURL);
		dv.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		dv.manage().window().maximize();
		dv.manage().deleteAllCookies();
		dv.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test(dataProvider="DP")
	public void user1(String a, String b)  {
		dv.findElement(By.id("txtUsername")).sendKeys(a);
		dv.findElement(By.id("txtPassword")).sendKeys(b);
		dv.findElement(By.id("btnLogin")).click();
	}
	
	@DataProvider(name="DP")
	public Object[][] datObject(){
		return new Object[][] {
			{"admin", "admin123"}
		};
	}
}
