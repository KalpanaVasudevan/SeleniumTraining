package week4.day2.classroom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnWindowsHandle {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Setting up driver and browser property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				
			//Create object for chrome driver
			ChromeDriver driver = new ChromeDriver();
				
		//launch URL
		driver.get("https://www.irctc.co.in/nget/train-search");
					
			//implicitlywait
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		//Click Ok for the alert
		driver.findElementByXPath("//button[text()='Ok']").click();
		
			//maximize the window
			driver.manage().window().maximize();
			
			//Get ticketing window reference
			String trainTicketingWindow = driver.getWindowHandle();
			
			//System.out.println("Ticketing window reference"+trainTicketingWindow);
			
		//Click on FLIGHTS link
		driver.findElementByXPath("//a[text()=' FLIGHTS ']").click();
		Thread.sleep(2000);
		
		//Get both windows reference
		Set<String> firstAndSecondWindows = driver.getWindowHandles();
		
			//create list to copy all the set items
			List<String> windowsList = new ArrayList<String>(firstAndSecondWindows);
		
			//Get second window reference
			String secondWindow = windowsList.get(1);
			
			//Switch to second window
			driver.switchTo().window(secondWindow);
		
		//create an object for Actions class
		Actions builder = new Actions(driver);
		
		WebElement checkbox = driver.findElementById("agree");
		Thread.sleep(1000);
		
		//Click checkbox in notification
		builder.click(checkbox).perform();
		
		//Click on Continue
		driver.findElementByXPath("//button[text()='Continue ']").click();
		
		//take screenShot of Flights window
		File source = driver.getScreenshotAs(OutputType.FILE);
		
		File target = new File("./snaps/flightwindow.png");
		
		FileUtils.copyFile(source, target);
		
		//Close the first window (Train eTicketing) alone
			//Get second window reference
			String irctcWindow = windowsList.get(0);
		
			//Switch to second window
			driver.switchTo().window(irctcWindow);
			Thread.sleep(1000);
			
			//close train search page			
			driver.close();
		
	}

}
