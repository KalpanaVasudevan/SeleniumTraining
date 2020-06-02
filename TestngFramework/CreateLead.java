package week5.day2.TestngFramework;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends ParentClass{
	
	@BeforeTest
	public void setFileName()
	{
		workBookName="CreateLead";
	}
	
	
	@Test(dataProvider="fetchData")
	public void runCreateLead(String cName,String fName,String lName,String industry,String email)
	{
		//click create lead
	  	driver.findElementByXPath("//a[text()='Create Lead']").click();
		
		//enter company name
		driver.findElementByXPath("//input[@class='inputBox' and @name='companyName']").sendKeys(cName);
		
		//enter first name
		driver.findElementByXPath("//input[@class='inputBox' and @name='firstName']").sendKeys(fName);
		
		//enter last name
		driver.findElementByXPath("//input[@class='inputBox' and @name='lastName']").sendKeys(lName);
		
		//select aerospace
		WebElement industryID = driver.findElementByXPath("//select[@class='inputBox' and @name='industryEnumId']");
			Select dropdown = new Select(industryID);		
			dropdown.selectByVisibleText(industry);
		
		//enter email address
		driver.findElementById("createLeadForm_primaryEmail").sendKeys(email);
		
		//click submit button
		driver.findElementByXPath("//input[@name='submitButton']").click();
	}

	
	
}
