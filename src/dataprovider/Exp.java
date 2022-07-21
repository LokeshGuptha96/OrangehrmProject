package dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Exp {
	WebDriver d;
	String baseURL="https://opensource-demo.orangehrmlive.com/";
	//@AfterTest
	//public void shutdown() {
		//d.close();
	//}

	@BeforeTest
	public void setup() {
	System.setProperty("webdriver.gecko.driver","/usr/bin/geckodriver");
	d=new FirefoxDriver();
	d.get(baseURL);
	//d.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
	d.manage().window().maximize();
	//d.manage().deleteAllCookies();
	//d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	



	}

	@Test(dataProvider="DP" )
	
	
	public void searchText(String a ) throws InterruptedException {
		
		d.findElement(By.id("txtUsername")).sendKeys(a);
	}
	@Test(priority =2)
	@Parameters({"b"})
	public void s(String c) throws InterruptedException {
		
	d.findElement(By.id("txtPassword")).sendKeys(c);
		d.findElement(By.id("btnLogin")).click();
		
		
		String expectedTitle = "OrangeHRM";
		String actualTitle = d.getTitle();
		/*if(assertEquals(actualTitle, expectedTitle, "Title is Matched")) {
			System.out.println("Successful login");
		}else
			System.out.println("Invalid login");
		
		}*/
        
	   		
	   		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
	   			  System.out.println("The login is Successfull");
	   		}
	   		else {
	   			System.out.println("The Login is Failed");
	   		}
	
	     d.findElement(By.partialLinkText("Admin")).click();
	   		Thread.sleep(1000);
	   		d.findElement(By.partialLinkText("Leave")).click();
	   		Thread.sleep(1000);

	   			   		d.findElement(By.partialLinkText("Recruitment")).click();
	   		Thread.sleep(1000);


	   		
	   		d.findElement(By.partialLinkText("Welcome")).click();
			d.findElement(By.linkText("Logout")).click();
	}




	@DataProvider(name="DP")
	public Object[][] dataObject(){
		return new Object[][] {
			{"Admin"}
		};
	}

}
