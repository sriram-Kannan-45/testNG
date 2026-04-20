package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class demoBlazeDataProvider {
  
	
  @DataProvider(name = "demo" , parallel = true )
  public Object[][] dp() {
    return new Object[][] {
      
    	  {"admin","a"},
    	  {"a","admin"}
    	  
    };
  }
}
