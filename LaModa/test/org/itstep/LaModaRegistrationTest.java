package org.itstep;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaModaRegistrationTest {
	
	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\QA\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.lamoda.ua/");
	}
	
	@Test
	public void test() {
		
		WebElement enter = driver.findElement(By.xpath("//span[@class='link user-nav__link js-auth-button']"));
		enter.click();
		//WebElement registration = driver.findElement(By.xpath("//span[@class='link_blue login-form__register link']"));
		//registration.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allPopupWindows = driver.getWindowHandles();
		for (String popupWindow : allPopupWindows) {
			driver.switchTo().window(popupWindow);
			driver.findElement(By.xpath("//span[@class='link_blue login-form__register link']")).click();
			
		}
		driver.switchTo().window(parentWindow); // возвращаемся на родительское окно
		String parentWindow1 = driver.getWindowHandle();
		Set<String> allPopupWindows1 = driver.getWindowHandles();
		for (String popupWindow : allPopupWindows1) {
			driver.switchTo().window(popupWindow);
			driver.findElement(By.xpath("//input[@name='email'][@class='text-field']")).sendKeys("spamformari@gmail.com");
			driver.findElement(By.xpath("//input[@name='password'][@class='text-field']")).sendKeys("qwe123qwe123");
			driver.findElement(By.xpath("//input[@name='password2'][@class='text-field']")).sendKeys("qwe123qwe123");
			driver.findElement(By.xpath("//input[@name='first_name'][@class='text-field']")).sendKeys("marimari");
			driver.findElement(By.xpath("//button[@type='submit'][@class='button button_blue js-registration-button']")).submit();
			
			
		}
			
		
			}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}

	

}
