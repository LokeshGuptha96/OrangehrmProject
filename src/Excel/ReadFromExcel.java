package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ReadFromExcel {
	WebDriver d;
@BeforeTest
public void TestSetup() throws IOException {
	
	String baseURL="https://opensource-demo.orangehrmlive.com/";
	System.setProperty("webdriver.Chrome.driver","/usr/bin/Chromedriver/");
			
	//WebDriverManager.chromedriver().setup();

	d= new ChromeDriver();
	d.get(baseURL);
	
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
}

@Test
public void ReadFromExcel() throws IOException, InterruptedException  {
	File file=new File("/home/guptha/eclipse-workspace/TestNGProject/src/Excel/TestData.xls");
	FileInputStream iStream=new FileInputStream(file);
	
	HSSFWorkbook workbook=new HSSFWorkbook(iStream);
	HSSFSheet sheet=workbook.getSheet("Sheet1");
	int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	//System.out.println(rowCount);
	for(int i=1;i<=rowCount;i++) {
	d.findElement(By.name("txtUsername")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
	d.findElement(By.name("txtPassword")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
	d.findElement(By.name("Submit")).click();	
	Thread.sleep(2000);
	d.findElement(By.partialLinkText("Welcome")).click();
	Thread.sleep(2000);
	d.findElement(By.linkText("Logout")).click();
	Thread.sleep(2000);
	}
	workbook.close();
	}	

}
