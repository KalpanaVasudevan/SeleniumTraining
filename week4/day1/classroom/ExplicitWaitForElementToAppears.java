package week4.day1.classroom;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitForElementToAppears {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting up driver and browser property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
			//Create an object for ChromeDriver
			ChromeDriver driver = new ChromeDriver();
			
			//maximize the window
			driver.manage().window().maximize();
			
		//Launch URL
		driver.get("http://www.leafground.com/home.html");
		
		//click on wait to appear image
		driver.findElementByXPath("//h5[text()='Wait to Appear']").click();
		
		//Create object for WebDriverWait class
		WebDriverWait wait = new WebDriverWait(driver,30);
			
			//wait until 'Voila! I'm here Guys' element appears on page
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn")));
			
			//Get text of the newly appeared element
			String newlyAppearedButtonText = driver.findElementById("btn").getText();
			
			//Print it into console
			System.out.println("Newly appeared element text is:"+newlyAppearedButtonText);
			
			Thread.sleep(1500);
			
		//Close the browser
		driver.close();
		
	}

}
