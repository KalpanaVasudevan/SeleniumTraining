package week4.day2.classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlerts {

	public static void main(String[] args) {
		
		//Setting up driver and browser property
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//Create object for chrome driver
		ChromeDriver driver = new ChromeDriver();
		
		//launch URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
			//maximize the window
			driver.manage().window().maximize();
			
			//implicitwait
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Get into frame -Try it button is inside frame
		driver.switchTo().frame("iframeResult");
		
			//Click Try it button
			driver.findElementByXPath("//button[text()='Try it']").click();
		
			//create alert object
			Alert alert = driver.switchTo().alert();
			
			//input to enter in textbox
			String input="kalpana";
		
			//Enter given input in Textbox
			alert.sendKeys(input);
		
			//click Ok button in alert
			alert.accept();
		
			//Get displayed Text from window
			String textDisplayed = driver.findElementByXPath("//p[@id='demo']").getText();
			
			//Verify that the text contains given name or not
			if (textDisplayed.contains(input)) 
				System.out.println("Given name "+input+" is available inside displayed text: "+textDisplayed);
			else
				
				System.out.println("Given name "+input+" is not available inside displayed text: "+textDisplayed);
		
		//Close the bowser
		driver.close();
	}

}
