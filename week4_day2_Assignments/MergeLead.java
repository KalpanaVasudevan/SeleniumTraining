package week4_day2_Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		
		//setting up browser and driver property
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
				//create object for ChromDriver
				ChromeDriver driver = new ChromeDriver();
		
		//Launch URL 
		driver.get("http://leaftaps.com/opentaps/control/login");
		  
				//Maximize window 
				driver.manage().window().maximize();
				
				//implicit wait for all elements in the page
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		 //Enter UserName and Password Using Id Locator
		  driver.findElementById("username").sendKeys("Demosalesmanager");
		  
		  //Enter Password
		  driver.findElementById("password").sendKeys("crmsfa");
		  
		  //Click on Login Button using Class Locator
		  driver.findElementByClassName("decorativeSubmit").click();
		  
		  //Click on CRM/SFA Link
		  driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		  
		  //Click on contacts Button
		  driver.findElementByXPath("//a[text()='Contacts']").click();
		  
		  //Click on Merge Contacts using Xpath Locator
		  driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		  		
		  		//Get unique reference of first window
		  		String firstwindow = driver.getWindowHandle();
		  		
		  		//SwitchTo first window
		  		driver.switchTo().window(firstwindow);
		  		
		  		//get title 
		  		String title = driver.getTitle();
		  		
		  //Click on Widget of From Contact
		  driver.findElementByXPath("//input[@id='partyIdFrom']/following-sibling::a").click();
		  Thread.sleep(1000);
		  		
		  		//Get unique references of merge and from contact window		
		  		Set<String> mergeandFromContactWindows = driver.getWindowHandles();
		  		
		  		//Create list to copy reference from set
		  		List<String> fromContatctList = new ArrayList<String>(mergeandFromContactWindows);
		  		
		  		//Get unique reference of from contact window		 
		  		String fromContactWindow = fromContatctList.get(1);
		  		
		  		//switch to from contact window
		  		driver.switchTo().window(fromContactWindow);
		  
		  // Click on First Resulting Contact 
		  driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click(); 
		  Thread.sleep(1000);
		  
		  System.out.println("From contact selected successfully");
		  
		 //switch to merge contact window
		  driver.switchTo().window(firstwindow);
		  		
		 //Click on Widget of To Contact
		 driver.findElementByXPath("//input[@id='partyIdTo']/following-sibling::a").click();
		 Thread.sleep(3000);
		  
		  		//Get unique references of merge and To contact window	
	  			Set<String> mergeandToContactWindows = driver.getWindowHandles();
	  		
	  			//Create list to copy reference from set
	  			List<String> toContactList = new ArrayList<String>(mergeandToContactWindows);
	  		
	  			//Get unique reference of To contact window
	  			String toContactWindow =toContactList.get(1);
	  
	  			//Switch to To contact window
	  			driver.switchTo().window(toContactWindow);
		 
		  //Click on Second Resulting Contact
		  driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]").click();
		  System.out.println("To contact selected successfully");
		  
		  //switch to merge contact window
		  driver.switchTo().window(firstwindow);
		  
		  //Click on Merge button using Xpath Locator
		  driver.findElementByXPath("//a[text()='Merge']").click();
		  Thread.sleep(2000);
		  
		  // Accept the Alert 
		 driver.switchTo().alert().accept();
		 Thread.sleep(3000);
		  
		 // Verify the title of the page
		 System.out.println(driver.getTitle());
		
	}

}
