package com.testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.excelutils.DataProviderCallMap;
import com.excelutils.ReadObjects;
import com.programwrappers.KeywordWrappers;

public class AnyClass {

	KeywordWrappers kw=new KeywordWrappers();
	ReadObjects rd= new ReadObjects();
	
	
	@Test(dataProviderClass = DataProviderCallMap.class,dataProvider = "fetchAll")
	public void loginmysite(Map<Object, Object> datamap) throws InterruptedException, IOException {
		
		//how to take value from excel
		String browser=datamap.get("Browser").toString();
		
		kw.launch(browser);
		
		String url=datamap.get("url").toString();
		kw.getURL(url);
		
		
		
		String[] siginfromproperty=rd.readlocator("signinbutton").split(":");
		String locatortypesignin=siginfromproperty[0];
		String locatornamesigin=siginfromproperty[1];
		kw.click(locatortypesignin, locatornamesigin);
		
		
		
		
	}
	
}
