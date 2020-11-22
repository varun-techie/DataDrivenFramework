package com.roughwork;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.excelutils.DataProviderCallMap;
import com.excelutils.ReadObjects;
import com.programwrappers.KeywordWrappers;

public class Assertions {

	KeywordWrappers kw = new KeywordWrappers();
	ReadObjects obj = new ReadObjects();

	@Test(dataProviderClass = DataProviderCallMap.class,dataProvider = "fetchAll",enabled=false)
	public void testone(Map<Object, Object> datamap) throws InterruptedException, IOException {

		kw.launch(datamap.get("Browser").toString());
		kw.getURL(datamap.get("url").toString());

		kw.sleep(4);
		String[] getsellertext = obj.readlocator("sellertext").split(":");
		String expectedtext = kw.getText(getsellertext[0], getsellertext[1]);

		Assert.assertEquals(datamap.get("actualtext").toString(), expectedtext);
		Assert.assertTrue(expectedtext.equals("BEST SELLERS"));
		
		kw.close();

	}
	
	@Test(dataProviderClass = DataProviderCallMap.class,dataProvider = "fetchAll")
	public void testtwo(Map<Object, Object> datamap) throws InterruptedException, IOException {

		
		SoftAssert soft=new SoftAssert();
		kw.launch(datamap.get("Browser").toString());
		kw.getURL(datamap.get("url").toString());

		kw.sleep(4);
		String[] getsellertext = obj.readlocator("sellertext").split(":");
		String expectedtext = kw.getText(getsellertext[0], getsellertext[1]);

		//Assert.assertEquals(datamap.get("actualtext").toString(), expectedtext);
		//Assert.assertTrue(expectedtext.equals("BEST SELLERS"));
		
		soft.assertEquals(datamap.get("actualtext").toString(), expectedtext);
		System.out.println("test");
		
		kw.close();
		soft.assertAll();

	}
	

}
