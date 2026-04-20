package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class DemoNewTest {
	
  WebDriver driver;
  
  
  @Test 
  public void loginCheck() 
  {
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  WebElement element = driver.findElement(By.id("loginusername"));
	  element.sendKeys("Admin");
	  WebElement pass = driver.findElement(By.id("loginpassword"));
	  pass.sendKeys("admi");
	  driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
	  System.out.println("login");
	  
  }
  
  @Test
  
  public void loginCheckInValPass() 
  {
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  WebElement element = driver.findElement(By.id("loginusername"));
	  element.sendKeys("Admin");
	  WebElement pass = driver.findElement(By.id("loginpassword"));
	  pass.sendKeys("123");
	  driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
	  System.out.println("PassWord");
  }
  
  
  @Test
  
  public void loginCheckInValUserName() 
  {
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  WebElement element = driver.findElement(By.id("loginusername"));
	  element.sendKeys("Admin123");
	  WebElement pass = driver.findElement(By.id("loginpassword"));
	  pass.sendKeys("admin");
	  driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
	  System.out.println("Username");
  }
  
  @Test
  
  public void dependsGroup()
  {
	  System.out.println("running dependence test ");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--start-maximized");
//	  options.addArguments("--headless");
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
