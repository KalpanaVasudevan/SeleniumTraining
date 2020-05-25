package week4_day2_Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServiceNowApplication {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting up driver and browser property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//create an object for chrome driver
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL
		driver.get("https://dev60453.service-now.com/");
		
			//maximize the window
			driver.manage().window().maximize();
		
			//impicit wait 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Switch to frame 'gsft_main'
			driver.switchTo().frame("gsft_main");
			
		//Enter user name
		driver.findElementById("user_name").sendKeys("admin");
			
		//Enter Password
		driver.findElementById("user_password").sendKeys("India@123");
			
		//CLick Login Button
		driver.findElementById("sysverb_login").click();
		Thread.sleep(2000);
		
		//Enter Change in filter navigator
		driver.findElementByXPath("//input[@id='filter']").sendKeys("Change");
		
			//Click ALL
			driver.findElementByXPath("(//div[text()='All'])[4]").click();
			Thread.sleep(1000);
			
			//Switch to frame 'gsft_main'
			driver.switchTo().frame("gsft_main");
			
			
		//Click Create New Button
		driver.findElementByXPath("//button[@id='sysverb_new']").click();
		
		//click Normal change under What type of change is required?
		driver.findElementByXPath("(//div[@class='container-fluid wizard-container']/a)[1]").click();
		
		//Capture the change request Number from the Number Filed
		String newChangeRequest = driver.findElementByXPath("//input[@id='change_request.number']").getAttribute("value");
		
		System.out.println("change Request Number displayed is: "+newChangeRequest);
		
		//Create new normal Change by filling mandatory fields
		driver.findElementByXPath("//input[@id='change_request.short_description']").sendKeys("normal change request");
		
		//click submit button
		driver.findElementById("sysverb_insert_bottom").click();
		
		//Go to the search field and search the captured number
		driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys(newChangeRequest,Keys.ENTER);
		
			//Capture change request number from search results
			String changeRequestFromSearchResult = driver.findElementByXPath("//a[@class='linked formlink']").getText();
		
			//Verify the successful creation of change request
			if (changeRequestFromSearchResult.equals(newChangeRequest)) 
				System.out.println("Change request created successfully");
			else
				System.out.println("Change request not created");
	
		//Close browser
		driver.close();
	}

}
