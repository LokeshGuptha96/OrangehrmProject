package dataprovider;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchParam {
WebDriver d;
String baseURL="https://google.com";
@AfterTest
public void shutdown() {
	d.close();
}

@BeforeTest
public void setup() {
System.setProperty("webdriber.gecko.driver","/usr/bin/geckodriver")	;
d=new FirefoxDriver();
d.get(baseURL);
d.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
d.manage().window().maximize();
d.manage().deleteAllCookies();
d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);



}

@Test(dataProvider="DP")
public void searchText(String author, String SrchText) throws InterruptedException {
	WebElement s=d.findElement(By.name("q"));
	s.clear();
	s.sendKeys(SrchText);
	
	s.submit();
	Thread.sleep(4000);
	String s1=s.getAttribute("value");
	System.out.println(author +"searching for"+SrchText+"and type text is:"+s1);
	s.clear();
	Assert.assertTrue(SrchText.equalsIgnoreCase(s1));
}




@DataProvider(name="DP")
public Object[][] dataObject(){
	return new Object[][] {
		{"lokesh","java"},{"Shankar","jmeter"},{"a","Junit"}
	};
}}
