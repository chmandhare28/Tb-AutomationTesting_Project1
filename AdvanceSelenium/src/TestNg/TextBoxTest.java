package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBoxTest {
	WebDriver driver;

	@BeforeClass
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Desktop\\AutomationTesting\\chromeDriverexe\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/text-box");
	}

	@Test
	public void fillTextBoxForm() {
		driver.findElement(By.id("userName")).sendKeys("Chaitrali Taware");
		driver.findElement(By.xpath("//*[@id=\"userEmail\"] ")).sendKeys("Chaitralitaware@gmail.com");
		driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Punawale");
		driver.findElement(By.cssSelector("#permanentAddress")).sendKeys("Pune");
		driver.findElement(By.cssSelector("#submit")).click();

		
		String name = driver.findElement(By.id("name")).getText();
		Assert.assertTrue(name.contains("Chaitrali"));
		System.out.println("Text Box Login Successfully ");
		
		driver.findElement(By.xpath("//*[@id=\"item-2\"]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/label")).click();
//		WebElement nameOutput = driver.findElement(By.id("userName"));
//		System.out.println(nameOutput.getText());
//		WebElement emailOutput = driver.findElement(By.xpath("//*[@id=\"userEmail\"] "));
//	    System.out.println(emailOutput.getText());
//	    WebElement currtaddressOutput = driver.findElement(By.cssSelector("#currentAddress"));
//	    System.out.println(currtaddressOutput.getText());
//	    WebElement perAddOutput = driver.findElement(By.cssSelector("#permanentAddress"));
//	    System.out.println(perAddOutput.getText());
//	
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();

	}

}
