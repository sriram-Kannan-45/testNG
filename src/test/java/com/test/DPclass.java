package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DPclass {
  

  @DataProvider(name = "testData" , parallel = true)
  public Object[][] dp() {
    return new Object[][] {
    	{"selenium"},{"testNg"},{"Automation"}
    };
  }
}
