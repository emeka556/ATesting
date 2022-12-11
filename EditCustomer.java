import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditCustomer {
	
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
		@DisplayName("Check results on entering a Valid Customer ID")
		public void tc007() throws InterruptedException {
			
			
			
			//========Test Data==================
			String customerID = "96485";
			
			
			
			String address = "499 Temples bar";
			String city = "Dublin";
			String state = "Dublin";
			Integer pin =  345678;
			String mobileNumber = "08329392023";
			Random random = new Random();
			int numberRandom = random.nextInt(100000);  // 54266
			//System.out.println(numberRandom);

			String email = "steph"+numberRandom+"@guru99.com";
			
		
			//====================================
			
			//Click on Edit Customer
			//driver.findElement(By.linkText("Edit Customer")).click();
			driver.get("https://demo.guru99.com/V4/manager/EditCustomer.php");
			
			//Enter Customer ID
			driver.findElement(By.name("cusid")).sendKeys(customerID);
			
			//CLick on submit button
			driver.findElement(By.name("AccSubmit")).click();
			
					
			
			
			//Enter address
			driver.findElement(By.name("addr")).clear();
			driver.findElement(By.name("addr")).sendKeys(address);
			
			//Enter city
			driver.findElement(By.name("city")).clear();
			driver.findElement(By.name("city")).sendKeys(city);
			
			//Enter state
			driver.findElement(By.name("state")).clear();
			driver.findElement(By.name("state")).sendKeys(state);
			
			//Enter Pin
			driver.findElement(By.name("pinno")).clear();
			driver.findElement(By.name("pinno")).sendKeys(pin.toString());
			//driver.findElement(By.name("pinno")).sendKeys(pin);
			
			//Enter MobileNumber
			driver.findElement(By.name("telephoneno")).clear();
			driver.findElement(By.name("telephoneno")).sendKeys(mobileNumber);
			
			//Enter Email
			driver.findElement(By.name("emailid")).clear();
			driver.findElement(By.name("emailid")).sendKeys(email);
			Thread.sleep(2000);
					
			//CLick the button submit
	        driver.findElement(By.name("sub")).click();
	        
	        
	        //No Changes made to Customer records
	        String actualText = driver.switchTo().alert().getText();
			String expectedText = "No Changes made to Customer records";
			
			assertEquals(expectedText, actualText);
			
			Thread.sleep(2000);
			
			driver.switchTo().alert().accept();
			
			
			
		}
		
		@Test
		@DisplayName("Check results on entering an invalid Customer ID")
		public void tc008() throws InterruptedException {
			
			//========Test Data==================
			String customerID = "333333";			
					
		
			//====================================
			
			
			//Click on Edit Customer
			//driver.findElement(By.linkText("Edit Customer")).click();
			driver.get("https://demo.guru99.com/V4/manager/EditCustomer.php");
			
			//Enter Customer ID
			driver.findElement(By.name("cusid")).sendKeys(customerID);
			
			//CLick on submit button
			driver.findElement(By.name("AccSubmit")).click();
			
			
			//Alert popup message "Customer does not exist!!"
			 String actualText = driver.switchTo().alert().getText();
				String expectedText = "Customer does not exist!!";
				
				assertEquals(expectedText, actualText);
				
				Thread.sleep(2000);
				
				driver.switchTo().alert().accept();
				
			
		}
		@Test
		@DisplayName("Check results leaving blank or entering special character on the Customer ID field")
		public void tc009() throws InterruptedException{
			
		//========Test Data==================
			String customrID = "";		
			//String customrID = "######";	
			//String customrID = "agdgfj";	
		//====================================
			
			
			//Click on Edit Customer
			//driver.findElement(By.linkText("Edit Customer")).click();
			driver.get("https://demo.guru99.com/V4/manager/EditCustomer.php");
			
			//Enter Customer ID
			driver.findElement(By.name("cusid")).sendKeys(customrID);
			
			//CLick on submit button
			driver.findElement(By.name("AccSubmit")).click();
			driver.findElement(By.name("AccSubmit")).click();
			
			
			//Alert popup message "Customer does not exist!!"
			 String actualText = driver.switchTo().alert().getText();
				String expectedText = "Please fill all fields";
				
				assertEquals(expectedText, actualText);
				
				Thread.sleep(2000);
				
				driver.switchTo().alert().accept();
				
				//click reset
				//driver.findElement(By.name("res")).click();
		}
}
