package week4_day2_Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NykaaApplication {

	public static void main(String[] args) throws InterruptedException {
		
		//setting up driver and browser property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			//Create an object to disable notification
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notification");
		
			//create object for ChromeDriver
			ChromeDriver driver = new ChromeDriver(options);
			
		//Launch URL
		driver.get("https://www.nykaa.com/");
			
			//maximize the window
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			//implict wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//create an object for Actions Class
			Actions builder = new Actions(driver);
				
		//Mouseover on Brands and Mouseover on Popular
		WebElement brands = driver.findElementByXPath("//a[text()='brands']");
			
			builder.moveToElement(brands).perform();
			Thread.sleep(1000);
			
			//Mouse hover on Popualr and Click L'Oreal Paris
			WebElement popular = driver.findElementByXPath("//a[text()='Popular']");
			
			builder.moveToElement(popular).perform();
			
			//click on loreal-paris
			driver.findElementByXPath("//a[@href='/brands/loreal-paris/c/595?eq=desktop']").click();
			Thread.sleep(2000);
			
			//Go to the newly opened window, check the Page title contains L'Oreal Paris and close the first window
			String newWindowTitle = driver.getTitle();
			
			if (newWindowTitle.contains("L'Oreal Paris")) {
				System.out.println("Page title of newly opened window is: "+newWindowTitle);
			}
					
			//Get first and second windows references
			Set<String> firstAndSecondWindows = driver.getWindowHandles();
			
			//create a list to copy references from set to list
			List<String> list1 = new ArrayList<String>(firstAndSecondWindows);
			
			String firstWindow = list1.get(0);
			
			//Switch to first window
			driver.switchTo().window(firstWindow).close();
			Thread.sleep(1000);
		
			
		//Switch to second window
		String secondWindow = list1.get(1);
		
		driver.switchTo().window(secondWindow);
			
		//Click sort By and select customer top rated
		driver.findElementByXPath("//div[@class='sort-btn clearfix']").click();
		
		//click customer top rated radio button
		driver.findElementByXPath("(//div[@class='control__indicator radio'])[4]").click();
		Thread.sleep(2000);
		
		//Click Category 
		driver.findElementByXPath("//div[text()='Category']").click();
		
		//click Shampoo
		driver.findElementByXPath("(//label[@for='chk_Shampoo_undefined']/div)[1]").click();
		
		Thread.sleep(2000);
		
		//Click the first listed item
		driver.findElementByXPath("(//div[@class='m-content__product-list__title']//span)[1]").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> list2 = new ArrayList<String>(windowHandles);
		
		String firstShampooWindow = list2.get(1);
		
		driver.switchTo().window(firstShampooWindow);
		
		//Get reference of newly opened window
		//String firstDisplayedShampoo = driver.getWindowHandle();
		
		
		//driver.switchTo().window(firstDisplayedShampoo);
		
		//GO to the new window and click add to bag
		driver.findElementByXPath("//div[@class='clearfix combo-add-to-btn-section']").click();
		
		//Go to Shopping Bag and click Proceed
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		
		//click proceed button
		driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
		
		//Print the error message and Close the browser
		String popupError = driver.findElementByXPath("//div[@class='popup-error']").getText();
		System.out.println("Displayed error is:"+popupError);
		
		//Close the browser
		driver.close();
	}

}
