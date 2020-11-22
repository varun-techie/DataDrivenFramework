package com.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert {

	
	@Test(enabled=false)
	public void assertone() {
		
		System.out.println("first statement");
		//validation purpose,program will stop at the time
		org.testng.Assert.assertEquals("suraj", "suraj");
		org.testng.Assert.assertTrue("karthik".equals("karthik"));
		System.out.println("last statement");
		
	}
	
	
	@Test
	public void asserttwo() {
		//methodwise
		SoftAssert soft=new SoftAssert();
		
		System.out.println("first statement");
		soft.assertEquals("suraj", "varun");
		
		
		System.out.println("last statement");
		soft.assertAll();
	}
	
}
