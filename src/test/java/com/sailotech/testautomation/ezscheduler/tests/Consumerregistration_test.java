package com.sailotech.testautomation.ezscheduler.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
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

public class Consumerregistration_test  extends TestBase{
	
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

	  @TestCaseId("TC_13")
	  @Severity(SeverityLevel.NORMAL)
	  @Description("Consumer Registering in EzScheduler Website")
	  @Test(description = "Navigate to consumer Login/Register page")
	  public void TC_13_ConsumerRegistration() throws Exception {
		  Consumerregistration c1 = new Consumerregistration();
	    c1.ConsumerRegister(driver);
	  }

	  @TestCaseId("TC_14")
	  @Severity(SeverityLevel.NORMAL)
	  @Description("Reading OTP from consumer Email")
	  @Test(description = "Reading OTPs from consumer Email")
	  public void TC_14_ConsumerCredentialsfrommail() throws Exception {
	    Consumercredentialsfrommail c2 = new Consumercredentialsfrommail();
	    c2.ReadingOTPfromConsumerMail();
	  }

	  @TestCaseId("TC_15")
	  @Severity(SeverityLevel.NORMAL)
	  @Description("Entering OTP in that OTP field and verifing that OTP")
	  @Test(
	      dependsOnMethods = {"TC_13_ConsumerRegistration"},
	      description =
	          "Entering OTP in that OTP field and verifing that OTP, once enter the OTP, it navigate to consumer  Login page")
	  public void TC_15_Consumer_OTP() throws Exception {
	    ConsumerOTP c3 = new ConsumerOTP(driver);
	    c3.Consumer_OTP(driver);
	  }

	  /*@TestCaseId("TC_16")
	  @Severity(SeverityLevel.NORMAL)
	  @Description("patient Logout from EzScheduler Website")
	  @Test(
	      dependsOnMethods = {"TC_14_Consumer_OTP"},
	      description = "patient Logout fromEzScheduler Website")
	  public void TC_16_ConsumerLogout() throws Exception {
	    Consumerlogout c4 = new Consumerlogout(driver);
	    c4.Patient_Logout(driver);
	  }
	  */
	  @AfterTest
	  public void stopRecording() throws Exception {
	    screenRecord.stopRecording();
	    driver.quit();
	  }
}
