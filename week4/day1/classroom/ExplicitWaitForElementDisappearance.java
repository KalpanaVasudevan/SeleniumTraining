package week4.day1.classroom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitForElementDisappearance {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting up property for driver and browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
			//create an object for ChromeDriver
			ChromeDriver driver = new ChromeDriver();
		
		//launch URL
		driver.get("http://www.leafground.com/home.html");
		
			//maximize the window
			driver.manage().window().maximize();
		
		//click wait to disappear image
		driver.findElementByXPath("//h5[text()='Wait to Disappear']").click();
		
		//Create an object for WebDriverWait class
		WebDriverWait wait = new WebDriverWait(driver,30);
		
			WebElement disappearedButton = driver.findElementByXPath("//button[@id='btn']");
			
			//wait until the button get disappeared 
			wait.until(ExpectedConditions.invisibilityOf(disappearedButton));
			
			//once button disappeared get the text saying disappeared and print it  
			String messageDisplayed = driver.findElementByXPath("//strong[contains(text(),'Button is disappeared!')]").getText();
		
			System.out.println(messageDisplayed);
			
			Thread.sleep(1000);
			
		//Close the browser
		driver.close();
	}

}
