package com.sailotech.testautomation.ezscheduler.tests;

import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sailotech.testautomation.ezscheduler.AdminFunctions.Adminlogout;
import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.commonutilities.ScreenRecording;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class Adminlogout_test extends TestBase {
	
	
	ScreenRecording screenRecord;
	  TestBase testBase;
	  ITestResult tr = null;

	  @BeforeClass
	  public void display() {
	    System.out.println("\nI am before method");
	  }

	  @BeforeMethod
	  public void setUp(ITestResult tr) {
	    tr.setAttribute("class", getClass().getName());
	    tr.setAttribute("toString", tr.toString());
	    this.tr = tr;
	  }

	  @BeforeClass
	  public void screenRecord() throws Exception {
	    screenRecord = new ScreenRecording();
	    screenRecord.startRecording();
	    testBase = new TestBase();
	  }

	  @TestCaseId("TC_10")
	  @Severity(SeverityLevel.NORMAL)
	  @Description("Admin Logout from EzScheduler Website")
	  @Test(
	      description = "Admin Logout from EzScheduler Website")
	  public void TC_10_AdminLogout() throws Exception {
	    Adminlogout a3 = new Adminlogout();
	    a3.AdminLogout(driver);
	  }
}
