package week5.day2.TestngFramework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuplicateLead extends ParentClass{
	
	@BeforeTest
	public void setFileName()
	{
		workBookName="DuplicateLead";
	}

	@Test(dataProvider="fetchData")
	public void runDuplicateLead(String email) throws InterruptedException
	{
		//click Find Leads Link
			driver.findElementByLinkText("Find Leads").click();
			Thread.sleep(500);	
		
		//Click on Email
			driver.findElementByXPath("//span[text()='Email']").click();
			Thread.sleep(500);
		
		//Enter Email
			//String email = "kalpana23@gmail.com";
		
			driver.findElementByXPath("//input[@name='emailAddress']").sendKeys(email);
		
		//Click find leads button
			driver.findElementByXPath("//button[text()='Find Leads']").click();
			Thread.sleep(2000);	
	
		//Capture name of First Resulting lead
			String firstLead = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").getText();
		
			String leadName = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]").getText();
		
			System.out.println("First resulting Lead ID is: "+firstLead);		
			System.out.println("First resulting Lead Name is: "+leadName);
		
		//Click First Resulting lead		
			driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		
		//Click Duplicate Lead
			driver.findElementByXPath("//a[text()='Duplicate Lead']").click();	
			Thread.sleep(1000);
		
		//Verify the title as 'Duplicate Lead'
			String pageTitle = driver.getTitle();
		
			if (pageTitle.contains("Duplicate Lead")) {
				System.out.println("Navigated to Duplicate Lead Page successfully");
			
			} else {
				System.out.println("Duplicate Lead Page not available");
			}
		
		//Click Create Lead button			
			driver.findElementByXPath("//input[@value='Create Lead']").click();
			Thread.sleep(1000);
			
		//Confirm the duplicated lead name is same as captured name
			String duplicateLeadName = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();
		
			System.out.println("Duplicate Lead Name is: "+duplicateLeadName);
	
		//Verify both Lead Names are same or not	
			if (leadName.equals(duplicateLeadName)) {
				System.out.println("Duplicated lead name is same as captured name: "+duplicateLeadName);
			} else {
				System.out.println("Duplicated lead name is not same as captured name: "+" First Captured Lead Name is: "+leadName+"Duplicate Lead name is: "+duplicateLeadName);
			}
		
	}
	
	
}
