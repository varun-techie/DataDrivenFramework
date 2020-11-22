package com.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;

import com.excelutils.DataProviderCall;
import com.excelutils.DataProviderCallMap;
import com.excelutils.ReadObjects;
import com.programwrappers.KeywordWrappers;

public class TestCaseone {
	
	KeywordWrappers kw=new KeywordWrappers();
	ReadObjects  rd=new ReadObjects();
	
	@Test(dataProviderClass = DataProviderCall.class,dataProvider="fetchAll",enabled=false)
	public void myfirstmethod(String browser,String url,String email) throws InterruptedException, MalformedURLException {
		
		//laucch and url
		kw.launch(browser);
		kw.getURL(url);
		
		//locator(property)
		
		
	}
	
	
	
	
	@Test(dataProviderClass =DataProviderCallMap.class,dataProvider="fetchAll")
	public void mysecondmethod(Map<Object, Object> datamap) throws InterruptedException, IOException {
		
		
		String Browser=datamap.get("Browser").toString();
		
		kw.launch(Browser);
		kw.getURL(datamap.get("url").toString());
		
		
		String[] signin=rd.readlocator("signinbutton").split(":");
		kw.click(signin[0], signin[1]);
		
		kw.sleep(4);
		
		String[] email=rd.readlocator("email").split(":");
		String emailfromexcel=datamap.get("email").toString();
		kw.enterText(email[0], email[1], emailfromexcel);
		
		kw.sleep(2);
		kw.close();
	}

}
