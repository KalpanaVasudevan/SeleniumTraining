package week4_day2_Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AcmeApplication {

	public static void main(String[] args) {
		
		//Setting up browser and driver property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Create an object for ChromeDriver 
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL
		driver.get("https://acme-test.uipath.com/account/login");
		
		//maximize the window
		driver.manage().window().maximize();
		
		//Enter username 
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		
		//Enter Password
		driver.findElementById("password").sendKeys("leaf@12");
		
		//Click Login button
		driver.findElementById("buttonLogin").click();
		
		//Implicit wait 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Create an object for Actions Class
		Actions builder = new Actions(driver);
		
			//find Webelement vendor on the page
			WebElement vendors = driver.findElementByXPath("//button[text()=' Vendors']");
		
			//Mouse Over on Vendors
			builder.moveToElement(vendors).perform();
			
			//Click Search for Vendor
			driver.findElementByXPath("//a[text()='Search for Vendor']").click();
		
		String vendorName = "Blue Lagoon";
		
		//Enter Vendor Name (Blue Lagoon)
		driver.findElementByXPath("//input[@id='vendorName']").sendKeys(vendorName);
		
		//click search button
		driver.findElementByXPath("//button[@id='buttonSearch']").click();
		
		//Find the Country Name based on the Vendor		
		String country = driver.findElementByXPath("(//table[@class='table']//tr/td)[5]").getText();		
		
		System.out.println("Country Name for the Vendor "+vendorName+" is: "+country);
		
		//Click Logout button
		driver.findElementByXPath("//a[text()='Log Out']").click();
		
		//Close browser
		driver.close();
	}

}
