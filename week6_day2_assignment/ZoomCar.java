package week6_day2_assignment;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomCar {
	public static String highPricedCarRide;
	public static void main(String[] args) throws InterruptedException {
	
		
		//setting up driver and browser property
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		//create an object for chromedriver
		ChromeDriver driver = new ChromeDriver();
		
		//launch Url and maximize the window
		driver.get("https://www.zoomcar.com/chennai");
		
		driver.manage().window().maximize();//maximize the window
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		
		//Click on the Start your wonderful journey link
		driver.findElementByXPath("//a[@title='Start your wonderful journey']").click();
		Thread.sleep(2000);
		
		//In the Search page, Click on any pick up point under POPULAR PICK-UP
		driver.findElementByXPath("(//div[@class='items'])[1]").click();
		Thread.sleep(2000);
		
		//Click on the Next button
		driver.findElementByXPath("//button[text()='Next']").click();
		Thread.sleep(1000);
		
		//Get current date and 
			Date date = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd");
			String format = sdf.format(date);
			
			int currentDate = Integer.parseInt(format); //current system date
	
			int startDate = currentDate + 1; //next day of current date
			
		//Specify the Start Date as tomorrow Date
		driver.findElementByXPath("//div[contains(text(),'"+startDate+"')]").click();
		Thread.sleep(1000);
		
		//Click on the Next Button
		driver.findElementByXPath("//button[text()='Next']").click();
		Thread.sleep(1000);
		
		//Confirm the Next day of Start Date  
		int nextDayOfStartDate = startDate + 1;
		driver.findElementByXPath("//div[contains(text(),'"+nextDayOfStartDate+"')]").click();
		
		//Click on the Done button
		driver.findElementByXPath("//button[text()='Done']").click();
		Thread.sleep(3000);
		
		//In the result page, capture the number of results displayed
		
		Map<String,String> map = new LinkedHashMap<String,String>(); //create map to store key and value pairs.
		
		List<WebElement> carNames = driver.findElementsByXPath("//div[@class='details']/h3"); //get all car names in list
		
		List<WebElement> carPrices = driver.findElementsByXPath("//div[@class='price']");//get all car prices in list
		
		//Iterate through each list and add car name and car price to map respectively.
		for (int i = 0; i <carNames.size(); i++) {
			
			String carNameKey = carNames.get(i).getText(); //get Car name
			
			String carPriceValue = carPrices.get(i).getText().replaceAll("[^0-9]", ""); //get car price
		
			map.put(carNameKey,carPriceValue);		//add car name and car price to map
			
		}	
		
		//Get the size of map(number of results displayed)
		System.out.println("No of results dispalyed is:"+map.size());
		
		//Find the highest priced car ride.
		String highestPriceDisplayed = Collections.max(map.values()); //Highest Car price displayed
		System.out.println("Highest Car Price Displayed is:"+highestPriceDisplayed);
		
		for (Entry<String, String> eachEntry : map.entrySet()) {
			if ((eachEntry.getValue()).equals(highestPriceDisplayed)) 
			{
				
				highPricedCarRide = eachEntry.getKey(); //highest priced car ride
				System.out.println("Highest priced car is: "+highPricedCarRide);
			}
		}
		
		
		//Click on the Book Now button for it	
		Thread.sleep(2000);
		driver.findElementByXPath("//h3[text()='"+highPricedCarRide+"']//following::button[1]").click();
		Thread.sleep(1500);
		
		//Close the Browser.
		driver.close();
	}

}
