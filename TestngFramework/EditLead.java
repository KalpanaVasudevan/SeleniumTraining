package week5.day2.TestngFramework;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends ParentClass{
	
	@BeforeTest
	public void setFileName()
	{
		workBookName="EditLead";
	}
	
	
	@Test(dataProvider="fetchData")
	public void runEditLead(String fName,String cName) throws InterruptedException {
		
		//Click Find leads
			driver.findElementByXPath("//a[text()='Find Leads']").click();
			Thread.sleep(1000);
			
		//Enter first name
			driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys(fName);
			
		//	Click Find leads button		
			driver.findElementByXPath("//button[text()='Find Leads']").click();
			
		//provide wait time to load search results
			Thread.sleep(2000);
			
		//Click on first resulting lead
			driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
			
		//Verify title of the page
			String pageTitle = driver.getTitle();
			
			if (pageTitle.contains("View Lead")) {
				System.out.println("Navigated to View Lead Page successfully");
			}
			
		//Click Edit
			driver.findElementByXPath("//a[text()='Edit']").click();
			
		//Change the company name
			//String expectedCompanyName="Cognizant";
			
			WebElement companyName = driver.findElementByXPath("//input[@id='updateLeadForm_companyName']");
			
				//Clear the company name
				companyName.clear();
				
				//change company name
				companyName.sendKeys(cName);
			
			
		//Click Update
			driver.findElementByXPath("//input[@value='Update']").click();
			
			Thread.sleep(1000);
			
		//Confirm the changed name appears
			String updatedCompanyName = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
			
			if (updatedCompanyName.contains(cName))
				System.out.println("Company Name updated as expected and Updated company name is:"+cName);
			else
				System.out.println("Company Name not updated as expected "+"Actual company name displayed is: "+updatedCompanyName+" Expected company name is: "+cName);
			
		}

}
