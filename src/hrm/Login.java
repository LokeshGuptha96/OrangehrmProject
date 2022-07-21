package hrm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
 WebDriver d;
		System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
				d=new ChromeDriver();
				d.get("https://opensource-demo.orangehrmlive.com/");
				d.manage().window().maximize();
				Properties p=new Properties();
				FileInputStream istream= new FileInputStream(System.getProperty("user.dir")+"/TestNGProject/OrangeHRM.properties");
				p.load(istream);
				d.findElement(By.xpath(p.getProperty("UserID"))).sendKeys("admin");
				d.findElement(By.xpath(p.getProperty("password"))).sendKeys("admin123");
				d.findElement(By.xpath(p.getProperty("btnlogin"))).click();
				
				
				
				
	
	}

}
