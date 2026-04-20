package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dataProviderParalel {
	private static final ThreadLocal <WebDriver> driver = new ThreadLocal <WebDriver>();
	
	@Test(dataProvider = "testData" , dataProviderClass=DPclass.class)
	  public void dataProv(String key) 
	  
	  {
			
		  WebDriver driver1 = driver.get();
		  
		  driver1.manage().window().maximize();
		  
		  driver1.get("https://www.bing.com/?toWww=1&redig=B0B4A92EA4614BC9964C4B38BA790843");
		  
		  WebElement search = driver.get().findElement(By.id("sb_form_q"));
		  
		  search.sendKeys(key);
		  
		  System.out.println(key);
		  
		  search.sendKeys(Keys.ENTER);
	  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("start the test");
	  
	  driver.set(new ChromeDriver());
  }

  @AfterMethod
  public void afterMethod() 
  {
	  WebDriver driver1 = driver.get();
	  
	  if (driver1 != null)
	  {
		  driver1.quit();
	  }
  }

}
