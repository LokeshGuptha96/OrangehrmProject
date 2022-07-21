package dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sugar {
	WebDriver d;
	String baseURL="https://open-source-guide.com/en/The-open-source/Learn-more";
	//@AfterTest
	//public void shutdown() {
		//d.close();
	//}

	@BeforeTest
	public void setup() {
	System.setProperty("webdriver.chrome.driver","/usr/bin/Chromedriver")	;
	d=new ChromeDriver();
	d.get(baseURL);
	//d.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
	d.manage().window().maximize();
	d.manage().deleteAllCookies();
	d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
}
	@Test(dataProvider="DP")
	public void searchText(String a ) throws InterruptedException {
		
		
		
		//String expectedTitle = "OrangeHRM";
		//String actualTitle = d.getTitle();
		/*if(assertEquals(actualTitle, expectedTitle, "Title is Matched")) {
			System.out.println("Sucessful login");
		}else
			System.out.println("Invalid login");
		
		}*/
        
	   		/*
	   		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
	   			  System.out.println("The login is Successfull");
	   		}
	   		else {
	   			System.out.println("The Login is Failed");
	   		}*/
	
	     d.findElement(By.partialLinkText("Introduction")).click();
	   		Thread.sleep(1000);
	   		d.findElement(By.partialLinkText("Solutions")).click();
	   		Thread.sleep(1000);

	   			   		d.findElement(By.id("search-string")).sendKeys(a);
	   			   		d.findElement(By.id("searchbuttonfield")).click();
	   		Thread.sleep(1000);


	   		
	   		
	}




	@DataProvider(name="DP")
	public Object[][] dataObject(){
		return new Object[][] {
			{"news"},
		};
	}
}
