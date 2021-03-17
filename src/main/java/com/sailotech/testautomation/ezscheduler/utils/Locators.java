package com.sailotech.testautomation.ezscheduler.utils;

import java.text.MessageFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.AdminPage;

public class Locators extends TestBase {
	
	private WebDriverWait wait = TestBase.wait;
	private String locType;
	
	public WebElement getWebElement(String locator, Object... params) {
		locType = locatorsProp.getProperty(locator + AdminPage.LOCTYPESTRING);
		return driver.findElement(buildLocator(locator, locType, params));
	}
	public By getElement(String locator, Object... params) {
		
		return buildLocator(locator, locType, params);
	}
	
	
	public void clickElemetUsingJavascriptExecutor(String locator, Object... params) {
		try {
			clickUsingJavascriptExecutor(getElement(locator, params), locator, driver);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This methods generates locators based on given inputs
	 * 
	 * @param locator
	 * @param locType
	 * @param params
	 * @return
	 */

			private By buildLocator(String locator, String locType, Object... params) {
				By element = null;
				try {
					locator = generateLocator(locatorsProp.getProperty(locator), params);
					if (locType == null)
						locType = AdminPage.XPATH;
					System.out.println("locType : "+locType);
					switch (locType.toLowerCase()) {
					case AdminPage.ID:
						element = By.id(locator);
						break;
					case AdminPage.NAME:
						element = By.name(locator);
						break;
					case AdminPage.CLASSNAME:
						element = By.className(locator);
						break;
					case AdminPage.TAGNAME:
						element = By.tagName(locator);
						break;
					case AdminPage.LINKTEXT:
						element = By.linkText(locator);
						break;
					case AdminPage.PARTIALLINKTEXT:
						element = By.partialLinkText(locator);
						break;
					case AdminPage.XPATH:
						element = By.xpath(locator);
						break;
					case AdminPage.CSS:
						element = By.cssSelector(locator);
						break;
					default:
						element = By.xpath(locator);
						break;
					}
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(element));
				} catch(Exception e) {
				}
				return element;
			}
			
	private String generateLocator(String locator, Object... params) {
		System.out.println(locator + "-" + params.length);
		locator = MessageFormat.format(locator, params);
		return locator;
	}

}
