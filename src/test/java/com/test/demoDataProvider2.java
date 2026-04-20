package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class demoDataProvider2 {
	
	WebDriver driver ;
	@Test(dataProvider = "testData" , dataProviderClass=DPclass.class)
	  public void dataProv(String key) 
	  {
		  WebElement search = driver.findElement(By.id("sb_form_q"));
		  
		  search.sendKeys(key);
		  
		  System.out.println(key);
		  
		  search.sendKeys(Keys.ENTER);
	  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("start the test");
	  
	  driver = new ChromeDriver();
	  driver.get("https://www.bing.com/?toWww=1&redig=B0B4A92EA4614BC9964C4B38BA790843");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
	  
	  System.out.println("END TEST");
  }

}
