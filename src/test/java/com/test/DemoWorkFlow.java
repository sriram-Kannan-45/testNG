package com.test;

import org.testng.annotations.Test;

public class DemoWorkFlow 

{
  @Test(priority = 1)
  public void c() 
  {
	  
	  System.out.println("Hii c");
  }
  
  @Test(priority = 2)
  public void b() 
  {
	  System.out.println("Hii b");
  }
  
  @Test(priority = 3)
  public void a()
  {
	  System.out.println("Hii a");
  }
  
  
}
