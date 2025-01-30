package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import seleniumdriver.SeleniumDriver;

public class LoginBasicTest extends SeleniumDriver {


	@Test
	public void login() {
		WebDriver driver = getDriver();
		System.out.println("0. Start");
		
		System.out.println("1. Open target page");
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().setSize(new Dimension(1350, 637));
		
		System.out.println("2. Insert username and password");
		
		System.out.println(" 2.1 Insert username");
		driver.findElement(By.id("login_credentials")).click();
		driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
		
		System.out.println(" 2.1 Insert password");
		driver.findElement(By.cssSelector(".login_password")).click();
		driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
		
		System.out.println("3. Click submit to perform login");
		driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();

		System.out.println("4. Verify login has been successfully executed");
		System.out.println(" 4.1 Page title is 'Swag Labs'");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		
		System.out.println(" 4.2 Page url contains 'inventory'");
		Assert.assertEquals(driver.getCurrentUrl().contains("inventory"), true);
		
		//Pause the execution for 2 seconds to show the logged in page
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("5. End");
	}
}
