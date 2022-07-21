package dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

public class Xml {

	WebDriver drv;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "");
		drv = new ChromeDriver();
		drv.get("https://opensource-demo.orangehrmlive.com");
		drv.manage().window().maximize();
	}
	
	@Test
	@Parameters({"username","password"})
	public void start(String username, String password) throws InterruptedException {
		
		WebElement usernameField = drv.findElement(By.id("txtUsername"));
		WebElement passwordField = drv.findElement(By.id("txtPassword"));
		WebElement submit = drv.findElement(By.name("Submit"));
		
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		submit.click();
		Thread.sleep(2000);
		
		drv.close();
	}
}
