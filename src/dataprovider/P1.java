package dataprovider;
//running
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class P1 {
WebDriver d;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		d = new FirefoxDriver();
		d.get("https://opensource-demo.orangehrmlive.com");
		d.manage().window().maximize();
	}
	
	@Test
	@Parameters( {"username", "password"})
	public void start(String username, String password) throws InterruptedException {
		
		WebElement username1 = d.findElement(By.id("txtUsername"));
		WebElement password1 = d.findElement(By.id("txtPassword"));
		WebElement submit = d.findElement(By.name("Submit"));
		
		username1.sendKeys(username);
		password1.sendKeys(password);
		submit.click();
		Thread.sleep(2000);
     d.findElement(By.linkText("Buzz")).click();
	} 
   
    
}
