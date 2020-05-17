package week3.day2.classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting up driver and browser property
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		//Create object for chrome driver
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL
		driver.get("https://erail.in/");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Uncheck the check box - sort on date
		driver.findElementById("chkSelectDateOnly").click();
		
		//clear and type in the source station
		WebElement sourceStation = driver.findElementByXPath("//input[@id='txtStationFrom']");
		
		//Clear the value in source station
		sourceStation.clear();
		
		//ENter the value in source station
		sourceStation.sendKeys("MAS",Keys.TAB);
		
		//clear and type in the destination station
		WebElement destinationStation = driver.findElementByXPath("//input[@id='txtStationTo']");
		
		//clear the value in destination
		destinationStation.clear();
		
		//Enter value in destination station'
		destinationStation.sendKeys("SBC",Keys.TAB);
		
		Thread.sleep(2000);
		
		//xpath for row in a table
		List<WebElement> rows = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr");
		
		//row size in table
		int rowSize = rows.size();
		  
		//System.out.println(rowSize);
		  
		List<String> list = new ArrayList<String>();  
		
		for (int i = 1; i <= rowSize; i++) 
		  {
			 //Find all the train names using xpath and store it in a list 
			 String trainNames = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]").getText();

			 //add train name to List
			 list.add(trainNames);
			  		  
		  }
		 
		System.out.println("Train names added successfully to list: ");
		
		System.out.println(list);
		
		//Use Java Collections sort to sort it and then print it
		Collections.sort(list);
		
		System.out.println("Train Names after sorting: ");
		
		System.out.println(list);
		
		//Close the browser
		driver.close();
	}

}
