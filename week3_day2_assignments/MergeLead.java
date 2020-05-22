package week3_day2_assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		
		//setting up browser and driver property
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		//create object for ChromDriver
		ChromeDriver driver = new ChromeDriver();
		
		  //Launch URL 
		 driver.get("http://leaftaps.com/opentaps/control/login");
		  
		  //Maximize window driver.manage().window().maximize();
		  
		  //Enter UserName and Password Using Id Locator
		  driver.findElementById("username").sendKeys("Demosalesmanager");
		  
		  driver.findElementById("password").sendKeys("crmsfa");
		  
		  //Click on Login Button using Class Locator
		  driver.findElementByClassName("decorativeSubmit").click();
		  
		  //Click on CRM/SFA Link
		  driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		  
		  //Click on contacts Button
		  driver.findElementByXPath("//a[text()='Contacts']").click();
		  
		  //Click on Merge Contacts using Xpath Locator
		  driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		  
		  //Click on Widget of From Contact
		  driver.findElementByXPath("//input[@id='partyIdFrom']/following-sibling::a").
		  click();
		  
		  Thread.sleep(3000);
		  
		  // Click on First Resulting Contact 
		 // driver.findElementByXPath("(//table[@class='x-grid3-row-table']//tr/td/div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"
		  //).click();
		  driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		  
		  Thread.sleep(10000);
		  
		  
		  //Click on Widget of To Contact
		  driver.findElementByXPath("//input[@id='partyIdTo']/following-sibling::a").
		  click();
		  
		  Thread.sleep(3000);
		 
		
		//Click on Second Resulting Contact
		driver.findElementByXPath("(//table[@class='x-grid3-row-table']//tr/td/div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]").click();
		
		Thread.sleep(2000);
		
		
		  //Click on Merge button using Xpath Locator
		  driver.findElementByXPath("//a[text()='Merge']").click();
		  
		  // Accept the Alert driver.switchTo().alert().accept();
		  
		  // Verify the title of the page
		 
		
		
		
		
		

	}

}
