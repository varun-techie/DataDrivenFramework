package com.programwrappers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebBase {
	
	static RemoteWebDriver driver=null;
	//static WebDriver driver=null;
	public static WebDriver launchbrowser(String browser ) throws MalformedURLException {
		// TODO Auto-generated method stub
		//notication,ssl,popup
		//String browser="chrome";
		
        DesiredCapabilities dr=null;
        
		if(browser.equals("chrome")) {
			
			//driver=new ChromeDriver();
				
			
			  dr=DesiredCapabilities.chrome(); 
			  dr.setBrowserName("chrome");
			  dr.setPlatform(Platform.WINDOWS); 
			  driver=new RemoteWebDriver(new  URL("http://localhost:4444/wd/hub"), dr);
			 
				 
		
			System.out.println(driver.getTitle());
		}else if (browser.equals("firefox")) {
			
			//driver=new FirefoxDriver();
			
			
			  dr=DesiredCapabilities.firefox(); dr.setBrowserName("firefox");
			  dr.setPlatform(Platform.WINDOWS); driver=new RemoteWebDriver(new
			  URL("http://localhost:4444/wd/hub"), dr);
			 
			 

		
		}else if(browser.equals("IE")) {
			
			driver=new InternetExplorerDriver();
		
		}
		return driver;
		
		
	}


	
	

}
