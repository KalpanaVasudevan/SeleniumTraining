package week5.day2.TestngFramework;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


public class ParentClass {
	
	ChromeDriver driver;
	String workBookName;
	
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void commonCode(String url,String uName,String Pword)
	{
		//setting up browser and driver property
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
				
		//create an object for chromedriver 
		driver = new ChromeDriver();
				
			//Launch URL:
			driver.get(url);
				
				//Enter User name
				driver.findElementByXPath("//input[@class='inputLogin' and @id='username']").sendKeys(uName);
				
				//Enter Password
				driver.findElementByXPath("//input[@class='inputLogin' and @id='password']").sendKeys(Pword);
				
				//CLick LOGIN button
				driver.findElementByXPath("//input[@value='Login']").click();
				
				
				//Click CRM/SFA link
				driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
				
				//Click Lead link
				driver.findElementByXPath("//a[text()='Leads']").click();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
			driver.close();
	}
	
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException
	{
			return ReadExcel.readData(workBookName);
	}
	
}
