package com.sailotech.testautomation.ezscheduler.accerlators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
  public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
