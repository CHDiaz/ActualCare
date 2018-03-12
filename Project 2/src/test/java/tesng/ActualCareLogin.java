package tesng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ActualCareLogin {

	public static WebDriver driver;
	public final String url = "http://52.207.237.90:8085/angular/";
	
	WebDriverWait wait;
	
	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		//We can configure our driver's implicit wait as soon as it is instantiated.
		//For any element, wait 4 seconds before determining a fail
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//For a specific action, wait 7 seconds before a fail
		wait = new WebDriverWait(driver, 7);
		
		driver.get(url);
	}
	
	@AfterTest
	public void teardown() throws InterruptedException{
		Thread.sleep(2500);
		driver.quit();
	}
	
	
	@Test
	public void logInToActualCare() {
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test35@com");

		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertEquals(driver.getTitle(), "ActualCare");
		
		
		}

	@Test
	public void confirmHomepage(){
		Assert.assertEquals(driver.getTitle(), "ActualCare");
	}
}