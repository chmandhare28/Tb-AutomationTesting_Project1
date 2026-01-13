package AdvanceseleniumjUnit;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class ConnectionWithSite {
@BeforeClass
public static void OpenBrower() {
	System.out.println("This is Locator in Selenium...");
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Admin\\Desktop\\AutomationTesting\\chromeDriverexe\\chromedriver-win64\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");

	driver.manage().window().maximize();
}
private int i;
private WebDriver driver;
@Before
public void getcounts() {
	List<WebElement> AllLinks = driver.findElements(By.tagName("a"));
	System.out.println("All Hyper Link From Current Page :" + AllLinks.size());

	WebElement Footer = driver.findElement(By.cssSelector("#gf-BIG"));
	List<WebElement> FooterLinks = Footer.findElements(By.tagName("a"));
	System.out.println("Footer hyper Links :" + FooterLinks.size());
	
}
@Test
public void CheckMultipalwindiws() {
	WebElement footerColumn = driver
			.findElement(By.cssSelector("#gf-BIG > table > tbody > tr > td:nth-child(1) > ul"));
	List<WebElement> footerColumnLinks = footerColumn.findElements(By.tagName("a"));
	System.out.println("Footer Column Links Size :" + footerColumnLinks.size());
	
	for(i=1 ;i<footerColumnLinks.size();i++) {
		String keys = Keys.chord(Keys.CONTROL, Keys.ENTER);
		footerColumnLinks.get(i).sendKeys(keys);
		//System.out.println(footerColumnLinks.get(i).getText());
	}
	Set<String> keys = driver.getWindowHandles();
	System.out.println(keys.size());
	
 //Assert.assertNotEquals( 0,keys.size());
}
}
