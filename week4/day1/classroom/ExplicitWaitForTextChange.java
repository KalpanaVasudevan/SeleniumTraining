package week4.day1.classroom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWaitForTextChange {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting up driver and browser property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Create object for ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL
		driver.get("http://www.leafground.com/home.html");
		
			//Maximize the window
			driver.manage().window().maximize();
		
		//Click  Wait for Text Change element
		driver.findElementByXPath("//h5[text()='Wait for Text Change']").click();
		
		//Explicit Wait		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
			//Wait until the button text changes to Click ME!
			wait.until(ExpectedConditions.textToBe(By.id("btn"), "Click ME!"));
		
			//Click the button
			driver.findElementByXPath("//button[@id='btn']").click();
			
			//click on the 'OK' button of the alert
			driver.switchTo().alert().accept();
			
			Thread.sleep(1000);
			
		//Close the browser
		driver.close();
	}

}
