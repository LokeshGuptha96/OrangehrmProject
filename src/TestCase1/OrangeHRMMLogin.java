package TestCase1;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import utilities.Constants;
import utilities.ExcelUse;

public class OrangeHRMMLogin {
static ExcelUse exceluse=new ExcelUse();
static String excelFilePath=Constants.TestDataPath+Constants.FileName;
public static void main(String args[]) throws IOException {
	System.setProperty("webdriver.chrome.driver", "/usr/bin/Chromedriver/");
	WebDriver d=new ChromeDriver();
	d.get(Constants.baseURL);
	WebElement uname=d.findElement(By.name("txtUsername"));
	//.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
	WebElement password=d.findElement(By.name("txtPassword"));
	//.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
	WebElement btnLogin=d.findElement(By.name("Submit"));	
	//Thread.sleep(2000);
	//WebElement linkWelcome=d.findElement(By.partialLinkText("Welcome")).click();
	//Thread.sleep(2000);
	WebElement linkLogout=d.findElement(By.linkText("Logout"));
	exceluse.setExcelFile(excelFilePath, "login");
	for(int i=1;i<=exceluse.getRowCountInSheet();i++) {
		//Thread.sleep(2000);
		uname.clear();
		
		uname.sendKeys(exceluse.getCellData(i,0));
		password.clear();
		password.sendKeys(exceluse.getCellData(i,1));
		btnLogin.click();
		String actualTitle=d.getTitle();
		System.out.println(actualTitle);
		String expectedTitle="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {

		exceluse.setCellValue(i,3,"Pass",excelFilePath);
		
		
		}
		else {
			exceluse.setCellValue(i,2,"Fall",excelFilePath);
		}
		d.navigate().back();
	}
	d.quit();
}
}
