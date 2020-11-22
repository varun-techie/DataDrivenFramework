package com.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.excelutils.DataProviderCall;
import com.excelutils.DataProviderCallMap;
import com.excelutils.ReadObjects;
import com.programwrappers.KeywordWrappers;

public class LoginTC {

	KeywordWrappers kw = new KeywordWrappers();
	ReadObjects obj = new ReadObjects();
	public static Logger log = Logger.getLogger(LoginTC.class);

	@BeforeClass
	public void logger() {
		PropertyConfigurator.configure("Log4j.properties");
		
	}

	@Test(dataProviderClass = DataProviderCall.class, dataProvider = "fetchAll", enabled = false)
	public void LoginPage(String Browser, String url) throws InterruptedException, MalformedURLException {

		//Logger log = Logger.getLogger(LoginTC.class);
		//PropertyConfigurator.configure("Log4j.properties");

		kw.launch(Browser);
		log.info("opening browser in Login Page opened");
		kw.getURL(url);
		log.info("opening browser");
		kw.close();

	}

	@Test(dataProviderClass = DataProviderCallMap.class, dataProvider = "fetchAll")
	public void LoginPagee(Map<Object, Object> map) throws InterruptedException, IOException {

		SoftAssert soft=new SoftAssert();
		String Browser1 = map.get("Browser").toString();
		System.out.println(Browser1);
		kw.launch(Browser1);
		log.info("opening browser");
		kw.getURL(map.get("url").toString());
		log.info("opening browser");

		// xpath://*[@id="header"]/div[2]/div/div/nav/div[1]/a
		String[] signinclick = obj.readlocator("signinbutton").split(":");
		kw.click(signinclick[0], signinclick[1]);
		
		String[] authtext=obj.readlocator("authText").split(":");
		String expectedtext=kw.getText(authtext[0], authtext[1]);
		soft.assertEquals(map.get("actualtext"), "AUTHENTICATION");
		

		String[] email = obj.readlocator("email").split(":");
		kw.enterText(email[0], email[1], map.get("email").toString());
		
		
		kw.sleep(4);

		kw.close();
soft.assertAll();
	}

}
