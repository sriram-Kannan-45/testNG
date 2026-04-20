package com.test;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class DemoBlazeWithParameter {
	WebDriver driver;
  @Test
  @Parameters({"valName","valpass"})
  public void login(String userName , String passWord) 
  {
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  WebElement element = driver.findElement(By.id("loginusername"));
	  element.sendKeys(userName);
	  WebElement pass = driver.findElement(By.id("loginpassword"));
	  pass.sendKeys(passWord);
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
  @Parameters({"valName","invalPass"})
  public void loginCheckInValPass(String name , String pass) 
  {
	  driver.findElement(By.id("login2")).click();

	  driver.findElement(By.id("loginusername")).sendKeys(name);
	  driver.findElement(By.id("loginpassword")).sendKeys(pass);

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
  @Parameters({"invalName","valpass"})
  public void loginCheckInValUserName(String name , String pass) 
  {
	  driver.findElement(By.id("login2")).click();

	  driver.findElement(By.id("loginusername")).sendKeys(name);
	  driver.findElement(By.id("loginpassword")).sendKeys(pass);

	  driver.findElement(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]")).click();

	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  Alert alt = wait.until(ExpectedConditions.alertIsPresent());

	  String actual = alt.getText();

	  

	  String expect = "Wrong password.";

	  Assert.assertEquals(actual, expect);

	  alt.accept();
	  
	  System.out.println("Wrong userName");
  }
  
  @Parameters({"browser","url"})
  @BeforeMethod
  
  public void beforeTest(String browser , String url)
  
  {
	  if(browser.equals("chrome"))
	  {
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--start-maximized");
//		  options.addArguments("--headless");
		  driver = new ChromeDriver(options);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get(url);
	  }
	  
	  else if (browser.equals("fireFox"))
	  {
		  FirefoxOptions options = new FirefoxOptions();
		  options.addArguments("--start-maximized");
		  // options.addArguments("--headless");  

		  WebDriver driver = new FirefoxDriver(options);

//		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get(url);
	  }
  }
  
  

  @AfterMethod
  
  public void afterTest()
  
  {
	  driver.quit();
  }

}
