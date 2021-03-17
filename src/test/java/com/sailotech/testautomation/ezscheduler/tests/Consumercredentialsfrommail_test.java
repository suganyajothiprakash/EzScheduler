package com.sailotech.testautomation.ezscheduler.tests;

import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.sailotech.testautomation.ezscheduler.ConsumerFunctions.*;
import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.commonutilities.ScreenRecording;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class Consumercredentialsfrommail_test extends TestBase {	

	  ScreenRecording screenRecord;
	  TestBase testbase;
	  ITestResult tr = null;

	  @BeforeClass
	  public void display() {
	    System.out.println("\nI am Before Method");
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
	    testbase = new TestBase();
	  }
	   
	  @TestCaseId("TC_30")
	  @Severity(SeverityLevel.NORMAL)
	  @Description("Reading Consumer credentials/OTP from mail")
	  @Test(
	      description =
	          "Reading Consumer credentials/OTP from consumer mail")
	  public void TC_15_Consumer_Credentialsfrom_Mail() throws Exception {
	 Consumercredentialsfrommail c3 = new Consumercredentialsfrommail();
	    c3.ReadingOTPfromConsumerMail();
	  }
}
