package week3.day2.classroom;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTrainNamesAreUnique {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting up browser and driver property
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		//Create object for chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL
		driver.get("https://erail.in/");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Click the 'sort on date' checkbox
		driver.findElementById("chkSelectDateOnly").click();
		
		//clear and type in the from station text field
		WebElement fromStation = driver.findElementById("txtStationFrom");
		
		//clear value in from station
		fromStation.clear();
		
		//Enter the value in from station field
		fromStation.sendKeys("MAS",Keys.TAB);
		
		//clear and type in the to station text field
		WebElement toStation = driver.findElementById("txtStationTo");
		
		//clear value from toStation field
		toStation.clear();
		
		//Enter the value in toStation field
		toStation.sendKeys("SBC",Keys.TAB);
		
		//Add a java sleep for 2 seconds
		Thread.sleep(2000);
		
		//xpath for row in a table
		List<WebElement> rows = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr");
		
		//size of row
		int rowSize = rows.size();
		
		//Create List to store all train names
		List<String> trainList = new LinkedList<String>();
		
		//Store all the train names from a table to a list
		for (int i = 1; i <= rowSize; i++) {
			
			//get train names from column
			String trainNames = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]").getText();
			
			//Add train name to List
			trainList.add(trainNames);
			
		}
		
		System.out.println("Train names added to list is: ");
		
		System.out.print(trainList);
		
		System.out.println(" ");
		
		//Get the size of list
		int listSize = trainList.size();
		
		
		//Create a Set and add all the train names to Set
		Set<String> trainSet = new HashSet<String>();
		
		//Add the list into a new Set
		trainSet.addAll(trainList);
		
		System.out.println("Train names are added to Set is: ");
		
		System.out.println(trainSet);
		
		//Get the size of set
		int setSize = trainSet.size();
		
		System.out.println(" ");
		System.out.println("number of values available in set is: "+setSize);
		
		System.out.println("number of values available in list is "+listSize);
		
		//Compare the Size of list and Set to verify the names are unique
		if (listSize==setSize) {
			System.out.println("List and Set have same number of train names");
			
		} else {
			System.out.println("List and Set is not having same number of train names");
		}
		
		
		
	}

}
