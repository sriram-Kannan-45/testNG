package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testAssertions {
	@Test
  public void assertions() 
  {
	  
	  String str1=new String("TestNG");
	  String str2=new String("TestNG");
	  String str3=null;
	  String str4="TestNG";
	  String str5="TestNG";
	  String str6=new String("Not_TestNG");
	  
	  int val1 = 5;
	  int val2 = 6;
	  
	  Assert.assertEquals(str1 , str2);
	  System.out.println("Equals Assertions is successful");
	  
	  Assert.assertNotEquals(str1 , str6);
	  System.out.println("NotEquals Assertions is successful");
	  
	  Assert.assertTrue(val1 < val2);
	  System.out.println("Ture assertion is succesful");
	  
	  Assert.assertFalse(val1 > val2);
	  System.out.println("False assertion is succesful");
	  
	  Assert.assertNotNull(str1);
	  System.out.println("Not Null assertion is succesful");
	  
	  Assert.assertNull(str3);
	  System.out.println("Null assertion is succesful");
	  
	  Assert.assertSame(str4,str5);
	  System.out.println("Same successful");
	  
	  Assert.assertNotSame(str1,str2);
	  System.out.println("Not same successful");
  }
}
