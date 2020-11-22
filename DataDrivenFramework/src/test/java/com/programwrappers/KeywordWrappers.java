package com.programwrappers;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.testcases.LoginTC;





public class KeywordWrappers extends WebBase {
	

	
	public void launch(String value) throws MalformedURLException {
		launchbrowser(value);
	
	}

	  public void getURL(String url) throws InterruptedException {
	    driver.navigate().to(url);
	    Thread.sleep(2000);
		  System.out.println("testurl");
		LoginTC.log.info("invoked the application");
		 
	    }
	 

	  public void click(String locatorType,String locatorname) {
		  try {
				By locator = locatorValue(locatorType, locatorname); 
				  WebElement element = driver.findElement(locator); 
				  element.click();
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				e.getMessage();
			
			}
  }
	  
	  public void enterText(String locatorType,String locatorname, String value) {
			  By locator = locatorValue(locatorType, locatorname); 
			   WebElement element = driver.findElement(locator);
			  element.sendKeys(value);
		
          }
	  
	  public void close() {
		  driver.close();
		  }
	  
	  public void dropdown(String locatortype, String locatorvalue, String inputvalues) {
			By locator = locatorValue(locatortype, locatorvalue);
			WebElement dropDownElement = driver.findElement(locator);
			Select dropDownSelect = new Select(dropDownElement);
			dropDownSelect.selectByVisibleText(inputvalues);
			
			}

		public void doubleClick(String locatortype, String locatorvalue) {
			By locator = locatorValue(locatortype, locatorvalue);
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(locator);
			action.doubleClick(element).perform();

		}

		public void rightclick(String locatortype, String locatorvalue) {
			By locator = locatorValue(locatortype, locatorvalue);
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(locator);
			action.contextClick(element).perform();

		}

		public void sleep(int timeOutInSeconds) throws InterruptedException {
			
				Thread.sleep(timeOutInSeconds * 1000);
				}

		
		public void implicitwait(int timeOutInSeconds) {
			driver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
		}
		
		
		
		public void acceptalert() {
			driver.switchTo().alert().accept();
		}

		public void rejectalert() {
			driver.switchTo().alert().dismiss();

		}

		public void mousehover(String locatortype, String locatorvalue) {
			By locator = locatorValue(locatortype, locatorvalue);
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(locator);
			action.moveToElement(element).build().perform();
		}

		public void switchToFrame(int frameId) {
			driver.switchTo().frame(frameId);
		}

		public void switchToFrame(String frameName) {
			driver.switchTo().frame(frameName);

		}

		public void switchToDefaultContent() {
			try {
				driver.switchTo().defaultContent();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public String getText(String locatortype, String locatorvalue) {
			By locator;
			try {
				locator = locatorValue(locatortype, locatorvalue);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}
			 
			return driver.findElement(locator).getText();
		}

		public Set<String> getWindowHandles() {
			return driver.getWindowHandles();
		}

		public String getWindowTitle() {
			return driver.getTitle();
		}

		public boolean switchToWindowWithElement(String locatortype, String locatorvalue) {
			By locator = locatorValue(locatortype, locatorvalue);
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				if (driver.findElements(locator).size() > 0)
					return true;
			}
			return false;
		}

		public boolean isElementselected(String locatortype, String locatorvalue) {
			By locator = locatorValue(locatortype, locatorvalue);
			WebElement element = driver.findElement(locator);
			if (element.isSelected()) {
				return true;
			}

			return false;

		}

		public boolean isElementPresent(String locatortype, String locatorvalue) {

			By locator = locatorValue(locatortype, locatorvalue);
			WebElement element = driver.findElement(locator);
			if (element != null) {

				return true;
			}

			return false;

		}

		public boolean isElementVisible(String locatortype, String locatorvalue) {
			By locator = locatorValue(locatortype, locatorvalue);
				WebElement element = driver.findElement(locator);
				if (element.isDisplayed()) {
						return true;
				}
			
				return false;
			
		}

		public void refreshPage() {
			driver.navigate().refresh();
		}

		
		public void javascriptClick(String locatortype, String locatorvalue) {
			By locator = locatorValue(locatortype, locatorvalue);
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(locator);		
			jsExecutor.executeScript("arguments[0].click();", element);
		}

		
		public void switchToPopUpWindow(String parentWindow) {
			String windowId = "";
			Set<String> nos = driver.getWindowHandles();
			System.out.println(nos.size());
			Iterator<String> iterator = nos.iterator();
			while (iterator.hasNext()) {
				windowId = (String) iterator.next();
				if (!windowId.equals(parentWindow)) {
				driver.switchTo().window(windowId);
				}
				
			}
		}

		public void scrollDown() {

			JavascriptExecutor javascript = (JavascriptExecutor) driver;
			javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
			
		}



	  private By locatorValue(String locatorType, String value) {
	        By by;
	        switch (locatorType) {
	            case "id":
	                by = By.id(value);
	                break;
	            case "name":
	                by = By.name(value);
	                break;
	            case "xpath":
	                by = By.xpath(value);
	                break;
	            case "css":
	                by = By.cssSelector(value);
	                break;
	            case "linkText":
	                by = By.linkText(value);
	                break;
	            case "partialLinkText":
	                by = By.partialLinkText(value);
	                break;
	            default:
	                by = null;
	                break;
	        }
	        return by;
	    }
}
