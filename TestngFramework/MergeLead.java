package week5.day2.TestngFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class MergeLead extends ParentClass{
		
		@Test
		public void runMergeLead() throws InterruptedException
		{
			//Click on Merge Lead using Xpath Locator
			  driver.findElementByXPath("//a[text()='Merge Leads']").click();
			  		
			  		//Get unique reference of first window
			  		String firstwindow = driver.getWindowHandle();
			  		
			  		//SwitchTo first window
			  		driver.switchTo().window(firstwindow);
			  		
			  		//get title 
			  		String title = driver.getTitle();
			  		
			  //Click on Widget of From Lead
			  driver.findElementByXPath("//input[@id='partyIdFrom']/following-sibling::a").click();
			  Thread.sleep(1000);
			  		
			  		//Get unique references of merge and from contact window		
			  		Set<String> mergeandFromLeadWindows = driver.getWindowHandles();
			  		
			  		//Create list to copy reference from set
			  		List<String> fromLeadList = new ArrayList<String>(mergeandFromLeadWindows);
			  		
			  		//Get unique reference of from contact window		 
			  		String fromLeadWindow = fromLeadList.get(1);
			  		
			  		//switch to from contact window
			  		driver.switchTo().window(fromLeadWindow);
			  
			  // Click on First Resulting Contact 
			  driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click(); 
			  Thread.sleep(1000);
			  
			  System.out.println("From Lead selected successfully");
			  
			 //switch to merge contact window
			  driver.switchTo().window(firstwindow);
			  		
			 //Click on Widget of To Contact
			 driver.findElementByXPath("//input[@id='partyIdTo']/following-sibling::a").click();
			 Thread.sleep(3000);
			  
			  		//Get unique references of merge and To contact window	
		  			Set<String> mergeandToLeadWindows = driver.getWindowHandles();
		  		
		  			//Create list to copy reference from set
		  			List<String> toLeadList = new ArrayList<String>(mergeandToLeadWindows);
		  		
		  			//Get unique reference of To contact window
		  			String toLeadWindow =toLeadList.get(1);
		  
		  			//Switch to To contact window
		  			driver.switchTo().window(toLeadWindow);
			 
			  //Click on Second Resulting Contact
			  driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]").click();
			  System.out.println("To Lead selected successfully");
			  
			  //switch to merge contact window
			  driver.switchTo().window(firstwindow);
			  
			  //Click on Merge button using Xpath Locator
			  driver.findElementByXPath("//a[text()='Merge']").click();
			  Thread.sleep(2000);
			  
			  // Accept the Alert 
			 driver.switchTo().alert().accept();
			 Thread.sleep(2000);
			  
			 // Verify the title of the page
			 System.out.println(driver.getTitle());
			 
			 if (driver.getTitle().contains("View Lead")) 
				System.out.println("View Lead page dispalyed successfully");
			 else
				System.out.println("View Lead page not dispalyed");	
			
		}
}
