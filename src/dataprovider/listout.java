package dataprovider;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class listout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/usr/bin/Chromedriver");
	      WebDriver driver = new ChromeDriver();
	      String url = "https://opensource-demo.orangehrmlive.com/";
	      driver.get(url);
	     // driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	      //Using tagname with anchor
	      List<WebElement> links = driver.findElements(By.tagName("a"));
	      System.out.println("The number of links is "+ links.size());
	      driver.close();
	}

}
