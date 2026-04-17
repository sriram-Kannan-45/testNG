package com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demoBlazeWithAssertion {
	WebDriver driver;
	  
	  
	  @Test 
	  public void loginCheck() throws InterruptedException 
	  {
		  driver.findElement(By.xpath("//a[@id='login2']")).click();
		  WebElement element = driver.findElement(By.id("loginusername"));
		  element.sendKeys("admin");
		  WebElement pass = driver.findElement(By.id("loginpassword"));
		  pass.sendKeys("admin");
		  driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		  System.out.println("login");
		  
		  String expect = "Welcome admin";
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  
		  WebElement actual_ele = driver.findElement(By.xpath("//a[text()='Welcome admin']"));
		  
		  String actual = actual_ele.getText();
		  
		  Assert.assertEquals(actual ,expect);
		  System.out.println("Login successful");
	  }
	  
	  @Test
	  
	  public void loginCheckInValPass() 
	  {
		  driver.findElement(By.id("login2")).click();

		  driver.findElement(By.id("loginusername")).sendKeys("admin");
		  driver.findElement(By.id("loginpassword")).sendKeys("123");

		  driver.findElement(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]")).click();

		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  Alert alt = wait.until(ExpectedConditions.alertIsPresent());

		  String actual = alt.getText();

		  System.out.println(actual);

		  String expect = "Wrong password.";

		  Assert.assertEquals(actual, expect);

		  alt.accept();
	  }
	  
	  
	  @Test
	  
	  public void loginCheckInValUserName() 
	  {
		  driver.findElement(By.id("login2")).click();

		  driver.findElement(By.id("loginusername")).sendKeys("admin");
		  driver.findElement(By.id("loginpassword")).sendKeys("123");

		  driver.findElement(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]")).click();

		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  Alert alt = wait.until(ExpectedConditions.alertIsPresent());

		  String actual = alt.getText();

		  

		  String expect = "Wrong password.";

		  Assert.assertEquals(actual, expect);

		  alt.accept();
		  
		  System.out.println("Wrong userName");
	  }
	  
	  
	  @BeforeMethod
	  public void beforeMethod() 
	  {
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--start-maximized");
//		  options.addArguments("--headless");
		  driver = new ChromeDriver(options);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://www.demoblaze.com/");
	  }
	  
	  
	  @AfterMethod
	  public void afterMethod()
	  {
		  driver.quit();
	  }
	  @BeforeTest
	  public void beforeTest() 
	  
	  {
		  
	  }

	  @AfterTest
	  public void afterTest() 
	  {
		  
	  }

}
