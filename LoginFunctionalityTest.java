import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFunctionalityTest {
	
//Declaration of the object webdriver
	public static WebDriver driver = null;
	
	

	@BeforeAll
	public static void BeforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	//@BeforeEach
	//public static void BeforeEach() {

	//}

	@AfterAll
	public static void afterAll() {}

	//@AfterEach
	//public void afterEach() {}


	@Test
	@DisplayName("Login Test - Happy Path")
	public void tc001() throws InterruptedException {
        //Open the URL of Guru99 
		driver.get("http://demo.guru99.com/v4");
		driver.manage().window().maximize();
         Thread.sleep(3000);
         
         //Closing the Iframe with GDPR consent
         driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
        
         //Typing UserID
         driver.findElement(By.name("uid")).sendKeys("mngr459024");
         
         //Typing password
         driver.findElement(By.name("password")).sendKeys("UjumEte");
        
         //CLick the button login
         driver.findElement(By.name("btnLogin")).click();
        
         //Check the expected results
         String expectedResults ="Welcome To Manager's Page of Guru99 Bank";
         String actualResults = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td > marquee")).getText();
	
         //AssertTrue will return true or false
         //assertTrue(actualResults.equals(expectedResults));
         
         
       //AssertEquals will compare two variables
         assertEquals(expectedResults,actualResults);
	
	}

	@Test
	@DisplayName("Check results on executing Invalid User Id and Password")
	public void tc002() throws InterruptedException {
		//Open the URL
				driver.get("http://demo.guru99.com/v4");
				
				driver.manage().window().maximize();
				Thread.sleep(3000);
				
				//WebDriverWait wait = new WebDriverWait(null, null);
				//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save")));
				//element.click();
				
				//Closing the Iframe with GDPR Consent
				driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
				Thread.sleep(3000);
				
				//Typing UserID
				driver.findElement(By.name("uid")).sendKeys("test99");
				
				//Type the Password
				driver.findElement(By.name("password")).sendKeys("pass99");
				
				//Click on the button LOGIN
				driver.findElement(By.name("btnLogin")).click();
				
				String actualText = driver.switchTo().alert().getText();
				String expectedText = "User or Password is not valid";
				
				assertEquals(expectedText, actualText);
				
				Thread.sleep(3000);
				
				driver.switchTo().alert().accept();

	}
	@Test
	@DisplayName("Check response when a User ID is Empty & Login Button is pressed")
	public void tc003() throws InterruptedException {
			//Open the URL
					driver.get("http://demo.guru99.com/v4");
					
					driver.manage().window().maximize();
					Thread.sleep(3000);
					
					//WebDriverWait wait = new WebDriverWait(null, null);
					//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save")));
					//element.click();
					
					//Closing the Iframe with GDPR Consent
					driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
					Thread.sleep(3000);
					
					//Typing UserID
					driver.findElement(By.name("uid")).sendKeys("");
					
					//Type the Password
					driver.findElement(By.name("password")).sendKeys("");
					Thread.sleep(4000);
					
					//Click on the button LOGIN
					driver.findElement(By.name("btnLogin")).click();
					
					String actualText = driver.switchTo().alert().getText();
					String expectedText = "User or Password is not valid";
					
					assertEquals(expectedText, actualText);
					
					Thread.sleep(3000);
					
					driver.switchTo().alert().accept();
		

	}
}
