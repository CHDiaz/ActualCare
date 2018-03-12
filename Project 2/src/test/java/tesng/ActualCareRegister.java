package tesng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActualCareRegister {
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
	public void goToRegisterPage() {
		driver.findElement(By.xpath("//input[@type='button']")).click();
		Assert.assertEquals(driver.getTitle(), "ActualCare");

	}
	
	
	@Test (dependsOnMethods = "goToRegisterPage")
	public void RegisterToActualCare() {
		
		driver.findElement(By.xpath("//form//div//input[@id='firstname']")).sendKeys("test");

		
		driver.findElement(By.xpath("//form//div//input[@id='lastname']")).sendKeys("test");
		
		driver.findElement(By.xpath("//form//div//input[@id='age']")).sendKeys("20");

		driver.findElement(By.xpath("//*[@id=\"register\"]/div[1]/div[4]/select")).findElement(By.xpath("//option[@value='FEMALE']")).click();

		driver.findElement(By.xpath("//*[@id=\"door\"]")).sendKeys("20");

		driver.findElement(By.xpath("//*[@id=\"street\"]")).sendKeys("queens college");

		driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("NY");
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test35@test");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("test");

		driver.findElement(By.xpath("//*[@id=\"ins\"]")).findElement(By.xpath("//option[@value='WELL_POINT']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"register\"]/app-doctors/div/div[2]/ul")).findElement(By.xpath("//*[@id=\"register\"]/app-doctors/div/div[2]/ul/li[2]")).click();

		driver.findElement(By.xpath("//*[@id=\"register\"]/button[1]")).click();

		Assert.assertEquals(driver.getTitle(), "ActualCare");
		
		
		}

	
	@Test(priority=0)
	public void confirmHomepage(){
		Assert.assertEquals(driver.getTitle(), "ActualCare");
	}
	
}

