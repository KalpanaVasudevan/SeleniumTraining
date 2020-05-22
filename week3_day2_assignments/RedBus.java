package week3_day2_assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		
		//setting up browser and driver property
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
			//Create an object to disable notification in Chrome
			ChromeOptions options = new ChromeOptions();
		
			options.addArguments("--disable-notifications");
		
			//create object for ChromeDriver
			ChromeDriver driver = new ChromeDriver(options);
		
		//Launch URL
		driver.get("https://www.redbus.in/");
			
			//Impicitwait
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
			//Maximize window
			driver.manage().window().maximize();
		
		//Enter From (Chennai) and Tab
		WebElement from = driver.findElementByXPath("//input[@id='src']");
			
			from.sendKeys("Chennai");
			Thread.sleep(1000);
			
			from.sendKeys(Keys.TAB);		
		
		//Enter To (Trichy) and Tab 
		WebElement destination = driver.findElementByXPath("//input[@id='dest']");
		  
		  	destination.sendKeys("Trichy"); 
		  	Thread.sleep(1000);
		  
		  	destination.sendKeys(Keys.TAB);
		 
		//Click on current date 
		//driver.findElementByXPath("//table[@class='rb-monthTable first last']//tr/td[@class='current day']").click();
		driver.findElementByXPath("(//td[@class='current day'])[2]").click();
		
		Thread.sleep(1000);
		
		//Click on Return Date
		driver.findElementByXPath("//label[text()='Return Date']").click();
		
		//Click on current date 
		driver.findElementByXPath("(//table[@class='rb-monthTable first last']//tr/td[@class='current day'])[2]").click();
		
		//Click Search Buses
		driver.findElementById("search_btn").click();
		
		//Get displayed message
		String text = driver.findElementByXPath("//div[@class='msg-c-msg']").getText();
		
		System.out.println(text);
	}

}
