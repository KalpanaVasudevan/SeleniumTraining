package week3_day2_assignments;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ClearTrip {

	public static void main(String[] args) throws InterruptedException {
		
		//setting up browser and driver property
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		//create an object to disable nptification in chrome
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		
		//create object for chrome driver
		ChromeDriver driver = new ChromeDriver(options);
		
		//Launch URL
		driver.get("https://www.cleartrip.com/");
		
			//implicit wait time 
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
			//maximize window
			driver.manage().window().maximize();
		
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Click Round trip
		driver.findElementById("RoundTrip").click();
		
			Thread.sleep(500);
		
		//Enter From city (Chennai) and TAB
		WebElement fromCity = driver.findElementById("FromTag");

			fromCity.sendKeys("Chennai",Keys.TAB);
			Thread.sleep(500);
		
		//Enter To city (New York) and TAB
		WebElement toCity = driver.findElementById("ToTag");
		
			toCity.sendKeys("New York",Keys.TAB);
			Thread.sleep(500);
		
		//Click Depart On (text box) 
		driver.findElementByXPath("//input[@id='DepartDate']").click();
		
		//Click Date (use current date as hardcoded) // Note it is link -> so use linkText
		
		//Get current system date
		Date date = new Date();		
		SimpleDateFormat sf = new SimpleDateFormat("dd");
		String todayDate = sf.format(date);
		
		driver.findElementByLinkText(todayDate).click();
			Thread.sleep(1000);
		
		//Click Return On (text box) 
		driver.findElementByXPath("//input[@id='ReturnDate']").click();
		
		//Click Date (10) // Note it is link -> so use linkText
		driver.findElementByXPath("//a[text()='10']").click();
			Thread.sleep(1000);
		
		//Select Adults (as 2)
		WebElement adults = driver.findElementByXPath("//select[@id='Adults']");
		
			Select dropdown1 = new Select(adults);
		
			dropdown1.selectByVisibleText("2");
		
		//Select Children (as 1)
		WebElement childrenDropDown = driver.findElementByXPath("//select[@id='Childrens']");
		
			Select dropdown2 = new Select(childrenDropDown);
		
			dropdown2.selectByValue("1");
		
		//Select Infant (as 1)
		WebElement infantsDropdown = driver.findElementByXPath("//select[@id='Infants']");
		
			Select dropdown3 = new Select(infantsDropdown);
		
			dropdown3.selectByIndex(1);
		
		//Click More Options (use id as locator)
		driver.findElementByXPath("//a[@id='MoreOptionsLink']").click();
		
		//Select Premium Economy as Class of Travel
		WebElement classDropdown = driver.findElementByXPath("//select[@id='Class']");
		
			Select dropdown4 = new Select(classDropdown);
		
			dropdown4.selectByVisibleText("Premium Economy");
			
			Thread.sleep(1000);

		//Enter Preferred Airline as Emirates and TAB
		WebElement preferedAirline = driver.findElementByXPath("//input[@id='AirlineAutocomplete']");
		
			preferedAirline.sendKeys("Emirates",Keys.TAB);
			Thread.sleep(1000);
			
		//Click Search Flights
		driver.findElementByXPath("//input[@id='SearchBtn']").click();
			
			Thread.sleep(4000);
			
		//get displayed message
		String messageDisplayed = driver.findElementByXPath("//div[@class='warningMessage']/h2").getText();
		
		System.out.println(messageDisplayed);
			
	}

}
