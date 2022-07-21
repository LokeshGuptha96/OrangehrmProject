package dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddDP {
	WebDriver d;
	String baseURL="https://google.com";
	
	@Test(dataProvider="DP")
	public void searchText(int a, int b)throws InterruptedException {
		int sum=a+b;
		System.out.println("sum ="+sum);
	}

	@Test(dataProvider="DP")
	public void subtr(int a, int b)throws InterruptedException {
		int sub=a-b;
		System.out.println("sub ="+sub);
	}



	@DataProvider(name="DP")
	public Object[][] dataObject(){
		return new Object[][] {
			{2,3},{3,4}
		};
	}
	
}
