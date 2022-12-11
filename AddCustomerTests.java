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
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AddCustomerTests {
	
	
	
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
	@DisplayName("Check Results on entering a valid information for all fields")
	public void tc004() {
		
		
		
		//Click on New Customer
		//driver.findElement(By.linkText("New Customer")).click();
		driver.get("https://demo.guru99.com/V4/manager/addcustomerpage.php");
		
		//Enter Customer Name
		driver.findElement(By.name("name")).sendKeys(TestData.customerName);
		
		
		//if testdata hardcoded is male the radio button will select male 
		if(TestData.gender.equals("male")) {
			driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(1)")).click();

		//else if TestData is hardcoded female then the radio button selection will be female
		} else if(TestData.gender.equals("female")) {
			driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(2)")).click();;
		
		}
		//Enter DOB
		driver.findElement(By.name("dob")).sendKeys(TestData.dateOfBirth);
		
		//Enter address
		driver.findElement(By.name("addr")).sendKeys(TestData.address);
		
		//Enter city
		driver.findElement(By.name("city")).sendKeys(TestData.city);
		
		//Enter state
		driver.findElement(By.name("state")).sendKeys(TestData.state);
		
		//Enter Pin
		driver.findElement(By.name("pinno")).sendKeys(TestData.pin.toString());
		//driver.findElement(By.name("pinno")).sendKeys(pin);
		
		//Enter MobileNumber
		driver.findElement(By.name("telephoneno")).sendKeys(TestData.mobileNumber);
		
		//Enter Email
		driver.findElement(By.name("emailid")).sendKeys(TestData.email);
		
		//Enter password
		driver.findElement(By.name("password")).sendKeys(TestData.customerPassword);
		
		
		//CLick the button submit
        driver.findElement(By.name("sub")).click();
	
        
        
      //Check the expected results
        String expectedResults ="Customer Registered Successfully!!!";
        String actualResults = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p")).getText();
       
        assertEquals(expectedResults,actualResults);
            
        
      //Check Customer Name
      	actualResults = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]")).getText();
      	assertEquals(TestData.customerName, actualResults);

      	//Check Gender
      	assertEquals(TestData.gender, driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(6) > td:nth-child(2)")).getText());
                                                                     
      	//Check DOB
      	assertEquals(TestData.expectedDOB, driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(7) > td:nth-child(2)")).getText());

      	
      //Check Address
      	assertEquals(TestData.address, driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(8) > td:nth-child(2)")).getText());
      	
      //Check city
      	assertEquals(TestData.city, driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(9) > td:nth-child(2)")).getText());

      //Check state
      	assertEquals(TestData.state, driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(10) > td:nth-child(2)")).getText());

      //Check pin
      assertEquals(TestData.pin.toString(), driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(11) > td:nth-child(2)")).getText());
      	
      //Check mobile number
      assertEquals(TestData.mobileNumber, driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(12) > td:nth-child(2)")).getText());
      	
 
      	//CheckEmail
      	assertEquals(TestData.email, driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]")).getText());
	
	
	}
	
	@Test
	@DisplayName("Check Results on entering a blank information for all field")
	public void tc005() throws InterruptedException {
		//========Test Data==================
				String customerName = "";
				String gender = "female";
				String dateOfBirth = "";
				String address = "";
				String city = "";
				String state = "";
				String pin = "" ;
				String mobileNumber = "";
				String email = "";
				String customerPassword = "";
				//====================================
				
				
				//Click on New Customer
				driver.findElement(By.linkText("New Customer")).click();
				
				driver.get("https://demo.guru99.com/V4/manager/addcustomerpage.php");
				
				//Enter Customer Name
				driver.findElement(By.name("name")).sendKeys(customerName);
				
				
				//Enter gender
				
				//if testdata hardcoded is male the radio button will select male 
				if(gender.equals("male")) {
					driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(1)")).click();

				//else if TestData is hardcoded female then the radio button selection will be female
				} else if(gender.equals("female")) {
					driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(2)")).click();;
				
				}
				//Enter DOB
				driver.findElement(By.name("dob")).sendKeys(dateOfBirth);
				
				//Enter address
				driver.findElement(By.name("addr")).sendKeys(address);
				
				//Enter city
				driver.findElement(By.name("city")).sendKeys(city);
				
				//Enter state
				driver.findElement(By.name("state")).sendKeys(state);
				
				//Enter Pin
				driver.findElement(By.name("pinno")).sendKeys(pin);
				//driver.findElement(By.name("pinno")).sendKeys(pin);
				
				//Enter MobileNumber
				driver.findElement(By.name("telephoneno")).sendKeys(mobileNumber);
				
				//Enter Email
				driver.findElement(By.name("emailid")).sendKeys(email);
				
				//Enter password
				driver.findElement(By.name("password")).sendKeys(customerPassword);
				
				
				//CLick the button submit
		        driver.findElement(By.name("sub")).click();
			
		        
		        
		        String actualText = driver.switchTo().alert().getText();
				String expectedText = "please fill all fields";
				
				assertEquals(expectedText, actualText);
				
				Thread.sleep(2000);
				
				driver.switchTo().alert().accept();
	}
	@Test
	@DisplayName("Check Reponse on entry of existing Customer")
	public void tc006() throws InterruptedException{
		
		//========Test Data==================
		String customerName = "Fred";
		String gender = "male";
		String dateOfBirth = "04/04/1997";
		String address = "12 Temples bar";
		String city = "Cork";
		String state = "Cork";
		Integer pin =  345678;
		String mobileNumber = "08329392023";
		String email = "fred@guru.ie";
		String customerPassword = "2223345";
		//====================================
		
		
		//Click on New Customer
		driver.findElement(By.linkText("New Customer")).click();
		
		driver.get("https://demo.guru99.com/V4/manager/addcustomerpage.php");
		
		//Enter Customer Name
		driver.findElement(By.name("name")).sendKeys(customerName);
		
		
		//Enter gender
		
		//if testdata hardcoded is male the radio button will select male 
		if(gender.equals("male")) {
			driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(1)")).click();

		//else if TestData is hardcoded female then the radio button selection will be female
		} else if(gender.equals("female")) {
			driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(2)")).click();;
		
		}
		//Enter DOB
		driver.findElement(By.name("dob")).sendKeys(dateOfBirth);
		
		//Enter address
		driver.findElement(By.name("addr")).sendKeys(address);
		
		//Enter city
		driver.findElement(By.name("city")).sendKeys(city);
		
		//Enter state
		driver.findElement(By.name("state")).sendKeys(state);
		
		//Enter Pin
		driver.findElement(By.name("pinno")).sendKeys(pin.toString());
		//driver.findElement(By.name("pinno")).sendKeys(pin);
		
		//Enter MobileNumber
		driver.findElement(By.name("telephoneno")).sendKeys(mobileNumber);
		
		//Enter Email
		driver.findElement(By.name("emailid")).sendKeys(email);
		
		//Enter password
		driver.findElement(By.name("password")).sendKeys(customerPassword);
		
		
		//CLick the button submit
        driver.findElement(By.name("sub")).click();
	
        
        
        String actualText = driver.switchTo().alert().getText();
		String expectedText = "Email Address Already Exist !!";
		
		assertEquals(expectedText, actualText);
		
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();


	}
	
}
