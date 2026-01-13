package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookLogin {
	WebDriver driver;
	@BeforeSuite
	public void OpenBrower() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Desktop\\AutomationTesting\\chromeDriverexe\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();}
	@BeforeTest
	public void WindowMaximize() {
		driver.manage().window().maximize();}
	@BeforeClass
	public void openDemoGuru() {
		driver.get("https://www.facebook.com/");
	}
	By EmailAddress = By.name("email");
	By Password = By.name("pass ");
	By LoginButton = By.name("login");
//	@BeforeMethod
//	public void clearInputBox() {
//		driver.findElement(EmailAddress).clear();
//		driver.findElement(Password).clear();
//	}
	@Test(dataProvider = "loginData")
	public void chechwithValidData(String emailid, String pass) throws InterruptedException {
		driver.findElement(EmailAddress).sendKeys(emailid);
		driver.findElement(Password).sendKeys(pass);
		driver.findElement(LoginButton).click();
	}
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return new Object[][] { new Object[] { "chaitraliTaware", "c12810" 
		}};
		}}

