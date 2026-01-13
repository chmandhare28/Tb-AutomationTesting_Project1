package TestNg;
//Day 38 04/12/2025

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoGuruLogin {
	
	WebDriver driver;

	@BeforeSuite
	public void OpenBrower() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Desktop\\AutomationTesting\\chromeDriverexe\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void WindowMaximize() {
		driver.manage().window().maximize();

	}

	@BeforeClass
	public void openDemoGuru() {
		driver.get("https://demo.guru99.com/test/newtours/");
	}

	By Username = By.name("userName");
	By Password = By.name("password");
	By LoginButton = By.cssSelector(
			"body > div:nth-child(6) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(3) > form > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(4) > td:nth-child(2) > div > input[type=submit]");
	By SuccessMessage = By.xpath(
			"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3 ");
	By Sign_Off = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a");

	@BeforeMethod
	public void clearInputBox() {
		driver.findElement(Username).clear();
		driver.findElement(Password).clear();
		//driver.findElement(LoginButton).clear();

	}

	@Test(dataProvider = "loginData")
	public void checkWithValidData(String un, String ps) throws InterruptedException {
		driver.findElement(Username).sendKeys(un);
		driver.findElement(Password).sendKeys(ps);
		driver.findElement(LoginButton).click();
//		File Screenshort = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
//		FileUtils.copyFile(screenshot,new File("Alert.png"))	;	
//				
		Thread.sleep(2000);
		String Message = null;
		try {
			Message = driver.findElement(SuccessMessage).getText();

			Assert.assertEquals(Message, "Login Successfully");
		} catch (Exception e) {
			Assert.assertEquals(Message, "Login Successfully");
		}
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		try {
			if (driver.findElement(Sign_Off).isDisplayed()) {

				driver.findElement(Sign_Off).click();
			}
		} catch (Exception e) {

		}
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

	@DataProvider
	public Object[][] loginData() {
		return new Object[][] { new Object[] { "QQQQ", "qqqq" }, new Object[] { "AAAA", "aaaa" }

		};
		// Object type 1)eagle Loading 2) Lazy Loading
		// This one is eagle Loading
//		Object [][] obj=Object[4][2];
//		obj[0][0]="AAAA";
//		obj[0][1]="aaaa";
//		
//		obj[0][0]="BBBB";
//		obj[0][1]="bbbb";
//		
//		obj[0][0]="CCCC";
//		obj[0][1]="cccc";
//		
//		obj[0][0]="XXXX";
//		obj[0][1]="xx123";
//		return obj;

	}

}
