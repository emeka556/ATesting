import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddAccountTest {
	//Declaration of the object webdriver
			public static WebDriver driver = null;
			
			

			@BeforeAll
			public static void BeforeAll() throws InterruptedException {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				preConditionLogin();
				
			}
			@AfterAll
			public static void afterAll() {
				
				//driver.quit();
				
				
			}
			public static void preConditionLogin() throws InterruptedException {
				
				//code to login in the system
				
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
				//Open the URL
				//Enter userid and password and login
			}
			
			@Test
			@DisplayName("Check results on entering a valid information for all fields for Savings Account")
			public void tc013() throws InterruptedException {
				
				
				
				//========Test Data==================
				String customerID = "96485";				
						
				//====================================
				
				//Click on the Link to add a new Account
				//driver.findElement(HomePage.letMenuNewAccount).click();
				//Go directly to the URL
				driver.get("https://demo.guru99.com/v4/manager/addAccount.php");
				
				
				//Enter a valid Customer ID
				//WebDriverWait wait = new WebDriverWait(null, null);
				//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cusid")));
				//element.click();
				//Thread.sleep(1000);
				
				driver.findElement(By.name("cusid")).sendKeys(customerID);
				
				//Change account type to Savings
				WebElement mySelectedElement = driver.findElement(By.name("selaccount"));
				Select dropdown= new Select(mySelectedElement);
				dropdown.selectByVisibleText("Savings");
				//dropdown.selectByValue("Savings");
				//dropdown.selectByIndex(0);

				//Add an initial deposit
				driver.findElement(By.name("inideposit")).sendKeys("1000");
				
				//Click on submit
				driver.findElement(By.name("button2")).click();
				
				//Check the expected Results
				String expectedResults = "Account Generated Successfully!!!";
				String actualResults = driver.findElement(By.cssSelector("#account > tbody > tr:nth-child(1) > td > p")).getText();
				assertEquals(expectedResults, actualResults);
				
				//Check CustomerID
				//Check AccountID
				// Check all the information
						
				
				
				
				
				
				
			}
			
		
}
