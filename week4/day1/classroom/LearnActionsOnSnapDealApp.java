package week4.day1.classroom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearnActionsOnSnapDealApp {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting up browser and driver property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
			//create object for ChromeOptions to disable notification on Chrome
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
		
		
			//Create driver object for ChromeDriver
			ChromeDriver driver = new ChromeDriver(options);
		
		//Launch URL
		driver.get("https://www.snapdeal.com/");
		
			//Maximize the window
			driver.manage().window().maximize();
		
			Thread.sleep(2000);
		
		// Mouse hover on Men's Fashion and Click Shirts
		WebElement mensFashion = driver.findElementByXPath("(//span[contains(text(),'Men')])[2]");		
		
			//Create object for Action class
			Actions builder = new Actions(driver);
			
			//Mouse hover on Men's Fashion
			builder.moveToElement(mensFashion).perform();
		
			Thread.sleep(2000);
		
			//Click on Shirts under Clothing Category
			driver.findElementByXPath("(//span[text()='Shirts'])[2]").click();
		
		// Mouse hover on the first product and Click on Quick View
		WebElement shirtPrice = driver.findElementByXPath("//span[contains(@id,'display-price')]");
			
			//Mouse hover on the first product
			builder.moveToElement(shirtPrice).perform();
		
			//Click Quick View button
			driver.findElementByXPath("//div[contains(text(),'Quick View')]").click();
			
			Thread.sleep(1000);
			
			String productDetails = driver.findElementByXPath("//div[@class='quickViewHead']").getText();
			System.out.println("Product name is:"+productDetails);
		
		//Close Browser
		driver.close();
			
	}

}
