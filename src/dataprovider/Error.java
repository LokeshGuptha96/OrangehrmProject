package dataprovider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Error {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver d= new FirefoxDriver();
System.setProperty("webdriver.gecko.driver","/usr/bin/geckodriver");
d.navigate().to("google.com");

	}

}
