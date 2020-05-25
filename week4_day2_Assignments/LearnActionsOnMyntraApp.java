package week4_day2_Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearnActionsOnMyntraApp {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting up browser and driver property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
		
			//Create an object for ChromeDriver 
			ChromeDriver driver = new ChromeDriver(options);
				
	//Step1:Open https://www.myntra.com/
			driver.get("https://www.myntra.com/");
				
			/*maximize the window*/
			driver.manage().window().maximize();
			
			//Create an object for Actions class
			Actions builder = new Actions(driver);
		
		
	//Step 2: Mouse over on WOMEN 
		
			/*Find Webelement Women on the page */
			WebElement women = driver.findElementByXPath("//a[text()='Women']");
			
			/*mouse hover on women*/
			builder.moveToElement(women).perform();
			Thread.sleep(2000);
		
	//Step3: Click Jackets & Coats
			
			/* find webelement Jackets & Coats in the page*/
			driver.findElementByXPath("//a[text()='Jackets & Coats']").click();
		
	//Step4: Find the total count of item 
			String countDiaplyed = driver.findElementByXPath("//span[@class='title-count']").getText();
		
			/*Total count of Coats & Jackets For Women*/
			int itemsCountDisplayed = Integer.parseInt(countDiaplyed.replaceAll("[^0-9]+", ""));
			
			System.out.println("Total count of Coats & Jackets For Women: "+itemsCountDisplayed);
		
	//Step5: Validate the sum of categories count matches
		
			int jacketsCount = Integer.parseInt(driver.findElementByXPath("//span[@class='categories-num']").getText().replaceAll("[^a-zA-Z0-9 ]", ""));
		
			int CoatsCount = Integer.parseInt(driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText().replaceAll("[^a-zA-Z0-9 ]", ""));
			int sumOfCategories = jacketsCount+CoatsCount;
			
			/*verify total count and sum of categories count*/
			if (itemsCountDisplayed==sumOfCategories) 
				System.out.println("Sum of categories count matched with total count: "+sumOfCategories);
			else
				System.out.println("Sum of categories count not matched with total count: "+sumOfCategories);	
		
			Thread.sleep(2000);
		
	//Step6: Check Coats in CATEGORIES 
			
			driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		
	//Step7: Click + More option under BRAND
			
			driver.findElementByXPath("//div[@class='brand-more']").click();
			Thread.sleep(2000);	
		
	//Step8: Type MANGO and click checkbox
			
			WebElement searchInput = driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']");
		
			/* Type MANGO */
			searchInput.sendKeys("MANGO");	
			Thread.sleep(1000);
		
			/* Click MANGO Checkbox */
			driver.findElementByXPath("//label[@class=' common-customCheckbox']/div").click();
		
	//Step9: Close the pop-up x
			
			driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
			Thread.sleep(2000);
		
	//Step10: Confirm all the Coats are of brand MANGO
			
			List<WebElement> productInfo = driver.findElementsByXPath("//div[@class='product-productMetaInfo']/h3");
			
			int size = productInfo.size();//sise of the list
			int brandVerficationCount=0; //variable declared for verification purpose
			
				for (int i = 1; i <= size; i++) {
					/*Get each brand name*/
					String eachBrandName = driver.findElementByXPath("(//div[@class='product-productMetaInfo']/h3)["+i+"]").getText();
				
					//System.out.println(eachBrandName);
			 
					/*Verifying all the Coats are of brand MANGO*/  
					if (eachBrandName.equals("MANGO")) {
						brandVerficationCount = brandVerficationCount+1;
					}
				}
		
				/*verifying product count*/ 
				if (size==brandVerficationCount) 
					System.out.println("All the Coats are of brand MANGO");			
				else
					System.out.println("Coats with other than MANGO brand available in list and count mismatching");
		
	//Step11: Sort by Better Discount		
			
			WebElement sortBy = driver.findElementByXPath("//div[@class='sort-sortBy']");
		
			/*Mouse hover on sort by*/
			builder.moveToElement(sortBy).perform();
		
			/*select Better Discount*/
			WebElement betterDiscount = driver.findElementByXPath("//label[contains(text(),'Better Discount')]");
		
			builder.click(betterDiscount).perform();

		
	//Step12: Find the price of first displayed item 
			
			builder.moveToElement(driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]")).perform();			
			Thread.sleep(2000);
			
			String firstProductDiscountPrice = driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]").getText();
			
			System.out.println("Price of first displayed item is: "+firstProductDiscountPrice);
			Thread.sleep(1000);
			
	//Step13: Mouse over on size of the first item
			
			/*size element of first item*/
			WebElement firstProductSize = driver.findElementByXPath("(//h4[@class='product-sizes'])[1]");
			
			/*mouse hover on size of the first item*/
			builder.moveToElement(firstProductSize).perform();
		
	//Step14: Click on WishList Now
			
			driver.findElementByXPath("(//span[@class='product-actionsButton product-wishlist '])[1]").click();			
			Thread.sleep(2000);
			
			/*Check whether Mobile number field is available or not*/
			if (driver.findElementByXPath("//input[@class='form-control mobileNumberInput']").isDisplayed()) 
				System.out.println("Enter phonenumber number to Login or SignUp");
			else
				System.out.println("No Login or SignUp page available");	
						
	//Step15: Close Browser
			driver.close();
	}
	
}
