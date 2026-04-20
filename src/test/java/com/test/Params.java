package com.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Params {
  @Test
  @Parameters({"val1","val2"})
  public void sum(int v1 , int v2) 
  {
	  System.out.println(v1+v2);
  }
  
  @Test
  @Parameters({"val1","val2"})
  public void sum1(int v3 , int v4) 
  {
	  System.out.println(v3-v4);
  }
  
}
