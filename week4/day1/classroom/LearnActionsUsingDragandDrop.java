package week4.day1.classroom;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnActionsUsingDragandDrop {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting up driver and browser property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
			//Create an object for ChromeDriver
			ChromeDriver driver = new ChromeDriver();
		
		//Launch URL
		driver.get("https://jqueryui.com/sortable/");
		
			Thread.sleep(2000);
		
			//Maximize the window
			driver.manage().window().maximize();
		
		//Get into the frame
		driver.switchTo().frame(0);
		
			//Find webelement item1 in the page
			WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		
			//Find webelement item4 in the page
			WebElement item4 = driver.findElementByXPath("//li[contains(text(),'Item 4')]");
		
			//Find location of item4
			Point location = item4.getLocation();
		
			int x = location.getX();
		
			int y = location.getY();
	
		//Create an object for Actions Class
		Actions builder = new Actions(driver);
		
		//Place the Item 1 in the Item4 place
		builder.dragAndDropBy(item1, x, y).perform();
		
		Thread.sleep(2000);
		
		//Close the browser
		driver.close();
		
	}

}
