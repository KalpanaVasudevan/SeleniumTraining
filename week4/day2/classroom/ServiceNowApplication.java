package week4.day2.classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ServiceNowApplication {

	public static void main(String[] args) {
		
		//Setting up driver and browser property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Create an object for ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL
		driver.get("https://dev60453.service-now.com/");
		
		//maximize the window
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//get into frame
		driver.switchTo().frame("gsft_main");
		
		//Enter user name
		driver.findElementByXPath("//input[@id='user_name']").sendKeys("admin");
		
		//Enter password
		driver.findElementByXPath("//input[@id='user_password']").sendKeys("India@123");
		
		//Click Login Button
		driver.findElementById("sysverb_login").click();
		
		driver.switchTo().defaultContent();
		
		//Get title of page
		System.out.println(driver.getTitle());
		
		
		//close the application
		driver.close();	
		
	}

}
