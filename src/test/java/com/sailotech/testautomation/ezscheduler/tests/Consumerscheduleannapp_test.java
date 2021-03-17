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

public class Consumerscheduleannapp_test extends TestBase {
	
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
	  
	  @TestCaseId("TC_17")
	  @Severity(SeverityLevel.NORMAL)
	  @Description("Navigate To Patient Login page")
	  @Test(description = "Navigate To Patient Login page")
	  public void TC_17_ConsumerLogin() throws Exception {
	    Consumerlogin c5 = new Consumerlogin();
	    c5.ConsumerLogin(driver);
	  }

	  @TestCaseId("TC_18")
	  @Severity(SeverityLevel.NORMAL)
	  @Description("Consumer schedule an Appointment with provider")
	  @Test(
	      dependsOnMethods = {"TC_17_ConsumerLogin"},
	      description = "Consumer schedule an Appointment with provider")
	  public void TC_18_PatientScheduleAnAppointment() throws Exception {
	    consumerscheduleanappointment c6 = new consumerscheduleanappointment(driver);
	    c6.patient_schedule_an_appointment(driver);
	  }

	  @TestCaseId("TC_16")
	  @Severity(SeverityLevel.NORMAL)
	  @Description("patient Logout from EzScheduler Website")
	  @Test(
	      dependsOnMethods = {"TC_18_PatientScheduleAnAppointment"},
	      description = "Consumer Logout from EzScheduler Website")
	  public void TC_16_PatientLogout() throws Exception {
	    Consumerlogout c4 = new Consumerlogout();
	    c4.Consumer_Logout(driver);
	  }

	  @AfterTest
	  public void stopRecording() throws Exception {
	    screenRecord.stopRecording();
	    driver.quit();
	  }
}
