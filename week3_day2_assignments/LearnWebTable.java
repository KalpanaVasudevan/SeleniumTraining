package week3_day2_assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebTable {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting up driver and browser property
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		
		//create object for ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Launch URL
		driver.get("http://www.leafground.com/pages/table.html");
		
		//Get the table and store it as a webelement
		WebElement table = driver.findElementByXPath("//table[@id='table_id']");
		
		
		//Find the number of rows based on its tag name and store it in a list
		List<WebElement> tableRows = driver.findElementsByXPath("//table[@id='table_id']//tr");
		
		//number of rows in a table
		int rowSize = tableRows.size();
		
		//Print the size of the rows
		System.out.println("Number of rows in a table: "+rowSize);
		
		//Find the number of cols based on its tag name and store it in a list
		List<WebElement> tableCols = driver.findElementsByXPath("//table[@id='table_id']//tr[2]/td");
		
		//number of columns in a table
		int colSize = tableCols.size();
		
		//Print the size of the cols
		System.out.println("Number of columns in a table: "+colSize);
		
		
		// Get the progress value of 'Learn to interact with Elements' and store it in a variable
		
		for (int i = 2; i <= rowSize; i++) {
			
			String text = driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]").getText();
			//System.out.println(text);
			
			if (text.contains("Learn to interact with Elements")) {
				
				//Print the text of the variable
				String progressValueofElements = driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]/td[2]").getText();
				
				System.out.println("progress value of Learn to interact with Elements is: "+progressValueofElements);
				
				break;
			}
			
		}
		
		
		//Find the vital task for the least completed progress and check the box
		
		List<Integer> list = new ArrayList<Integer>();
		
		  for (int j = 2; j <= rowSize; j++) 
		  {
		  
			  String progressText = driver.findElementByXPath("//table[@id='table_id']//tr["+j+"]/td[2]").getText();
		  
			  String replacedString = progressText.replace("%", "");
		
			  int progressTextIntValue = Integer.parseInt(replacedString);
			  
			  //Add progress text value to created List
			  list.add(progressTextIntValue);
			  
		  }
		 
		
		  //Get minimum values in the list
		  Integer minProgressValue = Collections.min(list);
		
		  System.out.println("Least completed progress Value is: "+minProgressValue);
		
		
		
		  // check the vital task checkbox for least completed progress
		
		  for (int i = 2; i <= rowSize; i++) {
			
			  for (int j = 1; j <= colSize; j++) 
			  {
				
				  String Text = driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]/td["+j+"]").getText();
								
				  if (Text.contains(minProgressValue.toString())) 
				  {
					
					  //Check the vital task Checkbox
					  driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]/td/input").click();
				  }
				
			  }
			
		  }		
		
	}

}
